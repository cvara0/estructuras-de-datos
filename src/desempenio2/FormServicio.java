package desempenio2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

    public static JButton setJButtonInsertar(int x,int y,int w,int h){
        JButton jButton= new JButton("Insertar nodo");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

    public static JButton setjButtonBorrarMayorSubIzq(int x,int y,int w,int h){
        JButton jButton= new JButton("Eliminar");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

    public static JButton setJButtonLimpiar(int x,int y,int w,int h){
        JButton jButton= new JButton("Limpiar");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

    public static JButton setJButtonVerificar(int x,int y,int w,int h){
        JButton jButton= new JButton("Verificar:");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

    public static JButton setJButton2(int x,int y,int w,int h){
        JButton jButton= new JButton("<html>2 - Mostrar mayor y menor de subárbol izquierdo, indique si el árbol o rama está vacío.</html>");
        jButton.setBounds(x,y,w,h);
        return jButton;
    }

}
