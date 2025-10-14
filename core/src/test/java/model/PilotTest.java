package model;

import exception.ExceptionPilot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class PilotTest {
    @Test
    void createPilot() {
        UUID licencia = UUID.randomUUID();
        Pilot pilot = Pilot.createPilot(licencia,
                "Franco",
                "123456ABC",
                LocalDate.of(2004, 6, 15));

        Assertions.assertEquals(licencia, pilot.getLicencia());
        Assertions.assertEquals("Franco", pilot.getName());
        Assertions.assertEquals("123456ABC", pilot.getDocument());
        Assertions.assertEquals(LocalDate.of(2004, 6, 15), pilot.getBrit());

    }

    @Test
    void createPilot_InvalidLicencia(){
        UUID licencia1 = null;
        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia1,
                "Franco",
                "123456ABC",
                LocalDate.of(2004, 6, 15)));
    }

    @Test
    void createPilot_InvalidName(){
        UUID licencia = UUID.randomUUID();
        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        "",
                        "123456ABC",
                        LocalDate.of(2004, 6, 15)));

        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        null,
                        "123456ABC",
                        LocalDate.of(2004, 6, 15)));
    }

    @Test
    void createPilot_InvalidDocuemnt(){
        UUID licencia = UUID.randomUUID();
        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        "Franco",
                        "",
                        LocalDate.of(2004, 6, 15)));

        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        "Franco",
                        null,
                        LocalDate.of(2004, 6, 15)));

        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        "Franco",
                        "9874345678909876",
                        LocalDate.of(2004, 6, 15)));

        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        "Franco",
                        "12",
                        LocalDate.of(2004, 6, 15)));
    }

    @Test
    void createPilot_InvalidBrit(){
        UUID licencia = UUID.randomUUID();
        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        "Franco",
                        "123456ABC",
                        LocalDate.of(2022, 6, 15)));

        Assertions.assertThrows(ExceptionPilot.class,
                () -> Pilot.createPilot(licencia,
                        "Franco",
                        "123456ABC",
                        LocalDate.of(2029, 6, 15)));

    }
}
