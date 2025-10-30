import java.util.Scanner;

public class GeometrikHesap {
    /*
     * Ad Soyad: [Enes PEPE]
     * Ogrenci No: [250541075]
     * Tarih: 30 Ekim 2025
     * Aciklama: Daire yaricapini alip daire ve kure hesaplamalarini yapan program.
     */
    public static void main(String[] args) {
        // Sabitler icin final kullanin
        final double PI = 3.14159;

        // Scanner sinifini kullanin
        Scanner input = new Scanner(System.in);

        System.out.println("=== GEOMETRIK HESAPLAYICI ===");
        System.out.print("Dairenin yaricapini girin (cm): ");

        // Anlamli degisken ismi
        double yaricap = input.nextDouble();

        input.close();

        // Hesaplamalar
        // 1 Daire Alani: π × r^2
        double daireAlani = PI * yaricap * yaricap;

        // 2 Daire Cevresi: 2 × π × r
        double daireCevresi = 2 * PI * yaricap;

        // 3 Daire Çapı: 2 × r
        double daireCapi = 2 * yaricap;

        // 4 Küre Hacmi: (4/3) × π × r^3. Integer division'dan kacinmak icin 4.0/3.0 kullanildi.
        double kureHacmi = (4.0 / 3.0) * PI * Math.pow(yaricap, 3);

        // 5 Küre Yüzey Alanı: 4 × π × r^2
        double kureYuzeyAlani = 4 * PI * yaricap * yaricap;


        System.out.println("\nSONUCLAR:");
        System.out.println("----------");

        // Tum sonuclari 2 ondalik basamakla gosterme (%.2f)
        // Ciktinin duzenli hizalanmasi icin genislik belirlendi (%-20s, %.2f)
        System.out.printf("%-20s : %.2f cm^2\n", "Daire Alani", daireAlani);
        System.out.printf("%-20s : %.2f cm\n", "Daire Cevresi", daireCevresi);
        System.out.printf("%-20s : %.2f cm\n", "Daire Capi", daireCapi);
        System.out.printf("%-20s : %.2f cm^3\n", "Kure Hacmi", kureHacmi);
        System.out.printf("%-20s : %.2f cm^2\n", "Kure Yuzey Alani", kureYuzeyAlani);
        System.out.println("=============================");
    }
}