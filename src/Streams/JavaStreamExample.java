import java.beans.Introspector;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
class Product{
    private Integer id;
    private String name;
    private Float price;
    public Product(Integer id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

public class JavaStreamExample {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products  
        productsList.add(new Product(1,"HP ",25000f));
        productsList.add(new Product(2,"Dell ",30000f));
        productsList.add(new Product(3,"Lenovo ",28000f));
        productsList.add(new Product(4,"Sony ",28000f));
        productsList.add(new Product(5,"Apple ",90000f));

//        List<String> productPriceList2 =productsList.stream()
//                .filter(p -> p.price > 27000)
//                .map(p -> p.name)
//                .collect(Collectors.toList());
//        System.out.println(productPriceList2);

//        Map<Integer, Product> mapList = productsList.stream().collect(Collectors.toMap(product -> product.getId(), product -> product));
          Map<Integer, Product> mapList = productsList.stream().collect(Collectors.toMap(Product :: getId, Function.identity() ));


        mapList.forEach((key, value) -> {
            System.out.println("Key : "+ key+ " | value : " + value.toString());
        });

//        List<String> words = new ArrayList<>();
//        words.add("sammed");
//        words.add("sumit");
//        words.add("kunal");
//        words.add("suraj");
//
//
//        List<String> toUpperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
//
//        System.out.println(toUpperCaseWords);

    }
}  