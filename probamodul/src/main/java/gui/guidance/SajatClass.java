package gui.guidance;


import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class SajatClass<RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition> {
	
public String name="hello magnolia";
private String name2="hello magnolia2";
   
    @Inject
    public SajatClass(Node content, RD definition, RenderingModel<?> parent) {
        super(content, definition, parent);
    }

    @Override
    public String execute() {
        return super.execute();
        
    }

    public String getName() {			
    	return name;
    }
    
     public String getName2() {			
    	return name2;
    }
     
     public void setName(String name) {
    	 this.name=name;
     }
     
}