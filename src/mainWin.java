import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainWin implements ActionListener {
    JFrame jm = new JFrame("MyWindow");
    JButton c= new JButton("Add vocab");
    JButton u=new JButton("Start");
    mainWin(){
        jm.setSize(500, 100);
        jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.addActionListener(this);
        u.addActionListener(this);
        GridLayout g1= new GridLayout();
        g1.setColumns(2);
        g1.setRows(1);
        jm.setLayout(g1);
        jm.add(u);
        jm.add(c);
        jm.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()==c.getActionCommand()){
            jm.setVisible(false);
            new Create();
        }
        if(e.getActionCommand()==u.getActionCommand()){
            jm.setVisible(false);
            new UseFlash();
        }
    }
}
