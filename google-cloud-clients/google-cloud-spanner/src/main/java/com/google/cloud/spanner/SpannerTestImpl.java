/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.api.client.util.Preconditions;
import com.google.cloud.spanner.SpannerOptions.SpannerTestOptions;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.protobuf.ByteString;
import java.util.Map;
import javax.annotation.Nullable;

class SpannerTestImpl extends SpannerImpl {
  private final SpannerTestOptions testOptions;

  SpannerTestImpl(SpannerOptions options) {
    super(options);
    Preconditions.checkNotNull(options.getSpannerTestOptions());
    this.testOptions = options.getSpannerTestOptions();
  }

  @Override
  SessionImpl newSession(String name, Map<SpannerRpc.Option, ?> options) {
    return new SessionTestImpl(name, options);
  }

  class SessionTestImpl extends SessionImpl {
    SessionTestImpl(String name, Map<Option, ?> options) {
      super(name, options);
    }

    @Override
    TransactionContextImpl newTransaction() {
      if (testOptions.getAbortedTransactionInjector() == null) {
        return super.newTransaction();
      }
      return new TransactionContextWithSimulatedAbortsImpl(
          this,
          getReadyTransactionId(),
          (SpannerRpc) SpannerTestImpl.this.getOptions().getRpc(),
          SpannerTestImpl.this.getOptions().getPrefetchChunks(),
          testOptions.getAbortedTransactionInjector());
    }
  }

  /**
   * {@link TransactionContext} that is used when an {@link AbortedTransactionInjector} has been
   * registered on this {@link SpannerImpl}.
   */
  static class TransactionContextWithSimulatedAbortsImpl extends TransactionContextImpl {
    private final class InjectedResultSet extends ForwardingResultSet {
      private InjectedResultSet(ResultSet delegate) {
        super(delegate);
      }

      @Override
      public boolean next() {
        TransactionContextWithSimulatedAbortsImpl.this.aborted = aborted || injector.shouldAbort();
        checkAndThrowInjectedAbort();
        return super.next();
      }
    }

    private final AbortedTransactionInjector injector;
    private boolean aborted = false;

    TransactionContextWithSimulatedAbortsImpl(
        SessionImpl session,
        @Nullable ByteString transactionId,
        SpannerRpc rpc,
        int defaultPrefetchChunks,
        AbortedTransactionInjector injector) {
      super(session, transactionId, rpc, defaultPrefetchChunks);
      Preconditions.checkNotNull(injector);
      this.injector = injector;
    }

    private void checkAndThrowInjectedAbort() {
      if (aborted) {
        SpannerException e =
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.ABORTED, "Transaction abort was injected");
        onError(e);
        throw e;
      }
    }

    @Override
    void commit() {
      this.aborted = aborted || injector.shouldAbort();
      checkAndThrowInjectedAbort();
      super.commit();
    }

    @Override
    void beforeReadOrQuery() {
      super.beforeReadOrQuery();
      this.aborted = aborted || injector.shouldAbort();
      checkAndThrowInjectedAbort();
    }

    @Override
    ResultSet executeQueryInternalWithOptions(
        Statement statement,
        com.google.spanner.v1.ExecuteSqlRequest.QueryMode queryMode,
        Options readOptions,
        ByteString partitionToken) {
      return new InjectedResultSet(
          super.executeQueryInternalWithOptions(statement, queryMode, readOptions, partitionToken));
    }
  }
}
