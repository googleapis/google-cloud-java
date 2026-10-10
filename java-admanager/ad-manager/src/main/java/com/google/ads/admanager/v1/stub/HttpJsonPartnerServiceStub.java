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

import static com.google.ads.admanager.v1.PartnerServiceClient.ListPartnersPagedResponse;

import com.google.ads.admanager.v1.BatchUpdatePartnersRequest;
import com.google.ads.admanager.v1.BatchUpdatePartnersResponse;
import com.google.ads.admanager.v1.GetPartnerRequest;
import com.google.ads.admanager.v1.ListPartnersRequest;
import com.google.ads.admanager.v1.ListPartnersResponse;
import com.google.ads.admanager.v1.Partner;
import com.google.ads.admanager.v1.UpdatePartnerRequest;
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
 * REST stub implementation for the PartnerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonPartnerServiceStub extends PartnerServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetPartnerRequest, Partner> getPartnerMethodDescriptor =
      ApiMethodDescriptor.<GetPartnerRequest, Partner>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.PartnerService/GetPartner")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPartnerRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/partners/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPartnerRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPartnerRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Partner>newBuilder()
                  .setDefaultInstance(Partner.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListPartnersRequest, ListPartnersResponse>
      listPartnersMethodDescriptor =
          ApiMethodDescriptor.<ListPartnersRequest, ListPartnersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.PartnerService/ListPartners")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPartnersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/partners",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPartnersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPartnersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPartnersResponse>newBuilder()
                      .setDefaultInstance(ListPartnersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePartnerRequest, Partner>
      updatePartnerMethodDescriptor =
          ApiMethodDescriptor.<UpdatePartnerRequest, Partner>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.PartnerService/UpdatePartner")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePartnerRequest>newBuilder()
                      .setPath(
                          "/v1/{partner.name=networks/*/partners/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePartnerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "partner.name", request.getPartner().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePartnerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("partner", request.getPartner(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Partner>newBuilder()
                      .setDefaultInstance(Partner.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchUpdatePartnersRequest, BatchUpdatePartnersResponse>
      batchUpdatePartnersMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdatePartnersRequest, BatchUpdatePartnersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.PartnerService/BatchUpdatePartners")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdatePartnersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/partners:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdatePartnersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdatePartnersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdatePartnersResponse>newBuilder()
                      .setDefaultInstance(BatchUpdatePartnersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable;
  private final UnaryCallable<ListPartnersRequest, ListPartnersResponse> listPartnersCallable;
  private final UnaryCallable<ListPartnersRequest, ListPartnersPagedResponse>
      listPartnersPagedCallable;
  private final UnaryCallable<UpdatePartnerRequest, Partner> updatePartnerCallable;
  private final UnaryCallable<BatchUpdatePartnersRequest, BatchUpdatePartnersResponse>
      batchUpdatePartnersCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPartnerServiceStub create(PartnerServiceStubSettings settings)
      throws IOException {
    return new HttpJsonPartnerServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPartnerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPartnerServiceStub(
        PartnerServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPartnerServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPartnerServiceStub(
        PartnerServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPartnerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPartnerServiceStub(
      PartnerServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPartnerServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPartnerServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPartnerServiceStub(
      PartnerServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetPartnerRequest, Partner> getPartnerTransportSettings =
        HttpJsonCallSettings.<GetPartnerRequest, Partner>newBuilder()
            .setMethodDescriptor(getPartnerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListPartnersRequest, ListPartnersResponse> listPartnersTransportSettings =
        HttpJsonCallSettings.<ListPartnersRequest, ListPartnersResponse>newBuilder()
            .setMethodDescriptor(listPartnersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdatePartnerRequest, Partner> updatePartnerTransportSettings =
        HttpJsonCallSettings.<UpdatePartnerRequest, Partner>newBuilder()
            .setMethodDescriptor(updatePartnerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("partner.name", String.valueOf(request.getPartner().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdatePartnersRequest, BatchUpdatePartnersResponse>
        batchUpdatePartnersTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdatePartnersRequest, BatchUpdatePartnersResponse>newBuilder()
                .setMethodDescriptor(batchUpdatePartnersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getPartnerCallable =
        callableFactory.createUnaryCallable(
            getPartnerTransportSettings, settings.getPartnerSettings(), clientContext);
    this.listPartnersCallable =
        callableFactory.createUnaryCallable(
            listPartnersTransportSettings, settings.listPartnersSettings(), clientContext);
    this.listPartnersPagedCallable =
        callableFactory.createPagedCallable(
            listPartnersTransportSettings, settings.listPartnersSettings(), clientContext);
    this.updatePartnerCallable =
        callableFactory.createUnaryCallable(
            updatePartnerTransportSettings, settings.updatePartnerSettings(), clientContext);
    this.batchUpdatePartnersCallable =
        callableFactory.createUnaryCallable(
            batchUpdatePartnersTransportSettings,
            settings.batchUpdatePartnersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getPartnerMethodDescriptor);
    methodDescriptors.add(listPartnersMethodDescriptor);
    methodDescriptors.add(updatePartnerMethodDescriptor);
    methodDescriptors.add(batchUpdatePartnersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable() {
    return getPartnerCallable;
  }

  @Override
  public UnaryCallable<ListPartnersRequest, ListPartnersResponse> listPartnersCallable() {
    return listPartnersCallable;
  }

  @Override
  public UnaryCallable<ListPartnersRequest, ListPartnersPagedResponse> listPartnersPagedCallable() {
    return listPartnersPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePartnerRequest, Partner> updatePartnerCallable() {
    return updatePartnerCallable;
  }

  @Override
  public UnaryCallable<BatchUpdatePartnersRequest, BatchUpdatePartnersResponse>
      batchUpdatePartnersCallable() {
    return batchUpdatePartnersCallable;
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
