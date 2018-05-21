/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramodular;
import java.math.BigInteger;
/**
 *
 * @author jose-
 */
public class Back {
    private BigInteger zn, a,b,resultado;
    public Back(){
        zn = BigInteger.ZERO;
        a = BigInteger.ZERO;
        b = BigInteger.ZERO;
        resultado = BigInteger.ZERO;
    }
    
    public boolean setZn(String n){
        zn = new BigInteger(n);
        if(0<zn.signum())            
            return true;
        else{
            zn = BigInteger.ZERO;
            return false;
        }
    }
    
    public String sumaModular(String sa,String sb){
        if(zn==BigInteger.ZERO)
            return "";
        a=new BigInteger(sa);
        b=new BigInteger(sb);
        a = perteneceAZn(a);
        b = perteneceAZn(b);
        resultado=a.add(b);
        resultado=resultado.mod(zn);
        return resultado.toString();
    }
    
    public String multiplicacionModular(String sa,String sb){
        if(zn==BigInteger.ZERO)
            return "";
        a=new BigInteger(sa);
        b=new BigInteger(sb);
        a = perteneceAZn(a);
        b = perteneceAZn(b);
        resultado=a.multiply(b);
        resultado=resultado.mod(zn);
        return resultado.toString();
    }
    
    public String divisionModular(String sa, String sb){
        if(zn==BigInteger.ZERO)
            return "";
        a=new BigInteger(sa);
        b=new BigInteger(sb);
        a = perteneceAZn(a);
        b = perteneceAZn(b);
        //b = invertibleModular
        resultado=a.multiply(b);
        return resultado.toString();
    }
    
    private BigInteger perteneceAZn(BigInteger x){
        if(0<x.compareTo(zn))
            return x;
        else
            return x.mod(zn);
    }
}
