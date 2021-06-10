package com.example.demo_mkb.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.demo_mkb.config.Config;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement usernameInput = $(By.id("txtLogin"));
    public SelenideElement passwordInput = $(By.id("txtPassword"));
    public SelenideElement signInButton = $(By.id("btnLoginStandard"));

    public void signInAction(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        signInButton.click();
    }

    // возможно ошибки можно через cssSelector указать, т.к. у разных ошибок они отличаются, но не уверен, поэтому xpath'ы
    public SelenideElement errorMessage = $x("//*[@id='errMessage' and " +
            "contains(text(), 'Ошибка аутентификации.')]");
    public SelenideElement blockedMessage = $x("//*[@id='errMessage' and " +
            "contains(text(), 'Вы ввели неправильный логин / пароль 3 раза.')]");
}
