package org.example.graphqlordersmanagment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponse {

    private String status;
    private String message;
}
