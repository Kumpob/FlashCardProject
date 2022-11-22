import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;

public class Remov1 extends javax.swing.JFrame {

    String tableName;
    DefaultTableModel tableModel = new DefaultTableModel();

    public Remov1(String Name) {
        initComponents(Name);
    }
    private void initComponents(String Name) {
        this.tableName = Name;
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();
        id = new javax.swing.JTextField();
        text = new javax.swing.JLabel();
        rem = new javax.swing.JButton();
        back = new javax.swing.JButton();
        setTitle("Remove");

        list.setModel(tableModel);
       
        tableModel.addColumn("id");
        tableModel.addColumn("Question");
        tableModel.addColumn("Answer");

        try {
            Connection ce;
            ce= DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
            PreparedStatement stmt = ce.prepareStatement("SELECT * FROM " + this.tableName);
            ResultSet got = stmt.executeQuery();
            while (got.next()) {
                String row[] = new String[3];
                row[0] = got.getString(1);
                row[1] = got.getString(2);
                row[2] = got.getString(3);
                tableModel.addRow(row);
            }
        } catch (Exception err) {
            System.err.println(err.getClass().getName() + ": " + err.getMessage());
            System.exit(0);
        }

        jScrollPane1.setViewportView(list);

        text.setText("Enter ID to be remove:");

        rem.setText("Remove");
        rem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remActionPerformed(evt);
            }
        });

        back.setText("Exit");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rem))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rem)
                    .addComponent(back))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        tableModel.fireTableDataChanged();
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        
        dispose();
    }

    private void remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remActionPerformed
        try {
            Connection ce;
            ce= DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
            PreparedStatement stmt = ce.prepareStatement("DELETE FROM " + this.tableName + " WHERE id = ?");
            stmt.setString(1, id.getText());
            stmt.executeUpdate();
            stmt.close();
            ce.close();
            JOptionPane.showMessageDialog(null,"Card removed Successfully!");

        } catch (Exception err) {
            System.err.println(err.getClass().getName() + ": " + err.getMessage());
            System.exit(0);
        }
        Refresh();
    }

    void Refresh(){
        tableModel.setRowCount(0);
        try {
            Connection ce;
            ce= DriverManager.getConnection("jdbc:sqlite:./src/database/deck.db");
            PreparedStatement stmt = ce.prepareStatement("SELECT * FROM " + this.tableName);
            ResultSet got = stmt.executeQuery();
            while (got.next()) {
                String row[] = new String[3];
                row[0] = got.getString(1);
                row[1] = got.getString(2);
                row[2] = got.getString(3);
                tableModel.addRow(row);
            }
        } catch (Exception err) {
            System.err.println(err.getClass().getName() + ": " + err.getMessage());
            System.exit(0);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable list;
    private javax.swing.JButton rem;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
