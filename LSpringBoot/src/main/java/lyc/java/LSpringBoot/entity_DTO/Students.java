package lyc.java.LSpringBoot.entity_DTO;


public class Students {

  private long id;
  private String name;
  private long gender;
  private long grade;
  private long score;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public long getGrade() {
    return grade;
  }

  public void setGrade(long grade) {
    this.grade = grade;
  }


  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }

}
