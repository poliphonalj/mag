<div>
	[#assign listOfNews = model.getAllNews()]
 	[#list listOfNews as actualNewsItem]
 		date: ${actualNewsItem.publish_date}<br>
 		author: ${actualNewsItem.author}<br>
 		intro: ${actualNewsItem.author}<br>
 		text: ${actualNewsItem.text}<br>
 		
 		[#assign img = "jcr:"+actualNewsItem.image]
		<img src="${damfn.getAssetLink(img!)}" width="300" height="234">		
				
 		<br><hr><br>
 	[/#list] 
</div>
 
 
 
 <div>
	
	[#assign listOfNews = model.getAllNews()]
	
		[#list 1..5 as i]
			
 		[/#list]
 	
 			
 			</div>
 	
 </div>
  
 