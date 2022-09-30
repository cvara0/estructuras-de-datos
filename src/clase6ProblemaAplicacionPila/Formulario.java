package clase6ProblemaAplicacionPila;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame{

    private JPanel contentPane;
    private JTextField textField;
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
    public Formulario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 203);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        textField = new JTextField();
        textField.setBounds(42, 40, 322, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        JButton btnNewButton = new JButton("Verificar f\u00F3rmula");
                btnNewButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent arg0) {
                        if (balanceada()) {
                            setTitle("Está correctamente balanceada.");
                        } else {
                            setTitle("No está correctamente balanceada.");
                        }
                    }
                });
        btnNewButton.setBounds(41, 93, 152, 23);
        contentPane.add(btnNewButton);
    }
    public boolean balanceada() {
        AplicacionPila pila1;
        pila1 = new AplicacionPila ();
        String cadena=textField.getText();
        for (int f = 0 ; f < cadena.length() ; f++)
        {
            if (cadena.charAt(f) == '(' || cadena.charAt(f) ==
                    '[' || cadena.charAt(f) == '{') {
                pila1.insertar(cadena.charAt(f));
            } else {
                if (cadena.charAt(f)==')') {
                    if (pila1.extraer()!='(') {
                        return false;
                    }
                } else {
                    if (cadena.charAt(f)==']') {
                        if (pila1.extraer()!='[') {
                            return false;
                        }
                    } else {
                        if (cadena.charAt(f)=='}') {
                            if (pila1.extraer()!='{') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (pila1.vacia()) {
            return true;
        } else {
            return false;
        }
    }
}

/*
*
* Planteo del problema:
Este práctico tiene por objetivo mostrar la importancia de las pilas en las Ciencias de
la Computación y más precisamente en la programación de software de bajo nivel.
Todoo compilador o intérprete de un lenguaje tiene un módulo dedicado a analizar si
una expresión está correctamente codificada, es decir que los paréntesis estén abiertos y
cerrados en un orden lógico y bien balanceados.
Se debe desarrollar una clase que tenga las siguientes responsabilidades (clase
Formula):
- Ingresar una fórmula que contenga paréntesis, corchetes y llaves.
- Validar que los ( ) [] y {} estén correctamente balanceados.
Para la solución de este problema la clase formula tendrá un atributo de la clase Pila.
Veamos como nos puede ayudar el empleo de una pila para solucionar este problema.
Primero cargaremos la fórmula en un JTextField.
Ejemplo de fórmula: (2+[3-12]*{8/3})
El algoritmo de validación es el siguiente:
Analizamos caracter a caracter la presencia de los paréntesis, corchetes y llaves.
Si vienen símbolos de apertura los almacenamos en la pila.
Si vienen símbolos de cerrado extraemos de la pila y verificamos si está el mismo
símbolo pero de apertura: en caso negativo podemos inferir que la fórmula no está
correctamente balanceada.
*
* */