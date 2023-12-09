/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders4__Threading;

/**
 *
 * @author Lenovo
 */
public class KronometreThread implements Runnable {

    private Thread t;
    private int sayaç;
    private String ThreadName;

    public KronometreThread(String threadname, int s) {// kronometrenin bi isminid bide kaç saniye çalışacağını dışardan allıyoruz
        this.sayaç = s;
        this.ThreadName = threadname;
        System.out.println("olusturuluyor");
    }

    @Override
    public void run() {// burası override olduğu için metodu çalıştırınca implements edilen metodun içinde abstrakt olan metot çağrılır ve çalışır 
        kronometre kro = new kronometre();// hew saniye sayı yazar ve her yazı yazacağında 1 sn bekler 
        kro.time(sayaç, ThreadName);
    }

    public void start() {// bu classı çalıştırma sebebimiz bu class paralel işlemler yapmamıza imkan sağlamaktadır
        System.out.println("kronometre  nesnesi oluşuyor");
        if (t == null) {
            t = new Thread(this, ThreadName);
            t.start();
        }
    }
}
