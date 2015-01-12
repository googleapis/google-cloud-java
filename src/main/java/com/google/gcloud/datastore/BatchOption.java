package com.google.gcloud.datastore;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public abstract class BatchOption implements java.io.Serializable {

  private static final long serialVersionUID = -3932758377282659839L;

  public static final class ForceWrites extends BatchOption {

    private static final long serialVersionUID = 2555054296046232799L;

    private final boolean force;

    public ForceWrites(boolean force) {
      this.force = force;
    }

    public boolean force() {
      return force;
    }
  }

  BatchOption() {
    // package protected
  }

  public static ForceWrites forceWrites() {
    return new ForceWrites(true);
  }

  static Map<Class<? extends BatchOption>, BatchOption> asImmutableMap(BatchOption... options) {
    ImmutableMap.Builder<Class<? extends BatchOption>, BatchOption> builder =
        ImmutableMap.builder();
    for (BatchOption option : options) {
      builder.put(option.getClass(), option);
    }
    return builder.build();
  }
}
