/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.BigQueryResult;
import com.google.cloud.bigquery.BigQuerySQLException;
import com.google.cloud.bigquery.Connection;
import com.google.cloud.bigquery.ConnectionSettings;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Parameter;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITNightlyBigQueryTest {
  private static final Logger logger = Logger.getLogger(ITNightlyBigQueryTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String TABLE = "TEMP_RS_TEST_TABLE";
  private static final byte[] BYTES = "TestByteValue".getBytes(StandardCharsets.UTF_8);
  private static final String BYTES_BASE64 = BaseEncoding.base64().encode(BYTES);
  // Script will populate NUM_BATCHES*REC_PER_BATCHES number of records (eg: 100*10000 = 1M)
  private static final int NUM_BATCHES = 55;
  private static final int REC_PER_BATCHES = 10000;
  private static final int LIMIT_RECS = 500000; // We can plan to read ~ 500K / 1M records
  private static final int MULTI_LIMIT_RECS =
      300000; // Used for multiquery testcase, a lower limit like 300K should be fine
  private static int rowCnt = 0;
  private static BigQuery bigquery;
  private static final String BASE_QUERY =
      "select StringField, GeographyField, BooleanField, BigNumericField, IntegerField, NumericField, BytesField,  "
          + "TimestampField, TimeField, DateField, IntegerArrayField,  RecordField.BooleanField, RecordField.StringField ,"
          + " JSONField, JSONField.hello, JSONField.id from %s.%s order by IntegerField asc LIMIT %s";
  private static final String POSITIONAL_QUERY =
      String.format(
          "select RecordField.BooleanField, RecordField.StringField, StringField, BooleanField, BytesField, IntegerField, GeographyField, NumericField, BigNumericField, TimeField, DateField, TimestampField, JSONField from %s.%s where DateField = ? and BooleanField = ? and IntegerField > ? and NumericField > ? LIMIT %s",
          DATASET, TABLE, MULTI_LIMIT_RECS);
  private static final String QUERY = String.format(BASE_QUERY, DATASET, TABLE, LIMIT_RECS);
  private static final String MULTI_QUERY =
      String.format(BASE_QUERY, DATASET, TABLE, MULTI_LIMIT_RECS);
  private static final String INVALID_QUERY =
      String.format(
          "select into %s.%s order by IntegerField asc LIMIT %s", DATASET, TABLE, LIMIT_RECS);

  private static final Schema BQ_SCHEMA =
      Schema.of(
          Field.newBuilder("TimestampField", StandardSQLTypeName.TIMESTAMP)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("TimestampDescription")
              .build(),
          Field.newBuilder("StringField", StandardSQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("StringDescription")
              .build(),
          Field.newBuilder("IntegerArrayField", StandardSQLTypeName.NUMERIC)
              .setMode(Field.Mode.REPEATED)
              .setDescription("IntegerArrayDescription")
              .build(),
          Field.newBuilder("BooleanField", StandardSQLTypeName.BOOL)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("BooleanDescription")
              .build(),
          Field.newBuilder("BytesField", StandardSQLTypeName.BYTES)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("BytesDescription")
              .build(),
          Field.newBuilder(
                  "RecordField",
                  StandardSQLTypeName.STRUCT,
                  Field.newBuilder("StringField", StandardSQLTypeName.STRING)
                      .setMode(Field.Mode.NULLABLE)
                      .setDescription("StringDescription")
                      .build(),
                  Field.newBuilder("BooleanField", StandardSQLTypeName.BOOL)
                      .setMode(Field.Mode.NULLABLE)
                      .setDescription("BooleanDescription")
                      .build())
              .setMode(Field.Mode.NULLABLE)
              .setDescription("RecordDescription")
              .build(),
          Field.newBuilder("IntegerField", StandardSQLTypeName.NUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("IntegerDescription")
              .build(),
          Field.newBuilder("GeographyField", StandardSQLTypeName.GEOGRAPHY)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("GeographyDescription")
              .build(),
          Field.newBuilder("NumericField", StandardSQLTypeName.NUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("NumericDescription")
              .build(),
          Field.newBuilder("BigNumericField", StandardSQLTypeName.BIGNUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("BigNumericDescription")
              .build(),
          Field.newBuilder("TimeField", StandardSQLTypeName.TIME)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("TimeDescription")
              .build(),
          Field.newBuilder("DateField", StandardSQLTypeName.DATE)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("DateDescription")
              .build(),
          Field.newBuilder("JSONField", StandardSQLTypeName.JSON)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("JSONFieldDescription")
              .build(),
          Field.newBuilder("IntervalField", StandardSQLTypeName.INTERVAL)
              .setMode(Field.Mode.NULLABLE)
              .setDescription("IntervalFieldDescription")
              .build());

  @Rule public Timeout globalTimeout = Timeout.seconds(1800); // setting 30 mins as the timeout

  @BeforeClass
  public static void beforeClass() throws InterruptedException, IOException {
    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    createDataset(DATASET);
    createTable(DATASET, TABLE, BQ_SCHEMA);
    populateTestRecords(DATASET, TABLE);
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    try {
      if (bigquery != null) {
        deleteTable(DATASET, TABLE);
        RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
      } else {
        fail("Error clearing the test dataset");
      }
    } catch (BigQueryException e) {
      fail("Error clearing the test dataset " + e);
    }
  }

  @Test
  public void testInvalidQuery() throws BigQuerySQLException {
    Connection connection = getConnection();
    try {
      BigQueryResult bigQueryResult = connection.executeSelect(INVALID_QUERY);
      fail("BigQuerySQLException was expected");
    } catch (BigQuerySQLException ex) {
      assertNotNull(ex.getMessage());
      assertTrue(ex.getMessage().toLowerCase().contains("unexpected keyword into"));
    } finally {
      connection.close();
    }
  }

  /*
  This tests for the order of the records as well as the value of the records using testForAllDataTypeValues
   */
  @Test
  public void testIterateAndOrder() throws SQLException {
    Connection connection = getConnection();
    BigQueryResult bigQueryResult = connection.executeSelect(QUERY);
    logger.log(Level.INFO, "Query used: {0}", QUERY);
    ResultSet rs = bigQueryResult.getResultSet();
    int cnt = 0;

    int prevIntegerFieldVal = 0;
    while (rs.next()) {
      if (cnt == 0) { // first row is supposed to be null
        assertNull(rs.getString("StringField"));
        assertNull(rs.getString("GeographyField"));
        Object intAryField = rs.getObject("IntegerArrayField");
        if (intAryField instanceof JsonStringArrayList) {
          assertEquals(
              new JsonStringArrayList(),
              ((JsonStringArrayList) intAryField)); // null array is returned as an empty array
        }
        assertFalse(rs.getBoolean("BooleanField"));
        assertTrue(0.0d == rs.getDouble("BigNumericField"));
        assertTrue(0 == rs.getInt("IntegerField"));
        assertTrue(0L == rs.getLong("NumericField"));
        assertNull(rs.getBytes("BytesField"));
        assertNull(rs.getTimestamp("TimestampField"));
        assertNull(rs.getTime("TimeField"));
        assertNull(rs.getDate("DateField"));
        assertNull(rs.getString("JSONField"));
        assertFalse(rs.getBoolean("BooleanField_1"));
        assertNull(rs.getString("StringField_1"));
        assertNull(rs.getString("hello")); // equivalent of testJsonType
        assertEquals(0, rs.getInt("id"));

      } else { // remaining rows are supposed to be non null
        assertNotNull(rs.getString("StringField"));
        assertNotNull(rs.getString("GeographyField"));
        assertNotNull(rs.getObject("IntegerArrayField"));
        assertTrue(rs.getBoolean("BooleanField"));
        assertTrue(0.0d < rs.getDouble("BigNumericField"));
        assertTrue(0 < rs.getInt("IntegerField"));
        assertTrue(0L < rs.getLong("NumericField"));
        assertNotNull(rs.getBytes("BytesField"));
        assertNotNull(rs.getTimestamp("TimestampField"));
        assertNotNull(rs.getTime("TimeField"));
        assertNotNull(rs.getDate("DateField"));
        assertNotNull(rs.getString("JSONField"));
        assertFalse(rs.getBoolean("BooleanField_1"));
        assertNotNull(rs.getString("StringField_1"));

        // check the order of the records
        assertTrue(prevIntegerFieldVal < rs.getInt("IntegerField"));
        prevIntegerFieldVal = rs.getInt("IntegerField");

        testForAllDataTypeValues(rs, cnt); // asserts the value of each row
      }
      ++cnt;
    }
    assertEquals(LIMIT_RECS, cnt); // all the records were retrieved
    connection.close();
  }

  /*
  This tests for the order of the records using default connection settings as well as the value of the records using testForAllDataTypeValues
   */
  @Test
  public void testIterateAndOrderDefaultConnSettings() throws SQLException {
    Connection connection = bigquery.createConnection();
    BigQueryResult bigQueryResult = connection.executeSelect(QUERY);
    logger.log(Level.INFO, "Query used: {0}", QUERY);
    ResultSet rs = bigQueryResult.getResultSet();
    int cnt = 0;

    int prevIntegerFieldVal = 0;
    while (rs.next()) {
      if (cnt == 0) { // first row is supposed to be null
        assertNull(rs.getString("StringField"));
        assertNull(rs.getString("GeographyField"));
        Object intAryField = rs.getObject("IntegerArrayField");
        if (intAryField instanceof JsonStringArrayList) {
          assertEquals(
              new JsonStringArrayList(),
              ((JsonStringArrayList) intAryField)); // null array is returned as an empty array
        }
        assertFalse(rs.getBoolean("BooleanField"));
        assertTrue(0.0d == rs.getDouble("BigNumericField"));
        assertTrue(0 == rs.getInt("IntegerField"));
        assertTrue(0L == rs.getLong("NumericField"));
        assertNull(rs.getBytes("BytesField"));
        assertNull(rs.getTimestamp("TimestampField"));
        assertNull(rs.getTime("TimeField"));
        assertNull(rs.getDate("DateField"));
        assertNull(rs.getString("JSONField"));
        assertFalse(rs.getBoolean("BooleanField_1"));
        assertNull(rs.getString("StringField_1"));
        assertNull(rs.getString("hello")); // equivalent of testJsonType
        assertEquals(0, rs.getInt("id"));

      } else { // remaining rows are supposed to be non null
        assertNotNull(rs.getString("StringField"));
        assertNotNull(rs.getString("GeographyField"));
        assertNotNull(rs.getObject("IntegerArrayField"));
        assertTrue(rs.getBoolean("BooleanField"));
        assertTrue(0.0d < rs.getDouble("BigNumericField"));
        assertTrue(0 < rs.getInt("IntegerField"));
        assertTrue(0L < rs.getLong("NumericField"));
        assertNotNull(rs.getBytes("BytesField"));
        assertNotNull(rs.getTimestamp("TimestampField"));
        assertNotNull(rs.getTime("TimeField"));
        assertNotNull(rs.getDate("DateField"));
        assertNotNull(rs.getString("JSONField"));
        assertFalse(rs.getBoolean("BooleanField_1"));
        assertNotNull(rs.getString("StringField_1"));

        // check the order of the records
        assertTrue(prevIntegerFieldVal < rs.getInt("IntegerField"));
        prevIntegerFieldVal = rs.getInt("IntegerField");

        testForAllDataTypeValues(rs, cnt); // asserts the value of each row
      }
      ++cnt;
    }
    assertEquals(LIMIT_RECS, cnt); // all the records were retrieved
    assertTrue(connection.close());
  }

  /*
  This tests interrupts the execution in between and checks if it has been interrupted successfully while using ReadAPI
   */
  @Test
  public void testConnectionClose() throws SQLException {
    Connection connection = bigquery.createConnection();
    assertNotNull("bigquery.createConnection() returned null", connection);
    BigQueryResult bigQueryResult = connection.executeSelect(QUERY);
    logger.log(Level.INFO, "Query used: {0}", QUERY);
    ResultSet rs = bigQueryResult.getResultSet();
    int cnt = 0;
    while (rs.next()) {
      ++cnt;
      if (cnt == 50000) { // interrupt at 50K
        assertTrue(connection.close());
      }
    }
    assertTrue(
        LIMIT_RECS
            > cnt); // we stopped at 50K but still we can expect additional records (typically ~100)
    // to be retrieved
    // as a number of records should have been already buffered. less than
    // LIMIT_RECS should be retrieved
  }

  @Test
  public void testMultipleRuns() throws SQLException {

    Connection connection = getConnection();
    BigQueryResult bigQueryResult = connection.executeSelect(MULTI_QUERY);
    logger.log(Level.INFO, "Query used: {0}", MULTI_QUERY);
    ResultSet rs = bigQueryResult.getResultSet();
    int cnt = 0;
    int totalCnt = 0;

    int prevIntegerFieldVal = 0;
    while (rs.next()) {
      if (cnt == 0) { // first row is supposed to be null
        assertNull(rs.getString("StringField"));
        assertNull(rs.getString("GeographyField"));
        Object intAryField = rs.getObject("IntegerArrayField");
        if (intAryField instanceof JsonStringArrayList) {
          assertEquals(
              new JsonStringArrayList(),
              ((JsonStringArrayList) intAryField)); // null array is returned as an empty array
        }
        assertFalse(rs.getBoolean("BooleanField"));
        assertTrue(0.0d == rs.getDouble("BigNumericField"));
        assertTrue(0 == rs.getInt("IntegerField"));
        assertTrue(0L == rs.getLong("NumericField"));
        assertNull(rs.getBytes("BytesField"));
        assertNull(rs.getTimestamp("TimestampField"));
        assertNull(rs.getTime("TimeField"));
        assertNull(rs.getDate("DateField"));
        assertNull(rs.getString("JSONField"));
        assertFalse(rs.getBoolean("BooleanField_1"));
        assertNull(rs.getString("StringField_1"));
        assertNull(rs.getString("hello")); // equivalent of testJsonType
        assertEquals(0, rs.getInt("id"));

      } else { // remaining rows are supposed to be non null
        // check the order of the records
        assertTrue(prevIntegerFieldVal < rs.getInt("IntegerField"));
        prevIntegerFieldVal = rs.getInt("IntegerField");

        testForAllDataTypeValues(rs, cnt); // asserts the value of each row
      }
      ++cnt;
    }
    connection.close();
    totalCnt += cnt;
    // Repeat the same run
    connection = getConnection();
    bigQueryResult = connection.executeSelect(MULTI_QUERY);
    rs = bigQueryResult.getResultSet();
    cnt = 0;
    prevIntegerFieldVal = 0;
    while (rs.next()) {
      if (cnt == 0) { // first row is supposed to be null
        assertNull(rs.getString("StringField"));
        assertNull(rs.getString("GeographyField"));
        Object intAryField = rs.getObject("IntegerArrayField");
        if (intAryField instanceof JsonStringArrayList) {
          assertEquals(
              new JsonStringArrayList(),
              ((JsonStringArrayList) intAryField)); // null array is returned as an empty array
        }
        assertFalse(rs.getBoolean("BooleanField"));
        assertTrue(0.0d == rs.getDouble("BigNumericField"));
        assertTrue(0 == rs.getInt("IntegerField"));
        assertTrue(0L == rs.getLong("NumericField"));
        assertNull(rs.getBytes("BytesField"));
        assertNull(rs.getTimestamp("TimestampField"));
        assertNull(rs.getTime("TimeField"));
        assertNull(rs.getDate("DateField"));
        assertNull(rs.getString("JSONField"));
        assertFalse(rs.getBoolean("BooleanField_1"));
        assertNull(rs.getString("StringField_1"));
        assertNull(rs.getString("hello")); // equivalent of testJsonType
        assertEquals(0, rs.getInt("id"));

      } else { // remaining rows are supposed to be non null
        // check the order of the records
        assertTrue(prevIntegerFieldVal < rs.getInt("IntegerField"));
        prevIntegerFieldVal = rs.getInt("IntegerField");

        testForAllDataTypeValues(rs, cnt); // asserts the value of each row
      }
      ++cnt;
    }
    connection.close();
    totalCnt += cnt;
    assertEquals(MULTI_LIMIT_RECS * 2, totalCnt);
  }

  @Test
  public void testPositionalParams()
      throws SQLException { // Bypasses Read API as it doesnt support Positional Params
    Connection connection = getConnection();
    Parameter dateParam =
        Parameter.newBuilder().setValue(QueryParameterValue.date("2022-01-01")).build();
    Parameter boolParam = Parameter.newBuilder().setValue(QueryParameterValue.bool(true)).build();
    Parameter intParam = Parameter.newBuilder().setValue(QueryParameterValue.int64(1)).build();
    Parameter numericParam =
        Parameter.newBuilder().setValue(QueryParameterValue.numeric(new BigDecimal(100))).build();
    List<Parameter> parameters = ImmutableList.of(dateParam, boolParam, intParam, numericParam);

    BigQueryResult bigQueryResult = connection.executeSelect(POSITIONAL_QUERY, parameters);
    logger.log(Level.INFO, "Query used: {0}", POSITIONAL_QUERY);
    ResultSet rs = bigQueryResult.getResultSet();
    int cnt = 0;
    while (rs.next()) {
      assertFalse(rs.getBoolean("BooleanField"));
      assertTrue(0.0d <= rs.getDouble("BigNumericField"));
      assertTrue(0 <= rs.getInt("IntegerField"));
      assertTrue(0L <= rs.getLong("NumericField"));
      assertNotNull(rs.getBytes("BytesField"));
      assertNotNull(rs.getTimestamp("TimestampField"));
      assertNotNull(rs.getTime("TimeField"));
      assertNotNull(rs.getDate("DateField"));
      assertNotNull(rs.getString("JSONField"));
      assertTrue(rs.getBoolean("BooleanField_1"));
      assertNotNull(rs.getString("StringField_1"));
      ++cnt;
    }
    connection.close();
    assertEquals(MULTI_LIMIT_RECS, cnt);
  }

  @Test
  // This testcase reads rows in bulk for a public table to make sure we do not get
  // table-not-found exception. Ref: b/241134681 . This exception has been seen while reading data
  // in bulk
  public void testForTableNotFound() throws SQLException {
    int recordCnt = 50000000; // 5Mil
    String query =
        String.format(
            "SELECT * FROM `bigquery-samples.wikipedia_benchmark.Wiki10B` LIMIT %s", recordCnt);
    logger.log(Level.INFO, "Query used: {0}", query);
    String dataSet = RemoteBigQueryHelper.generateDatasetName();
    String table = "TAB_" + UUID.randomUUID();
    createDataset(dataSet);
    TableId targetTable =
        TableId.of(
            ServiceOptions.getDefaultProjectId(),
            dataSet,
            table); // table will be created implicitly

    ConnectionSettings conSet =
        ConnectionSettings.newBuilder()
            .setUseReadAPI(true) // enable read api
            .setDestinationTable(targetTable)
            .setAllowLargeResults(true)
            .build();

    Connection connection =
        BigQueryOptions.getDefaultInstance().getService().createConnection(conSet);
    BigQueryResult bigQueryResultSet = connection.executeSelect(query);
    assertNotNull(getResultHashWiki(bigQueryResultSet)); // this iterated through all the rows
    assertTrue(
        (recordCnt == bigQueryResultSet.getTotalRows())
            || (-1
                == bigQueryResultSet
                    .getTotalRows())); // either job should return the actual count or -1 if the job
    // is still running
    try {
      deleteTable(dataSet, table);
      deleteDataset(dataSet);
    } catch (Exception e) {
      logger.log(
          Level.WARNING,
          String.format(
              "Error [ %s ] while deleting dataset: %s , table: %s",
              e.getMessage(), dataSet, table));
    }
  }

  // this iterated through all the rows (just reads the title column)
  private Long getResultHashWiki(BigQueryResult bigQueryResultSet) throws SQLException {
    ResultSet rs = bigQueryResultSet.getResultSet();
    long hash = 0L;
    System.out.print("\n Running");
    while (rs.next()) {
      hash += rs.getString("title") == null ? 0 : rs.getString("title").hashCode();
    }
    return hash;
  }

  // asserts the value of each row
  private static void testForAllDataTypeValues(ResultSet rs, int cnt) throws SQLException {
    // Testing JSON type
    assertEquals("\"world\"", rs.getString("hello")); // BQ stores the value as "world"
    assertEquals(100, rs.getInt("id"));
    assertEquals("{\"hello\":\"world\",\"id\":100}", rs.getString("JSONField"));

    // String and Geography types
    assertEquals(String.format("String Val %s", cnt), rs.getString("StringField"));
    assertEquals("POINT(1 2)", rs.getString("GeographyField"));

    // Array type tests
    if (rs.getObject("IntegerArrayField") instanceof JsonStringArrayList) {
      JsonStringArrayList<BigDecimal> ary = (JsonStringArrayList) rs.getObject("IntegerArrayField");
      assertEquals(3, ary.size());
      assertEquals(1, ary.get(0).intValue());
      assertEquals(2, ary.get(1).intValue());
      assertEquals(3, ary.get(2).intValue());
    }

    // BigNumeric, int and Numeric
    assertTrue(10000000L + cnt == rs.getDouble("BigNumericField"));
    assertEquals(1 + cnt, rs.getInt("IntegerField"));
    assertEquals(100 + cnt, rs.getLong("NumericField"));
    // Test Byte field
    assertEquals("TestByteValue", new String(rs.getBytes("BytesField"), StandardCharsets.UTF_8));

    // Struct Fields
    assertFalse(rs.getBoolean("BooleanField_1"));
    assertEquals(String.format("Str Val %s", cnt), rs.getString("StringField_1"));

    // Timestamp, Time, DateTime and Date fields
    assertEquals(1649064795000L, rs.getTimestamp("TimestampField").getTime());
    assertEquals(
        java.sql.Date.valueOf("2022-01-01").toString(), rs.getDate("DateField").toString());
    // Time is represented independent of a specific date and timezone. For example a 12:11:35 (GMT)
    // is returned as
    // 17:11:35 (GMT+5:30) . So we need to adjust the offset
    int offset =
        TimeZone.getTimeZone(ZoneId.systemDefault())
            .getOffset(new java.util.Date().getTime()); // offset in seconds
    assertEquals(
        Time.valueOf(LocalTime.of(12, 11, 35)).getTime() + offset,
        rs.getTime("TimeField").getTime());
  }

  private static void populateTestRecords(String datasetName, String tableName) {
    TableId tableId = TableId.of(datasetName, tableName);
    for (int batchCnt = 1; batchCnt <= NUM_BATCHES; batchCnt++) {
      addBatchRecords(tableId);
    }
  }

  private static void addBatchRecords(TableId tableId) {
    Map<String, Object> nullRow = new HashMap<>();
    try {
      InsertAllRequest.Builder reqBuilder = InsertAllRequest.newBuilder(tableId);
      if (rowCnt == 0) {
        reqBuilder.addRow(nullRow);
      }
      for (int i = 0; i < REC_PER_BATCHES; i++) {
        reqBuilder.addRow(getNextRow());
      }
      InsertAllResponse response = bigquery.insertAll(reqBuilder.build());

      if (response.hasErrors()) {
        // If any of the insertions failed, this lets you inspect the errors
        for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
          logger.log(Level.WARNING, "Exception while adding records {0}", entry.getValue());
        }
        fail("Response has errors");
      }
    } catch (BigQueryException e) {
      logger.log(Level.WARNING, "Exception while adding records {0}", e);
      fail("Error in addBatchRecords");
    }
  }

  private static void createTable(String datasetName, String tableName, Schema schema) {
    try {
      TableId tableId = TableId.of(datasetName, tableName);
      TableDefinition tableDefinition = StandardTableDefinition.of(schema);
      TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
      Table table = bigquery.create(tableInfo);
      assertTrue(table.exists());
    } catch (BigQueryException e) {
      fail("Table was not created. \n" + e);
    }
  }

  public static void deleteTable(String datasetName, String tableName) {
    try {
      assertTrue(bigquery.delete(TableId.of(datasetName, tableName)));
    } catch (BigQueryException e) {
      fail("Table was not deleted. \n" + e);
    }
  }

  public static void createDataset(String datasetName) {
    try {
      DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
      Dataset newDataset = bigquery.create(datasetInfo);
      assertNotNull(newDataset.getDatasetId().getDataset());
    } catch (BigQueryException e) {
      fail("Dataset was not created. \n" + e);
    }
  }

  public static void deleteDataset(String datasetName) {
    try {
      DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
      assertTrue(bigquery.delete(datasetInfo.getDatasetId()));
    } catch (BigQueryException e) {
      fail("Dataset was not deleted. \n" + e);
    }
  }

  private Connection getConnection() {

    ConnectionSettings connectionSettings =
        ConnectionSettings.newBuilder()
            .setDefaultDataset(DatasetId.of(DATASET))
            .build(); // Read API is enabled by default
    return bigquery.createConnection(connectionSettings);
  }

  private static Map<String, Object> getNextRow() {
    rowCnt++;
    Map<String, Object> row = new HashMap<>();
    Map<String, Object> structVal = new HashMap<>();
    structVal.put("StringField", "Str Val " + rowCnt);
    structVal.put("BooleanField", false);
    row.put("RecordField", structVal); // struct
    row.put("TimestampField", "2022-04-04 15:03:15.000 +05:30");
    row.put("StringField", "String Val " + rowCnt);
    row.put("IntegerArrayField", new int[] {1, 2, 3});
    row.put("BooleanField", true);
    row.put("BytesField", BYTES_BASE64);
    row.put("IntegerField", 1 + rowCnt);
    row.put("GeographyField", "POINT(1 2)");
    row.put("NumericField", 100 + rowCnt);
    row.put("BigNumericField", 10000000L + rowCnt);
    row.put("TimeField", "12:11:35");
    row.put("DateField", "2022-01-01");
    row.put("JSONField", "{\"hello\":\"world\",\"id\":100}");
    row.put("IntervalField", "10000-0 3660000 87840000:0:0");
    return row;
  }
}
