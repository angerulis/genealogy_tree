import java.util.ArrayList;

public class Test  implements  GenealogyTreeInterface{
    public static void main(String[] args) {
        Test t = new Test();

    }

    @Override
    public Node addChild(Node child, int level, String parentName) {
        return null;
    }

    @Override
    public Node insertChild(Node child, int level, String parentName) {
        return null;
    }

    @Override
    public ArrayList<Node> findIndividual(String firstName, String lastName) {
        return null;
    }

    @Override
    public ArrayList<Node> findAllGrandParents(Node child) {
        return null;
    }

    @Override
    public ArrayList<Node> findAllGrandfathers(Node child) {
        return null;
    }

    @Override
    public ArrayList<Node> findAllGrandMother(Node child) {
        return null;
    }

    @Override
    public ArrayList<Node> findAllGrandParentsPerLevel(Node child, int level) {
        return null;
    }

    @Override
    public Node modifyInformation(String firstName, String lastName, int level) {
        return null;
    }

    @Override
    public Node deleteIndividual(String firstName, String lastName, int level) {
        return null;
    }
}
