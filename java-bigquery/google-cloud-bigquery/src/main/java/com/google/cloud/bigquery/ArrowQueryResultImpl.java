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
import java.util.concurrent.locks.ReentrantLock;
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
  private ArrowRecordBatch currentRecordBatch;

  private final ReentrantLock lock = new ReentrantLock();
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
      BufferAllocator alloc = null;
      VectorSchemaRoot vRoot = null;
      try {
        alloc = ArrowDeserializer.createChildAllocator("ArrowQueryResult");
        vRoot = VectorSchemaRoot.create(this.arrowSchema, alloc);
        this.loader = new VectorLoader(vRoot);
        this.allocator = alloc;
        this.root = vRoot;
      } catch (Throwable t) {
        if (vRoot != null) {
          try {
            vRoot.close();
          } catch (Throwable suppressed) {
            t.addSuppressed(suppressed);
          }
        }
        if (alloc != null) {
          try {
            alloc.close();
          } catch (Throwable suppressed) {
            t.addSuppressed(suppressed);
          }
        }
        throw t;
      }
    } else {
      if ((initialRecordBatchBytes != null && initialRecordBatchBytes.length > 0)
          || streamName != null) {
        throw new IllegalArgumentException(
            "Arrow schema cannot be null when query results or streams are present.");
      }
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

    String streamName = null;
    if (readSession.getStreamsCount() > 0) {
      streamName = readSession.getStreams(0).getName();
    }

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
    lock.lock();
    try {
      checkNotClosed();
      if (iteratorCreated) {
        throw new IllegalStateException("ArrowQueryResult can only be iterated once");
      }
      iteratorCreated = true;
      return new VectorBatchIterator();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void close() {
    lock.lock();
    try {
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
      if (currentRecordBatch != null) {
        try {
          currentRecordBatch.close();
          currentRecordBatch = null;
        } catch (Throwable t) {
          if (firstException == null) {
            firstException = t;
          } else {
            firstException.addSuppressed(t);
          }
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
    } finally {
      lock.unlock();
    }
  }

  private void checkNotClosed() {
    if (closed) {
      throw new IllegalStateException("ArrowQueryResult has already been closed");
    }
  }

  void loadBatch(ArrowRecordBatch newBatch) {
    lock.lock();
    try {
      checkNotClosed();
      if (currentRecordBatch != null) {
        currentRecordBatch.close();
      }
      currentRecordBatch = newBatch;
      loader.load(currentRecordBatch);
    } finally {
      lock.unlock();
    }
  }

  private final class VectorBatchIterator implements Iterator<VectorSchemaRoot> {
    private boolean yieldedInitialBatch = false;
    private Iterator<ReadRowsResponse> streamIterator = null;
    private boolean streamInitialized = false;
    private long totalRowsYielded = 0;

    private ReadRowsResponse peekedResponse = null;

    private boolean isClosed() {
      lock.lock();
      try {
        return closed;
      } finally {
        lock.unlock();
      }
    }

    private boolean hasInitialBatchToYield() {
      lock.lock();
      try {
        return !yieldedInitialBatch
            && initialRecordBatchBytes != null
            && initialRecordBatchBytes.length > 0;
      } finally {
        lock.unlock();
      }
    }

    private Iterator<ReadRowsResponse> getStreamIterator() {
      lock.lock();
      try {
        return streamIterator;
      } finally {
        lock.unlock();
      }
    }

    @Override
    public boolean hasNext() {
      if (isClosed()) {
        return false;
      }
      if (hasInitialBatchToYield()) {
        return true;
      }
      if (peekedResponse != null) {
        return true;
      }
      try {
        ensureStreamInitialized();
        Iterator<ReadRowsResponse> iterator = getStreamIterator();
        if (iterator == null) {
          return false;
        }
        while (iterator.hasNext()) {
          ReadRowsResponse response = iterator.next();
          if (response.hasArrowRecordBatch()) {
            peekedResponse = response;
            return true;
          }
        }
        return false;
      } catch (Exception e) {
        if (isClosed()) {
          return false;
        }
        throw new BigQueryException(0, "Error reading from Arrow stream", e);
      }
    }

    @Override
    public VectorSchemaRoot next() {
      if (isClosed()) {
        throw new NoSuchElementException("ArrowQueryResult has already been closed");
      }

      // 1. Yield initial batch from REST response if present
      byte[] initialBytes = null;
      lock.lock();
      try {
        if (!yieldedInitialBatch
            && initialRecordBatchBytes != null
            && initialRecordBatchBytes.length > 0) {
          yieldedInitialBatch = true;
          initialBytes = initialRecordBatchBytes;
        } else {
          yieldedInitialBatch = true;
        }
      } finally {
        lock.unlock();
      }

      if (initialBytes != null) {
        try {
          loadBatch(initialBytes);
          lock.lock();
          try {
            checkNotClosed();
            totalRowsYielded += root.getRowCount();
            return root;
          } finally {
            lock.unlock();
          }
        } catch (IOException e) {
          throw new BigQueryException(0, "Failed to load initial Arrow record batch", e);
        }
      }

      // 2. Stream subsequent batches from gRPC
      try {
        ReadRowsResponse targetResponse = null;
        if (peekedResponse != null) {
          targetResponse = peekedResponse;
          peekedResponse = null;
        } else {
          ensureStreamInitialized();
          Iterator<ReadRowsResponse> iterator = getStreamIterator();
          if (iterator == null || !iterator.hasNext()) {
            throw new NoSuchElementException("No more Arrow batches available in query stream.");
          }

          while (iterator.hasNext()) {
            ReadRowsResponse response = iterator.next();
            if (response.hasArrowRecordBatch()) {
              targetResponse = response;
              break;
            }
          }
        }

        if (targetResponse == null || !targetResponse.hasArrowRecordBatch()) {
          throw new NoSuchElementException("No more Arrow batches available in query stream.");
        }

        com.google.cloud.bigquery.storage.v1.ArrowRecordBatch batch =
            targetResponse.getArrowRecordBatch();
        try {
          loadBatch(batch.getSerializedRecordBatch());
          lock.lock();
          try {
            checkNotClosed();
            totalRowsYielded += root.getRowCount();
            return root;
          } finally {
            lock.unlock();
          }
        } catch (IOException e) {
          throw new BigQueryException(0, "Failed to load streaming Arrow record batch", e);
        }
      } catch (NoSuchElementException | BigQueryException e) {
        throw e;
      } catch (Exception e) {
        if (isClosed()) {
          throw new NoSuchElementException("Query stream was closed.");
        }
        throw new BigQueryException(0, "Error reading from Arrow stream", e);
      }
    }

    private void ensureStreamInitialized() {
      lock.lock();
      try {
        if (streamInitialized) {
          return;
        }
        if (closed) {
          return;
        }
        if (totalRows >= 0 && totalRowsYielded >= totalRows && yieldedInitialBatch) {
          streamInitialized = true;
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
          streamInitialized = true;
          return;
        }
      } finally {
        lock.unlock();
      }

      ReadRowsRequest request =
          ReadRowsRequest.newBuilder()
              .setReadStream(streamName)
              .setOffset(totalRowsYielded)
              .build();

      ServerStream<ReadRowsResponse> stream = readClient.readRowsCallable().call(request);

      lock.lock();
      try {
        if (closed) {
          stream.cancel();
          return;
        }
        serverStream = stream;
        streamIterator = stream.iterator();
        streamInitialized = true;
      } finally {
        lock.unlock();
      }
    }

    private void loadBatch(byte[] bytes) throws IOException {
      try (ByteArrayReadableSeekableByteChannel byteChannel =
              new ByteArrayReadableSeekableByteChannel(bytes);
          ReadChannel readChannel = new ReadChannel(byteChannel)) {
        ArrowRecordBatch deserializedBatch =
            MessageSerializer.deserializeRecordBatch(readChannel, allocator);
        if (deserializedBatch == null) {
          throw new IOException("Unexpected end of stream when deserializing ArrowRecordBatch");
        }
        boolean loaded = false;
        try {
          ArrowQueryResultImpl.this.loadBatch(deserializedBatch);
          loaded = true;
        } finally {
          if (!loaded) {
            deserializedBatch.close();
          }
        }
      }
    }

    private void loadBatch(com.google.protobuf.ByteString byteString) throws IOException {
      try (java.nio.channels.ReadableByteChannel channel =
              java.nio.channels.Channels.newChannel(byteString.newInput());
          ReadChannel readChannel = new ReadChannel(channel)) {
        ArrowRecordBatch deserializedBatch =
            MessageSerializer.deserializeRecordBatch(readChannel, allocator);
        if (deserializedBatch == null) {
          throw new IOException("Unexpected end of stream when deserializing ArrowRecordBatch");
        }
        boolean loaded = false;
        try {
          ArrowQueryResultImpl.this.loadBatch(deserializedBatch);
          loaded = true;
        } finally {
          if (!loaded) {
            deserializedBatch.close();
          }
        }
      }
    }
  }
}
