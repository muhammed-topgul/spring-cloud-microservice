package com.muhammedtopgul.servicecommon.client.contract;

/*
 * created by Muhammed Topgul
 * on 09/06/2021
 * at 22:33
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;
    private String username;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;

    public String getNameAndSurname() {
        return this.name + " " + this.surname;
    }
}