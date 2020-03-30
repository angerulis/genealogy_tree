import java.util.ArrayList;

public class GenealogyTree implements GenealogyTreeInterface {
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
