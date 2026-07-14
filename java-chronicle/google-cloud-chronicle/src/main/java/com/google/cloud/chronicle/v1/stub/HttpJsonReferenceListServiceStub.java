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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.ReferenceListServiceClient.ListReferenceListsPagedResponse;

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
import com.google.cloud.chronicle.v1.CreateReferenceListRequest;
import com.google.cloud.chronicle.v1.GetReferenceListRequest;
import com.google.cloud.chronicle.v1.ListReferenceListsRequest;
import com.google.cloud.chronicle.v1.ListReferenceListsResponse;
import com.google.cloud.chronicle.v1.ReferenceList;
import com.google.cloud.chronicle.v1.UpdateReferenceListRequest;
import com.google.cloud.chronicle.v1.VerifyReferenceListRequest;
import com.google.cloud.chronicle.v1.VerifyReferenceListResponse;
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
 * REST stub implementation for the ReferenceListService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonReferenceListServiceStub extends ReferenceListServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetReferenceListRequest, ReferenceList>
      getReferenceListMethodDescriptor =
          ApiMethodDescriptor.<GetReferenceListRequest, ReferenceList>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.ReferenceListService/GetReferenceList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReferenceListRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/referenceLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReferenceList>newBuilder()
                      .setDefaultInstance(ReferenceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsMethodDescriptor =
          ApiMethodDescriptor.<ListReferenceListsRequest, ListReferenceListsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.ReferenceListService/ListReferenceLists")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReferenceListsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/referenceLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReferenceListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReferenceListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReferenceListsResponse>newBuilder()
                      .setDefaultInstance(ListReferenceListsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReferenceListRequest, ReferenceList>
      createReferenceListMethodDescriptor =
          ApiMethodDescriptor.<CreateReferenceListRequest, ReferenceList>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.ReferenceListService/CreateReferenceList")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReferenceListRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/referenceLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "referenceListId", request.getReferenceListId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("referenceList", request.getReferenceList(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReferenceList>newBuilder()
                      .setDefaultInstance(ReferenceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateReferenceListRequest, ReferenceList>
      updateReferenceListMethodDescriptor =
          ApiMethodDescriptor.<UpdateReferenceListRequest, ReferenceList>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.ReferenceListService/UpdateReferenceList")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReferenceListRequest>newBuilder()
                      .setPath(
                          "/v1/{referenceList.name=projects/*/locations/*/instances/*/referenceLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "referenceList.name", request.getReferenceList().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("referenceList", request.getReferenceList(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReferenceList>newBuilder()
                      .setDefaultInstance(ReferenceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<VerifyReferenceListRequest, VerifyReferenceListResponse>
      verifyReferenceListMethodDescriptor =
          ApiMethodDescriptor.<VerifyReferenceListRequest, VerifyReferenceListResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.ReferenceListService/VerifyReferenceList")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<VerifyReferenceListRequest>newBuilder()
                      .setPath(
                          "/v1/{instance=projects/*/locations/*/instances/*}:verifyReferenceList",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyReferenceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearInstance().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VerifyReferenceListResponse>newBuilder()
                      .setDefaultInstance(VerifyReferenceListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetReferenceListRequest, ReferenceList> getReferenceListCallable;
  private final UnaryCallable<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsCallable;
  private final UnaryCallable<ListReferenceListsRequest, ListReferenceListsPagedResponse>
      listReferenceListsPagedCallable;
  private final UnaryCallable<CreateReferenceListRequest, ReferenceList>
      createReferenceListCallable;
  private final UnaryCallable<UpdateReferenceListRequest, ReferenceList>
      updateReferenceListCallable;
  private final UnaryCallable<VerifyReferenceListRequest, VerifyReferenceListResponse>
      verifyReferenceListCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReferenceListServiceStub create(
      ReferenceListServiceStubSettings settings) throws IOException {
    return new HttpJsonReferenceListServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReferenceListServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReferenceListServiceStub(
        ReferenceListServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonReferenceListServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReferenceListServiceStub(
        ReferenceListServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReferenceListServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReferenceListServiceStub(
      ReferenceListServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonReferenceListServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReferenceListServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReferenceListServiceStub(
      ReferenceListServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetReferenceListRequest, ReferenceList> getReferenceListTransportSettings =
        HttpJsonCallSettings.<GetReferenceListRequest, ReferenceList>newBuilder()
            .setMethodDescriptor(getReferenceListMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListReferenceListsRequest, ListReferenceListsResponse>
        listReferenceListsTransportSettings =
            HttpJsonCallSettings.<ListReferenceListsRequest, ListReferenceListsResponse>newBuilder()
                .setMethodDescriptor(listReferenceListsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateReferenceListRequest, ReferenceList>
        createReferenceListTransportSettings =
            HttpJsonCallSettings.<CreateReferenceListRequest, ReferenceList>newBuilder()
                .setMethodDescriptor(createReferenceListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateReferenceListRequest, ReferenceList>
        updateReferenceListTransportSettings =
            HttpJsonCallSettings.<UpdateReferenceListRequest, ReferenceList>newBuilder()
                .setMethodDescriptor(updateReferenceListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "reference_list.name",
                          String.valueOf(request.getReferenceList().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<VerifyReferenceListRequest, VerifyReferenceListResponse>
        verifyReferenceListTransportSettings =
            HttpJsonCallSettings
                .<VerifyReferenceListRequest, VerifyReferenceListResponse>newBuilder()
                .setMethodDescriptor(verifyReferenceListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getInstance())
                .build();

    this.getReferenceListCallable =
        callableFactory.createUnaryCallable(
            getReferenceListTransportSettings, settings.getReferenceListSettings(), clientContext);
    this.listReferenceListsCallable =
        callableFactory.createUnaryCallable(
            listReferenceListsTransportSettings,
            settings.listReferenceListsSettings(),
            clientContext);
    this.listReferenceListsPagedCallable =
        callableFactory.createPagedCallable(
            listReferenceListsTransportSettings,
            settings.listReferenceListsSettings(),
            clientContext);
    this.createReferenceListCallable =
        callableFactory.createUnaryCallable(
            createReferenceListTransportSettings,
            settings.createReferenceListSettings(),
            clientContext);
    this.updateReferenceListCallable =
        callableFactory.createUnaryCallable(
            updateReferenceListTransportSettings,
            settings.updateReferenceListSettings(),
            clientContext);
    this.verifyReferenceListCallable =
        callableFactory.createUnaryCallable(
            verifyReferenceListTransportSettings,
            settings.verifyReferenceListSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getReferenceListMethodDescriptor);
    methodDescriptors.add(listReferenceListsMethodDescriptor);
    methodDescriptors.add(createReferenceListMethodDescriptor);
    methodDescriptors.add(updateReferenceListMethodDescriptor);
    methodDescriptors.add(verifyReferenceListMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetReferenceListRequest, ReferenceList> getReferenceListCallable() {
    return getReferenceListCallable;
  }

  @Override
  public UnaryCallable<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsCallable() {
    return listReferenceListsCallable;
  }

  @Override
  public UnaryCallable<ListReferenceListsRequest, ListReferenceListsPagedResponse>
      listReferenceListsPagedCallable() {
    return listReferenceListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateReferenceListRequest, ReferenceList> createReferenceListCallable() {
    return createReferenceListCallable;
  }

  @Override
  public UnaryCallable<UpdateReferenceListRequest, ReferenceList> updateReferenceListCallable() {
    return updateReferenceListCallable;
  }

  @Override
  public UnaryCallable<VerifyReferenceListRequest, VerifyReferenceListResponse>
      verifyReferenceListCallable() {
    return verifyReferenceListCallable;
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
