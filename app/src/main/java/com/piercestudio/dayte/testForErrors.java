package com.piercestudio.dayte;

import android.util.Log;

/**
 * Created by User on 02/12/15XX
 */

public class testForErrors {

    public static String E = "TAG";


        public static String[] check(String[] sArray){

            String s = sArray[0];
            sArray[1] = "error";

        if (s == null || s.length() != 10) {
            Log.i(E, "length out of bounds or null");
            if (s.length()<10) {
                sArray[1] = "too short";
                return sArray;
            }
            if(s.length()>10){
                sArray[1] = "too long";
                return sArray;
            }
        }

        Log.i(E, s.substring(0,2) + s.substring(2,3) + s.substring(3,5) + s.substring(5,6) + s.substring(6));


        try {
            if((Integer.parseInt(s.substring(0, 2)) > 0 && (Integer.parseInt(s.substring(0, 2)) < 13)) != true) {
                Log.i(E, "month out of bounds");
                sArray[1] = "month out of bounds";
                return sArray;
            }
        } catch (NumberFormatException e) {
            Log.i(E, "month out of bounds error");
            return sArray;
        }
            Log.i(E, "month in bounds");

        int month = Integer.parseInt(s.substring(0, 2));
            Log.i(E, "month = " + Integer.toString(month));

        //this activates only after the month has passed it's test
        //if it were inside the "try" block 1: the rest of the code couldn't see it.
        //10/25/1980

        try {
            Log.i(E, s);
            if(s.substring(2,3).equals("/") != true) {
                Log.i(E, s.substring(2,3));
                Log.i(E, "first slash out of bounds");
                return sArray;
                }
            }
        catch (NumberFormatException e){
            Log.i(E, "first slash error");
            return sArray;
        }
        Log.i(E, "first slash in bounds");

            switch (month) {
                case 1:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 32)) != true){
                            Log.i(E, "Jan out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Jan error");
                        sArray[1] = "days error";
                        return sArray;
                    }
                    Log.i(E, "Jan in bounds");
                    break;
                case 2:
                    int leap = 0;
                    try {
                        if((Integer.parseInt(s.substring(6))%4 == 0) && (Integer.parseInt(s.substring(6))%100 != 0)){
                            leap =1;
                            }
                        if (((Integer.parseInt(s.substring(6)) % 400 == 0))) {
                            leap = 1;
                        }

                        if (((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < (leap + 29))) != true) {
                            if (Integer.parseInt(s.substring(3, 5)) == 29) {
                                sArray[1] = "Leap Year";
                                return sArray;
                            }else
                            {
                                sArray[1] = "days error";
                                return sArray;
                            }
                                }


                    } catch (NumberFormatException e) {
                        Log.i(E, "Feb error");
                        return sArray;
                    }
                    Log.i(E, "Feb in bounds");
                    break;
                case 3:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 32)) != true){
                            Log.i(E, "Mar out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Mar error");
                        return sArray;
                    }
                    Log.i(E, "Mar in bounds");
                    break;
                case 4:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 31)) != true){
                            Log.i(E, "Apr out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Apr error");
                        sArray[1] = "days error";
                        return sArray;
                    }
                    Log.i(E, "Apr in bounds");
                    break;
                case 5:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 32)) != true){
                            Log.i(E, "May out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "May error");
                        return sArray;
                    }
                    Log.i(E, "May in bounds");
                    break;
                case 6:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 31)) != true){
                            Log.i(E, "Jun out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Jun error");
                        return sArray;
                    }
                    Log.i(E, "Jun in bounds");
                    break;
                case 7:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 32)) != true){
                            Log.i(E, "Jul out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Jul error");
                        return sArray;
                    }
                    Log.i(E, "Jul in bounds");
                    break;
                case 8:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 32)) != true){
                            Log.i(E, "Aug out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Aug error");
                        return sArray;
                    }
                    Log.i(E, "Aug in bounds");
                    break;
                case 9:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 31)) != true){
                            Log.i(E, "Sep out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Sep error");
                        return sArray;
                    }
                    Log.i(E, "Sep in bounds");
                    break;
                case 10:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 32)) != true){
                            Log.i(E, "Oct out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Oct error");
                        return sArray;
                    }
                    Log.i(E, "Oct in bounds");
                    break;
                case 11:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 31)) != true){
                            Log.i(E, "Nov out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Nov error");
                        return sArray;
                    }
                    Log.i(E, "Nov in bounds");
                    break;
                case 12:
                    try {
                        if(((Integer.parseInt(s.substring(3, 5)) > 0) && (Integer.parseInt(s.substring(3, 5)) < 32)) != true){
                            Log.i(E, "Dec out of bounds");
                            sArray[1] = "days error";
                            return sArray;
                        }
                    } catch (NumberFormatException e) {
                        Log.i(E, "Dec error");
                        return sArray;
                    }
                    Log.i(E, "Dec in bounds");
                    break;

            }

        try {
            if(s.substring(5,6).equals("/") != true) {
                Log.i(E, "second slash out of bounds");
                return sArray;
            }
        }
        catch (NumberFormatException e){
            Log.i(E, "second slash error");
            return sArray;
        }
        Log.i(E, "second slash in bounds");

        try {
            if((Integer.parseInt(s.substring(6)) < 1700 && Integer.parseInt(s.substring(6)) < 2600) == true) {
                Log.i(E, "century out of bounds");
                sArray[1] = "year error";
                return sArray;
            }
        }
        catch (NumberFormatException e){
            Log.i(E, "century error");
            return sArray;
        }
            sArray[1] = "PASS";
            return sArray;
    }

}