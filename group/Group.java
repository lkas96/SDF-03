package group;

public class Group {

    //Variables
    private String group;
    private String type;
    private Integer yearDebut;

    
    //Constructors
    public Group(String group, String type, Integer year) {
        this.group = group;
        this.type = type;
        this.yearDebut = year;
    }
    public Group(){

    }

    //Getters Setters
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getYear() {
        return yearDebut;
    }
    public void setYear(Integer year) {
        this.yearDebut = year;
    }

    
    
}
