import java.util.Arrays;
        import java.util.Collections;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String A=sc.nextLine();
            String B=sc.nextLine();
            String C=sc.nextLine();
            chkMixture(A,A.length(),B,B.length(),C,C.length());
        }
    }
    public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        if((n+m)!=v)
            return false;
        StringBuilder tem=new StringBuilder("");
       int i=0,j=0;
       while(i<n&&j<m){
           tem=tem.append(A.charAt(i));
           i++;
           while(i<n&&A.charAt(i)>='0'&&A.charAt(j)<='9'){
               tem=tem.append(A.charAt(i));
               i++;
           }
           tem=tem.append(B.charAt(j));
           j++;
           while(j<m&&B.charAt(j)>='0'&&B.charAt(j)<='9'){
               tem=tem.append(B.charAt(j));
               j++;
           }
       }
       while (i<n){
           tem=tem.append(A.charAt(i));
           i++;
       }
       while (j<m){
           tem=tem.append(B.charAt(j));
       }
        if(tem.equals(C))
            return true;
        else
            return  false;
    }
}
abstract  class A{
      double c=0;
        }
