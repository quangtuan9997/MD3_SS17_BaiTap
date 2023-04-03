package bai2;
import java.io.Serializable;

public class Product implements Serializable {
    private int proId;
    private String proName;
    private String proType;
    private int price;
    private String tittle;

    public Product() {
    }

    public Product(int proId, String proName, String proType, int price, String tittle) {
        this.proId = proId;
        this.proName = proName;
        this.proType = proType;
        this.price = price;
        this.tittle = tittle;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proType='" + proType + '\'' +
                ", price=" + price +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}

