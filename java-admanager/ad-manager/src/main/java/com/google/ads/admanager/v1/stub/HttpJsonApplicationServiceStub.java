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

import static com.google.ads.admanager.v1.ApplicationServiceClient.ListApplicationsPagedResponse;

import com.google.ads.admanager.v1.Application;
import com.google.ads.admanager.v1.BatchArchiveApplicationsRequest;
import com.google.ads.admanager.v1.BatchArchiveApplicationsResponse;
import com.google.ads.admanager.v1.BatchCreateApplicationsRequest;
import com.google.ads.admanager.v1.BatchCreateApplicationsResponse;
import com.google.ads.admanager.v1.BatchUnarchiveApplicationsRequest;
import com.google.ads.admanager.v1.BatchUnarchiveApplicationsResponse;
import com.google.ads.admanager.v1.BatchUpdateApplicationsRequest;
import com.google.ads.admanager.v1.BatchUpdateApplicationsResponse;
import com.google.ads.admanager.v1.CreateApplicationRequest;
import com.google.ads.admanager.v1.GetApplicationRequest;
import com.google.ads.admanager.v1.ListApplicationsRequest;
import com.google.ads.admanager.v1.ListApplicationsResponse;
import com.google.ads.admanager.v1.UpdateApplicationRequest;
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
 * REST stub implementation for the ApplicationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonApplicationServiceStub extends ApplicationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          ApiMethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ApplicationService/GetApplication")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/applications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Application>newBuilder()
                      .setDefaultInstance(Application.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsMethodDescriptor =
          ApiMethodDescriptor.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ApplicationService/ListApplications")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/applications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApplicationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListApplicationsResponse>newBuilder()
                      .setDefaultInstance(ListApplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApplicationRequest, Application>
      createApplicationMethodDescriptor =
          ApiMethodDescriptor.<CreateApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ApplicationService/CreateApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/applications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("application", request.getApplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Application>newBuilder()
                      .setDefaultInstance(Application.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateApplicationsRequest, BatchCreateApplicationsResponse>
      batchCreateApplicationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateApplicationsRequest, BatchCreateApplicationsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ApplicationService/BatchCreateApplications")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/applications:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateApplicationsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateApplicationsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateApplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateApplicationRequest, Application>
      updateApplicationMethodDescriptor =
          ApiMethodDescriptor.<UpdateApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ApplicationService/UpdateApplication")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{application.name=networks/*/applications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "application.name", request.getApplication().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("application", request.getApplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Application>newBuilder()
                      .setDefaultInstance(Application.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateApplicationsRequest, BatchUpdateApplicationsResponse>
      batchUpdateApplicationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateApplicationsRequest, BatchUpdateApplicationsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ApplicationService/BatchUpdateApplications")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/applications:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateApplicationsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateApplicationsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateApplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveApplicationsRequest, BatchArchiveApplicationsResponse>
      batchArchiveApplicationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveApplicationsRequest, BatchArchiveApplicationsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ApplicationService/BatchArchiveApplications")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/applications:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveApplicationsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveApplicationsResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveApplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUnarchiveApplicationsRequest, BatchUnarchiveApplicationsResponse>
      batchUnarchiveApplicationsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUnarchiveApplicationsRequest, BatchUnarchiveApplicationsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ApplicationService/BatchUnarchiveApplications")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUnarchiveApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/applications:batchUnarchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveApplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveApplicationsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUnarchiveApplicationsResponse>newBuilder()
                      .setDefaultInstance(BatchUnarchiveApplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable;
  private final UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable;
  private final UnaryCallable<BatchCreateApplicationsRequest, BatchCreateApplicationsResponse>
      batchCreateApplicationsCallable;
  private final UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable;
  private final UnaryCallable<BatchUpdateApplicationsRequest, BatchUpdateApplicationsResponse>
      batchUpdateApplicationsCallable;
  private final UnaryCallable<BatchArchiveApplicationsRequest, BatchArchiveApplicationsResponse>
      batchArchiveApplicationsCallable;
  private final UnaryCallable<BatchUnarchiveApplicationsRequest, BatchUnarchiveApplicationsResponse>
      batchUnarchiveApplicationsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonApplicationServiceStub create(ApplicationServiceStubSettings settings)
      throws IOException {
    return new HttpJsonApplicationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonApplicationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonApplicationServiceStub(
        ApplicationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonApplicationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonApplicationServiceStub(
        ApplicationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonApplicationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonApplicationServiceStub(
      ApplicationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonApplicationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonApplicationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonApplicationServiceStub(
      ApplicationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetApplicationRequest, Application> getApplicationTransportSettings =
        HttpJsonCallSettings.<GetApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(getApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListApplicationsRequest, ListApplicationsResponse>
        listApplicationsTransportSettings =
            HttpJsonCallSettings.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
                .setMethodDescriptor(listApplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateApplicationRequest, Application> createApplicationTransportSettings =
        HttpJsonCallSettings.<CreateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateApplicationsRequest, BatchCreateApplicationsResponse>
        batchCreateApplicationsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateApplicationsRequest, BatchCreateApplicationsResponse>newBuilder()
                .setMethodDescriptor(batchCreateApplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateApplicationRequest, Application> updateApplicationTransportSettings =
        HttpJsonCallSettings.<UpdateApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(updateApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "application.name", String.valueOf(request.getApplication().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateApplicationsRequest, BatchUpdateApplicationsResponse>
        batchUpdateApplicationsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateApplicationsRequest, BatchUpdateApplicationsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateApplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveApplicationsRequest, BatchArchiveApplicationsResponse>
        batchArchiveApplicationsTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveApplicationsRequest, BatchArchiveApplicationsResponse>newBuilder()
                .setMethodDescriptor(batchArchiveApplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchUnarchiveApplicationsRequest, BatchUnarchiveApplicationsResponse>
        batchUnarchiveApplicationsTransportSettings =
            HttpJsonCallSettings
                .<BatchUnarchiveApplicationsRequest, BatchUnarchiveApplicationsResponse>newBuilder()
                .setMethodDescriptor(batchUnarchiveApplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
    this.listApplicationsCallable =
        callableFactory.createUnaryCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.listApplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.createApplicationCallable =
        callableFactory.createUnaryCallable(
            createApplicationTransportSettings,
            settings.createApplicationSettings(),
            clientContext);
    this.batchCreateApplicationsCallable =
        callableFactory.createUnaryCallable(
            batchCreateApplicationsTransportSettings,
            settings.batchCreateApplicationsSettings(),
            clientContext);
    this.updateApplicationCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationSettings(),
            clientContext);
    this.batchUpdateApplicationsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateApplicationsTransportSettings,
            settings.batchUpdateApplicationsSettings(),
            clientContext);
    this.batchArchiveApplicationsCallable =
        callableFactory.createUnaryCallable(
            batchArchiveApplicationsTransportSettings,
            settings.batchArchiveApplicationsSettings(),
            clientContext);
    this.batchUnarchiveApplicationsCallable =
        callableFactory.createUnaryCallable(
            batchUnarchiveApplicationsTransportSettings,
            settings.batchUnarchiveApplicationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getApplicationMethodDescriptor);
    methodDescriptors.add(listApplicationsMethodDescriptor);
    methodDescriptors.add(createApplicationMethodDescriptor);
    methodDescriptors.add(batchCreateApplicationsMethodDescriptor);
    methodDescriptors.add(updateApplicationMethodDescriptor);
    methodDescriptors.add(batchUpdateApplicationsMethodDescriptor);
    methodDescriptors.add(batchArchiveApplicationsMethodDescriptor);
    methodDescriptors.add(batchUnarchiveApplicationsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
  }

  @Override
  public UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    return listApplicationsCallable;
  }

  @Override
  public UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    return listApplicationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable() {
    return createApplicationCallable;
  }

  @Override
  public UnaryCallable<BatchCreateApplicationsRequest, BatchCreateApplicationsResponse>
      batchCreateApplicationsCallable() {
    return batchCreateApplicationsCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable() {
    return updateApplicationCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateApplicationsRequest, BatchUpdateApplicationsResponse>
      batchUpdateApplicationsCallable() {
    return batchUpdateApplicationsCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveApplicationsRequest, BatchArchiveApplicationsResponse>
      batchArchiveApplicationsCallable() {
    return batchArchiveApplicationsCallable;
  }

  @Override
  public UnaryCallable<BatchUnarchiveApplicationsRequest, BatchUnarchiveApplicationsResponse>
      batchUnarchiveApplicationsCallable() {
    return batchUnarchiveApplicationsCallable;
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
