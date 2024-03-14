package com.aythee.datingapp.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String error;
    private String description;
}
