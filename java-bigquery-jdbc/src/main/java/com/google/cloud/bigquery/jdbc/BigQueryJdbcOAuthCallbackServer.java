/*
 * Copyright 2026 Google LLC
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

import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Uses java.net.ServerSocket (java.base) to avoid requiring jdk.httpserver in custom jlink or OSGi
// runtimes.
final class BigQueryJdbcOAuthCallbackServer implements AutoCloseable {

  static final int MAX_HTTP_REQUEST_LINE_BYTES = 8192;
  static final int MAX_HTTP_HEADER_BYTES = 65536;

  private static final int USER_AUTH_DRAIN_TIMEOUT_MS = 50;
  private static final int USER_AUTH_BACKLOG = 8;
  private static final int MAX_OAUTH_ERROR_LENGTH = 64;

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

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcOAuthCallbackServer.class.getName());

  @FunctionalInterface
  interface ServerSocketSupplier {
    ServerSocket open() throws IOException;
  }

  @FunctionalInterface
  interface LoopbackSocketBinder {
    ServerSocket bind(InetAddress bindAddress, int backlog) throws IOException;
  }

  static final class HttpCallbackException extends Exception {
    private HttpCallbackException(String message) {
      super(message);
    }
  }

  private final ServerSocket serverSocket;

  BigQueryJdbcOAuthCallbackServer(ServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  URI getCallbackUri() {
    return buildLoopbackCallbackUri(serverSocket.getInetAddress(), serverSocket.getLocalPort());
  }

  String waitForAuthorizationCode(String expectedState, int authTimeoutMs, int socketReadTimeoutMs)
      throws IOException {
    LOG.finer("++enter++");
    try {
      long overallDeadlineNanos = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(authTimeoutMs);
      String lastRejectedReason = null;
      while (true) {
        int acceptTimeoutMs = remainingMillis(overallDeadlineNanos);
        if (acceptTimeoutMs <= 0) {
          throw callbackTimeoutException(lastRejectedReason);
        }
        serverSocket.setSoTimeout(acceptTimeoutMs);
        Socket acceptedSocket;
        try {
          acceptedSocket = serverSocket.accept();
        } catch (SocketTimeoutException acceptTimedOut) {
          throw callbackTimeoutException(lastRejectedReason);
        }
        try (Socket socket = acceptedSocket) {
          String code =
              handleCallbackConnection(
                  socket, expectedState, overallDeadlineNanos, socketReadTimeoutMs);
          if (code != null) {
            return code;
          }
        } catch (HttpCallbackException rejectedRequest) {
          lastRejectedReason = rejectedRequest.getMessage();
        }
      }
    } finally {
      LOG.finer("++exit++");
    }
  }

  @Override
  public void close() throws IOException {
    serverSocket.close();
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

  static Map<String, String> parseOAuthQueryParameters(String rawQuery)
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

  private static String urlDecodeUtf8(String value) throws HttpCallbackException {
    try {
      return URLDecoder.decode(value.replace("+", "%2B"), StandardCharsets.UTF_8.name());
    } catch (IllegalArgumentException e) {
      throw new HttpCallbackException("Malformed query parameter encoding in OAuth callback.");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("UTF-8 encoding not supported", e);
    }
  }

  private static boolean isValidOAuthState(String expectedState, String actualState) {
    if (actualState == null) {
      return false;
    }
    return MessageDigest.isEqual(
        expectedState.getBytes(StandardCharsets.UTF_8),
        actualState.getBytes(StandardCharsets.UTF_8));
  }

  private static SocketTimeoutException callbackTimeoutException(String lastRejectedReason) {
    if (lastRejectedReason == null) {
      return new SocketTimeoutException("Timed out waiting for OAuth authorization callback.");
    }
    return new SocketTimeoutException(
        "Timed out waiting for OAuth authorization callback. Last rejected callback request: "
            + lastRejectedReason);
  }

  private static String handleCallbackConnection(
      Socket socket, String expectedState, long overallDeadlineNanos, int socketReadTimeoutMs)
      throws HttpCallbackException {
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
        if (!isValidOAuthState(expectedState, queryParams.get("state"))) {
          throw new HttpCallbackException("Missing or invalid state parameter in OAuth callback.");
        }
        String error = queryParams.get("error");
        if (error != null) {
          writeHttpResponseQuietly(socket, USER_AUTH_BAD_REQUEST_HTTP_RESPONSE_BYTES);
          throw new BigQueryJdbcRuntimeException(
              "OAuth authorization failed: " + sanitizeOAuthErrorCode(error));
        }
        String code = queryParams.get("code");
        if (code == null || code.isEmpty()) {
          writeHttpResponseQuietly(socket, USER_AUTH_BAD_REQUEST_HTTP_RESPONSE_BYTES);
          throw new BigQueryJdbcRuntimeException(
              "Could not retrieve the authorization code from OAuth callback.");
        }
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
        throw callbackError;
      }
    } catch (IOException clientIoError) {
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
            + "X-Content-Type-Options: nosniff\r\n"
            + "Content-Security-Policy: default-src 'none'\r\n"
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
      socket.shutdownOutput();
    } catch (IOException ignored) {
      // Peer may have already closed its side of the connection.
    }
  }
}
