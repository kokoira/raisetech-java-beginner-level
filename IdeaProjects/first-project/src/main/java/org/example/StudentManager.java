package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManager {

  public static void main(String[] args) {
    int selectTocNumber = 0;
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

    while (selectTocNumber != 6) {
      System.out.println(options);
      selectTocNumber = Integer.parseInt(scanner.nextLine());

      switch (selectTocNumber) {
        case 1: {
          System.out.println("学生の名前を入力してください: ");
          String inputFullName = scanner.nextLine();
          System.out.println(inputFullName + "の点数を入力してください: ");
          int inputPonits = Integer.parseInt(scanner.nextLine());
          studentList.put(inputFullName, inputPonits);
          break;
        }
        case 2: {
          System.out.println("学生の名前を入力してください: ");
          String inputFullName = scanner.nextLine();
          studentList.remove(inputFullName);
          break;
        }
        case 3: {
          System.out.println("学生の名前を入力してください: ");
          String inputFullName = scanner.nextLine();
          System.out.println("更新後の" + inputFullName + "の点数を入力してください: ");
          int inputPonits = Integer.parseInt(scanner.nextLine());
          studentList.replace(inputFullName, inputPonits);
          break;
        }
        case 4: {
          int sumPoints = 0;
          int countStudents = studentList.size();
          for (int studentPoints : studentList.values()) {
            sumPoints += studentPoints;
          }
          double averageStudentPoints = (double) sumPoints / countStudents;
          System.out.println(averageStudentPoints);
          break;
        }
        case 5: {
          for (String studentName : studentList.keySet()) {
            System.out.println(studentName + ":" + studentList.get(studentName));
          }
          break;
        }
        case 6:
          break;
        default:
          System.out.println("計算ができませんでした。再度正しい値や演算子を入力してください。");
      }
    }

    System.out.println("プログラムを終了します。");
    scanner.close();

  }
}