package com.example.floatingrecycleview;

/**
 * Created by wangxiabing on 2017/7/7.
 */

public class PasswordUtil {

    public int passStrengthCheck(String password){
        int strength = 0;
        if(password.length()<=4)
            strength+=0;
        else if(password.length()>=5&&password.length()<=7)
            strength+=5;
        else if(password.length()>=8)
            strength+=10;

        int countCapital = 0,countSmall = 0,countNum = 0,countSymbol = 0;
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)>='A'&&password.charAt(i)<='Z')
                countCapital++;
            else if(password.charAt(i)>='a'&&password.charAt(i)<='z')
                countSmall++;
            else if(password.charAt(i)>='0'&&password.charAt(i)<='9')
                countNum++;
            else if((password.charAt(i)>=0x21&&password.charAt(i)<=0x2F)||
                    (password.charAt(i)>=0x3A&&password.charAt(i)<=0x40)||
                    (password.charAt(i)>=0x5B&&password.charAt(i)<=0x60)||
                    (password.charAt(i)>=0x7B&&password.charAt(i)<=0x7E))
                countSymbol++;
        }

        if(countCapital==0&&countSmall==0)
            strength+=0;
        else if(countCapital==password.length() || countSmall==password.length())
            strength+=5;
        else if(countCapital>0 && countSmall>0)
            strength+=10;

        if(countNum==0)
            strength+=0;
        else if(countNum==1)
            strength+=5;
        else if(countNum>=2)
            strength+=10;

        if(countSymbol==0)
            strength+=0;
        else if(countSymbol==1)
            strength+=5;
        else if(countSymbol>=2)
            strength+=15;

        if((countCapital!=0&&countSmall!=0&&countNum==0&&countSymbol==0)||
                (countCapital!=0&&countSmall==0&&countNum!=0&&countSymbol==0)||
                (countCapital!=0&&countSmall==0&&countNum==0&&countSymbol!=0)||
                (countCapital==0&&countSmall!=0&&countNum!=0&&countSymbol==0)||
                (countCapital==0&&countSmall!=0&&countNum==0&&countSymbol!=0)||
                (countCapital==0&&countSmall==0&&countNum!=0&&countSymbol!=0))
            strength+=2;
        else if((countCapital!=0&&countSmall!=0&&countNum!=0&&countSymbol==0)||
                (countCapital!=0&&countSmall!=0&&countNum==0&&countSymbol!=0)||
                (countCapital!=0&&countSmall==0&&countNum==0&&countSymbol!=0)||
                (countCapital==0&&countSmall!=0&&countNum!=0&&countSymbol!=0))
            strength+=3;
        else if((countCapital!=0&&countSmall!=0&&countNum!=0&&countSymbol!=0))
            strength+=5;

        char[] c;

        c=password.toCharArray();
        int countSame=0;
        for(int i=1;i<c.length;i++){
            if(c[i]==c[i-1])
                countSame++;
        }
        strength-=countSame;
        return strength;
    }

    public String generatePass(int length,boolean hasNum,
                               boolean hasSmall,boolean hasCaptial,boolean hasSymbol){
        String pass = "";


        int type = 0;

        if (hasNum) {
            type +=1;
        }
        if (hasSmall)  {
            type += 1;
        }
        if (hasCaptial){
            type += 1;
        }
        if (hasSymbol){
            type += 1;
        }

        switch (type){
            case 0:
                for (int i= 0;i<length;i++){

                    char c = (char) (int) (Math.random() * 93 + 33);
                    pass += c;

                }
                break;


            case 1:

                if (hasNum){
                    for (int i= 0;i<length;i++){

                        char c = (char) (int) (Math.random() * 10 + 48);
                        pass += c;

                    }

                }else if (hasSmall){

                    for (int i= 0;i<length;i++){

                        char c = (char) (int) (Math.random() * 26 + 97);
                        pass += c;

                    }


                }else if (hasCaptial){
                    for (int i= 0;i<length;i++){

                        char c = (char) (int) (Math.random() * 26 + 65);
                        pass += c;

                    }

                }else if (hasSymbol){
                    for (int i= 0;i<length;i++){

                        char c = (char) (int) (Math.random() * 15 + 33);
                        pass += c;

                    }

                }

                break;


            case 2:
                if (hasNum && hasSmall){

                    geneRate2Type(pass,length,10,48,26,97);


                }else if (hasNum && hasCaptial){

                    geneRate2Type(pass,length,10,48,26,65);


                }else if (hasNum && hasSymbol){

                    geneRate2Type(pass,length,10,48,15,33);

                }else if (hasSmall && hasCaptial){

                    geneRate2Type(pass,length,26,97,26,65);

                }else if (hasSmall && hasSymbol){


                    geneRate2Type(pass,length,26,97,15,33);


                }else if (hasCaptial && hasSymbol){

                    geneRate2Type(pass,length,10,65,15,33);
                }


                break;


            case 3:

                if (!hasNum){

                    geneRate3Type(pass,length,26,97,26,65,15,33);


                }else if (!hasSmall){

                    geneRate3Type(pass,length,10,43,26,65,15,33);


                }else if (!hasCaptial){

                    geneRate3Type(pass,length,10,43,26,97,15,33);

                }else if(!hasSymbol){

                    geneRate3Type(pass,length,10,43,26,65,26,65);

                }

                break;


            case 4:

                geneRate4Type(pass,length,10,43,26,65,26,65,15,33);
               
                break;

            default:
                break;
        }




        return  pass;
    }


    public void geneRate2Type(String pass,
                                int length,int range,int from,int range2,int from2){

        for (int i=0;i<length;i++){
            if (i%2 == 0){
                char c = (char) (int) (Math.random() * range + from);
                pass += c;
            }else {

                char c = (char) (int) (Math.random() * range2 + from2);
                pass += c;

            }
        }

    }


    public void geneRate3Type(String pass,
            int length,int range,int from,int range2,int from2,int range3,int from3){

        for (int i= 0;i<length;i++){
            if (i%3 == 0){
                char c = (char) (int) (Math.random() * range + from);
                pass += c;
            }else if (i%3 == 1){

                char c = (char) (int) (Math.random() * range2 + from2);
                pass += c;

            }else {
                char c = (char) (int) (Math.random() * range3 + from3);
                pass += c;
            }

        }

    }

    public void geneRate4Type(String pass,
                              int length,int range,
                              int from,int range2,
                              int from2,
                              int range3,int from3,
                              int range4,int from4){

        for (int i= 0;i<length;i++){
            if (i%4 == 0){
                char c = (char) (int) (Math.random() * range + from);
                pass += c;
            }else if (i%4 == 1){

                char c = (char) (int) (Math.random() * range2 + from2);
                pass += c;

            }else if (i%4 == 2){
                char c = (char) (int) (Math.random() * range3 + from3);
                pass += c;
            }else {
                char c = (char) (int) (Math.random() * range4 + from4);
                pass += c;
            }

        }

    }



}
