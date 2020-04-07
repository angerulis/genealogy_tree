import java.util.Scanner;

public class Node<T> implements NodeInterface {
    // ATTRIBUTES
    private T individual = null;
    private int level=0;
    private Node<T> mother, father;

    // CONSTRUCTORS
    public Node() {}
    public Node(T individual) {
        this(individual, 0, null, null);
    }
    public Node(T individual, int myLevel) { this(individual, myLevel, null, null); }
    public Node(T individual, int myLevel, Node<T> mother, Node<T> father) {
        this.individual = individual;
        level = myLevel;
        this.mother = mother;
        this.father = father;
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

    public boolean isFirstGeneration() { return mother == null && father == null; }

}
