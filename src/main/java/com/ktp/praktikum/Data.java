/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktp.praktikum;

import java.io.Serializable;
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
@Table(name = "data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findById", query = "SELECT d FROM Data d WHERE d.id = :id"),
    @NamedQuery(name = "Data.findByNama", query = "SELECT d FROM Data d WHERE d.nama = :nama"),
    @NamedQuery(name = "Data.findByAgama", query = "SELECT d FROM Data d WHERE d.agama = :agama"),
    @NamedQuery(name = "Data.findByAlamat", query = "SELECT d FROM Data d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Data.findByJeniskelamin", query = "SELECT d FROM Data d WHERE d.jeniskelamin = :jeniskelamin"),
    @NamedQuery(name = "Data.findByNoktp", query = "SELECT d FROM Data d WHERE d.noktp = :noktp"),
    @NamedQuery(name = "Data.findByTgllahir", query = "SELECT d FROM Data d WHERE d.tgllahir = :tgllahir"),
    @NamedQuery(name = "Data.findByStatus", query = "SELECT d FROM Data d WHERE d.status = :status"),
    @NamedQuery(name = "Data.findByKewarganegaraan", query = "SELECT d FROM Data d WHERE d.kewarganegaraan = :kewarganegaraan"),
    @NamedQuery(name = "Data.findByBerlakuhingga", query = "SELECT d FROM Data d WHERE d.berlakuhingga = :berlakuhingga"),
    @NamedQuery(name = "Data.findByPekerjaan", query = "SELECT d FROM Data d WHERE d.pekerjaan = :pekerjaan")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "agama")
    private String agama;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "jeniskelamin")
    private String jeniskelamin;
    @Column(name = "noktp")
    private String noktp;
    @Column(name = "tgllahir")
    @Temporal(TemporalType.DATE)
    private Date tgllahir;
    @Column(name = "status")
    private String status;
    @Column(name = "kewarganegaraan")
    private String kewarganegaraan;
    @Column(name = "berlakuhingga")
    private String berlakuhingga;
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public Data() {
    }

    public Data(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getBerlakuhingga() {
        return berlakuhingga;
    }

    public void setBerlakuhingga(String berlakuhingga) {
        this.berlakuhingga = berlakuhingga;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ktp.praktikum.Data[ id=" + id + " ]";
    }
    
}
