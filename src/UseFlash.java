import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UseFlash extends temp implements ActionListener {
    UseFlash(){
        jf.setTitle("FlashCard");
        jf.setSize(400, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(this);
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
        jf.add(back);
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
        if(e.getActionCommand()== back.getActionCommand()){
            goBack();
        }
    }
}
