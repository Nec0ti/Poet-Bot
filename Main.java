import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PoetryBot bot = new PoetryBot();

        System.out.println("Hoş geldiniz! Aşağıdaki seçeneklerden birini seçin:");
        System.out.println("1. Hüzünlü şiir yaz");
        System.out.println("2. Aşk şiiri yaz");
        System.out.println("3. Çıkış");

        int secim = scanner.nextInt();

        switch (secim) {
            case 1:
                System.out.println("Hüzünlü şiir oluşturuluyor...\n");
                System.out.println(bot.huzunluSiirOlustur());
                break;
            case 2:
                System.out.println("Aşk şiiri oluşturuluyor...\n");
                System.out.println(bot.askSiiriOlustur());
                break;
            case 3:
                System.out.println("Programdan çıkılıyor...\n");
                System.exit(0);
                break;
            default:
                System.out.println("Geçersiz seçim! Lütfen geçerli bir seçenek seçin.\n");
        }
    }
}
