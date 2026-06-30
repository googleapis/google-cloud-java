/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.fail;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.auth.Retryable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Validate the behavior of our new "default" ResultRetryAlgorithms against that of the legacy retry
 * handling behavior.
 */
@RunWith(Parameterized.class)
public final class DefaultRetryHandlingBehaviorTest {
  private static final String DEFAULT_MESSAGE = "err_default_message";

  private final Case c;
  private final DefaultStorageRetryStrategy defaultStrategy;
  private final StorageRetryStrategy legacyStrategy;

  @SuppressWarnings("deprecation")
  public DefaultRetryHandlingBehaviorTest(Case c) {
    this.c = c;
    defaultStrategy = DefaultStorageRetryStrategy.INSTANCE;
    legacyStrategy = StorageRetryStrategy.getLegacyStorageRetryStrategy();
  }

  /**
   * For a specified {@link Case}
   *
   * <ol>
   *   <li>Resolve the ResultRetryAlgorithm for the specific {@link HandlerCategory} for both
   *       default and legacy
   *   <li>Evaluate the retryability of the throwable {@link Case#getThrowable()} against both of
   *       the resolved {@code ResultRetryAlgorithm}s
   *   <li>Resolve the {@link Behavior} change if any between the two evaluation results
   *   <li>Assert the behavior change matches the {@link Case#expectedBehavior expected behavior}
   * </ol>
   */
  @SuppressWarnings("ConstantConditions")
  @Test
  public void validateBehavior() {
    ResultRetryAlgorithm<?> defaultAlgorithm = c.handlerCategory.apply(defaultStrategy);
    ResultRetryAlgorithm<?> legacyAlgorithm = c.handlerCategory.apply(legacyStrategy);
    Throwable throwable = c.getThrowable();

    boolean defaultShouldRetryResult = defaultAlgorithm.shouldRetry(throwable, null);
    boolean legacyShouldRetryResult = legacyAlgorithm.shouldRetry(throwable, null);

    Behavior actualBehavior = null;
    String message = null;
    boolean shouldRetry = c.getExpectRetry().shouldRetry;
    if (shouldRetry && !defaultShouldRetryResult && legacyShouldRetryResult) {
      actualBehavior = Behavior.DEFAULT_MORE_STRICT;
      message = "default is more strict";
    } else if (shouldRetry && !defaultShouldRetryResult && !legacyShouldRetryResult) {
      actualBehavior = Behavior.SAME;
      message = "both are rejecting when we want a retry";
      fail(message);
    } else if (shouldRetry && defaultShouldRetryResult && legacyShouldRetryResult) {
      actualBehavior = Behavior.SAME;
      message = "both are allowing";
    } else if (shouldRetry && defaultShouldRetryResult && !legacyShouldRetryResult) {
      actualBehavior = Behavior.DEFAULT_MORE_PERMISSIBLE;
      message = "default is more permissive";
    } else if (!shouldRetry && !defaultShouldRetryResult && legacyShouldRetryResult) {
      actualBehavior = Behavior.DEFAULT_MORE_STRICT;
      message = "default is more strict";
    } else if (!shouldRetry && !defaultShouldRetryResult && !legacyShouldRetryResult) {
      actualBehavior = Behavior.SAME;
      message = "both are rejecting as expected";
    } else if (!shouldRetry && defaultShouldRetryResult && legacyShouldRetryResult) {
      actualBehavior = Behavior.SAME;
      message = "both are too permissive";
      fail(message);
    } else if (!shouldRetry && defaultShouldRetryResult && !legacyShouldRetryResult) {
      actualBehavior = Behavior.DEFAULT_MORE_PERMISSIBLE;
      message = "default is too permissive";
    }

    assertWithMessage(message).that(actualBehavior).isEqualTo(c.expectedBehavior);
  }

  /** Resolve all the test cases and assert all permutations have a case defined. */
  @Parameters(name = "{0}")
  public static Collection<Object[]> testCases() {

    // define the list of cases to be validated
    List<Case> cases = getAllCases();

    /* perform validation of the defined list of cases to ensure all permutations are defined */

    // calculate all the possible permutations
    ImmutableSet<String> expectedTokens =
        Arrays.stream(HandlerCategory.values())
            .flatMap(
                handlerCategory ->
                    Arrays.stream(ThrowableCategory.values())
                        .map(throwableCategory -> token(throwableCategory, handlerCategory)))
            .collect(toImmutableSet());

    // calculate the actual defined permutations
    ImmutableSet<String> actualTokens =
        cases.stream()
            .map(c -> token(c.throwableCategory, c.handlerCategory))
            .collect(toImmutableSet());

    // calculate the difference if any between expected and actual, then sort and listify
    ImmutableList<String> difference =
        Sets.difference(expectedTokens, actualTokens).stream().sorted().collect(toImmutableList());

    // ensure all permutations are accounted for, reporting any that haven't been and providing
    // a stub which can be used to easily define them.
    assertWithMessage("Missing mappings for tokens").that(difference).isEmpty();

    // wrap our case in an array for ultimate passing to the constructor
    return cases.stream().map(c -> new Object[] {c}).collect(toImmutableList());
  }

  /**
   * Generate a token which represents a permutation for which a {@link Case} must be defined.
   *
   * <p>If a case is not defined, this value will be reported and functions as a stub to easily
   * define a new {@code Case}.
   */
  private static String token(ThrowableCategory t, HandlerCategory h) {
    return String.format(
        Locale.US,
        "new Case(ThrowableCategory.%s, HandlerCategory.%s, /*TODO*/ null, /*TODO*/ null)",
        t.name(),
        h.name());
  }

  /**
   * An individual case we want to validate.
   *
   * <p>Given a {@link HandlerCategory} and {@link ThrowableCategory} validate the retryability and
   * behavior between default and legacy handlers.
   */
  static final class Case {

    private final HandlerCategory handlerCategory;
    private final ThrowableCategory throwableCategory;
    private final ExpectRetry expectRetry;
    private final Behavior expectedBehavior;

    Case(
        ThrowableCategory throwableCategory,
        HandlerCategory handlerCategory,
        ExpectRetry expectRetry,
        Behavior expectedBehavior) {
      this.handlerCategory = handlerCategory;
      this.throwableCategory = throwableCategory;
      this.expectRetry = expectRetry;
      this.expectedBehavior = expectedBehavior;
    }

    Throwable getThrowable() {
      return throwableCategory.throwable;
    }

    public ExpectRetry getExpectRetry() {
      return expectRetry;
    }

    @Override
    public String toString() {
      return "Case{"
          + "handlerCategory="
          + handlerCategory
          + ", throwableCategory="
          + throwableCategory
          + ", expectRetry="
          + expectRetry
          + ", expectedBehavior="
          + expectedBehavior
          + '}';
    }
  }

  /** Whether to expect a retry to happen or not */
  enum ExpectRetry {
    YES(true),
    NO(false);

    private final boolean shouldRetry;

    ExpectRetry(boolean shouldRetry) {
      this.shouldRetry = shouldRetry;
    }
  }

  /**
   * A category of handler type, and the ability to resolve the {@link ResultRetryAlgorithm} given a
   * {@link StorageRetryStrategy}
   */
  enum HandlerCategory implements Function<StorageRetryStrategy, ResultRetryAlgorithm<?>> {
    IDEMPOTENT,
    NONIDEMPOTENT;

    @Override
    public ResultRetryAlgorithm<?> apply(StorageRetryStrategy storageRetryStrategy) {
      switch (this) {
        case IDEMPOTENT:
          return storageRetryStrategy.getIdempotentHandler();
        case NONIDEMPOTENT:
          return storageRetryStrategy.getNonidempotentHandler();
        default:
          throw new IllegalStateException("Unmappable HandlerCategory: " + this.name());
      }
    }
  }

  /** Some states comparing behavior between default and legacy */
  enum Behavior {
    DEFAULT_MORE_PERMISSIBLE,
    SAME,
    DEFAULT_MORE_STRICT
  }

  /**
   * A set of exceptions we want to validate behavior for.
   *
   * <p>This class is an enum for convenience of specifying a closed set, along with providing easy
   * to read names in code thereby forgoing the need to maintain a separate set of strings.
   */
  enum ThrowableCategory {
    SOCKET_TIMEOUT_EXCEPTION(C.SOCKET_TIMEOUT_EXCEPTION),
    SOCKET_EXCEPTION(C.SOCKET_EXCEPTION),
    SSL_EXCEPTION(C.SSL_EXCEPTION),
    SSL_EXCEPTION_CONNECTION_SHUTDOWN(C.SSL_EXCEPTION_CONNECTION_SHUTDOWN),
    SSL_EXCEPTION_CONNECTION_RESET(C.SSL_EXCEPTION_CONNECTION_RESET),
    SSL_HANDSHAKE_EXCEPTION(C.SSL_HANDSHAKE_EXCEPTION),
    SSL_HANDSHAKE_EXCEPTION_CAUSED_BY_CERTIFICATE_EXCEPTION(
        C.SSL_HANDSHAKE_EXCEPTION_CERTIFICATE_EXCEPTION),
    INSUFFICIENT_DATA(C.INSUFFICIENT_DATA_WRITTEN),
    ERROR_WRITING_REQUEST_BODY(C.ERROR_WRITING_REQUEST_BODY),
    HTTP_RESPONSE_EXCEPTION_401(C.HTTP_401),
    HTTP_RESPONSE_EXCEPTION_403(C.HTTP_403),
    HTTP_RESPONSE_EXCEPTION_404(C.HTTP_404),
    HTTP_RESPONSE_EXCEPTION_408(C.HTTP_409),
    HTTP_RESPONSE_EXCEPTION_429(C.HTTP_429),
    HTTP_RESPONSE_EXCEPTION_500(C.HTTP_500),
    HTTP_RESPONSE_EXCEPTION_502(C.HTTP_502),
    HTTP_RESPONSE_EXCEPTION_503(C.HTTP_503),
    HTTP_RESPONSE_EXCEPTION_504(C.HTTP_504),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_401(new StorageException(C.HTTP_401)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_403(new StorageException(C.HTTP_403)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_404(new StorageException(C.HTTP_404)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_408(new StorageException(C.HTTP_409)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_429(new StorageException(C.HTTP_429)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_500(new StorageException(C.HTTP_500)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_502(new StorageException(C.HTTP_502)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_503(new StorageException(C.HTTP_503)),
    STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_504(new StorageException(C.HTTP_504)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_401(new StorageException(C.JSON_401)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_403(new StorageException(C.JSON_403)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_404(new StorageException(C.JSON_404)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_408(new StorageException(C.JSON_408)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_429(new StorageException(C.JSON_429)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_500(new StorageException(C.JSON_500)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_502(new StorageException(C.JSON_502)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_503(new StorageException(C.JSON_503)),
    STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_504(new StorageException(C.JSON_504)),
    STORAGE_EXCEPTION_SOCKET_TIMEOUT_EXCEPTION(new StorageException(C.SOCKET_TIMEOUT_EXCEPTION)),
    STORAGE_EXCEPTION_SOCKET_EXCEPTION(StorageException.translate(C.SOCKET_EXCEPTION)),
    STORAGE_EXCEPTION_SSL_EXCEPTION(new StorageException(C.SSL_EXCEPTION)),
    STORAGE_EXCEPTION_SSL_EXCEPTION_CONNECTION_SHUTDOWN(
        new StorageException(C.SSL_EXCEPTION_CONNECTION_SHUTDOWN)),
    STORAGE_EXCEPTION_SSL_EXCEPTION_CONNECTION_RESET(
        new StorageException(C.SSL_EXCEPTION_CONNECTION_RESET)),
    STORAGE_EXCEPTION_SSL_HANDSHAKE_EXCEPTION(new StorageException(C.SSL_HANDSHAKE_EXCEPTION)),
    STORAGE_EXCEPTION_SSL_HANDSHAKE_EXCEPTION_CAUSED_BY_CERTIFICATE_EXCEPTION(
        new StorageException(C.SSL_HANDSHAKE_EXCEPTION_CERTIFICATE_EXCEPTION)),
    STORAGE_EXCEPTION_INSUFFICIENT_DATA(new StorageException(C.INSUFFICIENT_DATA_WRITTEN)),
    STORAGE_EXCEPTION_ERROR_WRITING_REQUEST_BODY(
        new StorageException(C.ERROR_WRITING_REQUEST_BODY)),
    ILLEGAL_ARGUMENT_EXCEPTION(C.ILLEGAL_ARGUMENT_EXCEPTION),
    STORAGE_EXCEPTION_ILLEGAL_ARGUMENT_EXCEPTION(
        StorageException.coalesce(C.ILLEGAL_ARGUMENT_EXCEPTION)),
    STORAGE_EXCEPTION_0_INTERNAL_ERROR(
        new StorageException(0, "internalError", "internalError", null)),
    STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY(
        new StorageException(
            0, "connectionClosedPrematurely", "connectionClosedPrematurely", null)),
    STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY_IO_CAUSE(
        new StorageException(
            0,
            "connectionClosedPrematurely",
            "connectionClosedPrematurely",
            C.CONNECTION_CLOSED_PREMATURELY)),
    STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY_IO_CAUSE_NO_REASON(
        StorageException.translate(C.CONNECTION_CLOSED_PREMATURELY)),
    STORAGE_EXCEPTION_0_IO_PREMATURE_EOF(StorageException.translate(C.IO_PREMATURE_EOF)),
    EMPTY_JSON_PARSE_ERROR(new IllegalArgumentException("no JSON input found")),
    JACKSON_EOF_EXCEPTION(C.JACKSON_EOF_EXCEPTION),
    STORAGE_EXCEPTION_0_JACKSON_EOF_EXCEPTION(
        new StorageException(0, "parse error", C.JACKSON_EOF_EXCEPTION)),
    GSON_MALFORMED_EXCEPTION(C.GSON_MALFORMED_EXCEPTION),
    STORAGE_EXCEPTION_0_GSON_MALFORMED_EXCEPTION(
        new StorageException(0, "parse error", C.GSON_MALFORMED_EXCEPTION)),
    IO_EXCEPTION(new IOException("no retry")),
    AUTH_RETRYABLE_TRUE(new RetryableException(true)),
    AUTH_RETRYABLE_FALSE(new RetryableException(false)),
    UNKNOWN_HOST_EXCEPTION(C.UNKNOWN_HOST_EXCEPTION),
    ;

    private final Throwable throwable;

    ThrowableCategory(Throwable throwable) {
      this.throwable = throwable;
    }

    public Throwable getThrowable() {
      return throwable;
    }

    /**
     * A class of constants for use by the containing enum.
     *
     * <p>Enums can't have static fields, so we use this class to hold constants which are used by
     * the enum values.
     */
    private static final class C {
      private static final SocketTimeoutException SOCKET_TIMEOUT_EXCEPTION =
          new SocketTimeoutException();
      private static final SocketException SOCKET_EXCEPTION = new SocketException();
      private static final SSLException SSL_EXCEPTION = new SSLException("unknown");
      private static final SSLException SSL_EXCEPTION_CONNECTION_SHUTDOWN =
          new SSLException("Connection has been shutdown: asdf");
      private static final SSLException SSL_EXCEPTION_CONNECTION_RESET =
          new SSLException("Connection reset", new SocketException("Connection reset"));
      private static final SSLHandshakeException SSL_HANDSHAKE_EXCEPTION =
          newSslHandshakeExceptionWithCause(new SSLProtocolException(DEFAULT_MESSAGE));
      private static final SSLHandshakeException SSL_HANDSHAKE_EXCEPTION_CERTIFICATE_EXCEPTION =
          newSslHandshakeExceptionWithCause(new CertificateException());
      private static final IOException INSUFFICIENT_DATA_WRITTEN =
          new IOException("insufficient data written");
      private static final IOException ERROR_WRITING_REQUEST_BODY =
          new IOException("Error writing request body to server");
      private static final HttpResponseException HTTP_401 =
          newHttpResponseException(401, "Unauthorized");
      private static final HttpResponseException HTTP_403 =
          newHttpResponseException(403, "Forbidden");
      private static final HttpResponseException HTTP_404 =
          newHttpResponseException(404, "Not Found");
      private static final HttpResponseException HTTP_409 =
          newHttpResponseException(408, "Request Timeout");
      private static final HttpResponseException HTTP_429 =
          newHttpResponseException(429, "Too Many Requests");
      private static final HttpResponseException HTTP_500 =
          newHttpResponseException(500, "Internal Server Error");
      private static final HttpResponseException HTTP_502 =
          newHttpResponseException(502, "Bad Gateway");
      private static final HttpResponseException HTTP_503 =
          newHttpResponseException(503, "Service Unavailable");
      private static final HttpResponseException HTTP_504 =
          newHttpResponseException(504, "Gateway Timeout");
      private static final GoogleJsonError JSON_401 = newGoogleJsonError(401, "Unauthorized");
      private static final GoogleJsonError JSON_403 = newGoogleJsonError(403, "Forbidden");
      private static final GoogleJsonError JSON_404 = newGoogleJsonError(404, "Not Found");
      private static final GoogleJsonError JSON_408 = newGoogleJsonError(408, "Request Timeout");
      private static final GoogleJsonError JSON_429 = newGoogleJsonError(429, "Too Many Requests");
      private static final GoogleJsonError JSON_500 =
          newGoogleJsonError(500, "Internal Server Error");
      private static final GoogleJsonError JSON_502 = newGoogleJsonError(502, "Bad Gateway");
      private static final GoogleJsonError JSON_503 =
          newGoogleJsonError(503, "Service Unavailable");
      private static final GoogleJsonError JSON_504 = newGoogleJsonError(504, "Gateway Timeout");
      private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION =
          new IllegalArgumentException("illegal argument");
      private static final IOException CONNECTION_CLOSED_PREMATURELY =
          new IOException("simulated Connection closed prematurely");
      private static final JsonEOFException JACKSON_EOF_EXCEPTION =
          new JsonEOFException(null, JsonToken.VALUE_STRING, "parse-exception");
      private static final MalformedJsonException GSON_MALFORMED_EXCEPTION =
          new MalformedJsonException("parse-exception");
      private static final IOException IO_PREMATURE_EOF = new IOException("Premature EOF");
      private static final UnknownHostException UNKNOWN_HOST_EXCEPTION =
          new UnknownHostException("fake.fake");

      private static HttpResponseException newHttpResponseException(
          int httpStatusCode, String name) {
        return new HttpResponseException.Builder(httpStatusCode, name, new HttpHeaders()).build();
      }

      private static GoogleJsonError newGoogleJsonError(int code, String message) {
        GoogleJsonError error = new GoogleJsonError();
        error.setCode(code);
        error.setMessage(message);
        return error;
      }

      private static SSLHandshakeException newSslHandshakeExceptionWithCause(Throwable cause) {
        SSLHandshakeException sslHandshakeException = new SSLHandshakeException(DEFAULT_MESSAGE);
        Throwable throwable = sslHandshakeException.initCause(cause);
        return (SSLHandshakeException) throwable;
      }
    }
  }

  /**
   * A corralled method which allows us to move the individual cases away from the rest of the code
   * since our code formatter is very strict and seems to feel 475 lines of code at 100 columns is
   * better than 90 lines at 200 columns.
   *
   * <p>this method returns a list that essentially is a table of where each row is an individual
   * test case
   *
   * <table>
   *   <tr>
   *     <th>{@link ThrowableCategory throwable category}</th>
   *     <th>{@link HandlerCategory handler category}</th>
   *     <th>{@link ExpectRetry whether retry is expected}</th>
   *     <th>{@link Behavior what the expected behavior comparison is}</th>
   *   </tr>
   *   <tr>
   *     <td>{@link ThrowableCategory#STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_500 STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_500}</td>
   *     <td>{@link HandlerCategory#NONIDEMPOTENT NONIDEMPOTENT}</td>
   *     <td>{@link ExpectRetry#NO NO}</td>
   *     <td>{@link Behavior#DEFAULT_MORE_STRICT DEFAULT_MORE_STRICT}</td>
   *   </tr>
   * </table>
   */
  private static ImmutableList<Case> getAllCases() {
    return ImmutableList.<Case>builder()
        .add(
            new Case(
                ThrowableCategory.ERROR_WRITING_REQUEST_BODY,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.ERROR_WRITING_REQUEST_BODY,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_401,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_401,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_403,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_403,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_404,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_404,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_408,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_408,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_429,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_429,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_500,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_500,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_502,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_502,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_503,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_503,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_504,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.HTTP_RESPONSE_EXCEPTION_504,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.ILLEGAL_ARGUMENT_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.ILLEGAL_ARGUMENT_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.INSUFFICIENT_DATA,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.INSUFFICIENT_DATA,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SOCKET_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.SOCKET_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SOCKET_TIMEOUT_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.SOCKET_TIMEOUT_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SSL_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SSL_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SSL_EXCEPTION_CONNECTION_SHUTDOWN,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.SSL_EXCEPTION_CONNECTION_SHUTDOWN,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SSL_EXCEPTION_CONNECTION_RESET,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.SSL_EXCEPTION_CONNECTION_RESET,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SSL_HANDSHAKE_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.SSL_HANDSHAKE_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SSL_HANDSHAKE_EXCEPTION_CAUSED_BY_CERTIFICATE_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.SSL_HANDSHAKE_EXCEPTION_CAUSED_BY_CERTIFICATE_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_ERROR_WRITING_REQUEST_BODY,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_ERROR_WRITING_REQUEST_BODY,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_401,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_401,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_403,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_403,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_404,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_404,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_408,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_408,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_429,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_429,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_500,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_500,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_502,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_502,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_503,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_503,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_504,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_GOOGLE_JSON_ERROR_504,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_401,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_401,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_403,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_403,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_404,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_404,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_408,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_408,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_429,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_429,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_500,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_500,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_502,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_502,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_503,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_503,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_504,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_HTTP_RESPONSE_EXCEPTION_504,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_ILLEGAL_ARGUMENT_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_ILLEGAL_ARGUMENT_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_INSUFFICIENT_DATA,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_INSUFFICIENT_DATA,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SOCKET_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SOCKET_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SOCKET_TIMEOUT_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SOCKET_TIMEOUT_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_EXCEPTION_CONNECTION_SHUTDOWN,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_EXCEPTION_CONNECTION_SHUTDOWN,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_EXCEPTION_CONNECTION_RESET,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_EXCEPTION_CONNECTION_RESET,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_HANDSHAKE_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_SSL_HANDSHAKE_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory
                    .STORAGE_EXCEPTION_SSL_HANDSHAKE_EXCEPTION_CAUSED_BY_CERTIFICATE_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory
                    .STORAGE_EXCEPTION_SSL_HANDSHAKE_EXCEPTION_CAUSED_BY_CERTIFICATE_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY_IO_CAUSE,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY_IO_CAUSE,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory
                    .STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY_IO_CAUSE_NO_REASON,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory
                    .STORAGE_EXCEPTION_0_CONNECTION_CLOSED_PREMATURELY_IO_CAUSE_NO_REASON,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_IO_PREMATURE_EOF,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_IO_PREMATURE_EOF,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_INTERNAL_ERROR,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_INTERNAL_ERROR,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.DEFAULT_MORE_STRICT),
            new Case(
                ThrowableCategory.EMPTY_JSON_PARSE_ERROR,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.EMPTY_JSON_PARSE_ERROR,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.IO_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.IO_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.JACKSON_EOF_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.JACKSON_EOF_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_JACKSON_EOF_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_JACKSON_EOF_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.GSON_MALFORMED_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.GSON_MALFORMED_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_GSON_MALFORMED_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.STORAGE_EXCEPTION_0_GSON_MALFORMED_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.AUTH_RETRYABLE_TRUE,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.AUTH_RETRYABLE_TRUE,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.AUTH_RETRYABLE_FALSE,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.AUTH_RETRYABLE_FALSE,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME),
            new Case(
                ThrowableCategory.UNKNOWN_HOST_EXCEPTION,
                HandlerCategory.IDEMPOTENT,
                ExpectRetry.YES,
                Behavior.DEFAULT_MORE_PERMISSIBLE),
            new Case(
                ThrowableCategory.UNKNOWN_HOST_EXCEPTION,
                HandlerCategory.NONIDEMPOTENT,
                ExpectRetry.NO,
                Behavior.SAME))
        .build();
  }

  /**
   * The auth library provides the interface {@link Retryable} to annotate an exception as
   * retryable. Add a definition here. Explicitly extend IOException to ensure our handling of this
   * type is sooner than IOExceptions
   */
  private static final class RetryableException extends IOException implements Retryable {

    private final boolean isRetryable;

    private RetryableException(boolean isRetryable) {
      super(String.format(Locale.US, "RetryableException{isRetryable=%s}", isRetryable));
      this.isRetryable = isRetryable;
    }

    @Override
    public boolean isRetryable() {
      return isRetryable;
    }

    @Override
    public int getRetryCount() {
      return 0;
    }
  }
}
