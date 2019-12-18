package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExtractTableToJSONIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testExtractTableToJSON() {
    String generatedDatasetName = RemoteBigQueryHelper.generateDatasetName();

    // Create a new dataset to create a new table in
    CreateDataset.createDataset(generatedDatasetName);

    // Create a new table to extract to GCS for
    String tableName = "my_table_name";
    Schema schema =
        Schema.of(
            Field.of("stringField", LegacySQLTypeName.STRING),
            Field.of("booleanField", LegacySQLTypeName.BOOLEAN));
    Table table = createTableHelper(generatedDatasetName, tableName, schema);

    // Extract table content to GCS in CSV format
    ExtractTableToJSON.extractTableToJSON(table, "CSV", "gs://my-bucket/extractTest.csv");
    assertThat(bout.toString()).contains("Table extraction job completed successfully");
  }

  private static Table createTableHelper(String datasetName, String tableName, Schema schema) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

    TableId tableId = TableId.of(datasetName, tableName);
    TableDefinition tableDefinition = StandardTableDefinition.of(schema);
    TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();

    try {
      Table table = bigquery.create(tableInfo);
      return table;
    } catch (BigQueryException e) {
      System.out.println("Table was not created. \n" + e.toString());
      return null;
    }
  }
}
