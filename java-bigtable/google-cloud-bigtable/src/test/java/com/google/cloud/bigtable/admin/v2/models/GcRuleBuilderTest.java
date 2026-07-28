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

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.GcRule;
import com.google.protobuf.util.Durations;
import java.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GcRuleBuilderTest {

  @Test
  public void maxAge_createsCorrectProto() {
    GcRule rule = GcRuleBuilder.maxAge(Duration.ofHours(1));

    assertThat(rule.hasMaxAge()).isTrue();
    assertThat(rule.getMaxAge()).isEqualTo(Durations.fromHours(1));
  }

  @Test
  public void maxVersions_createsCorrectProto() {
    GcRule rule = GcRuleBuilder.maxVersions(5);

    assertThat(rule.hasMaxNumVersions()).isTrue();
    assertThat(rule.getMaxNumVersions()).isEqualTo(5);
  }

  @Test
  public void intersection_buildsNestedRules() {
    // Expected Proto structure
    GcRule expected =
        GcRule.newBuilder()
            .setIntersection(
                GcRule.Intersection.newBuilder()
                    .addRules(GcRule.newBuilder().setMaxNumVersions(1).build())
                    .addRules(GcRule.newBuilder().setMaxAge(Durations.fromHours(2)).build()))
            .build();

    // Using the new Builder
    GcRule actual =
        GcRuleBuilder.intersection()
            .add(GcRuleBuilder.maxVersions(1))
            .add(GcRuleBuilder.maxAge(Duration.ofHours(2)))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void union_buildsNestedRules() {
    // Expected Proto structure
    GcRule expected =
        GcRule.newBuilder()
            .setUnion(
                GcRule.Union.newBuilder()
                    .addRules(GcRule.newBuilder().setMaxNumVersions(10).build())
                    .addRules(GcRule.newBuilder().setMaxAge(Durations.fromDays(5)).build()))
            .build();

    // Using the new Builder
    GcRule actual =
        GcRuleBuilder.union()
            .add(GcRuleBuilder.maxVersions(10))
            .add(GcRuleBuilder.maxAge(Duration.ofDays(5)))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void nestedComplexRules_workCorrectly() {
    // Expected Proto structure: Union of (Version(1) OR Intersection(Age(1h) AND Version(5)))
    GcRule expected =
        GcRule.newBuilder()
            .setUnion(
                GcRule.Union.newBuilder()
                    .addRules(GcRule.newBuilder().setMaxNumVersions(1).build())
                    .addRules(
                        GcRule.newBuilder()
                            .setIntersection(
                                GcRule.Intersection.newBuilder()
                                    .addRules(
                                        GcRule.newBuilder()
                                            .setMaxAge(Durations.fromHours(1))
                                            .build())
                                    .addRules(GcRule.newBuilder().setMaxNumVersions(5).build())
                                    .build())
                            .build())
                    .build())
            .build();

    // Using the new Builder
    GcRule actual =
        GcRuleBuilder.union()
            .add(GcRuleBuilder.maxVersions(1))
            .add(
                GcRuleBuilder.intersection()
                    .add(GcRuleBuilder.maxAge(Duration.ofHours(1)))
                    .add(GcRuleBuilder.maxVersions(5))
                    .build())
            .build();

    // Verify the structure matches the raw proto construction
    assertThat(actual).isEqualTo(expected);

    // Verify specific properties
    assertThat(actual.getUnion().getRulesCount()).isEqualTo(2);
    assertThat(actual.getUnion().getRules(1).getIntersection().getRulesCount()).isEqualTo(2);
  }
}
