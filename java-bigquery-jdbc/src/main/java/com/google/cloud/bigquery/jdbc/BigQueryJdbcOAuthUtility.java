/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.api.client.util.PemReader.readFirstSectionAndClose;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.OAUTH_TYPE_ERROR_MESSAGE;

import com.google.api.client.util.PemReader;
import com.google.api.client.util.SecurityUtils;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.ClientId;
import com.google.auth.oauth2.ExternalAccountCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;
import com.google.auth.oauth2.PKCEProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.UserAuthorizer;
import com.google.auth.oauth2.UserCredentials;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonReader;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

final class BigQueryJdbcOAuthUtility {

  private static final String USER_AUTH_SUCCESS_HTML_BODY =
      "<!DOCTYPE html><html><body>\n"
          + "Thank you for using JDBC Driver for Google BigQuery!\n"
          + "You may now close the window.</body></html>";
  private static final String USER_AUTH_BAD_REQUEST_HTML_BODY =
      "<!DOCTYPE html><html><body>\n"
          + "Authentication could not be completed. Please close this window and retry.\n"
          + "</body></html>";
  private static final String USER_AUTH_NOT_FOUND_HTML_BODY =
      "<!DOCTYPE html><html><body>Not Found</body></html>";

  private static final byte[] USER_AUTH_SUCCESS_HTTP_RESPONSE_BYTES =
      buildHttpResponseBytes(200, "OK", USER_AUTH_SUCCESS_HTML_BODY);
  private static final byte[] USER_AUTH_BAD_REQUEST_HTTP_RESPONSE_BYTES =
      buildHttpResponseBytes(400, "Bad Request", USER_AUTH_BAD_REQUEST_HTML_BODY);
  private static final byte[] USER_AUTH_NOT_FOUND_HTTP_RESPONSE_BYTES =
      buildHttpResponseBytes(404, "Not Found", USER_AUTH_NOT_FOUND_HTML_BODY);

  static final String BIGQUERY_SCOPE = "https://www.googleapis.com/auth/bigquery";
  static final String DRIVE_READONLY_SCOPE = "https://www.googleapis.com/auth/drive.readonly";

  static final List<String> DEFAULT_BIGQUERY_SCOPES = Arrays.asList(BIGQUERY_SCOPE);
  static final List<String> BIGQUERY_WITH_DRIVE_SCOPES =
      Arrays.asList(BIGQUERY_SCOPE, DRIVE_READONLY_SCOPE);

  private static final int USER_AUTH_TIMEOUT_MS = 120000;
  private static final int USER_AUTH_SOCKET_READ_TIMEOUT_MS = 5000;
  private static final int USER_AUTH_DRAIN_TIMEOUT_MS = 50;
  private static final int USER_AUTH_BACKLOG = 8;
  static final int MAX_HTTP_REQUEST_LINE_BYTES = 8192;
  private static final int MAX_HTTP_HEADER_BYTES = 16384;
  private static final int OAUTH_RANDOM_TOKEN_BYTES = 32;
  private static final int MAX_OAUTH_ERROR_LENGTH = 64;
  private static final SecureRandom SECURE_RANDOM = new SecureRandom();
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcOAuthUtility.class.getName());

  private static final Map<String, String> BYOID_NAME_MAP =
      new HashMap<String, String>() {
        {
          put(BigQueryJdbcUrlUtility.BYOID_AUDIENCE_URI_PROPERTY_NAME, "audience");
          put(BigQueryJdbcUrlUtility.BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME, "credential_source");
          put(BigQueryJdbcUrlUtility.BYOID_SUBJECT_TOKEN_TYPE_PROPERTY_NAME, "subject_token_type");
          put(BigQueryJdbcUrlUtility.BYOID_TOKEN_URI_PROPERTY_NAME, "token_url");
          put(
              BigQueryJdbcUrlUtility.BYOID_POOL_USER_PROJECT_PROPERTY_NAME,
              "workforce_pool_user_project");
          put(
              BigQueryJdbcUrlUtility.BYOID_SA_IMPERSONATION_URI_PROPERTY_NAME,
              "service_account_impersonation_url");
        }
      };

  /**
   * Parses the OAuth properties from the given URL.
   *
   * @param url The URL to parse.
   * @return A map of OAuth properties.
   */
  static Map<String, String> parseOAuthProperties(DataSource ds, String callerClassName) {
    LOG.finer("++enter++\t" + callerClassName);
    Map<String, String> oauthProperties = new HashMap<>();

    AuthType authType;
    try {
      authType = AuthType.fromValue(ds.getOAuthType());
    } catch (NumberFormatException exception) {
      LOG.severe(OAUTH_TYPE_ERROR_MESSAGE, exception);
      throw new IllegalArgumentException(OAUTH_TYPE_ERROR_MESSAGE);
    }
    oauthProperties.put(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME, String.valueOf(authType));

    switch (authType) {
      case GOOGLE_SERVICE_ACCOUNT:
        // For using a Google Service Account (OAuth Type 0)
        // need: project id, OAuthServiceAcctEmail and OAuthPvtKey or OAuthPvtKeyPath that can be
        // .p12 or json.
        // TODO: validation if .p12 or json file can be in getPropertyInfo can be handy for user
        String serviceAccountEmail = ds.getOAuthServiceAcctEmail();
        String serviceAccountPK = ds.getOAuthPvtKey();
        String serviceAccountPrivateKeyPath = ds.getOAuthPvtKeyPath();
        String p12Password = ds.getOAuthP12Password();

        oauthProperties.put(
            BigQueryJdbcUrlUtility.OAUTH_SA_EMAIL_PROPERTY_NAME, serviceAccountEmail);
        oauthProperties.put(BigQueryJdbcUrlUtility.OAUTH_P12_PASSWORD_PROPERTY_NAME, p12Password);
        if (serviceAccountEmail != null && serviceAccountPK != null) {
          oauthProperties.put(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME, serviceAccountPK);
        } else {
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME,
              serviceAccountPrivateKeyPath);
        }
        break;
      case GOOGLE_USER_ACCOUNT:
        oauthProperties.put(
            BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, ds.getOAuthClientId());
        oauthProperties.put(
            BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, ds.getOAuthClientSecret());
        break;
      case PRE_GENERATED_TOKEN:
        String refreshToken = ds.getOAuthRefreshToken();
        if (refreshToken != null) {
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME, refreshToken);
          LOG.fine("OAuthRefreshToken provided.");
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, ds.getOAuthClientId());
          LOG.fine("OAuthClientId provided.");
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, ds.getOAuthClientSecret());
          LOG.fine("OAuthClientSecret provided.");
          break;
        }
        oauthProperties.put(
            BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_PROPERTY_NAME, ds.getOAuthAccessToken());
        oauthProperties.put(
            BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_READONLY_PROPERTY_NAME,
            String.valueOf(ds.getOAuthAccessTokenReadonly()));
        LOG.fine("OAuthAccessToken provided.");
        break;
      case APPLICATION_DEFAULT_CREDENTIALS:
        // For Application Default Credentials (OAuth Type 3)
        // need: project id
        break;
      case EXTERNAL_ACCOUNT_AUTH:
        // For External account authentication (OAuth Type 4)
        // need: project id, OAuthPvtKey or OAuthPvtKeyPath or BYOID_PROPERTIES
        String pvtKey = ds.getOAuthPvtKey();
        String pvtKeyPath = ds.getOAuthPvtKeyPath();
        if (pvtKey != null) {
          oauthProperties.put(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME, pvtKey);
          LOG.fine("OAuthPvtKey provided.");
        } else if (pvtKeyPath != null) {
          oauthProperties.put(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME, pvtKeyPath);
          LOG.fine("OAuthPvtKeyPath provided.");
        } else {
          if (ds.getByoidAudienceUri() != null) {
            oauthProperties.put(
                BigQueryJdbcUrlUtility.BYOID_AUDIENCE_URI_PROPERTY_NAME, ds.getByoidAudienceUri());
          }
          if (ds.getByoidCredentialSource() != null) {
            oauthProperties.put(
                BigQueryJdbcUrlUtility.BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME,
                ds.getByoidCredentialSource());
          }
          if (ds.getByoidPoolUserProject() != null) {
            oauthProperties.put(
                BigQueryJdbcUrlUtility.BYOID_POOL_USER_PROJECT_PROPERTY_NAME,
                ds.getByoidPoolUserProject());
          }
          if (ds.getByoidSAImpersonationUri() != null) {
            oauthProperties.put(
                BigQueryJdbcUrlUtility.BYOID_SA_IMPERSONATION_URI_PROPERTY_NAME,
                ds.getByoidSAImpersonationUri());
          }
          if (ds.getByoidSubjectTokenType() != null) {
            oauthProperties.put(
                BigQueryJdbcUrlUtility.BYOID_SUBJECT_TOKEN_TYPE_PROPERTY_NAME,
                ds.getByoidSubjectTokenType());
          }
          if (ds.getByoidTokenUri() != null) {
            oauthProperties.put(
                BigQueryJdbcUrlUtility.BYOID_TOKEN_URI_PROPERTY_NAME, ds.getByoidTokenUri());
          }

          String universeDomain = ds.getUniverseDomain();
          if (universeDomain != null) {
            oauthProperties.put(
                BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME, universeDomain);
            LOG.fine(
                BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME
                    + " provided. Caller : "
                    + callerClassName);
          }
        }
        break;
    }

    oauthProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME,
        ds.getOAuthSAImpersonationEmail());
    oauthProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME,
        ds.getOAuthSAImpersonationChain());
    oauthProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME,
        ds.getOAuthSAImpersonationScopes() != null
            ? ds.getOAuthSAImpersonationScopes()
            : BIGQUERY_SCOPE);
    oauthProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME,
        ds.getOAuthSAImpersonationTokenLifetime() != null
            ? ds.getOAuthSAImpersonationTokenLifetime()
            : BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_VALUE);
    return oauthProperties;
  }

  /**
   * Gets the credentials for the given Auth properties.
   *
   * @param authProperties A map of Auth properties.
   * @return A GoogleCredentials object.
   */
  static GoogleCredentials getCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      Boolean reqGoogleDriveScopeBool,
      HttpTransportFactory httpTransportFactory,
      String callerClassName) {
    LOG.finer("++enter++\t" + callerClassName);

    AuthType authType =
        AuthType.valueOf(authProperties.get(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME));

    GoogleCredentials credentials;
    switch (authType) {
      case GOOGLE_SERVICE_ACCOUNT:
        credentials =
            getGoogleServiceAccountCredentials(
                authProperties, overrideProperties, httpTransportFactory, callerClassName);
        break;
      case GOOGLE_USER_ACCOUNT:
        credentials =
            getGoogleUserAccountCredentials(
                authProperties, overrideProperties, httpTransportFactory, callerClassName);
        break;
      case PRE_GENERATED_TOKEN:
        credentials =
            getPreGeneratedTokensCredentials(
                authProperties, overrideProperties, httpTransportFactory, callerClassName);
        break;
      case APPLICATION_DEFAULT_CREDENTIALS:
        credentials = getApplicationDefaultCredentials(httpTransportFactory, callerClassName);
        break;
      case EXTERNAL_ACCOUNT_AUTH:
        credentials =
            getExternalAccountAuthCredentials(
                authProperties, httpTransportFactory, callerClassName);
        break;
      default:
        IllegalStateException ex = new IllegalStateException(OAUTH_TYPE_ERROR_MESSAGE);
        LOG.severe(ex.getMessage(), ex);
        throw ex;
    }

    return getServiceAccountImpersonatedCredentials(
        credentials, reqGoogleDriveScopeBool, authProperties, httpTransportFactory);
  }

  static boolean isFileExists(String filename) {
    try {
      return filename != null && !filename.isEmpty() && Files.exists(Paths.get(filename));
    } catch (Exception e) {
      // Filename is invalid
      return false;
    }
  }

  static boolean isJson(byte[] value) {
    try {
      // This is done this way to ensure strict Json parsing
      // https://github.com/google/gson/issues/1208#issuecomment-2120764686
      InputStream stream = new ByteArrayInputStream(value);
      InputStreamReader reader = new InputStreamReader(stream);
      JsonReader jsonReader = new JsonReader(reader);
      jsonReader.setStrictness(Strictness.STRICT);
      JsonElement json = JsonParser.parseReader(jsonReader);
      return json != null;
    } catch (Exception e) {
      // Unable to parse json string
      return false;
    }
  }

  private static GoogleCredentials getGoogleServiceAccountCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      HttpTransportFactory httpTransportFactory,
      String callerClassName) {
    LOG.finer("++enter++\t" + callerClassName);

    ServiceAccountCredentials.Builder builder;
    try {
      final String pvtKeyPath =
          authProperties.get(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME);
      final String pvtKey = authProperties.get(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME);
      final String pvtEmail =
          authProperties.get(BigQueryJdbcUrlUtility.OAUTH_SA_EMAIL_PROPERTY_NAME);
      final String p12Password =
          authProperties.get(BigQueryJdbcUrlUtility.OAUTH_P12_PASSWORD_PROPERTY_NAME);

      final String keyPath = pvtKeyPath != null ? pvtKeyPath : pvtKey;
      PrivateKey key = null;
      byte[] keyBytes = pvtKey != null ? pvtKey.getBytes() : null;

      if (isFileExists(keyPath)) {
        try (InputStream stream = new FileInputStream(keyPath)) {
          int bufferSize = 1024 * 1024;
          byte[] buffer = new byte[bufferSize];
          stream.read(buffer, 0, bufferSize);
          keyBytes = buffer;
        }
      }

      InputStream stream = null;
      if (isJson(keyBytes)) {
        stream = new ByteArrayInputStream(keyBytes);
      } else if (pvtKey != null) {
        key = privateKeyFromPkcs8(pvtKey);
      } else if (keyBytes != null) {
        key = privateKeyFromP12Bytes(keyBytes, p12Password);
      }

      if (stream != null) {
        builder = ServiceAccountCredentials.fromStream(stream).toBuilder();
      } else if (pvtEmail != null && key != null) {
        builder =
            ServiceAccountCredentials.newBuilder().setClientEmail(pvtEmail).setPrivateKey(key);
      } else {
        throw new BigQueryJdbcRuntimeException("No valid credentials provided.");
      }

      if (httpTransportFactory != null) {
        builder.setHttpTransportFactory(httpTransportFactory);
      }

      if (overrideProperties.containsKey(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)) {
        builder.setTokenServerUri(
            new URI(overrideProperties.get(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)));
      }
      if (overrideProperties.containsKey(
          BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME)) {
        builder.setUniverseDomain(
            overrideProperties.get(BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
      }
    } catch (URISyntaxException | IOException e) {
      throw new BigQueryJdbcRuntimeException(
          "Validation failure for Service Account credentials.", e);
    }
    LOG.info("GoogleCredentials instantiated. Auth Method: Service Account.");
    return builder.build();
  }

  @FunctionalInterface
  interface BrowserOpener {
    void open(URI authorizationUri) throws IOException;
  }

  @FunctionalInterface
  interface ServerSocketSupplier {
    ServerSocket open() throws IOException;
  }

  @FunctionalInterface
  interface LoopbackSocketBinder {
    ServerSocket bind(InetAddress bindAddress, int backlog) throws IOException;
  }

  // DefaultPKCEProvider in google-auth-library-oauth2-http 1.58.0 emits a 172-character padded
  // code_verifier, outside RFC 7636 Section 4.1 (43..128 unreserved characters, unpadded).
  private static final class Rfc7636PkceProvider implements PKCEProvider {
    private static final String CHALLENGE_METHOD_S256 = "S256";
    private final String codeVerifier;
    private final String codeChallenge;

    private Rfc7636PkceProvider() {
      byte[] verifierBytes = new byte[OAUTH_RANDOM_TOKEN_BYTES];
      SECURE_RANDOM.nextBytes(verifierBytes);
      this.codeVerifier = Base64.getUrlEncoder().withoutPadding().encodeToString(verifierBytes);
      this.codeChallenge = computeS256Challenge(this.codeVerifier);
    }

    private static String computeS256Challenge(String verifier) {
      try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(verifier.getBytes(StandardCharsets.US_ASCII));
        return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
      } catch (NoSuchAlgorithmException e) {
        throw new IllegalStateException("SHA-256 MessageDigest not available", e);
      }
    }

    @Override
    public String getCodeVerifier() {
      return codeVerifier;
    }

    @Override
    public String getCodeChallenge() {
      return codeChallenge;
    }

    @Override
    public String getCodeChallengeMethod() {
      return CHALLENGE_METHOD_S256;
    }
  }

  private static final class HttpCallbackException extends Exception {
    private HttpCallbackException(String message) {
      super(message);
    }
  }

  static UserAuthorizer getUserAuthorizer(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      URI callbackUri,
      HttpTransportFactory httpTransportFactory,
      String callerClassName)
      throws URISyntaxException {
    LOG.finer("++enter++\t" + callerClassName);

    ClientId clientId =
        ClientId.of(
            authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME),
            authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME));
    UserAuthorizer.Builder userAuthorizerBuilder =
        UserAuthorizer.newBuilder()
            .setClientId(clientId)
            .setScopes(DEFAULT_BIGQUERY_SCOPES)
            .setCallbackUri(callbackUri)
            .setPKCEProvider(new Rfc7636PkceProvider());

    if (httpTransportFactory != null) {
      userAuthorizerBuilder.setHttpTransportFactory(httpTransportFactory);
    }

    if (overrideProperties.containsKey(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)) {
      userAuthorizerBuilder.setTokenServerUri(
          new URI(overrideProperties.get(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)));
    }

    return userAuthorizerBuilder.build();
  }

  static UserCredentials getCredentialsFromCode(
      UserAuthorizer userAuthorizer,
      String code,
      HttpTransportFactory httpTransportFactory,
      String callerClassName)
      throws IOException {
    LOG.finer("++enter++\t" + callerClassName);
    UserCredentials credentials = userAuthorizer.getCredentialsFromCode(code, URI.create(""));
    if (httpTransportFactory != null) {
      credentials = credentials.toBuilder().setHttpTransportFactory(httpTransportFactory).build();
    }
    return credentials;
  }

  private static GoogleCredentials getGoogleUserAccountCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      HttpTransportFactory httpTransportFactory,
      String callerClassName) {
    if (!isDesktopBrowseSupported()) {
      throw new BigQueryJdbcRuntimeException("User auth only supported in desktop environments");
    }
    return getGoogleUserAccountCredentials(
        authProperties,
        overrideProperties,
        httpTransportFactory,
        callerClassName,
        BigQueryJdbcOAuthUtility::openLoopbackServerSocket,
        uri -> Desktop.getDesktop().browse(uri),
        USER_AUTH_TIMEOUT_MS,
        USER_AUTH_SOCKET_READ_TIMEOUT_MS);
  }

  static GoogleCredentials getGoogleUserAccountCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      HttpTransportFactory httpTransportFactory,
      String callerClassName,
      ServerSocketSupplier serverSocketSupplier,
      BrowserOpener browserOpener,
      int authTimeoutMs,
      int socketReadTimeoutMs) {
    LOG.finer("++enter++\t" + callerClassName);
    try {
      UserAuthorizer userAuthorizer;
      String code;
      try (ServerSocket serverSocket = serverSocketSupplier.open()) {
        URI callbackUri =
            buildLoopbackCallbackUri(serverSocket.getInetAddress(), serverSocket.getLocalPort());
        userAuthorizer =
            getUserAuthorizer(
                authProperties,
                overrideProperties,
                callbackUri,
                httpTransportFactory,
                callerClassName);
        String expectedState = generateOAuthState();
        URL authUrl = userAuthorizer.getAuthorizationUrl("user", expectedState, URI.create(""));
        browserOpener.open(authUrl.toURI());
        code =
            waitForAuthorizationCode(
                serverSocket, expectedState, authTimeoutMs, socketReadTimeoutMs);
      }
      return getCredentialsFromCode(userAuthorizer, code, httpTransportFactory, callerClassName);
    } catch (IOException | URISyntaxException ex) {
      throw new BigQueryJdbcRuntimeException(
          "Failed to establish connection using User Account authentication", ex);
    } finally {
      LOG.finer("++exit++\t" + callerClassName);
    }
  }

  static boolean isDesktopBrowseSupported() {
    if (GraphicsEnvironment.isHeadless() || !Desktop.isDesktopSupported()) {
      return false;
    }
    return Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
  }

  static ServerSocket openLoopbackServerSocket() throws IOException {
    return openLoopbackServerSocket((address, backlog) -> new ServerSocket(0, backlog, address));
  }

  static ServerSocket openLoopbackServerSocket(LoopbackSocketBinder binder) throws IOException {
    InetAddress ipv4Loopback = InetAddress.getByAddress(new byte[] {127, 0, 0, 1});
    try {
      return binder.bind(ipv4Loopback, USER_AUTH_BACKLOG);
    } catch (IOException ipv4Unavailable) {
      InetAddress ipv6Loopback =
          InetAddress.getByAddress(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
      try {
        return binder.bind(ipv6Loopback, USER_AUTH_BACKLOG);
      } catch (IOException ipv6Unavailable) {
        ipv4Unavailable.addSuppressed(ipv6Unavailable);
        throw ipv4Unavailable;
      }
    }
  }

  static URI buildLoopbackCallbackUri(InetAddress bindAddress, int port) {
    if (bindAddress instanceof Inet6Address) {
      return URI.create("http://[::1]:" + port);
    }
    return URI.create("http://127.0.0.1:" + port);
  }

  private static String generateOAuthState() {
    byte[] stateBytes = new byte[OAUTH_RANDOM_TOKEN_BYTES];
    SECURE_RANDOM.nextBytes(stateBytes);
    return Base64.getUrlEncoder().withoutPadding().encodeToString(stateBytes);
  }

  private static boolean isValidOAuthState(String expectedState, String actualState) {
    if (actualState == null) {
      return false;
    }
    return MessageDigest.isEqual(
        expectedState.getBytes(StandardCharsets.UTF_8),
        actualState.getBytes(StandardCharsets.UTF_8));
  }

  private static String waitForAuthorizationCode(
      ServerSocket serverSocket, String expectedState, int authTimeoutMs, int socketReadTimeoutMs)
      throws IOException {
    long overallDeadlineNanos = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(authTimeoutMs);
    while (true) {
      int acceptTimeoutMs = remainingMillis(overallDeadlineNanos);
      if (acceptTimeoutMs <= 0) {
        throw new SocketTimeoutException("Timed out waiting for OAuth authorization callback.");
      }
      serverSocket.setSoTimeout(acceptTimeoutMs);
      Socket acceptedSocket;
      try {
        acceptedSocket = serverSocket.accept();
      } catch (SocketTimeoutException acceptTimedOut) {
        throw new SocketTimeoutException("Timed out waiting for OAuth authorization callback.");
      }
      try (Socket socket = acceptedSocket) {
        String code =
            handleCallbackConnection(
                socket, expectedState, overallDeadlineNanos, socketReadTimeoutMs);
        if (code != null) {
          return code;
        }
      }
    }
  }

  private static String handleCallbackConnection(
      Socket socket, String expectedState, long overallDeadlineNanos, int socketReadTimeoutMs)
      throws SocketTimeoutException {
    long readDeadlineNanos =
        Math.min(
            overallDeadlineNanos,
            System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(socketReadTimeoutMs));
    try {
      BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
      boolean headersDrained = false;
      try {
        String requestLine =
            readHttpRequestLine(
                socket, inputStream, readDeadlineNanos, MAX_HTTP_REQUEST_LINE_BYTES);
        if (requestLine == null) {
          return null;
        }
        URI requestUri = parseHttpGetRequestTarget(requestLine);
        drainHttpHeaders(socket, inputStream, readDeadlineNanos, MAX_HTTP_HEADER_BYTES);
        headersDrained = true;
        if (!"/".equals(requestUri.getPath())) {
          writeHttpResponseQuietly(socket, USER_AUTH_NOT_FOUND_HTTP_RESPONSE_BYTES);
          return null;
        }
        Map<String, String> queryParams = parseOAuthQueryParameters(requestUri.getRawQuery());
        String code = extractVerifiedAuthorizationCode(queryParams, expectedState);
        writeHttpResponseQuietly(socket, USER_AUTH_SUCCESS_HTTP_RESPONSE_BYTES);
        return code;
      } catch (HttpCallbackException callbackError) {
        if (!headersDrained) {
          long drainDeadlineNanos =
              Math.min(
                  overallDeadlineNanos,
                  System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(USER_AUTH_DRAIN_TIMEOUT_MS));
          drainHttpHeaders(socket, inputStream, drainDeadlineNanos, MAX_HTTP_HEADER_BYTES);
        }
        writeHttpResponseQuietly(socket, USER_AUTH_BAD_REQUEST_HTTP_RESPONSE_BYTES);
        throw new BigQueryJdbcRuntimeException(callbackError.getMessage());
      }
    } catch (IOException clientIoError) {
      if (remainingMillis(overallDeadlineNanos) <= 0) {
        throw new SocketTimeoutException("Timed out waiting for OAuth authorization callback.");
      }
      return null;
    }
  }

  private static int remainingMillis(long deadlineNanos) {
    long remainingNanos = deadlineNanos - System.nanoTime();
    if (remainingNanos <= 0L) {
      return 0;
    }
    long millis = TimeUnit.NANOSECONDS.toMillis(remainingNanos);
    if (millis == 0L) {
      return 1;
    }
    return (int) millis;
  }

  private static int readByteBeforeDeadline(
      Socket socket, BufferedInputStream inputStream, long deadlineNanos) throws IOException {
    if (inputStream.available() > 0) {
      return inputStream.read();
    }
    int remainingMs = remainingMillis(deadlineNanos);
    if (remainingMs <= 0) {
      throw new SocketTimeoutException("Timed out reading OAuth callback request.");
    }
    socket.setSoTimeout(remainingMs);
    return inputStream.read();
  }

  private static String readHttpRequestLine(
      Socket socket, BufferedInputStream inputStream, long deadlineNanos, int maxBytes)
      throws IOException, HttpCallbackException {
    int b = readByteBeforeDeadline(socket, inputStream, deadlineNanos);
    if (b == -1) {
      return null;
    }
    ByteArrayOutputStream buffer = new ByteArrayOutputStream(256);
    int totalRead = 0;
    while (true) {
      if (b == '\n') {
        break;
      }
      if (b == -1) {
        throw new HttpCallbackException("Incomplete OAuth callback HTTP request line.");
      }
      totalRead++;
      if (totalRead > maxBytes) {
        throw new HttpCallbackException(
            "OAuth callback HTTP request line exceeded maximum length.");
      }
      if (b == '\r') {
        int next = readByteBeforeDeadline(socket, inputStream, deadlineNanos);
        if (next != '\n') {
          throw new HttpCallbackException("Invalid bare CR in OAuth callback HTTP request line.");
        }
        break;
      }
      buffer.write(b);
      b = readByteBeforeDeadline(socket, inputStream, deadlineNanos);
    }
    return new String(buffer.toByteArray(), StandardCharsets.US_ASCII);
  }

  private static void drainHttpHeaders(
      Socket socket, BufferedInputStream inputStream, long deadlineNanos, int maxHeaderBytes) {
    int totalRead = 0;
    int lineChars = 0;
    try {
      while (totalRead < maxHeaderBytes) {
        int b = readByteBeforeDeadline(socket, inputStream, deadlineNanos);
        if (b == -1) {
          return;
        }
        totalRead++;
        if (b == '\n') {
          if (lineChars == 0) {
            return;
          }
          lineChars = 0;
        } else if (b != '\r') {
          lineChars++;
        }
      }
    } catch (IOException ignored) {
      // Best-effort drain so closing the socket after writing the HTTP response avoids TCP RST.
    }
  }

  private static URI parseHttpGetRequestTarget(String requestLine) throws HttpCallbackException {
    String[] parts = requestLine.split(" ", -1);
    if (parts.length != 3
        || !"GET".equals(parts[0])
        || !parts[1].startsWith("/")
        || (!"HTTP/1.1".equals(parts[2]) && !"HTTP/1.0".equals(parts[2]))) {
      throw new HttpCallbackException("Invalid HTTP request line on OAuth callback.");
    }
    URI requestUri;
    try {
      requestUri = new URI(parts[1]);
    } catch (URISyntaxException e) {
      throw new HttpCallbackException("Malformed URI in OAuth callback request.");
    }
    if (requestUri.getRawAuthority() != null || requestUri.getRawFragment() != null) {
      throw new HttpCallbackException("Unexpected URI format in OAuth callback request.");
    }
    return requestUri;
  }

  private static Map<String, String> parseOAuthQueryParameters(String rawQuery)
      throws HttpCallbackException {
    if (rawQuery == null || rawQuery.isEmpty()) {
      return Collections.emptyMap();
    }
    Map<String, String> params = new HashMap<>();
    String[] pairs = rawQuery.split("&");
    for (String pair : pairs) {
      if (pair.isEmpty()) {
        continue;
      }
      int eqIndex = pair.indexOf('=');
      String rawKey = eqIndex >= 0 ? pair.substring(0, eqIndex) : pair;
      String rawValue = eqIndex >= 0 ? pair.substring(eqIndex + 1) : "";
      String key = urlDecodeUtf8(rawKey);
      String value = urlDecodeUtf8(rawValue);
      if (("code".equals(key) || "state".equals(key) || "error".equals(key))
          && params.containsKey(key)) {
        throw new HttpCallbackException("Duplicate OAuth callback parameter: " + key);
      }
      params.put(key, value);
    }
    return params;
  }

  private static String urlDecodeUtf8(String value) {
    try {
      return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("UTF-8 encoding not supported", e);
    }
  }

  private static String extractVerifiedAuthorizationCode(
      Map<String, String> queryParams, String expectedState) throws HttpCallbackException {
    if (!isValidOAuthState(expectedState, queryParams.get("state"))) {
      throw new HttpCallbackException("Missing or invalid state parameter in OAuth callback.");
    }
    String error = queryParams.get("error");
    if (error != null) {
      throw new HttpCallbackException(
          "OAuth authorization failed: " + sanitizeOAuthErrorCode(error));
    }
    String code = queryParams.get("code");
    if (code == null || code.isEmpty()) {
      throw new HttpCallbackException(
          "Could not retrieve the authorization code from OAuth callback.");
    }
    return code;
  }

  private static String sanitizeOAuthErrorCode(String error) {
    if (error.isEmpty()) {
      return "unknown_error";
    }
    int limit = Math.min(error.length(), MAX_OAUTH_ERROR_LENGTH);
    StringBuilder sb = new StringBuilder(limit);
    for (int i = 0; i < limit; i++) {
      char c = error.charAt(i);
      if (c >= 0x21 && c <= 0x7E && c != '"' && c != '\'') {
        sb.append(c);
      } else {
        sb.append('_');
      }
    }
    return sb.toString();
  }

  private static byte[] buildHttpResponseBytes(
      int statusCode, String reasonPhrase, String htmlBody) {
    byte[] bodyBytes = htmlBody.getBytes(StandardCharsets.UTF_8);
    String headers =
        "HTTP/1.1 "
            + statusCode
            + " "
            + reasonPhrase
            + "\r\n"
            + "Content-Type: text/html; charset=utf-8\r\n"
            + "Content-Length: "
            + bodyBytes.length
            + "\r\n"
            + "Cache-Control: no-store\r\n"
            + "Connection: close\r\n"
            + "\r\n";
    byte[] headerBytes = headers.getBytes(StandardCharsets.US_ASCII);
    byte[] response = new byte[headerBytes.length + bodyBytes.length];
    System.arraycopy(headerBytes, 0, response, 0, headerBytes.length);
    System.arraycopy(bodyBytes, 0, response, headerBytes.length, bodyBytes.length);
    return response;
  }

  private static void writeHttpResponseQuietly(Socket socket, byte[] responseBytes) {
    try {
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(responseBytes);
      outputStream.flush();
    } catch (IOException ignored) {
      // Peer may have already closed its side of the connection.
    }
  }

  private static GoogleCredentials getPreGeneratedAccessTokenCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      String callerClassName) {
    LOG.finer("++enter++\t" + callerClassName);
    GoogleCredentials.Builder builder = GoogleCredentials.newBuilder();
    if (overrideProperties.containsKey(
        BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME)) {
      builder.setUniverseDomain(
          overrideProperties.get(BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
    }

    LOG.info("Connection established. Auth Method: Pre-generated Access Token.");
    GoogleCredentials credentials =
        builder
            .setAccessToken(
                AccessToken.newBuilder()
                    .setTokenValue(
                        authProperties.get(BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_PROPERTY_NAME))
                    .build())
            .build();

    return credentials;
  }

  static GoogleCredentials getPreGeneratedTokensCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      HttpTransportFactory httpTransportFactory,
      String callerClassName) {
    LOG.finer("++enter++\t" + callerClassName);
    if (authProperties.containsKey(BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME)) {
      try {
        return getPreGeneratedRefreshTokenCredentials(
            authProperties, overrideProperties, httpTransportFactory, callerClassName);
      } catch (URISyntaxException ex) {
        throw new BigQueryJdbcRuntimeException(
            "URISyntaxException during getPreGeneratedTokensCredentials", ex);
      }
    } else {
      return getPreGeneratedAccessTokenCredentials(
          authProperties, overrideProperties, callerClassName);
    }
  }

  static UserCredentials getPreGeneratedRefreshTokenCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      HttpTransportFactory httpTransportFactory,
      String callerClassName)
      throws URISyntaxException {
    LOG.finer("++enter++\t" + callerClassName);

    UserCredentials.Builder userCredentialsBuilder =
        UserCredentials.newBuilder()
            .setRefreshToken(
                authProperties.get(BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME))
            .setClientId(authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME))
            .setClientSecret(
                authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME));

    if (httpTransportFactory != null) {
      userCredentialsBuilder.setHttpTransportFactory(httpTransportFactory);
    }

    if (overrideProperties.containsKey(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)) {
      userCredentialsBuilder.setTokenServerUri(
          new URI(overrideProperties.get(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)));
    }
    if (overrideProperties.containsKey(
        BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME)) {
      userCredentialsBuilder.setUniverseDomain(
          overrideProperties.get(BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
    }

    LOG.info("Connection established. Auth Method: Pre-generated Refresh Token.");
    return userCredentialsBuilder.build();
  }

  private static GoogleCredentials getApplicationDefaultCredentials(
      HttpTransportFactory httpTransportFactory, String callerClassName) {
    LOG.finer("++enter++\t" + callerClassName);
    try {
      GoogleCredentials credentials =
          httpTransportFactory != null
              ? GoogleCredentials.getApplicationDefault(httpTransportFactory)
              : GoogleCredentials.getApplicationDefault();
      String principal = "unknown";
      if (credentials instanceof ServiceAccountCredentials) {
        principal = ((ServiceAccountCredentials) credentials).getClientEmail();
      } else if (credentials instanceof UserCredentials) {
        principal = "user credentials";
      } else if (credentials instanceof ExternalAccountCredentials) {
        principal = "external account";
      }
      LOG.info(
          "Connection established. Auth Method: Application Default Credentials, Principal: %s.",
          principal);

      return credentials;
    } catch (IOException exception) {
      throw new BigQueryJdbcRuntimeException(
          "Application default credentials not found.", exception);
    }
  }

  private static GoogleCredentials getExternalAccountAuthCredentials(
      Map<String, String> authProperties,
      HttpTransportFactory httpTransportFactory,
      String callerClassName) {
    LOG.finer("++enter++\t" + callerClassName);
    try {
      JsonObject jsonObject = null;
      String credentialsPath = null;
      if (authProperties.containsKey(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME)) {
        String pvtKeyPath =
            authProperties.get(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME).trim();
        if (pvtKeyPath.startsWith("{")) {
          jsonObject = JsonParser.parseString(pvtKeyPath).getAsJsonObject();
        } else {
          credentialsPath = pvtKeyPath;
        }
      } else if (authProperties.containsKey(
          BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME)) {
        credentialsPath =
            authProperties.get(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME);
      } else {
        jsonObject = new JsonObject();
        for (String property : BigQueryJdbcUrlUtility.BYOID_PROPERTIES) {
          if (Objects.equals(
              property, BigQueryJdbcUrlUtility.BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME)) {
            jsonObject.add(
                BYOID_NAME_MAP.get(property),
                JsonParser.parseString(authProperties.get(property)).getAsJsonObject());
          } else if (authProperties.containsKey(property)) {
            jsonObject.addProperty(BYOID_NAME_MAP.get(property), authProperties.get(property));
          }
        }
        if (authProperties.containsKey(
            BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME)) {
          jsonObject.addProperty(
              "universe_domain",
              authProperties.get(BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
        }
      }

      ExternalAccountCredentials credentials;
      if (credentialsPath != null) {
        try (InputStream stream = Files.newInputStream(Paths.get(credentialsPath))) {
          credentials =
              httpTransportFactory != null
                  ? ExternalAccountCredentials.fromStream(stream, httpTransportFactory)
                  : ExternalAccountCredentials.fromStream(stream);
        }
      } else if (jsonObject != null) {
        InputStream stream =
            new ByteArrayInputStream(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        credentials =
            httpTransportFactory != null
                ? ExternalAccountCredentials.fromStream(stream, httpTransportFactory)
                : ExternalAccountCredentials.fromStream(stream);
      } else {
        IllegalArgumentException ex =
            new IllegalArgumentException("Insufficient info provided for external authentication");
        LOG.severe(ex.getMessage(), ex);
        throw ex;
      }
      return credentials;
    } catch (IOException e) {
      throw new BigQueryJdbcRuntimeException(
          "IOException during getExternalAccountAuthCredentials", e);
    }
  }

  // This function checks if connection string contains configuration for
  // credentials impersonation. If not, it returns regular credentials object.
  // If impersonated service account is provided, returns Credentials object
  // accommodating this information.
  private static GoogleCredentials getServiceAccountImpersonatedCredentials(
      GoogleCredentials credentials,
      Boolean reqGoogleDriveScopeBool,
      Map<String, String> authProperties,
      HttpTransportFactory httpTransportFactory) {

    String impersonationEmail =
        authProperties.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME);
    if (impersonationEmail == null || impersonationEmail.isEmpty()) {
      if (reqGoogleDriveScopeBool) {
        credentials = credentials.createScoped(BIGQUERY_WITH_DRIVE_SCOPES);
        LOG.fine("Added Google Drive read-only scope to GoogleCredentials.");
      }
      return credentials;
    }

    String impersonationChainString =
        authProperties.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME);
    List<String> impersonationChain = null;
    if (impersonationChainString != null && !impersonationChainString.isEmpty()) {
      impersonationChain = Arrays.asList(impersonationChainString.split(","));
    }

    // Scopes has a default value, so it should never be null
    List<String> impersonationScopes =
        new java.util.ArrayList<>(
            Arrays.asList(
                authProperties
                    .get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME)
                    .split(",")));

    if (reqGoogleDriveScopeBool) {
      if (!impersonationScopes.contains(DRIVE_READONLY_SCOPE)) {
        impersonationScopes.add(DRIVE_READONLY_SCOPE);
        LOG.fine("Added Google Drive read-only scope to impersonation scopes.");
      }
    }

    // Token lifetime has a default value, so it should never be null
    String impersonationLifetime =
        authProperties.get(
            BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME);
    int impersonationLifetimeInt = 0;
    try {
      impersonationLifetimeInt = Integer.parseInt(impersonationLifetime);
    } catch (NumberFormatException e) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              "Invalid value for ServiceAccountImpersonationTokenLifetime: must be a positive integer.",
              e);
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }

    if (httpTransportFactory != null) {
      return ImpersonatedCredentials.create(
          credentials,
          impersonationEmail,
          impersonationChain,
          impersonationScopes,
          impersonationLifetimeInt,
          httpTransportFactory);
    }
    return ImpersonatedCredentials.create(
        credentials,
        impersonationEmail,
        impersonationChain,
        impersonationScopes,
        impersonationLifetimeInt);
  }

  static PrivateKey privateKeyFromP12Bytes(byte[] privateKey, String password) {
    try {
      InputStream stream = new ByteArrayInputStream(privateKey);
      return SecurityUtils.loadPrivateKeyFromKeyStore(
          SecurityUtils.getPkcs12KeyStore(), stream, "notasecret", "privatekey", password);
    } catch (IOException | GeneralSecurityException e) {
      LOG.warning("Unable to parse p12 file: " + e.getMessage());
      return null;
    }
  }

  static PrivateKey privateKeyFromPkcs8(String privateKeyPkcs8) {
    try {
      Reader reader = new StringReader(privateKeyPkcs8);
      PemReader.Section section = readFirstSectionAndClose(reader, "PRIVATE KEY");
      if (section == null) {
        IOException ex = new IOException("Invalid PKCS#8 data.");
        LOG.severe(ex.getMessage(), ex);
        throw ex;
      }
      byte[] bytes = section.getBase64DecodedBytes();
      PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
      KeyFactory keyFactory = SecurityUtils.getRsaKeyFactory();
      return keyFactory.generatePrivate(keySpec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
      LOG.warning("Unable to parse pkcs8 secret: " + e.getMessage());
      return null;
    }
  }

  enum AuthType {
    GOOGLE_SERVICE_ACCOUNT(0),
    GOOGLE_USER_ACCOUNT(1),
    PRE_GENERATED_TOKEN(2),
    APPLICATION_DEFAULT_CREDENTIALS(3),
    EXTERNAL_ACCOUNT_AUTH(4);

    private final int value;

    AuthType(int value) {
      this.value = value;
    }

    static AuthType fromValue(int value) {
      for (AuthType authType : values()) {
        if (authType.value == value) {
          return authType;
        }
      }
      IllegalStateException ex = new IllegalStateException(OAUTH_TYPE_ERROR_MESSAGE + ": " + value);
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
  }
}
