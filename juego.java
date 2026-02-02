package ruleta;

import java.util.Scanner;
import java.util.InputMismatchException;

public class juego {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Rule_v2 rule = new Rule_v2();
		Interfaz ruleta = new Interfaz();
		
		int saldoIntroducido = 0;
		boolean saldoValido = false;
		
		while (!saldoValido) {
			try{
				ruleta.saldoInicial();			
				saldoIntroducido = sc.nextInt();
				saldoValido = true;
			} catch (InputMismatchException e){
				ruleta.error();
				sc.nextLine();
			}
		}
		
		rule.miSaldo(saldoIntroducido);
		int opcion;
		
		do {
				
			try {				
				ruleta.mostrarSaldo(rule.saldo);
				
				opcion = ruleta.apuesta();
				
				if (opcion == 6) {
					break;
				}
				
				ruleta.dineroApostado();
				
				int apuesta = sc.nextInt();
				
				if (apuesta > rule.saldo) {
					ruleta.saldoInsuficiente();
					continue;
				}			
				
				int bolita = rule.tirarBolita();
				
				boolean victoria = false;
				
				String colores = rule.color();
				
				switch(opcion) {
					case 1 -> {
						ruleta.menuColor();
						String colorApostado = sc.next().toLowerCase();					
						victoria = rule.apostarColor(apuesta, colorApostado);
					}
					
					case 2 -> {
						ruleta.menuNum();
						int numApostado = sc.nextInt();			
						victoria = rule.apostarNumero(apuesta, numApostado);
					}
					
					case 3 -> {
						ruleta.menuPar();
						String parImpar = sc.next().toLowerCase();
						victoria = rule.apostarParImpar(apuesta, parImpar);
					}
					
					case 4 -> {
						ruleta.menuFila();
						int filaApostada = sc.nextInt();					
						victoria = rule.apostarFila(apuesta, filaApostada);
					}
					
					case 5 -> {					
						ruleta.menuDocenas();
						int docenaApostada = sc.nextInt();
						victoria = rule.apostarDocena(apuesta, docenaApostada);
					}
				}
				
				ruleta.resultado(bolita, colores, victoria);
			
			} catch (InputMismatchException e) {
				ruleta.error();
				sc.nextLine();
			}
			
		} while (rule.saldo > 0);
		
		if (rule.saldo <= 0) {
			ruleta.sinSaldo();
		}
		
		ruleta.fin(rule.saldo);		
	}

}