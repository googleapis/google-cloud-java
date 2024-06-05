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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.GetRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse;
import com.google.shopping.merchant.accounts.v1beta.Region;
import com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonRegionsServiceStub extends RegionsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetRegionRequest, Region> getRegionMethodDescriptor =
      ApiMethodDescriptor.<GetRegionRequest, Region>newBuilder()
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.RegionsService/GetRegion")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRegionRequest>newBuilder()
                  .setPath(
                      "/accounts/v1beta/{name=accounts/*/regions/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRegionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRegionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Region>newBuilder()
                  .setDefaultInstance(Region.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateRegionRequest, Region>
      createRegionMethodDescriptor =
          ApiMethodDescriptor.<CreateRegionRequest, Region>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.RegionsService/CreateRegion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRegionRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/regions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRegionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRegionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "regionId", request.getRegionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("region", request.getRegion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Region>newBuilder()
                      .setDefaultInstance(Region.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRegionRequest, Region>
      updateRegionMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionRequest, Region>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.RegionsService/UpdateRegion")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegionRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{region.name=accounts/*/regions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "region.name", request.getRegion().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("region", request.getRegion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Region>newBuilder()
                      .setDefaultInstance(Region.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRegionRequest, Empty>
      deleteRegionMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.RegionsService/DeleteRegion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/regions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRegionsRequest, ListRegionsResponse>
      listRegionsMethodDescriptor =
          ApiMethodDescriptor.<ListRegionsRequest, ListRegionsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.RegionsService/ListRegions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/regions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRegionsResponse>newBuilder()
                      .setDefaultInstance(ListRegionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetRegionRequest, Region> getRegionCallable;
  private final UnaryCallable<CreateRegionRequest, Region> createRegionCallable;
  private final UnaryCallable<UpdateRegionRequest, Region> updateRegionCallable;
  private final UnaryCallable<DeleteRegionRequest, Empty> deleteRegionCallable;
  private final UnaryCallable<ListRegionsRequest, ListRegionsResponse> listRegionsCallable;
  private final UnaryCallable<ListRegionsRequest, ListRegionsPagedResponse>
      listRegionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionsServiceStub create(RegionsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonRegionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionsServiceStub(
        RegionsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionsServiceStub(
        RegionsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionsServiceStub(
      RegionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionsServiceStub(
      RegionsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetRegionRequest, Region> getRegionTransportSettings =
        HttpJsonCallSettings.<GetRegionRequest, Region>newBuilder()
            .setMethodDescriptor(getRegionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateRegionRequest, Region> createRegionTransportSettings =
        HttpJsonCallSettings.<CreateRegionRequest, Region>newBuilder()
            .setMethodDescriptor(createRegionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRegionRequest, Region> updateRegionTransportSettings =
        HttpJsonCallSettings.<UpdateRegionRequest, Region>newBuilder()
            .setMethodDescriptor(updateRegionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("region.name", String.valueOf(request.getRegion().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRegionRequest, Empty> deleteRegionTransportSettings =
        HttpJsonCallSettings.<DeleteRegionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRegionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRegionsRequest, ListRegionsResponse> listRegionsTransportSettings =
        HttpJsonCallSettings.<ListRegionsRequest, ListRegionsResponse>newBuilder()
            .setMethodDescriptor(listRegionsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getRegionMethodDescriptor);
    methodDescriptors.add(createRegionMethodDescriptor);
    methodDescriptors.add(updateRegionMethodDescriptor);
    methodDescriptors.add(deleteRegionMethodDescriptor);
    methodDescriptors.add(listRegionsMethodDescriptor);
    return methodDescriptors;
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
