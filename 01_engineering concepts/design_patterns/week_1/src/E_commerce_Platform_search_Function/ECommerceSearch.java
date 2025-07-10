package E_commerce_Platform_search_Function;



import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {


	    public static Product linearSearch(Product[] products, int targetId) {
	        for (Product product : products) {
	            if (product.productId == targetId) {
	                return product;
	            }
	        }
	        return null;
	    }

	    public static Product binarySearch(Product[] products, int targetId) {
	        int low = 0;
	        int high = products.length - 1;

	        while (low <= high) {
	            int mid = (low + high) / 2;
	            if (products[mid].productId == targetId) {
	                return products[mid];
	            } else if (products[mid].productId < targetId) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        return null;
	    }

	    public static void main(String[] args) {
	
	        Product[] products = {
	            new Product(103, "Keyboard", "Electronics"),
	            new Product(101, "Shampoo", "Personal Care"),
	            new Product(104, "Monitor", "Electronics"),
	            new Product(102, "Notebook", "Stationery")
	        };

	        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

	        int searchId = 104;
	        System.out.println("Using Linear Search:");
	        Product result1 = linearSearch(products, searchId);
	        if (result1 != null) result1.display();
	        else System.out.println("Product not found!");

	        System.out.println("\nUsing Binary Search:");
	        Product result2 = binarySearch(products, searchId);
	        if (result2 != null) result2.display();
	        else System.out.println("Product not found!");
	    }
	
}
