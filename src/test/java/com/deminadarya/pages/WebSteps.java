package com.deminadarya.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Выполнить поиск введённого наименования репозитория {repo}")
    public void searchRepo(String repo) {
        $(".header-search-input").setValue(repo).pressEnter();
    }

    @Step("Выполнить переход в репозиторий")
    public void goToRepo() {
        $("a[href$='/eroshenkoam/allure-example']").click();
    }

    @Step("Выполнить переход в раздел Issues")
    public void switchToIssue() {
        $("#issues-tab").click();
    }

    @Step("Поиск по тексту названия Issues {nameIssue}")
    public void searchNameIssue(String nameIssue) {
        $("#issue_81_link").shouldHave(text(nameIssue));
    }
}
