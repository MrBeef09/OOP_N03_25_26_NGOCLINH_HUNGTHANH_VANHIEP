/*
package com.example.servingwebcontent.console;
import com.example.servingwebcontent.Test.TestCoSoVatChat;
import com.example.servingwebcontent.Test.TestNganhHoc;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Quản lý Cơ sở vật chất");
            System.out.println("2. Tư vấn Ngành học");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); // bỏ ký tự xuống dòng

            switch (choice) {
                case 1:
                    TestCoSoVatChat.runTest();
                    break;
                case 2:
                    TestNganhHoc.runTest();
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();
    }
}

*/