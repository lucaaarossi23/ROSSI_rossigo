package modello;

public class Bici extends Veicolo{
    private int numeroMarce;
    final double TARIFFA = 0.15;
    final double CONSUMO = 0.5;

    public int getNumeroMarce() {
        return numeroMarce;
    }

    public Bici(String codice, int livelloBatteria, String stato, int numeroMarce) {
        super(codice, livelloBatteria, stato);
        this.numeroMarce = numeroMarce;
    }

    @Override
    public double calcolaCosto(int minuti) {
        return TARIFFA * minuti;
    }

    @Override
    public double consumoBatteriaPerMinuto() {
        return CONSUMO;
    }

}
