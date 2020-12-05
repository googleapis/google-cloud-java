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

package com.google.cloud.bigquery;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.google.api.services.bigquery.model.QueryRequest;
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.QueryJobConfiguration.Priority;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class QueryRequestInfoTest {

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
  private static final TimePartitioning TIME_PARTITIONING =
      TimePartitioning.of(TimePartitioning.Type.DAY);
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
  private static final List<QueryParameterValue> POSITIONAL_PARAMETER =
      ImmutableList.of(STRING_PARAMETER, TIMESTAMP_PARAMETER);
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
          .setMaxResults(100L)
          .build();
  QueryRequestInfo REQUEST_INFO = new QueryRequestInfo(QUERY_JOB_CONFIGURATION);
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_SUPPORTED =
      QueryJobConfiguration.newBuilder(QUERY)
          .setUseQueryCache(USE_QUERY_CACHE)
          .setDefaultDataset(DATASET_ID)
          .setDryRun(true)
          .setUseLegacySql(USE_LEGACY_SQL)
          .setMaximumBytesBilled(MAX_BYTES_BILL)
          .setLabels(LABELS)
          .setConnectionProperties(CONNECTION_PROPERTIES)
          .setPositionalParameters(POSITIONAL_PARAMETER)
          .setMaxResults(100L)
          .build();
  QueryRequestInfo REQUEST_INFO_SUPPORTED = new QueryRequestInfo(QUERY_JOB_CONFIGURATION_SUPPORTED);

  @Test
  public void testIsFastQuerySupported() {
    assertEquals(false, REQUEST_INFO.isFastQuerySupported());
    assertEquals(true, REQUEST_INFO_SUPPORTED.isFastQuerySupported());
  }

  @Test
  public void testToPb() {
    QueryRequest requestPb = REQUEST_INFO.toPb();
    assertEquals(requestPb, REQUEST_INFO.toPb());
  }

  @Test
  public void equalTo() {
    compareQueryRequestInfo(
        new QueryRequestInfo(QUERY_JOB_CONFIGURATION_SUPPORTED), REQUEST_INFO_SUPPORTED);
    compareQueryRequestInfo(new QueryRequestInfo(QUERY_JOB_CONFIGURATION), REQUEST_INFO);
  }

  private void compareQueryRequestInfo(QueryRequestInfo expected, QueryRequestInfo actual) {
    // requestId are expected to be different
    assertThat(actual).isEqualToIgnoringGivenFields(expected, "requestId");
  }
}
