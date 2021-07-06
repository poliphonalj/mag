package gui.guidance;

public class MyPagination {

	private int numOfArticles;
	

	public MyPagination(int numOfArticles) {
		
		this.numOfArticles = numOfArticles;
	}

	
	public int getNumOfArticles() {
		return numOfArticles;
	}

	
	public void setNumOfArticles(int numOfArticles) {
		this.numOfArticles = numOfArticles;
	}
	
	
	public int countPages(){
		if(numOfArticles%2==0){
			return numOfArticles/2;
		}
		else{
			return (numOfArticles/2)+1;
		}
	}
	
	
	public void shareArticlesForPages(){
		
	}
	
	
}
