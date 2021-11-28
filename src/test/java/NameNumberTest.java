import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Рассчет чисел имени ОНЛАЙН")
public class NameNumberTest {

    @BeforeAll
    public static void beforeAll(){
        Configuration.browserSize="1900x1600";
        open("https://calculat.ru/chislo-imeni-rasschitat-onlajn");
    }

    @CsvSource({
            "Анна, Петровна, Ясенева, 5, 6, 1",
            "Ин, Ко-За, Ко-За, 7, 2, 2",
            "тОМАРА, эЛЕОНОРОВНА, вАСИЛЕНКО, 7, 6, 7",
            "Жина Изуми, Ая Аризу, Банко Джун, 8, 3, 5",
            "John, Albert, Brown, 0, 0, 0",
            "ИгнатW, АртемовичQ, ПушковF, 5, 5, 5",
            "123, 709, 000, 0, 0, 0",
            "*!@#$%^&(){}[], *!@#$%^&(){}[], *!@#$%^&(){}[], 0, 0, 0"
    })
   @ParameterizedTest(name = "Вычисление чисел ФИО: {0} {1} {2}, результат: {3} {4} {5}")
   @Tag("major")

    public void countFullNameNumberTest(String firstName, String middleName, String lastName,
                                    String firstNameNumber, String middleNameNumber, String lastNameNumber){

        $("#name").setValue(firstName);
        $("#otc").setValue(middleName);
        $("#fam").setValue(lastName);
        $(byText("ПОСЧИТАТЬ")).click();

        $$("#res_div span").get(0).shouldHave(Condition.text(firstNameNumber));
        $$("#res_div span").get(1).shouldHave(Condition.text(middleNameNumber));
        $$("#res_div span").get(2).shouldHave(Condition.text(lastNameNumber));
    }
    @CsvSource({
            "Анна, Петровна, Ясенева, 5, 6, 1",
            "Ин, Ко-За, Ко-За, 7, 2, 2",
            "тОМАРА, эЛЕОНОРОВНА, вАСИЛЕНКО, 7, 6, 7",
            "Жина Изуми, Ая Аризу, Банко Джун, 8, 3, 5",
            "John, Albert, Brown, 0, 0, 0",
            "ИгнатW, АртемовичQ, ПушковF, 5, 5, 5",
            "123, 709, 000, 0, 0, 0",
            "*!@#$%^&(){}[], *!@#$%^&(){}[], *!@#$%^&(){}[], 0, 0, 0"
    })
    @ValueSource(strings = {"Анна", ""})
    @ParameterizedTest(name = "Вычисление чисел ФИО: {0} {1} {2}, результат: {3} {4} {5}")
    @Tag("major")

    public void countNameNumberTest(String firstName, String middleName, String lastName,
                                    String firstNameNumber, String middleNameNumber, String lastNameNumber){

        $("#name").setValue(firstName);
        $("#otc").setValue(middleName);
        $("#fam").setValue(lastName);
        $(byText("ПОСЧИТАТЬ")).click();

        $$("#res_div span").get(0).shouldHave(Condition.text(firstNameNumber));
        $$("#res_div span").get(1).shouldHave(Condition.text(middleNameNumber));
        $$("#res_div span").get(2).shouldHave(Condition.text(lastNameNumber));
    }
}
