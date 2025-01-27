package org.example;

import java.util.Scanner;

public class JapaneseMobilePhoneValidator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("携帯電話番号を入力してください: ");
    String phoneNumber = scanner.nextLine();

    if (phoneNumber.matches("\\d{3}-\\d{4}-\\d{4}")) {
      System.out.println("有効な電話番号です");
    } else {
      System.out.println("無効な電話番号です");
    }

    scanner.close();

  }
}