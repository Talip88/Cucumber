package _JDBC.Gun02;

public class _03_Printf {

    public static void main(String[] args) {
        System.out.printf("","2");

        //printf
        //virgülden önceki bölüm formatı virgulden sonraki bölüm dataları temsil eder...

        int a=2343;
        double pi=3.14566566;
        String isim="Talip Çolak";
        char basHarf='T';

        System.out.printf("%5d", a); // a yı 5 hane içinde ondalık sistemde göster demek... İkilik 8 lik sistemde de gösterebilirsin

        System.out.printf("%-5d %6.2f \n",a,pi);

        // %6.2f 6 hane kullan noktadan sonra 2 hane kullan

        System.out.printf("%-5d %6.2f %20s \n",a,pi, isim);






    }
}
