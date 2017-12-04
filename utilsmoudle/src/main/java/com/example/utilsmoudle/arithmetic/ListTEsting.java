package com.example.utilsmoudle.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dogoodsoft-app on 2017/11/30.
 */

public class ListTEsting {

    public static void main(String [] a){

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0;i<100;i++){



                list1.add(i);


        }

        for (int i = 80;i<200;i++){

            list2.add(i);
        }

        list2.removeAll(list1);
        list1.addAll(list2);

        for (int i=0;i<list1.size();i++){


            System.out.println(list1.get(i));

        }


    }

}
