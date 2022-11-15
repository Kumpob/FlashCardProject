import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Create implements ActionListener{
        JFrame jf = new JFrame("CreatePage");
        JTextField q= new JTextField();
        JTextField a=new JTextField();
        JLabel qlabel=new JLabel("Question: ");
        JLabel alabel=new JLabel("Answer: ");
        JButton add=new JButton("Add flashcard");
        JButton back=new JButton("Exit");
        JLabel blank=new JLabel();
        FileWriter fw;


        Create(){
            jf.setSize(400, 300);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GridLayout g1= new GridLayout();
            g1.setColumns(2);
            g1.setRows(3);
            jf.setLayout(g1);
            add.addActionListener(this);
            back.addActionListener(this);
            jf.add(qlabel);
            jf.add(q);
            jf.add(alabel);
            jf.add(a);
            jf.add(back);
            jf.add(add);

            jf.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand()==add.getActionCommand()){
                try {
                    fw= new FileWriter("data.txt",true);
                    fw.write(q.getText()+"\n");
                    fw.write(a.getText()+"\n");
                    fw.close();
                    JOptionPane.showMessageDialog(null,"Flashcard added Successfully!");
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, e+"");
                }
            }
            if(ae.getActionCommand()==back.getActionCommand()){
                jf.setVisible(false);
                new mainWin();
            }
        }
}
