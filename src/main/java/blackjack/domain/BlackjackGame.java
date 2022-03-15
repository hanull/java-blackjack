package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Participant;
import blackjack.domain.player.Player;
import blackjack.domain.player.Players;
import java.util.List;

public class BlackjackGame {

    private final CardDeck cardDeck;
    private final Players players;
    private final Dealer dealer;

    private BlackjackGame(final CardDeck cardDeck, final Players players, final Dealer dealer) {
        this.cardDeck = cardDeck;
        this.players = players;
        this.dealer = dealer;
    }

    public static BlackjackGame create(final List<String> playerNames, CardDeck cardDeck) {
        return new BlackjackGame(cardDeck, setUpPlayers(playerNames, cardDeck), setUpDealer(cardDeck));
    }

    private static Players setUpPlayers(final List<String> playerNames, final CardDeck cardDeck) {
        return Players.of(playerNames, cardDeck);
    }

    private static Dealer setUpDealer(final CardDeck cardDeck) {
        return new Dealer(cardDeck.drawInitialCards());
    }

    public void hit(final Participant participant) {
        participant.hit(drawCard());
    }

    private Card drawCard() {
        return cardDeck.draw();
    }

    public ParticipantResult findGameResult() {
        return ParticipantResult.create(dealer, players.getPlayers());
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public Dealer getDealer() {
        return dealer;
    }
}
