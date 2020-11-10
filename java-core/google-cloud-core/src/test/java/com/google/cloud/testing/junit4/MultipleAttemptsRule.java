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

package com.google.cloud.testing.junit4;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.List;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/**
 * A JUnit rule that allows multiple attempts of a test execution before ultimately reporting
 * failure for the test. Attempts will be attempted with an exponential backoff which defaults to a
 * starting duration of 1 second.
 *
 * <p>If after the maximum number of attempts the test has still not succeeded, all failures will be
 * propagated as the result of the test allowing all errors to be visible (regardless if they are
 * the same failure or different ones).
 *
 * <p>To use this rule add the field declaration to your JUnit 4 Test class:
 *
 * <p><i>Note: It is important that the field is public</i>
 *
 * <pre>{@code
 * @Rule
 * public MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);
 * }</pre>
 *
 * @see org.junit.Rule
 */
public final class MultipleAttemptsRule implements TestRule {
  private final long initialBackoffMillis;
  private final int maxAttemptCount;

  /**
   * Construct a {@link MultipleAttemptsRule} which will attempt a test up to {@code attemptCount}
   * times before ultimately reporting failure of the test.
   *
   * <p>The initialBackoffMillis will be set to 1000L.
   *
   * @param maxAttemptCount max number of attempts before reporting failure, must be greater than 0
   * @see #MultipleAttemptsRule(int, long)
   */
  public MultipleAttemptsRule(int maxAttemptCount) {
    this(maxAttemptCount, 1000L);
  }

  /**
   * Construct a {@link MultipleAttemptsRule} which will attempt a test up to {@code attemptCount}
   * times before ultimately reporting failure of the test.
   *
   * <p>The {@code initialBackoffMillis} will be used as the first pause duration before
   * reattempting the test.
   *
   * @param maxAttemptCount max number of attempts before reporting failure, must be greater than 0
   * @param initialBackoffMillis initial duration in millis to wait between attempts, must be
   *     greater than or equal to 0
   */
  public MultipleAttemptsRule(int maxAttemptCount, long initialBackoffMillis) {
    checkArgument(maxAttemptCount > 0, "attemptCount must be > 0");
    checkArgument(initialBackoffMillis >= 0, "initialBackoffMillis must be >= 0");
    this.initialBackoffMillis = initialBackoffMillis;
    this.maxAttemptCount = maxAttemptCount;
  }

  @Override
  public Statement apply(final Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        List<Throwable> failures = new ArrayList<>();

        long retryIntervalMillis = initialBackoffMillis;

        for (int i = 1; i <= maxAttemptCount; i++) {
          try {
            base.evaluate();
            return;
          } catch (Throwable t) {
            failures.add(t);
            Thread.sleep(retryIntervalMillis);
            retryIntervalMillis *= 1.5f;
          }
        }

        MultipleFailureException.assertEmpty(failures);
      }
    };
  }
}
