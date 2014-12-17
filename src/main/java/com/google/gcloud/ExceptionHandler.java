package com.google.gcloud;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Exception handling used by {@link RetryHelper}.
 */
public final class ExceptionHandler implements Serializable {

  private static final long serialVersionUID = -2460707015779532919L;

  private static final ExceptionHandler DEFAULT_INSTANCE =
      builder().retryOn(Exception.class).abortOn(RuntimeException.class).build();

  private final ImmutableList<Interceptor> interceptors;
  private final ImmutableSet<Class<? extends Exception>> retriableExceptions;
  private final ImmutableSet<Class<? extends Exception>> nonRetriableExceptions;
  private final Set<RetryInfo> retryInfos = Sets.newHashSet();

  public interface Interceptor extends Serializable {

    /**
     * This method is called before evaluating if the exception should be propagated
     * and could short-circuit the evaluation process.
     *
     * @param exception the exception that is being evaluated
     * @return {@code Boolean.TRUE} if exception should be ignored, {@code Boolean.FALSE}
     *      if exception should be propagated or {@code null} if evaluation should proceed.
     */
    Boolean shouldRetry(Exception exception);

    /**
     * This method is called after the evaluation but could alter the result if desired.
     *
     * @param exception the exception that is being evaluated
     * @param shouldRetry the result of the evaluation
     * @return {@code true} if exception should be ignored or {@code false}
     *      if exception should be propagated.
     */
    boolean shouldRetry(Exception exception, boolean shouldRetry);
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

    private Builder() {
    }


    /**
     * Adds the exception handler interceptors.
     * Call order will be maintained.

     * @param interceptors the interceptors for this exception handler
     * @return the Builder for chaining
     */
    public Builder interceptor(Interceptor... interceptors) {
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
    private final boolean retry;
    private final Set<RetryInfo> children = Sets.newHashSet();

    RetryInfo(Class<? extends Exception> exception, boolean retry) {
      this.exception = checkNotNull(exception);
      this.retry = retry;
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
        "Same exception was found in both retriable and non-retriable sets");
    for (Class<? extends Exception> exception : retriableExceptions) {
      addToRetryInfos(retryInfos, new RetryInfo(exception, true));
    }
    for (Class<? extends Exception> exception : nonRetriableExceptions) {
      addToRetryInfos(retryInfos,  new RetryInfo(exception, false));
    }
  }

  private static void addToRetryInfos(Set<RetryInfo> retryInfos, RetryInfo retryInfo) {
    for (RetryInfo current : retryInfos) {
      if (current.exception.isAssignableFrom(retryInfo.exception)) {
        addToRetryInfos(current.children, retryInfo);
        return;
      }
      if (retryInfo.exception.isAssignableFrom(current.exception)) {
        retryInfo.children.add(current);
      }
    }
    retryInfos.removeAll(retryInfo.children);
    retryInfos.add(retryInfo);
  }


  private static RetryInfo findMostSpecificRetryInfo(Set<RetryInfo> retryInfos,
      Class<? extends Exception> exception) {
    for (RetryInfo current : retryInfos) {
      if (current.exception.isAssignableFrom(exception)) {
        RetryInfo  match = findMostSpecificRetryInfo(current.children, exception);
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
      throw new RuntimeException("Unexpected exception", e);
    }
  }

  void verifyCaller(Callable<?> callable) {
    Method callMethod = getCallableMethod(callable.getClass());
    for (Class<?> exceptionOrError : callMethod.getExceptionTypes()) {
      Preconditions.checkArgument(Exception.class.isAssignableFrom(exceptionOrError),
          "Callable method exceptions must be dervied from Exception");
      @SuppressWarnings("unchecked") Class<? extends Exception> exception =
          (Class<? extends Exception>) exceptionOrError;
      Preconditions.checkArgument(findMostSpecificRetryInfo(retryInfos, exception) != null,
          "Declared exception '" + exception + "' is not covered by exception handler");
    }
  }

  public Set<Class<? extends Exception>> getRetriableExceptions() {
    return retriableExceptions;
  }

  public Set<Class<? extends Exception>> getNonRetriableExceptions() {
    return nonRetriableExceptions;
  }

  boolean shouldRetry(Exception ex) {
    for (Interceptor interceptor : interceptors) {
      Boolean shouldRetry = interceptor.shouldRetry(ex);
      if (shouldRetry != null) {
        return shouldRetry.booleanValue();
      }
    }
    RetryInfo retryInfo = findMostSpecificRetryInfo(retryInfos, ex.getClass());
    boolean shouldRetry = retryInfo == null ? false : retryInfo.retry;
    for (Interceptor interceptor : interceptors) {
      shouldRetry = interceptor.shouldRetry(ex, shouldRetry);
    }
    return shouldRetry;
  }

  /**
   * Returns an instance which retry any checked exception and abort on any runtime exception.
   */
  public static ExceptionHandler getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static Builder builder() {
    return new Builder();
  }
}
