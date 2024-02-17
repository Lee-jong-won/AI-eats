package Personal.AIEats.Controller;
public class Pizzaform {
private Long Menu_price;
private String Menu_name;
private String Delivery_location;

    public String getDelivery_location() {
        return Delivery_location;
    }

    public void setDelivery_location(String delivery_location) {
        Delivery_location = delivery_location;
    }

    private Long user_id;


    public Long getMenu_price() {
        return Menu_price;
    }

    public void setMenu_price(Long menu_price) {
        Menu_price = menu_price;
    }

    public String getMenu_name() {
        return Menu_name;
    }

    public void setMenu_name(String menu_name) {
        Menu_name = menu_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
