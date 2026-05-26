/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.jdbc.BigQueryJdbcBaseTest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ITBase extends BigQueryJdbcBaseTest {

  public static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  public static String connectionUrl =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
          + DEFAULT_CATALOG
          + ";OAuthType=3;Timeout=3600;";

  public static final String createDatasetQuery =
      "CREATE SCHEMA IF NOT EXISTS `%s.%s` OPTIONS(default_table_expiration_days = 5)";
  public static final String dropSchema = "DROP SCHEMA IF EXISTS `%s.%s` CASCADE;";
  public static final String createTableQuery =
      "CREATE OR REPLACE TABLE "
          + " `%s.%s.%s` "
          + " (\n"
          + "`StringField` STRING,\n"
          + "`BytesField` BYTES,\n"
          + "`IntegerField` INTEGER,\n"
          + "`FloatField` FLOAT64,\n"
          + "`NumericField` NUMERIC,\n"
          + "`BigNumericField` BIGNUMERIC,\n"
          + "`BooleanField` BOOLEAN,\n"
          + "`TimestampField` TIMESTAMP,\n"
          + "`DateField` DATE,\n"
          + "`TimeField` TIME,\n"
          + "`DateTimeField` DATETIME,\n"
          + "`GeographyField` GEOGRAPHY,\n"
          + "`RecordField` STRUCT<Name STRING, Age INT64>,\n"
          + "`JsonField` JSON,\n"
          + ");";
  public static final String insertQuery1 =
      "INSERT INTO "
          + " `%s.%s.%s` "
          + " (\n"
          + "StringField, BytesField,IntegerField,FloatField,NumericField,BigNumericField,BooleanField,\n"
          + "TimestampField,DateField,TimeField,DateTimeField,GeographyField,RecordField,JsonField )\n"
          + "VALUES('string1',CAST ('string1' AS BYTES),111,1.1, CAST('11.1E11' AS NUMERIC), \n"
          + "CAST('1.1E37' AS BIGNUMERIC), TRUE,CAST('2001-05-1 8:05:01' AS TIMESTAMP), \n"
          + "CAST('2001-05-1' AS DATE),CAST('5:1:11.041' AS TIME), CAST('2001-05-1 11:31:45' AS DATETIME), \n"
          + "CAST(ST_GEOGFROMTEXT('POINT(1.500989010415034 -1.11471081311336843)') AS GEOGRAPHY), \n"
          + "CAST(('name1', 1) AS STRUCT<STRING,INT64>), \n"
          + "  JSON \"\"\"{\n"
          + "        \"name\": \"Alice1\",\n"
          + "        \"items\": [\n"
          + "            {\"product\": \"book1\", \"price\": 1},\n"
          + "            {\"product\": \"food1\", \"price\": 1}\n"
          + "        ]\n"
          + "    }\"\"\"\n"
          + ");";
  public static final String insertQuery2 =
      "INSERT INTO "
          + " `%s.%s.%s` "
          + " (\n"
          + "  StringField, BytesField,IntegerField,FloatField,NumericField,BigNumericField,BooleanField,\n"
          + "  TimestampField,DateField,TimeField,DateTimeField,GeographyField,RecordField,JsonField )\n"
          + "  VALUES('string2',CAST ('string2' AS BYTES),222,2.2, CAST('22.2E22' AS NUMERIC),\n"
          + "  CAST('2.2E37' AS BIGNUMERIC), TRUE,CAST('2002-05-2 8:05:02' AS TIMESTAMP),\n"
          + "  CAST('2002-05-2' AS DATE),CAST('5:2:22.042' AS TIME), CAST('2002-05-2 22:32:45' AS DATETIME),\n"
          + "  CAST(ST_GEOGFROMTEXT('POINT(2.500989020425034 -2.22472082322336843)') AS GEOGRAPHY),\n"
          + "  CAST(('name2', 2) AS STRUCT<STRING,INT64>),\n"
          + "  JSON \"\"\"{\n"
          + "        \"name\": \"Alice2\",\n"
          + "        \"items\": [\n"
          + "            {\"product\": \"book2\", \"price\": 2},\n"
          + "            {\"product\": \"food2\", \"price\": 2}\n"
          + "        ]\n"
          + "    }\"\"\"\n"
          + "      );";

  public static final String createProcedure =
      "CREATE OR REPLACE PROCEDURE `%s.%s`.create_customer() \n"
          + "\tBEGIN\n"
          + "\t\tDECLARE id STRING;\n"
          + "\t\tSET id = GENERATE_UUID();\n"
          + "\t\tINSERT INTO `%s.%s.%s` (StringField) VALUES(id);\n"
          + "\t\tSELECT FORMAT(\"Created customer.\");\n"
          + "\tEND";

  public static void setUpProcedure(String dataset, String table) throws InterruptedException {
    {
      BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();
      bigQuery.query(
          QueryJobConfiguration.of(
              String.format(
                  createProcedure, DEFAULT_CATALOG, dataset, DEFAULT_CATALOG, dataset, table)));
    }
  }

  public static void setUpDataset(String dataset) throws InterruptedException {
    BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();
    bigQuery.query(
        QueryJobConfiguration.of(String.format(createDatasetQuery, DEFAULT_CATALOG, dataset)));
  }

  public static void setUpTable(String dataset, String table) throws InterruptedException {
    BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();
    bigQuery.query(
        QueryJobConfiguration.of(String.format(createTableQuery, DEFAULT_CATALOG, dataset, table)));
    bigQuery.query(
        QueryJobConfiguration.of(String.format(insertQuery1, DEFAULT_CATALOG, dataset, table)));
    bigQuery.query(
        QueryJobConfiguration.of(String.format(insertQuery2, DEFAULT_CATALOG, dataset, table)));
  }

  public static void cleanUp(String dataset) throws InterruptedException {
    BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();
    bigQuery.query(QueryJobConfiguration.of(String.format(dropSchema, DEFAULT_CATALOG, dataset)));
  }

  protected static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        System.getenv(varName),
        "Environment variable " + varName + " is required to perform these tests.");
    return value;
  }

  protected int resultSetRowCount(ResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }

  public static List<String> getInfoBySQL(Connection connection, String sqlCmd)
      throws SQLException {
    List<String> result = new ArrayList<>();
    try (Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sqlCmd)) {
      while (rs.next()) {
        result.add(rs.getString(1));
      }
    } catch (SQLException e) {
      throw e;
    }
    return result;
  }
}
