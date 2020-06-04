import java.util.Calendar;

public class Person {

    //Fields or data members that represent the Person object
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    public static String COMMA = ",";

    //Constructor declaration of class
    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        setID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setTitle(title);
        setYOB(YOB);
    }

    //Setter methods created to assign user input to data members
    public void setID(String ID) { this.ID = ID; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getFullName() {
        String fullName = (firstName + " " + lastName);
        return fullName;
    }

    public String getFormalName() {
        String formalName = (title + " " + getFullName());
        return formalName;
    }

    public static int getAge(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return (currentYear - year);

    }

    //Method to return a csv String for writing to a java text file
    public String toCSVDataRecord() {

        //csvDataRecord Object of type StringBuilder is created to build the needed output
        //Using StringBuilder to reduce number of objects created;
        StringBuilder csvDataRecord = new StringBuilder();
        csvDataRecord.append(ID);
        csvDataRecord.append(COMMA);
        csvDataRecord.append(firstName);
        csvDataRecord.append(COMMA);
        csvDataRecord.append(lastName);
        csvDataRecord.append(COMMA);
        csvDataRecord.append(title);
        csvDataRecord.append(COMMA);
        csvDataRecord.append(YOB);

        return csvDataRecord.toString();
    }
}