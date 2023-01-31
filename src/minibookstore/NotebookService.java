package minibookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a)Product Service'i implemente et ve methodlari notebook'a uygun sekilde doldur
//ODEV
 public class NotebookService implements ProductService {
//Once notebook eklemek icin bir list ve constructor ekle
  Scanner inp = new Scanner(System.in);

    List<Notebook> noteBookList =new ArrayList<>();


    public NotebookService(){

         Notebook notebook1 = new Notebook(1, "Kareli Defter", "50 Lira", 150, "Net", "100");
         Notebook notebook2 = new Notebook(2, "Cizgili Defter", "55 Lira", 200, "Cizgi", "70");
         Notebook notebook3 = new Notebook(3, "Spiralli Defter", "85 Lira", 90, "Net", "150");

         this.noteBookList.add(notebook1);
         this.noteBookList.add(notebook2);
         this.noteBookList.add(notebook3);


     }

    @Override
    public void processMenu() {


        int choise = -1;

        while (choise != 0) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("1- Defterleri Listele");
            System.out.println("2- Defter Ekle");
            System.out.println("3- Defter Sil");
            System.out.println("4- Markaya Gore Filtrele");
            System.out.println("0-Geri Don");
            System.out.println("Seciminiz");
            choise = inp.nextInt();
            switch (choise) {
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    System.out.println("Marka :");
                    String brand = inp.next();
                    filterProduct(brand);
                    break;
                case 0:
                    System.out.println("Ana menuye yonlendiriliyorsunuz");
                    break;
                default:
                    System.out.println("Hatali Giris!!!");
            }
        }


    }

    @Override
    public void listProduct() {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-11s | %-8s \n", "ID", "Defter Adi", "Birim Fiyat", "Stok", "Marka", "Sayfa Sayisi");
        for (Notebook notebook : this.noteBookList) {
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-11s | %-8s \n", notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getStock(), notebook.getBrand(), notebook.getSheet());
        }
        System.out.println("--------------------------------------------------------------");

    }



    @Override
    public void addProduct() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Defter Adi : ");
        String noteBookName = inp.nextLine();
        System.out.println("Birim Fiyat : ");
        String price = inp.nextLine();
        System.out.println("Stok : ");
        int stock = inp.nextInt();
        inp.nextLine();//dummy
        System.out.println("Marka : ");
        String brand = inp.nextLine();
        System.out.println("Sayfa Sayisi : ");
        String sheet = inp.nextLine();




        Notebook newNoteBook = new Notebook(this.noteBookList.get(this.noteBookList.size() - 1).getId() + 1, noteBookName, price, stock, brand, sheet);
        this.noteBookList.add(newNoteBook);

    }



    @Override
    public void removeProduct() {


            boolean isExist = true;
            System.out.println("Defter id :");
            int id = inp.nextInt();
            for (Notebook notebook : this.noteBookList) {
                if (notebook.getId() == id) {
                    isExist = true;
                    this.noteBookList.remove(notebook);
                    System.out.println("Defter Silindi");
                    break;
                } else {
                    isExist = false;
                }

            }
            if (!isExist) {
                System.out.println("Defter Bulunamadi");
            }

        }

    @Override
    public void filterProduct(String filter) {
        for (Notebook notebook : this.noteBookList) {
            if (notebook.getBrand().equalsIgnoreCase(filter)) {//Cizgi
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-11s | %-8s \n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getStock(), notebook.getBrand(), notebook.getSheet());
            }
        }

    }
}








