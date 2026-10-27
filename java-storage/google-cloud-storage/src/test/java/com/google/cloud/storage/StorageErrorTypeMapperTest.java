/*
 * Copyright 2026 Google LLC
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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.auth.ServiceAccountSigner.SigningException;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import org.junit.Test;

public final class StorageErrorTypeMapperTest {

  private static final Crc32cValue<?> EXPECTED_CRC32C = Crc32cValue.of(12345, 100);
  private static final Crc32cValue.Crc32cLengthKnown ACTUAL_CRC32C = Crc32cValue.of(54321, 100);

  @Test
  public void mapGrpcStatus_allStatusesMappedCorrectly() {
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.OK)).isEqualTo("OK");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.CANCELLED)).isEqualTo("CANCELLED");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.UNKNOWN)).isEqualTo("UNKNOWN");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.INVALID_ARGUMENT))
        .isEqualTo("INVALID_ARGUMENT");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.DEADLINE_EXCEEDED)).isEqualTo("TIMEOUT");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.NOT_FOUND)).isEqualTo("NOT_FOUND");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.ALREADY_EXISTS))
        .isEqualTo("ALREADY_EXISTS");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.PERMISSION_DENIED))
        .isEqualTo("PERMISSION_DENIED");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.RESOURCE_EXHAUSTED))
        .isEqualTo("RESOURCE_EXHAUSTED");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.FAILED_PRECONDITION))
        .isEqualTo("FAILED_PRECONDITION");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.ABORTED)).isEqualTo("ABORTED");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.OUT_OF_RANGE)).isEqualTo("OUT_OF_RANGE");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.UNIMPLEMENTED))
        .isEqualTo("UNIMPLEMENTED");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.INTERNAL)).isEqualTo("INTERNAL");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.UNAVAILABLE)).isEqualTo("UNAVAILABLE");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.DATA_LOSS)).isEqualTo("DATA_LOSS");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(Status.UNAUTHENTICATED))
        .isEqualTo("UNAUTHENTICATED");
    assertThat(StorageErrorTypeMapper.mapGrpcStatus(null)).isEqualTo("UNKNOWN");
  }

  @Test
  public void mapHttpResponseCode_standardCodesMappedCorrectly() {
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(200)).isEqualTo("OK");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(201)).isEqualTo("OK");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(204)).isEqualTo("OK");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(299)).isEqualTo("OK");

    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(400)).isEqualTo("INVALID_ARGUMENT");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(401)).isEqualTo("UNAUTHENTICATED");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(403)).isEqualTo("PERMISSION_DENIED");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(404)).isEqualTo("NOT_FOUND");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(408)).isEqualTo("TIMEOUT");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(409)).isEqualTo("ALREADY_EXISTS");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(412)).isEqualTo("FAILED_PRECONDITION");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(416)).isEqualTo("OUT_OF_RANGE");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(429)).isEqualTo("RESOURCE_EXHAUSTED");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(499)).isEqualTo("CANCELLED");

    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(500)).isEqualTo("INTERNAL");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(501)).isEqualTo("UNIMPLEMENTED");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(502)).isEqualTo("UNAVAILABLE");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(503)).isEqualTo("UNAVAILABLE");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(504)).isEqualTo("TIMEOUT");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(505)).isEqualTo("505");

    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(418)).isEqualTo("418");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(0)).isEqualTo("UNKNOWN");
    assertThat(StorageErrorTypeMapper.mapHttpResponseCode(-1)).isEqualTo("UNKNOWN");
  }

  @Test
  public void mapThrowable_nullReturnsOk() {
    assertThat(StorageErrorTypeMapper.mapThrowable(null)).isEqualTo("OK");
  }

  @Test
  public void mapThrowable_grpcExceptions() {
    StatusRuntimeException sre = new StatusRuntimeException(Status.DEADLINE_EXCEEDED);
    assertThat(StorageErrorTypeMapper.mapThrowable(sre)).isEqualTo("TIMEOUT");

    StatusException se = new StatusException(Status.PERMISSION_DENIED);
    assertThat(StorageErrorTypeMapper.mapThrowable(se)).isEqualTo("PERMISSION_DENIED");

    ApiException apiEx =
        new ApiException(
            new StatusRuntimeException(Status.NOT_FOUND),
            GrpcStatusCode.of(Status.Code.NOT_FOUND),
            /* retryable= */ false);
    assertThat(StorageErrorTypeMapper.mapThrowable(apiEx)).isEqualTo("NOT_FOUND");
  }

  @Test
  public void mapThrowable_apiExceptionWithNullStatusCode() {
    ApiException apiExNullStatusCode =
        new ApiException(
            "Null status code",
            /* cause= */ null,
            GrpcStatusCode.of(Status.Code.UNKNOWN),
            /* retryable= */ false) {
          @Override
          public StatusCode getStatusCode() {
            return null;
          }
        };
    assertThat(StorageErrorTypeMapper.mapThrowable(apiExNullStatusCode)).isEqualTo("UNKNOWN");

    ApiException apiExNullStatusCodeWithTimeoutCause =
        new ApiException(
            "Null status code with timeout",
            new SocketTimeoutException("Read timed out"),
            GrpcStatusCode.of(Status.Code.UNKNOWN),
            /* retryable= */ false) {
          @Override
          public StatusCode getStatusCode() {
            return null;
          }
        };
    assertThat(StorageErrorTypeMapper.mapThrowable(apiExNullStatusCodeWithTimeoutCause))
        .isEqualTo("TIMEOUT");
  }

  @Test
  public void mapThrowable_gaxTimeoutExceptions() throws Exception {
    DeadlineExceededException dee =
        new DeadlineExceededException(
            new StatusRuntimeException(Status.DEADLINE_EXCEEDED),
            GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
            /* retryable= */ false);
    assertThat(StorageErrorTypeMapper.mapThrowable(dee)).isEqualTo("TIMEOUT");

    WatchdogTimeoutException wte = createWatchdogTimeoutException();
    assertThat(StorageErrorTypeMapper.mapThrowable(wte)).isEqualTo("TIMEOUT");
  }

  @Test
  public void mapThrowable_httpExceptions() {
    HttpResponseException hre =
        new HttpResponseException.Builder(503, "Service Unavailable", new HttpHeaders()).build();
    assertThat(StorageErrorTypeMapper.mapThrowable(hre)).isEqualTo("UNAVAILABLE");

    GoogleJsonError error = new GoogleJsonError();
    error.setCode(404);
    error.setMessage("Not Found");
    GoogleJsonResponseException gjre =
        new GoogleJsonResponseException(
            new HttpResponseException.Builder(404, "Not Found", new HttpHeaders()), error);
    assertThat(StorageErrorTypeMapper.mapThrowable(gjre)).isEqualTo("NOT_FOUND");

    StorageException se404 = new StorageException(404, "Not found");
    assertThat(StorageErrorTypeMapper.mapThrowable(se404)).isEqualTo("NOT_FOUND");

    StorageException se401 = new StorageException(401, "Unauthorized");
    assertThat(StorageErrorTypeMapper.mapThrowable(se401)).isEqualTo("UNAUTHENTICATED");
  }

  @Test
  public void mapThrowable_httpResponseExceptionWithSpecificClientCause() {
    HttpResponseException hreWithTimeout =
        new HttpResponseException.Builder(500, "Server Error", new HttpHeaders()).build();
    hreWithTimeout.initCause(new SocketTimeoutException("Read timed out"));
    assertThat(StorageErrorTypeMapper.mapThrowable(hreWithTimeout)).isEqualTo("TIMEOUT");

    HttpResponseException hre400WithTimeout =
        new HttpResponseException.Builder(400, "Bad Request", new HttpHeaders()).build();
    hre400WithTimeout.initCause(new SocketTimeoutException("Read timed out"));
    GoogleAuthException authWrappingHttpWrappingTimeout =
        new GoogleAuthException("Token refresh failed", hre400WithTimeout);
    assertThat(StorageErrorTypeMapper.mapThrowable(authWrappingHttpWrappingTimeout))
        .isEqualTo("TIMEOUT");
  }

  @Test
  public void mapThrowable_networkAndTlsExceptions() {
    assertThat(StorageErrorTypeMapper.mapThrowable(new SocketTimeoutException("Read timed out")))
        .isEqualTo("TIMEOUT");
    assertThat(StorageErrorTypeMapper.mapThrowable(new TimeoutException("Operation timed out")))
        .isEqualTo("TIMEOUT");
    assertThat(
            StorageErrorTypeMapper.mapThrowable(new UnknownHostException("storage.googleapis.com")))
        .isEqualTo("DNS_FAILURE");
    assertThat(StorageErrorTypeMapper.mapThrowable(new ConnectException("Connection refused")))
        .isEqualTo("CONNECTION_REFUSED");
    assertThat(StorageErrorTypeMapper.mapThrowable(new SocketException("Connection reset")))
        .isEqualTo("CONNECTION_RESET");
    assertThat(StorageErrorTypeMapper.mapThrowable(new SocketException("Broken pipe")))
        .isEqualTo("CONNECTIVITY");
    assertThat(StorageErrorTypeMapper.mapThrowable(new SSLHandshakeException("Handshake failed")))
        .isEqualTo("TLS_FAILURE");
    assertThat(StorageErrorTypeMapper.mapThrowable(new SSLException("SSL error")))
        .isEqualTo("TLS_FAILURE");
    assertThat(StorageErrorTypeMapper.mapThrowable(new IOException("Broken pipe")))
        .isEqualTo("CONNECTIVITY");
    assertThat(StorageErrorTypeMapper.mapThrowable(new CancellationException("Cancelled")))
        .isEqualTo("CANCELLED");
  }

  @Test
  public void mapThrowable_authExceptions() {
    Throwable signingEx = new SigningException("Signing error", new RuntimeException());
    assertThat(StorageErrorTypeMapper.mapThrowable(signingEx)).isEqualTo("AUTHENTICATION_ERROR");

    assertThat(StorageErrorTypeMapper.mapThrowable(new GoogleAuthException("Auth failed")))
        .isEqualTo("AUTHENTICATION_ERROR");
    assertThat(StorageErrorTypeMapper.mapThrowable(new OAuth2Exception("Token invalid")))
        .isEqualTo("AUTHENTICATION_ERROR");
    assertThat(StorageErrorTypeMapper.mapThrowable(new AuthenticationException("Auth failed")))
        .isEqualTo("AUTHENTICATION_ERROR");
    assertThat(StorageErrorTypeMapper.mapThrowable(new AuthorNotFoundException("Not found")))
        .isEqualTo("UNKNOWN");
  }

  @Test
  public void mapThrowable_anonymousAndSubclassAuthExceptions() {
    Throwable anonymousOAuth2 = new OAuth2Exception("Anonymous token invalid") {};
    assertThat(StorageErrorTypeMapper.mapThrowable(anonymousOAuth2))
        .isEqualTo("AUTHENTICATION_ERROR");

    Throwable anonymousAuth = new AuthenticationException("Anonymous auth failed") {};
    assertThat(StorageErrorTypeMapper.mapThrowable(anonymousAuth))
        .isEqualTo("AUTHENTICATION_ERROR");

    Throwable customSubclass = new CustomTokenException("Subclass of GoogleAuthException");
    assertThat(StorageErrorTypeMapper.mapThrowable(customSubclass))
        .isEqualTo("AUTHENTICATION_ERROR");
  }

  @Test
  public void mapThrowable_checksumMismatchExceptions() {
    Hasher.ChecksumMismatchException cme =
        new Hasher.ChecksumMismatchException(EXPECTED_CRC32C, ACTUAL_CRC32C);
    assertThat(StorageErrorTypeMapper.mapThrowable(cme)).isEqualTo("CHECKSUM_MISMATCH");

    Hasher.UncheckedChecksumMismatchException ucme =
        new Hasher.UncheckedChecksumMismatchException(EXPECTED_CRC32C, ACTUAL_CRC32C);
    assertThat(StorageErrorTypeMapper.mapThrowable(ucme)).isEqualTo("CHECKSUM_MISMATCH");

    IOException messageMismatch = new IOException("Checksum mismatch for downloaded object");
    assertThat(StorageErrorTypeMapper.mapThrowable(messageMismatch)).isEqualTo("CHECKSUM_MISMATCH");
  }

  @Test
  public void mapThrowable_unwrapsWrapperExceptions() {
    SocketTimeoutException root = new SocketTimeoutException("timeout");
    ExecutionException ee = new ExecutionException(root);
    assertThat(StorageErrorTypeMapper.mapThrowable(ee)).isEqualTo("TIMEOUT");

    CompletionException ce = new CompletionException(new UnknownHostException("host"));
    assertThat(StorageErrorTypeMapper.mapThrowable(ce)).isEqualTo("DNS_FAILURE");

    StorageException seWithCause = new StorageException(0, "Wrapped IO", root);
    assertThat(StorageErrorTypeMapper.mapThrowable(seWithCause)).isEqualTo("TIMEOUT");
  }

  @Test
  public void mapThrowable_storageExceptionWithSpecificClientCauseUnwrapped() throws Exception {
    WatchdogTimeoutException wte = createWatchdogTimeoutException();
    StorageException se500WithTimeout = new StorageException(500, "Internal error", wte);
    assertThat(StorageErrorTypeMapper.mapThrowable(se500WithTimeout)).isEqualTo("TIMEOUT");

    Hasher.ChecksumMismatchException cme =
        new Hasher.ChecksumMismatchException(EXPECTED_CRC32C, ACTUAL_CRC32C);
    StorageException se400WithChecksum = new StorageException(400, "Bad Request", cme);
    assertThat(StorageErrorTypeMapper.mapThrowable(se400WithChecksum))
        .isEqualTo("CHECKSUM_MISMATCH");

    SSLHandshakeException tlsEx = new SSLHandshakeException("Handshake failed");
    StorageException se500WithTls = new StorageException(500, "Internal error", tlsEx);
    assertThat(StorageErrorTypeMapper.mapThrowable(se500WithTls)).isEqualTo("TLS_FAILURE");

    SocketTimeoutException ste = new SocketTimeoutException("Read timed out");
    StorageException se504WithSocketTimeout = new StorageException(504, "Gateway timeout", ste);
    assertThat(StorageErrorTypeMapper.mapThrowable(se504WithSocketTimeout)).isEqualTo("TIMEOUT");
  }

  @Test
  public void mapThrowable_storageExceptionWrappingApiExceptions() {
    ApiException apiExAborted =
        new ApiException(
            new StatusRuntimeException(Status.ABORTED),
            GrpcStatusCode.of(Status.Code.ABORTED),
            /* retryable= */ false);
    StorageException seAborted = new StorageException(409, "Aborted", apiExAborted);
    assertThat(StorageErrorTypeMapper.mapThrowable(seAborted)).isEqualTo("ABORTED");

    ApiException apiExPrecondition =
        new ApiException(
            new StatusRuntimeException(Status.FAILED_PRECONDITION),
            GrpcStatusCode.of(Status.Code.FAILED_PRECONDITION),
            /* retryable= */ false);
    StorageException sePrecondition =
        new StorageException(400, "Failed Precondition", apiExPrecondition);
    assertThat(StorageErrorTypeMapper.mapThrowable(sePrecondition))
        .isEqualTo("FAILED_PRECONDITION");

    ApiException apiExOutOfRange =
        new ApiException(
            new StatusRuntimeException(Status.OUT_OF_RANGE),
            GrpcStatusCode.of(Status.Code.OUT_OF_RANGE),
            /* retryable= */ false);
    StorageException seOutOfRange = new StorageException(400, "Out of Range", apiExOutOfRange);
    assertThat(StorageErrorTypeMapper.mapThrowable(seOutOfRange)).isEqualTo("OUT_OF_RANGE");

    ApiException apiExUnauthenticated =
        new ApiException(
            new StatusRuntimeException(Status.UNAUTHENTICATED),
            GrpcStatusCode.of(Status.Code.UNAUTHENTICATED),
            /* retryable= */ false);
    StorageException seUnauthenticated =
        new StorageException(401, "Unauthenticated", apiExUnauthenticated);
    assertThat(StorageErrorTypeMapper.mapThrowable(seUnauthenticated)).isEqualTo("UNAUTHENTICATED");
  }

  @Test
  public void mapThrowable_storageExceptionCoalescedFromApiExceptions() {
    ApiException apiExAborted =
        new ApiException(
            new StatusRuntimeException(Status.ABORTED),
            GrpcStatusCode.of(Status.Code.ABORTED),
            /* retryable= */ false);
    ApiException apiExPrecondition =
        new ApiException(
            new StatusRuntimeException(Status.FAILED_PRECONDITION),
            GrpcStatusCode.of(Status.Code.FAILED_PRECONDITION),
            /* retryable= */ false);
    ApiException apiExOutOfRange =
        new ApiException(
            new StatusRuntimeException(Status.OUT_OF_RANGE),
            GrpcStatusCode.of(Status.Code.OUT_OF_RANGE),
            /* retryable= */ false);

    assertThat(StorageErrorTypeMapper.mapThrowable(StorageException.coalesce(apiExAborted)))
        .isEqualTo("ABORTED");
    assertThat(StorageErrorTypeMapper.mapThrowable(StorageException.coalesce(apiExPrecondition)))
        .isEqualTo("FAILED_PRECONDITION");
    assertThat(StorageErrorTypeMapper.mapThrowable(StorageException.coalesce(apiExOutOfRange)))
        .isEqualTo("OUT_OF_RANGE");
  }

  @Test
  public void mapThrowable_storageExceptionWrappingDirectGrpcStatusExceptions() {
    StorageException seFromStatusRuntime =
        new StorageException(
            500, "gRPC Status Runtime", new StatusRuntimeException(Status.ABORTED));
    assertThat(StorageErrorTypeMapper.mapThrowable(seFromStatusRuntime)).isEqualTo("ABORTED");

    StorageException seFromStatus =
        new StorageException(500, "gRPC Status", new StatusException(Status.FAILED_PRECONDITION));
    assertThat(StorageErrorTypeMapper.mapThrowable(seFromStatus)).isEqualTo("FAILED_PRECONDITION");
  }

  @Test
  public void mapThrowable_storageExceptionWrappingSocketResetException() {
    StorageException seFromSocketReset =
        new StorageException(0, "Socket Reset", new SocketException("Connection reset"));
    assertThat(StorageErrorTypeMapper.mapThrowable(seFromSocketReset))
        .isEqualTo("CONNECTION_RESET");
  }

  @Test
  public void mapThrowable_authExceptionWrappingDirectNetworkAndTimeoutCauses() {
    GoogleAuthException authTimeout =
        new GoogleAuthException("Auth timeout", new SocketTimeoutException("Read timed out"));
    assertThat(StorageErrorTypeMapper.mapThrowable(authTimeout)).isEqualTo("TIMEOUT");

    GoogleAuthException authDns =
        new GoogleAuthException(
            "Auth DNS failure", new UnknownHostException("oauth2.googleapis.com"));
    assertThat(StorageErrorTypeMapper.mapThrowable(authDns)).isEqualTo("DNS_FAILURE");

    GoogleAuthException authRefused =
        new GoogleAuthException("Auth connect refused", new ConnectException("Connection refused"));
    assertThat(StorageErrorTypeMapper.mapThrowable(authRefused)).isEqualTo("CONNECTION_REFUSED");

    GoogleAuthException authTls =
        new GoogleAuthException(
            "Auth TLS failed", new SSLHandshakeException("TLS handshake failed"));
    assertThat(StorageErrorTypeMapper.mapThrowable(authTls)).isEqualTo("TLS_FAILURE");
  }

  @Test
  public void mapThrowable_authExceptionWrappingNestedTimeoutCause() {
    GoogleAuthException nestedAuthTimeout =
        new GoogleAuthException(
            "Nested timeout", new IOException("IO failed", new SocketTimeoutException("timeout")));
    assertThat(StorageErrorTypeMapper.mapThrowable(nestedAuthTimeout)).isEqualTo("TIMEOUT");

    GoogleAuthException authTimeout =
        new GoogleAuthException("Auth timeout", new SocketTimeoutException("Read timed out"));
    StorageException se401WithTimeout = new StorageException(401, "Unauthorized", authTimeout);
    assertThat(StorageErrorTypeMapper.mapThrowable(se401WithTimeout)).isEqualTo("TIMEOUT");
  }

  @Test
  public void mapThrowable_authExceptionWithoutSpecificNetworkCauseMapsToAuthError() {
    GoogleAuthException simpleAuth = new GoogleAuthException("Invalid credentials");
    assertThat(StorageErrorTypeMapper.mapThrowable(simpleAuth)).isEqualTo("AUTHENTICATION_ERROR");

    GoogleAuthException authWithGenericIo =
        new GoogleAuthException("Grant error", new IOException("Invalid grant"));
    assertThat(StorageErrorTypeMapper.mapThrowable(authWithGenericIo))
        .isEqualTo("AUTHENTICATION_ERROR");
  }

  @Test
  public void mapThrowable_statusRuntimeExceptionWithNetworkCauses() {
    StatusRuntimeException sreDns =
        new StatusRuntimeException(
            Status.UNAVAILABLE.withCause(new UnknownHostException("storage.googleapis.com")));
    assertThat(StorageErrorTypeMapper.mapThrowable(sreDns)).isEqualTo("DNS_FAILURE");

    StatusRuntimeException sreTls =
        new StatusRuntimeException(
            Status.UNAVAILABLE.withCause(new SSLHandshakeException("TLS failed")));
    assertThat(StorageErrorTypeMapper.mapThrowable(sreTls)).isEqualTo("TLS_FAILURE");

    StatusRuntimeException sreRefused =
        new StatusRuntimeException(
            Status.UNAVAILABLE.withCause(new ConnectException("Connection refused")));
    assertThat(StorageErrorTypeMapper.mapThrowable(sreRefused)).isEqualTo("CONNECTION_REFUSED");

    StatusRuntimeException sreReset =
        new StatusRuntimeException(
            Status.UNAVAILABLE.withCause(new SocketException("Connection reset")));
    assertThat(StorageErrorTypeMapper.mapThrowable(sreReset)).isEqualTo("CONNECTION_RESET");

    StatusRuntimeException srePipe =
        new StatusRuntimeException(
            Status.UNAVAILABLE.withCause(new SocketException("Broken pipe")));
    assertThat(StorageErrorTypeMapper.mapThrowable(srePipe)).isEqualTo("CONNECTIVITY");
  }

  @Test
  public void mapThrowable_statusExceptionWithNetworkCauses() {
    StatusException seDns =
        new StatusException(
            Status.UNAVAILABLE.withCause(new UnknownHostException("storage.googleapis.com")));
    assertThat(StorageErrorTypeMapper.mapThrowable(seDns)).isEqualTo("DNS_FAILURE");

    StatusException seTls =
        new StatusException(Status.UNAVAILABLE.withCause(new SSLHandshakeException("TLS failed")));
    assertThat(StorageErrorTypeMapper.mapThrowable(seTls)).isEqualTo("TLS_FAILURE");
  }

  @Test
  public void mapThrowable_apiExceptionWithNetworkCauses() {
    StatusRuntimeException sreDns =
        new StatusRuntimeException(
            Status.UNAVAILABLE.withCause(new UnknownHostException("storage.googleapis.com")));
    ApiException apiExDns =
        new ApiException(
            sreDns, GrpcStatusCode.of(Status.Code.UNAVAILABLE), /* retryable= */ false);
    assertThat(StorageErrorTypeMapper.mapThrowable(apiExDns)).isEqualTo("DNS_FAILURE");

    ApiException apiExRefused =
        new ApiException(
            new ConnectException("Refused"),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            /* retryable= */ false);
    assertThat(StorageErrorTypeMapper.mapThrowable(apiExRefused)).isEqualTo("CONNECTION_REFUSED");
  }

  @Test
  public void mapThrowable_selfReferencingExceptionTerminates() {
    class SelfCausedExecutionException extends ExecutionException {
      @Override
      public synchronized Throwable getCause() {
        return this;
      }
    }
    assertThat(StorageErrorTypeMapper.mapThrowable(new SelfCausedExecutionException()))
        .isEqualTo("UNKNOWN");

    class SelfCausedCompletionException extends CompletionException {
      @Override
      public synchronized Throwable getCause() {
        return this;
      }
    }
    assertThat(StorageErrorTypeMapper.mapThrowable(new SelfCausedCompletionException()))
        .isEqualTo("UNKNOWN");
  }

  @Test
  public void mapThrowable_unknownFallback() {
    assertThat(StorageErrorTypeMapper.mapThrowable(new IllegalStateException("unexpected state")))
        .isEqualTo("UNKNOWN");
  }

  private static WatchdogTimeoutException createWatchdogTimeoutException() throws Exception {
    Constructor<WatchdogTimeoutException> ctor =
        WatchdogTimeoutException.class.getDeclaredConstructor(String.class, boolean.class);
    ctor.setAccessible(true);
    return ctor.newInstance("Watchdog timeout", /* retryable= */ true);
  }

  private static class GoogleAuthException extends RuntimeException {
    GoogleAuthException(String msg) {
      super(msg);
    }

    GoogleAuthException(String msg, Throwable cause) {
      super(msg, cause);
    }
  }

  private static final class CustomTokenException extends GoogleAuthException {
    CustomTokenException(String msg) {
      super(msg);
    }
  }

  private static class OAuth2Exception extends RuntimeException {
    OAuth2Exception(String msg) {
      super(msg);
    }
  }

  private static class AuthenticationException extends RuntimeException {
    AuthenticationException(String msg) {
      super(msg);
    }
  }

  private static final class AuthorNotFoundException extends RuntimeException {
    AuthorNotFoundException(String msg) {
      super(msg);
    }
  }
}
