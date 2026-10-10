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
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
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
 * {@link VectorSchemaRoot} batches across initial REST response and subsequent gRPC stream as the
 * Arrow-native counterpart to {@link TableResult}.
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
  private volatile boolean closed = false;
  private boolean iteratorCreated = false;
  private volatile ServerStream<ReadRowsResponse> serverStream;

  /**
   * Constructs an {@link ArrowQueryResultImpl}.
   *
   * @param arrowSchema the Arrow schema describing column types, or {@code null} if empty
   * @param jobId the ID of the query job
   * @param queryId the ID of the fast-path query execution
   * @param jobCreationReason the reason why a job was created
   * @param totalRows the total number of rows returned by the query, or -1 if unknown
   * @param initialRecordBatchBytes serialized Arrow record batch bytes from the REST response
   * @param streamName the Storage Read API stream name for reading subsequent rows
   * @param readClient the {@link BigQueryReadClient} for streaming rows via gRPC
   * @throws IllegalArgumentException if {@code arrowSchema} is null but query data or stream is
   *     present
   */
  ArrowQueryResultImpl(
      Schema arrowSchema,
      JobId jobId,
      String queryId,
      JobCreationReason jobCreationReason,
      long totalRows,
      byte[] initialRecordBatchBytes,
      String streamName,
      BigQueryReadClient readClient) {
    this.arrowSchema = arrowSchema != null ? arrowSchema : new Schema(Collections.emptyList());
    if (arrowSchema == null
        && ((initialRecordBatchBytes != null && initialRecordBatchBytes.length > 0)
            || streamName != null)) {
      throw new IllegalArgumentException(
          "Arrow schema cannot be null when query results or streams are present.");
    }
    this.jobId = jobId;
    this.queryId = queryId;
    this.jobCreationReason = jobCreationReason;
    this.totalRows = totalRows;
    this.initialRecordBatchBytes = initialRecordBatchBytes;
    this.streamName = streamName;
    this.readClient = readClient;

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
  }

  /**
   * Constructs an {@link ArrowQueryResultImpl} from a BigQuery Storage Read API {@link
   * ReadSession}.
   *
   * @param readSession the read session containing the Arrow schema and stream names
   * @param jobId the ID of the associated BigQuery query job
   * @param readClient the client used to stream rows from the read session
   * @return a new {@link ArrowQueryResultImpl} instance
   * @throws BigQueryException if deserializing the Arrow schema from the session fails
   */
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

    if (readSession.getStreamsCount() > 1) {
      throw new IllegalArgumentException(
          "ArrowQueryResult only supports single-stream ReadSessions, but got "
              + readSession.getStreamsCount()
              + " streams.");
    }
    String streamName = null;
    if (readSession.getStreamsCount() == 1) {
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

  /** {@inheritDoc} */
  @Override
  public Schema getArrowSchema() {
    return arrowSchema;
  }

  /** {@inheritDoc} */
  @Override
  public JobId getJobId() {
    return jobId;
  }

  /** {@inheritDoc} */
  @Override
  public String getQueryId() {
    return queryId;
  }

  /** {@inheritDoc} */
  @Override
  public JobCreationReason getJobCreationReason() {
    return jobCreationReason;
  }

  /** {@inheritDoc} */
  @Override
  public long getTotalRows() {
    return totalRows;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Note: An {@code ArrowQueryResult} instance can only be iterated once because the underlying
   * {@link VectorSchemaRoot} is mutated in-place across batches.
   *
   * @throws IllegalStateException if this result has already been closed or iterated
   */
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

  /**
   * {@inheritDoc}
   *
   * <p>Cancels any in-flight gRPC read streams and frees off-heap native memory allocated for Arrow
   * vectors and record batches.
   */
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

  /**
   * Asserts that this query result instance has not been closed.
   *
   * @throws IllegalStateException if the query result has already been closed
   */
  private void checkNotClosed() {
    if (closed) {
      throw new IllegalStateException("ArrowQueryResult has already been closed");
    }
  }

  /**
   * Loads an {@link ArrowRecordBatch} into the underlying {@link VectorSchemaRoot} and releases the
   * previously loaded batch to prevent memory leaks.
   *
   * @param newBatch the Arrow record batch to load
   */
  void loadBatch(ArrowRecordBatch newBatch) {
    lock.lock();
    try {
      checkNotClosed();
      loader.load(newBatch);
      ArrowRecordBatch oldBatch = currentRecordBatch;
      currentRecordBatch = newBatch;
      if (oldBatch != null) {
        oldBatch.close();
      }
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
      return closed;
    }

    /**
     * Returns whether an initial Arrow record batch from the fast-path REST query response is
     * present and has not yet been yielded by the iterator.
     *
     * <p>For queries using the fast-path execution, BigQuery returns the first batch of Arrow bytes
     * inline in the REST response. Subsequent batches are streamed via the Storage Read API gRPC
     * connection.
     */
    private boolean hasInitialBatchToYield() {
      return !yieldedInitialBatch
          && initialRecordBatchBytes != null
          && initialRecordBatchBytes.length > 0;
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
        if (streamIterator == null) {
          return false;
        }
        while (streamIterator.hasNext()) {
          ReadRowsResponse response = streamIterator.next();
          if (response.hasArrowRecordBatch()) {
            peekedResponse = response;
            return true;
          }
        }
        return false;
      } catch (BigQueryException e) {
        if (isClosed()) {
          return false;
        }
        throw e;
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
      if (hasInitialBatchToYield()) {
        initialBytes = initialRecordBatchBytes;
      }
      yieldedInitialBatch = true;

      if (initialBytes != null) {
        try {
          loadBatch(initialBytes);
          return root;
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
          if (streamIterator == null || !streamIterator.hasNext()) {
            throw new NoSuchElementException("No more Arrow batches available in query stream.");
          }

          while (streamIterator.hasNext()) {
            ReadRowsResponse response = streamIterator.next();
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
          return root;
        } catch (IOException e) {
          throw new BigQueryException(0, "Failed to load streaming Arrow record batch", e);
        }
      } catch (NoSuchElementException | BigQueryException e) {
        // Rethrow directly to fulfill Iterator contract and prevent double-wrapping
        // BigQueryException.
        throw e;
      } catch (Exception e) {
        if (isClosed()) {
          // Stream was cancelled due to close(); throw NoSuchElementException rather than a
          // transport error.
          throw new NoSuchElementException("Query stream was closed.");
        }
        throw new BigQueryException(0, "Error reading from Arrow stream", e);
      }
    }

    /**
     * Initializes the gRPC {@code ReadRows} stream via {@link BigQueryReadClient} if more rows
     * remain to be consumed and the stream has not yet been started.
     *
     * @throws BigQueryException if stream initialization fails or required stream parameters are
     *     missing
     */
    private void ensureStreamInitialized() {
      if (streamInitialized || closed) {
        return;
      }
      if (totalRows >= 0 && totalRowsYielded >= totalRows && !hasInitialBatchToYield()) {
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
      long offset = totalRowsYielded;
      ReadRowsRequest request =
          ReadRowsRequest.newBuilder().setReadStream(streamName).setOffset(offset).build();

      ServerStream<ReadRowsResponse> stream = readClient.readRowsCallable().call(request);

      if (closed || streamInitialized) {
        try {
          stream.cancel();
        } catch (Throwable t) {
          // ignore
        }
        return;
      }
      serverStream = stream;
      streamIterator = stream.iterator();
      streamInitialized = true;
    }

    /**
     * Deserializes an Arrow record batch from raw bytes and loads it into the root vector.
     *
     * @param bytes serialized Arrow record batch bytes
     * @throws IOException if deserialization fails
     */
    private void loadBatch(byte[] bytes) throws IOException {
      loadBatch(new ByteArrayReadableSeekableByteChannel(bytes));
    }

    /**
     * Deserializes an Arrow record batch from a protobuf {@link ByteString} and loads it into the
     * root vector.
     *
     * @param byteString serialized Arrow record batch bytes as a {@link ByteString}
     * @throws IOException if deserialization fails
     */
    private void loadBatch(ByteString byteString) throws IOException {
      loadBatch(Channels.newChannel(byteString.newInput()));
    }

    /**
     * Deserializes an Arrow record batch from a {@link ReadableByteChannel} and loads it into the
     * root vector.
     *
     * @param channel readable byte channel providing serialized Arrow record batch bytes
     * @throws IOException if deserialization fails
     */
    private void loadBatch(ReadableByteChannel channel) throws IOException {
      checkNotClosed();
      try (ReadableByteChannel byteChannel = channel;
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
      totalRowsYielded += root.getRowCount();
    }
  }
}
