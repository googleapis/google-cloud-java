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
import com.google.bigtable.admin.v2.GcRule.Intersection;

/**
 * Builder for creating an Intersection (AND) GC Rule.
 *
 * <p>This class ensures type safety when constructing composite rules, preventing the misuse of the
 * standard builder's ambiguous setters.
 */
public final class IntersectionRuleBuilder {
  private final Intersection.Builder intersectionBuilder = Intersection.newBuilder();

  /**
   * Adds a rule to the intersection.
   *
   * @param rule The rule to add to the intersection.
   * @return The builder instance for chaining.
   */
  public IntersectionRuleBuilder add(GcRule rule) {
    intersectionBuilder.addRules(rule);
    return this;
  }

  /**
   * Builds the final GcRule proto.
   *
   * @return The constructed GcRule proto.
   */
  public GcRule build() {
    return GcRule.newBuilder().setIntersection(intersectionBuilder).build();
  }
}
