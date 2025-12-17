/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigquery.storage.v1.it.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFutureCallback;
import com.google.api.gax.rpc.ServerStream;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.DataFormat;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.common.base.Preconditions;
import com.google.protobuf.util.Timestamps;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecordBuilder;

public class Helper {

  public static final Long[] INPUT_TIMESTAMPS_MICROS =
      new Long[] {
        1735734896123456L, // 2025-01-01T12:34:56.123456Z
        1580646896123456L, // 2020-02-02T12:34:56.123456Z
        636467696123456L, // 1990-03-03T12:34:56.123456Z
        165846896123456L // 1975-04-04T12:34:56.123456Z
      };

  public static final Long[] EXPECTED_TIMESTAMPS_MICROS =
      new Long[] {
        1735734896123456L, // 2025-01-01T12:34:56.123456Z
        1580646896123456L, // 2020-02-02T12:34:56.123456Z
        636467696123456L, // 1990-03-03T12:34:56.123456Z
        165846896123456L // 1975-04-04T12:34:56.123456Z
      };

  public static ServiceAccountCredentials loadCredentials(String credentialFile) {
    try (InputStream keyStream = new ByteArrayInputStream(credentialFile.getBytes())) {
      return ServiceAccountCredentials.fromStream(keyStream);
    } catch (IOException e) {
      fail("Couldn't create fake JSON credentials.");
    }
    return null;
  }

  public static class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {
    private final Object lock = new Object();
    private int batchCount = 0;

    public void onSuccess(AppendRowsResponse response) {
      synchronized (lock) {
        if (response.hasError()) {
          System.out.format("Error: %s\n", response.getError());
        } else {
          ++batchCount;
          System.out.format("Wrote batch %d\n", batchCount);
        }
      }
    }

    public void onFailure(Throwable throwable) {
      System.out.format("Error: %s\n", throwable.toString());
    }
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
  public static void processRowsAtSnapshot(
      BigQueryReadClient client,
      String parentProjectId,
      String table,
      Long snapshotInMillis,
      String filter,
      SimpleRowReaderAvro.AvroRowConsumer consumer)
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
      createSessionRequestBuilder
          .getReadSessionBuilder()
          .setTableModifiers(
              ReadSession.TableModifiers.newBuilder()
                  .setSnapshotTime(Timestamps.fromMillis(snapshotInMillis))
                  .build());
    }

    if (filter != null && !filter.isEmpty()) {
      createSessionRequestBuilder
          .getReadSessionBuilder()
          .setReadOptions(
              ReadSession.TableReadOptions.newBuilder().setRowRestriction(filter).build());
    }

    ReadSession session = client.createReadSession(createSessionRequestBuilder.build());
    assertEquals(
        String.format(
            "Did not receive expected number of streams for table '%s' CreateReadSession"
                + " response:%n%s",
            table, session.toString()),
        1,
        session.getStreamsCount());

    ReadRowsRequest readRowsRequest =
        ReadRowsRequest.newBuilder().setReadStream(session.getStreams(0).getName()).build();

    SimpleRowReaderAvro reader =
        new SimpleRowReaderAvro(new Schema.Parser().parse(session.getAvroSchema().getSchema()));

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
  public static List<GenericData.Record> readAllRows(
      BigQueryReadClient client, String parentProjectId, String table, String filter)
      throws IOException {
    final List<GenericData.Record> rows = new ArrayList<>();
    processRowsAtSnapshot(
        client,
        parentProjectId,
        /* table= */ table,
        /* snapshotInMillis= */ null,
        /* filter= */ filter,
        (SimpleRowReaderAvro.AvroRowConsumer)
            record -> {
              // clone the record since that reference will be reused by the reader.
              rows.add(new GenericRecordBuilder(record).build());
            });
    return rows;
  }
}
