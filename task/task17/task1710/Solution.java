package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //напишите тут ваш код
// параметр -с
        if ((args[0].contains("-c"))) {
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
            } else {
                allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
            }
            System.out.println(allPeople.size() -1);
        }
// параметр -r
        if ((args[0].contains("-r"))) {

            String sex = allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж";
            System.out.println(
                    allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                          sex  + " " +
                    new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[1])).getBirthDate())
            );
        }
// параметр -u
        //System.out.println(allPeople.size());

        if ((args[0].contains("-u"))) {
//            if (args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setSex(args[3].equals("м")?Sex.MALE:Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getBirthDate());
//            }else {
//                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
//                allPeople.get(Integer.parseInt(args[1])).setSex(args[3].equals("м")?Sex.MALE:Sex.FEMALE);
//                allPeople.get(Integer.parseInt(args[1])).setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
//                System.out.println(allPeople.get(Integer.parseInt(args[1])).getBirthDate());
//            }
            //System.out.println(allPeople.size());

        }
// параметр -d
        if ((args[0].contains("-d"))) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
        }
    }
}

