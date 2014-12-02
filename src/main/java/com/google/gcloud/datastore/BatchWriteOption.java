package com.google.gcloud.datastore;

import java.io.Serializable;

public abstract class BatchWriteOption implements Serializable {

  private static final long serialVersionUID = -3932758377282659839L;

  BatchWriteOption() {
    // package protected
  }

  public static final class ForceWrites extends BatchWriteOption {

    private static final long serialVersionUID = 2555054296046232799L;

    private final boolean force;

    public ForceWrites(boolean force) {
      this.force = force;
    }

    public boolean isForce() {
      return force;
    }
  }

  public static ForceWrites forceWrites() {
    return new ForceWrites(true);
  }
}
