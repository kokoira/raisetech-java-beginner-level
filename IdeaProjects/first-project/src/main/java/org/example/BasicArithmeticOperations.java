package org.example;

import java.util.Scanner;

public class BasicArithmeticOperations {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continueCalculation = true;

    while (continueCalculation) {
      try {
        int inputNum1 = getValidNumber(scanner, "1 番目の数字を入力してください:");
        String inputOperator = getValidOperator(scanner);
        int inputNum2 = getValidNumber(scanner, "2 番目の数字を入力してください:");

        double result = calculate(inputNum1, inputNum2, inputOperator);
        System.out.printf("計算結果: %.2f%n", result);

        continueCalculation = false;

      } catch (Exception e) {
        System.out.println("エラーが発生しました: " + e.getMessage());
        System.out.println("もう一度最初からやり直してください。");
      }
    }
    scanner.close();
  }

  private static int getValidNumber(Scanner scanner, String inputMessage) {
    while (true) {
      System.out.println(inputMessage);
      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      } else {
        System.out.println("無効な入力です。整数を入力してください。");
        scanner.next();
      }
    }
  }

  private static String getValidOperator(Scanner scanner) {
    while (true) {
      System.out.println("演算子を入力してください (+, -, *, /): ");
      String operator = scanner.next();
      if (operator.matches("[+\\-*/]")) {
        return operator;
      }
      System.out.println("無効な演算子です。+, -, *, / のいずれかを入力してください。");
    }
  }

  private static double calculate(int num1, int num2, String operator) {
    return switch (operator) {
      case "+" -> num1 + num2;
      case "-" -> num1 - num2;
      case "*" -> num1 * num2;
      case "/" -> {
        if (num2 == 0) {
          throw new ArithmeticException("0 での除算はできません。");
        }
        yield (double) num1 / num2;
      }
      default -> throw new IllegalArgumentException("無効な演算子です。");
    };
  }
}