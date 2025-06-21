package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        //написать тут вашу реализацию пунктов 1-
        for (Apartment element : apartments) {
            if (element instanceof OneRoomApt) {
                ((OneRoomApt) element).clean1Room();
            }
            if (element instanceof TwoRoomApt) {
                ((TwoRoomApt) element).clean2Rooms();
            }
            if (element instanceof ThreeRoomApt) {
                ((ThreeRoomApt) element).clean3Rooms();
            }
        }
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
