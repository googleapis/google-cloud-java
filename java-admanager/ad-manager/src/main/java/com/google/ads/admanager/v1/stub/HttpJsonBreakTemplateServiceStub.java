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

import static com.google.ads.admanager.v1.BreakTemplateServiceClient.ListBreakTemplatesPagedResponse;

import com.google.ads.admanager.v1.BatchCreateBreakTemplatesRequest;
import com.google.ads.admanager.v1.BatchCreateBreakTemplatesResponse;
import com.google.ads.admanager.v1.BatchUpdateBreakTemplatesRequest;
import com.google.ads.admanager.v1.BatchUpdateBreakTemplatesResponse;
import com.google.ads.admanager.v1.BreakTemplate;
import com.google.ads.admanager.v1.CreateBreakTemplateRequest;
import com.google.ads.admanager.v1.GetBreakTemplateRequest;
import com.google.ads.admanager.v1.ListBreakTemplatesRequest;
import com.google.ads.admanager.v1.ListBreakTemplatesResponse;
import com.google.ads.admanager.v1.UpdateBreakTemplateRequest;
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
 * REST stub implementation for the BreakTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonBreakTemplateServiceStub extends BreakTemplateServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBreakTemplateRequest, BreakTemplate>
      getBreakTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetBreakTemplateRequest, BreakTemplate>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.BreakTemplateService/GetBreakTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBreakTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/breakTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBreakTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBreakTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BreakTemplate>newBuilder()
                      .setDefaultInstance(BreakTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBreakTemplatesRequest, ListBreakTemplatesResponse>
      listBreakTemplatesMethodDescriptor =
          ApiMethodDescriptor.<ListBreakTemplatesRequest, ListBreakTemplatesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.BreakTemplateService/ListBreakTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBreakTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/breakTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBreakTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBreakTemplatesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBreakTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListBreakTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBreakTemplateRequest, BreakTemplate>
      createBreakTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateBreakTemplateRequest, BreakTemplate>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.BreakTemplateService/CreateBreakTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBreakTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/breakTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBreakTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBreakTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("breakTemplate", request.getBreakTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BreakTemplate>newBuilder()
                      .setDefaultInstance(BreakTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
      batchCreateBreakTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.BreakTemplateService/BatchCreateBreakTemplates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateBreakTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/breakTemplates:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateBreakTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateBreakTemplatesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateBreakTemplatesResponse>newBuilder()
                      .setDefaultInstance(BatchCreateBreakTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBreakTemplateRequest, BreakTemplate>
      updateBreakTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateBreakTemplateRequest, BreakTemplate>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.BreakTemplateService/UpdateBreakTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBreakTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{breakTemplate.name=networks/*/breakTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBreakTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "breakTemplate.name", request.getBreakTemplate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBreakTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("breakTemplate", request.getBreakTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BreakTemplate>newBuilder()
                      .setDefaultInstance(BreakTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
      batchUpdateBreakTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.BreakTemplateService/BatchUpdateBreakTemplates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateBreakTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/breakTemplates:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateBreakTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateBreakTemplatesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateBreakTemplatesResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateBreakTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBreakTemplateRequest, BreakTemplate> getBreakTemplateCallable;
  private final UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesResponse>
      listBreakTemplatesCallable;
  private final UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesPagedResponse>
      listBreakTemplatesPagedCallable;
  private final UnaryCallable<CreateBreakTemplateRequest, BreakTemplate>
      createBreakTemplateCallable;
  private final UnaryCallable<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
      batchCreateBreakTemplatesCallable;
  private final UnaryCallable<UpdateBreakTemplateRequest, BreakTemplate>
      updateBreakTemplateCallable;
  private final UnaryCallable<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
      batchUpdateBreakTemplatesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBreakTemplateServiceStub create(
      BreakTemplateServiceStubSettings settings) throws IOException {
    return new HttpJsonBreakTemplateServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBreakTemplateServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBreakTemplateServiceStub(
        BreakTemplateServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBreakTemplateServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBreakTemplateServiceStub(
        BreakTemplateServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBreakTemplateServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBreakTemplateServiceStub(
      BreakTemplateServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBreakTemplateServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBreakTemplateServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBreakTemplateServiceStub(
      BreakTemplateServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBreakTemplateRequest, BreakTemplate> getBreakTemplateTransportSettings =
        HttpJsonCallSettings.<GetBreakTemplateRequest, BreakTemplate>newBuilder()
            .setMethodDescriptor(getBreakTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListBreakTemplatesRequest, ListBreakTemplatesResponse>
        listBreakTemplatesTransportSettings =
            HttpJsonCallSettings.<ListBreakTemplatesRequest, ListBreakTemplatesResponse>newBuilder()
                .setMethodDescriptor(listBreakTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateBreakTemplateRequest, BreakTemplate>
        createBreakTemplateTransportSettings =
            HttpJsonCallSettings.<CreateBreakTemplateRequest, BreakTemplate>newBuilder()
                .setMethodDescriptor(createBreakTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
        batchCreateBreakTemplatesTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>newBuilder()
                .setMethodDescriptor(batchCreateBreakTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateBreakTemplateRequest, BreakTemplate>
        updateBreakTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateBreakTemplateRequest, BreakTemplate>newBuilder()
                .setMethodDescriptor(updateBreakTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "break_template.name",
                          String.valueOf(request.getBreakTemplate().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
        batchUpdateBreakTemplatesTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>newBuilder()
                .setMethodDescriptor(batchUpdateBreakTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getBreakTemplateCallable =
        callableFactory.createUnaryCallable(
            getBreakTemplateTransportSettings, settings.getBreakTemplateSettings(), clientContext);
    this.listBreakTemplatesCallable =
        callableFactory.createUnaryCallable(
            listBreakTemplatesTransportSettings,
            settings.listBreakTemplatesSettings(),
            clientContext);
    this.listBreakTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listBreakTemplatesTransportSettings,
            settings.listBreakTemplatesSettings(),
            clientContext);
    this.createBreakTemplateCallable =
        callableFactory.createUnaryCallable(
            createBreakTemplateTransportSettings,
            settings.createBreakTemplateSettings(),
            clientContext);
    this.batchCreateBreakTemplatesCallable =
        callableFactory.createUnaryCallable(
            batchCreateBreakTemplatesTransportSettings,
            settings.batchCreateBreakTemplatesSettings(),
            clientContext);
    this.updateBreakTemplateCallable =
        callableFactory.createUnaryCallable(
            updateBreakTemplateTransportSettings,
            settings.updateBreakTemplateSettings(),
            clientContext);
    this.batchUpdateBreakTemplatesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateBreakTemplatesTransportSettings,
            settings.batchUpdateBreakTemplatesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBreakTemplateMethodDescriptor);
    methodDescriptors.add(listBreakTemplatesMethodDescriptor);
    methodDescriptors.add(createBreakTemplateMethodDescriptor);
    methodDescriptors.add(batchCreateBreakTemplatesMethodDescriptor);
    methodDescriptors.add(updateBreakTemplateMethodDescriptor);
    methodDescriptors.add(batchUpdateBreakTemplatesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBreakTemplateRequest, BreakTemplate> getBreakTemplateCallable() {
    return getBreakTemplateCallable;
  }

  @Override
  public UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesResponse>
      listBreakTemplatesCallable() {
    return listBreakTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesPagedResponse>
      listBreakTemplatesPagedCallable() {
    return listBreakTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateBreakTemplateRequest, BreakTemplate> createBreakTemplateCallable() {
    return createBreakTemplateCallable;
  }

  @Override
  public UnaryCallable<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
      batchCreateBreakTemplatesCallable() {
    return batchCreateBreakTemplatesCallable;
  }

  @Override
  public UnaryCallable<UpdateBreakTemplateRequest, BreakTemplate> updateBreakTemplateCallable() {
    return updateBreakTemplateCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
      batchUpdateBreakTemplatesCallable() {
    return batchUpdateBreakTemplatesCallable;
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
