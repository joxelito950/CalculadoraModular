/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramodular;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author jose-
 */
public class Front extends JFrame implements ActionListener{
    private JTextField zn,a,b,resultado;
    private JScrollPane r;
    private JLabel infoZn, infoA, infoB, infoResultado;
    private JButton sum, mult, div, powAb, powBa, raizA, raizB, cp, inversoA, inversoB;
    private Back operaciones;
    
    public Front(){
        this.setLayout(null);
        this.setBounds(200, 200, 300, 300);
        this.setTitle("Calculadora Modular");
        this.setResizable(false);
        infoZn = new JLabel("Zn");
        zn = new JTextField();
        infoA = new JLabel("a");
        a = new JTextField();
        infoB = new JLabel("b");
        b = new JTextField();
        infoResultado = new JLabel("Resultado");
        resultado= new JTextField();
        resultado.setEditable(false);
        r =new JScrollPane(resultado);
        sum = new JButton("a⊕b");
        mult = new JButton("a⊗b");
        div = new JButton("aØb");
        powAb = new JButton("a^b");
        powBa = new JButton("b^a");
        raizA = new JButton("√a");
        raizB = new JButton("√b");
        cp = new JButton("C.P");
        inversoA = new JButton("a^-1");
        inversoB = new JButton("b^-1");
        operaciones = new Back();
        
    }
    
    public void ventana(){
        infoZn.setBounds(10,10,20,20);
        zn.setBounds(35,10,220,20);
        infoA.setBounds(15,35,20,20);
        a.setBounds(35,35,220,20);
        infoB.setBounds(15,60,20,20);
        b.setBounds(35,60,220,20);
        sum.setBounds(10,85,60,25);
        mult.setBounds(75,85,60,25);
        div.setBounds(140,85,60,25);
        powAb.setBounds(205,85,60,25);
        powBa.setBounds(20,115,60,25);
        raizA.setBounds(85,115,80,25);
        raizB.setBounds(170,115,80,25);
        cp.setBounds(35,145,60,25);
        inversoA.setBounds(100,145,60,25);
        inversoB.setBounds(165,145,60,25);
        infoResultado.setBounds(115,180,100,20);
        r.setBounds(10, 200, 270, 42);
        
        this.add(infoZn);
        this.add(zn);
        this.add(infoA);
        this.add(a);
        this.add(infoB);
        this.add(b);
        this.add(infoResultado);
        this.add(r);
        this.add(sum);
        this.add(mult);
        this.add(div);
        this.add(powAb);
        this.add(powBa);
        this.add(raizA);
        this.add(raizB);
        this.add(cp);
        this.add(inversoA);
        this.add(inversoB);
        
        infoZn.setVisible(true);
        zn.setVisible(true);
        infoA.setVisible(true);
        a.setVisible(true);
        infoB.setVisible(true);
        b.setVisible(true);
        infoResultado.setVisible(true);
        r.setVisible(true);
        sum.setVisible(true);
        mult.setVisible(true);
        div.setVisible(true);
        powAb.setVisible(true);
        powBa.setVisible(true);
        raizA.setVisible(true);
        raizB.setVisible(true);
        cp.setVisible(true);
        inversoA.setVisible(true);
        inversoB.setVisible(true);
        this.setVisible(true);
        
        sum.setEnabled(false);
        mult.setEnabled(false);
        div.setEnabled(false);
        powAb.setEnabled(false);
        powBa.setEnabled(false);
        raizA.setEnabled(false);
        raizB.setEnabled(false);
        cp.setEnabled(false);
        inversoA.setEnabled(false);
        inversoB.setEnabled(false);
                
        Teclado tecleo=new Teclado();
        Foco evento=new Foco();
        
        zn.addKeyListener(tecleo);
        a.addKeyListener(tecleo);
        b.addKeyListener(tecleo);
        zn.addFocusListener(evento);
        zn.addActionListener(this);
        sum.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
        powAb.addActionListener(this);
        powBa.addActionListener(this);
        raizA.addActionListener(this);
        raizB.addActionListener(this);
        cp.addActionListener(this);
        inversoA.addActionListener(this);
        inversoB.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void znCorrecto(){
        if(operaciones.setZn(zn.getText())){
                    sum.setEnabled(true);
                    mult.setEnabled(true);
                    div.setEnabled(true);
                    powAb.setEnabled(true);
                    powBa.setEnabled(true);
                    raizA.setEnabled(true);
                    raizB.setEnabled(true);
                    cp.setEnabled(true);
                    inversoA.setEnabled(true);
                    inversoB.setEnabled(true);
                }
                else{
                    zn.setText("");
                    sum.setEnabled(false);
                    mult.setEnabled(false);
                    div.setEnabled(false);
                    powAb.setEnabled(false);
                    powBa.setEnabled(false);
                    raizA.setEnabled(false);
                    raizB.setEnabled(false);
                    cp.setEnabled(false);
                    inversoA.setEnabled(false);
                    inversoB.setEnabled(false);
                }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==zn){
            znCorrecto();
        }
        if(e.getSource()==sum){
            resultado.setText(operaciones.sumaModular(a.getText(),b.getText()));
        }
        if(e.getSource()==mult){
            resultado.setText(operaciones.multiplicacionModular(a.getText(), b.getText()));
        }
        if(e.getSource()==div){
            resultado.setText(operaciones.divisionModular(a.getText(), b.getText()));
        }
        if(e.getSource()==powAb){
            resultado.setText(operaciones.powModular(a.getText(), b.getText()));
        }
        if(e.getSource()==powBa){
            resultado.setText(operaciones.powModular(b.getText(),a.getText()));
        }
        if(e.getSource()==raizA){
            resultado.setText(operaciones.raiz(a.getText()));
        }
        if(e.getSource()==raizB){
            resultado.setText(operaciones.raiz(b.getText()));
        }
        if(e.getSource()==cp){
            resultado.setText(operaciones.cuadradosPerfectos());
        }
        if(e.getSource()==inversoA){
            resultado.setText(operaciones.invertibleModular(a.getText()));
        }
        if(e.getSource()==inversoB){
            resultado.setText(operaciones.invertibleModular(b.getText()));
        }
        zn.requestFocus();
    }
    
    private class Foco implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void focusLost(FocusEvent e) {
                if(e.getSource()==zn){
                    znCorrecto();
            }
        }
            
    }
    
    private class Teclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
                char d=e.getKeyChar();
                if(Character.isAlphabetic(d))
                    e.consume();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            if(code==KeyEvent.VK_DELETE)
                e.setSource("");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode(); 
            if(code==KeyEvent.VK_INSERT||code==KeyEvent.VK_ENTER)
                znCorrecto();
        }
        
    }

}
