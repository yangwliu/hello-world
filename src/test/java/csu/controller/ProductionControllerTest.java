package csu.controller;

import com.csu.advice.ProductionControllerExceptionHandler;
import com.csu.controller.ProductionController;
import com.csu.exception.ProductionNotFoundException;
import com.csu.service.ProductionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class ProductionControllerTest {

  @Mock
  private ProductionService productionService;

  @InjectMocks
  private ProductionController productionController;

  @InjectMocks
  private ProductionControllerExceptionHandler productionControllerExceptionHandler;

  @Test
  public void givenNoExistingProductionWhenGetProductionThenRespondWithStatusOkAndEmptyArray() {
    when(productionService.getAllProductions()).thenReturn(Collections.emptyList());

    given()
        .standaloneSetup(productionController)
        .when()
        .get("/productions")
        .then()
        .log().ifValidationFails()
        .statusCode(OK.value())
        .contentType(JSON)
        .body(is(equalTo("[]")));
  }

  @Test
  public void givenNoMatchingProductionWhenGetProductionThenRespondWithStatusNotFound() {
    String nonMatchingCourseCode = "nonMatchingProductionCode";

    when(productionService.getProductionByCode(nonMatchingCourseCode)).thenThrow(new ProductionNotFoundException(nonMatchingCourseCode));

    given()
        .standaloneSetup(productionController, productionControllerExceptionHandler)
        .when()
        .get("/productions/" + nonMatchingCourseCode)
        .then()
        .log().ifValidationFails()
        .statusCode(NOT_FOUND.value());
  }
}