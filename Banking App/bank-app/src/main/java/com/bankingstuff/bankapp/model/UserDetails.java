package com.bankingstuff.bankapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    
@Id
@Column(name = "USERINFO_ID", nullable=false)
@GeneratedValue(strategy=GenerationType.AUTO)
private Long userInfoId;

private String address;
private String phoneNumber;


}
