import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
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
        $("#wiki-tab").shouldBe(visible).click();
        $$(".internal").shouldHave(itemWithText("Soft assertions"));
        open("/selenide/selenide/wiki/SoftAssertions");
        $(byAttribute("href","#3-using-junit5-extend-test-class")).shouldHave(text("3. Using JUnit5 extend test class:"));
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text("SoftAssertsExtension"));
    }
}