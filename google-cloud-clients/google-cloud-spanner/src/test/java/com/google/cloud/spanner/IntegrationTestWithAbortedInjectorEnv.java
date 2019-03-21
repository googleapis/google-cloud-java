package com.google.cloud.spanner;

import com.google.cloud.spanner.SpannerOptions.SpannerTestOptions;

public class IntegrationTestWithAbortedInjectorEnv extends IntegrationTestEnv {
  private final AbortedTransactionInjectorImpl injector = new AbortedTransactionInjectorImpl();

  public AbortedTransactionInjectorImpl getAbortedTransactionInjector() {
    return injector;
  }

  @Override
  protected SpannerTestOptions createSpannerTestOptions(SpannerTestOptions testOptions) {
    return testOptions.toBuilder().setAbortedTransactionInjector(injector).build();
  }

  /** Injects simulated aborted transaction. */
  public static final class AbortedTransactionInjectorImpl implements AbortedTransactionInjector {
    private boolean injectAbortOnce = false;

    @Override
    public boolean shouldAbort() {
      if (injectAbortOnce) {
        injectAbortOnce = false;
        return true;
      }
      return false;
    }

    @Override
    public void injectAbortOnce() {
      this.injectAbortOnce = true;
    }
  }
}
