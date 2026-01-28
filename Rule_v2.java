package ruleta;

public class Rule_v2 {
	
	final String ROJO = "rojo";
	final String NEGRO = "negro";
	final String VERDE = "verde";
	
	final String[] COLORES = {VERDE,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO,NEGRO,ROJO};
	
	int saldo;
	int bolita;
	String colorBolita;
	
	int miSaldo(int saldoIntroducido) {
		
		saldo = saldo + saldoIntroducido;
		return saldo;
		
	}
	
	int tirarBolita() {
		
		this.bolita = (int) (Math.random() * 37);
		return this.bolita;
		
	}
	
	String color() {
		
		this.colorBolita = COLORES[this.bolita];
		return this.colorBolita;
		
	}
		
	boolean apostarColor (int apuesta, String colorApostado) {
		
		saldo = saldo - apuesta;
		
		switch(colorApostado) {
			case NEGRO -> {
				if (this.colorBolita.equals(NEGRO)) {
					saldo = saldo + (apuesta*2);
					return true;
				}
			}
			case ROJO -> {
				if (this.colorBolita.equals(ROJO)) {
					saldo = saldo + (apuesta*2);
					return true;
				}
			}
			case VERDE -> {
				if (this.colorBolita.equals(VERDE)) {
					saldo = saldo + (apuesta*2);
					return true;
				}
			}
		}
		
		return false;
	}
	
	boolean apostarNumero (int apuesta, int numApostado) {
		
		saldo = saldo - apuesta;
		
		if (numApostado == this.bolita) {
			saldo = saldo + (apuesta * 36);
			return true;
		}
		
		return false;
	}
	
	boolean apostarParImpar (int apuesta, String parImpar) {
		
		saldo = saldo - apuesta;
		
		switch(parImpar) {
			case "par" -> {
				if (this.bolita % 2 == 0 && this.bolita != 0) {
					saldo = saldo + (apuesta*2);
					return true;
				}
			}
			case "impar" -> {
				if (this.bolita % 2 != 0) {
					saldo = saldo + (apuesta*2);
					return true;
				}
			}
		}
		
		return false;
	}
	
	boolean apostarFila (int apuesta, int filaApostada) {
		
		saldo = saldo - apuesta;
		
		switch(filaApostada) {
			case 1 -> {
				if (this.bolita != 0 && this.bolita % 3 == 1) {
					saldo = saldo + (apuesta * 3);
					return true;
				}
			}
			case 2 -> {
				if (this.bolita != 0 && this.bolita % 3 == 2) {
					saldo = saldo + (apuesta * 3);
					return true;
				}
			}
			case 3 -> {
				if (this.bolita != 0 && this.bolita % 3 == 0) {
					saldo = saldo + (apuesta * 3);
					return true;
				}
			}
		}
		
		return false;
	}
	
	boolean apostarDocena (int apuesta, int docenaApostada) {
		
		saldo = saldo - apuesta;
		
		switch(docenaApostada) {
			case 1 -> {
				if(this.bolita > 0 && this.bolita <=12) {
					saldo = saldo + (apuesta * 3);
					return true;
				}
			}
			case 2 -> {
				if(this.bolita > 12 && this.bolita <=24) {
					saldo = saldo + (apuesta * 3);
					return true;
				}
			}
			case 3 -> {
				if(this.bolita > 24 && this.bolita <=36) {
					saldo = saldo + (apuesta * 3);
					return true;
				}
			}
		}
		
		return false;		
	}
}