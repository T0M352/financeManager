package tomaszmorgas.financemanager.entity;

import jakarta.persistence.Column;

import java.sql.Date;

public class FullProduct implements Comparable<FullProduct> {
    private int id;
    private String productName;
    private double fullPrice;
    private double nettoPrice;
    private int tax;
    private String typeOfInvoice;
    private String typeOfPayment;
    private double kEarnings;
    private Date buyDate;
    private boolean shipped;

    public FullProduct(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.fullPrice = product.getFullPrice();
        this.tax = product.getTax();
        this.typeOfInvoice = product.getTypeOfInvoice();
        this.typeOfPayment = product.getTypeOfPayment();
        this.buyDate = product.getBuyDate();
        this.shipped = product.isShipped();
        this.kEarnings = (fullPrice * 0.03) * 0.81;
        kEarnings = Math.round(kEarnings * 100.0) / 100.0;
        this.nettoPrice = fullPrice / (1 + tax / 100.0);
        nettoPrice = Math.round(nettoPrice * 100.0) / 100.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(double nettoPrice) {
        this.nettoPrice = nettoPrice;
    }


    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getTypeOfInvoice() {
        return typeOfInvoice;
    }

    public void setTypeOfInvoice(String typeOfInvoice) {
        this.typeOfInvoice = typeOfInvoice;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }



    public double getkEarnings() {
        return kEarnings;
    }

    public void setkEarnings(double kEarnings) {
        this.kEarnings = kEarnings;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }



    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    @Override
    public int compareTo(FullProduct o) {
        return this.buyDate.compareTo(o.getBuyDate());
    }
}
