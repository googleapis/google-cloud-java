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

package com.google.cloud.retail.v2beta.stub;

import static com.google.cloud.retail.v2beta.CatalogServiceClient.ListCatalogsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.AddCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.AttributesConfig;
import com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest;
import com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse;
import com.google.cloud.retail.v2beta.Catalog;
import com.google.cloud.retail.v2beta.CompletionConfig;
import com.google.cloud.retail.v2beta.GetAttributesConfigRequest;
import com.google.cloud.retail.v2beta.GetCompletionConfigRequest;
import com.google.cloud.retail.v2beta.GetDefaultBranchRequest;
import com.google.cloud.retail.v2beta.GetDefaultBranchResponse;
import com.google.cloud.retail.v2beta.ListCatalogsRequest;
import com.google.cloud.retail.v2beta.ListCatalogsResponse;
import com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.SetDefaultBranchRequest;
import com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest;
import com.google.cloud.retail.v2beta.UpdateCatalogRequest;
import com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCatalogServiceStub extends CatalogServiceStub {
  private static final MethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          MethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/ListCatalogs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCatalogsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCatalogRequest, Catalog>
      updateCatalogMethodDescriptor =
          MethodDescriptor.<UpdateCatalogRequest, Catalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/UpdateCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Catalog.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetDefaultBranchRequest, Empty>
      setDefaultBranchMethodDescriptor =
          MethodDescriptor.<SetDefaultBranchRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/SetDefaultBranch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetDefaultBranchRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchMethodDescriptor =
          MethodDescriptor.<GetDefaultBranchRequest, GetDefaultBranchResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/GetDefaultBranch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDefaultBranchRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetDefaultBranchResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCompletionConfigRequest, CompletionConfig>
      getCompletionConfigMethodDescriptor =
          MethodDescriptor.<GetCompletionConfigRequest, CompletionConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/GetCompletionConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCompletionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CompletionConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigMethodDescriptor =
          MethodDescriptor.<UpdateCompletionConfigRequest, CompletionConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/UpdateCompletionConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCompletionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CompletionConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAttributesConfigRequest, AttributesConfig>
      getAttributesConfigMethodDescriptor =
          MethodDescriptor.<GetAttributesConfigRequest, AttributesConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/GetAttributesConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAttributesConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AttributesConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigMethodDescriptor =
          MethodDescriptor.<UpdateAttributesConfigRequest, AttributesConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/UpdateAttributesConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAttributesConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AttributesConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddCatalogAttributeRequest, AttributesConfig>
      addCatalogAttributeMethodDescriptor =
          MethodDescriptor.<AddCatalogAttributeRequest, AttributesConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/AddCatalogAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddCatalogAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AttributesConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeMethodDescriptor =
          MethodDescriptor.<RemoveCatalogAttributeRequest, AttributesConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/RemoveCatalogAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveCatalogAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AttributesConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesMethodDescriptor =
          MethodDescriptor
              .<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.CatalogService/BatchRemoveCatalogAttributes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRemoveCatalogAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchRemoveCatalogAttributesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeMethodDescriptor =
          MethodDescriptor.<ReplaceCatalogAttributeRequest, AttributesConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.CatalogService/ReplaceCatalogAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReplaceCatalogAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AttributesConfig.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable;
  private final UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable;
  private final UnaryCallable<SetDefaultBranchRequest, Empty> setDefaultBranchCallable;
  private final UnaryCallable<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchCallable;
  private final UnaryCallable<GetCompletionConfigRequest, CompletionConfig>
      getCompletionConfigCallable;
  private final UnaryCallable<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigCallable;
  private final UnaryCallable<GetAttributesConfigRequest, AttributesConfig>
      getAttributesConfigCallable;
  private final UnaryCallable<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigCallable;
  private final UnaryCallable<AddCatalogAttributeRequest, AttributesConfig>
      addCatalogAttributeCallable;
  private final UnaryCallable<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeCallable;
  private final UnaryCallable<
          BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesCallable;
  private final UnaryCallable<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeCallable;

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
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCatalogRequest, Catalog> updateCatalogTransportSettings =
        GrpcCallSettings.<UpdateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(updateCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("catalog.name", String.valueOf(request.getCatalog().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetDefaultBranchRequest, Empty> setDefaultBranchTransportSettings =
        GrpcCallSettings.<SetDefaultBranchRequest, Empty>newBuilder()
            .setMethodDescriptor(setDefaultBranchMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("catalog", String.valueOf(request.getCatalog()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDefaultBranchRequest, GetDefaultBranchResponse>
        getDefaultBranchTransportSettings =
            GrpcCallSettings.<GetDefaultBranchRequest, GetDefaultBranchResponse>newBuilder()
                .setMethodDescriptor(getDefaultBranchMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("catalog", String.valueOf(request.getCatalog()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCompletionConfigRequest, CompletionConfig>
        getCompletionConfigTransportSettings =
            GrpcCallSettings.<GetCompletionConfigRequest, CompletionConfig>newBuilder()
                .setMethodDescriptor(getCompletionConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCompletionConfigRequest, CompletionConfig>
        updateCompletionConfigTransportSettings =
            GrpcCallSettings.<UpdateCompletionConfigRequest, CompletionConfig>newBuilder()
                .setMethodDescriptor(updateCompletionConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "completion_config.name",
                          String.valueOf(request.getCompletionConfig().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAttributesConfigRequest, AttributesConfig>
        getAttributesConfigTransportSettings =
            GrpcCallSettings.<GetAttributesConfigRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(getAttributesConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateAttributesConfigRequest, AttributesConfig>
        updateAttributesConfigTransportSettings =
            GrpcCallSettings.<UpdateAttributesConfigRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(updateAttributesConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "attributes_config.name",
                          String.valueOf(request.getAttributesConfig().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<AddCatalogAttributeRequest, AttributesConfig>
        addCatalogAttributeTransportSettings =
            GrpcCallSettings.<AddCatalogAttributeRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(addCatalogAttributeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "attributes_config", String.valueOf(request.getAttributesConfig()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RemoveCatalogAttributeRequest, AttributesConfig>
        removeCatalogAttributeTransportSettings =
            GrpcCallSettings.<RemoveCatalogAttributeRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(removeCatalogAttributeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "attributes_config", String.valueOf(request.getAttributesConfig()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
        batchRemoveCatalogAttributesTransportSettings =
            GrpcCallSettings
                .<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
                    newBuilder()
                .setMethodDescriptor(batchRemoveCatalogAttributesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "attributes_config", String.valueOf(request.getAttributesConfig()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ReplaceCatalogAttributeRequest, AttributesConfig>
        replaceCatalogAttributeTransportSettings =
            GrpcCallSettings.<ReplaceCatalogAttributeRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(replaceCatalogAttributeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "attributes_config", String.valueOf(request.getAttributesConfig()));
                      return params.build();
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
    this.getCompletionConfigCallable =
        callableFactory.createUnaryCallable(
            getCompletionConfigTransportSettings,
            settings.getCompletionConfigSettings(),
            clientContext);
    this.updateCompletionConfigCallable =
        callableFactory.createUnaryCallable(
            updateCompletionConfigTransportSettings,
            settings.updateCompletionConfigSettings(),
            clientContext);
    this.getAttributesConfigCallable =
        callableFactory.createUnaryCallable(
            getAttributesConfigTransportSettings,
            settings.getAttributesConfigSettings(),
            clientContext);
    this.updateAttributesConfigCallable =
        callableFactory.createUnaryCallable(
            updateAttributesConfigTransportSettings,
            settings.updateAttributesConfigSettings(),
            clientContext);
    this.addCatalogAttributeCallable =
        callableFactory.createUnaryCallable(
            addCatalogAttributeTransportSettings,
            settings.addCatalogAttributeSettings(),
            clientContext);
    this.removeCatalogAttributeCallable =
        callableFactory.createUnaryCallable(
            removeCatalogAttributeTransportSettings,
            settings.removeCatalogAttributeSettings(),
            clientContext);
    this.batchRemoveCatalogAttributesCallable =
        callableFactory.createUnaryCallable(
            batchRemoveCatalogAttributesTransportSettings,
            settings.batchRemoveCatalogAttributesSettings(),
            clientContext);
    this.replaceCatalogAttributeCallable =
        callableFactory.createUnaryCallable(
            replaceCatalogAttributeTransportSettings,
            settings.replaceCatalogAttributeSettings(),
            clientContext);

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
  public UnaryCallable<GetCompletionConfigRequest, CompletionConfig> getCompletionConfigCallable() {
    return getCompletionConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigCallable() {
    return updateCompletionConfigCallable;
  }

  @Override
  public UnaryCallable<GetAttributesConfigRequest, AttributesConfig> getAttributesConfigCallable() {
    return getAttributesConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigCallable() {
    return updateAttributesConfigCallable;
  }

  @Override
  public UnaryCallable<AddCatalogAttributeRequest, AttributesConfig> addCatalogAttributeCallable() {
    return addCatalogAttributeCallable;
  }

  @Override
  public UnaryCallable<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeCallable() {
    return removeCatalogAttributeCallable;
  }

  @Override
  public UnaryCallable<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesCallable() {
    return batchRemoveCatalogAttributesCallable;
  }

  @Override
  public UnaryCallable<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeCallable() {
    return replaceCatalogAttributeCallable;
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
