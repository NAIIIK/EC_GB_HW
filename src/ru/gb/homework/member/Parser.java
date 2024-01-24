package ru.gb.homework.member;

import ru.gb.homework.exceptions.MyDateFormatException;
import ru.gb.homework.exceptions.MyGenderFormatException;
import ru.gb.homework.exceptions.MyNumberFormatException;
import ru.gb.homework.file_handler.FileHandler;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    public Member parse(String info) throws Exception{
        Member member = new Member();
        LocalDate birthDate = null;
        StringBuilder stringBuilder = new StringBuilder();
        FileHandler fileHandler = new FileHandler();
        String[] input = info.split(" ");
        if (input.length < 6) {
            throw new RuntimeException("Недостаточно данных");
        } else if (input.length > 6) {
            throw new RuntimeException("Указаны лишние данные");
        }
        member.setFullName(input);
        try {
            birthDate = LocalDate.parse(input[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            member.setBirthDate(birthDate);
        } catch (DateTimeParseException e){
            throw new MyDateFormatException("Неверный формат данных, введите данные в формате дд.мм.гггг");
        }
        try {
            int phoneNumber = Integer.parseInt(input[4]);
            member.setPhoneNumber(phoneNumber);
        } catch (NumberFormatException e) {
            throw new MyNumberFormatException("Неверный формат номера телефона, попробуйте ввести номер без специальных знаков");
        }
        if (!(input[5].equals("м") || input[5].equals("ж"))) {
            throw new MyGenderFormatException("Неверный формат пола, введите м или ж для мужского или женского соответственно");
        } else {
            member.setGender(input[5]);
        }
        String path = stringBuilder.append(input[0].substring(0, 1).toUpperCase())
                        .append(input[0].substring(1))
                .append(".txt")
                .toString();
        fileHandler.write(Path.of(path), member.toString() + "\n\n");
        return member;
    }
}
