package in.dreamplug.demo.unittest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
@Getter
@AllArgsConstructor
public enum CardType {
    black(10_000, 10_000, Brand.Visa),
    white(3_0000, 3_000, Brand.Visa);

    private Integer joiningFee;

    private Integer renewalFee;

    private Brand brand;
}
