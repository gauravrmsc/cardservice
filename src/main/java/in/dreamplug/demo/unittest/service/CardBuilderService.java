package in.dreamplug.demo.unittest.service;

import java.util.concurrent.ThreadLocalRandom;
import in.dreamplug.demo.unittest.domain.Card;
import in.dreamplug.demo.unittest.domain.CardType;
import lombok.AllArgsConstructor;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
@AllArgsConstructor
public class CardBuilderService {
    ThreadLocalRandom r;

    public Card buildCard(CardType cardType) {
        Long cardNumber = r.nextLong(1_000_000_000_000_000l, 9_999_999_999_999_999l);
        Integer cvv = r.nextInt(100, 999);
        cardNumber = r.nextLong(1_000_000_000_000_000l, 9_999_999_999_999_999l);
        return Card.builder().cardType(cardType).brand(cardType.getBrand()).number(cardNumber.toString()).cvv(cvv.toString())
                   .joiningFee(cardType.getJoiningFee()).renewalFee(cardType.getRenewalFee()).build();
    }
}
