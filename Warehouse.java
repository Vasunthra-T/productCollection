import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.lang.String;


public class Warehouse {


    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Wholesaler> wholesaler_products = new ArrayList<>();
    static ArrayList<Retailer> retailer_products = new ArrayList<>();

    static ArrayList<String> p_wholesaler = new ArrayList<>();
    static ArrayList<String> p_retailer = new ArrayList<>();
    static Map<String,ArrayList<Product>> wMap=new HashMap<String,ArrayList<Product>>();



    public static void main(String[] args) {
        try {
            Scanner sc1 = new Scanner(new File("/Users/vasunthra/Documents/training/day 2/src/Product - Sheet1.csv"));
            sc1.useDelimiter("\n");
            while (sc1.hasNext()) {
                //System.out.println(sc1.next());
                String[] productSplit = sc1.next().split(",",4);
                products.add(new Product(productSplit[0], productSplit[1], productSplit[2], productSplit[3]));
            }
            sc1.close();
            Scanner sc2 = new Scanner(new File("/Users/vasunthra/Documents/training/day 2/src/Product - Sheet2.csv"));
            sc2.useDelimiter("\n");
            while (sc2.hasNext()) {

                //String[] wholesalerSplit = sc2.next().split(",");
                wholesaler_products.add(new Wholesaler(sc2.next()));
            }
            sc2.close();

            Scanner sc3 = new Scanner(new File("/Users/vasunthra/Documents/training/day 2/src/Product - Sheet3.csv"));
            sc3.useDelimiter("\n");
            while (sc3.hasNext()) {

                //String[] retailerSplit = sc3.next().split(",", 2);
                retailer_products.add(new Retailer(sc3.next()));
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
                System.out.println("9.To exit");
                Scanner sc = new Scanner(System.in);
                int user = sc.nextInt();

                switch (user) {
                    case 1: {
                        //Product sp = new Product();
                        Product.showProductData();
                        break;
                    }
                    case 2: {
                        Wholesaler.showWholesaler();
                        break;

                    }
                    case 3: {
                        Retailer.showRetailer();
                        break;

                    }
                    case 4: {
                        System.out.println("Enter wholesaler name to allocate product");
                        String w_name = sc.next();
                        System.out.println("Enter the product id");
                        String wp_id = sc.next();
                        System.out.println("Enter number of items to buy");
                        int w_item = sc.nextInt();
                        Wholesaler.allocateProductWholesaler(w_name, wp_id,w_item,wholesaler_products,products);
                        //Wholesaler.showWholesaler();
                        //Wholesaler ws = new Wholesaler();
                        //ws.changeStockProduct(id,items);
                    }
                    case 5: {
                        System.out.println("Enter retailer name to allocate product");
                        String r_name = sc.next();
                        System.out.println("Enter the product id");
                        String rp_id = sc.next();
                        System.out.println("Enter number of items to buy");
                        int r_item = sc.nextInt();
                       // Retailer.allocateProductWholesaler(r_name, rp_id,r_item,retailer_products,wholesaler_products);
                        break;
                    }
                    case 6: {
                        System.out.println("Enter product name to display stock");
                        String nameProduct = sc.next();
                        Product.displayProduct(nameProduct);

                        break;
                    }
                    case 7: {
                        System.out.println("Enter product name to display wholesaler stock");
                        String nameW = sc.next();
                       Wholesaler.displayWholesaler(nameW);
                        break;
                    }
                    case 8: {
                        break;
                    }
                    case 9:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

    class Product {
      String id;
        String name;
        String price;
        public Product(){}

        public Product(String id, String name, String price, String stock) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
        }

        static String stock;

      public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }
    /* static String id;
        String name;
        String price;
        String stock;
        Product(String id,String name, String price,String stock)
        {
            this.id=id;
            this.name=name;
            this.price=price;
            this.stock=stock;
        }
        Product() {
        }*/
        static void showProductData() {
            System.out.println(Warehouse.products.size());
            for (Product e : Warehouse.products) {
               // System.out.println(e.id + e.name + e.price + e.stock);
               System.out.println(e.getId() + " " + e.getName() + " " + e.getPrice() + " " + e.getStock());
            }

        }
        static void displayProduct(String nameProduct)
        {
            for (Product itr : Warehouse.products) {
                //System.out.println(itr.stock);

                if (itr.name.equals(nameProduct)) {
                    System.out.println(itr.stock);
                    break;
                    //int indexId = values.indexOf(itr);
                   // values.get(indexId).name = name;
                    //System.out.println(indexId);
                }
                else{
                    System.out.println("Enter the correct product");
                }
            }
        }
        //static ArrayList<Product> values = new ArrayList<>();


    }

class Wholesaler extends Product {
    public String getWholeSaler_name() {
        return wholeSaler_name;
    }

    public void setWholeSaler_name(String wholeSaler_name) {
        this.wholeSaler_name = wholeSaler_name;
    }

    public Wholesaler() {
    }

    Wholesaler(String wholeSaler_name) {
        //super(id, name, price, stock);
        this.wholeSaler_name = wholeSaler_name;
    }

    String wholeSaler_name;

    static void showWholesaler() {
        // System.out.println(wholesaler_products.size());
        for (Wholesaler element : Warehouse.wholesaler_products) {
            System.out.println(element.getWholeSaler_name());
        }
    }

    static void allocateProductWholesaler(String w_name, String p_id, int w_stock, ArrayList<Wholesaler> wholesaler_products, ArrayList<Product> products) {

        for (Product p : products) {
            //System.out.println(p.id);

            if (p.id.equals(p_id)) {

                if (Integer.parseInt(p.stock) >= w_stock) {

                    // Product.p_wholesaler.add(product);
                    p.stock = String.valueOf(Integer.parseInt(p.stock) - w_stock);
                    System.out.println(p.stock);
                    //showWholeSaler();
                } else {
                    System.out.println("Stock not available.");
                }
            }
        }
        for (Wholesaler w : wholesaler_products) {
            System.out.println(w.name);
            if (w.name.equals(w_name)) {
                for (Product pw : products) {
                    if (pw.id.equals(p_id)) {
                        int indexId = products.indexOf(pw);
                        //products.get(indexId).id = id;
                        System.out.println(indexId);
                        Warehouse.p_wholesaler.add(indexId, pw.id);
                        Warehouse.p_wholesaler.add(indexId, pw.name);
                        Warehouse.p_wholesaler.add(indexId, pw.price);
                        pw.stock = String.valueOf(Integer.parseInt(pw.stock) + w_stock);
                        Warehouse.p_wholesaler.add(indexId, pw.stock);
                        System.out.println(pw.stock);


                        //for(Product pp:Warehouse.p_wholesaler) {
                        //  pp.stock = String.valueOf(Integer.parseInt(pp.stock) + w_stock);
                        //System.out.println(pp.stock);
                        //   }


                    }
                    //  wMap.put(w_name,Warehouse.p_wholesaler);
                }

            }
        }
    }

    static void displayWholesaler(String nameW) {
        for (String itr : Warehouse.p_wholesaler) {
            //System.out.println(itr.stock);

            if (itr.equals(nameW)) {
                int indexId = Warehouse.p_wholesaler.indexOf(itr);
                break;
                //  System.out.println(Warehouse.p_wholesaler.get(indexId).);
                //  Warehouse.p_wholesaler.get(indexId).nameW
            }
            //  System.out.println(itr.get(0).stock);

            //int indexId = values.indexOf(itr);
            // values.get(indexId).name = name;
            //System.out.println(indexId);

            else {
                System.out.println("Enter the correct product");
            }
        }
    }
}




           /* for (Wholesaler p: wholesaler_products) {
                System.out.println(p.wholeSaler_name);
            }

            for (Product p: products ){
                System.out.println(p.id);
                System.out.println(p_id);
                if(p.id=="id")
                {
                    continue;
                }
                else if (p.id.equals(p_id)) {
                    System.out.println(p.id);
                    int indexId = products.indexOf(p);
                    //Integer.parseInt(stock);
                    products.get(indexId).stock = String.valueOf(Integer.parseInt(stock) - w_stock);
                    System.out.println(stock);
                }
            }*/
    // wholesaler_products.add()



  /*  static int[] w_stock={0,0,0,0,0};
    public void items(){
//        System.out.println("Available Products");
//        for(int i=0;i<pro_name.length;i++){
//            System.out.println(i+" "+pro_name[i] +" Count "+stock[i]);
//        }
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int cou = inp.nextInt();
        if(cou>stock[num]){
            System.out.println("Stock not exist");
        }
        else{
            System.out.println("You have to pay Rs."+price[num]);
            stock[num]-=cou;
            w_stock[num]+=cou;
        }
    }
    public void availpro(){
        System.out.println("Wholesaler Available Products\n");
        for(int i=0;i<pro_name.length;i++){
            System.out.println(i+" "+pro_name[i] +" Count "+w_stock[i]);
        }*/
    //}


    class Retailer extends Wholesaler {
        public Retailer(String retailer_name) {
            this.retailer_name = retailer_name;
        }


        String retailer_name;


        static void showRetailer() {
            // System.out.println(wholesaler_products.size());
            for (Retailer element : Warehouse.retailer_products) {
                System.out.println(element.getRetailer_name());
            }

        }

        public String getRetailer_name() {
            return retailer_name;
        }

        public void setRetailer_name(String retailer_name) {
            this.retailer_name = retailer_name;
        }
    }


