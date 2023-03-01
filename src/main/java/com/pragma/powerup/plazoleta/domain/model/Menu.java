package com.pragma.powerup.plazoleta.domain.model;

public class Menu {
    private Long pagina;
    private Long numeroRegistros;
    private Long idRestaurantes;

    public Long getPagina() {
        return pagina;
    }

    public void setPagina(Long pagina) {
        this.pagina = pagina;
    }

    public Long getNumeroRegistros() {
        return numeroRegistros;
    }

    public void setNumeroRegistros(Long numeroRegistros) {
        this.numeroRegistros = numeroRegistros;
    }

    public Long getIdRestaurantes() {
        return idRestaurantes;
    }

    public void setIdRestaurantes(Long idRestaurantes) {
        this.idRestaurantes = idRestaurantes;
    }
}
