package addressbook.controller;

import addressbook.data.DataSource;
import addressbook.model.CustomerInfo;
import addressbook.model.SanitisedCustomer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerInformationControllerTest {

    @Mock
    private DataSource dataSourceMock;

    @InjectMocks
    private CustomerInformationControllerImpl CustomerInformationControllerImpl;

    private final List<CustomerInfo> sampleCustomerInfo() {
        List<CustomerInfo> customerInfoList = new ArrayList<>(6);

        CustomerInfo stephen = new CustomerInfo();
        stephen.setId(1);
        stephen.setForeName("Stephen");
        stephen.setSurname("Fox");
        stephen.setAddress("");
        stephen.setContactNumber("");
        customerInfoList.add(stephen);

        CustomerInfo gary = new CustomerInfo();
        gary.setId(2);
        gary.setForeName("Gary");
        gary.setSurname("Fox");
        gary.setAddress("");
        gary.setContactNumber("");
        customerInfoList.add(gary);

        CustomerInfo hawking = new CustomerInfo();
        hawking.setId(3);
        hawking.setForeName("Stephen");
        hawking.setSurname("Hawking");
        hawking.setAddress("");
        hawking.setContactNumber("");
        customerInfoList.add(hawking);

        CustomerInfo king = new CustomerInfo();
        king.setId(4);
        king.setForeName("Stephen");
        king.setSurname("King");
        king.setAddress("");
        king.setContactNumber("");
        customerInfoList.add(king);

        CustomerInfo messi = new CustomerInfo();
        messi.setId(5);
        messi.setForeName("Lionel");
        messi.setSurname("Messi");
        messi.setAddress("");
        messi.setContactNumber("");
        customerInfoList.add(messi);

        CustomerInfo oshea = new CustomerInfo();
        oshea.setId(6);
        oshea.setForeName("John");
        oshea.setSurname("O'Shea");
        oshea.setAddress("");
        oshea.setContactNumber("");
        customerInfoList.add(oshea);

        return customerInfoList;
    }

    @Test
    public void testSearchByValidSurnameReturnsValues() {
        when(dataSourceMock.getCustomers()).thenReturn(sampleCustomerInfo());
        List<SanitisedCustomer> result = CustomerInformationControllerImpl.searchBySurname("Fox");
        List<SanitisedCustomer> expectedResponse = new ArrayList<>();
        SanitisedCustomer stephen = new SanitisedCustomer();
        stephen.setId(1);
        stephen.setForename("Stephen");
        stephen.setSurname("Fox");
        expectedResponse.add(stephen);
        SanitisedCustomer gary = new SanitisedCustomer();
        gary.setId(2);
        gary.setForename("Gary");
        gary.setSurname("Fox");
        expectedResponse.add(gary);
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testSearchWithSpecialCharacterReturnsSingleValue() {
        when(dataSourceMock.getCustomers()).thenReturn(sampleCustomerInfo());
        List<SanitisedCustomer> result = CustomerInformationControllerImpl.searchBySurname("o's");
        List<SanitisedCustomer> expectedResponse = new ArrayList<>();
        SanitisedCustomer oshea = new SanitisedCustomer();
        oshea.setId(6);
        oshea.setForename("John");
        oshea.setSurname("O'Shea");
        expectedResponse.add(oshea);
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testSearchByValidPartialSurnameReturnsSingleValue() {
        when(dataSourceMock.getCustomers()).thenReturn(sampleCustomerInfo());
        List<SanitisedCustomer> result = CustomerInformationControllerImpl.searchBySurname("Haw");
        List<SanitisedCustomer> expectedResponse = new ArrayList<>();
        SanitisedCustomer stephen = new SanitisedCustomer();
        stephen.setId(3);
        stephen.setForename("Stephen");
        stephen.setSurname("Hawking");
        expectedResponse.add(stephen);
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testSearchByInvalidSurnameReturnsEmptyArray() {
        when(dataSourceMock.getCustomers()).thenReturn(sampleCustomerInfo());
        List<SanitisedCustomer> result = CustomerInformationControllerImpl.searchBySurname("invalid surname");
        List<SanitisedCustomer> expectedResponse = new ArrayList<>();
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testSearchByInvalidValuesReturnsEmptyArray() {
        when(dataSourceMock.getCustomers()).thenReturn(sampleCustomerInfo());
        List<SanitisedCustomer> result = CustomerInformationControllerImpl.searchBySurname("12<>34234");
        List<SanitisedCustomer> expectedResponse = new ArrayList<>();
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testSearchByEmptyValueReturnsEmptyArray() {
        when(dataSourceMock.getCustomers()).thenReturn(sampleCustomerInfo());
        List<SanitisedCustomer> result = CustomerInformationControllerImpl.searchBySurname("");
        List<SanitisedCustomer> expectedResponse = new ArrayList<>();
        assertEquals(expectedResponse, result);
    }
}
