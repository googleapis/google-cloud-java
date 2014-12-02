package com.google.gcloud.datastore;

public class DatastoreServiceException extends RuntimeException {

  private static final long serialVersionUID = 8170357898917041899L;

  private final boolean isTransient;

  public DatastoreServiceException(boolean isTransient, String msg, Exception cause) {
    super(msg, cause);
    this.isTransient = isTransient;
  }

  /**
   * @return {@code true} if this exception is transient and could be safely retried.
   */
  public boolean isTransient() {
    return isTransient;
  }
}
