package com.pm.patientservice.dto;

import lombok.Getter;
import lombok.Setter;

public record PatientResponseDTO(String id,
                                 String name,
                                 String email,
                                 String address,
                                 String dateOfBirth) {
}
