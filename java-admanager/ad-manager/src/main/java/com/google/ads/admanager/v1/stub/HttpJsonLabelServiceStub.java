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

import static com.google.ads.admanager.v1.LabelServiceClient.ListLabelsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLabelsRequest;
import com.google.ads.admanager.v1.BatchActivateLabelsResponse;
import com.google.ads.admanager.v1.BatchCreateLabelsRequest;
import com.google.ads.admanager.v1.BatchCreateLabelsResponse;
import com.google.ads.admanager.v1.BatchDeactivateLabelsRequest;
import com.google.ads.admanager.v1.BatchDeactivateLabelsResponse;
import com.google.ads.admanager.v1.BatchUpdateLabelsRequest;
import com.google.ads.admanager.v1.BatchUpdateLabelsResponse;
import com.google.ads.admanager.v1.CreateLabelRequest;
import com.google.ads.admanager.v1.GetLabelRequest;
import com.google.ads.admanager.v1.Label;
import com.google.ads.admanager.v1.ListLabelsRequest;
import com.google.ads.admanager.v1.ListLabelsResponse;
import com.google.ads.admanager.v1.UpdateLabelRequest;
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
 * REST stub implementation for the LabelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonLabelServiceStub extends LabelServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLabelRequest, Label> getLabelMethodDescriptor =
      ApiMethodDescriptor.<GetLabelRequest, Label>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.LabelService/GetLabel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetLabelRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/labels/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Label>newBuilder()
                  .setDefaultInstance(Label.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListLabelsRequest, ListLabelsResponse>
      listLabelsMethodDescriptor =
          ApiMethodDescriptor.<ListLabelsRequest, ListLabelsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LabelService/ListLabels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/labels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLabelsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLabelsResponse>newBuilder()
                      .setDefaultInstance(ListLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateLabelRequest, Label> createLabelMethodDescriptor =
      ApiMethodDescriptor.<CreateLabelRequest, Label>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.LabelService/CreateLabel")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateLabelRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=networks/*}/labels",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("label", request.getLabel(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Label>newBuilder()
                  .setDefaultInstance(Label.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchCreateLabelsRequest, BatchCreateLabelsResponse>
      batchCreateLabelsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateLabelsRequest, BatchCreateLabelsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LabelService/BatchCreateLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/labels:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLabelsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateLabelsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateLabelRequest, Label> updateLabelMethodDescriptor =
      ApiMethodDescriptor.<UpdateLabelRequest, Label>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.LabelService/UpdateLabel")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateLabelRequest>newBuilder()
                  .setPath(
                      "/v1/{label.name=networks/*/labels/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "label.name", request.getLabel().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateLabelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("label", request.getLabel(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Label>newBuilder()
                  .setDefaultInstance(Label.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>
      batchUpdateLabelsMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LabelService/BatchUpdateLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/labels:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLabelsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateLabelsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchActivateLabelsRequest, BatchActivateLabelsResponse>
      batchActivateLabelsMethodDescriptor =
          ApiMethodDescriptor.<BatchActivateLabelsRequest, BatchActivateLabelsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LabelService/BatchActivateLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/labels:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLabelsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateLabelsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>
      batchDeactivateLabelsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LabelService/BatchDeactivateLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/labels:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateLabelsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateLabelsResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLabelRequest, Label> getLabelCallable;
  private final UnaryCallable<ListLabelsRequest, ListLabelsResponse> listLabelsCallable;
  private final UnaryCallable<ListLabelsRequest, ListLabelsPagedResponse> listLabelsPagedCallable;
  private final UnaryCallable<CreateLabelRequest, Label> createLabelCallable;
  private final UnaryCallable<BatchCreateLabelsRequest, BatchCreateLabelsResponse>
      batchCreateLabelsCallable;
  private final UnaryCallable<UpdateLabelRequest, Label> updateLabelCallable;
  private final UnaryCallable<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>
      batchUpdateLabelsCallable;
  private final UnaryCallable<BatchActivateLabelsRequest, BatchActivateLabelsResponse>
      batchActivateLabelsCallable;
  private final UnaryCallable<BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>
      batchDeactivateLabelsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLabelServiceStub create(LabelServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLabelServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLabelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLabelServiceStub(
        LabelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLabelServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLabelServiceStub(
        LabelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLabelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLabelServiceStub(LabelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLabelServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLabelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLabelServiceStub(
      LabelServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLabelRequest, Label> getLabelTransportSettings =
        HttpJsonCallSettings.<GetLabelRequest, Label>newBuilder()
            .setMethodDescriptor(getLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListLabelsRequest, ListLabelsResponse> listLabelsTransportSettings =
        HttpJsonCallSettings.<ListLabelsRequest, ListLabelsResponse>newBuilder()
            .setMethodDescriptor(listLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateLabelRequest, Label> createLabelTransportSettings =
        HttpJsonCallSettings.<CreateLabelRequest, Label>newBuilder()
            .setMethodDescriptor(createLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateLabelsRequest, BatchCreateLabelsResponse>
        batchCreateLabelsTransportSettings =
            HttpJsonCallSettings.<BatchCreateLabelsRequest, BatchCreateLabelsResponse>newBuilder()
                .setMethodDescriptor(batchCreateLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateLabelRequest, Label> updateLabelTransportSettings =
        HttpJsonCallSettings.<UpdateLabelRequest, Label>newBuilder()
            .setMethodDescriptor(updateLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("label.name", String.valueOf(request.getLabel().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>
        batchUpdateLabelsTransportSettings =
            HttpJsonCallSettings.<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateLabelsRequest, BatchActivateLabelsResponse>
        batchActivateLabelsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateLabelsRequest, BatchActivateLabelsResponse>newBuilder()
                .setMethodDescriptor(batchActivateLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>
        batchDeactivateLabelsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>newBuilder()
                .setMethodDescriptor(batchDeactivateLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getLabelCallable =
        callableFactory.createUnaryCallable(
            getLabelTransportSettings, settings.getLabelSettings(), clientContext);
    this.listLabelsCallable =
        callableFactory.createUnaryCallable(
            listLabelsTransportSettings, settings.listLabelsSettings(), clientContext);
    this.listLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listLabelsTransportSettings, settings.listLabelsSettings(), clientContext);
    this.createLabelCallable =
        callableFactory.createUnaryCallable(
            createLabelTransportSettings, settings.createLabelSettings(), clientContext);
    this.batchCreateLabelsCallable =
        callableFactory.createUnaryCallable(
            batchCreateLabelsTransportSettings,
            settings.batchCreateLabelsSettings(),
            clientContext);
    this.updateLabelCallable =
        callableFactory.createUnaryCallable(
            updateLabelTransportSettings, settings.updateLabelSettings(), clientContext);
    this.batchUpdateLabelsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateLabelsTransportSettings,
            settings.batchUpdateLabelsSettings(),
            clientContext);
    this.batchActivateLabelsCallable =
        callableFactory.createUnaryCallable(
            batchActivateLabelsTransportSettings,
            settings.batchActivateLabelsSettings(),
            clientContext);
    this.batchDeactivateLabelsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateLabelsTransportSettings,
            settings.batchDeactivateLabelsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLabelMethodDescriptor);
    methodDescriptors.add(listLabelsMethodDescriptor);
    methodDescriptors.add(createLabelMethodDescriptor);
    methodDescriptors.add(batchCreateLabelsMethodDescriptor);
    methodDescriptors.add(updateLabelMethodDescriptor);
    methodDescriptors.add(batchUpdateLabelsMethodDescriptor);
    methodDescriptors.add(batchActivateLabelsMethodDescriptor);
    methodDescriptors.add(batchDeactivateLabelsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLabelRequest, Label> getLabelCallable() {
    return getLabelCallable;
  }

  @Override
  public UnaryCallable<ListLabelsRequest, ListLabelsResponse> listLabelsCallable() {
    return listLabelsCallable;
  }

  @Override
  public UnaryCallable<ListLabelsRequest, ListLabelsPagedResponse> listLabelsPagedCallable() {
    return listLabelsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateLabelRequest, Label> createLabelCallable() {
    return createLabelCallable;
  }

  @Override
  public UnaryCallable<BatchCreateLabelsRequest, BatchCreateLabelsResponse>
      batchCreateLabelsCallable() {
    return batchCreateLabelsCallable;
  }

  @Override
  public UnaryCallable<UpdateLabelRequest, Label> updateLabelCallable() {
    return updateLabelCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>
      batchUpdateLabelsCallable() {
    return batchUpdateLabelsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateLabelsRequest, BatchActivateLabelsResponse>
      batchActivateLabelsCallable() {
    return batchActivateLabelsCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>
      batchDeactivateLabelsCallable() {
    return batchDeactivateLabelsCallable;
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
