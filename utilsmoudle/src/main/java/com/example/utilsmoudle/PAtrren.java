package com.example.utilsmoudle;

/**
 * Created by dogoodsoft-app on 2017/11/3.
 */

public class PAtrren {

    public static void main(String ... a){

        String VIDEO = ".*\\.(?i)(?:rm(vb)?|mp4|avi|mkv|3gp|wmv|flv|asf|wmv|mov|mkv)$";
        String PIC = ".*\\.(?i)(?:gif|jpe?g|png|bmp)$";
        String MUSIC = ".*\\.(?i)(?:mp3|wav|wma|ogg|m4a|aac|amr)$";
        String DOC = ".*\\.(?i)(?:txt|docx?|xlsx?|pptx?)$";

        String name = "lalala.TXT";

        boolean matches = name.matches(DOC);

        System.out.print(matches);

    }
}
