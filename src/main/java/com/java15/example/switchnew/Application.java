package com.java15.example.switchnew;

/**
 * https://docs.oracle.com/en/java/javase/14/language/switch-expressions.html
 */
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
        System.out.println(switchNew2(day));
        System.out.println(switchNew3(day));
        System.out.println(switchNew4(day));
        System.out.println(switchNew5(day));
    }

    /**
     * If return statment is not attached to switch then we can use break statment
     * @param day
     * @return
     */
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

    /**
     * Returning value from switch
     * @param day
     * @return
     */
    private static int switchNew1(Day day) {
        int val =  switch (day){
            case MONDAY,TUESDAY -> 7;
            case FRIDAY,SUNDAY -> 6;
            default->throw new IllegalStateException();
        };
        return val;
    }

    /**
     * switch is returning (->)
     * @param day
     * @return
     */
    private static int switchNew2(Day day) {
        return  switch (day){
            case MONDAY,TUESDAY -> 7;
            case FRIDAY,SUNDAY -> 6;
            default->throw new IllegalStateException();
        };
    }

    private static int switchNew3(Day day){
        return switch (day){
            case MONDAY:
            case FRIDAY:
            case SUNDAY:yield 6;
            case TUESDAY:yield  7;
            default:
                throw  new IllegalStateException();
        };
    }

    private static int switchNew4(Day day){
        return switch (day){
            case MONDAY:
            case FRIDAY:
            case SUNDAY:yield 6;
            case TUESDAY:yield  7;
            default:
                throw  new IllegalStateException();
        };
    }
    private static int switchNew5(Day day) {
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println(6);
                yield 6;
            }
            case TUESDAY -> {
                System.out.println(7);
                yield 7;
            }
            case THURSDAY, SATURDAY -> {
                System.out.println(8);
                yield 8;
            }
            case WEDNESDAY -> {
                System.out.println(9);
                yield 9;
            }
            default -> {
                throw new IllegalStateException("Invalid day: " + day);
            }
        };
        return numLetters;
    }

}
