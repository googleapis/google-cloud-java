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

package com.example.spanner;

import com.google.cloud.spanner.SpannerException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Predicate;

/**
 * Runs a sample and captures the output as a String.
 */
public class SampleRunner {

  @FunctionalInterface
  public interface SampleRunnerCallable {

    void call() throws Exception;
  }

  public static String runSample(SampleRunnerCallable sample) throws Exception {
    return runSampleWithRetry(sample, e -> false);
  }

  /**
   * Runs a sample and retries it if the given predicate returns true for a given {@link
   * SpannerException}. The predicate can return different answers for the same error, for example
   * by only allowing the retry of a certain error a specific number of times.
   */
  public static String runSampleWithRetry(SampleRunnerCallable sample,
      Predicate<SpannerException> shouldRetry) throws Exception {
    final PrintStream stdOut = System.out;
    final ByteArrayOutputStream bout = new ByteArrayOutputStream();
    final PrintStream out = new PrintStream(bout);
    System.setOut(out);
    while (true) {
      try {
        sample.call();
        break;
      } catch (SpannerException e) {
        if (!shouldRetry.test(e)) {
          throw e;
        }
      }
    }
    System.setOut(stdOut);
    return bout.toString();
  }
}
