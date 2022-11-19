import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class createCardDeck implements ActionListener{
    JFrame jf = new JFrame("CreatePage");
    JTextField name = new JTextField();
    JLabel nameLabel = new JLabel("Deck name: ");
    JButton add=new JButton("Add flashcard");
    JButton back=new JButton("Exit");
    String dbName;

    createCardDeck(){
        jf.setSize(400, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout g1= new GridLayout();
        back.addActionListener(this);
        add.addActionListener(this);
        g1.setColumns(2);
        g1.setRows(2);
        jf.setLayout(g1);
        jf.add(nameLabel);
        jf.add(name);
        jf.add(back);
        jf.add(add);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals(back.getActionCommand())){
            jf.setVisible(false);
        }
        if(e.getActionCommand().equals(add.getActionCommand())){
            this.dbName = name.getText();
            Connection c = null;
            Statement stmt = null;
      
            try {
               c = DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
               stmt = c.createStatement();
               String sql = "CREATE TABLE IF NOT EXISTS " + this.dbName +

                            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +

                            " Question TEXT, " +

                            " Answer TEXT) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            jf.setVisible(false);
            new Create(this.dbName);
            } catch ( Exception err ) {
               System.err.println( err.getClass().getName() + ": " + err.getMessage() );
               System.exit(0);
            }
         }  
    }  

}