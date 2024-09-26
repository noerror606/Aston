import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Task {

    private Steps steps;

    @BeforeTest
    public void setup() {
        steps = new Steps();
    }

    @Test(description = "Проверка GET запроса со статусом 200")
    public void postmanEchoGetStatus200() {
        Response response = steps.getRequest();
        Assert.assertEquals(response.getStatusCode(), 200, "Статус ответа должен быть 200");

    }

    @Test(description = "Проверка POST RAW запроса со статусом 200 и валидация полей")
    public void postmanEchoPostRawStatus200() {
        String requestBody = "{\"name\": \"Diana\", \"surname\": \"Will\"}";
        Response response = steps.postRequest(requestBody);
        Assert.assertEquals(response.getStatusCode(), 200, "Статус ответа должен быть 200");
        String name = response.jsonPath().getString("json.name");
        String surname = response.jsonPath().getString("json.surname");
        Assert.assertEquals(name, "Diana", "Имя не совпадает");
        Assert.assertEquals(surname, "Will", "Фамилия не совпадает");
    }

    @Test(description = "Проверка POST Form Data запроса со статусом 200 и валидация полей")
    public void postmanEchoPostFormDataStatus200() {
        Response response = steps.postFormData("Diana", "Will");
        Assert.assertEquals(response.getStatusCode(), 200, "Статус ответа должен быть 200");
        String name = response.jsonPath().getString("form.name");
        String surname = response.jsonPath().getString("form.surname");
        Assert.assertEquals(name, "Diana", "Имя не совпадает");
        Assert.assertEquals(surname, "Will", "Фамилия не совпадает");
    }

    @Test(description = "Проверка PUT запроса со статусом 200 и валидация полей")
    public void postmanEchoPutStatus200() {
        String requestBody = "{\"name\":\"Diana\"}";
        Response response = steps.putRequest(requestBody);
        Assert.assertEquals(response.getStatusCode(), 200, "Статус ответа должен быть 200");
        String name = response.jsonPath().getString("json.name");
        Assert.assertEquals(name, "Diana", "Имя не соответствует ожидаемому значению");
    }

    @Test(description = "Проверка PATCH запроса со статусом 200 и валидация полей")
    public void postmanEchoPatchStatus200() {
        String requestBody = "{\"name\":\"Diana\"}";
        Response response = steps.patchRequest(requestBody);
        Assert.assertEquals(response.getStatusCode(), 200, "Статус ответа должен быть 200");
        String name = response.jsonPath().getString("json.name");
        Assert.assertEquals(name, "Diana", "Имя в ответе должно быть 'Diana'");
    }

    @Test(description = "Проверка DELETE запроса со статусом 200")
    public void postmanEchoDeleteStatus200() {
        Response response = steps.deleteRequest();
        Assert.assertEquals(response.getStatusCode(), 200, "Статус ответа должен быть 200");
    }
}