package help;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by ktagintsev on 02.11.15.
 */
public class Helper {

    public static final String ADMIN_TEST_LOGIN = "adminTest";
    public static final String ADMIN_TEST_PASSWORD = "tyn77dc";

    public static final String USER_TEST_LOGIN = "userTest";
    public static final String USER_TEST_PASSWORD = "tyn77dc";

    public static final String LOGIN_BAD = "BAD";
    public static final String PASSWORD_BAD = "tyn77dc";

    public static final String URL = "http://localhost:8080/login";

    public static final String ADD_CLIENT_BUTTON_XPATH = "//*[contains(text(), 'Добавить')]";
    public static final String ADD_CLIENT_FORM_XPATH = "//*[contains(text(), 'Добавление клиента')]";
    public static final String LOGOUT_XPATH = "//*[contains(text(), 'Выход')]";

    public static final String LOGIN_FILED_XPATH = "//input[@name='username']";
    public static final String PASSWORD_FILED_XPATH = "//input[@name='password']";
    public static final String ENTER_BUTTON_XPATH = "//input[@name='commit']";
    public static final String FIRTS_NAME_XPATH = "//input[@name='firstName']";
    public static final String SECOND_NAME_XPATH = "//input[@name='secondName']";
    public static final String LAST_NAME_XPATH = "//input[@name='lastName']";
    public static final String HAPPY_XPATH = "//input[@name='happyBirthday']";
    public static final String HAPPY_151095 = "15/10/95";
    public static final String PHONE_XPATH = "//input[@name='phone']";
    public static final String EMAIL_XPATH = "//input[@name='email']";
    public static final String STATUS_XPATH = "//input[@name='status']";
    public static final String STATUS_01 = "0.1";
    public static final String STATUS_05 = "0.5";
    public static final String STATUS_09 = "0.9";
    public static final String STATUS_1 = "1";
    public static final String SAVE_BUTTON_ADD_CLIENT_XPATH = "//*[contains(text(), 'Сохранить')]";

    public static WebDriver driver;

    /**
     * Инициализировать WebDriver
     */
    public static void init(){
        driver = driver();
        driver.get(URL);
    }

    /**
     * Разлогиниться
     */
    public static void logout(){
        WebElement logout = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGOUT_XPATH)));
        logout.click();
    }

    /**
     * Произвести авторизацию в роле пользователя
     */
    public static void authorizationUser() {
        sendKeysInFieldLoginAndPAssword(USER_TEST_LOGIN, USER_TEST_PASSWORD);
        WebElement enter = driver.findElement(By.xpath(ENTER_BUTTON_XPATH));
        enter.click();
    }

    /**
     * Произвести авторизацию в роле администратора
     */
    public static void authorizationAdmin() {
        sendKeysInFieldLoginAndPAssword(ADMIN_TEST_LOGIN, ADMIN_TEST_PASSWORD);
        WebElement enter = driver.findElement(By.xpath(ENTER_BUTTON_XPATH));
        enter.click();
    }

    /**
     * Произвести неправильную авторизацию
     */
    public static void authorizationBad() {
        sendKeysInFieldLoginAndPAssword(LOGIN_BAD, PASSWORD_BAD);
        WebElement enter = driver.findElement(By.xpath(ENTER_BUTTON_XPATH));
        enter.click();
    }

    /**
     * Заполнить поля "логин" и "пароль" на форме авторизации
     */
    public static void sendKeysInFieldLoginAndPAssword(String log, String pass){
        WebElement login = driver.findElement(By.xpath(LOGIN_FILED_XPATH));
        login.click();
        login.sendKeys(log);

        WebElement password = driver.findElement(By.xpath(PASSWORD_FILED_XPATH));
        password.click();
        password.sendKeys(pass);
    }

    /**
     * Нажать на кнопку "Добавить" на главной форме клиентской базы
     */
    public static void clickAddClientButton(){
        WebElement addClientButton = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_CLIENT_BUTTON_XPATH)));
        addClientButton.click();
    }

    /**
     * Проверить присутствие формы дабвления клиента
     */
    public static void appearedAddClientForm(){
        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_CLIENT_FORM_XPATH)));
        Assert.assertNotNull("Форма добавления клиента не появилась!", addFormClient);
    }

    /**
     * Заполнить поле "имя" на форме добавления клиента
     * @return имя
     */
    public static String sendKeysInFirstName(){
        WebElement element = driver.findElement(By.xpath(FIRTS_NAME_XPATH));
        element.click();
        String firstName = generateString();
        element.sendKeys(firstName);
        return firstName;
    }

    /**
     * Заполнить поле "отчество" на форме добавления клиента
     * @return отчество
     */
    public static String sendKeysInLastName(){
        WebElement element = driver.findElement(By.xpath(LAST_NAME_XPATH));
        element.click();
        String lastName = generateString();
        element.sendKeys(lastName);
        return lastName;
    }

    /**
     * Заполнить поле "фамилия" на форме добавления клиента
     * @return фамилия
     */
    public static String sendKeysInSecondName(){
        WebElement element = driver.findElement(By.xpath(SECOND_NAME_XPATH));
        element.click();
        String secondName = generateString();
        element.sendKeys(secondName);
        return secondName;
    }

    /**
     * Заполнить поле "день рождения" на форме добавления клиента
     * @return день рождения
     */
    public static String sendKeysInHappy(){
        WebElement happyBirthday = driver.findElement(By.xpath(HAPPY_XPATH));
        happyBirthday.click();
        happyBirthday.sendKeys(HAPPY_151095);
        return HAPPY_151095;
    }

    /**
     * Заполнить поле "телефон" на форме добавления клиента
     * @return телефон
     */
    public static String sendKeysInPhone(){
        WebElement element = driver.findElements(By.xpath(PHONE_XPATH)).get(1);
        element.click();
        String phone = generatePhone();
        element.sendKeys(phone);
        return phone;
    }

    /**
     * Заполнить поле "email" на форме добавления клиента
     * @return email
     */
    public static String sendKeysInEmail(){
        WebElement element = driver.findElements(By.xpath(EMAIL_XPATH)).get(1);
        element.click();
        String email = generateEmail();
        element.sendKeys(email);
        return email;
    }

    /**
     * Заполнить поле "Статус" на форме добавления клиента
     * @return status
     */
    public static String sendKeysInStatus(){
        WebElement status = driver.findElement(By.xpath(STATUS_XPATH));
        status.click();
        status.sendKeys(STATUS_1);
        return STATUS_1;
    }

    /**
     * Нажать на кнопку "сохранить" на форме добавления клиента
     */
    public static void clickSaveButtonAddClient(){
        WebElement button = driver.findElement(By.xpath(SAVE_BUTTON_ADD_CLIENT_XPATH));
        button.click();
    }

    /**
     * Проверить присутсвие текста
     */
    public static void assertText(String text){
        try {
            WebElement element = (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '" + text + "')]")));
        } catch (Exception e) {
            Assert.fail("Текст не найден!");
        }
    }

    /**
     * Выбор chromedriver в зависимости от платформы (Windows/Mac)
     * @return driver
     */
    public static WebDriver driver(){

        WebDriver driver = null;
        if(isWindows()){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        if(isMac()){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }

        return driver;
    }

    /**
     * Проверка на Windows
     * @return true or false
     */
    public static boolean isWindows(){

        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf( "win" ) >= 0);

    }

    /**
     * Проверка на Mac
     * @return true or false
     */
    public static boolean isMac(){

        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf( "mac" ) >= 0);

    }

    /**
     * Сгенерировать строку
     * @return текст
     */
    public static String generateString()
    {
        int length = new Random().nextInt(20 - 10 + 1) + 10;
        String characters = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(new Random().nextInt(characters.length()));
        }
        return new String(text);
    }

    /**
     * Сгенерировать email
     * @return email
     */
    public static String generateEmail()
    {
        int length = new Random().nextInt(20 - 10 + 1) + 10;
        String characters = "abcdefghijklmnopqrstuvwxyz";
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(new Random().nextInt(characters.length()));
        }
        return new String(text) + "@mail.ru";
    }

    /**
     * Сгенерировать телефон
     * @return телефон
     */
    public static String generatePhone(){
        int phone = new Random().nextInt(99999999 - 90000000 + 1) + 90000000;
        return String.valueOf(phone);
    }

}
