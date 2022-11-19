import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class mainWin implements ActionListener {
    JFrame jm = new JFrame("MyWindow");
    JButton c= new JButton("Add vocab");
    JButton u=new JButton("Start");
    Connection ce;
    ArrayList <String> flashcardList = new ArrayList<String>();
    JPanel panel = new JPanel();
    

    mainWin(){
        
        for (int i = 0; i < 10; i++) {
            panel.add(new JButton(""+i));
        }
    
        JScrollPane scrollPane = new JScrollPane(panel);
        jm.getContentPane().setLayout(new BorderLayout());
        jm.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        jm.pack();
        jm.setVisible(true);
    }

    // void getTable(){
    //     try {
    //         ce= DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
    //         PreparedStatement stmt = ce.prepareStatement("SELECT Question, Answer FROM Linear");
    //         ResultSet got = stmt.executeQuery();
           
    //     } catch (Exception err) {
    //         System.err.println(err.getClass().getName() + ": " + err.getMessage());
    //         System.exit(0);
    //     }
    // }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()==c.getActionCommand()){
            jm.setVisible(false);
        }
        if(e.getActionCommand()==u.getActionCommand()){
            jm.setVisible(false);
            new UseFlash();
        }
    }
}
