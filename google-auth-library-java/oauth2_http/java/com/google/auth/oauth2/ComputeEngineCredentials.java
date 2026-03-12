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

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.Retryable;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.MetricsUtils.RequestType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * OAuth2 credentials representing the built-in service account for a Google Compute Engine VM.
 *
 * <p>Fetches access tokens from the Google Compute Engine metadata server.
 *
 * <p>These credentials use the IAM API to sign data. See {@link #sign(byte[])} for more details.
 */
public class ComputeEngineCredentials extends GoogleCredentials
    implements ServiceAccountSigner, IdTokenProvider {

  static final String METADATA_RESPONSE_EMPTY_CONTENT_ERROR_MESSAGE =
      "Empty content from metadata token server request.";
  // Decrease timing margins on GCE.
  // This is needed because GCE VMs maintain their own OAuth cache that expires T-4 mins, attempting
  // to refresh a token before then, will yield the same stale token. To enable pre-emptive
  // refreshes, the margins must be shortened. This shouldn't cause problems since the clock skew
  // on the VM and metadata proxy should be non-existent.
  static final Duration COMPUTE_EXPIRATION_MARGIN = Duration.ofMinutes(3);
  static final Duration COMPUTE_REFRESH_MARGIN = Duration.ofMinutes(3).plusSeconds(45);

  private static final Logger LOGGER = Logger.getLogger(ComputeEngineCredentials.class.getName());
  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(ComputeEngineCredentials.class);

  static final String DEFAULT_METADATA_SERVER_URL = "http://metadata.google.internal";

  // Note: the explicit `timeout` and `tries` below is a workaround. The underlying
  // issue is that resolving an unknown host on some networks will take
  // 20-30 seconds; making this timeout short fixes the issue, but
  // could lead to false negatives in the event that we are on GCE, but
  // the metadata resolution was particularly slow. The latter case is
  // "unlikely" since the expected 4-nines time is about 0.5 seconds.
  // This allows us to limit the total ping maximum timeout to 1.5 seconds
  // for developer desktop scenarios.
  static final int MAX_COMPUTE_PING_TRIES = 3;
  static final int COMPUTE_PING_CONNECTION_TIMEOUT_MS = 500;

  private static final String METADATA_FLAVOR = "Metadata-Flavor";
  private static final String GOOGLE = "Google";
  private static final String WINDOWS = "windows";
  private static final String LINUX = "linux";

  private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
  private static final String PARSE_ERROR_ACCOUNT = "Error parsing service account response. ";
  private static final long serialVersionUID = -4113476462526554235L;

  private final String transportFactoryClassName;

  private final Collection<String> scopes;

  private final GoogleAuthTransport transport;
  private final BindingEnforcement bindingEnforcement;

  private transient HttpTransportFactory transportFactory;

  private String universeDomainFromMetadata = null;

  /**
   * Experimental Feature.
   *
   * <p>{@link GoogleAuthTransport} specifies how to authenticate to Google APIs.
   *
   * <p>Behavior of setting {@link GoogleAuthTransport} / {@link BindingEnforcement}:
   *
   * <p>MTLS-bound token where binding enforcement depends on IAM policy: MTLS / IAM_POLICY
   *
   * <p>MTLS-bound token where bindings are always enforced: MTLS / ON
   *
   * <p>DirectPath bound token: ALTS / {}
   */
  public enum GoogleAuthTransport {
    // Authenticating to Google APIs via DirectPath
    ALTS("alts"),
    // Authenticating to Google APIs via GFE
    MTLS("mtls");

    private final String label;

    private GoogleAuthTransport(String label) {
      this.label = label;
    }

    public String getLabel() {
      return label;
    }
  }

  /**
   * Experimental Feature.
   *
   * <p>{@link BindingEnforcement} specifies how binding info in tokens will be enforced.
   *
   * <p>Behavior of setting {@link GoogleAuthTransport} / {@link BindingEnforcement}:
   *
   * <p>MTLS-bound token where binding enforcement depends on IAM policy: MTLS / {}, {} /
   * IAM_POLICY, MTLS / IAM_POLICY
   *
   * <p>MTLS-bound token where bindings are always enforced: {} / ON, MTLS / ON
   *
   * <p>DirectPath bound token: ALTS / {}
   */
  public enum BindingEnforcement {
    // Binding enforcement will always happen, irrespective of the IAM policy.
    ON("on"),
    // Binding enforcement will depend on IAM policy.
    IAM_POLICY("iam-policy");

    private final String label;

    private BindingEnforcement(String label) {
      this.label = label;
    }

    public String getLabel() {
      return label;
    }
  }

  /**
   * An internal constructor
   *
   * @param builder A builder for {@link ComputeEngineCredentials} See {@link
   *     ComputeEngineCredentials.Builder}
   */
  private ComputeEngineCredentials(ComputeEngineCredentials.Builder builder) {
    super(builder);
    this.transportFactory =
        firstNonNull(
            builder.getHttpTransportFactory(),
            getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    this.transportFactoryClassName = this.transportFactory.getClass().getName();
    // Use defaultScopes only when scopes don't exist.
    Collection<String> scopesToUse = builder.scopes;
    if (scopesToUse == null || scopesToUse.isEmpty()) {
      scopesToUse = builder.getDefaultScopes();
    }
    if (scopesToUse == null) {
      this.scopes = ImmutableSet.<String>of();
    } else {
      List<String> scopeList = new ArrayList<String>(scopesToUse);
      scopeList.removeAll(Arrays.asList("", null));
      this.scopes = ImmutableSet.<String>copyOf(scopeList);
    }
    this.transport = builder.getGoogleAuthTransport();
    this.bindingEnforcement = builder.getBindingEnforcement();
    this.name = GoogleCredentialsInfo.COMPUTE_ENGINE_CREDENTIALS.getCredentialName();
  }

  @Override
  public CredentialTypeForMetrics getMetricsCredentialType() {
    return CredentialTypeForMetrics.VM_CREDENTIALS;
  }

  /** Clones the compute engine account with the specified scopes. */
  @Override
  public GoogleCredentials createScoped(Collection<String> newScopes) {
    return createScoped(newScopes, ImmutableList.of());
  }

  /** Clones the compute engine account with the specified scopes and default scopes. */
  @Override
  public GoogleCredentials createScoped(
      Collection<String> newScopes, Collection<String> newDefaultScopes) {
    return this.toBuilder()
        .setHttpTransportFactory(transportFactory)
        .setScopes(newScopes)
        .setDefaultScopes(newDefaultScopes)
        .setAccessToken(null)
        .build();
  }

  /**
   * Create a new ComputeEngineCredentials instance with default behavior.
   *
   * @return new ComputeEngineCredentials
   */
  public static ComputeEngineCredentials create() {
    return new ComputeEngineCredentials(ComputeEngineCredentials.newBuilder());
  }

  public final Collection<String> getScopes() {
    return scopes;
  }

  /**
   * If scopes is specified, add "?scopes=comma-separated-list-of-scopes" to the token url. If
   * transport is specified, add "?transport=xyz" to the token url; xyz is one of "alts" or "mtls".
   * If bindingEnforcement is specified, add "?binding-enforcement=xyz" to the token url; xyz is one
   * of "iam-policy" or "on".
   *
   * @return token url with the given scopes
   */
  String createTokenUrlWithScopes() {
    GenericUrl tokenUrl = new GenericUrl(getTokenServerEncodedUrl());
    if (!scopes.isEmpty()) {
      tokenUrl.set("scopes", Joiner.on(',').join(scopes));
    }
    if (transport != null) {
      tokenUrl.set("transport", transport.getLabel());
    }
    if (bindingEnforcement != null) {
      tokenUrl.set("binding-enforcement", bindingEnforcement.getLabel());
    }
    return tokenUrl.toString();
  }

  /**
   * Gets the universe domain from the GCE metadata server.
   *
   * <p>Returns an explicit universe domain if it was provided during credential initialization.
   *
   * <p>Returns the {@link Credentials#GOOGLE_DEFAULT_UNIVERSE} if universe domain endpoint is not
   * found (404) or returns an empty string.
   *
   * <p>Otherwise, returns universe domain from GCE metadata service.
   *
   * <p>Any above value is cached for the credential lifetime.
   *
   * @throws IOException if a call to GCE metadata service was unsuccessful. Check if exception
   *     implements the {@link Retryable} and {@code isRetryable()} will return true if the
   *     operation may be retried.
   * @return string representing a universe domain in the format some-domain.xyz
   */
  @Override
  public String getUniverseDomain() throws IOException {
    if (isExplicitUniverseDomain()) {
      return super.getUniverseDomain();
    }

    synchronized (this) {
      if (this.universeDomainFromMetadata != null) {
        return this.universeDomainFromMetadata;
      }
    }

    String universeDomainFromMetadata = getUniverseDomainFromMetadata();
    synchronized (this) {
      this.universeDomainFromMetadata = universeDomainFromMetadata;
    }
    return universeDomainFromMetadata;
  }

  private String getUniverseDomainFromMetadata() throws IOException {
    HttpResponse response =
        getMetadataResponse(getUniverseDomainUrl(), RequestType.UNTRACKED, false);
    int statusCode = response.getStatusCode();
    if (statusCode == HttpStatusCodes.STATUS_CODE_NOT_FOUND) {
      return Credentials.GOOGLE_DEFAULT_UNIVERSE;
    }
    if (statusCode != HttpStatusCodes.STATUS_CODE_OK) {
      IOException cause =
          new IOException(
              String.format(
                  "Unexpected Error code %s trying to get universe domain"
                      + " from Compute Engine metadata for the default service account: %s",
                  statusCode, response.parseAsString()));
      throw new GoogleAuthException(true, cause);
    }
    String responseString = response.parseAsString();

    /* Earlier versions of MDS that supports universe_domain return empty string instead of GDU. */
    if (responseString.isEmpty()) {
      return Credentials.GOOGLE_DEFAULT_UNIVERSE;
    }
    return responseString;
  }

  /** Refresh the access token by getting it from the GCE metadata server */
  @Override
  public AccessToken refreshAccessToken() throws IOException {
    HttpResponse response =
        getMetadataResponse(createTokenUrlWithScopes(), RequestType.ACCESS_TOKEN_REQUEST, true);
    int statusCode = response.getStatusCode();
    if (statusCode == HttpStatusCodes.STATUS_CODE_NOT_FOUND) {
      throw new IOException(
          String.format(
              "Error code %s trying to get security access token from"
                  + " Compute Engine metadata for the default service account. This may be because"
                  + " the virtual machine instance does not have permission scopes specified."
                  + " It is possible to skip checking for Compute Engine metadata by specifying the environment "
                  + " variable "
                  + DefaultCredentialsProvider.NO_GCE_CHECK_ENV_VAR
                  + "=true.",
              statusCode));
    }
    if (statusCode != HttpStatusCodes.STATUS_CODE_OK) {
      throw new IOException(
          String.format(
              "Unexpected Error code %s trying to get security access"
                  + " token from Compute Engine metadata for the default service account: %s",
              statusCode, response.parseAsString()));
    }
    InputStream content = response.getContent();
    if (content == null) {
      // Throw explicitly here on empty content to avoid NullPointerException from parseAs call.
      // Mock transports will have success code with empty content by default.
      throw new IOException(METADATA_RESPONSE_EMPTY_CONTENT_ERROR_MESSAGE);
    }
    GenericData responseData = response.parseAs(GenericData.class);
    LoggingUtils.logResponsePayload(
        responseData, LOGGER_PROVIDER, "Response payload for access token");
    String accessToken =
        OAuth2Utils.validateString(responseData, "access_token", PARSE_ERROR_PREFIX);
    int expiresInSeconds =
        OAuth2Utils.validateInt32(responseData, "expires_in", PARSE_ERROR_PREFIX);
    long expiresAtMilliseconds = clock.currentTimeMillis() + expiresInSeconds * 1000;

    return new AccessToken(accessToken, new Date(expiresAtMilliseconds));
  }

  /**
   * Returns a Google ID Token from the metadata server on ComputeEngine
   *
   * @param targetAudience the aud: field the IdToken should include
   * @param options list of Credential specific options for the token. For example, an IDToken for a
   *     ComputeEngineCredential could have the full formatted claims returned if
   *     IdTokenProvider.Option.FORMAT_FULL) is provided as a list option. Valid option values are:
   *     <br>
   *     IdTokenProvider.Option.FORMAT_FULL<br>
   *     IdTokenProvider.Option.LICENSES_TRUE<br>
   *     If no options are set, the defaults are "&amp;format=standard&amp;licenses=false"
   * @throws IOException if the attempt to get an IdToken failed
   * @return IdToken object which includes the raw id_token, JsonWebSignature
   */
  @Override
  public IdToken idTokenWithAudience(String targetAudience, List<IdTokenProvider.Option> options)
      throws IOException {
    GenericUrl documentUrl = new GenericUrl(getIdentityDocumentUrl());
    if (options != null) {
      if (options.contains(IdTokenProvider.Option.FORMAT_FULL)) {
        documentUrl.set("format", "full");
      }
      if (options.contains(IdTokenProvider.Option.LICENSES_TRUE)) {
        // licenses will only get returned if format is also full
        documentUrl.set("format", "full");
        documentUrl.set("licenses", "TRUE");
      }
    }
    documentUrl.set("audience", targetAudience);
    HttpResponse response =
        getMetadataResponse(documentUrl.toString(), RequestType.ID_TOKEN_REQUEST, true);
    int statusCode = response.getStatusCode();
    if (statusCode == HttpStatusCodes.STATUS_CODE_NOT_FOUND) {
      throw new IOException(
          String.format(
              "Error code %s trying to get identity token from"
                  + " Compute Engine metadata. This may be because the virtual machine instance"
                  + " does not have permission scopes specified.",
              statusCode));
    }
    if (statusCode != HttpStatusCodes.STATUS_CODE_OK) {
      throw new IOException(
          String.format(
              "Unexpected Error code %s trying to get identity token from Compute Engine metadata: %s",
              statusCode, response.parseAsString()));
    }
    InputStream content = response.getContent();
    if (content == null) {
      throw new IOException(METADATA_RESPONSE_EMPTY_CONTENT_ERROR_MESSAGE);
    }
    String rawToken = response.parseAsString();

    LoggingUtils.log(
        LOGGER_PROVIDER,
        Level.FINE,
        ImmutableMap.of("idToken", rawToken),
        "Response Payload for ID token");
    return IdToken.create(rawToken);
  }

  private HttpResponse getMetadataResponse(
      String url, RequestType requestType, boolean shouldSendMetricsHeader) throws IOException {
    GenericUrl genericUrl = new GenericUrl(url);
    HttpRequest request =
        transportFactory.create().createRequestFactory().buildGetRequest(genericUrl);
    JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
    request.setParser(parser);
    request.getHeaders().set(METADATA_FLAVOR, GOOGLE);
    // do not send metric header for getUniverseDomain and getAccount
    if (shouldSendMetricsHeader) {
      MetricsUtils.setMetricsHeader(
          request,
          MetricsUtils.getGoogleCredentialsMetricsHeader(requestType, getMetricsCredentialType()));
    }

    request.setThrowExceptionOnExecuteError(false);
    HttpResponse response;
    try {
      String requestMessage;
      String responseMessage;
      if (requestType.equals(RequestType.ID_TOKEN_REQUEST)) {
        requestMessage = "Sending request to get ID token";
        responseMessage = "Received response for ID token request";
      } else if (requestType.equals(RequestType.ACCESS_TOKEN_REQUEST)) {
        requestMessage = "Sending request to refresh access token";
        responseMessage = "Received response for refresh access token";
      } else {
        // TODO: this includes get universe domain and get default sa.
        // refactor for more clear logging message.
        requestMessage = "Sending request for universe domain/default service account";
        responseMessage = "Received response for universe domain/default service account";
      }
      LoggingUtils.logRequest(request, LOGGER_PROVIDER, requestMessage);
      response = request.execute();
      LoggingUtils.logResponse(response, LOGGER_PROVIDER, responseMessage);
    } catch (UnknownHostException exception) {
      throw new IOException(
          "ComputeEngineCredentials cannot find the metadata server. This is"
              + " likely because code is not running on Google Compute Engine.",
          exception);
    }

    if (response.getStatusCode() == 503) {
      throw GoogleAuthException.createWithTokenEndpointResponseException(
          new HttpResponseException(response));
    }

    return response;
  }

  /**
   * Implements an algorithm to detect whether the code is running on Google Compute Environment
   * (GCE) or equivalent runtime. <a href="https://google.aip.dev/auth/4115">See AIP-4115 for more
   * details</a> The algorithm consists of active and passive checks: <br>
   * <b>Active:</b> to check that GCE Metadata service is present by sending a http request to send
   * a request to {@code ComputeEngineCredentials.DEFAULT_METADATA_SERVER_URL}
   *
   * <p><b>Passive:</b> to check if SMBIOS variable is present and contains expected value. This
   * step is platform specific:
   *
   * <p><b>For Linux:</b> check if the file "/sys/class/dmi/id/product_name" exists and contains a
   * line that starts with Google.
   *
   * <p><b>For Windows:</b> to be implemented
   *
   * <p><b>Other platforms:</b> not supported
   *
   * <p>This algorithm can be disabled with environment variable {@code
   * DefaultCredentialsProvider.NO_GCE_CHECK_ENV_VAR} set to {@code true}. In this case, the
   * algorithm will always return {@code false} Returns {@code true} if currently running on Google
   * Compute Environment (GCE) or equivalent runtime. Returns {@code false} if detection fails,
   * platform is not supported or if detection disabled using the environment variable.
   */
  static synchronized boolean isOnGce(
      HttpTransportFactory transportFactory, DefaultCredentialsProvider provider) {
    // If the environment has requested that we do no GCE checks, return immediately.
    if (Boolean.parseBoolean(provider.getEnv(DefaultCredentialsProvider.NO_GCE_CHECK_ENV_VAR))) {
      return false;
    }

    boolean result = pingComputeEngineMetadata(transportFactory, provider);

    if (!result) {
      result = checkStaticGceDetection(provider);
    }

    if (!result) {
      LOGGER.log(Level.FINE, "Failed to detect whether running on Google Compute Engine.");
    }

    return result;
  }

  @VisibleForTesting
  static boolean checkProductNameOnLinux(BufferedReader reader) throws IOException {
    String name = reader.readLine().trim();
    return name.startsWith(GOOGLE);
  }

  @VisibleForTesting
  static boolean checkStaticGceDetection(DefaultCredentialsProvider provider) {
    String osName = provider.getOsName();
    try {
      if (osName.startsWith(LINUX)) {
        // Checks GCE residency on Linux platform.
        File linuxFile = new File("/sys/class/dmi/id/product_name");
        return checkProductNameOnLinux(
            new BufferedReader(new InputStreamReader(provider.readStream(linuxFile))));
      } else if (osName.startsWith(WINDOWS)) {
        // Checks GCE residency on Windows platform.
        // TODO: implement registry check via FFI
        return false;
      }
    } catch (IOException e) {
      LOGGER.log(Level.FINE, "Encountered an unexpected exception when checking SMBIOS value", e);
      return false;
    }
    // Platforms other than Linux and Windows are not supported.
    return false;
  }

  private static boolean pingComputeEngineMetadata(
      HttpTransportFactory transportFactory, DefaultCredentialsProvider provider) {
    GenericUrl tokenUrl = new GenericUrl(getMetadataServerUrl(provider));
    for (int i = 1; i <= MAX_COMPUTE_PING_TRIES; ++i) {
      try {
        HttpRequest request =
            transportFactory.create().createRequestFactory().buildGetRequest(tokenUrl);
        request.setConnectTimeout(COMPUTE_PING_CONNECTION_TIMEOUT_MS);
        request.getHeaders().set(METADATA_FLAVOR, GOOGLE);
        MetricsUtils.setMetricsHeader(
            request,
            MetricsUtils.getGoogleCredentialsMetricsHeader(
                RequestType.METADATA_SERVER_PING, CredentialTypeForMetrics.DO_NOT_SEND));
        HttpResponse response = request.execute();
        try {
          // Internet providers can return a generic response to all requests, so it is necessary
          // to check that metadata header is present also.
          HttpHeaders headers = response.getHeaders();
          return OAuth2Utils.headersContainValue(headers, METADATA_FLAVOR, GOOGLE);
        } finally {
          response.disconnect();
        }
      } catch (SocketTimeoutException expected) {
        // Ignore logging timeouts which is the expected failure mode in non GCE environments.
      } catch (IOException e) {
        LOGGER.log(
            Level.FINE,
            "Encountered an unexpected exception when checking"
                + " if running on Google Compute Engine using Metadata Service ping.",
            e);
      }
    }
    return false;
  }

  public static String getMetadataServerUrl(DefaultCredentialsProvider provider) {
    String metadataServerAddress =
        provider.getEnv(DefaultCredentialsProvider.GCE_METADATA_HOST_ENV_VAR);
    if (metadataServerAddress != null) {
      return "http://" + metadataServerAddress;
    }
    return DEFAULT_METADATA_SERVER_URL;
  }

  public static String getMetadataServerUrl() {
    return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT);
  }

  public static String getTokenServerEncodedUrl(DefaultCredentialsProvider provider) {
    return getMetadataServerUrl(provider)
        + "/computeMetadata/v1/instance/service-accounts/default/token";
  }

  public static String getTokenServerEncodedUrl() {
    return getTokenServerEncodedUrl(DefaultCredentialsProvider.DEFAULT);
  }

  public static String getUniverseDomainUrl() {
    return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT)
        + "/computeMetadata/v1/universe/universe-domain";
  }

  public static String getServiceAccountsUrl() {
    return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT)
        + "/computeMetadata/v1/instance/service-accounts/?recursive=true";
  }

  /** Url to retrieve the default service account entry from the Metadata Server. */
  static String getDefaultServiceAccountUrl() {
    return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT)
        + "/computeMetadata/v1/instance/service-accounts/default/email";
  }

  public static String getIdentityDocumentUrl() {
    return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT)
        + "/computeMetadata/v1/instance/service-accounts/default/identity";
  }

  @Override
  public int hashCode() {
    return Objects.hash(transportFactoryClassName);
  }

  @Override
  protected ToStringHelper toStringHelper() {
    synchronized (this) {
      return super.toStringHelper()
          .add("transportFactoryClassName", transportFactoryClassName)
          .add("scopes", scopes)
          .add("universeDomainFromMetadata", universeDomainFromMetadata);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ComputeEngineCredentials)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    ComputeEngineCredentials other = (ComputeEngineCredentials) obj;
    return Objects.equals(this.transportFactoryClassName, other.transportFactoryClassName)
        && Objects.equals(this.scopes, other.scopes)
        && Objects.equals(this.universeDomainFromMetadata, other.universeDomainFromMetadata);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    transportFactory = newInstance(transportFactoryClassName);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns the email address associated with the GCE default service account.
   *
   * @throws RuntimeException if the default service account cannot be read
   */
  @Override
  // todo(#314) getAccount should not throw a RuntimeException
  public String getAccount() {
    if (principal == null) {
      try {
        principal = getDefaultServiceAccount();
      } catch (IOException ex) {
        throw new RuntimeException("Failed to get service account", ex);
      }
    }
    return principal;
  }

  /**
   * Signs the provided bytes using the private key associated with the service account.
   *
   * <p>The Compute Engine's project must enable the Identity and Access Management (IAM) API and
   * the instance's service account must have the iam.serviceAccounts.signBlob permission.
   *
   * @param toSign bytes to sign
   * @return signed bytes
   * @throws SigningException if the attempt to sign the provided bytes failed
   * @see <a
   *     href="https://cloud.google.com/iam/credentials/reference/rest/v1/projects.serviceAccounts/signBlob">Blob
   *     Signing</a>
   */
  @Override
  public byte[] sign(byte[] toSign) {
    try {
      String account = getAccount();
      return IamUtils.sign(
          account,
          this,
          this.getUniverseDomain(),
          transportFactory.create(),
          toSign,
          Collections.<String, Object>emptyMap());
    } catch (SigningException ex) {
      throw ex;
    } catch (RuntimeException ex) {
      throw new SigningException("Signing failed", ex);
    } catch (IOException ex) {
      throw new SigningException("Failed to sign: Error obtaining universe domain", ex);
    }
  }

  private String getDefaultServiceAccount() throws IOException {
    HttpResponse response =
        getMetadataResponse(getDefaultServiceAccountUrl(), RequestType.UNTRACKED, false);
    int statusCode = response.getStatusCode();
    if (statusCode == HttpStatusCodes.STATUS_CODE_NOT_FOUND) {
      throw new IOException(
          String.format(
              "Error code %s trying to get service accounts from"
                  + " Compute Engine metadata. This may be because the virtual machine instance"
                  + " does not have permission scopes specified.",
              statusCode));
    }
    if (statusCode != HttpStatusCodes.STATUS_CODE_OK) {
      throw new IOException(
          String.format(
              "Unexpected Error code %s trying to get service accounts"
                  + " from Compute Engine metadata: %s",
              statusCode, response.parseAsString()));
    }
    InputStream content = response.getContent();
    if (content == null) {
      // Throw explicitly here on empty content to avoid NullPointerException from parseAs call.
      // Mock transports will have success code with empty content by default.
      throw new IOException(METADATA_RESPONSE_EMPTY_CONTENT_ERROR_MESSAGE);
    }
    return response.parseAsString();
  }

  public static class Builder extends GoogleCredentials.Builder {
    private HttpTransportFactory transportFactory;
    private Collection<String> scopes;
    private Collection<String> defaultScopes;

    private GoogleAuthTransport transport;
    private BindingEnforcement bindingEnforcement;

    protected Builder() {
      setRefreshMargin(COMPUTE_REFRESH_MARGIN);
      setExpirationMargin(COMPUTE_EXPIRATION_MARGIN);
    }

    protected Builder(ComputeEngineCredentials credentials) {
      super(credentials);
      this.transportFactory = credentials.transportFactory;
      this.scopes = credentials.scopes;
    }

    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      this.transportFactory = transportFactory;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes) {
      this.scopes = scopes;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setDefaultScopes(Collection<String> defaultScopes) {
      this.defaultScopes = defaultScopes;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setUniverseDomain(String universeDomain) {
      this.universeDomain = universeDomain;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      super.quotaProjectId = quotaProjectId;
      return this;
    }

    /**
     * Set the {@code GoogleAuthTransport} type.
     *
     * @param transport the transport type over which to authenticate to Google APIs
     */
    @CanIgnoreReturnValue
    public Builder setGoogleAuthTransport(GoogleAuthTransport transport) {
      this.transport = transport;
      return this;
    }

    /**
     * Set the {@code BindingEnforcement} type.
     *
     * @param bindingEnforcement the token binding enforcement policy.
     */
    @CanIgnoreReturnValue
    public Builder setBindingEnforcement(BindingEnforcement bindingEnforcement) {
      this.bindingEnforcement = bindingEnforcement;
      return this;
    }

    public HttpTransportFactory getHttpTransportFactory() {
      return transportFactory;
    }

    public Collection<String> getScopes() {
      return scopes;
    }

    public Collection<String> getDefaultScopes() {
      return defaultScopes;
    }

    /**
     * Get the {@code GoogleAuthTransport} type.
     *
     * @return the transport type over which to authenticate to Google APIs
     */
    public GoogleAuthTransport getGoogleAuthTransport() {
      return transport;
    }

    /**
     * Get the {@code BindingEnforcement} type.
     *
     * @return the token binding enforcement policy.
     */
    public BindingEnforcement getBindingEnforcement() {
      return bindingEnforcement;
    }

    @Override
    public ComputeEngineCredentials build() {
      return new ComputeEngineCredentials(this);
    }
  }
}
