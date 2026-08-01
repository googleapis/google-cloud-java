/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.CreativeSetServiceClient.ListCreativeSetsPagedResponse;

import com.google.ads.admanager.v1.CreateCreativeSetRequest;
import com.google.ads.admanager.v1.CreativeSet;
import com.google.ads.admanager.v1.GetCreativeSetRequest;
import com.google.ads.admanager.v1.ListCreativeSetsRequest;
import com.google.ads.admanager.v1.ListCreativeSetsResponse;
import com.google.ads.admanager.v1.UpdateCreativeSetRequest;
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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CreativeSetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonCreativeSetServiceStub extends CreativeSetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCreativeSetRequest, CreativeSet>
      getCreativeSetMethodDescriptor =
          ApiMethodDescriptor.<GetCreativeSetRequest, CreativeSet>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CreativeSetService/GetCreativeSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCreativeSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/creativeSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreativeSet>newBuilder()
                      .setDefaultInstance(CreativeSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCreativeSetsRequest, ListCreativeSetsResponse>
      listCreativeSetsMethodDescriptor =
          ApiMethodDescriptor.<ListCreativeSetsRequest, ListCreativeSetsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CreativeSetService/ListCreativeSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCreativeSetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativeSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativeSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCreativeSetsResponse>newBuilder()
                      .setDefaultInstance(ListCreativeSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCreativeSetRequest, CreativeSet>
      createCreativeSetMethodDescriptor =
          ApiMethodDescriptor.<CreateCreativeSetRequest, CreativeSet>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CreativeSetService/CreateCreativeSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCreativeSetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCreativeSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCreativeSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("creativeSet", request.getCreativeSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreativeSet>newBuilder()
                      .setDefaultInstance(CreativeSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCreativeSetRequest, CreativeSet>
      updateCreativeSetMethodDescriptor =
          ApiMethodDescriptor.<UpdateCreativeSetRequest, CreativeSet>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CreativeSetService/UpdateCreativeSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCreativeSetRequest>newBuilder()
                      .setPath(
                          "/v1/{creativeSet.name=networks/*/creativeSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCreativeSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "creativeSet.name", request.getCreativeSet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCreativeSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("creativeSet", request.getCreativeSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreativeSet>newBuilder()
                      .setDefaultInstance(CreativeSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCreativeSetRequest, CreativeSet> getCreativeSetCallable;
  private final UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsResponse>
      listCreativeSetsCallable;
  private final UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsPagedResponse>
      listCreativeSetsPagedCallable;
  private final UnaryCallable<CreateCreativeSetRequest, CreativeSet> createCreativeSetCallable;
  private final UnaryCallable<UpdateCreativeSetRequest, CreativeSet> updateCreativeSetCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCreativeSetServiceStub create(CreativeSetServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCreativeSetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCreativeSetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCreativeSetServiceStub(
        CreativeSetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCreativeSetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCreativeSetServiceStub(
        CreativeSetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCreativeSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeSetServiceStub(
      CreativeSetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCreativeSetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCreativeSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeSetServiceStub(
      CreativeSetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCreativeSetRequest, CreativeSet> getCreativeSetTransportSettings =
        HttpJsonCallSettings.<GetCreativeSetRequest, CreativeSet>newBuilder()
            .setMethodDescriptor(getCreativeSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListCreativeSetsRequest, ListCreativeSetsResponse>
        listCreativeSetsTransportSettings =
            HttpJsonCallSettings.<ListCreativeSetsRequest, ListCreativeSetsResponse>newBuilder()
                .setMethodDescriptor(listCreativeSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateCreativeSetRequest, CreativeSet> createCreativeSetTransportSettings =
        HttpJsonCallSettings.<CreateCreativeSetRequest, CreativeSet>newBuilder()
            .setMethodDescriptor(createCreativeSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateCreativeSetRequest, CreativeSet> updateCreativeSetTransportSettings =
        HttpJsonCallSettings.<UpdateCreativeSetRequest, CreativeSet>newBuilder()
            .setMethodDescriptor(updateCreativeSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "creative_set.name", String.valueOf(request.getCreativeSet().getName()));
                  return builder.build();
                })
            .build();

    this.getCreativeSetCallable =
        callableFactory.createUnaryCallable(
            getCreativeSetTransportSettings, settings.getCreativeSetSettings(), clientContext);
    this.listCreativeSetsCallable =
        callableFactory.createUnaryCallable(
            listCreativeSetsTransportSettings, settings.listCreativeSetsSettings(), clientContext);
    this.listCreativeSetsPagedCallable =
        callableFactory.createPagedCallable(
            listCreativeSetsTransportSettings, settings.listCreativeSetsSettings(), clientContext);
    this.createCreativeSetCallable =
        callableFactory.createUnaryCallable(
            createCreativeSetTransportSettings,
            settings.createCreativeSetSettings(),
            clientContext);
    this.updateCreativeSetCallable =
        callableFactory.createUnaryCallable(
            updateCreativeSetTransportSettings,
            settings.updateCreativeSetSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCreativeSetMethodDescriptor);
    methodDescriptors.add(listCreativeSetsMethodDescriptor);
    methodDescriptors.add(createCreativeSetMethodDescriptor);
    methodDescriptors.add(updateCreativeSetMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCreativeSetRequest, CreativeSet> getCreativeSetCallable() {
    return getCreativeSetCallable;
  }

  @Override
  public UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsResponse>
      listCreativeSetsCallable() {
    return listCreativeSetsCallable;
  }

  @Override
  public UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsPagedResponse>
      listCreativeSetsPagedCallable() {
    return listCreativeSetsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCreativeSetRequest, CreativeSet> createCreativeSetCallable() {
    return createCreativeSetCallable;
  }

  @Override
  public UnaryCallable<UpdateCreativeSetRequest, CreativeSet> updateCreativeSetCallable() {
    return updateCreativeSetCallable;
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
