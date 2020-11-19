/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery.it;

import static com.google.cloud.bigquery.JobStatus.State.DONE;
import static com.google.common.truth.Truth.assertThat;
import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.Date;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.RetryOption;
import com.google.cloud.Role;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.Acl;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQuery.DatasetField;
import com.google.cloud.bigquery.BigQuery.DatasetListOption;
import com.google.cloud.bigquery.BigQuery.DatasetOption;
import com.google.cloud.bigquery.BigQuery.JobField;
import com.google.cloud.bigquery.BigQuery.JobListOption;
import com.google.cloud.bigquery.BigQuery.JobOption;
import com.google.cloud.bigquery.BigQuery.TableField;
import com.google.cloud.bigquery.BigQuery.TableOption;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Clustering;
import com.google.cloud.bigquery.ConnectionProperty;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.ExtractJobConfiguration;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.MaterializedViewDefinition;
import com.google.cloud.bigquery.Model;
import com.google.cloud.bigquery.ModelId;
import com.google.cloud.bigquery.ModelInfo;
import com.google.cloud.bigquery.PolicyTags;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.RangePartitioning;
import com.google.cloud.bigquery.Routine;
import com.google.cloud.bigquery.RoutineArgument;
import com.google.cloud.bigquery.RoutineId;
import com.google.cloud.bigquery.RoutineInfo;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLDataType;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.TimePartitioning;
import com.google.cloud.bigquery.TimePartitioning.Type;
import com.google.cloud.bigquery.ViewDefinition;
import com.google.cloud.bigquery.WriteChannelConfiguration;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.threeten.bp.Duration;

public class ITBigQueryTest {

  private static final byte[] BYTES = {0xD, 0xE, 0xA, 0xD};
  private static final String BYTES_BASE64 = BaseEncoding.base64().encode(BYTES);
  private static final Long EXPIRATION_MS = 86400000L;
  private static final Logger LOG = Logger.getLogger(ITBigQueryTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String DESCRIPTION = "Test dataset";
  private static final String OTHER_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String MODEL_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String ROUTINE_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String RANDOM_ID = UUID.randomUUID().toString().substring(0, 8);
  private static final Map<String, String> LABELS =
      ImmutableMap.of(
          "example-label1", "example-value1",
          "example-label2", "example-value2");
  private static final String sampleTag =
      String.format("projects/%s/locations/us/taxonomies/1/policyTags/2", PROJECT_ID);
  private static final PolicyTags POLICY_TAGS =
      PolicyTags.newBuilder().setNames(ImmutableList.of(sampleTag)).build();
  private static final Field TIMESTAMP_FIELD_SCHEMA =
      Field.newBuilder("TimestampField", LegacySQLTypeName.TIMESTAMP)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("TimestampDescription")
          .build();
  private static final Field STRING_FIELD_SCHEMA =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("StringDescription")
          .build();
  private static final Field INTEGER_ARRAY_FIELD_SCHEMA =
      Field.newBuilder("IntegerArrayField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.REPEATED)
          .setDescription("IntegerArrayDescription")
          .build();
  private static final Field BOOLEAN_FIELD_SCHEMA =
      Field.newBuilder("BooleanField", LegacySQLTypeName.BOOLEAN)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BooleanDescription")
          .build();
  private static final Field BYTES_FIELD_SCHEMA =
      Field.newBuilder("BytesField", LegacySQLTypeName.BYTES)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BytesDescription")
          .build();
  private static final Field RECORD_FIELD_SCHEMA =
      Field.newBuilder(
              "RecordField",
              LegacySQLTypeName.RECORD,
              TIMESTAMP_FIELD_SCHEMA,
              STRING_FIELD_SCHEMA,
              INTEGER_ARRAY_FIELD_SCHEMA,
              BOOLEAN_FIELD_SCHEMA,
              BYTES_FIELD_SCHEMA)
          .setMode(Field.Mode.REQUIRED)
          .setDescription("RecordDescription")
          .build();
  private static final Field INTEGER_FIELD_SCHEMA =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("IntegerDescription")
          .build();
  private static final Field FLOAT_FIELD_SCHEMA =
      Field.newBuilder("FloatField", LegacySQLTypeName.FLOAT)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FloatDescription")
          .build();
  private static final Field GEOGRAPHY_FIELD_SCHEMA =
      Field.newBuilder("GeographyField", LegacySQLTypeName.GEOGRAPHY)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("GeographyDescription")
          .build();
  private static final Field NUMERIC_FIELD_SCHEMA =
      Field.newBuilder("NumericField", LegacySQLTypeName.NUMERIC)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("NumericDescription")
          .build();
  private static final Field BIGNUMERIC_FIELD_SCHEMA =
      Field.newBuilder("BigNumericField", LegacySQLTypeName.BIGNUMERIC)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BigNumericDescription")
          .build();
  private static final Field BIGNUMERIC_FIELD_SCHEMA1 =
      Field.newBuilder("BigNumericField1", LegacySQLTypeName.BIGNUMERIC)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BigNumeric1Description")
          .build();
  private static final Field BIGNUMERIC_FIELD_SCHEMA2 =
      Field.newBuilder("BigNumericField2", LegacySQLTypeName.BIGNUMERIC)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BigNumeric2Description")
          .build();
  private static final Field BIGNUMERIC_FIELD_SCHEMA3 =
      Field.newBuilder("BigNumericField3", LegacySQLTypeName.BIGNUMERIC)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BigNumeric3Description")
          .build();
  private static final Field BIGNUMERIC_FIELD_SCHEMA4 =
      Field.newBuilder("BigNumericField4", LegacySQLTypeName.BIGNUMERIC)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BigNumeric4Description")
          .build();
  private static final Field STRING_FIELD_SCHEMA_WITH_POLICY =
      Field.newBuilder("StringFieldWithPolicy", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("field has a policy")
          .setPolicyTags(POLICY_TAGS)
          .build();
  private static final Schema TABLE_SCHEMA =
      Schema.of(
          TIMESTAMP_FIELD_SCHEMA,
          STRING_FIELD_SCHEMA,
          INTEGER_ARRAY_FIELD_SCHEMA,
          BOOLEAN_FIELD_SCHEMA,
          BYTES_FIELD_SCHEMA,
          RECORD_FIELD_SCHEMA,
          INTEGER_FIELD_SCHEMA,
          FLOAT_FIELD_SCHEMA,
          GEOGRAPHY_FIELD_SCHEMA,
          NUMERIC_FIELD_SCHEMA,
          BIGNUMERIC_FIELD_SCHEMA,
          BIGNUMERIC_FIELD_SCHEMA1,
          BIGNUMERIC_FIELD_SCHEMA2,
          BIGNUMERIC_FIELD_SCHEMA3,
          BIGNUMERIC_FIELD_SCHEMA4);

  private static final Field DDL_TIMESTAMP_FIELD_SCHEMA =
      Field.newBuilder("TimestampField", LegacySQLTypeName.TIMESTAMP)
          .setDescription("TimestampDescription")
          .build();
  private static final Field DDL_STRING_FIELD_SCHEMA =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
          .setDescription("StringDescription")
          .build();
  private static final Field DDL_BOOLEAN_FIELD_SCHEMA =
      Field.newBuilder("BooleanField", LegacySQLTypeName.BOOLEAN)
          .setDescription("BooleanDescription")
          .build();
  private static final Schema DDL_TABLE_SCHEMA =
      Schema.of(DDL_TIMESTAMP_FIELD_SCHEMA, DDL_STRING_FIELD_SCHEMA, DDL_BOOLEAN_FIELD_SCHEMA);
  private static final Schema LARGE_TABLE_SCHEMA =
      Schema.of(
          Field.newBuilder("date", LegacySQLTypeName.DATE).setMode(Field.Mode.NULLABLE).build(),
          Field.newBuilder("county", LegacySQLTypeName.STRING).setMode(Field.Mode.NULLABLE).build(),
          Field.newBuilder("state_name", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("county_fips_code", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("confirmed_cases", LegacySQLTypeName.INTEGER)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("deaths", LegacySQLTypeName.INTEGER)
              .setMode(Field.Mode.NULLABLE)
              .build());

  private static final Schema SIMPLE_SCHEMA = Schema.of(STRING_FIELD_SCHEMA);
  private static final Schema POLICY_SCHEMA =
      Schema.of(STRING_FIELD_SCHEMA, STRING_FIELD_SCHEMA_WITH_POLICY, INTEGER_FIELD_SCHEMA);
  private static final Schema QUERY_RESULT_SCHEMA =
      Schema.of(
          Field.newBuilder("TimestampField", LegacySQLTypeName.TIMESTAMP)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("StringField", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BooleanField", LegacySQLTypeName.BOOLEAN)
              .setMode(Field.Mode.NULLABLE)
              .build());
  private static final Schema QUERY_RESULT_SCHEMA_BIGNUMERIC =
      Schema.of(
          Field.newBuilder("TimestampField", LegacySQLTypeName.TIMESTAMP)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("StringField", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BooleanField", LegacySQLTypeName.BOOLEAN)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BigNumericField", LegacySQLTypeName.BIGNUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BigNumericField1", LegacySQLTypeName.BIGNUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BigNumericField2", LegacySQLTypeName.BIGNUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BigNumericField3", LegacySQLTypeName.BIGNUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BigNumericField4", LegacySQLTypeName.BIGNUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .build());
  private static final Schema VIEW_SCHEMA =
      Schema.of(
          Field.newBuilder("TimestampField", LegacySQLTypeName.TIMESTAMP)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("StringField", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("BooleanField", LegacySQLTypeName.BOOLEAN)
              .setMode(Field.Mode.NULLABLE)
              .build());
  private static final RangePartitioning.Range RANGE =
      RangePartitioning.Range.newBuilder().setStart(1L).setInterval(2L).setEnd(20L).build();
  private static final RangePartitioning RANGE_PARTITIONING =
      RangePartitioning.newBuilder().setField("IntegerField").setRange(RANGE).build();
  private static final String LOAD_FILE = "load.csv";
  private static final String LOAD_FILE_LARGE = "load_large.csv";
  private static final String JSON_LOAD_FILE = "load.json";
  private static final String JSON_LOAD_FILE_SIMPLE = "load_simple.json";
  private static final String EXTRACT_FILE = "extract.csv";
  private static final String EXTRACT_MODEL_FILE = "extract_model.csv";
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final TableId TABLE_ID = TableId.of(DATASET, "testing_table");
  private static final TableId TABLE_ID_DDL = TableId.of(DATASET, "ddl_testing_table");
  private static final TableId TABLE_ID_FASTQUERY = TableId.of(DATASET, "fastquery_testing_table");
  private static final TableId TABLE_ID_LARGE = TableId.of(DATASET, "large_data_testing_table");
  private static final String CSV_CONTENT = "StringValue1\nStringValue2\n";
  private static final String JSON_CONTENT =
      "{"
          + "  \"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
          + "  \"StringField\": \"stringValue\","
          + "  \"IntegerArrayField\": [\"0\", \"1\"],"
          + "  \"BooleanField\": \"false\","
          + "  \"BytesField\": \""
          + BYTES_BASE64
          + "\","
          + "  \"RecordField\": {"
          + "    \"TimestampField\": \"1969-07-20 20:18:04 UTC\","
          + "    \"StringField\": null,"
          + "    \"IntegerArrayField\": [\"1\",\"0\"],"
          + "    \"BooleanField\": \"true\","
          + "    \"BytesField\": \""
          + BYTES_BASE64
          + "\""
          + "  },"
          + "  \"IntegerField\": \"3\","
          + "  \"FloatField\": \"1.2\","
          + "  \"GeographyField\": \"POINT(-122.35022 47.649154)\","
          + "  \"NumericField\": \"123456.789012345\","
          + "  \"BigNumericField\": \"0.33333333333333333333333333333333333333\","
          + "  \"BigNumericField1\": \"1e-38\","
          + "  \"BigNumericField2\": \"-1e38\","
          + "  \"BigNumericField3\": \"578960446186580977117854925043439539266.34992332820282019728792003956564819967\","
          + "  \"BigNumericField4\": \"-578960446186580977117854925043439539266.34992332820282019728792003956564819968\""
          + "}\n"
          + "{"
          + "  \"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
          + "  \"StringField\": \"stringValue\","
          + "  \"IntegerArrayField\": [\"0\", \"1\"],"
          + "  \"BooleanField\": \"false\","
          + "  \"BytesField\": \""
          + BYTES_BASE64
          + "\","
          + "  \"RecordField\": {"
          + "    \"TimestampField\": \"1969-07-20 20:18:04 UTC\","
          + "    \"StringField\": null,"
          + "    \"IntegerArrayField\": [\"1\",\"0\"],"
          + "    \"BooleanField\": \"true\","
          + "    \"BytesField\": \""
          + BYTES_BASE64
          + "\""
          + "  },"
          + "  \"IntegerField\": \"3\","
          + "  \"FloatField\": \"1.2\","
          + "  \"GeographyField\": \"POINT(-122.35022 47.649154)\","
          + "  \"NumericField\": \"123456.789012345\","
          + "  \"BigNumericField\": \"0.33333333333333333333333333333333333333\","
          + "  \"BigNumericField1\": \"1e-38\","
          + "  \"BigNumericField2\": \"-1e38\","
          + "  \"BigNumericField3\": \"578960446186580977117854925043439539266.34992332820282019728792003956564819967\","
          + "  \"BigNumericField4\": \"-578960446186580977117854925043439539266.34992332820282019728792003956564819968\""
          + "}";
  private static final String JSON_CONTENT_SIMPLE =
      "{"
          + "  \"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
          + "  \"StringField\": \"stringValue\","
          + "  \"BooleanField\": \"false\""
          + "}\n"
          + "{"
          + "  \"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
          + "  \"StringField\": \"stringValue\","
          + "  \"BooleanField\": \"false\""
          + "}";
  private static final String KEY = "time_zone";
  private static final String VALUE = "US/Eastern";
  private static final ConnectionProperty CONNECTION_PROPERTY =
      ConnectionProperty.newBuilder().setKey(KEY).setValue(VALUE).build();
  private static final List<ConnectionProperty> CONNECTION_PROPERTIES =
      ImmutableList.of(CONNECTION_PROPERTY);

  private static final Set<String> PUBLIC_DATASETS =
      ImmutableSet.of("github_repos", "hacker_news", "noaa_gsod", "samples", "usa_names");

  private static final String PUBLIC_PROJECT = "bigquery-public-data";
  private static final String PUBLIC_DATASET = "census_bureau_international";

  private static BigQuery bigquery;
  private static Storage storage;

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() throws InterruptedException, IOException {
    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    RemoteStorageHelper storageHelper = RemoteStorageHelper.create();
    Map<String, String> labels = ImmutableMap.of("test-job-name", "test-load-job");
    bigquery = bigqueryHelper.getOptions().getService();
    storage = storageHelper.getOptions().getService();
    storage.create(BucketInfo.of(BUCKET));
    storage.create(
        BlobInfo.newBuilder(BUCKET, LOAD_FILE).setContentType("text/plain").build(),
        CSV_CONTENT.getBytes(StandardCharsets.UTF_8));
    storage.create(
        BlobInfo.newBuilder(BUCKET, JSON_LOAD_FILE).setContentType("application/json").build(),
        JSON_CONTENT.getBytes(StandardCharsets.UTF_8));
    storage.create(
        BlobInfo.newBuilder(BUCKET, JSON_LOAD_FILE_SIMPLE)
            .setContentType("application/json")
            .build(),
        JSON_CONTENT_SIMPLE.getBytes(StandardCharsets.UTF_8));
    storage.createFrom(
        BlobInfo.newBuilder(BUCKET, LOAD_FILE_LARGE).setContentType("text/plain").build(),
        FileSystems.getDefault().getPath("src/test/resources", "QueryTestData.csv"));
    DatasetInfo info =
        DatasetInfo.newBuilder(DATASET).setDescription(DESCRIPTION).setLabels(LABELS).build();
    bigquery.create(info);
    DatasetInfo info2 =
        DatasetInfo.newBuilder(MODEL_DATASET).setDescription("java model lifecycle").build();
    bigquery.create(info2);
    DatasetInfo info3 =
        DatasetInfo.newBuilder(ROUTINE_DATASET).setDescription("java routine lifecycle").build();
    bigquery.create(info3);
    LoadJobConfiguration configuration =
        LoadJobConfiguration.newBuilder(
                TABLE_ID, "gs://" + BUCKET + "/" + JSON_LOAD_FILE, FormatOptions.json())
            .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
            .setSchema(TABLE_SCHEMA)
            .setLabels(labels)
            .build();
    Job job = bigquery.create(JobInfo.of(configuration));
    job = job.waitFor();
    assertNull(job.getStatus().getError());
    LoadJobConfiguration loadJobConfiguration = job.getConfiguration();
    assertEquals(labels, loadJobConfiguration.getLabels());

    LoadJobConfiguration configurationFastQuery =
        LoadJobConfiguration.newBuilder(
                TABLE_ID_FASTQUERY, "gs://" + BUCKET + "/" + JSON_LOAD_FILE, FormatOptions.json())
            .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
            .setSchema(TABLE_SCHEMA)
            .setLabels(labels)
            .build();
    Job jobFastQuery = bigquery.create(JobInfo.of(configurationFastQuery));
    jobFastQuery = jobFastQuery.waitFor();
    assertNull(jobFastQuery.getStatus().getError());

    LoadJobConfiguration configurationDDL =
        LoadJobConfiguration.newBuilder(
                TABLE_ID_DDL, "gs://" + BUCKET + "/" + JSON_LOAD_FILE_SIMPLE, FormatOptions.json())
            .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
            .setSchema(DDL_TABLE_SCHEMA)
            .setLabels(labels)
            .build();
    Job jobDDL = bigquery.create(JobInfo.of(configurationDDL));
    jobDDL = jobDDL.waitFor();
    assertNull(jobDDL.getStatus().getError());

    LoadJobConfiguration configurationLargeTable =
        LoadJobConfiguration.newBuilder(
                TABLE_ID_LARGE, "gs://" + BUCKET + "/" + LOAD_FILE_LARGE, FormatOptions.csv())
            .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
            .setSchema(LARGE_TABLE_SCHEMA)
            .setLabels(labels)
            .build();
    Job jobLargeTable = bigquery.create(JobInfo.of(configurationLargeTable));
    jobLargeTable = jobLargeTable.waitFor();
    assertNull(jobLargeTable.getStatus().getError());
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
      RemoteBigQueryHelper.forceDelete(bigquery, MODEL_DATASET);
      RemoteBigQueryHelper.forceDelete(bigquery, ROUTINE_DATASET);
    }
    if (storage != null) {
      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 10, TimeUnit.SECONDS);
      if (!wasDeleted && LOG.isLoggable(Level.WARNING)) {
        LOG.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void testListDatasets() {
    Page<Dataset> datasets = bigquery.listDatasets("bigquery-public-data");
    Iterator<Dataset> iterator = datasets.iterateAll().iterator();
    Set<String> datasetNames = new HashSet<>();
    while (iterator.hasNext()) {
      datasetNames.add(iterator.next().getDatasetId().getDataset());
    }
    for (String type : PUBLIC_DATASETS) {
      assertTrue(datasetNames.contains(type));
    }
  }

  @Test
  public void testListDatasetsWithFilter() {
    String labelFilter = "labels.example-label1:example-value1";
    Page<Dataset> datasets = bigquery.listDatasets(DatasetListOption.labelFilter(labelFilter));
    int count = 0;
    for (Dataset dataset : datasets.getValues()) {
      assertTrue(
          "failed to find label key in dataset", dataset.getLabels().containsKey("example-label1"));
      assertTrue(
          "failed to find label value in dataset",
          dataset.getLabels().get("example-label1").equals("example-value1"));
      count++;
    }
    assertTrue(count > 0);
  }

  @Test
  public void testGetDataset() {
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(bigquery.getOptions().getProjectId(), dataset.getDatasetId().getProject());
    assertEquals(DATASET, dataset.getDatasetId().getDataset());
    assertEquals(DESCRIPTION, dataset.getDescription());
    assertEquals(LABELS, dataset.getLabels());
    assertNotNull(dataset.getAcl());
    assertNotNull(dataset.getEtag());
    assertNotNull(dataset.getGeneratedId());
    assertNotNull(dataset.getLastModified());
    assertNotNull(dataset.getSelfLink());
  }

  @Test
  public void testDatasetUpdateAccess() throws IOException {
    Dataset dataset = bigquery.getDataset(DATASET);
    ServiceAccountCredentials credentials =
        (ServiceAccountCredentials) GoogleCredentials.getApplicationDefault();
    List<Acl> acl =
        ImmutableList.of(
            Acl.of(new Acl.Group("projectOwners"), Acl.Role.OWNER),
            Acl.of(new Acl.User(credentials.getClientEmail()), Acl.Role.OWNER),
            Acl.of(new Acl.IamMember("allUsers"), Acl.Role.READER));
    Dataset remoteDataset = dataset.toBuilder().setAcl(acl).build().update();
    assertNotNull(remoteDataset);
    assertEquals(3, remoteDataset.getAcl().size());
  }

  @Test
  public void testGetDatasetWithSelectedFields() {
    Dataset dataset =
        bigquery.getDataset(
            DATASET, DatasetOption.fields(DatasetField.CREATION_TIME, DatasetField.LABELS));
    assertEquals(bigquery.getOptions().getProjectId(), dataset.getDatasetId().getProject());
    assertEquals(DATASET, dataset.getDatasetId().getDataset());
    assertEquals(LABELS, dataset.getLabels());
    assertNotNull(dataset.getCreationTime());
    assertNull(dataset.getDescription());
    assertNull(dataset.getDefaultTableLifetime());
    assertNull(dataset.getAcl());
    assertNull(dataset.getEtag());
    assertNull(dataset.getFriendlyName());
    assertNull(dataset.getGeneratedId());
    assertNull(dataset.getLastModified());
    assertNull(dataset.getLocation());
    assertNull(dataset.getSelfLink());
  }

  @Test
  public void testUpdateDataset() {
    Dataset dataset =
        bigquery.create(
            DatasetInfo.newBuilder(OTHER_DATASET)
                .setDescription("Some Description")
                .setLabels(Collections.singletonMap("a", "b"))
                .build());
    assertThat(dataset).isNotNull();
    assertThat(dataset.getDatasetId().getProject()).isEqualTo(bigquery.getOptions().getProjectId());
    assertThat(dataset.getDatasetId().getDataset()).isEqualTo(OTHER_DATASET);
    assertThat(dataset.getDescription()).isEqualTo("Some Description");
    assertThat(dataset.getLabels()).containsExactly("a", "b");

    Map<String, String> updateLabels = new HashMap<>();
    updateLabels.put("x", "y");
    updateLabels.put("a", null);
    Dataset updatedDataset =
        bigquery.update(
            dataset
                .toBuilder()
                .setDescription("Updated Description")
                .setLabels(updateLabels)
                .build());
    assertThat(updatedDataset.getDescription()).isEqualTo("Updated Description");
    assertThat(updatedDataset.getLabels()).containsExactly("x", "y");

    updatedDataset = bigquery.update(updatedDataset.toBuilder().setLabels(null).build());
    assertThat(updatedDataset.getLabels()).isEmpty();
    assertThat(dataset.delete()).isTrue();
  }

  @Test
  public void testUpdateDatasetWithSelectedFields() {
    Dataset dataset =
        bigquery.create(
            DatasetInfo.newBuilder(OTHER_DATASET).setDescription("Some Description").build());
    assertNotNull(dataset);
    assertEquals(bigquery.getOptions().getProjectId(), dataset.getDatasetId().getProject());
    assertEquals(OTHER_DATASET, dataset.getDatasetId().getDataset());
    assertEquals("Some Description", dataset.getDescription());
    Dataset updatedDataset =
        bigquery.update(
            dataset.toBuilder().setDescription("Updated Description").build(),
            DatasetOption.fields(DatasetField.DESCRIPTION));
    assertEquals("Updated Description", updatedDataset.getDescription());
    assertNull(updatedDataset.getCreationTime());
    assertNull(updatedDataset.getDefaultTableLifetime());
    assertNull(updatedDataset.getAcl());
    assertNull(updatedDataset.getEtag());
    assertNull(updatedDataset.getFriendlyName());
    assertNull(updatedDataset.getGeneratedId());
    assertNull(updatedDataset.getLastModified());
    assertNull(updatedDataset.getLocation());
    assertNull(updatedDataset.getSelfLink());
    assertTrue(dataset.delete());
  }

  @Test
  public void testGetNonExistingTable() {
    assertNull(bigquery.getTable(DATASET, "test_get_non_existing_table"));
  }

  @Test
  public void testCreateTableWithRangePartitioning() {
    String tableName = "test_create_table_rangepartitioning";
    TableId tableId = TableId.of(DATASET, tableName);
    try {
      StandardTableDefinition tableDefinition =
          StandardTableDefinition.newBuilder()
              .setSchema(TABLE_SCHEMA)
              .setRangePartitioning(RANGE_PARTITIONING)
              .build();
      Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
      assertNotNull(createdTable);
      Table remoteTable = bigquery.getTable(DATASET, tableName);
      assertEquals(
          RANGE,
          remoteTable.<StandardTableDefinition>getDefinition().getRangePartitioning().getRange());
      assertEquals(
          RANGE_PARTITIONING,
          remoteTable.<StandardTableDefinition>getDefinition().getRangePartitioning());
    } finally {
      bigquery.delete(tableId);
    }
  }

  public void testCreateTableWithPolicyTags() {
    String tableName = "test_create_table_policytags";
    TableId tableId = TableId.of(DATASET, tableName);
    try {
      StandardTableDefinition tableDefinition =
          StandardTableDefinition.newBuilder().setSchema(POLICY_SCHEMA).build();
      Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
      assertNotNull(createdTable);
      Table remoteTable = bigquery.getTable(DATASET, tableName);
      assertEquals(POLICY_SCHEMA, remoteTable.<StandardTableDefinition>getDefinition().getSchema());
    } finally {
      bigquery.delete(tableId);
    }
  }

  @Test
  public void testCreateAndGetTable() {
    String tableName = "test_create_and_get_table";
    TableId tableId = TableId.of(DATASET, tableName);
    TimePartitioning partitioning = TimePartitioning.of(Type.DAY);
    Clustering clustering =
        Clustering.newBuilder().setFields(ImmutableList.of(STRING_FIELD_SCHEMA.getName())).build();
    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder()
            .setSchema(TABLE_SCHEMA)
            .setTimePartitioning(partitioning)
            .setClustering(clustering)
            .build();
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertTrue(remoteTable.getDefinition() instanceof StandardTableDefinition);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertEquals(TableDefinition.Type.TABLE, remoteTable.getDefinition().getType());
    assertEquals(TABLE_SCHEMA, remoteTable.getDefinition().getSchema());
    assertNotNull(remoteTable.getCreationTime());
    assertNotNull(remoteTable.getLastModifiedTime());
    assertNotNull(remoteTable.<StandardTableDefinition>getDefinition().getNumBytes());
    assertNotNull(remoteTable.<StandardTableDefinition>getDefinition().getNumLongTermBytes());
    assertNotNull(remoteTable.<StandardTableDefinition>getDefinition().getNumRows());
    assertEquals(
        partitioning, remoteTable.<StandardTableDefinition>getDefinition().getTimePartitioning());
    assertEquals(clustering, remoteTable.<StandardTableDefinition>getDefinition().getClustering());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateAndGetTableWithSelectedField() {
    String tableName = "test_create_and_get_selected_fields_table";
    TableId tableId = TableId.of(DATASET, tableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    Table createdTable =
        bigquery.create(
            TableInfo.newBuilder(tableId, tableDefinition)
                .setLabels(Collections.singletonMap("a", "b"))
                .build());
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable =
        bigquery.getTable(
            DATASET, tableName, TableOption.fields(TableField.CREATION_TIME, TableField.LABELS));
    assertNotNull(remoteTable);
    assertTrue(remoteTable.getDefinition() instanceof StandardTableDefinition);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertEquals(TableDefinition.Type.TABLE, remoteTable.getDefinition().getType());
    assertThat(remoteTable.getLabels()).containsExactly("a", "b");
    assertNotNull(remoteTable.getCreationTime());
    assertNull(remoteTable.getDefinition().getSchema());
    assertNull(remoteTable.getLastModifiedTime());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getNumBytes());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getNumLongTermBytes());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getNumRows());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getTimePartitioning());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getClustering());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateExternalTable() throws InterruptedException {
    String tableName = "test_create_external_table";
    TableId tableId = TableId.of(DATASET, tableName);
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.of(
            "gs://" + BUCKET + "/" + JSON_LOAD_FILE, TABLE_SCHEMA, FormatOptions.json());
    TableInfo tableInfo = TableInfo.of(tableId, externalTableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertTrue(remoteTable.getDefinition() instanceof ExternalTableDefinition);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertEquals(TABLE_SCHEMA, remoteTable.getDefinition().getSchema());
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(
                "SELECT TimestampField, StringField, IntegerArrayField, BooleanField FROM "
                    + DATASET
                    + "."
                    + tableName)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setUseLegacySql(true)
            .build();
    TableResult result = bigquery.query(config);
    long integerValue = 0;
    int rowCount = 0;
    for (FieldValueList row : result.getValues()) {
      FieldValue timestampCell = row.get(0);
      assertEquals(timestampCell, row.get("TimestampField"));
      FieldValue stringCell = row.get(1);
      assertEquals(stringCell, row.get("StringField"));
      FieldValue integerCell = row.get(2);
      assertEquals(integerCell, row.get("IntegerArrayField"));
      FieldValue booleanCell = row.get(3);
      assertEquals(booleanCell, row.get("BooleanField"));

      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, integerCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(integerValue, integerCell.getLongValue());
      assertEquals(false, booleanCell.getBooleanValue());
      integerValue = ~integerValue & 0x1;
      rowCount++;
    }
    assertEquals(4, rowCount);
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateViewTable() throws InterruptedException {
    String tableName = "test_create_view_table";
    TableId tableId = TableId.of(DATASET, tableName);
    ViewDefinition viewDefinition =
        ViewDefinition.newBuilder(
                String.format(
                    "SELECT TimestampField, StringField, BooleanField FROM %s.%s",
                    DATASET, TABLE_ID.getTable()))
            .setUseLegacySql(true)
            .build();
    TableInfo tableInfo = TableInfo.of(tableId, viewDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertTrue(remoteTable.getDefinition() instanceof ViewDefinition);
    assertEquals(VIEW_SCHEMA, remoteTable.getDefinition().getSchema());
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder("SELECT * FROM " + tableName)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setUseLegacySql(true)
            .build();
    TableResult result = bigquery.query(config);
    int rowCount = 0;
    for (FieldValueList row : result.getValues()) {
      FieldValue timestampCell = row.get(0);
      assertEquals(timestampCell, row.get("TimestampField"));
      FieldValue stringCell = row.get(1);
      assertEquals(stringCell, row.get("StringField"));
      FieldValue booleanCell = row.get(2);
      assertEquals(booleanCell, row.get("BooleanField"));
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateMaterializedViewTable() {
    String tableName = "test_materialized_view_table";
    TableId tableId = TableId.of(DATASET, tableName);
    MaterializedViewDefinition viewDefinition =
        MaterializedViewDefinition.newBuilder(
                String.format(
                    "SELECT MAX(TimestampField) AS TimestampField,StringField, MAX(BooleanField) AS BooleanField FROM %s.%s.%s GROUP BY StringField",
                    PROJECT_ID, DATASET, TABLE_ID.getTable()))
            .build();
    TableInfo tableInfo = TableInfo.of(tableId, viewDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertTrue(remoteTable.getDefinition() instanceof MaterializedViewDefinition);
    assertEquals(VIEW_SCHEMA, remoteTable.getDefinition().getSchema());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testTableIAM() {
    String tableName = "test_iam_table";
    TableId tableId = TableId.of(DATASET, tableName);
    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder().setSchema(TABLE_SCHEMA).build();

    bigquery.create(TableInfo.of(tableId, tableDefinition));

    // Check we have some of the expected default permissions as we created the table.
    List<String> checkedPerms =
        ImmutableList.<String>of(
            "bigquery.tables.get", "bigquery.tables.getData", "bigquery.tables.update");
    List<String> grantedPerms = bigquery.testIamPermissions(tableId, checkedPerms);
    assertEquals(checkedPerms, grantedPerms);

    // get and modify policy
    Policy policy = bigquery.getIamPolicy(tableId);
    Policy editedPolicy =
        policy
            .toBuilder()
            .addIdentity(Role.of("roles/bigquery.dataViewer"), Identity.allUsers())
            .build();
    Policy updatedPolicy = bigquery.setIamPolicy(tableId, editedPolicy);
    // We should have a different etag, so the policies aren't strictly equal
    assertNotEquals(updatedPolicy, editedPolicy);
    // However, the bindings should be.
    assertEquals(updatedPolicy.getBindingsList(), editedPolicy.getBindingsList());
  }

  @Test
  public void testListTables() {
    String tableName = "test_list_tables";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    Page<Table> tables = bigquery.listTables(DATASET);
    boolean found = false;
    Iterator<Table> tableIterator = tables.getValues().iterator();
    while (tableIterator.hasNext() && !found) {
      if (tableIterator.next().getTableId().equals(createdTable.getTableId())) {
        found = true;
      }
    }
    assertTrue(found);
    assertTrue(createdTable.delete());
  }

  @Test
  public void testListTablesWithPartitioning() {
    String tableName = "test_list_tables_partitioning";
    TimePartitioning timePartitioning = TimePartitioning.of(Type.DAY, EXPIRATION_MS);
    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder()
            .setSchema(TABLE_SCHEMA)
            .setTimePartitioning(timePartitioning)
            .build();
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdPartitioningTable = bigquery.create(tableInfo);
    assertNotNull(createdPartitioningTable);
    try {
      Page<Table> tables = bigquery.listTables(DATASET);
      boolean found = false;
      Iterator<Table> tableIterator = tables.getValues().iterator();
      while (tableIterator.hasNext() && !found) {
        StandardTableDefinition standardTableDefinition = tableIterator.next().getDefinition();
        if (standardTableDefinition.getTimePartitioning() != null
            && standardTableDefinition.getTimePartitioning().getType().equals(Type.DAY)
            && standardTableDefinition
                .getTimePartitioning()
                .getExpirationMs()
                .equals(EXPIRATION_MS)) {
          found = true;
        }
      }
      assertTrue(found);
    } finally {
      createdPartitioningTable.delete();
    }
  }

  @Test
  public void testListTablesWithRangePartitioning() {
    String tableName = "test_list_tables_range_partitioning";
    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder()
            .setSchema(TABLE_SCHEMA)
            .setRangePartitioning(RANGE_PARTITIONING)
            .build();
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdRangePartitioningTable = bigquery.create(tableInfo);
    assertNotNull(createdRangePartitioningTable);
    try {
      Page<Table> tables = bigquery.listTables(DATASET);
      boolean found = false;
      Iterator<Table> tableIterator = tables.getValues().iterator();
      while (tableIterator.hasNext() && !found) {
        StandardTableDefinition standardTableDefinition = tableIterator.next().getDefinition();
        if (standardTableDefinition.getRangePartitioning() != null) {
          assertEquals(RANGE_PARTITIONING, standardTableDefinition.getRangePartitioning());
          assertEquals(RANGE, standardTableDefinition.getRangePartitioning().getRange());
          assertEquals("IntegerField", standardTableDefinition.getRangePartitioning().getField());
          found = true;
        }
      }
      assertTrue(found);
    } finally {
      createdRangePartitioningTable.delete();
    }
  }

  @Test
  public void testListPartitions() throws InterruptedException {
    String tableName = "test_table_partitions_" + UUID.randomUUID().toString().substring(0, 8);
    Date date = Date.fromJavaUtilDate(new java.util.Date());
    String partitionDate = date.toString().replaceAll("-", "");
    TableId tableId = TableId.of(DATASET, tableName + "$" + partitionDate);
    String query =
        String.format(
            "CREATE OR REPLACE TABLE  %s.%s ( StringField STRING )"
                + " PARTITION BY DATE(_PARTITIONTIME) "
                + "OPTIONS( partition_expiration_days=1)",
            DATASET, tableName);
    Job job = bigquery.create(JobInfo.of(QueryJobConfiguration.newBuilder(query).build()));
    job.waitFor();
    assertTrue(job.isDone());
    Map<String, Object> row = new HashMap<>();
    row.put("StringField", "StringValue");
    InsertAllRequest request = InsertAllRequest.newBuilder(tableId).addRow(row).build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.getInsertErrors().size());
    List<String> partitions = bigquery.listPartitions(TableId.of(DATASET, tableName));
    assertEquals(1, partitions.size());
    bigquery.delete(tableId);
  }

  @Test
  public void testUpdateTable() {
    String tableName = "test_update_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo =
        TableInfo.newBuilder(TableId.of(DATASET, tableName), tableDefinition)
            .setDescription("Some Description")
            .setLabels(Collections.singletonMap("a", "b"))
            .build();
    Table createdTable = bigquery.create(tableInfo);
    assertThat(createdTable.getDescription()).isEqualTo("Some Description");
    assertThat(createdTable.getLabels()).containsExactly("a", "b");

    Map<String, String> updateLabels = new HashMap<>();
    updateLabels.put("x", "y");
    updateLabels.put("a", null);
    Table updatedTable =
        bigquery.update(
            createdTable
                .toBuilder()
                .setDescription("Updated Description")
                .setLabels(updateLabels)
                .build());
    assertThat(updatedTable.getDescription()).isEqualTo("Updated Description");
    assertThat(updatedTable.getLabels()).containsExactly("x", "y");

    updatedTable = bigquery.update(updatedTable.toBuilder().setLabels(null).build());
    assertThat(updatedTable.getLabels()).isEmpty();
    assertThat(createdTable.delete()).isTrue();
  }

  @Test
  public void testUpdateTimePartitioning() {
    String tableName = "testUpdateTimePartitioning";
    TableId tableId = TableId.of(DATASET, tableName);
    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder()
            .setSchema(TABLE_SCHEMA)
            .setTimePartitioning(TimePartitioning.of(Type.DAY))
            .build();

    Table table = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertThat(table.getDefinition()).isInstanceOf(StandardTableDefinition.class);
    assertThat(
            ((StandardTableDefinition) table.getDefinition())
                .getTimePartitioning()
                .getExpirationMs())
        .isNull();

    table =
        table
            .toBuilder()
            .setDefinition(
                tableDefinition
                    .toBuilder()
                    .setTimePartitioning(TimePartitioning.of(Type.DAY, 42L))
                    .build())
            .build()
            .update(BigQuery.TableOption.fields(BigQuery.TableField.TIME_PARTITIONING));
    assertThat(
            ((StandardTableDefinition) table.getDefinition())
                .getTimePartitioning()
                .getExpirationMs())
        .isEqualTo(42L);

    table =
        table
            .toBuilder()
            .setDefinition(
                tableDefinition
                    .toBuilder()
                    .setTimePartitioning(TimePartitioning.of(Type.DAY))
                    .build())
            .build()
            .update(BigQuery.TableOption.fields(BigQuery.TableField.TIME_PARTITIONING));
    assertThat(
            ((StandardTableDefinition) table.getDefinition())
                .getTimePartitioning()
                .getExpirationMs())
        .isNull();

    table.delete();
  }

  @Test
  public void testUpdateTableWithSelectedFields() {
    String tableName = "test_update_with_selected_fields_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    Table updatedTable =
        bigquery.update(
            tableInfo.toBuilder().setDescription("newDescr").build(),
            TableOption.fields(TableField.DESCRIPTION));
    assertTrue(updatedTable.getDefinition() instanceof StandardTableDefinition);
    assertEquals(DATASET, updatedTable.getTableId().getDataset());
    assertEquals(tableName, updatedTable.getTableId().getTable());
    assertEquals("newDescr", updatedTable.getDescription());
    assertNull(updatedTable.getDefinition().getSchema());
    assertNull(updatedTable.getLastModifiedTime());
    assertNull(updatedTable.<StandardTableDefinition>getDefinition().getNumBytes());
    assertNull(updatedTable.<StandardTableDefinition>getDefinition().getNumLongTermBytes());
    assertNull(updatedTable.<StandardTableDefinition>getDefinition().getNumRows());
    assertTrue(createdTable.delete());
  }

  @Test
  public void testUpdateNonExistingTable() {
    TableInfo tableInfo =
        TableInfo.of(
            TableId.of(DATASET, "test_update_non_existing_table"),
            StandardTableDefinition.of(SIMPLE_SCHEMA));
    try {
      bigquery.update(tableInfo);
      fail("BigQueryException was expected");
    } catch (BigQueryException e) {
      BigQueryError error = e.getError();
      assertNotNull(error);
      assertEquals("notFound", error.getReason());
      assertNotNull(error.getMessage());
    }
  }

  @Test
  public void testDeleteNonExistingTable() {
    assertFalse(bigquery.delete("test_delete_non_existing_table"));
  }

  @Test
  public void testInsertAll() throws IOException {
    String tableName = "test_insert_all_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    ImmutableMap.Builder<String, Object> builder1 = ImmutableMap.builder();
    builder1.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder1.put("StringField", "stringValue");
    builder1.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder1.put("BooleanField", false);
    builder1.put("BytesField", BYTES_BASE64);
    builder1.put(
        "RecordField",
        ImmutableMap.of(
            "TimestampField",
            "1969-07-20 20:18:04 UTC",
            "IntegerArrayField",
            ImmutableList.of(1, 0),
            "BooleanField",
            true,
            "BytesField",
            BYTES_BASE64));
    builder1.put("IntegerField", 5);
    builder1.put("FloatField", 1.2);
    builder1.put("GeographyField", "POINT(-122.350220 47.649154)");
    builder1.put("NumericField", new BigDecimal("123456789.123456789"));
    ImmutableMap.Builder<String, Object> builder2 = ImmutableMap.builder();
    builder2.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder2.put("StringField", "stringValue");
    builder2.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder2.put("BooleanField", false);
    builder2.put("BytesField", BYTES_BASE64);
    builder2.put(
        "RecordField",
        ImmutableMap.of(
            "TimestampField",
            "1969-07-20 20:18:04 UTC",
            "IntegerArrayField",
            ImmutableList.of(1, 0),
            "BooleanField",
            true,
            "BytesField",
            BYTES_BASE64));
    builder2.put("IntegerField", 5);
    builder2.put("FloatField", 1.2);
    builder2.put("GeographyField", "POINT(-122.350220 47.649154)");
    builder2.put("NumericField", new BigDecimal("123456789.123456789"));
    InsertAllRequest request =
        InsertAllRequest.newBuilder(tableInfo.getTableId())
            .addRow(builder1.build())
            .addRow(builder2.build())
            .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.getInsertErrors().size());
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
  }

  @Test
  public void testInsertAllWithSuffix() throws InterruptedException {
    String tableName = "test_insert_all_with_suffix_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    ImmutableMap.Builder<String, Object> builder1 = ImmutableMap.builder();
    builder1.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder1.put("StringField", "stringValue");
    builder1.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder1.put("BooleanField", false);
    builder1.put("BytesField", BYTES_BASE64);
    builder1.put(
        "RecordField",
        ImmutableMap.of(
            "TimestampField",
            "1969-07-20 20:18:04 UTC",
            "IntegerArrayField",
            ImmutableList.of(1, 0),
            "BooleanField",
            true,
            "BytesField",
            BYTES_BASE64));
    builder1.put("IntegerField", 5);
    builder1.put("FloatField", 1.2);
    builder1.put("GeographyField", "POINT(-122.350220 47.649154)");
    builder1.put("NumericField", new BigDecimal("123456789.123456789"));
    ImmutableMap.Builder<String, Object> builder2 = ImmutableMap.builder();
    builder2.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder2.put("StringField", "stringValue");
    builder2.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder2.put("BooleanField", false);
    builder2.put("BytesField", BYTES_BASE64);
    builder2.put(
        "RecordField",
        ImmutableMap.of(
            "TimestampField",
            "1969-07-20 20:18:04 UTC",
            "IntegerArrayField",
            ImmutableList.of(1, 0),
            "BooleanField",
            true,
            "BytesField",
            BYTES_BASE64));
    builder2.put("IntegerField", 5);
    builder2.put("FloatField", 1.2);
    builder2.put("GeographyField", "POINT(-122.350220 47.649154)");
    builder2.put("NumericField", new BigDecimal("123456789.123456789"));
    InsertAllRequest request =
        InsertAllRequest.newBuilder(tableInfo.getTableId())
            .addRow(builder1.build())
            .addRow(builder2.build())
            .setTemplateSuffix("_suffix")
            .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.getInsertErrors().size());
    String newTableName = tableName + "_suffix";
    Table suffixTable = bigquery.getTable(DATASET, newTableName, TableOption.fields());
    // wait until the new table is created. If the table is never created the test will time-out
    while (suffixTable == null) {
      Thread.sleep(1000L);
      suffixTable = bigquery.getTable(DATASET, newTableName, TableOption.fields());
    }
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
    assertTrue(suffixTable.delete());
  }

  @Test
  public void testInsertAllWithErrors() {
    String tableName = "test_insert_all_with_errors_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    ImmutableMap.Builder<String, Object> builder1 = ImmutableMap.builder();
    builder1.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder1.put("StringField", "stringValue");
    builder1.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder1.put("BooleanField", false);
    builder1.put("BytesField", BYTES_BASE64);
    builder1.put(
        "RecordField",
        ImmutableMap.of(
            "TimestampField",
            "1969-07-20 20:18:04 UTC",
            "IntegerArrayField",
            ImmutableList.of(1, 0),
            "BooleanField",
            true,
            "BytesField",
            BYTES_BASE64));
    builder1.put("IntegerField", 5);
    builder1.put("FloatField", 1.2);
    builder1.put("GeographyField", "POINT(-122.350220 47.649154)");
    builder1.put("NumericField", new BigDecimal("123456789.123456789"));
    ImmutableMap.Builder<String, Object> builder2 = ImmutableMap.builder();
    builder2.put("TimestampField", "invalidDate");
    builder2.put("StringField", "stringValue");
    builder2.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder2.put("BooleanField", false);
    builder2.put("BytesField", BYTES_BASE64);
    builder2.put(
        "RecordField",
        ImmutableMap.of(
            "TimestampField",
            "1969-07-20 20:18:04 UTC",
            "IntegerArrayField",
            ImmutableList.of(1, 0),
            "BooleanField",
            true,
            "BytesField",
            BYTES_BASE64));
    builder2.put("IntegerField", 5);
    builder2.put("FloatField", 1.2);
    builder2.put("GeographyField", "POINT(-122.350220 47.649154)");
    builder2.put("NumericField", new BigDecimal("123456789.123456789"));
    ImmutableMap.Builder<String, Object> builder3 = ImmutableMap.builder();
    builder3.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder3.put("StringField", "stringValue");
    builder3.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder3.put("BooleanField", false);
    builder3.put("BytesField", BYTES_BASE64);
    InsertAllRequest request =
        InsertAllRequest.newBuilder(tableInfo.getTableId())
            .addRow(builder1.build())
            .addRow(builder2.build())
            .addRow(builder3.build())
            .setSkipInvalidRows(true)
            .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertTrue(response.hasErrors());
    assertEquals(2, response.getInsertErrors().size());
    assertNotNull(response.getErrorsFor(1L));
    assertNotNull(response.getErrorsFor(2L));
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
  }

  @Test
  public void testListAllTableData() {
    Page<FieldValueList> rows = bigquery.listTableData(TABLE_ID);
    int rowCount = 0;
    for (FieldValueList row : rows.getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerArrayCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      FieldValue bytesCell = row.get(4);
      FieldValue recordCell = row.get(5);
      FieldValue integerCell = row.get(6);
      FieldValue floatCell = row.get(7);
      FieldValue geographyCell = row.get(8);
      FieldValue numericCell = row.get(9);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.REPEATED, integerArrayCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, bytesCell.getAttribute());
      assertEquals(FieldValue.Attribute.RECORD, recordCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, integerCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, floatCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, geographyCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, numericCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(0, integerArrayCell.getRepeatedValue().get(0).getLongValue());
      assertEquals(1, integerArrayCell.getRepeatedValue().get(1).getLongValue());
      assertEquals(false, booleanCell.getBooleanValue());
      assertArrayEquals(BYTES, bytesCell.getBytesValue());
      assertEquals(-14182916000000L, recordCell.getRecordValue().get(0).getTimestampValue());
      assertTrue(recordCell.getRecordValue().get(1).isNull());
      assertEquals(1, recordCell.getRecordValue().get(2).getRepeatedValue().get(0).getLongValue());
      assertEquals(0, recordCell.getRecordValue().get(2).getRepeatedValue().get(1).getLongValue());
      assertEquals(true, recordCell.getRecordValue().get(3).getBooleanValue());
      assertEquals(3, integerCell.getLongValue());
      assertEquals(1.2, floatCell.getDoubleValue(), 0.0001);
      assertEquals("POINT(-122.35022 47.649154)", geographyCell.getStringValue());
      assertEquals(new BigDecimal("123456.789012345"), numericCell.getNumericValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
  }

  @Test
  public void testListPageWithStartIndex() {
    String tableName = "midyear_population_agespecific";
    TableId tableId = TableId.of(PUBLIC_PROJECT, PUBLIC_DATASET, tableName);
    Table table = bigquery.getTable(tableId);
    long numRows = table.getNumRows().longValue();
    Page<FieldValueList> tableResult =
        bigquery.listTableData(
            tableId,
            BigQuery.TableDataListOption.startIndex(numRows - 300_000L),
            BigQuery.TableDataListOption.pageSize(600_000L));
    assertNotNull(tableResult.getNextPageToken());
    long totalRows = ((Collection<?>) tableResult.getValues()).size();
    tableResult = tableResult.getNextPage();
    totalRows = totalRows + ((Collection<?>) tableResult.getValues()).size();
    assertNull(tableResult.getNextPageToken());
    assertEquals(300_000L, totalRows);
  }

  @Test
  public void testModelLifecycle() throws InterruptedException {

    String modelName = RemoteBigQueryHelper.generateModelName();

    // Create a model using SQL.
    String sql =
        "CREATE MODEL `"
            + MODEL_DATASET
            + "."
            + modelName
            + "`"
            + "OPTIONS ( "
            + "model_type='linear_reg', "
            + "max_iteration=1, "
            + "learn_rate=0.4, "
            + "learn_rate_strategy='constant' "
            + ") AS ( "
            + "	SELECT 'a' AS f1, 2.0 AS label "
            + "UNION ALL "
            + "SELECT 'b' AS f1, 3.8 AS label "
            + ")";

    QueryJobConfiguration config = QueryJobConfiguration.newBuilder(sql).build();
    Job job = bigquery.create(JobInfo.of(JobId.of(), config));
    job.waitFor();
    assertNull(job.getStatus().getError());

    // Model is created.  Fetch.
    ModelId modelId = ModelId.of(MODEL_DATASET, modelName);
    Model model = bigquery.getModel(modelId);
    assertNotNull(model);
    assertEquals(model.getModelType(), "LINEAR_REGRESSION");
    // Compare the extended model metadata.
    assertEquals(model.getFeatureColumns().get(0).getName(), "f1");
    assertEquals(model.getLabelColumns().get(0).getName(), "predicted_label");
    assertEquals(
        model.getTrainingRuns().get(0).getTrainingOptions().getLearnRateStrategy(), "CONSTANT");

    // Mutate metadata.
    ModelInfo info = model.toBuilder().setDescription("TEST").build();
    Model afterUpdate = bigquery.update(info);
    assertEquals(afterUpdate.getDescription(), "TEST");

    // Ensure model is present in listModels.
    Page<Model> models = bigquery.listModels(MODEL_DATASET);
    Boolean found = false;
    for (Model m : models.getValues()) {
      if (m.getModelId().getModel().equals(modelName)) {
        found = true;
        break;
      }
    }
    assertTrue(found);

    // Delete the model.
    assertTrue(bigquery.delete(modelId));
  }

  @Test
  public void testEmptyListModels() {
    String datasetId = "test_empty_dataset_list_models_" + RANDOM_ID;
    assertNotNull(bigquery.create(DatasetInfo.of(datasetId)));
    Page<Model> models = bigquery.listModels(datasetId, BigQuery.ModelListOption.pageSize(100));
    assertEquals(0, Iterables.size(models.getValues()));
    assertFalse(models.hasNextPage());
    assertNull(models.getNextPageToken());
    assertTrue(bigquery.delete(datasetId));
  }

  @Test
  public void testEmptyListRoutines() {
    String datasetId = "test_empty_dataset_list_routines_" + RANDOM_ID;
    assertNotNull(bigquery.create(DatasetInfo.of(datasetId)));
    Page<Routine> routines =
        bigquery.listRoutines(datasetId, BigQuery.RoutineListOption.pageSize(100));
    assertEquals(0, Iterables.size(routines.getValues()));
    assertFalse(routines.hasNextPage());
    assertNull(routines.getNextPageToken());
    assertTrue(bigquery.delete(datasetId));
  }

  @Test
  public void testRoutineLifecycle() throws InterruptedException {

    String routineName = RemoteBigQueryHelper.generateRoutineName();
    // Create a routine using SQL.
    String sql =
        "CREATE FUNCTION `" + ROUTINE_DATASET + "." + routineName + "`" + "(x INT64) AS (x * 3)";
    QueryJobConfiguration config = QueryJobConfiguration.newBuilder(sql).build();
    Job job = bigquery.create(JobInfo.of(JobId.of(), config));
    job.waitFor();
    assertNull(job.getStatus().getError());

    // Routine is created.  Fetch.
    RoutineId routineId = RoutineId.of(ROUTINE_DATASET, routineName);
    Routine routine = bigquery.getRoutine(routineId);
    assertNotNull(routine);
    assertEquals(routine.getRoutineType(), "SCALAR_FUNCTION");

    // Mutate metadata.
    RoutineInfo newInfo =
        routine
            .toBuilder()
            .setBody("x * 4")
            .setReturnType(routine.getReturnType())
            .setArguments(routine.getArguments())
            .setRoutineType(routine.getRoutineType())
            .build();
    Routine afterUpdate = bigquery.update(newInfo);
    assertEquals(afterUpdate.getBody(), "x * 4");

    // Ensure routine is present in listRoutines.
    Page<Routine> routines = bigquery.listRoutines(ROUTINE_DATASET);
    Boolean found = false;
    for (Routine r : routines.getValues()) {
      if (r.getRoutineId().getRoutine().equals(routineName)) {
        found = true;
        break;
      }
    }
    assertTrue(found);

    // Delete the routine.
    assertTrue(bigquery.delete(routineId));
  }

  @Test
  public void testRoutineAPICreation() {
    String routineName = RemoteBigQueryHelper.generateRoutineName();
    RoutineId routineId = RoutineId.of(ROUTINE_DATASET, routineName);
    RoutineInfo routineInfo =
        RoutineInfo.newBuilder(routineId)
            .setRoutineType("SCALAR_FUNCTION")
            .setBody("x * 3")
            .setLanguage("SQL")
            .setArguments(
                ImmutableList.of(
                    RoutineArgument.newBuilder()
                        .setName("x")
                        .setDataType(StandardSQLDataType.newBuilder("INT64").build())
                        .build()))
            .build();

    Routine routine = bigquery.create(routineInfo);
    assertNotNull(routine);
    assertEquals(routine.getRoutineType(), "SCALAR_FUNCTION");
  }

  @Test
  public void testAuthorizeRoutine() {
    String routineName = RemoteBigQueryHelper.generateRoutineName();
    RoutineId routineId = RoutineId.of(PROJECT_ID, ROUTINE_DATASET, routineName);
    RoutineInfo routineInfo =
        RoutineInfo.newBuilder(routineId)
            .setRoutineType("SCALAR_FUNCTION")
            .setBody("x * 3")
            .setLanguage("SQL")
            .setArguments(
                ImmutableList.of(
                    RoutineArgument.newBuilder()
                        .setName("x")
                        .setDataType(StandardSQLDataType.newBuilder("INT64").build())
                        .build()))
            .build();
    Routine routine = bigquery.create(routineInfo);
    assertNotNull(routine);
    assertEquals(routine.getRoutineType(), "SCALAR_FUNCTION");
    Dataset routineDataset = bigquery.getDataset(ROUTINE_DATASET);
    List<Acl> routineAcl = new ArrayList<>(routineDataset.getAcl());
    routineAcl.add(Acl.of(new Acl.Routine(routineId)));
    routineDataset = routineDataset.toBuilder().setAcl(routineAcl).build().update();
    assertEquals(routineAcl, routineDataset.getAcl());
  }

  @Test
  public void testSingleStatementsQueryException() throws InterruptedException {
    String invalidQuery =
        String.format("INSERT %s.%s VALUES('3', 10);", DATASET, TABLE_ID.getTable());
    try {
      bigquery.create(JobInfo.of(QueryJobConfiguration.of(invalidQuery))).waitFor();
      fail("BigQueryException was expected");
    } catch (BigQueryException ex) {
      assertEquals("invalidQuery", ex.getReason());
      assertNotNull(ex.getMessage());
      BigQueryError error = ex.getError();
      assertEquals("invalidQuery", error.getReason());
      assertNotNull(error.getMessage());
    }
  }

  @Test
  public void testMultipleStatementsQueryException() throws InterruptedException {
    String invalidQuery =
        String.format(
            "INSERT %s.%s VALUES('3', 10); DELETE %s.%s where c2=3;",
            DATASET, TABLE_ID.getTable(), DATASET, TABLE_ID.getTable());
    try {
      bigquery.create(JobInfo.of(QueryJobConfiguration.of(invalidQuery))).waitFor();
      fail("BigQueryException was expected");
    } catch (BigQueryException ex) {
      assertEquals("invalidQuery", ex.getReason());
      assertNotNull(ex.getMessage());
      BigQueryError error = ex.getError();
      assertEquals("invalidQuery", error.getReason());
      assertNotNull(error.getMessage());
    }
  }

  @Test
  public void testQuery() throws InterruptedException {
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query).setDefaultDataset(DatasetId.of(DATASET)).build();
    Job job = bigquery.create(JobInfo.of(JobId.of(), config));

    TableResult result = job.getQueryResults();
    assertEquals(QUERY_RESULT_SCHEMA, result.getSchema());
    int rowCount = 0;
    for (FieldValueList row : result.getValues()) {
      FieldValue timestampCell = row.get(0);
      assertEquals(timestampCell, row.get("TimestampField"));
      FieldValue stringCell = row.get(1);
      assertEquals(stringCell, row.get("StringField"));
      FieldValue booleanCell = row.get(2);
      assertEquals(booleanCell, row.get("BooleanField"));
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);

    Job job2 = bigquery.getJob(job.getJobId());
    JobStatistics.QueryStatistics statistics = job2.getStatistics();
    assertNotNull(statistics.getQueryPlan());
  }

  @Test
  public void testQueryCaseInsensitiveSchemaFieldByGetName() throws InterruptedException {
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query).setDefaultDataset(DatasetId.of(DATASET)).build();
    Job job = bigquery.create(JobInfo.of(JobId.of(), config));

    TableResult result = job.getQueryResults();
    assertEquals(QUERY_RESULT_SCHEMA, result.getSchema());
    int rowCount = 0;
    for (FieldValueList row : result.getValues()) {
      FieldValue timestampCell = row.get(0);
      assertEquals(timestampCell, row.get("TimestampField"));
      assertEquals(timestampCell, row.get("timestampfield"));
      assertEquals(timestampCell, row.get("timeStampfIeld"));
      FieldValue stringCell = row.get(1);
      assertEquals(stringCell, row.get("StringField"));
      assertEquals(stringCell, row.get("stringfield"));
      assertEquals(stringCell, row.get("sTrinGfield"));
      FieldValue booleanCell = row.get(2);
      assertEquals(booleanCell, row.get("BooleanField"));
      assertEquals(booleanCell, row.get("booleanfield"));
      assertEquals(booleanCell, row.get("booLeanfielD"));
      rowCount++;
    }
    assertEquals(2, rowCount);
  }

  @Test
  public void testFastQueryMultipleRuns() throws InterruptedException {
    String query =
        "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID_FASTQUERY.getTable();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query).setDefaultDataset(DatasetId.of(DATASET)).build();
    TableResult result = bigquery.query(config);
    assertEquals(QUERY_RESULT_SCHEMA, result.getSchema());
    assertEquals(2, result.getTotalRows());
    assertNull(result.getNextPage());
    assertNull(result.getNextPageToken());
    assertFalse(result.hasNextPage());

    QueryJobConfiguration config2 =
        QueryJobConfiguration.newBuilder(query).setDefaultDataset(DatasetId.of(DATASET)).build();
    TableResult result2 = bigquery.query(config2);
    assertEquals(QUERY_RESULT_SCHEMA, result2.getSchema());
    assertEquals(2, result2.getTotalRows());
    assertNull(result2.getNextPage());
    assertNull(result2.getNextPageToken());
    assertFalse(result2.hasNextPage());
  }

  @Test
  public void testFastQuerySinglePageDuplicateRequestIds() throws InterruptedException {
    String query =
        "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID_FASTQUERY.getTable();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query).setDefaultDataset(DatasetId.of(DATASET)).build();
    TableResult result = bigquery.query(config);
    assertEquals(QUERY_RESULT_SCHEMA, result.getSchema());
    assertEquals(2, result.getTotalRows());
    assertNull(result.getNextPage());
    assertNull(result.getNextPageToken());
    assertFalse(result.hasNextPage());

    TableResult result1 = bigquery.query(config);
    assertEquals(QUERY_RESULT_SCHEMA, result1.getSchema());
    assertEquals(2, result1.getTotalRows());
    assertNull(result1.getNextPage());
    assertNull(result1.getNextPageToken());
    assertFalse(result1.hasNextPage());

    config.toBuilder().setQuery(query).build();
    TableResult result2 = bigquery.query(config);
    assertEquals(QUERY_RESULT_SCHEMA, result2.getSchema());
    assertEquals(2, result2.getTotalRows());
    assertNull(result2.getNextPage());
    assertNull(result2.getNextPageToken());
    assertFalse(result2.hasNextPage());
  }

  @Test
  public void testFastSQLQuery() throws InterruptedException {
    String query =
        "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID_FASTQUERY.getTable();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query).setDefaultDataset(DatasetId.of(DATASET)).build();
    TableResult result = bigquery.query(config);
    assertEquals(QUERY_RESULT_SCHEMA, result.getSchema());
    assertEquals(2, result.getTotalRows());
    assertNull(result.getNextPage());
    assertNull(result.getNextPageToken());
    assertFalse(result.hasNextPage());
    // Verify correctness of table content
    for (FieldValueList row : result.getValues()) {
      FieldValue timestampCell = row.get(0);
      assertEquals(timestampCell, row.get("TimestampField"));
      FieldValue stringCell = row.get(1);
      assertEquals(stringCell, row.get("StringField"));
      FieldValue booleanCell = row.get(2);
      assertEquals(booleanCell, row.get("BooleanField"));
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
    }
  }

  @Test
  public void testFastSQLQueryMultiPage() throws InterruptedException {
    String query =
        "SELECT date, county, state_name, county_fips_code, confirmed_cases, deaths FROM "
            + TABLE_ID_LARGE.getTable();
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query).setDefaultDataset(DatasetId.of(DATASET)).build();
    TableResult result = bigquery.query(config);
    assertEquals(LARGE_TABLE_SCHEMA, result.getSchema());
    assertEquals(313348, result.getTotalRows());
    assertNotNull(result.getNextPage());
    assertNotNull(result.getNextPageToken());
    assertTrue(result.hasNextPage());

    TableResult result1 = bigquery.query(config);
    assertEquals(LARGE_TABLE_SCHEMA, result.getSchema());
    assertEquals(313348, result.getTotalRows());
    assertNotNull(result1.getNextPage());
    assertNotNull(result1.getNextPageToken());
    assertTrue(result1.hasNextPage());

    config.toBuilder().setQuery(query).build();
    TableResult result2 = bigquery.query(config);
    assertEquals(LARGE_TABLE_SCHEMA, result2.getSchema());
    assertEquals(313348, result2.getTotalRows());
    assertNotNull(result2.getNextPage());
    assertNotNull(result2.getNextPageToken());
    assertTrue(result2.hasNextPage());
  }

  @Test
  public void testFastDMLQuery() throws InterruptedException {
    String tableName = TABLE_ID_FASTQUERY.getTable();
    String dmlQuery =
        String.format("UPDATE %s.%s SET StringField = 'hello' WHERE TRUE", DATASET, tableName);
    QueryJobConfiguration dmlConfig = QueryJobConfiguration.newBuilder(dmlQuery).build();
    TableResult result = bigquery.query(dmlConfig);
    assertEquals(TABLE_SCHEMA, result.getSchema());
    assertEquals(2, result.getTotalRows());
    // Verify correctness of table content
    String sqlQuery = String.format("SELECT * FROM %s.%s", DATASET, tableName);
    QueryJobConfiguration sqlConfig = QueryJobConfiguration.newBuilder(sqlQuery).build();
    TableResult resultAfterDML = bigquery.query(sqlConfig);
    for (FieldValueList row : resultAfterDML.getValues()) {
      FieldValue timestampCell = row.get(0);
      assertEquals(timestampCell, row.get("TimestampField"));
      FieldValue stringCell = row.get(1);
      assertEquals(stringCell, row.get("StringField"));
      FieldValue booleanCell = row.get(3);
      assertEquals(booleanCell, row.get("BooleanField"));
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("hello", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
    }
  }

  @Test
  public void testFastDDLQuery() throws InterruptedException {
    String tableName = "test_table_fast_query_ddl";
    String tableNameFastQuery = TABLE_ID_DDL.getTable();
    String ddlQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s ("
                + "TimestampField TIMESTAMP OPTIONS(description='TimestampDescription'), "
                + "StringField STRING OPTIONS(description='StringDescription'), "
                + "BooleanField BOOLEAN OPTIONS(description='BooleanDescription') "
                + ") AS SELECT * FROM %s",
            tableName, tableNameFastQuery);
    QueryJobConfiguration ddlConfig =
        QueryJobConfiguration.newBuilder(ddlQuery).setDefaultDataset(DatasetId.of(DATASET)).build();
    TableResult result = bigquery.query(ddlConfig);
    assertEquals(DDL_TABLE_SCHEMA, result.getSchema());
    assertEquals(0, result.getTotalRows());
    // Verify correctness of table content
    String sqlQuery = String.format("SELECT * FROM %s.%s", DATASET, tableName);
    QueryJobConfiguration sqlConfig = QueryJobConfiguration.newBuilder(sqlQuery).build();
    TableResult resultAfterDDL = bigquery.query(sqlConfig);
    for (FieldValueList row : resultAfterDDL.getValues()) {
      FieldValue timestampCell = row.get(0);
      assertEquals(timestampCell, row.get("TimestampField"));
      FieldValue stringCell = row.get(1);
      assertEquals(stringCell, row.get("StringField"));
      FieldValue booleanCell = row.get(2);
      assertEquals(booleanCell, row.get("BooleanField"));
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
    }
  }

  @Test
  public void testFastQuerySlowDDL() throws InterruptedException {
    String tableName =
        "test_table_fast_query_ddl_slow_" + UUID.randomUUID().toString().substring(0, 8);
    // This query take more than 10s to run and should fall back on the old query path
    String slowDdlQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s AS SELECT unique_key, agency, complaint_type, descriptor, street_name, city, landmark FROM `bigquery-public-data.new_york.311_service_requests`",
            tableName);
    QueryJobConfiguration ddlConfig =
        QueryJobConfiguration.newBuilder(slowDdlQuery)
            .setDefaultDataset(DatasetId.of(DATASET))
            .build();
    TableResult result = bigquery.query(ddlConfig);
    assertEquals(0, result.getTotalRows());
    assertNotNull(result.getSchema());
    // Verify correctness of table content
    String sqlQuery = String.format("SELECT * FROM %s.%s", DATASET, tableName);
    QueryJobConfiguration sqlConfig = QueryJobConfiguration.newBuilder(sqlQuery).build();
    TableResult resultAfterDDL = bigquery.query(sqlConfig);
    for (FieldValueList row : resultAfterDDL.getValues()) {
      FieldValue unique_key = row.get(0);
      assertEquals(unique_key, row.get("unique_key"));
      FieldValue agency = row.get(1);
      assertEquals(agency, row.get("agency"));
      FieldValue complaint_type = row.get(2);
      assertEquals(complaint_type, row.get("complaint_type"));
    }
  }

  @Test
  public void testFastQueryHTTPException() throws InterruptedException {
    String queryInvalid =
        "CREATE OR REPLACE SELECT * FROM UPDATE TABLE SET " + TABLE_ID_FASTQUERY.getTable();
    QueryJobConfiguration configInvalidQuery =
        QueryJobConfiguration.newBuilder(queryInvalid)
            .setDefaultDataset(DatasetId.of(DATASET))
            .build();
    try {
      bigquery.query(configInvalidQuery);
      fail("\"BigQueryException was expected\"");
    } catch (BigQueryException e) {
      BigQueryError error = e.getError();
      assertNotNull(error.getMessage());
      assertEquals("invalidQuery", error.getReason());
    }

    String queryMissingTable =
        "SELECT * FROM " + TableId.of(DATASET, "non_existing_table").getTable();
    QueryJobConfiguration configMissingTable =
        QueryJobConfiguration.newBuilder(queryMissingTable)
            .setDefaultDataset(DatasetId.of(DATASET))
            .build();
    try {
      bigquery.query(configMissingTable);
      fail("\"BigQueryException was expected\"");
    } catch (BigQueryException e) {
      BigQueryError error = e.getError();
      assertNotNull(error.getMessage());
      assertEquals("notFound", error.getReason());
    }
  }

  @Test
  public void testScriptStatistics() throws InterruptedException {
    String script =
        "-- Declare a variable to hold names as an array.\n"
            + "DECLARE top_names ARRAY<STRING>;\n"
            + "-- Build an array of the top 100 names from the year 2017.\n"
            + "SET top_names = (\n"
            + "  SELECT ARRAY_AGG(name ORDER BY number DESC LIMIT 100)\n"
            + "  FROM `bigquery-public-data`.usa_names.usa_1910_current\n"
            + "  WHERE year = 2017\n"
            + ");\n"
            + "-- Which names appear as words in Shakespeare's plays?\n"
            + "SELECT\n"
            + "  name AS shakespeare_name\n"
            + "FROM UNNEST(top_names) AS name\n"
            + "WHERE name IN (\n"
            + "  SELECT word\n"
            + "  FROM `bigquery-public-data`.samples.shakespeare\n"
            + ");";
    QueryJobConfiguration config = QueryJobConfiguration.of(script);
    Job remoteJob = bigquery.create(JobInfo.of(config));
    JobInfo info = remoteJob.waitFor();
    JobStatistics jobStatistics = info.getStatistics();
    String parentJobId = info.getJobId().getJob();
    assertEquals(2, jobStatistics.getNumChildJobs().longValue());
    Page<Job> page = bigquery.listJobs(JobListOption.parentJobId(parentJobId));
    for (Job job : page.iterateAll()) {
      JobStatistics.ScriptStatistics scriptStatistics = job.getStatistics().getScriptStatistics();
      if (scriptStatistics != null) {
        if (scriptStatistics.getEvaluationKind().equals("STATEMENT")) {
          assertEquals("STATEMENT", scriptStatistics.getEvaluationKind());
          for (JobStatistics.ScriptStatistics.ScriptStackFrame stackFrame :
              scriptStatistics.getStackFrames()) {
            assertEquals(2, stackFrame.getEndColumn().intValue());
            assertEquals(16, stackFrame.getEndLine().intValue());
            assertEquals(1, stackFrame.getStartColumn().intValue());
            assertEquals(10, stackFrame.getStartLine().intValue());
          }

        } else {
          assertEquals("EXPRESSION", scriptStatistics.getEvaluationKind());
          for (JobStatistics.ScriptStatistics.ScriptStackFrame stackFrame :
              scriptStatistics.getStackFrames()) {
            assertEquals(2, stackFrame.getEndColumn().intValue());
            assertEquals(8, stackFrame.getEndLine().intValue());
            assertEquals(17, stackFrame.getStartColumn().intValue());
            assertEquals(4, stackFrame.getStartLine().intValue());
          }
        }
      }
    }
  }

  @Test
  public void testPositionalQueryParameters() throws InterruptedException {
    String query =
        "SELECT TimestampField, StringField, BooleanField, BigNumericField, BigNumericField1, BigNumericField2, BigNumericField3, BigNumericField4 FROM "
            + TABLE_ID.getTable()
            + " WHERE StringField = ?"
            + " AND TimestampField > ?"
            + " AND IntegerField IN UNNEST(?)"
            + " AND IntegerField < ?"
            + " AND FloatField > ?"
            + " AND NumericField < ?"
            + " AND BigNumericField = ?";
    QueryParameterValue stringParameter = QueryParameterValue.string("stringValue");
    QueryParameterValue timestampParameter =
        QueryParameterValue.timestamp("2014-01-01 07:00:00.000000+00:00");
    QueryParameterValue intArrayParameter =
        QueryParameterValue.array(new Integer[] {3, 4}, Integer.class);
    QueryParameterValue int64Parameter = QueryParameterValue.int64(5);
    QueryParameterValue float64Parameter = QueryParameterValue.float64(0.5);
    QueryParameterValue numericParameter =
        QueryParameterValue.numeric(new BigDecimal("234567890.123456"));
    QueryParameterValue bigNumericParameter =
        QueryParameterValue.bigNumeric(new BigDecimal("0.33333333333333333333333333333333333333"));
    QueryParameterValue bigNumericParameter1 =
        QueryParameterValue.bigNumeric(new BigDecimal("1e-38"));
    QueryParameterValue bigNumericParameter2 =
        QueryParameterValue.bigNumeric(new BigDecimal("-1e38"));
    QueryParameterValue bigNumericParameter3 =
        QueryParameterValue.bigNumeric(
            new BigDecimal(
                "578960446186580977117854925043439539266.34992332820282019728792003956564819967"));
    QueryParameterValue bigNumericParameter4 =
        QueryParameterValue.bigNumeric(
            new BigDecimal(
                "-578960446186580977117854925043439539266.34992332820282019728792003956564819968"));
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setUseLegacySql(false)
            .addPositionalParameter(stringParameter)
            .addPositionalParameter(timestampParameter)
            .addPositionalParameter(intArrayParameter)
            .addPositionalParameter(int64Parameter)
            .addPositionalParameter(float64Parameter)
            .addPositionalParameter(numericParameter)
            .addPositionalParameter(bigNumericParameter)
            .addPositionalParameter(bigNumericParameter1)
            .addPositionalParameter(bigNumericParameter2)
            .addPositionalParameter(bigNumericParameter3)
            .addPositionalParameter(bigNumericParameter4)
            .build();
    TableResult result = bigquery.query(config);
    assertEquals(QUERY_RESULT_SCHEMA_BIGNUMERIC, result.getSchema());
    assertEquals(2, Iterables.size(result.getValues()));
    for (FieldValueList values : result.iterateAll()) {
      assertEquals("1.40845209522E9", values.get(0).getValue());
      assertEquals("stringValue", values.get(1).getValue());
      assertEquals(false, values.get(2).getBooleanValue());
      assertEquals("0.33333333333333333333333333333333333333", values.get(3).getValue());
      assertEquals("0.00000000000000000000000000000000000001", values.get(4).getValue());
      assertEquals("-100000000000000000000000000000000000000", values.get(5).getValue());
      assertEquals(
          "578960446186580977117854925043439539266.34992332820282019728792003956564819967",
          values.get(6).getValue());
      assertEquals(
          "-578960446186580977117854925043439539266.34992332820282019728792003956564819968",
          values.get(7).getValue());
    }
  }

  @Test
  public void testNamedQueryParameters() throws InterruptedException {
    String query =
        "SELECT TimestampField, StringField, BooleanField FROM "
            + TABLE_ID.getTable()
            + " WHERE StringField = @stringParam"
            + " AND IntegerField IN UNNEST(@integerList)";
    QueryParameterValue stringParameter = QueryParameterValue.string("stringValue");
    QueryParameterValue intArrayParameter =
        QueryParameterValue.array(new Integer[] {3, 4}, Integer.class);
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setUseLegacySql(false)
            .addNamedParameter("stringParam", stringParameter)
            .addNamedParameter("integerList", intArrayParameter)
            .build();
    TableResult result = bigquery.query(config);
    assertEquals(QUERY_RESULT_SCHEMA, result.getSchema());
    assertEquals(2, Iterables.size(result.getValues()));
  }

  @Test
  public void testStructNamedQueryParameters() throws InterruptedException {
    QueryParameterValue booleanValue = QueryParameterValue.bool(true);
    QueryParameterValue stringValue = QueryParameterValue.string("test-stringField");
    QueryParameterValue integerValue = QueryParameterValue.int64(10);
    Map<String, QueryParameterValue> struct = new HashMap<>();
    struct.put("booleanField", booleanValue);
    struct.put("integerField", integerValue);
    struct.put("stringField", stringValue);
    QueryParameterValue recordValue = QueryParameterValue.struct(struct);
    String query = "SELECT STRUCT(@recordField) AS record";
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DATASET)
            .setUseLegacySql(false)
            .addNamedParameter("recordField", recordValue)
            .build();
    TableResult result = bigquery.query(config);
    assertEquals(1, Iterables.size(result.getValues()));
    for (FieldValueList values : result.iterateAll()) {
      for (FieldValue value : values) {
        for (FieldValue record : value.getRecordValue()) {
          assertsFieldValue(record);
        }
      }
    }
  }

  @Test
  public void testStructQuery() throws InterruptedException {
    // query into a table
    String query = String.format("SELECT RecordField FROM %s.%s", DATASET, TABLE_ID.getTable());
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DATASET)
            .setUseLegacySql(false)
            .build();
    TableResult result = bigquery.query(config);
    assertEquals(2, Iterables.size(result.getValues()));
    for (FieldValueList values : result.iterateAll()) {
      for (FieldValue value : values) {
        assertEquals(null, value.getRecordValue().get("StringField").getValue());
        assertEquals(true, value.getRecordValue().get("BooleanField").getBooleanValue());
      }
    }
  }

  private static void assertsFieldValue(FieldValue record) {
    assertEquals(FieldValue.Attribute.RECORD, record.getAttribute());
    assertEquals(true, record.getRecordValue().get("booleanField").getBooleanValue());
    assertEquals(10, record.getRecordValue().get("integerField").getLongValue());
    assertEquals("test-stringField", record.getRecordValue().get("stringField").getStringValue());
  }

  @Test
  public void testNestedStructNamedQueryParameters() throws InterruptedException {
    QueryParameterValue booleanValue = QueryParameterValue.bool(true);
    QueryParameterValue stringValue = QueryParameterValue.string("test-stringField");
    QueryParameterValue integerValue = QueryParameterValue.int64(10);
    Map<String, QueryParameterValue> struct = new HashMap<>();
    struct.put("booleanField", booleanValue);
    struct.put("integerField", integerValue);
    struct.put("stringField", stringValue);
    QueryParameterValue recordValue = QueryParameterValue.struct(struct);
    Map<String, QueryParameterValue> structValue = new HashMap<>();
    structValue.put("bool", booleanValue);
    structValue.put("int", integerValue);
    structValue.put("string", stringValue);
    structValue.put("struct", recordValue);
    QueryParameterValue nestedRecordField = QueryParameterValue.struct(structValue);
    String query = "SELECT STRUCT(@nestedRecordField) AS record";
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DATASET)
            .setUseLegacySql(false)
            .addNamedParameter("nestedRecordField", nestedRecordField)
            .build();
    TableResult result = bigquery.query(config);
    assertEquals(1, Iterables.size(result.getValues()));
    for (FieldValueList values : result.iterateAll()) {
      for (FieldValue value : values) {
        assertEquals(FieldValue.Attribute.RECORD, value.getAttribute());
        for (FieldValue record : value.getRecordValue()) {
          assertEquals(
              true, record.getRecordValue().get(0).getRecordValue().get(0).getBooleanValue());
          assertEquals(10, record.getRecordValue().get(0).getRecordValue().get(1).getLongValue());
          assertEquals(
              "test-stringField",
              record.getRecordValue().get(0).getRecordValue().get(2).getStringValue());
          assertEquals(true, record.getRecordValue().get(1).getBooleanValue());
          assertEquals("test-stringField", record.getRecordValue().get(2).getStringValue());
          assertEquals(10, record.getRecordValue().get(3).getLongValue());
        }
      }
    }
  }

  @Test
  public void testBytesParameter() throws Exception {
    String query = "SELECT BYTE_LENGTH(@p) AS length";
    QueryParameterValue bytesParameter = QueryParameterValue.bytes(new byte[] {1, 3});
    QueryJobConfiguration config =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setUseLegacySql(false)
            .addNamedParameter("p", bytesParameter)
            .build();
    TableResult result = bigquery.query(config);
    int rowCount = 0;
    for (FieldValueList row : result.getValues()) {
      rowCount++;
      assertEquals(2, row.get(0).getLongValue());
      assertEquals(2, row.get("length").getLongValue());
    }
    assertEquals(1, rowCount);
  }

  @Test
  public void testListJobs() {
    Page<Job> jobs = bigquery.listJobs();
    for (Job job : jobs.getValues()) {
      assertNotNull(job.getJobId());
      assertNotNull(job.getStatistics());
      assertNotNull(job.getStatus());
      assertNotNull(job.getUserEmail());
      assertNotNull(job.getGeneratedId());
    }
  }

  @Test
  public void testListJobsWithSelectedFields() {
    Page<Job> jobs = bigquery.listJobs(JobListOption.fields(JobField.USER_EMAIL));
    for (Job job : jobs.getValues()) {
      assertNotNull(job.getJobId());
      assertNotNull(job.getStatus());
      assertNotNull(job.getUserEmail());
      assertNull(job.getStatistics());
      assertNull(job.getGeneratedId());
    }
  }

  @Test
  public void testListJobsWithCreationBounding() {
    long currentMillis = currentTimeMillis();
    long lowerBound = currentMillis - 3600 * 1000;
    long upperBound = currentMillis;
    Page<Job> jobs =
        bigquery.listJobs(
            JobListOption.minCreationTime(lowerBound), JobListOption.maxCreationTime(upperBound));
    long foundMin = upperBound;
    long foundMax = lowerBound;
    long jobCount = 0;
    for (Job job : jobs.getValues()) {
      jobCount++;
      foundMin = Math.min(job.getStatistics().getCreationTime(), foundMin);
      foundMax = Math.max(job.getStatistics().getCreationTime(), foundMax);
    }
    assertTrue(
        "Found min job time " + foundMin + " earlier than " + lowerBound, foundMin >= lowerBound);
    assertTrue(
        "Found max job time " + foundMax + " later than " + upperBound, foundMax <= upperBound);
    assertTrue("no jobs listed", jobCount > 0);
  }

  @Test
  public void testCreateAndGetJob() throws InterruptedException, TimeoutException {
    String sourceTableName = "test_create_and_get_job_source_table";
    String destinationTableName = "test_create_and_get_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(sourceTableName, createdTable.getTableId().getTable());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration copyJobConfiguration =
        CopyJobConfiguration.of(destinationTable, sourceTable);
    Job createdJob = bigquery.create(JobInfo.of(copyJobConfiguration));
    Job remoteJob = bigquery.getJob(createdJob.getJobId());
    assertEquals(createdJob.getJobId(), remoteJob.getJobId());
    CopyJobConfiguration createdConfiguration = createdJob.getConfiguration();
    CopyJobConfiguration remoteConfiguration = remoteJob.getConfiguration();
    assertEquals(createdConfiguration.getSourceTables(), remoteConfiguration.getSourceTables());
    assertEquals(
        createdConfiguration.getDestinationTable(), remoteConfiguration.getDestinationTable());
    assertEquals(
        createdConfiguration.getCreateDisposition(), remoteConfiguration.getCreateDisposition());
    assertEquals(
        createdConfiguration.getWriteDisposition(), remoteConfiguration.getWriteDisposition());
    assertNotNull(remoteJob.getEtag());
    assertNotNull(remoteJob.getStatistics());
    assertNotNull(remoteJob.getStatus());
    assertEquals(createdJob.getSelfLink(), remoteJob.getSelfLink());
    assertEquals(createdJob.getUserEmail(), remoteJob.getUserEmail());
    assertTrue(createdTable.delete());

    Job completedJob = remoteJob.waitFor(RetryOption.totalTimeout(Duration.ofMinutes(1)));

    assertNotNull(completedJob);
    assertNull(completedJob.getStatus().getError());
    assertTrue(bigquery.delete(destinationTable));
  }

  @Test
  public void testCreateAndGetJobWithSelectedFields()
      throws InterruptedException, TimeoutException {
    String sourceTableName = "test_create_and_get_job_with_selected_fields_source_table";
    String destinationTableName = "test_create_and_get_job_with_selected_fields_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(sourceTableName, createdTable.getTableId().getTable());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, sourceTable);
    Job createdJob = bigquery.create(JobInfo.of(configuration), JobOption.fields(JobField.ETAG));
    CopyJobConfiguration createdConfiguration = createdJob.getConfiguration();
    assertNotNull(createdJob.getJobId());
    assertNotNull(createdConfiguration.getSourceTables());
    assertNotNull(createdConfiguration.getDestinationTable());
    assertNotNull(createdJob.getEtag());
    assertNull(createdJob.getStatistics());
    assertNull(createdJob.getStatus());
    assertNull(createdJob.getSelfLink());
    assertNull(createdJob.getUserEmail());
    Job remoteJob = bigquery.getJob(createdJob.getJobId(), JobOption.fields(JobField.ETAG));
    CopyJobConfiguration remoteConfiguration = remoteJob.getConfiguration();
    assertEquals(createdJob.getJobId(), remoteJob.getJobId());
    assertEquals(createdConfiguration.getSourceTables(), remoteConfiguration.getSourceTables());
    assertEquals(
        createdConfiguration.getDestinationTable(), remoteConfiguration.getDestinationTable());
    assertEquals(
        createdConfiguration.getCreateDisposition(), remoteConfiguration.getCreateDisposition());
    assertEquals(
        createdConfiguration.getWriteDisposition(), remoteConfiguration.getWriteDisposition());
    assertNotNull(remoteJob.getEtag());
    assertNull(remoteJob.getStatistics());
    assertNull(remoteJob.getStatus());
    assertNull(remoteJob.getSelfLink());
    assertNull(remoteJob.getUserEmail());
    assertTrue(createdTable.delete());

    Job completedJob =
        remoteJob.waitFor(
            RetryOption.initialRetryDelay(Duration.ofSeconds(1)),
            RetryOption.totalTimeout(Duration.ofMinutes(1)));
    assertNotNull(completedJob);
    assertNull(completedJob.getStatus().getError());
    assertTrue(bigquery.delete(destinationTable));
  }

  @Test
  public void testCopyJob() throws InterruptedException, TimeoutException {
    String sourceTableName = "test_copy_job_source_table";
    String destinationTableName = "test_copy_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(sourceTableName, createdTable.getTableId().getTable());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, sourceTable);
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    remoteJob = remoteJob.waitFor();
    assertNull(remoteJob.getStatus().getError());
    Table remoteTable = bigquery.getTable(DATASET, destinationTableName);
    assertNotNull(remoteTable);
    assertEquals(destinationTable.getDataset(), remoteTable.getTableId().getDataset());
    assertEquals(destinationTableName, remoteTable.getTableId().getTable());
    assertEquals(TABLE_SCHEMA, remoteTable.getDefinition().getSchema());
    assertTrue(createdTable.delete());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCopyJobWithLabels() throws InterruptedException {
    String sourceTableName = "test_copy_job_source_table_label";
    String destinationTableName = "test_copy_job_destination_table_label";
    Map<String, String> labels = ImmutableMap.of("test_job_name", "test_copy_job");
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration configuration =
        CopyJobConfiguration.newBuilder(destinationTable, sourceTable).setLabels(labels).build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    remoteJob = remoteJob.waitFor();
    assertNull(remoteJob.getStatus().getError());
    CopyJobConfiguration copyJobConfiguration = remoteJob.getConfiguration();
    assertEquals(labels, copyJobConfiguration.getLabels());
    Table remoteTable = bigquery.getTable(DATASET, destinationTableName);
    assertNotNull(remoteTable);
    assertTrue(createdTable.delete());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testQueryJob() throws InterruptedException, TimeoutException {
    String tableName = "test_query_job_table";
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    TableId destinationTable = TableId.of(DATASET, tableName);
    QueryJobConfiguration configuration =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setDestinationTable(destinationTable)
            .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    remoteJob = remoteJob.waitFor();
    assertNull(remoteJob.getStatus().getError());

    TableResult result = remoteJob.getQueryResults();
    assertEquals(QUERY_RESULT_SCHEMA, result.getSchema());
    int rowCount = 0;
    for (FieldValueList row : result.getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue booleanCell = row.get(2);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(bigquery.delete(destinationTable));
    Job queryJob = bigquery.getJob(remoteJob.getJobId());
    JobStatistics.QueryStatistics statistics = queryJob.getStatistics();
    assertNotNull(statistics.getQueryPlan());
  }

  @Test
  public void testQueryJobWithConnectionProperties() throws InterruptedException {
    String tableName = "test_query_job_table_connection_properties";
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    TableId destinationTable = TableId.of(DATASET, tableName);
    QueryJobConfiguration configuration =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setDestinationTable(destinationTable)
            .setConnectionProperties(CONNECTION_PROPERTIES)
            .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    remoteJob = remoteJob.waitFor();
    assertNull(remoteJob.getStatus().getError());
    QueryJobConfiguration jobConfiguration = remoteJob.getConfiguration();
    assertEquals(CONNECTION_PROPERTIES, jobConfiguration.getConnectionProperties());
    assertTrue(bigquery.delete(destinationTable));
  }

  @Test
  public void testQueryJobWithLabels() throws InterruptedException, TimeoutException {
    String tableName = "test_query_job_table";
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    Map<String, String> labels = ImmutableMap.of("test-job-name", "test-query-job");
    TableId destinationTable = TableId.of(DATASET, tableName);
    try {
      QueryJobConfiguration configuration =
          QueryJobConfiguration.newBuilder(query)
              .setDefaultDataset(DatasetId.of(DATASET))
              .setDestinationTable(destinationTable)
              .setLabels(labels)
              .build();
      Job remoteJob = bigquery.create(JobInfo.of(configuration));
      remoteJob = remoteJob.waitFor();
      assertNull(remoteJob.getStatus().getError());
      QueryJobConfiguration queryJobConfiguration = remoteJob.getConfiguration();
      assertEquals(labels, queryJobConfiguration.getLabels());
    } finally {
      bigquery.delete(destinationTable);
    }
  }

  @Test
  public void testQueryJobWithRangePartitioning() throws InterruptedException {
    String tableName = "test_query_job_table_rangepartitioning";
    String query =
        "SELECT IntegerField, TimestampField, StringField, BooleanField FROM "
            + TABLE_ID.getTable();
    TableId destinationTable = TableId.of(DATASET, tableName);
    try {
      QueryJobConfiguration configuration =
          QueryJobConfiguration.newBuilder(query)
              .setDefaultDataset(DatasetId.of(DATASET))
              .setDestinationTable(destinationTable)
              .setRangePartitioning(RANGE_PARTITIONING)
              .build();
      Job remoteJob = bigquery.create(JobInfo.of(configuration));
      remoteJob = remoteJob.waitFor();
      assertNull(remoteJob.getStatus().getError());
      QueryJobConfiguration queryJobConfiguration = remoteJob.getConfiguration();
      assertEquals(RANGE, queryJobConfiguration.getRangePartitioning().getRange());
      assertEquals(RANGE_PARTITIONING, queryJobConfiguration.getRangePartitioning());
    } finally {
      bigquery.delete(destinationTable);
    }
  }

  @Test
  public void testLoadJobWithRangePartitioning() throws InterruptedException {
    String tableName = "test_load_job_table_rangepartitioning";
    TableId destinationTable = TableId.of(DATASET, tableName);
    try {
      LoadJobConfiguration configuration =
          LoadJobConfiguration.newBuilder(
                  TABLE_ID, "gs://" + BUCKET + "/" + JSON_LOAD_FILE, FormatOptions.json())
              .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
              .setSchema(TABLE_SCHEMA)
              .setRangePartitioning(RANGE_PARTITIONING)
              .setDestinationTable(destinationTable)
              .build();
      Job job = bigquery.create(JobInfo.of(configuration));
      job = job.waitFor();
      assertNull(job.getStatus().getError());
      LoadJobConfiguration loadJobConfiguration = job.getConfiguration();
      assertEquals(RANGE, loadJobConfiguration.getRangePartitioning().getRange());
      assertEquals(RANGE_PARTITIONING, loadJobConfiguration.getRangePartitioning());
    } finally {
      bigquery.delete(destinationTable);
    }
  }

  @Test
  public void testQueryJobWithDryRun() throws InterruptedException, TimeoutException {
    String tableName = "test_query_job_table";
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    TableId destinationTable = TableId.of(DATASET, tableName);
    QueryJobConfiguration configuration =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setDestinationTable(destinationTable)
            .setDryRun(true)
            .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    assertNull(remoteJob.getJobId().getJob());
    assertEquals(DONE, remoteJob.getStatus().getState());
    assertNotNull(remoteJob.getConfiguration());
  }

  @Test
  public void testExtractJob() throws InterruptedException, TimeoutException {
    String tableName = "test_export_job_table";
    TableId destinationTable = TableId.of(DATASET, tableName);
    Map<String, String> labels = ImmutableMap.of("test-job-name", "test-load-extract-job");
    LoadJobConfiguration configuration =
        LoadJobConfiguration.newBuilder(destinationTable, "gs://" + BUCKET + "/" + LOAD_FILE)
            .setSchema(SIMPLE_SCHEMA)
            .setLabels(labels)
            .build();
    Job remoteLoadJob = bigquery.create(JobInfo.of(configuration));
    remoteLoadJob = remoteLoadJob.waitFor();
    assertNull(remoteLoadJob.getStatus().getError());
    LoadJobConfiguration loadJobConfiguration = remoteLoadJob.getConfiguration();
    assertEquals(labels, loadJobConfiguration.getLabels());

    ExtractJobConfiguration extractConfiguration =
        ExtractJobConfiguration.newBuilder(destinationTable, "gs://" + BUCKET + "/" + EXTRACT_FILE)
            .setPrintHeader(false)
            .build();
    Job remoteExtractJob = bigquery.create(JobInfo.of(extractConfiguration));
    remoteExtractJob = remoteExtractJob.waitFor();
    assertNull(remoteExtractJob.getStatus().getError());

    String extractedCsv =
        new String(storage.readAllBytes(BUCKET, EXTRACT_FILE), StandardCharsets.UTF_8);
    assertEquals(
        Sets.newHashSet(CSV_CONTENT.split("\n")), Sets.newHashSet(extractedCsv.split("\n")));
    assertTrue(bigquery.delete(destinationTable));
  }

  @Test
  public void testExtractJobWithModel() throws InterruptedException {
    String modelName = RemoteBigQueryHelper.generateModelName();
    String sql =
        "CREATE MODEL `"
            + MODEL_DATASET
            + "."
            + modelName
            + "`"
            + "OPTIONS ( "
            + "model_type='linear_reg', "
            + "max_iteration=1, "
            + "learn_rate=0.4, "
            + "learn_rate_strategy='constant' "
            + ") AS ( "
            + "	SELECT 'a' AS f1, 2.0 AS label "
            + "UNION ALL "
            + "SELECT 'b' AS f1, 3.8 AS label "
            + ")";

    QueryJobConfiguration config = QueryJobConfiguration.newBuilder(sql).build();
    Job job = bigquery.create(JobInfo.of(JobId.of(), config));
    job.waitFor();
    assertNull(job.getStatus().getError());
    ModelId destinationModel = ModelId.of(MODEL_DATASET, modelName);
    assertNotNull(destinationModel);
    ExtractJobConfiguration extractConfiguration =
        ExtractJobConfiguration.newBuilder(
                destinationModel, "gs://" + BUCKET + "/" + EXTRACT_MODEL_FILE)
            .setPrintHeader(false)
            .build();
    Job remoteExtractJob = bigquery.create(JobInfo.of(extractConfiguration));
    remoteExtractJob = remoteExtractJob.waitFor();
    assertNull(remoteExtractJob.getStatus().getError());
    assertTrue(bigquery.delete(destinationModel));
  }

  @Test
  public void testExtractJobWithLabels() throws InterruptedException, TimeoutException {
    String tableName = "test_export_job_table_label";
    Map<String, String> labels = ImmutableMap.of("test_job_name", "test_export_job");
    TableId destinationTable = TableId.of(DATASET, tableName);
    LoadJobConfiguration configuration =
        LoadJobConfiguration.newBuilder(destinationTable, "gs://" + BUCKET + "/" + LOAD_FILE)
            .setSchema(SIMPLE_SCHEMA)
            .build();
    Job remoteLoadJob = bigquery.create(JobInfo.of(configuration));
    remoteLoadJob = remoteLoadJob.waitFor();
    assertNull(remoteLoadJob.getStatus().getError());

    ExtractJobConfiguration extractConfiguration =
        ExtractJobConfiguration.newBuilder(destinationTable, "gs://" + BUCKET + "/" + EXTRACT_FILE)
            .setLabels(labels)
            .setPrintHeader(false)
            .build();
    Job remoteExtractJob = bigquery.create(JobInfo.of(extractConfiguration));
    remoteExtractJob = remoteExtractJob.waitFor();
    assertNull(remoteExtractJob.getStatus().getError());
    ExtractJobConfiguration extractJobConfiguration = remoteExtractJob.getConfiguration();
    assertEquals(labels, extractJobConfiguration.getLabels());
    assertTrue(bigquery.delete(destinationTable));
  }

  @Test
  public void testCancelJob() throws InterruptedException, TimeoutException {
    String destinationTableName = "test_cancel_query_job_table";
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    QueryJobConfiguration configuration =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setDestinationTable(destinationTable)
            .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    assertTrue(remoteJob.cancel());
  }

  @Test
  public void testCancelNonExistingJob() {
    assertFalse(bigquery.cancel("test_cancel_non_existing_job"));
  }

  @Test
  public void testInsertFromFile() throws InterruptedException, IOException, TimeoutException {
    String destinationTableName = "test_insert_from_file_table";
    TableId tableId = TableId.of(DATASET, destinationTableName);
    WriteChannelConfiguration configuration =
        WriteChannelConfiguration.newBuilder(tableId)
            .setFormatOptions(FormatOptions.json())
            .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
            .setSchema(TABLE_SCHEMA)
            .build();
    TableDataWriteChannel channel = bigquery.writer(configuration);
    try {
      // A zero byte write should not throw an exception.
      assertEquals(0, channel.write(ByteBuffer.wrap("".getBytes(StandardCharsets.UTF_8))));
    } finally {
      // Force the channel to flush by calling `close`.
      channel.close();
    }
    channel = bigquery.writer(configuration);
    try {
      channel.write(ByteBuffer.wrap(JSON_CONTENT.getBytes(StandardCharsets.UTF_8)));
    } finally {
      channel.close();
    }
    Job job = channel.getJob().waitFor();
    LoadStatistics statistics = job.getStatistics();
    assertEquals(1L, statistics.getInputFiles().longValue());
    assertEquals(2L, statistics.getOutputRows().longValue());
    LoadJobConfiguration jobConfiguration = job.getConfiguration();
    assertEquals(TABLE_SCHEMA, jobConfiguration.getSchema());
    assertNull(jobConfiguration.getSourceUris());
    assertNull(job.getStatus().getError());
    Page<FieldValueList> rows = bigquery.listTableData(tableId);
    int rowCount = 0;
    for (FieldValueList row : rows.getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerArrayCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      FieldValue bytesCell = row.get(4);
      FieldValue recordCell = row.get(5);
      FieldValue integerCell = row.get(6);
      FieldValue floatCell = row.get(7);
      FieldValue geographyCell = row.get(8);
      FieldValue numericCell = row.get(9);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.REPEATED, integerArrayCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, bytesCell.getAttribute());
      assertEquals(FieldValue.Attribute.RECORD, recordCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, integerCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, floatCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, geographyCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, numericCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(0, integerArrayCell.getRepeatedValue().get(0).getLongValue());
      assertEquals(1, integerArrayCell.getRepeatedValue().get(1).getLongValue());
      assertEquals(false, booleanCell.getBooleanValue());
      assertArrayEquals(BYTES, bytesCell.getBytesValue());
      assertEquals(-14182916000000L, recordCell.getRecordValue().get(0).getTimestampValue());
      assertTrue(recordCell.getRecordValue().get(1).isNull());
      assertEquals(1, recordCell.getRecordValue().get(2).getRepeatedValue().get(0).getLongValue());
      assertEquals(0, recordCell.getRecordValue().get(2).getRepeatedValue().get(1).getLongValue());
      assertEquals(true, recordCell.getRecordValue().get(3).getBooleanValue());
      assertEquals(3, integerCell.getLongValue());
      assertEquals(1.2, floatCell.getDoubleValue(), 0.0001);
      assertEquals("POINT(-122.35022 47.649154)", geographyCell.getStringValue());
      assertEquals(new BigDecimal("123456.789012345"), numericCell.getNumericValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(bigquery.delete(tableId));
  }

  @Test
  public void testInsertFromFileWithLabels()
      throws InterruptedException, IOException, TimeoutException {
    String destinationTableName = "test_insert_from_file_table_with_labels";
    TableId tableId = TableId.of(DATASET, destinationTableName);
    WriteChannelConfiguration configuration =
        WriteChannelConfiguration.newBuilder(tableId)
            .setFormatOptions(FormatOptions.json())
            .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
            .setSchema(TABLE_SCHEMA)
            .setLabels(LABELS)
            .build();
    TableDataWriteChannel channel = bigquery.writer(configuration);
    try {
      // A zero byte write should not throw an exception.
      assertEquals(0, channel.write(ByteBuffer.wrap("".getBytes(StandardCharsets.UTF_8))));
    } finally {
      // Force the channel to flush by calling `close`.
      channel.close();
    }
    channel = bigquery.writer(configuration);
    try {
      channel.write(ByteBuffer.wrap(JSON_CONTENT.getBytes(StandardCharsets.UTF_8)));
    } finally {
      channel.close();
    }
    Job job = channel.getJob().waitFor();
    LoadJobConfiguration jobConfiguration = job.getConfiguration();
    assertEquals(TABLE_SCHEMA, jobConfiguration.getSchema());
    assertEquals(LABELS, jobConfiguration.getLabels());
    assertNull(job.getStatus().getError());
    assertTrue(bigquery.delete(tableId));
  }

  @Test
  public void testLocation() throws Exception {
    String location = "EU";
    String wrongLocation = "US";

    assertThat(location).isNotEqualTo(wrongLocation);

    Dataset dataset =
        bigquery.create(
            DatasetInfo.newBuilder("locationset_" + UUID.randomUUID().toString().replace("-", "_"))
                .setLocation(location)
                .build());
    try {
      TableId tableId = TableId.of(dataset.getDatasetId().getDataset(), "sometable");
      Schema schema = Schema.of(Field.of("name", LegacySQLTypeName.STRING));
      TableDefinition tableDef = StandardTableDefinition.of(schema);
      Table table = bigquery.create(TableInfo.newBuilder(tableId, tableDef).build());

      String query =
          String.format(
              "SELECT * FROM `%s.%s.%s`",
              table.getTableId().getProject(),
              table.getTableId().getDataset(),
              table.getTableId().getTable());

      // Test create/get
      {
        Job job =
            bigquery.create(
                JobInfo.of(
                    JobId.newBuilder().setLocation(location).build(),
                    QueryJobConfiguration.of(query)));
        job = job.waitFor();
        assertThat(job.getStatus().getError()).isNull();

        assertThat(job.getJobId().getLocation()).isEqualTo(location);

        JobId jobId = job.getJobId();
        JobId wrongId = jobId.toBuilder().setLocation(wrongLocation).build();

        // Getting with location should work.
        assertThat(bigquery.getJob(jobId)).isNotNull();
        // Getting with wrong location shouldn't work.
        assertThat(bigquery.getJob(wrongId)).isNull();

        // Cancelling with location should work. (Cancelling already finished job is fine.)
        assertThat(bigquery.cancel(jobId)).isTrue();
        // Cancelling with wrong location shouldn't work.
        assertThat(bigquery.cancel(wrongId)).isFalse();
      }

      // Test query
      {
        assertThat(
                bigquery
                    .query(
                        QueryJobConfiguration.of(query),
                        JobId.newBuilder().setLocation(location).build())
                    .iterateAll())
            .isEmpty();

        try {
          bigquery
              .query(
                  QueryJobConfiguration.of(query),
                  JobId.newBuilder().setLocation(wrongLocation).build())
              .iterateAll();
          fail("querying a table with wrong location shouldn't work");
        } catch (BigQueryException e) {
          // Nothing to do
        }
      }

      // Test write
      {
        WriteChannelConfiguration writeChannelConfiguration =
            WriteChannelConfiguration.newBuilder(tableId)
                .setFormatOptions(FormatOptions.csv())
                .build();
        try (TableDataWriteChannel writer =
            bigquery.writer(
                JobId.newBuilder().setLocation(location).build(), writeChannelConfiguration)) {
          writer.write(ByteBuffer.wrap("foo".getBytes()));
        }

        try {
          bigquery.writer(
              JobId.newBuilder().setLocation(wrongLocation).build(), writeChannelConfiguration);
          fail("writing to a table with wrong location shouldn't work");
        } catch (BigQueryException e) {
          // Nothing to do
        }
      }
    } finally {
      bigquery.delete(dataset.getDatasetId(), DatasetDeleteOption.deleteContents());
    }
  }
}
