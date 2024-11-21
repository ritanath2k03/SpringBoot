package com.ritanath.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Component;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "appUser" , cascade = CascadeType.ALL)
    private List<Borrowing> borrowings;

  

}
