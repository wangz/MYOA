package oa.data;
import oa.sys.*;
public class Message {
	private int id;
	private String title;
	private String time; 
	private int sender;
	private int accepter;
	private String content;
	private int news;

	/**
	 * 信息收发
	 */
	public Message() {
		super();
		id=0;
		title="";
		time=new Time().getYMDHMS();
		sender=0;
		accepter=0;
		content="";
		news=0;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setSender(int sender) {
		this.sender = sender; 
	}
	public int getSender() {
		return sender;
	}
	public void setAccepter(int accepter) {
		this.accepter = accepter;
	}
	public int getAccepter() {
		return accepter;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setNews(int news) {
		this.news= news;
	}
	public int getNews() {
		return news;
	}
}
