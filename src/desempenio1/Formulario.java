package desempenio1;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Formulario extends JFrame{
    private JPanel contentPane;


    private JLabel jLabel1;
    private JTextField textField1;

    private JLabel jLabel2;
    private JTextField textField2;

    private JLabel jLabelLista;
    private JLabel jLabelConsigna2;

    private FormServicio formServ;

    private Lista lista=new Lista();

    ////////////////////////////main//////////////////////////////////
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    desempenio1.Formulario frame = new desempenio1.Formulario();
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
                "1- Confeccionar un método que reciba dos enteros. <br/>" +
                "Si la lista tiene cuatro nodos se insertan al final, "+
                        "en cualquier otro caso se insertan al principio."
                ,(int)(x*0.2),y*2,(int)(w*2.6),h));

        jLabel1=FormServicio.setJLabel("Numero 1 : ",(int)(x*0.2), y*7, (int)(w*0.5), h);
        contentPane.add(jLabel1);
        textField1=FormServicio.setJTextField((int)(x*0.2), y*10, (int)(w*0.5), h);
        contentPane.add(textField1);

        jLabel2=FormServicio.setJLabel("Numero 2 : ",(int)(x*0.8), y*7, (int)(w*0.5), h);
        contentPane.add(jLabel2);
        textField2=FormServicio.setJTextField((int)(x*0.8), y*10, (int)(w*0.5), h);
        contentPane.add(textField2);
//////////
        JButton jButton1 = FormServicio.setJButton1((int)(x*1.5), y*10, (int)(w*0.5), h);
        contentPane.add(jButton1);

        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                lista.insertarPar(textField1.getText() ,textField2.getText());
                jLabelLista.setText("Lista : "+lista.imprimir());
                textField1.setText("");
                textField2.setText("");
                contentPane.updateUI();
            }
        });
//////////
        JButton jButtonLimpiar = FormServicio.setJButtonLimpiar((int)(x*2.2), y*10, (int)(w*0.5), h);
        contentPane.add(jButtonLimpiar);
        jButtonLimpiar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                lista.limpiar();
                jLabelLista.setText("Lista : "+lista.imprimir());
                textField1.setText("");
                textField2.setText("");
                jLabelConsigna2.setText("Consigna 2 :");
                contentPane.updateUI();
            }
        });
//////////
        jLabelLista=FormServicio.setJLabel("Lista : ",(int)(x*0.2),y*15,(int)(w*2.6),h);
        contentPane.add(jLabelLista);

//////////
        jLabelConsigna2=FormServicio.setJLabel("Consigna 2 : ",(int)(x*0.2),y*20,(int)(w*2.6),h);
        contentPane.add(jLabelConsigna2);

        JButton jButton2=FormServicio.setJButton2((int)(x*0.2),y*25,(int)(w*2.6),h);
        contentPane.add(jButton2);

        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                jLabelConsigna2.setText("Consigna 2 : "+lista.sumarNodosPosImpar());
                contentPane.updateUI();
            }
        });
//////////
        JButton jButton3=FormServicio.setJButton3((int)(x*0.2),y*30,(int)(w*2.6),h);
        contentPane.add(jButton3);

        jButton3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                lista.elimnarPrimeroYUltimo();
                jLabelLista.setText("Lista : "+lista.imprimir());
                textField1.setText("");
                textField2.setText("");
                jLabelConsigna2.setText("Consigna 2 : ");
                contentPane.updateUI();
            }
        });

/////////
        JButton jButton4=FormServicio.setJButton4((int)(x*0.2),y*35,(int)(w*2.6),h);
        contentPane.add(jButton4);

        jButton4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) {
                lista.cambiarPrimeroConUltimo();
                jLabelLista.setText("Lista : "+lista.imprimir());
                textField1.setText("");
                textField2.setText("");
                jLabelConsigna2.setText("Consigna 2 : ");
                contentPane.updateUI();
            }
        });

////////
        JButton jButton5=FormServicio.setJButton5((int)(x*0.2),y*40,(int)(w*2.6),h);
        contentPane.add(jButton5);

        contentPane.add(FormServicio.setJLabel(
                "Cristian V.R. Parra -- Desempeño 1 -- AED"
                ,(int)(x*1.8),y*45,(int)(w*2.6),h));


    }

}
