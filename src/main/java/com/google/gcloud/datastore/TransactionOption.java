package com.google.gcloud.datastore;

import java.io.Serializable;

public abstract class TransactionOption implements Serializable {

  private static final long serialVersionUID = -1862234444015690375L;


  TransactionOption() {
    // package protected
  }

  public static final class IsolationLevel extends TransactionOption {

    private static final long serialVersionUID = -5592165378565409515L;

    private final Level level;

    public enum Level {
      SERIALIZABLE, SNAPSHOT;
    }

    public IsolationLevel(Level level) {
      this.level = level;
    }

    public Level getLevel() {
      return level;
    }
  }

  public static final class ForceWrites extends TransactionOption {

    private static final long serialVersionUID = 7448106703678852594L;

    private final boolean force;

    public ForceWrites(boolean force) {
      this.force = force;
    }

    public boolean isForce() {
      return force;
    }
  }

  public static IsolationLevel serializable() {
    return new IsolationLevel(IsolationLevel.Level.SERIALIZABLE);
  }

  public static IsolationLevel snapshot() {
    return new IsolationLevel(IsolationLevel.Level.SNAPSHOT);
  }

  public static ForceWrites forceWrites() {
    return new ForceWrites(true);
  }
}
