import java.util.*;

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
        Node<Person> n5 = new Node<>(p5, 1, n1, n2, null, null, null);
        Node<Person> n6 = new Node<>(p6, 1, n3, n4, n5, null, null);
        Node<Person> n7 = new Node<>(p7, 1, n4, n5, null, new ArrayList<>(Collections.singletonList(n6)), null);
        Node<Person> n8 = new Node<>(p8, 2, n5, n6, null, null, null);

        // Setting Relationships
            // Setting offspring
        n1.setOffspring(new ArrayList<>(Collections.singleton(n5)));
        n2.setOffspring(new ArrayList<>(Collections.singleton(n5)));
        n3.setOffspring(new ArrayList<>(Arrays.asList(n6,n7)));
        n4.setOffspring(new ArrayList<>(Arrays.asList(n6,n7)));
        n5.setOffspring(new ArrayList<>(Collections.singleton(n8)));
        n6.setOffspring(new ArrayList<>(Collections.singleton(n8)));

            // Setting spouses
        n2.setSpouse(n1); n1.setSpouse(n2);
        n3.setSpouse(n4); n4.setSpouse(n3);
        n5.setSpouse(n6); n6.setSpouse(n7);

            // Setting Siblings
        n5.setSiblings(new ArrayList<>(Collections.singletonList(n6))); // Creates an ArrayList and initiate it with a single value.
        n6.setSiblings(new ArrayList<>(Collections.singletonList(n5)));

        ArrayList<Node<Person>> back = new ArrayList<>();
        // Test getNodePerLevel
        Node.getNodePerLevel(n4, 1, back);
        try {
            for (Node<Person> a : back)
                System.out.println(a.getIndividual().getFirstName());
        }
        catch (NullPointerException e){
            System.out.println("That's it!");
        }
        System.out.println();

        // Test get allGrandParentsPerLevel
        back = Node.allGrandParentsPerLevel(n1, 0);
        try {
            for (Node<Person> a : back )
                System.out.println(a.getIndividual().getFirstName());
        }
        catch (NullPointerException e){
            System.out.println("That's it!");
        }

        System.out.println();
        // Test allDirectGrandMothers
        back = Node.allDirectGrandMothers(n8);
        try {
            for (Node<Person> a : back )
                System.out.println(a.getIndividual().getFirstName());
        }
        catch (NullPointerException e){
            System.out.println("That's it!");
        }

        System.out.println();
        // Test allDirectGrandFathers
        back = Node.allDirectGrandFathers(n8);
        try {
            for (Node<Person> a : back )
                System.out.println(a.getIndividual().getFirstName());
        }
        catch (NullPointerException e){
            System.out.println("That's it!");
        }


        GenealogyTreeGUI treeGUI = new GenealogyTreeGUI();
        treeGUI.drawTree(n1, 200, 100);


    }
}
