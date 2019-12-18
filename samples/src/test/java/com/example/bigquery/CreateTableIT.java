package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateTableIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testCreateTable() {
    String generatedDatasetName = RemoteBigQueryHelper.generateDatasetName();

    // Create a new dataset to create a table in
    CreateDataset.createDataset(generatedDatasetName);

    // Create an empty table with specific schema in the dataset just created
    String tableName = "my_table_name";
    Schema schema =
        Schema.of(
            Field.of("stringField", LegacySQLTypeName.STRING),
            Field.of("booleanField", LegacySQLTypeName.BOOLEAN));
    CreateTable.createTable(generatedDatasetName, tableName, schema);

    assertThat(bout.toString()).contains("Table created successfully");
  }
}
