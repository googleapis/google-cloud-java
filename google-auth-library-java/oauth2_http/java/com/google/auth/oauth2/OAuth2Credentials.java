/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
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

package com.google.auth.oauth2;

import com.google.api.client.util.Clock;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/** Base type for Credentials using OAuth2. */
public class OAuth2Credentials extends Credentials {

  private static final long serialVersionUID = 4556936364828217687L;
  static final Duration DEFAULT_EXPIRATION_MARGIN = Duration.ofMinutes(3);
  static final Duration DEFAULT_REFRESH_MARGIN = Duration.ofMinutes(3).plusSeconds(45);
  private static final ImmutableMap<String, List<String>> EMPTY_EXTRA_HEADERS = ImmutableMap.of();

  @VisibleForTesting private final Duration expirationMargin;
  @VisibleForTesting private final Duration refreshMargin;

  // byte[] is serializable, so the lock variable can be final
  @VisibleForTesting final Object lock = new byte[0];
  private volatile OAuthValue value = null;
  @VisibleForTesting transient RefreshTask refreshTask;

  // Change listeners are not serialized
  private transient List<CredentialsChangedListener> changeListeners;
  // Until we expose this to the users it can remain transient and non-serializable
  @VisibleForTesting transient Clock clock = Clock.SYSTEM;

  /**
   * Returns the credentials instance from the given access token.
   *
   * @param accessToken the access token
   * @return the credentials instance
   */
  public static OAuth2Credentials create(AccessToken accessToken) {
    return OAuth2Credentials.newBuilder().setAccessToken(accessToken).build();
  }

  /** Default constructor. */
  protected OAuth2Credentials() {
    this(null);
  }

  /**
   * Constructor with explicit access token.
   *
   * @param accessToken initial or temporary access token
   */
  protected OAuth2Credentials(AccessToken accessToken) {
    this(accessToken, DEFAULT_REFRESH_MARGIN, DEFAULT_EXPIRATION_MARGIN);
  }

  protected OAuth2Credentials(
      AccessToken accessToken, Duration refreshMargin, Duration expirationMargin) {
    if (accessToken != null) {
      this.value = OAuthValue.create(accessToken, EMPTY_EXTRA_HEADERS);
    }

    this.refreshMargin = Preconditions.checkNotNull(refreshMargin, "refreshMargin");
    Preconditions.checkArgument(!refreshMargin.isNegative(), "refreshMargin can't be negative");
    this.expirationMargin = Preconditions.checkNotNull(expirationMargin, "expirationMargin");
    Preconditions.checkArgument(
        !expirationMargin.isNegative(), "expirationMargin can't be negative");
  }

  @Override
  public String getAuthenticationType() {
    return "OAuth2";
  }

  @Override
  public boolean hasRequestMetadata() {
    return true;
  }

  @Override
  public boolean hasRequestMetadataOnly() {
    return true;
  }

  /**
   * Returns the cached access token.
   *
   * <p>If not set, you should call {@link #refresh()} to fetch and cache an access token.
   *
   * @return The cached access token.
   */
  public final AccessToken getAccessToken() {
    OAuthValue localState = value;
    if (localState != null) {
      return localState.temporaryAccess;
    }
    return null;
  }

  /** Returns the credentials' refresh margin. */
  @VisibleForTesting
  Duration getRefreshMargin() {
    return this.refreshMargin;
  }

  /** Returns the credentials' expiration margin. */
  @VisibleForTesting
  Duration getExpirationMargin() {
    return this.expirationMargin;
  }

  @Override
  public void getRequestMetadata(
      final URI uri, Executor executor, final RequestMetadataCallback callback) {

    Futures.addCallback(
        asyncFetch(executor),
        new FutureCallbackToMetadataCallbackAdapter(callback),
        MoreExecutors.directExecutor());
  }

  /**
   * Provide the request metadata by ensuring there is a current access token and providing it as an
   * authorization bearer token.
   */
  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    return unwrapDirectFuture(asyncFetch(MoreExecutors.directExecutor())).requestMetadata;
  }

  /**
   * Request a new token regardless of the current token state. If the current token is not expired,
   * it will still be returned during the refresh.
   */
  @Override
  public void refresh() throws IOException {
    AsyncRefreshResult refreshResult = getOrCreateRefreshTask();
    refreshResult.executeIfNew(MoreExecutors.directExecutor());
    unwrapDirectFuture(refreshResult.task);
  }

  /**
   * Refresh these credentials only if they have expired or are expiring imminently.
   *
   * @throws IOException during token refresh.
   */
  public void refreshIfExpired() throws IOException {
    // asyncFetch will ensure that the token is refreshed
    unwrapDirectFuture(asyncFetch(MoreExecutors.directExecutor()));
  }

  /**
   * Attempts to get a fresh token.
   *
   * <p>If a fresh token is already available, it will be immediately returned. Otherwise a refresh
   * will be scheduled using the passed in executor. While a token is being freshed, a stale value
   * will be returned.
   */
  private ListenableFuture<OAuthValue> asyncFetch(Executor executor) {
    AsyncRefreshResult refreshResult = null;

    // fast and common path: skip the lock if the token is fresh
    // The inherent race condition here is a non-issue: even if the value gets replaced after the
    // state check, the new token will still be fresh.
    if (getState() == CacheState.FRESH) {
      return Futures.immediateFuture(value);
    }

    // Schedule a refresh as necessary
    synchronized (lock) {
      if (getState() != CacheState.FRESH) {
        refreshResult = getOrCreateRefreshTask();
      }
    }
    // Execute the refresh if necessary. This should be done outside of the lock to avoid blocking
    // metadata requests during a stale refresh.
    if (refreshResult != null) {
      refreshResult.executeIfNew(executor);
    }

    synchronized (lock) {
      // Immediately resolve the token token if its not expired, or wait for the refresh task to
      // complete
      if (getState() != CacheState.EXPIRED) {
        return Futures.immediateFuture(value);
      } else if (refreshResult != null) {
        return refreshResult.task;
      } else {
        // Should never happen
        return Futures.immediateFailedFuture(
            new IllegalStateException("Credentials expired, but there is no task to refresh"));
      }
    }
  }

  /**
   * Atomically creates a single flight refresh token task.
   *
   * <p>Only a single refresh task can be scheduled at a time. If there is an existing task, it will
   * be returned for subsequent invocations. However if a new task is created, it is the
   * responsibility of the caller to execute it. The task will clear the single flight slow upon
   * completion.
   */
  private AsyncRefreshResult getOrCreateRefreshTask() {
    synchronized (lock) {
      if (refreshTask != null) {
        return new AsyncRefreshResult(refreshTask, false);
      }

      final ListenableFutureTask<OAuthValue> task =
          ListenableFutureTask.create(
              new Callable<OAuthValue>() {
                @Override
                public OAuthValue call() throws Exception {
                  return OAuthValue.create(refreshAccessToken(), getAdditionalHeaders());
                }
              });

      refreshTask = new RefreshTask(task, new RefreshTaskListener(task));

      return new AsyncRefreshResult(refreshTask, true);
    }
  }

  /**
   * Async callback for committing the result from a token refresh.
   *
   * <p>The result will be stored, listeners are invoked and the single flight slot is cleared.
   */
  private void finishRefreshAsync(ListenableFuture<OAuthValue> finishedTask) {
    synchronized (lock) {
      try {
        this.value = Futures.getDone(finishedTask);
        for (CredentialsChangedListener listener : changeListeners) {
          listener.onChanged(this);
        }
      } catch (Exception e) {
        // noop
      } finally {
        if (this.refreshTask != null && this.refreshTask.getTask() == finishedTask) {
          this.refreshTask = null;
        }
      }
    }
  }

  /**
   * Unwraps the value from the future.
   *
   * <p>Under most circumstances, the underlying future will already be resolved by the
   * DirectExecutor. In those cases, the error stacktraces will be rooted in the caller's call tree.
   * However, in some cases when async and sync usage is mixed, it's possible that a blocking call
   * will await an async future. In those cases, the stacktrace will be orphaned and be rooted in a
   * thread of whatever executor the async call used. This doesn't affect correctness and is
   * extremely unlikely.
   */
  private static <T> T unwrapDirectFuture(ListenableFuture<T> future) throws IOException {
    try {
      return future.get();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IOException("Interrupted while asynchronously refreshing the access token", e);
    } catch (ExecutionException e) {
      Throwable cause = e.getCause();
      if (cause instanceof IOException) {
        throw (IOException) cause;
      } else if (cause instanceof RuntimeException) {
        throw (RuntimeException) cause;
      } else {
        throw new IOException("Unexpected error refreshing access token", cause);
      }
    }
  }

  /** Computes the effective credential state in relation to the current time. */
  private CacheState getState() {
    OAuthValue localValue = value;

    if (localValue == null) {
      return CacheState.EXPIRED;
    }
    Date expirationTime = localValue.temporaryAccess.getExpirationTime();

    if (expirationTime == null) {
      return CacheState.FRESH;
    }

    Duration remaining = Duration.ofMillis(expirationTime.getTime() - clock.currentTimeMillis());
    if (remaining.compareTo(expirationMargin) <= 0) {
      return CacheState.EXPIRED;
    }

    if (remaining.compareTo(refreshMargin) <= 0) {
      return CacheState.STALE;
    }

    return CacheState.FRESH;
  }

  /**
   * Method to refresh the access token according to the specific type of credentials.
   *
   * <p>Throws IllegalStateException if not overridden since direct use of OAuth2Credentials is only
   * for temporary or non-refreshing access tokens.
   *
   * @return never
   * @throws IllegalStateException always. OAuth2Credentials does not support refreshing the access
   *     token. An instance with a new access token or a derived type that supports refreshing
   *     should be used instead.
   */
  public AccessToken refreshAccessToken() throws IOException {
    throw new IllegalStateException(
        "OAuth2Credentials instance does not support refreshing the"
            + " access token. An instance with a new access token should be used, or a derived type"
            + " that supports refreshing.");
  }

  /**
   * Provide additional headers to return as request metadata.
   *
   * @return additional headers
   */
  protected Map<String, List<String>> getAdditionalHeaders() {
    return EMPTY_EXTRA_HEADERS;
  }

  /**
   * Adds a listener that is notified when the Credentials data changes.
   *
   * <p>This is called when token content changes, such as when the access token is refreshed. This
   * is typically used by code caching the access token.
   *
   * @param listener the listener to be added
   */
  public final void addChangeListener(CredentialsChangedListener listener) {
    synchronized (lock) {
      if (changeListeners == null) {
        changeListeners = new ArrayList<>();
      }
      changeListeners.add(listener);
    }
  }

  /**
   * Removes a listener that was added previously.
   *
   * @param listener The listener to be removed.
   */
  public final void removeChangeListener(CredentialsChangedListener listener) {
    synchronized (lock) {
      if (changeListeners != null) {
        changeListeners.remove(listener);
      }
    }
  }

  /**
   * Listener for changes to credentials.
   *
   * <p>This is called when token content changes, such as when the access token is refreshed. This
   * is typically used by code caching the access token.
   */
  public interface CredentialsChangedListener {

    /**
     * Notifies that the credentials have changed.
     *
     * <p>This is called when token content changes, such as when the access token is refreshed.
     * This is typically used by code caching the access token.
     *
     * @param credentials The updated credentials instance
     * @throws IOException My be thrown by listeners if saving credentials fails.
     */
    void onChanged(OAuth2Credentials credentials) throws IOException;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Nullable
  protected Map<String, List<String>> getRequestMetadataInternal() {
    OAuthValue localValue = value;
    if (localValue != null) {
      return localValue.requestMetadata;
    }
    return null;
  }

  @Override
  public String toString() {
    OAuthValue localValue = value;

    Map<String, List<String>> requestMetadata = null;
    AccessToken temporaryAccess = null;

    if (localValue != null) {
      requestMetadata = localValue.requestMetadata;
      temporaryAccess = localValue.temporaryAccess;
    }
    return MoreObjects.toStringHelper(this)
        .add("requestMetadata", requestMetadata)
        .add("temporaryAccess", temporaryAccess)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof OAuth2Credentials)) {
      return false;
    }
    OAuth2Credentials other = (OAuth2Credentials) obj;
    return Objects.equals(this.value, other.value);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    clock = Clock.SYSTEM;
    refreshTask = null;
  }

  /**
   * Best-effort safe mechanism to attempt to instantiate an {@link HttpTransportFactory} from a
   * class name.
   *
   * <p>This method attempts to avoid Arbitrary Code Execution (ACE) vulnerabilities by:
   *
   * <ol>
   *   <li>Checking if the class name matches the default or ServiceLoader-provided factory, and
   *       returning that instance if so.
   *   <li>If not, loading the class using reflection without running static initializers.
   *   <li>Verifying that the loaded class is assignable to {@link HttpTransportFactory}.
   *   <li>Only after verification, instantiating the class using its default constructor.
   * </ol>
   *
   * @param className The fully qualified name of the class to instantiate.
   * @return An instance of {@link HttpTransportFactory}.
   * @throws IOException If the class cannot be loaded, is the wrong type, or cannot be
   *     instantiated.
   * @throws ClassNotFoundException If the class cannot be found.
   */
  protected static HttpTransportFactory newInstance(String className)
      throws IOException, ClassNotFoundException {
    // Check if the requested class matches the default transport or ServiceLoader-provided
    // transport. This avoids unsafe reflection for the most common use cases. This check runs first
    // to replicate the logic in each Credential's constructor.
    HttpTransportFactory currentFactory =
        getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    // If this doesn't match, then it may be a custom implementation of HttpTransportFactory
    if (className.equals(currentFactory.getClass().getName())) {
      return currentFactory;
    }

    // Fallback to reflection to initialize the transport if the requested class is not from
    // ServiceLoader or the default value. This handles cases where a custom factory was used.
    try {
      // Load the class without initializing it (second argument: false) to prevent
      // static initializers from running (preventing gadget chain attacks). Use the class loader
      // of HttpTransportFactory to ensure the class is loaded from the same context as the library
      // to try to prevent any class loading manipulation.
      Class<?> clazz = Class.forName(className, false, HttpTransportFactory.class.getClassLoader());

      // Check that the class is an instance of `HttpTransportFactory` to prevent loading of
      // arbitrary classes.
      if (!HttpTransportFactory.class.isAssignableFrom(clazz)) {
        throw new IOException(
            String.format(
                "Class: %s, is not assignable from %s",
                className, HttpTransportFactory.class.getName()));
      }
      Constructor<?> constructor = clazz.getDeclaredConstructor();
      return (HttpTransportFactory) constructor.newInstance();
    } catch (InstantiationException
        | IllegalAccessException
        | NoSuchMethodException
        | InvocationTargetException e) {
      throw new IOException(e);
    }
  }

  /**
   * Returns the first service provider from the given service loader.
   *
   * @param clazz The class of the service provider to load.
   * @param defaultInstance The default instance to return if no service providers are found.
   * @param <T> The type of the service provider.
   * @return The first service provider from the service loader, or the {@code defaultInstance} if
   *     no service providers are found.
   */
  public static <T> T getFromServiceLoader(Class<? extends T> clazz, T defaultInstance) {
    return Iterables.getFirst(ServiceLoader.load(clazz), defaultInstance);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Stores an immutable snapshot of the accesstoken owned by {@link OAuth2Credentials} */
  static class OAuthValue implements Serializable {
    private final AccessToken temporaryAccess;
    private final Map<String, List<String>> requestMetadata;

    static OAuthValue create(AccessToken token, Map<String, List<String>> additionalHeaders) {
      return new OAuthValue(
          token,
          ImmutableMap.<String, List<String>>builder()
              .put(
                  AuthHttpConstants.AUTHORIZATION,
                  ImmutableList.of(OAuth2Utils.BEARER_PREFIX + token.getTokenValue()))
              .putAll(additionalHeaders)
              .build());
    }

    private OAuthValue(AccessToken temporaryAccess, Map<String, List<String>> requestMetadata) {
      this.temporaryAccess = temporaryAccess;
      this.requestMetadata = requestMetadata;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof OAuthValue)) {
        return false;
      }
      OAuthValue other = (OAuthValue) obj;
      return Objects.equals(this.requestMetadata, other.requestMetadata)
          && Objects.equals(this.temporaryAccess, other.temporaryAccess);
    }

    @Override
    public int hashCode() {
      return Objects.hash(temporaryAccess, requestMetadata);
    }
  }

  enum CacheState {
    FRESH,
    STALE,
    EXPIRED;
  }

  static class FutureCallbackToMetadataCallbackAdapter implements FutureCallback<OAuthValue> {
    private final RequestMetadataCallback callback;

    public FutureCallbackToMetadataCallbackAdapter(RequestMetadataCallback callback) {
      this.callback = callback;
    }

    @Override
    public void onSuccess(@Nullable OAuthValue value) {
      callback.onSuccess(value.requestMetadata);
    }

    @Override
    public void onFailure(Throwable throwable) {
      // refreshAccessToken will be invoked in an executor, so if it fails unwrap the underlying
      // error
      if (throwable instanceof ExecutionException) {
        throwable = throwable.getCause();
      }
      callback.onFailure(throwable);
    }
  }

  /**
   * Result from {@link com.google.auth.oauth2.OAuth2Credentials#getOrCreateRefreshTask()}.
   *
   * <p>Contains the refresh task and a flag indicating if the task is newly created. If the task is
   * newly created, it is the caller's responsibility to execute it.
   */
  static class AsyncRefreshResult {
    private final RefreshTask task;
    private final boolean isNew;

    AsyncRefreshResult(RefreshTask task, boolean isNew) {
      this.task = task;
      this.isNew = isNew;
    }

    void executeIfNew(Executor executor) {
      if (isNew) {
        executor.execute(task);
      }
    }
  }

  @VisibleForTesting
  class RefreshTaskListener implements Runnable {
    private ListenableFutureTask<OAuthValue> task;

    RefreshTaskListener(ListenableFutureTask<OAuthValue> task) {
      this.task = task;
    }

    @Override
    public void run() {
      finishRefreshAsync(task);
    }
  }

  class RefreshTask extends AbstractFuture<OAuthValue> implements Runnable {
    private final ListenableFutureTask<OAuthValue> task;
    private final RefreshTaskListener listener;

    RefreshTask(ListenableFutureTask<OAuthValue> task, RefreshTaskListener listener) {
      this.task = task;
      this.listener = listener;

      // Update Credential state first
      task.addListener(listener, MoreExecutors.directExecutor());

      // Then notify the world
      Futures.addCallback(
          task,
          new FutureCallback<OAuthValue>() {
            @Override
            public void onSuccess(OAuthValue result) {
              RefreshTask.this.set(result);
            }

            @Override
            public void onFailure(Throwable t) {
              RefreshTask.this.setException(t);
            }
          },
          MoreExecutors.directExecutor());
    }

    public ListenableFutureTask<OAuthValue> getTask() {
      return this.task;
    }

    @Override
    public void run() {
      task.run();
    }
  }

  public static class Builder {

    private AccessToken accessToken;
    private Duration refreshMargin = DEFAULT_REFRESH_MARGIN;
    private Duration expirationMargin = DEFAULT_EXPIRATION_MARGIN;

    protected Builder() {}

    protected Builder(OAuth2Credentials credentials) {
      this.accessToken = credentials.getAccessToken();
      this.refreshMargin = credentials.refreshMargin;
      this.expirationMargin = credentials.expirationMargin;
    }

    @CanIgnoreReturnValue
    public Builder setAccessToken(AccessToken token) {
      this.accessToken = token;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setRefreshMargin(Duration refreshMargin) {
      this.refreshMargin = refreshMargin;
      return this;
    }

    public Duration getRefreshMargin() {
      return refreshMargin;
    }

    @CanIgnoreReturnValue
    public Builder setExpirationMargin(Duration expirationMargin) {
      this.expirationMargin = expirationMargin;
      return this;
    }

    public Duration getExpirationMargin() {
      return expirationMargin;
    }

    public AccessToken getAccessToken() {
      return accessToken;
    }

    public OAuth2Credentials build() {
      return new OAuth2Credentials(accessToken, refreshMargin, expirationMargin);
    }
  }
}
