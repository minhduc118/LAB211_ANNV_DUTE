package model;

public class Experience extends Candidate {

    private int yearExperience;
    private String professionalSkill;

    public Experience() {
        super();
    }

    public Experience(String id, String firstName, String lastName, int birthDate,
            String address, String phone, String email, int candidateType,
            int yearExperience, String professionalSkill) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " | Experience: " + yearExperience
                + " years | Skill: " + professionalSkill;
    }
}
