package es.jacaranda.model;

import java.util.ArrayList;


public class Play {
	
	
	// Número de jugadas que tiene una partida.
	private int numPlays;
	
	
	// Iremos guardando quien va guardando las partidas.
	// 0=WINMACHINE gana la máquina
	// 1=WINPLAYER gana el jugador
	private final int WINMACHINE=0;
	private final int WINPLAYER = 1;
	private ArrayList<Integer> playsWin;
	
	// Guardaremos la tirada actual del jugador y la máquina
	private ArrayList<Integer> dieOfRollMachine;
	private ArrayList<Integer> dieOfRollPlayer;
	
		
	
	public Play(int numPlays) {
		this.numPlays= numPlays;
		this.dieOfRollMachine = new ArrayList<Integer>();
		this.dieOfRollPlayer = new ArrayList<Integer>();
		this.playsWin = new ArrayList<Integer>();
	}
	
	
	/**
	 * Función que devuelve la puntuación del jugador 
	 * @return
	 */
	
	public int pointOfPlayer() {
		int result=0;
		for (int i: dieOfRollPlayer) {
			result+= i;
		}
		return result;
	}
	
	/**
	 * función que devuelve la puntuación de la máquina
	 * @return
	 */
	
	public int pointOfMachine() {
		int result=0;
		for (int i: dieOfRollMachine) {
			result+= i;
		}
		return result;
	}
	
	/**
	 * Cuando juega la máquina tiene que tirar hasta que le gane al jugador
	 * o hasta que pierda.
	 * Luego debe actualizar la lista de partidas ganadas
	 *  
	 */
	public void playMachine() {
		boolean fall= false;
		// Parará cuando gane o cuando salga un 1
		while (this.pointOfPlayer() >= this.pointOfMachine() && !fall ) {
			this.dieOfRollMachine.add(this.rollOfDie());
			if (this.dieOfRollMachine.get(this.dieOfRollMachine.size()-1)== 1)
				fall=true;
		}
		// Si falla la máquina es que gana el jugador
		if (fall) {
			this.playsWin.add(WINPLAYER);
		}else {
			this.playsWin.add(WINMACHINE);
		}
		
	}
	
	/**
	 * Esto se llamará cuando se inicie el juego, que deberá empezar el jugador
	 * Debe poner las listas de las tiradas a "cero" y tirar el jugado.
	 * Si el jugador saca un uno deberá decir que ha terminado la jugada,
	 * para lo que devuelve false.
	 * Devuelve true si el jugador ha sacado cualquier número menos el uno
	 * @return
	 *     True: puede seguir jugando.
	 *     False: no puede seguir jugando.
	 */
	public void newPlay() {
		this.dieOfRollMachine.clear();
		this.dieOfRollPlayer.clear();
			
	}
	
	/**
	 * Método que determina si la partida ha terminado. 
	 * Terminará cuando se jueguen todos los juegos de la partida
	 * @return
	 *     True si ha terminado
	 *     False si no ha termiando
	 */
	public boolean isFinished() {
		if (this.numPlays == this.playsWin.size()) {
			
			return true;
		}
			
		else
			return false;
		
	}
	
	/**
	 * Devuelve un array con los ganadores de las partidas jugadas
	 * @return
	 */
	public ArrayList<String> getWinner() {
		ArrayList<String> result= new ArrayList<String>();
		int numPartida=1;
		for (int i: this.playsWin) {
			result.add("El ganador de la partida " + numPartida++ + "es " + ((i==0)?"la máquina":"el usuario") );
		}
		return result;
	}
	
	/**
	 * Devuelve un array con los dados que han salido en la partida del jugado
	 * @return
	 */
	public ArrayList<String> getRollesPlayer(){
		ArrayList<String> result= new ArrayList<String>();
		for (int i: this.dieOfRollPlayer) {
			result.add("" + i + ".png");
		}
		return result;
	}
	
	/**
	 * Devuelve un array con los dados que han salido en la partida de la máquina
	 * @return
	 */
	public ArrayList<String> getRollesMachine(){
		ArrayList<String> result= new ArrayList<String>();
		for (int i: this.dieOfRollMachine) {
			result.add("" + i + ".png");
		}
		return result;
	}
	
	
	
	/**
	 * Esto se llamará cuando el jugador quiera seguir tirando. 
	 * Debe actualizar su lista de tiradas
	 *  * Si el jugador saca un uno deberá decir que ha terminado la jugada,
	 * para lo que devuelve false.
	 * Devuelve true si el jugador ha sacado cualquier número menos el uno
	 * @return
	 *     True: puede seguir jugando
	 *     False: no puede seguir jugando porque ha perdido
	 */
	public boolean playPlayer() {
		this.dieOfRollPlayer.add(this.rollOfDie());
		if (this.dieOfRollPlayer.get(dieOfRollPlayer.size()-1)== 1) {
			this.playsWin.add(WINMACHINE);
			return false;
		}
		else {
			
			return true;
		}
		
	}

	/**
	 * Tirada de un dado
	 * @return la cara del dado
	 */
	private int rollOfDie() {
		return (int) (Math.random()*6+1);
	}
	
	
	
	
}
