import java.util.ArrayList;

public class GenealogyTree implements GenealogyTreeInterface {

    Node<Person> root;

    public GenealogyTree(){}
    public GenealogyTree(Node root){this.root = root; }


    @Override
    public NodeInterface addChild(NodeInterface child, int level, String parentName) {
        return null;
    }

    @Override
    public NodeInterface insertChild(NodeInterface child, int level, String parentFirstName, String parentLastName) {
        /*
        The method looks for the parent node with his name and level
        When found we check the sex of parent and set the child's father/mother attribute
         */

         /*
         Node parent;
         ArrayList<Node<Person>> personFound  =  root.findNode(parentFirstName, parentLastName);
         for( Node<Person> curNOde : personfound){
            if (curNode.getLevel == level)
                parent = curNode;
                break;
            }
         if(parent.getIndividual().isMale){
            child.setFather(parent);
            child.setLevel(level + 1);
         }

         return child;

          */
         return  child;
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
