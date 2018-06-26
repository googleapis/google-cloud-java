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
    return maxAge(Duration.ofNanos(TimeUnit.NANOSECONDS.convert(maxAge, timeUnit)));
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
  public DefaultRule defaultRule() {
    return new DefaultRule();
  }

  /**
   * Fluent wrapper for {@link Intersection} rule. Allows far adding an hierarchy of rules with
   * intersection as the root
   */
  public static final class IntersectionRule implements GCRule {
    private final List<GCRule> rulesList;

    private IntersectionRule() {
      rulesList = new ArrayList<>();
    }

    /**
     * Adds a new GCRule
     *
     * @param rule
     * @return IntersectionRule
     */
    public IntersectionRule rule(@Nonnull GCRule rule) {
      rulesList.add(rule);
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
      switch (rulesList.size()) {
        case 0:
          return GcRule.newBuilder().build();
        case 1:
          return rulesList.get(0).toProto();
        default:
          return GcRule.newBuilder()
              .setIntersection(Intersection.newBuilder().addAllRules(convertToGcRules(rulesList)))
              .build();
      }
    }
  }

  /**
   * Fluent wrapper for {@link Union} rule. Allows far adding an hierarchy of rules with union as
   * the root
   */
  public static final class UnionRule implements GCRule {
    private final List<GCRule> rulesList;

    private UnionRule() {
      rulesList = new ArrayList<>();
    }

    /**
     * Adds a new GCRule
     *
     * @param rule
     * @return UnionRule
     */
    public UnionRule rule(@Nonnull GCRule rule) {
      rulesList.add(rule);
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
      switch (rulesList.size()) {
        case 0:
          return GcRule.newBuilder().build();
        case 1:
          return rulesList.get(0).toProto();
        default:
          return GcRule.newBuilder()
              .setUnion(Union.newBuilder().addAllRules(convertToGcRules(rulesList)))
              .build();
      }
    }
  }

  /** Wrapper for building max versions rule */
  public static final class VersionRule implements GCRule {
    private final GcRule.Builder builder;

    private VersionRule(int maxVersion) {
      this.builder = GcRule.newBuilder();
      builder.setMaxNumVersions(maxVersion);
    }

    /** Gets the configured maximum versions */
    public int getMaxVersions() {
      return builder.getMaxNumVersions();
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
  public static final class DurationRule implements GCRule {
    private final com.google.protobuf.Duration.Builder builder;

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
      return Duration.ofSeconds(builder.getSeconds(), builder.getNanos());
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
  public static final class DefaultRule implements GCRule {
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

  /** interface for fluent GcRule wrappers */
  public interface GCRule {
    @InternalApi
    GcRule toProto();
  }

  private static List<GcRule> convertToGcRules(List<GCRule> rules) {
    List<GcRule> gcRules = new ArrayList<>(rules.size());

    for (GCRule rule : rules) {
      gcRules.add(rule.toProto());
    }
    return gcRules;
  }
}
