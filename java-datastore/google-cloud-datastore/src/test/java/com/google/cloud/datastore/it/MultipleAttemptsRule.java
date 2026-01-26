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

package com.google.cloud.datastore.it;

import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.List;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/**
 * A JUnit rule that allows us to allow multiple attempts of a test execution before it is
 * ultimately failed. When it fails, all failures will be propagated as the result of the test.
 */
public final class MultipleAttemptsRule implements TestRule {
  private final long initialBackoffMillis;
  private final int attemptCount;

  MultipleAttemptsRule(int attemptCount) {
    this(attemptCount, 1000L);
  }

  public MultipleAttemptsRule(int attemptCount, long initialBackoffMillis) {
    checkState(attemptCount > 0, "attemptCount must be > 0");
    checkState(initialBackoffMillis > 0, "initialBackoffMillis must be > 0");
    this.initialBackoffMillis = initialBackoffMillis;
    this.attemptCount = attemptCount;
  }

  @Override
  public Statement apply(final Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        List<Throwable> failures = new ArrayList<>();

        long retryIntervalMillis = initialBackoffMillis;

        for (int i = 1; i <= attemptCount; i++) {
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
