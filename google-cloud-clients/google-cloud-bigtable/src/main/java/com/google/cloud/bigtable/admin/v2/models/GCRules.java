package com.google.cloud.bigtable.admin.v2.models;

import javax.annotation.Nonnull;
import com.google.bigtable.admin.v2.GcRule;
import com.google.common.base.Preconditions;
import com.google.protobuf.Duration;

public final class GCRules {
  public static final GCRules GCRULES = new GCRules();
  
  private GCRules() {}
  
  public IntersectionRule intersection() {
    return new IntersectionRule();
  }

  public UnionRule union() {
    return new UnionRule();
  }

  public VersionRule versions() {
    return new VersionRule();
  }
  
  public DurationRule age() {
    return new DurationRule();
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
    private GcRule.Builder builder ;
    
    private VersionRule() {
     this.builder = GcRule.newBuilder();
    }
    
    public VersionRule maxNum(int value) {
      Preconditions.checkNotNull(value);
      builder.setMaxNumVersions(value);
      return this;
    }

    @Override
    public GcRule toProto() {
      return builder.build();
    }
  }

  public static final class DurationRule implements GCRule {
    private Duration.Builder builder;
    
    private DurationRule() {
      this.builder = Duration.newBuilder();
    }
    
    public DurationRule seconds(long value) {
      Preconditions.checkNotNull(value);
      builder.setSeconds(value);
      return this;
    }

    public DurationRule nanos(int value) {
      Preconditions.checkNotNull(value);
      builder.setNanos(value);
      return this;
    }

    @Override
    public GcRule toProto() {
      return GcRule.newBuilder().setMaxAge(builder.build()).build();
    }
  }

  interface GCRule extends Cloneable {
    GcRule toProto();
  }
}
