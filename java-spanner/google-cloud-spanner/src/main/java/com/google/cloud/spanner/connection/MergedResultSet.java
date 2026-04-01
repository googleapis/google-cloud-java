/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.connection;

import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ForwardingStructReader;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.Code;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

/**
 * {@link MergedResultSet} is a {@link ResultSet} implementation that combines the results from
 * multiple queries. Each query uses its own {@link RowProducer} that feeds rows into the {@link
 * MergedResultSet}. The order of the records in the {@link MergedResultSet} is not guaranteed.
 */
class MergedResultSet extends ForwardingStructReader implements PartitionedQueryResultSet {
  static class PartitionExecutor implements Runnable {
    private final Connection connection;
    private final String partitionId;
    private final LinkedBlockingDeque<PartitionExecutorResult> queue;
    private final CountDownLatch metadataAvailableLatch;
    private final AtomicBoolean shouldStop = new AtomicBoolean();

    PartitionExecutor(
        Connection connection,
        String partitionId,
        LinkedBlockingDeque<PartitionExecutorResult> queue,
        CountDownLatch metadataAvailableLatch) {
      this.connection = Preconditions.checkNotNull(connection);
      this.partitionId = Preconditions.checkNotNull(partitionId);
      this.queue = queue;
      this.metadataAvailableLatch = Preconditions.checkNotNull(metadataAvailableLatch);
    }

    @Override
    public void run() {
      try (ResultSet resultSet = connection.runPartition(partitionId)) {
        boolean first = true;
        while (resultSet.next()) {
          Struct row = resultSet.getCurrentRowAsStruct();
          if (first) {
            queue.put(
                PartitionExecutorResult.dataAndMetadata(
                    row, resultSet.getType(), resultSet.getMetadata()));
            metadataAvailableLatch.countDown();
            first = false;
          } else {
            queue.put(PartitionExecutorResult.data(row));
          }
          if (shouldStop.get()) {
            break;
          }
        }
        if (first
            && resultSet.getType().getCode() == Code.STRUCT
            && !resultSet.getType().getStructFields().isEmpty()) {
          // Special case: The result set did not return any rows, but did return metadata.
          // Push the metadata to the merged result set.
          queue.put(
              PartitionExecutorResult.typeAndMetadata(
                  resultSet.getType(), resultSet.getMetadata()));
          metadataAvailableLatch.countDown();
        }
      } catch (Throwable exception) {
        putWithoutInterruptPropagation(PartitionExecutorResult.exception(exception));
        metadataAvailableLatch.countDown();
      } finally {
        // Emit a special 'finished' result to ensure that the row producer is not blocked on a
        // queue that never receives any more results. This ensures that we can safely block on
        // queue.take(), as we know that we will always receive at least one result from each
        // worker.
        putWithoutInterruptPropagation(PartitionExecutorResult.finished());
      }
    }

    private void putWithoutInterruptPropagation(PartitionExecutorResult result) {
      try {
        queue.put(result);
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
      }
    }
  }

  static class PartitionExecutorResult {
    private final Struct data;
    private final Throwable exception;
    private final Type type;
    private final ResultSetMetadata metadata;

    static PartitionExecutorResult data(@Nonnull Struct data) {
      return new PartitionExecutorResult(Preconditions.checkNotNull(data), null, null, null);
    }

    static PartitionExecutorResult typeAndMetadata(
        @Nonnull Type type, @Nonnull ResultSetMetadata metadata) {
      return new PartitionExecutorResult(
          null, Preconditions.checkNotNull(type), Preconditions.checkNotNull(metadata), null);
    }

    static PartitionExecutorResult dataAndMetadata(
        @Nonnull Struct data, @Nonnull Type type, @Nonnull ResultSetMetadata metadata) {
      return new PartitionExecutorResult(
          Preconditions.checkNotNull(data),
          Preconditions.checkNotNull(type),
          Preconditions.checkNotNull(metadata),
          null);
    }

    static PartitionExecutorResult exception(@Nonnull Throwable exception) {
      return new PartitionExecutorResult(null, null, null, Preconditions.checkNotNull(exception));
    }

    static PartitionExecutorResult finished() {
      return new PartitionExecutorResult(null, null, null, null);
    }

    private PartitionExecutorResult(
        Struct data, Type type, ResultSetMetadata metadata, Throwable exception) {
      this.data = data;
      this.type = type;
      this.metadata = metadata;
      this.exception = exception;
    }

    boolean hasData() {
      return this.data != null;
    }

    boolean isFinished() {
      return this.data == null
          && this.type == null
          && this.metadata == null
          && this.exception == null;
    }
  }

  interface RowProducer extends Supplier<Struct> {
    boolean nextRow() throws Throwable;

    void close();

    Type getType();

    ResultSetMetadata getMetadata();

    int getNumPartitions();

    int getParallelism();
  }

  static class EmptyRowProducer implements RowProducer {
    @Override
    public Struct get() {
      return Struct.newBuilder().build();
    }

    @Override
    public boolean nextRow() {
      return false;
    }

    @Override
    public Type getType() {
      return Type.struct();
    }

    @Override
    public ResultSetMetadata getMetadata() {
      return ResultSetMetadata.getDefaultInstance();
    }

    @Override
    public int getNumPartitions() {
      return 0;
    }

    @Override
    public int getParallelism() {
      return 0;
    }

    @Override
    public void close() {}
  }

  private static class RowProducerImpl implements RowProducer {
    /** The maximum number of rows that we will cache per thread that is fetching rows. */
    private static final int QUEUE_SIZE_PER_WORKER = 32;

    private final ExecutorService executor;
    private final int parallelism;
    private final List<PartitionExecutor> partitionExecutors;
    private final AtomicInteger finishedCounter;
    private final LinkedBlockingDeque<PartitionExecutorResult> queue;
    private ResultSetMetadata metadata;
    private final CountDownLatch metadataAvailableLatch = new CountDownLatch(1);
    private Type type;
    private Struct currentRow;
    private Throwable exception;

    RowProducerImpl(Connection connection, List<String> partitions, int maxParallelism) {
      Preconditions.checkArgument(maxParallelism >= 0, "maxParallelism must be >= 0");
      Preconditions.checkArgument(
          !Preconditions.checkNotNull(partitions).isEmpty(), "partitions must not be empty");
      if (maxParallelism == 0) {
        // Dynamically determine parallelism.
        this.parallelism = Math.min(partitions.size(), Runtime.getRuntime().availableProcessors());
      } else {
        this.parallelism = Math.min(partitions.size(), maxParallelism);
      }
      this.executor =
          Executors.newFixedThreadPool(
              this.parallelism,
              runnable -> {
                Thread thread = new Thread(runnable);
                thread.setName("partitioned-query-row-producer");
                thread.setDaemon(true);
                return thread;
              });
      this.queue = new LinkedBlockingDeque<>(QUEUE_SIZE_PER_WORKER * this.parallelism);
      this.partitionExecutors = new ArrayList<>(partitions.size());
      this.finishedCounter = new AtomicInteger(partitions.size());
      for (String partition : partitions) {
        PartitionExecutor partitionExecutor =
            new PartitionExecutor(connection, partition, this.queue, this.metadataAvailableLatch);
        this.partitionExecutors.add(partitionExecutor);
        this.executor.submit(partitionExecutor);
      }
      // Pre-emptively shutdown the executor. This does not terminate any running tasks, but it
      // stops the executor from accepting any new tasks and guarantees that the executor will
      // always be shutdown, regardless whether the user calls ResultSet#close().
      this.executor.shutdown();
    }

    @Override
    public void close() {
      this.partitionExecutors.forEach(partitionExecutor -> partitionExecutor.shouldStop.set(true));
      // shutdownNow will interrupt any running tasks and then shut down directly.
      // This will also cancel any queries that might be running.
      this.executor.shutdownNow();
    }

    @Override
    public boolean nextRow() throws Throwable {
      if (this.exception != null) {
        throw this.exception;
      }
      while (true) {
        PartitionExecutorResult next;
        if ((next = queue.peek()) != null && !next.isFinished()) {
          // There's a valid result available. Return this quickly.
          if (setNextRow(queue.remove())) {
            return true;
          }
        }
        // Block until the next row is available.
        next = queue.take();
        if (next.isFinished()) {
          finishedCounter.decrementAndGet();
          if (finishedCounter.get() == 0) {
            return false;
          }
        } else {
          if (setNextRow(next)) {
            return true;
          }
        }
      }
    }

    boolean setNextRow(PartitionExecutorResult next) throws Throwable {
      if (next.exception != null) {
        this.exception = next.exception;
        throw next.exception;
      }
      currentRow = next.data;
      if (this.metadata == null && next.metadata != null) {
        this.metadata = next.metadata;
      }
      if (this.type == null && next.type != null) {
        this.type = next.type;
      }
      return next.hasData();
    }

    @Override
    public Struct get() {
      checkState(currentRow != null, "next() call required");
      return currentRow;
    }

    private PartitionExecutorResult getFirstResultWithMetadata() {
      try {
        metadataAvailableLatch.await();
      } catch (InterruptedException interruptedException) {
        throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
      }
      PartitionExecutorResult result =
          queue.stream()
              .filter(rs -> rs.metadata != null || rs.exception != null)
              .findFirst()
              .orElse(null);
      if (result == null) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.FAILED_PRECONDITION, "Thread-unsafe access to ResultSet");
      }
      if (result.exception != null) {
        throw SpannerExceptionFactory.asSpannerException(result.exception);
      }
      return result;
    }

    public ResultSetMetadata getMetadata() {
      if (metadata == null) {
        return getFirstResultWithMetadata().metadata;
      }
      return metadata;
    }

    @Override
    public int getNumPartitions() {
      return partitionExecutors.size();
    }

    @Override
    public int getParallelism() {
      return parallelism;
    }

    public Type getType() {
      if (type == null) {
        return getFirstResultWithMetadata().type;
      }
      return type;
    }
  }

  private final RowProducer rowProducer;

  private boolean closed;

  MergedResultSet(Connection connection, List<String> partitions, int maxParallelism) {
    this(
        Preconditions.checkNotNull(partitions).isEmpty()
            ? new EmptyRowProducer()
            : new RowProducerImpl(connection, partitions, maxParallelism));
  }

  private MergedResultSet(RowProducer rowProducer) {
    super(rowProducer);
    this.rowProducer = rowProducer;
  }

  @Override
  protected void checkValidState() {
    Preconditions.checkState(!closed, "This result set has been closed");
  }

  @Override
  public boolean next() throws SpannerException {
    checkValidState();
    try {
      return rowProducer.nextRow();
    } catch (InterruptedException interruptedException) {
      throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
    } catch (Throwable throwable) {
      throw SpannerExceptionFactory.asSpannerException(throwable);
    }
  }

  @Override
  public Struct getCurrentRowAsStruct() {
    checkValidState();
    return rowProducer.get();
  }

  @Override
  public void close() {
    this.closed = true;
    rowProducer.close();
  }

  @Override
  public ResultSetStats getStats() {
    throw new UnsupportedOperationException(
        "ResultSetStats are available only for results returned from analyzeQuery() calls");
  }

  @Override
  public ResultSetMetadata getMetadata() {
    checkValidState();
    return rowProducer.getMetadata();
  }

  @Override
  public Type getType() {
    checkValidState();
    return rowProducer.getType();
  }

  @Override
  public int getColumnCount() {
    return getType().getStructFields().size();
  }

  @Override
  public int getColumnIndex(String columnName) {
    return getType().getFieldIndex(columnName);
  }

  @Override
  public Type getColumnType(int columnIndex) {
    return getType().getStructFields().get(columnIndex).getType();
  }

  @Override
  public Type getColumnType(String columnName) {
    return getType().getStructFields().get(getColumnIndex(columnName)).getType();
  }

  @Override
  public int getNumPartitions() {
    return rowProducer.getNumPartitions();
  }

  @Override
  public int getParallelism() {
    return rowProducer.getParallelism();
  }
}
