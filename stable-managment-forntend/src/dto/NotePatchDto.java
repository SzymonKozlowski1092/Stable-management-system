package dto;

public class NotePatchDto 
{
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NotePatchDto(String content) {
		super();
		this.content = content;
	}

}
