package com.infosupport;

import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jupiter.MicroShedTest;

import static io.restassured.RestAssured.given;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
public class AppIT {

    @Test
    void whenGetAangiftesIsCalledItWorks() {
        given().contentType("application/json")
                .when().get("/api/aangiftes")
                .then().statusCode(200);
    }
}
