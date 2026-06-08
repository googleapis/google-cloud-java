/*
 * Copyright 2022 Google LLC
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
package com.google.datastore.v1.client.it;

import static com.google.datastore.v1.client.DatastoreHelper.makeFilter;
import static com.google.datastore.v1.client.DatastoreHelper.makeValue;

import com.google.common.truth.Truth;
import com.google.datastore.v1.Filter;
import com.google.datastore.v1.KindExpression;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyFilter;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.client.Datastore;
import com.google.datastore.v1.client.DatastoreException;
import com.google.datastore.v1.client.DatastoreHelper;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.DirectRetryingExecutor;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ResultRetryAlgorithmWithContext;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiClock;
import com.google.api.core.NanoClock;
import com.google.rpc.Code;
import java.time.Duration;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;

public class ITDatastoreProtoClientTest {

  private static Datastore DATASTORE;

  private static PartitionId PARTITION;

  private static final String KIND = "test-kind";
  private static final String PROJECT_ID = System.getenv(DatastoreHelper.PROJECT_ID_ENV_VAR);

  @Before
  public void setUp() throws GeneralSecurityException, IOException {
    DATASTORE = DatastoreHelper.getDatastoreFromEnv();
  }

  @Test
  public void testQuerySplitterWithDefaultDb() throws Exception {
    Filter propertyFilter =
        makeFilter("foo", PropertyFilter.Operator.EQUAL, makeValue("value")).build();
    Query query =
        Query.newBuilder()
            .addKind(KindExpression.newBuilder().setName(KIND).build())
            .setFilter(propertyFilter)
            .build();

    PARTITION = PartitionId.newBuilder().setProjectId(PROJECT_ID).build();

    List<Query> splits = getSplitsWithRetry(query, PARTITION, 2, DATASTORE);
    Truth.assertThat(splits).isNotEmpty();
    splits.forEach(
        split -> {
          Truth.assertThat(split.getKind(0).getName()).isEqualTo(KIND);
          Truth.assertThat(split.getFilter()).isEqualTo(propertyFilter);
        });
  }

  @Test
  public void testQuerySplitterWithDb() throws Exception {
    Filter propertyFilter =
        makeFilter("foo", PropertyFilter.Operator.EQUAL, makeValue("value")).build();
    Query query =
        Query.newBuilder()
            .addKind(KindExpression.newBuilder().setName(KIND).build())
            .setFilter(propertyFilter)
            .build();

    PARTITION = PartitionId.newBuilder().setProjectId(PROJECT_ID).setDatabaseId("test-db").build();

    List<Query> splits = getSplitsWithRetry(query, PARTITION, 2, DATASTORE);

    Truth.assertThat(splits).isNotEmpty();
    splits.forEach(
        split -> {
          Truth.assertThat(split.getKind(0).getName()).isEqualTo(KIND);
          Truth.assertThat(split.getFilter()).isEqualTo(propertyFilter);
        });
  }

  /**
   * A generic helper method that executes a {@link Callable} with retries using
   * the GAX retrying framework.
   *
   * <p>It configures a {@link DirectRetryingExecutor} with the provided {@link RetrySettings}
   * and the custom {@link ResultRetryAlgorithmWithContext}.
   *
   * @param callable the action to execute
   * @param retrySettings the retry configuration (backoff, max attempts, timeouts)
   * @param resultRetryAlgorithm the algorithm to determine if a failed attempt should be retried
   * @return the result of the callable execution
   * @throws Exception if the execution fails after all retry attempts.
   */
  private static <V> V runWithRetry(
      Callable<V> callable,
      RetrySettings retrySettings,
      ResultRetryAlgorithmWithContext<V> resultRetryAlgorithm)
      throws Exception {
    ApiClock clock = NanoClock.getDefaultClock();
    // We must wrap the result algorithm and timed algorithm into a RetryAlgorithm
    // as required by DirectRetryingExecutor.
    RetryAlgorithm<V> retryAlgorithm = new RetryAlgorithm<>(
        resultRetryAlgorithm,
        new ExponentialRetryAlgorithm(retrySettings, clock)
    );

    DirectRetryingExecutor<V> executor = new DirectRetryingExecutor<>(retryAlgorithm);
    RetryingFuture<V> future = executor.createFuture(callable);

    ApiFuture<V> submittedFuture = executor.submit(future);

    try {
      return submittedFuture.get();
    } catch (ExecutionException e) {
      Throwable cause = e.getCause();
      // submittedFuture.get() wraps any exception thrown during execution in an ExecutionException.
      // We unwrap and rethrow the actual cause (Exception or Error) directly so that test failures
      // report the root cause (e.g., DatastoreException or AssertionError) instead of the wrapper.
      if (cause instanceof Exception) {
        throw (Exception) cause;
      }
      if (cause instanceof Error) {
        throw (Error) cause;
      }
      throw e;
    } catch (InterruptedException e) {
      // Restore the interrupted status before rethrowing, as per Java concurrency best practices.
      Thread.currentThread().interrupt();
      throw e;
    }
  }

  // This low-level Datastore client (proto-over-HTTP) does not have built-in retry logic
  // (unlike the high-level google-cloud-datastore gRPC client). We must explicitly retry
  // here to handle transient backend errors (such as Code.INTERNAL auth issues).
  // We reuse GAX retrying utilities here in the test to implement this backoff/retry.
  private static List<Query> getSplitsWithRetry(
      Query query, PartitionId partition, int numSplits, Datastore datastore)
      throws Exception {
    // Fail fast configuration to avoid long wait times during test failures
    RetrySettings retrySettings = RetrySettings.newBuilder()
        .setMaxAttempts(3)
        .setInitialRetryDelayDuration(Duration.ofMillis(200))
        .setRetryDelayMultiplier(1.5)
        .setMaxRetryDelayDuration(Duration.ofMillis(500))
        .setTotalTimeoutDuration(Duration.ofSeconds(2))
        .build();
    return runWithRetry(
        () -> DatastoreHelper.getQuerySplitter().getSplits(query, partition, numSplits, datastore),
        retrySettings,
        new BasicResultRetryAlgorithm<List<Query>>() {
          @Override
          public boolean shouldRetry(Throwable prevThrowable, List<Query> prevResult) {
            if (prevThrowable instanceof DatastoreException) {
              DatastoreException de = (DatastoreException) prevThrowable;
              return de.getCode() == Code.INTERNAL;
            }
            return false;
          }
        }
    );
  }
}
