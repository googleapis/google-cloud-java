/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.bigquery.storage.v1beta1.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.RetryOption;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
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
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;
import com.google.cloud.bigquery.storage.v1beta1.ReadOptions.TableReadOptions;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.DataFormat;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.Stream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableModifiers;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableReference;
import com.google.cloud.bigquery.storage.v1beta1.it.SimpleRowReader.AvroRowConsumer;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.base.Preconditions;
import com.google.protobuf.TextFormat;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.util.Utf8;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;

/** Integration tests for BigQuery Storage API. */
public class ITBigQueryStorageTest {

  private static final Logger LOG = Logger.getLogger(ITBigQueryStorageTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String DESCRIPTION = "BigQuery Storage Java client test dataset";

  private static BigQueryStorageClient client;
  private static String parentProjectId;
  private static BigQuery bigquery;

  @BeforeClass
  public static void beforeClass() throws IOException {
    client = BigQueryStorageClient.create();
    parentProjectId = String.format("projects/%s", ServiceOptions.getDefaultProjectId());

    LOG.info(
        String.format(
            "%s tests running with parent project: %s",
            ITBigQueryStorageTest.class.getSimpleName(), parentProjectId));

    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    DatasetInfo datasetInfo =
        DatasetInfo.newBuilder(/* datasetId = */ DATASET).setDescription(DESCRIPTION).build();
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
  public void testSimpleRead() {
    TableReference tableReference =
        TableReference.newBuilder()
            .setProjectId("bigquery-public-data")
            .setDatasetId("samples")
            .setTableId("shakespeare")
            .build();

    ReadSession session =
        client.createReadSession(
            /* tableReference = */ tableReference,
            /* parent = */ parentProjectId,
            /* requestedStreams = */ 1);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table reference '%s' CreateReadSession response:%n%s",
            TextFormat.shortDebugString(tableReference), session.toString()),
        1,
        session.getStreamsCount());

    StreamPosition readPosition =
        StreamPosition.newBuilder().setStream(session.getStreams(0)).build();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    long avroRowCount = 0;
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      assertTrue(
          String.format(
              "Response is missing 'avro_rows'. Read %d rows so far. ReadRows response:%n%s",
              avroRowCount, response.toString()),
          response.hasAvroRows());
      avroRowCount += response.getAvroRows().getRowCount();
    }

    assertEquals(164_656, avroRowCount);
  }

  @Test
  public void testSimpleReadAndResume() {
    TableReference tableReference =
        TableReference.newBuilder()
            .setProjectId("bigquery-public-data")
            .setDatasetId("samples")
            .setTableId("shakespeare")
            .build();

    ReadSession session =
        client.createReadSession(
            /* tableReference = */ tableReference,
            /* parent = */ parentProjectId,
            /* requestedStreams = */ 1);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table reference '%s' CreateReadSession response:%n%s",
            TextFormat.shortDebugString(tableReference), session.toString()),
        1,
        session.getStreamsCount());

    // We have to read some number of rows in order to be able to resume. More details:
    // https://cloud.google.com/bigquery/docs/reference/storage/rpc/google.cloud.bigquery.storage.v1beta1#google.cloud.bigquery.storage.v1beta1.ReadRowsRequest

    long avroRowCount = ReadStreamToOffset(session.getStreams(0), /* rowOffset = */ 34_846);

    StreamPosition readPosition =
        StreamPosition.newBuilder()
            .setStream(session.getStreams(0))
            .setOffset(avroRowCount)
            .build();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);

    for (ReadRowsResponse response : stream) {
      assertTrue(
          String.format(
              "Response is missing 'avro_rows'. Read %d rows so far. ReadRows response:%n%s",
              avroRowCount, response.toString()),
          response.hasAvroRows());
      avroRowCount += response.getAvroRows().getRowCount();
    }

    // Verifies that the number of rows skipped and read equals to the total number of rows in the
    // table.
    assertEquals(164_656, avroRowCount);
  }

  @Test
  public void testFilter() throws IOException {
    TableReference tableReference =
        TableReference.newBuilder()
            .setProjectId("bigquery-public-data")
            .setDatasetId("samples")
            .setTableId("shakespeare")
            .build();

    TableReadOptions options =
        TableReadOptions.newBuilder().setRowRestriction("word_count > 100").build();

    CreateReadSessionRequest request =
        CreateReadSessionRequest.newBuilder()
            .setParent(parentProjectId)
            .setRequestedStreams(1)
            .setTableReference(tableReference)
            .setReadOptions(options)
            .setFormat(DataFormat.AVRO)
            .build();

    ReadSession session = client.createReadSession(request);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table reference '%s' CreateReadSession response:%n%s",
            TextFormat.shortDebugString(tableReference), session.toString()),
        1,
        session.getStreamsCount());

    StreamPosition readPosition =
        StreamPosition.newBuilder().setStream(session.getStreams(0)).build();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    SimpleRowReader reader =
        new SimpleRowReader(new Schema.Parser().parse(session.getAvroSchema().getSchema()));

    long avroRowCount = 0;

    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      assertTrue(
          String.format(
              "Response is missing 'avro_rows'. Read %d rows so far. ReadRows response:%n%s",
              avroRowCount, response.toString()),
          response.hasAvroRows());
      avroRowCount += response.getAvroRows().getRowCount();

      reader.processRows(
          response.getAvroRows(),
          new SimpleRowReader.AvroRowConsumer() {
            @Override
            public void accept(GenericRecord record) {
              Long wordCount = (Long) record.get("word_count");
              assertWithMessage("Row not matching expectations: %s", record.toString())
                  .that(wordCount)
                  .isGreaterThan(100L);
            }
          });
    }

    assertEquals(1_333, avroRowCount);
  }

  @Test
  public void testColumnSelection() throws IOException {
    TableReference tableReference =
        TableReference.newBuilder()
            .setProjectId("bigquery-public-data")
            .setDatasetId("samples")
            .setTableId("shakespeare")
            .build();

    TableReadOptions options =
        TableReadOptions.newBuilder()
            .addSelectedFields("word")
            .addSelectedFields("word_count")
            .setRowRestriction("word_count > 100")
            .build();

    CreateReadSessionRequest request =
        CreateReadSessionRequest.newBuilder()
            .setParent(parentProjectId)
            .setRequestedStreams(1)
            .setTableReference(tableReference)
            .setReadOptions(options)
            .setFormat(DataFormat.AVRO)
            .build();

    ReadSession session = client.createReadSession(request);
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table reference '%s' CreateReadSession response:%n%s",
            TextFormat.shortDebugString(tableReference), session.toString()),
        1,
        session.getStreamsCount());

    StreamPosition readPosition =
        StreamPosition.newBuilder().setStream(session.getStreams(0)).build();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

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

    long avroRowCount = 0;
    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      assertTrue(
          String.format(
              "Response is missing 'avro_rows'. Read %d rows so far. ReadRows response:%n%s",
              avroRowCount, response.toString()),
          response.hasAvroRows());
      avroRowCount += response.getAvroRows().getRowCount();
      reader.processRows(
          response.getAvroRows(),
          new SimpleRowReader.AvroRowConsumer() {
            @Override
            public void accept(GenericRecord record) {
              String rowAssertMessage =
                  String.format("Row not matching expectations: %s", record.toString());

              Long wordCount = (Long) record.get("word_count");
              assertWithMessage(rowAssertMessage).that(wordCount).isGreaterThan(100L);

              Utf8 word = (Utf8) record.get("word");
              assertWithMessage(rowAssertMessage).that(word.length()).isGreaterThan(0);
            }
          });
    }

    assertEquals(1_333, avroRowCount);
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

    TableReference tableReference =
        TableReference.newBuilder()
            .setTableId(testTableId.getTable())
            .setDatasetId(DATASET)
            .setProjectId(ServiceOptions.getDefaultProjectId())
            .build();

    Job firstJob =
        RunQueryJobAndExpectSuccess(
            /* destinationTableId = */ testTableId, /* query = */ "SELECT 1 AS col");

    Job secondJob =
        RunQueryJobAndExpectSuccess(
            /* destinationTableId = */ testTableId, /* query = */ "SELECT 2 AS col");

    final List<Long> rowsAfterFirstSnapshot = new ArrayList<>();
    ProcessRowsAtSnapshot(
        tableReference,
        firstJob.getStatistics().getEndTime(),
        new AvroRowConsumer() {
          @Override
          public void accept(GenericRecord record) {
            rowsAfterFirstSnapshot.add((Long) record.get("col"));
          }
        });
    assertEquals(Arrays.asList(1L), rowsAfterFirstSnapshot);

    final List<Long> rowsAfterSecondSnapshot = new ArrayList<>();
    ProcessRowsAtSnapshot(
        tableReference,
        secondJob.getStatistics().getEndTime(),
        new AvroRowConsumer() {
          @Override
          public void accept(GenericRecord record) {
            rowsAfterSecondSnapshot.add((Long) record.get("col"));
          }
        });
    Collections.sort(rowsAfterSecondSnapshot);
    assertEquals(Arrays.asList(1L, 2L), rowsAfterSecondSnapshot);
  }

  /**
   * Reads to the specified row offset within the stream. If the stream does not have the desired
   * rows to read, it will read all of them.
   *
   * @param stream
   * @param rowOffset
   * @return the number of requested rows to skip or the total rows read if stream had less rows.
   */
  private long ReadStreamToOffset(Stream stream, long rowOffset) {
    StreamPosition readPosition = StreamPosition.newBuilder().setStream(stream).build();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    long avroRowCount = 0;
    ServerStream<ReadRowsResponse> serverStream = client.readRowsCallable().call(readRowsRequest);
    Iterator<ReadRowsResponse> responseIterator = serverStream.iterator();

    while (responseIterator.hasNext()) {
      ReadRowsResponse response = responseIterator.next();
      avroRowCount += response.getAvroRows().getRowCount();
      if (avroRowCount >= rowOffset) {
        return rowOffset;
      }
    }

    return avroRowCount;
  }

  /**
   * Reads all the rows from the specified tableReference that are added up to timestamp defined in
   * snapshot. If snapshot is not provided, current time will be used.
   *
   * <p>For every row, the consumer is called for processing.
   *
   * @param tableReference
   * @param snapshotInMillis
   * @param consumer
   * @throws IOException
   */
  private void ProcessRowsAtSnapshot(
      TableReference tableReference, Long snapshotInMillis, AvroRowConsumer consumer)
      throws IOException {
    Preconditions.checkNotNull(tableReference);
    Preconditions.checkNotNull(consumer);

    CreateReadSessionRequest.Builder createSessionRequestBuilder =
        CreateReadSessionRequest.newBuilder()
            .setParent(parentProjectId)
            .setRequestedStreams(1)
            .setTableReference(tableReference)
            .setFormat(DataFormat.AVRO);

    if (snapshotInMillis != null) {
      Timestamp snapshotTimestamp =
          Timestamp.newBuilder()
              .setSeconds(snapshotInMillis / 1_000)
              .setNanos((int) ((snapshotInMillis % 1000) * 1000000))
              .build();
      createSessionRequestBuilder.setTableModifiers(
          TableModifiers.newBuilder().setSnapshotTime(snapshotTimestamp).build());
    }

    ReadSession session = client.createReadSession(createSessionRequestBuilder.build());
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table reference '%s' CreateReadSession response:%n%s",
            TextFormat.shortDebugString(tableReference), session.toString()),
        1,
        session.getStreamsCount());

    StreamPosition readPosition =
        StreamPosition.newBuilder().setStream(session.getStreams(0)).build();

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    SimpleRowReader reader =
        new SimpleRowReader(new Schema.Parser().parse(session.getAvroSchema().getSchema()));

    ServerStream<ReadRowsResponse> stream = client.readRowsCallable().call(readRowsRequest);
    for (ReadRowsResponse response : stream) {
      reader.processRows(response.getAvroRows(), consumer);
    }
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
  private Job RunQueryJobAndExpectSuccess(TableId destinationTableId, String query)
      throws InterruptedException {
    QueryJobConfiguration configuration =
        QueryJobConfiguration.newBuilder(query)
            .setDestinationTable(destinationTableId)
            .setUseQueryCache(false)
            .setUseLegacySql(false)
            .setWriteDisposition(WriteDisposition.WRITE_APPEND)
            .build();

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
}
