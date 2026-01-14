package model;

public class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;

    public Fresher() {
        super();
    }

    public Fresher(String id, String firstName, String lastName, int birthDate,
            String address, String phone, String email, int candidateType,
            String graduationDate, String graduationRank) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    @Override
    public String toString() {
        return super.toString() + " | Graduation: " + graduationDate
                + " | Rank: " + graduationRank;
    }
}
