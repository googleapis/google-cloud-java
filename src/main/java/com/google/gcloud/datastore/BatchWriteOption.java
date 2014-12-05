package com.google.gcloud.datastore;

import java.io.Serializable;

public abstract class BatchWriteOption implements Serializable {

  private static final long serialVersionUID = -3932758377282659839L;

  public static final class ForceWrites extends BatchWriteOption {

    private static final long serialVersionUID = 2555054296046232799L;

    private final boolean force;

    public ForceWrites(boolean force) {
      this.force = force;
    }

    public boolean force() {
      return force;
    }

    @Override
    void apply(BatchWriterImpl batchWriter) {
      batchWriter.apply(this);
    }
  }

  BatchWriteOption() {
    // package protected
  }

  abstract void apply(BatchWriterImpl batchWriter);

  public static ForceWrites forceWrites() {
    return new ForceWrites(true);
  }
}
