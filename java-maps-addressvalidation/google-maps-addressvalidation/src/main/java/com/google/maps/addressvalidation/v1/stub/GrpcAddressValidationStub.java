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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.addressvalidation.v1.ProvideValidationFeedbackRequest;
import com.google.maps.addressvalidation.v1.ProvideValidationFeedbackResponse;
import com.google.maps.addressvalidation.v1.ValidateAddressRequest;
import com.google.maps.addressvalidation.v1.ValidateAddressResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AddressValidation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAddressValidationStub extends AddressValidationStub {
  private static final MethodDescriptor<ValidateAddressRequest, ValidateAddressResponse>
      validateAddressMethodDescriptor =
          MethodDescriptor.<ValidateAddressRequest, ValidateAddressResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.addressvalidation.v1.AddressValidation/ValidateAddress")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ValidateAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ValidateAddressResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
      provideValidationFeedbackMethodDescriptor =
          MethodDescriptor
              .<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.addressvalidation.v1.AddressValidation/ProvideValidationFeedback")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProvideValidationFeedbackRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ProvideValidationFeedbackResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ValidateAddressRequest, ValidateAddressResponse>
      validateAddressCallable;
  private final UnaryCallable<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
      provideValidationFeedbackCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAddressValidationStub create(AddressValidationStubSettings settings)
      throws IOException {
    return new GrpcAddressValidationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAddressValidationStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAddressValidationStub(
        AddressValidationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAddressValidationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAddressValidationStub(
        AddressValidationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAddressValidationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAddressValidationStub(
      AddressValidationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAddressValidationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAddressValidationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAddressValidationStub(
      AddressValidationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ValidateAddressRequest, ValidateAddressResponse>
        validateAddressTransportSettings =
            GrpcCallSettings.<ValidateAddressRequest, ValidateAddressResponse>newBuilder()
                .setMethodDescriptor(validateAddressMethodDescriptor)
                .build();
    GrpcCallSettings<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
        provideValidationFeedbackTransportSettings =
            GrpcCallSettings
                .<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>newBuilder()
                .setMethodDescriptor(provideValidationFeedbackMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
