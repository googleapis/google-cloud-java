/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.retail.v2.stub;

import static com.google.cloud.retail.v2.CatalogServiceClient.ListCatalogsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.Catalog;
import com.google.cloud.retail.v2.GetDefaultBranchRequest;
import com.google.cloud.retail.v2.GetDefaultBranchResponse;
import com.google.cloud.retail.v2.ListCatalogsRequest;
import com.google.cloud.retail.v2.ListCatalogsResponse;
import com.google.cloud.retail.v2.SetDefaultBranchRequest;
import com.google.cloud.retail.v2.UpdateCatalogRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCatalogServiceStub extends CatalogServiceStub {
  private static final MethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          MethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.CatalogService/ListCatalogs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCatalogsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCatalogRequest, Catalog>
      updateCatalogMethodDescriptor =
          MethodDescriptor.<UpdateCatalogRequest, Catalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.CatalogService/UpdateCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetDefaultBranchRequest, Empty>
      setDefaultBranchMethodDescriptor =
          MethodDescriptor.<SetDefaultBranchRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.CatalogService/SetDefaultBranch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetDefaultBranchRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchMethodDescriptor =
          MethodDescriptor.<GetDefaultBranchRequest, GetDefaultBranchResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.CatalogService/GetDefaultBranch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDefaultBranchRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetDefaultBranchResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable;
  private final UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable;
  private final UnaryCallable<SetDefaultBranchRequest, Empty> setDefaultBranchCallable;
  private final UnaryCallable<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCatalogServiceStub create(CatalogServiceStubSettings settings)
      throws IOException {
    return new GrpcCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCatalogServiceStub(
        CatalogServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCatalogServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCatalogServiceStub(
        CatalogServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCatalogServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCatalogServiceStub(CatalogServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCatalogServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCatalogServiceStub(
      CatalogServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListCatalogsRequest, ListCatalogsResponse> listCatalogsTransportSettings =
        GrpcCallSettings.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
            .setMethodDescriptor(listCatalogsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListCatalogsRequest>() {
                  @Override
                  public Map<String, String> extract(ListCatalogsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateCatalogRequest, Catalog> updateCatalogTransportSettings =
        GrpcCallSettings.<UpdateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(updateCatalogMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateCatalogRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateCatalogRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("catalog.name", String.valueOf(request.getCatalog().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetDefaultBranchRequest, Empty> setDefaultBranchTransportSettings =
        GrpcCallSettings.<SetDefaultBranchRequest, Empty>newBuilder()
            .setMethodDescriptor(setDefaultBranchMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetDefaultBranchRequest>() {
                  @Override
                  public Map<String, String> extract(SetDefaultBranchRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("catalog", String.valueOf(request.getCatalog()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetDefaultBranchRequest, GetDefaultBranchResponse>
        getDefaultBranchTransportSettings =
            GrpcCallSettings.<GetDefaultBranchRequest, GetDefaultBranchResponse>newBuilder()
                .setMethodDescriptor(getDefaultBranchMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetDefaultBranchRequest>() {
                      @Override
                      public Map<String, String> extract(GetDefaultBranchRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("catalog", String.valueOf(request.getCatalog()));
                        return params.build();
                      }
                    })
                .build();

    this.listCatalogsCallable =
        callableFactory.createUnaryCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.listCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listCatalogsTransportSettings, settings.listCatalogsSettings(), clientContext);
    this.updateCatalogCallable =
        callableFactory.createUnaryCallable(
            updateCatalogTransportSettings, settings.updateCatalogSettings(), clientContext);
    this.setDefaultBranchCallable =
        callableFactory.createUnaryCallable(
            setDefaultBranchTransportSettings, settings.setDefaultBranchSettings(), clientContext);
    this.getDefaultBranchCallable =
        callableFactory.createUnaryCallable(
            getDefaultBranchTransportSettings, settings.getDefaultBranchSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return listCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse> listCatalogsPagedCallable() {
    return listCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable() {
    return updateCatalogCallable;
  }

  @Override
  public UnaryCallable<SetDefaultBranchRequest, Empty> setDefaultBranchCallable() {
    return setDefaultBranchCallable;
  }

  @Override
  public UnaryCallable<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchCallable() {
    return getDefaultBranchCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
