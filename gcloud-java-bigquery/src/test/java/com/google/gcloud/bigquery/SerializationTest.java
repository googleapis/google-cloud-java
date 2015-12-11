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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.AuthCredentials;
import com.google.gcloud.RetryParams;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class SerializationTest {

  private static final Acl DOMAIN_ACCESS =
      new Acl(new Acl.Domain("domain"), Acl.Role.WRITER);
  private static final Acl GROUP_ACCESS =
      new Acl(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER);
  private static final Acl USER_ACCESS = new Acl(new Acl.User("user"), Acl.Role.OWNER);
  private static final Acl VIEW_ACCESS =
      new Acl(new Acl.View(TableId.of("project", "dataset", "table")), Acl.Role.WRITER);
  private static final List<Acl> ACCESS_RULES = ImmutableList.of(DOMAIN_ACCESS, GROUP_ACCESS,
      VIEW_ACCESS, USER_ACCESS);
  private static final Long CREATION_TIME = System.currentTimeMillis() - 10;
  private static final Long DEFAULT_TABLE_EXPIRATION = 100L;
  private static final String DESCRIPTION = "Description";
  private static final String ETAG = "0xFF00";
  private static final String FRIENDLY_NAME = "friendlyDataset";
  private static final String ID = "P/D:1";
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
      .id(ID)
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
  private static final BaseTableInfo.StreamingBuffer STREAMING_BUFFER =
      new BaseTableInfo.StreamingBuffer(1L, 2L, 3L);
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final ExternalDataConfiguration EXTERNAL_DATA_CONFIGURATION =
      ExternalDataConfiguration.builder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
      .ignoreUnknownValues(true)
      .maxBadRecords(42)
      .build();
  private static final UserDefinedFunction INLINE_FUNCTION =
      new UserDefinedFunction.InlineFunction("inline");
  private static final UserDefinedFunction URI_FUNCTION =
      new UserDefinedFunction.UriFunction("URI");
  private static final BaseTableInfo TABLE_INFO =
      TableInfo.builder(TABLE_ID, TABLE_SCHEMA)
          .creationTime(CREATION_TIME)
          .description(DESCRIPTION)
          .etag(ETAG)
          .id(ID)
          .location(LOCATION)
          .streamingBuffer(STREAMING_BUFFER)
          .build();
  private static final ViewInfo VIEW_INFO =
      ViewInfo.builder(TABLE_ID, "QUERY")
          .creationTime(CREATION_TIME)
          .description(DESCRIPTION)
          .etag(ETAG)
          .id(ID)
          .build();
  private static final ExternalTableInfo EXTERNAL_TABLE_INFO =
      ExternalTableInfo.builder(TABLE_ID, EXTERNAL_DATA_CONFIGURATION)
          .creationTime(CREATION_TIME)
          .description(DESCRIPTION)
          .etag(ETAG)
          .id(ID)
          .streamingBuffer(STREAMING_BUFFER)
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
  private static final CopyJobInfo COPY_JOB = CopyJobInfo.of(TABLE_ID, TABLE_ID);
  private static final ExtractJobInfo EXTRACT_JOB = ExtractJobInfo.of(TABLE_ID, SOURCE_URIS);
  private static final LoadJobInfo LOAD_JOB = LoadJobInfo.of(TABLE_ID, SOURCE_URIS);
  private static final QueryJobInfo QUERY_JOB = QueryJobInfo.of("query");
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
  private static final FieldValue FIELD_VALUE = new FieldValue(FieldValue.Attribute.PRIMITIVE, "value");
  private static final TableRow TABLE_ROW = new TableRow.Builder()
      .addValue(FIELD_VALUE)
      .build();

  @Test
  public void testServiceOptions() throws Exception {
    BigQueryOptions options = BigQueryOptions.builder()
        .projectId("p1")
        .authCredentials(AuthCredentials.createForAppEngine())
        .build();
    BigQueryOptions serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);

    options = options.toBuilder()
        .projectId("p2")
        .retryParams(RetryParams.getDefaultInstance())
        .authCredentials(AuthCredentials.noCredentials())
        .build();
    serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
  }

  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {DOMAIN_ACCESS, GROUP_ACCESS, USER_ACCESS, VIEW_ACCESS, DATASET_ID,
        DATASET_INFO, TABLE_ID, CSV_OPTIONS, STREAMING_BUFFER, EXTERNAL_DATA_CONFIGURATION,
        TABLE_SCHEMA, TABLE_INFO, VIEW_INFO, EXTERNAL_TABLE_INFO, INLINE_FUNCTION, URI_FUNCTION,
        JOB_STATISTICS, EXTRACT_STATISTICS, LOAD_STATISTICS, QUERY_STATISTICS, BIGQUERY_ERROR,
        JOB_STATUS, JOB_ID, COPY_JOB, EXTRACT_JOB, LOAD_JOB, QUERY_JOB, INSERT_ALL_REQUEST,
        INSERT_ALL_RESPONSE, FIELD_VALUE, TABLE_ROW};
    for (Serializable obj : objects) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @SuppressWarnings("unchecked")
  private <T extends java.io.Serializable> T serializeAndDeserialize(T obj)
      throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(obj);
    }
    try (ObjectInputStream input =
        new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      return (T) input.readObject();
    }
  }
}
