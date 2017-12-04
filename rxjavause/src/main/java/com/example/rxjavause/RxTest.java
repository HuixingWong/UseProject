package com.example.rxjavause;

import android.provider.Settings;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by wangxiabing on 2017/6/28.
 */

public class RxTest {


    public static void main(String ... args){



        System.out.println("this is RXJava Test");


        Observable observable = Observable.just("lala","haha","xixi");



        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable1 = Observable.fromArray(words);


        Observer<String> observer = new Observer<String>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                System.out.println("失败了"+e);
            }

            @Override
            public void onComplete() {

                System.out.println("完成啦");
            }
        };


       Subscriber<String> subscriber  = new Subscriber<String>() {
           @Override
           public void onSubscribe(Subscription s) {

           }

           @Override
           public void onNext(String s) {

               System.out.println(s);
           }

           @Override
           public void onError(Throwable t) {

               System.out.println("失败了"+t);

           }

           @Override
           public void onComplete() {

               System.out.println("完成啦");


           }
       };


       observable1.subscribe(observer);




    }


}
