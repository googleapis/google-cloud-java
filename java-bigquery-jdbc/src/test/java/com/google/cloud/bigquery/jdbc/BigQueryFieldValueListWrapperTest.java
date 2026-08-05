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

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.common.collect.ImmutableList;
import com.sun.management.ThreadMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BigQueryFieldValueListWrapperTest {

  private static final FieldList PROFILE_SCHEMA =
      FieldList.of(
          Field.of("pname", StandardSQLTypeName.STRING),
          Field.of("page", StandardSQLTypeName.INT64));

  private static final FieldList INNER_STRUCT_SCHEMA =
      FieldList.of(
          Field.of("city", StandardSQLTypeName.STRING),
          Field.of("country", StandardSQLTypeName.STRING));

  private static final FieldList OUTER_STRUCT_SCHEMA =
      FieldList.of(
          Field.of("company", StandardSQLTypeName.STRING),
          Field.of("location", StandardSQLTypeName.STRUCT, INNER_STRUCT_SCHEMA));

  private static final FieldList ALL_TYPES_SCHEMA_FIELDS =
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
          Field.of("range_col", StandardSQLTypeName.RANGE),
          Field.newBuilder("tags", StandardSQLTypeName.STRING).setMode(Field.Mode.REPEATED).build(),
          Field.newBuilder("profiles", StandardSQLTypeName.STRUCT, PROFILE_SCHEMA)
              .setMode(Field.Mode.REPEATED)
              .build(),
          Field.of("org", StandardSQLTypeName.STRUCT, OUTER_STRUCT_SCHEMA));

  private static final Schema ALL_TYPES_SCHEMA = Schema.of(ALL_TYPES_SCHEMA_FIELDS);

  private static final FieldValue ID_FV = FieldValue.of(Attribute.PRIMITIVE, "101");
  private static final FieldValue NAME_FV = FieldValue.of(Attribute.PRIMITIVE, "Alice");
  private static final FieldValue SCORE_FV = FieldValue.of(Attribute.PRIMITIVE, "98.5");
  private static final FieldValue ACTIVE_FV = FieldValue.of(Attribute.PRIMITIVE, "true");
  private static final FieldValue GEO_FV =
      FieldValue.of(Attribute.PRIMITIVE, "POINT(-122.084 37.422)");
  private static final FieldValue JSON_FV =
      FieldValue.of(Attribute.PRIMITIVE, "{\"key\": \"value\"}");
  private static final FieldValue NUM_FV =
      FieldValue.of(Attribute.PRIMITIVE, "123456789.987654321");
  private static final FieldValue BIGNUM_FV =
      FieldValue.of(Attribute.PRIMITIVE, "99999999999999999999999999999999999999.999999999");
  private static final FieldValue INTERVAL_FV = FieldValue.of(Attribute.PRIMITIVE, "0-0 0 0:0:0");
  private static final FieldValue BYTES_FV = FieldValue.of(Attribute.PRIMITIVE, "SGVsbG8gV29ybGQ=");
  private static final FieldValue TS_FV = FieldValue.of(Attribute.PRIMITIVE, "1408452095.22");
  private static final FieldValue DT_FV = FieldValue.of(Attribute.PRIMITIVE, "2023-03-13");
  private static final FieldValue TM_FV = FieldValue.of(Attribute.PRIMITIVE, "23:59:59");
  private static final FieldValue RANGE_FV =
      FieldValue.of(
          Attribute.RANGE, com.google.cloud.bigquery.Range.of("[2020-01-01, 2020-01-31)"));
  private static final FieldValue TAGS_FV =
      FieldValue.of(
          Attribute.REPEATED,
          Arrays.asList(
              FieldValue.of(Attribute.PRIMITIVE, "tag1"),
              FieldValue.of(Attribute.PRIMITIVE, "tag2")));
  private static final FieldValue PROFILES_FV =
      FieldValue.of(
          Attribute.REPEATED,
          Arrays.asList(
              FieldValue.of(
                  Attribute.RECORD,
                  FieldValueList.of(
                      Arrays.asList(
                          FieldValue.of(Attribute.PRIMITIVE, "Bob"),
                          FieldValue.of(Attribute.PRIMITIVE, "30")),
                      PROFILE_SCHEMA))));
  private static final FieldValue ORG_FV =
      FieldValue.of(
          Attribute.RECORD,
          FieldValueList.of(
              Arrays.asList(
                  FieldValue.of(Attribute.PRIMITIVE, "Acme Corp"),
                  FieldValue.of(
                      Attribute.RECORD,
                      FieldValueList.of(
                          Arrays.asList(
                              FieldValue.of(Attribute.PRIMITIVE, "London"),
                              FieldValue.of(Attribute.PRIMITIVE, "UK")),
                          INNER_STRUCT_SCHEMA))),
              OUTER_STRUCT_SCHEMA));

  private static final FieldValueList SAMPLE_ALL_TYPES_FVL =
      FieldValueList.of(
          Arrays.asList(
              ID_FV,
              NAME_FV,
              SCORE_FV,
              ACTIVE_FV,
              GEO_FV,
              JSON_FV,
              NUM_FV,
              BIGNUM_FV,
              INTERVAL_FV,
              BYTES_FV,
              TS_FV,
              DT_FV,
              TM_FV,
              RANGE_FV,
              TAGS_FV,
              PROFILES_FV,
              ORG_FV),
          ALL_TYPES_SCHEMA_FIELDS);

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
    boolean[] isComplexColumn =
        BigQueryFieldValueListWrapper.createComplexColumnFlags(simpleSchema.getFields());

    int rowCount = 100000;
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
      rowBuffers[i] = BigQueryFieldValueListWrapper.unpackRow(sampleFvl, isComplexColumn);
    }
    long allocatedBytes = threadBean.getThreadAllocatedBytes(threadId) - bytesBefore;

    assertThat(rowBuffers.length).isEqualTo(rowCount);
    assertTrue(
        allocatedBytes < 25 * 1024 * 1024,
        "Allocated bytes " + allocatedBytes + " exceeded threshold");
  }
}
