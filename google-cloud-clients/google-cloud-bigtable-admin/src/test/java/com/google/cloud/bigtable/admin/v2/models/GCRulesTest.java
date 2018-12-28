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
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.GcRule.Intersection;
import com.google.bigtable.admin.v2.GcRule.Union;
import com.google.cloud.bigtable.admin.v2.models.GCRules.DurationRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.VersionRule;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class GCRulesTest {

  @Test
  public void duration() {
    DurationRule actual = GCRULES.maxAge(Duration.ofSeconds(61, 9));
    GcRule expected = buildAgeRule(61, 9);
    assertNotNull(actual.getMaxAge());
    assertThat(actual.toProto()).isEqualTo(expected);
  }

  @Test
  public void durationSeconds() {
    GcRule actual = GCRULES.maxAge(Duration.ofSeconds(1)).toProto();
    GcRule expected = buildAgeRule(1, 0);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationNanos() {
    GcRule actual = GCRULES.maxAge(Duration.ofNanos(11)).toProto();
    GcRule expected = buildAgeRule(0, 11);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationTimeUnitSeconds() {
    GcRule actual = GCRULES.maxAge(1, TimeUnit.DAYS).toProto();
    GcRule expected = buildAgeRule(3600 * 24, 0);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationTimeUnitMinutes() {
    GcRule actual = GCRULES.maxAge(1, TimeUnit.MINUTES).toProto();
    GcRule expected = buildAgeRule(60, 0);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationTimeUnitNanos() {
    GcRule actual = GCRULES.maxAge(1, TimeUnit.NANOSECONDS).toProto();
    GcRule expected = buildAgeRule(0, 1);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void durationTimeUnitNegative() {
    GcRule actual = GCRULES.maxAge(-1, TimeUnit.MINUTES).toProto();
    GcRule expected = buildAgeRule(-60, 0);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void versions() {
    VersionRule actual = GCRULES.maxVersions(10);
    GcRule expected = buildVersionsRule(10);
    assertNotNull(actual.getMaxVersions());
    assertThat(actual.toProto()).isEqualTo(expected);
  }

  @Test
  public void unionEmpty() {
    GcRule actual = GCRULES.union().toProto();
    GcRule expected = GcRule.newBuilder().build();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionOne() {
    GcRule actual = GCRULES.union().rule(GCRULES.maxVersions(1)).toProto();
    GcRule expected = buildVersionsRule(1);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionTwo() {
    GcRule actual =
        GCRULES
            .union()
            .rule(GCRULES.maxVersions(1))
            .rule(GCRULES.maxAge(Duration.ofSeconds(1)))
            .toProto();

    GcRule expected =
        GcRule.newBuilder()
            .setUnion(
                Union.newBuilder().addRules(buildVersionsRule(1)).addRules(buildAgeRule(1, 0)))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionThree() {
    GcRule actual =
        GCRULES
            .union()
            .rule(GCRULES.maxVersions(1))
            .rule(GCRULES.maxAge(Duration.ofSeconds(1)))
            .rule(GCRULES.maxAge(Duration.ofNanos(1)))
            .toProto();

    GcRule expected =
        GcRule.newBuilder()
            .setUnion(
                Union.newBuilder()
                    .addRules(buildVersionsRule(1))
                    .addRules(buildAgeRule(1, 0))
                    .addRules(buildAgeRule(0, 1)))
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
    GcRule actual = GCRULES.intersection().rule(GCRULES.maxVersions(1)).toProto();
    GcRule expected = buildVersionsRule(1);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void intersectionTwo() {
    GcRule actual =
        GCRULES
            .intersection()
            .rule(GCRULES.maxVersions(1))
            .rule(GCRULES.maxAge(Duration.ofSeconds(1)))
            .toProto();

    GcRule expected =
        GcRule.newBuilder()
            .setIntersection(
                Intersection.newBuilder()
                    .addRules(buildVersionsRule(1))
                    .addRules(buildAgeRule(1, 0)))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void intersectionThree() {
    GcRule actual =
        GCRULES
            .intersection()
            .rule(GCRULES.maxVersions(1))
            .rule(GCRULES.maxAge(Duration.ofSeconds(1)))
            .rule(GCRULES.maxAge(Duration.ofNanos(1)))
            .toProto();

    GcRule expected =
        GcRule.newBuilder()
            .setIntersection(
                Intersection.newBuilder()
                    .addRules(buildVersionsRule(1))
                    .addRules(buildAgeRule(1, 0))
                    .addRules(buildAgeRule(0, 1)))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void unionOfIntersections() {
    UnionRule actual =
        GCRULES
            .union()
            .rule(
                GCRULES
                    .intersection()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))))
            .rule(
                GCRULES
                    .intersection()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))));

    GcRule expected =
        GcRule.newBuilder()
            .setUnion(
                Union.newBuilder()
                    .addRules(
                        GcRule.newBuilder()
                            .setIntersection(
                                Intersection.newBuilder()
                                    .addRules(buildVersionsRule(1))
                                    .addRules(buildAgeRule(1, 0))))
                    .addRules(
                        GcRule.newBuilder()
                            .setIntersection(
                                Intersection.newBuilder()
                                    .addRules(buildVersionsRule(1))
                                    .addRules(buildAgeRule(1, 0)))))
            .build();

    assertEquals(2, actual.getRulesList().size());
    assertThat(actual.toProto()).isEqualTo(expected);
  }

  @Test
  public void intersectionOfUnions() {
    IntersectionRule actual =
        GCRULES
            .intersection()
            .rule(
                GCRULES
                    .union()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))))
            .rule(
                GCRULES
                    .union()
                    .rule(GCRULES.maxVersions(1))
                    .rule(GCRULES.maxAge(Duration.ofSeconds(1))));

    GcRule expected =
        GcRule.newBuilder()
            .setIntersection(
                Intersection.newBuilder()
                    .addRules(
                        GcRule.newBuilder()
                            .setUnion(
                                Union.newBuilder()
                                    .addRules(buildVersionsRule(1))
                                    .addRules(buildAgeRule(1, 0))))
                    .addRules(
                        GcRule.newBuilder()
                            .setUnion(
                                Union.newBuilder()
                                    .addRules(buildVersionsRule(1))
                                    .addRules(buildAgeRule(1, 0)))))
            .build();

    assertEquals(2, actual.getRulesList().size());
    assertThat(actual.toProto()).isEqualTo(expected);
  }

  public static GcRule buildAgeRule(long seconds, int nanos) {
    com.google.protobuf.Duration.Builder duartionBuilder =
        com.google.protobuf.Duration.newBuilder();
    duartionBuilder.setSeconds(seconds);
    duartionBuilder.setNanos(nanos);

    return GcRule.newBuilder().setMaxAge(duartionBuilder).build();
  }

  public static GcRule buildVersionsRule(int maxVer) {
    return GcRule.newBuilder().setMaxNumVersions(maxVer).build();
  }
}
