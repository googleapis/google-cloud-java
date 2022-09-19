/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.PagesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PagesClient.ListPagesPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPagesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPagesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Page;
import com.google.cloud.dialogflow.cx.v3beta1.UpdatePageRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the Pages service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPagesStub extends PagesStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListPagesRequest, ListPagesResponse>
      listPagesMethodDescriptor =
          ApiMethodDescriptor.<ListPagesRequest, ListPagesResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/ListPages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPagesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*/flows/*}/pages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPagesResponse>newBuilder()
                      .setDefaultInstance(ListPagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPageRequest, Page> getPageMethodDescriptor =
      ApiMethodDescriptor.<GetPageRequest, Page>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/GetPage")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPageRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{name=projects/*/locations/*/agents/*/flows/*/pages/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languageCode", request.getLanguageCode());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Page>newBuilder()
                  .setDefaultInstance(Page.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreatePageRequest, Page> createPageMethodDescriptor =
      ApiMethodDescriptor.<CreatePageRequest, Page>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/CreatePage")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreatePageRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{parent=projects/*/locations/*/agents/*/flows/*}/pages",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreatePageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreatePageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languageCode", request.getLanguageCode());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("page", request.getPage(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Page>newBuilder()
                  .setDefaultInstance(Page.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdatePageRequest, Page> updatePageMethodDescriptor =
      ApiMethodDescriptor.<UpdatePageRequest, Page>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/UpdatePage")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdatePageRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{page.name=projects/*/locations/*/agents/*/flows/*/pages/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdatePageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "page.name", request.getPage().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdatePageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languageCode", request.getLanguageCode());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("page", request.getPage(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Page>newBuilder()
                  .setDefaultInstance(Page.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeletePageRequest, Empty> deletePageMethodDescriptor =
      ApiMethodDescriptor.<DeletePageRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/DeletePage")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeletePageRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{name=projects/*/locations/*/agents/*/flows/*/pages/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeletePageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeletePageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListPagesRequest, ListPagesResponse> listPagesCallable;
  private final UnaryCallable<ListPagesRequest, ListPagesPagedResponse> listPagesPagedCallable;
  private final UnaryCallable<GetPageRequest, Page> getPageCallable;
  private final UnaryCallable<CreatePageRequest, Page> createPageCallable;
  private final UnaryCallable<UpdatePageRequest, Page> updatePageCallable;
  private final UnaryCallable<DeletePageRequest, Empty> deletePageCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPagesStub create(PagesStubSettings settings) throws IOException {
    return new HttpJsonPagesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPagesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonPagesStub(PagesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPagesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPagesStub(
        PagesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPagesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPagesStub(PagesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPagesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPagesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPagesStub(
      PagesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListPagesRequest, ListPagesResponse> listPagesTransportSettings =
        HttpJsonCallSettings.<ListPagesRequest, ListPagesResponse>newBuilder()
            .setMethodDescriptor(listPagesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetPageRequest, Page> getPageTransportSettings =
        HttpJsonCallSettings.<GetPageRequest, Page>newBuilder()
            .setMethodDescriptor(getPageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreatePageRequest, Page> createPageTransportSettings =
        HttpJsonCallSettings.<CreatePageRequest, Page>newBuilder()
            .setMethodDescriptor(createPageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdatePageRequest, Page> updatePageTransportSettings =
        HttpJsonCallSettings.<UpdatePageRequest, Page>newBuilder()
            .setMethodDescriptor(updatePageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeletePageRequest, Empty> deletePageTransportSettings =
        HttpJsonCallSettings.<DeletePageRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listPagesCallable =
        callableFactory.createUnaryCallable(
            listPagesTransportSettings, settings.listPagesSettings(), clientContext);
    this.listPagesPagedCallable =
        callableFactory.createPagedCallable(
            listPagesTransportSettings, settings.listPagesSettings(), clientContext);
    this.getPageCallable =
        callableFactory.createUnaryCallable(
            getPageTransportSettings, settings.getPageSettings(), clientContext);
    this.createPageCallable =
        callableFactory.createUnaryCallable(
            createPageTransportSettings, settings.createPageSettings(), clientContext);
    this.updatePageCallable =
        callableFactory.createUnaryCallable(
            updatePageTransportSettings, settings.updatePageSettings(), clientContext);
    this.deletePageCallable =
        callableFactory.createUnaryCallable(
            deletePageTransportSettings, settings.deletePageSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listPagesMethodDescriptor);
    methodDescriptors.add(getPageMethodDescriptor);
    methodDescriptors.add(createPageMethodDescriptor);
    methodDescriptors.add(updatePageMethodDescriptor);
    methodDescriptors.add(deletePageMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListPagesRequest, ListPagesResponse> listPagesCallable() {
    return listPagesCallable;
  }

  @Override
  public UnaryCallable<ListPagesRequest, ListPagesPagedResponse> listPagesPagedCallable() {
    return listPagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPageRequest, Page> getPageCallable() {
    return getPageCallable;
  }

  @Override
  public UnaryCallable<CreatePageRequest, Page> createPageCallable() {
    return createPageCallable;
  }

  @Override
  public UnaryCallable<UpdatePageRequest, Page> updatePageCallable() {
    return updatePageCallable;
  }

  @Override
  public UnaryCallable<DeletePageRequest, Empty> deletePageCallable() {
    return deletePageCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
