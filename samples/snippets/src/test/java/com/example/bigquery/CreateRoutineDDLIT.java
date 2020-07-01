package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateRoutineDDLIT {

  private String routineName;
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");
  private static final String BIGQUERY_DATASET_NAME = requireEnvVar("BIGQUERY_DATASET_NAME");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() {
    routineName = "MY_ROUTINE_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteRoutine.deleteRoutine(BIGQUERY_DATASET_NAME, routineName);
    System.setOut(null);
  }

  @Test
  public void testCreateRoutineDDL() {
    String sql =
        "CREATE FUNCTION "
            + "`"
            + PROJECT_ID
            + "."
            + BIGQUERY_DATASET_NAME
            + "."
            + routineName
            + "`"
            + "( arr ARRAY<STRUCT<name STRING, val INT64>>) AS ( (SELECT SUM(IF(elem.name = \"foo\",elem.val,null)) FROM UNNEST(arr) AS elem))";
    CreateRoutineDDL.createRoutineDDL(sql);
    assertThat(bout.toString()).contains("Routine created successfully");
  }
}
