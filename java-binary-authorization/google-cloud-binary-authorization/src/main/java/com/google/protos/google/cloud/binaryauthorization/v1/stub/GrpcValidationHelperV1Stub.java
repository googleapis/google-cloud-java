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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ValidationHelperV1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcValidationHelperV1Stub extends ValidationHelperV1Stub {
  private static final MethodDescriptor<
          Service.ValidateAttestationOccurrenceRequest,
          Service.ValidateAttestationOccurrenceResponse>
      validateAttestationOccurrenceMethodDescriptor =
          MethodDescriptor
              .<Service.ValidateAttestationOccurrenceRequest,
                  Service.ValidateAttestationOccurrenceResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.ValidationHelperV1/ValidateAttestationOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      Service.ValidateAttestationOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      Service.ValidateAttestationOccurrenceResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<
          Service.ValidateAttestationOccurrenceRequest,
          Service.ValidateAttestationOccurrenceResponse>
      validateAttestationOccurrenceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcValidationHelperV1Stub create(ValidationHelperV1StubSettings settings)
      throws IOException {
    return new GrpcValidationHelperV1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcValidationHelperV1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcValidationHelperV1Stub(
        ValidationHelperV1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcValidationHelperV1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcValidationHelperV1Stub(
        ValidationHelperV1StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcValidationHelperV1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcValidationHelperV1Stub(
      ValidationHelperV1StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcValidationHelperV1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcValidationHelperV1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcValidationHelperV1Stub(
      ValidationHelperV1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            Service.ValidateAttestationOccurrenceRequest,
            Service.ValidateAttestationOccurrenceResponse>
        validateAttestationOccurrenceTransportSettings =
            GrpcCallSettings
                .<Service.ValidateAttestationOccurrenceRequest,
                    Service.ValidateAttestationOccurrenceResponse>
                    newBuilder()
                .setMethodDescriptor(validateAttestationOccurrenceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("attestor", String.valueOf(request.getAttestor()));
                      return params.build();
                    })
                .build();

    this.validateAttestationOccurrenceCallable =
        callableFactory.createUnaryCallable(
            validateAttestationOccurrenceTransportSettings,
            settings.validateAttestationOccurrenceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
