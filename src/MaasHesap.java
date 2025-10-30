import java.util.Scanner;

public class MaasHesap {
    /*
     * Ad Soyad: [Enes PEPE]
     * Ogrenci No: [250541075]
     * Tarih: 30 Ekim 2025
     * Aciklama: Calisan bilgilerini alarak detayli maas bordrosu olusturan program.
     */
    public static void main(String[] args) {
        // Sabitler (final) - Oranlari ondalik olarak tanimlayin
        final double SGK_ORANI = 0.14;
        final double GELIR_VERGISI_ORANI = 0.15;
        final double DAMGA_VERGISI_ORANI = 0.00759;
        final int AYLIK_CALISMA_SAATI = 176; // 22 gun * 8 saat
        final int STANDART_AYLIK_SAAT = 160; // Mesai ucreti hesaplamasi icin
        final double MESAI_CARPANI = 1.5;

        // Scanner sinifini kullanin
        Scanner input = new Scanner(System.in);

        System.out.println("=== MAAS HESAPLAMA SISTEMI ===");

        // Alinacak Bilgiler
        System.out.print("Calisan Ad Soyadini girin: ");
        // nextLine() bug'ini onlemek icin tum String girdilerini baslangicta alalim.
        // nextLine() bug'i genelde nextInt()/nextDouble() sonrasinda bos satiri okumasiyla olusur.
        String adSoyad = input.nextLine();

        System.out.print("Aylik Brut Maas (TL): ");
        double brutMaas = input.nextDouble();

        System.out.print("Haftalik Calisma Saati: ");
        int haftalikSaat = input.nextInt(); // Bu bilgi dogrudan hesaplamada kullanilmiyor, sadece bilgi

        System.out.print("Mesai Saati Sayisi: ");
        int mesaiSaati = input.nextInt();

        input.close();

        // ----------------------------------------------------
        // 1. GELIRLER HESAPLAMASI
        // ----------------------------------------------------
        // Mesai Ucreti= (Brüt Maaş / 160) × Mesai Saat × 1.5
        double saatlikBrutUcret = brutMaas / STANDART_AYLIK_SAAT; // 160 saat
        double mesaiUcreti = saatlikBrutUcret * mesaiSaati * MESAI_CARPANI;

        // Toplam Gelir= Brüt + Mesai
        double toplamGelir = brutMaas + mesaiUcreti;

        // ----------------------------------------------------
        // 2. KESINTILER HESAPLAMASI
        // ----------------------------------------------------
        // SGK: Toplam Gelir × 0.14
        double sgkKesintisi = toplamGelir * SGK_ORANI;

        // Gelir Vergisi: Toplam Gelir × 0.15
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORANI;

        // Damga Vergisi: Toplam Gelir × 0.00759
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORANI;

        // Toplam Kesinti= SGK + Gelir V. + Damga V.
        double toplamKesinti = sgkKesintisi + gelirVergisi + damgaVergisi;

        // ----------------------------------------------------
        // 3. NET MAAS HESAPLAMASI
        // ----------------------------------------------------
        // Net Maaş= Toplam Gelir - Toplam Kesinti
        double netMaas = toplamGelir - toplamKesinti;

        // ----------------------------------------------------
        // 4. ISTATISTIKLER HESAPLAMASI
        // ----------------------------------------------------
        // Kesinti Oranı (%): (Toplam Kesinti / Toplam Gelir) × 100
        double kesintiOraniYuzde = (toplamKesinti / toplamGelir) * 100;

        // Saatlik Net Kazanç: Net Maaş / 176 saat
        double saatlikNetKazanc = netMaas / AYLIK_CALISMA_SAATI;

        // Günlük Net Kazanç: Net Maaş / 22 gün
        final double GUNLUK_CALISMA_GUNU = 22.0; // 22 gun
        double gunlukNetKazanc = netMaas / GUNLUK_CALISMA_GUNU;


        // ----------------------------------------------------
        // SONUCLAR - printf() ile profesyonel cikti
        // ----------------------------------------------------
        System.out.println("\n" + "=".repeat(36));
        System.out.println("MAAS BORDROSU");
        System.out.println("=".repeat(36));

        System.out.printf("Calisan: %s\n", adSoyad);
        System.out.println("-".repeat(36));

        // GELIRLER BOLUMU
        System.out.println("GELIRLER:");
        // Tum para degerleri 2 ondalikla (%.2f)
        System.out.printf("%-20s : %10.2f TL\n", "Brut Maas", brutMaas);
        System.out.printf("%-20s : %10.2f TL\n", "Mesai Ucreti (" + mesaiSaati + " saat)", mesaiUcreti);
        System.out.println("------------------------------------");
        System.out.printf("%-20s : %10.2f TL\n", "TOPLAM GELIR", toplamGelir);
        System.out.println("-".repeat(36));


        // KESINTILER BOLUMU
        System.out.println("KESINTILER:");
        // Yuzde degerleri 1 ondalikla (%.1f)
        System.out.printf("%-20s (%.1f%%) : %10.2f TL\n", "SGK Kesintisi", SGK_ORANI * 100, sgkKesintisi);
        System.out.printf("%-20s (%.1f%%) : %10.2f TL\n", "Gelir Vergisi", GELIR_VERGISI_ORANI * 100, gelirVergisi);
        // %0.8 yerine %0.759'un yuvarlanmis hali (yaklasik %0.8)
        System.out.printf("%-20s (%.1f%%) : %10.2f TL\n", "Damga Vergisi", DAMGA_VERGISI_ORANI * 100, damgaVergisi);
        System.out.println("------------------------------------");
        System.out.printf("%-20s : %10.2f TL\n", "TOPLAM KESINTI", toplamKesinti);
        System.out.println("-".repeat(36));

        System.out.printf("NET MAAS %24.2f TL\n", netMaas);
        System.out.println("=".repeat(36));

        // ISTATISTIKLER BOLUMU
        System.out.println("\nISTATISTIKLER:");
        System.out.printf("%-25s : %8.1f%%\n", "Toplam Kesinti Orani", kesintiOraniYuzde); // Yuzde 1 ondalik
        System.out.printf("%-25s : %8.2f TL\n", "Saatlik Net Kazanc", saatlikNetKazanc);
        System.out.printf("%-25s : %8.2f TL\n", "Gunluk Net Kazanc", gunlukNetKazanc);
        System.out.println("=".repeat(36));
    }
}