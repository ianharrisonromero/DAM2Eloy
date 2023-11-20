import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Simulacro {
  public static void main(String[] args) {
    JFrame myFrame = new JFrame("Título de la ventana");
    JPanel myPanel = new JPanel();
    myFrame.setVisible(true);

    JLabel labelTitulo = new JLabel("Escribe tu título:");
    JTextField textTitulo = new JTextField(20);
    JButton buttonCambia = new JButton("Cambia!");
    JButton buttonMinimizar = new JButton("Minimizar");
    JButton buttonCerrar = new JButton("Cerrar");
    JLabel labelColor = new JLabel("Selecciona el color de fondo");
    JComboBox<String> comboColores = new JComboBox<>();
    comboColores.addItem("rojo");
    comboColores.addItem("azul");
    comboColores.addItem("verde");
    comboColores.addItem("amarillo");
    JButton buttonMensaje = new JButton("Mensaje");
    JCheckBox chkVainilla = new JCheckBox("Vainilla");
    JCheckBox chkChoco = new JCheckBox("Chocolate");
    JRadioButton radioCono = new JRadioButton("Cono");
    JRadioButton radioTarrina = new JRadioButton("Tarrina");
    ButtonGroup grupoRadios = new ButtonGroup();
    JButton comprobarRadio = new JButton("Compueba el Radio buttonN");

    myFrame.setResizable(true);
    myFrame.setSize(500, 500);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.add(myPanel);
    myPanel.add(labelTitulo);
    myPanel.add(textTitulo);
    myPanel.add(buttonCambia);
    myPanel.add(buttonMinimizar);
    myPanel.add(buttonCerrar);
    myPanel.add(labelColor);
    myPanel.add(comboColores);
    myPanel.add(buttonMensaje);
    myPanel.add(chkVainilla);
    myPanel.add(chkChoco);
    myPanel.add(radioCono);
    myPanel.add(radioTarrina);
    myPanel.add(comprobarRadio);

    grupoRadios.add(radioCono);
    grupoRadios.add(radioTarrina);

    comboColores.setSelectedItem(comboColores.getItemAt(3));

    chkChoco.addActionListener(e -> {
      JOptionPane.showMessageDialog(myFrame, "HELADO DE CHOCOLATE FOR YOU");
    });

    grupoRadios.getS

    comprobarRadio.addActionListener(e -> {
      if (radioCono.isSelected()) {
        JOptionPane.showMessageDialog(myFrame, "has seleccionado cono!");
      } else if (radioTarrina.isSelected()) {
        JOptionPane.showConfirmDialog(myFrame, "has elegido TARRINA!!!");
      } else {
        JOptionPane.showInputDialog("No has seleccionado nada?");
      }
    });

    buttonCambia.addActionListener(e -> {
      if (!textTitulo.getText().trim().isEmpty()) {
        String nuevoTitulo = textTitulo.getText();
        myFrame.setTitle(nuevoTitulo);
      } else {
        JOptionPane.showMessageDialog(myFrame, "No has introducido ningún titulo");
      }
    });

    buttonMinimizar.addActionListener(e -> {
      myFrame.setExtendedState(JFrame.ICONIFIED);
      buttonCambia.setEnabled(false);
    });

    comboColores.addActionListener(e -> {
      String colorSeleccionado = comboColores.getSelectedItem().toString();
      switch (colorSeleccionado) {
        case "rojo":
          myPanel.setBackground(Color.RED);
          break;
        case "azul":
          myPanel.setBackground(Color.BLUE);
          break;
        case "amarillo":
          myPanel.setBackground(Color.YELLOW);
          break;
        case "verde":
          myPanel.setBackground(Color.GREEN);
          break;
        default:
          break;
      }
    });

    buttonMensaje.addActionListener(e -> {
      JOptionPane.showConfirmDialog(myFrame, "Este examen es demasiado sencillo");
    });
  }
}