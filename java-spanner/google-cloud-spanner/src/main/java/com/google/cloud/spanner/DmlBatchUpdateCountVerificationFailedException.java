/*
 * Copyright 2024 Google LLC
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

import com.google.cloud.spanner.connection.Connection;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Exception thrown by a {@link Connection} when an automatic DML batch detects that one or more of
 * the update counts that it returned during the buffering of DML statements does not match with the
 * actual update counts that were returned after execution.
 */
public class DmlBatchUpdateCountVerificationFailedException extends AbortedException {
  private static final long serialVersionUID = 1L;

  private final long[] expected;

  private final long[] actual;

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  DmlBatchUpdateCountVerificationFailedException(
      DoNotConstructDirectly token, long[] expected, long[] actual) {
    super(
        token,
        String.format(
            "Actual update counts that were returned during execution do not match the previously"
                + " returned update counts.\n"
                + "Expected: %s\n"
                + "Actual: %s\n"
                + "Set auto_batch_dml_update_count_verification to false to skip this"
                + " verification.",
            Arrays.stream(expected).mapToObj(Long::toString).collect(Collectors.joining()),
            Arrays.stream(actual).mapToObj(Long::toString).collect(Collectors.joining())),
        /* cause= */ null);
    this.expected = expected;
    this.actual = actual;
  }

  /**
   * The expected update counts. These were returned to the client application when the DML
   * statements were buffered.
   */
  public long[] getExpected() {
    return Arrays.copyOf(this.expected, this.expected.length);
  }

  /**
   * The actual update counts. These were returned by Spanner to the client when the DML statements
   * were actually executed, and are the update counts that the client application would have
   * received if auto-batching had not been enabled.
   */
  public long[] getActual() {
    return Arrays.copyOf(this.actual, this.actual.length);
  }
}
