package desempenio1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormServicio {



    public static JPanel getContentPane() {

        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel.setLayout(null);
        return jPanel;
    }
    public static JLabel setJLabel(String text,int x,int y,int w, int h) {
        JLabel jLabel;
        jLabel = new JLabel("<html>"+text+"</html>");
        jLabel.setBounds(x,y,w,h);
        return jLabel;
    }
    public static JTextField setJTextField(int x,int y,int w, int h) {
        JTextField jTextField;
        jTextField = new JTextField();
        jTextField.setBounds(x,y,w,h);
        return jTextField;
    }

    public static JButton setJButton1(int x,int y,int w,int h){
        JButton jButton= new JButton("Insertar par");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

    public static JButton setJButton2(int x,int y,int w,int h){
        JButton jButton= new JButton("<html>2 - Sumar todos los nodos de las posiciones impares.</html>");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

    public static JButton setJButton3(int x,int y,int w,int h){
        JButton jButton= new JButton("<html>3 - Borrar el primero y el último nodo de la lista, dejando al resto correctamente enlazados. </html>");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

    public static JButton setJButton4(int x,int y,int w,int h){
        JButton jButton= new JButton("<html>4 - Intercambiar el primer nodo con el último de la lista. </html>");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

}
