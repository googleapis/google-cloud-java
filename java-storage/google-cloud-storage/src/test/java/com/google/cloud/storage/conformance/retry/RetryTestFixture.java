/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage.conformance.retry;

import static org.junit.Assert.assertTrue;

import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.it.runner.registry.TestBench;
import com.google.cloud.storage.it.runner.registry.TestBench.RetryTestResource;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Locale;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A JUnit 4 {@link TestRule} which integrates with {@link TestBench} and {@link
 * TestRetryConformance} to provide transparent lifecycle integration of setup/validation/cleanup of
 * {@code /retry_test} resources. This rule expects to be bound as an {@link org.junit.Rule @Rule}
 * field.
 *
 * <p>Provides pre-configured instances of {@link Storage} for setup/teardown & test.
 */
final class RetryTestFixture extends TestWatcher {
  private static final Logger LOGGER = LoggerFactory.getLogger(RetryTestFixture.class);
  private static final int STATUS_CODE_NOT_IMPLEMENTED = 501;

  private final CleanupStrategy cleanupStrategy;
  private final TestBench testBench;
  private final TestRetryConformance testRetryConformance;

  boolean testSuccess = false;
  boolean testSkipped = false;

  private RetryTestResource retryTest;
  private Storage nonTestStorage;
  private Storage testStorage;

  RetryTestFixture(
      CleanupStrategy cleanupStrategy,
      TestBench testBench,
      TestRetryConformance testRetryConformance) {
    this.cleanupStrategy = cleanupStrategy;
    this.testBench = testBench;
    this.testRetryConformance = testRetryConformance;
  }

  public Storage getNonTestStorage() {
    if (nonTestStorage == null) {
      this.nonTestStorage = newStorage(false);
    }
    return nonTestStorage;
  }

  public Storage getTestStorage() {
    if (testStorage == null) {
      this.testStorage = newStorage(true);
    }
    return testStorage;
  }

  @Override
  protected void starting(Description description) {
    LOGGER.trace("Setting up retry_test resource...");
    RetryTestResource retryTestResource =
        RetryTestResource.newRetryTestResource(
            testRetryConformance.getMethod(),
            testRetryConformance.getInstruction(),
            testRetryConformance.getTransport().name());
    try {
      retryTest = testBench.createRetryTest(retryTestResource);
    } catch (HttpResponseException e) {
      if (e.getStatusCode() == STATUS_CODE_NOT_IMPLEMENTED) {
        AssumptionViolatedException exception =
            new AssumptionViolatedException(
                "Testbench not yet implemented for " + retryTestResource);
        // make skips due to not implemented more terse
        // we know where this comes from, we don't need the full stack trace for each of the
        // 200+ occurrences.
        exception.setStackTrace(new StackTraceElement[0]);
        throw exception;
      } else {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    LOGGER.trace("Setting up retry_test resource complete");
  }

  @Override
  protected void finished(Description description) {
    LOGGER.trace("Verifying end state of retry_test resource...");
    try (Storage ignore1 = nonTestStorage;
        Storage ignore2 = testStorage) { // use try-with to shut down grpc resources
      try {
        if (retryTest != null) {
          RetryTestResource postTestState = testBench.getRetryTest(retryTest);
          if (testSuccess) {
            assertTrue("expected completed to be true, but was false", postTestState.completed);
          }
        }
      } finally {
        LOGGER.trace("Verifying end state of retry_test resource complete");
        if ((shouldCleanup(testSuccess, testSkipped)) && retryTest != null) {
          testBench.deleteRetryTest(retryTest);
          retryTest = null;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void succeeded(Description description) {
    testSuccess = true;
  }

  @Override
  protected void failed(Throwable e, Description description) {
    super.failed(e, description);
  }

  @Override
  protected void skipped(AssumptionViolatedException e, Description description) {
    testSkipped = true;
  }

  private boolean shouldCleanup(boolean testSuccess, boolean testSkipped) {
    return cleanupStrategy == CleanupStrategy.ALWAYS
        || ((testSuccess || testSkipped) && cleanupStrategy == CleanupStrategy.ONLY_ON_SUCCESS);
  }

  private Storage newStorage(boolean forTest) {
    RetrySettings.Builder retrySettingsBuilder =
        StorageOptions.getDefaultRetrySettings().toBuilder();
    if (forTest) {
      StorageOptions.Builder builder;
      switch (testRetryConformance.getTransport()) {
        case HTTP:
          builder = StorageOptions.http().setHost(testBench.getBaseUri());
          break;
        case GRPC:
          builder =
              StorageOptions.grpc()
                  .setHost(testBench.getGRPCBaseUri())
                  .setEnableGrpcClientMetrics(false)
                  .setAttemptDirectPath(false);
          break;
        default:
          throw new IllegalStateException(
              "Enum switch exhaustion checking would be nice. Unhandled case: "
                  + testRetryConformance.getTransport());
      }
      builder
          .setCredentials(NoCredentials.getInstance())
          .setProjectId(testRetryConformance.getProjectId())
          .setHeaderProvider(
              FixedHeaderProvider.create(
                  ImmutableMap.of(
                      "x-retry-test-id", retryTest.id, "User-Agent", fmtUserAgent("test"))))
          .setRetrySettings(retrySettingsBuilder.setMaxAttempts(3).build());
      return builder.build().getService();
    } else {
      return StorageOptions.http()
          .setHost(testBench.getBaseUri())
          .setCredentials(NoCredentials.getInstance())
          .setProjectId(testRetryConformance.getProjectId())
          .setHeaderProvider(
              FixedHeaderProvider.create(ImmutableMap.of("User-Agent", fmtUserAgent("non-test"))))
          .setRetrySettings(retrySettingsBuilder.setMaxAttempts(1).build())
          .build()
          .getService();
    }
  }

  private String fmtUserAgent(String testDescriptor) {
    return String.format(
        Locale.US,
        "%s/ (%s) java-conformance-tests/",
        testDescriptor,
        testRetryConformance.getTestName());
  }
}
