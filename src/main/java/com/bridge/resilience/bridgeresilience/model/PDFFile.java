package com.bridge.resilience.bridgeresilience.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "pdftable")
public class PDFFile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @Column(name="file_name")
    private String fileName;

    @Lob
    @Column(name="pdffile")
    private byte[] data;

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PDFFile() {

    }

    public PDFFile(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

}
