package com.google.cloud.spanner;

/**
 * Interface for simulating an aborted read/write transaction in test code. You should only use this
 * class in test cases to verify that your code handles aborted exceptions correctly.
 *
 * <p>DO NOT USE IN PRODUCTION CODE.
 */
public interface AbortedTransactionInjector {
  /**
   * @return <code>true</code> if the client library should simulate that the current transaction
   *     was aborted by Cloud Spanner. Use this method to simulate an aborted transaction in your
   *     test code to ensure that your code can handle aborted transaction correctly.
   */
  boolean shouldAbort();

  /** Instructs the injector to simulate an aborted transaction once on the next database call. */
  public void injectAbortOnce();
}
