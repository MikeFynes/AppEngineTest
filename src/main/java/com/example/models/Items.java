/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.Size;


import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByEntryID", query = "SELECT i FROM Items i WHERE i.entryID = :entryID"),
    @NamedQuery(name = "Items.findByDriveID", query = "SELECT i FROM Items i WHERE i.driveID = :driveID"),
    @NamedQuery(name = "Items.findByTitle", query = "SELECT i FROM Items i WHERE i.title = :title"),
    @NamedQuery(name = "Items.findByLink", query = "SELECT i FROM Items i WHERE i.link = :link")})
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entryID")
    private Integer entryID;
    @Size(max = 255)
    @Column(name = "driveID")
    private String driveID;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "link")
    private String link;

    public Items() {
    }

    public Items(Integer entryID) {
        this.entryID = entryID;
    }

    public Integer getEntryID() {
        return entryID;
    }

    public void setEntryID(Integer entryID) {
        this.entryID = entryID;
    }

    public String getDriveID() {
        return driveID;
    }

    public void setDriveID(String driveID) {
        this.driveID = driveID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryID != null ? entryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.entryID == null && other.entryID != null) || (this.entryID != null && !this.entryID.equals(other.entryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cin,exaample.models.Items[ entryID=" + entryID + " ]";
    }
    
}