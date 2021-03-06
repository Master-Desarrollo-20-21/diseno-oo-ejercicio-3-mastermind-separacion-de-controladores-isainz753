package views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.console.ProposedCombinationView;
import usantatecla.utils.Console;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationViewTest {
    @Mock
    Console console;

    @Mock
    ProposalController proposalController;

    @InjectMocks
    ProposedCombinationView proposedCombinationView;

    @Test
    void testGivenColorsOfProposedCombinationWhenWriteThenCorrectColorsAreCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposedCombinationView = new ProposedCombinationView(this.proposalController);
            ArgumentCaptor<String> colorCaptor = ArgumentCaptor.forClass(String.class);
            when(this.proposalController.getColors(anyInt())).thenReturn(Arrays.asList(Color.BLUE, Color.ORANGE, Color.PURPLE, Color.GREEN));

            this.proposedCombinationView.write(0);
            verify(this.console, times(4)).write(colorCaptor.capture());

            String reset_color = "\u001B[0m";
            assertThat(colorCaptor.getAllValues().get(0), is("\u001B[34mb" + reset_color));
            assertThat(colorCaptor.getAllValues().get(1), is("\u001B[37mo" + reset_color));
            assertThat(colorCaptor.getAllValues().get(2), is("\u001B[35mp" + reset_color));
            assertThat(colorCaptor.getAllValues().get(3), is("\u001B[32mg" + reset_color));
        }
    }

    @Test
    void testGivenInputColorsWhenReadThenCorrectColorsAreReturned() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString("Propose a combination: ")).thenReturn("rgby");
            assertThat(this.proposedCombinationView.read(), is(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)));
        }
    }
}
