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

package com.google.cloud.apigeeconnect.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.cloud.apigeeconnect.v1.EgressRequest;
import com.google.cloud.apigeeconnect.v1.EgressResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Tether service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTetherStub extends TetherStub {
  private static final MethodDescriptor<EgressResponse, EgressRequest> egressMethodDescriptor =
      MethodDescriptor.<EgressResponse, EgressRequest>newBuilder()
          .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName("google.cloud.apigeeconnect.v1.Tether/Egress")
          .setRequestMarshaller(ProtoUtils.marshaller(EgressResponse.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(EgressRequest.getDefaultInstance()))
          .build();

  private final BidiStreamingCallable<EgressResponse, EgressRequest> egressCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTetherStub create(TetherStubSettings settings) throws IOException {
    return new GrpcTetherStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTetherStub create(ClientContext clientContext) throws IOException {
    return new GrpcTetherStub(TetherStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTetherStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTetherStub(
        TetherStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTetherStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTetherStub(TetherStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTetherCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTetherStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTetherStub(
      TetherStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<EgressResponse, EgressRequest> egressTransportSettings =
        GrpcCallSettings.<EgressResponse, EgressRequest>newBuilder()
            .setMethodDescriptor(egressMethodDescriptor)
            .build();

    this.egressCallable =
        callableFactory.createBidiStreamingCallable(
            egressTransportSettings, settings.egressSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public BidiStreamingCallable<EgressResponse, EgressRequest> egressCallable() {
    return egressCallable;
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
