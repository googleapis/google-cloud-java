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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import org.threeten.bp.Duration;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.GcRule.Intersection;
import com.google.bigtable.admin.v2.GcRule.Union;
import com.google.common.base.MoreObjects;

/** Wraps {@link GcRule} protocol buffer object and exposes a simpler Fluent DSL model */
@BetaApi
public final class GCRules {
  /** Factory method to create GCRules - entry point into the DSL. */
  public static final GCRules GCRULES = new GCRules();

  private GCRules() {}

  /**
   * Creates a new instance of the IntersectionRule
   *
   * @return IntersectionRule
   */
  public IntersectionRule intersection() {
    return new IntersectionRule();
  }

  /**
   * Creates a new instance of the IntersectionRule
   *
   * @return UnionRule
   */
  public UnionRule union() {
    return new UnionRule();
  }

  /**
   * Creates a new instance of the VersionRule
   *
   * @param maxVersion - maximum number of cell versions to keep
   * @return VersionRule
   */
  public VersionRule maxVersions(int maxVersion) {
    return new VersionRule(maxVersion);
  }

  /**
   * Creates a new instance of the DurationRule
   *
   * @param maxAge - maximum age of the cell to keep
   * @param timeUnit - timeunit for the age
   * @return DurationRule
   */
  public DurationRule maxAge(long maxAge, TimeUnit timeUnit) {
    Duration duration = Duration.ZERO;
    TimeUnit.SECONDS.convert(maxAge, timeUnit);
    return maxAge(duration);
  }

  /**
   * Creates a new instance of the DurationRule
   *
   * @param duration - age expressed as duration
   * @return DurationRule
   */
  public DurationRule maxAge(Duration duration) {
    return new DurationRule(duration);
  }

  /**
   * Creates an empty default rule
   *
   * @return DefaultRule
   */
  public DefaultRule defaulRule() {
    return new DefaultRule();
  }

  /**
   * Fluent wrapper for {@link Intersection} rule. Allows far adding an hierarchy of rules with
   * intersection as the root
   */
  public static final class IntersectionRule extends BaseRule {
    private GcRule.Intersection.Builder builder;
    private List<GCRule> rulesList = new ArrayList<>();

    private IntersectionRule() {
      this.builder = GcRule.Intersection.newBuilder();
    }

    /**
     * Adds a new GCRule
     *
     * @param rule
     * @return IntersectionRule
     */
    public IntersectionRule rule(@Nonnull GCRule rule) {
      rulesList.add(rule);
      builder.addRules(rule.toProto());
      return this;
    }

    /**
     * Gets the list of child rules
     *
     * @return List<GCRule>
     */
    public List<GCRule> getRulesList() {
      return rulesList;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("rulesList", rulesList).toString();
    }

    @InternalApi
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

  /**
   * Fluent wrapper for {@link Union} rule. Allows far adding an hierarchy of rules with union as
   * the root
   */
  public static final class UnionRule extends BaseRule {
    private GcRule.Union.Builder builder;
    private List<GCRule> rulesList = new ArrayList<>();

    private UnionRule() {
      this.builder = GcRule.Union.newBuilder();
    }

    /**
     * Adds a new GCRule
     *
     * @param rule
     * @return UnionRule
     */
    public UnionRule rule(@Nonnull GCRule rule) {
      rulesList.add(rule);
      builder.addRules(rule.toProto());
      return this;
    }

    /**
     * Gets the list of child rules
     *
     * @return List<GCRule>
     */
    public List<GCRule> getRulesList() {
      return rulesList;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("rulesList", rulesList).toString();
    }

    @InternalApi
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

  /** Wrapper for building max versions rule */
  public static final class VersionRule extends BaseRule {
    private GcRule.Builder builder;

    private VersionRule(int maxVersion) {
      this.builder = GcRule.newBuilder();
      builder.setMaxNumVersions(maxVersion);
    }

    /** Gets the configured maximum versions */
    public int getMaxVersions() {
      return toProto().getMaxNumVersions();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("maxNumVersions", getMaxVersions()).toString();
    }

    @InternalApi
    @Override
    public GcRule toProto() {
      return builder.build();
    }
  }

  /** Wrapper for building max duration rule */
  public static final class DurationRule extends BaseRule {
    private com.google.protobuf.Duration.Builder builder;

    private DurationRule(Duration duration) {
      this.builder =
          com.google.protobuf.Duration.newBuilder()
              .setSeconds(duration.getSeconds())
              .setNanos(duration.getNano());
    }

    /**
     * Gets the configured maximum age
     *
     * @return Duration
     */
    public Duration getMaxAge() {
      long seconds = toProto().getMaxAge().getSeconds();
      int nanos = toProto().getMaxAge().getNanos();
      return Duration.ofSeconds(seconds, nanos);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("maxAge", getMaxAge()).toString();
    }

    @InternalApi
    @Override
    public GcRule toProto() {
      return GcRule.newBuilder().setMaxAge(builder.build()).build();
    }
  }

  /** Wrapper for building a empty rule */
  public static final class DefaultRule extends BaseRule {
    private DefaultRule() {}

    @InternalApi
    @Override
    public GcRule toProto() {
      return GcRule.getDefaultInstance();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).toString();
    }
  }

  /** Helpers to support casting rules the Type, when the Type is known */
  public abstract static class BaseRule implements GCRule {

    /** Casts the rule to DurationRule. On failure throws a ClassCastException */
    public DurationRule getDurationOrThow() {
      return (DurationRule) this;
    }

    /** Casts the rule to VersionRule. On failure throws a ClassCastException */
    public VersionRule getVersionOrThow() {
      return (VersionRule) this;
    }

    /** Casts the rule to UnionRule. On failure throws a ClassCastException */
    public UnionRule getUnionOrThow() {
      return (UnionRule) this;
    }

    /** Casts the rule to IntersectionRule. On failure throws a ClassCastException */
    public IntersectionRule getIntersectionOrThow() {
      return (IntersectionRule) this;
    }
  }

  /** interface for fluent GcRule wrappers */
  public interface GCRule {
    DurationRule getDurationOrThow();

    VersionRule getVersionOrThow();

    UnionRule getUnionOrThow();

    IntersectionRule getIntersectionOrThow();

    @InternalApi
    GcRule toProto();
  }
}
