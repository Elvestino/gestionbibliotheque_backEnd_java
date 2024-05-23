package com.bibliotheque.gestionbibliotheque.dto;

public class EmpruntRequestDTO {
    private Long adherentId;
    private Long livreId;
    private int joursEmprunt;

    // Getters and setters
    public Long getAdherentId() {
        return adherentId;
    }

    public void setAdherentId(Long adherentId) {
        this.adherentId = adherentId;
    }

    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }

    public int getJoursEmprunt() {
        return joursEmprunt;
    }

    public void setJoursEmprunt(int joursEmprunt) {
        this.joursEmprunt = joursEmprunt;
    }
}
