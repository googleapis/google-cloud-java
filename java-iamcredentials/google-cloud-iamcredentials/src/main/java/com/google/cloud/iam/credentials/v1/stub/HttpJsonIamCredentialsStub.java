/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.iam.credentials.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest;
import com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse;
import com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest;
import com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse;
import com.google.cloud.iam.credentials.v1.SignBlobRequest;
import com.google.cloud.iam.credentials.v1.SignBlobResponse;
import com.google.cloud.iam.credentials.v1.SignJwtRequest;
import com.google.cloud.iam.credentials.v1.SignJwtResponse;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the IAMCredentials service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonIamCredentialsStub extends IamCredentialsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenMethodDescriptor =
          ApiMethodDescriptor.<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
              .setFullMethodName("google.iam.credentials.v1.IAMCredentials/GenerateAccessToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAccessTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/serviceAccounts/*}:generateAccessToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateAccessTokenResponse>newBuilder()
                      .setDefaultInstance(GenerateAccessTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateIdTokenRequest, GenerateIdTokenResponse>
      generateIdTokenMethodDescriptor =
          ApiMethodDescriptor.<GenerateIdTokenRequest, GenerateIdTokenResponse>newBuilder()
              .setFullMethodName("google.iam.credentials.v1.IAMCredentials/GenerateIdToken")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateIdTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/serviceAccounts/*}:generateIdToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateIdTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateIdTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateIdTokenResponse>newBuilder()
                      .setDefaultInstance(GenerateIdTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SignBlobRequest, SignBlobResponse>
      signBlobMethodDescriptor =
          ApiMethodDescriptor.<SignBlobRequest, SignBlobResponse>newBuilder()
              .setFullMethodName("google.iam.credentials.v1.IAMCredentials/SignBlob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SignBlobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/serviceAccounts/*}:signBlob",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SignBlobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SignBlobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SignBlobResponse>newBuilder()
                      .setDefaultInstance(SignBlobResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SignJwtRequest, SignJwtResponse>
      signJwtMethodDescriptor =
          ApiMethodDescriptor.<SignJwtRequest, SignJwtResponse>newBuilder()
              .setFullMethodName("google.iam.credentials.v1.IAMCredentials/SignJwt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SignJwtRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/serviceAccounts/*}:signJwt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SignJwtRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SignJwtRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SignJwtResponse>newBuilder()
                      .setDefaultInstance(SignJwtResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable;
  private final UnaryCallable<GenerateIdTokenRequest, GenerateIdTokenResponse>
      generateIdTokenCallable;
  private final UnaryCallable<SignBlobRequest, SignBlobResponse> signBlobCallable;
  private final UnaryCallable<SignJwtRequest, SignJwtResponse> signJwtCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIamCredentialsStub create(IamCredentialsStubSettings settings)
      throws IOException {
    return new HttpJsonIamCredentialsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIamCredentialsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIamCredentialsStub(
        IamCredentialsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIamCredentialsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIamCredentialsStub(
        IamCredentialsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIamCredentialsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIamCredentialsStub(
      IamCredentialsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonIamCredentialsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIamCredentialsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIamCredentialsStub(
      IamCredentialsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenTransportSettings =
            HttpJsonCallSettings
                .<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAccessTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GenerateIdTokenRequest, GenerateIdTokenResponse>
        generateIdTokenTransportSettings =
            HttpJsonCallSettings.<GenerateIdTokenRequest, GenerateIdTokenResponse>newBuilder()
                .setMethodDescriptor(generateIdTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SignBlobRequest, SignBlobResponse> signBlobTransportSettings =
        HttpJsonCallSettings.<SignBlobRequest, SignBlobResponse>newBuilder()
            .setMethodDescriptor(signBlobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SignJwtRequest, SignJwtResponse> signJwtTransportSettings =
        HttpJsonCallSettings.<SignJwtRequest, SignJwtResponse>newBuilder()
            .setMethodDescriptor(signJwtMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.generateAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAccessTokenTransportSettings,
            settings.generateAccessTokenSettings(),
            clientContext);
    this.generateIdTokenCallable =
        callableFactory.createUnaryCallable(
            generateIdTokenTransportSettings, settings.generateIdTokenSettings(), clientContext);
    this.signBlobCallable =
        callableFactory.createUnaryCallable(
            signBlobTransportSettings, settings.signBlobSettings(), clientContext);
    this.signJwtCallable =
        callableFactory.createUnaryCallable(
            signJwtTransportSettings, settings.signJwtSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(generateAccessTokenMethodDescriptor);
    methodDescriptors.add(generateIdTokenMethodDescriptor);
    methodDescriptors.add(signBlobMethodDescriptor);
    methodDescriptors.add(signJwtMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    return generateAccessTokenCallable;
  }

  @Override
  public UnaryCallable<GenerateIdTokenRequest, GenerateIdTokenResponse> generateIdTokenCallable() {
    return generateIdTokenCallable;
  }

  @Override
  public UnaryCallable<SignBlobRequest, SignBlobResponse> signBlobCallable() {
    return signBlobCallable;
  }

  @Override
  public UnaryCallable<SignJwtRequest, SignJwtResponse> signJwtCallable() {
    return signJwtCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
