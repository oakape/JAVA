/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gato;


import java.util.Scanner;
/**
 * 
 * @author Oakape
 */
public class Tablero {
private Jugador jugador1,jugador2;
private Ficha fichasJuego[][] = new Ficha[3][3];
private final Scanner eleccion ;
private int contJ1,contJ2;


    public Tablero(){
        eleccion = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fichasJuego [i][j]= new Ficha();
            }
        }
        contJ1=0;
        contJ2=0;
    
    }
    
    public void obtenerDatosJugadores(){
    jugador1=datosJugador();
    jugador2=datosJugador();
    //jugador1=new Jugador("daniel","x");
  //  jugador2=new Jugador("Guillermo","v");
    
    
    }
    
    public Jugador datosJugador(){
        
    String nombre,ficha;
    System.out.print("Intruduzca su nombre: ");
    nombre=eleccion.nextLine();
    System.out.println("Elija ficha de jugador");
    ficha=eleccion.nextLine();
    Jugador jugador=new Jugador(nombre,ficha);
    return jugador;    
    
    }
    
     public void colocarFicha(int jugador,int x, int y){
        if(jugador==1){
            fichasJuego[x][y]=jugador1.obtenerFichaJugador();
        }
        if (jugador==2){
           fichasJuego[x][y]=jugador2.obtenerFichaJugador();
        }
    }
    
    public void imprimirEstadoDeJuego()
    {
    System.out.println("Tablero del Juego version consola");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s\t|",fichasJuego[i][j].obtenerTipoDeFicha());
                 
            }
            
            System.out.print("\n-------------------------\n");
        }
    
    }
    
    public boolean juegoTerminado(){
        
       
    boolean condicion1=verificarFilas();    
    
    boolean condicion2=verificarColumnas();
    boolean condicion3=verificarDiagonales();  
    return condicion1 || condicion2 || condicion3;
   
        
         
    }
    
    public boolean verificarFilas(){
        
        if (contJ1==3||contJ2==3) {return true; }
        
         
        for (int i = 0; i < 3; i++) 
        {
             for (int j = 0; j < 3; j++) 
             {
                 if(fichasJuego[i][j].obtenerTipoDeFicha().toString().equals(jugador1.conseguirTipoFicha().toString()))
                 {
                     contJ1++;
                 }
                 if(fichasJuego[i][j].obtenerTipoDeFicha().toString().equals(jugador2.conseguirTipoFicha().toString())) 
                 {
                     contJ2++;
                 }
             }
             if(contJ2==3 || contJ1==3)
             { 
    return true;
             }
             else
             {
                 contJ2=0;
                 contJ1=0;
             }
         }
    return false;
    }
     
    public boolean verificarColumnas(){
         if (contJ1==3||contJ2==3) {return true; }
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 if(fichasJuego[j][i].obtenerTipoDeFicha().equals(jugador1.conseguirTipoFicha())){
                 contJ1++;
                 }
                 if(fichasJuego[j][i].obtenerTipoDeFicha().equals(jugador2.conseguirTipoFicha())){
                 contJ2++;
                 
                 }
             }
             if(contJ2==3 || contJ1==3)
             {
    System.out.println("paso por aqui columnas");
    return true;
             
             }
             else{
                 contJ2=0;
                 contJ1=0;
             }
             
         }
    return false;
    
    
    }
    
    public boolean verificarDiagonales(){
       if (contJ1==3||contJ2==3) {return true; }
        for (int i = 0; i < 3; i++) 
        {
            if(fichasJuego[i][i].obtenerTipoDeFicha().equals(jugador1.conseguirTipoFicha())){
                contJ1++;
            }
            if(fichasJuego[i][i].obtenerTipoDeFicha().equals(jugador2.conseguirTipoFicha())){
                contJ2++;
            }
            
        } 
        if(contJ1==3||contJ2==3){return true;}
        else{
            contJ1=0;
            contJ2=0;
        }
        for (int i = 0; i < 3; i++) 
        {
            if(fichasJuego[2-i][i].obtenerTipoDeFicha().equals(jugador1.conseguirTipoFicha())){
                contJ1++;
            }
            if(fichasJuego[2-i][i].obtenerTipoDeFicha().equals(jugador2.conseguirTipoFicha())){
                contJ2++;
            }
        }
        if(contJ1==3||contJ2==3){return true;}
        else{
            contJ1=0;
            contJ2=0;
        }
        return false;
    }
    
    public Jugador obtenerGanador(){
        System.out.println("contJ1: "+contJ1+" contJ2: "+contJ2);
        if(contJ1==3){
            jugador1.est=Jugador.estados.gano;
            jugador2.est=Jugador.estados.perdio;
        return jugador1;
        }
        if(contJ2==3){
            jugador2.est=Jugador.estados.gano;
            jugador1.est=Jugador.estados.perdio;
        return jugador2;
        
        }
        else{return null;}
    
    }
    
    
}
