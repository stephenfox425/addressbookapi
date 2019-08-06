package addressbook.util;

import addressbook.model.CustomerInfo;

public class ModelUtils {

    public static final CustomerInfo badCustomerInfo() {
        CustomerInfo badCust = new CustomerInfo();
        badCust.setId(-1);
        badCust.setForeName("");
        badCust.setSurname("");
        badCust.setAddress("");
        badCust.setContactNumber("");
        return badCust;
    }
}
