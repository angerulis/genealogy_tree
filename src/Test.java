import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test  implements  GenealogyTreeInterface{
    public static void main(String[] args) throws ParseException {
        Test t = new Test();
        Scanner input = new Scanner(System.in);
        SimpleDateFormat date = new SimpleDateFormat("d/M/y");
        System.out.print("Date of Birth (Day/Month/Year): ");
        String dateString = input.nextLine();
        Date date1 = date.parse(dateString);
        System.out.println(date1);
        System.out.println(dateString);


    }

    @Override
    public NodeInterface addChild(NodeInterface child, int level, String parentName) {
        return null;
    }

    @Override
    public NodeInterface insertChild(NodeInterface child, int level, String parentName) {
        return null;
    }

    @Override
    public ArrayList<NodeInterface> findIndividual(String firstName, String lastName) {
        return null;
    }

    @Override
    public ArrayList<NodeInterface> findAllGrandParents(NodeInterface child) {
        return null;
    }

    @Override
    public ArrayList<NodeInterface> findAllGrandfathers(NodeInterface child) {
        return null;
    }

    @Override
    public ArrayList<NodeInterface> findAllGrandMother(NodeInterface child) {
        return null;
    }

    @Override
    public ArrayList<NodeInterface> findAllGrandParentsPerLevel(NodeInterface child, int level) {
        return null;
    }

    @Override
    public NodeInterface modifyInformation(String firstName, String lastName, int level) {
        return null;
    }

    @Override
    public NodeInterface deleteIndividual(String firstName, String lastName, int level) {
        return null;
    }
}
