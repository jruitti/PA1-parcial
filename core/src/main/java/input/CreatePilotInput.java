package input;

import model.Pilot;

import java.time.LocalDate;
import java.util.UUID;

public interface CreatePilotInput {
    Boolean verifyPilot(String docuemnt);
    UUID savePilot(String name, String document, LocalDate brit);
}
