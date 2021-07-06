package gui.guidance;

import java.util.Comparator;

public class SortByPublishDateAsc implements Comparator<News>{

	@Override
	public int compare(News a, News b) {
		return a.getPublish_date().compareTo(b.getPublish_date());
	}

	
}
