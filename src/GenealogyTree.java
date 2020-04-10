import java.util.ArrayList;

public class GenealogyTree implements GenealogyTreeInterface {
    // INSTANCES VARIABLES
    private Node<Person> rootNode = null;
    private GenealogyTree leftTree = null, rightTree = null;
    private static int height = -1;


    // CONSTRUCTOR
    GenealogyTree(){}
    GenealogyTree(Node<Person> rootNode){ this.rootNode = rootNode; }
    GenealogyTree(Node<Person> rootNode, GenealogyTree leftTree, GenealogyTree rightTree){
        this.rootNode = rootNode;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }


    // METHODS
    public static GenealogyTree createBinaryTree() { return new GenealogyTree(); }
    public static GenealogyTree createBinaryTree(Node<Person> rootNode) { return new GenealogyTree(rootNode); }
    public Node<Person> getRootNode() { return rootNode; }
    public void setRootNode(Node<Person> rootNode) { this.rootNode = rootNode; }
    public GenealogyTree getLeftTree() { return leftTree; }
    public void setLeftTree(GenealogyTree leftTree) { this.leftTree = leftTree; }
    public GenealogyTree getRightTree() { return rightTree; }
    public void setRightTree(GenealogyTree myRightTree) { rightTree = myRightTree; }

    // OTHER METHODS
    public boolean isRootTree() {
        return(rootNode != null && rootNode.getFather() == null && rootNode.getMother() == null);
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
