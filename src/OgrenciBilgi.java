/*
 * Ad Soyad: [Enes PEPE]
 * Ogrenci No: [250541075]
 * Tarih: [30.10.2025]
 * Aciklama: Ogrenci Bilgi Sistemi
 */


import java.util.Scanner;


public class OgrenciBilgi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("=== OGRENCI BILGI SISTEMI ===");
        System.out.print("Adinizi girin: ");
        String ad = input.next(); // tek kelime olarak isteniyor


        System.out.print("Soyadinizi girin: ");
        String soyad = input.next();


        System.out.print("Ogrenci numaraniz: ");
        int ogrenciNo = input.nextInt();


        System.out.print("Yasiniz: ");
        int yas = input.nextInt();


        System.out.print("GPA (0.00-4.00): ");
        double gpa = input.nextDouble();


        System.out.println("=== OGRENCI BILGI SISTEMI ===");
        System.out.printf("Ad Soyad: %s %s\n", ad, soyad);
        System.out.printf("Ogrenci No: %d\n", ogrenciNo);
        System.out.printf("Yas: %d\n", yas);
        System.out.printf("GPA: %.2f\n", gpa);
        System.out.println("Başarı Durumu: Başarılı");


        input.close();
    }
}
