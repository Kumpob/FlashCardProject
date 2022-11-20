import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Create extends temp implements ActionListener {

        Create(){
            jf.setTitle("Create Card");
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
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand()==add.getActionCommand()){
                try {
                    fw= new FileWriter("data.txt",true);
                    fw.write(q.getText()+"\n");
                    fw.write(a.getText()+"\n");
                    fw.close();
                    JOptionPane.showMessageDialog(null,"Flashcard added Successfully!");
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex+"");
                }
            }
            if(e.getActionCommand()==back.getActionCommand()){
                goBack();
            }
        }
}
