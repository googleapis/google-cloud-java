/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static java.time.Month.MARCH;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.rules.TimeZoneRule;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import com.google.common.io.CharStreams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class BigQueryJsonResultSetTest {

  @Rule public final TimeZoneRule timeZoneRule = new TimeZoneRule("UTC");

  private static final FieldList fieldList =
      FieldList.of(
          Field.of("first", StandardSQLTypeName.BOOL),
          Field.of("second", StandardSQLTypeName.INT64),
          Field.of("third", StandardSQLTypeName.FLOAT64),
          Field.of("fourth", StandardSQLTypeName.STRING),
          Field.of("fifth", StandardSQLTypeName.TIMESTAMP),
          Field.of("sixth", StandardSQLTypeName.BYTES),
          Field.of("seventh", StandardSQLTypeName.STRING),
          Field.newBuilder("eight", StandardSQLTypeName.INT64).setMode(Field.Mode.REPEATED).build(),
          Field.of(
              "ninth",
              StandardSQLTypeName.STRUCT,
              Field.of("first", StandardSQLTypeName.FLOAT64),
              Field.of("second", StandardSQLTypeName.TIMESTAMP)),
          Field.of("tenth", StandardSQLTypeName.NUMERIC),
          Field.of("eleventh", StandardSQLTypeName.BIGNUMERIC),
          Field.of("twelfth", LegacySQLTypeName.TIME),
          Field.of("thirteenth", LegacySQLTypeName.INTEGER),
          Field.of("fourteenth", LegacySQLTypeName.DATE));

  LocalDateTime aTimeStamp = LocalDateTime.of(2023, MARCH, 30, 11, 14, 19, 820000000);
  LocalTime aTime = LocalTime.of(11, 14, 19, 820000000);
  private static final String STRING_VAL = "STRING_VALUE";
  private static final Schema QUERY_SCHEMA = Schema.of(fieldList);
  private final FieldValue booleanFv = FieldValue.of(Attribute.PRIMITIVE, "false");
  private final FieldValue integerFv = FieldValue.of(Attribute.PRIMITIVE, "1");
  private final FieldValue floatFv = FieldValue.of(Attribute.PRIMITIVE, "1.5");
  private final FieldValue stringFv = FieldValue.of(Attribute.PRIMITIVE, STRING_VAL);
  private final FieldValue timestampFv =
      FieldValue.of(Attribute.PRIMITIVE, "1680174859.820000"); // 2023-03-30 16:44:19.82

  private final FieldValue bytesFv =
      FieldValue.of(
          Attribute.PRIMITIVE,
          BaseEncoding.base64().encode(STRING_VAL.getBytes(StandardCharsets.UTF_8)));

  private final FieldValue nullFv = FieldValue.of(Attribute.PRIMITIVE, null);
  private final FieldValue repeatedFv =
      FieldValue.of(
          Attribute.REPEATED,
          FieldValueList.of(
              ImmutableList.of(
                  FieldValue.of(Attribute.PRIMITIVE, "10"),
                  FieldValue.of(Attribute.PRIMITIVE, "20"))));
  private final FieldValue recordFv =
      FieldValue.of(
          Attribute.RECORD,
          FieldValueList.of(
              ImmutableList.of(floatFv, timestampFv), fieldList.get("ninth").getSubFields()));
  private final FieldValue numericFv = FieldValue.of(Attribute.PRIMITIVE, "12345678");
  private final FieldValue bigNumericFv = FieldValue.of(Attribute.PRIMITIVE, "12345678.99");

  private final FieldValue timeFv = FieldValue.of(Attribute.PRIMITIVE, "11:14:19.820000");

  private final FieldValue shortFv = FieldValue.of(Attribute.PRIMITIVE, "10");
  private final FieldValue dateFv = FieldValue.of(Attribute.PRIMITIVE, "2020-01-15");

  private final FieldValueList fieldValues =
      FieldValueList.of(
          ImmutableList.of(
              booleanFv, // 1
              integerFv, // 2
              floatFv, // 3
              stringFv, // 4
              timestampFv, // 5
              bytesFv, // 6
              nullFv, // 7
              repeatedFv, // 8
              recordFv, // 9
              numericFv, // 10
              bigNumericFv, // 11
              timeFv, // 12
              shortFv, // 13
              dateFv // 14
              ),
          fieldList);

  private BigQueryFieldValueListWrapper bigQueryFieldValueListWrapperNested;

  private BigQueryStatement statement;
  private BigQueryStatement statementForTwoRows;

  private BigQueryJsonResultSet bigQueryJsonResultSet;
  private BigQueryJsonResultSet bigQueryJsonResultSetNested;

  private BlockingQueue<BigQueryFieldValueListWrapper> buffer;
  private BlockingQueue<BigQueryFieldValueListWrapper> bufferWithTwoRows;

  @Before
  public void setUp() {
    // Buffer with one row
    buffer = new LinkedBlockingDeque<>(2);
    statement = mock(BigQueryStatement.class);
    buffer.add(BigQueryFieldValueListWrapper.of(fieldList, fieldValues));
    buffer.add(BigQueryFieldValueListWrapper.of(null, null, true)); // last marker
    Thread[] workerThreads = {new Thread()};
    bigQueryJsonResultSet =
        BigQueryJsonResultSet.of(QUERY_SCHEMA, 1L, buffer, statement, workerThreads);

    // Buffer with 2 rows.
    bufferWithTwoRows = new LinkedBlockingDeque<>(3);
    statementForTwoRows = mock(BigQueryStatement.class);
    bufferWithTwoRows.add(BigQueryFieldValueListWrapper.of(fieldList, fieldValues));
    bufferWithTwoRows.add(BigQueryFieldValueListWrapper.of(fieldList, fieldValues));
    bufferWithTwoRows.add(BigQueryFieldValueListWrapper.of(null, null, true)); // last marker

    // values for nested types
    Field fieldEight = fieldList.get("eight");
    FieldValue fieldEightValue = fieldValues.get("eight");
    FieldList nestedFieldList = Schema.of(fieldEight).getFields();
    bigQueryFieldValueListWrapperNested =
        BigQueryFieldValueListWrapper.getNestedFieldValueListWrapper(
            nestedFieldList, fieldEightValue.getRepeatedValue());
    bigQueryJsonResultSetNested =
        BigQueryJsonResultSet.getNestedResultSet(
            Schema.of(fieldEight),
            bigQueryFieldValueListWrapperNested,
            0,
            fieldEightValue.getRepeatedValue().size());
  }

  private boolean resetResultSet()
      throws SQLException { // re-initialises the resultset and moves the cursor to the first row
    Thread[] workerThreads = {new Thread()};
    bigQueryJsonResultSet =
        BigQueryJsonResultSet.of(QUERY_SCHEMA, 1L, buffer, statement, workerThreads);
    return bigQueryJsonResultSet.next(); // move to the first row
  }

  @Test
  public void testIsClosed() {
    assertThat(bigQueryJsonResultSet.isClosed()).isFalse();
  }

  @Test
  public void testClose() {
    // TODO(prashant): Add test case after close method is implemented
  }

  @Test
  public void testRowCount() throws SQLException {
    Thread[] workerThreads = {new Thread()};
    // ResultSet with 1 row buffer and 1 total rows.
    BigQueryJsonResultSet bigQueryJsonResultSet2 =
        BigQueryJsonResultSet.of(QUERY_SCHEMA, 1L, buffer, statement, workerThreads);
    assertThat(resultSetRowCount(bigQueryJsonResultSet2)).isEqualTo(1);
    // ResultSet with 2 rows buffer and 1 total rows.
    bigQueryJsonResultSet2 =
        BigQueryJsonResultSet.of(
            QUERY_SCHEMA, 1L, bufferWithTwoRows, statementForTwoRows, workerThreads);
    assertThat(resultSetRowCount(bigQueryJsonResultSet2)).isEqualTo(1);
  }

  @Test
  // This method tests iteration and Resultset's type getters
  public void testIteration() throws SQLException {
    int cnt = 0;
    assertThat(bigQueryJsonResultSet.isBeforeFirst()).isTrue();
    while (bigQueryJsonResultSet.next()) {
      cnt++;
      assertThat(bigQueryJsonResultSet.isLast()).isTrue(); // we have one test row
      assertThat(bigQueryJsonResultSet.isFirst()).isTrue(); // we have one test row
      assertThat(bigQueryJsonResultSet.getBoolean("first")).isFalse();
      assertThat(bigQueryJsonResultSet.getBoolean(1)).isFalse();
      assertThat(bigQueryJsonResultSet.getInt("second")).isEqualTo(1);
      assertThat(bigQueryJsonResultSet.getInt(2)).isEqualTo(1);
      assertThat(bigQueryJsonResultSet.getFloat("third")).isEqualTo(1.5f);
      assertThat(bigQueryJsonResultSet.getFloat(3)).isEqualTo(1.5f);
      assertThat(bigQueryJsonResultSet.getString("fourth")).isEqualTo(STRING_VAL);
      assertThat(bigQueryJsonResultSet.getString(4)).isEqualTo(STRING_VAL);
      assertThat(bigQueryJsonResultSet.getTimestamp("fifth"))
          .isEqualTo(Timestamp.valueOf(aTimeStamp));
      assertThat(bigQueryJsonResultSet.getTimestamp(5)).isEqualTo(Timestamp.valueOf(aTimeStamp));
      assertThat(bigQueryJsonResultSet.wasNull()).isFalse();
      assertThat(bigQueryJsonResultSet.getObject("seventh")).isNull(); // test null
      assertThat(bigQueryJsonResultSet.getObject(7)).isNull();
      assertThat(bigQueryJsonResultSet.wasNull()).isTrue();
      assertThat(bigQueryJsonResultSet.getArray("eight").getArray())
          .isEqualTo(new Object[] {10L, 20L});
      assertThat(bigQueryJsonResultSet.getArray(8).getArray()).isEqualTo(new Object[] {10L, 20L});
      assertThat(((Array) bigQueryJsonResultSet.getObject("eight")).getArray())
          .isEqualTo(new Object[] {10L, 20L});
      assertThat(((Array) bigQueryJsonResultSet.getObject(8)).getArray())
          .isEqualTo(new Object[] {10L, 20L});
      assertThat(((Struct) bigQueryJsonResultSet.getObject("ninth")).getAttributes())
          .isEqualTo(new Object[] {1.5, Timestamp.valueOf(aTimeStamp)});
      assertThat(((Struct) bigQueryJsonResultSet.getObject(9)).getAttributes())
          .isEqualTo(new Object[] {1.5, Timestamp.valueOf(aTimeStamp)});
      assertThat(bigQueryJsonResultSet.getLong("tenth")).isEqualTo(12345678L);
      assertThat(bigQueryJsonResultSet.getLong(10)).isEqualTo(12345678L);
      assertThat(bigQueryJsonResultSet.getDouble("eleventh")).isEqualTo(12345678.99D);
      assertThat(bigQueryJsonResultSet.getDouble(11)).isEqualTo(12345678.99D);
      Time expectedTime = new Time(TimeUnit.NANOSECONDS.toMillis(aTime.toNanoOfDay()));
      assertThat(bigQueryJsonResultSet.getTime("twelfth")).isEqualTo(expectedTime);
      assertThat(bigQueryJsonResultSet.getTime(12)).isEqualTo(expectedTime);
      assertThat(bigQueryJsonResultSet.getShort("thirteenth")).isEqualTo((short) 10);
      assertThat(bigQueryJsonResultSet.getShort(13)).isEqualTo((short) 10);
    }
    assertThat(cnt).isEqualTo(1);
    assertThat(bigQueryJsonResultSet.next()).isFalse();
    assertThat(bigQueryJsonResultSet.isAfterLast()).isTrue();
  }

  @Test
  public void testGetObjectWithPrimitives() throws SQLException {
    bigQueryJsonResultSet.next();
    assertThat(bigQueryJsonResultSet.getObject("first")).isEqualTo(false);
    assertThat(bigQueryJsonResultSet.getObject(1)).isEqualTo(false);
    assertThat(bigQueryJsonResultSet.getObject("second")).isEqualTo(1);
    assertThat(bigQueryJsonResultSet.getObject(2)).isEqualTo(1);
    assertThat(bigQueryJsonResultSet.getObject("third")).isEqualTo(1.5);
    assertThat(bigQueryJsonResultSet.getObject(3)).isEqualTo(1.5);
    assertThat(bigQueryJsonResultSet.getObject("fourth")).isEqualTo(STRING_VAL);
    assertThat(bigQueryJsonResultSet.getObject(4)).isEqualTo(STRING_VAL);
    assertThat(bigQueryJsonResultSet.getObject("fifth")).isEqualTo(Timestamp.valueOf(aTimeStamp));
    assertThat(bigQueryJsonResultSet.getObject(5)).isEqualTo(Timestamp.valueOf(aTimeStamp));
    assertThat(bigQueryJsonResultSet.getObject("sixth"))
        .isEqualTo(STRING_VAL.getBytes(StandardCharsets.UTF_8));
    assertThat(bigQueryJsonResultSet.getObject(6))
        .isEqualTo(STRING_VAL.getBytes(StandardCharsets.UTF_8));
    assertThat(bigQueryJsonResultSet.wasNull()).isFalse();
    assertThat(bigQueryJsonResultSet.getObject("seventh")).isNull(); // test null
    assertThat(bigQueryJsonResultSet.getObject(7)).isNull();
    assertThat(bigQueryJsonResultSet.wasNull()).isTrue();

    assertThat(bigQueryJsonResultSet.getObject("tenth")).isEqualTo(new BigDecimal("12345678"));
    assertThat(bigQueryJsonResultSet.getObject(10)).isEqualTo(new BigDecimal("12345678"));
    assertThat(bigQueryJsonResultSet.getObject("eleventh"))
        .isEqualTo(new BigDecimal("12345678.99"));
    assertThat(bigQueryJsonResultSet.getObject(11)).isEqualTo(new BigDecimal("12345678.99"));
    Time expectedTime = new Time(TimeUnit.NANOSECONDS.toMillis(aTime.toNanoOfDay()));
    assertThat(bigQueryJsonResultSet.getObject("twelfth")).isEqualTo(expectedTime);
    assertThat(bigQueryJsonResultSet.getObject(12)).isEqualTo(expectedTime);
    assertThat(bigQueryJsonResultSet.getObject("thirteenth")).isEqualTo((short) 10);
    assertThat(bigQueryJsonResultSet.getObject(13)).isEqualTo((short) 10);
  }

  // validate the input streams
  @Test
  public void testCharacterStream() throws SQLException, IOException {
    assertThat(resetResultSet()).isTrue();
    Reader charStream = bigQueryJsonResultSet.getCharacterStream("fourth");
    String expectedVal = CharStreams.toString(charStream);
    assertThat(expectedVal).isEqualTo(STRING_VAL);
  }

  @Test
  public void testBinaryStream() throws SQLException, IOException {
    assertThat(resetResultSet()).isTrue();
    StringBuilder textBuilder = new StringBuilder();
    InputStream binInputStream = bigQueryJsonResultSet.getBinaryStream(6);
    Reader reader = new BufferedReader(new InputStreamReader(binInputStream));
    int c;
    while ((c = reader.read()) != -1) {
      textBuilder.append((char) c);
    }
    assertThat(textBuilder.toString()).isEqualTo(STRING_VAL);
    reader.close();
  }

  @Test
  public void testAsciiStream() throws SQLException, IOException {
    assertThat(resetResultSet()).isTrue();
    StringBuilder textBuilder = new StringBuilder();
    InputStream binInputStream = bigQueryJsonResultSet.getAsciiStream(4);
    Reader reader = new BufferedReader(new InputStreamReader(binInputStream));
    int c;
    while ((c = reader.read()) != -1) {
      textBuilder.append((char) c);
    }
    String expectedAsciiString =
        new String(STRING_VAL.getBytes(), 0, STRING_VAL.length(), StandardCharsets.US_ASCII);
    assertThat(textBuilder.length()).isEqualTo(expectedAsciiString.length());
    assertThat(textBuilder.toString()).isEqualTo(expectedAsciiString);
    reader.close();
  }

  @Test
  public void testUnicodeStream() throws SQLException, IOException {
    assertThat(resetResultSet()).isTrue();
    InputStream binInputStream = bigQueryJsonResultSet.getUnicodeStream(4);
    byte[] cbuf = new byte[100];
    int len = binInputStream.read(cbuf, 0, cbuf.length);
    String colFourVal = new String(cbuf, 0, len, StandardCharsets.UTF_16LE);
    assertThat(colFourVal).isEqualTo(STRING_VAL);
  }

  @Test
  public void testClob() throws SQLException, IOException {
    assertThat(resetResultSet()).isTrue();
    java.sql.Clob clobVal = bigQueryJsonResultSet.getClob(4);
    StringBuilder textBuilder = new StringBuilder();
    Reader charStream = clobVal.getCharacterStream();
    int intValueOfChar;
    while ((intValueOfChar = charStream.read()) != -1) {
      textBuilder.append((char) intValueOfChar);
    }
    charStream.close();
    assertThat(textBuilder.toString()).isEqualTo(STRING_VAL);
  }

  @Test
  public void testBlob() throws SQLException, IOException {
    assertThat(resetResultSet()).isTrue();
    StringBuilder textBuilder = new StringBuilder();
    Blob blobVal = bigQueryJsonResultSet.getBlob(6);
    InputStream binInputStream = blobVal.getBinaryStream();
    Reader reader = new BufferedReader(new InputStreamReader(binInputStream));
    int c;
    while ((c = reader.read()) != -1) {
      textBuilder.append((char) c);
    }
    assertThat(textBuilder.toString()).isEqualTo(STRING_VAL);
    reader.close();
  }

  @Test
  public void testBytes() throws SQLException {
    assertThat(resetResultSet()).isTrue();
    assertThat(bigQueryJsonResultSet.getBytes("sixth"))
        .isEqualTo(STRING_VAL.getBytes(StandardCharsets.UTF_8));
    assertThat(bigQueryJsonResultSet.getBytes(6))
        .isEqualTo(STRING_VAL.getBytes(StandardCharsets.UTF_8));
  }

  @Test
  public void testResultSetHoldability()
      throws SQLException { // TODO(prashant): Revisit this after Statement's commit is finalised
    assertThat(bigQueryJsonResultSet.getHoldability())
        .isEqualTo(ResultSet.HOLD_CURSORS_OVER_COMMIT);
  }

  @Test
  public void testStatement() throws SQLException {
    assertThat(bigQueryJsonResultSet.getStatement()).isEqualTo(statement);
    assertThat(bigQueryJsonResultSetNested.getStatement()).isNull();
  }

  @Test
  public void testConcurrency() throws SQLException {
    assertThat(bigQueryJsonResultSet.getConcurrency()).isEqualTo(ResultSet.CONCUR_READ_ONLY);
    assertThat(bigQueryJsonResultSet.getType()).isEqualTo(ResultSet.TYPE_FORWARD_ONLY);
    assertThat(bigQueryJsonResultSet.findColumn("first")).isEqualTo(1);
  }

  @Test
  public void testIterationNested() throws SQLException {
    int cnt = 0;
    assertThat(bigQueryJsonResultSetNested.isBeforeFirst()).isTrue();
    while (bigQueryJsonResultSetNested.next()) {
      cnt++;
      if (cnt == 1) {
        assertThat(bigQueryJsonResultSetNested.isFirst()).isTrue();

      } else { // 2nd row is the last row
        assertThat(bigQueryJsonResultSetNested.isLast()).isTrue();
      }
      assertThat(bigQueryJsonResultSetNested.getInt(1))
          .isEqualTo(cnt); // the first column is index 1
      assertThat(bigQueryJsonResultSetNested.getInt(2))
          .isEqualTo(cnt * 10); // second column has values 10 and 20
    }
    assertThat(cnt).isEqualTo(2);
    assertThat(bigQueryJsonResultSetNested.next()).isFalse();
    assertThat(bigQueryJsonResultSetNested.isAfterLast()).isTrue();
  }

  @Test
  public void testTime() throws SQLException {
    assertThat(resetResultSet()).isTrue();
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
    Time expectedTime = new Time(TimeUnit.NANOSECONDS.toMillis(aTime.toNanoOfDay()));
    assertThat(bigQueryJsonResultSet.getTime(12))
        .isEqualTo(bigQueryJsonResultSet.getTime(12, calendar));
    assertThat(expectedTime).isEqualTo(bigQueryJsonResultSet.getTime(12, calendar));
    assertThat(bigQueryJsonResultSet.getTime("twelfth"))
        .isEqualTo(bigQueryJsonResultSet.getTime("twelfth", calendar));
  }

  @Test
  public void testTimestamp() throws SQLException {
    assertThat(resetResultSet()).isTrue();
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
    Timestamp time = bigQueryJsonResultSet.getTimestamp(5);
    Timestamp timeWithCal = bigQueryJsonResultSet.getTimestamp(5, calendar);
    assertThat(time).isEqualTo(timeWithCal);
    assertThat(bigQueryJsonResultSet.getTimestamp("fifth"))
        .isEqualTo(bigQueryJsonResultSet.getTimestamp("fifth"));
  }

  @Test
  public void testDate() throws SQLException {
    assertThat(resetResultSet()).isTrue();
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
    // epoc should match
    assertThat(bigQueryJsonResultSet.getDate(14).getTime())
        .isEqualTo(bigQueryJsonResultSet.getDate(14, calendar).getTime());
    assertThat(Date.valueOf("2020-01-15").getTime())
        .isEqualTo(bigQueryJsonResultSet.getDate(14, calendar).getTime());
    assertThat(bigQueryJsonResultSet.getDate("fourteenth").getTime())
        .isEqualTo(bigQueryJsonResultSet.getDate("fourteenth", calendar).getTime());
  }

  private int resultSetRowCount(BigQueryJsonResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }
}
