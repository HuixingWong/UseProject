package com.example.dagger2project;

import javax.inject.Inject;

/**
 * Created by dogoodsoft-app on 2017/11/23.
 */

public class Province {
    @Inject
    public City city;
    @Inject
    public Province(City city) {
        this.city = city;
    }
    public String showAddress() {
        return "四川省" + city.show();
    }
}