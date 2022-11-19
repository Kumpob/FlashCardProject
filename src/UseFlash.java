import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class UseFlash implements ActionListener {
    Connection c = null;
    HashMap<String, String> qa = new HashMap<String, String>();
    ArrayList<String> keys;
    

    int canScore = 0, loop = 0,totalScore;

    JFrame jf = new JFrame("FlashCard");
    JTextField q = new JTextField();
    JTextField a = new JTextField();
    JLabel qlabel = new JLabel("Question: ");
    JLabel alabel = new JLabel("Answer: ");
    JButton next = new JButton("Next");
    JButton ans = new JButton("I can answer");
    JTextField score = new JTextField("Score: " + canScore);
    JButton exit = new JButton("exit");
    JLabel blank = new JLabel();

    UseFlash() {
        jf.setSize(400, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exit.addActionListener(this);
        next.addActionListener(this);
        ans.addActionListener(this);
        GridLayout g1 = new GridLayout();
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

        try {
            c = DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
            PreparedStatement stmt = c.prepareStatement("SELECT Question, Answer FROM Linear");
            ResultSet got = stmt.executeQuery();
            while (got.next()) {
                qa.put(got.getString(1), got.getString(2));
            }
            c.close();

        } catch (Exception err) {
            System.err.println(err.getClass().getName() + ": " + err.getMessage());
            System.exit(0);
        }
        keys = new ArrayList<>(qa.keySet());
        Collections.shuffle(keys);
        totalScore = keys.size();
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == next.getActionCommand()) {
            if (loop % 2 == 0){
                q.setText(keys.get(0));
                a.setText("");
            }else{
                a.setText(qa.get(keys.get(0)));   
                keys.remove(0);
            }
            loop++;
            
            if(keys.isEmpty()){
                JOptionPane.showMessageDialog(null, "Total Score: "+canScore+"/"+totalScore);
            }
        }
        if (e.getActionCommand() == ans.getActionCommand()) {
            canScore = canScore + 1;
            score.setText("Score: " + canScore);
            if (loop % 2 == 0){
                q.setText(keys.get(0));
                a.setText("");
            }else{
                a.setText(qa.get(keys.get(0)));   
                keys.remove(0);
            }
            loop++;
            
            if(keys.isEmpty()){
                JOptionPane.showMessageDialog(null, "Total Score: "+canScore+"/"+totalScore);
            }
        }
        if (e.getActionCommand() == exit.getActionCommand()) {
            jf.setVisible(false);
            new mainWin();
            try {
                c.close();
            } catch (SQLException err) {
                System.out.println(err);
            }
        }
    }
}
