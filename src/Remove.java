import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Remove implements ActionListener {
    JFrame jf = new JFrame("Remove Word");
    JLabel text= new JLabel("<html>Enter the question to be remove:<br/>(Not the answer))</html>");
    JTextField q= new JTextField();
    JButton rem= new JButton("Remove");
    JButton back=new JButton("Exit");
    FileWriter fw;
    String word =null;

    Remove(){
        jf.setSize(400, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout g1= new GridLayout();
        g1.setColumns(2);
        g1.setRows(2);
        jf.setLayout(g1);
        back.addActionListener(this);
        rem.addActionListener(this);
        jf.add(text);
        jf.add(q);
        jf.add(back);
        jf.add(rem);

        jf.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()==rem.getActionCommand()){
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader("data.txt"));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            String line;
            boolean def=false;
            while(true)
            {
                try {
                    if (!((line = in.readLine()) != null)) break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(!(line.equals(q.getText()))){
                    if(def==false){
                        word=(word==null?"":word)+line+"\n";
                        System.out.println(word);
                    }
                    else{
                        def=false;

                    }                }
                else{
                    def=true;
                }
            }
            try {
                in.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fw= new FileWriter("data.txt");
                fw.write(word);
                fw.close();
                JOptionPane.showMessageDialog(null,"Flashcard added Successfully!");
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex+"");
            }
        }
        if(e.getActionCommand()==back.getActionCommand()){
            jf.setVisible(false);
            new mainWin();
        }
    }
}
