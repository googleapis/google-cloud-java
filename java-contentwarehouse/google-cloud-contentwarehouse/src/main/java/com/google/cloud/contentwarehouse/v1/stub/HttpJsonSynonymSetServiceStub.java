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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.SynonymSetServiceClient.ListSynonymSetsPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest;
import com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse;
import com.google.cloud.contentwarehouse.v1.SynonymSet;
import com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest;
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
 * REST stub implementation for the SynonymSetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSynonymSetServiceStub extends SynonymSetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSynonymSetRequest, SynonymSet>
      createSynonymSetMethodDescriptor =
          ApiMethodDescriptor.<CreateSynonymSetRequest, SynonymSet>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/CreateSynonymSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSynonymSetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/synonymSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSynonymSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSynonymSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("synonymSet", request.getSynonymSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SynonymSet>newBuilder()
                      .setDefaultInstance(SynonymSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSynonymSetRequest, SynonymSet>
      getSynonymSetMethodDescriptor =
          ApiMethodDescriptor.<GetSynonymSetRequest, SynonymSet>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.SynonymSetService/GetSynonymSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSynonymSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/synonymSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSynonymSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSynonymSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SynonymSet>newBuilder()
                      .setDefaultInstance(SynonymSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSynonymSetRequest, SynonymSet>
      updateSynonymSetMethodDescriptor =
          ApiMethodDescriptor.<UpdateSynonymSetRequest, SynonymSet>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/UpdateSynonymSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSynonymSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/synonymSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSynonymSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSynonymSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("synonymSet", request.getSynonymSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SynonymSet>newBuilder()
                      .setDefaultInstance(SynonymSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSynonymSetRequest, Empty>
      deleteSynonymSetMethodDescriptor =
          ApiMethodDescriptor.<DeleteSynonymSetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/DeleteSynonymSet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSynonymSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/synonymSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSynonymSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSynonymSetRequest> serializer =
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

  private static final ApiMethodDescriptor<ListSynonymSetsRequest, ListSynonymSetsResponse>
      listSynonymSetsMethodDescriptor =
          ApiMethodDescriptor.<ListSynonymSetsRequest, ListSynonymSetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.SynonymSetService/ListSynonymSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSynonymSetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/synonymSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSynonymSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSynonymSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSynonymSetsResponse>newBuilder()
                      .setDefaultInstance(ListSynonymSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateSynonymSetRequest, SynonymSet> createSynonymSetCallable;
  private final UnaryCallable<GetSynonymSetRequest, SynonymSet> getSynonymSetCallable;
  private final UnaryCallable<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetCallable;
  private final UnaryCallable<DeleteSynonymSetRequest, Empty> deleteSynonymSetCallable;
  private final UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsResponse>
      listSynonymSetsCallable;
  private final UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsPagedResponse>
      listSynonymSetsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSynonymSetServiceStub create(SynonymSetServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSynonymSetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSynonymSetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSynonymSetServiceStub(
        SynonymSetServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSynonymSetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSynonymSetServiceStub(
        SynonymSetServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSynonymSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSynonymSetServiceStub(
      SynonymSetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSynonymSetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSynonymSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSynonymSetServiceStub(
      SynonymSetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSynonymSetRequest, SynonymSet> createSynonymSetTransportSettings =
        HttpJsonCallSettings.<CreateSynonymSetRequest, SynonymSet>newBuilder()
            .setMethodDescriptor(createSynonymSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSynonymSetRequest, SynonymSet> getSynonymSetTransportSettings =
        HttpJsonCallSettings.<GetSynonymSetRequest, SynonymSet>newBuilder()
            .setMethodDescriptor(getSynonymSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetTransportSettings =
        HttpJsonCallSettings.<UpdateSynonymSetRequest, SynonymSet>newBuilder()
            .setMethodDescriptor(updateSynonymSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSynonymSetRequest, Empty> deleteSynonymSetTransportSettings =
        HttpJsonCallSettings.<DeleteSynonymSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSynonymSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListSynonymSetsRequest, ListSynonymSetsResponse>
        listSynonymSetsTransportSettings =
            HttpJsonCallSettings.<ListSynonymSetsRequest, ListSynonymSetsResponse>newBuilder()
                .setMethodDescriptor(listSynonymSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createSynonymSetCallable =
        callableFactory.createUnaryCallable(
            createSynonymSetTransportSettings, settings.createSynonymSetSettings(), clientContext);
    this.getSynonymSetCallable =
        callableFactory.createUnaryCallable(
            getSynonymSetTransportSettings, settings.getSynonymSetSettings(), clientContext);
    this.updateSynonymSetCallable =
        callableFactory.createUnaryCallable(
            updateSynonymSetTransportSettings, settings.updateSynonymSetSettings(), clientContext);
    this.deleteSynonymSetCallable =
        callableFactory.createUnaryCallable(
            deleteSynonymSetTransportSettings, settings.deleteSynonymSetSettings(), clientContext);
    this.listSynonymSetsCallable =
        callableFactory.createUnaryCallable(
            listSynonymSetsTransportSettings, settings.listSynonymSetsSettings(), clientContext);
    this.listSynonymSetsPagedCallable =
        callableFactory.createPagedCallable(
            listSynonymSetsTransportSettings, settings.listSynonymSetsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSynonymSetMethodDescriptor);
    methodDescriptors.add(getSynonymSetMethodDescriptor);
    methodDescriptors.add(updateSynonymSetMethodDescriptor);
    methodDescriptors.add(deleteSynonymSetMethodDescriptor);
    methodDescriptors.add(listSynonymSetsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSynonymSetRequest, SynonymSet> createSynonymSetCallable() {
    return createSynonymSetCallable;
  }

  @Override
  public UnaryCallable<GetSynonymSetRequest, SynonymSet> getSynonymSetCallable() {
    return getSynonymSetCallable;
  }

  @Override
  public UnaryCallable<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetCallable() {
    return updateSynonymSetCallable;
  }

  @Override
  public UnaryCallable<DeleteSynonymSetRequest, Empty> deleteSynonymSetCallable() {
    return deleteSynonymSetCallable;
  }

  @Override
  public UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsResponse> listSynonymSetsCallable() {
    return listSynonymSetsCallable;
  }

  @Override
  public UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsPagedResponse>
      listSynonymSetsPagedCallable() {
    return listSynonymSetsPagedCallable;
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
