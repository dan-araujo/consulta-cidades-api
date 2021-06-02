package br.com.daniel.arj.consultacidadesapi.cidades.servico;

public enum RaioDaTerra {
    METROS("m", 6378168),
    KILOMETROS("km", 6378.168f),
    MILHAS("mi", 3958.747716f);

    private final String unidade;
    private final float valor;

    RaioDaTerra(final String unidade, final float valor) {
        this.unidade = unidade;
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public float getValor() {
        return valor;
    }
}
