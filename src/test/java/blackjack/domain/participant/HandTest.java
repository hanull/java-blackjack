package blackjack.domain.participant;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.carddeck.Card;
import blackjack.domain.carddeck.Number;
import blackjack.domain.carddeck.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HandTest {

    @Test
    @DisplayName("손패에 카드 추가 테스트")
    void testAddCardInHand() {
        Hand hand = new Hand();
        hand.addCard(Card.valueOf(Pattern.DIAMOND, Number.TWO));
        assertThat(hand.totalScore()).isEqualTo(2);
    }

    @Test
    @DisplayName("손패 점수 총합 테스트")
    void testHandsTotalScore() {
        Hand hand = new Hand();
        hand.addCard(Card.valueOf(Pattern.CLOVER, Number.EIGHT));
        hand.addCard(Card.valueOf(Pattern.CLOVER, Number.NINE));
        hand.addCard(Card.valueOf(Pattern.CLOVER, Number.QUEEN));
        assertThat(hand.totalScore()).isEqualTo(27);
    }

    @Test
    @DisplayName("SoftAce에서 HardAce로 자동변환 테스트")
    void testAceAutoChange() {
        Hand hand = new Hand();
        hand.addCard(Card.valueOf(Pattern.DIAMOND, Number.ACE));
        hand.addCard(Card.valueOf(Pattern.CLOVER, Number.ACE));
        hand.addCard(Card.valueOf(Pattern.HEART, Number.ACE));
        assertThat(hand.totalScore()).isEqualTo(13);
    }
}
