package com.ritanath.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Borrowing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;


    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate borrowingDate;

    private LocalDate dateMustReturnIn;

    private LocalDate actualReturnDate;

    private Integer paidFeesAmount;
}
