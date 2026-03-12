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

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.PemReader.Section;
import com.google.api.client.util.SecurityUtils;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.Strings;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Internal utilities for the com.google.auth.oauth2 namespace.
 *
 * <p>These classes are marked public but should be treated effectively as internal classes only.
 * They are not subject to any backwards compatibility guarantees and might change or be removed at
 * any time. They are provided only as a convenience for other libraries within the {@code
 * com.google.auth} family. Application developers should avoid using these classes directly; they
 * are not part of the public API.
 */
public class OAuth2Utils {

  static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

  public static final String TOKEN_TYPE_ACCESS_TOKEN =
      "urn:ietf:params:oauth:token-type:access_token";
  static final String TOKEN_TYPE_TOKEN_EXCHANGE = "urn:ietf:params:oauth:token-type:token-exchange";
  public static final String TOKEN_TYPE_ACCESS_BOUNDARY_INTERMEDIARY_TOKEN =
      "urn:ietf:params:oauth:token-type:access_boundary_intermediary_token";
  static final String GRANT_TYPE_JWT_BEARER = "urn:ietf:params:oauth:grant-type:jwt-bearer";

  public static final String TOKEN_EXCHANGE_URL_FORMAT = "https://sts.%s/v1/token";
  static final URI TOKEN_SERVER_URI = URI.create("https://oauth2.googleapis.com/token");

  static final URI TOKEN_REVOKE_URI = URI.create("https://oauth2.googleapis.com/revoke");
  static final URI USER_AUTH_URI = URI.create("https://accounts.google.com/o/oauth2/auth");

  public static final String CLOUD_PLATFORM_SCOPE =
      "https://www.googleapis.com/auth/cloud-platform";

  static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

  public static final HttpTransportFactory HTTP_TRANSPORT_FACTORY =
      new DefaultHttpTransportFactory();

  static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

  private static String VALUE_NOT_FOUND_MESSAGE = "%sExpected value %s not found.";
  private static String VALUE_WRONG_TYPE_MESSAGE = "%sExpected %s value %s of wrong type.";

  static final String BEARER_PREFIX = AuthHttpConstants.BEARER + " ";

  static final String TOKEN_RESPONSE_SCOPE = "scope";

  static final int INITIAL_RETRY_INTERVAL_MILLIS = 1000;
  static final double RETRY_RANDOMIZATION_FACTOR = 0.1;
  static final double RETRY_MULTIPLIER = 2;
  static final int DEFAULT_NUMBER_OF_RETRIES = 3;

  // Includes expected server errors from Google token endpoint
  // Other 5xx codes are either not used or retries are unlikely to succeed
  public static final Set<Integer> TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES =
      new HashSet<>(Arrays.asList(500, 503, 408, 429));

  static class DefaultHttpTransportFactory implements HttpTransportFactory {

    @Override
    public HttpTransport create() {
      return HTTP_TRANSPORT;
    }
  }

  /**
   * Returns whether the headers contain the specified value as one of the entries in the specified
   * header.
   */
  static boolean headersContainValue(HttpHeaders headers, String headerName, String value) {
    Object values = headers.get(headerName);
    if (values instanceof Collection) {
      @SuppressWarnings("unchecked")
      Collection<Object> valuesCollection = (Collection<Object>) values;
      return valuesCollection.contains(value);
    }
    return false;
  }

  /** Parses the specified JSON text. */
  static GenericJson parseJson(String json) throws IOException {
    JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
    InputStream stateStream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
    GenericJson stateJson =
        parser.parseAndClose(stateStream, StandardCharsets.UTF_8, GenericJson.class);
    return stateJson;
  }

  /** Return the specified string from JSON or throw a helpful error message. */
  static String validateString(Map<String, Object> map, String key, String errorPrefix)
      throws IOException {
    Object value = map.get(key);
    if (value == null) {
      throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, errorPrefix, key));
    }
    if (!(value instanceof String)) {
      throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, errorPrefix, "string", key));
    }
    return (String) value;
  }

  /**
   * Saves the end user credentials into the given file path.
   *
   * @param credentials InputStream containing user credentials in JSON format
   * @param filePath Path to file where to store the credentials
   * @throws IOException An error saving the credentials.
   */
  static void writeInputStreamToFile(InputStream credentials, String filePath) throws IOException {
    final OutputStream outputStream = new FileOutputStream(new File(filePath));
    try {
      ByteStreams.copy(credentials, outputStream);
    } finally {
      outputStream.close();
    }
  }

  /** Return the specified optional string from JSON or throw a helpful error message. */
  static String validateOptionalString(Map<String, Object> map, String key, String errorPrefix)
      throws IOException {
    Object value = map.get(key);
    if (value == null) {
      return null;
    }
    if (!(value instanceof String)) {
      throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, errorPrefix, "string", key));
    }
    return (String) value;
  }

  /** Return the specified list of strings from JSON or throw a helpful error message. */
  @SuppressWarnings("unchecked")
  static List<String> validateOptionalListString(
      Map<String, Object> map, String key, String errorPrefix) throws IOException {
    Object value = map.get(key);
    if (value == null) {
      return null;
    }
    if (!(value instanceof List)) {
      throw new IOException(
          String.format(VALUE_WRONG_TYPE_MESSAGE, errorPrefix, "List<String>", key));
    }
    return (List<String>) value;
  }

  /** Return the specified integer from JSON or throw a helpful error message. */
  static int validateInt32(Map<String, Object> map, String key, String errorPrefix)
      throws IOException {
    Object value = map.get(key);
    if (value == null) {
      throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, errorPrefix, key));
    }
    if (value instanceof BigDecimal) {
      BigDecimal bigDecimalValue = (BigDecimal) value;
      return bigDecimalValue.intValueExact();
    }
    if (!(value instanceof Integer)) {
      throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, errorPrefix, "integer", key));
    }
    return (Integer) value;
  }

  /** Return the specified long from JSON or throw a helpful error message. */
  static long validateLong(Map<String, Object> map, String key, String errorPrefix)
      throws IOException {
    Object value = map.get(key);
    if (value == null) {
      throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, errorPrefix, key));
    }
    if (value instanceof BigDecimal) {
      BigDecimal bigDecimalValue = (BigDecimal) value;
      return bigDecimalValue.longValueExact();
    }
    if (!(value instanceof Long)) {
      throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, errorPrefix, "long", key));
    }
    return (Long) value;
  }

  /** Return the specified map from JSON or throw a helpful error message. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  static Map<String, Object> validateMap(Map<String, Object> map, String key, String errorPrefix)
      throws IOException {
    Object value = map.get(key);
    if (value == null) {
      throw new IOException(String.format(VALUE_NOT_FOUND_MESSAGE, errorPrefix, key));
    }
    if (!(value instanceof Map)) {
      throw new IOException(String.format(VALUE_WRONG_TYPE_MESSAGE, errorPrefix, "Map", key));
    }
    return (Map) value;
  }

  /**
   * Converts a PKCS#8 string to an RSA private key.
   *
   * @param privateKeyPkcs8 the PKCS#8 string.
   * @return the RSA private key.
   * @throws IOException if the PKCS#8 data is invalid or if an unexpected exception occurs during
   *     key creation.
   */
  public static PrivateKey privateKeyFromPkcs8(String privateKeyPkcs8) throws IOException {
    Reader reader = new StringReader(privateKeyPkcs8);
    Section section = PemReader.readFirstSectionAndClose(reader, "PRIVATE KEY");
    if (section == null) {
      throw new IOException("Invalid PKCS#8 data.");
    }
    byte[] bytes = section.getBase64DecodedBytes();
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
    Exception unexpectedException;
    try {
      KeyFactory keyFactory = SecurityUtils.getRsaKeyFactory();
      return keyFactory.generatePrivate(keySpec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException exception) {
      unexpectedException = exception;
    }
    throw new IOException("Unexpected exception reading PKCS#8 data", unexpectedException);
  }

  /**
   * Generates a Basic Authentication header string for the provided username and password.
   *
   * <p>This method constructs a Basic Authentication string using the provided username and
   * password. The credentials are encoded in Base64 format and prefixed with the "Basic " scheme
   * identifier.
   *
   * @param username The username for authentication.
   * @param password The password for authentication.
   * @return The Basic Authentication header value.
   * @throws IllegalArgumentException if either username or password is null or empty.
   */
  static String generateBasicAuthHeader(String username, String password) {
    if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)) {
      throw new IllegalArgumentException("Username and password cannot be null or empty.");
    }
    String credentials = username + ":" + password;
    String encodedCredentials = BaseEncoding.base64().encode(credentials.getBytes());
    return "Basic " + encodedCredentials;
  }

  private OAuth2Utils() {}
}
