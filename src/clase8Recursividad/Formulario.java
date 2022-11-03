package clase8Recursividad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Formulario extends JFrame {
    private JPanel contentPane;
    private JLabel[][] l;
    private boolean salida;
    /**
     * Launch the application.
     */
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
    /**
     * Create the frame.
     */
    public Formulario() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 604, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnRecorrer = new JButton("Recorrer");
        btnRecorrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                salida=false;
                recorrer(0,0);
                if (salida)
                    setTitle("tiene salida");
                else
                    setTitle("no tiene salida");
            }
        });
        btnRecorrer.setBounds(10, 11, 89, 23);
        contentPane.add(btnRecorrer);
        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crear();
            }
        });
        btnCrear.setBounds(109, 11, 89, 23);
        contentPane.add(btnCrear);
        l=new JLabel[10][10];
        for(int f=0;f<10;f++) {
            for(int c=0;c<10;c++) {
                l[f][c]=new JLabel();
                l[f][c].setBounds(20+c*20,50+f*20,20,20);
                add(l[f][c]);
            }
        }
        crear();
    }
    public void crear()
    {
        for(int f=0;f<10;f++) {
            for(int c=0;c<10;c++) {
                int a=(int)(Math.random()*4);
                l[f][c].setForeground(Color.black);
                if (a==0)
                    l[f][c].setText("1");
                else
                    l[f][c].setText("0");
            }
        }
        l[9][9].setText("s");
        l[0][0].setText("0");
    }
    public void recorrer(int fil,int col)
    {
        if (fil>=0 && fil<10 && col>=0 && col<10 && salida==false) {
            if (l[fil][col].getText().equals("s"))salida=true;
            else
            if (l[fil][col].getText().equals("0")) {
                l[fil][col].setText("9");
                l[fil][col].setForeground(Color.red);
                recorrer(fil,col+1);
                recorrer(fil+1,col);
                recorrer(fil-1,col);
                recorrer(fil,col-1);
            }
        }
    }
}