package addressbook.data;

import addressbook.model.CustomerInfo;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class DataSourceJson implements DataSource {

    @Override
    public List<CustomerInfo> getCustomers() {
        return getCustomerInfoFromJSON();
    }

    private List<CustomerInfo> getCustomerInfoFromJSON() {
        JSONArray customerList = readCustomerInfoJSON();
        List<CustomerInfo> customerListResult = new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerInfo customerInfo = new CustomerInfo();
            JSONObject customerObject = (JSONObject) customer;
            customerInfo.setId(((Long) customerObject.get("id")).intValue());
            customerInfo.setForeName((String) customerObject.get("foreName"));
            customerInfo.setSurname((String) customerObject.get("surname"));
            customerInfo.setAddress((String) customerObject.get("address"));
            customerInfo.setContactNumber((String) customerObject.get("contactNumber"));
            customerListResult.add(customerInfo);
        });
        return customerListResult;
    }

    private JSONArray readCustomerInfoJSON() {
        JSONParser jsonParser = new JSONParser();
        JSONArray result = new JSONArray();

        try(FileReader reader = new FileReader("src/main/resources/customer-data.json")) {
            result = (JSONArray) jsonParser.parse(reader);
        } catch(IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CustomerInfo getPersonById(int id) {
        return null;
    }
}
