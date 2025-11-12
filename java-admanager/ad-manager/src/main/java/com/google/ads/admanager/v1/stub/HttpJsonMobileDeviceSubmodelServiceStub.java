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

import static com.google.ads.admanager.v1.MobileDeviceSubmodelServiceClient.ListMobileDeviceSubmodelsPagedResponse;

import com.google.ads.admanager.v1.GetMobileDeviceSubmodelRequest;
import com.google.ads.admanager.v1.ListMobileDeviceSubmodelsRequest;
import com.google.ads.admanager.v1.ListMobileDeviceSubmodelsResponse;
import com.google.ads.admanager.v1.MobileDeviceSubmodel;
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
 * REST stub implementation for the MobileDeviceSubmodelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonMobileDeviceSubmodelServiceStub extends MobileDeviceSubmodelServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>
      getMobileDeviceSubmodelMethodDescriptor =
          ApiMethodDescriptor.<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.MobileDeviceSubmodelService/GetMobileDeviceSubmodel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMobileDeviceSubmodelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/mobileDeviceSubmodels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMobileDeviceSubmodelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMobileDeviceSubmodelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MobileDeviceSubmodel>newBuilder()
                      .setDefaultInstance(MobileDeviceSubmodel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsResponse>
      listMobileDeviceSubmodelsMethodDescriptor =
          ApiMethodDescriptor
              .<ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.MobileDeviceSubmodelService/ListMobileDeviceSubmodels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMobileDeviceSubmodelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/mobileDeviceSubmodels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMobileDeviceSubmodelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMobileDeviceSubmodelsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMobileDeviceSubmodelsResponse>newBuilder()
                      .setDefaultInstance(ListMobileDeviceSubmodelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>
      getMobileDeviceSubmodelCallable;
  private final UnaryCallable<ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsResponse>
      listMobileDeviceSubmodelsCallable;
  private final UnaryCallable<
          ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsPagedResponse>
      listMobileDeviceSubmodelsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMobileDeviceSubmodelServiceStub create(
      MobileDeviceSubmodelServiceStubSettings settings) throws IOException {
    return new HttpJsonMobileDeviceSubmodelServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMobileDeviceSubmodelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMobileDeviceSubmodelServiceStub(
        MobileDeviceSubmodelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonMobileDeviceSubmodelServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMobileDeviceSubmodelServiceStub(
        MobileDeviceSubmodelServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMobileDeviceSubmodelServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonMobileDeviceSubmodelServiceStub(
      MobileDeviceSubmodelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonMobileDeviceSubmodelServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMobileDeviceSubmodelServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonMobileDeviceSubmodelServiceStub(
      MobileDeviceSubmodelServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>
        getMobileDeviceSubmodelTransportSettings =
            HttpJsonCallSettings.<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>newBuilder()
                .setMethodDescriptor(getMobileDeviceSubmodelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsResponse>
        listMobileDeviceSubmodelsTransportSettings =
            HttpJsonCallSettings
                .<ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsResponse>newBuilder()
                .setMethodDescriptor(listMobileDeviceSubmodelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getMobileDeviceSubmodelCallable =
        callableFactory.createUnaryCallable(
            getMobileDeviceSubmodelTransportSettings,
            settings.getMobileDeviceSubmodelSettings(),
            clientContext);
    this.listMobileDeviceSubmodelsCallable =
        callableFactory.createUnaryCallable(
            listMobileDeviceSubmodelsTransportSettings,
            settings.listMobileDeviceSubmodelsSettings(),
            clientContext);
    this.listMobileDeviceSubmodelsPagedCallable =
        callableFactory.createPagedCallable(
            listMobileDeviceSubmodelsTransportSettings,
            settings.listMobileDeviceSubmodelsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMobileDeviceSubmodelMethodDescriptor);
    methodDescriptors.add(listMobileDeviceSubmodelsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetMobileDeviceSubmodelRequest, MobileDeviceSubmodel>
      getMobileDeviceSubmodelCallable() {
    return getMobileDeviceSubmodelCallable;
  }

  @Override
  public UnaryCallable<ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsResponse>
      listMobileDeviceSubmodelsCallable() {
    return listMobileDeviceSubmodelsCallable;
  }

  @Override
  public UnaryCallable<ListMobileDeviceSubmodelsRequest, ListMobileDeviceSubmodelsPagedResponse>
      listMobileDeviceSubmodelsPagedCallable() {
    return listMobileDeviceSubmodelsPagedCallable;
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
