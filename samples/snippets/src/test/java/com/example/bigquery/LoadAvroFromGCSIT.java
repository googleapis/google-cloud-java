package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.Schema;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoadAvroFromGCSIT {

  private String tableName;
  private ByteArrayOutputStream bout;
  private PrintStream out;

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
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    // Create a test table
    tableName = "MY_LOAD_AVRO_TABLE_FROM_GCS_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    CreateTable.createTable(BIGQUERY_DATASET_NAME, tableName, Schema.of());

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, tableName);
    System.setOut(null);
  }

  @Test
  public void loadLoadAvroFromGCS() {
    String sourceUri = "gs://cloud-samples-data/bigquery/us-states/us-states.avro";
    LoadAvroFromGCS.loadAvroFromGCS(BIGQUERY_DATASET_NAME, tableName, sourceUri);
    assertThat(bout.toString()).contains("Avro from GCS successfully loaded in a table");
  }
}
