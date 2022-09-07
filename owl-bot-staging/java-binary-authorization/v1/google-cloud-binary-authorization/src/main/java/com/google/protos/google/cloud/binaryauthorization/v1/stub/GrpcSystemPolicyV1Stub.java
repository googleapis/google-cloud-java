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
import com.google.protos.google.cloud.binaryauthorization.v1.Resources;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SystemPolicyV1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSystemPolicyV1Stub extends SystemPolicyV1Stub {
  private static final MethodDescriptor<Service.GetSystemPolicyRequest, Resources.Policy>
      getSystemPolicyMethodDescriptor =
          MethodDescriptor.<Service.GetSystemPolicyRequest, Resources.Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.SystemPolicyV1/GetSystemPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.GetSystemPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Resources.Policy.getDefaultInstance()))
              .build();

  private final UnaryCallable<Service.GetSystemPolicyRequest, Resources.Policy>
      getSystemPolicyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSystemPolicyV1Stub create(SystemPolicyV1StubSettings settings)
      throws IOException {
    return new GrpcSystemPolicyV1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcSystemPolicyV1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSystemPolicyV1Stub(
        SystemPolicyV1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSystemPolicyV1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSystemPolicyV1Stub(
        SystemPolicyV1StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSystemPolicyV1Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSystemPolicyV1Stub(SystemPolicyV1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSystemPolicyV1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcSystemPolicyV1Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSystemPolicyV1Stub(
      SystemPolicyV1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<Service.GetSystemPolicyRequest, Resources.Policy>
        getSystemPolicyTransportSettings =
            GrpcCallSettings.<Service.GetSystemPolicyRequest, Resources.Policy>newBuilder()
                .setMethodDescriptor(getSystemPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.getSystemPolicyCallable =
        callableFactory.createUnaryCallable(
            getSystemPolicyTransportSettings, settings.getSystemPolicySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<Service.GetSystemPolicyRequest, Resources.Policy> getSystemPolicyCallable() {
    return getSystemPolicyCallable;
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
