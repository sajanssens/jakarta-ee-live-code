package com.infosupport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infosupport.domain.Aangifte;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jupiter.MicroShedTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
public class AppIT {

    private static final Gson gson = new GsonBuilder().create();

    @Test
    void whenPostAndGetAangiftesIsCalledItWorks() {
        var a = Aangifte.builder().bsn("1234").bedrag(289.99).build();

        var aangifte = given().contentType("application/json")
                .header("Authorization", "true")
                .body(gson.toJson(a))
                .when().post("/api/aangiftes")
                .then().statusCode(200)
                .extract().response();

        var aangiftes =
                given().contentType("application/json")
                        .when().get("/api/aangiftes")
                        .then().statusCode(200)
                        .extract().response();

        assertTrue(aangifte.asPrettyString().contains("id"));
        assertNotNull(aangiftes.getBody());
        assertTrue(aangiftes.asPrettyString().contains("1234"));
        assertTrue(aangiftes.asPrettyString().contains("289.99"));
    }
}
