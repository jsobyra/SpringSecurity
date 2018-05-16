package hello;

import javax.persistence.*;

@Entity
public class Item {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private Integer available;

        @Column(nullable = false)
        private Double price;

        public Item(){}

        public Item(Long id, String title, Integer available, Double price) {
            this.id = id;
            this.title = title;
            this.available = available;
            this.price = price;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", price=" + price +
                '}';
    }
}
