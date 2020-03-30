import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {
    // ATTRIBUTES
    private String firstName, lastName, placeOfBirth;
    private int age;
    private Date dateOfBirth;
    private ImageIcon picture;

    // CONSTRUCTOR
    Person(){}
    Person(String firstName, String lastName, String placeOfBirth, int age, Date dateOfBirth, ImageIcon picture){
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfBirth = placeOfBirth;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
    }

    // METHODS
    Person interactiveCreation(){
        try {
            Scanner input = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/y");
            System.out.print("First Name: ");
            String fName = input.nextLine();
            System.out.print("Last Name: ");
            String lName = input.nextLine();
            System.out.print("Place of Birth: ");
            String placeOfBirth = input.nextLine();
            System.out.print("Age: ");
            int age = input.nextInt();
            input.nextLine();
            System.out.print("Date of Birth (Day/Month/Year): ");
            String dateString = input.nextLine();
            Date date = dateFormat.parse(dateString);
            return new Person(fName, lName, placeOfBirth, age, date, null);
        }
        catch (ParseException p){
            System.out.println(p.getMessage());
            return null;
        }
    } // to modify to add picture

    public void setAge(int age) {
        this.age = age;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPicture(ImageIcon picture) {
        this.picture = picture;
    }
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getAge() {
        return age;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public ImageIcon getPicture() {
        return picture;
    }
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

}
