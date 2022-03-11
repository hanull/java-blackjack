package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> requestUserNamesToPlayGame() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.stream(readLine().split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static String readLine() {
        return SCANNER.nextLine();
    }
}
