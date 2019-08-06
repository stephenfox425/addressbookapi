package addressbook.controller;

import addressbook.data.DataSource;
import addressbook.model.CustomerInfo;
import addressbook.model.SanitisedCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerInformationControllerImpl implements CustomerInformationController {

    @Autowired
    DataSource dataSource;

    @Override
    public List<SanitisedCustomer> searchBySurname(String searchString) {
        List<CustomerInfo> people = dataSource.getCustomers();
        List<SanitisedCustomer> result = new ArrayList<>();
        if(searchString.isEmpty()) {
            //Do nothing, we don't want to expose all customer info on an empty search
        } else {
            for(CustomerInfo person: people) {
                if(person.getSurname().toLowerCase().contains(searchString.toLowerCase())) {
                    SanitisedCustomer sanitisedCustomer = sanitiseCustomer(person);
                    result.add(sanitisedCustomer);
                }
            }
        }
        return result;
    }

    private SanitisedCustomer sanitiseCustomer(CustomerInfo customerInfo) {
        SanitisedCustomer sanitisedCustomer = new SanitisedCustomer();
        sanitisedCustomer.setId(customerInfo.getId());
        sanitisedCustomer.setForename(customerInfo.getForeName());
        sanitisedCustomer.setSurname(customerInfo.getSurname());
        return sanitisedCustomer;
    }

    @Override
    public CustomerInfo getCustomerById(int id) {
        return dataSource.getPersonById(id);
    }
}
