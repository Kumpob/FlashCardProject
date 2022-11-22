import javax.swing.*;
import java.awt.*;
import java.util.*;
public class selectionPanel {
    JFrame jm = new JFrame("Selection Page");
    JLabel qlabel=new JLabel("Question: ");

    selectionPanel(ArrayList <JButton> buttonsList ){   

        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("FLASHCARD!");
        JLabel blank1 = new JLabel();

        jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setFont(new Font("Serif", Font.PLAIN, 32));
        panel.setLayout(new GridLayout(0, 2,20,25));
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 25));
        
        panel.add(label);
        panel.add(blank1);

        container.add(panel);
        JScrollPane scrollPane = new JScrollPane(container);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        jm.getContentPane().add(scrollPane);
        jm.setSize(new Dimension(480,600));

        jm.setResizable(false);
        jm.setLocationRelativeTo(null);  
        for(int i = 0;i < buttonsList.size();i++){
            JButton but = buttonsList.get(i);
            
            panel.add(but);
        }
        jm.setVisible(true);
    }

        


    }