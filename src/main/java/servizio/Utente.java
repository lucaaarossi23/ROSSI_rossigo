package servizio;

public class Utente {
    private String ID;
    private String nome;
    private String email;
    private String codiceFiescale;
    private double credito;

    public Utente(String ID, String nome, String email, String codiceFiescale, double credito) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.codiceFiescale = codiceFiescale;
        this.credito = credito;
    }

    public String getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCodiceFiescale() {
        return codiceFiescale;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}
