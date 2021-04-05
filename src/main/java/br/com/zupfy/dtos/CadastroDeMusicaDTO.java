package br.com.zupfy.dtos;

import br.com.zupfy.models.Banda;
import br.com.zupfy.models.Musica;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class CadastroDeMusicaDTO {

    @NotBlank
    private String nomeMusica;
    @NotNull
    private LocalTime duracao;
    @NotBlank
    private String enderecoMusica;

    @NotNull(message = "Id da Banda é Obrigatório")
    private int bandaID;

    public CadastroDeMusicaDTO() {
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

    public String getEnderecoMusica() {
        return enderecoMusica;
    }

    public void setEnderecoMusica(String enderecoMusica) {
        this.enderecoMusica = enderecoMusica;
    }

    public int getBandaID() {
        return bandaID;
    }

    public void setBandaID(int bandaID) {
        this.bandaID = bandaID;
    }

    public Musica converterDTOParaModel(){
        Musica musica = new Musica();
        musica.setNomeMusica(this.nomeMusica);
        musica.setEnderecoMusica(this.enderecoMusica);
        musica.setDuracao(this.duracao);

        Banda banda = new Banda();
        banda.setId(this.bandaID);
        musica.setBanda(banda);

        return musica;
    }
}
