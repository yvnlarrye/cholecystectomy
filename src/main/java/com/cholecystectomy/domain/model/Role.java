package com.cholecystectomy.domain.model;

public enum Role {
    ROLE_DOCTOR("Врач"), ROLE_PATIENT("Пациент"), ROLE_ADMIN("Администратор");

    Role(String name) {
    }
}
