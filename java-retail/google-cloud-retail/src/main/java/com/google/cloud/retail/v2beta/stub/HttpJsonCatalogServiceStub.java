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
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCatalogServiceStub extends CatalogServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListCatalogsRequest, ListCatalogsResponse>
      listCatalogsMethodDescriptor =
          ApiMethodDescriptor.<ListCatalogsRequest, ListCatalogsResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/ListCatalogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCatalogsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*}/catalogs",
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
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/UpdateCatalog")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCatalogRequest>newBuilder()
                      .setPath(
                          "/v2beta/{catalog.name=projects/*/locations/*/catalogs/*}",
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
                              ProtoRestSerializer.create()
                                  .toBody("catalog", request.getCatalog(), false))
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
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/SetDefaultBranch")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetDefaultBranchRequest>newBuilder()
                      .setPath(
                          "/v2beta/{catalog=projects/*/locations/*/catalogs/*}:setDefaultBranch",
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
                                  .toBody("*", request.toBuilder().clearCatalog().build(), false))
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
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/GetDefaultBranch")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDefaultBranchRequest>newBuilder()
                      .setPath(
                          "/v2beta/{catalog=projects/*/locations/*/catalogs/*}:getDefaultBranch",
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

  private static final ApiMethodDescriptor<GetCompletionConfigRequest, CompletionConfig>
      getCompletionConfigMethodDescriptor =
          ApiMethodDescriptor.<GetCompletionConfigRequest, CompletionConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/GetCompletionConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCompletionConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/locations/*/catalogs/*/completionConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCompletionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCompletionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompletionConfig>newBuilder()
                      .setDefaultInstance(CompletionConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateCompletionConfigRequest, CompletionConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/UpdateCompletionConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCompletionConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{completionConfig.name=projects/*/locations/*/catalogs/*/completionConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCompletionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "completionConfig.name",
                                request.getCompletionConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCompletionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("completionConfig", request.getCompletionConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompletionConfig>newBuilder()
                      .setDefaultInstance(CompletionConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAttributesConfigRequest, AttributesConfig>
      getAttributesConfigMethodDescriptor =
          ApiMethodDescriptor.<GetAttributesConfigRequest, AttributesConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/GetAttributesConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAttributesConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/locations/*/catalogs/*/attributesConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttributesConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttributesConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttributesConfig>newBuilder()
                      .setDefaultInstance(AttributesConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateAttributesConfigRequest, AttributesConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/UpdateAttributesConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAttributesConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{attributesConfig.name=projects/*/locations/*/catalogs/*/attributesConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttributesConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "attributesConfig.name",
                                request.getAttributesConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttributesConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attributesConfig", request.getAttributesConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttributesConfig>newBuilder()
                      .setDefaultInstance(AttributesConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AddCatalogAttributeRequest, AttributesConfig>
      addCatalogAttributeMethodDescriptor =
          ApiMethodDescriptor.<AddCatalogAttributeRequest, AttributesConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/AddCatalogAttribute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddCatalogAttributeRequest>newBuilder()
                      .setPath(
                          "/v2beta/{attributesConfig=projects/*/locations/*/catalogs/*/attributesConfig}:addCatalogAttribute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddCatalogAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "attributesConfig", request.getAttributesConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddCatalogAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearAttributesConfig().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttributesConfig>newBuilder()
                      .setDefaultInstance(AttributesConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeMethodDescriptor =
          ApiMethodDescriptor.<RemoveCatalogAttributeRequest, AttributesConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.CatalogService/RemoveCatalogAttribute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveCatalogAttributeRequest>newBuilder()
                      .setPath(
                          "/v2beta/{attributesConfig=projects/*/locations/*/catalogs/*/attributesConfig}:removeCatalogAttribute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveCatalogAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "attributesConfig", request.getAttributesConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveCatalogAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearAttributesConfig().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttributesConfig>newBuilder()
                      .setDefaultInstance(AttributesConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.CatalogService/BatchRemoveCatalogAttributes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRemoveCatalogAttributesRequest>newBuilder()
                      .setPath(
                          "/v2beta/{attributesConfig=projects/*/locations/*/catalogs/*/attributesConfig}:batchRemoveCatalogAttributes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRemoveCatalogAttributesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "attributesConfig", request.getAttributesConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRemoveCatalogAttributesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearAttributesConfig().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchRemoveCatalogAttributesResponse>newBuilder()
                      .setDefaultInstance(BatchRemoveCatalogAttributesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeMethodDescriptor =
          ApiMethodDescriptor.<ReplaceCatalogAttributeRequest, AttributesConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.CatalogService/ReplaceCatalogAttribute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReplaceCatalogAttributeRequest>newBuilder()
                      .setPath(
                          "/v2beta/{attributesConfig=projects/*/locations/*/catalogs/*/attributesConfig}:replaceCatalogAttribute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceCatalogAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "attributesConfig", request.getAttributesConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceCatalogAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearAttributesConfig().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttributesConfig>newBuilder()
                      .setDefaultInstance(AttributesConfig.getDefaultInstance())
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
    HttpJsonCallSettings<GetCompletionConfigRequest, CompletionConfig>
        getCompletionConfigTransportSettings =
            HttpJsonCallSettings.<GetCompletionConfigRequest, CompletionConfig>newBuilder()
                .setMethodDescriptor(getCompletionConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCompletionConfigRequest, CompletionConfig>
        updateCompletionConfigTransportSettings =
            HttpJsonCallSettings.<UpdateCompletionConfigRequest, CompletionConfig>newBuilder()
                .setMethodDescriptor(updateCompletionConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAttributesConfigRequest, AttributesConfig>
        getAttributesConfigTransportSettings =
            HttpJsonCallSettings.<GetAttributesConfigRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(getAttributesConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAttributesConfigRequest, AttributesConfig>
        updateAttributesConfigTransportSettings =
            HttpJsonCallSettings.<UpdateAttributesConfigRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(updateAttributesConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddCatalogAttributeRequest, AttributesConfig>
        addCatalogAttributeTransportSettings =
            HttpJsonCallSettings.<AddCatalogAttributeRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(addCatalogAttributeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveCatalogAttributeRequest, AttributesConfig>
        removeCatalogAttributeTransportSettings =
            HttpJsonCallSettings.<RemoveCatalogAttributeRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(removeCatalogAttributeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
        batchRemoveCatalogAttributesTransportSettings =
            HttpJsonCallSettings
                .<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
                    newBuilder()
                .setMethodDescriptor(batchRemoveCatalogAttributesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ReplaceCatalogAttributeRequest, AttributesConfig>
        replaceCatalogAttributeTransportSettings =
            HttpJsonCallSettings.<ReplaceCatalogAttributeRequest, AttributesConfig>newBuilder()
                .setMethodDescriptor(replaceCatalogAttributeMethodDescriptor)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listCatalogsMethodDescriptor);
    methodDescriptors.add(updateCatalogMethodDescriptor);
    methodDescriptors.add(setDefaultBranchMethodDescriptor);
    methodDescriptors.add(getDefaultBranchMethodDescriptor);
    methodDescriptors.add(getCompletionConfigMethodDescriptor);
    methodDescriptors.add(updateCompletionConfigMethodDescriptor);
    methodDescriptors.add(getAttributesConfigMethodDescriptor);
    methodDescriptors.add(updateAttributesConfigMethodDescriptor);
    methodDescriptors.add(addCatalogAttributeMethodDescriptor);
    methodDescriptors.add(removeCatalogAttributeMethodDescriptor);
    methodDescriptors.add(batchRemoveCatalogAttributesMethodDescriptor);
    methodDescriptors.add(replaceCatalogAttributeMethodDescriptor);
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
