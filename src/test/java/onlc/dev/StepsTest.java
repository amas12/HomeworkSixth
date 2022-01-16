package onlc.dev;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsTest {
    private static final String REPOSITOPY = "amas12/HomeworkSixth-";

    @Test
    @Owner("amasgutova7@gmail.com")
    @Feature("IssueSearch")
    @Stories({
            @Story("Проверку Issue в репозитории"),
    })
    @Severity(SeverityLevel.BLOCKER)
    public void lambdaStepTest() {

        step("Открываем страницу", () -> {
            open("https://github.com/");
        });
        step("ищем репозидорий" + REPOSITOPY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITOPY);
            $(".header-search-input").submit();
        });
        step("переходим репозидорий" + REPOSITOPY, () -> {
            $(linkText(REPOSITOPY)).click();
        });
        step("Открываем таб issue", () -> {
            $(partialLinkText("Issues")).click();
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $(partialLinkText("Issues")).click();
        });

    }

    @Test
    @Owner("amasgutova7@gmail.com")
    @Feature("IssueSearch")
    @Stories({
            @Story("Проверку Issue в репозитории"),
    })
    @Severity(SeverityLevel.BLOCKER)
    public void annotatedStepTest() {
        AttachmentsTest steps = new AttachmentsTest();
        steps.openGithub();
        steps.openRepository(REPOSITOPY);
        steps.enterRepository(REPOSITOPY);
        steps.openIssues();

    }

}
