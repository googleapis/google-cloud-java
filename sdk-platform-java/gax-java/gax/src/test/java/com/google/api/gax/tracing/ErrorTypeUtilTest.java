/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.tracing;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLHandshakeException;
import org.junit.jupiter.api.Test;

class ErrorTypeUtilTest {

  @Test
  void testExtractErrorType_apiException_noReason() {
    ApiException exception =
        new ApiException(
            "fake_error", null, new FakeStatusCode(StatusCode.Code.INVALID_ARGUMENT), false);
    assertThat(ErrorTypeUtil.extractErrorType(exception))
        .isEqualTo(StatusCode.Code.INVALID_ARGUMENT.toString());
  }

  @Test
  void testExtractErrorType_realSocketTimeoutException() throws Exception {
    try (ServerSocket serverSocket = new ServerSocket(0)) {
      int port = serverSocket.getLocalPort();
      try (Socket clientSocket = new Socket()) {
        clientSocket.connect(new InetSocketAddress("localhost", port), 1000);
        clientSocket.setSoTimeout(10); // 10ms read timeout
        clientSocket.getInputStream().read();
        org.junit.jupiter.api.Assertions.fail("Expected SocketTimeoutException");
      } catch (Exception e) {
        assertThat(e).isInstanceOf(SocketTimeoutException.class);
        assertThat(ErrorTypeUtil.extractErrorType(e))
            .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_TIMEOUT.toString());
      }
    }
  }

  @Test
  void testExtractErrorType_realConnectException() {
    try {
      try (ServerSocket tempServer = new ServerSocket(0)) {
        int freePort = tempServer.getLocalPort();
        tempServer.close();
        new Socket("localhost", freePort);
      }
      org.junit.jupiter.api.Assertions.fail("Expected ConnectException");
    } catch (Exception e) {
      assertThat(e).isInstanceOf(ConnectException.class);
      assertThat(ErrorTypeUtil.extractErrorType(e))
          .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_CONNECTION_ERROR.toString());
    }
  }

  @Test
  void testExtractErrorType_realUnknownHostException() {
    try {
      new Socket("this.host.does.not.exist.invalid", 80);
      org.junit.jupiter.api.Assertions.fail("Expected UnknownHostException");
    } catch (Exception e) {
      assertThat(e).isInstanceOf(UnknownHostException.class);
      assertThat(ErrorTypeUtil.extractErrorType(e))
          .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_CONNECTION_ERROR.toString());
    }
  }

  @Test
  void testExtractErrorType_realSSLHandshakeException() throws Exception {
    // Emulating a reliable SSLHandshakeException (vs a generic SSLException) requires
    // complex keystore setups which are brittle. We instantiate it directly here.
    assertThat(
            ErrorTypeUtil.extractErrorType(new SSLHandshakeException("Cert path building failed")))
        .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_CONNECTION_ERROR.toString());
  }

  @Test
  void testExtractErrorType_realBindException() throws Exception {
    try (ServerSocket serverSocket1 = new ServerSocket(0)) {
      int port = serverSocket1.getLocalPort();
      try (ServerSocket serverSocket2 = new ServerSocket(port)) {
        org.junit.jupiter.api.Assertions.fail("Expected BindException");
      } catch (Exception e) {
        assertThat(e).isInstanceOf(BindException.class);
        assertThat(ErrorTypeUtil.extractErrorType(e))
            .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_CONNECTION_ERROR.toString());
      }
    }
  }

  @Test
  void testExtractErrorType_clientTimeout_others() {
    assertThat(
            ErrorTypeUtil.extractErrorType(
                new DeadlineExceededException(
                    "timeout", null, new FakeStatusCode(StatusCode.Code.DEADLINE_EXCEEDED), false)))
        .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED.toString());
  }

  @Test
  void testExtractErrorType_clientAuthenticationError() {
    assertThat(ErrorTypeUtil.extractErrorType(new GeneralSecurityException("auth fail")))
        .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_AUTHENTICATION_ERROR.toString());
  }

  @Test
  void testExtractErrorType_clientRequestError() {
    assertThat(ErrorTypeUtil.extractErrorType(new IllegalArgumentException()))
        .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_REQUEST_ERROR.toString());
  }

  @Test
  void testExtractErrorType_fallbackToSimpleName() {
    assertThat(ErrorTypeUtil.extractErrorType(new NullPointerException()))
        .isEqualTo("NullPointerException");
    assertThat(ErrorTypeUtil.extractErrorType(new IllegalStateException()))
        .isEqualTo("IllegalStateException");
  }

  @Test
  void testExtractErrorType_otherNetworkErrors() {
    assertThat(ErrorTypeUtil.extractErrorType(new NoRouteToHostException()))
        .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_CONNECTION_ERROR.toString());
  }

  @Test
  void testExtractErrorType_noCauseChainTraversal() {
    Exception root = new ConnectException("refused");
    Exception wrapped = new IOException("io fail", root);
    assertThat(ErrorTypeUtil.extractErrorType(wrapped)).isEqualTo("IOException");
  }

  @Test
  void testExtractErrorType_unknownException() {
    assertThat(ErrorTypeUtil.extractErrorType(new Exception("Unknown stuff")))
        .isEqualTo("Exception");
  }

  @Test
  void testExtractErrorType_redirectFallback() {
    assertThat(ErrorTypeUtil.extractErrorType(new Exception("redirect"))).isEqualTo("Exception");
  }

  @Test
  void testExtractErrorType_unknownClassNameFallback() {
    class UnknownClientException extends Exception {}
    assertThat(ErrorTypeUtil.extractErrorType(new UnknownClientException()))
        .isEqualTo("UnknownClientException");
  }

  @Test
  void testExtractErrorType_uncheckedExecutionException_unwraps() {
    Exception cause = new SocketTimeoutException("timeout");
    Exception wrapper = new UncheckedExecutionException(cause);
    assertThat(ErrorTypeUtil.extractErrorType(wrapper))
        .isEqualTo(ErrorTypeUtil.ErrorType.CLIENT_TIMEOUT.toString());
  }
}
