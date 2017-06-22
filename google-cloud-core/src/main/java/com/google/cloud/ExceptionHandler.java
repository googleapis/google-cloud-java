/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Exception retry algorithm implementation used by {@link RetryHelper}.
 */
@BetaApi
public final class ExceptionHandler implements ResultRetryAlgorithm<Object>, Serializable {

  private static final long serialVersionUID = -2460707015779532919L;

  private static final ExceptionHandler DEFAULT_INSTANCE =
      newBuilder().retryOn(Exception.class).abortOn(RuntimeException.class).build();

  private final ImmutableList<Interceptor> interceptors;
  private final ImmutableSet<Class<? extends Exception>> retriableExceptions;
  private final ImmutableSet<Class<? extends Exception>> nonRetriableExceptions;
  private final Set<RetryInfo> retryInfo = Sets.newHashSet();

  public interface Interceptor extends Serializable {

    enum RetryResult {
      NO_RETRY, RETRY, CONTINUE_EVALUATION;
    }

    /**
     * This method is called before exception evaluation and could short-circuit the process.
     *
     * @param exception the exception that is being evaluated
     * @return {@link RetryResult} to indicate if the exception should be ignored (
     *         {@link RetryResult#RETRY}), propagated ({@link RetryResult#NO_RETRY}), or evaluation
     *         should proceed ({@link RetryResult#CONTINUE_EVALUATION}).
     */
    RetryResult beforeEval(Exception exception);

    /**
     * This method is called after the evaluation and could alter its result.
     *
     * @param exception the exception that is being evaluated
     * @param retryResult the result of the evaluation so far
     * @return {@link RetryResult} to indicate if the exception should be ignored (
     *         {@link RetryResult#RETRY}), propagated ({@link RetryResult#NO_RETRY}), or evaluation
     *         should proceed ({@link RetryResult#CONTINUE_EVALUATION}).
     */
    RetryResult afterEval(Exception exception, RetryResult retryResult);
  }

  /**
   * ExceptionHandler builder.
   */
  public static class Builder {

    private final ImmutableList.Builder<Interceptor> interceptors = ImmutableList.builder();
    private final ImmutableSet.Builder<Class<? extends Exception>> retriableExceptions =
        ImmutableSet.builder();
    private final ImmutableSet.Builder<Class<? extends Exception>> nonRetriableExceptions =
        ImmutableSet.builder();

    private Builder() {}



    /**
     * Adds the exception handler interceptors. Call order will be maintained.
     *
     * @param interceptors the interceptors for this exception handler
     * @return the Builder for chaining
     */
    public Builder addInterceptors(Interceptor... interceptors) {
      for (Interceptor interceptor : interceptors) {
        this.interceptors.add(interceptor);
      }
      return this;
    }

    /**
     * Add the exceptions to ignore/retry-on.
     *
     * @param exceptions retry should continue when such exceptions are thrown
     * @return the Builder for chaining
     */
    @SafeVarargs
    public final Builder retryOn(Class<? extends Exception>... exceptions) {
      for (Class<? extends Exception> exception : exceptions) {
        retriableExceptions.add(checkNotNull(exception));
      }
      return this;
    }

    /**
     * Adds the exceptions to abort on.
     *
     * @param exceptions retry should abort when such exceptions are thrown
     * @return the Builder for chaining
     */
    @SafeVarargs
    public final Builder abortOn(Class<? extends Exception>... exceptions) {
      for (Class<? extends Exception> exception : exceptions) {
        nonRetriableExceptions.add(checkNotNull(exception));
      }
      return this;
    }

    /**
     * Returns a new ExceptionHandler instance.
     */
    public ExceptionHandler build() {
      return new ExceptionHandler(this);
    }
  }

  @VisibleForTesting
  static final class RetryInfo implements Serializable {

    private static final long serialVersionUID = -4264634837841455974L;
    private final Class<? extends Exception> exception;
    private final Interceptor.RetryResult retry;
    private final Set<RetryInfo> children = Sets.newHashSet();

    RetryInfo(Class<? extends Exception> exception, Interceptor.RetryResult retry) {
      this.exception = checkNotNull(exception);
      this.retry = checkNotNull(retry);
    }

    @Override
    public int hashCode() {
      return exception.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof RetryInfo)) {
        return false;
      }
      // We only care about exception in equality as we allow only one instance per exception
      return ((RetryInfo) obj).exception.equals(exception);
    }
  }

  private ExceptionHandler(Builder builder) {
    interceptors = builder.interceptors.build();
    retriableExceptions = builder.retriableExceptions.build();
    nonRetriableExceptions = builder.nonRetriableExceptions.build();
    Preconditions.checkArgument(
        Sets.intersection(retriableExceptions, nonRetriableExceptions).isEmpty(),
        "Same exception was found in both retryable and non-retryable sets");
    for (Class<? extends Exception> exception : retriableExceptions) {
      addRetryInfo(new RetryInfo(exception, Interceptor.RetryResult.RETRY), retryInfo);
    }
    for (Class<? extends Exception> exception : nonRetriableExceptions) {
      addRetryInfo(new RetryInfo(exception, Interceptor.RetryResult.NO_RETRY), retryInfo);
    }
  }

  private static void addRetryInfo(RetryInfo retryInfo, Set<RetryInfo> dest) {
    for (RetryInfo current : dest) {
      if (current.exception.isAssignableFrom(retryInfo.exception)) {
        addRetryInfo(retryInfo, current.children);
        return;
      }
      if (retryInfo.exception.isAssignableFrom(current.exception)) {
        retryInfo.children.add(current);
      }
    }
    dest.removeAll(retryInfo.children);
    dest.add(retryInfo);
  }

  private static RetryInfo findMostSpecificRetryInfo(Set<RetryInfo> retryInfo,
      Class<? extends Exception> exception) {
    for (RetryInfo current : retryInfo) {
      if (current.exception.isAssignableFrom(exception)) {
        RetryInfo match = findMostSpecificRetryInfo(current.children, exception);
        return match == null ? current : match;
      }
    }
    return null;
  }

  // called for Class<? extends Callable>, therefore a "call" method must be found.
  private static Method getCallableMethod(Class<?> clazz) {
    try {
      return clazz.getDeclaredMethod("call");
    } catch (NoSuchMethodException e) {
      // check parent
      return getCallableMethod(clazz.getSuperclass());
    } catch (SecurityException e) {
      // This should never happen
      throw new IllegalStateException("Unexpected exception", e);
    }
  }

  void verifyCaller(Callable<?> callable) {
    Method callMethod = getCallableMethod(callable.getClass());
    for (Class<?> exceptionOrError : callMethod.getExceptionTypes()) {
      Preconditions.checkArgument(Exception.class.isAssignableFrom(exceptionOrError),
          "Callable method exceptions must be derived from Exception");
      @SuppressWarnings("unchecked")
      Class<? extends Exception> exception = (Class<? extends Exception>) exceptionOrError;
      Preconditions.checkArgument(findMostSpecificRetryInfo(retryInfo, exception) != null,
          "Declared exception '" + exception + "' is not covered by exception handler");
    }
  }

  @Override
  public boolean shouldRetry(Throwable prevThrowable, Object prevResponse) {
    if(!(prevThrowable instanceof Exception)) {
      return false;
    }
    Exception ex = (Exception) prevThrowable;
    for (Interceptor interceptor : interceptors) {
      Interceptor.RetryResult retryResult = checkNotNull(interceptor.beforeEval(ex));
      if (retryResult != Interceptor.RetryResult.CONTINUE_EVALUATION) {
        return retryResult == Interceptor.RetryResult.RETRY;
      }
    }
    RetryInfo retryInfo = findMostSpecificRetryInfo(this.retryInfo, ex.getClass());
    Interceptor.RetryResult retryResult =
        retryInfo == null ? Interceptor.RetryResult.NO_RETRY : retryInfo.retry;
    for (Interceptor interceptor : interceptors) {
      Interceptor.RetryResult interceptorRetry =
          checkNotNull(interceptor.afterEval(ex, retryResult));
      if (interceptorRetry != Interceptor.RetryResult.CONTINUE_EVALUATION) {
        retryResult = interceptorRetry;
      }
    }
    return retryResult == Interceptor.RetryResult.RETRY;
  }

  @Override
  public TimedAttemptSettings createNextAttempt(Throwable prevThrowable, Object prevResponse,
      TimedAttemptSettings prevSettings) {
    // Return null to indicate that this implementation does not provide any specific attempt
    // settings, so by default the TimedRetryAlgorithm options can be used instead.
    return null;
  }

  @Override
  public int hashCode() {
    return Objects.hash(interceptors, retriableExceptions, nonRetriableExceptions, retryInfo);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof ExceptionHandler)) {
      return false;
    }
    ExceptionHandler other = (ExceptionHandler) obj;
    return Objects.equals(interceptors, other.interceptors)
        && Objects.equals(retriableExceptions, other.retriableExceptions)
        && Objects.equals(nonRetriableExceptions, other.nonRetriableExceptions)
        && Objects.equals(retryInfo, other.retryInfo);
  }


  /**
   * Returns an instance which retry any checked exception and abort on any runtime exception.
   */
  public static ExceptionHandler getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }


  public static Builder newBuilder() {
    return new Builder();
  }
}
