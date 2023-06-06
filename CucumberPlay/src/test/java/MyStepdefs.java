import com.learn.springboot.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = Main.class)
public class MyStepdefs {

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable{
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
    }

    @And("the client receives server version {double}")
    public void theClientReceivesServerVersion(double arg0) {
    }


}
