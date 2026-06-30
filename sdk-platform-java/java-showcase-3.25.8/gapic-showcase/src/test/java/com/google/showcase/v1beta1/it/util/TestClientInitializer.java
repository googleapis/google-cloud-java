/*
 * Copyright 2023 Google LLC
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

package com.google.showcase.v1beta1.it.util;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.HttpJsonClientInterceptor;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.common.collect.ImmutableList;
import com.google.showcase.v1beta1.ComplianceClient;
import com.google.showcase.v1beta1.ComplianceSettings;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.IdentityClient;
import com.google.showcase.v1beta1.IdentitySettings;
import com.google.showcase.v1beta1.WaitRequest;
import com.google.showcase.v1beta1.stub.EchoStub;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import java.util.List;
import java.util.Set;

public class TestClientInitializer {

  public static final int AWAIT_TERMINATION_SECONDS = 10;

  // gRPC's endpoint must follow the format of {host}:{port}
  public static final String DEFAULT_GRPC_ENDPOINT = "localhost:7469";
  // httpjson's endpoint uses `https://` by default if the scheme is not specified
  // local test requires `http://` as not SSL/TLS has been set up for showcase
  public static final String DEFAULT_HTTPJSON_ENDPOINT = "http://localhost:7469";

  public static EchoClient createGrpcEchoClient() throws Exception {
    return createGrpcEchoClient(ImmutableList.of());
  }

  public static EchoClient createGrpcEchoClient(List<ClientInterceptor> interceptorList)
      throws Exception {
    EchoSettings grpcEchoSettings =
        EchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .setInterceptorProvider(() -> interceptorList)
                    .build())
            .setEndpoint(DEFAULT_GRPC_ENDPOINT)
            .build();
    return EchoClient.create(grpcEchoSettings);
  }

  public static EchoClient createGrpcEchoClientWithRetrySettings(
      RetrySettings retrySettings,
      Set<StatusCode.Code> retryableCodes,
      List<ClientInterceptor> interceptorList)
      throws Exception {
    EchoStubSettings.Builder grpcEchoSettingsBuilder = EchoStubSettings.newBuilder();
    grpcEchoSettingsBuilder
        .echoSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(retryableCodes);
    EchoSettings grpcEchoSettings = EchoSettings.create(grpcEchoSettingsBuilder.build());
    grpcEchoSettings =
        grpcEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .setInterceptorProvider(() -> interceptorList)
                    .build())
            .setEndpoint(DEFAULT_GRPC_ENDPOINT)
            .build();
    return EchoClient.create(grpcEchoSettings);
  }

  public static EchoClient createHttpJsonEchoClient() throws Exception {
    return createHttpJsonEchoClient(ImmutableList.of());
  }

  public static EchoClient createHttpJsonEchoClient(List<HttpJsonClientInterceptor> interceptorList)
      throws Exception {
    EchoSettings httpJsonEchoSettings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
                    .setInterceptorProvider(() -> interceptorList)
                    .build())
            .build();
    return EchoClient.create(httpJsonEchoSettings);
  }

  public static EchoClient createHttpJsonEchoClientWithRetrySettings(
      RetrySettings retrySettings,
      Set<StatusCode.Code> retryableCodes,
      List<HttpJsonClientInterceptor> interceptorList)
      throws Exception {
    EchoStubSettings.Builder httpJsonEchoSettingsBuilder = EchoStubSettings.newHttpJsonBuilder();
    httpJsonEchoSettingsBuilder
        .echoSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(retryableCodes);
    EchoSettings httpJsonEchoSettings = EchoSettings.create(httpJsonEchoSettingsBuilder.build());
    httpJsonEchoSettings =
        httpJsonEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setInterceptorProvider(() -> interceptorList)
                    .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();
    return EchoClient.create(httpJsonEchoSettings);
  }

  public static EchoClient createGrpcEchoClientCustomBlockSettings(
      RetrySettings retrySettings, Set<StatusCode.Code> retryableCodes) throws Exception {
    EchoStubSettings.Builder grpcEchoSettingsBuilder = EchoStubSettings.newBuilder();
    grpcEchoSettingsBuilder
        .blockSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(retryableCodes);
    EchoSettings grpcEchoSettings = EchoSettings.create(grpcEchoSettingsBuilder.build());
    grpcEchoSettings =
        grpcEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint(DEFAULT_GRPC_ENDPOINT)
            .build();
    return EchoClient.create(grpcEchoSettings);
  }

  public static EchoClient createHttpJsonEchoClientCustomBlockSettings(
      RetrySettings retrySettings, Set<StatusCode.Code> retryableCodes) throws Exception {
    EchoStubSettings.Builder httpJsonEchoSettingsBuilder = EchoStubSettings.newHttpJsonBuilder();
    httpJsonEchoSettingsBuilder
        .blockSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(retryableCodes);
    EchoSettings httpJsonEchoSettings = EchoSettings.create(httpJsonEchoSettingsBuilder.build());
    httpJsonEchoSettings =
        httpJsonEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();
    return EchoClient.create(httpJsonEchoSettings);
  }

  public static EchoClient createGrpcEchoClientCustomWaitSettings(
      RetrySettings initialUnaryRetrySettings, RetrySettings pollingRetrySettings)
      throws Exception {
    EchoStubSettings.Builder grpcEchoSettingsBuilder = EchoStubSettings.newBuilder();
    grpcEchoSettingsBuilder
        .waitOperationSettings()
        .setInitialCallSettings(
            UnaryCallSettings.<WaitRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                .setRetrySettings(initialUnaryRetrySettings)
                .build())
        .setPollingAlgorithm(OperationTimedPollAlgorithm.create(pollingRetrySettings));
    EchoSettings grpcEchoSettings = EchoSettings.create(grpcEchoSettingsBuilder.build());
    grpcEchoSettings =
        grpcEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint(DEFAULT_GRPC_ENDPOINT)
            .build();
    return EchoClient.create(grpcEchoSettings);
  }

  public static EchoClient createHttpJsonEchoClientCustomWaitSettings(
      RetrySettings initialUnaryRetrySettings, RetrySettings pollingRetrySettings)
      throws Exception {
    EchoStubSettings.Builder httpJsonEchoSettingsBuilder = EchoStubSettings.newHttpJsonBuilder();
    httpJsonEchoSettingsBuilder
        .waitOperationSettings()
        .setInitialCallSettings(
            UnaryCallSettings.<WaitRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                .setRetrySettings(initialUnaryRetrySettings)
                .build())
        .setPollingAlgorithm(OperationTimedPollAlgorithm.create(pollingRetrySettings));
    EchoSettings httpJsonEchoSettings = EchoSettings.create(httpJsonEchoSettingsBuilder.build());
    httpJsonEchoSettings =
        httpJsonEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();
    return EchoClient.create(httpJsonEchoSettings);
  }

  public static IdentityClient createGrpcIdentityClient() throws Exception {
    IdentitySettings grpcIdentitySettings =
        IdentitySettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                IdentitySettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint(DEFAULT_GRPC_ENDPOINT)
            .build();
    return IdentityClient.create(grpcIdentitySettings);
  }

  public static IdentityClient createHttpJsonIdentityClient() throws Exception {
    IdentitySettings httpjsonIdentitySettings =
        IdentitySettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();
    return IdentityClient.create(httpjsonIdentitySettings);
  }

  // Create grpcComplianceClient with Interceptor
  public static ComplianceClient createGrpcComplianceClient(List<ClientInterceptor> interceptorList)
      throws Exception {
    ComplianceSettings grpcComplianceSettings =
        ComplianceSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                ComplianceSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .setInterceptorProvider(() -> interceptorList)
                    .build())
            .setEndpoint(DEFAULT_GRPC_ENDPOINT)
            .build();
    return ComplianceClient.create(grpcComplianceSettings);
  }

  public static ComplianceClient createHttpJsonComplianceClient(
      List<HttpJsonClientInterceptor> interceptorList) throws Exception {
    ComplianceSettings httpJsonComplianceSettings =
        ComplianceSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
                    .setInterceptorProvider(() -> interceptorList)
                    .build())
            .build();
    return ComplianceClient.create(httpJsonComplianceSettings);
  }

  public static EchoClient createGrpcEchoClientOpentelemetry(ApiTracerFactory metricsTracerFactory)
      throws Exception {
    return createGrpcEchoClientOpentelemetry(
        metricsTracerFactory,
        EchoSettings.defaultGrpcTransportProviderBuilder()
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .build());
  }

  public static EchoClient createGrpcEchoClientOpentelemetry(
      ApiTracerFactory metricsTracerFactory, TransportChannelProvider transportChannelProvider)
      throws Exception {
    EchoSettings grpcEchoSettings =
        EchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(transportChannelProvider)
            .setEndpoint(DEFAULT_GRPC_ENDPOINT)
            .build();

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            grpcEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(metricsTracerFactory)
                .build();
    EchoStub stub = echoStubSettings.createStub();

    return EchoClient.create(stub);
  }

  public static EchoClient createHttpJsonEchoClientOpentelemetry(
      ApiTracerFactory metricsTracerFactory) throws Exception {

    EchoSettings httpJsonEchoSettings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
                    .build())
            .build();

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(metricsTracerFactory)
                .build();
    EchoStub stub = echoStubSettings.createStub();

    return EchoClient.create(stub);
  }
}
