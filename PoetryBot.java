import java.util.Random;

public class PoetryBot {
    private Random random;

    private String[] dize1;
    private String[] dize2;
    private String[] kafiye;

    public PoetryBot() {
        this.random = new Random();

        this.dize1 = new String[]{"Gözlerimde yaşlar birikiyor", "Dudaklarım titreyerek fısıldıyor", "Yüreğim yanarken inliyor", "Ruhum kırılıp dağılıyor"};
        this.dize2 = new String[]{"Hüzün dolu anılarla boğuşurken", "Karanlık bir geceye gömülüyorum", "Hasret dolu günlerde kayboluyorum", "Yalnızlık içinde çaresizce arıyorum"};
        this.kafiye = new String[]{"Gözyaşların akıyor", "Onlar ağlıyor", "Seni kuslar bırakıyor", "Uykuda kalıyor"};
    }

    public String huzunluSiirOlustur() {
        return dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               kafiye[random.nextInt(kafiye.length)] + "\n\n" +

               dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               kafiye[random.nextInt(kafiye.length)];
    }

    public String askSiiriOlustur() {
        return dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               kafiye[random.nextInt(kafiye.length)] + "\n\n" +

               dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               dize1[random.nextInt(dize1.length)] + "\n" +
               dize2[random.nextInt(dize2.length)] + "\n" +
               kafiye[random.nextInt(kafiye.length)];
    }
}
