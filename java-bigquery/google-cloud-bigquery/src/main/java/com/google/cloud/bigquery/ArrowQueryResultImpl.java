/*
 * Copyright 2026 Google LLC
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

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.Schema;
import org.apache.arrow.vector.util.ByteArrayReadableSeekableByteChannel;

/**
 * Implementation of {@link ArrowQueryResult} that provides zero-copy streaming of Apache Arrow
 * {@link VectorSchemaRoot} batches across initial REST response and subsequent gRPC stream.
 */
class ArrowQueryResultImpl implements ArrowQueryResult {

  private final Schema arrowSchema;
  private final JobId jobId;
  private final String queryId;
  private final JobCreationReason jobCreationReason;
  private final long totalRows;
  private final byte[] initialRecordBatchBytes;
  private final String streamName;
  private final BigQueryReadClient readClient;

  private final BufferAllocator allocator;
  private final VectorSchemaRoot root;
  private final VectorLoader loader;

  private final Object lock = new Object();
  private boolean closed = false;
  private boolean iteratorCreated = false;
  private ServerStream<ReadRowsResponse> serverStream;

  ArrowQueryResultImpl(
      Schema arrowSchema,
      JobId jobId,
      String queryId,
      JobCreationReason jobCreationReason,
      long totalRows,
      byte[] initialRecordBatchBytes,
      String streamName,
      BigQueryReadClient readClient) {
    this.arrowSchema = arrowSchema;
    this.jobId = jobId;
    this.queryId = queryId;
    this.jobCreationReason = jobCreationReason;
    this.totalRows = totalRows;
    this.initialRecordBatchBytes = initialRecordBatchBytes;
    this.streamName = streamName;
    this.readClient = readClient;

    if (this.arrowSchema != null) {
      this.allocator = ArrowDeserializer.createChildAllocator("ArrowQueryResult");
      this.root = VectorSchemaRoot.create(this.arrowSchema, this.allocator);
      this.loader = new VectorLoader(this.root);
    } else {
      this.allocator = null;
      this.root = null;
      this.loader = null;
    }
  }

  static ArrowQueryResultImpl fromReadSession(
      ReadSession readSession, JobId jobId, BigQueryReadClient readClient) {
    Schema pojoSchema = null;
    if (readSession.hasArrowSchema()) {
      try {
        pojoSchema =
            ArrowDeserializer.deserializeSchema(
                readSession.getArrowSchema().getSerializedSchema().toByteArray());
      } catch (IOException e) {
        throw new BigQueryException(0, "Failed to deserialize Arrow schema from ReadSession", e);
      }
    }
    String streamName =
        readSession.getStreamsCount() > 0 ? readSession.getStreams(0).getName() : null;
    return new ArrowQueryResultImpl(
        pojoSchema,
        jobId,
        /* queryId= */ null,
        /* jobCreationReason= */ null,
        /* totalRows= */ -1L,
        /* initialRecordBatchBytes= */ null,
        streamName,
        readClient);
  }

  @Override
  public Schema getArrowSchema() {
    return arrowSchema;
  }

  @Override
  public JobId getJobId() {
    return jobId;
  }

  @Override
  public String getQueryId() {
    return queryId;
  }

  @Override
  public JobCreationReason getJobCreationReason() {
    return jobCreationReason;
  }

  @Override
  public long getTotalRows() {
    return totalRows;
  }

  @Override
  public Iterator<VectorSchemaRoot> iterator() {
    synchronized (lock) {
      checkNotClosed();
      if (iteratorCreated) {
        throw new IllegalStateException("ArrowQueryResult can only be iterated once");
      }
      iteratorCreated = true;
      return new VectorBatchIterator();
    }
  }

  @Override
  public void close() {
    synchronized (lock) {
      if (closed) {
        return;
      }
      closed = true;
      Throwable firstException = null;

      if (serverStream != null) {
        try {
          serverStream.cancel();
        } catch (Throwable t) {
          firstException = t;
        }
      }
      if (root != null) {
        try {
          root.close();
        } catch (Throwable t) {
          if (firstException == null) {
            firstException = t;
          } else {
            firstException.addSuppressed(t);
          }
        }
      }
      if (allocator != null) {
        try {
          allocator.close();
        } catch (Throwable t) {
          if (firstException == null) {
            firstException = t;
          } else {
            firstException.addSuppressed(t);
          }
        }
      }
      if (firstException instanceof RuntimeException) {
        throw (RuntimeException) firstException;
      } else if (firstException instanceof Error) {
        throw (Error) firstException;
      } else if (firstException != null) {
        throw new RuntimeException("Failed to close Arrow resources", firstException);
      }
    }
  }

  private void checkNotClosed() {
    if (closed) {
      throw new IllegalStateException("ArrowQueryResult has already been closed");
    }
  }

  private final class VectorBatchIterator implements Iterator<VectorSchemaRoot> {
    private boolean yieldedInitialBatch = false;
    private Iterator<ReadRowsResponse> streamIterator = null;
    private boolean streamInitialized = false;
    private long totalRowsYielded = 0;

    @Override
    public boolean hasNext() {
      synchronized (lock) {
        if (closed) {
          return false;
        }
        if (!yieldedInitialBatch
            && initialRecordBatchBytes != null
            && initialRecordBatchBytes.length > 0) {
          return true;
        }
        try {
          ensureStreamInitialized();
          if (streamIterator == null) {
            return false;
          }
          return streamIterator.hasNext();
        } catch (Exception e) {
          throw new BigQueryException(0, "Error reading from Arrow stream", e);
        }
      }
    }

    @Override
    public VectorSchemaRoot next() {
      synchronized (lock) {
        checkNotClosed();

        // 1. Yield initial batch from REST response if present
        if (!yieldedInitialBatch
            && initialRecordBatchBytes != null
            && initialRecordBatchBytes.length > 0) {
          yieldedInitialBatch = true;
          try {
            loadBatch(initialRecordBatchBytes);
            totalRowsYielded += root.getRowCount();
            return root;
          } catch (IOException e) {
            throw new BigQueryException(0, "Failed to load initial Arrow record batch", e);
          }
        }
        yieldedInitialBatch = true;

        // 2. Stream subsequent batches from gRPC
        try {
          ensureStreamInitialized();
          if (streamIterator == null || !streamIterator.hasNext()) {
            throw new NoSuchElementException("No more Arrow batches available in query stream.");
          }

          while (streamIterator.hasNext()) {
            ReadRowsResponse response = streamIterator.next();
            if (response.hasArrowRecordBatch()) {
              com.google.cloud.bigquery.storage.v1.ArrowRecordBatch batch =
                  response.getArrowRecordBatch();
              try {
                loadBatch(batch.getSerializedRecordBatch());
                totalRowsYielded += root.getRowCount();
                return root;
              } catch (IOException e) {
                throw new BigQueryException(0, "Failed to load streaming Arrow record batch", e);
              }
            }
          }
          throw new NoSuchElementException("No more Arrow batches available in query stream.");
        } catch (NoSuchElementException | BigQueryException e) {
          throw e;
        } catch (Exception e) {
          throw new BigQueryException(0, "Error reading from Arrow stream", e);
        }
      }
    }

    private void ensureStreamInitialized() {
      if (streamInitialized) {
        return;
      }
      streamInitialized = true;
      if (totalRows >= 0 && totalRowsYielded >= totalRows && yieldedInitialBatch) {
        return;
      }
      if (streamName == null || readClient == null) {
        if (totalRows > 0 && totalRowsYielded < totalRows) {
          throw new BigQueryException(
              0,
              "Cannot stream query results: stream name or read client is missing, "
                  + "but there are more rows to read (totalRows="
                  + totalRows
                  + ", yielded="
                  + totalRowsYielded
                  + ")");
        }
        return;
      }
      ReadRowsRequest request =
          ReadRowsRequest.newBuilder()
              .setReadStream(streamName)
              .setOffset(totalRowsYielded)
              .build();
      serverStream = readClient.readRowsCallable().call(request);
      streamIterator = serverStream.iterator();
    }

    private void loadBatch(byte[] bytes) throws IOException {
      try (ByteArrayReadableSeekableByteChannel byteChannel =
              new ByteArrayReadableSeekableByteChannel(bytes);
          ReadChannel readChannel = new ReadChannel(byteChannel);
          ArrowRecordBatch deserializedBatch =
              MessageSerializer.deserializeRecordBatch(readChannel, allocator)) {
        if (deserializedBatch != null) {
          loader.load(deserializedBatch);
        }
      }
    }

    private void loadBatch(com.google.protobuf.ByteString byteString) throws IOException {
      try (java.nio.channels.ReadableByteChannel channel =
              java.nio.channels.Channels.newChannel(byteString.newInput());
          ReadChannel readChannel = new ReadChannel(channel);
          ArrowRecordBatch deserializedBatch =
              MessageSerializer.deserializeRecordBatch(readChannel, allocator)) {
        if (deserializedBatch != null) {
          loader.load(deserializedBatch);
        }
      }
    }
  }
}
