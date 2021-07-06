package gui.guidance;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.vaadin.ui.Component;
import com.vaadin.v7.data.Item;

import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class Filterer <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition> {

	
	@Inject
	public Filterer(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) throws RepositoryException {
		super(content, definition, parent);
	//	System.out.println("name: " +content.getName());//kiadja az elso node nevet>>uj-page
		//System.out.println("depth: "+content.getDepth());//kiadja az aktuális node méységét 1
		//System.out.println("template: "+definition.getName());//kiadja az aktuális templatet pl: showNewsPage
		
		
		
		//System.out.println("contnet path: "+content.getPath());//kiadja a node path-jat>>>> /uj-page
		//System.out.println();
	//	System.out.println("a contnet ancestor: "+content.getAncestor(1).getName());//  >uj-page
		Node node=(Node) content.getAncestor(3);
	System.out.println(node.getProperty("radioGroup").getString());///itt kiirja a dialog ertekeit, ezeket kiiffelve meghivni a metodusokat!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
		//System.out.println(content.getNodes().next().toString()+" , ");//mainben van most
		// TODO Auto-generated constructor stub
	System.out.println();
	System.out.println("--------------------------------------------------------------");
	

	//System.out.println(node.getName());
	
	
	
	
	

	
	
	//ADATOK KIKÉRESE:
	//beleállok az aktuális node-ba, onnnan getProperty(rel path=property nev) kiveszem a propertit es
	//annak az erteket kiirom toStringgel!
	//Node rootNode=session.getRootNode();	//a root node az a /
	//Node node=rootNode.getNode(content.getPath());
	//System.out.println(node.getPath());
	//System.out.println(node.getProperty("a hirek szama: "+"hirszam").getString());
	//System.out.println(content.filt);
	//Node node=content.getNode(content.getPath());
	//System.out.println(node.getProperty("filt").getString());
	//System.out.println(session.getProperty("/uj-page/main/0/hirszam"));
	
	
	
	Session session2=MgnlContext.getJCRSession("news-app"); // igy vaálto workspace-t
	NodeIterator nodeIter=session2.getRootNode().getNodes();
	
	ArrayList<News>listOfNews=new ArrayList<News>();
	
	while(nodeIter.hasNext()) {
		Node node2=nodeIter.nextNode();
		///////System.out.println(node2.getProperty("radioGroups").getString());
		ArrayList<String>listOfProperties=new ArrayList<>();
		News actualNews=new News();
		if(node2.getName().contains("jcr:system") || node2.getName().contains("rep:accesscontrol") ){
			node2=nodeIter.nextNode();
		}
		else{
			System.out.println("nodenevek:   "+node2.getName());
			
			actualNews.setText(node2.getProperty("text").getString());
			actualNews.setAuthor(node2.getProperty("author").getString());
			actualNews.setPublish_date(node2.getProperty("publish_date").getString());
			actualNews.setIntro(node2.getProperty("intro").getString());
			actualNews.setImage(node2.getProperty("image").getString());
			
			listOfNews.add(actualNews);
			listOfProperties.clear();
		}		
	}
	System.out.println(listOfNews);
	Collections.shuffle(listOfNews);
	System.out.println("shuffle utan: ");
	System.out.println(listOfNews);
	Collections.sort(listOfNews,new SortByAuthorAsc());
	System.out.println("rendezes utan: ");
	System.out.println(listOfNews);//igy mukodik
	
	
	
}

	
	
	
	
	
	//ADATOK VISSZAIRÁSA
	
	//To add some content to the structure created using the "hello" and "world" nodes, we use the Node.setProperty(String name, String value) method to add a string property called "message" to the "world" node. The value of the property is the string "Hello, World!".
	//Like the added nodes, also the property is first created in the transient storage associated with the current session. If the named property already exists, then this method will change the value of that property.
	//session.save(); 

	
	/*
		//NodeIterator nodeIterator= content.getNodes();	//visszaadja az osszes childNNode-t
		//while(nodeIterator.hasNext()){
			//Node node = nodeIterator.nextNode();
			
			
			PropertyIterator pIterator =  node.getProperties();	//visszaadja az adott node osszes propertyjet
			while (pIterator.hasNext()) {
				Property p = pIterator.nextProperty();
				System.out.println(" propertyname:  "+p.getName());
				System.out.println(" path:  "+p.getPath());
				System.out.println(" value:  "+p.getValue().toString());
			
				
					String value = p.getString();
					System.out.println("------------->" + p);
					System.out.println("------------->" + value);
				
			
				
				
			}
		
			*/	
		


	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
