package Personal.AIEats.domain;

import jakarta.persistence.*;


@Entity
@Table(name="order_request")
public class order_request {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Request_num;
    private String User_Request_id;
    private String Delivery_status;
    private String Delivery_location;
    private String Menu_name;
    private Long Menu_price;

    public Long getRequest_num() {
        return Request_num;
    }

    public void setRequest_num(Long request_num) {
        Request_num = request_num;
    }

    public String getUser_Request_id() {
        return User_Request_id;
    }

    public void setUser_Request_id(String user_Request_id) {
        User_Request_id = user_Request_id;
    }

    public String getDelivery_status() {
        return Delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        Delivery_status = delivery_status;
    }

    public String getDelivery_location() {
        return Delivery_location;
    }

    public void setDelivery_location(String delivery_location) {
        Delivery_location = delivery_location;
    }

    public String getMenu_name() {
        return Menu_name;
    }

    public void setMenu_name(String menu_name) {
        Menu_name = menu_name;
    }

    public Long getMenu_price() {
        return Menu_price;
    }

    public void setMenu_price(Long menu_price) {
        Menu_price = menu_price;
    }
}

