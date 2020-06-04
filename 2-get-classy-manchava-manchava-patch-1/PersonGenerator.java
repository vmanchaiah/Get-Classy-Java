import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class PersonGenerator {
    public static void main(String[] args) {

        // Defining a variable of type FileWriter to create a text file
        FileWriter fileWriter = null;
        
        try {
            //Creating an ArrayList object called people to store objects of type Person
            ArrayList<Person> people = new ArrayList<Person>();
        
            // creating Scanner object to read user input
            Scanner in = new Scanner(System.in);

            // Variables to hold information read from the user
            String ID;
            String firstName;
            String lastName;
            String title;
            int YOB;
            
            char readMorePeople = 'y';

            //Loop will run and read information until user inputs character n
            while (readMorePeople == 'y') {

                //Collecting user info
                ID = SafeInput.getString(in, "What is your ID? ");
                firstName = SafeInput.getString(in, "What is your first name? ");
                lastName = SafeInput.getString(in, "What is your last name? ");
                title = SafeInput.getString(in, "What is your title? ");
                //Reading the string YOB input by the user and converting it to an int
                YOB = Integer.parseInt(SafeInput.getString(in, "What is your year of birth? "));

                //Constructing a person object from the information gathered
                Person person = new Person(ID, firstName, lastName, title, YOB);

                //Adding each instance of Person to ArrayList people
                people.add(person);

                System.out.println("Do you have any more people to enter? (y/n)");
                readMorePeople = in.nextLine().charAt(0);
            }

            // Creating fileWriter object to create a text file
            fileWriter = new FileWriter("Persons.txt");

            //Writing person information to a text file

            for (int peopleIndex = 0; peopleIndex < people.size(); peopleIndex++) {
                if (peopleIndex > 0) {
                    //to write a newline between each record
                    fileWriter.write("\n");
                }
                //Getting person objects from the ArrayList one at a time
                Person person = people.get(peopleIndex);

                // Getting formatted string from Person.toCSVDataRecord() method and writing to a text file
                fileWriter.write(person.toCSVDataRecord());
                System.out.println(person.toCSVDataRecord());
            }

        } catch (Exception e) {
            //prints the code execution path
            e.printStackTrace();
        }

        //to prevent resource leaks
        finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
