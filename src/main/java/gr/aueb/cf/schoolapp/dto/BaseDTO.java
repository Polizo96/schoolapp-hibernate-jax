package gr.aueb.cf.schoolapp.dto;

public abstract class BaseDTO {
    private Long id;

    public BaseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
