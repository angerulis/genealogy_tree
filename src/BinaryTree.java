import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {
    private BinaryNode rootNode = null;
    private BinaryTree leftTree = null, rightTree = null;
    private static int height = -1;

    public BinaryTree() {
    }

    public BinaryTree(BinaryNode myRootNode) {
        rootNode = myRootNode;
    }

    public BinaryTree(BinaryNode myRootNode, BinaryTree myLeftTree, BinaryTree myRightTree) {
        rootNode = myRootNode;
        leftTree = myLeftTree;
        rightTree = myRightTree;
    }


    public static BinaryTree createBinaryTree() {
        return new BinaryTree();
    }

    public static BinaryTree createBinaryTree(BinaryNode myRootNode) {
        return new BinaryTree(myRootNode);
    }

    public BinaryNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryNode myRootNode) {
        rootNode = myRootNode;
    }

    public BinaryTree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(BinaryTree myLeftTree) {
        leftTree = myLeftTree;
    }

    public BinaryTree getRightTree() {
        return rightTree;
    }

    public void setRightTree(BinaryTree myRightTree) {
        rightTree = myRightTree;
    }

    public boolean isRootTree() {
        if (rootNode != null && rootNode.getParentNode() == null)
            return true;
        else
            return false;
    }

    public boolean isLeftTree() {
        boolean result = false;
        if (rootNode.getParentNode() != null) {
            if (rootNode.compareTo(rootNode.getParentNode()) < 0) {
                result = true;
            }
        }
        return result;
    }

    public boolean isRightTree() {
        boolean result = false;
        if (rootNode.getParentNode() != null) {
            if (rootNode.compareTo(rootNode.getParentNode()) > 0) {
                result = true;
            }
        }
        return result;
    }

    public BinaryTree findParentTree(BinaryTree rootTree, BinaryTree curTree) {
        BinaryTree parentTree = null;
        if (rootTree != null) {
            if (rootTree.getRootNode().compareTo(curTree.getRootNode().getParentNode()) == 0)
                parentTree = rootTree;
            else {
                if (rootTree.getRootNode().compareTo(curTree.getRootNode().getParentNode()) > 0)
                    rootTree = rootTree.getRightTree();
                else
                    rootTree = rootTree.getLeftTree();
                parentTree = findParentTree(rootTree, curTree);
            }
        }
        return parentTree;
    }

    public void detachLeftTree(BinaryTree myCurTree, int count) {
        BinaryTree curLeftTree = myCurTree;
        if (myCurTree != null && count == 0)
            curLeftTree = myCurTree.getLeftTree();
        if (curLeftTree != null) {
            count++;
            detachLeftTree(curLeftTree.getLeftTree(), count);
            detachLeftTree(curLeftTree.getRightTree(), count);
        }
        System.out.println(curLeftTree.getLeftTree().getRootNode().getCurrentItem());
        curLeftTree = null;
    }

    public void detachRightTree(BinaryTree myCurTree, int count) {
        BinaryTree curRightTree = myCurTree;
        if (myCurTree != null && count == 0)
            curRightTree = myCurTree.getRightTree();
        if (curRightTree != null) {
            count++;
            detachRightTree(curRightTree.getLeftTree(), count);
            detachRightTree(curRightTree.getRightTree(), count);
        }
        curRightTree = null;
    }


    public static int getHeight() {
        return height;
    }

    public void attachLeftTree(BinaryTree newTree) {
        if (leftTree == null) {
            setLeftTree(newTree);
            newTree.getRootNode().setParentNode(rootNode);
            newTree.getRootNode().setLevel(rootNode.getLevel() + 1);
        } else {
            BinaryTree oldLeftTree = leftTree;
            setLeftTree(newTree);
            newTree.getRootNode().setParentNode(rootNode);
            newTree.getRootNode().setLevel(rootNode.getLevel() + 1);
            if (oldLeftTree != null) {
                oldLeftTree.getRootNode().setParentNode(newTree.getRootNode());
                newTree.insertChildTree(oldLeftTree);
                increaseAllSubTreesLevels(oldLeftTree, oldLeftTree.getRootNode().getLevel());
            }
        }
    }

    public void attachRightTree(BinaryTree newTree) {
        if (rightTree == null) {
            setRightTree(newTree);
            newTree.getRootNode().setParentNode(rootNode);
            newTree.getRootNode().setLevel(rootNode.getLevel() + 1);
        } else {
            BinaryTree oldRightTree = rightTree;
            setRightTree(newTree);
            newTree.getRootNode().setParentNode(rootNode);
            newTree.getRootNode().setLevel(rootNode.getLevel() + 1);
            if (oldRightTree != null) {
                oldRightTree.getRootNode().setParentNode(newTree.getRootNode());
                newTree.insertChildTree(oldRightTree);
                increaseAllSubTreesLevels(oldRightTree, oldRightTree.getRootNode().getLevel());
            }
        }
    }

    public void increaseAllSubTreesLevels(BinaryTree initTree, int level) {
        BinaryTree curTree = initTree;
        if (curTree != null) {
            int curLevel = level + 1;
            curTree.getRootNode().setLevel(curLevel);
            increaseAllSubTreesLevels(curTree.getLeftTree(), curLevel);
            increaseAllSubTreesLevels(curTree.getRightTree(), curLevel);
        }
    }

    //In case currentNode value is greater than left node value and lower than right node value
    public void insertChildTree(BinaryTree newTree) {
        if (rootNode.compareTo(newTree.getRootNode()) > 0) {
            setLeftTree(newTree);
        } else if (rootNode.compareTo(newTree.getRootNode()) < 0) {
            setRightTree(newTree);
        }
    }

    public ArrayList<BinaryTree> getAllTreesAtLevel(BinaryTree curTree, int level) {
        ArrayList<BinaryTree> list = new ArrayList<BinaryTree>();
        if (level == 1 && curTree.getRootNode().getLevel() == 1) {
            list.add(curTree);
            return list;
        } else if (level > 1 && curTree.getRootNode().getLevel() <= level) {
            BinaryTree curLeftTree = curTree.getLeftTree();
            BinaryTree curRightTree = curTree.getRightTree();
            if (curLeftTree.getRootNode().getLevel() != level) {
                return getAllTreesAtLevel(curLeftTree, level);
            } else {
                list.add(curLeftTree);
            }
            if (curRightTree.getRootNode().getLevel() != level) {
                return getAllTreesAtLevel(curRightTree, level);
            } else {
                list.add(curRightTree);
            }
        }
        return list;
    }

    public static boolean isSubTree(BinaryTree myCurTree, BinaryTree subTree) {
        boolean result = false;
        BinaryTree curTree = myCurTree;
        if (curTree == subTree) {
            result = true;
        } else if (curTree.getLeftTree() != null)
            return isSubTree(curTree.getLeftTree(), subTree); // Left
        else if (curTree.getRightTree() != null)
            return isSubTree(curTree.getRightTree(), subTree); // Right

        return result;
    }

    public int calculateHeight(ArrayList<BinaryNode> origArr) {
        int max = -1;
        int i = 0;
        if (origArr.size() > 0) {
            max = origArr.get(i).getLevel();
            // origArr.get(i).getLevel()
            for (i = 1; i < origArr.size(); i++) {
                if (max < origArr.get(i).getLevel()) {
                    max = origArr.get(i).getLevel();
                }
            }
        }
        height = max;
        return max;
    }

    public static int calculateHeight(BinaryTree myCurTree, int myHeight) {
        int maxLevel = myHeight;
        BinaryTree curTree = myCurTree;
        if (curTree.getRootNode().getLevel() > maxLevel) {
            maxLevel = curTree.getRootNode().getLevel();
        }
        if (curTree.getLeftTree() != null)
            return calculateHeight(curTree.getLeftTree(), maxLevel); // Left
        if (curTree.getRightTree() != null)
            return calculateHeight(curTree.getRightTree(), maxLevel); // Right
        return maxLevel;
    }

    public void makeEmpty() {
        if (rootNode.getLevel() == 1) {
            detachLeftTree(this, 0);
            detachRightTree(this, 0);
            rootNode = null;
        }
    }

    public boolean isEmpty() {
        return (rootNode == null && height < 1);
    }

    public int splitList(ArrayList<BinaryTree> origArr, ArrayList<BinaryTree> firstSplit,
                         ArrayList<BinaryTree> secondSplit) {
        int middle = 0;
        if (origArr != null) {
            if (origArr.size() % 2 == 0)
                middle = (origArr.size()) / 2 - 1;
            else
                middle = (origArr.size() + 1) / 2 - 1;
            for (int i = 0; i < middle; i++) {
                firstSplit.add(origArr.get(i));
            }
            for (int j = middle + 1; j < origArr.size(); j++) {
                secondSplit.add(origArr.get(j));
            }
        }
        System.out.println(origArr.get(middle));
        return middle;
    }

    //Ordered nodes in array, split and added in a binaryTree using binary search method
    public void buildBinaryTree(ArrayList<BinaryTree> origTreeArr, BinaryTree parentTree, int counter) {
        BinaryTree current = null;
        int middle = -1;
        if (origTreeArr.size() > 1) {
            ArrayList<BinaryTree> leftTreeArr = new ArrayList<BinaryTree>();
            ArrayList<BinaryTree> rightTreeArr = new ArrayList<BinaryTree>();
            middle = splitList(origTreeArr, leftTreeArr, rightTreeArr);
            counter++;
            current = origTreeArr.get(middle);
            current.getRootNode().setLevel(counter);
            if (current.getRootNode().getLevel() == 1) {
                setRootNode(current.getRootNode());
                current.getRootNode().setParentNode(null);
            }else
                current.getRootNode().setParentNode(parentTree.getRootNode());
            if (parentTree != null) {
                parentTree.insertChildTree(current);
            }
            buildBinaryTree(leftTreeArr, current, counter);
            buildBinaryTree(rightTreeArr, current, counter);
        }
        if (origTreeArr.size() == 1) {
            current = origTreeArr.get(0);
            counter++;
            current.getRootNode().setLevel(counter);
            current.getRootNode().setParentNode(parentTree.getRootNode());
            parentTree.insertChildTree(current);
        }
    }


    public void buildIntegerBinaryTree(int maxLevel) {
        System.out.println("Please enter the root node item");
        Scanner scan = new Scanner(System.in);
        int item = scan.nextInt();
        BinaryNode rootNode = new BinaryNode(item);
        rootNode.setLevel(1);
        rootNode.setParentNode(null);
        setRootNode(rootNode);
        BinaryTree curTree = this;
        if (maxLevel > 1) {
            BinaryNode curNode = rootNode;
            for (int i = 1; i <= maxLevel; i++) {
                ArrayList<BinaryTree> currentTrees = getAllTreesAtLevel(this, i);
                BinaryTree newTree = null;
                BinaryNode newNode = null;
                String answer = "";
                for (int j = 0; j < currentTrees.size(); j++) {
                    curNode = currentTrees.get(j).getRootNode();
                    System.out.println("Select current node item " + curNode.getCurrentItem() + "children types");
                    System.out.println("(L) Left child only");
                    System.out.println("(R) Right child only");
                    System.out.println("(T) Two children Left and Right");
                    answer = scan.nextLine();
                    switch (answer) {
                    case "L":
                        System.out.println("Please enter the left node item");
                        item = scan.nextInt();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        //                       curNode.setLeftNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setLeftTree(newTree);
                        break;

                    case "R":
                        System.out.println("Please enter the right node item");
                        item = scan.nextInt();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        curNode.setRightNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setRightTree(newTree);
                        break;

                    case "T":
                        System.out.println("Please enter the left node item");
                        item = scan.nextInt();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        //               curNode.setLeftNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setLeftTree(newTree);

                        System.out.println("Please enter the right node item");
                        item = scan.nextInt();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        curNode.setRightNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setRightTree(newTree);
                        break;
                    }
                }
            }
        }
    }


    public void buildStringBinaryTree(int maxLevel) {
        System.out.println("Please enter the root node item");
        Scanner scan = new Scanner(System.in);
        String item = scan.nextLine();
        BinaryNode rootNode = new BinaryNode(item);
        rootNode.setParentNode(null);
        rootNode.setLevel(1);
        setRootNode(rootNode);
        BinaryTree curTree = this;
        if (maxLevel > 1) {
            BinaryNode curNode = rootNode;
            for (int i = 1; i < maxLevel; i++) {
                ArrayList<BinaryTree> currentTrees = getAllTreesAtLevel(this, i);
                BinaryTree newTree = null;
                BinaryNode newNode = null;
                String answer = "";
                for (int j = 0; j < currentTrees.size(); j++) {
                    curTree = currentTrees.get(j);
                    curNode = currentTrees.get(j).getRootNode();
                    System.out.println("Select current node item " + curNode.getCurrentItem() + " children types");
                    System.out.println("(L) Left child only");
                    System.out.println("(R) Right child only");
                    System.out.println("(T) Two children Left and Right");
                    answer = scan.nextLine();
                    switch (answer) {
                    case "L":
                        System.out.println("Please enter the left node item");
                        item = scan.nextLine();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        //            curNode.setLeftNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setLeftTree(newTree);
                        break;

                    case "R":
                        System.out.println("Please enter the right node item");
                        item = scan.nextLine();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        curNode.setRightNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setRightTree(newTree);
                        break;

                    case "T":
                        System.out.println("Please enter the left node item");
                        item = scan.nextLine();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        curNode.setLeftNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setLeftTree(newTree);

                        System.out.println("Please enter the right node item");
                        item = scan.nextLine();
                        newNode = new BinaryNode(item);
                        newNode.setLevel(curNode.getLevel() + 1);
                        newNode.setParentNode(curNode);
                        curNode.setRightNode(newNode);
                        newTree = new BinaryTree();
                        newTree.setRootNode(newNode);
                        curTree.setRightTree(newTree);
                        break;

                    }

                }
            }
        }
    }


    public Object deleteMin(BinaryTree myCurTree) {
        BinaryTree curTree = myCurTree;
        Object currentItem = curTree.getRootNode().getCurrentItem();
        if (curTree.getLeftTree() == null) {
            //curTree.getRootNode().getParentNode().setLeftNode(curTree.getRootNode().getRightNode());
            BinaryTree parentTree = findParentTree(this, myCurTree);
            parentTree.setLeftTree(parentTree.getRightTree());
            if (curTree.getRootNode().getRightNode() != null)
                curTree.getRightTree().getRootNode().setParentNode(curTree.getRootNode().getParentNode());
            //          curTree = curTree.getRightTree();
        } else {
            curTree = curTree.getLeftTree();
            return deleteMin(curTree);
        }
        return currentItem;
    }

    public void printAllLeafNodes(BinaryNode myCurNode) {
        BinaryNode curNode = myCurNode;
        if (curNode.isLeaf()) {
            System.out.println("Leaf node value =" + curNode.getCurrentItem());
        } else {
            printAllLeafNodes(curNode.getLeftNode());
            printAllLeafNodes(curNode.getRightNode());
        }

    }

    // Print tree rooted at current node using preorder traversal.
    public void printPreOrder(BinaryNode curNode) {
        System.out.println("Current node =" + curNode.getCurrentItem() + " level =" + curNode.getLevel()); // Node
        if (curNode.getLeftNode() != null)
            printPreOrder(curNode.getLeftNode()); // Left
        if (curNode.getRightNode() != null)
            printPreOrder(curNode.getRightNode()); // Right
    }


    // Print tree rooted at current node using postorder traversal.
    public void printPostOrder(BinaryNode curNode) {
        if (curNode.getLeftNode() != null)
            printPostOrder(curNode.getLeftNode()); // Left
        if (curNode.getRightNode() != null)
            printPostOrder(curNode.getRightNode()); // Right
        System.out.println("Current node =" + curNode.getCurrentItem() + " level =" + curNode.getLevel()); // Node
    }

    // Print tree rooted at current node using inorder traversal.
    public void printInOrder(BinaryNode curNode) {
        if (curNode.getLeftNode() != null)
            printInOrder(curNode.getLeftNode()); // Left
        System.out.println("Current node =" + curNode.getCurrentItem() + " level =" + curNode.getLevel()); // Node
        if (curNode.getRightNode() != null)
            printInOrder(curNode.getRightNode()); // Right
    }

    public static void main(String[] args) {
        BinaryTree curTree = createBinaryTree();
        curTree.buildStringBinaryTree(3);


        System.out.println(curTree.getRootNode());
        int treeHeight = calculateHeight(curTree, 0);
        System.out.println();
        System.out.println("Binary Tree Height = " + treeHeight);
        System.out.println();
        curTree.printAllLeafNodes(curTree.getRootNode());
        System.out.println();
        System.out.println("Root node value = " + curTree.getRootNode().getCurrentItem());
        System.out.println();
        System.out.println("Print all node values using pre-order method...");
        curTree.printPreOrder(curTree.getRootNode());
        System.out.println();
        System.out.println("Print all node values using in-order method...");
        curTree.printInOrder(curTree.getRootNode());
        System.out.println();
        System.out.println("Print all node values using post-order method...");
        curTree.printPostOrder(curTree.getRootNode());
        System.out.println();
        System.out.println(curTree.deleteMin(curTree));
        System.out.println();
        System.out.println("Print all node values after min node value deletion...");
        curTree.printInOrder(curTree.getRootNode());
    }
}
