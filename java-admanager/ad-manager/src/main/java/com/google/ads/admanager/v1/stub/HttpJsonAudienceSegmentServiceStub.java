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

import static com.google.ads.admanager.v1.AudienceSegmentServiceClient.ListAudienceSegmentsPagedResponse;

import com.google.ads.admanager.v1.AudienceSegment;
import com.google.ads.admanager.v1.GetAudienceSegmentRequest;
import com.google.ads.admanager.v1.ListAudienceSegmentsRequest;
import com.google.ads.admanager.v1.ListAudienceSegmentsResponse;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AudienceSegmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAudienceSegmentServiceStub extends AudienceSegmentServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAudienceSegmentRequest, AudienceSegment>
      getAudienceSegmentMethodDescriptor =
          ApiMethodDescriptor.<GetAudienceSegmentRequest, AudienceSegment>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.AudienceSegmentService/GetAudienceSegment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAudienceSegmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/audienceSegments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AudienceSegment>newBuilder()
                      .setDefaultInstance(AudienceSegment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAudienceSegmentsRequest, ListAudienceSegmentsResponse>
      listAudienceSegmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.AudienceSegmentService/ListAudienceSegments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAudienceSegmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/audienceSegments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceSegmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceSegmentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAudienceSegmentsResponse>newBuilder()
                      .setDefaultInstance(ListAudienceSegmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAudienceSegmentRequest, AudienceSegment>
      getAudienceSegmentCallable;
  private final UnaryCallable<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse>
      listAudienceSegmentsCallable;
  private final UnaryCallable<ListAudienceSegmentsRequest, ListAudienceSegmentsPagedResponse>
      listAudienceSegmentsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAudienceSegmentServiceStub create(
      AudienceSegmentServiceStubSettings settings) throws IOException {
    return new HttpJsonAudienceSegmentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAudienceSegmentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAudienceSegmentServiceStub(
        AudienceSegmentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAudienceSegmentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAudienceSegmentServiceStub(
        AudienceSegmentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAudienceSegmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAudienceSegmentServiceStub(
      AudienceSegmentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAudienceSegmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAudienceSegmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAudienceSegmentServiceStub(
      AudienceSegmentServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAudienceSegmentRequest, AudienceSegment>
        getAudienceSegmentTransportSettings =
            HttpJsonCallSettings.<GetAudienceSegmentRequest, AudienceSegment>newBuilder()
                .setMethodDescriptor(getAudienceSegmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse>
        listAudienceSegmentsTransportSettings =
            HttpJsonCallSettings
                .<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse>newBuilder()
                .setMethodDescriptor(listAudienceSegmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getAudienceSegmentCallable =
        callableFactory.createUnaryCallable(
            getAudienceSegmentTransportSettings,
            settings.getAudienceSegmentSettings(),
            clientContext);
    this.listAudienceSegmentsCallable =
        callableFactory.createUnaryCallable(
            listAudienceSegmentsTransportSettings,
            settings.listAudienceSegmentsSettings(),
            clientContext);
    this.listAudienceSegmentsPagedCallable =
        callableFactory.createPagedCallable(
            listAudienceSegmentsTransportSettings,
            settings.listAudienceSegmentsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAudienceSegmentMethodDescriptor);
    methodDescriptors.add(listAudienceSegmentsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAudienceSegmentRequest, AudienceSegment> getAudienceSegmentCallable() {
    return getAudienceSegmentCallable;
  }

  @Override
  public UnaryCallable<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse>
      listAudienceSegmentsCallable() {
    return listAudienceSegmentsCallable;
  }

  @Override
  public UnaryCallable<ListAudienceSegmentsRequest, ListAudienceSegmentsPagedResponse>
      listAudienceSegmentsPagedCallable() {
    return listAudienceSegmentsPagedCallable;
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
