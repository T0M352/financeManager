package tomaszmorgas.financemanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Pattern(regexp = "[a-zA-Z0-9 ]*", message= "Nie uzywaj polskich znakow")
    @NotNull(message="pole wymagane")
    @Size(min=1, message="pole wymagane")
    @Column(name="product_name")

    private String productName;

    @NotNull(message="pole wymagane")
    @Column(name="full_price")
    private double fullPrice;

    @NotNull(message="pole wymagane")
    @Column(name="tax")
    private int tax;

    @Column(name="type_of_invoice")
    private String typeOfInvoice;

    @Column(name="type_of_payment")
    private String typeOfPayment;


    @NotNull(message="wypełnij date")
    @Column(name="date")
    private Date buyDate;

    @Column(name="shipped")
    private boolean shipped;


    public Product() {

    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }


    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
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



    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", fullPrice=" + fullPrice +  '\'' +
                ", typeOfInvoice='" + typeOfInvoice + '\'' +
                ", typeOfPayment='" + typeOfPayment + '\'' +
                ", shipped=" + shipped +
                '}';
    }
}

