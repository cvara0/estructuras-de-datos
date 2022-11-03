package desempenio2;

import desempenio2.FormServicio;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Formulario extends JFrame{
    private JPanel contentPane;

    private JLabel jLabel;
    private JTextField textField;


    private JLabel jLabelArbolPre;
    private JLabel jLabelArbolEntre;
    private JLabel jLabelArbolPost;

    private final Arbol arbol=new Arbol();

    ////////////////////////////main//////////////////////////////////
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario frame = new Formulario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //////////////////////////////////////////////////////////////
    public Formulario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 550);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        int y=10;
        int x=300;
        int w=300;
        int h=30;

        contentPane.add(FormServicio.setJLabel(
                "1- Insertar nodos al arbol"
                ,(int)(x*0.2),y*2,(int)(w*2.6),h));

        jLabel=FormServicio.setJLabel("Nodo : ",(int)(x*0.2), y*7, (int)(w*0.5), h);
        contentPane.add(jLabel);
        textField=FormServicio.setJTextField((int)(x*0.2), y*10, (int)(w*0.5), h);
        contentPane.add(textField);

        jLabelArbolPre= FormServicio.setJLabel("Arbol Pre: ",(int)(x*0.2),y*15,(int)(w*2.6),h);
        contentPane.add(jLabelArbolPre);

//////////
        JButton jButton1 = FormServicio.setJButton1((int)(x*1.5), y*10, (int)(w*0.5), h);
        contentPane.add(jButton1);

        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {

                arbol.insertarNodo(textField.getText());
                textField.setText("");
                arbol.imprimirPre();
                jLabelArbolPre.setText("Pre Orden : [ "+arbol.getPreList()+" ]");
                contentPane.updateUI();
            }
        });
//////////
        JButton jButtonLimpiar = FormServicio.setJButtonLimpiar((int)(x*2.2), y*10, (int)(w*0.5), h);
        contentPane.add(jButtonLimpiar);
        jButtonLimpiar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                arbol.limpiar();
                arbol.setPreList("");
                jLabelArbolPre.setText("Arbol vacio");
                textField.setText("");
                contentPane.updateUI();
            }
        });

//
        contentPane.add(FormServicio.setJLabel(
                "Cristian V.R. Parra -- Desempeño 2 -- AED"
                ,(int)(x*1.8),y*45,(int)(w*2.6),h));
    }

}
