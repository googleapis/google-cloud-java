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

package com.google.shopping.merchant.conversions.v1beta.stub;

import static com.google.shopping.merchant.conversions.v1beta.ConversionSourcesServiceClient.ListConversionSourcesPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.conversions.v1beta.ConversionSource;
import com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse;
import com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ConversionSourcesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonConversionSourcesServiceStub extends ConversionSourcesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceMethodDescriptor =
          ApiMethodDescriptor.<CreateConversionSourceRequest, ConversionSource>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/CreateConversionSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConversionSourceRequest>newBuilder()
                      .setPath(
                          "/conversions/v1beta/{parent=accounts/*}/conversionSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("conversionSource", request.getConversionSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversionSource>newBuilder()
                      .setDefaultInstance(ConversionSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceMethodDescriptor =
          ApiMethodDescriptor.<UpdateConversionSourceRequest, ConversionSource>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/UpdateConversionSource")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConversionSourceRequest>newBuilder()
                      .setPath(
                          "/conversions/v1beta/{conversionSource.name=accounts/*/conversionSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "conversionSource.name",
                                request.getConversionSource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("conversionSource", request.getConversionSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversionSource>newBuilder()
                      .setDefaultInstance(ConversionSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConversionSourceRequest, Empty>
      deleteConversionSourceMethodDescriptor =
          ApiMethodDescriptor.<DeleteConversionSourceRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/DeleteConversionSource")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversionSourceRequest>newBuilder()
                      .setPath(
                          "/conversions/v1beta/{name=accounts/*/conversionSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceMethodDescriptor =
          ApiMethodDescriptor.<UndeleteConversionSourceRequest, ConversionSource>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/UndeleteConversionSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteConversionSourceRequest>newBuilder()
                      .setPath(
                          "/conversions/v1beta/{name=accounts/*/conversionSources/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversionSource>newBuilder()
                      .setDefaultInstance(ConversionSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConversionSourceRequest, ConversionSource>
      getConversionSourceMethodDescriptor =
          ApiMethodDescriptor.<GetConversionSourceRequest, ConversionSource>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/GetConversionSource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversionSourceRequest>newBuilder()
                      .setPath(
                          "/conversions/v1beta/{name=accounts/*/conversionSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversionSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversionSource>newBuilder()
                      .setDefaultInstance(ConversionSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesMethodDescriptor =
          ApiMethodDescriptor
              .<ListConversionSourcesRequest, ListConversionSourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.conversions.v1beta.ConversionSourcesService/ListConversionSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversionSourcesRequest>newBuilder()
                      .setPath(
                          "/conversions/v1beta/{parent=accounts/*}/conversionSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversionSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversionSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversionSourcesResponse>newBuilder()
                      .setDefaultInstance(ListConversionSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceCallable;
  private final UnaryCallable<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceCallable;
  private final UnaryCallable<DeleteConversionSourceRequest, Empty> deleteConversionSourceCallable;
  private final UnaryCallable<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceCallable;
  private final UnaryCallable<GetConversionSourceRequest, ConversionSource>
      getConversionSourceCallable;
  private final UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesCallable;
  private final UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesPagedResponse>
      listConversionSourcesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConversionSourcesServiceStub create(
      ConversionSourcesServiceStubSettings settings) throws IOException {
    return new HttpJsonConversionSourcesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConversionSourcesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConversionSourcesServiceStub(
        ConversionSourcesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConversionSourcesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConversionSourcesServiceStub(
        ConversionSourcesServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConversionSourcesServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversionSourcesServiceStub(
      ConversionSourcesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonConversionSourcesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConversionSourcesServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversionSourcesServiceStub(
      ConversionSourcesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateConversionSourceRequest, ConversionSource>
        createConversionSourceTransportSettings =
            HttpJsonCallSettings.<CreateConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(createConversionSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateConversionSourceRequest, ConversionSource>
        updateConversionSourceTransportSettings =
            HttpJsonCallSettings.<UpdateConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(updateConversionSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_source.name",
                          String.valueOf(request.getConversionSource().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteConversionSourceRequest, Empty>
        deleteConversionSourceTransportSettings =
            HttpJsonCallSettings.<DeleteConversionSourceRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConversionSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UndeleteConversionSourceRequest, ConversionSource>
        undeleteConversionSourceTransportSettings =
            HttpJsonCallSettings.<UndeleteConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(undeleteConversionSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConversionSourceRequest, ConversionSource>
        getConversionSourceTransportSettings =
            HttpJsonCallSettings.<GetConversionSourceRequest, ConversionSource>newBuilder()
                .setMethodDescriptor(getConversionSourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListConversionSourcesRequest, ListConversionSourcesResponse>
        listConversionSourcesTransportSettings =
            HttpJsonCallSettings
                .<ListConversionSourcesRequest, ListConversionSourcesResponse>newBuilder()
                .setMethodDescriptor(listConversionSourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createConversionSourceCallable =
        callableFactory.createUnaryCallable(
            createConversionSourceTransportSettings,
            settings.createConversionSourceSettings(),
            clientContext);
    this.updateConversionSourceCallable =
        callableFactory.createUnaryCallable(
            updateConversionSourceTransportSettings,
            settings.updateConversionSourceSettings(),
            clientContext);
    this.deleteConversionSourceCallable =
        callableFactory.createUnaryCallable(
            deleteConversionSourceTransportSettings,
            settings.deleteConversionSourceSettings(),
            clientContext);
    this.undeleteConversionSourceCallable =
        callableFactory.createUnaryCallable(
            undeleteConversionSourceTransportSettings,
            settings.undeleteConversionSourceSettings(),
            clientContext);
    this.getConversionSourceCallable =
        callableFactory.createUnaryCallable(
            getConversionSourceTransportSettings,
            settings.getConversionSourceSettings(),
            clientContext);
    this.listConversionSourcesCallable =
        callableFactory.createUnaryCallable(
            listConversionSourcesTransportSettings,
            settings.listConversionSourcesSettings(),
            clientContext);
    this.listConversionSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listConversionSourcesTransportSettings,
            settings.listConversionSourcesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createConversionSourceMethodDescriptor);
    methodDescriptors.add(updateConversionSourceMethodDescriptor);
    methodDescriptors.add(deleteConversionSourceMethodDescriptor);
    methodDescriptors.add(undeleteConversionSourceMethodDescriptor);
    methodDescriptors.add(getConversionSourceMethodDescriptor);
    methodDescriptors.add(listConversionSourcesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceCallable() {
    return createConversionSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceCallable() {
    return updateConversionSourceCallable;
  }

  @Override
  public UnaryCallable<DeleteConversionSourceRequest, Empty> deleteConversionSourceCallable() {
    return deleteConversionSourceCallable;
  }

  @Override
  public UnaryCallable<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceCallable() {
    return undeleteConversionSourceCallable;
  }

  @Override
  public UnaryCallable<GetConversionSourceRequest, ConversionSource> getConversionSourceCallable() {
    return getConversionSourceCallable;
  }

  @Override
  public UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesCallable() {
    return listConversionSourcesCallable;
  }

  @Override
  public UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesPagedResponse>
      listConversionSourcesPagedCallable() {
    return listConversionSourcesPagedCallable;
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
