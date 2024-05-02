/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.storage.v1.it;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.RetryOption;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TimePartitioning;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.DataFormat;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.cloud.bigquery.storage.v1.ReadSession.TableModifiers;
import com.google.cloud.bigquery.storage.v1.ReadSession.TableReadOptions;
import com.google.cloud.bigquery.storage.v1.ReadStream;
import com.google.cloud.bigquery.storage.v1.it.SimpleRowReader.AvroRowConsumer;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.base.Preconditions;
import com.google.protobuf.Timestamp;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.apache.avro.Conversions;
import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.util.Utf8;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

/** Integration tests for BigQuery Storage API. */
public class ITBigQueryStorageTest {
  private static final Logger LOG = Logger.getLogger(ITBigQueryStorageTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String DESCRIPTION = "BigQuery Storage Java client test dataset";

  private static BigQueryReadClient client;
  private static String parentProjectId;
  private static BigQuery bigquery;

  private static final String FAKE_JSON_CRED_WITH_GOOGLE_DOMAIN =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
          + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
          + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
          + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
          + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
          + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
          + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
          + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
          + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
          + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
          + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
          + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
          + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
          + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
          + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
          + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
          + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
          + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
          + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
          + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
          + "  \"project_id\": \"someprojectid\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\",\n"
          + "  \"universe_domain\": \"googleapis.com\"\n"
          + "}";

  private static final String FAKE_JSON_CRED_WITH_INVALID_DOMAIN =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
          + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
          + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
          + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
          + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
          + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
          + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
          + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
          + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
          + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
          + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
          + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
          + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
          + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
          + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
          + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
          + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
          + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
          + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
          + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
          + "  \"project_id\": \"someprojectid\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\",\n"
          + "  \"universe_domain\": \"fake.domain\"\n"
          + "}";

  @BeforeClass
  public static void beforeClass() throws IOException {
    client = BigQueryReadClient.create();
    parentProjectId = String.format("projects/%s", ServiceOptions.getDefaultProjectId());

    LOG.info(
        String.format(
            "%s tests running with parent project: %s",
            ITBigQueryStorageTest.class.getSimpleName(), parentProjectId));

    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    DatasetInfo datasetInfo =
        DatasetInfo.newBuilder(/* datasetId bigquery= */ DATASET)
            .setDescription(DESCRIPTION)
            .build();
    bigquery.create(datasetInfo);
    LOG.info("Created test dataset: " + DATASET);
  }

  @AfterClass
  public static void afterClass() {
    if (client != null) {
      client.close();
    }

    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
      LOG.info("Deleted test dataset: " + DATASET);
    }
  }

  @Test
  public void testSimpleReadAvro() {
    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    ReadSession session =
        client.createReadSession(
            /* parent = */ parentProjectId,
            /* readSession = */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.AVRO)
                .build(),
            /* maxStreamCount = */ 1);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    long rowCount = 0;
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      rowCount += response.getRowCount();
    }

    assertEquals(164_656, rowCount);
  }

  @Test
  public void testSimpleReadArrow() {
    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    ReadSession session =
        client.createReadSession(
            /* parent = */ parentProjectId,
            /* readSession = */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.ARROW)
                .build(),
            /* maxStreamCount = */ 1);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    // Assert that there are streams available in the session.  An empty table may not have
    // data available.  If no sessions are available for an anonymous (cached) table, consider
    // writing results of a query to a named table rather than consuming cached results
    // directly.
    Preconditions.checkState(session.getStreamsCount() > 0);

    // Use the first stream to perform reading.
    String streamName = session.getStreams(0).getName();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(streamName).build();

    long rowCount = 0;
    // Process each block of rows as they arrive and decode using our simple row reader.
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      Preconditions.checkState(response.hasArrowRecordBatch());
      rowCount += response.getRowCount();
    }
    assertEquals(164_656, rowCount);
  }

  @Test
  public void testRangeType() throws InterruptedException {
    // Create table with Range values.
    String tableName = "test_range_type";
    TableId tableId = TableId.of(DATASET, tableName);
    QueryJobConfiguration createTable =
        QueryJobConfiguration.newBuilder(
                String.format(
                    "CREATE TABLE %s AS SELECT RANGE(DATE '2020-01-01', DATE '2020-12-31') as date, \n"
                        + "RANGE(DATETIME '2020-01-01T12:00:00', DATETIME '2020-12-31T12:00:00') as datetime, \n"
                        + "RANGE(TIMESTAMP '2014-01-01 07:00:00.000000+00:00', TIMESTAMP '2015-01-01 07:00:00.000000+00:00') as timestamp",
                    tableName))
            .setDefaultDataset(DatasetId.of(DATASET))
            .setUseLegacySql(false)
            .build();
    bigquery.query(createTable);

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ DATASET,
            /* tableId = */ tableId.getTable());

    ReadSession session =
        client.createReadSession(
            /* parent = */ parentProjectId,
            /* readSession = */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.ARROW)
                .build(),
            /* maxStreamCount = */ 1);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    // Assert that there are streams available in the session.  An empty table may not have
    // data available.  If no sessions are available for an anonymous (cached) table, consider
    // writing results of a query to a named table rather than consuming cached results
    // directly.
    Preconditions.checkState(session.getStreamsCount() > 0);

    // Use the first stream to perform reading.
    String streamName = session.getStreams(0).getName();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(streamName).build();

    long rowCount = 0;
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      Preconditions.checkState(response.hasArrowRecordBatch());
      rowCount += response.getRowCount();
    }
    assertEquals(1, rowCount);
  }

  @Test
  public void testSimpleReadAndResume() {
    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    ReadSession session =
        client.createReadSession(
            /* parent = */ parentProjectId,
            /* readSession = */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.AVRO)
                .build(),
            /* maxStreamCount = */ 1);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    // We have to read some number of rows in order to be able to resume. More details:

    long rowCount = ReadStreamToOffset(session.getStreams(0), /* rowOffset = */ 34_846);

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder()
            .setReadStream(session.getStreams(0).getName())
            .setOffset(rowCount)
            .build();

    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);

    for (ReadRowsResponse response : stream) {
      rowCount += response.getRowCount();
    }

    // Verifies that the number of rows skipped and read equals to the total number of rows in the
    // table.
    assertEquals(164_656, rowCount);
  }

  @Test
  public void testFilter() throws IOException {
    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    TableReadOptions options =
        TableReadOptions.newBuilder().setRowRestriction("word_count > 100").build();

    CreateReadSessionRequest request =
        CreateReadSessionRequest.newBuilder()
            .setParent(parentProjectId)
            .setMaxStreamCount(1)
            .setReadSession(
                ReadSession.newBuilder()
                    .setTable(table)
                    .setReadOptions(options)
                    .setDataFormat(DataFormat.AVRO)
                    .build())
            .build();

    ReadSession session = client.createReadSession(request);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    SimpleRowReader reader =
        new SimpleRowReader(new Schema.Parser().parse(session.getAvroSchema().getSchema()));

    long rowCount = 0;

    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      rowCount += response.getRowCount();
      reader.processRows(
          response.getAvroRows(),
          new AvroRowConsumer() {
            @Override
            public void accept(GenericData.Record record) {
              Long wordCount = (Long) record.get("word_count");
              assertWithMessage("Row not matching expectations: %s", record.toString())
                  .that(wordCount)
                  .isGreaterThan(100L);
            }
          });
    }

    assertEquals(1_333, rowCount);
  }

  @Test
  public void testColumnSelection() throws IOException {
    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    TableReadOptions options =
        TableReadOptions.newBuilder()
            .addSelectedFields("word")
            .addSelectedFields("word_count")
            .setRowRestriction("word_count > 100")
            .build();

    CreateReadSessionRequest request =
        CreateReadSessionRequest.newBuilder()
            .setParent(parentProjectId)
            .setMaxStreamCount(1)
            .setReadSession(
                ReadSession.newBuilder()
                    .setTable(table)
                    .setReadOptions(options)
                    .setDataFormat(DataFormat.AVRO)
                    .build())
            .build();

    ReadSession session = client.createReadSession(request);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    Schema avroSchema = new Schema.Parser().parse(session.getAvroSchema().getSchema());

    String actualSchemaMessage =
        String.format(
            "Unexpected schema. Actual schema:%n%s", avroSchema.toString(/* pretty = */ true));
    assertEquals(actualSchemaMessage, Schema.Type.RECORD, avroSchema.getType());
    assertEquals(actualSchemaMessage, "__root__", avroSchema.getName());

    assertEquals(actualSchemaMessage, 2, avroSchema.getFields().size());
    assertEquals(
        actualSchemaMessage, Schema.Type.STRING, avroSchema.getField("word").schema().getType());
    assertEquals(
        actualSchemaMessage,
        Schema.Type.LONG,
        avroSchema.getField("word_count").schema().getType());

    SimpleRowReader reader = new SimpleRowReader(avroSchema);

    long rowCount = 0;
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      rowCount += response.getRowCount();
      reader.processRows(
          response.getAvroRows(),
          new AvroRowConsumer() {
            @Override
            public void accept(GenericData.Record record) {
              String rowAssertMessage =
                  String.format("Row not matching expectations: %s", record.toString());

              Long wordCount = (Long) record.get("word_count");
              assertWithMessage(rowAssertMessage).that(wordCount).isGreaterThan(100L);

              Utf8 word = (Utf8) record.get("word");
              assertWithMessage(rowAssertMessage).that(word.length()).isGreaterThan(0);
            }
          });
    }

    assertEquals(1_333, rowCount);
  }

  @Test
  public void testReadAtSnapshot() throws InterruptedException, IOException {
    Field intFieldSchema =
        Field.newBuilder("col", LegacySQLTypeName.INTEGER)
            .setMode(Mode.REQUIRED)
            .setDescription("IntegerDescription")
            .build();
    com.google.cloud.bigquery.Schema tableSchema =
        com.google.cloud.bigquery.Schema.of(intFieldSchema);

    TableId testTableId = TableId.of(/* dataset = */ DATASET, /* table = */ "test_read_snapshot");
    bigquery.create(TableInfo.of(testTableId, StandardTableDefinition.of(tableSchema)));

    testTableId.toString();

    Job firstJob =
        RunQueryAppendJobAndExpectSuccess(
            /* destinationTableId = */ testTableId, /* query = */ "SELECT 1 AS col");

    Job secondJob =
        RunQueryAppendJobAndExpectSuccess(
            /* destinationTableId = */ testTableId, /* query = */ "SELECT 2 AS col");

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ DATASET,
            /* tableId = */ testTableId.getTable());

    final List<Long> rowsAfterFirstSnapshot = new ArrayList<>();
    ProcessRowsAtSnapshot(
        /* table = */ table,
        /* snapshotInMillis = */ firstJob.getStatistics().getEndTime(),
        /* filter = */ null,
        /* consumer = */ new AvroRowConsumer() {
          @Override
          public void accept(GenericData.Record record) {
            rowsAfterFirstSnapshot.add((Long) record.get("col"));
          }
        });
    assertEquals(Arrays.asList(1L), rowsAfterFirstSnapshot);

    final List<Long> rowsAfterSecondSnapshot = new ArrayList<>();
    ProcessRowsAtSnapshot(
        /* table = */ table,
        /* snapshotInMillis = */ secondJob.getStatistics().getEndTime(),
        /* filter = */ null,
        /* consumer = */ new AvroRowConsumer() {
          @Override
          public void accept(GenericData.Record record) {
            rowsAfterSecondSnapshot.add((Long) record.get("col"));
          }
        });
    Collections.sort(rowsAfterSecondSnapshot);
    assertEquals(Arrays.asList(1L, 2L), rowsAfterSecondSnapshot);
  }

  @Test
  public void testColumnPartitionedTableByDateField() throws InterruptedException, IOException {
    String partitionedTableName = "test_column_partition_table_by_date";
    String createTableStatement =
        String.format(
            " CREATE TABLE %s.%s (num_field INT64, date_field DATE) "
                + " PARTITION BY date_field "
                + " OPTIONS( "
                + "   description=\"a table partitioned by date_field\" "
                + " ) "
                + "AS "
                + "   SELECT 1, CAST(\"2019-01-01\" AS DATE)"
                + "   UNION ALL"
                + "   SELECT 2, CAST(\"2019-01-02\" AS DATE)"
                + "   UNION ALL"
                + "   SELECT 3, CAST(\"2019-01-03\" AS DATE)",
            DATASET, partitionedTableName);

    RunQueryJobAndExpectSuccess(QueryJobConfiguration.newBuilder(createTableStatement).build());

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ DATASET,
            /* tableId = */ partitionedTableName);

    List<GenericData.Record> unfilteredRows = ReadAllRows(/* table = */ table, /* filter = */ null);
    assertEquals("Actual rows read: " + unfilteredRows.toString(), 3, unfilteredRows.size());

    List<GenericData.Record> partitionFilteredRows =
        ReadAllRows(
            /* table = */ table, /* filter = */ "date_field = CAST(\"2019-01-02\" AS DATE)");
    assertEquals(
        "Actual rows read: " + partitionFilteredRows.toString(), 1, partitionFilteredRows.size());
    assertEquals(2L, partitionFilteredRows.get(0).get("num_field"));
  }

  @Test
  public void testIngestionTimePartitionedTable() throws InterruptedException, IOException {
    Field intFieldSchema =
        Field.newBuilder("num_field", LegacySQLTypeName.INTEGER)
            .setMode(Mode.REQUIRED)
            .setDescription("IntegerDescription")
            .build();
    com.google.cloud.bigquery.Schema tableSchema =
        com.google.cloud.bigquery.Schema.of(intFieldSchema);

    TableId testTableId =
        TableId.of(/* dataset = */ DATASET, /* table = */ "test_date_partitioned_table");
    bigquery.create(
        TableInfo.of(
            testTableId,
            StandardTableDefinition.newBuilder()
                .setTimePartitioning(TimePartitioning.of(TimePartitioning.Type.DAY))
                .setSchema(tableSchema)
                .build()));

    // Simulate ingestion for 2019-01-01.
    RunQueryAppendJobAndExpectSuccess(
        /* destinationTableId = */ TableId.of(
            /* dataset = */ DATASET, /* table = */ testTableId.getTable() + "$20190101"),
        /* query = */ "SELECT 1 AS num_field");

    // Simulate ingestion for 2019-01-02.
    RunQueryAppendJobAndExpectSuccess(
        /* destinationTableId = */ TableId.of(
            /* dataset = */ DATASET, /* table = */ testTableId.getTable() + "$20190102"),
        /* query = */ "SELECT 2 AS num_field");

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ testTableId.getDataset(),
            /* tableId = */ testTableId.getTable());

    List<GenericData.Record> unfilteredRows = ReadAllRows(/* table = */ table, /* filter = */ null);
    assertEquals("Actual rows read: " + unfilteredRows.toString(), 2, unfilteredRows.size());

    List<GenericData.Record> partitionFilteredRows =
        ReadAllRows(/* table = */ table, /* filter = */ "_PARTITIONDATE > \"2019-01-01\"");
    assertEquals(
        "Actual rows read: " + partitionFilteredRows.toString(), 1, partitionFilteredRows.size());
    assertEquals(2L, partitionFilteredRows.get(0).get("num_field"));
  }

  @Test
  public void testBasicSqlTypes() throws InterruptedException, IOException {
    String tableName = "test_basic_sql_types";
    String createTableStatement =
        String.format(
            " CREATE TABLE %s.%s "
                + " (int_field INT64 NOT NULL,"
                + "  num_field NUMERIC NOT NULL,"
                + "  float_field FLOAT64 NOT NULL,"
                + "  bool_field BOOL NOT NULL,"
                + "  str_field STRING NOT NULL,"
                + "  bytes_field BYTES NOT NULL) "
                + " OPTIONS( "
                + "   description=\"a table with basic column types\" "
                + " ) "
                + "AS "
                + "   SELECT "
                + "     17,"
                + "     CAST(1234.56 AS NUMERIC),"
                + "     6.547678,"
                + "     TRUE,"
                + "     \"String field value\","
                + "     b\"абвгд\"",
            DATASET, tableName);

    RunQueryJobAndExpectSuccess(QueryJobConfiguration.newBuilder(createTableStatement).build());

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ DATASET,
            /* tableId = */ tableName);

    List<GenericData.Record> rows = ReadAllRows(/* table = */ table, /* filter = */ null);
    assertEquals("Actual rows read: " + rows.toString(), 1, rows.size());

    GenericData.Record record = rows.get(0);
    Schema avroSchema = record.getSchema();

    String actualSchemaMessage =
        String.format(
            "Unexpected schema. Actual schema:%n%s", avroSchema.toString(/* pretty = */ true));
    String rowAssertMessage = String.format("Row not matching expectations: %s", record.toString());

    assertEquals(actualSchemaMessage, Schema.Type.RECORD, avroSchema.getType());
    assertEquals(actualSchemaMessage, "__root__", avroSchema.getName());
    assertEquals(actualSchemaMessage, 6, avroSchema.getFields().size());

    assertEquals(
        actualSchemaMessage, Schema.Type.LONG, avroSchema.getField("int_field").schema().getType());
    assertEquals(rowAssertMessage, 17L, (long) record.get("int_field"));

    assertEquals(
        actualSchemaMessage,
        Schema.Type.BYTES,
        avroSchema.getField("num_field").schema().getType());
    assertEquals(
        actualSchemaMessage,
        LogicalTypes.decimal(/* precision = */ 38, /* scale = */ 9),
        avroSchema.getField("num_field").schema().getLogicalType());
    BigDecimal actual_num_field =
        new Conversions.DecimalConversion()
            .fromBytes(
                (ByteBuffer) record.get("num_field"),
                avroSchema,
                avroSchema.getField("num_field").schema().getLogicalType());
    assertEquals(
        rowAssertMessage,
        BigDecimal.valueOf(/* unscaledVal = */ 1_234_560_000_000L, /* scale = */ 9),
        actual_num_field);

    assertEquals(
        actualSchemaMessage,
        Schema.Type.DOUBLE,
        avroSchema.getField("float_field").schema().getType());
    assertEquals(
        rowAssertMessage,
        /* expected = */ 6.547678d,
        /* actual = */ (double) record.get("float_field"),
        /* delta = */ 0.0001);

    assertEquals(
        actualSchemaMessage,
        Schema.Type.BOOLEAN,
        avroSchema.getField("bool_field").schema().getType());
    assertEquals(rowAssertMessage, true, record.get("bool_field"));

    assertEquals(
        actualSchemaMessage,
        Schema.Type.STRING,
        avroSchema.getField("str_field").schema().getType());
    assertEquals(rowAssertMessage, new Utf8("String field value"), record.get("str_field"));

    assertEquals(
        actualSchemaMessage,
        Schema.Type.BYTES,
        avroSchema.getField("bytes_field").schema().getType());
    assertArrayEquals(
        rowAssertMessage,
        Utf8.getBytesFor("абвгд"),
        ((ByteBuffer) (record.get("bytes_field"))).array());
  }

  @Test
  public void testDateAndTimeSqlTypes() throws InterruptedException, IOException {
    String tableName = "test_date_and_time_sql_types";
    String createTableStatement =
        String.format(
            " CREATE TABLE %s.%s "
                + " (date_field DATE NOT NULL,"
                + "  datetime_field DATETIME NOT NULL,"
                + "  time_field TIME NOT NULL,"
                + "  timestamp_field TIMESTAMP NOT NULL)"
                + " OPTIONS( "
                + "   description=\"a table with date and time column types\" "
                + " ) "
                + "AS "
                + "   SELECT "
                + "     CAST(\"2019-05-31\" AS DATE),"
                + "     CAST(\"2019-04-30 21:47:59.999999\" AS DATETIME),"
                + "     CAST(\"21:47:59.999999\" AS TIME),"
                + "     CAST(\"2019-04-30 19:24:19.123456 UTC\" AS TIMESTAMP)",
            DATASET, tableName);

    RunQueryJobAndExpectSuccess(QueryJobConfiguration.newBuilder(createTableStatement).build());

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ DATASET,
            /* tableId = */ tableName);

    List<GenericData.Record> rows = ReadAllRows(/* table = */ table, /* filter = */ null);
    assertEquals("Actual rows read: " + rows.toString(), 1, rows.size());

    GenericData.Record record = rows.get(0);
    Schema avroSchema = record.getSchema();

    String actualSchemaMessage =
        String.format(
            "Unexpected schema. Actual schema:%n%s", avroSchema.toString(/* pretty = */ true));
    String rowAssertMessage = String.format("Row not matching expectations: %s", record.toString());

    assertEquals(actualSchemaMessage, Schema.Type.RECORD, avroSchema.getType());
    assertEquals(actualSchemaMessage, "__root__", avroSchema.getName());
    assertEquals(actualSchemaMessage, 4, avroSchema.getFields().size());

    assertEquals(
        actualSchemaMessage, Schema.Type.INT, avroSchema.getField("date_field").schema().getType());
    assertEquals(
        actualSchemaMessage,
        LogicalTypes.date(),
        avroSchema.getField("date_field").schema().getLogicalType());
    assertEquals(
        rowAssertMessage,
        LocalDate.of(/* year = */ 2019, /* month = */ 5, /* dayOfMonth = */ 31),
        LocalDate.ofEpochDay((int) record.get("date_field")));

    assertEquals(
        actualSchemaMessage,
        Schema.Type.STRING,
        avroSchema.getField("datetime_field").schema().getType());
    assertEquals(
        actualSchemaMessage,
        "datetime",
        avroSchema.getField("datetime_field").schema().getObjectProp("logicalType"));
    assertEquals(
        rowAssertMessage,
        new Utf8("2019-04-30T21:47:59.999999"),
        (Utf8) record.get("datetime_field"));

    assertEquals(
        actualSchemaMessage,
        Schema.Type.LONG,
        avroSchema.getField("time_field").schema().getType());
    assertEquals(
        actualSchemaMessage,
        LogicalTypes.timeMicros(),
        avroSchema.getField("time_field").schema().getLogicalType());
    assertEquals(
        rowAssertMessage,
        LocalTime.of(
            /* hour = */ 21,
            /* minute = */ 47,
            /* second = */ 59,
            /* nanoOfSecond = */ 999_999_000),
        LocalTime.ofNanoOfDay(1_000L * (long) record.get("time_field")));

    assertEquals(
        actualSchemaMessage,
        Schema.Type.LONG,
        avroSchema.getField("timestamp_field").schema().getType());
    assertEquals(
        actualSchemaMessage,
        LogicalTypes.timestampMicros(),
        avroSchema.getField("timestamp_field").schema().getLogicalType());
    ZonedDateTime expected_timestamp =
        ZonedDateTime.parse(
                "2019-04-30T19:24:19Z", DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC))
            .withNano(123_456_000);
    long actual_timestamp_micros = (long) record.get("timestamp_field");
    ZonedDateTime actual_timestamp =
        ZonedDateTime.ofInstant(
            Instant.ofEpochSecond(
                /* epochSecond = */ actual_timestamp_micros / 1_000_000,
                (actual_timestamp_micros % 1_000_000) * 1_000),
            ZoneOffset.UTC);
    assertEquals(rowAssertMessage, expected_timestamp, actual_timestamp);
  }

  @Test
  public void testGeographySqlType() throws InterruptedException, IOException {
    String tableName = "test_geography_sql_type";
    String createTableStatement =
        String.format(
            " CREATE TABLE %s.%s "
                + " (geo_field GEOGRAPHY NOT NULL)"
                + " OPTIONS( "
                + "   description=\"a table with a geography column type\" "
                + " ) "
                + "AS "
                + "   SELECT ST_GEOGPOINT(1.1, 2.2)",
            DATASET, tableName);

    RunQueryJobAndExpectSuccess(QueryJobConfiguration.newBuilder(createTableStatement).build());

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ DATASET,
            /* tableId = */ tableName);

    List<GenericData.Record> rows = ReadAllRows(/* table = */ table, /* filter = */ null);
    assertEquals("Actual rows read: " + rows.toString(), 1, rows.size());

    GenericData.Record record = rows.get(0);
    Schema avroSchema = record.getSchema();

    String actualSchemaMessage =
        String.format(
            "Unexpected schema. Actual schema:%n%s", avroSchema.toString(/* pretty = */ true));
    String rowAssertMessage = String.format("Row not matching expectations: %s", record.toString());

    assertEquals(actualSchemaMessage, Schema.Type.RECORD, avroSchema.getType());
    assertEquals(actualSchemaMessage, "__root__", avroSchema.getName());
    assertEquals(actualSchemaMessage, 1, avroSchema.getFields().size());

    assertEquals(
        actualSchemaMessage,
        Schema.Type.STRING,
        avroSchema.getField("geo_field").schema().getType());
    assertEquals(
        actualSchemaMessage,
        "GEOGRAPHY",
        avroSchema.getField("geo_field").schema().getObjectProp("sqlType"));
    assertEquals(rowAssertMessage, new Utf8("POINT(1.1 2.2)"), (Utf8) record.get("geo_field"));
  }

  @Test
  public void testStructAndArraySqlTypes() throws InterruptedException, IOException {
    String tableName = "test_struct_and_array_sql_types";
    String createTableStatement =
        String.format(
            " CREATE TABLE %s.%s "
                + " (array_field ARRAY<INT64>,"
                + "  struct_field STRUCT<int_field INT64 NOT NULL, str_field STRING NOT NULL> NOT NULL)"
                + " OPTIONS( "
                + "   description=\"a table with array and time column types\" "
                + " ) "
                + "AS "
                + "   SELECT "
                + "     [1, 2, 3],"
                + "     (10, 'abc')",
            DATASET, tableName);

    RunQueryJobAndExpectSuccess(QueryJobConfiguration.newBuilder(createTableStatement).build());

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ ServiceOptions.getDefaultProjectId(),
            /* datasetId = */ DATASET,
            /* tableId = */ tableName);

    List<GenericData.Record> rows = ReadAllRows(/* table = */ table, /* filter = */ null);
    assertEquals("Actual rows read: " + rows.toString(), 1, rows.size());

    GenericData.Record record = rows.get(0);
    Schema avroSchema = record.getSchema();

    String actualSchemaMessage =
        String.format(
            "Unexpected schema. Actual schema:%n%s", avroSchema.toString(/* pretty = */ true));
    String rowAssertMessage = String.format("Row not matching expectations: %s", record.toString());

    assertEquals(actualSchemaMessage, Schema.Type.RECORD, avroSchema.getType());
    assertEquals(actualSchemaMessage, "__root__", avroSchema.getName());
    assertEquals(actualSchemaMessage, 2, avroSchema.getFields().size());

    assertEquals(
        actualSchemaMessage,
        Schema.Type.ARRAY,
        avroSchema.getField("array_field").schema().getType());
    assertEquals(
        actualSchemaMessage,
        Schema.Type.LONG,
        avroSchema.getField("array_field").schema().getElementType().getType());
    assertArrayEquals(
        rowAssertMessage,
        new Long[] {1L, 2L, 3L},
        ((GenericData.Array<Long>) record.get("array_field")).toArray(new Long[0]));

    // Validate the STRUCT field and its members.
    Schema structSchema = avroSchema.getField("struct_field").schema();
    assertEquals(actualSchemaMessage, Schema.Type.RECORD, structSchema.getType());
    GenericData.Record structRecord = (GenericData.Record) record.get("struct_field");

    assertEquals(
        actualSchemaMessage,
        Schema.Type.LONG,
        structSchema.getField("int_field").schema().getType());
    assertEquals(rowAssertMessage, 10L, (long) structRecord.get("int_field"));

    assertEquals(
        actualSchemaMessage,
        Schema.Type.STRING,
        structSchema.getField("str_field").schema().getType());
    assertEquals(rowAssertMessage, new Utf8("abc"), structRecord.get("str_field"));
  }

  @Test
  public void testSimpleReadWithBackgroundExecutorProvider() throws IOException {
    BigQueryReadSettings bigQueryReadSettings =
        BigQueryReadSettings.newBuilder()
            .setBackgroundExecutorProvider(
                InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(14).build())
            .build();
    // Overriding the default client
    client = BigQueryReadClient.create(bigQueryReadSettings);
    assertTrue(
        client.getStub().getStubSettings().getBackgroundExecutorProvider()
            instanceof InstantiatingExecutorProvider);
    assertEquals(
        14,
        ((InstantiatingExecutorProvider)
                client.getStub().getStubSettings().getBackgroundExecutorProvider())
            .getExecutorThreadCount());
    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    ReadSession session =
        client.createReadSession(
            /* parent = */ parentProjectId,
            /* readSession = */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.AVRO)
                .build(),
            /* maxStreamCount = */ 1);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    long rowCount = 0;
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      rowCount += response.getRowCount();
    }

    assertEquals(164_656, rowCount);
  }

  @Test
  public void testUniverseDomainWithInvalidUniverseDomain() throws IOException {
    BigQueryReadSettings bigQueryReadSettings =
        BigQueryReadSettings.newBuilder()
            .setCredentialsProvider(
                FixedCredentialsProvider.create(loadCredentials(FAKE_JSON_CRED_WITH_GOOGLE_DOMAIN)))
            .setUniverseDomain("invalid.domain")
            .build();
    BigQueryReadClient localClient = BigQueryReadClient.create(bigQueryReadSettings);

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    try {
      localClient.createReadSession(
          /* parent = */ parentProjectId,
          /* readSession = */ ReadSession.newBuilder()
              .setTable(table)
              .setDataFormat(DataFormat.AVRO)
              .build(),
          /* maxStreamCount = */ 1);
      fail("RPCs to invalid universe domain should fail");
    } catch (UnauthenticatedException e) {
      assertThat(
              (e.getMessage()
                  .contains("does not match the universe domain found in the credentials")))
          .isTrue();
    }
    localClient.close();
  }

  @Test
  public void testInvalidUniverseDomainWithMismatchCredentials() throws IOException {
    BigQueryReadSettings bigQueryReadSettings =
        BigQueryReadSettings.newBuilder()
            .setCredentialsProvider(
                FixedCredentialsProvider.create(
                    loadCredentials(FAKE_JSON_CRED_WITH_INVALID_DOMAIN)))
            .setUniverseDomain("invalid.domain")
            .build();
    BigQueryReadClient localClient = BigQueryReadClient.create(bigQueryReadSettings);

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    try {
      ReadSession session =
          localClient.createReadSession(
              /* parent = */ parentProjectId,
              /* readSession = */ ReadSession.newBuilder()
                  .setTable(table)
                  .setDataFormat(DataFormat.AVRO)
                  .build(),
              /* maxStreamCount = */ 1);
      fail("RPCs to invalid universe domain should fail");
    } catch (UnauthenticatedException e) {
      assertThat(
              (e.getMessage()
                  .contains("does not match the universe domain found in the credentials")))
          .isTrue();
    }
    localClient.close();
  }

  @Test
  public void testUniverseDomainWithMatchingDomain() throws IOException {
    // Test a valid domain using the default credentials and Google default universe domain.
    BigQueryReadSettings bigQueryReadSettings =
        BigQueryReadSettings.newBuilder().setUniverseDomain("googleapis.com").build();
    BigQueryReadClient localClient = BigQueryReadClient.create(bigQueryReadSettings);

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "bigquery-public-data",
            /* datasetId = */ "samples",
            /* tableId = */ "shakespeare");

    ReadSession session =
        localClient.createReadSession(
            /* parent = */ parentProjectId,
            /* readSession = */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.AVRO)
                .build(),
            /* maxStreamCount = */ 1);

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    long rowCount = 0;
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      rowCount += response.getRowCount();
    }

    assertEquals(164_656, rowCount);
    localClient.close();
  }

  public void testUniverseDomain() throws IOException {
    // This test is not yet part presubmit integration test as it requires the apis-tpclp.goog
    // universe domain credentials.
    // Test a valid read session in the universe domain gdutst.
    BigQueryReadSettings bigQueryReadSettings =
        BigQueryReadSettings.newBuilder().setUniverseDomain("apis-tpclp.goog").build();
    BigQueryReadClient localClient = BigQueryReadClient.create(bigQueryReadSettings);

    String table =
        BigQueryResource.FormatTableResource(
            /* projectId = */ "google-tpc-testing-environment:cloudsdk-test-project",
            /* datasetId = */ "tpc_demo_dataset",
            /* tableId = */ "new_table");

    ReadSession session =
        localClient.createReadSession(
            /* parent = */ parentProjectId,
            /* readSession = */ ReadSession.newBuilder()
                .setTable(table)
                .setDataFormat(DataFormat.AVRO)
                .build(),
            /* maxStreamCount = */ 1);

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    long rowCount = 0;
    ServerStream<ReadRowsResponse> stream = localClient.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      rowCount += response.getRowCount();
    }

    assertEquals(1, rowCount);
    localClient.close();
  }

  /**
   * Reads to the specified row offset within the stream. If the stream does not have the desired
   * rows to read, it will read all of them.
   *
   * @param readStream
   * @param rowOffset
   * @return the number of requested rows to skip or the total rows read if stream had less rows.
   */
  private long ReadStreamToOffset(ReadStream readStream, long rowOffset) {

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(readStream.getName()).build();

    long rowCount = 0;
    ServerStream<ReadRowsResponse> serverStream = client.readRowsCallable().call(readRowsRequest);
    Iterator<ReadRowsResponse> responseIterator = serverStream.iterator();

    while (responseIterator.hasNext()) {
      ReadRowsResponse response = responseIterator.next();
      rowCount += response.getRowCount();
      if (rowCount >= rowOffset) {
        return rowOffset;
      }
    }

    return rowCount;
  }

  /**
   * Reads all the rows from the specified table.
   *
   * <p>For every row, the consumer is called for processing.
   *
   * @param table
   * @param snapshotInMillis Optional. If specified, all rows up to timestamp will be returned.
   * @param filter Optional. If specified, it will be used to restrict returned data.
   * @param consumer that receives all Avro rows.
   * @throws IOException
   */
  private void ProcessRowsAtSnapshot(
      String table, Long snapshotInMillis, String filter, AvroRowConsumer consumer)
      throws IOException {
    Preconditions.checkNotNull(table);
    Preconditions.checkNotNull(consumer);

    CreateReadSessionRequest.Builder createSessionRequestBuilder =
        CreateReadSessionRequest.newBuilder()
            .setParent(parentProjectId)
            .setMaxStreamCount(1)
            .setReadSession(
                ReadSession.newBuilder().setTable(table).setDataFormat(DataFormat.AVRO).build());

    if (snapshotInMillis != null) {
      Timestamp snapshotTimestamp =
          Timestamp.newBuilder()
              .setSeconds(snapshotInMillis / 1_000)
              .setNanos((int) ((snapshotInMillis % 1000) * 1000000))
              .build();
      createSessionRequestBuilder
          .getReadSessionBuilder()
          .setTableModifiers(
              TableModifiers.newBuilder().setSnapshotTime(snapshotTimestamp).build());
    }

    if (filter != null && !filter.isEmpty()) {
      createSessionRequestBuilder
          .getReadSessionBuilder()
          .setReadOptions(TableReadOptions.newBuilder().setRowRestriction(filter).build());
    }

    ReadSession session = client.createReadSession(createSessionRequestBuilder.build());
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    SimpleRowReader reader =
        new SimpleRowReader(new Schema.Parser().parse(session.getAvroSchema().getSchema()));

    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      reader.processRows(response.getAvroRows(), consumer);
    }
  }

  /**
   * Reads all the rows from the specified table and returns a list as generic Avro records.
   *
   * @param table
   * @param filter Optional. If specified, it will be used to restrict returned data.
   * @return
   */
  List<GenericData.Record> ReadAllRows(String table, String filter) throws IOException {
    final List<GenericData.Record> rows = new ArrayList<>();
    ProcessRowsAtSnapshot(
        /* table = */ table,
        /* snapshotInMillis = */ null,
        /* filter = */ filter,
        new AvroRowConsumer() {
          @Override
          public void accept(GenericData.Record record) {
            // clone the record since that reference will be reused by the reader.
            rows.add(new GenericRecordBuilder(record).build());
          }
        });
    return rows;
  }

  /**
   * Runs a query job with WRITE_APPEND disposition to the destination table and returns the
   * successfully completed job.
   *
   * @param destinationTableId
   * @param query
   * @return
   * @throws InterruptedException
   */
  private Job RunQueryAppendJobAndExpectSuccess(TableId destinationTableId, String query)
      throws InterruptedException {
    return RunQueryJobAndExpectSuccess(
        QueryJobConfiguration.newBuilder(query)
            .setDestinationTable(destinationTableId)
            .setUseQueryCache(false)
            .setUseLegacySql(false)
            .setWriteDisposition(WriteDisposition.WRITE_APPEND)
            .build());
  }

  /**
   * Runs a query job with provided configuration and returns the successfully completed job.
   *
   * @param configuration
   * @return
   * @throws InterruptedException
   */
  private Job RunQueryJobAndExpectSuccess(QueryJobConfiguration configuration)
      throws InterruptedException {
    Job job = bigquery.create(JobInfo.of(configuration));
    Job completedJob =
        job.waitFor(
            RetryOption.initialRetryDelay(Duration.ofSeconds(1)),
            RetryOption.totalTimeout(Duration.ofMinutes(1)));

    assertNotNull(completedJob);
    assertNull(
        /* message = */ "Received a job status that is not a success: "
            + completedJob.getStatus().toString(),
        /* object = */ completedJob.getStatus().getError());

    return completedJob;
  }

  static GoogleCredentials loadCredentials(String credentialFile) {
    try {
      InputStream keyStream = new ByteArrayInputStream(credentialFile.getBytes());
      return GoogleCredentials.fromStream(keyStream);
    } catch (IOException e) {
      fail("Couldn't create fake JSON credentials.");
    }
    return null;
  }
}
