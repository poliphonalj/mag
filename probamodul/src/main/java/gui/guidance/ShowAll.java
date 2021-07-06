package gui.guidance;



import java.util.ArrayList;
import java.util.Collections;

import javax.jcr.AccessDeniedException;
import javax.jcr.ItemNotFoundException;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.swing.SortingFocusTraversalPolicy;

import gui.guidance.News;

import org.checkerframework.checker.units.qual.s;

import com.sun.tools.javac.util.List;

import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class ShowAll <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition> {
	private String radioProperty;
	private String selectProperty;
	private ArrayList<News>listOfNews=new ArrayList<News>();
	
	public ShowAll(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) throws AccessDeniedException, ItemNotFoundException, RepositoryException {
		super(content, definition, parent);
		readProperties();
		sorting(getAllNewsFromJcr());
		
	}

	
	//bolvassa a dialogban kiválasztott értékeket
	public void readProperties() throws AccessDeniedException, ItemNotFoundException, RepositoryException{
		Session session=content.getSession();
		Node node=(Node) content.getAncestor(3);
		System.out.println("radioGroup: "+node.getProperty("radioGroup").getString());
		System.out.println("select: "+node.getProperty("filt").getString());
		session.save();
	
		radioProperty=node.getProperty("radioGroup").getString();
		selectProperty=node.getProperty("filt") .getString();
	}
	
	
	//a JCR-ból kikéri az összes news propertiest, ebbõl épít egy news objektumot, majd egy listába rakja
	public ArrayList<News> getAllNewsFromJcr() throws LoginException, RepositoryException{
		
		Session session2=MgnlContext.getJCRSession("news-app"); // igy vaálto workspace-t
		NodeIterator nodeIter=session2.getRootNode().getNodes();
		
		while(nodeIter.hasNext()) {
			Node node2=nodeIter.nextNode();
			ArrayList<String>listOfProperties=new ArrayList<>();
			News actualNews=new News();
			if(node2.getName().contains("jcr:system") || node2.getName().contains("rep:accesscontrol") ){
				node2=nodeIter.nextNode();
			}
			else{
				actualNews.setText(node2.getProperty("text").getString());
				actualNews.setAuthor(node2.getProperty("author").getString());
				actualNews.setPublish_date(node2.getProperty("publish_date").getString());
				actualNews.setIntro(node2.getProperty("intro").getString());
				actualNews.setImage(node2.getProperty("image").getString());
				
				listOfNews.add(actualNews);
				listOfProperties.clear();
			}		
		}
		return listOfNews;
	}
	
	
	//a selectProperty és a radioProperty alapján sorba rendezi a news-okt tartalmazó listát
	//használja a  két sort..... comparator osztályt
	public void sorting(ArrayList<News> list){
		switch(selectProperty){
			case "abc":
				Collections.sort(list,new SortByAuthorAsc());
				if(radioProperty.equals("n")){
					break;
				}
				else {
					
					Collections.reverse(list);
					break;
				}
		
			case "ido":
				Collections.sort(list,new SortByPublishDateAsc());
				if(radioProperty.equals("n")){
					break;
				}
				else {
					Collections.reverse(list);
					break;
				}
		}
	}
	
	
	//visszaadja a listát majd az ftl-nek
	public ArrayList<News> getAllNews(){
		return listOfNews; 
	}

}
