import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainWin implements ActionListener {
    JFrame jf = new JFrame("MyWindow");
    JButton c= new JButton("Add vocab");
    JButton r= new JButton("Remove vocab");
    JButton u=new JButton("Start");
    mainWin(){
        jf.setSize(500, 100);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.addActionListener(this);
        r.addActionListener(this);
        u.addActionListener(this);
        GridLayout g1= new GridLayout();
        g1.setColumns(3);
        g1.setRows(1);
        jf.setLayout(g1);
        jf.add(u);
        jf.add(c);
        jf.add(r);
        jf.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()==c.getActionCommand()){
            jf.setVisible(false);
            new Create();
        }
        if(e.getActionCommand()==u.getActionCommand()){
            jf.setVisible(false);
            new UseFlash();
        }
        if(e.getActionCommand()==r.getActionCommand()){
            jf.setVisible(false);
            new Remove();
        }
    }
}
