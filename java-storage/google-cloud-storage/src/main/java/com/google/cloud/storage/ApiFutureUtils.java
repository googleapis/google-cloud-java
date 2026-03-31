/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A set of utility methods for working with {@link com.google.api.core.ApiFuture ApiFutures} that
 * aren't already provided by {@link com.google.api.core.ApiFutures}
 */
final class ApiFutureUtils {

  private ApiFutureUtils() {}

  /**
   * Similar to {@link com.google.api.gax.rpc.ApiExceptions#callAndTranslateApiException(ApiFuture)}
   * except that it doesn't add a suppressed exception.
   *
   * <p>This should only be used in a context in which awaiting the future is on a thread that
   * already contains the stack frames which originated the work.
   */
  static <T> T await(ApiFuture<T> future) {
    try {
      return Futures.getUnchecked(future);
    } catch (UncheckedExecutionException exception) {
      if (exception.getCause() instanceof RuntimeException) {
        throw (RuntimeException) exception.getCause();
      }
      throw exception;
    }
  }

  static <T> ApiFuture<T> just(T value) {
    return ApiFutures.immediateFuture(value);
  }

  /**
   * @see SmugglingException
   */
  static <T> ApiFuture<List<T>> quietAllAsList(List<ApiFuture<T>> futures) {
    List<ApiFuture<T>> pending =
        futures.stream().map(ApiFutureUtils::smuggleThrowable).collect(Collectors.toList());
    ApiFuture<List<T>> futureValues = ApiFutures.allAsList(pending);
    return unwrapSmuggling(futureValues);
  }

  @FunctionalInterface
  interface OnSuccessApiFutureCallback<T> extends ApiFutureCallback<T> {
    @Override
    default void onFailure(Throwable t) {
      // noop
    }
  }

  @FunctionalInterface
  interface OnFailureApiFutureCallback<T> extends ApiFutureCallback<T> {
    @Override
    default void onSuccess(T result) {
      // noop
    }
  }

  private static <T> ApiFuture<T> smuggleThrowable(ApiFuture<T> future) {
    return ApiFutures.catchingAsync(
        future,
        Throwable.class,
        throwable -> ApiFutures.immediateFailedFuture(new SmugglingException(throwable)),
        MoreExecutors.directExecutor());
  }

  private static <T> ApiFuture<T> unwrapSmuggling(ApiFuture<T> future) {
    return ApiFutures.catchingAsync(
        future,
        SmugglingException.class,
        smuggled -> ApiFutures.immediateFailedFuture(smuggled.smuggledCause),
        MoreExecutors.directExecutor());
  }

  /**
   * Guava's AggregateFuture attempts to help let you know when multiple futures fail while
   * resolving via {@link com.google.common.util.concurrent.Futures#allAsList(Iterable)}.
   *
   * <p>This is detrimental to our use case, because we don't want to be spamming our customers with
   * error message they can do nothing about. In an effort to prevent this spam we define a custom
   * exception wrapper class that is able to smuggle the context we care about past the detection
   * mechanism (instances are added to a ConcurrentHashSet).
   *
   * <p>To accomplish this smuggling, we abuse the following:
   *
   * <ol>
   *   <li>hashCode is hardcoded to a constant value
   *   <li>equals(Object) returns true if the classes are equal
   *   <li>we define our own field to carry the cause (guava looks at the cause too)
   * </ol>
   *
   * For our purposes we don't need to distinguish between different instances of our exception, as
   * we track error at a different level.
   */
  private static final class SmugglingException extends RuntimeException {
    private final Throwable smuggledCause;

    private SmugglingException(Throwable smuggledCause) {
      super("");
      this.smuggledCause = smuggledCause;
    }

    public int hashCode() {
      return 1;
    }

    public boolean equals(Object other) {
      return other.getClass().equals(this.getClass());
    }
  }
}
