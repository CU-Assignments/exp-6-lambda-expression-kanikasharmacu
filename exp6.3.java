import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;
    
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Product [name=" + name + ", category=" + category + ", price=$" + price + "]";
    }
}

public class ProductAnalysisDemo {
    public static void main(String[] args) {
        // Create a list of product objects simulating a large dataset
        List<Product> products = new ArrayList<>();
        
        // Electronics
        products.add(new Product("Laptop", "Electronics", 1299.99));
        products.add(new Product("Smartphone", "Electronics", 899.99));
        products.add(new Product("Tablet", "Electronics", 499.99));
        products.add(new Product("Headphones", "Electronics", 249.99));
        products.add(new Product("TV", "Electronics", 1499.99));
        
        // Clothing
        products.add(new Product("T-Shirt", "Clothing", 19.99));
        products.add(new Product("Jeans", "Clothing", 59.99));
        products.add(new Product("Dress", "Clothing", 89.99));
        products.add(new Product("Jacket", "Clothing", 129.99));
        products.add(new Product("Shoes", "Clothing", 79.99));
        
        // Books
        products.add(new Product("Novel", "Books", 14.99));
        products.add(new Product("Textbook", "Books", 99.99));
        products.add(new Product("Cookbook", "Books", 24.99));
        products.add(new Product("Biography", "Books", 19.99));
        products.add(new Product("Dictionary", "Books", 29.99));
        
        // Home
        products.add(new Product("Sofa", "Home", 799.99));
        products.add(new Product("Dining Table", "Home", 599.99));
        products.add(new Product("Bed", "Home", 899.99));
        products.add(new Product("Chair", "Home", 199.99));
        products.add(new Product("Lamp", "Home", 79.99));
        
        System.out.println("Total number of products: " + products.size());
        
        // 1. Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
        
        System.out.printf("\nAverage price of all products: $%.2f\n", averagePrice);
        
        // 2. Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        
        System.out.println("\nNumber of products in each category:");
        productsByCategory.forEach((category, productList) -> 
            System.out.println(category + ": " + productList.size()));
        
        // 3. Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = productsByCategory.entrySet().stream()
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> entry.getValue().stream()
                                 .max(Comparator.comparing(Product::getPrice))
                ));
        
        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> {
            if (product.isPresent()) {
                System.out.println(category + ": " + product.get().getName() + " - $" + product.get().getPrice());
            }
        });
        
        // 4. Calculate the average price for each category
        Map<String, Double> averagePriceByCategory = productsByCategory.entrySet().stream()
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> entry.getValue().stream()
                                 .mapToDouble(Product::getPrice)
                                 .average()
                                 .orElse(0.0)
                ));
        
        System.out.println("\nAverage price in each category:");
        averagePriceByCategory.forEach((category, avgPrice) -> 
            System.out.printf("%s: $%.2f\n", category, avgPrice));
        
        // 5. Find products more expensive than the average price
        System.out.println("\nProducts more expensive than the average price:");
        products.stream()
                .filter(product -> product.getPrice() > averagePrice)
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
        
        // 6. Count how many products are above and below average price
        long aboveAverageCount = products.stream()
                .filter(product -> product.getPrice() > averagePrice)
                .count();
        
        System.out.println("\nNumber of products above average price: " + aboveAverageCount);
        System.out.println("Number of products below average price: " + (products.size() - aboveAverageCount));
    }
}
