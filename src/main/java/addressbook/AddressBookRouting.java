package addressbook;

import addressbook.controller.CustomerInformationController;
import addressbook.model.CustomerInfo;
import addressbook.util.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookRouting {

    @Autowired
    CustomerInformationController customerInformationController;

    @RequestMapping("/search/{surname}")
    public ResponseEntity search(@PathVariable("surname") String surname) {
        return ResponseEntity.ok(customerInformationController.searchBySurname(surname));
    }

    @RequestMapping("/lookup/{customerId}")
    public ResponseEntity lookup(@PathVariable("customerId") int customerId) {
        CustomerInfo response = customerInformationController.getCustomerById(customerId);
        if(response.equals(ModelUtils.badCustomerInfo())) {
            return ResponseEntity.badRequest().body("Invalid Customer ID");
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
