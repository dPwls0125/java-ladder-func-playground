package view;

import domain.LadderScale;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static LadderScale induceLadderScaleToBeEnteredAndReturn() {

        System.out.println("사다리의 넓이는 몇 개인가요?");
        int width = readIntAndClearBuffer();

        System.out.println("사다리의 높이는 몇 개인가요?");
        int height = readIntAndClearBuffer();

        return new LadderScale(width, height);
    }

    private static int readIntAndClearBuffer() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}

