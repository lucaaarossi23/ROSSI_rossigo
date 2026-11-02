package modello;

public class Monopattino extends Veicolo {
    final double TARIFFA = 0.15;
    final double CONSUMO = 0.5;

    public Monopattino(String codice, int livelloBatteria, String stato) {
        super(codice, livelloBatteria, stato);
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
