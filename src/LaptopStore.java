import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Windows 10", "Black"));
        laptops.add(new Laptop("Windows 11", "White"));
        laptops.add(new Laptop("macOS", "Black"));
        laptops.add(new Laptop("macOS", "Gray"));
        laptops.add(new Laptop("Linux", "White"));

        Map<Integer, String> crit = new HashMap<>();
        crit.put(1, "Операционная система");
        crit.put(2, "Цвет");

        Scanner scan = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        boolean continueFiltering = true;

        while (continueFiltering) {

        System.out.println("Введите цифру, соответствующую необходимому критерию:");

        for (Map.Entry<Integer, String> entry : crit.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        int criterion = scan.nextInt();
        scan.nextLine();

        switch (criterion) {
        
            case 1:
                System.out.print("Введите операционную систему: ");
                filters.put("os", scan.nextLine());
                break;

            case 2:
                System.out.print("Введите цвет: ");
                filters.put("color", scan.nextLine());
                break;

            default:
                System.out.println("Некорректный критерий.");

            }

            System.out.print("Хотите добавить еще один критерий? (yes/no): ");
            String response = scan.nextLine();
            continueFiltering = response.equalsIgnoreCase("yes");
        }

        filterLaptops(laptops, filters);
        scan.close();
    }

    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {

        for (Laptop laptop : laptops) {
            boolean matches = true;
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) matches = false;

            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String)filters.get("color"))) matches = false;

            if (matches) System.out.println(laptop);
        }
    }
}
