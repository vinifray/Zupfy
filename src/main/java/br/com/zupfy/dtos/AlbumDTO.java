package br.com.zupfy.dtos;

import br.com.zupfy.models.Album;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AlbumDTO {

    private Integer id;
    @NotBlank
    private String nome;
    @NotNull
    @Min(1000)
    private int anoLancamento;

    public AlbumDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Album converterDTOParaModel(){
        Album album = new Album();

        album.setAnoLancamento(this.anoLancamento);
        album.setNome(this.nome);
        album.setId(this.id);

        return album;
    }
}
