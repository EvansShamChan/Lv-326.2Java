package com.softserve.edu.cajillo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "table_lists")
@EqualsAndHashCode(callSuper = false)
public class TableList extends DateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Instant createTime;
    private Instant updateTime;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Board board;

    @OneToOne(fetch = FetchType.LAZY)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "tableList")
    private List<Ticket> tickets = new ArrayList<>();

}