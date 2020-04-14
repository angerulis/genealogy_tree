import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Node<T> implements NodeInterface {
    // ATTRIBUTES
    private T individual = null;
    private int level=0;
    private Node<T> mother, father, spouse;
    private ArrayList<Node<T>> offspring = null , siblings = null;
    // CONSTRUCTORS
    public Node() {}
    public Node(T individual) {
        this(individual, 0, null, null, null, null,null);
    }
    public Node(T individual, int level) { this(individual, level, null, null, null, null,null); }
    public Node(T individual, int level, Node<T> mother, Node<T> father, Node<T> spouse, ArrayList<Node<T>> siblings, ArrayList<Node<T>> offspring) {
        this.individual = individual;
        this.level = level;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.siblings = siblings;
        this.offspring = offspring;
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
    public ArrayList<Node<T>> getOffspring() { return offspring; }

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
    public void setOffspring(ArrayList<Node<T>> offspring) { this.offspring = offspring; }

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
    public static void iterativeDFS(Node<Person> root){
        Deque<Node<Person>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node<Person> node = stack.pop();
            if (node.father.father != null)
                System.out.println(node.father.father.getIndividual().getFirstName());

        }
    }
    public static @NotNull List<Node<Person>> getNodePerLevel(@NotNull Node<Person> root, int levelWanted, ArrayList<Node<Person>> nodes){
            if (root.getLevel() < levelWanted && root.getOffspring() != null) // if level is different from the node's, and node has at list one child, we recall the method
                for (Node<Person> p : root.getOffspring())
                    getNodePerLevel(p, levelWanted, nodes); // the goal is to have the same level as the nodes while being able to move around and collect other node by their adjacent nodes
            else if (root.getLevel() > levelWanted) // Same principle here
                    getNodePerLevel(root.getFather(), levelWanted, nodes);
            else {
                nodes.add(root); // If the level is equal, we add root as a match and its spouse node
                nodes.add(root.getSpouse());
                if (root.getSiblings() != null)
                    for (Node<Person> sibling: root.getSiblings()){ // add siblings if any
                        nodes.add(sibling);
                        nodes.add(sibling.spouse);
                    }

                    getNodePerLevel(root.getSpouse().getFather(), levelWanted, nodes); // StackOverFlowError // root.getOffspring.getFather

             }

        return removeDuplicates(nodes);
    }
    private static ArrayList<Node<Person>> allDirectGrandMothersCall(@NotNull Node<Person> root){
        ArrayList<Node<Person>> directGM = null;
         try {
             directGM = new ArrayList<>() {{
                 add(root.getFather().getMother());
                 add(root.getMother().getMother());
             }};
         }catch (NullPointerException npe){
             System.out.println(root.getIndividual().getFirstName() + " has no grand mothers.");
         }
        return directGM;
    }
    public static ArrayList<Node<Person>> allDirectGrandMothers(Node<Person> root){
            return allDirectGrandMothersCall(root);
    }
    public static ArrayList<Node<Person>> allGrandParentsPerLevel(Node<Person> root, int level){
        ArrayList<Node<Person>> nodes = new ArrayList<>(), grandParents = new ArrayList<>();
        try{
            getNodePerLevel(root, level, nodes);
            for (Node<Person> p : nodes)
                if (p.getOffspring() != null)
                    for (Node<Person> q: p.getOffspring())
                        if (q.getOffspring() != null)
                            grandParents.add(p);

        }catch (NullPointerException npe){
            System.out.println("there is no grand parent at this level");
        }
        return grandParents;
    }

    @Contract("_ -> param1")
    public static <T> @NotNull ArrayList<T> removeDuplicates(ArrayList<T> list) {
        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(list);

        // Clear the list
        list.clear();

        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);

        // return the list
        return list;
    }
}






