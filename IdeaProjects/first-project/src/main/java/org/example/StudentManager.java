package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManager {
  public static void main(String[] args) {
    Map<String, Integer> studentList = new HashMap<>();
    String options = """
            1. 学生を追加
            2. 学生を削除
            3. 点数を更新
            4. 平均点を計算
            5. 全学生の情報を表示
            6. 終了
            選択してください:
            """;
    Scanner scanner = new Scanner(System.in);
    int selectTocNumber = 0;

    while (selectTocNumber != 6) {
      try {
        System.out.println(options);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
          System.out.println("選択肢を入力してください。");
          continue;
        }

        selectTocNumber = Integer.parseInt(input);

        switch (selectTocNumber) {
          case 1 -> {
            System.out.println("学生の名前を入力してください: ");
            String inputFullName = getValidName(scanner);

            if (studentList.containsKey(inputFullName)) {
              System.out.println("この学生は既に登録されています。");
              continue;
            }

            System.out.println(inputFullName + "の点数を入力してください: ");
            int inputPoints = getValidScore(scanner);
            studentList.put(inputFullName, inputPoints);
            System.out.println("学生を登録しました。");
          }
          case 2 -> {
            if (studentList.isEmpty()) {
              System.out.println("登録されている学生がいません。");
              continue;
            }

            System.out.println("学生の名前を入力してください: ");
            String inputFullName = getValidName(scanner);

            if (!studentList.containsKey(inputFullName)) {
              System.out.println("入力された学生は登録されていません。");
              continue;
            }

            studentList.remove(inputFullName);
            System.out.println("入力された学生を登録から削除しました。");
          }
          case 3 -> {
            if (studentList.isEmpty()) {
              System.out.println("登録されている学生がいません。");
              continue;
            }

            System.out.println("学生の名前を入力してください: ");
            String inputFullName = getValidName(scanner);

            if (!studentList.containsKey(inputFullName)) {
              System.out.println("入力された学生は登録されていません。");
              continue;
            }

            System.out.println("更新後の" + inputFullName + "の点数を入力してください: ");
            int inputPoints = getValidScore(scanner);
            studentList.replace(inputFullName, inputPoints);
            System.out.println("点数を更新しました。");
          }
          case 4 -> {
            if (studentList.isEmpty()) {
              System.out.println("登録されている学生がいません。");
              continue;
            }

            int sumPoints = 0;
            int countStudents = studentList.size();
            for (int studentPoints : studentList.values()) {
              sumPoints += studentPoints;
            }
            double averageStudentPoints = (double) sumPoints / countStudents;
            System.out.printf("平均点: %.2f%n", averageStudentPoints);
          }
          case 5 -> {
            if (studentList.isEmpty()) {
              System.out.println("登録されている学生がいません。");
              continue;
            }

            System.out.println("【登録されている学生一覧】");
            for (Map.Entry<String, Integer> entry : studentList.entrySet()) {
              System.out.printf("%s: %d点%n", entry.getKey(), entry.getValue());
            }
          }
          case 6 -> System.out.println("プログラムを終了します。");
          default -> System.out.println("1 から 6 の数字を入力してください。");
        }
      } catch (NumberFormatException e) {
        System.out.println("数値を入力してください。");
      } catch (Exception e) {
        System.out.println("エラーが発生しました: " + e.getMessage());
      }
    }

    scanner.close();
  }

  private static String getValidName(Scanner scanner) {
    while (true) {
      String name = scanner.nextLine().trim();
      if (name.isEmpty()) {
        System.out.println("名前を入力してください。");
        continue;
      }
      return name;
    }
  }

  private static int getValidScore(Scanner scanner) {
    while (true) {
      try {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
          System.out.println("点数を入力してください。");
          continue;
        }

        int score = Integer.parseInt(input);
        if (score < 0 || score > 100) {
          System.out.println("点数は 0 ～ 100 の間で入力してください。");
          continue;
        }
        return score;
      } catch (NumberFormatException e) {
        System.out.println("有効な数値を入力してください。");
      }
    }
  }
}