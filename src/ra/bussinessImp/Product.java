package ra.bussinessImp;

import ra.bussiness.IProduct;
import ra.config.InputMethod;
import ra.config.ShopMessage;


public class Product implements IProduct,Comparable<Product>  {
    private int productID;
    private String productName;
    private String title;
    private String description;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productID, String productName, String title, String description, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.title = title;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        this.productID = inputProductId();
        this.productName = inputProductNamer();
        this.title = inputProductTitle();
        this.description = inputProductDescription();
        this.importPrice = inputProductImportPrice();
        this.exportPrice = inputProductExportPrice();
        this.interest = this.exportPrice - this.importPrice;
        this.productStatus = inputProductStatus();
    }

    private boolean inputProductStatus() {
        System.out.println("Nhập trạng thái của sản phẩm: ");
        return InputMethod.getBoolean();
    }

    private float inputProductExportPrice() {
        System.out.println("Nhập vào giá xuất của sản phẩm :");
        return InputMethod.getFloat();
    }

    private float inputProductImportPrice() {
        System.out.println("Nhập vào giá nhập của sản phẩm :");
        return InputMethod.getFloat();
    }

    private String inputProductDescription() {
        System.out.println("Nhập vào mô tả cho sản phẩm :");
        return InputMethod.getString();
    }

    private String inputProductTitle() {
        System.out.println("Nhập tiêu đề cho sản phẩm :");
        return InputMethod.getString();
    }

    private String inputProductNamer() {
        System.out.println("Nhập tên cho sản phẩm :");
        return InputMethod.getString();
    }

    private int inputProductId() {
        System.out.println("Nhập vào mã sản phẩm (Lớn hơn không) :");
        return InputMethod.getInteger();
    }

    @Override
    public void displayData() {
        System.out.printf("|ID : %-5d | Name : %-20s | Title : %-20s | Description : %-20s | ImportPrice : %-12.2f | ExportPrice : %-12.2f | Interest : %-12.2f | Status : %-10s\n",
                this.productID, this.productName, this.title, this.description, this.importPrice, this.exportPrice, this.interest, this.productStatus ? "Đang bán" : "Ngừng bán");
        ;
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.interest, o.interest);
    }
}
