
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ensayoExamen {

  public static void main(String[] args) {

    JPanel panel = new JPanel();
    panel.add(new JButton("Click"));
    panel.add(new JTextField(20));
    panel.add(new JLabel("Label"));
    JButton btn1 = new JButton();
    JOptionPane.showMessageDialog(null, "Simple Information Message");
  }

}