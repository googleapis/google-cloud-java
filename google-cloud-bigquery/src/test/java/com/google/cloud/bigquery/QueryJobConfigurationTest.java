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

import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.cloud.bigquery.QueryJobConfiguration.Priority;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class QueryJobConfigurationTest {

  private static final String QUERY = "BigQuery SQL";
  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", LegacySQLTypeName.RECORD, FIELD_SCHEMA1, FIELD_SCHEMA2)
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final CsvOptions CSV_OPTIONS = CsvOptions.newBuilder().build();
  private static final ExternalTableDefinition TABLE_CONFIGURATION =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .setCompression(COMPRESSION)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .build();
  private static final Map<String, ExternalTableDefinition> TABLE_DEFINITIONS =
      ImmutableMap.of("tableName", TABLE_CONFIGURATION);
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final Priority PRIORITY = Priority.BATCH;
  private static final boolean ALLOW_LARGE_RESULTS = true;
  private static final boolean USE_QUERY_CACHE = false;
  private static final boolean FLATTEN_RESULTS = true;
  private static final boolean USE_LEGACY_SQL = true;
  private static final Integer MAX_BILLING_TIER = 123;
  private static final List<SchemaUpdateOption> SCHEMA_UPDATE_OPTIONS =
      ImmutableList.of(SchemaUpdateOption.ALLOW_FIELD_RELAXATION);
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS = ImmutableList.of(
      UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION =
      QueryJobConfiguration.newBuilder(QUERY)
          .setUseQueryCache(USE_QUERY_CACHE)
          .setTableDefinitions(TABLE_DEFINITIONS)
          .setAllowLargeResults(ALLOW_LARGE_RESULTS)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setDefaultDataset(DATASET_ID)
          .setDestinationTable(TABLE_ID)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setPriority(PRIORITY)
          .setFlattenResults(FLATTEN_RESULTS)
          .setUserDefinedFunctions(USER_DEFINED_FUNCTIONS)
          .setDryRun(true)
          .setUseLegacySql(USE_LEGACY_SQL)
          .setMaximumBillingTier(MAX_BILLING_TIER)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .build();

  @Test
  public void testToBuilder() {
    compareQueryJobConfiguration(QUERY_JOB_CONFIGURATION,
        QUERY_JOB_CONFIGURATION.toBuilder().build());
    QueryJobConfiguration job = QUERY_JOB_CONFIGURATION.toBuilder()
        .setQuery("New BigQuery SQL")
        .build();
    assertEquals("New BigQuery SQL", job.getQuery());
    job = job.toBuilder().setQuery(QUERY).build();
    compareQueryJobConfiguration(QUERY_JOB_CONFIGURATION, job);
  }

  @Test
  public void testOf() {
    QueryJobConfiguration job = QueryJobConfiguration.of(QUERY);
    assertEquals(QUERY, job.getQuery());
  }

  @Test
  public void testToBuilderIncomplete() {
    QueryJobConfiguration job = QueryJobConfiguration.of(QUERY);
    compareQueryJobConfiguration(job, job.toBuilder().build());
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
    assertEquals("p", configuration.getDefaultDataset().getProject());
    assertEquals("p", configuration.getDestinationTable().getProject());
  }

  @Test
  public void testGetType() {
    assertEquals(JobConfiguration.Type.QUERY, QUERY_JOB_CONFIGURATION.getType());
  }

  private void compareQueryJobConfiguration(QueryJobConfiguration expected,
      QueryJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.dryRun(), value.dryRun());
    assertEquals(expected.allowLargeResults(), value.allowLargeResults());
    assertEquals(expected.getCreateDisposition(), value.getCreateDisposition());
    assertEquals(expected.getDefaultDataset(), value.getDefaultDataset());
    assertEquals(expected.getDestinationTable(), value.getDestinationTable());
    assertEquals(expected.flattenResults(), value.flattenResults());
    assertEquals(expected.getPriority(), value.getPriority());
    assertEquals(expected.getQuery(), value.getQuery());
    assertEquals(expected.getTableDefinitions(), value.getTableDefinitions());
    assertEquals(expected.useQueryCache(), value.useQueryCache());
    assertEquals(expected.getUserDefinedFunctions(), value.getUserDefinedFunctions());
    assertEquals(expected.getWriteDisposition(), value.getWriteDisposition());
    assertEquals(expected.useLegacySql(), value.useLegacySql());
    assertEquals(expected.getMaximumBillingTier(), value.getMaximumBillingTier());
    assertEquals(expected.getSchemaUpdateOptions(), value.getSchemaUpdateOptions());
  }
}
