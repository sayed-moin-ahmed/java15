package com.java15.example.switchnew;

public class Application {

    public enum Day{
        //The constructor should be placed after Enum declaration
        MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7);
        private int dayOrder;
        private Day(int dayNo){
            this.dayOrder = dayNo;
        }

        public int getDayOrder() {
            return dayOrder;
        }
    }
    public static void main(String[] args) {
        Day day = Day.MONDAY ;
        System.out.println(legacy(day));
        System.out.println(switchNew1(day));
    }

    private static int legacy(Day day) {
        int numLetters;
        switch (day){
            case MONDAY: case TUESDAY:
                numLetters = 7;
                break;
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            default:
                throw new IllegalStateException();
        }
        return numLetters;
    }

    private static int switchNew1(Day day) {
        return switch (day){
            case MONDAY,TUESDAY -> 7;
            case FRIDAY,SUNDAY -> 6;
            default->throw new IllegalStateException();
        };
    }

}
