/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.QueryJobConfiguration.Priority;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class QueryJobConfigurationTest {

  private static final String QUERY = "BigQuery SQL";
  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.builder("IntegerField", Field.Type.integer())
          .mode(Field.Mode.REPEATED)
          .description("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.builder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .mode(Field.Mode.REQUIRED)
          .description("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder().build();
  private static final ExternalTableDefinition TABLE_CONFIGURATION =
      ExternalTableDefinition.builder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .compression(COMPRESSION)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .maxBadRecords(MAX_BAD_RECORDS)
          .build();
  private static final Map<String, ExternalTableDefinition> TABLE_DEFINITIONS =
      ImmutableMap.of("tableName", TABLE_CONFIGURATION);
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final Priority PRIORITY = Priority.BATCH;
  private static final boolean ALLOW_LARGE_RESULTS = true;
  private static final boolean USE_QUERY_CACHE = false;
  private static final boolean FLATTEN_RESULTS = true;
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS = ImmutableList.of(
      UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION =
      QueryJobConfiguration.builder(QUERY)
          .useQueryCache(USE_QUERY_CACHE)
          .tableDefinitions(TABLE_DEFINITIONS)
          .allowLargeResults(ALLOW_LARGE_RESULTS)
          .createDisposition(CREATE_DISPOSITION)
          .defaultDataset(DATASET_ID)
          .destinationTable(TABLE_ID)
          .writeDisposition(WRITE_DISPOSITION)
          .priority(PRIORITY)
          .flattenResults(FLATTEN_RESULTS)
          .userDefinedFunctions(USER_DEFINED_FUNCTIONS)
          .dryRun(true)
          .build();

  @Test
  public void testToBuilder() {
    compareQueryJobConfiguration(QUERY_JOB_CONFIGURATION,
        QUERY_JOB_CONFIGURATION.toBuilder().build());
    QueryJobConfiguration job = QUERY_JOB_CONFIGURATION.toBuilder()
        .query("New BigQuery SQL")
        .build();
    assertEquals("New BigQuery SQL", job.query());
    job = job.toBuilder().query(QUERY).build();
    compareQueryJobConfiguration(QUERY_JOB_CONFIGURATION, job);
  }

  @Test
  public void testOf() {
    QueryJobConfiguration job = QueryJobConfiguration.of(QUERY);
    assertEquals(QUERY, job.query());
  }

  @Test
  public void testToBuilderIncomplete() {
    QueryJobConfiguration job = QueryJobConfiguration.of(QUERY);
    compareQueryJobConfiguration(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ALLOW_LARGE_RESULTS, QUERY_JOB_CONFIGURATION.allowLargeResults());
    assertEquals(CREATE_DISPOSITION, QUERY_JOB_CONFIGURATION.createDisposition());
    assertEquals(DATASET_ID, QUERY_JOB_CONFIGURATION.defaultDataset());
    assertEquals(TABLE_ID, QUERY_JOB_CONFIGURATION.destinationTable());
    assertEquals(FLATTEN_RESULTS, QUERY_JOB_CONFIGURATION.flattenResults());
    assertEquals(PRIORITY, QUERY_JOB_CONFIGURATION.priority());
    assertEquals(QUERY, QUERY_JOB_CONFIGURATION.query());
    assertEquals(TABLE_DEFINITIONS, QUERY_JOB_CONFIGURATION.tableDefinitions());
    assertEquals(USE_QUERY_CACHE, QUERY_JOB_CONFIGURATION.useQueryCache());
    assertEquals(USER_DEFINED_FUNCTIONS, QUERY_JOB_CONFIGURATION.userDefinedFunctions());
    assertEquals(WRITE_DISPOSITION, QUERY_JOB_CONFIGURATION.writeDisposition());
    assertTrue(QUERY_JOB_CONFIGURATION.dryRun());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(QUERY_JOB_CONFIGURATION.toPb().getQuery());
    assertNull(QUERY_JOB_CONFIGURATION.toPb().getExtract());
    assertNull(QUERY_JOB_CONFIGURATION.toPb().getCopy());
    assertNull(QUERY_JOB_CONFIGURATION.toPb().getLoad());
    compareQueryJobConfiguration(QUERY_JOB_CONFIGURATION,
        QueryJobConfiguration.fromPb(QUERY_JOB_CONFIGURATION.toPb()));
    QueryJobConfiguration job = QueryJobConfiguration.of(QUERY);
    compareQueryJobConfiguration(job, QueryJobConfiguration.fromPb(job.toPb()));
  }

  @Test
  public void testSetProjectId() {
    QueryJobConfiguration configuration = QUERY_JOB_CONFIGURATION.setProjectId("p");
    assertEquals("p", configuration.defaultDataset().project());
    assertEquals("p", configuration.destinationTable().project());
  }

  private void compareQueryJobConfiguration(QueryJobConfiguration expected,
      QueryJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.dryRun(), value.dryRun());
    assertEquals(expected.allowLargeResults(), value.allowLargeResults());
    assertEquals(expected.createDisposition(), value.createDisposition());
    assertEquals(expected.defaultDataset(), value.defaultDataset());
    assertEquals(expected.destinationTable(), value.destinationTable());
    assertEquals(expected.flattenResults(), value.flattenResults());
    assertEquals(expected.priority(), value.priority());
    assertEquals(expected.query(), value.query());
    assertEquals(expected.tableDefinitions(), value.tableDefinitions());
    assertEquals(expected.useQueryCache(), value.useQueryCache());
    assertEquals(expected.userDefinedFunctions(), value.userDefinedFunctions());
    assertEquals(expected.writeDisposition(), value.writeDisposition());
  }
}
