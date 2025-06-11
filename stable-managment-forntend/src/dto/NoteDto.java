package dto;

import java.time.LocalDateTime;

public class NoteDto {

	private Long id;
	private Long horseId;
    private Long creatorId;
    private String content;
    private LocalDateTime createdDate;

    public NoteDto() {}
    
    public NoteDto(Long id, Long horseId, Long creatorId, String content, LocalDateTime createdDate) {
		super();
		this.id = id;
		this.horseId = horseId;
		this.creatorId = creatorId;
		this.content = content;
		this.createdDate = createdDate;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHorseId() {
		return horseId;
	}

	public void setHorseId(Long horseId) {
		this.horseId = horseId;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


   
}
