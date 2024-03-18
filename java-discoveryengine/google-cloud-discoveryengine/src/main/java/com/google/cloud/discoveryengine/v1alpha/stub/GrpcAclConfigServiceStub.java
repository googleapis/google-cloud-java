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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.AclConfig;
import com.google.cloud.discoveryengine.v1alpha.GetAclConfigRequest;
import com.google.cloud.discoveryengine.v1alpha.UpdateAclConfigRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AclConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAclConfigServiceStub extends AclConfigServiceStub {
  private static final MethodDescriptor<UpdateAclConfigRequest, AclConfig>
      updateAclConfigMethodDescriptor =
          MethodDescriptor.<UpdateAclConfigRequest, AclConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.AclConfigService/UpdateAclConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAclConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AclConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAclConfigRequest, AclConfig>
      getAclConfigMethodDescriptor =
          MethodDescriptor.<GetAclConfigRequest, AclConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.AclConfigService/GetAclConfig")
              .setRequestMarshaller(ProtoUtils.marshaller(GetAclConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AclConfig.getDefaultInstance()))
              .build();

  private final UnaryCallable<UpdateAclConfigRequest, AclConfig> updateAclConfigCallable;
  private final UnaryCallable<GetAclConfigRequest, AclConfig> getAclConfigCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAclConfigServiceStub create(AclConfigServiceStubSettings settings)
      throws IOException {
    return new GrpcAclConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAclConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAclConfigServiceStub(
        AclConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAclConfigServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAclConfigServiceStub(
        AclConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAclConfigServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAclConfigServiceStub(
      AclConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAclConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAclConfigServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAclConfigServiceStub(
      AclConfigServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<UpdateAclConfigRequest, AclConfig> updateAclConfigTransportSettings =
        GrpcCallSettings.<UpdateAclConfigRequest, AclConfig>newBuilder()
            .setMethodDescriptor(updateAclConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("acl_config.name", String.valueOf(request.getAclConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAclConfigRequest, AclConfig> getAclConfigTransportSettings =
        GrpcCallSettings.<GetAclConfigRequest, AclConfig>newBuilder()
            .setMethodDescriptor(getAclConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.updateAclConfigCallable =
        callableFactory.createUnaryCallable(
            updateAclConfigTransportSettings, settings.updateAclConfigSettings(), clientContext);
    this.getAclConfigCallable =
        callableFactory.createUnaryCallable(
            getAclConfigTransportSettings, settings.getAclConfigSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<UpdateAclConfigRequest, AclConfig> updateAclConfigCallable() {
    return updateAclConfigCallable;
  }

  @Override
  public UnaryCallable<GetAclConfigRequest, AclConfig> getAclConfigCallable() {
    return getAclConfigCallable;
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
