package dto;

public class NoteDto {
    private Long id;
    private String horseName;
    private String content;
    private String creatorFullName;

    public NoteDto() {}

    public NoteDto(Long id, String horseName, String content, String creatorFullName) {
        this.id = id;
        this.horseName = horseName;
        this.content = content;
        this.creatorFullName = creatorFullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatorFullName() {
        return creatorFullName;
    }

    public void setCreatorFullName(String creatorFullName) {
        this.creatorFullName = creatorFullName;
    }
}
