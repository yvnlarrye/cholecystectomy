package com.cholecystectomy.domain.model;

import lombok.Getter;

@Getter
public enum Sex {
    MALE("Мужской"), FEMALE("Женский");

    private final String name;

    Sex(String name) {
        this.name = name;
    }

}
