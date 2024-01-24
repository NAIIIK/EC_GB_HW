package ru.gb.homework.member;

import java.time.LocalDate;

public class Member {
    private String fullName;
    private LocalDate birthDate;
    private int phoneNumber;
    private String gender;

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setFullName(String[] fullName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(fullName[i].substring(0, 1).toUpperCase())
                    .append(fullName[i].substring(1))
                    .append(" ");
        }
        this.fullName = stringBuilder.toString();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        if (gender.equals("м")){
            this.gender = "мужской";
        } else {
            this.gender = "женский";
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ФИО: ")
                .append(fullName.substring(0, fullName.length() - 1))
                .append("\n")
                .append("Дата рождения: ")
                .append(birthDate)
                .append("\n")
                .append("Номер телефона: ")
                .append(phoneNumber)
                .append("\n")
                .append("Пол: ")
                .append(gender);
        return stringBuilder.toString();
    }
}
