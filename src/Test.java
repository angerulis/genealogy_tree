import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        Person p1 = new Person("Leo", "Haker", "York", 102, new Date(),true, null);
        Person p2 = new Person("Adele", "Shap", "York", 102, new Date(), true, null);
        Person p3 = new Person("Hermes", "Lee", "York", 102, new Date(), true, null);
        Person p4 = new Person("John", "haker", "Abu Dabi", 102, new Date(), true,null);
        Person p5 = new Person("Ray", "Haker", "Abu Dabi", 80, new Date(), true, null);
        Person p6 = new Person("Steve", "Levis", "Paris", 78, new Date(),true, null);
        Person p7 = new Person("Zoe", "Levis", "Paris", 84, new Date(), true, null);
        Person p8 = new Person("Jany", "ball", "Abidjan", 42, new Date(), true,  null);


        Node<Person> n1 = new Node<>(p1, 1,null, null, null, null, null);
        Node<Person> n2 = new Node<>(p2, 1, null, null, n1, null, null);
        Node<Person> n3 = new Node<>(p3, 2, n1, n2, null,  null, null);
        Node<Person> n4 = new Node<>(p4, 2, n1, n2, null, null, null);
        Node<Person> n5 = new Node<>(p5, 2, n1, n2,  null, null, null);
        Node<Person> n6 = new Node<>(p6, 2, null, null, n5, null, null);
        Node<Person> n7 = new Node<>(p7, 3, n6, n3, null, null, null);
        Node<Person> n8 = new Node<>(p8, 2, null, null, n5, null, null);

        ArrayList<Node<Person>> sibling = new ArrayList<>();
        sibling.add(n4); sibling.add(n3);
        n5.setSpouse(n8);
        n3.setSpouse(n6);
        n5.setSiblings(sibling);
        sibling.add(n5);
        sibling.remove(n4);
        n4.setSiblings(sibling);
        //n4.setSpouse(n9);
        n8.setSpouse(n5);
        sibling.remove(n3); sibling.add(n4);
        n3.setSiblings(sibling);
        n1.setSpouse(n2);

        ArrayList<Node<Person>> offSpring = new ArrayList<>();
        offSpring.add(n7);
        n3.setOffspring(offSpring);

        offSpring = new ArrayList<>();
        offSpring.add(n5); offSpring.add(n3); offSpring.add(n4);
        n1.setOffspring(offSpring);

        GenealogyTreeGUI treeGUI = new GenealogyTreeGUI();
        treeGUI.drawTree(n1, 200, 100);


    }

}