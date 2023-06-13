package com.deminadarya.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.deminadarya.pages.WebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckNameRepoIssueTest {

    private final static String repo = "eroshenkoam/allure-example";
    private final static String nameIssue = "issue_to_test_allure_report";
    private final WebSteps steps = new WebSteps();

    @Test
    @Feature("Issues")
    @Story("Поиск по названию Issues")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Selenide.Название Issue содержится в разделе Issues")
    public void shouldHaveIssueNameWithoutAllureReport() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").setValue(repo).pressEnter();
        $("a[href$='/eroshenkoam/allure-example']").click();
        $("#issues-tab").click();
        $("#issue_81_link").shouldHave(text(nameIssue));
    }

    @Test
    @Feature("Issues")
    @Story("Поиск по названию Issues")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("LambdaStep.Название Issue содержится в разделе Issues")
    public void shouldHaveIssueNameWithLambdaStep() {
        step("Открыть главную страницу",
                () -> open("https://github.com"));
        step("Выполнить поиск введённого наименования репозитория",
                () -> {
                    $(".header-search-input").setValue(repo).pressEnter();
                });
        step("Выполнить переход в репозиторий",
                () -> $("a[href$='/eroshenkoam/allure-example']").click());
        step("Выполнить переход в раздел Issues",
                () -> $("#issues-tab").click());
        step("Поиск по тексту названия Issues",
                () -> {
                    $("#issue_81_link").shouldHave(text(nameIssue));
                });
    }

    @Test
    @Feature("Issues")
    @Story("Поиск по названию Issues")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("AnnotationStep.Название Issue содержится в разделе Issues")
    public void shouldHaveIssueNameWithAnnotationStep() {
        steps.openMainPage();
        steps.searchRepo(repo);
        steps.goToRepo();
        steps.switchToIssue();
        steps.searchNameIssue(nameIssue);
    }
}
