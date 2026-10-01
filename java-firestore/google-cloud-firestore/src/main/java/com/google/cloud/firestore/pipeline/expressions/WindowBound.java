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

package com.google.cloud.firestore.pipeline.expressions;

import java.util.Objects;

/**
 * A symbolic window frame boundary, as opposed to a numeric offset.
 *
 * <p>Use {@link #CURRENT} and {@link #UNBOUNDED} for symbolic bounds, and plain numbers for
 * offsets:
 *
 * <pre>{@code
 * new WindowSpec().documents(WindowBound.UNBOUNDED, WindowBound.CURRENT) // symbolic
 * new WindowSpec().range(30, WindowBound.CURRENT, "day")                 // mixed
 * new WindowSpec().documents(-1, 2)                                      // numeric offsets
 * }</pre>
 *
 * <p>In a {@link WindowSpec#documents documents} frame, {@link #CURRENT} refers strictly to the
 * current document's position (ties are not included, equivalent to a numeric offset of {@code 0}).
 * In a {@link WindowSpec#range range} frame, {@link #CURRENT} is peer-inclusive (like SQL {@code
 * CURRENT ROW} in {@code RANGE} mode): it includes all documents whose sort value(s) tie with the
 * current document (also semantically equivalent to a numeric offset of {@code 0}, though {@link
 * #CURRENT} is encoded on the wire as {@code "current"} rather than {@code 0}). Given documents
 * with sort values {@code [10, 10, 20]} and {@code range(UNBOUNDED, CURRENT)}, the frame for either
 * {@code 10} document includes both {@code 10} documents (2 documents), and for {@code 20} includes
 * all 3 documents.
 */
public final class WindowBound {
  private final String protoString;

  private WindowBound(String protoString) {
    this.protoString = protoString;
  }

  /**
   * The current document's position in a {@code documents} frame, or the current document and its
   * tied peers in a {@code range} frame.
   */
  public static final WindowBound CURRENT = new WindowBound("current");

  /** No boundary in this direction. */
  public static final WindowBound UNBOUNDED = new WindowBound("unbounded");

  /** The wire representation of this boundary. */
  String wireName() {
    return protoString;
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || (other instanceof WindowBound
            && Objects.equals(protoString, ((WindowBound) other).protoString));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(protoString);
  }

  @Override
  public String toString() {
    return protoString;
  }
}
