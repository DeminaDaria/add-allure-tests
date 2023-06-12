package com.deminadarya.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckNameRepoIssueTest {
    @BeforeEach
    void setapp() {
        Configuration.holdBrowserOpen = true;
    }


    @Test
    public void shouldHaveIssueNameWithoutAllureReport() {
        open("https://github.com");
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();
        $("a[href$='/eroshenkoam/allure-example']").click();
        $("#issues-tab").click();
        $("#issue_81_link").shouldHave(text("issue_to_test_allure_report"));
    }

    @Test
    public void shouldHaveIssueNameWithLambdaStep() {

    }

    @Test
    public void shouldHaveIssueNameWithAnnotationStep() {

    }

}
