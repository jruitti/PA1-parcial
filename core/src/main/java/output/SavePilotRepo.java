package output;

import model.Pilot;

import java.util.UUID;

public interface SavePilotRepo {
    Boolean existPilot(String docuemnto);
    Boolean savePilot(Pilot pilot);

}
