import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jeanne", "Jane", "Gagnoa", 102, new Date(), null);
        Person p2 = new Person("Martin", "Jane", "Gagnoa", 102, new Date(), null);
        Person p3 = new Person("Myriam", "Jane", "Gagnoa", 102, new Date(), null);
        Person p4 = new Person("Ping", "Pong", "Gagnoa", 102, new Date(), null);
        Person p5 = new Person("Esther", "Jane", "Gagnoa", 80, new Date(), null);
        Person p6 = new Person("Ben", "Jane", "Gagnoa", 78, new Date(), null);
        Person p7 = new Person("Rita", "Jane", "Gagnoa", 84, new Date(), null);
        Person p8 = new Person("John", "Jane", "Gagnoa", 42, new Date(), null);
        Person p9 = new Person("Sekouba", "Bambino", "Lakota", 53, new Date(), null);

        Node<Person> n1 = new Node<>(p1);
        Node<Person> n2 = new Node<>(p2);
        Node<Person> n3 = new Node<>(p3);
        Node<Person> n4 = new Node<>(p4);
        Node<Person> n5 = new Node<>(p5, 1, n1, n2, null, null,null);
        Node<Person> n6 = new Node<>(p6, 1, n3, n4, n5, null,null);
        Node<Person> n7 = new Node<>(p7, 1, n4, n5, null, new ArrayList<>(Collections.singletonList(n6)),null);
        Node<Person> n8 = new Node<>(p8, 2, n5, n6, null, null,null);
        Node<Person> n9 = new Node<>(p9, 3, n8,n8, null, null, null);

        // Setting missing relations
            // Setting offspring
        n1.setOffspring(new ArrayList<>(Collections.singletonList(n5)));
        n2.setOffspring(new ArrayList<>(Collections.singletonList(n5)));
        n3.setOffspring(new ArrayList<>(Arrays.asList(n6,n7)));
        n4.setOffspring(new ArrayList<>(Arrays.asList(n6,n7)));
        n5.setOffspring(new ArrayList<>(Collections.singletonList(n8)));
        n6.setOffspring(new ArrayList<>(Collections.singletonList(n8)));
        n8.setOffspring(new ArrayList<>(Collections.singletonList(n9)));

            // Setting Spouse
        n1.setSpouse(n2); n2.setSpouse(n1);
        n3.setSpouse(n4); n4.setSpouse(n3);
        n5.setSpouse(n6); n6.setSpouse(n5);

            // Setting Siblings
        n5.setSiblings(new ArrayList<>(Collections.singletonList(n6))); // Creates an ArrayList and initiate it with a single value.

        // Creating Tree
        GenealogyTree tree = new GenealogyTree(n1);
        GenealogyTree tree2 = new GenealogyTree(n4);
        GenealogyTree tree3 = new GenealogyTree(n8);
        tree.setLeftTree(tree2); tree2.setLeftTree(tree3);

        ArrayList<Node<Person>> result = tree.findAllGrandParentsPerLevel(n1, 0);
        System.out.println(result.size());
    }
}
