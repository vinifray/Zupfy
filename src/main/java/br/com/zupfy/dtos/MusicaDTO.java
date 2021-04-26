package br.com.zupfy.dtos;

import br.com.zupfy.models.Banda;
import br.com.zupfy.models.Musica;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MusicaDTO {

    private Integer id;
    private String nomeMusica;
    private LocalTime duracao;
    private String enderecoMusica;
    private BandaDTO banda;
    private AlbumResumeDTO album;

    public MusicaDTO() {
    }

    public BandaDTO getBanda() {
        return banda;
    }

    public AlbumResumeDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumResumeDTO album) {
        this.album = album;
    }

    public void setBanda(BandaDTO banda) {
        this.banda = banda;
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
        musicaDTO.setBanda(BandaDTO.conveterModelParaDTO(musica.getBanda()));

        return musicaDTO;
    }

    public static MusicaDTO converterModelParaComAlbumDTO(Musica musica){
        MusicaDTO musicaDTO = converterModelParaDTO(musica);
        musicaDTO.setAlbum(AlbumResumeDTO.converterModelParaDTO(musica.getAlbum()));

        return musicaDTO;
    }

    public static Iterable<MusicaDTO> converterIterableModelParaDTO(Iterable<Musica> musicas){
        List<MusicaDTO> musicaDTOS = new ArrayList<>();

        for(Musica musica : musicas){
            musicaDTOS.add(converterModelParaComAlbumDTO(musica));
        }

        return musicaDTOS;
    }
}
