/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramodular;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.math.BigInteger;


/**
 *
 * @author jose-
 */
public class Front extends JFrame implements ActionListener{
    private JTextField zn;
    private JTextField a;
    private JTextField b;
    private JTextArea resultado;
    private JLabel info;
    private JLabel infoZn;
    private JLabel infoA;
    private JLabel infoB;
    private JLabel infoResultado;
    private JButton sum;
    private JButton mult;
    private JButton div;
    private JButton powAb;
    private JButton powBa;
    private JButton raizA;
    private JButton raizB;
    private JButton cp;
    private JButton inversoA;
    private JButton inversoB;
    private Back operaciones;
    
    public Front(){
        this.setLayout(null);
        this.setBounds(200, 200, 300, 450);
        this.setTitle("Calculadora Modular");
        info = new JLabel("press Enter");
        infoZn = new JLabel("Zn");
        zn = new JTextField();
        infoA = new JLabel("a");
        a = new JTextField();
        infoB = new JLabel("b");
        b = new JTextField();
        infoResultado = new JLabel("Resultado");
        resultado =new JTextArea();
        sum = new JButton("S.M");
        mult = new JButton("M.M");
        div = new JButton("D.M");
        powAb = new JButton("a^b");
        powBa = new JButton("b^a");
        raizA = new JButton("a^1/2");
        raizB = new JButton("b^1/2");
        cp = new JButton("C.P");
        inversoA = new JButton("a^-1");
        inversoB = new JButton("b^-1");
        operaciones = new Back();
    }
    
    public void ventana(){
        info.setBounds(100, 10, 100, 20);
        infoZn.setBounds(10,10,20,20);
        zn.setBounds(35,10,50,20);
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
        resultado.setBounds(10,200,260,200);
        
        this.add(info);
        this.add(infoZn);
        this.add(zn);
        this.add(infoA);
        this.add(a);
        this.add(infoB);
        this.add(b);
        this.add(infoResultado);
        this.add(resultado);
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
        
        info.setVisible(true);
        infoZn.setVisible(true);
        zn.setVisible(true);
        infoA.setVisible(true);
        a.setVisible(true);
        infoB.setVisible(true);
        b.setVisible(true);
        infoResultado.setVisible(true);
        resultado.setVisible(true);
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
        
        a.setEnabled(false);
        b.setEnabled(false);
        
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==zn){
            if(operaciones.setZn(zn.getText())){ 
                info.setVisible(false);
                a.setEnabled(true);
                b.setEnabled(true);
            }
            else{
                zn.setText("");
                info.setVisible(true);
                a.setEnabled(false);
                b.setEnabled(false);
            }
        }
        if(e.getSource()==sum){
            resultado.setText(operaciones.sumaModular(a.getText(),b.getText()));
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==mult){
            resultado.setText(operaciones.multiplicacionModular(a.getText(), b.getText()));
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==div){
            resultado.setText(operaciones.divisionModular(a.getText(), b.getText()));
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==powAb){
            
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==powBa){
            
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==raizA){
            
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==raizB){
            
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==cp){
            
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==inversoA){
            
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        if(e.getSource()==inversoB){
            
            zn.setText("");
            info.setVisible(true);
            a.setEnabled(false);
            b.setEnabled(false);
        }
        
    }
    
}
