package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {

    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case ("-c"): synchronized (allPeople) {createPerson(args);}
                break;
            case ("-u"): synchronized (allPeople) {updatePerson(args);}
                break;
            case ("-i"): synchronized (allPeople) {informToConsolePerson(args);}
                break;
            case ("-d"): synchronized (allPeople) {deletePerson(args);}
                break;
            default:
                synchronized (allPeople) {System.out.println("Неверные параметры");}

        }
    }

    private static Sex whatSex(String gender) {
        return gender.equals("м") ? Sex.MALE : Sex.FEMALE;
    }

    private static Date birthDay(final String bdString) throws ParseException{

        return new SimpleDateFormat("dd/MMM/yyy", Locale.ENGLISH).parse(bdString);
    }

    private static void createPerson(String[] parametrs) throws ParseException{
        for (int i = 1; i < parametrs.length; i=i+3) {
            String name = parametrs[i];
            Sex sex = whatSex(parametrs[i+1]);
            Date bd = birthDay(parametrs[i+2]);

            if (sex == Sex.MALE) {
                allPeople.add(Person.createMale(name, bd));
                //System.out.println(allPeople.size() - 1);
            }
            if (sex == Sex.FEMALE){
                allPeople.add(Person.createFemale(name, bd));
                //System.out.println(allPeople.size() - 1);
            }
            System.out.println(allPeople.size() - 1);

        }

//        for (int i = 0; i < allPeople.size(); i++) {
//            System.out.println(i);
//        }
//        for (int i = 0; i < allPeople.size(); i++) {
//
//            System.out.println(allPeople.get(i).getName() + " " +
//                    allPeople.get(i).getSex() + " " +
//                    allPeople.get(i).getBirthDate());
//
//        }
    }

    private static void updatePerson(String[] parametrs) throws ParseException {
        //System.out.println(allPeople.size());
        for (int i = 1; i < parametrs.length; i=i+4) {
            int id = Integer.parseInt(parametrs[i]);
            String name = parametrs[i+1];
            Sex sex = whatSex(parametrs[i+2]);
            Date bd = birthDay(parametrs[i+3]);

            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(sex);
            allPeople.get(id).setBirthDate(bd);
        }

        //System.out.println(allPeople.size());

        for (int i = 0; i < allPeople.size(); i++) {

            System.out.println(allPeople.get(i).getName() + " " +
                    allPeople.get(i).getSex() + " " +
                    allPeople.get(i).getBirthDate());

        }
    }
    private static void informToConsolePerson(String[] parametrs) {
        for (int i = 1; i < parametrs.length; i++) {
            int id = Integer.parseInt(parametrs[i]);
            String m = allPeople.get(id).getSex() == Sex.MALE ? "м":"ж";
            System.out.println(allPeople.get(id).getName() + " " +
                     m + " " +
                    new SimpleDateFormat("dd-MMM-yyy",Locale.ENGLISH).format(allPeople.get(id).getBirthDate()));
            System.out.println();
        }
    }
    private static void deletePerson(String[] parametrs) {
        for (int i = 1; i < parametrs.length; i++) {
            int id = Integer.parseInt(parametrs[i]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);
        }
    }

}
