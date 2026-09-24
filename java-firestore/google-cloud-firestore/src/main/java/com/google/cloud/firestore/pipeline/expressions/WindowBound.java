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

/**
 * A symbolic window frame boundary, as opposed to a numeric offset.
 *
 * <p>Use these constants (or the {@link WindowSpec#CURRENT} / {@link WindowSpec#UNBOUNDED} aliases)
 * for symbolic bounds, and plain numbers for offsets:
 *
 * <pre>{@code
 * WindowSpec.documents(WindowSpec.UNBOUNDED, WindowSpec.CURRENT) // symbolic
 * WindowSpec.range(30, WindowSpec.CURRENT, "day")                // mixed
 * WindowSpec.documents(-1, 2)                                    // numeric offsets
 * }</pre>
 *
 * <p>Note that a numeric offset of {@code 0} is <i>not</i> equivalent to {@link #CURRENT}: in a
 * {@code range} frame, {@link #CURRENT} cuts off strictly at the current document's position, while
 * an offset of {@code 0} includes every document whose sort value ties with the current one. Given
 * documents with sort values {@code [10, 10, 10]}, a frame evaluated at the second document with an
 * unbounded lower bound yields the first two documents under {@link #CURRENT}, but all three under
 * an offset of {@code 0}.
 */
public enum WindowBound {
  /** The current document's position in the frame. */
  CURRENT,

  /** No boundary in this direction. */
  UNBOUNDED;

  /** The wire representation of this boundary. */
  String wireName() {
    switch (this) {
      case CURRENT:
        return "current";
      case UNBOUNDED:
        return "unbounded";
      default:
        throw new AssertionError("Unreachable: " + this);
    }
  }
}
