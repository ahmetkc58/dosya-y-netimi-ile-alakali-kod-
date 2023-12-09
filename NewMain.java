package ders2__workingWithFiles;

import ders4__Threading.KronometreThread;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
*
*
*
*
*kodun içerisinde bulunan yorum satırları metotlarda bulunmaktadır 
*
*
*
 */
public class NewMain {

    static String konum = "C:\\Users\\samie\\OneDrive\\Belgeler\\NetBeansProjects\\btk_Akademi2\\src\\ders2__workingWithFiles\\asd.txt";

    public static void main(String[] args) throws InterruptedException {
        long sayaç = 3;
        KronometreThread thread1 = new KronometreThread("thread1", (int) sayaç);// burada sayaçta ne yazacağını ve ne kadar süre içinde yazacağını belirttik burada ekrana 1 er saniye farkla yazdırma işlemini gerçekleştiriyoruz
        // thread1.start();                // aynı anda birden fazla işlem yapmak için kullandık   ekrana sayıları yazarken aynı anda başka işlemlerde yapabilmek için bunu kullandık 

        // readFile();
        // WriterFile();        
        // operating(sayaç);               // dosyayı çalıştırmak için yazdığımız metod  ekranan sayılar yazılırken bizde burada program çalıştırıyoruz aynı anda 
        //thread1.start();
        // readFile();
        createFile();
        //  closing();
       // getFileİnfo();

    }

    public static void WriterFile() throws InterruptedException {  // dosyaya yeni veriler eklemek için kullanılır
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(konum, true));//true yazmamızın sebebi dosyanın üstüne değil yanına veriyi yazar 
            writer.newLine();//yeni satır  oluşturur    
            writer.write("merhaba bu 5. satır");
            writer.close();
        } catch (IOException ex) {// eğer dosya bulunamz ise hata verecek BufferedWriter ve FileWriter de hata oluşursa diye yazdık
            ex.printStackTrace();
        }

    }

    public static void operating(long x) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("notepad students.txt");       // students adındaki notepad dosyasını çalıştıracak 
            Thread.sleep(x * 1000);// x sn kadar bekleyecek
            closing(); //dosyayı kapatacak

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            process.waitFor();  // programın kapanmasını sağlar
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void closing() {// programın kapatılmasını sağlar
        try {
            Process process = Runtime.getRuntime().exec("taskkill /F /IM notepad.exe");
            process.waitFor();
            System.out.println("Program kapatıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getFileİnfo() {// dosya bilgilerine ulaşmak için kullanıyoruz
        File file = new File(konum);
        if (file.exists()) {//  eğer varsa anlamında 
            System.out.println("dosya adı   : " + file.getName());// dosyanın ismini verir 
            System.out.println("dossya yolu   : " + file.getAbsolutePath());//dosyanın yolunu verir bize 
            System.out.println("dosya yazılabilir mi " + file.canWrite());//dosya yazılabilir mi ona bakıyoruz biz
            System.out.println("dosya okunabilir mi " + file.canRead());//dosya okunabilir mi 
            System.out.println("dosya boyutu " + file.length());//bayt şekilnde gösterir bize

        }
    }

    public static void readFile() {// dosyanın içindeki satırları okumamızı sağlıyor
        File file = new File(konum);
        System.out.println("deneme1 " + file);
        try {
            Scanner reader = new Scanner(file);//neyi okuyacaksak onu Scanner ın içine yazacağız

            while (reader.hasNextLine()) { // okunacak satır varsa anlamına geliyor
                String line = reader.nextLine();
                System.out.println(line);
            }
            System.out.println("okuma işlemi bitmiştir:");
            reader.close();// reader dosyasını kapatmış olduk

        } catch (FileNotFoundException ex) {//bu dosya olmazsa anlamına geliyor file...
            ex.printStackTrace();
        } 

    }

    public static void createFile() {//dosya oluşturma 
        File file = new File(konum);
        try {
            if (file.createNewFile()) {//dosya oluşturmak için yazılır  bir özelliğide eğer dosyayı oluşturursa true oluşturmaz ise false dönderir 
                System.out.println("dosya  oluşturuldu ");
            } else {
                System.out.println("dosya bulunmaktadır ");
                System.out.println("yeni dosyanızıın konumu " + file.getAbsolutePath());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
