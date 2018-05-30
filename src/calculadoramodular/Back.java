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

    public String getZn() {
        if(0<zn.signum())
            return zn.toString();
        else
            return "No asignado";
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
            return " ";
        a=new BigInteger(sa);
        b=new BigInteger(sb);
        if(b.signum()<0)
        	return"No es posible dividir por "+b.toString();
        
        a = perteneceAZn(a);
        b = perteneceAZn(b);
        sa=invertibleModular(b.toString());
        if(sa.contains("No"))
            return sa;
        else
            b=new BigInteger(sa);
        resultado=a.multiply(b);
        resultado=resultado.mod(zn);
        if(a.signum()<0){
        	resultado.add(BigInteger.valueOf(-1));
        }
        return resultado.toString();
    }
    
    public String powModular(String base, String expo){
        if(zn==BigInteger.ZERO)
            return "";
        a=new BigInteger(base);
        b= new BigInteger(expo);
        resultado = a.pow(b.intValue());
        resultado=resultado.mod(zn);
        return resultado.toString();
    }
    
    public int[] cPerfectos(){
        int cp[]=new int[zn.intValue()];
        for(int i=0;i<zn.intValue();i++){
            b=BigInteger.valueOf(i);
            b=b.multiply(b);
            b=b.mod(zn);
            cp[i]=b.intValue();
        }
        return cp;
    }
    
    public String cuadradosPerfectos(){
        int cp[]=cPerfectos();
        String r="";
        for(int i=0;i<zn.intValue();i++){
            if(r.contains(Integer.toString(cp[i])))
                continue;
            r+=cp[i]+", ";
        }
        return r+" No more data.";
    }
    
    public String raiz(String r){
        if(zn==BigInteger.ZERO)
            return "";
        a=new BigInteger(r);
        r="{";
        int cp[]=cPerfectos();
        for(int i=0;i<zn.intValue();i++){
            if(cp[i]==a.intValue())
                r+=i+", ";
        }
        return r+"No more}";
    }
    
    public String invertibleModular(String i){
        b=new BigInteger(i);
        if(!b.gcd(zn).equals(BigInteger.ONE))
            return "No existe invertible para "+b.toString()+" en "+ zn.toString();
        b=b.modInverse(zn);
        b.mod(zn);
        return b.toString();
    }
    
    private BigInteger perteneceAZn(BigInteger x){
        if(0<x.compareTo(zn))
            return x;
        else
            return x.mod(zn);
    }
}
    