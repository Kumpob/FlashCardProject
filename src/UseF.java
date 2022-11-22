
import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class UseF extends JFrame {

    public UseF(String name) {
        initComponents(name);
    }
    int canScore=0;
    int totScore=0;
    Connection c = null;
    HashMap<String, String> qa = new HashMap<String, String>();
    ArrayList<String> keys;
    String tableName;
    int no=1;
    int loop = 1;

    private void initComponents(String Name) {
        this.tableName = Name;
        qLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        q = new JTextArea();
        q.setFont(q.getFont().deriveFont(15f));
        aLabel = new JLabel();
        jScrollPane2 = new JScrollPane();
        a = new JTextArea();
        a.setFont(a.getFont().deriveFont(15f));
        next = new JButton();
        sLabel = new JLabel();
        score = new JTextField();
        score.setFont(score.getFont().deriveFont(15f));
        ans = new JButton();
        back = new JButton();
        getFlashquestion();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("FlashCard");

        qLabel.setText("Question");

        q.setColumns(20);
        q.setRows(5);
        jScrollPane1.setViewportView(q);

        aLabel.setText("Answer");

        a.setColumns(20);
        a.setRows(5);
        jScrollPane2.setViewportView(a);

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        sLabel.setText("Score:");

        score.setText("0000000");
        score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreActionPerformed(evt);
            }
        });

        ans.setText("I can answer");
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });

        back.setText("Exit");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(qLabel)
                    .addComponent(aLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ans, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(score, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(back))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(qLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sLabel)
                        .addComponent(score, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(ans, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        dispose();
    }

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed

        canScore=canScore+1;
        score.setText(String.valueOf(canScore));
    }

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        
        if(!keys.isEmpty()){
            if (loop % 2 == 1){
            System.out.println(keys);
            q.setText(keys.get(0));
            a.setText("");
        }else{
            a.setText(qa.get(keys.get(0)));   
            keys.remove(0);
        }
        loop = loop + 1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Total Score: "+canScore+"/"+totScore);
        }
    }

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    void getFlashquestion(){
        try {
            c = DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
            PreparedStatement stmt = c.prepareStatement("SELECT Question, Answer FROM " + this.tableName);
            ResultSet got = stmt.executeQuery();
            while (got.next()) {
                qa.put(got.getString(1), got.getString(2));
            }
            c.close();
            keys = new ArrayList<>(qa.keySet());
            Collections.shuffle(keys);
            totScore = keys.size();
        } catch (Exception err) {
            System.err.println(err.getClass().getName() + ": " + err.getMessage());
            System.exit(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextArea a;
    private JLabel aLabel;
    private JButton ans;
    private JButton back;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JButton next;
    private JTextArea q;
    private JLabel qLabel;
    private JLabel sLabel;
    private JTextField score;
    // End of variables declaration//GEN-END:variables
}
