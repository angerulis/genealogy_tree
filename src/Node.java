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

}
