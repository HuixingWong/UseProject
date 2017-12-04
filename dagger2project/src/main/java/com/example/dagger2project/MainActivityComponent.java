package com.example.dagger2project;

import dagger.Component;

/**
 * Created by dogoodsoft-app on 2017/11/23.
 */

@Component
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
