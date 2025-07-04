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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.PrivateAuctionServiceClient.ListPrivateAuctionsPagedResponse;

import com.google.ads.admanager.v1.CreatePrivateAuctionRequest;
import com.google.ads.admanager.v1.GetPrivateAuctionRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionsRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionsResponse;
import com.google.ads.admanager.v1.PrivateAuction;
import com.google.ads.admanager.v1.UpdatePrivateAuctionRequest;
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
 * REST stub implementation for the PrivateAuctionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonPrivateAuctionServiceStub extends PrivateAuctionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetPrivateAuctionRequest, PrivateAuction>
      getPrivateAuctionMethodDescriptor =
          ApiMethodDescriptor.<GetPrivateAuctionRequest, PrivateAuction>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.PrivateAuctionService/GetPrivateAuction")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrivateAuctionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/privateAuctions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateAuctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateAuctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateAuction>newBuilder()
                      .setDefaultInstance(PrivateAuction.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>
      listPrivateAuctionsMethodDescriptor =
          ApiMethodDescriptor.<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.PrivateAuctionService/ListPrivateAuctions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrivateAuctionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/privateAuctions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateAuctionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateAuctionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPrivateAuctionsResponse>newBuilder()
                      .setDefaultInstance(ListPrivateAuctionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePrivateAuctionRequest, PrivateAuction>
      createPrivateAuctionMethodDescriptor =
          ApiMethodDescriptor.<CreatePrivateAuctionRequest, PrivateAuction>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.PrivateAuctionService/CreatePrivateAuction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePrivateAuctionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/privateAuctions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateAuctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateAuctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateAuction", request.getPrivateAuction(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateAuction>newBuilder()
                      .setDefaultInstance(PrivateAuction.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePrivateAuctionRequest, PrivateAuction>
      updatePrivateAuctionMethodDescriptor =
          ApiMethodDescriptor.<UpdatePrivateAuctionRequest, PrivateAuction>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.PrivateAuctionService/UpdatePrivateAuction")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePrivateAuctionRequest>newBuilder()
                      .setPath(
                          "/v1/{privateAuction.name=networks/*/privateAuctions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateAuctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "privateAuction.name",
                                request.getPrivateAuction().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateAuctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateAuction", request.getPrivateAuction(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateAuction>newBuilder()
                      .setDefaultInstance(PrivateAuction.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetPrivateAuctionRequest, PrivateAuction> getPrivateAuctionCallable;
  private final UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>
      listPrivateAuctionsCallable;
  private final UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsPagedResponse>
      listPrivateAuctionsPagedCallable;
  private final UnaryCallable<CreatePrivateAuctionRequest, PrivateAuction>
      createPrivateAuctionCallable;
  private final UnaryCallable<UpdatePrivateAuctionRequest, PrivateAuction>
      updatePrivateAuctionCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPrivateAuctionServiceStub create(
      PrivateAuctionServiceStubSettings settings) throws IOException {
    return new HttpJsonPrivateAuctionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPrivateAuctionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPrivateAuctionServiceStub(
        PrivateAuctionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPrivateAuctionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPrivateAuctionServiceStub(
        PrivateAuctionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPrivateAuctionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivateAuctionServiceStub(
      PrivateAuctionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPrivateAuctionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPrivateAuctionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivateAuctionServiceStub(
      PrivateAuctionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetPrivateAuctionRequest, PrivateAuction>
        getPrivateAuctionTransportSettings =
            HttpJsonCallSettings.<GetPrivateAuctionRequest, PrivateAuction>newBuilder()
                .setMethodDescriptor(getPrivateAuctionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>
        listPrivateAuctionsTransportSettings =
            HttpJsonCallSettings
                .<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>newBuilder()
                .setMethodDescriptor(listPrivateAuctionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePrivateAuctionRequest, PrivateAuction>
        createPrivateAuctionTransportSettings =
            HttpJsonCallSettings.<CreatePrivateAuctionRequest, PrivateAuction>newBuilder()
                .setMethodDescriptor(createPrivateAuctionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePrivateAuctionRequest, PrivateAuction>
        updatePrivateAuctionTransportSettings =
            HttpJsonCallSettings.<UpdatePrivateAuctionRequest, PrivateAuction>newBuilder()
                .setMethodDescriptor(updatePrivateAuctionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "private_auction.name",
                          String.valueOf(request.getPrivateAuction().getName()));
                      return builder.build();
                    })
                .build();

    this.getPrivateAuctionCallable =
        callableFactory.createUnaryCallable(
            getPrivateAuctionTransportSettings,
            settings.getPrivateAuctionSettings(),
            clientContext);
    this.listPrivateAuctionsCallable =
        callableFactory.createUnaryCallable(
            listPrivateAuctionsTransportSettings,
            settings.listPrivateAuctionsSettings(),
            clientContext);
    this.listPrivateAuctionsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateAuctionsTransportSettings,
            settings.listPrivateAuctionsSettings(),
            clientContext);
    this.createPrivateAuctionCallable =
        callableFactory.createUnaryCallable(
            createPrivateAuctionTransportSettings,
            settings.createPrivateAuctionSettings(),
            clientContext);
    this.updatePrivateAuctionCallable =
        callableFactory.createUnaryCallable(
            updatePrivateAuctionTransportSettings,
            settings.updatePrivateAuctionSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getPrivateAuctionMethodDescriptor);
    methodDescriptors.add(listPrivateAuctionsMethodDescriptor);
    methodDescriptors.add(createPrivateAuctionMethodDescriptor);
    methodDescriptors.add(updatePrivateAuctionMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetPrivateAuctionRequest, PrivateAuction> getPrivateAuctionCallable() {
    return getPrivateAuctionCallable;
  }

  @Override
  public UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>
      listPrivateAuctionsCallable() {
    return listPrivateAuctionsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsPagedResponse>
      listPrivateAuctionsPagedCallable() {
    return listPrivateAuctionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateAuctionRequest, PrivateAuction> createPrivateAuctionCallable() {
    return createPrivateAuctionCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateAuctionRequest, PrivateAuction> updatePrivateAuctionCallable() {
    return updatePrivateAuctionCallable;
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
