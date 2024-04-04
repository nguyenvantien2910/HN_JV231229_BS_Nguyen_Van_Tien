package ra.run;

import ra.bussinessImp.Product;
import ra.config.InputMethod;
import ra.config.ShopMessage;

import java.util.*;
public class ProductManagement {
    public static final List<Product> productList = new ArrayList<>();
    static {
         productList.add(new Product(3,"Áo thun", "Đây là áo","Đây là áo",30000,15000,-15000,true)) ;
         productList.add(new Product(2,"Áo ba lõ", "Đây là áo","Đây là áo",60000,15000,15000,false)) ;
         productList.add(new Product(7,"Quần thun", "Đây là áo","Đây là áo",66660000,15000,777775000,true)) ;
         productList.add(new Product(9,"Áo thun", "Đây là quân","Quần đây",30000,15000,8000,true)) ;
         productList.add(new Product(4,"Áo phông", "Đây là áo","Đây là áo",30007770,15000,-12000,false)) ;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte choice;
        boolean isExit = false;

        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("7. Thoát");

            System.out.println("Nhập lựa chọn của bạn : ");

            choice = InputMethod.getByte();

            switch (choice) {
                case 1:
                    addNewProduct(productList);
                    break;
                case 2:
                    displayAllProduct(productList);
                    break;
                case 3:
                    sortProductByInterest(productList);
                    break;
                case 4:
                    deleteProductById(productList);
                    break;
                case 5:
                    findProductByName(productList);
                    break;
                case 6:
                    updateProductStatusById(productList);
                    break;
                case 7:
                    scanner.close();
                    isExit = true;
                    System.out.println("Đã thoát chương trình !");
                    break;
                default:
                    System.err.println(ShopMessage.SELECT_INVALID);
            }

        } while (!isExit);
    }

    private static void updateProductStatusById(List<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println(ShopMessage.EMTY_LIST);
        } else {
            System.out.printf("Nhập mã sản phẩm muốn thay đổi trạng thái : ");
            int searchId = InputMethod.getInteger();
            int productIndex = findIndexByID(searchId, productList);
            if (productIndex != -1) {
                productList.get(productIndex).setProductStatus(!productList.get(productIndex).isProductStatus());
                System.out.printf(ShopMessage.UPDATE_STATUS_SUCESS);
            } else {
                System.err.println(ShopMessage.ID_NOT_FOUND);
            }
        }
    }

    private static void findProductByName(List<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println(ShopMessage.EMTY_LIST);
        } else {
            System.out.println("Nhập tên sản phẩm muốn tìm kiếm :");
            do {
                String searchName = InputMethod.getString().toLowerCase();
                List<Product> filterBySearchKey = productList.stream().filter(product -> product.getProductName().toLowerCase().contains(searchName)).toList();
                if (filterBySearchKey.isEmpty()) {
                    System.err.println(ShopMessage.NAME_NOT_FOUND);
                } else {
                    System.out.printf("Danh sách tìm kiếm theo từ khòa &s là :\n", searchName);
                    filterBySearchKey.forEach(product -> product.displayData());
                    break;
                }
            } while (true);
        }
    }

    private static void deleteProductById(List<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println(ShopMessage.EMTY_LIST);
        } else {
            do {
                System.out.println("Nhập mã sản phầm muốn xóa : ");
                int inputDeleteId = InputMethod.getInteger();

                int deleteIndex = findIndexByID(inputDeleteId, productList);

                if (deleteIndex != -1) {
                    productList.remove(deleteIndex);
                    System.out.println(ShopMessage.DELETE_SUCESS);
                    break;
                } else {
                    System.err.println(ShopMessage.ID_NOT_FOUND);
                }
            } while (true);
        }
    }

    private static void sortProductByInterest(List<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println(ShopMessage.EMTY_LIST);
        } else {
            System.out.println("Danh sách sản phẩm sau khi sắp xếp theo lợi nhuận tăng dần ");
            Collections.sort(productList);
            productList.forEach(product -> product.displayData());
        }
    }

    private static void displayAllProduct(List<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println(ShopMessage.EMTY_LIST);
        } else {
            System.out.println("DANH SÁCH SẢN PHẨM HIỆN CÓ ");
            for (Product product : productList) {
                product.displayData();
            }
        }
    }

    private static void addNewProduct(List<Product> productList) {
        System.out.println("Nhập số lượng sản phẩm muôn thêm : ");
        byte addNum = InputMethod.getByte();

        for (int i = 0; i < addNum; i++) {
            Product product = new Product();
            System.out.printf("Nhập thông tin cho sản phẩm thứ %d\n", i + 1);
            product.inputData();
            productList.add(product);
            System.out.println(ShopMessage.ADD_NEW_SUCESS);
        }
    }

    private static int findIndexByID(int id, List<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == id) {
                return i;
            }
        }

        return -1;
    }
}
