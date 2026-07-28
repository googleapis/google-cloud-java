/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.admin.v2.models;

import com.google.bigtable.admin.v2.GcRule;
import com.google.protobuf.util.Durations;
import java.time.Duration;

/**
 * Factory for creating safe GcRule protos.
 *
 * <p>Use this class to construct {@link GcRule} instances instead of the raw proto builder ({@link
 * GcRule#newBuilder()}) to avoid common pitfalls with "oneof" fields (e.g. accidentally overwriting
 * max age with max versions).
 */
public final class GcRuleBuilder {
  private GcRuleBuilder() {} // Static utility

  // Entry points for composite rules

  /**
   * Starts building an Intersection (AND) rule.
   *
   * @return A new builder for an intersection rule.
   */
  public static IntersectionRuleBuilder intersection() {
    return new IntersectionRuleBuilder();
  }

  /**
   * Starts building a Union (OR) rule.
   *
   * @return A new builder for a union rule.
   */
  public static UnionRuleBuilder union() {
    return new UnionRuleBuilder();
  }

  // Entry points for simple rules (return the Proto directly)

  /**
   * Creates a Max Age rule.
   *
   * @param age The maximum age of the cell.
   * @return The constructed GcRule proto.
   */
  public static GcRule maxAge(Duration age) {
    long seconds = age.getSeconds();
    int nanos = age.getNano();
    return GcRule.newBuilder()
        .setMaxAge(Durations.fromNanos(seconds * 1_000_000_000L + nanos))
        .build();
  }

  /**
   * Creates a Max Versions rule.
   *
   * @param versions The maximum number of versions.
   * @return The constructed GcRule proto.
   */
  public static GcRule maxVersions(int versions) {
    return GcRule.newBuilder().setMaxNumVersions(versions).build();
  }
}
