/*
 * Copyright 2019, Google Inc. All rights reserved.
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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.GenericData;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.MetricsUtils.RequestType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * This internal class provides shared utilities for interacting with the IAM API for common
 * features like signing.
 */
@NullMarked
class IamUtils {

  // IAM credentials endpoints are to be formatted with universe domain and client email.
  static final String IAM_ID_TOKEN_ENDPOINT_FORMAT =
      "https://iamcredentials.%s/v1/projects/-/serviceAccounts/%s:generateIdToken";
  static final String IAM_ACCESS_TOKEN_ENDPOINT_FORMAT =
      "https://iamcredentials.%s/v1/projects/-/serviceAccounts/%s:generateAccessToken";
  static final String IAM_SIGN_BLOB_ENDPOINT_FORMAT =
      "https://iamcredentials.%s/v1/projects/-/serviceAccounts/%s:signBlob";
  private static final String PARSE_ERROR_MESSAGE = "Error parsing error message response. ";
  private static final String PARSE_ERROR_SIGNATURE = "Error parsing signature response. ";
  private static final LoggerProvider LOGGER_PROVIDER = LoggerProvider.forClazz(IamUtils.class);

  // Following guidance for IAM retries:
  // https://cloud.google.com/iam/docs/retry-strategy#errors-to-retry
  static final Set<Integer> IAM_RETRYABLE_STATUS_CODES =
      new HashSet<>(Arrays.asList(500, 502, 503, 504));

  // Prefix that turns a universe domain into the mTLS domain in the IAM_*_ENDPOINT_FORMAT URLs,
  // for example iamcredentials.mtls.googleapis.com.
  private static final String MTLS_DOMAIN_PREFIX = "mtls.";

  // Overrides the per-CertInfo mTLS transport factory in tests; null uses CertInfo's shared
  // MtlsHttpTransportFactory.
  private static volatile @Nullable Function<KeyStore, HttpTransportFactory>
      mtlsTransportFactoryProvider;

  /**
   * The credentials, transport and endpoint domain to use for one IAM Credentials call.
   *
   * <p>{@link #endpointDomain} is the value to substitute into the {@code IAM_*_ENDPOINT_FORMAT}
   * templates (and to pass as the universe domain argument of {@link #sign} and {@link
   * #getIdToken}): the universe domain, or {@code mtls.<universe domain>} for the mTLS endpoint.
   */
  static final class IamCallTarget {
    final Credentials credentials;
    final HttpTransportFactory transportFactory;
    final String endpointDomain;
    private final boolean usesMtls;

    IamCallTarget(
        Credentials credentials,
        HttpTransportFactory transportFactory,
        String endpointDomain,
        boolean usesMtls) {
      this.credentials = credentials;
      this.transportFactory = transportFactory;
      this.endpointDomain = endpointDomain;
      this.usesMtls = usesMtls;
    }

    boolean usesMtls() {
      return usesMtls;
    }
  }

  /**
   * A {@link GoogleCredentials} pinned to a single already-minted {@link BoundAccessToken}, so the
   * request header always uses the token bound to the presented mTLS certificate even if the source
   * credential refreshes concurrently.
   */
  private static final class PinnedTokenCredentials extends GoogleCredentials {
    private static final long serialVersionUID = 1L;
    private final transient BoundAccessToken token;

    PinnedTokenCredentials(
        BoundAccessToken token, @Nullable String quotaProjectId, String universeDomain) {
      super(
          GoogleCredentials.newBuilder()
              .setQuotaProjectId(quotaProjectId)
              .setUniverseDomain(universeDomain));
      this.token = token;
    }

    @Override
    public AccessToken refreshAccessToken() {
      return token;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      throw new NotSerializableException("PinnedTokenCredentials cannot be serialized");
    }

    private void readObject(ObjectInputStream in) throws IOException {
      throw new InvalidObjectException("PinnedTokenCredentials cannot be deserialized");
    }
  }

  /**
   * Returns where and how to send an IAM Credentials call that is authenticated with {@code
   * authCredentials}.
   *
   * <p>When {@code authCredentials} is a {@link ComputeEngineCredentials} whose current access
   * token is bound to an agent identity certificate, a bound token is accepted only over mTLS,
   * presenting that certificate, to the mTLS endpoint. In that case the call goes to {@code
   * iamcredentials.mtls.<universe domain>} over an mTLS transport that presents the certificate the
   * token was bound to, authenticated with that same token.
   *
   * <p>Otherwise, and whenever the caller customized the transport or the universe domain isn't the
   * default one, the call goes to {@code iamcredentials.<universe domain>} with {@code
   * authCredentials} and {@code transportFactory}, as before.
   */
  static IamCallTarget resolveCallTarget(
      Credentials authCredentials, HttpTransportFactory transportFactory, String universeDomain)
      throws IOException {
    if (!(transportFactory instanceof OAuth2Utils.DefaultHttpTransportFactory)) {
      return new IamCallTarget(
          authCredentials, transportFactory, universeDomain, /* usesMtls= */ false);
    }
    return resolveBoundTokenCallTarget(
        authCredentials, transportFactory, universeDomain, mtlsTransportFactoryProvider);
  }

  /**
   * Refreshes {@code authCredentials} after a 401 response on a bound-token mTLS call and resolves
   * a fresh {@link IamCallTarget} for a single retry.
   *
   * <p>Skips forcing a refresh when another thread has already refreshed {@code authCredentials} to
   * a different token or certificate. Returns {@code null} if the refresh fails or produces the
   * same bound token value and certificate as {@code previousTarget}, so the caller surfaces the
   * original 401 instead of resending an identical rejected request.
   */
  static @Nullable IamCallTarget refreshAndResolveRetryTarget(
      Credentials authCredentials,
      HttpTransportFactory transportFactory,
      String universeDomain,
      IamCallTarget previousTarget) {
    if (!previousTarget.usesMtls()
        || !(previousTarget.credentials instanceof PinnedTokenCredentials)
        || !(authCredentials instanceof ComputeEngineCredentials)) {
      return null;
    }
    BoundAccessToken previousToken = ((PinnedTokenCredentials) previousTarget.credentials).token;
    ComputeEngineCredentials computeEngineCredentials = (ComputeEngineCredentials) authCredentials;
    try {
      AccessToken currentToken = computeEngineCredentials.getAccessToken();
      if (currentToken == null || isSameBoundToken(previousToken, currentToken)) {
        computeEngineCredentials.refresh();
      }
      IamCallTarget retryTarget =
          resolveCallTarget(authCredentials, transportFactory, universeDomain);
      if (retryTarget.credentials instanceof PinnedTokenCredentials
          && isSameBoundToken(
              previousToken, ((PinnedTokenCredentials) retryTarget.credentials).token)) {
        return null;
      }
      return retryTarget;
    } catch (IOException e) {
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.WARNING,
          Collections.emptyMap(),
          "Unable to refresh credentials after 401 response: " + e.getMessage());
      return null;
    }
  }

  private static boolean isSameBoundToken(
      BoundAccessToken previousToken, @Nullable AccessToken candidateToken) {
    if (!(candidateToken instanceof BoundAccessToken)) {
      return false;
    }
    BoundAccessToken candidate = (BoundAccessToken) candidateToken;
    return Objects.equals(previousToken.getTokenValue(), candidate.getTokenValue())
        && !OAuth2Utils.hasCertificateChanged(
            previousToken.getCertInfo().getKeyStore(), candidate.getCertInfo().getKeyStore());
  }

  @VisibleForTesting
  static void setMtlsTransportFactoryProvider(
      @Nullable Function<KeyStore, HttpTransportFactory> provider) {
    mtlsTransportFactoryProvider = provider;
  }

  @VisibleForTesting
  static void resetForTest() {
    mtlsTransportFactoryProvider = null;
  }

  /**
   * Like {@link #resolveCallTarget}, without the transport check, and with an optional mTLS
   * transport factory override supplied by the caller (when {@code null}, uses the shared {@link
   * com.google.auth.mtls.MtlsHttpTransportFactory} on the token's {@link
   * AgentIdentityUtils.CertInfo}).
   */
  @VisibleForTesting
  static IamCallTarget resolveBoundTokenCallTarget(
      Credentials authCredentials,
      HttpTransportFactory transportFactory,
      String universeDomain,
      @Nullable Function<KeyStore, HttpTransportFactory> mtlsTransportFactory)
      throws IOException {
    IamCallTarget defaultTarget =
        new IamCallTarget(authCredentials, transportFactory, universeDomain, /* usesMtls= */ false);
    if (!(authCredentials instanceof ComputeEngineCredentials)
        || !Credentials.GOOGLE_DEFAULT_UNIVERSE.equals(universeDomain)) {
      return defaultTarget;
    }
    ComputeEngineCredentials computeEngineCredentials = (ComputeEngineCredentials) authCredentials;
    computeEngineCredentials.refreshIfExpired();
    // The token object carries the certificate it was bound to, so the token and the certificate
    // presented below always match, even if another thread refreshes the credentials meanwhile.
    final AccessToken token = computeEngineCredentials.getAccessToken();
    if (!(token instanceof BoundAccessToken)) {
      return defaultTarget;
    }
    BoundAccessToken boundToken = (BoundAccessToken) token;
    AgentIdentityUtils.CertInfo certInfo = boundToken.getCertInfo();
    KeyStore keyStore = certInfo.getKeyStore();
    if (keyStore == null) {
      return defaultTarget;
    }
    HttpTransportFactory resolvedTransportFactory =
        mtlsTransportFactory != null
            ? mtlsTransportFactory.apply(keyStore)
            : certInfo.getMtlsTransportFactory();
    if (resolvedTransportFactory == null) {
      return defaultTarget;
    }
    // Authenticate with exactly this token: the source credentials could otherwise refresh and
    // attach a token bound to a different certificate. Calling refresh() populates OAuthValue in
    // memory via getAdditionalHeaders() after quotaProjectId is initialized, so x-goog-user-project
    // is preserved while getAccessToken() and getRequestMetadata() start ready without extra I/O.
    PinnedTokenCredentials pinnedTokenCredentials =
        new PinnedTokenCredentials(
            boundToken, computeEngineCredentials.getQuotaProjectId(), universeDomain);
    pinnedTokenCredentials.refresh();
    return new IamCallTarget(
        pinnedTokenCredentials,
        resolvedTransportFactory,
        MTLS_DOMAIN_PREFIX + universeDomain,
        /* usesMtls= */ true);
  }

  /**
   * Returns a signature for the provided bytes.
   *
   * @param serviceAccountEmail the email address for the service account used for signing
   * @param credentials credentials required for making the IAM call
   * @param transport transport used for building the HTTP request
   * @param toSign bytes to sign
   * @param additionalFields additional fields to send in the IAM call
   * @return signed bytes
   * @throws ServiceAccountSigner.SigningException if signing fails
   */
  static byte[] sign(
      String serviceAccountEmail,
      Credentials credentials,
      String universeDomain,
      HttpTransport transport,
      byte[] toSign,
      Map<String, ?> additionalFields) {
    BaseEncoding base64 = BaseEncoding.base64();
    HttpRequestFactory factory =
        transport.createRequestFactory(new HttpCredentialsAdapter(credentials));
    String signature;
    try {
      signature =
          getSignature(
              serviceAccountEmail,
              universeDomain,
              base64.encode(toSign),
              additionalFields,
              factory);
    } catch (IOException ex) {
      throw new ServiceAccountSigner.SigningException("Failed to sign the provided bytes", ex);
    }
    return base64.decode(signature);
  }

  private static String getSignature(
      String serviceAccountEmail,
      String universeDomain,
      String bytes,
      Map<String, ?> additionalFields,
      HttpRequestFactory factory)
      throws IOException {
    String signBlobUrl =
        String.format(IAM_SIGN_BLOB_ENDPOINT_FORMAT, universeDomain, serviceAccountEmail);
    GenericUrl genericUrl = new GenericUrl(signBlobUrl);

    GenericData signRequest = new GenericData();
    signRequest.set("payload", bytes);
    for (Map.Entry<String, ?> entry : additionalFields.entrySet()) {
      signRequest.set(entry.getKey(), entry.getValue());
    }
    JsonHttpContent signContent = new JsonHttpContent(OAuth2Utils.JSON_FACTORY, signRequest);

    HttpRequest request = factory.buildPostRequest(genericUrl, signContent);

    // Disable automatic logging by google-http-java-client to prevent leakage of sensitive tokens.
    // Client Library Debug Logging via LoggingUtils is used instead.
    request.setLoggingEnabled(false);

    JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
    request.setParser(parser);
    request.setThrowExceptionOnExecuteError(false);
    request.setNumberOfRetries(OAuth2Utils.DEFAULT_NUMBER_OF_RETRIES);

    ExponentialBackOff backoff =
        new ExponentialBackOff.Builder()
            .setInitialIntervalMillis(OAuth2Utils.INITIAL_RETRY_INTERVAL_MILLIS)
            .setRandomizationFactor(OAuth2Utils.RETRY_RANDOMIZATION_FACTOR)
            .setMultiplier(OAuth2Utils.RETRY_MULTIPLIER)
            .build();

    // Retry on 500, 502, 503, and 503 status codes
    request.setUnsuccessfulResponseHandler(
        new HttpBackOffUnsuccessfulResponseHandler(backoff)
            .setBackOffRequired(
                response ->
                    IamUtils.IAM_RETRYABLE_STATUS_CODES.contains(response.getStatusCode())));
    request.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(backoff));

    LoggingUtils.logRequest(
        request, LOGGER_PROVIDER, "Sending request to get signature to sign the blob");
    HttpResponse response = request.execute();
    LoggingUtils.logResponse(
        response, LOGGER_PROVIDER, "Received response for signature to sign the blob");
    int statusCode = response.getStatusCode();
    if (statusCode >= 400 && statusCode < HttpStatusCodes.STATUS_CODE_SERVER_ERROR) {
      String errorMessage = parseErrorMessage(response);
      throw new IOException(
          String.format(
              "Error code %s trying to sign provided bytes: %s", statusCode, errorMessage));
    }

    // Request will have retried a 5xx error 3 times and is still receiving a 5xx error code
    if (statusCode != HttpStatusCodes.STATUS_CODE_OK) {
      throw new IOException(
          String.format(
              "Unexpected Error code %s trying to sign provided bytes: %s",
              statusCode, response.parseAsString()));
    }
    InputStream content = response.getContent();
    if (content == null) {
      // Throw explicitly here on empty content to avoid NullPointerException from parseAs call.
      // Mock transports will have success code with empty content by default.
      throw new IOException("Empty content from sign blob server request.");
    }

    GenericData responseData = response.parseAs(GenericData.class);
    LoggingUtils.logResponsePayload(
        responseData, LOGGER_PROVIDER, "Response payload for sign blob");
    return OAuth2Utils.validateString(responseData, "signedBlob", PARSE_ERROR_SIGNATURE);
  }

  /**
   * Returns the error message from an IAM Credentials 4xx response, or falls back to the HTTP
   * status message when the body is missing, empty, not JSON, or lacks {@code error.message}.
   *
   * <p>For example, {@code HttpURLConnection} (used by {@code NetHttpTransport}) discards the body
   * of a 401 or 407 response to a request sent in streaming mode (every POST with content) and of
   * any response with {@code Content-Length: 0}, and proxies can return HTML or other non-IAM
   * bodies. Falling back preserves the HTTP status code in the caller's {@link IOException} instead
   * of failing with a {@link NullPointerException}, {@link IllegalArgumentException}, or JSON parse
   * error.
   */
  private static String parseErrorMessage(HttpResponse response) {
    GenericData responseError;
    try {
      if (response.getContent() == null) {
        return getStatusMessageOrDefault(response);
      }
      responseError = response.parseAs(GenericData.class);
    } catch (IOException | IllegalArgumentException e) {
      // Empty body ("no JSON input found"), non-JSON body (for example, an HTML error page from a
      // proxy), or unreadable stream.
      return getStatusMessageOrDefault(response);
    }
    if (responseError != null) {
      Object error = responseError.get("error");
      if (error instanceof Map) {
        Object message = ((Map<?, ?>) error).get("message");
        if (message instanceof String && !((String) message).isEmpty()) {
          return (String) message;
        }
      }
    }
    return getStatusMessageOrDefault(response);
  }

  private static String getStatusMessageOrDefault(HttpResponse response) {
    String statusMessage = response.getStatusMessage();
    return Strings.isNullOrEmpty(statusMessage)
        ? "(no error details in the response)"
        : statusMessage;
  }

  /**
   * Resolves the IAM call target (routing bound agent-identity tokens over mTLS) and requests an ID
   * token, performing a single source-credential refresh and retry if IAM rejects a bound token
   * with HTTP 401.
   */
  static IdToken getIdToken(
      String serviceAccountEmail,
      Credentials authCredentials,
      HttpTransportFactory transportFactory,
      String targetAudience,
      boolean includeEmail,
      Map<String, ?> additionalFields,
      CredentialTypeForMetrics credentialTypeForMetrics,
      String universeDomain)
      throws IOException {
    IamCallTarget target = resolveCallTarget(authCredentials, transportFactory, universeDomain);
    HttpResponse response =
        executeIdTokenRequest(
            serviceAccountEmail,
            target.credentials,
            target.transportFactory.create(),
            targetAudience,
            includeEmail,
            additionalFields,
            credentialTypeForMetrics,
            target.endpointDomain,
            /* disableAdapterRetry= */ target.usesMtls());
    if (target.usesMtls() && response.getStatusCode() == HttpStatusCodes.STATUS_CODE_UNAUTHORIZED) {
      IamCallTarget retryTarget =
          refreshAndResolveRetryTarget(authCredentials, transportFactory, universeDomain, target);
      if (retryTarget != null) {
        try {
          response.ignore();
        } catch (IOException ignored) {
          // Best-effort cleanup of the rejected 401 response before retrying.
        }
        response =
            executeIdTokenRequest(
                serviceAccountEmail,
                retryTarget.credentials,
                retryTarget.transportFactory.create(),
                targetAudience,
                includeEmail,
                additionalFields,
                credentialTypeForMetrics,
                retryTarget.endpointDomain,
                /* disableAdapterRetry= */ true);
      }
    }
    return parseIdTokenResponse(response);
  }

  /**
   * Returns an IdToken issued to the serviceAccount with a specified targetAudience
   *
   * @param serviceAccountEmail the email address for the service account to get an ID Token for
   * @param credentials credentials required for making the IAM call
   * @param transport transport used for building the HTTP request
   * @param targetAudience the audience the issued ID token should include
   * @param additionalFields additional fields to send in the IAM call
   * @param credentialTypeForMetrics credential type for credential making this call
   * @return IdToken issed to the serviceAccount
   * @throws IOException if the IdToken cannot be issued.
   * @see <a
   *     href="https://cloud.google.com/iam/credentials/reference/rest/v1/projects.serviceAccounts/generateIdToken">...</a>
   */
  static IdToken getIdToken(
      String serviceAccountEmail,
      Credentials credentials,
      HttpTransport transport,
      String targetAudience,
      boolean includeEmail,
      Map<String, ?> additionalFields,
      CredentialTypeForMetrics credentialTypeForMetrics,
      String universeDomain)
      throws IOException {
    HttpResponse response =
        executeIdTokenRequest(
            serviceAccountEmail,
            credentials,
            transport,
            targetAudience,
            includeEmail,
            additionalFields,
            credentialTypeForMetrics,
            universeDomain,
            /* disableAdapterRetry= */ credentials instanceof PinnedTokenCredentials);
    return parseIdTokenResponse(response);
  }

  private static HttpResponse executeIdTokenRequest(
      String serviceAccountEmail,
      Credentials credentials,
      HttpTransport transport,
      String targetAudience,
      boolean includeEmail,
      Map<String, ?> additionalFields,
      CredentialTypeForMetrics credentialTypeForMetrics,
      String universeDomain,
      boolean disableAdapterRetry)
      throws IOException {
    String idTokenUrl =
        String.format(IAM_ID_TOKEN_ENDPOINT_FORMAT, universeDomain, serviceAccountEmail);
    GenericUrl genericUrl = new GenericUrl(idTokenUrl);

    GenericData idTokenRequest = new GenericData();
    idTokenRequest.set("audience", targetAudience);
    idTokenRequest.set("includeEmail", includeEmail);
    for (Map.Entry<String, ?> entry : additionalFields.entrySet()) {
      idTokenRequest.set(entry.getKey(), entry.getValue());
    }
    JsonHttpContent idTokenContent = new JsonHttpContent(OAuth2Utils.JSON_FACTORY, idTokenRequest);

    HttpCredentialsAdapter adapter = new HttpCredentialsAdapter(credentials);
    HttpRequest request =
        transport.createRequestFactory(adapter).buildPostRequest(genericUrl, idTokenContent);
    if (disableAdapterRetry) {
      // PinnedTokenCredentials always returns the same token on refresh(), so disable
      // HttpCredentialsAdapter's 401 retry to avoid resending a rejected token 10 times; the
      // caller performs at most one outer refresh-and-retry pairing the new token and certificate.
      request.setUnsuccessfulResponseHandler(null);
    }

    // Disable automatic logging by google-http-java-client to prevent leakage of sensitive tokens.
    // Client Library Debug Logging via LoggingUtils is used instead.
    request.setLoggingEnabled(false);

    JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
    request.setParser(parser);
    request.setThrowExceptionOnExecuteError(false);

    MetricsUtils.setMetricsHeader(
        request,
        MetricsUtils.getGoogleCredentialsMetricsHeader(
            RequestType.ID_TOKEN_REQUEST, credentialTypeForMetrics));

    LoggingUtils.logRequest(request, LOGGER_PROVIDER, "Sending request to get ID token");
    HttpResponse response = request.execute();

    LoggingUtils.logResponse(response, LOGGER_PROVIDER, "Received response for ID token request");
    return response;
  }

  private static IdToken parseIdTokenResponse(HttpResponse response) throws IOException {
    int statusCode = response.getStatusCode();
    if (statusCode >= 400 && statusCode < HttpStatusCodes.STATUS_CODE_SERVER_ERROR) {
      String errorMessage = parseErrorMessage(response);
      throw new IOException(
          String.format("Error code %s trying to getIDToken: %s", statusCode, errorMessage));
    }
    if (statusCode != HttpStatusCodes.STATUS_CODE_OK) {
      throw new IOException(
          String.format(
              "Unexpected Error code %s trying to getIDToken: %s",
              statusCode, response.parseAsString()));
    }
    InputStream content = response.getContent();
    if (content == null) {
      // Throw explicitly here on empty content to avoid NullPointerException from
      // parseAs call.
      // Mock transports will have success code with empty content by default.
      throw new IOException("Empty content from generateIDToken server request.");
    }

    GenericJson responseData = response.parseAs(GenericJson.class);
    LoggingUtils.logResponsePayload(
        responseData, LOGGER_PROVIDER, "Response payload for ID token request");
    String rawToken = OAuth2Utils.validateString(responseData, "token", PARSE_ERROR_MESSAGE);
    return IdToken.create(rawToken);
  }
}
