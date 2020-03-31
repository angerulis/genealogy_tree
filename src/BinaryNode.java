

public class BinaryNode<T>  {
    private T currentItem = null;
    private int level=-1;
    private BinaryNode<T> leftNode, rightNode, parentNode = null;

    public BinaryNode() {

    }

    public BinaryNode(T myCurrentItem) {
        currentItem = myCurrentItem;
    }
    
    public BinaryNode(T myCurrentItem, int myLevel) {
        currentItem = myCurrentItem;
        level=myLevel;
    }

    public BinaryNode(T myCurrentItem, int myLevel, BinaryNode<T> myParentNode, BinaryNode<T> myLeftNode,
                      BinaryNode<T> myRightNode) {
        currentItem = myCurrentItem;
        level=myLevel;
        parentNode = myParentNode;
        leftNode = myLeftNode;
        rightNode = myRightNode;
    }

    public int getLevel(){
        return level;
    }
    public BinaryNode<T> getParentNode() {
        return parentNode;
    }

    public BinaryNode<T> getLeftNode() {
        return leftNode;
    }

    public BinaryNode<T> getRightNode() {
        return rightNode;
    }

    public T getCurrentItem() {
        return currentItem;
    }

    public void setLevel(int myLevel){
        level=myLevel;
    }
    public void setParentNode(BinaryNode<T> myParentNode) {
        parentNode = myParentNode;
    }

    public void setLeftNode(BinaryNode<T> myLeftNode) {
        leftNode = myLeftNode;
    }

    public void setRightNode(BinaryNode<T> myRightNode) {
        rightNode = myRightNode;
    }

    public void setCurrentItem(T myCurrentItem) {
        currentItem = myCurrentItem;
    }

    public boolean isRoot() {
        if (parentNode == null)
            return true;
        else
            return false;
    }

    public boolean isLeaf() {
        if (leftNode == null && rightNode == null)
            return true;
        else
            return false;
    }
    
    public boolean isLeftNode (){
        boolean result=false;
        if (this.compareTo(this.getParentNode())<0){
            result=true;
        }
        return result;
    }
    
    public boolean isRightNode (){
        boolean result=false;
        if (this.compareTo(this.getParentNode())>0){
            result=true;
        }
        return result;
    }
    
    public int compareTo (BinaryNode compareNode){
        int result=-1;
        if (compareNode.getCurrentItem() instanceof String || compareNode.getCurrentItem() instanceof Integer 
            || compareNode.getCurrentItem() instanceof Double  || compareNode.getCurrentItem() instanceof Float){
            result=(String.valueOf(this.getCurrentItem()).compareTo(String.valueOf(compareNode.getCurrentItem())));
    }
        return result;
    }

}
