package ru.gb.homework;

import ru.gb.homework.file_handler.FileHandler;
import ru.gb.homework.member.Member;
import ru.gb.homework.member.Parser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        System.out.println("Введите ФИО, дате рождения, номер телефона и пол через пробел:");
        try {
            parser.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
