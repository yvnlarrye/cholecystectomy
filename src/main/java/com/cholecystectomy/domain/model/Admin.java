package com.cholecystectomy.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table
@OnDelete(action = OnDeleteAction.CASCADE)
public class Admin extends User {

}
