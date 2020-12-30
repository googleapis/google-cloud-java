/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1beta2;

import static org.junit.Assert.*;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.storage.test.JsonTest.*;
import com.google.cloud.bigquery.storage.test.SchemaTest.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BQV2ToBQStorageConverterTest {
  @Test
  public void testStructSimple() throws Exception {
    final TableFieldSchema StringType =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.TIME)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_field_time")
            .build();
    final TableFieldSchema tableFieldSchema =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_field_type")
            .addFields(0, StringType)
            .build();
    final TableSchema expectedSchema =
        TableSchema.newBuilder().addFields(0, tableFieldSchema).build();

    Schema v2Schema =
        Schema.of(
            Field.newBuilder(
                    "test_field_type",
                    StandardSQLTypeName.STRUCT,
                    Field.newBuilder("test_field_time", StandardSQLTypeName.TIME)
                        .setMode(Field.Mode.NULLABLE)
                        .build())
                .setMode(Field.Mode.NULLABLE)
                .build());
    final TableSchema convertedSchema = BQV2ToBQStorageConverter.ConvertTableSchema(v2Schema);
    assertEquals(expectedSchema.toString(), convertedSchema.toString());
  }
}
