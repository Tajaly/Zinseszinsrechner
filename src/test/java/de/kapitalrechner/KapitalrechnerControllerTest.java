package de.kapitalrechner;

import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class KapitalrechnerControllerTest {
    //TODO Funktionen der Chekboxen implementieren
    //TODO Rundung auf zwei Nachkommastellen hinzufügen

    @MockBean
    Rechner rechner;

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Startseite unter / ist erreichbar und die Felder sind mit 0 besetzt")
    public void test1 () throws Exception{
        MvcResult result = mvc.perform(get("/")).andExpect(status().isOk())
            .andExpect(model().attributeExists("kapitalForm"))
            .andExpect(view().name("kapitalrechner"))
            .andReturn();
        String html = result.getResponse().getContentAsString();
        CharSequence s = "Zinseszinsrechner";
        assertThat(html).contains(s);
    }

    @Test
    @DisplayName("bei Eingabe mit ungültigen Eingaben sollte zu einer Fehlermeldung führen")
    public void test2 () throws Exception {
        MvcResult result = mvc.perform(get("/submit")
                .param("kapital", "-10")
                .param("laufzeit", "-10")
                .param("zinssatz", "-10"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("kapitalForm"))
            .andExpect(view().name("kapitalrechner"))
            .andReturn();
            String html = result.getResponse().getContentAsString();
            CharSequence s = "das Feld muss eine positive Zahl enthalten!";
            assertThat(html).contains(s);
    }
}
