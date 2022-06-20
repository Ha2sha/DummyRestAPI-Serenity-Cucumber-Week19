package com.restapiexample.stepdef;

import com.restapiexample.employeeinfo.EmployeeSteps;
import com.restapiexample.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by HariKrishna
 */
public class EmployeeStepdefs {
    static String employee_name = "Hina" + TestUtils.getRandomValue();
    static String employee_salary = "65000";
    static String employee_age="35";
    static int employeeId;
    static ValidatableResponse response;

    @Steps
    EmployeeSteps employeeSteps;

    @When("^I create a new employee by providing the information name salary and age$")
    public void iCreateANewEmployeeByProvidingTheInformationNameSalaryAndAge() {
        response=employeeSteps.createEmployee(employee_name,employee_salary,employee_age);
        response.log().all().statusCode(200);
    }

    @Then("^I verify that the new employee is created$")
    public void iVerifyThatTheNewEmployeeIsCreated() {
        employee_name="Brielle Williamson";//not needed in real api
        HashMap<String, Object> employeeMap = employeeSteps.getEmployeeInfoByEmployeeName(employee_name);
        Assert.assertThat(employeeMap, hasValue(employee_name));
        employeeId = (int) employeeMap.get("id");
        System.out.println(employeeId);
    }

    @When("^I update the employee with name salary and age$")
    public void iUpdateTheEmployeeWithNameSalaryAndAge() {
        employee_name = "Hina22";
        employee_salary="80000";
        employee_age="24";
        employeeId=5;//not needed in real api
        response=employeeSteps.updateEmployee(employeeId,employee_name,employee_salary,employee_age);
    }

    @Then("^I verify that the employee information is updated$")
    public void iVerifyThatTheEmployeeInformationIsUpdated() {
        response.log().all().statusCode(200);
    }

    @When("^I delete the created employee with id$")
    public void iDeleteTheCreatedEmployeeWithId() {
        employeeId=2;//not needed in real api
        response= employeeSteps.deleteEmployee(employeeId);
    }

    @Then("^I verify that the employee is deleted and get the status (\\d+)$")
    public void iVerifyThatTheEmployeeIsDeletedAndGetTheStatus(int exp) {
        response.statusCode(exp).log().status();
    }
}
