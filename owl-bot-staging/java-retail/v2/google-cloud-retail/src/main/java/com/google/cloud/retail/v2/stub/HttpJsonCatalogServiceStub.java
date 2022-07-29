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

package com.google.cloud.retail.v2.stub;

import static com.google.cloud.retail.v2.CatalogServiceClient.ListCatalogsPagedResponse;

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
import com.google.cloud.retail.v2.Catalog;
import com.google.cloud.retail.v2.GetDefaultBranchRequest;
import com.google.cloud.retail.v2.GetDefaultBranchResponse;
import com.google.cloud.retail.v2.ListCatalogsRequest;
import com.google.cloud.retail.v2.ListCatalogsResponse;
import com.google.cloud.retail.v2.SetDefaultBranchRequest;
import com.google.cloud.retail.v2.UpdateCatalogRequest;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCatalogServiceStub extends CatalogServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          ApiMethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.CatalogService/ListCatalogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCatalogsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/catalogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCatalogsResponse>newBuilder()
                      .setDefaultInstance(ListCatalogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCatalogRequest, Catalog>
      updateCatalogMethodDescriptor =
          ApiMethodDescriptor.<UpdateCatalogRequest, Catalog>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.CatalogService/UpdateCatalog")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCatalogRequest>newBuilder()
                      .setPath(
                          "/v2/{catalog.name=projects/*/locations/*/catalogs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "catalog.name", request.getCatalog().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("catalog", request.getCatalog()))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Catalog>newBuilder()
                      .setDefaultInstance(Catalog.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetDefaultBranchRequest, Empty>
      setDefaultBranchMethodDescriptor =
          ApiMethodDescriptor.<SetDefaultBranchRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.CatalogService/SetDefaultBranch")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetDefaultBranchRequest>newBuilder()
                      .setPath(
                          "/v2/{catalog=projects/*/locations/*/catalogs/*}:setDefaultBranch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetDefaultBranchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "catalog", request.getCatalog());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetDefaultBranchRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearCatalog().build()))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchMethodDescriptor =
          ApiMethodDescriptor.<GetDefaultBranchRequest, GetDefaultBranchResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.CatalogService/GetDefaultBranch")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDefaultBranchRequest>newBuilder()
                      .setPath(
                          "/v2/{catalog=projects/*/locations/*/catalogs/*}:getDefaultBranch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDefaultBranchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "catalog", request.getCatalog());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDefaultBranchRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GetDefaultBranchResponse>newBuilder()
                      .setDefaultInstance(GetDefaultBranchResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable;
  private final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable;
  private final UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable;
  private final UnaryCallable<SetDefaultBranchRequest, Empty> setDefaultBranchCallable;
  private final UnaryCallable<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCatalogServiceStub create(CatalogServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCatalogServiceStub(
        CatalogServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCatalogServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCatalogServiceStub(
        CatalogServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCatalogServiceStub(
      CatalogServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCatalogServiceStub(
      CatalogServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListCatalogsRequest, ListCatalogsResponse> listCatalogsTransportSettings =
        HttpJsonCallSettings.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
            .setMethodDescriptor(listCatalogsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCatalogRequest, Catalog> updateCatalogTransportSettings =
        HttpJsonCallSettings.<UpdateCatalogRequest, Catalog>newBuilder()
            .setMethodDescriptor(updateCatalogMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetDefaultBranchRequest, Empty> setDefaultBranchTransportSettings =
        HttpJsonCallSettings.<SetDefaultBranchRequest, Empty>newBuilder()
            .setMethodDescriptor(setDefaultBranchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDefaultBranchRequest, GetDefaultBranchResponse>
        getDefaultBranchTransportSettings =
            HttpJsonCallSettings.<GetDefaultBranchRequest, GetDefaultBranchResponse>newBuilder()
                .setMethodDescriptor(getDefaultBranchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listCatalogsMethodDescriptor);
    methodDescriptors.add(updateCatalogMethodDescriptor);
    methodDescriptors.add(setDefaultBranchMethodDescriptor);
    methodDescriptors.add(getDefaultBranchMethodDescriptor);
    return methodDescriptors;
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
