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
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;
import com.google.cloud.bigquery.storage.v1beta1.ReadOptions.TableReadOptions;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.DataFormat;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableReference;
import com.google.protobuf.TextFormat;
import java.io.IOException;
import java.util.logging.Logger;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.util.Utf8;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for BigQuery Storage API. */
public class ITBigQueryStorageTest {

  private static final Logger LOG = Logger.getLogger(ITBigQueryStorageTest.class.getName());

  private static BigQueryStorageClient client;
  private static String parentProjectId;

  @BeforeClass
  public static void beforeClass() throws IOException {
    client = BigQueryStorageClient.create();
    parentProjectId = String.format("projects/%s", ServiceOptions.getDefaultProjectId());

    LOG.info(
        String.format(
            "%s tests running with parent project: %s",
            ITBigQueryStorageTest.class.getSimpleName(), parentProjectId));
  }

  @AfterClass
  public static void afterClass() {
    if (client != null) {
      client.close();
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

    ReadSession session = client.createReadSession(tableReference, parentProjectId, 1);
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
}
