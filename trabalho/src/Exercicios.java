public class Exercicios {
    private String nomeexr;
    private String musculoAlvo;
    private int series;
    private int repeticoes;

    public Exercicios(String nomeexr, String musculoAlvo, int series, int repeticoes) {
        this.nomeexr = nomeexr;
        this.musculoAlvo = musculoAlvo;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNomeexr() {
        return nomeexr;
    }
    public void setNomeexr(String nomeexr) {
        this.nomeexr = nomeexr;
    }

    public String getMusculoAlvo() {
        return musculoAlvo;
    }
    public void setMusculoAlvo(String musculoAlvo) {
        this.musculoAlvo = musculoAlvo;
    }

    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }
    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return nomeexr + " (" + musculoAlvo + ") - " + series + "x" + repeticoes;
    }
}
