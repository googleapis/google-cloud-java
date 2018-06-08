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

import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import org.threeten.bp.Duration;
import com.google.bigtable.admin.v2.GcRule;

public final class GCRules {
  public static final GCRules GCRULES = new GCRules();

  private GCRules() {}

  public IntersectionRule intersection() {
    return new IntersectionRule();
  }

  public UnionRule union() {
    return new UnionRule();
  }

  public VersionRule maxVersions(int maxVersion) {
    return new VersionRule(maxVersion);
  }

  public DurationRule maxAge(long maxAge, TimeUnit timeUnit) {
    Duration duration = Duration.ZERO;
    TimeUnit.SECONDS.convert(maxAge, timeUnit);
    return maxAge(duration);
  }

  public DurationRule maxAge(Duration duration) {
    return new DurationRule(duration);
  }

  public DefaultRule defaulRule() {
    return new DefaultRule();
  }

  public static final class IntersectionRule implements GCRule {
    private GcRule.Intersection.Builder builder;

    private IntersectionRule() {
      this.builder = GcRule.Intersection.newBuilder();
    }

    public IntersectionRule rule(@Nonnull GCRule rule) {
      builder.addRules(rule.toProto());
      return this;
    }

    @Override
    public GcRule toProto() {
      switch (builder.getRulesCount()) {
        case 0:
          return GcRule.newBuilder().build();
        case 1:
          return builder.getRules(0);
        default:
          return GcRule.newBuilder().setIntersection(builder.build()).build();
      }
    }
  }

  public static final class UnionRule implements GCRule {
    private GcRule.Union.Builder builder;

    private UnionRule() {
      this.builder = GcRule.Union.newBuilder();
    }

    public UnionRule rule(@Nonnull GCRule rule) {
      builder.addRules(rule.toProto());
      return this;
    }

    @Override
    public GcRule toProto() {
      switch (builder.getRulesCount()) {
        case 0:
          return GcRule.newBuilder().build();
        case 1:
          return builder.getRules(0);
        default:
          return GcRule.newBuilder().setUnion(builder.build()).build();
      }
    }
  }

  public static final class VersionRule implements GCRule {
    private GcRule.Builder builder;

    private VersionRule(int maxVersion) {
      this.builder = GcRule.newBuilder();
      builder.setMaxNumVersions(maxVersion);
    }

    @Override
    public GcRule toProto() {
      return builder.build();
    }
  }

  public static final class DurationRule implements GCRule {
    private com.google.protobuf.Duration.Builder builder;

    private DurationRule(Duration duration) {
      this.builder =
          com.google.protobuf.Duration.newBuilder()
              .setSeconds(duration.getSeconds())
              .setNanos(duration.getNano());
    }

    @Override
    public GcRule toProto() {
      return GcRule.newBuilder().setMaxAge(builder.build()).build();
    }
  }

  public static final class DefaultRule implements GCRule {
    private DefaultRule() {}

    @Override
    public GcRule toProto() {
      return GcRule.getDefaultInstance();
    }
  }

  interface GCRule {
    GcRule toProto();
  }
}
