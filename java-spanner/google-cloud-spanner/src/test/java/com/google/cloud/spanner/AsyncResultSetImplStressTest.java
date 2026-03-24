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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.Type.StructField;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AsyncResultSetImplStressTest {
  private static final int TEST_RUNS = 25;

  /** Timeout is applied to each test case individually. */
  @Rule public Timeout timeout = new Timeout(240, TimeUnit.SECONDS);

  @Parameter(0)
  public int resultSetSize;

  @Parameters(name = "rows = {0}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    for (int rows : new int[] {0, 1, 5, 10}) {
      params.add(new Object[] {rows});
    }
    return params;
  }

  /** POJO representing a row in the test {@link ResultSet}. */
  private static final class Row {
    private final Long id;
    private final String name;

    static Row create(StructReader reader) {
      return new Row(reader.getLong("ID"), reader.getString("NAME"));
    }

    private Row(Long id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Row)) {
        return false;
      }
      Row other = (Row) o;
      return Objects.equals(this.id, other.id) && Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
      return String.format("ID: %d, NAME: %s", id, name);
    }
  }

  private static final class ResultSetWithRandomErrors extends ForwardingResultSet {
    private final Random random = new Random();
    private final double errorFraction;

    private ResultSetWithRandomErrors(ResultSet delegate, double errorFraction) {
      super(delegate);
      this.errorFraction = errorFraction;
    }

    @Override
    public boolean next() {
      if (random.nextDouble() < errorFraction) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "random error");
      }
      return super.next();
    }
  }

  /** Creates a simple in-mem {@link ResultSet}. */
  private ResultSet createResultSet() {
    List<Struct> rows = new ArrayList<>(resultSetSize);
    for (int i = 0; i < resultSetSize; i++) {
      rows.add(
          Struct.newBuilder()
              .set("ID")
              .to(i + 1)
              .set("NAME")
              .to(String.format("Row %d", (i + 1)))
              .build());
    }
    return ResultSets.forRows(
        Type.struct(StructField.of("ID", Type.int64()), StructField.of("NAME", Type.string())),
        rows);
  }

  private ResultSet createResultSetWithErrors(double errorFraction) {
    return new ResultSetWithRandomErrors(createResultSet(), errorFraction);
  }

  /**
   * Generates a list of {@link Row} instances that correspond with the rows in {@link
   * #createResultSet()}.
   */
  private List<Row> createExpectedRows() {
    List<Row> rows = new ArrayList<>(resultSetSize);
    for (int i = 0; i < resultSetSize; i++) {
      rows.add(new Row(i + 1L, String.format("Row %d", (i + 1))));
    }
    return rows;
  }

  /** Creates a single-threaded {@link ExecutorService}. */
  private static ScheduledExecutorService createExecService() {
    return createExecService(1);
  }

  /** Creates an {@link ExecutorService} using a bounded pool of threadCount threads. */
  private static ScheduledExecutorService createExecService(int threadCount) {
    return Executors.newScheduledThreadPool(
        threadCount, new ThreadFactoryBuilder().setDaemon(true).build());
  }

  @Test
  public void toList() {
    ExecutorProvider executorProvider = SpannerOptions.createDefaultAsyncExecutorProvider();
    for (int bufferSize = 1; bufferSize < resultSetSize * 2; bufferSize *= 2) {
      for (int i = 0; i < TEST_RUNS; i++) {
        try (AsyncResultSetImpl impl =
            new AsyncResultSetImpl(executorProvider, createResultSet(), bufferSize)) {
          List<Row> list = impl.toList(Row::create);
          assertThat(list).containsExactlyElementsIn(createExpectedRows());
        }
      }
    }
  }

  @Test
  public void toListWithErrors() {
    ExecutorProvider executorProvider = SpannerOptions.createDefaultAsyncExecutorProvider();
    for (int bufferSize = 1; bufferSize < resultSetSize * 2; bufferSize *= 2) {
      for (int i = 0; i < TEST_RUNS; i++) {
        try (AsyncResultSetImpl impl =
            new AsyncResultSetImpl(
                executorProvider, createResultSetWithErrors(1.0 / resultSetSize), bufferSize)) {
          List<Row> list = impl.toList(Row::create);
          assertThat(list).containsExactlyElementsIn(createExpectedRows());
        } catch (SpannerException e) {
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
          assertThat(e.getMessage()).contains("random error");
        }
      }
    }
  }

  @Test
  public void asyncToList() throws Exception {
    ExecutorProvider executorProvider = SpannerOptions.createDefaultAsyncExecutorProvider();
    for (int bufferSize = 1; bufferSize < resultSetSize * 2; bufferSize *= 2) {
      List<ApiFuture<List<Row>>> futures = new ArrayList<>(TEST_RUNS);
      ExecutorService executor = createExecService(32);
      for (int i = 0; i < TEST_RUNS; i++) {
        try (AsyncResultSet impl =
            new AsyncResultSetImpl(executorProvider, createResultSet(), bufferSize)) {
          futures.add(impl.toListAsync(Row::create, executor));
        }
      }
      List<List<Row>> lists = ApiFutures.allAsList(futures).get();
      for (List<Row> list : lists) {
        assertThat(list).containsExactlyElementsIn(createExpectedRows());
      }
      executor.shutdown();
    }
  }

  @Test
  public void consume() throws Exception {
    ExecutorProvider executorProvider = SpannerOptions.createDefaultAsyncExecutorProvider();
    final Random random = new Random();
    for (Executor executor :
        new Executor[] {
          MoreExecutors.directExecutor(), createExecService(), createExecService(32)
        }) {
      for (int bufferSize = 1; bufferSize < resultSetSize * 2; bufferSize *= 2) {
        for (int i = 0; i < TEST_RUNS; i++) {
          final SettableApiFuture<ImmutableList<Row>> future = SettableApiFuture.create();
          try (AsyncResultSetImpl impl =
              new AsyncResultSetImpl(executorProvider, createResultSet(), bufferSize)) {
            final ImmutableList.Builder<Row> builder = ImmutableList.builder();
            impl.setCallback(
                executor,
                resultSet -> {
                  // Randomly do something with the received data or not. Not calling tryNext() in
                  // the onDataReady is not 'normal', but users may do it, and the result set
                  // should be able to handle that.
                  if (random.nextBoolean()) {
                    CursorState state;
                    while ((state = resultSet.tryNext()) == CursorState.OK) {
                      builder.add(Row.create(resultSet));
                    }
                    if (state == CursorState.DONE) {
                      future.set(builder.build());
                    }
                  }
                  return CallbackResponse.CONTINUE;
                });
            assertThat(future.get()).containsExactlyElementsIn(createExpectedRows());
          }
        }
      }
    }
  }

  @Test
  public void returnDoneBeforeEnd() throws Exception {
    ExecutorProvider executorProvider = SpannerOptions.createDefaultAsyncExecutorProvider();
    final Random random = new Random();
    for (Executor executor :
        new Executor[] {
          MoreExecutors.directExecutor(), createExecService(), createExecService(32)
        }) {
      for (int bufferSize = 1; bufferSize < resultSetSize * 2; bufferSize *= 2) {
        for (int i = 0; i < TEST_RUNS; i++) {
          try (AsyncResultSetImpl impl =
              new AsyncResultSetImpl(executorProvider, createResultSet(), bufferSize)) {
            ApiFuture<Void> res =
                impl.setCallback(
                    executor,
                    resultSet -> {
                      switch (resultSet.tryNext()) {
                        case DONE:
                          return CallbackResponse.DONE;
                        case NOT_READY:
                          return random.nextBoolean()
                              ? CallbackResponse.DONE
                              : CallbackResponse.CONTINUE;
                        case OK:
                          return random.nextInt(resultSetSize) <= 2
                              ? CallbackResponse.DONE
                              : CallbackResponse.CONTINUE;
                        default:
                          throw new IllegalStateException();
                      }
                    });
            assertThat(res.get(10L, TimeUnit.SECONDS)).isNull();
          }
        }
      }
    }
  }

  @Test
  public void pauseResume() throws Exception {
    ExecutorProvider executorProvider = SpannerOptions.createDefaultAsyncExecutorProvider();
    final Random random = new Random();
    List<ApiFuture<ImmutableList<Row>>> futures = new ArrayList<>();
    for (Executor executor :
        new Executor[] {
          MoreExecutors.directExecutor(), createExecService(), createExecService(32)
        }) {
      final List<AsyncResultSet> resultSets = Collections.synchronizedList(new ArrayList<>());
      for (int bufferSize = 1; bufferSize < resultSetSize * 2; bufferSize *= 2) {
        for (int i = 0; i < TEST_RUNS; i++) {
          final SettableApiFuture<ImmutableList<Row>> future = SettableApiFuture.create();
          futures.add(future);
          try (AsyncResultSetImpl impl =
              new AsyncResultSetImpl(executorProvider, createResultSet(), bufferSize)) {
            resultSets.add(impl);
            final ImmutableList.Builder<Row> builder = ImmutableList.builder();
            impl.setCallback(
                executor,
                resultSet -> {
                  CursorState state;
                  while ((state = resultSet.tryNext()) == CursorState.OK) {
                    builder.add(Row.create(resultSet));
                    // Randomly request the iterator to pause.
                    if (random.nextBoolean()) {
                      return CallbackResponse.PAUSE;
                    }
                  }
                  if (state == CursorState.DONE) {
                    future.set(builder.build());
                  }
                  return CallbackResponse.CONTINUE;
                });
          }
        }
      }
      final AtomicBoolean finished = new AtomicBoolean(false);
      ExecutorService resumeService = createExecService();
      resumeService.execute(
          () -> {
            while (!finished.get()) {
              // Randomly resume result sets.
              resultSets.get(random.nextInt(resultSets.size())).resume();
            }
          });
      List<ImmutableList<Row>> lists = ApiFutures.allAsList(futures).get();
      for (ImmutableList<Row> list : lists) {
        assertThat(list).containsExactlyElementsIn(createExpectedRows());
      }
      if (executor instanceof ExecutorService) {
        ((ExecutorService) executor).shutdown();
      }
      finished.set(true);
      resumeService.shutdown();
    }
  }

  @Test
  public void cancel() throws Exception {
    ExecutorProvider executorProvider = SpannerOptions.createDefaultAsyncExecutorProvider();
    final Random random = new Random();
    for (Executor executor :
        new Executor[] {
          MoreExecutors.directExecutor(), createExecService(), createExecService(32)
        }) {
      List<ApiFuture<ImmutableList<Row>>> futures = new ArrayList<>();
      final List<AsyncResultSet> resultSets = Collections.synchronizedList(new ArrayList<>());
      final Set<Integer> cancelledIndexes = new HashSet<>();
      for (int bufferSize = 1; bufferSize < resultSetSize * 2; bufferSize *= 2) {
        for (int i = 0; i < TEST_RUNS; i++) {
          final SettableApiFuture<ImmutableList<Row>> future = SettableApiFuture.create();
          futures.add(future);
          try (AsyncResultSetImpl impl =
              new AsyncResultSetImpl(executorProvider, createResultSet(), bufferSize)) {
            resultSets.add(impl);
            final ImmutableList.Builder<Row> builder = ImmutableList.builder();
            impl.setCallback(
                executor,
                resultSet -> {
                  try {
                    CursorState state;
                    while ((state = resultSet.tryNext()) == CursorState.OK) {
                      builder.add(Row.create(resultSet));
                      // Randomly request the iterator to pause.
                      if (random.nextBoolean()) {
                        return CallbackResponse.PAUSE;
                      }
                    }
                    if (state == CursorState.DONE) {
                      future.set(builder.build());
                    }
                    return CallbackResponse.CONTINUE;
                  } catch (SpannerException e) {
                    future.setException(e);
                    throw e;
                  }
                });
          }
        }
      }
      final AtomicBoolean finished = new AtomicBoolean(false);
      // Both resume and cancel resultsets randomly.
      ExecutorService resumeService = createExecService();
      resumeService.execute(
          () -> {
            while (!finished.get()) {
              // Randomly resume result sets.
              resultSets.get(random.nextInt(resultSets.size())).resume();
            }
            // Make sure all result sets finish.
            for (AsyncResultSet rs : resultSets) {
              rs.resume();
            }
          });
      ExecutorService cancelService = createExecService();
      cancelService.execute(
          () -> {
            while (!finished.get()) {
              // Randomly cancel result sets.
              int index = random.nextInt(resultSets.size());
              resultSets.get(index).cancel();
              cancelledIndexes.add(index);
            }
          });

      // First wait until all result sets have finished.
      for (ApiFuture<ImmutableList<Row>> future : futures) {
        try {
          future.get();
        } catch (Throwable e) {
          // ignore for now.
        }
      }
      finished.set(true);
      cancelService.shutdown();
      cancelService.awaitTermination(10L, TimeUnit.SECONDS);

      int index = 0;
      for (ApiFuture<ImmutableList<Row>> future : futures) {
        try {
          ImmutableList<Row> list = future.get(30L, TimeUnit.SECONDS);
          // Note that the fact that the call succeeded for for this result set, does not
          // necessarily mean that the result set was not cancelled. Cancelling a result set is a
          // best-effort operation, and the entire result set may still be produced and returned to
          // the user.
          assertThat(list).containsExactlyElementsIn(createExpectedRows());
        } catch (ExecutionException e) {
          assertThat(e.getCause()).isInstanceOf(SpannerException.class);
          SpannerException se = (SpannerException) e.getCause();
          assertThat(se.getErrorCode()).isEqualTo(ErrorCode.CANCELLED);
          assertThat(cancelledIndexes).contains(index);
        }
        index++;
      }
      if (executor instanceof ExecutorService) {
        ((ExecutorService) executor).shutdown();
      }
    }
  }
}
