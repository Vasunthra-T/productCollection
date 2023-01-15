import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.String;

public class Warehouse {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Wholesaler> wholesaler_details = new ArrayList<>();
    static ArrayList<Retailer> retailer_details = new ArrayList<>();

    public static void main(String[] args) {
        try {
            String line = "";
            String splitBy = ",";
            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Product.csv"));
            while ((line = sc1.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1] + ", Price="
                        + productSplit[2] + ", Stock=" + productSplit[3]);
                products.add(new Product(Integer.parseInt(productSplit[0]), productSplit[1],
                        Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3])));
            }
            sc1.close();

            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Wholesaler.csv"));
            while ((line = sc2.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1]);
                wholesaler_details.add(new Wholesaler(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc2.close();

            BufferedReader sc3 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Retailer.csv"));
            while ((line = sc3.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1]);
                retailer_details.add(new Retailer(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc3.close();

            while (true) {
                System.out.println("Enter the option: ");
                System.out.println("1. View products");
                System.out.println("2. View wholesalers");
                System.out.println("3. View retailers");
                System.out.println("4. Allocate product to wholesaler");
                System.out.println("5. Allocate wholesaler product to retailer");
                System.out.println("6. Display product stock");
                System.out.println("7. Display wholesaler stock");
                System.out.println("8. Display retailer stock");
                System.out.println("9. To conclude and print");
                System.out.println("10. To exit");
                Scanner sc = new Scanner(System.in);
                int user = sc.nextInt();

                switch (user) {
                    case 1: {
                        // Product sp = new Product();
                        System.out.println("ProductId" + " " + "ProductName" + " " + "Price" + " " + "Stock");
                        for (Product element : products) {
                            System.out.println(
                                    element.id + " " + element.name + " " + element.price + " " + element.stock);
                        }
                        System.out.println("-----------------");
                        break;
                    }
                    case 2: {
                        System.out.println("Wholesaler details");
                        for (Wholesaler element : wholesaler_details) {

                            System.out.println(element.getWholesaler_id() + " " + element.getWholesaler_name());
                        }
                        System.out.println("-----------------");
                        break;

                    }
                    case 3: {
                        System.out.println("Retailer details");
                        for (Retailer element : Warehouse.retailer_details) {
                            System.out.println(element.getRetailer_id() + " " + element.getRetailer_name());

                        }
                        System.out.println("-----------------");
                        break;

                    }
                    case 4: {
                        System.out.println("Enter wholesaler id to allocate product");
                        int wholeSalerId = sc.nextInt();
                        System.out.println("Enter the product id");
                        int productId = sc.nextInt();
                        System.out.println("Enter number of items to buy");
                        int itemCountToBuy = sc.nextInt();
                        allocateWholesaler(wholeSalerId, productId, itemCountToBuy);
                        System.out.println("-----------------");
                        break;
                    }
                    case 5: {
                        System.out.println("Enter retailer id to allocate product");
                        int retailerId = sc.nextInt();
                        System.out.println("Enter wholesaler id to buy product");
                        int wholeSalerId = sc.nextInt();
                        System.out.println("Enter the product id");
                        int productId = sc.nextInt();
                        System.out.println("Enter number of items to buy");
                        int itemCountToBuy = sc.nextInt();
                        allocateRetailer(retailerId, wholeSalerId, productId, itemCountToBuy);
                        System.out.println("-----------------");
                        break;
                    }
                    case 6: {
                        System.out.println("Enter product id to display stock");
                        int nameProduct = sc.nextInt();
                        displayProduct(nameProduct);
                        System.out.println("-----------------");

                        break;
                    }
                    case 7: {
                        System.out.println("Enter product id to display wholesaler stock");
                        int productId = sc.nextInt();
                        displayWholesaler(productId);
                        System.out.println("-----------------");
                        break;
                    }
                    case 8: {
                        System.out.println("Enter product id to display retailer stock");
                        int productId = sc.nextInt();
                        displayRetailer(productId);
                        System.out.println("-----------------");
                        break;
                    }
                    case 9: {
                        System.out.println("For whole saler enter 1, retailer enter 2");
                        int input = sc.nextInt();
                        if(input == 1)
                            GstCalculation.calculateGSTWS(wholesaler_details);
                        if(input == 2)
                            GstCalculation.calculateGSTRE(retailer_details);
                    }
                    case 10:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void allocateWholesaler(int wholeSalerId, int productId, int itemCountToBuy) {
        for (Wholesaler eachWholesaler : wholesaler_details) {
            if (eachWholesaler.getWholesaler_id() == wholeSalerId) {
                for (Product eachProduct : products) {
                    if (eachProduct.getStock() > itemCountToBuy) {
                        if (eachProduct.getId() == productId) {
                            if (eachWholesaler.wholesaler_product_list.size() == 0) {
                                Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(),
                                        eachProduct.getPrice(), itemCountToBuy);
                                eachWholesaler.setWholesaler_product_list(newProduct);
                                eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                            } else {
                                int flag = 0;
                                for (Product checkProduct : eachWholesaler.wholesaler_product_list) {
                                    if (checkProduct.getId() == productId) {
                                        checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
                                        eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                        flag = 1;
                                    }
                                    if (flag == 0) {
                                        Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(),
                                                eachProduct.getPrice(), itemCountToBuy);
                                        eachWholesaler.setWholesaler_product_list(newProduct);
                                        eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Wholesale dealer doesn't have enough stock to deliver");
                    }
                }
            }
        }
    }

    static void allocateRetailer(int retailerId, int wholeSalerId, int productId, int itemCountToBuy) {
        for (Retailer re : retailer_details) {
            if (re.getRetailer_id() == retailerId) {
                for (Wholesaler ws : wholesaler_details) {
                    if (ws.getWholesaler_id() == wholeSalerId) {
                        for (Product pr : ws.wholesaler_product_list) {
                            if (pr.getId() == productId) {
                                if (pr.getStock() > itemCountToBuy) {
                                    if (re.retailer_product_list.size() == 0) {
                                        Product newProduct = new Product(pr.getId(), pr.getName(),
                                                pr.getPrice(), itemCountToBuy);
                                        re.setRetailerProductList(newProduct);
                                        pr.setStock(pr.getStock() - itemCountToBuy);
                                    } else {
                                        int flag = 0;
                                        for (Product checkProduct : re.retailer_product_list) {
                                            if (checkProduct.getId() == productId) {
                                                checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
                                                pr.setStock(pr.getStock() - itemCountToBuy);
                                                flag = 1;
                                            }
                                            if (flag == 0) {
                                                Product newProduct = new Product(pr.getId(), pr.getName(),
                                                        pr.getPrice(), itemCountToBuy);
                                                re.setRetailerProductList(newProduct);
                                                pr.setStock(pr.getStock() - itemCountToBuy);
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Wholesale dealer doesn't have enough stock to deliver");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void displayProduct(int nameProduct) {
        for (Product itr : products) {
            if (itr.id == nameProduct) {
                System.out.println(itr.stock);
                break;
            }
        }
    }

    static void displayWholesaler(int productId) {
        for (int i = 0; i < wholesaler_details.size(); i++) {
            for (Product pr : wholesaler_details.get(i).wholesaler_product_list) {
                if (pr.getId() == productId) {
                    System.out.println("Wholesaler ID :" + wholesaler_details.get(i).getWholesaler_id()
                            + " -- Wholesaler name :" + wholesaler_details.get(i).getWholesaler_name());
                    System.out.println("ProductId" + " " + "ProductName" + " " + "Price" + " " + "Stock");
                    System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getStock());
                }
            }
        }
    }

    static void displayRetailer(int productId) {
        for (int i = 0; i < retailer_details.size(); i++) {
            for (Product pr : retailer_details.get(i).retailer_product_list) {
                if (pr.getId() == productId) {
                    System.out.println("Retailer ID :" + retailer_details.get(i).getRetailer_id()
                            + " -- Retailer name :" + retailer_details.get(i).getRetailer_name());
                    System.out.println("ProductId" + " " + "ProductName" + " " + "Price" + " " + "Stock");
                    System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getStock());
                }
            }
        }
    }
}
