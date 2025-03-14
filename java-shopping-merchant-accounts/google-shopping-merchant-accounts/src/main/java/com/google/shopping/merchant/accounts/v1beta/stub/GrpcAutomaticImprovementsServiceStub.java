/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements;
import com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AutomaticImprovementsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAutomaticImprovementsServiceStub extends AutomaticImprovementsServiceStub {
  private static final MethodDescriptor<GetAutomaticImprovementsRequest, AutomaticImprovements>
      getAutomaticImprovementsMethodDescriptor =
          MethodDescriptor.<GetAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AutomaticImprovementsService/GetAutomaticImprovements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAutomaticImprovementsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AutomaticImprovements.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
      updateAutomaticImprovementsMethodDescriptor =
          MethodDescriptor.<UpdateAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AutomaticImprovementsService/UpdateAutomaticImprovements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAutomaticImprovementsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AutomaticImprovements.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetAutomaticImprovementsRequest, AutomaticImprovements>
      getAutomaticImprovementsCallable;
  private final UnaryCallable<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
      updateAutomaticImprovementsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAutomaticImprovementsServiceStub create(
      AutomaticImprovementsServiceStubSettings settings) throws IOException {
    return new GrpcAutomaticImprovementsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAutomaticImprovementsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAutomaticImprovementsServiceStub(
        AutomaticImprovementsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAutomaticImprovementsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAutomaticImprovementsServiceStub(
        AutomaticImprovementsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcAutomaticImprovementsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAutomaticImprovementsServiceStub(
      AutomaticImprovementsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAutomaticImprovementsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAutomaticImprovementsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAutomaticImprovementsServiceStub(
      AutomaticImprovementsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAutomaticImprovementsRequest, AutomaticImprovements>
        getAutomaticImprovementsTransportSettings =
            GrpcCallSettings.<GetAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
                .setMethodDescriptor(getAutomaticImprovementsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
        updateAutomaticImprovementsTransportSettings =
            GrpcCallSettings.<UpdateAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
                .setMethodDescriptor(updateAutomaticImprovementsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "automatic_improvements.name",
                          String.valueOf(request.getAutomaticImprovements().getName()));
                      return builder.build();
                    })
                .build();

    this.getAutomaticImprovementsCallable =
        callableFactory.createUnaryCallable(
            getAutomaticImprovementsTransportSettings,
            settings.getAutomaticImprovementsSettings(),
            clientContext);
    this.updateAutomaticImprovementsCallable =
        callableFactory.createUnaryCallable(
            updateAutomaticImprovementsTransportSettings,
            settings.updateAutomaticImprovementsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAutomaticImprovementsRequest, AutomaticImprovements>
      getAutomaticImprovementsCallable() {
    return getAutomaticImprovementsCallable;
  }

  @Override
  public UnaryCallable<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
      updateAutomaticImprovementsCallable() {
    return updateAutomaticImprovementsCallable;
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
