package com.example.demo_mkb.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.example.demo_mkb.config.Config;
import com.example.demo_mkb.page.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MkbTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.timeout = 10 * 1000; //microseconds
    }

    @BeforeEach
    public void setUp() {
        open(Config.base_url);
    }

    @Test
    public void blockingLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.signInAction(Config.username, Config.password);
        loginPage.errorMessage.shouldHave(Condition.text("Ошибка аутентификации."));

        loginPage.signInAction(Config.username, Config.password);
        loginPage.errorMessage.shouldHave(Condition.text("Ошибка аутентификации."));

        loginPage.signInAction(Config.username, Config.password);
        loginPage.blockedMessage.shouldHave(Condition.text("Вы ввели неправильный логин / пароль 3 раза."));
    }
}
