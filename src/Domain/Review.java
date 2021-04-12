package Domain;

import java.sql.Date;

public class Review {
	private long seq;
	private long member_no;
	private String nick;
	private String subject;
	private String content;
	private Date rdate;
	private long views;
	private long rlike;
	private String name;
	
	public Review(long seq, long member_no, String nick, String subject, String content, Date rdate, long views,
			long rlike) {
		super();
		this.seq = seq;
		this.member_no = member_no;
		this.nick = nick;
		this.subject = subject;
		this.content = content;
		this.rdate = rdate;
		this.views = views;
		this.rlike = rlike;
		
	}
	/*public Review(long seq) {
		this.seq = seq;
	}*/
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public long getMember_no() {
		return member_no;
	}
	public void setMember_no(long member_no) {
		this.member_no = member_no;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public long getViews() {
		return views;
	}
	public void setViews(long views) {
		this.views = views;
	}
	public long getRlike() {
		return rlike;
	}
	public void setRlike(long rlike) {
		this.rlike = rlike;
	}
	

	
}