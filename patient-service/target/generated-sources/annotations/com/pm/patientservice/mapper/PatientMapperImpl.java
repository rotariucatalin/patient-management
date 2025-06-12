package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T10:58:02+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientResponseDTO patientToDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String email = null;
        String address = null;
        String dateOfBirth = null;

        if ( patient.getId() != null ) {
            id = patient.getId().toString();
        }
        name = patient.getName();
        email = patient.getEmail();
        address = patient.getAddress();
        if ( patient.getDateOfBirth() != null ) {
            dateOfBirth = DateTimeFormatter.ISO_LOCAL_DATE.format( patient.getDateOfBirth() );
        }

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO( id, name, email, address, dateOfBirth );

        return patientResponseDTO;
    }

    @Override
    public Patient patientRequestDtoToEntity(PatientRequestDTO patientRequestDTO) {
        if ( patientRequestDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setName( patientRequestDTO.name() );
        patient.setEmail( patientRequestDTO.email() );
        patient.setAddress( patientRequestDTO.address() );
        if ( patientRequestDTO.dateOfBirth() != null ) {
            patient.setDateOfBirth( LocalDate.parse( patientRequestDTO.dateOfBirth() ) );
        }
        if ( patientRequestDTO.registeredDate() != null ) {
            patient.setRegisteredDate( LocalDate.parse( patientRequestDTO.registeredDate() ) );
        }

        return patient;
    }
}
