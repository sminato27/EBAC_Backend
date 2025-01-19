public class MP3 {

    private boolean botaoLigarEDesligar;
    private String musica;
    private boolean botaoStartEPause;
    private int volume;
    private boolean botaoVoltar;
    private boolean botaoAvancar;

    public boolean isBotaoLigarEDesligar() {
        return botaoLigarEDesligar;
    }

    public void setBotaoLigarEDesligar(boolean botaoLigarEDesligar) {
        this.botaoLigarEDesligar = botaoLigarEDesligar;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public boolean isBotaoStartEPause() {
        return botaoStartEPause;
    }

    public void setBotaoStartEPause(boolean botaoStartEPause) {
        this.botaoStartEPause = botaoStartEPause;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isBotaoVoltar() {
        return botaoVoltar;
    }

    public void setBotaoVoltar(boolean botaoVoltar) {
        this.botaoVoltar = botaoVoltar;
    }

    public boolean isBotaoAvancar() {
        return botaoAvancar;
    }

    public void setBotaoAvancar(boolean botaoAvancar) {
        this.botaoAvancar = botaoAvancar;
    }

    /**
     * Método que retorna o valor/nível atual do volume.
     *
     * @param count Valor do volume
     * @return
     */
    public int valorVolume (int count) {
        return 10;
    }

}
