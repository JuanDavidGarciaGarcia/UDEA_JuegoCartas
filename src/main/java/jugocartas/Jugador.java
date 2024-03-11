package jugocartas;

import java.util.Random;
import javax.swing.JPanel;

public class Jugador {

    private int TOTAL_CARTAS = 10;
    private int MARGEN = 20;
    private int DISTANCIA = 50;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];

    private Random r = new Random();

    public void repartir() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        int x = MARGEN;

        //recorrido objtual por una lista de objetos
        for (Carta c : cartas) {
            c.mostrar(pnl, x, MARGEN);
            x += DISTANCIA;
        }

        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No se encuentran grupos";
        int[] contadores = new int[NombreCarta.values().length];
        for (Carta c : cartas) {
            contadores[c.getNombreCarta().ordinal()]++;
        }
        
        int totalGrupos = 0;
        for(int c: contadores){
            if(c>= 2) {
                totalGrupos++;
            }
        }
        if(totalGrupos>0){
            mensaje = "Los grupos encontrados fueron:\n";
            for(int i = 0; i<contadores.length; i++){
                if (contadores[i] >= 2){
                    mensaje += Grupos.values()[contadores[i]]+" de "+ NombreCarta.values()[i] + "\n";
                }
            }
        }
                
        return mensaje;
    }
}
