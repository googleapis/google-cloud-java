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
package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.core.*;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.bigquery.storage.v1alpha2.ProtoBufProto.ProtoRows;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsRequest;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Writer that can help user to write data to BigQuery. This is a simplified version of the Write
 * API. For users writing with COMMITTED stream and don't care about row deduplication, it is
 * recommended to use this Writer.
 *
 * <pre>{@code
 * DataProto data;
 * ApiFuture<Long> response = DirectWriter.<DataProto>append("projects/pid/datasets/did/tables/tid", Arrays.asList(data1));
 * }</pre>
 *
 * <p>{@link DirectWriter} will use the credentials set on the channel, which uses application
 * default credentials through {@link GoogleCredentials#getApplicationDefault} by default.
 */
public class DirectWriter {
  private static final Logger LOG = Logger.getLogger(DirectWriter.class.getName());
  private static WriterCache cache = null;
  private static Lock cacheLock = new ReentrantLock();

  /**
   * Append rows to the given table.
   *
   * @param tableName table name in the form of "projects/{pName}/datasets/{dName}/tables/{tName}"
   * @param protoRows rows in proto buffer format.
   * @return A future that contains the offset at which the append happened. Only when the future
   *     returns with valid offset, then the append actually happened.
   * @throws IOException, InterruptedException, InvalidArgumentException
   */
  public static <T extends Message> ApiFuture<Long> append(String tableName, List<T> protoRows)
      throws IOException, InterruptedException, InvalidArgumentException {
    if (protoRows.isEmpty()) {
      throw new InvalidArgumentException(
          new Exception("Empty rows are not allowed"),
          GrpcStatusCode.of(Status.Code.INVALID_ARGUMENT),
          false);
    }
    try {
      cacheLock.lock();
      if (cache == null) {
        cache = WriterCache.getInstance();
      }
    } finally {
      cacheLock.unlock();
    }

    StreamWriter writer = cache.getTableWriter(tableName, protoRows.get(0).getDescriptorForType());
    ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
    Descriptors.Descriptor descriptor = null;
    for (Message protoRow : protoRows) {
      rowsBuilder.addSerializedRows(protoRow.toByteString());
    }

    AppendRowsRequest.ProtoData.Builder data = AppendRowsRequest.ProtoData.newBuilder();
    data.setWriterSchema(ProtoSchemaConverter.convert(protoRows.get(0).getDescriptorForType()));
    data.setRows(rowsBuilder.build());

    return ApiFutures.<Storage.AppendRowsResponse, Long>transform(
        writer.append(AppendRowsRequest.newBuilder().setProtoRows(data.build()).build()),
        new ApiFunction<Storage.AppendRowsResponse, Long>() {
          @Override
          public Long apply(Storage.AppendRowsResponse appendRowsResponse) {
            return Long.valueOf(appendRowsResponse.getOffset());
          }
        },
        MoreExecutors.directExecutor());
  }

  @VisibleForTesting
  public static void testSetStub(
      BigQueryWriteClient stub, int maxTableEntry, SchemaCompact schemaCheck) {
    cache = WriterCache.getTestInstance(stub, maxTableEntry, schemaCheck);
  }
}
