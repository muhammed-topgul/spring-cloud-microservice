package com.muhammedtopgul.ticketservice.entity;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:04
 */

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
