package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String DATA="/Users/hai/Desktop/MD3/bai17_baiTap/src/bai1/data.txt";
    public static  List<Product> listPro;
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        listPro=readPro();
        while (true){
            System.out.println("******************MENU*************");
            System.out.println("1.them ");
            System.out.println("2.hien thi ");
            System.out.println("3.tim kiem  ");
            System.out.println("4.Thoat  ");
            System.out.print("nhap lua chon:");
            int n= Integer.parseInt(scanner.nextLine());
            switch (n){
                case 1:
                    System.out.println("nhap so luong sap muon them ");
                    int size= Integer.parseInt(scanner.nextLine());
                    for (int i=0;i<size;i++){
                        Product product=createProductToFile();
                        listPro.add(product);
                    }
                    writePro();
                    break;
                case 2:
                    showPro();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    System.out.println("***Buy***");
                    System.exit(0);
            }
        }
    }
    public static List<Product> readPro(){
        File file=new File(DATA);
        try {
            if (file.exists()){
                FileInputStream fis=new FileInputStream(file);
                ObjectInputStream  ois=new ObjectInputStream(fis);
                List<Product> list= (List<Product>) ois.readObject();
                ois.close();
                fis.close();
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public static void showPro(){
        System.out.print("*************Product*************\n");
        for (Product pro:listPro) {
            System.out.println(pro);
        }
    }
    public static void writePro(){
        try {
            File file=new File(DATA);
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos= new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(listPro);
            fos.close();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static Product createProductToFile() {
        Product product = new Product();
        if (listPro.isEmpty()) {
            product.setProId(1);
        } else {
            int newId = listPro.get(listPro.size() - 1).getProId() + 1;
            product.setProId(newId);
        }
        System.out.println("Nhập tên sản phẩm: ");
        product.setProName(scanner.nextLine());
        System.out.println("Nhập hãng sản xuất sản phẩm: ");
        product.setProType(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm: ");
        product.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập mô tả sản phẩm: ");
        product.setTittle(scanner.nextLine());
        return product;
    }
    private  static void search(){
        List<Product> listSearch=new ArrayList<>();
        System.out.println("nhap ten san pham:");
        String string=scanner.nextLine();
        for (int i=0;i<listPro.size();i++){
            if (listPro.get(i).getProName().equalsIgnoreCase(string)){
                listSearch.add(listPro.get(i));
            }
        }
        if (listSearch.size()==0){
            System.out.println("khong co san pham nay");
        }else {
            System.out.println("thong tin san pham tim thay");
            System.out.println(listSearch);
        }

    }

}
