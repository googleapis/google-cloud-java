/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.NoCredentials;
import com.google.cloud.Restorable;
import com.google.cloud.bigquery.StandardTableDefinition.StreamingBuffer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class SerializationTest extends BaseSerializationTest {

  private static final Acl DOMAIN_ACCESS =
      Acl.of(new Acl.Domain("domain"), Acl.Role.WRITER);
  private static final Acl GROUP_ACCESS =
      Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER);
  private static final Acl USER_ACCESS = Acl.of(new Acl.User("user"), Acl.Role.OWNER);
  private static final Acl VIEW_ACCESS =
      Acl.of(new Acl.View(TableId.of("project", "dataset", "table")), Acl.Role.WRITER);
  private static final List<Acl> ACCESS_RULES = ImmutableList.of(DOMAIN_ACCESS, GROUP_ACCESS,
      VIEW_ACCESS, USER_ACCESS);
  private static final Long CREATION_TIME = System.currentTimeMillis() - 10;
  private static final Long DEFAULT_TABLE_EXPIRATION = 100L;
  private static final String DESCRIPTION = "Description";
  private static final String ETAG = "0xFF00";
  private static final String FRIENDLY_NAME = "friendlyDataset";
  private static final String GENERATED_ID = "P/D:1";
  private static final Long LAST_MODIFIED = CREATION_TIME + 50;
  private static final String LOCATION = "";
  private static final String SELF_LINK = "http://bigquery/p/d";
  private static final DatasetId DATASET_ID = DatasetId.of("project", "dataset");
  private static final DatasetInfo DATASET_INFO = DatasetInfo.newBuilder(DATASET_ID)
      .setAcl(ACCESS_RULES)
      .setCreationTime(CREATION_TIME)
      .setDefaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
      .setDescription(DESCRIPTION)
      .setEtag(ETAG)
      .setFriendlyName(FRIENDLY_NAME)
      .setGeneratedId(GENERATED_ID)
      .setLastModified(LAST_MODIFIED)
      .setLocation(LOCATION)
      .setSelfLink(SELF_LINK)
      .build();
  private static final TableId TABLE_ID = TableId.of("project", "dataset", "table");
  private static final CsvOptions CSV_OPTIONS = CsvOptions.newBuilder()
      .setAllowJaggedRows(true)
      .setAllowQuotedNewLines(false)
      .setEncoding(StandardCharsets.ISO_8859_1)
      .setFieldDelimiter(",")
      .setQuote("\"")
      .setSkipLeadingRows(42L)
      .build();
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
  private static final StreamingBuffer STREAMING_BUFFER = new StreamingBuffer(1L, 2L, 3L);
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .setIgnoreUnknownValues(true)
          .setMaxBadRecords(42)
          .build();
  private static final UserDefinedFunction INLINE_FUNCTION =
      new UserDefinedFunction.InlineFunction("inline");
  private static final UserDefinedFunction URI_FUNCTION =
      new UserDefinedFunction.UriFunction("URI");
  private static final TableDefinition TABLE_DEFINITION = StandardTableDefinition.newBuilder()
      .setSchema(TABLE_SCHEMA)
      .setLocation(LOCATION)
      .setStreamingBuffer(STREAMING_BUFFER)
      .build();
  private static final TableInfo TABLE_INFO = TableInfo.newBuilder(TABLE_ID, TABLE_DEFINITION)
      .setCreationTime(CREATION_TIME)
      .setDescription(DESCRIPTION)
      .setEtag(ETAG)
      .setGeneratedId(GENERATED_ID)
      .build();
  private static final TableDefinition VIEW_DEFINITION = ViewDefinition.of("QUERY");
  private static final TableInfo VIEW_INFO = TableInfo.newBuilder(TABLE_ID, VIEW_DEFINITION)
      .setCreationTime(CREATION_TIME)
      .setDescription(DESCRIPTION)
      .setEtag(ETAG)
      .setGeneratedId(GENERATED_ID)
      .build();
  private static final TableInfo EXTERNAL_TABLE_INFO =
      TableInfo.newBuilder(TABLE_ID, EXTERNAL_TABLE_DEFINITION)
          .setCreationTime(CREATION_TIME)
          .setDescription(DESCRIPTION)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .build();
  private static final JobStatistics.CopyStatistics COPY_STATISTICS =
      JobStatistics.CopyStatistics.newBuilder()
          .setCreationTimestamp(1L)
          .setEndTime(3L)
          .setStartTime(2L)
          .build();
  private static final JobStatistics.ExtractStatistics EXTRACT_STATISTICS =
      JobStatistics.ExtractStatistics.newBuilder()
          .setCreationTimestamp(1L)
          .setEndTime(3L)
          .setStartTime(2L)
          .setDestinationUriFileCounts(ImmutableList.of(42L))
          .build();
  private static final JobStatistics.LoadStatistics LOAD_STATISTICS =
      JobStatistics.LoadStatistics.newBuilder()
          .setCreationTimestamp(1L)
          .setEndTime(3L)
          .setStartTime(2L)
          .setInputFiles(42L)
          .setOutputBytes(1024L)
          .setInputBytes(2048L)
          .setOutputRows(24L)
          .build();
  private static final JobStatistics.QueryStatistics QUERY_STATISTICS =
      JobStatistics.QueryStatistics.newBuilder()
          .setCreationTimestamp(1L)
          .setEndTime(3L)
          .setStartTime(2L)
          .setTotalBytesProcessed(2048L)
          .setTotalBytesBilled(1024L)
          .setCacheHit(false)
          .setBillingTier(42)
          .build();
  private static final BigQueryError BIGQUERY_ERROR =
      new BigQueryError("reason", "location", "message", "debugInfo");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE, BIGQUERY_ERROR,
      ImmutableList.of(BIGQUERY_ERROR));
  private static final JobId JOB_ID = JobId.of("project", "job");
  private static final Long NUM_DL_AFFECTED_ROWS = 24L;
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID, TABLE_ID);
  private static final ExtractJobConfiguration EXTRACT_JOB_CONFIGURATION =
      ExtractJobConfiguration.of(TABLE_ID, SOURCE_URIS);
  private static final WriteChannelConfiguration LOAD_CONFIGURATION =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
          .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
          .setWriteDisposition(JobInfo.WriteDisposition.WRITE_APPEND)
          .setFormatOptions(CSV_OPTIONS)
          .setIgnoreUnknownValues(true)
          .setMaxBadRecords(10)
          .setSchema(TABLE_SCHEMA)
          .build();
  private static final LoadJobConfiguration LOAD_JOB_CONFIGURATION =
      LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS);
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION =
      QueryJobConfiguration.of("query");
  private static final JobInfo JOB_INFO = JobInfo.of(COPY_JOB_CONFIGURATION);
  private static final Map<String, Object> CONTENT1 =
      ImmutableMap.<String, Object>of("key", "val1");
  private static final Map<String, Object> CONTENT2 =
      ImmutableMap.<String, Object>of("key", "val2");
  private static final InsertAllRequest INSERT_ALL_REQUEST = InsertAllRequest.newBuilder(TABLE_ID)
      .addRow(CONTENT1)
      .addRow(CONTENT2)
      .setIgnoreUnknownValues(true)
      .setSkipInvalidRows(false)
      .build();
  private static final Map<Long, List<BigQueryError>> ERRORS_MAP =
      ImmutableMap.<Long, List<BigQueryError>>of(0L, ImmutableList.of(BIGQUERY_ERROR));
  private static final InsertAllResponse INSERT_ALL_RESPONSE = new InsertAllResponse(ERRORS_MAP);
  private static final FieldValue FIELD_VALUE =
      FieldValue.of(FieldValue.Attribute.PRIMITIVE, "value");
  // TODO (pongad): test this once we make it serializable.
  // private static final QueryResult QUERY_RESULT = QueryResult.newBuilder()
  //     .setSchema(TABLE_SCHEMA)
  //     .setTotalRows(1L)
  //     .setCursor("cursor")
  //     .setPageFetcher(null)
  //     .setResults(ImmutableList.<FieldValueList>of())
  //     .build();
  private static final BigQuery BIGQUERY =
      BigQueryOptions.newBuilder().setProjectId("p1").build().getService();
  private static final Dataset DATASET =
      new Dataset(BIGQUERY, new DatasetInfo.BuilderImpl(DATASET_INFO));
  private static final Table TABLE = new Table(BIGQUERY, new TableInfo.BuilderImpl(TABLE_INFO));
  private static final Job JOB = new Job(BIGQUERY, new JobInfo.BuilderImpl(JOB_INFO));
  private static final BigQueryException BIG_QUERY_EXCEPTION =
      new BigQueryException(42, "message", BIGQUERY_ERROR);
  private static final TimePartitioning TIME_PARTITIONING =
      TimePartitioning.of(TimePartitioning.Type.DAY, 42);

  @Override
  protected Serializable[] serializableObjects() {
    BigQueryOptions options = BigQueryOptions.newBuilder()
        .setProjectId("p1")
        .setCredentials(NoCredentials.getInstance())
        .build();
    BigQueryOptions otherOptions = options.toBuilder().setProjectId("p2").build();
    return new Serializable[] {
      DOMAIN_ACCESS,
      GROUP_ACCESS,
      USER_ACCESS,
      VIEW_ACCESS,
      DATASET_ID,
      DATASET_INFO,
      TABLE_ID,
      CSV_OPTIONS,
      STREAMING_BUFFER,
      TABLE_DEFINITION,
      EXTERNAL_TABLE_DEFINITION,
      VIEW_DEFINITION,
      TABLE_SCHEMA,
      TABLE_INFO,
      VIEW_INFO,
      EXTERNAL_TABLE_INFO,
      INLINE_FUNCTION,
      URI_FUNCTION,
      COPY_STATISTICS,
      EXTRACT_STATISTICS,
      LOAD_STATISTICS,
      QUERY_STATISTICS,
      BIGQUERY_ERROR,
      JOB_STATUS,
      JOB_ID,
      COPY_JOB_CONFIGURATION,
      EXTRACT_JOB_CONFIGURATION,
      LOAD_CONFIGURATION,
      LOAD_JOB_CONFIGURATION,
      QUERY_JOB_CONFIGURATION,
      JOB_INFO,
      INSERT_ALL_REQUEST,
      INSERT_ALL_RESPONSE,
      FIELD_VALUE,
      BIG_QUERY_EXCEPTION,
      TIME_PARTITIONING,
      BigQuery.DatasetOption.fields(),
      BigQuery.DatasetDeleteOption.deleteContents(),
      BigQuery.DatasetListOption.all(),
      BigQuery.TableOption.fields(),
      BigQuery.TableListOption.pageSize(42L),
      BigQuery.JobOption.fields(),
      BigQuery.JobListOption.allUsers(),
      DATASET,
      TABLE,
      JOB,
      options,
      otherOptions
    };
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    BigQueryOptions options = BigQueryOptions.newBuilder().setProjectId("p2").build();
    // avoid closing when you don't want partial writes upon failure
    @SuppressWarnings("resource")
    TableDataWriteChannel writer =
        new TableDataWriteChannel(options, LOAD_CONFIGURATION, "upload-id");
    return new Restorable<?>[]{writer};
  }
}
