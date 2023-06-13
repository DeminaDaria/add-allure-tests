package com.deminadarya.tests;

import com.codeborne.selenide.Configuration;
import com.deminadarya.pages.WebSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckNameRepoIssueTest {
    @BeforeEach
    void setapp() {
        Configuration.holdBrowserOpen = true;
    }

    private final static String repo =  "eroshenkoam/allure-example";
    private final static String nameIssue =  "issue_to_test_allure_report";
    private WebSteps steps = new WebSteps();

    @Test
    public void shouldHaveIssueNameWithoutAllureReport() {
        open("https://github.com");
        $(".header-search-input").setValue(repo).pressEnter();
        $("a[href$='/eroshenkoam/allure-example']").click();
        $("#issues-tab").click();
        $("#issue_81_link").shouldHave(text(nameIssue));
    }

    @Test
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
    public void shouldHaveIssueNameWithAnnotationStep() {
        steps.openMainPage();
        steps.searchRepo(repo);
        steps.goToRepo();
        steps.switchToIssue();
        steps.searchNameIssue(nameIssue);
    }
}
