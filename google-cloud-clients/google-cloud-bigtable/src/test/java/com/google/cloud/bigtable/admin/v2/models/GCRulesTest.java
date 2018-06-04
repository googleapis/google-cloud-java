/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.GcRule.Intersection;
import com.google.bigtable.admin.v2.GcRule.Union;
import com.google.protobuf.Duration;

@RunWith(JUnit4.class)
public class GCRulesTest {

  @Test
  public void duration() {
    GcRule actual = GCRULES.age().seconds(61).nanos(9).toProto();

    GcRule expected = buildAgeRule(61, 9);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationSeconds() {
    GcRule actual = GCRULES.age().seconds(1).toProto();

    GcRule expected = buildAgeRule(1, -1);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationNanos() {
    GcRule actual = GCRULES.age().nanos(11).toProto();

    GcRule expected = buildAgeRule(-1, 11);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationOverwrite() {
    GcRule actual = GCRULES.age().seconds(61).nanos(9).seconds(1).nanos(5).seconds(4).toProto();

    GcRule expected = buildAgeRule(4, 5);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void versions() {
    GcRule actual = GCRULES.versions().maxNum(10).toProto();

    GcRule expected = buildVersionsRule(10);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionEmpty() {
    GcRule actual = GCRULES.union().toProto();

    GcRule expected = GcRule.newBuilder().build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionOne() {
    GcRule actual = GCRULES.union().rule(GCRULES.versions().maxNum(1)).toProto();

    GcRule expected = buildVersionsRule(1);;

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionTwo() {
    GcRule actual =
        GCRULES.union().rule(GCRULES.versions().maxNum(1)).rule(GCRULES.age().seconds(1)).toProto();

    GcRule expected =
        GcRule.newBuilder()
              .setUnion(
                  Union.newBuilder().addRules(buildVersionsRule(1)).addRules(buildAgeRule(1, -1)))
              .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionThree() {
    GcRule actual = GCRULES.union().rule(GCRULES.versions().maxNum(1))
                           .rule(GCRULES.age().seconds(1)).rule(GCRULES.age().nanos(1)).toProto();

    GcRule expected =
        GcRule.newBuilder()
              .setUnion(Union.newBuilder().addRules(buildVersionsRule(1))
                             .addRules(buildAgeRule(1, -1)).addRules(buildAgeRule(-1, 1)))
              .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void intersectionEmpty() {
    GcRule actual = GCRULES.intersection().toProto();

    GcRule expected = GcRule.newBuilder().build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void intersectionOne() {
    GcRule actual = GCRULES.intersection().rule(GCRULES.versions().maxNum(1)).toProto();

    GcRule expected = buildVersionsRule(1);;

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void intersectionTwo() {
    GcRule actual = GCRULES.intersection().rule(GCRULES.versions().maxNum(1))
                           .rule(GCRULES.age().seconds(1)).toProto();

    GcRule expected = GcRule.newBuilder().setIntersection(
        Intersection.newBuilder().addRules(buildVersionsRule(1)).addRules(buildAgeRule(1, -1)))
                            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void intersectionThree() {
    GcRule actual = GCRULES.intersection().rule(GCRULES.versions().maxNum(1))
                           .rule(GCRULES.age().seconds(1)).rule(GCRULES.age().nanos(1)).toProto();

    GcRule expected =
        GcRule.newBuilder()
              .setIntersection(
                  Intersection.newBuilder().addRules(buildVersionsRule(1))
                              .addRules(buildAgeRule(1, -1)).addRules(buildAgeRule(-1, 1)))
              .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void UnionOfIntersections() {
    GcRule actual = GCRULES.union()
                           .rule(GCRULES.intersection().rule(GCRULES.versions().maxNum(1))
                                        .rule(GCRULES.age().seconds(1)))
                           .rule(GCRULES.intersection().rule(GCRULES.versions().maxNum(1))
                                        .rule(GCRULES.age().seconds(1)))
                           .toProto();

    GcRule expected =
        GcRule.newBuilder()
              .setUnion(Union.newBuilder().addRules(
                  GcRule.newBuilder().setIntersection(
                      Intersection.newBuilder().addRules(buildVersionsRule(1))
                                  .addRules(buildAgeRule(1, -1))))
                             .addRules(GcRule.newBuilder().setIntersection(
                                 Intersection.newBuilder().addRules(buildVersionsRule(1))
                                             .addRules(buildAgeRule(1, -1)))))
              .build();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void IntersectionOfUnion() {
    GcRule actual = GCRULES.intersection()
                           .rule(GCRULES.union().rule(GCRULES.versions().maxNum(1))
                                        .rule(GCRULES.age().seconds(1)))
                           .rule(GCRULES.union().rule(GCRULES.versions().maxNum(1))
                                        .rule(GCRULES.age().seconds(1)))
                           .toProto();

    GcRule expected = GcRule.newBuilder().setIntersection(
        Intersection.newBuilder()
                    .addRules(
                        GcRule.newBuilder()
                              .setUnion(Union.newBuilder().addRules(buildVersionsRule(1))
                                             .addRules(buildAgeRule(1, -1))))
                    .addRules(GcRule.newBuilder()
                                    .setUnion(Union.newBuilder().addRules(buildVersionsRule(1))
                                                   .addRules(buildAgeRule(1, -1)))))
                            .build();
    assertThat(actual).isEqualTo(expected);
  }

  private GcRule buildAgeRule(int seconds, int nanos) {
    Duration.Builder duartionBuilder = Duration.newBuilder();

    if (seconds > -1) {
      duartionBuilder.setSeconds(seconds);
    }

    if (nanos > -1) {
      duartionBuilder.setNanos(nanos);
    }

    return GcRule.newBuilder().setMaxAge(duartionBuilder).build();
  }

  private GcRule buildVersionsRule(int maxVer) {
    return GcRule.newBuilder().setMaxNumVersions(maxVer).build();
  }
}
