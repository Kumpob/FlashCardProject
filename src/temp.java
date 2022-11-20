import javax.swing.*;
import java.io.FileWriter;

public class temp {
    JFrame jf = new JFrame();
    int canScore=0;
    int totScore=0;
    FileWriter fw;
    int no=1;
    String word =null;
    JTextField q= new JTextField();
    JTextField a=new JTextField();
    JLabel qlabel=new JLabel("Question: ");
    JLabel alabel=new JLabel("Answer: ");
    JButton add=new JButton("Add flashcard");
    JButton back=new JButton("Exit");
    JLabel blank=new JLabel();
    JLabel text= new JLabel("<html>Enter the question to be remove:<br/>(Not the answer)</html>");
    JButton rem= new JButton("Remove");
    JButton next=new JButton("Next");
    JButton ans=new JButton("I can answer");
    JTextField score=new JTextField("Score: "+canScore);

    public void goBack(){
        jf.setVisible(false);
        new mainWin();
    }
}
