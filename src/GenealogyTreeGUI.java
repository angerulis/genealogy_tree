import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*

Graphic User interface of Genealogic Tree
 */
public class GenealogyTreeGUI extends JPanel {
    JFrame frame = new JFrame("Genealogy Tree");
    Graphics2D g2;

    public GenealogyTreeGUI(){
        //Using bufferedImage to create a new Graphics object without overriding methods
        BufferedImage treeImage = new BufferedImage(800, 900, BufferedImage.TYPE_4BYTE_ABGR);
        g2 = treeImage.createGraphics();
        g2.setPaint(Color.BLUE);
        Icon myIcon = new ImageIcon(treeImage);
        JLabel label = new JLabel();
        label.setIcon(myIcon);
        add(label);
    }

    //Show the window after drawing
    public void displayTree(){
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Draw schema that link to person
    public void drawTwoLink(int x, int y, Person p1, Person p2){
        System.out.println("----------------------DrawTwoTree---------------------------------");
        this.g2.drawString(p1.getFirstName() + " " + p1.getLastName(), x -1, y + 30);
        this.g2.drawOval(x, y, 70 , 50 );
        this.g2.drawLine(x+25 , y+50 ,x + 25,y + 57  );
        this.g2.drawLine(x + 25,y + 57 ,x + 125,y + 57  );
        this.g2.drawLine(x + 75,y + 57 ,x + 75,y + 67   );
        this.g2.drawLine(x + 125,y + 57  ,x + 125 ,y + 50  );
        this.g2.drawString(p2.getFirstName() + " " + p2.getLastName(), x + 99 , y+25);
        this.g2.drawOval(x + 100, y , 70 , 50 );
    }

    //Draw a cercle with name for single person
    public void drawPerson(int x, int y, Person p1){
        System.out.println("----------------------DrawPerson---------------------------------");
        this.g2.drawString(p1.getFirstName() + " " + p1.getLastName(), x -1, y +30);
        this.g2.drawOval(x, y, 70 , 50 );
    }

    //Draw the entire tree from root
    //Parameter determine the position of the drawing in the window
    public void drawTree(Node<Person> rootNode, int x , int y){
        /*
        This method go from the root to all descendant node through a recursive Call
         */

            if(rootNode.getSpouse() != null){ //Find couples
                this.g2.setPaint(Color.red);
                drawTwoLink(x, y, rootNode.getIndividual(), rootNode.getSpouse().getIndividual());
                this.g2.setPaint(Color.BLUE);
                x = x + 1;
                y = y + 75;
            }else{
                this.g2.setPaint(Color.BLACK); //Single person
                drawPerson(x, y, rootNode.getIndividual());
                this.g2.setPaint(Color.BLUE);
                x = x - 25;
            }
            if(rootNode.getOffspring() != null){ //Recursive
                for(Node<Person> childNode: rootNode.getOffspring()){
                    drawTree(childNode, x+50, y);
                    x = x - 200;

                }
            }
        displayTree();
    }
}
