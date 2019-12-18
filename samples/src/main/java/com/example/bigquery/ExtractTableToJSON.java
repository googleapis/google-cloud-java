package com.example.bigquery;

// [START bigquery_extract_table]
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Table;

public class ExtractTableToJSON {

  public static void runExtractTableToJSON() {
    // TODO(developer): Replace these variables before running the sample.
    Table table = null;
    String format = "CSV";
    String bucketName = "my-bucket";
    String gcsFileName = "gs://" + bucketName + "/extractTest.csv";
    extractTableToJSON(table, format, gcsFileName);
  }

  // Exports my-dataset-name:my_table to gcs://my-bucket/my-file as raw CSV
  public static void extractTableToJSON(Table table, String format, String gcsFileName) {

    try {
      table.extract(format, gcsFileName);
      System.out.println("Table extraction job completed successfully");
    } catch (BigQueryException e) {
      System.out.println("Table extraction job was interrupted. \n" + e.toString());
    }
  }
}
// [END bigquery_extract_table]
