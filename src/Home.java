import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class Home extends javax.swing.JFrame {
    ArrayList <String> flashcardList = new ArrayList<String>();
    ImageIcon imageIcon;
    Color color=new Color(72,31,1);

    public Home() {
        initComponents();
    }

    private void initComponents() {
        imageIcon = new ImageIcon("./src/others/flashPic.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); 
        Image newimg = image.getScaledInstance(220, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        getTable();
        
        imageIcon = new ImageIcon(newimg); 
        jLabel1 = new javax.swing.JLabel();
        addWord = new javax.swing.JButton();
        start = new javax.swing.JButton();
        remov = new javax.swing.JButton();
        viewList = new javax.swing.JButton();
        creator = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addDeck = new javax.swing.JButton();

        setTitle("Main Page");

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        jLabel1.setText("FlashCard");

        addWord.setText("Add Word");
        addWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWordActionPerformed(evt);
            }
        });

        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        remov.setText("Remove");
        remov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removActionPerformed(evt);
            }
        });

        viewList.setText("View List");
        viewList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewListActionPerformed(evt);
            }
        });

        creator.setText("Made By:");

        jLabel2.setText("Kumpob Yuwapreecha 64011451 ");

        jLabel3.setText("Wipat Thongchew 64011702");

        jLabel4.setText("Opaspong Bunnag 64011497");

        addDeck.setText("Add Deck");
        addDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewList, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creator, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addDeck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addWord, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                            .addComponent(remov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(start)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(viewList)
                                    .addComponent(addDeck)))
                            .addComponent(addWord))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remov))
                    .addComponent(creator))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void addWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWordActionPerformed
        ArrayList<JButton> buttonWithAddFunc = new ArrayList<>(); 
        for(int i = 0;i < flashcardList.size();i++){
            buttonWithAddFunc.add(createButtonwithFuncAdd(flashcardList.get(i)));
        }
        
        new selectionPanel(buttonWithAddFunc);
    }

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        ArrayList<JButton> buttonWithUseFunc = new ArrayList<>(); 
        for(int i = 0;i < flashcardList.size();i++){
            buttonWithUseFunc.add(createButtonwithFuncUse(flashcardList.get(i)));
        }
        new selectionPanel(buttonWithUseFunc);
    }

    private void removActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removActionPerformed
        ArrayList<JButton> buttonWithRemoveFunc = new ArrayList<>(); 
        for(int i = 0;i < flashcardList.size();i++){
            buttonWithRemoveFunc.add(createButtonwithFuncDelete(flashcardList.get(i)));
        }

        new selectionPanel(buttonWithRemoveFunc);
    }

    private void viewListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewListActionPerformed
        ArrayList<JButton> buttonWithListFunc = new ArrayList<>(); 
        for(int i = 0;i < flashcardList.size();i++){
            buttonWithListFunc.add(createButtonwithFuncList(flashcardList.get(i)));
        }
        new selectionPanel(buttonWithListFunc);
    }

    private void addDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeckActionPerformed
        new Create_Deck().setVisible(true);
    }
    

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    JButton createButtonwithFuncUse(String name){
        JButton but = new JButton(name);
        but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new UseF(name);
            }
        });
        but.setFont(new Font("Bradley Hand ITC", Font.BOLD, 36));
        but.setForeground(color);
        but.setPreferredSize(new Dimension(100, 100));
        but.setIcon(imageIcon);
        but.setHorizontalTextPosition(JButton.CENTER);
        but.setVerticalTextPosition(JButton.CENTER);

        return but;
    }

    JButton createButtonwithFuncAdd(String name){
        JButton but = new JButton(name);
        but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new NewWord(name).setVisible(true);
            }
        });
        but.setFont(new Font("Bradley Hand ITC", Font.BOLD, 36));
        but.setForeground(color);
        but.setPreferredSize(new Dimension(100, 100));
        but.setIcon(imageIcon);
        but.setHorizontalTextPosition(JButton.CENTER);
        but.setVerticalTextPosition(JButton.CENTER);

        return but;
    }

    JButton createButtonwithFuncList(String name){
        JButton but = new JButton(name);
        but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new List(name).setVisible(true);
            }
        });
        but.setFont(new Font("Bradley Hand ITC", Font.BOLD, 36));
        but.setForeground(color);
        but.setPreferredSize(new Dimension(100, 100));
        but.setIcon(imageIcon);
        but.setHorizontalTextPosition(JButton.CENTER);
        but.setVerticalTextPosition(JButton.CENTER);

        return but;
    }

    JButton createButtonwithFuncDelete(String name){
        JButton but = new JButton(name);
        but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Remov1(name).setVisible(true);
            }
        });
        but.setFont(new Font("Bradley Hand ITC", Font.BOLD, 36));
        but.setForeground(color);
        but.setPreferredSize(new Dimension(100, 100));
        but.setIcon(imageIcon);
        but.setHorizontalTextPosition(JButton.CENTER);
        but.setVerticalTextPosition(JButton.CENTER);

        return but;
    }


    void getTable(){
        try {
            Connection ce;
            ce= DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
            ResultSet rs = ce.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                flashcardList.add(rs.getString("TABLE_NAME"));
            }
            ce.close();
        } catch (Exception err) {
            System.err.println(err.getClass().getName() + ": " + err.getMessage());
            System.exit(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeck;
    private javax.swing.JButton addWord;
    private javax.swing.JLabel creator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton remov;
    private javax.swing.JButton start;
    private javax.swing.JButton viewList;
    // End of variables declaration//GEN-END:variables
}
