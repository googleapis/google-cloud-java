/*
 * Copyright 2024 Google LLC
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

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.http.AuthHttpConstants;
import com.google.common.collect.ImmutableList;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.GrpcCapturingClientInterceptor;
import com.google.showcase.v1beta1.it.util.HttpJsonCapturingClientInterceptor;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm a client can be instantiated with API key credentials and correct
 * authorization sent via headers to back end
 */
class ITApiKeyCredentials {

  private static final String API_KEY = "fake_api_key";
  private static final String API_KEY_AUTH_HEADER = "x-goog-api-key";
  private static final String HTTP_RESPONSE_HEADER_STRING =
      "x-showcase-request-" + API_KEY_AUTH_HEADER;
  private static final String GRPC_ENDPOINT = "localhost:7469";
  private static final String HTTP_ENDPOINT = "http://localhost:7469";

  private static HttpJsonCapturingClientInterceptor httpJsonInterceptor;
  private static EchoClient grpcClient;
  private static EchoClient httpJsonClient;
  private static GrpcCapturingClientInterceptor grpcInterceptor;

  @BeforeEach
  void setup() throws IOException {
    grpcInterceptor = new GrpcCapturingClientInterceptor();
    httpJsonInterceptor = new HttpJsonCapturingClientInterceptor();
  }

  @AfterEach
  void tearDown() throws InterruptedException {
    if (httpJsonClient != null) {
      httpJsonClient.close();
      httpJsonClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
    if (grpcClient != null) {
      grpcClient.close();
      grpcClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testCreateGrpcClient_withApiKey_sendsApiHeaderToServer() throws IOException {
    Metadata.Key<String> apiKeyAuthHeader =
        Metadata.Key.of(API_KEY_AUTH_HEADER, Metadata.ASCII_STRING_MARSHALLER);
    Metadata.Key<String> defaultAuthorizationHeader =
        Metadata.Key.of(AuthHttpConstants.AUTHORIZATION, Metadata.ASCII_STRING_MARSHALLER);
    EchoSettings.Builder echoBuilder =
        EchoSettings.newBuilder()
            .setApiKey(API_KEY)
            .setEndpoint(GRPC_ENDPOINT)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .setInterceptorProvider(() -> ImmutableList.of(grpcInterceptor))
                    .build());
    EchoSettings settings = echoBuilder.build();
    grpcClient = EchoClient.create(settings);

    grpcClient.echo(EchoRequest.newBuilder().build());

    assertThat(echoBuilder.getApiKey()).isEqualTo(API_KEY);
    assertThat(settings.getApiKey()).isEqualTo(API_KEY);
    String headerValue = grpcInterceptor.metadata.get(apiKeyAuthHeader);
    assertThat(headerValue).isEqualTo(API_KEY);
    String defaultAuthorizationHeaderValue =
        grpcInterceptor.metadata.get(defaultAuthorizationHeader);
    assertThat(defaultAuthorizationHeaderValue).isNull();
  }

  @Test
  void testCreateGrpcClient_withApiKeySetViaSetterAndHeader_dedupsHeader() throws IOException {
    String apiHeaderKey = "fake_api_key_2";
    Metadata.Key<String> apiKeyAuthHeader =
        Metadata.Key.of(API_KEY_AUTH_HEADER, Metadata.ASCII_STRING_MARSHALLER);
    Metadata.Key<String> defaultAuthorizationHeader =
        Metadata.Key.of(AuthHttpConstants.AUTHORIZATION, Metadata.ASCII_STRING_MARSHALLER);
    Map<String, String> header =
        new HashMap<String, String>() {
          {
            put(API_KEY_AUTH_HEADER, apiHeaderKey);
          }
        };
    FixedHeaderProvider headerProvider = FixedHeaderProvider.create(header);

    TransportChannelProvider transportChannelProvider =
        EchoSettings.defaultGrpcTransportProviderBuilder()
            .setHeaderProvider(headerProvider)
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setInterceptorProvider(() -> ImmutableList.of(grpcInterceptor))
            .build();
    EchoSettings settings =
        EchoSettings.newBuilder()
            .setApiKey(API_KEY)
            .setEndpoint(GRPC_ENDPOINT)
            .setTransportChannelProvider(transportChannelProvider)
            .build();
    grpcClient = EchoClient.create(settings);

    grpcClient.echo(EchoRequest.newBuilder().build());

    Iterable<String> matchingHeaders = grpcInterceptor.metadata.getAll(apiKeyAuthHeader);
    List<String> matchingHeadersList =
        StreamSupport.stream(matchingHeaders.spliterator(), false).collect(Collectors.toList());

    String headerValue = matchingHeadersList.get(0);
    assertThat(headerValue).isEqualTo(API_KEY);
    assertThat(matchingHeadersList.size()).isEqualTo(1);
  }

  @Test
  void testCreateHttpClient_withApiKey_sendsApiHeaderToServer() throws Exception {
    EchoSettings httpJsonEchoSettings =
        EchoSettings.newHttpJsonBuilder()
            .setApiKey(API_KEY)
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(HTTP_ENDPOINT)
                    .setInterceptorProvider(() -> ImmutableList.of(httpJsonInterceptor))
                    .build())
            .build();
    httpJsonClient = EchoClient.create(httpJsonEchoSettings);

    httpJsonClient.echo(EchoRequest.newBuilder().build());

    ArrayList<String> headerValues =
        (ArrayList<String>)
            httpJsonInterceptor.metadata.getHeaders().get(HTTP_RESPONSE_HEADER_STRING);
    String headerValue = headerValues.get(0);
    assertThat(headerValue).isEqualTo(API_KEY);
  }

  @Test
  void testCreateHttpClient_withApiKeySetViaSetterAndHeader_dedupsHeader() throws Exception {
    String apiHeaderKey = "fake_api_key_2";
    Metadata.Key<String> apiKeyAuthHeader =
        Metadata.Key.of(API_KEY_AUTH_HEADER, Metadata.ASCII_STRING_MARSHALLER);
    Metadata.Key<String> defaultAuthorizationHeader =
        Metadata.Key.of(AuthHttpConstants.AUTHORIZATION, Metadata.ASCII_STRING_MARSHALLER);
    Map<String, String> header =
        new HashMap<String, String>() {
          {
            put(API_KEY_AUTH_HEADER, apiHeaderKey);
          }
        };
    FixedHeaderProvider headerProvider = FixedHeaderProvider.create(header);

    TransportChannelProvider transportChannelProvider =
        EchoSettings.defaultHttpJsonTransportProviderBuilder()
            .setHeaderProvider(headerProvider)
            .setInterceptorProvider(() -> ImmutableList.of(httpJsonInterceptor))
            .build();
    EchoSettings httpJsonEchoSettings =
        EchoSettings.newHttpJsonBuilder()
            .setApiKey(API_KEY)
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(HTTP_ENDPOINT)
                    .setInterceptorProvider(() -> ImmutableList.of(httpJsonInterceptor))
                    .build())
            .build();
    httpJsonClient = EchoClient.create(httpJsonEchoSettings);

    httpJsonClient.echo(EchoRequest.newBuilder().build());

    ArrayList<String> headerValues =
        (ArrayList<String>)
            httpJsonInterceptor.metadata.getHeaders().get(HTTP_RESPONSE_HEADER_STRING);
    String headerValue = headerValues.get(0);
    assertThat(headerValue).isEqualTo(API_KEY);
    assertThat(headerValues.size()).isEqualTo(1);
  }
}
