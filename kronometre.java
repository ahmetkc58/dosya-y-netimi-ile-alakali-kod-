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
public class kronometre {

    public  void time(int sn,String ThreadName)   {
        for (int i = 1; i <= sn; i++) {                        // burada kullanıcıdan girilen süre kadar beklememizi sağlayan metod bulunmaktadır
            System.out.println(ThreadName + " : " + i);
            //burada kaçıncı saniyede olduğunu gösteriyor ekrana yazdırıyor 
           try{
                Thread.sleep(1000);
                // sn = milisaniye burada 1 saniye beklemesi için komut girilmiş 
           }catch(Exception ex){
            System.out.println(ex);
        }
        }
        System.out.println(ThreadName + " bitti");

    }
}
