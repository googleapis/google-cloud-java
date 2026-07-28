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

import static com.google.ads.admanager.v1.TargetingPresetServiceClient.ListTargetingPresetsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateTargetingPresetsRequest;
import com.google.ads.admanager.v1.BatchCreateTargetingPresetsResponse;
import com.google.ads.admanager.v1.BatchDeactivateTargetingPresetsRequest;
import com.google.ads.admanager.v1.BatchDeactivateTargetingPresetsResponse;
import com.google.ads.admanager.v1.CreateTargetingPresetRequest;
import com.google.ads.admanager.v1.GetTargetingPresetRequest;
import com.google.ads.admanager.v1.ListTargetingPresetsRequest;
import com.google.ads.admanager.v1.ListTargetingPresetsResponse;
import com.google.ads.admanager.v1.TargetingPreset;
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
 * REST stub implementation for the TargetingPresetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonTargetingPresetServiceStub extends TargetingPresetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetTargetingPresetRequest, TargetingPreset>
      getTargetingPresetMethodDescriptor =
          ApiMethodDescriptor.<GetTargetingPresetRequest, TargetingPreset>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TargetingPresetService/GetTargetingPreset")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetingPresetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/targetingPresets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetingPresetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetingPresetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetingPreset>newBuilder()
                      .setDefaultInstance(TargetingPreset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListTargetingPresetsRequest, ListTargetingPresetsResponse>
      listTargetingPresetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListTargetingPresetsRequest, ListTargetingPresetsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TargetingPresetService/ListTargetingPresets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetingPresetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/targetingPresets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetingPresetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetingPresetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListTargetingPresetsResponse>newBuilder()
                      .setDefaultInstance(ListTargetingPresetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTargetingPresetRequest, TargetingPreset>
      createTargetingPresetMethodDescriptor =
          ApiMethodDescriptor.<CreateTargetingPresetRequest, TargetingPreset>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TargetingPresetService/CreateTargetingPreset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTargetingPresetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/targetingPresets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetingPresetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetingPresetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("targetingPreset", request.getTargetingPreset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetingPreset>newBuilder()
                      .setDefaultInstance(TargetingPreset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>
      batchCreateTargetingPresetsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TargetingPresetService/BatchCreateTargetingPresets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateTargetingPresetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/targetingPresets:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTargetingPresetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTargetingPresetsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateTargetingPresetsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateTargetingPresetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
      batchDeactivateTargetingPresetsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TargetingPresetService/BatchDeactivateTargetingPresets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateTargetingPresetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/targetingPreset:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateTargetingPresetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateTargetingPresetsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateTargetingPresetsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDeactivateTargetingPresetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetTargetingPresetRequest, TargetingPreset>
      getTargetingPresetCallable;
  private final UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsResponse>
      listTargetingPresetsCallable;
  private final UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsPagedResponse>
      listTargetingPresetsPagedCallable;
  private final UnaryCallable<CreateTargetingPresetRequest, TargetingPreset>
      createTargetingPresetCallable;
  private final UnaryCallable<
          BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>
      batchCreateTargetingPresetsCallable;
  private final UnaryCallable<
          BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
      batchDeactivateTargetingPresetsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetingPresetServiceStub create(
      TargetingPresetServiceStubSettings settings) throws IOException {
    return new HttpJsonTargetingPresetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetingPresetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetingPresetServiceStub(
        TargetingPresetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetingPresetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetingPresetServiceStub(
        TargetingPresetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetingPresetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetingPresetServiceStub(
      TargetingPresetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetingPresetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetingPresetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetingPresetServiceStub(
      TargetingPresetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetTargetingPresetRequest, TargetingPreset>
        getTargetingPresetTransportSettings =
            HttpJsonCallSettings.<GetTargetingPresetRequest, TargetingPreset>newBuilder()
                .setMethodDescriptor(getTargetingPresetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListTargetingPresetsRequest, ListTargetingPresetsResponse>
        listTargetingPresetsTransportSettings =
            HttpJsonCallSettings
                .<ListTargetingPresetsRequest, ListTargetingPresetsResponse>newBuilder()
                .setMethodDescriptor(listTargetingPresetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateTargetingPresetRequest, TargetingPreset>
        createTargetingPresetTransportSettings =
            HttpJsonCallSettings.<CreateTargetingPresetRequest, TargetingPreset>newBuilder()
                .setMethodDescriptor(createTargetingPresetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>
        batchCreateTargetingPresetsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateTargetingPresetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
        batchDeactivateTargetingPresetsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateTargetingPresetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getTargetingPresetCallable =
        callableFactory.createUnaryCallable(
            getTargetingPresetTransportSettings,
            settings.getTargetingPresetSettings(),
            clientContext);
    this.listTargetingPresetsCallable =
        callableFactory.createUnaryCallable(
            listTargetingPresetsTransportSettings,
            settings.listTargetingPresetsSettings(),
            clientContext);
    this.listTargetingPresetsPagedCallable =
        callableFactory.createPagedCallable(
            listTargetingPresetsTransportSettings,
            settings.listTargetingPresetsSettings(),
            clientContext);
    this.createTargetingPresetCallable =
        callableFactory.createUnaryCallable(
            createTargetingPresetTransportSettings,
            settings.createTargetingPresetSettings(),
            clientContext);
    this.batchCreateTargetingPresetsCallable =
        callableFactory.createUnaryCallable(
            batchCreateTargetingPresetsTransportSettings,
            settings.batchCreateTargetingPresetsSettings(),
            clientContext);
    this.batchDeactivateTargetingPresetsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateTargetingPresetsTransportSettings,
            settings.batchDeactivateTargetingPresetsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTargetingPresetMethodDescriptor);
    methodDescriptors.add(listTargetingPresetsMethodDescriptor);
    methodDescriptors.add(createTargetingPresetMethodDescriptor);
    methodDescriptors.add(batchCreateTargetingPresetsMethodDescriptor);
    methodDescriptors.add(batchDeactivateTargetingPresetsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetTargetingPresetRequest, TargetingPreset> getTargetingPresetCallable() {
    return getTargetingPresetCallable;
  }

  @Override
  public UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsResponse>
      listTargetingPresetsCallable() {
    return listTargetingPresetsCallable;
  }

  @Override
  public UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsPagedResponse>
      listTargetingPresetsPagedCallable() {
    return listTargetingPresetsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTargetingPresetRequest, TargetingPreset>
      createTargetingPresetCallable() {
    return createTargetingPresetCallable;
  }

  @Override
  public UnaryCallable<BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>
      batchCreateTargetingPresetsCallable() {
    return batchCreateTargetingPresetsCallable;
  }

  @Override
  public UnaryCallable<
          BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
      batchDeactivateTargetingPresetsCallable() {
    return batchDeactivateTargetingPresetsCallable;
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
