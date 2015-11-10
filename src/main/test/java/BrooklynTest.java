package java;

import help.Helper;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

/**
 * Created by ktagintsev on 30.09.15.
 */
public class BrooklynTest {

    public BrooklynTest(){
        Helper.init();
    }

    @After
    public void logout(){
        Helper.logout();
    }

    @AfterClass
    public static void close(){
        Helper.driver.close();
    }

    /**
     * Тестирование добавления клиента без доп. контактов и истории разговора
     * */
    @Test
    public void addClientWithoutParentAndStoreTest() {

        //Подготовка
        Helper.authorizationUser();
        Helper.clickAddClientButton();
        Helper.appearedAddClientForm();
        String firstName = Helper.sendKeysInFirstName();
        String secondName = Helper.sendKeysInSecondName();
        String lastName = Helper.sendKeysInLastName();
        String happy = Helper.sendKeysInHappy();
        String phone = Helper.sendKeysInPhone();
        String email = Helper.sendKeysInEmail();
        String status = Helper.sendKeysInStatus();
        Helper.clickSaveButtonAddClient();

        //Проверка
        Helper.assertText(firstName);
        Helper.assertText(phone);
        Helper.assertText(email);
        Helper.assertText(status);

    }


    /*
    /*Удаление клиента

    public static void deleteClientTest(WebDriver driver) throws InterruptedException {
        WebElement firstNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'КонстантинЛАЛ')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "КонстантинЛАЛ".equals(firstNameInGrid.getText()));
        firstNameInGrid.click();

        WebElement deleteClientButton = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Удалить')]")));
        deleteClientButton.click();
        WebElement deleteFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Удалить сотрудника')]")));

        WebElement yesButton = driver.findElements(By.xpath("//*[contains(text(), 'Да')]")).get(1);
        yesButton.click();

        Thread.sleep(5000);

    }

    */
    /*Редактирование клиента

    public static void editClientTest(WebDriver driver) throws InterruptedException {
        WebElement firstNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Константин')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "Константин".equals(firstNameInGrid.getText()));

        Actions builder = new Actions(driver);
        //build the action chain.
        Action doubleclick = builder.doubleClick(firstNameInGrid).build();
        //perform the double click action
        doubleclick.perform();

        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавление клиента')]")));

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.click();
        firstName.sendKeys("ЛАЛ");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.click();
        lastName.sendKeys("ЛАЛ");

        WebElement secondName = driver.findElement(By.xpath("//input[@name='secondName']"));
        secondName.click();
        secondName.sendKeys("ЛАЛ");

        WebElement happyBirthday = driver.findElement(By.xpath("//input[@name='happyBirthday']"));
        happyBirthday.click();
        happyBirthday.clear();
        happyBirthday.sendKeys("20/06/15");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.click();
        phone.clear();
        phone.sendKeys("12345678");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.click();
        email.clear();
        email.sendKeys("lal@lal.lal");

        WebElement status = driver.findElement(By.xpath("//input[@name='status']"));
        status.click();
        status.clear();
        status.sendKeys("0.1");

        WebElement saveButton = driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]"));
        saveButton.click();

        WebElement testNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'КонстантинЛАЛ')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "КонстантинЛАЛ".equals(testNameInGrid.getText()));

        Thread.sleep(5000);

    }

    */

    /*Добавление родственника при создание клиента

    public static void addParentInAddClientTest(WebDriver driver) throws InterruptedException {
        WebElement addClientButton = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавить')]")));
        addClientButton.click();
        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавление клиента')]")));

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.click();
        firstName.sendKeys("Константин");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.click();
        lastName.sendKeys("Тагинцев");

        WebElement secondName = driver.findElement(By.xpath("//input[@name='secondName']"));
        secondName.click();
        secondName.sendKeys("Дмитриевич");

        WebElement happyBirthday = driver.findElement(By.xpath("//input[@name='happyBirthday']"));
        happyBirthday.click();
        happyBirthday.sendKeys("20/06/91");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.click();
        phone.sendKeys("89080434717");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.click();
        email.sendKeys("k.tagintsev@gmail.com");

        WebElement status = driver.findElement(By.xpath("//input[@name='status']"));
        status.click();
        status.sendKeys("0.5");

        WebElement addParentButton = driver.findElements(By.xpath("//*[contains(text(), 'Добавить')]")).get(1);
        addParentButton.click();

        WebElement saveButton = driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]"));
        saveButton.click();

        saveButton = driver.findElements(By.xpath("//*[contains(text(), 'Сохранить')]")).get(1);
        saveButton.click();

        WebElement testNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Константин')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "Константин".equals(testNameInGrid.getText()));
        WebElement testPhoneInGrid = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '89080434717')]")));
        assertTrue("Данные в столбце 'Телефон' не совпадают!", "89080434717".equals(testPhoneInGrid.getText()));
        WebElement testEmailInGrid = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'k.tagintsev@gmail.com')]")));
        assertTrue("Данные в столбце 'E-mail' не совпадают!", "k.tagintsev@gmail.com".equals(testEmailInGrid.getText()));
        WebElement testStatusInGrid = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '0.5')]")));
        assertTrue("Данные в столбце 'Статус' не совпадают!", "0.5".equals(testStatusInGrid.getText()));

        Thread.sleep(5000);

    }

    */

    /*Редактирование родственника при редактирование клиента

    public static void editParentInEditClientTest(WebDriver driver) throws InterruptedException {
        WebElement firstNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Константин')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "Константин".equals(firstNameInGrid.getText()));

        Actions builder = new Actions(driver);
        //build the action chain.
        Action doubleclick = builder.doubleClick(firstNameInGrid).build();
        //perform the double click action
        doubleclick.perform();

        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавление клиента')]")));

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.click();
        firstName.sendKeys("ЛАЛ");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.click();
        lastName.sendKeys("ЛАЛ");

        WebElement secondName = driver.findElement(By.xpath("//input[@name='secondName']"));
        secondName.click();
        secondName.sendKeys("ЛАЛ");

        WebElement happyBirthday = driver.findElement(By.xpath("//input[@name='happyBirthday']"));
        happyBirthday.click();
        happyBirthday.clear();
        happyBirthday.sendKeys("20/06/15");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.click();
        phone.clear();
        phone.sendKeys("12345678");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.click();
        email.clear();
        email.sendKeys("lal@lal.lal");

        WebElement status = driver.findElement(By.xpath("//input[@name='status']"));
        status.click();
        status.clear();
        status.sendKeys("0.1");

        WebElement parentInGrid = driver.findElement(By.xpath("//*[contains(text(), 'Иванов')]"));
        assertTrue("Данные в столбце 'Фамилия' не совпадают!", "Иванов".equals(parentInGrid.getText()));

        builder = new Actions(driver);
        //build the action chain.
        doubleclick = builder.doubleClick(parentInGrid).build();
        //perform the double click action
        doubleclick.perform();

        parentInGrid = driver.findElements(By.xpath("//input[@name='secondName']")).get(1);
        parentInGrid.click();
        parentInGrid.clear();
        parentInGrid.sendKeys("Сидоров");

        parentInGrid = driver.findElements(By.xpath("//input[@name='firstName']")).get(1);
        parentInGrid.click();
        parentInGrid.clear();
        parentInGrid.sendKeys("Илья");

        parentInGrid = driver.findElements(By.xpath("//input[@name='lastName']")).get(1);
        parentInGrid.click();
        parentInGrid.clear();
        parentInGrid.sendKeys("Ильич");

        parentInGrid = driver.findElement(By.xpath("//input[@name='kin']"));
        parentInGrid.click();
        parentInGrid.clear();
        parentInGrid.sendKeys("батя");

        parentInGrid = driver.findElements(By.xpath("//input[@name='phone']")).get(1);
        parentInGrid.click();
        parentInGrid.clear();
        parentInGrid.sendKeys("123");

        parentInGrid = driver.findElements(By.xpath("//input[@name='email']")).get(1);
        parentInGrid.click();
        parentInGrid.clear();
        parentInGrid.sendKeys("b-boyila@mail.ru");

        WebElement saveButton = driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]"));
        saveButton.click();

        WebElement testNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Илья')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "Илья".equals(testNameInGrid.getText()));

        saveButton = driver.findElements(By.xpath("//*[contains(text(), 'Сохранить')]")).get(1);
        saveButton.click();

        Thread.sleep(5000);

    }

    */

    /*Удаление родственника при редактирование клиента

    public static void deleteParentInEditClientTest(WebDriver driver) throws InterruptedException {
        WebElement firstNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'КонстантинЛАЛ')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "КонстантинЛАЛ".equals(firstNameInGrid.getText()));

        Actions builder = new Actions(driver);
        //build the action chain.
        Action doubleclick = builder.doubleClick(firstNameInGrid).build();
        //perform the double click action
        doubleclick.perform();

        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавление клиента')]")));

        WebElement parentInGrid = driver.findElement(By.xpath("//*[contains(text(), 'Сидоров')]"));
        assertTrue("Данные в столбце 'Фамилия' не совпадают!", "Сидоров".equals(parentInGrid.getText()));
        parentInGrid.click();

        WebElement deleteButton = driver.findElements(By.xpath("//*[contains(text(), 'Удалить')]")).get(2);
        deleteButton.click();

        WebElement yesButton = driver.findElements(By.xpath("//*[contains(text(), 'Да')]")).get(1);
        yesButton.click();

        WebElement saveButton = driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]"));
        saveButton.click();

        Thread.sleep(5000);

    }
    */

    /*Добавление комментария при создание клиента

    public static void addCommentInAddClientTest(WebDriver driver) throws InterruptedException {
        WebElement addClientButton = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавить')]")));
        addClientButton.click();
        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавление клиента')]")));

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.click();
        firstName.sendKeys("Константин");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.click();
        lastName.sendKeys("Тагинцев");

        WebElement secondName = driver.findElement(By.xpath("//input[@name='secondName']"));
        secondName.click();
        secondName.sendKeys("Дмитриевич");

        WebElement happyBirthday = driver.findElement(By.xpath("//input[@name='happyBirthday']"));
        happyBirthday.click();
        happyBirthday.sendKeys("20/06/91");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.click();
        phone.sendKeys("89080434717");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.click();
        email.sendKeys("k.tagintsev@gmail.com");

        WebElement status = driver.findElement(By.xpath("//input[@name='status']"));
        status.click();
        status.sendKeys("0.5");

        WebElement addCommentButton = driver.findElements(By.xpath("//*[contains(text(), 'Добавить')]")).get(2);
        addCommentButton.click();

        WebElement saveButton = driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]"));
        saveButton.click();

        saveButton = driver.findElements(By.xpath("//*[contains(text(), 'Сохранить')]")).get(1);
        saveButton.click();

        WebElement testNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Константин')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "Константин".equals(testNameInGrid.getText()));
        WebElement testPhoneInGrid = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '89080434717')]")));
        assertTrue("Данные в столбце 'Телефон' не совпадают!", "89080434717".equals(testPhoneInGrid.getText()));
        WebElement testEmailInGrid = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'k.tagintsev@gmail.com')]")));
        assertTrue("Данные в столбце 'E-mail' не совпадают!", "k.tagintsev@gmail.com".equals(testEmailInGrid.getText()));
        WebElement testStatusInGrid = (new WebDriverWait(driver, 1))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '0.5')]")));
        assertTrue("Данные в столбце 'Статус' не совпадают!", "0.5".equals(testStatusInGrid.getText()));

        Thread.sleep(5000);

    }

    */

    /*Редактирование комментария при редактирование клиента

    public static void editCommentInEditClientTest(WebDriver driver) throws InterruptedException {
        WebElement firstNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Константин')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "Константин".equals(firstNameInGrid.getText()));

        Actions builder = new Actions(driver);
        //build the action chain.
        Action doubleclick = builder.doubleClick(firstNameInGrid).build();
        //perform the double click action
        doubleclick.perform();

        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавление клиента')]")));

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.click();
        firstName.sendKeys("ЛАЛ");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.click();
        lastName.sendKeys("ЛАЛ");

        WebElement secondName = driver.findElement(By.xpath("//input[@name='secondName']"));
        secondName.click();
        secondName.sendKeys("ЛАЛ");

        WebElement happyBirthday = driver.findElement(By.xpath("//input[@name='happyBirthday']"));
        happyBirthday.click();
        happyBirthday.clear();
        happyBirthday.sendKeys("20/06/15");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.click();
        phone.clear();
        phone.sendKeys("12345678");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.click();
        email.clear();
        email.sendKeys("lal@lal.lal");

        WebElement status = driver.findElement(By.xpath("//input[@name='status']"));
        status.click();
        status.clear();
        status.sendKeys("0.1");

        WebElement commentInGrid = driver.findElement(By.xpath("//*[contains(text(), 'Телефон недоступен')]"));
        assertTrue("Данные в столбце 'Комментарий' не совпадают!", "Телефон недоступен".equals(commentInGrid.getText()));

        builder = new Actions(driver);
        //build the action chain.
        doubleclick = builder.doubleClick(commentInGrid).build();
        //perform the double click action
        doubleclick.perform();

        commentInGrid = driver.findElement(By.xpath("//input[@name='dateOfCall']"));
        commentInGrid.click();
        commentInGrid.sendKeys("10/15/2015");

        commentInGrid = driver.findElement(By.xpath("//input[@name='comment']"));
        commentInGrid.click();
        commentInGrid.clear();
        commentInGrid.sendKeys("Лалище полное");

        WebElement saveButton = driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]"));
        saveButton.click();

        WebElement testCommentInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Лалище полное')]")));
        assertTrue("Данные в столбце 'Комментарий' не совпадают!", "Лалище полное".equals(testCommentInGrid.getText()));

        saveButton = driver.findElements(By.xpath("//*[contains(text(), 'Сохранить')]")).get(1);
        saveButton.click();

        Thread.sleep(5000);

    }

    */

    /*Удаление комментария при редактирование клиента

    public static void deleteCommentInEditClientTest(WebDriver driver) throws InterruptedException {
        WebElement firstNameInGrid = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'КонстантинЛАЛ')]")));
        assertTrue("Данные в столбце 'Имя' не совпадают!", "КонстантинЛАЛ".equals(firstNameInGrid.getText()));

        Actions builder = new Actions(driver);
        //build the action chain.
        Action doubleclick = builder.doubleClick(firstNameInGrid).build();
        //perform the double click action
        doubleclick.perform();

        WebElement addFormClient = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавление клиента')]")));

        WebElement commentInGrid = driver.findElement(By.xpath("//*[contains(text(), 'Лалище полное')]"));
        assertTrue("Данные в столбце 'Комментарий' не совпадают!", "Лалище полное".equals(commentInGrid.getText()));
        commentInGrid.click();

        WebElement deleteButton = driver.findElements(By.xpath("//*[contains(text(), 'Удалить')]")).get(3);
        deleteButton.click();

        WebElement yesButton = driver.findElements(By.xpath("//*[contains(text(), 'Да')]")).get(1);
        yesButton.click();

        WebElement saveButton = driver.findElement(By.xpath("//*[contains(text(), 'Сохранить')]"));
        saveButton.click();

        Thread.sleep(5000);

    }
*/

}

