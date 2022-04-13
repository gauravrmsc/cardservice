package in.dreamplug.demo.unittest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
@Getter
@Setter
@AllArgsConstructor
public class UserCard {
    private String userName;

    private Long creditLimit;

    private Card card;
}
