import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {

    // 1
    private Map<Long, Product> products = new HashMap<>();
    private static ProductService instance;

    private ProductService() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public void add(Product product) {
        products.put(product.getId(), product);
    }

    // Ds
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    // Tìm kiếm
    public Product findById(long id) {
        return products.get(id);
    }

    // Thêm
    public boolean update(Product product) {
        if (products.containsKey(product.getId())) {
            products.put(product.getId(), product);
            return true;
        }
        return false;
    }

    // Xoá
    public boolean delete(long id) {
        if (products.containsKey(id)) {
            products.remove(id);
            return true;
        }
        return false;
    }

    // Tìm kiếm
    public List<Product> searchByName(String nameKeyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            String productNameLower = product.getName().toLowerCase();
            String keywordLower = nameKeyword.toLowerCase();
            if (productNameLower.contains(keywordLower)) {
                result.add(product);
            }
        }
        return result;
    }

    // In và lưu file()
    public void saveToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Product product : products.values()) {
                String line = String.format("%d,%s,%.1f,%d",
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity());
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadFromFile(String path) {
        products.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    long id = Long.parseLong(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    add(new Product(id, name, price, quantity));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Notice: products.csv not found. Starting with an empty database.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}