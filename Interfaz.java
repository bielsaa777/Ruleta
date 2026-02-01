package ruleta;

import java.util.Scanner;

public class Interfaz {
	
	Scanner sc = new Scanner(System.in);
    
    public void saldoInicial() {
    	System.out.print("¿Cuanto saldo quieres introducir?: ");
    }
    
    public void mostrarSaldo(int saldo) {
    	System.out.println();
		System.out.println("Saldo actual: " + saldo);
		System.out.println();
    }
    
    public void dineroApostado() {
    	System.out.print("¿Cuanto dinero quieres apostar?: ");
    }
	
	String apuesta() {	
		System.out.println("¿A que quieres apostar?");
		System.out.println();
		System.out.println("1. Color");
		System.out.println("2. Numero");
		System.out.println("3. Par/Impar");
		System.out.println("4. Fila");
		System.out.println("5. Docenas");
		System.out.println("6. Acabar");
		return sc.next().toLowerCase();		
	}
	
	public void menuColor() {
		System.out.println("1. Escribe negro para apostar al negro.");
		System.out.println("2. Escribe rojo para apostar al rojo.");
		System.out.println("3. Escribe verde para apostar al verde.");
		System.out.print("¿A que color quieres apostar?: ");
	}
	
	public void menuNum() {
		System.out.print("¿A que numero quieres apostar (0/36)?: ");
	}
	
	public void menuPar() {
		System.out.println("1. Escribe par para apostar a pares.");
		System.out.println("2. Escribe impar para apostar a impares.");
		System.out.print("¿A que quieres apostar?: ");
	}
	
	public void menuFila() {
		System.out.println("¿A qué fila quieres apostar?");
		System.out.println("1. Fila uno");
		System.out.println("2. Fila dos");
		System.out.println("3. Fila tres");
	}
	
	public void menuDocenas() {
		System.out.println("¿A qué docena quieres apostar?");
		System.out.println("1. Primera docena");
		System.out.println("2. Segunda docena");
		System.out.println("2. Tercera docena");
	}
	
	public void resultado(int bolita, String colorBolita, boolean victoria) {
		System.out.println();
		System.out.println("El número es " + bolita + " " + colorBolita);
		System.out.println();
		if (victoria) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("Has perdido");
        }
	}
	
	public void saldoInsuficiente() {
		System.out.println("No tienes suficiente saldo para esa apuesta.");
	}
	
	public void sinSaldo() {
		System.out.println("Te has quedado sin saldo.");
	}
	
	public void fin(int saldo) {
		System.out.println("Juego terminado. Tu saldo es: " + saldo);
	}
	
	public void error() {
		System.out.println("Error");
	}
}