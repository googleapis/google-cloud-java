/*
 * Copyright 2025, Google LLC
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
 *    * Neither the name of Google LLC nor the names of its
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

package com.google.auth.credentialaccessboundary;

import static com.google.auth.oauth2.OAuth2Credentials.getFromServiceLoader;
import static com.google.auth.oauth2.OAuth2Utils.TOKEN_EXCHANGE_URL_FORMAT;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Clock;
import com.google.auth.Credentials;
import com.google.auth.credentialaccessboundary.protobuf.ClientSideAccessBoundary;
import com.google.auth.credentialaccessboundary.protobuf.ClientSideAccessBoundaryRule;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.CredentialAccessBoundary;
import com.google.auth.oauth2.CredentialAccessBoundary.AccessBoundaryRule;
import com.google.auth.oauth2.DownscopedCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh;
import com.google.auth.oauth2.OAuth2Utils;
import com.google.auth.oauth2.StsRequestHandler;
import com.google.auth.oauth2.StsTokenExchangeRequest;
import com.google.auth.oauth2.StsTokenExchangeResponse;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.RegistryConfiguration;
import com.google.crypto.tink.TinkProtoKeysetFormat;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dev.cel.common.CelAbstractSyntaxTree;
import dev.cel.common.CelOptions;
import dev.cel.common.CelProtoAbstractSyntaxTree;
import dev.cel.common.CelValidationException;
import dev.cel.compiler.CelCompiler;
import dev.cel.compiler.CelCompilerFactory;
import dev.cel.expr.Expr;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/**
 * A factory for generating downscoped access tokens using a client-side approach.
 *
 * <p>Downscoped tokens enable the ability to downscope, or restrict, the Identity and Access
 * Management (IAM) permissions that a short-lived credential can use for accessing Google Cloud
 * Storage. This factory allows clients to efficiently generate multiple downscoped tokens locally,
 * minimizing calls to the Security Token Service (STS). This client-side approach is particularly
 * beneficial when Credential Access Boundary rules change frequently or when many unique downscoped
 * tokens are required. For scenarios where rules change infrequently or a single downscoped
 * credential is reused many times, the server-side approach using {@link DownscopedCredentials} is
 * more appropriate.
 *
 * <p>To downscope permissions you must define a {@link CredentialAccessBoundary} which specifies
 * the upper bound of permissions that the credential can access. You must also provide a source
 * credential which will be used to acquire the downscoped credential.
 *
 * <p>The factory can be configured with options such as the {@code refreshMargin} and {@code
 * minimumTokenLifetime}. The {@code refreshMargin} controls how far in advance of the underlying
 * credentials' expiry a refresh is attempted. The {@code minimumTokenLifetime} ensures that
 * generated tokens have a minimum usable lifespan. See the {@link Builder} class for more details
 * on these options.
 *
 * <p>Usage:
 *
 * <pre><code>
 * GoogleCredentials sourceCredentials = GoogleCredentials.getApplicationDefault()
 *     .createScoped("https://www.googleapis.com/auth/cloud-platform");
 *
 * ClientSideCredentialAccessBoundaryFactory factory =
 *     ClientSideCredentialAccessBoundaryFactory.newBuilder()
 *         .setSourceCredential(sourceCredentials)
 *         .build();
 *
 * CredentialAccessBoundary.AccessBoundaryRule rule =
 *     CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
 *         .setAvailableResource(
 *             "//storage.googleapis.com/projects/_/buckets/bucket")
 *         .addAvailablePermission("inRole:roles/storage.objectViewer")
 *         .build();
 *
 * CredentialAccessBoundary credentialAccessBoundary =
 *     CredentialAccessBoundary.newBuilder().addRule(rule).build();
 *
 * AccessToken downscopedAccessToken = factory.generateToken(credentialAccessBoundary);
 *
 * OAuth2Credentials credentials = OAuth2Credentials.create(downscopedAccessToken);
 *
 * Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
 *
 * Blob blob = storage.get(BlobId.of("bucket", "object"));
 * System.out.printf("Blob %s retrieved.", blob.getBlobId());
 * </code></pre>
 *
 * Note that {@link OAuth2CredentialsWithRefresh} can instead be used to consume the downscoped
 * token, allowing for automatic token refreshes by providing a {@link
 * OAuth2CredentialsWithRefresh.OAuth2RefreshHandler}.
 */
public class ClientSideCredentialAccessBoundaryFactory {
  static final Duration DEFAULT_REFRESH_MARGIN = Duration.ofMinutes(45);
  static final Duration DEFAULT_MINIMUM_TOKEN_LIFETIME = Duration.ofMinutes(30);
  private final GoogleCredentials sourceCredential;
  private final transient HttpTransportFactory transportFactory;
  private final String tokenExchangeEndpoint;
  private final Duration minimumTokenLifetime;
  private final Duration refreshMargin;
  private RefreshTask refreshTask;
  private final Object refreshLock = new byte[0];
  private IntermediateCredentials intermediateCredentials = null;
  private final Clock clock;
  private final CelCompiler celCompiler;

  enum RefreshType {
    NONE,
    ASYNC,
    BLOCKING
  }

  private ClientSideCredentialAccessBoundaryFactory(Builder builder) {
    this.transportFactory = builder.transportFactory;
    this.sourceCredential = builder.sourceCredential;
    this.tokenExchangeEndpoint = builder.tokenExchangeEndpoint;
    this.refreshMargin = builder.refreshMargin;
    this.minimumTokenLifetime = builder.minimumTokenLifetime;
    this.clock = builder.clock;

    // Initializes the Tink AEAD registry for encrypting the client-side restrictions.
    try {
      AeadConfig.register();
    } catch (GeneralSecurityException e) {
      throw new IllegalStateException("Error occurred when registering Tink", e);
    }

    CelOptions options = CelOptions.current().build();
    this.celCompiler = CelCompilerFactory.standardCelCompilerBuilder().setOptions(options).build();
  }

  /**
   * Generates a downscoped access token given the {@link CredentialAccessBoundary}.
   *
   * @param accessBoundary The credential access boundary that defines the restrictions for the
   *     generated CAB token.
   * @return The downscoped access token in an {@link AccessToken} object
   * @throws IOException If an I/O error occurs while refreshing the source credentials
   * @throws CelValidationException If the availability condition is an invalid CEL expression
   * @throws GeneralSecurityException If an error occurs during encryption
   */
  public AccessToken generateToken(CredentialAccessBoundary accessBoundary)
      throws IOException, CelValidationException, GeneralSecurityException {
    this.refreshCredentialsIfRequired();

    String intermediateToken;
    String sessionKey;
    Date intermediateTokenExpirationTime;

    synchronized (refreshLock) {
      intermediateToken = this.intermediateCredentials.intermediateAccessToken.getTokenValue();
      intermediateTokenExpirationTime =
          this.intermediateCredentials.intermediateAccessToken.getExpirationTime();
      sessionKey = this.intermediateCredentials.accessBoundarySessionKey;
    }

    byte[] rawRestrictions = this.serializeCredentialAccessBoundary(accessBoundary);

    byte[] encryptedRestrictions = this.encryptRestrictions(rawRestrictions, sessionKey);

    // withoutPadding() is used to stay consistent with server-side CAB
    // withoutPadding() avoids additional URL encoded token issues (i.e. extra equal signs `=` in
    // the path)
    String tokenValue =
        intermediateToken
            + "."
            + Base64.getUrlEncoder().withoutPadding().encodeToString(encryptedRestrictions);

    return new AccessToken(tokenValue, intermediateTokenExpirationTime);
  }

  /**
   * Refreshes the intermediate access token and access boundary session key if required.
   *
   * <p>This method checks the expiration time of the current intermediate access token and
   * initiates a refresh if necessary. The refresh process also refreshes the underlying source
   * credentials.
   *
   * @throws IOException If an error occurs during the refresh process, such as network issues,
   *     invalid credentials, or problems with the token exchange endpoint.
   */
  @VisibleForTesting
  void refreshCredentialsIfRequired() throws IOException {
    RefreshType refreshType = determineRefreshType();

    if (refreshType == RefreshType.NONE) {
      // No refresh needed, token is still valid.
      return;
    }

    // If a refresh is required, create or retrieve the refresh task.
    RefreshTask currentRefreshTask = getOrCreateRefreshTask();

    // Handle the refresh based on the determined refresh type.
    switch (refreshType) {
      case BLOCKING:
        if (currentRefreshTask.isNew) {
          // Start a new refresh task only if the task is new.
          MoreExecutors.directExecutor().execute(currentRefreshTask.task);
        }
        try {
          // Wait for the refresh task to complete.
          currentRefreshTask.task.get();
        } catch (InterruptedException e) {
          // Restore the interrupted status and throw an exception.
          Thread.currentThread().interrupt();
          throw new IOException(
              "Interrupted while asynchronously refreshing the intermediate credentials", e);
        } catch (ExecutionException e) {
          // Unwrap the underlying cause of the execution exception.
          Throwable cause = e.getCause();
          if (cause instanceof IOException) {
            throw (IOException) cause;
          } else if (cause instanceof RuntimeException) {
            throw (RuntimeException) cause;
          } else {
            // Wrap other exceptions in an IOException.
            throw new IOException("Unexpected error refreshing intermediate credentials", cause);
          }
        }
        break;
      case ASYNC:
        if (currentRefreshTask.isNew) {
          // Starts a new background thread for the refresh task if it's a new task.
          // We create a new thread because the Auth Library doesn't currently include a background
          // executor. Introducing an executor would add complexity in managing its lifecycle and
          // could potentially lead to memory leaks.
          // We limit the number of concurrent refresh threads to 1, so the overhead of creating new
          // threads for asynchronous calls should be acceptable.
          new Thread(currentRefreshTask.task).start();
        } // (No else needed - if not new, another thread is handling the refresh)
        break;
      default:
        // This should not happen unless RefreshType enum is extended and this method is not
        // updated.
        throw new IllegalStateException("Unexpected refresh type: " + refreshType);
    }
  }

  private RefreshType determineRefreshType() {
    AccessToken intermediateAccessToken;
    synchronized (refreshLock) {
      if (intermediateCredentials == null
          || intermediateCredentials.intermediateAccessToken == null) {
        // A blocking refresh is needed if the intermediate access token doesn't exist.
        return RefreshType.BLOCKING;
      }
      intermediateAccessToken = intermediateCredentials.intermediateAccessToken;
    }

    Date expirationTime = intermediateAccessToken.getExpirationTime();
    if (expirationTime == null) {
      // Token does not expire, no refresh needed.
      return RefreshType.NONE;
    }

    Duration remaining = Duration.ofMillis(expirationTime.getTime() - clock.currentTimeMillis());

    if (remaining.compareTo(minimumTokenLifetime) <= 0) {
      // Intermediate token has expired or remaining lifetime is less than the minimum required
      // for CAB token generation. A blocking refresh is necessary.
      return RefreshType.BLOCKING;
    } else if (remaining.compareTo(refreshMargin) <= 0) {
      // The token is nearing expiration, an async refresh is needed.
      return RefreshType.ASYNC;
    }
    // Token is still fresh, no refresh needed.
    return RefreshType.NONE;
  }

  /**
   * Atomically creates a single flight refresh task.
   *
   * <p>Only a single refresh task can be scheduled at a time. If there is an existing task, it will
   * be returned for subsequent invocations. However, if a new task is created, it is the
   * responsibility of the caller to execute it. The task will clear the single flight slot upon
   * completion.
   */
  private RefreshTask getOrCreateRefreshTask() {
    synchronized (refreshLock) {
      if (refreshTask != null) {
        // An existing refresh task is already in progress. Return a NEW RefreshTask instance with
        // the existing task, but set isNew to false. This indicates to the caller that a new
        // refresh task was NOT created.
        return new RefreshTask(refreshTask.task, false);
      }

      final ListenableFutureTask<IntermediateCredentials> task =
          ListenableFutureTask.create(this::fetchIntermediateCredentials);

      // Store the new refresh task in the refreshTask field before returning. This ensures that
      // subsequent calls to this method will return the existing task while it's still in progress.
      refreshTask = new RefreshTask(task, true);
      return refreshTask;
    }
  }

  /**
   * Fetches the credentials by refreshing the source credential and exchanging it for an
   * intermediate access token using the STS endpoint.
   *
   * <p>The source credential is refreshed, and a token exchange request is made to the STS endpoint
   * to obtain an intermediate access token and an associated access boundary session key. This
   * ensures the intermediate access token meets this factory's refresh margin and minimum lifetime
   * requirements.
   *
   * @return The fetched {@link IntermediateCredentials} containing the intermediate access token
   *     and access boundary session key.
   * @throws IOException If an error occurs during credential refresh or token exchange.
   */
  @VisibleForTesting
  IntermediateCredentials fetchIntermediateCredentials() throws IOException {
    try {
      // Force a refresh on the source credentials. The intermediate token's lifetime is tied to the
      // source credential's expiration. The factory's refreshMargin might be different from the
      // refreshMargin on source credentials. This ensures the intermediate access token
      // meets this factory's refresh margin and minimum lifetime requirements.
      sourceCredential.refresh();
    } catch (IOException e) {
      throw new IOException("Unable to refresh the provided source credential.", e);
    }

    AccessToken sourceAccessToken = sourceCredential.getAccessToken();
    if (sourceAccessToken == null || Strings.isNullOrEmpty(sourceAccessToken.getTokenValue())) {
      throw new IllegalStateException("The source credential does not have an access token.");
    }

    StsTokenExchangeRequest request =
        StsTokenExchangeRequest.newBuilder(
                sourceAccessToken.getTokenValue(), OAuth2Utils.TOKEN_TYPE_ACCESS_TOKEN)
            .setRequestTokenType(OAuth2Utils.TOKEN_TYPE_ACCESS_BOUNDARY_INTERMEDIARY_TOKEN)
            .build();

    StsRequestHandler handler =
        StsRequestHandler.newBuilder(
                tokenExchangeEndpoint, request, transportFactory.create().createRequestFactory())
            .build();

    StsTokenExchangeResponse response = handler.exchangeToken();
    return new IntermediateCredentials(
        getTokenFromResponse(response, sourceAccessToken), response.getAccessBoundarySessionKey());
  }

  /**
   * Extracts the access token from the STS exchange response and sets the appropriate expiration
   * time.
   *
   * @param response The STS token exchange response.
   * @param sourceAccessToken The original access token used for the exchange.
   * @return The intermediate access token.
   */
  private static AccessToken getTokenFromResponse(
      StsTokenExchangeResponse response, AccessToken sourceAccessToken) {
    AccessToken intermediateToken = response.getAccessToken();

    // The STS endpoint will only return the expiration time for the intermediate token
    // if the original access token represents a service account.
    // The intermediate token's expiration time will always match the source credential expiration.
    // When no expires_in is returned, we can copy the source credential's expiration time.
    if (intermediateToken.getExpirationTime() == null
        && sourceAccessToken.getExpirationTime() != null) {
      return new AccessToken(
          intermediateToken.getTokenValue(), sourceAccessToken.getExpirationTime());
    }

    // Return original if no modification needed.
    return intermediateToken;
  }

  /**
   * Completes the refresh task by storing the results and clearing the single flight slot.
   *
   * <p>This method is called when a refresh task finishes. It stores the refreshed credentials if
   * successful. The single-flight "slot" is cleared, allowing subsequent refresh attempts. Any
   * exceptions during the refresh are caught and suppressed to prevent indefinite blocking of
   * subsequent refresh attempts.
   */
  private void finishRefreshTask(ListenableFuture<IntermediateCredentials> finishedTask)
      throws ExecutionException {
    synchronized (refreshLock) {
      try {
        this.intermediateCredentials = Futures.getDone(finishedTask);
      } finally {
        if (this.refreshTask != null && this.refreshTask.task == finishedTask) {
          this.refreshTask = null;
        }
      }
    }
  }

  @VisibleForTesting
  String getTokenExchangeEndpoint() {
    return tokenExchangeEndpoint;
  }

  @VisibleForTesting
  HttpTransportFactory getTransportFactory() {
    return transportFactory;
  }

  @VisibleForTesting
  Duration getRefreshMargin() {
    return refreshMargin;
  }

  @VisibleForTesting
  Duration getMinimumTokenLifetime() {
    return minimumTokenLifetime;
  }

  /**
   * Holds intermediate credentials obtained from the STS token exchange endpoint.
   *
   * <p>These credentials include an intermediate access token and an access boundary session key.
   */
  @VisibleForTesting
  static class IntermediateCredentials {
    private final AccessToken intermediateAccessToken;
    private final String accessBoundarySessionKey;

    IntermediateCredentials(AccessToken accessToken, String accessBoundarySessionKey) {
      this.intermediateAccessToken = accessToken;
      this.accessBoundarySessionKey = accessBoundarySessionKey;
    }

    String getAccessBoundarySessionKey() {
      return accessBoundarySessionKey;
    }

    AccessToken getIntermediateAccessToken() {
      return intermediateAccessToken;
    }
  }

  /**
   * Represents a task for refreshing intermediate credentials, ensuring that only one refresh
   * operation is in progress at a time.
   *
   * <p>The {@code isNew} flag indicates whether this is a newly initiated refresh operation or an
   * existing one already in progress. This distinction is used to prevent redundant refreshes.
   */
  class RefreshTask extends AbstractFuture<IntermediateCredentials> implements Runnable {
    private final ListenableFutureTask<IntermediateCredentials> task;
    final boolean isNew;

    RefreshTask(ListenableFutureTask<IntermediateCredentials> task, boolean isNew) {
      this.task = task;
      this.isNew = isNew;

      // Add listener to update factory's credentials when the task completes.
      task.addListener(
          () -> {
            try {
              finishRefreshTask(task);
            } catch (ExecutionException e) {
              Throwable cause = e.getCause();
              RefreshTask.this.setException(cause);
            }
          },
          MoreExecutors.directExecutor());

      // Add callback to set the result or exception based on the outcome.
      Futures.addCallback(
          task,
          new FutureCallback<IntermediateCredentials>() {
            @Override
            public void onSuccess(IntermediateCredentials result) {
              RefreshTask.this.set(result);
            }

            @Override
            public void onFailure(@Nullable Throwable t) {
              RefreshTask.this.setException(
                  t != null ? t : new IOException("Refresh failed with null Throwable."));
            }
          },
          MoreExecutors.directExecutor());
    }

    @Override
    public void run() {
      task.run();
    }
  }

  /** Serializes a {@link CredentialAccessBoundary} object into Protobuf wire format. */
  @VisibleForTesting
  byte[] serializeCredentialAccessBoundary(CredentialAccessBoundary credentialAccessBoundary)
      throws CelValidationException {
    List<AccessBoundaryRule> rules = credentialAccessBoundary.getAccessBoundaryRules();
    ClientSideAccessBoundary.Builder accessBoundaryBuilder = ClientSideAccessBoundary.newBuilder();

    for (AccessBoundaryRule rule : rules) {
      ClientSideAccessBoundaryRule.Builder ruleBuilder =
          accessBoundaryBuilder
              .addAccessBoundaryRulesBuilder()
              .addAllAvailablePermissions(rule.getAvailablePermissions())
              .setAvailableResource(rule.getAvailableResource());

      // Availability condition is an optional field from the CredentialAccessBoundary
      // CEL compilation is only performed if there is a non-empty availability condition.
      if (rule.getAvailabilityCondition() != null) {
        String availabilityCondition = rule.getAvailabilityCondition().getExpression();

        Expr availabilityConditionExpr = this.compileCel(availabilityCondition);
        ruleBuilder.setCompiledAvailabilityCondition(availabilityConditionExpr);
      }
    }

    return accessBoundaryBuilder.build().toByteArray();
  }

  /** Compiles CEL expression from String to an {@link Expr} proto object. */
  private Expr compileCel(String expr) throws CelValidationException {
    CelAbstractSyntaxTree ast = celCompiler.parse(expr).getAst();

    CelProtoAbstractSyntaxTree astProto = CelProtoAbstractSyntaxTree.fromCelAst(ast);

    return astProto.getExpr();
  }

  /** Encrypts the given bytes using a sessionKey using Tink Aead. */
  private byte[] encryptRestrictions(byte[] restriction, String sessionKey)
      throws GeneralSecurityException {
    byte[] rawKey;

    try {
      rawKey = Base64.getDecoder().decode(sessionKey);
    } catch (IllegalArgumentException e) {
      // Session key from the server is expected to be Base64 encoded.
      throw new IllegalStateException("Session key is not Base64 encoded", e);
    }

    KeysetHandle keysetHandle =
        TinkProtoKeysetFormat.parseKeyset(rawKey, InsecureSecretKeyAccess.get());

    Aead aead = keysetHandle.getPrimitive(RegistryConfiguration.get(), Aead.class);

    // For downscoped access token encryption, empty associated data is expected.
    // Tink requires a byte[0] to be passed for this case.
    return aead.encrypt(restriction, /* associatedData= */ new byte[0]);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Builder for {@link ClientSideCredentialAccessBoundaryFactory}.
   *
   * <p>Use this builder to create instances of {@code ClientSideCredentialAccessBoundaryFactory}
   * with the desired configuration options.
   */
  public static class Builder {
    private GoogleCredentials sourceCredential;
    private HttpTransportFactory transportFactory;
    private String universeDomain;
    private String tokenExchangeEndpoint;
    private Duration minimumTokenLifetime;
    private Duration refreshMargin;
    private Clock clock = Clock.SYSTEM; // Default to system clock;

    private Builder() {}

    /**
     * Sets the required source credential.
     *
     * @param sourceCredential the {@code GoogleCredentials} to set. This is a
     *     <strong>required</strong> parameter.
     * @return this {@code Builder} object for chaining.
     * @throws NullPointerException if {@code sourceCredential} is {@code null}.
     */
    @CanIgnoreReturnValue
    public Builder setSourceCredential(GoogleCredentials sourceCredential) {
      checkNotNull(sourceCredential, "Source credential must not be null.");
      this.sourceCredential = sourceCredential;
      return this;
    }

    /**
     * Sets the minimum acceptable lifetime for a generated downscoped access token.
     *
     * <p>This parameter ensures that any generated downscoped access token has a minimum validity
     * period. If the time remaining before the underlying credentials expire is less than this
     * value, the factory will perform a blocking refresh, meaning that it will wait until the
     * credentials are refreshed before generating a new downscoped token. This guarantees that the
     * generated token will be valid for at least {@code minimumTokenLifetime}. A reasonable value
     * should be chosen based on the expected duration of operations using the downscoped token. If
     * not set, the default value is defined by {@link #DEFAULT_MINIMUM_TOKEN_LIFETIME}.
     *
     * @param minimumTokenLifetime The minimum acceptable lifetime for a generated downscoped access
     *     token. Must be greater than zero.
     * @return This {@code Builder} object.
     * @throws IllegalArgumentException if {@code minimumTokenLifetime} is negative or zero.
     */
    @CanIgnoreReturnValue
    public Builder setMinimumTokenLifetime(Duration minimumTokenLifetime) {
      checkNotNull(minimumTokenLifetime, "Minimum token lifetime must not be null.");
      if (minimumTokenLifetime.isNegative() || minimumTokenLifetime.isZero()) {
        throw new IllegalArgumentException("Minimum token lifetime must be greater than zero.");
      }
      this.minimumTokenLifetime = minimumTokenLifetime;
      return this;
    }

    /**
     * Sets the refresh margin for the underlying credentials.
     *
     * <p>This duration specifies how far in advance of the credentials' expiration time an
     * asynchronous refresh should be initiated. This refresh happens in the background, without
     * blocking the main thread. If not provided, it will default to the value defined by {@link
     * #DEFAULT_REFRESH_MARGIN}.
     *
     * <p>Note: The {@code refreshMargin} must be at least one minute longer than the {@code
     * minimumTokenLifetime}.
     *
     * @param refreshMargin The refresh margin. Must be greater than zero.
     * @return This {@code Builder} object.
     * @throws IllegalArgumentException if {@code refreshMargin} is negative or zero.
     */
    @CanIgnoreReturnValue
    public Builder setRefreshMargin(Duration refreshMargin) {
      checkNotNull(refreshMargin, "Refresh margin must not be null.");
      if (refreshMargin.isNegative() || refreshMargin.isZero()) {
        throw new IllegalArgumentException("Refresh margin must be greater than zero.");
      }
      this.refreshMargin = refreshMargin;
      return this;
    }

    /**
     * Sets the HTTP transport factory.
     *
     * @param transportFactory the {@code HttpTransportFactory} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      this.transportFactory = transportFactory;
      return this;
    }

    /**
     * Sets the optional universe domain.
     *
     * @param universeDomain the universe domain to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setUniverseDomain(String universeDomain) {
      this.universeDomain = universeDomain;
      return this;
    }

    /**
     * Set the clock for checking token expiry. Used for testing.
     *
     * @param clock the clock to use. Defaults to the system clock
     * @return the builder
     */
    public Builder setClock(Clock clock) {
      this.clock = clock;
      return this;
    }

    /**
     * Creates a new {@code ClientSideCredentialAccessBoundaryFactory} instance based on the current
     * builder configuration.
     *
     * @return A new {@code ClientSideCredentialAccessBoundaryFactory} instance.
     * @throws IllegalStateException if the builder is not properly configured (e.g., if the source
     *     credential is not set).
     * @throws IllegalArgumentException if the refresh margin is not at least one minute longer than
     *     the minimum token lifetime.
     */
    public ClientSideCredentialAccessBoundaryFactory build() {
      checkNotNull(sourceCredential, "Source credential must not be null.");

      // Use the default HTTP transport factory if none was provided.
      if (transportFactory == null) {
        this.transportFactory =
            getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
      }

      // Default to GDU when not supplied.
      if (Strings.isNullOrEmpty(universeDomain)) {
        this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
      }

      // Ensure source credential's universe domain matches.
      try {
        if (!universeDomain.equals(sourceCredential.getUniverseDomain())) {
          throw new IllegalArgumentException(
              "The client side access boundary credential's universe domain must be the same as the source "
                  + "credential.");
        }
      } catch (IOException e) {
        // Throwing an IOException would be a breaking change, so wrap it here.
        throw new IllegalStateException(
            "Error occurred when attempting to retrieve source credential universe domain.", e);
      }

      // Use default values for refreshMargin if not provided.
      if (refreshMargin == null) {
        this.refreshMargin = DEFAULT_REFRESH_MARGIN;
      }

      // Use default values for minimumTokenLifetime if not provided.
      if (minimumTokenLifetime == null) {
        this.minimumTokenLifetime = DEFAULT_MINIMUM_TOKEN_LIFETIME;
      }

      // Check if refreshMargin is at least one minute longer than minimumTokenLifetime.
      Duration minRefreshMargin = minimumTokenLifetime.plusMinutes(1);
      if (refreshMargin.compareTo(minRefreshMargin) < 0) {
        throw new IllegalArgumentException(
            "Refresh margin must be at least one minute longer than the minimum token lifetime.");
      }

      this.tokenExchangeEndpoint = String.format(TOKEN_EXCHANGE_URL_FORMAT, universeDomain);
      return new ClientSideCredentialAccessBoundaryFactory(this);
    }
  }
}
