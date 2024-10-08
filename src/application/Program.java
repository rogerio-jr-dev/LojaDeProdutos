package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<Product>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Product #%d data: \n", i);
            System.out.print("Common, used or imported (c/u/i)?");
            char ch = sc.next().charAt(0);
            while (ch != 'c' && ch != 'i' && ch != 'u') {
                System.out.print("Common, used or imported (c/u/i)?");
                ch = sc.next().charAt(0);
            }

            sc.nextLine(); //Limpeza de buffer
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // Limpeza de buffer
            if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, customsFee);
                list.add(product);
            } else if (ch == 'c') {
                Product product = new Product(name, price);
                list.add(product);
            } else {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String manufactureDateString = sc.nextLine();
                //Convertendo a String para Date
                Date manufactureDate = sdf.parse(manufactureDateString);
                Product product = new UsedProduct(name, price, manufactureDate);
                list.add(product);
            }

        }

        System.out.println("PRICE TAGS:");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }



        sc.close();
    }
}
