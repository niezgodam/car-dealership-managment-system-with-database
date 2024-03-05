public class Employee extends Person {
    
    private int experience;
    private String position;

    public Employee(String firstName, String lastName, int age, int experience, String position) {
        super(firstName, lastName, age);
        this.experience = experience;
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "First name: " + getFirstName() + ", Last name: " + getLastName() + ", Age: " + getAge() + ", Experience: " + experience + " years" + ", Position: " + position;
    }
}
