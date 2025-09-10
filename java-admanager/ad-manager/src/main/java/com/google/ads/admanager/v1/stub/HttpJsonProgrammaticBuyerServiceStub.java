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

import static com.google.ads.admanager.v1.ProgrammaticBuyerServiceClient.ListProgrammaticBuyersPagedResponse;

import com.google.ads.admanager.v1.GetProgrammaticBuyerRequest;
import com.google.ads.admanager.v1.ListProgrammaticBuyersRequest;
import com.google.ads.admanager.v1.ListProgrammaticBuyersResponse;
import com.google.ads.admanager.v1.ProgrammaticBuyer;
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
 * REST stub implementation for the ProgrammaticBuyerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonProgrammaticBuyerServiceStub extends ProgrammaticBuyerServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetProgrammaticBuyerRequest, ProgrammaticBuyer>
      getProgrammaticBuyerMethodDescriptor =
          ApiMethodDescriptor.<GetProgrammaticBuyerRequest, ProgrammaticBuyer>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ProgrammaticBuyerService/GetProgrammaticBuyer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProgrammaticBuyerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/programmaticBuyers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProgrammaticBuyerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProgrammaticBuyerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProgrammaticBuyer>newBuilder()
                      .setDefaultInstance(ProgrammaticBuyer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse>
      listProgrammaticBuyersMethodDescriptor =
          ApiMethodDescriptor
              .<ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ProgrammaticBuyerService/ListProgrammaticBuyers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProgrammaticBuyersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/programmaticBuyers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProgrammaticBuyersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProgrammaticBuyersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListProgrammaticBuyersResponse>newBuilder()
                      .setDefaultInstance(ListProgrammaticBuyersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetProgrammaticBuyerRequest, ProgrammaticBuyer>
      getProgrammaticBuyerCallable;
  private final UnaryCallable<ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse>
      listProgrammaticBuyersCallable;
  private final UnaryCallable<ListProgrammaticBuyersRequest, ListProgrammaticBuyersPagedResponse>
      listProgrammaticBuyersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProgrammaticBuyerServiceStub create(
      ProgrammaticBuyerServiceStubSettings settings) throws IOException {
    return new HttpJsonProgrammaticBuyerServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProgrammaticBuyerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProgrammaticBuyerServiceStub(
        ProgrammaticBuyerServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonProgrammaticBuyerServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProgrammaticBuyerServiceStub(
        ProgrammaticBuyerServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProgrammaticBuyerServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProgrammaticBuyerServiceStub(
      ProgrammaticBuyerServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonProgrammaticBuyerServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProgrammaticBuyerServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProgrammaticBuyerServiceStub(
      ProgrammaticBuyerServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProgrammaticBuyerRequest, ProgrammaticBuyer>
        getProgrammaticBuyerTransportSettings =
            HttpJsonCallSettings.<GetProgrammaticBuyerRequest, ProgrammaticBuyer>newBuilder()
                .setMethodDescriptor(getProgrammaticBuyerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse>
        listProgrammaticBuyersTransportSettings =
            HttpJsonCallSettings
                .<ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse>newBuilder()
                .setMethodDescriptor(listProgrammaticBuyersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getProgrammaticBuyerCallable =
        callableFactory.createUnaryCallable(
            getProgrammaticBuyerTransportSettings,
            settings.getProgrammaticBuyerSettings(),
            clientContext);
    this.listProgrammaticBuyersCallable =
        callableFactory.createUnaryCallable(
            listProgrammaticBuyersTransportSettings,
            settings.listProgrammaticBuyersSettings(),
            clientContext);
    this.listProgrammaticBuyersPagedCallable =
        callableFactory.createPagedCallable(
            listProgrammaticBuyersTransportSettings,
            settings.listProgrammaticBuyersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProgrammaticBuyerMethodDescriptor);
    methodDescriptors.add(listProgrammaticBuyersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetProgrammaticBuyerRequest, ProgrammaticBuyer>
      getProgrammaticBuyerCallable() {
    return getProgrammaticBuyerCallable;
  }

  @Override
  public UnaryCallable<ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse>
      listProgrammaticBuyersCallable() {
    return listProgrammaticBuyersCallable;
  }

  @Override
  public UnaryCallable<ListProgrammaticBuyersRequest, ListProgrammaticBuyersPagedResponse>
      listProgrammaticBuyersPagedCallable() {
    return listProgrammaticBuyersPagedCallable;
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
