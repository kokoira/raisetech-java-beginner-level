package org.example;

import java.util.Scanner;

public class JapaneseMobilePhoneValidator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean isValidInput = false;

    while (!isValidInput) {
      try {
        System.out.println("携帯電話番号を入力してください（例: 090-1234-5678）: ");
        String phoneNumber = scanner.nextLine().trim();

        if (phoneNumber.isEmpty()) {
          System.out.println("電話番号が入力されていません。");
          continue;
        }

        if (phoneNumber.length() > 13) {
          System.out.println("入力された文字数が 12 文字を超過しています。");
          continue;
        }

        if (countHyphens(phoneNumber) != 2) {
          System.out.println("ハイフン(-) の数が正しくありません。");
          continue;
        }

        if (!phoneNumber.matches("\\d{3}-\\d{4}-\\d{4}")) {
          System.out.println("無効な電話番号です。以下の形式で入力してください：");
          System.out.println("・3 桁 - 4 桁 - 4 桁の数字");
          System.out.println("・上記の桁数ごとに数値をハイフン(-) で区切る");
          continue;
        }

        // 携帯電話番号の先頭番号チェック
        String prefix = phoneNumber.substring(0, 3);
        if (!isValidMobilePrefix(prefix)) {
          System.out.println("携帯電話番号の先頭 3 桁が無効です。");
          System.out.println("070, 080, 090 のいずれかで始まる番号を入力してください。");
          continue;
        }

        System.out.println("有効な携帯電話番号です: " + phoneNumber);
        isValidInput = true;

      } catch (Exception e) {
        System.out.println("予期せぬエラーが発生しました: " + e.getMessage());
      }
    }

    scanner.close();
  }

  private static int countHyphens(String phoneNumber) {
    return (int) phoneNumber.chars().filter(character -> character == '-').count();
  }

  private static boolean isValidMobilePrefix(String prefix) {
    return prefix.matches("0[789]0");  // 070, 080, 090
  }
}