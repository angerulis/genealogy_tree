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
    public ArrayList<Node<Person>> findAllGrandParentsPerLevel(Node<Person> child, int level) {
        return getAllNodesAtLevel(child, level);
    }

    public ArrayList<Node<Person>> getAllNodesAtLevel(Node<Person> person, int level) {
        level = person.getLevel();
        ArrayList<Node<Person>> list = new ArrayList<>();
        if (level == 0 && person.getLevel() == 0) {
            if (person.getSiblings() != null)
                for (Node<Person> p : person.getSiblings())
                    for (Node<Person> p1 : p.getSiblings())
                        for (int i = 0; i < p.getSiblings().size(); ++i)
                            if (p1.getOffspring().get(i).getOffspring() != null)
                                list.add(person);
            if (person.getSpouse().getSiblings() != null)
                for (Node<Person> p : person.getSpouse().getSiblings())
                    for (Node<Person> p1 : p.getSiblings())
                        for (int i = 0; i < p.getSiblings().size(); ++i)
                            if (p1.getOffspring().get(i).getOffspring() != null)
                                list.add(person);
            if (list.contains(person) && person.getSpouse() != null)
                list.add(person.getSpouse());

            return list;
        }
        else{
            try {
                if (person.getOffspring() != null)
                    for (Node<Person> p : person.getOffspring())
                        for (Node<Person> p1 : p.getOffspring())
                            if (p1 != null)
                                for (int i = 0; i < person.getOffspring().size(); ++i)
                                    if (person.getOffspring().get(i).getOffspring() != null)
                                        list.add(person);

//                for (Node<Person> personNode : person.getOffspring())
//                    if (personNode != null)
//                        for (Node<Person> personNode1 : personNode.getOffspring())
//                            if (personNode1 != null)
//                                list.add(person);
                for (Node<Person> personNode : person.getSiblings())
                    getAllNodesAtLevel(personNode, level);
            }
            catch (Exception e){
                System.out.println("No Grandparent at level.");
            }
        }
        return list;
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
