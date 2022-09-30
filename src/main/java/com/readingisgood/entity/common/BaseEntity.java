package com.readingisgood.entity.common;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_status", nullable = false)
    private Boolean recordStatus = Boolean.TRUE;

    @CreationTimestamp
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "created_user")
    private String createdUser;

    @UpdateTimestamp
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @Column(name = "updated_user")
    private String updatedUser;

    @Column(name = "statu")
    private String status;
}
