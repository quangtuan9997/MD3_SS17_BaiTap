package bai2;

import bai1.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
     public static final String SOURCE_FILE="/Users/hai/Desktop/MD3/bai17_baiTap/src/bai2/source.txt";
     public static final String TARGET_FILE="/Users/hai/Desktop/MD3/bai17_baiTap/src/bai2/target.txt";
    public static Scanner scanner=new Scanner(System.in);
    public static List<bai2.Product> listPro;
    public static List<bai2.Product> readPro(){
        File file=new File(SOURCE_FILE);
        try {
            if (file.exists()){
                FileInputStream fis=new FileInputStream(file);
                ObjectInputStream ois=new ObjectInputStream(fis);
                List<bai2.Product> list= (List<bai2.Product>) ois.readObject();
                ois.close();
                fis.close();
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public static void writePro(){
        try {
            File file=new File(SOURCE_FILE);
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
    private static bai2.Product createProductToFile() {
        bai2.Product product = new bai2.Product();
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
    public static void showPro(){
        System.out.print("*************Product*************\n");
        for (bai2.Product pro:listPro) {
            System.out.println(pro);
        }
    }
    public static void copy_file(){
            File targetFile = new File(TARGET_FILE);
            try {
                if (!targetFile.exists()) {
                    targetFile.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(targetFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(listPro);
                fos.close();
                oos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        listPro=readPro();
        while (true){
            System.out.println("******************MENU*************");
            System.out.println("1.them ");
            System.out.println("2.hien thi ");
            System.out.println("3. copy file  ");
            System.out.println("4.Thoat  ");
            System.out.print("nhap lua chon:");
            int n= Integer.parseInt(scanner.nextLine());
            switch (n){
                case 1:
                    System.out.println("nhap so luong sap muon them ");
                    int size= Integer.parseInt(scanner.nextLine());
                    for (int i=0;i<size;i++){
                        bai2.Product product=createProductToFile();
                        listPro.add(product);
                    }
                    writePro();
                    break;
                case 2:
                    showPro();
                    break;
                case 3:
                    copy_file();
                    break;
                case 4:
                    System.out.println("***Buy***");
                    System.exit(0);
            }
        }
    }
}
