/*
 * Copyright 2020 Google LLC
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

package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InsertingDataTypesIT {

  private String tableName;
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String BIGQUERY_DATASET_NAME = requireEnvVar("BIGQUERY_DATASET_NAME");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() {
    tableName = "MY_TABLE_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, tableName);
    System.setOut(null);
  }

  @Test
  public void testInsertingDataTypes() {
    // Inserting data types
    Field name = Field.of("name", StandardSQLTypeName.STRING);
    Field age = Field.of("age", StandardSQLTypeName.INT64);
    Field school =
        Field.newBuilder("school", StandardSQLTypeName.BYTES).setMode(Field.Mode.REPEATED).build();
    Field location = Field.of("location", StandardSQLTypeName.GEOGRAPHY);
    Field measurements =
        Field.newBuilder("measurements", StandardSQLTypeName.FLOAT64)
            .setMode(Field.Mode.REPEATED)
            .build();
    Field day = Field.of("day", StandardSQLTypeName.DATE);
    Field firstTime = Field.of("firstTime", StandardSQLTypeName.DATETIME);
    Field secondTime = Field.of("secondTime", StandardSQLTypeName.TIME);
    Field thirdTime = Field.of("thirdTime", StandardSQLTypeName.TIMESTAMP);
    Field datesTime =
        Field.of("datesTime", StandardSQLTypeName.STRUCT, day, firstTime, secondTime, thirdTime);
    Schema schema = Schema.of(name, age, school, location, measurements, datesTime);

    // Inserting Sample data
    Map<String, Object> datesTimeContent = new HashMap<>();
    datesTimeContent.put("day", "2019-1-12");
    datesTimeContent.put("firstTime", "2019-02-17 11:24:00.000");
    datesTimeContent.put("secondTime", "14:00:00");
    datesTimeContent.put("thirdTime", "2020-04-27T18:07:25.356Z");

    Map<String, Object> rowContent = new HashMap<>();
    rowContent.put("name", "Tom");
    rowContent.put("age", 30);
    rowContent.put("school", "Test University".getBytes());
    rowContent.put("location", "POINT(1 2)");
    rowContent.put("measurements", new Float[] {50.05f, 100.5f});
    rowContent.put("datesTime", datesTimeContent);

    InsertingDataTypes.insertingDataTypes(BIGQUERY_DATASET_NAME, tableName, schema, rowContent);
    assertThat(bout.toString()).contains("Rows successfully inserted into table");
  }
}
