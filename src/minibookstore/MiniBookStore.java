package minibookstore;

import java.util.Scanner;

/*
Proje: Mini Book Store
     Online bir kitap market için ürün yönetim uygulaması yapınız.
     Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı.

     Kitap özellikleri: id, isim, birim fiyat, stok, yazar adı, yayınevi
     Defter özellikleri: id, isim, birim fiyat, stok, marka, yaprak sayısı

     Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
     Kullanıcı kategoriye göre ürün ekleyebilmeli
     Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli.
     Kullanıcı ürünleri marka(kitap) veya yayınevine göre filtreleyip listeleyebilmeli.
*/
public class MiniBookStore {
    public static void main(String[] args) {

        enter();

    }
    //1-product, book , notebook classlari olustur
    public static void enter(){
        //10-Kategori menu
        Scanner inp =new Scanner(System.in);
        System.out.println( "******************* MINI BOOK STORE************************");
        int select =-1;
        while (select!=0){
            System.out.println("Urun Yonetim Paneli");
            System.out.println("1-Kitaplar");
            System.out.println("2-Defterler");
            System.out.println("0-Cikis");
            System.out.println("Seciminiz : ");
            select = inp.nextInt();
            //ProductService i referans alarak service olustur
            ProductService service=select==1 ? new BookService() : new NotebookService();

            //select==1 ==>ProductService service1 = new BookService();
            //select==2 ==>ProductService service2 = new NotebookService();

            if (select==1 || select==2){
                service.processMenu();
            }else if (select==0){
                System.out.println("Iyi gunler...");
            }else {
                System.out.println("Hatali Giris");
            }


        }


    }



}
