package automation.steps;

import automation.pages.CommonPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jline.internal.Log;
import net.thucydides.core.annotations.Steps;

public class CommonSteps {

	@Steps
	CommonPage commonPage;

	@When("^Launch the application \"([^\"]*)\" in \"([^\"]*)\"$")
	public void launch_Chrome_Brower(String url, String browser) throws Exception {
		Log.info("Chrome Browser");
		commonPage.launchBrowser(url, browser);
	}

	@When("^User Login using the credential$")
	public void login_using_the_credentials() throws Exception {
		commonPage.login();
	}

	@Then("^select \"([^\"]*)\" from the parent menu$")
	public void select_from_the_parent_menu(String parentMenuName) throws Exception {
		commonPage.parentMenuSelection(parentMenuName);
	}

	@Then("^select \"([^\"]*)\" from the child menu$")
	public void select_from_the_child_menu(String childMenuName) throws Exception {
		commonPage.childMenuSelection(childMenuName);
	}

}
