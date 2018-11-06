/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.base.Preconditions;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// TODO(hzyi): add a public FakeOperationSnapshot in gax to support testing
class OperationFutureUtil {

  private OperationFutureUtil() {
    // Utility class
  }

  public static class FakeStatusCode implements StatusCode {
    private final Code code;

    public FakeStatusCode(Code code) {
      this.code = code;
    }

    @Override
    public Code getCode() {
      return code;
    }

    @Override
    public Code getTransportCode() {
      return getCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      FakeStatusCode that = (FakeStatusCode) o;

      return code == that.code;
    }

    @Override
    public int hashCode() {
      return code != null ? code.hashCode() : 0;
    }

    public static FakeStatusCode of(Code code) {
      return new FakeStatusCode(code);
    }
  }

  public static final <ResponseT extends Message, MetadataT extends Message>
      OperationSnapshot completedSnapshot(
          final String name, final ResponseT response, final MetadataT metadata) {
    return new OperationSnapshot() {
      @Override
      public String getName() {
        return name;
      }

      @Override
      public Object getMetadata() {
        return Any.pack(metadata);
      }

      @Override
      public Object getResponse() {
        return Any.pack(response);
      }

      @Override
      public boolean isDone() {
        return true;
      }

      @Override
      public StatusCode getErrorCode() {
        return FakeStatusCode.of(StatusCode.Code.OK);
      }

      @Override
      public String getErrorMessage() {
        return null;
      }
    };
  }

  /** Already-completed {@code ImmediateRetryingFuture}, useful for testing. */
  public static final class ImmediateRetryingFuture<V> implements RetryingFuture<V> {

    private final ApiFuture<V> immediateFuture;
    private ApiFuture<V> attemptFuture;

    ImmediateRetryingFuture(V response) {
      this.immediateFuture = ApiFutures.immediateFuture(response);
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
      immediateFuture.addListener(runnable, executor);
    }

    @Override
    public V get(long time, TimeUnit unit)
        throws ExecutionException, InterruptedException, TimeoutException {
      return get();
    }

    @Override
    public V get() throws ExecutionException, InterruptedException {
      return immediateFuture.get();
    }

    @Override
    public boolean isDone() {
      return true;
    }

    @Override
    public boolean isCancelled() {
      return false;
    }

    @Override
    public boolean cancel(boolean b) {
      return false;
    }

    @Override
    public void setAttemptFuture(ApiFuture<V> attemptFuture) {
      this.attemptFuture = attemptFuture;
    }

    @Override
    public ApiFuture<V> getAttemptResult() {
      return this.attemptFuture;
    }

    @Override
    public TimedAttemptSettings getAttemptSettings() {
      throw new UnsupportedOperationException("Not implemented: getAttemptSettings()");
    }

    @Override
    public Callable<V> getCallable() {
      throw new UnsupportedOperationException("Not implemented: getCallable()");
    }

    @Override
    public ApiFuture<V> peekAttemptResult() {
      return this.attemptFuture;
    }
  }

  public static final <ResponseT> RetryingFuture<ResponseT> immediateRetryingFuture(
      final ResponseT response) {
    return new ImmediateRetryingFuture(response);
  }

  public static final <ResponseT extends Message, MetadataT extends Message>
      OperationFuture<ResponseT, MetadataT> immediateOperationFuture(
          final String name, final ResponseT response, final MetadataT metadata) {
    return immediateOperationFuture(completedSnapshot(name, response, metadata));
  }

  /**
   * Creates an already-completed {@code OperationFuture}, useful for testing.
   *
   * <p>{@code completedSnapshot.isDone()} must return true. The snapshot's {@code getResponse()}
   * and {@code getMetadata()} must be instances of {@code ResponseT} and {@code MetadataT},
   * respectively.
   */
  @SuppressWarnings("unchecked")
  public static final <ResponseT, MetadataT>
      OperationFuture<ResponseT, MetadataT> immediateOperationFuture(
          final OperationSnapshot completedSnapshot) {

    Preconditions.checkArgument(
        completedSnapshot.isDone(), "given snapshot must already be completed");
    final ApiFuture<MetadataT> metadataFuture =
        ApiFutures.immediateFuture((MetadataT) completedSnapshot.getMetadata());
    final ApiFuture<OperationSnapshot> initialFuture =
        ApiFutures.immediateFuture(completedSnapshot);
    final RetryingFuture<OperationSnapshot> pollingFuture =
        immediateRetryingFuture(completedSnapshot);

    return new OperationFuture<ResponseT, MetadataT>() {
      @Override
      public String getName() {
        return completedSnapshot.getName();
      }

      @Override
      public ApiFuture<MetadataT> getMetadata() {
        return metadataFuture;
      }

      @Override
      public ApiFuture<MetadataT> peekMetadata() {
        return metadataFuture;
      }

      @Override
      public ApiFuture<OperationSnapshot> getInitialFuture() {
        return initialFuture;
      }

      @Override
      public RetryingFuture<OperationSnapshot> getPollingFuture() {
        return pollingFuture;
      }

      @Override
      public void addListener(Runnable runnable, Executor executor) {
        pollingFuture.addListener(runnable, executor);
      }

      @Override
      public ResponseT get(long time, TimeUnit unit)
          throws ExecutionException, InterruptedException, TimeoutException {
        return get();
      }

      @Override
      public ResponseT get() throws ExecutionException, InterruptedException {
        return (ResponseT) pollingFuture.get().getResponse();
      }

      @Override
      public boolean isDone() {
        return true;
      }

      @Override
      public boolean isCancelled() {
        return false;
      }

      @Override
      public boolean cancel(boolean b) {
        return false;
      }
    };
  }
}
