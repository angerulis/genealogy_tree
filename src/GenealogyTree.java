import java.util.ArrayList;
import java.util.HashMap;

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
        ArrayList<NodeInterface> grandParents = null;

        ArrayList<NodeInterface>  grandfathers = this.findAllGrandfathers(child);
        ArrayList<NodeInterface>  grandMothers = this.findAllGrandMothers(child);

        if (grandfathers != null && grandMothers != null){
            grandParents = new ArrayList<>();

            grandParents.addAll(grandfathers);
            grandParents.addAll(grandMothers);
        }

        return grandParents;
    }

    @Override
    public ArrayList<NodeInterface> findAllGrandfathers(NodeInterface child) {
        ArrayList<NodeInterface> grandfathers = null;
        ArrayList<NodeInterface> childParents = this.getParents(child);

        if (!childParents.isEmpty()){
           NodeInterface fatherOfFather =  ((Node<Person>)childParents.get(0)).getFather();
           NodeInterface fatherOfMother =  ((Node<Person>)childParents.get(1)).getFather();

           if (fatherOfFather != null && fatherOfMother != null){
               grandfathers = new ArrayList<>();
               grandfathers.add(fatherOfFather);
               grandfathers.add(fatherOfMother);
           }
        }

        return grandfathers;
    }

    @Override
    public ArrayList<NodeInterface> findAllGrandMothers(NodeInterface child) {
        ArrayList<NodeInterface> grandMothers = null;
        ArrayList<NodeInterface> childParents = this.getParents(child);

        if (!childParents.isEmpty()){
            NodeInterface motherOfFather =  ((Node<Person>)childParents.get(0)).getMother();
            NodeInterface motherOfMother =  ((Node<Person>)childParents.get(1)).getMother();

            if (motherOfFather != null && motherOfMother != null){
                grandMothers = new ArrayList<>();
                grandMothers.add(motherOfFather);
                grandMothers.add(motherOfMother);
            }
        }

        return grandMothers;
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

    /*Return the parent sof the specified child or empty list...
    index 0: Father
    index 1: Mother
    */
    private ArrayList<NodeInterface> getParents(NodeInterface child){
        ArrayList<NodeInterface> parents = null;

        if (child != null){
            parents = new ArrayList<>();
            parents.add(((Node<Person>)child).getFather());
            parents.add(((Node<Person>)child).getMother());
        }

        return parents;
    }
}
