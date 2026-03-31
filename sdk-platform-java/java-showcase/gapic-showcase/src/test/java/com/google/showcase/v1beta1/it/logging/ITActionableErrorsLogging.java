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

package com.google.showcase.v1beta1.it.logging;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.logging.TestLogger;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.tracing.LoggingTracerFactory;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

public class ITActionableErrorsLogging {

  private static EchoClient grpcClient;
  private static EchoClient httpjsonClient;
  private TestLogger testLogger;

  @BeforeAll
  static void createClients() throws Exception {
    grpcClient =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(new LoggingTracerFactory());
    httpjsonClient =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetry(new LoggingTracerFactory());
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    grpcClient.close();
    httpjsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @BeforeEach
  void setupTestLogger() {
    testLogger = (TestLogger) LoggerFactory.getLogger("com.google.api.gax.tracing.LoggingTracer");
    testLogger.getMessageList().clear();
    testLogger.getKeyValuePairsMap().clear();
  }

  private EchoRequest buildErrorRequest() {
    ErrorInfo errorInfo =
        ErrorInfo.newBuilder()
            .setReason("TEST_REASON")
            .setDomain("test.googleapis.com")
            .putMetadata("test_metadata", "test_value")
            .build();
    Status status =
        Status.newBuilder()
            .setCode(3) // INVALID_ARGUMENT
            .setMessage("This is a test error")
            .addDetails(Any.pack(errorInfo))
            .build();
    return EchoRequest.newBuilder().setError(status).build();
  }

  @Test
  void testGrpc_actionableErrorLogged() {
    EchoRequest request = buildErrorRequest();

    assertThrows(ApiException.class, () -> grpcClient.echo(request));

    assertThat(testLogger.getMessageList().size()).isAtLeast(1);
    String loggedMessage = testLogger.getMessageList().get(testLogger.getMessageList().size() - 1);

    assertThat(loggedMessage).contains("This is a test error");

    Map<String, Object> kvps = testLogger.getKeyValuePairsMap();
    assertThat(kvps).containsEntry("rpc.system.name", "grpc");
    assertThat(kvps).containsEntry("rpc.method", "google.showcase.v1beta1.Echo/Echo");
    assertThat(kvps).containsEntry("rpc.response.status_code", "INVALID_ARGUMENT");
    assertThat(kvps).containsEntry("error.type", "TEST_REASON");
    assertThat(kvps).containsEntry("gcp.errors.domain", "test.googleapis.com");
    assertThat(kvps).containsEntry("gcp.errors.metadata.test_metadata", "test_value");
  }

  @Test
  void testHttpJson_actionableErrorLogged() throws Exception {
    // The gapic-showcase server currently returns text/plain for failEchoWithDetails instead of
    // JSON.
    // Additionally, sending an ErrorInfo in a request over REST fails serialization.
    // To test HTTP JSON actionable errors logic, we use a MockHttpTransport that simulates the
    // correct JSON format.
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(409); // ABORTED
                response.setContentType("application/json");
                String jsonError =
                    "{\n"
                        + "  \"error\": {\n"
                        + "    \"code\": 409,\n"
                        + "    \"message\": \"This is a mock JSON error generated by the server\",\n"
                        + "    \"status\": \"ABORTED\",\n"
                        + "    \"details\": [\n"
                        + "      {\n"
                        + "        \"@type\": \"type.googleapis.com/google.rpc.ErrorInfo\",\n"
                        + "        \"reason\": \"mock_error_reason\",\n"
                        + "        \"domain\": \"mock.googleapis.com\",\n"
                        + "        \"metadata\": {\"mock_key\": \"mock_value\"}\n"
                        + "      }\n"
                        + "    ]\n"
                        + "  }\n"
                        + "}";
                response.setContent(jsonError);
                return response;
              }
            };
          }
        };

    EchoSettings httpJsonEchoSettings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockTransport)
                    .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();

    com.google.showcase.v1beta1.stub.EchoStubSettings echoStubSettings =
        (com.google.showcase.v1beta1.stub.EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(new LoggingTracerFactory())
                .build();
    com.google.showcase.v1beta1.stub.EchoStub stub = echoStubSettings.createStub();
    EchoClient mockHttpJsonClient = EchoClient.create(stub);

    EchoRequest request = EchoRequest.newBuilder().build();

    assertThrows(ApiException.class, () -> mockHttpJsonClient.echo(request));

    assertThat(testLogger.getMessageList().size()).isAtLeast(1);
    String loggedMessage = testLogger.getMessageList().get(testLogger.getMessageList().size() - 1);

    assertThat(loggedMessage).contains("This is a mock JSON error generated by the server");

    Map<String, Object> kvps = testLogger.getKeyValuePairsMap();
    assertThat(kvps).containsEntry("rpc.system.name", "http");
    assertThat(kvps).containsEntry("http.request.method", "POST");
    assertThat(kvps).containsEntry("url.template", "v1beta1/echo:echo");
    assertThat(kvps).containsEntry("rpc.response.status_code", "ABORTED");
    assertThat(kvps).containsEntry("error.type", "mock_error_reason");
    assertThat(kvps).containsEntry("gcp.errors.domain", "mock.googleapis.com");
    assertThat(kvps).containsEntry("gcp.errors.metadata.mock_key", "mock_value");

    mockHttpJsonClient.close();
    mockHttpJsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }
}
