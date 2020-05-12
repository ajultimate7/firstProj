package com.ajultimate.first;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        if(arr.length==2)
        {            
            System.out.println("yes");
            System.out.println("swap 1 2");
            System.exit(0);
        }
        else
        {
            int min=1000001;
            for(int i:arr)
            {
                if(i<min)
                    min=i;
            }
            //boolean flag=false;

            // if(arr[0]==min)
            // {
            int p1=0;
            int p2=0;
            int count=0;
            for(int i=1;i<arr.length;i++)
            {
                if(arr[i]<arr[i-1])
                {
                    if(count==0)
                    {
                        p1=i-1;
                        p2=i;
                    }
                    count++;
                    if(count==2)
                        p2=i;
                    if(count>2)
                        break;
                }
            }
            boolean flag=true;
            if(count<=2)
            {
                swap(arr,p1,p2);
                for(int i=0;i<arr.length-1;i++)
                {
                    if(arr[i]>arr[i+1])
                        flag=false;
                }
            }
            if(flag && count<=2)
            {
                System.out.println("yes");
                System.out.println("swap "+(p1+1)+" "+(p2+1));
                System.exit(0);
            }
            else if(count<=2)
                swap(arr,p1,p2);
            //System.out.println("No swapping pattern found cause count="+count+" and flag="+flag);
            //System.out.println("after swap pattern check");
            // for(int n:arr)
            //     System.out.print(n+" ");
            // System.out.println();
            count=0;
            //int miss=0;
            int start=0;
            int end=0;
            for(int i=1;i<arr.length;i++)
            {
                //System.out.println("Inside for i="+i);
                if(arr[i]<arr[i-1])
                {
                    //System.out.println("Inside if");
                    if(count==0)
                    {
                        //System.out.println("Inside if if setting start="+(i-1));
                        start=i-1;
                        count++;
                    }
                    end=i;
                }
                // else
                // {
                //     System.out.println("Inside else setting end="+(i-1));
                //     if(count>=1)
                //     {
                //         end=i-1;
                //         break;
                //     }
                // }
            }
            flag=true;
            if(count>=1)
            {
                //flag=reverse(arr,start,end);
                System.out.println("Value of start="+start+" and end="+end);
                // if(end-start==count)
                // {
                reverse(arr,start,end);
                for(int i=arr.length-1;i>end;i--)
                {
                    if(arr[i]<arr[i-1])
                        flag=false;
                }
                //}
                if(flag && arr[0]==min)
                {
                    System.out.println("yes");
                    System.out.println("reverse "+(start+1)+" "+(end+1));
                    System.exit(0);
                }
                System.out.println("no");
                
            }
        }
        //System.out.println("No reverse pattern found");
        
    }

    static boolean swap(int[] arr,int i,int j)
    {
        //System.out.println("Inside swap");
        arr[i]=arr[i]+arr[j]-(arr[j]=arr[i]);
        return true;
    }

    static void reverse(int[] arr,int i,int j)
    {
        int max=(j-i+1)/2;
        if(max==1)
            swap(arr,i,j);
        else
        {
            //System.out.println("Inside reverse() and max="+max);
            for(int k=i;k<=max;k++)
            {
                arr[k]=arr[k]+arr[j]-(arr[j]=arr[k]);
                j--;
            }
        }
         System.out.println("After reverse");
         for(int k:arr)
             System.out.print(k+" ");
         System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}


