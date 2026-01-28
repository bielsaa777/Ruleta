package ruleta;

import java.util.Scanner;

public class juego {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Rule_v2 rule = new Rule_v2();
		
		System.out.print("¿Cuanto saldo quieres introducir?: ");
		int saldoIntroducido = sc.nextInt();
		
		rule.miSaldo(saldoIntroducido);
		
		String opcion;
		
		do {
			System.out.println();
			System.out.println("Saldo actual: " + rule.saldo);
			System.out.println();
			System.out.println("¿A que quieres apostar?");
			System.out.println();
			System.out.println("1. Color");
			System.out.println("2. Numero");
			System.out.println("3. Par/Impar");
			System.out.println("4. Fila");
			System.out.println("5. Docenas");
			System.out.println("6. Acabar");
			opcion = sc.next().toLowerCase();
			
			if (opcion.equals("acabar")) {
				break;
			}
			
			System.out.print("¿Cuanto dinero quieres apostar?: ");
			int apuesta = sc.nextInt();
			
			if (apuesta > rule.saldo) {
				System.out.println("No tienes suficiente saldo para esa apuesta.");
				continue;
			}
			
			int bolita = rule.tirarBolita();
			
			boolean victoria = false;
			
			String colores = rule.color();
			
			switch(opcion) {
				case "color" -> {
					System.out.println("1. Escribe negro para apostar al negro.");
					System.out.println("2. Escribe rojo para apostar al rojo.");
					System.out.println("3. Escribe verde para apostar al verde.");
					System.out.print("¿A que color quieres apostar?: ");
					String colorApostado = sc.next().toLowerCase();
					
					victoria = rule.apostarColor(apuesta, colorApostado);
				}
				
				case "numero" -> {
					System.out.print("¿A que numero quieres apostar (0/36)?: ");
					int numApostado = sc.nextInt();
			
					victoria = rule.apostarNumero(apuesta, numApostado);
				}
				
				case "par/impar" -> {
					System.out.println("1. Escribe par para apostar a pares.");
					System.out.println("2. Escribe impar para apostar a impares.");
					System.out.print("¿A que quieres apostar?: ");
					String parImpar = sc.next().toLowerCase();
					
					victoria = rule.apostarParImpar(apuesta, parImpar);
				}
				
				case "fila" -> {
					System.out.println("¿A qué fila quieres apostar?");
					System.out.println("1. Fila uno");
					System.out.println("2. Fila dos");
					System.out.println("3. Fila tres");
					int filaApostada = sc.nextInt();
					
					victoria = rule.apostarFila(apuesta, filaApostada);
				}
				
				case "docenas" -> {
					System.out.println("¿A qué docena quieres apostar?");
					System.out.println("1. Primera docena");
					System.out.println("2. Segunda docena");
					System.out.println("2. Tercera docena");					
					int docenaApostada = sc.nextInt();
					
					victoria = rule.apostarDocena(apuesta, docenaApostada);
				}
			}
				
			System.out.println();
			System.out.println("El número es " + bolita + " " + colores);
			System.out.println();
			
			if (victoria) {
				System.out.println("¡Has ganado!");
			} else {
				System.out.println("Has perdido");
			}
			System.out.println();
		} while (rule.saldo > 0);
		
		if (rule.saldo <= 0) {
			System.out.println("Te has quedado sin saldo.");
		}
		
		System.out.println("Juego terminado. Tu saldo es: " + rule.saldo);
		
	}

}