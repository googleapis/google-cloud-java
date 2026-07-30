/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.TypeRegistry;
import com.google.protobuf.util.JsonFormat;
import com.google.rpc.BadRequest;
import com.google.rpc.DebugInfo;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Help;
import com.google.rpc.LocalizedMessage;
import com.google.rpc.PreconditionFailure;
import com.google.rpc.QuotaFailure;
import com.google.rpc.RequestInfo;
import com.google.rpc.ResourceInfo;
import com.google.rpc.RetryInfo;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.FailEchoWithDetailsRequest;
import com.google.showcase.v1beta1.PoetryError;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Integration tests for verifying that client libraries correctly propagate and deserialize
 * standard and custom error details from {@link ApiException} over gRPC and HTTP/JSON transports.
 */
class ITErrorDetails {

  private static EchoClient grpcClient;
  private static EchoClient httpjsonClient;

  @BeforeAll
  static void createClients() throws Exception {
    grpcClient = TestClientInitializer.createGrpcEchoClient();
    httpjsonClient = TestClientInitializer.createHttpJsonEchoClient();
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    grpcClient.close();
    httpjsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  /**
   * Helper method to verify the content of error details. Transport-neutral validation of standard
   * and custom error packets.
   */
  private void verifyErrorDetailsContent(ErrorDetails errorDetails, String expectedPoem) {
    // Verify standard error details are present and populated
    // We are assuming that the mock server's hardcoded return values will stay the same
    // https://github.com/googleapis/gapic-showcase/blob/b6c247f153369044d599969f6929ecdeb066c4c6/server/services/echo_service.go
    ErrorInfo errorInfo = errorDetails.getErrorInfo();
    assertThat(errorInfo).isNotNull();
    assertThat(errorInfo.getReason()).isEqualTo("some ErrorInfo reason");

    RetryInfo retryInfo = errorDetails.getRetryInfo();
    assertThat(retryInfo).isNotNull();
    assertThat(retryInfo.getRetryDelay().getSeconds()).isEqualTo(11);

    DebugInfo debugInfo = errorDetails.getDebugInfo();
    assertThat(debugInfo).isNotNull();
    assertThat(debugInfo.getDetail()).isEqualTo("a DebugInfo detail");

    QuotaFailure quotaFailure = errorDetails.getQuotaFailure();
    assertThat(quotaFailure).isNotNull();
    assertThat(quotaFailure.getViolations(0).getDescription())
        .isEqualTo("First QuotaFailure description");

    PreconditionFailure preconditionFailure = errorDetails.getPreconditionFailure();
    assertThat(preconditionFailure).isNotNull();
    assertThat(preconditionFailure.getViolations(0).getDescription())
        .isEqualTo("First PreconditionFailure description");

    BadRequest badRequest = errorDetails.getBadRequest();
    assertThat(badRequest).isNotNull();
    assertThat(badRequest.getFieldViolations(0).getDescription())
        .isEqualTo("First BadRequest description");

    RequestInfo requestInfo = errorDetails.getRequestInfo();
    assertThat(requestInfo).isNotNull();
    assertThat(requestInfo.getRequestId()).isEqualTo("RequestInfo: showcase-request-id");
    assertThat(requestInfo.getServingData()).isEqualTo("RequestInfo: showcase serving data");

    ResourceInfo resourceInfo = errorDetails.getResourceInfo();
    assertThat(resourceInfo).isNotNull();
    assertThat(resourceInfo.getResourceType()).isEqualTo("ResourceInfo: showcase resource");

    Help help = errorDetails.getHelp();
    assertThat(help).isNotNull();
    assertThat(help.getLinks(0).getDescription()).isEqualTo("Help: first showcase help link");

    LocalizedMessage localizedMessage = errorDetails.getLocalizedMessage();
    assertThat(localizedMessage).isNotNull();
    assertThat(localizedMessage.getLocale()).isEqualTo("fr-CH");
    assertThat(localizedMessage.getMessage())
        .isEqualTo("This LocalizedMessage should be treated specially");

    // Verify custom PoetryError can be unpacked and matches expected poem
    PoetryError poetryError = errorDetails.getMessage(PoetryError.class);
    assertThat(poetryError).isNotNull();
    assertThat(poetryError.getPoem()).isEqualTo(expectedPoem);
  }

  // Verifies error details are correctly propagated and unpacked over standard gRPC protocol
  @Test
  void testGrpc_failEchoWithDetails() {
    FailEchoWithDetailsRequest request = FailEchoWithDetailsRequest.newBuilder().build();
    ApiException exception =
        assertThrows(ApiException.class, () -> grpcClient.failEchoWithDetails(request));

    assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.ABORTED);
    assertThat(exception.getErrorDetails()).isNotNull();

    // Reuse Transport-neutral Validation
    verifyErrorDetailsContent(exception.getErrorDetails(), "roses are red");
  }

  // Verifies custom Error Details messages reflect user-defined inputs via gRPC
  @Test
  void testGrpc_failEchoWithDetails_customMessage() {
    String customMessage = "this is a custom message to echo back";
    FailEchoWithDetailsRequest request =
        FailEchoWithDetailsRequest.newBuilder().setMessage(customMessage).build();
    ApiException exception =
        assertThrows(ApiException.class, () -> grpcClient.failEchoWithDetails(request));

    assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.ABORTED);
    assertThat(exception.getErrorDetails()).isNotNull();

    // Reuse Transport-neutral Validation
    verifyErrorDetailsContent(exception.getErrorDetails(), customMessage);
  }

  // Verifies error details are accessible in raw form over REST/HTTP and validates manually-parsed
  // decompression
  @Test
  void testHttpJson_failEchoWithDetails() throws Exception {
    FailEchoWithDetailsRequest request = FailEchoWithDetailsRequest.newBuilder().build();
    ApiException exception =
        assertThrows(ApiException.class, () -> httpjsonClient.failEchoWithDetails(request));
    assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.ABORTED);

    // GAX HTTP/JSON parser limitation: Because the response contains a custom/unregistered type
    // (PoetryError) in the Any details list, HttpJsonErrorParser fails to parse the status payload,
    // resulting in empty ErrorDetails (where getErrorInfo() returns null).
    // Note: Standard Google Cloud services follow AIP-193 error details (ErrorInfo, RetryInfo, etc.)
    // and do not use custom error payload types like PoetryError.
    ErrorDetails errorDetails = exception.getErrorDetails();
    if (errorDetails != null) {
      assertThat(errorDetails.getErrorInfo()).isNull();
    }

    // Workaround REST limitation: Parse the raw HTTP JSON error response manually using a custom
    // TypeRegistry that registers standard types plus the showcase-specific PoetryError type.
    // This mimics the behavior of HttpJsonErrorParser, which currently does not support passing in
    // a custom TypeRegistry.
    assertThat(exception.getCause()).isInstanceOf(HttpResponseException.class);
    HttpResponseException httpException = (HttpResponseException) exception.getCause();
    String errorJson = httpException.getContent();
    assertThat(errorJson).isNotNull();

    TypeRegistry typeRegistry =
        TypeRegistry.newBuilder()
            .add(ErrorInfo.getDescriptor())
            .add(RetryInfo.getDescriptor())
            .add(DebugInfo.getDescriptor())
            .add(QuotaFailure.getDescriptor())
            .add(PreconditionFailure.getDescriptor())
            .add(BadRequest.getDescriptor())
            .add(RequestInfo.getDescriptor())
            .add(ResourceInfo.getDescriptor())
            .add(Help.getDescriptor())
            .add(LocalizedMessage.getDescriptor())
            .add(PoetryError.getDescriptor())
            .build();
    JsonFormat.Parser jsonParser =
        JsonFormat.parser().ignoringUnknownFields().usingTypeRegistry(typeRegistry);

    // Parse the AIP-193 "error" JSON object into a status builder
    JsonObject root = JsonParser.parseString(errorJson).getAsJsonObject();
    JsonObject errorObj = root.getAsJsonObject("error");
    Status.Builder statusBuilder = Status.newBuilder();
    jsonParser.merge(errorObj.toString(), statusBuilder);
    Status status = statusBuilder.build();

    // Verify we can successfully unpack the details from our custom status instance
    ErrorDetails parsedDetails =
        ErrorDetails.builder().setRawErrorMessages(status.getDetailsList()).build();

    // Reuse Transport-neutral Validation!
    verifyErrorDetailsContent(parsedDetails, "roses are red");
  }
}
