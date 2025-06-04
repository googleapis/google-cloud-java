/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ReservationSubBlocksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.GetReservationSubBlockRequest;
import com.google.cloud.compute.v1.ListReservationSubBlocksRequest;
import com.google.cloud.compute.v1.ReservationSubBlocksGetResponse;
import com.google.cloud.compute.v1.ReservationSubBlocksListResponse;
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
 * REST stub implementation for the ReservationSubBlocks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonReservationSubBlocksStub extends ReservationSubBlocksStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ReservationSubBlocks/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReservationSubBlockRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/{parentName}/reservationSubBlocks/{reservationSubBlock}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationSubBlockRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parentName", request.getParentName());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "reservationSubBlock", request.getReservationSubBlock());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationSubBlockRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationSubBlocksGetResponse>newBuilder()
                      .setDefaultInstance(ReservationSubBlocksGetResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ReservationSubBlocks/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReservationSubBlocksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/{parentName}/reservationSubBlocks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationSubBlocksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parentName", request.getParentName());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationSubBlocksRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationSubBlocksListResponse>newBuilder()
                      .setDefaultInstance(ReservationSubBlocksListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
      getCallable;
  private final UnaryCallable<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>
      listCallable;
  private final UnaryCallable<ListReservationSubBlocksRequest, ListPagedResponse> listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReservationSubBlocksStub create(
      ReservationSubBlocksStubSettings settings) throws IOException {
    return new HttpJsonReservationSubBlocksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReservationSubBlocksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReservationSubBlocksStub(
        ReservationSubBlocksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonReservationSubBlocksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReservationSubBlocksStub(
        ReservationSubBlocksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReservationSubBlocksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReservationSubBlocksStub(
      ReservationSubBlocksStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonReservationSubBlocksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReservationSubBlocksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReservationSubBlocksStub(
      ReservationSubBlocksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent_name", String.valueOf(request.getParentName()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add(
                          "reservation_sub_block",
                          String.valueOf(request.getReservationSubBlock()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent_name", String.valueOf(request.getParentName()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();

    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
      getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListReservationSubBlocksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
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
