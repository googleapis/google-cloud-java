/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.test_helpers.env;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.threeten.bp.Instant;

public class PrefixGenerator implements TestRule {
  private static final Logger LOGGER = Logger.getLogger(TestEnvRule.class.getName());

  static final String PREFIX = "temp-";
  private static final AtomicInteger prefixCounter = new AtomicInteger(0);
  private static final int SUFFIX = new Random().nextInt(Integer.MAX_VALUE);

  private String testName;

  @Override
  public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      public void evaluate() throws Throwable {
        before(description);

        try {
          base.evaluate();
        } finally {
          after();
        }
      }
    };
  }

  private void before(Description description) {
    testName = description.toString();
  }

  private void after() {
    testName = null;
  }

  public String newPrefix() {
    return newPrefix(testName);
  }

  public static String newPrefix(String source) {
    // Sortable resource prefix - time, process identifier, serial counterck
    String prefix =
        String.format(
            "%s-%x-%x", newTimePrefix(Instant.now()), SUFFIX, prefixCounter.getAndIncrement());

    LOGGER.info(source + ": newPrefix: " + prefix);
    return prefix;
  }

  static String newTimePrefix(Instant instant) {
    return String.format(PREFIX + "08%x", instant.getEpochSecond());
  }
}
