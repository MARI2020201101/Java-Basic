package net.notice;

public class NoticeDTO {
	
	private int noticeno;
	private String subject;
	private String content;
	private String regdt;
	
	public NoticeDTO(int noticeno, String subject, String content, String regdt) {
		this.noticeno = noticeno;
		this.subject = subject;
		this.content = content;
		this.regdt = regdt;
	}
	
	public NoticeDTO() {}

	public int getNoticeno() {
		return noticeno;
	}

	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
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

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeno=" + noticeno + ", subject=" + subject + ", content=" + content + ", regdt=" + regdt
				+ "]";
	}
	
	
	
}
