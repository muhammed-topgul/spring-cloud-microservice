package com.muhammedtopgul.ticketservice.enumeration;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:08
 */

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Acil"), LOW("Önemsiz"), HIGH("Öncelikli");

    private final String label;

    PriorityType(String label) {
        this.label = label;
    }
}
