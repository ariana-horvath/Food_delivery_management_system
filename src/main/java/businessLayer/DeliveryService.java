package businessLayer;
import exception.InputValidationFailedException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Delivery service.
 * - does the main operations of the application: manages products, manages orders, creates reports.
 * @author Ariana Horvath
 * @invariant isWellFormed()
 */
public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {

    private static final long serialVersionUID = 1L;
    private Map<String, User> users;
    private List<MenuItem> menuItems;
    private String compositeProductString;
    private int orderId;
    private Map<Order, ArrayList<MenuItem>> orders;

    /**
     * Instantiates a new Delivery service.
     */
    public DeliveryService() {
        users = new HashMap<>();
        menuItems = new ArrayList<>();
        orders = new HashMap<>();
    }

    @Override
    public void registerUser(User user) {
        assert user != null;
        assert isWellFormed();
        int preSize = users.size();

        if (users.containsKey(user.getUsername()))
            throw new InputValidationFailedException(user.getRole() + " username already existent.");
        users.put(user.getUsername(), user);

        int postSize = users.size();
        assert postSize == preSize + 1;
        assert isWellFormed();
    }

    @Override
    public void logInUser(String username, String password, Role role) {
        assert username != null && !username.isBlank();
        assert password != null && !password.isBlank();
        assert role != null;
        assert isWellFormed();

        User user = users.get(username);
        if (user == null || user.getRole() != role)
            throw new InputValidationFailedException("Invalid " + role +" username.");
        if (user.getPassword().compareTo(password) != 0)
            throw  new InputValidationFailedException("Invalid "+ role +" password.");

        assert isWellFormed();
    }

    @Override
    public void importProducts() {
        assert isWellFormed();
        if(menuItems.size() > 0)
            throw new InputValidationFailedException("Menu items list is not empty, you will lose the data!");
        List<MenuItem> inputList;
        try { File inputFile = new File("products.csv");
            InputStream inputStream = new FileInputStream(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            inputList = bufferedReader.lines()
                    .skip(1)
                    .map((line) -> {
                        String[] lineString = line.split(",");
                        return new BaseProduct(lineString[0], Double.parseDouble(lineString[1]), Integer.parseInt(lineString[2]),
                                Integer.parseInt(lineString[3]), Integer.parseInt(lineString[4]), Integer.parseInt(lineString[5]),
                                Integer.parseInt(lineString[6]));
                    })
                    .collect(Collectors.toList());
            bufferedReader.close();

            Map<String, MenuItem> itemMap = new HashMap<>();
            for (MenuItem menuItem : inputList)
                itemMap.put(menuItem.getTitle(), menuItem);

            for (String key : itemMap.keySet())
                menuItems.add(itemMap.get(key));

            menuItems = menuItems.stream().sorted(Comparator.comparing(MenuItem::getTitle)).collect(Collectors.toList());
            assert menuItems.size() > 0;
            assert isWellFormed();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBaseProduct(MenuItem menuItem) {
        assert menuItem != null;
        assert !menuItem.getTitle().isBlank();
        assert menuItem.getRating() >= 0 && menuItem.getRating() <= 5;
        assert menuItem.getCalories() >= 0;
        assert menuItem.getFat() >= 0;
        assert menuItem.getSodium() >= 0;
        assert menuItem.getProtein() >= 0;
        assert menuItem.getPrice() >= 0;
        assert isWellFormed();
        int preSize = menuItems.size();

        for (MenuItem item : menuItems) {
            if (menuItem.getTitle().compareTo(item.getTitle()) == 0)
                throw new InputValidationFailedException("Product already existent!");
        }
        menuItems.add(menuItem);

        int postSize = menuItems.size();
        assert postSize == preSize + 1;
        assert isWellFormed();
    }

    @Override
    public void updateBaseProduct(MenuItem menuItem) {
        assert menuItem != null;
        assert !menuItem.getTitle().isBlank();
        assert menuItem.getRating() >= 0 && menuItem.getRating() <= 5;
        assert menuItem.getCalories() >= 0;
        assert menuItem.getFat() >= 0;
        assert menuItem.getSodium() >= 0;
        assert menuItem.getProtein() >= 0;
        assert menuItem.getPrice() >= 0;
        assert isWellFormed();
        int preSize = menuItems.size();

        boolean found = false;
        for (MenuItem item : menuItems) {
            if (menuItem.getTitle().compareTo(item.getTitle()) == 0) {
                found = true;
                item.setTitle(menuItem.getTitle());
                item.setRating(menuItem.getRating());
                item.setCalories(menuItem.getCalories());
                item.setProtein(menuItem.getProtein());
                item.setFat(menuItem.getFat());
                item.setSodium(menuItem.getSodium());
                item.setPrice(menuItem.getPrice());
            }
        }
        if (!found)
            throw new InputValidationFailedException("Product to update is not existent!");

        int postSize = menuItems.size();
        assert postSize == preSize;
        assert isWellFormed();
    }

    @Override
    public void deleteBaseProduct(String menuItemTitle) {
        assert menuItemTitle != null && !menuItemTitle.isBlank();
        assert isWellFormed();
        int preSize = menuItems.size();

        int index = -1;
        for (MenuItem item : menuItems) {
            if (menuItemTitle.compareTo(item.getTitle()) == 0) {
                index = menuItems.indexOf(item);
            }
        }
        if (index == -1)
            throw new InputValidationFailedException("Product to delete is not existent!");
        menuItems.remove(index);

        int postSize = menuItems.size();
        assert postSize == preSize - 1;
        assert isWellFormed();
    }

    @Override
    public void addCompositeProduct(String title, String products) {
        assert title != null && !title.isBlank();
        assert products != null && !products.isBlank();
        assert isWellFormed();
        int preSize = menuItems.size();

        for (MenuItem item : menuItems) {
            if (item.getTitle().compareTo(title) == 0)
                throw new InputValidationFailedException("Composite Product title already existent!");
        }
        double rating = 0;
        int calories = 0, protein = 0, fat = 0, sodium = 0, price = 0;
        String[] product = products.split(",");
        ArrayList<MenuItem> composite = new ArrayList<>();
        for (String prod : product) {
            prod = prod.replaceAll("\\s+", "");
            boolean found = false;
            for (MenuItem item : menuItems) {
                String titleS = item.getTitle().replaceAll("\\s+", "");
                if (titleS.compareTo(prod) == 0) {
                    found = true;
                    composite.add(item);
                    rating += item.getRating();
                    calories += item.getCalories();
                    protein += item.getProtein();
                    fat += item.getFat();
                    sodium += item.getSodium();
                    price += item.getPrice();
                }
            }
            if (!found) throw new InputValidationFailedException(prod + " is not existent in the menu!");
        }
        rating = rating / composite.size();
        menuItems.add(new CompositeProduct(title, rating, calories, protein, fat, sodium, price, composite));

        int postSize = menuItems.size();
        assert postSize == preSize + 1;
        assert isWellFormed();
    }

    @Override
    public List<MenuItem> searchProducts(String title, String rating, String calories, String protein, String fat, String sodium, String price) {
        assert isWellFormed();

        List<MenuItem> filteredItems = new ArrayList<>(menuItems);
        Stream<MenuItem> stream = filteredItems.stream();
        try {
            if (!title.isEmpty())
                stream = stream.filter(product -> product.getTitle().contains(title));
            if (rating.compareTo("") != 0)
                stream = stream.filter(product -> product.getRating() == Double.parseDouble(rating));
            if (calories.compareTo("") != 0)
                stream = stream.filter(product -> product.getCalories() == Integer.parseInt(calories));
            if (protein.compareTo("") != 0)
                stream = stream.filter(product -> product.getProtein() == Integer.parseInt(protein));
            if (fat.compareTo("") != 0)
                stream = stream.filter(product -> product.getFat() == Integer.parseInt(fat));
            if (sodium.compareTo("") != 0)
                stream = stream.filter(product -> product.getSodium() == Integer.parseInt(sodium));
            if (price.compareTo("") != 0)
                stream = stream.filter(product -> product.getPrice() == Integer.parseInt(price));

            assert isWellFormed();
            return stream.collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputValidationFailedException("Input is not a number!");
        }
    }

    @Override
    public void createOrder(String client, String products) {
        assert client != null && !client.isBlank();
        assert products != null && !products.isBlank();
        assert isWellFormed();
        int preSize = orders.size();

        compositeProductString = "";
        ArrayList<MenuItem> orderedItems = new ArrayList<>();
        User user = users.get(client);
        if (user == null || user.getRole() != Role.CLIENT)
            throw new InputValidationFailedException("Invalid client username.");

        int price = 0;
        String[] product = products.split("\n");
        for(String prod : product) {
            prod = prod.replaceAll("\\s+", "");
            boolean found = false;
            for(MenuItem item : menuItems) {
                String title = item.getTitle().replaceAll("\\s+", "");
                if(title.compareTo(prod) == 0){
                    found = true;
                    price += item.getPrice();
                    if (item instanceof BaseProduct)
                        compositeProductString = compositeProductString + item.getTitle() + "\n";
                    else extractProducts((CompositeProduct) item);
                    orderedItems.add(item);
                }
            }
            if (!found) throw new InputValidationFailedException(prod + " is not existent in the menu!");
        }
        orderId = idGenerator() + 1;
        Order order = new Order(orderId, client, LocalDateTime.now(), compositeProductString, price);
        orders.put(order, orderedItems);
        createBill(order);
        String stringForEmployee = "\nOrder id: " + orderId + "\nClient: " + client + "\n" + compositeProductString;
        setChanged();
        notifyObservers(stringForEmployee);

        int postSize = orders.size();
        assert postSize == preSize + 1;
        assert isWellFormed();
    }

    @Override
    public void createBill(Order order) {
        assert order != null;
        assert isWellFormed();

        FileWriter writer;
        try {
            writer = new FileWriter("Bill" + order.getOrderID()+".txt");
            writer.append("Bill \nOrder ID: " + order.getOrderID() + "\nClient: " + order.getClientID()+"\n\nPlaced at: "+ order.getOrderDate()
                         + "\n\nOrdered products:\n" + order.getProducts() + "\nTotal: " + order.getPrice());
            writer.close();
            assert isWellFormed();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport1(int startHourMinutes, int endHourMinutes) {
        assert startHourMinutes >= 0 && endHourMinutes >= 0;
        assert isWellFormed();

        List<Order> ordersR1 = orders.keySet()
                                     .stream()
                                     .filter(order -> {
                                         int hour = order.getOrderDate().getHour() * 60 + order.getOrderDate().getMinute();
                                         return hour >= startHourMinutes && hour <= endHourMinutes; })
                                     .collect(Collectors.toList());
        FileWriter writer;
        try {
            writer = new FileWriter("Report1.txt");
            writer.append("Orders placed between " + startHourMinutes/60 + ":" + startHourMinutes%60 + " and " + endHourMinutes/60 + ":"+ endHourMinutes%60);
            for(Order order : ordersR1) {
                writer.append("\n\nOrder ID: " + order.getOrderID() + "\nClient: " + order.getClientID()+"Placed at: "+ order.getOrderDate()
                        + "\nOrdered products:\n" + order.getProducts() + "Total: " + order.getPrice());
            }
            writer.close();
            assert isWellFormed();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport2(int nbOfTimes) {
        assert nbOfTimes >= 0;
        assert isWellFormed();

        Stream<MenuItem> stream = Stream.of();
        for(Order order : orders.keySet()) {
            stream = Stream.concat(stream, orders.get(order).stream());
        }
        List<MenuItem> products = stream.collect(Collectors.toList());
        List<MenuItem> products2 = products.stream()
                                           .filter(item -> Collections.frequency(products, item) > nbOfTimes)
                                           .distinct()
                                           .collect(Collectors.toList());
        FileWriter writer;
        try {
            writer = new FileWriter("Report2.txt");
            writer.append("Products ordered more then " + nbOfTimes + " times: \n\n");
            for(MenuItem item : products2) {
                writer.append(item.getTitle() + "\n");
            }
            writer.close();
            assert isWellFormed();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport3(int nbOfTimes, int amount) {
        assert nbOfTimes >= 0;
        assert amount >= 0;
        assert isWellFormed();

        List<String> clients = orders.keySet()
                                     .stream()
                                     .filter(order -> order.getPrice() > amount)
                                     .map(Order::getClientID)
                                     .collect(Collectors.toList());
        List<String> clients2 = clients.stream()
                                       .filter(c -> Collections.frequency(clients, c) > nbOfTimes)
                                       .distinct()
                                       .collect(Collectors.toList());
        FileWriter writer;
        try {
            writer = new FileWriter("Report3.txt");
            writer.append("The clients that have ordered more than "+ nbOfTimes +" times and the value of the order was higher than " +
                            amount + "\n\n");
            for (String client : clients2) {
                writer.append(client + "\n");
            }
            writer.close();
            assert isWellFormed();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport4(int day, int month, int year) {
        assert day >= 0 && day <= 31;
        assert month >= 0 && month <= 12;
        assert year >= 0 && year <= LocalDateTime.now().getYear();
        assert isWellFormed();

        Stream<MenuItem> stream = Stream.of();
        for(Order order : orders.keySet()) {
            if (order.getOrderDate().getDayOfMonth() == day && order.getOrderDate().getMonthValue() == month &&
                    order.getOrderDate().getYear() == year)
            stream = Stream.concat(stream, orders.get(order).stream());
        }
        List<MenuItem> products = stream.collect(Collectors.toList());
        Map<MenuItem, Long> myProducts = products.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        FileWriter writer;
        try {
            writer = new FileWriter("Report4.txt");
            writer.append("Products ordered on "+day+"/"+month+"/"+year+"\n\n");
            for(MenuItem product : myProducts.keySet()) {
                writer.append(product.getTitle() + " " + myProducts.get(product) + "\n");
            }
            writer.close();
            assert isWellFormed();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean isWellFormed() {
        if (users == null || menuItems == null || orders == null)

        if (users.size() > 0)
            for (String username : users.keySet()) {
                if (users.get(username) == null ) return false;
                if (users.get(username).getUsername() == null || users.get(username).getUsername().isBlank()) return false;
                if (users.get(username).getPassword() == null || users.get(username).getPassword().isBlank()) return false;
                if (users.get(username).getRole() == null) return false;
            }

        if (menuItems.size() > 0)
            for (MenuItem item : menuItems) {
                if (item == null ) return false;
                if (item.getTitle() == null || item.getTitle().isBlank()) return false;
                if (item.getRating() < 0 || item.getRating() > 5) return false;
                if (item.getCalories() < 0) return false;
                if (item.getProtein() < 0) return false;
                if (item.getFat() < 0) return false;
                if (item.getSodium() < 0) return false;
                if (item.getPrice() < 0) return false;
            }
        else return orders.size() <= 0;

        if (orders.size() > 0)
            for (Order order : orders.keySet()) {
                if (order == null) return false;
                if (orders.get(order) == null || orders.get(order).size() == 0) return false;
                if (order.getOrderID() == 0) return false;
                if (order.getOrderDate() == null) return false;
                if (order.getOrderDate().isAfter(LocalDateTime.now())) return false;
                if (order.getClientID() == null || order.getClientID().isBlank()) return false;
                if (order.getPrice() < 0) return false;
            }
        return true;
    }

    /**
     * Create products JTable.
     * @param list the list of menu items
     * @return the JTable
     */
    public JTable createProductsTable(List<MenuItem> list) {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("Title");
        columns.add("Rating");
        columns.add("Calories");
        columns.add("Protein");
        columns.add("Fat");
        columns.add("Sodium");
        columns.add("Price");

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns.toArray());
        for (MenuItem item : list) {
            ArrayList<String> menuItems = new ArrayList<>();
            menuItems.add(item.getTitle());
            menuItems.add(Double.toString(item.getRating()));
            menuItems.add(Integer.toString(item.getCalories()));
            menuItems.add(Integer.toString(item.getProtein()));
            menuItems.add(Integer.toString(item.getFat()));
            menuItems.add(Integer.toString(item.getSodium()));
            menuItems.add(Integer.toString(item.getPrice()));

            model.addRow(menuItems.toArray());
        }
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getTableHeader().setBackground(new Color(234, 144, 173, 255));
        table.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 14));
        table.getTableHeader().setForeground(new Color(146, 8, 51, 255));
        table.setRowHeight(20);
        table.setBackground(new Color(246, 218, 227, 255));
        table.setForeground(new Color(146, 8, 51, 255));
        table.setGridColor(new Color(146, 8, 51, 255));
        table.setFont(new Font("Calibri", Font.PLAIN, 14));
        return table;
    }

    /**
     * Create composite product string.
     * @param menuItemS the menu item string
     * creates the string with the items of the composite product
     * @return the string
     */
    public String createCProductString(String menuItemS) {
        compositeProductString = "";
        boolean found = false;
        for (MenuItem item : menuItems) {
            if (item.getTitle().compareTo(menuItemS) == 0) {
                found = true;
                if (item instanceof BaseProduct)
                    throw new InputValidationFailedException("Product is not composite!");
                extractProducts((CompositeProduct) item);
            }
        }
        if (!found) throw new InputValidationFailedException("Product is not existent!");
        return compositeProductString;
    }

    /**
     * Extract products.
     * @param product the composite product
     * - creates using recursion the string with the items of the composite product
     */
    public void extractProducts(CompositeProduct product) {
        for(MenuItem item : product.getCompositeProduct()) {
            if (item instanceof BaseProduct)
                compositeProductString = compositeProductString + item.getTitle() + "\n";
            else extractProducts((CompositeProduct) item);
        }
    }

    /**
     * Id generator int.
     *
     * @return the int: the max id of the existent orders
     */
    public int idGenerator() {
        int max = 0;
        for(Order order : orders.keySet()) {
            if (order.getOrderID() > max)
                max = order.getOrderID();
        }
        return max;
    }

    /**
     * Gets menu items.
     *
     * @return the menu items
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
