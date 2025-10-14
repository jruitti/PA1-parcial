package usecase;

import com.sun.source.tree.AssertTree;
import exception.ExceptionPilot;
import exception.ExceptionRepo;
import model.Pilot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import output.SavePilotRepo;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreatePilotTest {

    @Mock
    SavePilotRepo repo;
    @InjectMocks
    CreatePilot useCase;

    @Test
    void createPilot() {
        when(repo.existPilot("123456ABC")).thenReturn(false);
        when(repo.savePilot(any(Pilot.class))).thenReturn(true);

        UUID save = useCase.savePilot("Franco",
                "123456ABC",
                LocalDate.of(2004, 6, 15));

        Assertions.assertNotNull(save);
        verify(repo).existPilot("123456ABC");
        verify(repo).savePilot(any(Pilot.class));
    }

    @Test
    void createPilot_exist() {
        when(repo.existPilot("123456ABC")).thenReturn(true);

        Assertions.assertThrows(ExceptionRepo.class,
                () -> useCase.savePilot("Franco",
                "123456ABC",
                LocalDate.of(2004, 6, 15)));

        verify(repo).existPilot("123456ABC");
    }

    @Test
    void createPilot_FailRepo() {
        when(repo.existPilot("123456ABC")).thenReturn(false);
        when(repo.savePilot(any(Pilot.class))).thenReturn(false);

        Assertions.assertThrows(ExceptionRepo.class,
                () -> useCase.savePilot("Franco",
                "123456ABC",
                LocalDate.of(2004, 6, 15)));

        verify(repo).existPilot("123456ABC");
        verify(repo).savePilot(any(Pilot.class));
    }

}
