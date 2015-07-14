package com.piercestudio.dayte;

public class GuassAlgorithm {
	
    public static String getDate(String s){ //method declaration

        if(s == "error"){
            return "error";
        }
    	
    	String dayOfWeek = "some day"; //String declared with variable to test if anything is changing

    	int centuryInt = Integer.parseInt(s.substring(6, 8));
    	int decadeAndYearInt = Integer.parseInt(s.substring(8, 10));
    	int monthInt = Integer.parseInt(s.substring(0, 2));
    	int dayInt = Integer.parseInt(s.substring(3, 5));

        Object monthName[][] = {{3, "March"}, {4, "April"}, {5, "May"}, {6, "June"}, {7, "July"}, {8, "August"}, {9, "September"}, {10, "October"}, {11, "November"}, {12, "December"}, {13, "January"}, {14, "February"}};

        switch (monthInt){
        case 1: monthInt = 12; //jan
            break;
        case 2: monthInt = 13; //feb
            break;
        case 3: monthInt = 0; //mar
            break;
        case 4: monthInt = 1; //apr
            break;
        case 5: monthInt = 2; //may
            break;
        case 6: monthInt = 3; //jun
            break;
        case 7: monthInt = 4; //jul
            break;
        case 8: monthInt = 5; //aug
            break;
        case 9: monthInt = 6; //sep
            break;
        case 10: monthInt = 7; //oct
            break;
        case 11: monthInt = 8; //nov
            break;
        case 12: monthInt = 9; //dec
            break;
        }

        //algorithm
//Log.i("currentApp", Integer.toString(centuryInt));
//Log.i("currentApp", Integer.toString(decadeAndYearInt));
//Log.i("currentApp", Integer.toString(monthInt));
//Log.i("currentApp", Integer.toString(dayInt));

        int h = (dayInt + (26*(monthInt+1)/10) + decadeAndYearInt + (decadeAndYearInt/4) + (centuryInt/4) + (5*centuryInt)) % 7;
        //wtf, why do I number the months and then immediately run it as m+1 and then never use it again?
        //% gives me the remainder   / gives me integer division ie: 2/4=0  3/2=1 3%2=1

    	String weekDays[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        dayOfWeek = weekDays[h];

    		return dayOfWeek;
    }
}