package dto;

public class DoctorDTO {

    private String code;
    private String name;
    private String specialization;
    private Integer availability;

    public DoctorDTO() {
    }

    public DoctorDTO(String code, String name, String specialization, Integer availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public boolean hasCode() {
        return code != null && !code.trim().isEmpty();
    }

    public boolean hasName() {
        return name != null && !name.trim().isEmpty();
    }

    public boolean hasSpecialization() {
        return specialization != null && !specialization.trim().isEmpty();
    }

    public boolean hasAvailability() {
        return availability != null;
    }
}
