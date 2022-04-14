package in.dreamplug.demp.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import in.dreamplug.demo.unittest.domain.Card;
import in.dreamplug.demo.unittest.domain.CardType;
import in.dreamplug.demo.unittest.service.CardBuilderService;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
public class CardBuilderServiceTest {
    CardBuilderService cardBuilderService = new CardBuilderService(ThreadLocalRandom.current());

    @Test
    public void testBuildCard() {
        CardType cardType = CardType.black;
        Card card = cardBuilderService.buildCard(CardType.black);
        //notNull assertions
        assertNotNull(card.getCvv());
        assertNotNull(card.getNumber());
        assertEquals(cardType.getBrand(), card.getBrand());
        assertEquals(cardType, card.getCardType());
        assertEquals(cardType.getJoiningFee(), card.getJoiningFee());
        assertEquals(cardType.getRenewalFee(), card.getRenewalFee());
        /*
         * How can we validate values assigned to cvv, number
         * */
    }
}
