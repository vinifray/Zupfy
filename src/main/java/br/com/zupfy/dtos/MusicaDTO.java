package br.com.zupfy.dtos;

import br.com.zupfy.models.Musica;

import java.time.LocalTime;

public class MusicaDTO {

    private Integer id;
    private String nomeMusica;
    private LocalTime duracao;
    private String enderecoMusica;

    public MusicaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static MusicaDTO converterModelParaDTO(Musica musica){
        MusicaDTO musicaDTO = new MusicaDTO();

        musicaDTO.setNomeMusica(musica.getNomeMusica());
        musicaDTO.setEnderecoMusica(musica.getEnderecoMusica());
        musicaDTO.setId(musica.getId());
        musicaDTO.setDuracao(musica.getDuracao());

        return musicaDTO;
    }
}
