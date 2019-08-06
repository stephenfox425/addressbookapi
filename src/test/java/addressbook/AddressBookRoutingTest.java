package addressbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookRoutingTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void searchForFoxAndExpectValidResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search/{surname}", "Fox").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(content().json("[{\"id\":1,\"forename\":\"Stephen\",\"surname\":\"Fox\"},{\"id\":2,\"forename\":\"Gary\",\"surname\":\"Fox\"}]"));
    }

    @Test
    public void searchForHawAndExpectValidResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search/{surname}", "hAw").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(content().json("[{\"id\":3,\"forename\":\"Stephen\",\"surname\":\"Hawking\"}]"));
    }

    @Test
    public void searchForSpecialCharacterAndExpectValidResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search/{surname}", "o's").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(content().json("[{\"id\":6,\"forename\":\"John\",\"surname\":\"O'Shea\"}]"));
    }

    @Test
    public void searchForNumbersAndExpectEmptyResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search/{surname}", "123").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(content().json("[]"));
    }

    @Test
    public void searchForNothingAndExpectInvalidResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search/{surname}", "").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

}
