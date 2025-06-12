package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PatientMapperTest {

    private static final String NAME = "Alex";
    private static final String EMAIL = "random-string@email.com";
    private static final String ADDRESS = "123 Main St, Springfield";
    private static final String DATE_OF_BIRTH = "1985-06-15";
    private static final String REGISTERED_DATE = "2024-01-10";

    @Test
    void shouldReturnValidPatientResponseDTO() {

        Patient patient = new Patient();
        patient.setId(UUID.randomUUID());
        patient.setName(NAME);
        patient.setEmail(EMAIL);
        patient.setAddress(ADDRESS);
        patient.setDateOfBirth(LocalDate.parse(DATE_OF_BIRTH));
        patient.setRegisteredDate(LocalDate.parse(REGISTERED_DATE));

        PatientResponseDTO patientResponseDTO = PatientMapper.INSTANCE.patientToDto(patient);

        assertEquals(patient.getId().toString(), patientResponseDTO.id());
        assertEquals(patient.getName(), patientResponseDTO.name());
        assertEquals(patient.getEmail(), patientResponseDTO.email());
        assertEquals(patient.getAddress(), patientResponseDTO.address());
        assertEquals(patient.getDateOfBirth().toString(), patientResponseDTO.dateOfBirth());

    }

    @Test
    public void shouldReturnValidPatientEntity() {

        PatientRequestDTO patientRequestDTO = new PatientRequestDTO(
                NAME,EMAIL,ADDRESS,DATE_OF_BIRTH,REGISTERED_DATE
        );

        Patient patientEntity = PatientMapper.INSTANCE.patientRequestDtoToEntity(patientRequestDTO);

        assertEquals(patientEntity.getName(), patientRequestDTO.name());
        assertEquals(patientEntity.getEmail(), patientRequestDTO.email());
        assertEquals(patientEntity.getAddress(), patientRequestDTO.address());
        assertEquals(patientEntity.getDateOfBirth().toString(), patientRequestDTO.dateOfBirth());
        assertEquals(patientEntity.getRegisteredDate().toString(), patientRequestDTO.registeredDate());

    }

}