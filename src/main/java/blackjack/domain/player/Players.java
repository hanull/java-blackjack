package blackjack.domain.player;

import blackjack.domain.CardDeck;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_COUNT_TO_PLAY_GAME = 1;
    private static final int MAX_PLAYER_COUNT_TO_PLAY_GAME = 8;

    private final List<Player> players;

    private Players(List<Player> players) {
        players = List.copyOf(players);
        checkPlayerCountToPlayGame(players.size());
        checkDuplicatePlayerName(players);
        this.players = players;
    }

    public static Players of(final List<String> playerNames, final CardDeck cardDeck) {
        return new Players(playerNames.stream()
                .map(name -> new Player(name, cardDeck.drawInitialCards()))
                .collect(Collectors.toList()));
    }

    private void checkPlayerCountToPlayGame(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT_TO_PLAY_GAME || playerCount > MAX_PLAYER_COUNT_TO_PLAY_GAME) {
            throw new IllegalArgumentException("게임을 하기 위한 플레이어 수는 1명이상 8명이하로 입력해주세요.");
        }
    }

    private void checkDuplicatePlayerName(final List<Player> playerNames) {
        boolean duplicated = playerNames.size() != playerNames.stream()
                .map(Participant::getName)
                .distinct()
                .count();

        if (duplicated) {
            throw new IllegalArgumentException("중복된 플레이어의 이름이 있습니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
