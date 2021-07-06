package gui.guidance;

import java.sql.Date;
import java.util.Comparator;

import com.google.inject.spi.PrivateElements;

public class News {
  private String author;
  private String image;
  private String intro;
  private String text;
  private String jcr_name;
  private String publish_date;
  

  
  
  public News() {
	
}

public News(String author, String image, String intro, String text, String jcr_name, String publish_date) {
	super();
	this.author = author;
	this.image = image;
	this.intro = intro;
	this.text = text;
	this.jcr_name = jcr_name;
	this.publish_date = publish_date;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getIntro() {
	return intro;
}

public void setIntro(String intro) {
	this.intro = intro;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public String getJcr_name() {
	return jcr_name;
}

public void setJcr_name(String jcr_name) {
	this.jcr_name = jcr_name;
}

public String getPublish_date() {
	return publish_date;
}

public void setPublish_date(String publish_date) {
	this.publish_date = publish_date;
}

@Override
public String toString() {
	return "News [author=" + author + ", image=" + image + ", intro=" + intro + ", text=" + text + ", jcr_name="
			+ jcr_name + ", publish_date=" + publish_date + "]";
}

}



