package org.example;

import java.util.Scanner;

public class BasicArithmeticOperations {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("1番目の数字を入力してください:");
    int input_num1 = scanner.nextInt();

    System.out.println("演算子を入力してください (+, -, *, /): ");

    String input_operator = scanner.next();

    System.out.println("2番目の数字を入力してください: ");

    int input_num2 = scanner.nextInt();

    switch (input_operator) {
      case "+" -> System.out.println(input_num1 + input_num2);
      case "-" -> System.out.println(input_num1 - input_num2);
      case "*" -> System.out.println(input_num1 * input_num2);
      case "/" -> System.out.println(input_num1 / input_num2);
      default ->
          System.out.println("計算ができませんでした。再度正しい値や演算子を入力してください。");
    }

    scanner.close();

  }
}