import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void githubTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("div.wiki-rightbar").$$("div ul").first().shouldHave(text("SoftAssertions"));
        $(byText("Soft assertions")).click();
        String codeText = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """;
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class")).shouldHave(text(codeText));
    }

}