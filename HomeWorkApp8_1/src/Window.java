import javax.swing.*;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window (){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(5,200,500,500);
        JButton firstButton = new JButton("Выход");

        ActionListener listener = new CloseActionListener();
        firstButton.addActionListener(listener);

        JButton secondButton = new JButton("Тоже выход");
        ActionListener secondListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        secondButton.addActionListener(secondListener);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(secondButton);
        panel.add(firstButton);
        add(panel,BorderLayout.SOUTH);
    }

}
