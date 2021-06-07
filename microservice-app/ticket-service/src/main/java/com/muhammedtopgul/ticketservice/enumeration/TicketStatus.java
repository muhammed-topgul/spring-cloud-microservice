package com.muhammedtopgul.ticketservice.enumeration;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:08
 */

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Acik"), IN_PROGRESS("Devam Ediyor"), RESOLVED("Cözüldü"), CLOSED("Kapali");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
