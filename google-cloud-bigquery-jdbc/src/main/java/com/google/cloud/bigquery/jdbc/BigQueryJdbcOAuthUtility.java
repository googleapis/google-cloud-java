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
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.ClientId;
import com.google.auth.oauth2.ExternalAccountCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;
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
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class BigQueryJdbcOAuthUtility {

  private static final String USER_AUTH_SUCCESS_HTTP_RESPONSE =
      "HTTP/1.1 200 OK\n"
          + "Content-Length: 300\n"
          + "Connection: close\n"
          + "Content-Type: text/html; charset=utf-8\n"
          + "\n"
          + "<!DOCTYPE html><html><body>\n"
          + "Thank you for using JDBC Driver for Google BigQuery!\n"
          + "You may now close the window.</body></html>";

  private static final int USER_AUTH_TIMEOUT_MS = 120000;
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
  static Map<String, String> parseOAuthProperties(String url, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    Map<String, String> oauthProperties = new HashMap<>();

    AuthType authType;
    try {
      authType =
          AuthType.fromValue(
              BigQueryJdbcUrlUtility.parseIntProperty(
                  url,
                  BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME,
                  BigQueryJdbcUrlUtility.DEFAULT_OAUTH_TYPE_VALUE,
                  callerClassName));
    } catch (NumberFormatException exception) {
      throw new IllegalArgumentException(OAUTH_TYPE_ERROR_MESSAGE);
    }
    oauthProperties.put(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME, String.valueOf(authType));
    switch (authType) {
      case GOOGLE_SERVICE_ACCOUNT:
        // For using a Google Service Account (OAuth Type 0)
        // need: project id, OAuthServiceAcctEmail and OAuthPvtKey or OAuthPvtKeyPath that can be
        // .p12 or json.
        // TODO: validation if .p12 or json file can be in getPropertyInfo can be handy for user
        String serviceAccountEmail =
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_SA_EMAIL_PROPERTY_NAME);
        String serviceAccountPK =
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME);
        String serviceAccountPrivateKeyPath =
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME);
        String p12Password =
            BigQueryJdbcUrlUtility.parseStringProperty(
                url,
                BigQueryJdbcUrlUtility.OAUTH_P12_PASSWORD_PROPERTY_NAME,
                BigQueryJdbcUrlUtility.DEFAULT_OAUTH_P12_PASSWORD_VALUE,
                callerClassName);

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
            BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME,
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME));
        oauthProperties.put(
            BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME,
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME));
        int reqGoogleDriveScope =
            BigQueryJdbcUrlUtility.parseIntProperty(
                url,
                BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME,
                BigQueryJdbcUrlUtility.DEFAULT_REQUEST_GOOGLE_DRIVE_SCOPE_VALUE,
                callerClassName);
        oauthProperties.put(
            BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME,
            String.valueOf(reqGoogleDriveScope));
        LOG.fine("RequestGoogleDriveScope parsed.");
        break;
      case PRE_GENERATED_TOKEN:
        String refreshToken =
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME);
        if (refreshToken != null) {
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME, refreshToken);
          LOG.fine("OAuthRefreshToken provided.");
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.parseUriProperty(
                  url, BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME));
          LOG.fine("OAuthClientId provided.");
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.parseUriProperty(
                  url, BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME));
          LOG.fine("OAuthClientSecret provided.");
          break;
        }
        oauthProperties.put(
            BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_PROPERTY_NAME,
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_PROPERTY_NAME));
        LOG.fine("OAuthAccessToken provided.");
        break;
      case APPLICATION_DEFAULT_CREDENTIALS:
        // For Application Default Credentials (OAuth Type 3)
        // need: project id
        break;
      case EXTERNAL_ACCOUNT_AUTH:
        // For External account authentication (OAuth Type 4)
        // need: project id, OAuthPvtKey or OAuthPvtKeyPath or BYOID_PROPERTIES
        String pvtKey =
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME);
        String pvtKeyPath =
            BigQueryJdbcUrlUtility.parseUriProperty(
                url, BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME);
        if (pvtKey != null) {
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.parseUriProperty(
                  url, BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME));
          LOG.fine("OAuthPvtKey provided.");
        } else if (pvtKeyPath != null) {
          oauthProperties.put(
              BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.parseUriProperty(
                  url, BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME));
          LOG.fine("OAuthPvtKeyPath provided.");
        } else {
          for (String property : BigQueryJdbcUrlUtility.BYOID_PROPERTIES) {
            String value =
                BigQueryJdbcUrlUtility.parseBYOIDProperty(url, property, callerClassName);
            if (value != null) {
              oauthProperties.put(property, value);
              LOG.fine(property + " provided.");
            }
          }
          String universeDomainProp = BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME;
          String universeDomain = BigQueryJdbcUrlUtility.parseUriProperty(url, universeDomainProp);
          if (universeDomain != null) {
            oauthProperties.put(universeDomainProp, universeDomain);
            LOG.fine(universeDomainProp + " provided. Caller : " + callerClassName);
          }
        }
        break;
    }

    if (authType == AuthType.GOOGLE_SERVICE_ACCOUNT
        || authType == AuthType.GOOGLE_USER_ACCOUNT
        || authType == AuthType.PRE_GENERATED_TOKEN) {
      oauthProperties.put(
          BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME,
          BigQueryJdbcUrlUtility.parseStringProperty(
              url,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_EMAIL_VALUE,
              callerClassName));
      oauthProperties.put(
          BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME,
          BigQueryJdbcUrlUtility.parseStringProperty(
              url,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_CHAIN_VALUE,
              callerClassName));
      oauthProperties.put(
          BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME,
          BigQueryJdbcUrlUtility.parseStringProperty(
              url,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_SCOPES_VALUE,
              callerClassName));
      oauthProperties.put(
          BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME,
          BigQueryJdbcUrlUtility.parseStringProperty(
              url,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_VALUE,
              callerClassName));
    }
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
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);

    AuthType authType =
        AuthType.valueOf(authProperties.get(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME));

    GoogleCredentials credentials;
    switch (authType) {
      case GOOGLE_SERVICE_ACCOUNT:
        credentials =
            getGoogleServiceAccountCredentials(authProperties, overrideProperties, callerClassName);
        break;
      case GOOGLE_USER_ACCOUNT:
        credentials =
            getGoogleUserAccountCredentials(authProperties, overrideProperties, callerClassName);
        break;
      case PRE_GENERATED_TOKEN:
        credentials =
            getPreGeneratedTokensCredentials(authProperties, overrideProperties, callerClassName);
        break;
      case APPLICATION_DEFAULT_CREDENTIALS:
        // This auth method doesn't support service account impersonation
        return getApplicationDefaultCredentials(callerClassName);
      case EXTERNAL_ACCOUNT_AUTH:
        // This auth method doesn't support service account impersonation
        return getExternalAccountAuthCredentials(authProperties, callerClassName);
      default:
        throw new IllegalStateException(OAUTH_TYPE_ERROR_MESSAGE);
    }

    return getServiceAccountImpersonatedCredentials(credentials, authProperties);
  }

  private static boolean isFileExists(String filename) {
    try {
      return filename != null && !filename.isEmpty() && Files.exists(Paths.get(filename));
    } catch (Exception e) {
      // Filename is invalid
      return false;
    }
  }

  private static boolean isJson(String value) {
    try {
      // This is done this way to ensure strict Json parsing
      // https://github.com/google/gson/issues/1208#issuecomment-2120764686
      InputStream stream = new ByteArrayInputStream(value.getBytes());
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
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);

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
      InputStream stream = null;

      if (isFileExists(keyPath)) {
        key = privateKeyFromP12File(keyPath, p12Password);
        if (key == null) {
          stream = Files.newInputStream(Paths.get(keyPath));
        }
      } else if (isJson(pvtKey)) {
        stream = new ByteArrayInputStream(pvtKey.getBytes());
      } else if (pvtKey != null) {
        key = privateKeyFromPkcs8(pvtKey);
      }

      if (stream != null) {
        builder = ServiceAccountCredentials.fromStream(stream).toBuilder();
      } else if (pvtEmail != null && key != null) {
        builder =
            ServiceAccountCredentials.newBuilder().setClientEmail(pvtEmail).setPrivateKey(key);
      } else {
        LOG.severe("No valid Service Account credentials provided.");
        throw new BigQueryJdbcRuntimeException("No valid credentials provided.");
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
      LOG.severe("Validation failure for Service Account credentials.");
      throw new BigQueryJdbcRuntimeException(e);
    }
    LOG.info("GoogleCredentials instantiated. Auth Method: Service Account.");
    return builder.build();
  }

  static UserAuthorizer getUserAuthorizer(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      int port,
      String callerClassName)
      throws URISyntaxException {
    LOG.finest("++enter++\t" + callerClassName);
    List<String> scopes = new ArrayList<>();
    scopes.add("https://www.googleapis.com/auth/bigquery");

    // Add Google Drive scope conditionally
    if (authProperties.containsKey(
        BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME)) {
      try {
        int driveScopeValue =
            Integer.parseInt(
                authProperties.get(
                    BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME));
        if (driveScopeValue == 1) {
          scopes.add("https://www.googleapis.com/auth/drive.readonly");
          LOG.fine("Added Google Drive read-only scope. Caller: " + callerClassName);
        }
      } catch (NumberFormatException e) {
        LOG.severe(
            "Invalid value for RequestGoogleDriveScope, defaulting to not request Drive scope. Caller: "
                + callerClassName);
      }
    }

    List<String> responseTypes = new ArrayList<>();
    responseTypes.add("code");

    ClientId clientId =
        ClientId.of(
            authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME),
            authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME));
    UserAuthorizer.Builder userAuthorizerBuilder =
        UserAuthorizer.newBuilder()
            .setClientId(clientId)
            .setScopes(scopes)
            .setCallbackUri(URI.create("http://localhost:" + port));

    if (overrideProperties.containsKey(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)) {
      userAuthorizerBuilder.setTokenServerUri(
          new URI(overrideProperties.get(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME)));
    }

    return userAuthorizerBuilder.build();
  }

  static UserCredentials getCredentialsFromCode(
      UserAuthorizer userAuthorizer, String code, String callerClassName) throws IOException {
    LOG.finest("++enter++\t" + callerClassName);
    return userAuthorizer.getCredentialsFromCode(code, URI.create(""));
  }

  private static GoogleCredentials getGoogleUserAccountCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    try {
      ServerSocket serverSocket = new ServerSocket(0);
      serverSocket.setSoTimeout(USER_AUTH_TIMEOUT_MS);
      int port = serverSocket.getLocalPort();
      UserAuthorizer userAuthorizer =
          getUserAuthorizer(authProperties, overrideProperties, port, callerClassName);

      URL authURL = userAuthorizer.getAuthorizationUrl("user", "", URI.create(""));
      String code;

      if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().browse(authURL.toURI());

        Socket socket = serverSocket.accept();

        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = bufferedReader.readLine();

        Pattern p = Pattern.compile("(?<=code=).*?(?=&|$)");
        Matcher m = p.matcher(response);

        if (!m.find()) {
          throw new BigQueryJdbcRuntimeException("Could not retrieve the code for user auth");
        }
        code = m.group();

        printWriter.println(USER_AUTH_SUCCESS_HTTP_RESPONSE);
        printWriter.flush();
        socket.close();
        serverSocket.close();
      } else {
        throw new BigQueryJdbcRuntimeException("User auth only supported in desktop environments");
      }

      return getCredentialsFromCode(userAuthorizer, code, callerClassName);
    } catch (IOException | URISyntaxException ex) {
      LOG.severe(
          String.format(
              "Failed to establish connection using User Account authentication: %s",
              ex.getMessage()));
      throw new BigQueryJdbcRuntimeException(ex);
    }
  }

  private static GoogleCredentials getPreGeneratedAccessTokenCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    GoogleCredentials.Builder builder = GoogleCredentials.newBuilder();
    if (overrideProperties.containsKey(
        BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME)) {
      builder.setUniverseDomain(
          overrideProperties.get(BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
    }
    LOG.info("Connection established. Auth Method: Pre-generated Access Token.");
    return builder
        .setAccessToken(
            AccessToken.newBuilder()
                .setTokenValue(
                    authProperties.get(BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_PROPERTY_NAME))
                .build())
        .build();
  }

  static GoogleCredentials getPreGeneratedTokensCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    if (authProperties.containsKey(BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME)) {
      try {
        return getPreGeneratedRefreshTokenCredentials(
            authProperties, overrideProperties, callerClassName);
      } catch (URISyntaxException ex) {
        throw new BigQueryJdbcRuntimeException(ex);
      }
    } else {
      return getPreGeneratedAccessTokenCredentials(
          authProperties, overrideProperties, callerClassName);
    }
  }

  static UserCredentials getPreGeneratedRefreshTokenCredentials(
      Map<String, String> authProperties,
      Map<String, String> overrideProperties,
      String callerClassName)
      throws URISyntaxException {
    LOG.finest("++enter++\t" + callerClassName);

    UserCredentials.Builder userCredentialsBuilder =
        UserCredentials.newBuilder()
            .setRefreshToken(
                authProperties.get(BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME))
            .setClientId(authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME))
            .setClientSecret(
                authProperties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME));

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

  private static GoogleCredentials getApplicationDefaultCredentials(String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    try {
      GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
      String principal = "unknown";
      if (credentials instanceof ServiceAccountCredentials) {
        principal = ((ServiceAccountCredentials) credentials).getClientEmail();
      } else if (credentials instanceof UserCredentials) {
        principal = "user credentials";
      } else if (credentials instanceof ExternalAccountCredentials) {
        principal = "external account";
      }
      LOG.info(
          String.format(
              "Connection established. Auth Method: Application Default Credentials, Principal: %s.",
              principal));
      return credentials;
    } catch (IOException exception) {
      // TODO throw exception
      throw new BigQueryJdbcRuntimeException("Application default credentials not found.");
    }
  }

  private static GoogleCredentials getExternalAccountAuthCredentials(
      Map<String, String> authProperties, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
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

      if (credentialsPath != null) {
        return ExternalAccountCredentials.fromStream(
            Files.newInputStream(Paths.get(credentialsPath)));
      } else if (jsonObject != null) {
        return ExternalAccountCredentials.fromStream(
            new ByteArrayInputStream(jsonObject.toString().getBytes()));
      } else {
        throw new IllegalArgumentException(
            "Insufficient info provided for external authentication");
      }
    } catch (IOException e) {
      throw new BigQueryJdbcRuntimeException(e);
    }
  }

  // This function checks if connection string contains configuration for
  // credentials impersonation. If not, it returns regular credentials object.
  // If impersonated service account is provided, returns Credentials object
  // accomodating this information.
  private static GoogleCredentials getServiceAccountImpersonatedCredentials(
      GoogleCredentials credentials, Map<String, String> authProperties) {

    String impersonationEmail =
        authProperties.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME);
    if (impersonationEmail == null || impersonationEmail.isEmpty()) {
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
        Arrays.asList(
            authProperties
                .get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME)
                .split(","));

    // Token lifetime has a default value, so it should never be null
    String impersonationLifetime =
        authProperties.get(
            BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME);
    int impersonationLifetimeInt = 0;
    try {
      impersonationLifetimeInt = Integer.parseInt(impersonationLifetime);
    } catch (NumberFormatException e) {
      LOG.severe("Invalid value for ServiceAccountImpersonationTokenLifetime.");
      throw new IllegalArgumentException(
          "Invalid value for ServiceAccountImpersonationTokenLifetime: must be a positive integer.",
          e);
    }

    return ImpersonatedCredentials.create(
        credentials,
        impersonationEmail,
        impersonationChain,
        impersonationScopes,
        impersonationLifetimeInt);
  }

  static PrivateKey privateKeyFromP12File(String privateKeyFile, String password) {
    try {
      InputStream stream = Files.newInputStream(Paths.get(privateKeyFile));
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
        throw new IOException("Invalid PKCS#8 data.");
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
      throw new IllegalStateException(OAUTH_TYPE_ERROR_MESSAGE + ": " + value);
    }
  }
}
