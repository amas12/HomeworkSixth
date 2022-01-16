package onlc.dev;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    @Owner("amasgutova7@gmail.com")
    @Feature("IssueSearch")
    @Stories({
            @Story("Проверку Issue в репозитории"),
    })
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://github.com")
    public void testsIssueSearch() {
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("amas12/HomeworkSixth-");
        $(".header-search-input").submit();
        $(linkText("amas12/HomeworkSixth-")).click();
        $(partialLinkText("Issues")).click();
    }
}

