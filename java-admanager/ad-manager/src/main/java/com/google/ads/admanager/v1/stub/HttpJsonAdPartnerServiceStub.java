/*
 * Copyright 2024 Google LLC
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

import static com.google.ads.admanager.v1.AdPartnerServiceClient.ListAdPartnersPagedResponse;

import com.google.ads.admanager.v1.AdPartner;
import com.google.ads.admanager.v1.GetAdPartnerRequest;
import com.google.ads.admanager.v1.ListAdPartnersRequest;
import com.google.ads.admanager.v1.ListAdPartnersResponse;
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
 * REST stub implementation for the AdPartnerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAdPartnerServiceStub extends AdPartnerServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAdPartnerRequest, AdPartner>
      getAdPartnerMethodDescriptor =
          ApiMethodDescriptor.<GetAdPartnerRequest, AdPartner>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdPartnerService/GetAdPartner")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAdPartnerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/adPartners/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdPartnerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdPartnerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdPartner>newBuilder()
                      .setDefaultInstance(AdPartner.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAdPartnersRequest, ListAdPartnersResponse>
      listAdPartnersMethodDescriptor =
          ApiMethodDescriptor.<ListAdPartnersRequest, ListAdPartnersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdPartnerService/ListAdPartners")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdPartnersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adPartners",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdPartnersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdPartnersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdPartnersResponse>newBuilder()
                      .setDefaultInstance(ListAdPartnersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAdPartnerRequest, AdPartner> getAdPartnerCallable;
  private final UnaryCallable<ListAdPartnersRequest, ListAdPartnersResponse> listAdPartnersCallable;
  private final UnaryCallable<ListAdPartnersRequest, ListAdPartnersPagedResponse>
      listAdPartnersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdPartnerServiceStub create(AdPartnerServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAdPartnerServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdPartnerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdPartnerServiceStub(
        AdPartnerServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdPartnerServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdPartnerServiceStub(
        AdPartnerServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdPartnerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdPartnerServiceStub(
      AdPartnerServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAdPartnerServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdPartnerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdPartnerServiceStub(
      AdPartnerServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAdPartnerRequest, AdPartner> getAdPartnerTransportSettings =
        HttpJsonCallSettings.<GetAdPartnerRequest, AdPartner>newBuilder()
            .setMethodDescriptor(getAdPartnerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAdPartnersRequest, ListAdPartnersResponse>
        listAdPartnersTransportSettings =
            HttpJsonCallSettings.<ListAdPartnersRequest, ListAdPartnersResponse>newBuilder()
                .setMethodDescriptor(listAdPartnersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getAdPartnerCallable =
        callableFactory.createUnaryCallable(
            getAdPartnerTransportSettings, settings.getAdPartnerSettings(), clientContext);
    this.listAdPartnersCallable =
        callableFactory.createUnaryCallable(
            listAdPartnersTransportSettings, settings.listAdPartnersSettings(), clientContext);
    this.listAdPartnersPagedCallable =
        callableFactory.createPagedCallable(
            listAdPartnersTransportSettings, settings.listAdPartnersSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAdPartnerMethodDescriptor);
    methodDescriptors.add(listAdPartnersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAdPartnerRequest, AdPartner> getAdPartnerCallable() {
    return getAdPartnerCallable;
  }

  @Override
  public UnaryCallable<ListAdPartnersRequest, ListAdPartnersResponse> listAdPartnersCallable() {
    return listAdPartnersCallable;
  }

  @Override
  public UnaryCallable<ListAdPartnersRequest, ListAdPartnersPagedResponse>
      listAdPartnersPagedCallable() {
    return listAdPartnersPagedCallable;
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
