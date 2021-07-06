<div>
	[#assign node = cmsfn.nodeByPath("/", "news-app")]						<!-- gives back the node from path and workspace-->
	[#assign childrenNodeList =  cmsfn.children(node,"lib:actualNews")]	
	
	[#list childrenNodeList as childNode]
 		
 	[#assign peaceOfNews = cmsfn.contentByPath("/"+childNode.name, "news-app")]	
 	${peaceOfNews.author}
 	[/#list] 
 	
</div>
 
 
 
 <div>
	[#assign searchResults = searchfn.searchContent('news-app', '', '/', '') /]
	
	

[#if searchResults?has_content]
    [#list searchResults as item]
        [#if item.text??]
            <div class="found-component">
            ${item.text}
            </div>
        [/#if]
    [/#list]
[/#if]
	
	
 </div>
  
 