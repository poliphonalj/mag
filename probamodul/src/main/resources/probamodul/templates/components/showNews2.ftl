<div>
 
 beirt: ${content.hirszam!}
 
	[#assign num = content.hirszam?number!]
	[#assign node = cmsfn.nodeByPath("/", "news-app")]						<!-- gives back the node form path and workspace-->
	[#assign childrenNodeList =  cmsfn.children(node,"lib:actualNews")]		<!--returns a LIST of childnodes, they are actualNews like peteri, peteri2 etc-->
	<!-- [#assign childNode = childrenNodeList[0]]	-->							<!--the very first item of the list is the oldest one-->
	
	[#if childrenNodeList?size  < num]
	  nincs még ${num} db rekord a db-ben! Ezért megjeelenitem mindet, de max 3-at!
	  [#if childrenNodeList?size  <=3]
	    [#assign num = childrenNodeList?size]
	  [#else]
	    [#assign num = 3]
	  [/#if]  
	[/#if]
	
	
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