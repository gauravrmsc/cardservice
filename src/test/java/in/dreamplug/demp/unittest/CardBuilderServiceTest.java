package in.dreamplug.demp.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import in.dreamplug.demo.unittest.domain.Card;
import in.dreamplug.demo.unittest.domain.CardType;
import in.dreamplug.demo.unittest.service.CardBuilderService;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
@ExtendWith (MockitoExtension.class)
public class CardBuilderServiceTest {
    @InjectMocks
    CardBuilderService cardBuilderService;

    @Mock
    ThreadLocalRandom threadLocalRandom;

    @Test
    public void testBuildCard() {
        CardType cardType = CardType.black;
        /*
         * can use any() when argument is dynamic
         * */
        when(threadLocalRandom.nextInt(eq(100), eq(999))).thenReturn(255);
        Card card = cardBuilderService.buildCard(CardType.black);
        assertEquals("255", card.getCvv());
        verify(threadLocalRandom, times(1)).nextInt(eq(100), eq(999));
        //TODO add mocks for number
        assertNotNull(card.getNumber());
        assertEquals(cardType.getBrand(), card.getBrand());
        assertEquals(cardType, card.getCardType());
        assertEquals(cardType.getJoiningFee(), card.getJoiningFee());
        assertEquals(cardType.getRenewalFee(), card.getRenewalFee());
    }
}


/*
 * Mocks are the keys to find the needle in the hey-stack and are extremely helpful while performing regressions.
 * Mocks can also be useful when the dependencies are yet not ready and one need to test the built component.
 *
 * */

/*
* We can create plugins for JUnit using JUnit Extensions.
* Eg: MockitoExtension, CommonsTest framework
* */