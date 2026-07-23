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

import static com.google.ads.admanager.v1.SlateServiceClient.ListSlatesPagedResponse;

import com.google.ads.admanager.v1.BatchArchiveSlatesRequest;
import com.google.ads.admanager.v1.BatchArchiveSlatesResponse;
import com.google.ads.admanager.v1.BatchCreateSlatesRequest;
import com.google.ads.admanager.v1.BatchCreateSlatesResponse;
import com.google.ads.admanager.v1.BatchUnarchiveSlatesRequest;
import com.google.ads.admanager.v1.BatchUnarchiveSlatesResponse;
import com.google.ads.admanager.v1.BatchUpdateSlatesRequest;
import com.google.ads.admanager.v1.BatchUpdateSlatesResponse;
import com.google.ads.admanager.v1.CreateSlateRequest;
import com.google.ads.admanager.v1.GetSlateRequest;
import com.google.ads.admanager.v1.ListSlatesRequest;
import com.google.ads.admanager.v1.ListSlatesResponse;
import com.google.ads.admanager.v1.Slate;
import com.google.ads.admanager.v1.UpdateSlateRequest;
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
 * REST stub implementation for the SlateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonSlateServiceStub extends SlateServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetSlateRequest, Slate> getSlateMethodDescriptor =
      ApiMethodDescriptor.<GetSlateRequest, Slate>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.SlateService/GetSlate")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSlateRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/slates/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSlateRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSlateRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Slate>newBuilder()
                  .setDefaultInstance(Slate.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListSlatesRequest, ListSlatesResponse>
      listSlatesMethodDescriptor =
          ApiMethodDescriptor.<ListSlatesRequest, ListSlatesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SlateService/ListSlates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSlatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/slates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSlatesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSlatesResponse>newBuilder()
                      .setDefaultInstance(ListSlatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSlateRequest, Slate> createSlateMethodDescriptor =
      ApiMethodDescriptor.<CreateSlateRequest, Slate>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.SlateService/CreateSlate")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSlateRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=networks/*}/slates",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSlateRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSlateRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("slate", request.getSlate(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Slate>newBuilder()
                  .setDefaultInstance(Slate.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateSlatesRequest, BatchCreateSlatesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SlateService/BatchCreateSlates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateSlatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/slates:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateSlatesResponse>newBuilder()
                      .setDefaultInstance(BatchCreateSlatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSlateRequest, Slate> updateSlateMethodDescriptor =
      ApiMethodDescriptor.<UpdateSlateRequest, Slate>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.SlateService/UpdateSlate")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSlateRequest>newBuilder()
                  .setPath(
                      "/v1/{slate.name=networks/*/slates/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSlateRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "slate.name", request.getSlate().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSlateRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("slate", request.getSlate(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Slate>newBuilder()
                  .setDefaultInstance(Slate.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SlateService/BatchUpdateSlates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateSlatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/slates:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUpdateSlatesResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateSlatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesMethodDescriptor =
          ApiMethodDescriptor.<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SlateService/BatchArchiveSlates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveSlatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/slates:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchArchiveSlatesResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveSlatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SlateService/BatchUnarchiveSlates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUnarchiveSlatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/slates:batchUnarchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveSlatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUnarchiveSlatesResponse>newBuilder()
                      .setDefaultInstance(BatchUnarchiveSlatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetSlateRequest, Slate> getSlateCallable;
  private final UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable;
  private final UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable;
  private final UnaryCallable<CreateSlateRequest, Slate> createSlateCallable;
  private final UnaryCallable<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesCallable;
  private final UnaryCallable<UpdateSlateRequest, Slate> updateSlateCallable;
  private final UnaryCallable<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesCallable;
  private final UnaryCallable<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesCallable;
  private final UnaryCallable<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSlateServiceStub create(SlateServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSlateServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSlateServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSlateServiceStub(
        SlateServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSlateServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSlateServiceStub(
        SlateServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSlateServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSlateServiceStub(SlateServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSlateServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSlateServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSlateServiceStub(
      SlateServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetSlateRequest, Slate> getSlateTransportSettings =
        HttpJsonCallSettings.<GetSlateRequest, Slate>newBuilder()
            .setMethodDescriptor(getSlateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListSlatesRequest, ListSlatesResponse> listSlatesTransportSettings =
        HttpJsonCallSettings.<ListSlatesRequest, ListSlatesResponse>newBuilder()
            .setMethodDescriptor(listSlatesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateSlateRequest, Slate> createSlateTransportSettings =
        HttpJsonCallSettings.<CreateSlateRequest, Slate>newBuilder()
            .setMethodDescriptor(createSlateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
        batchCreateSlatesTransportSettings =
            HttpJsonCallSettings.<BatchCreateSlatesRequest, BatchCreateSlatesResponse>newBuilder()
                .setMethodDescriptor(batchCreateSlatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateSlateRequest, Slate> updateSlateTransportSettings =
        HttpJsonCallSettings.<UpdateSlateRequest, Slate>newBuilder()
            .setMethodDescriptor(updateSlateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("slate.name", String.valueOf(request.getSlate().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
        batchUpdateSlatesTransportSettings =
            HttpJsonCallSettings.<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>newBuilder()
                .setMethodDescriptor(batchUpdateSlatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
        batchArchiveSlatesTransportSettings =
            HttpJsonCallSettings.<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>newBuilder()
                .setMethodDescriptor(batchArchiveSlatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
        batchUnarchiveSlatesTransportSettings =
            HttpJsonCallSettings
                .<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>newBuilder()
                .setMethodDescriptor(batchUnarchiveSlatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getSlateCallable =
        callableFactory.createUnaryCallable(
            getSlateTransportSettings, settings.getSlateSettings(), clientContext);
    this.listSlatesCallable =
        callableFactory.createUnaryCallable(
            listSlatesTransportSettings, settings.listSlatesSettings(), clientContext);
    this.listSlatesPagedCallable =
        callableFactory.createPagedCallable(
            listSlatesTransportSettings, settings.listSlatesSettings(), clientContext);
    this.createSlateCallable =
        callableFactory.createUnaryCallable(
            createSlateTransportSettings, settings.createSlateSettings(), clientContext);
    this.batchCreateSlatesCallable =
        callableFactory.createUnaryCallable(
            batchCreateSlatesTransportSettings,
            settings.batchCreateSlatesSettings(),
            clientContext);
    this.updateSlateCallable =
        callableFactory.createUnaryCallable(
            updateSlateTransportSettings, settings.updateSlateSettings(), clientContext);
    this.batchUpdateSlatesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateSlatesTransportSettings,
            settings.batchUpdateSlatesSettings(),
            clientContext);
    this.batchArchiveSlatesCallable =
        callableFactory.createUnaryCallable(
            batchArchiveSlatesTransportSettings,
            settings.batchArchiveSlatesSettings(),
            clientContext);
    this.batchUnarchiveSlatesCallable =
        callableFactory.createUnaryCallable(
            batchUnarchiveSlatesTransportSettings,
            settings.batchUnarchiveSlatesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSlateMethodDescriptor);
    methodDescriptors.add(listSlatesMethodDescriptor);
    methodDescriptors.add(createSlateMethodDescriptor);
    methodDescriptors.add(batchCreateSlatesMethodDescriptor);
    methodDescriptors.add(updateSlateMethodDescriptor);
    methodDescriptors.add(batchUpdateSlatesMethodDescriptor);
    methodDescriptors.add(batchArchiveSlatesMethodDescriptor);
    methodDescriptors.add(batchUnarchiveSlatesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetSlateRequest, Slate> getSlateCallable() {
    return getSlateCallable;
  }

  @Override
  public UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable() {
    return listSlatesCallable;
  }

  @Override
  public UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable() {
    return listSlatesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSlateRequest, Slate> createSlateCallable() {
    return createSlateCallable;
  }

  @Override
  public UnaryCallable<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesCallable() {
    return batchCreateSlatesCallable;
  }

  @Override
  public UnaryCallable<UpdateSlateRequest, Slate> updateSlateCallable() {
    return updateSlateCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesCallable() {
    return batchUpdateSlatesCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesCallable() {
    return batchArchiveSlatesCallable;
  }

  @Override
  public UnaryCallable<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesCallable() {
    return batchUnarchiveSlatesCallable;
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
