package usecase;

import exception.ExceptionPilot;
import exception.ExceptionRepo;
import input.CreatePilotInput;
import model.Pilot;
import output.SavePilotRepo;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePilot implements CreatePilotInput {

    private SavePilotRepo savePilotRepo;

    public CreatePilot (SavePilotRepo savePilotRepo){
        this.savePilotRepo = savePilotRepo;
    }

    @Override
    public Boolean verifyPilot(String docuemnt) {
        if (savePilotRepo.existPilot(docuemnt)){
            throw new ExceptionRepo("El piloto ya existe");
        }
        return false;
    }

    @Override
    public UUID savePilot(String name, String document, LocalDate brit) {
        verifyPilot(document);
        UUID licencia = UUID.randomUUID();
        Pilot newPilot = Pilot.createPilot(licencia,
                    name,
                    document,
                    brit);
        if (!savePilotRepo.savePilot(newPilot)){
            throw new ExceptionRepo("Fallo al guardar");
        }
        return licencia;
    }
}
