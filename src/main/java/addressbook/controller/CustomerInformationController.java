package addressbook.controller;

import addressbook.model.SanitisedCustomer;

import java.util.List;

public interface CustomerInformationController {

    List<SanitisedCustomer> searchBySurname(String surname);
}
