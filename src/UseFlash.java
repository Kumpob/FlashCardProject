import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UseFlash implements ActionListener {
    JFrame jf = new JFrame("FlashCard");
    JTextField q= new JTextField();
    JTextField a=new JTextField();
    JLabel qlabel=new JLabel("Question: ");
    JLabel alabel=new JLabel("Answer: ");
    JButton next=new JButton("Next");
    JButton ans=new JButton("I can answer");
    int canScore=0;
    int totScore=0;
    JTextField score=new JTextField("Score: "+canScore);
    JButton exit=new JButton("exit");
    JLabel blank=new JLabel();
    FileWriter fw;
    int no=1;


    UseFlash(){
        jf.setSize(400, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exit.addActionListener(this);
        next.addActionListener(this);
        ans.addActionListener(this);
        GridLayout g1= new GridLayout();
        g1.setColumns(2);
        g1.setRows(4);
        jf.setLayout(g1);
        jf.add(qlabel);
        jf.add(q);
        jf.add(alabel);
        jf.add(a);
        jf.add(score);
        jf.add(ans);
        jf.add(exit);
        jf.add(next);

        jf.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()==next.getActionCommand()){
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader("data.txt"));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            String line;
            int loop=1;
            boolean end=true;
            while(true)
            {
                try {
                    if (!((line = in.readLine()) != null)) break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(loop>=no){
                    if(no%2==1){
                        q.setText(line);
                        a.setText("");
                    }
                    else{
                        a.setText(line);
                    }
                    end=false;
                    totScore=totScore+1;
                    no=no+1;
                    break;
                }
                loop=loop+1;
            }
            try {
                in.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if(end==true){
                JOptionPane.showMessageDialog(null, "Total Score: "+canScore+"/"+totScore/2);
            }
        }
        if(e.getActionCommand()==ans.getActionCommand()){
            canScore=canScore+1;
            score.setText("Score: "+canScore);
        }
        if(e.getActionCommand()==exit.getActionCommand()){
            jf.setVisible(false);
            new mainWin();
        }
    }
}
