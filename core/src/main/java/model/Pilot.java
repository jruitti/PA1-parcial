package model;

import exception.ExceptionPilot;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Pilot {

    private UUID licencia;
    private String name;
    private String document;
    private LocalDate brit;

    public Pilot(UUID licencia,
                  String name,
                  String document,
                  LocalDate brit) {
        this.licencia = licencia;
        this.name = name;
        this.document = document;
        this.brit = brit;
    }

    public static Pilot createPilot(UUID licencia,
                             String name,
                             String document,
                             LocalDate brit){

        if (licencia == null) {
            throw new ExceptionPilot("Id del piloto nulo");
        }
        if (name == null || name.isBlank()) {
            throw new ExceptionPilot("El nombre no puede ser nulo");
        }
        if (document == null || document.isBlank()) {
            throw new ExceptionPilot("El documento no puede ser nulo");
        }
        if (document.length()<5 || document.length()> 10){
            throw new ExceptionPilot("Documento invalido");
        }
        if (Period.between(brit, LocalDate.now()).getYears() < 18) {
            throw new ExceptionPilot("El piloto no puede ser menor de edad");
        }
        if (brit.isAfter(LocalDate.now())){
            throw new ExceptionPilot("Fecha invalida");
        }

        return new Pilot(licencia, name, document, brit);
    }

    public UUID getLicencia() {
        return licencia;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBrit() {
        return brit;
    }
}
