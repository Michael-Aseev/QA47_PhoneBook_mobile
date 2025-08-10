package utils;

import java.time.LocalDate;
import java.time.Month;

public class Experiments {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().getMonthValue());  //9 Sep
        System.out.println( Month.valueOf("JULY").getValue());

    }
}
