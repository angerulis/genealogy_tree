import java.util.ArrayList;

public class Node<T> implements NodeInterface {
    // ATTRIBUTES
    private T individual = null;
    private int level=0;
    private Node<T> mother, father, spouse;
    private ArrayList<Node<T>> siblings = null;
    // CONSTRUCTORS
    public Node() {}
    public Node(T individual) {
        this(individual, 0, null, null, null, null);
    }
    public Node(T individual, int level) { this(individual, level, null, null, null, null); }
    public Node(T individual, int level, Node<T> mother, Node<T> father, Node<T> spouse, ArrayList<Node<T>> siblings) {
        this.individual = individual;
        this.level = level;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.siblings = siblings;
    }

    // SETTERS, GETTERS, AND BOOLEANS METHODS
    public int getLevel(){
        return level;
    }
    public Node<T> getMother() {
        return mother;
    }
    public Node<T> getFather() {
        return father;
    }
    public T getIndividual() {
        return individual;
    }
    public Node<T> getSpouse() {
        return spouse;
    }
    public ArrayList<Node<T>> getSiblings() { return siblings; }

    public void setLevel(int myLevel){
        level=myLevel;
    }
    public void setMother(Node<T> mother) {
        this.mother = mother;
    }
    public void setFather(Node<T> father) {
        this.father = father;
    }
    public void setIndividual(T individual) {
        this.individual = individual;
    }
    public void setSpouse(Node<T> spouse) { this.spouse = spouse; }
    public void setSiblings(ArrayList<Node<T>> siblings) { this.siblings = siblings; }

    public boolean isFirstGeneration() { return mother == null && father == null; }

    //Find a person through the node links
    public Node<Person> findNode(String firstName, String lastName){

        //

        /*
        This method compare the first name and last name in parameters
        with those of the parents( mother & father), spouse and all siblings
        We start from the current node then go to his parent node after to his spouse
        and finally in his siblings in which this method will repeat in recursive
         */

        /*PROBLEM : Due to generality I can not have access to the Person object to perform the task
        The variable curNode should be like : Node<Person> curNode = this;
        Or if i keep the genericity i should add the starting node as parameter
         public Node<Person> findNode(String firstName, String lastName, Node<Person> startingNode)
         */
        Node<Person> curNode = new Node<>();


        if(curNode == null)
            return null;
        else{
            //Compare Full name with mother full name
            if(curNode.getIndividual() != null)
                if(curNode.getIndividual().getLastName().equals(lastName) && curNode.getIndividual().getFirstName().equals(firstName) )
                    return curNode;

            //Compare Full name with mother full name
            if(curNode.getMother() != null)
                if(curNode.getMother().getIndividual().getLastName().equals(lastName) && curNode.getMother().getIndividual().getFirstName().equals(firstName))
                    return curNode.getMother();

            if(curNode.getFather() != null)
                if(curNode.getFather().getIndividual().getLastName().equals(lastName) && curNode.getFather().getIndividual().getFirstName().equals(firstName))
                    return curNode.getFather();

            if(curNode.getSpouse() != null)
                if(curNode.getSpouse().getIndividual().getLastName().equals(lastName) && curNode.getSpouse().getIndividual().getFirstName().equals(firstName))
                    return curNode.getSpouse();


            assert curNode.getSiblings() != null;
            if(curNode.getSiblings() != null)
                for (Node<Person> node : curNode.getSiblings()) {
                node.findNode(firstName, lastName);
            }

        }
        return curNode;
    }
}



