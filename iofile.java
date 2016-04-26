/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a;
import java.util.*;
/**
 *
 * @author Ashishrp
 */
public class iofile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("number of input");
       int n=in.nextInt();
       n++;
       String inp[]=new String[n];
      Set<String> set = new HashSet<>();
       for(int j=0;j<n;j++){
      String s[]=in.nextLine().split(" ");//=new String[500];
        
      
      for(int i=0;i<s.length;i++){
       inp[j]+=s[i]+" ";
          set.add(s[i]);
       }
       
        
    }String temp="";
    for (Iterator i = set.iterator(); i.hasNext();) {temp=temp+(String) i.next()+" "; }
     String key[]=temp.split(" ");
        System.out.println();
      for (int j = 1; j <key.length; j++) { System.out.print(key[j]+" ");}System.out.println();
      
      int ar[][]=new int[n][key.length];
      
       for (int i = 1; i <n; i++) {
           
           for (int j = 1; j <key.length; j++) {
                        if(inp[i].contains(key[j]+" ")||inp[i].contains(" "+key[j])){
                        ar[i][j]=1;//System.out.println("1 ");
                        } else{
                            ar[i][j]=0;// System.out.println("0 ");
                        }
        }//System.out.println("");
       }
       int x=0;
  for (int i = 1; i <n; i++) {
      System.out.print(i+" ");ar[i][0]=i;
      for (int j = 1; j <key.length; j++) {
         
          System.out.print(ar[i][j]+" ");
           
           }System.out.println();}
    
    
    
    }
    
    
}
