package desempenio2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Formulario extends JFrame{
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textFieldExiste;
    private JLabel jLabelArbolPre;
    private JLabel jLabelArbolEntre;
    private JLabel jLabelArbolPost;
    private JLabel jLabelListaIngresados;
    private JLabel jLabelMayorYMenorSubIzquierdo;
    private JLabel jLabelNodoRaiz;
    private JLabel jLabelExistePrimeros3niveles;
    private JLabel jLabelCantidadHojasDeSubArbolIzq;
    private String ingresoList="";
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

        contentPane.add(FormServicio.setJLabel("1 - Insertar nodos al arbol:",(int)(x*0.2),(int)(y*3),(int)(w*2.6),h));

        textField=FormServicio.setJTextField((int)(x*0.9), (int)(y*3), (int)(w*0.2), h);
        contentPane.add(textField);
        JButton jButtonInsertar = FormServicio.setJButtonInsertar((int)(x*1.2), (int)(y*3), (int)(w*0.5), h);
        contentPane.add(jButtonInsertar);

        JButton jButtonLimpiar = FormServicio.setJButtonLimpiar((int)(x*2.4), (int)(y*3), (int)(w*0.3), h);
        contentPane.add(jButtonLimpiar);

        jLabelNodoRaiz=FormServicio.setJLabel("Raiz ( nivel 0 ): --",(int)(x*0.2), y*8, (int)(w*0.5), h);
        contentPane.add(jLabelNodoRaiz);

        jLabelArbolPre= FormServicio.setJLabel("Recorrido PreOrden: --",(int)(x*0.2),y*12,(int)(w*2.6),h);
        contentPane.add(jLabelArbolPre);

        jLabelArbolEntre= FormServicio.setJLabel("Recorrido EntreOrden: --",(int)(x*0.2),y*16,(int)(w*2.6),h);
        contentPane.add(jLabelArbolEntre);

        jLabelArbolPost= FormServicio.setJLabel("Recorrido PostOrden: --",(int)(x*0.2),y*20,(int)(w*2.6),h);
        contentPane.add(jLabelArbolPost);

        contentPane.add(FormServicio.setJLabel("Historial de insercion: ",(int)(x*0.2),y*24,(int)(w*2.6),h));
        jLabelListaIngresados= FormServicio.setJLabel("--",(int)(x*0.2),y*28,(int)(w*2.6),(int)(h*6.5));
        jLabelListaIngresados.setVerticalAlignment(SwingConstants.BOTTOM);
        contentPane.add(jLabelListaIngresados);

        contentPane.add(FormServicio.setJLabel("2 - Mayor y menor del subarbol izquierdo:",(int)(x*1.2),y*24,(int)(w*2.6),h));
        jLabelMayorYMenorSubIzquierdo=FormServicio.setJLabel("--",(int)(x*2.2),y*24,(int)(w*2.6),h);
        contentPane.add(jLabelMayorYMenorSubIzquierdo);

        contentPane.add(FormServicio.setJLabel("3 - Existe en los primeros 3 niveles?: ",(int)(x*1.2),y*28,(int)(w*2.6),h));
        textFieldExiste=FormServicio.setJTextField((int)(x*2.1), y*28, (int)(w*0.2), h);
        contentPane.add(textFieldExiste);
        JButton jButtonVerificar = FormServicio.setJButtonVerificar((int)(x*2.4), (y*28), (int)(w*0.35), h);
        contentPane.add(jButtonVerificar);
        jLabelExistePrimeros3niveles=FormServicio.setJLabel("--",(int)(x*2.8), (y*28), (int)(w*0.35), h);
        contentPane.add(jLabelExistePrimeros3niveles);

        contentPane.add(FormServicio.setJLabel("4 - Cantidad de nodos hoja de subarbol izquierdo: ",(int)(x*1.2),y*32,(int)(w*2.6),h));
        jLabelCantidadHojasDeSubArbolIzq=FormServicio.setJLabel("--",(int)(x*2.4), (y*32), (int)(w*0.35), h);
        contentPane.add(jLabelCantidadHojasDeSubArbolIzq);

        contentPane.add(FormServicio.setJLabel("5 - Borrar el mayor valor del subárbol izquierdo: ",(int)(x*1.2),y*36,(int)(w*2.6),h));
        JButton jButtonBorrarMayorSubIzq = FormServicio.setjButtonBorrarMayorSubIzq((int)(x*2.4), (y*36), (int)(w*0.35), h);
        contentPane.add(jButtonBorrarMayorSubIzq);

//////////todo boton insertar nodo
        jButtonInsertar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                arbol.insertarNodo(textField.getText());
                ingresoList+=arbol.getIngresoString()+"<br>";
                jLabelListaIngresados.setText("<html>"+ingresoList+"</html>");
                refrescar();
                contentPane.updateUI();
            }
        });
//////////

        jButtonLimpiar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                arbol.limpiar();
                arbol.setPreList("");
                arbol.setEntreList("");
                arbol.setPostList("");
                jLabelNodoRaiz.setText("Raiz ( nivel 0 ): --");
                jLabelArbolPre.setText("Recorrido PreOrden: --");
                jLabelArbolEntre.setText("Recorrido EntreOrden: --");
                jLabelArbolPost.setText("Recorrido PostOrden: --");
                jLabelListaIngresados.setText("--");
                ingresoList="";
                jLabelMayorYMenorSubIzquierdo.setText("--");
                textField.setText("");
                jLabelExistePrimeros3niveles.setText("--");
                jLabelCantidadHojasDeSubArbolIzq.setText("--");
                contentPane.updateUI();
            }
        });

/////todo boton verificar si existe en los 3 primeros niveles
        jButtonVerificar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {

                jLabelExistePrimeros3niveles.setText(arbol.existeEnPrimeros3Niveles(textFieldExiste.getText())?"Si":"No");
                ingresoList+=arbol.getIngresoString()+"<br>";
                jLabelListaIngresados.setText("<html>"+ingresoList+"</html>");
                contentPane.updateUI();
            }
        });

        jButtonBorrarMayorSubIzq.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {

                arbol.borrarMayorSubIzq();
                ingresoList+=arbol.getIngresoString()+"<br>";
                jLabelListaIngresados.setText("<html>"+ingresoList+"</html>");
                refrescar();
                contentPane.updateUI();
            }
        });



        contentPane.add(FormServicio.setJLabel(
                "Cristian V.R. Parra -- Desempeño 2 -- AED"
                ,(int)(x*1.8),y*45,(int)(w*2.6),h));
    }
    public void refrescar(){
        textField.setText("");
        arbol.imprimirPre();
        arbol.imprimirEntre();
        arbol.imprimirPost();
        jLabelArbolPre.setText("Recorrido PreOrden: [ "+arbol.getPreList()+" ]");
        jLabelArbolEntre.setText("Recorrido EntreOrden: [ "+arbol.getEntreList()+" ]");
        jLabelArbolPost.setText("Recorrido PostOrden: [ "+arbol.getPostList()+" ]");
        jLabelNodoRaiz.setText("Raiz ( nivel 0 ): "+arbol.getRaiz());
        jLabelMayorYMenorSubIzquierdo.setText("[ "+arbol.hallarMayorDeSubArbolIzq()+" , "+arbol.hallarMenorDeSubArbolIzq()+" ]");
        jLabelCantidadHojasDeSubArbolIzq.setText(arbol.cantidadNodosHojaDeSubArbolIzq());
        contentPane.updateUI();
    }

}
