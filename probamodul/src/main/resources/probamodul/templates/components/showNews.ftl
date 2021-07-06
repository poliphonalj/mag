<!-- 
------------------------------------------------------------------------------------------------------------------------------------
imageAndNewsFromDB.ftl

This template is responsible for a piece of news, which contains an image from DAM. 

this is a freemarker template which comes into the showNews.ftl during the runtime,
we should not use html head, body etc tags. If we check the html source code, the browser interprets this piece of code for html.
----------------------------------------------------------------------------------------------------------------------------------  
-->
 
<div>																	<!--we are on news-app workspace-->
 
 	selected: ${content.numofnews!}
 	[#assign num = content.numofnews?number!]
 	
	[#assign node = cmsfn.nodeByPath("/", "news-app")]						<!-- gives back the node from path and workspace-->
	[#assign childrenNodeList =  cmsfn.children(node,"lib:actualNews")]		<!--returns a LIST of childnodes, they are actualNews like peteri, peteri2 etc-->
	<!-- [#assign childNode = childrenNodeList[0]]	-->							<!--the very first item of the list is the oldest one-->
	
	
	[#list 1..num as i]
	[#assign childNode = childrenNodeList[childrenNodeList?size - i]]			<!--the very last item of the list is the oldest one-->
			
			<strong> node: /${childNode.name!}	</strong>						<!--render the name of the nodes-->
			[#assign childName = "/"+childNode.name	]							
			[#assign peaceOfNews = cmsfn.contentByPath(childName, "news-app")]		
	

				<p>${peaceOfNews.author}</p>								
				<p>${peaceOfNews.intro}</p>
				<p>${peaceOfNews.text}</p>
				<p>${peaceOfNews.publish_date!}</p>
				<p>${peaceOfNews.image}</p>
				
				[#assign img = "jcr:"+peaceOfNews.image]
				
				<img src="${damfn.getAssetLink(img!)}" width="300" height="234">	<!--showing an image, we need to use an embed html image tag-->
			
				<br><br>
			[/#list]	
				
</div>