package addressbook.data;

import addressbook.model.CustomerInfo;

import java.util.List;

public interface DataSource {

    List<CustomerInfo> getCustomers();

    CustomerInfo getPersonById(int id);
}
