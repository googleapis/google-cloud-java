package com.example.bigquery;

// [START bigquery_create_table]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

public class CreateTable {

  public static void runCreateTable() {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "my-dataset-name";
    String tableName = "my_table_name";
    Schema schema =
        Schema.of(
            // LegacySQLTypeName will be updated to StandardSQLTypeName once release rolls out
            Field.of("stringField", LegacySQLTypeName.STRING),
            Field.of("booleanField", LegacySQLTypeName.BOOLEAN));
    createTable(datasetName, tableName, schema);
  }

  public static void createTable(String datasetName, String tableName, Schema schema) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

    TableId tableId = TableId.of(datasetName, tableName);
    TableDefinition tableDefinition = StandardTableDefinition.of(schema);
    TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();

    try {
      bigquery.create(tableInfo);
      System.out.println("Table created successfully");
    } catch (BigQueryException e) {
      System.out.println("Table was not created. \n" + e.toString());
    }
  }
}
// [END bigquery_create_table]
