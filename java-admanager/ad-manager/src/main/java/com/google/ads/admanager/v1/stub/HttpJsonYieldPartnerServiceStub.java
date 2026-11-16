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

import static com.google.ads.admanager.v1.YieldPartnerServiceClient.ListYieldPartnersPagedResponse;

import com.google.ads.admanager.v1.GetYieldPartnerRequest;
import com.google.ads.admanager.v1.ListYieldPartnersRequest;
import com.google.ads.admanager.v1.ListYieldPartnersResponse;
import com.google.ads.admanager.v1.YieldPartner;
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
 * REST stub implementation for the YieldPartnerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonYieldPartnerServiceStub extends YieldPartnerServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetYieldPartnerRequest, YieldPartner>
      getYieldPartnerMethodDescriptor =
          ApiMethodDescriptor.<GetYieldPartnerRequest, YieldPartner>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldPartnerService/GetYieldPartner")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetYieldPartnerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/yieldPartners/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetYieldPartnerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetYieldPartnerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<YieldPartner>newBuilder()
                      .setDefaultInstance(YieldPartner.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListYieldPartnersRequest, ListYieldPartnersResponse>
      listYieldPartnersMethodDescriptor =
          ApiMethodDescriptor.<ListYieldPartnersRequest, ListYieldPartnersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldPartnerService/ListYieldPartners")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListYieldPartnersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldPartners",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListYieldPartnersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListYieldPartnersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListYieldPartnersResponse>newBuilder()
                      .setDefaultInstance(ListYieldPartnersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetYieldPartnerRequest, YieldPartner> getYieldPartnerCallable;
  private final UnaryCallable<ListYieldPartnersRequest, ListYieldPartnersResponse>
      listYieldPartnersCallable;
  private final UnaryCallable<ListYieldPartnersRequest, ListYieldPartnersPagedResponse>
      listYieldPartnersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonYieldPartnerServiceStub create(
      YieldPartnerServiceStubSettings settings) throws IOException {
    return new HttpJsonYieldPartnerServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonYieldPartnerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonYieldPartnerServiceStub(
        YieldPartnerServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonYieldPartnerServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonYieldPartnerServiceStub(
        YieldPartnerServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonYieldPartnerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonYieldPartnerServiceStub(
      YieldPartnerServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonYieldPartnerServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonYieldPartnerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonYieldPartnerServiceStub(
      YieldPartnerServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetYieldPartnerRequest, YieldPartner> getYieldPartnerTransportSettings =
        HttpJsonCallSettings.<GetYieldPartnerRequest, YieldPartner>newBuilder()
            .setMethodDescriptor(getYieldPartnerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListYieldPartnersRequest, ListYieldPartnersResponse>
        listYieldPartnersTransportSettings =
            HttpJsonCallSettings.<ListYieldPartnersRequest, ListYieldPartnersResponse>newBuilder()
                .setMethodDescriptor(listYieldPartnersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getYieldPartnerCallable =
        callableFactory.createUnaryCallable(
            getYieldPartnerTransportSettings, settings.getYieldPartnerSettings(), clientContext);
    this.listYieldPartnersCallable =
        callableFactory.createUnaryCallable(
            listYieldPartnersTransportSettings,
            settings.listYieldPartnersSettings(),
            clientContext);
    this.listYieldPartnersPagedCallable =
        callableFactory.createPagedCallable(
            listYieldPartnersTransportSettings,
            settings.listYieldPartnersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getYieldPartnerMethodDescriptor);
    methodDescriptors.add(listYieldPartnersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetYieldPartnerRequest, YieldPartner> getYieldPartnerCallable() {
    return getYieldPartnerCallable;
  }

  @Override
  public UnaryCallable<ListYieldPartnersRequest, ListYieldPartnersResponse>
      listYieldPartnersCallable() {
    return listYieldPartnersCallable;
  }

  @Override
  public UnaryCallable<ListYieldPartnersRequest, ListYieldPartnersPagedResponse>
      listYieldPartnersPagedCallable() {
    return listYieldPartnersPagedCallable;
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
