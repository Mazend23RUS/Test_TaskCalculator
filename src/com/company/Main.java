package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static String[] roman = {"С", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static Pattern patternPlus = Pattern.compile("[+]+");
    public static Pattern patternMinus = Pattern.compile("[-]+");
    public static Pattern patternUmno = Pattern.compile("[*]+");
    public static Pattern patternDelen = Pattern.compile("[/]+");


    public static void main(String[] args) {

        System.out.println("Калькулятор арабских или римских цифр: ввод допускается только чисел от 1 до 10 включительно \n"+ "Введите числа от 1 до 10 и математичекое действие");
            Scanner scanner = new Scanner(System.in);
            String work = scanner.next();

           if (work.matches("\\d+\\D\\d+"))
            {

                if (work.contains("+")) {
                    String[] resalt = patternPlus.split(work);
                    int num1 = Integer.parseInt(resalt[0]);
                    int num2 = Integer.parseInt(resalt[1]);
                    if ((num1 <= 10 && num1 >= 0) && (num2 <= 10 && num2 >= 0))
                        System.out.println(num1 + num2);

                } else if (work.contains("-")) {
                    String[] resalt = patternMinus.split(work);
                    int num1 = Integer.parseInt(resalt[0]);
                    int num2 = Integer.parseInt(resalt[1]);
                    if ((num1 <= 10 && num1 >= 0) && (num2 <= 10 && num2 >= 0))
                        System.out.println(num1 - num2);

                } else if (work.contains("*")) {
                    String[] resalt = patternUmno.split(work);
                    int num1 = Integer.parseInt(resalt[0]);
                    int num2 = Integer.parseInt(resalt[1]);
                    if ((num1 <= 10 && num1 >= 0) && (num2 <= 10 && num2 >= 0))
                        System.out.println(num1 * num2);

                } else if (work.contains("/")) {
                    String[] resalt = patternDelen.split(work);
                    int num1 = Integer.parseInt(resalt[0]);
                    int num2 = Integer.parseInt(resalt[1]);
                    if ((num1 <= 10 && num1 >= 0) && (num2 <= 10 && num2 >= 0))
                        System.out.println(num1 / num2);
                }
            }

           else if (work.matches("[IVX]+\\D[IVX]+"))
            {
                int indexRoman1 = 0;
                int indexRoman2 = 0;
                int sum = 0;

                if (work.contains("+")) {
                    String[] resalt = patternPlus.split(work);
                    String num1 = resalt[0];
                    String num2 = resalt[1];
                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num1)) {
                            indexRoman1 = i;
                        }
                    }
                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num2)) {
                            indexRoman2 = i;
                        }
                    }
                    sum = indexRoman1 + indexRoman2;

                }else if (work.contains("-")) {
                    String[] resalt = patternMinus.split(work);
                    String num1 = resalt[0];
                    String num2 = resalt[1];

                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num1)) {
                            indexRoman1 = i;
                        }
                    }
                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num2)) {
                            indexRoman2 = i;
                        }
                    }
                    sum = indexRoman1 - indexRoman2;

                }else if (work.contains("*")) {
                    String[] resalt = patternUmno.split(work);
                    String num1 = resalt[0];
                    String num2 = resalt[1];
                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num1)) {
                            indexRoman1 = i;
                        }
                    }
                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num2)) {
                            indexRoman2 = i;
                        }
                    }
                    sum = indexRoman1 * indexRoman2;

                } else if (work.contains("/")) {
                    String[] resalt = patternDelen.split(work);
                    String num1 = resalt[0];
                    String num2 = resalt[1];

                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num1)) {
                            indexRoman1 = i;
                        }
                    }
                    for (int i = 0; i < roman.length; i++) {
                        if (roman[i].equals(num2)) {
                            indexRoman2 = i;
                        }
                    }
                    sum = indexRoman1 / indexRoman2;
                }

                System.out.println(converteResolToString(sum));
            }else System.out.println("Не верно введены данные, попробуйте еще раз");

        }



        public static String converteResolToString (int sum) {
            String resoltString = "";

            if (sum >= 0 || sum <= 100) {
                while (sum >= 100) {
                    resoltString += "C";
                    sum -= 100;
                }
                while (sum >= 90) {
                    resoltString += "XC";
                    sum -= 90;
                }
                while (sum >= 50) {
                    resoltString += "L";
                    sum -= 50;
                }
                while (sum >= 40) {
                    resoltString += "XL";
                    sum -= 40;
                }

                while (sum >= 10) {
                    resoltString += "X";
                    sum -= 10;
                }
                while (sum >= 9) {
                    resoltString += "IX";
                    sum -= 9;
                }
                while (sum >= 5) {
                    resoltString += "V";
                    sum -= 5;
                }
                while (sum >= 4) {
                    resoltString += "IV";
                    sum -= 4;
                }
                while (sum >= 1) {
                    resoltString += "I";
                    sum -= 1;
                }
            }
            return "Итого в римской кодировке = "+resoltString;
        }

    }

