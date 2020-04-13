import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jeanne", "Jane", "Gagnoa", 102, new Date(),true, null);
        Person p2 = new Person("Martin", "Jane", "Gagnoa", 102, new Date(), true, null);
        Person p3 = new Person("Myriam", "Jane", "Gagnoa", 102, new Date(), true, null);
        Person p4 = new Person("Ping", "Pong", "Gagnoa", 102, new Date(), true,null);
        Person p5 = new Person("Esther", "Jane", "Gagnoa", 80, new Date(), true, null);
        Person p6 = new Person("Ben", "Jane", "Gagnoa", 78, new Date(),true, null);
        Person p7 = new Person("Rita", "Jane", "Gagnoa", 84, new Date(), true, null);
        Person p8 = new Person("John", "Jane", "Gagnoa", 42, new Date(), true,  null);

        Node<Person> n1 = new Node<>(p1);
        Node<Person> n2 = new Node<>(p2);
        Node<Person> n3 = new Node<>(p3);
        Node<Person> n4 = new Node<>(p4);
        Node<Person> n5 = new Node<>(p5, 1, n1, n2, null, null);
        Node<Person> n6 = new Node<>(p6, 1, n3, n4, n5, null);
        Node<Person> n7 = new Node<>(p7, 1, n4, n5, null, new ArrayList<>(Collections.singletonList(n6)));
        Node<Person> n8 = new Node<>(p8, 2, n5, n6, null, null);

        Node.iterativeDFS(n8);
        // Setting missing spouse
        n5.setSpouse(n6);
        n5.setSiblings(new ArrayList<>(Collections.singletonList(n6))); // Creates an ArrayList and initiate it with a single value.

    }
}
