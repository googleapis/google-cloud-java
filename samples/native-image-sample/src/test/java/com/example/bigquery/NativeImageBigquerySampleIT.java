/*
 * Copyright 2022 Google LLC
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

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

/** Tests for {@link NativeImageBigquerySample} */
public class NativeImageBigquerySampleIT {

  private static final String DATASET_ID = "nativeimage_it_dataset";

  private static final String TABLE_ID = "nativeimage_it_table";

  private static final Schema TABLE_SCHEMA =
      Schema.of(
          Field.of("id", StandardSQLTypeName.STRING), Field.of("age", StandardSQLTypeName.INT64));

  private BigQuery bigQuery;

  private String tableName;

  @Before
  public void setUp() {
    bigQuery = BigQueryOptions.getDefaultInstance().getService();
    tableName = TABLE_ID + "_" + UUID.randomUUID().toString().replace("-", "");
    if (!NativeImageBigquerySample.hasDataset(bigQuery, DATASET_ID)) {
      NativeImageBigquerySample.createDataset(bigQuery, DATASET_ID);
    }
    NativeImageBigquerySample.createTable(bigQuery, DATASET_ID, tableName, TABLE_SCHEMA);
  }

  @Test
  public void testQueryTable() throws InterruptedException {
    String testId = "TestUser-" + UUID.randomUUID();
    NativeImageBigquerySample.insertTestRecord(bigQuery, DATASET_ID, tableName, testId, 40);

    String result = NativeImageBigquerySample.queryTable(bigQuery, DATASET_ID, tableName);

    assertThat(result).isEqualTo("User id: " + testId + " | age: 40\n");

    // Clean up
    NativeImageBigquerySample.deleteTable(bigQuery, DATASET_ID, tableName);
  }
}
