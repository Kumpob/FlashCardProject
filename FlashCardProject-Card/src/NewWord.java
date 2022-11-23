import javax.swing.*;
import java.sql.*;

public class NewWord extends JFrame {
    String tableName;

    public NewWord(String tableName) {
        initComponents(tableName);
    }


    private void initComponents(String Name) {
        this.tableName = Name;
        qLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        q = new JTextArea();
        aLabel = new JLabel();
        jScrollPane2 = new JScrollPane();
        a = new JTextArea();
        back = new JButton();
        add = new JButton();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Word");

        qLabel.setText("Question");

        q.setColumns(20);
        q.setRows(5);
        jScrollPane1.setViewportView(q);

        aLabel.setText("Answer");

        a.setColumns(20);
        a.setRows(5);
        jScrollPane2.setViewportView(a);

        back.setText("Exit");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        add.setText("Add Word");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back))
                    .addComponent(aLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING)
                    .addComponent(qLabel, GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(add))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            Connection c = null;
      
            try {
               c = DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
               PreparedStatement stmt = c.prepareStatement("INSERT INTO " + this.tableName + " (Question, Answer) VALUES (?,?)");
               stmt.setString(1, q.getText());
               stmt.setString(2, a.getText());
               stmt.executeUpdate();
               c.close();
            } catch ( Exception err ) {
               System.err.println( err.getClass().getName() + ": " + err.getMessage() );
               System.exit(0);
            }
            q.setText("");
            a.setText("");
            JOptionPane.showMessageDialog(null,"Flashcard added Successfully!");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e+"");
        }
        
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        dispose();
    }

    private JTextArea a;
    private JLabel aLabel;
    private JButton add;
    private JButton back;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea q;
    private JLabel qLabel;
    // End of variables declaration//GEN-END:variables
}
