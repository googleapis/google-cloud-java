package com.google.cloud.spanner;

public class SpannerBatchUpdateException extends SpannerException {
  private long[] updateCounts;
  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  SpannerBatchUpdateException(
      DoNotConstructDirectly token,
      ErrorCode code,
      String message,
      long[] counts) {
    super(token, code, false, message, null);
    updateCounts = counts;
  }

  /**
   * Returns the number of rows affected by each statement that is successfully run.
   */
  public long[] getUpdateCounts() {
    return updateCounts;
  }
}
