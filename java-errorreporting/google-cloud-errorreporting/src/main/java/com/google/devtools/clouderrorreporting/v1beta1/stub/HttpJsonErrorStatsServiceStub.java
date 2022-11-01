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

package com.google.devtools.clouderrorreporting.v1beta1.stub;

import static com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceClient.ListEventsPagedResponse;
import static com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceClient.ListGroupStatsPagedResponse;

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
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
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
 * REST stub implementation for the ErrorStatsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonErrorStatsServiceStub extends ErrorStatsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListGroupStatsRequest, ListGroupStatsResponse>
      listGroupStatsMethodDescriptor =
          ApiMethodDescriptor.<ListGroupStatsRequest, ListGroupStatsResponse>newBuilder()
              .setFullMethodName(
                  "google.devtools.clouderrorreporting.v1beta1.ErrorStatsService/ListGroupStats")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGroupStatsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{projectName=projects/*}/groupStats",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGroupStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "projectName", request.getProjectName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGroupStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "alignment", request.getAlignmentValue());
                            serializer.putQueryParam(
                                fields, "alignmentTime", request.getAlignmentTime());
                            serializer.putQueryParam(fields, "groupId", request.getGroupIdList());
                            serializer.putQueryParam(fields, "order", request.getOrderValue());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "serviceFilter", request.getServiceFilter());
                            serializer.putQueryParam(fields, "timeRange", request.getTimeRange());
                            serializer.putQueryParam(
                                fields, "timedCountDuration", request.getTimedCountDuration());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGroupStatsResponse>newBuilder()
                      .setDefaultInstance(ListGroupStatsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEventsRequest, ListEventsResponse>
      listEventsMethodDescriptor =
          ApiMethodDescriptor.<ListEventsRequest, ListEventsResponse>newBuilder()
              .setFullMethodName(
                  "google.devtools.clouderrorreporting.v1beta1.ErrorStatsService/ListEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEventsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{projectName=projects/*}/events",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "projectName", request.getProjectName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "groupId", request.getGroupId());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "serviceFilter", request.getServiceFilter());
                            serializer.putQueryParam(fields, "timeRange", request.getTimeRange());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEventsResponse>newBuilder()
                      .setDefaultInstance(ListEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEventsRequest, DeleteEventsResponse>
      deleteEventsMethodDescriptor =
          ApiMethodDescriptor.<DeleteEventsRequest, DeleteEventsResponse>newBuilder()
              .setFullMethodName(
                  "google.devtools.clouderrorreporting.v1beta1.ErrorStatsService/DeleteEvents")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEventsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{projectName=projects/*}/events",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "projectName", request.getProjectName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteEventsResponse>newBuilder()
                      .setDefaultInstance(DeleteEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> listGroupStatsCallable;
  private final UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable;
  private final UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonErrorStatsServiceStub create(ErrorStatsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonErrorStatsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonErrorStatsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonErrorStatsServiceStub(
        ErrorStatsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonErrorStatsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonErrorStatsServiceStub(
        ErrorStatsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonErrorStatsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonErrorStatsServiceStub(
      ErrorStatsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonErrorStatsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonErrorStatsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonErrorStatsServiceStub(
      ErrorStatsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListGroupStatsRequest, ListGroupStatsResponse>
        listGroupStatsTransportSettings =
            HttpJsonCallSettings.<ListGroupStatsRequest, ListGroupStatsResponse>newBuilder()
                .setMethodDescriptor(listGroupStatsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListEventsRequest, ListEventsResponse> listEventsTransportSettings =
        HttpJsonCallSettings.<ListEventsRequest, ListEventsResponse>newBuilder()
            .setMethodDescriptor(listEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteEventsRequest, DeleteEventsResponse> deleteEventsTransportSettings =
        HttpJsonCallSettings.<DeleteEventsRequest, DeleteEventsResponse>newBuilder()
            .setMethodDescriptor(deleteEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listGroupStatsCallable =
        callableFactory.createUnaryCallable(
            listGroupStatsTransportSettings, settings.listGroupStatsSettings(), clientContext);
    this.listGroupStatsPagedCallable =
        callableFactory.createPagedCallable(
            listGroupStatsTransportSettings, settings.listGroupStatsSettings(), clientContext);
    this.listEventsCallable =
        callableFactory.createUnaryCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.listEventsPagedCallable =
        callableFactory.createPagedCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.deleteEventsCallable =
        callableFactory.createUnaryCallable(
            deleteEventsTransportSettings, settings.deleteEventsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listGroupStatsMethodDescriptor);
    methodDescriptors.add(listEventsMethodDescriptor);
    methodDescriptors.add(deleteEventsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> listGroupStatsCallable() {
    return listGroupStatsCallable;
  }

  @Override
  public UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable() {
    return listGroupStatsPagedCallable;
  }

  @Override
  public UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return listEventsCallable;
  }

  @Override
  public UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return listEventsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable() {
    return deleteEventsCallable;
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
