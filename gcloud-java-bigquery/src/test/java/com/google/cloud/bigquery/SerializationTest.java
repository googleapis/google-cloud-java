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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.cloud.AuthCredentials;
import com.google.cloud.BaseSerializationTest;
import com.google.cloud.Restorable;
import com.google.cloud.bigquery.StandardTableDefinition.StreamingBuffer;

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
  private static final DatasetInfo DATASET_INFO = DatasetInfo.builder(DATASET_ID)
      .acl(ACCESS_RULES)
      .creationTime(CREATION_TIME)
      .defaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
      .description(DESCRIPTION)
      .etag(ETAG)
      .friendlyName(FRIENDLY_NAME)
      .generatedId(GENERATED_ID)
      .lastModified(LAST_MODIFIED)
      .location(LOCATION)
      .selfLink(SELF_LINK)
      .build();
  private static final TableId TABLE_ID = TableId.of("project", "dataset", "table");
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder()
      .allowJaggedRows(true)
      .allowQuotedNewLines(false)
      .encoding(StandardCharsets.ISO_8859_1)
      .fieldDelimiter(",")
      .quote("\"")
      .skipLeadingRows(42)
      .build();
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
  private static final StreamingBuffer STREAMING_BUFFER = new StreamingBuffer(1L, 2L, 3L);
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.builder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .ignoreUnknownValues(true)
          .maxBadRecords(42)
          .build();
  private static final UserDefinedFunction INLINE_FUNCTION =
      new UserDefinedFunction.InlineFunction("inline");
  private static final UserDefinedFunction URI_FUNCTION =
      new UserDefinedFunction.UriFunction("URI");
  private static final TableDefinition TABLE_DEFINITION = StandardTableDefinition.builder()
      .schema(TABLE_SCHEMA)
      .location(LOCATION)
      .streamingBuffer(STREAMING_BUFFER)
      .build();
  private static final TableInfo TABLE_INFO = TableInfo.builder(TABLE_ID, TABLE_DEFINITION)
      .creationTime(CREATION_TIME)
      .description(DESCRIPTION)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .build();
  private static final TableDefinition VIEW_DEFINITION = ViewDefinition.of("QUERY");
  private static final TableInfo VIEW_INFO = TableInfo.builder(TABLE_ID, VIEW_DEFINITION)
      .creationTime(CREATION_TIME)
      .description(DESCRIPTION)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .build();
  private static final TableInfo EXTERNAL_TABLE_INFO =
      TableInfo.builder(TABLE_ID, EXTERNAL_TABLE_DEFINITION)
          .creationTime(CREATION_TIME)
          .description(DESCRIPTION)
          .etag(ETAG)
          .generatedId(GENERATED_ID)
          .build();
  private static final JobStatistics JOB_STATISTICS = JobStatistics.builder()
      .creationTime(1L)
      .endTime(3L)
      .startTime(2L)
      .build();
  private static final JobStatistics.ExtractStatistics EXTRACT_STATISTICS =
      JobStatistics.ExtractStatistics.builder()
          .creationTime(1L)
          .endTime(3L)
          .startTime(2L)
          .destinationUriFileCounts(ImmutableList.of(42L))
          .build();
  private static final JobStatistics.LoadStatistics LOAD_STATISTICS =
      JobStatistics.LoadStatistics.builder()
          .creationTime(1L)
          .endTime(3L)
          .startTime(2L)
          .inputFiles(42L)
          .outputBytes(1024L)
          .inputBytes(2048L)
          .outputRows(24L)
          .build();
  private static final JobStatistics.QueryStatistics QUERY_STATISTICS =
      JobStatistics.QueryStatistics.builder()
          .creationTime(1L)
          .endTime(3L)
          .startTime(2L)
          .totalBytesProcessed(2048L)
          .totalBytesBilled(1024L)
          .cacheHit(false)
          .billingTier(42)
          .build();
  private static final BigQueryError BIGQUERY_ERROR =
      new BigQueryError("reason", "location", "message", "debugInfo");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE, BIGQUERY_ERROR,
      ImmutableList.of(BIGQUERY_ERROR));
  private static final JobId JOB_ID = JobId.of("project", "job");
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID, TABLE_ID);
  private static final ExtractJobConfiguration EXTRACT_JOB_CONFIGURATION =
      ExtractJobConfiguration.of(TABLE_ID, SOURCE_URIS);
  private static final WriteChannelConfiguration LOAD_CONFIGURATION =
      WriteChannelConfiguration.builder(TABLE_ID)
          .createDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
          .writeDisposition(JobInfo.WriteDisposition.WRITE_APPEND)
          .formatOptions(CSV_OPTIONS)
          .ignoreUnknownValues(true)
          .maxBadRecords(10)
          .schema(TABLE_SCHEMA)
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
  private static final InsertAllRequest INSERT_ALL_REQUEST = InsertAllRequest.builder(TABLE_ID)
      .addRow(CONTENT1)
      .addRow(CONTENT2)
      .ignoreUnknownValues(true)
      .skipInvalidRows(false)
      .build();
  private static final Map<Long, List<BigQueryError>> ERRORS_MAP =
      ImmutableMap.<Long, List<BigQueryError>>of(0L, ImmutableList.of(BIGQUERY_ERROR));
  private static final InsertAllResponse INSERT_ALL_RESPONSE = new InsertAllResponse(ERRORS_MAP);
  private static final FieldValue FIELD_VALUE =
      new FieldValue(FieldValue.Attribute.PRIMITIVE, "value");
  private static final QueryRequest QUERY_REQUEST = QueryRequest.builder("query")
      .useQueryCache(true)
      .defaultDataset(DATASET_ID)
      .dryRun(false)
      .pageSize(42L)
      .maxWaitTime(10L)
      .build();
  private static final QueryResult QUERY_RESULT = QueryResult.builder()
      .schema(TABLE_SCHEMA)
      .totalRows(1L)
      .totalBytesProcessed(42L)
      .cursor("cursor")
      .pageFetcher(null)
      .results(ImmutableList.<List<FieldValue>>of())
      .build();
  private static final QueryResponse QUERY_RESPONSE = QueryResponse.builder()
      .etag(ETAG)
      .jobId(JOB_ID)
      .jobCompleted(true)
      .result(QUERY_RESULT)
      .build();
  private static final BigQuery BIGQUERY =
      BigQueryOptions.builder().projectId("p1").build().service();
  private static final Dataset DATASET =
      new Dataset(BIGQUERY, new DatasetInfo.BuilderImpl(DATASET_INFO));
  private static final Table TABLE = new Table(BIGQUERY, new TableInfo.BuilderImpl(TABLE_INFO));
  private static final Job JOB = new Job(BIGQUERY, new JobInfo.BuilderImpl(JOB_INFO));
  private static final BigQueryException BIG_QUERY_EXCEPTION =
      new BigQueryException(42, "message", BIGQUERY_ERROR);

  @Override
  protected Serializable[] serializableObjects() {
    BigQueryOptions options = BigQueryOptions.builder()
        .projectId("p1")
        .authCredentials(AuthCredentials.createForAppEngine())
        .build();
    BigQueryOptions otherOptions = options.toBuilder()
        .projectId("p2")
        .authCredentials(null)
        .build();
    return new Serializable[]{DOMAIN_ACCESS, GROUP_ACCESS, USER_ACCESS, VIEW_ACCESS, DATASET_ID,
        DATASET_INFO, TABLE_ID, CSV_OPTIONS, STREAMING_BUFFER, TABLE_DEFINITION,
        EXTERNAL_TABLE_DEFINITION, VIEW_DEFINITION, TABLE_SCHEMA, TABLE_INFO, VIEW_INFO,
        EXTERNAL_TABLE_INFO, INLINE_FUNCTION, URI_FUNCTION, JOB_STATISTICS, EXTRACT_STATISTICS,
        LOAD_STATISTICS, QUERY_STATISTICS, BIGQUERY_ERROR, JOB_STATUS, JOB_ID,
        COPY_JOB_CONFIGURATION, EXTRACT_JOB_CONFIGURATION, LOAD_CONFIGURATION,
        LOAD_JOB_CONFIGURATION, QUERY_JOB_CONFIGURATION, JOB_INFO, INSERT_ALL_REQUEST,
        INSERT_ALL_RESPONSE, FIELD_VALUE, QUERY_REQUEST, QUERY_RESPONSE, BIG_QUERY_EXCEPTION,
        BigQuery.DatasetOption.fields(), BigQuery.DatasetDeleteOption.deleteContents(),
        BigQuery.DatasetListOption.all(), BigQuery.TableOption.fields(),
        BigQuery.TableListOption.pageSize(42L), BigQuery.JobOption.fields(),
        BigQuery.JobListOption.allUsers(), DATASET, TABLE, JOB, options, otherOptions};
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    BigQueryOptions options = BigQueryOptions.builder().projectId("p2").build();
    // avoid closing when you don't want partial writes upon failure
    @SuppressWarnings("resource")
    TableDataWriteChannel writer =
        new TableDataWriteChannel(options, LOAD_CONFIGURATION, "upload-id");
    return new Restorable<?>[]{writer};
  }
}
