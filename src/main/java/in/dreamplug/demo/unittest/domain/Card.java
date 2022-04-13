package in.dreamplug.demo.unittest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String number;

    private String cvv;

    private CardType cardType;

    private Brand brand;

    private Integer joiningFee;

    private Integer renewalFee;
}
