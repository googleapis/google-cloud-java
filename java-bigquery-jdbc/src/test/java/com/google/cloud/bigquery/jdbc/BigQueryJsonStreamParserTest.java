/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.common.collect.ImmutableList;
import com.sun.management.ThreadMXBean;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.Date;
import java.sql.Struct;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import org.junit.jupiter.api.Test;

public class BigQueryJsonStreamParserTest {

  @Test
  public void testStreamParsingAndCoercionAllTypes() throws Exception {
    FieldList profileSchema =
        FieldList.of(
            Field.of("pname", StandardSQLTypeName.STRING),
            Field.of("page", StandardSQLTypeName.INT64));

    FieldList innerStructSchema =
        FieldList.of(
            Field.of("city", StandardSQLTypeName.STRING),
            Field.of("country", StandardSQLTypeName.STRING));

    FieldList outerStructSchema =
        FieldList.of(
            Field.of("company", StandardSQLTypeName.STRING),
            Field.of("location", StandardSQLTypeName.STRUCT, innerStructSchema));

    FieldList schemaFields =
        FieldList.of(
            Field.of("id", StandardSQLTypeName.INT64),
            Field.of("name", StandardSQLTypeName.STRING),
            Field.of("score", StandardSQLTypeName.FLOAT64),
            Field.of("active", StandardSQLTypeName.BOOL),
            Field.of("geo", StandardSQLTypeName.GEOGRAPHY),
            Field.of("json_col", StandardSQLTypeName.JSON),
            Field.of("num", StandardSQLTypeName.NUMERIC),
            Field.of("bignum", StandardSQLTypeName.BIGNUMERIC),
            Field.of("interval_col", StandardSQLTypeName.INTERVAL),
            Field.of("bytes_col", StandardSQLTypeName.BYTES),
            Field.of("ts", StandardSQLTypeName.TIMESTAMP),
            Field.of("dt", StandardSQLTypeName.DATE),
            Field.of("tm", StandardSQLTypeName.TIME),
            Field.newBuilder("tags", StandardSQLTypeName.STRING)
                .setMode(Field.Mode.REPEATED)
                .build(),
            Field.newBuilder("profiles", StandardSQLTypeName.STRUCT, profileSchema)
                .setMode(Field.Mode.REPEATED)
                .build(),
            Field.of("org", StandardSQLTypeName.STRUCT, outerStructSchema));

    Schema schema = Schema.of(schemaFields);
    BigQueryJsonStreamParser parser = new BigQueryJsonStreamParser(schema);

    String json =
        "{\n"
            + "  \"rows\": [\n"
            + "    {\n"
            + "      \"f\": [\n"
            + "        { \"v\": \"101\" },\n"
            + "        { \"v\": \"Alice\" },\n"
            + "        { \"v\": \"98.5\" },\n"
            + "        { \"v\": \"true\" },\n"
            + "        { \"v\": \"POINT(-122.084 37.422)\" },\n"
            + "        { \"v\": \"{\\\"key\\\": \\\"value\\\"}\" },\n"
            + "        { \"v\": \"123456789.987654321\" },\n"
            + "        { \"v\": \"99999999999999999999999999999999999999.999999999\" },\n"
            + "        { \"v\": \"0-0 0 0:0:0\" },\n"
            + "        { \"v\": \"SGVsbG8gV29ybGQ=\" },\n"
            + "        { \"v\": \"1408452095.22\" },\n"
            + "        { \"v\": \"2023-03-13\" },\n"
            + "        { \"v\": \"23:59:59\" },\n"
            + "        { \"v\": [ { \"v\": \"tag1\" }, { \"v\": \"tag2\" } ] },\n"
            + "        { \"v\": [ { \"v\": { \"f\": [ { \"v\": \"Bob\" }, { \"v\": \"30\" } ] } } ] },\n"
            + "        { \"v\": { \"f\": [ { \"v\": \"Acme Corp\" }, { \"v\": { \"f\": [ { \"v\": \"London\" }, { \"v\": \"UK\" } ] } } ] } }\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";

    InputStream stream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
    List<Object[]> rows = parser.parseStream(stream);

    assertThat(rows).hasSize(1);
    Object[] row = rows.get(0);
    assertThat(row[0]).isEqualTo("101");
    assertThat(row[1]).isEqualTo("Alice");
    assertThat(row[2]).isEqualTo("98.5");
    assertThat(row[3]).isEqualTo("true");
    assertThat(row[4]).isEqualTo("POINT(-122.084 37.422)");
    assertThat(row[5]).isEqualTo("{\"key\": \"value\"}");
    assertThat(row[6]).isEqualTo("123456789.987654321");
    assertThat(row[7]).isEqualTo("99999999999999999999999999999999999999.999999999");
    assertThat(row[8]).isEqualTo("0-0 0 0:0:0");
    assertThat(row[9]).isEqualTo("SGVsbG8gV29ybGQ=");
    assertThat(row[10]).isEqualTo("1408452095.22");
    assertThat(row[11]).isEqualTo("2023-03-13");
    assertThat(row[12]).isEqualTo("23:59:59");
    assertThat(row[13]).isInstanceOf(FieldValue.class);
    assertThat(row[14]).isInstanceOf(FieldValue.class);
    assertThat(row[15]).isInstanceOf(FieldValue.class);

    // Verify ResultSet end-to-end JDBC Coercion
    BlockingQueue<BigQueryFieldValueListWrapper> queue = new LinkedBlockingDeque<>();
    queue.add(BigQueryFieldValueListWrapper.ofRow(schemaFields, row));
    queue.add(BigQueryFieldValueListWrapper.ofRow(null, null, true));
    BigQueryStatement statement = mock(BigQueryStatement.class);
    Future<?>[] workerTasks = {mock(Future.class)};

    BigQueryJsonResultSet rs = BigQueryJsonResultSet.of(schema, 1L, queue, statement, workerTasks);
    assertTrue(rs.next());

    assertThat(rs.getLong("id")).isEqualTo(101L);
    assertThat(rs.getString("name")).isEqualTo("Alice");
    assertThat(rs.getDouble("score")).isEqualTo(98.5D);
    assertThat(rs.getBoolean("active")).isTrue();
    assertThat(rs.getString("geo")).isEqualTo("POINT(-122.084 37.422)");
    assertThat(rs.getString("json_col")).isEqualTo("{\"key\": \"value\"}");
    assertThat(rs.getBigDecimal("num")).isEqualTo(new BigDecimal("123456789.987654321"));
    assertThat(rs.getBigDecimal("bignum"))
        .isEqualTo(new BigDecimal("99999999999999999999999999999999999999.999999999"));
    assertThat(rs.getString("interval_col")).isEqualTo("0-0 0 0:0:0");
    assertThat(rs.getBytes("bytes_col")).isEqualTo("Hello World".getBytes(StandardCharsets.UTF_8));
    assertThat(rs.getTimestamp("ts")).isNotNull();
    assertThat(rs.getDate("dt")).isEqualTo(Date.valueOf("2023-03-13"));
    assertThat(rs.getTime("tm")).isEqualTo(Time.valueOf("23:59:59"));

    // Array of Primitives
    Array tagsArray = rs.getArray("tags");
    assertThat((String[]) tagsArray.getArray()).isEqualTo(new String[] {"tag1", "tag2"});

    // Array of Structs
    Array profilesArray = rs.getArray("profiles");
    Object[] profileStructs = (Object[]) profilesArray.getArray();
    assertThat(profileStructs.length).isEqualTo(1);
    assertThat(((Struct) profileStructs[0]).getAttributes()).isEqualTo(new Object[] {"Bob", 30L});

    // Nested Structs
    Struct orgStruct = (Struct) rs.getObject("org");
    Object[] orgAttributes = orgStruct.getAttributes();
    assertThat(orgAttributes[0]).isEqualTo("Acme Corp");
    assertThat(((Struct) orgAttributes[1]).getAttributes())
        .isEqualTo(new Object[] {"London", "UK"});
  }

  @Test
  public void testMemoryAllocationReduction() throws Exception {
    java.lang.management.ThreadMXBean baseBean = ManagementFactory.getThreadMXBean();
    if (!(baseBean instanceof ThreadMXBean)) {
      return;
    }
    ThreadMXBean threadBean = (ThreadMXBean) baseBean;
    long threadId = Thread.currentThread().getId();

    FieldList simpleFieldList =
        FieldList.of(
            Field.of("col1", StandardSQLTypeName.INT64),
            Field.of("col2", StandardSQLTypeName.STRING),
            Field.of("col3", StandardSQLTypeName.FLOAT64),
            Field.of("col4", StandardSQLTypeName.BOOL),
            Field.of("col5", StandardSQLTypeName.TIMESTAMP));

    Schema simpleSchema = Schema.of(simpleFieldList);
    BigQueryJsonStreamParser parser = new BigQueryJsonStreamParser(simpleSchema);

    int rowCount = 10000;
    FieldValue fv1 = FieldValue.of(Attribute.PRIMITIVE, "100");
    FieldValue fv2 = FieldValue.of(Attribute.PRIMITIVE, "test_string");
    FieldValue fv3 = FieldValue.of(Attribute.PRIMITIVE, "123.456");
    FieldValue fv4 = FieldValue.of(Attribute.PRIMITIVE, "true");
    FieldValue fv5 = FieldValue.of(Attribute.PRIMITIVE, "1680174859.820000");

    List<FieldValue> fvItems = ImmutableList.of(fv1, fv2, fv3, fv4, fv5);
    FieldValueList sampleFvl = FieldValueList.of(fvItems, simpleFieldList);

    long bytesBefore = threadBean.getThreadAllocatedBytes(threadId);
    Object[][] rowBuffers = new Object[rowCount][];
    for (int i = 0; i < rowCount; i++) {
      rowBuffers[i] = parser.unpackRow(sampleFvl);
    }
    long allocatedBytes = threadBean.getThreadAllocatedBytes(threadId) - bytesBefore;

    assertThat(rowBuffers.length).isEqualTo(rowCount);
    assertTrue(
        allocatedBytes < 5 * 1024 * 1024,
        "Allocated bytes " + allocatedBytes + " exceeded threshold");
  }
}
