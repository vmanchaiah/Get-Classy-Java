import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {

        //Creating chooser object of type JFileChooser
        JFileChooser chooser = new JFileChooser(".");

        //Allows user to select file
        int returnValue = chooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            //User successfully selected a file
            //Creating a File object and assigning it to selectedFile variable
            File selectedFile = chooser.getSelectedFile();
            BufferedReader bufFileReader = null;

            try {
                /**
                 Creating a FileReader object for the selected file and passing that as
                 the parameter for the BufferedReader constructor
                 */
                bufFileReader = new BufferedReader(new FileReader(selectedFile));
                //Creating the format of the header
                System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n", "ID", "FirstName", "LastName", "Title", "YOB");
                System.out.print("=======================================================");

                //Declaring String variable to use when reading from the file

                //Creating an ArrayList object called people to store objects of type Person
                ArrayList<Person> people = new ArrayList<Person>();
                String line = null;

                //Looping until there are no more lines left to read in the file
                while ((line = bufFileReader.readLine()) != null) {

                    //Splitting the comma delimited string read from the file
                    String[] lineSplit = line.split(",");

                    //Printing formatted user information
                    System.out.printf("\n%-10s\t%-10s\t%-10s\t%-10s\t%-10s", lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4]);

                    //Instantiating a Person object using information read from the file
                    Person person = new Person(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], Integer.parseInt(lineSplit[4]));




                    //Adding each instance of Person to ArrayList people
                    people.add(person);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                // cleaning up system resources
                if(bufFileReader != null)
                {
                    try {
                        bufFileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}