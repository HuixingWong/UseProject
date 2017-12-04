package com.example.dagger2project;

import javax.inject.Inject;

/**
 * Created by dogoodsoft-app on 2017/11/23.
 */

public class City {
    @Inject
    public Street street;
    @Inject
    public City(Street street) {
        this.street = street;
    }
    public String show() {
        return "成都市" + street.show();
    }
}