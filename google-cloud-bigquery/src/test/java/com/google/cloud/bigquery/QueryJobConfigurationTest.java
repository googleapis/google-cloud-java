/*
 * Copyright 2016 Google LLC
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
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.QueryJobConfiguration.Priority;
import com.google.cloud.bigquery.TimePartitioning.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class QueryJobConfigurationTest {

  private static final String TEST_PROJECT_ID = "test-project-id";
  private static final String QUERY = "BigQuery SQL";
  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final String KEY = "time_zone";
  private static final String VALUE = "US/Eastern";
  private static final ConnectionProperty CONNECTION_PROPERTY =
      ConnectionProperty.newBuilder().setKey(KEY).setValue(VALUE).build();
  private static final List<ConnectionProperty> CONNECTION_PROPERTIES =
      ImmutableList.of(CONNECTION_PROPERTY);
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
  private static final Long MAX_BYTES_BILL = 12345L;
  private static final List<SchemaUpdateOption> SCHEMA_UPDATE_OPTIONS =
      ImmutableList.of(SchemaUpdateOption.ALLOW_FIELD_RELAXATION);
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS =
      ImmutableList.of(UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final EncryptionConfiguration JOB_ENCRYPTION_CONFIGURATION =
      EncryptionConfiguration.newBuilder().setKmsKeyName("KMS_KEY_1").build();
  private static final TimePartitioning TIME_PARTITIONING = TimePartitioning.of(Type.DAY);
  private static final Clustering CLUSTERING =
      Clustering.newBuilder().setFields(ImmutableList.of("Foo", "Bar")).build();
  private static final Long TIMEOUT = 10L;
  private static final Map<String, String> LABELS =
      ImmutableMap.of("test-job-name", "test-query-job");
  private static final RangePartitioning.Range RANGE =
      RangePartitioning.Range.newBuilder().setStart(1L).setInterval(2L).setEnd(10L).build();
  private static final RangePartitioning RANGE_PARTITIONING =
      RangePartitioning.newBuilder().setField("IntegerField").setRange(RANGE).build();
  private static final QueryParameterValue STRING_PARAMETER =
      QueryParameterValue.string("stringValue");
  private static final QueryParameterValue TIMESTAMP_PARAMETER =
      QueryParameterValue.timestamp("2014-01-01 07:00:00.000000+00:00");
  private static final QueryParameterValue BIGNUMERIC_PARAMETER =
      QueryParameterValue.bigNumeric(new BigDecimal(1 / 3));
  private static final List<QueryParameterValue> POSITIONAL_PARAMETER =
      ImmutableList.of(STRING_PARAMETER, TIMESTAMP_PARAMETER, BIGNUMERIC_PARAMETER);
  private static final Map<String, QueryParameterValue> NAME_PARAMETER =
      ImmutableMap.of("string", STRING_PARAMETER, "timestamp", TIMESTAMP_PARAMETER);
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
          .setMaximumBytesBilled(MAX_BYTES_BILL)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .setDestinationEncryptionConfiguration(JOB_ENCRYPTION_CONFIGURATION)
          .setTimePartitioning(TIME_PARTITIONING)
          .setClustering(CLUSTERING)
          .setJobTimeoutMs(TIMEOUT)
          .setLabels(LABELS)
          .setRangePartitioning(RANGE_PARTITIONING)
          .setConnectionProperties(CONNECTION_PROPERTIES)
          .setPositionalParameters(POSITIONAL_PARAMETER)
          .build();
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_ADD_POSITIONAL_PARAMETER =
      QUERY_JOB_CONFIGURATION
          .toBuilder()
          .setPositionalParameters(ImmutableList.<QueryParameterValue>of())
          .addPositionalParameter(STRING_PARAMETER)
          .build();
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_SET_NAME_PARAMETER =
      QUERY_JOB_CONFIGURATION
          .toBuilder()
          .setPositionalParameters(ImmutableList.<QueryParameterValue>of())
          .setNamedParameters(NAME_PARAMETER)
          .build();

  @Test
  public void testToBuilder() {
    compareQueryJobConfiguration(
        QUERY_JOB_CONFIGURATION, QUERY_JOB_CONFIGURATION.toBuilder().build());
    QueryJobConfiguration job =
        QUERY_JOB_CONFIGURATION.toBuilder().setQuery("New BigQuery SQL").build();
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
    assertNotNull(QUERY_JOB_CONFIGURATION.getJobTimeoutMs());
    assertNotNull(QUERY_JOB_CONFIGURATION.getLabels());
    assertNotNull(QUERY_JOB_CONFIGURATION.getRangePartitioning());
    assertNotNull(QUERY_JOB_CONFIGURATION.getConnectionProperties());
    assertNotNull(QUERY_JOB_CONFIGURATION.getPositionalParameters());
    assertNotNull(QUERY_JOB_CONFIGURATION.getNamedParameters());
    compareQueryJobConfiguration(
        QUERY_JOB_CONFIGURATION, QueryJobConfiguration.fromPb(QUERY_JOB_CONFIGURATION.toPb()));
    QueryJobConfiguration job = QueryJobConfiguration.of(QUERY);
    compareQueryJobConfiguration(job, QueryJobConfiguration.fromPb(job.toPb()));
  }

  @Test
  public void testSetProjectId() {
    QueryJobConfiguration configuration = QUERY_JOB_CONFIGURATION.setProjectId(TEST_PROJECT_ID);
    assertEquals(TEST_PROJECT_ID, configuration.getDefaultDataset().getProject());
    assertEquals(TEST_PROJECT_ID, configuration.getDestinationTable().getProject());
  }

  @Test
  public void testSetProjectIdDoNotOverride() {
    QueryJobConfiguration configuration =
        QUERY_JOB_CONFIGURATION
            .toBuilder()
            .setDestinationTable(TABLE_ID.setProjectId(TEST_PROJECT_ID))
            .build()
            .setProjectId("update-only-on-dataset");
    assertEquals("update-only-on-dataset", configuration.getDefaultDataset().getProject());
    assertEquals(TEST_PROJECT_ID, configuration.getDestinationTable().getProject());
  }

  @Test
  public void testGetType() {
    assertEquals(JobConfiguration.Type.QUERY, QUERY_JOB_CONFIGURATION.getType());
  }

  @Test
  public void testPositionalParameter() {
    compareQueryJobConfiguration(
        QUERY_JOB_CONFIGURATION_ADD_POSITIONAL_PARAMETER,
        QUERY_JOB_CONFIGURATION_ADD_POSITIONAL_PARAMETER.toBuilder().build());
  }

  @Test
  public void testNamedParameter() {
    compareQueryJobConfiguration(
        QUERY_JOB_CONFIGURATION_SET_NAME_PARAMETER,
        QUERY_JOB_CONFIGURATION_SET_NAME_PARAMETER.toBuilder().build());
  }

  private void compareQueryJobConfiguration(
      QueryJobConfiguration expected, QueryJobConfiguration value) {
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
    assertEquals(expected.getMaximumBytesBilled(), value.getMaximumBytesBilled());
    assertEquals(expected.getSchemaUpdateOptions(), value.getSchemaUpdateOptions());
    assertEquals(
        expected.getDestinationEncryptionConfiguration(),
        value.getDestinationEncryptionConfiguration());
    assertEquals(expected.getTimePartitioning(), value.getTimePartitioning());
    assertEquals(expected.getClustering(), value.getClustering());
    assertEquals(expected.getJobTimeoutMs(), value.getJobTimeoutMs());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.getRangePartitioning(), value.getRangePartitioning());
    assertEquals(expected.getConnectionProperties(), value.getConnectionProperties());
    assertEquals(expected.getPositionalParameters(), value.getPositionalParameters());
    assertEquals(expected.getNamedParameters(), value.getNamedParameters());
  }
}
