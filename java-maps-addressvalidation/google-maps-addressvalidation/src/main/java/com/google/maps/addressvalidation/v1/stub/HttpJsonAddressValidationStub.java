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

package com.google.maps.addressvalidation.v1.stub;

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
import com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest;
import com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse;
import com.google.maps.addressvalidation.v1.ValidateAddressRequest;
import com.google.maps.addressvalidation.v1.ValidateAddressResponse;
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
 * REST stub implementation for the AddressValidation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAddressValidationStub extends AddressValidationStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ValidateAddressRequest, ValidateAddressResponse>
      validateAddressMethodDescriptor =
          ApiMethodDescriptor.<ValidateAddressRequest, ValidateAddressResponse>newBuilder()
              .setFullMethodName(
                  "google.maps.addressvalidation.v1.AddressValidation/ValidateAddress")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateAddressRequest>newBuilder()
                      .setPath(
                          "/v1:validateAddress",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ValidateAddressResponse>newBuilder()
                      .setDefaultInstance(ValidateAddressResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
      provideValidationFeedbackMethodDescriptor =
          ApiMethodDescriptor
              .<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>newBuilder()
              .setFullMethodName(
                  "google.maps.addressvalidation.v1.AddressValidation/ProvideValidationFeedback")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProvideValidationFeedbackRequest>newBuilder()
                      .setPath(
                          "/v1:provideValidationFeedback",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProvideValidationFeedbackRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProvideValidationFeedbackRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProvideValidationFeedbackResponse>newBuilder()
                      .setDefaultInstance(ProvideValidationFeedbackResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ValidateAddressRequest, ValidateAddressResponse>
      validateAddressCallable;
  private final UnaryCallable<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
      provideValidationFeedbackCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAddressValidationStub create(AddressValidationStubSettings settings)
      throws IOException {
    return new HttpJsonAddressValidationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAddressValidationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAddressValidationStub(
        AddressValidationStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAddressValidationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAddressValidationStub(
        AddressValidationStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAddressValidationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAddressValidationStub(
      AddressValidationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAddressValidationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAddressValidationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAddressValidationStub(
      AddressValidationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ValidateAddressRequest, ValidateAddressResponse>
        validateAddressTransportSettings =
            HttpJsonCallSettings.<ValidateAddressRequest, ValidateAddressResponse>newBuilder()
                .setMethodDescriptor(validateAddressMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
        provideValidationFeedbackTransportSettings =
            HttpJsonCallSettings
                .<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>newBuilder()
                .setMethodDescriptor(provideValidationFeedbackMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.validateAddressCallable =
        callableFactory.createUnaryCallable(
            validateAddressTransportSettings, settings.validateAddressSettings(), clientContext);
    this.provideValidationFeedbackCallable =
        callableFactory.createUnaryCallable(
            provideValidationFeedbackTransportSettings,
            settings.provideValidationFeedbackSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(validateAddressMethodDescriptor);
    methodDescriptors.add(provideValidationFeedbackMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ValidateAddressRequest, ValidateAddressResponse> validateAddressCallable() {
    return validateAddressCallable;
  }

  @Override
  public UnaryCallable<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
      provideValidationFeedbackCallable() {
    return provideValidationFeedbackCallable;
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
