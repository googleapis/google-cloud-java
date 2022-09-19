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

package com.google.protos.google.cloud.binaryauthorization.v1.stub;

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
import com.google.protobuf.TypeRegistry;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ValidationHelperV1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonValidationHelperV1Stub extends ValidationHelperV1Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          Service.ValidateAttestationOccurrenceRequest,
          Service.ValidateAttestationOccurrenceResponse>
      validateAttestationOccurrenceMethodDescriptor =
          ApiMethodDescriptor
              .<Service.ValidateAttestationOccurrenceRequest,
                  Service.ValidateAttestationOccurrenceResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.ValidationHelperV1/ValidateAttestationOccurrence")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<Service.ValidateAttestationOccurrenceRequest>newBuilder()
                      .setPath(
                          "/v1/{attestor=projects/*/attestors/*}:validateAttestationOccurrence",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.ValidateAttestationOccurrenceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "attestor", request.getAttestor());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.ValidateAttestationOccurrenceRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearAttestor().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<Service.ValidateAttestationOccurrenceResponse>newBuilder()
                      .setDefaultInstance(
                          Service.ValidateAttestationOccurrenceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          Service.ValidateAttestationOccurrenceRequest,
          Service.ValidateAttestationOccurrenceResponse>
      validateAttestationOccurrenceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonValidationHelperV1Stub create(ValidationHelperV1StubSettings settings)
      throws IOException {
    return new HttpJsonValidationHelperV1Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonValidationHelperV1Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonValidationHelperV1Stub(
        ValidationHelperV1StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonValidationHelperV1Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonValidationHelperV1Stub(
        ValidationHelperV1StubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonValidationHelperV1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonValidationHelperV1Stub(
      ValidationHelperV1StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonValidationHelperV1CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonValidationHelperV1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonValidationHelperV1Stub(
      ValidationHelperV1StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            Service.ValidateAttestationOccurrenceRequest,
            Service.ValidateAttestationOccurrenceResponse>
        validateAttestationOccurrenceTransportSettings =
            HttpJsonCallSettings
                .<Service.ValidateAttestationOccurrenceRequest,
                    Service.ValidateAttestationOccurrenceResponse>
                    newBuilder()
                .setMethodDescriptor(validateAttestationOccurrenceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.validateAttestationOccurrenceCallable =
        callableFactory.createUnaryCallable(
            validateAttestationOccurrenceTransportSettings,
            settings.validateAttestationOccurrenceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(validateAttestationOccurrenceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          Service.ValidateAttestationOccurrenceRequest,
          Service.ValidateAttestationOccurrenceResponse>
      validateAttestationOccurrenceCallable() {
    return validateAttestationOccurrenceCallable;
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
