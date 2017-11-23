package com.example.utilsmoudle.arithmetic;

/**
 * Created by huixing on 2017/11/20.
 */

public class ErFenSerch {

    public static  void main(String ... args){

        int[] arr = {1,2,4,5,7,8,10,34,46,78,99,123,128,138,234,256,567,678,789,888,898,1000};
        int target = 256;

        int i = binarySerch(arr, target);

        System.out.print(i);

    }


    public static  int binarySerch(int [] arr,int target){

        int l=0;
        int r = arr.length-1;

        while (l<=r){

            int mid = l+(r-l)/2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target){

                l = mid+1;
            }else {

                r = mid-1;
            }


        }


        return -1;

    }


    public static int floor(int [] arr,int target){
        //todo 返回第一个出现的位置，如果没有出现，就返回最接近的比他小的最后一个


        return -1;
    }

    public  static int seil(int arr[],int target){

        //todo 返回最后一个出现的位置，如果没有出现，就返回最接近的比他大的第一个


        return -1;
    }
}
