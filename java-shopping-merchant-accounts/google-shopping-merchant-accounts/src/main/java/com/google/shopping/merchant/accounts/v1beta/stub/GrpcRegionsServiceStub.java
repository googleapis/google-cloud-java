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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.RegionsServiceClient.ListRegionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.GetRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse;
import com.google.shopping.merchant.accounts.v1beta.Region;
import com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RegionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcRegionsServiceStub extends RegionsServiceStub {
  private static final MethodDescriptor<GetRegionRequest, Region> getRegionMethodDescriptor =
      MethodDescriptor.<GetRegionRequest, Region>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.RegionsService/GetRegion")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRegionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Region.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateRegionRequest, Region> createRegionMethodDescriptor =
      MethodDescriptor.<CreateRegionRequest, Region>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.RegionsService/CreateRegion")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRegionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Region.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateRegionRequest, Region> updateRegionMethodDescriptor =
      MethodDescriptor.<UpdateRegionRequest, Region>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.RegionsService/UpdateRegion")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRegionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Region.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteRegionRequest, Empty> deleteRegionMethodDescriptor =
      MethodDescriptor.<DeleteRegionRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.RegionsService/DeleteRegion")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRegionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRegionsRequest, ListRegionsResponse>
      listRegionsMethodDescriptor =
          MethodDescriptor.<ListRegionsRequest, ListRegionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.RegionsService/ListRegions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRegionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRegionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetRegionRequest, Region> getRegionCallable;
  private final UnaryCallable<CreateRegionRequest, Region> createRegionCallable;
  private final UnaryCallable<UpdateRegionRequest, Region> updateRegionCallable;
  private final UnaryCallable<DeleteRegionRequest, Empty> deleteRegionCallable;
  private final UnaryCallable<ListRegionsRequest, ListRegionsResponse> listRegionsCallable;
  private final UnaryCallable<ListRegionsRequest, ListRegionsPagedResponse>
      listRegionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRegionsServiceStub create(RegionsServiceStubSettings settings)
      throws IOException {
    return new GrpcRegionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRegionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRegionsServiceStub(
        RegionsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRegionsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRegionsServiceStub(
        RegionsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRegionsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRegionsServiceStub(RegionsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRegionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRegionsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRegionsServiceStub(
      RegionsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetRegionRequest, Region> getRegionTransportSettings =
        GrpcCallSettings.<GetRegionRequest, Region>newBuilder()
            .setMethodDescriptor(getRegionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRegionRequest, Region> createRegionTransportSettings =
        GrpcCallSettings.<CreateRegionRequest, Region>newBuilder()
            .setMethodDescriptor(createRegionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRegionRequest, Region> updateRegionTransportSettings =
        GrpcCallSettings.<UpdateRegionRequest, Region>newBuilder()
            .setMethodDescriptor(updateRegionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("region.name", String.valueOf(request.getRegion().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRegionRequest, Empty> deleteRegionTransportSettings =
        GrpcCallSettings.<DeleteRegionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRegionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRegionsRequest, ListRegionsResponse> listRegionsTransportSettings =
        GrpcCallSettings.<ListRegionsRequest, ListRegionsResponse>newBuilder()
            .setMethodDescriptor(listRegionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getRegionCallable =
        callableFactory.createUnaryCallable(
            getRegionTransportSettings, settings.getRegionSettings(), clientContext);
    this.createRegionCallable =
        callableFactory.createUnaryCallable(
            createRegionTransportSettings, settings.createRegionSettings(), clientContext);
    this.updateRegionCallable =
        callableFactory.createUnaryCallable(
            updateRegionTransportSettings, settings.updateRegionSettings(), clientContext);
    this.deleteRegionCallable =
        callableFactory.createUnaryCallable(
            deleteRegionTransportSettings, settings.deleteRegionSettings(), clientContext);
    this.listRegionsCallable =
        callableFactory.createUnaryCallable(
            listRegionsTransportSettings, settings.listRegionsSettings(), clientContext);
    this.listRegionsPagedCallable =
        callableFactory.createPagedCallable(
            listRegionsTransportSettings, settings.listRegionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetRegionRequest, Region> getRegionCallable() {
    return getRegionCallable;
  }

  @Override
  public UnaryCallable<CreateRegionRequest, Region> createRegionCallable() {
    return createRegionCallable;
  }

  @Override
  public UnaryCallable<UpdateRegionRequest, Region> updateRegionCallable() {
    return updateRegionCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionRequest, Empty> deleteRegionCallable() {
    return deleteRegionCallable;
  }

  @Override
  public UnaryCallable<ListRegionsRequest, ListRegionsResponse> listRegionsCallable() {
    return listRegionsCallable;
  }

  @Override
  public UnaryCallable<ListRegionsRequest, ListRegionsPagedResponse> listRegionsPagedCallable() {
    return listRegionsPagedCallable;
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
