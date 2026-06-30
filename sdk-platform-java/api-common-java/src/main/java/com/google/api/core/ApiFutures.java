/*
 * Copyright 2017, Google Inc.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.core;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/** Static utility methods for the {@link ApiFuture} interface. */
public final class ApiFutures {
  private ApiFutures() {}

  /**
   * Registers a callback to be run when the {@link ApiFuture}'s computation is complete or, if the
   * computation is already complete, immediately.
   *
   * @param future The future attach the callback to
   * @param callback The callback to invoke when future is completed
   * @deprecated Use {@linkplain #addCallback(ApiFuture, ApiFutureCallback, Executor) the overload
   *     that requires an executor}. For identical behavior, pass {@link
   *     com.google.common.util.concurrent.MoreExecutors#directExecutor}, but consider whether
   *     another executor would be safer.
   */
  @Deprecated
  public static <V> void addCallback(
      final ApiFuture<V> future, final ApiFutureCallback<? super V> callback) {
    addCallback(future, callback, directExecutor());
  }

  /**
   * Registers a callback to be run when the {@link ApiFuture}'s computation is complete or, if the
   * computation is already complete, immediately.
   *
   * <p>Note that this method is a delegate of {@link Futures#addCallback(ListenableFuture,
   * FutureCallback, Executor)}.
   *
   * @param future The future attach the callback to
   * @param callback The callback to invoke when future is completed
   * @param executor The executor to run callback when the future completes
   * @see Futures#addCallback(ListenableFuture, FutureCallback, Executor)
   */
  public static <V> void addCallback(
      final ApiFuture<V> future, final ApiFutureCallback<? super V> callback, Executor executor) {
    Futures.addCallback(
        listenableFutureForApiFuture(future),
        new FutureCallback<V>() {
          @Override
          public void onFailure(Throwable t) {
            callback.onFailure(t);
          }

          @Override
          public void onSuccess(V v) {
            callback.onSuccess(v);
          }
        },
        executor);
  }

  /**
   * Returns an {@link ApiFuture} whose result is taken from the given primary input or, if the
   * primary input fails with the given exceptionType, from the result provided by the callback.
   *
   * @param input The primary input {@code ApiFuture}
   * @param exceptionType The exception type that triggers use of {@code fallback}
   * @param callback The {@link ApiFunction} to be called if input fails with the expected exception
   *     type
   * @return A future whose result is taken either from the given {@code input} or by the {@code
   *     callback}
   * @deprecated Use {@linkplain #catching(ApiFuture, Class, ApiFunction, Executor) the overload
   *     that requires an executor}. For identical behavior, pass {@link
   *     com.google.common.util.concurrent.MoreExecutors#directExecutor}, but consider whether
   *     another executor would be safer.
   */
  @Deprecated
  public static <V, X extends Throwable> ApiFuture<V> catching(
      ApiFuture<? extends V> input,
      Class<X> exceptionType,
      ApiFunction<? super X, ? extends V> callback) {
    return catching(input, exceptionType, callback, directExecutor());
  }

  /**
   * Returns an {@link ApiFuture} whose result is taken from the given primary input or, if the
   * primary input fails with the given exceptionType, from the result provided by the callback.
   *
   * <p>Note that this method is a delegate of {@link Futures#catching(ListenableFuture, Class,
   * Function, Executor)}.
   *
   * @param input The primary input {@code ApiFuture}
   * @param exceptionType The exception type that triggers use of {@code fallback}
   * @param callback The {@link ApiFunction} to be called if input fails with the expected exception
   *     type
   * @param executor The executor that runs {@code fallback} if {@code input} fails
   * @return A future whose result is taken either from the given {@code input} or by the {@code
   *     callback}
   * @see Futures#catching(ListenableFuture, Class, Function, Executor)
   */
  public static <V, X extends Throwable> ApiFuture<V> catching(
      ApiFuture<? extends V> input,
      Class<X> exceptionType,
      ApiFunction<? super X, ? extends V> callback,
      Executor executor) {
    ListenableFuture<V> catchingFuture =
        Futures.catching(
            listenableFutureForApiFuture(input),
            exceptionType,
            new ApiFunctionToGuavaFunction<X, V>(callback),
            executor);
    return new ListenableFutureToApiFuture<V>(catchingFuture);
  }

  /**
   * Returns a {@link ApiFuture} whose result is taken from the given primary input or, if the
   * primary input fails with the given exceptionType, from the result provided by the callback.
   *
   * <p>Note that this method is a delegate of {@link Futures#catchingAsync(ListenableFuture, Class,
   * AsyncFunction, Executor)}
   *
   * @param input The primary input {@code ApiFuture}
   * @param exceptionType The exception type that triggers use of {@code fallback}.
   * @param callback The {@link ApiAsyncFunction} to be called if {@code input} fails with the
   *     expected * exception type.
   * @param executor The executor that runs {@code fallback} if {@code input} fails
   * @return A future whose result is taken either from the given {@code input} or by the {@code
   *     callback}
   * @see Futures#catchingAsync(ListenableFuture, Class, AsyncFunction, Executor)
   */
  public static <V, X extends Throwable> ApiFuture<V> catchingAsync(
      ApiFuture<V> input,
      Class<X> exceptionType,
      final ApiAsyncFunction<? super X, V> callback,
      Executor executor) {
    ListenableFuture<V> catchingFuture =
        Futures.catchingAsync(
            listenableFutureForApiFuture(input),
            exceptionType,
            new AsyncFunction<X, V>() {
              @Override
              public ListenableFuture<V> apply(X exception) throws Exception {
                ApiFuture<V> result = callback.apply(exception);
                return listenableFutureForApiFuture(result);
              }
            },
            executor);
    return new ListenableFutureToApiFuture<>(catchingFuture);
  }

  /**
   * Creates a {@code ApiFuture} which has its value set immediately upon construction.
   *
   * <p>Note that this method is a delegate of {@link Futures#immediateFuture(Object)}.
   *
   * @param value The value set to the {@code ApiFuture} upon construction
   * @return A future that holds {@code value}
   * @see Futures#immediateFuture(Object)
   */
  public static <V> ApiFuture<V> immediateFuture(V value) {
    return new ListenableFutureToApiFuture<>(Futures.<V>immediateFuture(value));
  }

  /**
   * Returns a {@code ApiFuture} which has an exception set immediately upon construction.
   *
   * <p>Note that this method is a delegate of {@link Futures#immediateFailedFuture(Throwable)}.
   *
   * @param throwable The exception set to the {@code ApiFuture} upon construction
   * @return A future that holds an exception
   * @see Futures#immediateFailedFuture(Throwable)
   */
  public static <V> ApiFuture<V> immediateFailedFuture(Throwable throwable) {
    return new ListenableFutureToApiFuture<V>(Futures.<V>immediateFailedFuture(throwable));
  }

  /**
   * Creates a {@code ApiFuture} which is cancelled immediately upon construction, so that {@code
   * isCancelled()} always returns {@code true}.
   *
   * <p>Note that this method is a delegate of {@link Futures#immediateCancelledFuture()}.
   *
   * @return A cancelled future
   * @see Futures#immediateCancelledFuture()
   */
  public static <V> ApiFuture<V> immediateCancelledFuture() {
    return new ListenableFutureToApiFuture<V>(Futures.<V>immediateCancelledFuture());
  }

  /**
   * Returns a new {@code ApiFuture} whose result is derived from the result of the given {@code
   * ApiFuture}.
   *
   * @param input The future to transform
   * @param function A Function to transform the results of the provided future to the results of
   *     the returned future
   * @return A future that holds result of the transformation
   * @deprecated Use {@linkplain #transform(ApiFuture, ApiFunction, Executor) the overload that
   *     requires an executor}. For identical behavior, pass {@link
   *     com.google.common.util.concurrent.MoreExecutors#directExecutor}, but consider whether
   *     another executor would be safer.
   */
  @Deprecated
  public static <V, X> ApiFuture<X> transform(
      ApiFuture<? extends V> input, final ApiFunction<? super V, ? extends X> function) {
    return transform(input, function, directExecutor());
  }

  /**
   * Returns a new {@code ApiFuture} whose result is derived from the result of the given {@code
   * ApiFuture}.
   *
   * <p>Note that this method is a delegate of {@link Futures#transform(ListenableFuture, Function,
   * Executor)}.
   *
   * @param input The future to transform
   * @param function A Function to transform the results of the provided future to the results of
   *     the returned future.
   * @param executor Executor to run the function in.
   * @return A future that holds result of the transformation
   * @see Futures#transform(ListenableFuture, Function, Executor)
   */
  public static <V, X> ApiFuture<X> transform(
      ApiFuture<? extends V> input,
      final ApiFunction<? super V, ? extends X> function,
      Executor executor) {
    return new ListenableFutureToApiFuture<>(
        Futures.transform(
            listenableFutureForApiFuture(input),
            new ApiFunctionToGuavaFunction<V, X>(function),
            executor));
  }

  /**
   * Creates a new {@code ApiFuture} whose value is a list containing the values of all its input
   * futures, if all succeed.
   *
   * <p>The list of results is in the same order as the input list.
   *
   * <p>Note that this method is a delegate of {@link Futures#allAsList(Iterable)}.
   *
   * @param futures Futures to combine
   * @return A future that provides a list of the results of the component futures
   * @see Futures#allAsList(Iterable)
   */
  public static <V> ApiFuture<List<V>> allAsList(
      Iterable<? extends ApiFuture<? extends V>> futures) {
    return new ListenableFutureToApiFuture<>(
        Futures.allAsList(
            Iterables.transform(
                futures,
                new Function<ApiFuture<? extends V>, ListenableFuture<? extends V>>() {
                  public ListenableFuture<? extends V> apply(ApiFuture<? extends V> apiFuture) {
                    return listenableFutureForApiFuture(apiFuture);
                  }
                })));
  }

  /**
   * Creates a new {@code ApiFuture} whose value is a list containing the values of all its
   * successful input futures. The list of results is in the same order as the input list, and if
   * any of the provided futures fails or is canceled, its corresponding position will contain
   * {@code null} (which is indistinguishable from the future having a successful value of {@code
   * null}).
   *
   * <p>The list of results is in the same order as the input list.
   *
   * <p>Note that this method is a delegate of {@link Futures#successfulAsList(Iterable)}.
   *
   * @param futures Futures to combine
   * @return A future that provides a list of the results of the component futures
   * @see Futures#successfulAsList(Iterable)
   */
  @BetaApi
  public static <V> ApiFuture<List<V>> successfulAsList(
      Iterable<? extends ApiFuture<? extends V>> futures) {
    return new ListenableFutureToApiFuture<>(
        Futures.successfulAsList(
            Iterables.transform(
                futures,
                new Function<ApiFuture<? extends V>, ListenableFuture<? extends V>>() {
                  public ListenableFuture<? extends V> apply(ApiFuture<? extends V> apiFuture) {
                    return listenableFutureForApiFuture(apiFuture);
                  }
                })));
  }

  /**
   * Returns a new {@code ApiFuture} whose result is asynchronously derived from the result of the
   * given {@code ApiFuture}. If the given {@code Future} fails, the returned {@code ApiFuture}
   * fails with the same exception (and the function is not invoked).
   *
   * @param input The future to transform
   * @param function A function to transform the result of the input future to the result of the
   *     output future
   * @return A future that holds result of the function (if the input succeeded) or the original
   *     input's failure (if not)
   * @deprecated Use {@linkplain #transformAsync(ApiFuture, ApiAsyncFunction, Executor)}, the
   *     overload that requires an executor. For identical behavior, pass {@link
   *     com.google.common.util.concurrent.MoreExecutors#directExecutor}, but consider whether
   *     another executor would be safer.
   */
  @Deprecated
  public static <I, O> ApiFuture<O> transformAsync(
      ApiFuture<I> input, final ApiAsyncFunction<I, O> function) {
    return transformAsync(input, function, directExecutor());
  }

  /**
   * Returns a new {@code ApiFuture} whose result is asynchronously derived from the result of the
   * given {@code ApiFuture}. If the given {@code Future} fails, the returned {@code ApiFuture}
   * fails with the same exception (and the function is not invoked).
   *
   * <p>Note that this method is a delegate of {@link Futures#transformAsync(ListenableFuture,
   * AsyncFunction, Executor)}.
   *
   * @param input The future to transform
   * @param function A function to transform the result of the input future to the result of the
   *     output future
   * @param executor Executor to run the function in.
   * @return A future that holds result of the function (if the input succeeded) or the original
   *     input's failure (if not)
   * @see Futures#transformAsync(ListenableFuture, AsyncFunction, Executor)
   */
  public static <I, O> ApiFuture<O> transformAsync(
      ApiFuture<I> input, final ApiAsyncFunction<I, O> function, Executor executor) {
    ListenableFuture<I> listenableInput = listenableFutureForApiFuture(input);
    ListenableFuture<O> listenableOutput =
        Futures.transformAsync(
            listenableInput,
            new AsyncFunction<I, O>() {
              @Override
              public ListenableFuture<O> apply(I input) throws Exception {
                return listenableFutureForApiFuture(function.apply(input));
              }
            },
            executor);
    return new ListenableFutureToApiFuture<>(listenableOutput);
  }

  private static <V> ListenableFuture<V> listenableFutureForApiFuture(ApiFuture<V> apiFuture) {
    ListenableFuture<V> listenableFuture;
    if (apiFuture instanceof AbstractApiFuture) {
      // prefer to use the wrapped ListenableFuture to reduce the number of layers
      listenableFuture = ((AbstractApiFuture<V>) apiFuture).getInternalListenableFuture();
    } else {
      listenableFuture = new ApiFutureToListenableFuture<V>(apiFuture);
    }
    return listenableFuture;
  }

  private static class ApiFunctionToGuavaFunction<X, V>
      implements com.google.common.base.Function<X, V> {
    private ApiFunction<? super X, ? extends V> f;

    public ApiFunctionToGuavaFunction(ApiFunction<? super X, ? extends V> f) {
      this.f = f;
    }

    @Nullable
    @Override
    public V apply(@Nullable X input) {
      return f.apply(input);
    }
  }
}
