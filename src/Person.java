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
    boolean sex;
    private ImageIcon picture;
    //Sex added : Male = true & Female = false
    // CONSTRUCTOR
    Person(){}
    Person(String firstName, String lastName, String placeOfBirth, int age, Date dateOfBirth, boolean sex, ImageIcon picture){
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfBirth = placeOfBirth;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
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
            System.out.print("Sex M = true & F = false): ");
            boolean sex = input.nextBoolean();
            System.out.print("Date of Birth (Day/Month/Year): ");
            String dateString = input.nextLine();
            Date date = dateFormat.parse(dateString);
            return new Person(fName, lName, placeOfBirth, age, date, sex, null);
        }
        catch (ParseException p){
            System.out.println(p.getMessage());
            return null;
        }
    } // to modify to add picture
    Person interactiveMod(){
        try {
            Scanner input = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/y");
            System.out.print("First Name: ");
            String fName = input.nextLine();
            this.setFirstName(fName);
            System.out.print("Last Name: ");
            String lName = input.nextLine();
            this.setLastName(lName);
            System.out.print("Place of Birth: ");
            String placeOfBirth = input.nextLine();
            this.setPlaceOfBirth(placeOfBirth);
            System.out.print("Age: ");
            int age = input.nextInt();
            this.setAge(age);
            input.nextLine();
            System.out.print("Sex M = true & F = false): ");
            boolean sex = input.nextBoolean();
            this.setSex(sex);
            System.out.print("Date of Birth (Day/Month/Year): ");
            String dateString = input.nextLine();
            Date date = dateFormat.parse(dateString);
            this.setDateOfBirth(date);

        } catch (ParseException pe){ }

        return this;
    }

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
    public void setSex(boolean sex) { this.sex = sex; }

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

    public boolean isMale() {return sex; }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

}
