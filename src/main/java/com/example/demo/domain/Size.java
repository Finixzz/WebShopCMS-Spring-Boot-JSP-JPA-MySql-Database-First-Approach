package com.example.demo.domain;

import javax.persistence.*;

@Entity(name="size")
@Table(name="size")
public class Size {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="sizeid",nullable=false)
    private int SizeId;

    @Column(name="size",nullable=false)
    private String Size;

    public Size(){
    }

    public int getSizeId() {
        return SizeId;
    }

    public void setSizeId(int sizeId) {
        SizeId = sizeId;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }
}
