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

import static com.google.ads.admanager.v1.MobileCarrierServiceClient.ListMobileCarriersPagedResponse;

import com.google.ads.admanager.v1.GetMobileCarrierRequest;
import com.google.ads.admanager.v1.ListMobileCarriersRequest;
import com.google.ads.admanager.v1.ListMobileCarriersResponse;
import com.google.ads.admanager.v1.MobileCarrier;
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
 * REST stub implementation for the MobileCarrierService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonMobileCarrierServiceStub extends MobileCarrierServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetMobileCarrierRequest, MobileCarrier>
      getMobileCarrierMethodDescriptor =
          ApiMethodDescriptor.<GetMobileCarrierRequest, MobileCarrier>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.MobileCarrierService/GetMobileCarrier")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMobileCarrierRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/mobileCarriers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMobileCarrierRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMobileCarrierRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MobileCarrier>newBuilder()
                      .setDefaultInstance(MobileCarrier.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMobileCarriersRequest, ListMobileCarriersResponse>
      listMobileCarriersMethodDescriptor =
          ApiMethodDescriptor.<ListMobileCarriersRequest, ListMobileCarriersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.MobileCarrierService/ListMobileCarriers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMobileCarriersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/mobileCarriers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMobileCarriersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMobileCarriersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMobileCarriersResponse>newBuilder()
                      .setDefaultInstance(ListMobileCarriersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetMobileCarrierRequest, MobileCarrier> getMobileCarrierCallable;
  private final UnaryCallable<ListMobileCarriersRequest, ListMobileCarriersResponse>
      listMobileCarriersCallable;
  private final UnaryCallable<ListMobileCarriersRequest, ListMobileCarriersPagedResponse>
      listMobileCarriersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMobileCarrierServiceStub create(
      MobileCarrierServiceStubSettings settings) throws IOException {
    return new HttpJsonMobileCarrierServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMobileCarrierServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMobileCarrierServiceStub(
        MobileCarrierServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonMobileCarrierServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMobileCarrierServiceStub(
        MobileCarrierServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMobileCarrierServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMobileCarrierServiceStub(
      MobileCarrierServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMobileCarrierServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMobileCarrierServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMobileCarrierServiceStub(
      MobileCarrierServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetMobileCarrierRequest, MobileCarrier> getMobileCarrierTransportSettings =
        HttpJsonCallSettings.<GetMobileCarrierRequest, MobileCarrier>newBuilder()
            .setMethodDescriptor(getMobileCarrierMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMobileCarriersRequest, ListMobileCarriersResponse>
        listMobileCarriersTransportSettings =
            HttpJsonCallSettings.<ListMobileCarriersRequest, ListMobileCarriersResponse>newBuilder()
                .setMethodDescriptor(listMobileCarriersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getMobileCarrierCallable =
        callableFactory.createUnaryCallable(
            getMobileCarrierTransportSettings, settings.getMobileCarrierSettings(), clientContext);
    this.listMobileCarriersCallable =
        callableFactory.createUnaryCallable(
            listMobileCarriersTransportSettings,
            settings.listMobileCarriersSettings(),
            clientContext);
    this.listMobileCarriersPagedCallable =
        callableFactory.createPagedCallable(
            listMobileCarriersTransportSettings,
            settings.listMobileCarriersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMobileCarrierMethodDescriptor);
    methodDescriptors.add(listMobileCarriersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetMobileCarrierRequest, MobileCarrier> getMobileCarrierCallable() {
    return getMobileCarrierCallable;
  }

  @Override
  public UnaryCallable<ListMobileCarriersRequest, ListMobileCarriersResponse>
      listMobileCarriersCallable() {
    return listMobileCarriersCallable;
  }

  @Override
  public UnaryCallable<ListMobileCarriersRequest, ListMobileCarriersPagedResponse>
      listMobileCarriersPagedCallable() {
    return listMobileCarriersPagedCallable;
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
