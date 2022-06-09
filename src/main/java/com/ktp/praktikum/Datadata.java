/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktp.praktikum;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SWMahardhika
 */
@Entity
@Table(name = "datadata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datadata.findAll", query = "SELECT d FROM Datadata d"),
    @NamedQuery(name = "Datadata.findById", query = "SELECT d FROM Datadata d WHERE d.id = :id"),
    @NamedQuery(name = "Datadata.findByNama", query = "SELECT d FROM Datadata d WHERE d.nama = :nama"),
    @NamedQuery(name = "Datadata.findByTanggal", query = "SELECT d FROM Datadata d WHERE d.tanggal = :tanggal"),
    @NamedQuery(name = "Datadata.findByKewarganegaraan", query = "SELECT d FROM Datadata d WHERE d.kewarganegaraan = :kewarganegaraan")})
public class Datadata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Lob
    @Column(name = "gambar")
    private String gambar;
    @Column(name = "kewarganegaraan")
    private String kewarganegaraan;

    public Datadata() {
    }

    public Datadata(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datadata)) {
            return false;
        }
        Datadata other = (Datadata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ktp.praktikum.Datadata[ id=" + id + " ]";
    }

}
