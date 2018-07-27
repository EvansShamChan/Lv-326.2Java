package com.softserve.edu.cajillo.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "boards")
@ToString(exclude = "boardType")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "boards")
    private List<User> users = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private BoardType boardType;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "board")
    private List<TableList> tableLists = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<RoleManager> roleManagers = new ArrayList<>();

}