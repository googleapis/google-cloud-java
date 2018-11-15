package com.google.cloud.examples.bigtable;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.InstanceName;

import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import java.sql.Timestamp;

// [START HelloWorld]
public class HelloWorld {

  public static void main(String[] args) throws Exception {

    // the ID of the cloud bigtable project, instance and table
    String TABLE_ID = "Hello-Bigtable";
    String COLUMN_FAMILY_ID = "cf1";
    String COLUMN_QUALIFIER = "greeting";
    String INSTANCE_ID = System.getenv("INSTANCE_ID");
    String GCLOUD_PROJECT_ID = System.getenv("GCLOUD_PROJECT_ID");
    final String rowKeyPrefix = "rowKey";

    if (INSTANCE_ID.length() == 0) {
      System.out.println("Environment variables for INSTANCE_ID must be set!");
    }
    if (GCLOUD_PROJECT_ID.length() == 0) {
      throw new Error("Environment variables GCLOUD_PROJECT_ID must be set!");
    }

    // create the settings to configure a bigtable data client
    BigtableDataSettings settings = BigtableDataSettings.newBuilder()
        .setInstanceName(InstanceName.of(GCLOUD_PROJECT_ID, INSTANCE_ID)).build();

    // create bigtable data client
    BigtableDataClient dataClient = BigtableDataClient.create(settings);

    BigtableTableAdminSettings adminSettings = BigtableTableAdminSettings.newBuilder()
        .setInstanceName(
            com.google.bigtable.admin.v2.InstanceName.of(GCLOUD_PROJECT_ID, INSTANCE_ID)).build();

    BigtableTableAdminClient adminClient = BigtableTableAdminClient.create(adminSettings);

    if (!adminClient.exists(TABLE_ID)) {
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(TABLE_ID).addFamily(COLUMN_FAMILY_ID);
      System.out.println("Creating table " + TABLE_ID);
      adminClient.createTable(createTableRequest);
    }

    try {
      System.out.println("Write some greetings to the table");
      String[] greetings = { "Hello World!", "Hello Bigtable!", "Hello Node!" };
      for (int i = 0; i < greetings.length; i++) {
        RowMutation rowMutation = RowMutation.create(TABLE_ID, rowKeyPrefix + i);
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        rowMutation.setCell(COLUMN_FAMILY_ID, COLUMN_QUALIFIER, timestamp, greetings[i]);
        dataClient.mutateRow(rowMutation);
      }

      System.out.println("Reading a single row by row key");
      Row row = dataClient.readRow(TABLE_ID, rowKeyPrefix + 1);
      System.out.println(row.getKey().toStringUtf8());
      for (RowCell cell : row.getCells()) {
        System.out.println(
            "Family: " + cell.getFamily() + "   Qualifier: " + cell.getQualifier().toStringUtf8()
                + "   Timestamp: " + cell.getTimestamp() + "   Value: " + cell.getValue()
                .toStringUtf8());
      }

      System.out.println("Reading the entire table");
      Query query = Query.create(TABLE_ID);
      ServerStream<Row> rowStream = dataClient.readRows(query);
      for (Row r : rowStream) {
        System.out.println("Row Key: " + r.getKey());
        for (RowCell cell : r.getCells()) {
          System.out.println(
              "Family: " + cell.getFamily() + "   Qualifier: " + cell.getQualifier().toStringUtf8()
                  + "   Timestamp: " + cell.getTimestamp() + "   Value: " + cell.getValue()
                  .toStringUtf8());
        }
      }

      System.out.println("Delete the table");
      adminClient.deleteTable(TABLE_ID);

    } catch (Exception e) {
      System.out.println("Exception while running HelloWorld: " + e.getMessage());
    } finally {
      dataClient.close();
      adminClient.close();
    }
  }
}
// [END HelloWorld]