package br.com.zupfy.dtos;

import br.com.zupfy.models.Banda;

public class BandaDTO {

    private int id;
    private String nome;
    private Integer nascimento;

    public BandaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNascimento() {
        return nascimento;
    }

    public void setNascimento(Integer nascimento) {
        this.nascimento = nascimento;
    }

    public static BandaDTO conveterModelParaDTO(Banda banda){
        BandaDTO bandaDTO = new BandaDTO();

        if(banda != null){
            bandaDTO.setId(banda.getId());
            bandaDTO.setNascimento(banda.getNascimento());
            bandaDTO.setNome(banda.getNome());
        }

        return bandaDTO;
    }
}
