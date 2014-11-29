package com.fabrefrederic.metier.musicManager.implementation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author frederic.fabre
 * 
 */
@Entity
@Table(name = "track")
@Component
public class Track implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -17295649203002122L;

    /** Id */
    @Id
    @GeneratedValue
    @Column(name = "track_id")
    private Integer id;

    /** Name */
    @Column(name = "track_name")
    private String name;

    /** Genre */
    @Column(name = "track_genre")
    private String genre;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(final String genre) {
        this.genre = genre;
    }

}