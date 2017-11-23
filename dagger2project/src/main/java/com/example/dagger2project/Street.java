package com.example.dagger2project;

import javax.inject.Inject;

/**
 * Created by dogoodsoft-app on 2017/11/23.
 */

public class Street {
    @Inject
    public Street(){}
    public String show(){
        return "人民南路";
    }
}