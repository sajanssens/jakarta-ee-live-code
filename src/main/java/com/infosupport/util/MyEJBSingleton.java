package com.infosupport.util;

import jakarta.ejb.Stateless;

import java.util.Calendar;

@Stateless
public class MyEJBSingleton {

    public void doeIets() {
        System.out.println("doeIets");
    }

    // @Schedule(hour = "*", minute = "*", second = "*/1", persistent = false)
    public void printTime() {
        System.out.println("AutomaticTimer current time: " + Calendar.getInstance().getTime());
    }
}
