package gui.guidance;

import java.util.Comparator;

public class SortByAuthorAsc implements Comparator<News>{
	 
@Override
	public int compare(News a, News b)
	    {
	        return a.getAuthor().compareTo(b.getAuthor());
	    }
}
