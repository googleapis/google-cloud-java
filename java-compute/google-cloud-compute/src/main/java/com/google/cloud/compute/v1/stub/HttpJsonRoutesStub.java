/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RoutesClient.ListPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRouteRequest;
import com.google.cloud.compute.v1.GetRouteRequest;
import com.google.cloud.compute.v1.InsertRouteRequest;
import com.google.cloud.compute.v1.ListRoutesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Route;
import com.google.cloud.compute.v1.RouteList;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRoutesStub extends RoutesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRouteRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteRouteRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routes.Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteRouteRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/routes/{route}",
                      new FieldsExtractor<DeleteRouteRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteRouteRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteRouteRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "route", request.getRoute());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteRouteRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteRouteRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteRouteRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteRouteRequest, String>() {
                        @Override
                        public String extract(DeleteRouteRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRouteRequest, Route> getMethodDescriptor =
      ApiMethodDescriptor.<GetRouteRequest, Route>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routes.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRouteRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/routes/{route}",
                      new FieldsExtractor<GetRouteRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetRouteRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetRouteRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "route", request.getRoute());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetRouteRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetRouteRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetRouteRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetRouteRequest, String>() {
                        @Override
                        public String extract(GetRouteRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Route>newBuilder()
                  .setDefaultInstance(Route.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRouteRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertRouteRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routes.Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertRouteRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/routes",
                      new FieldsExtractor<InsertRouteRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertRouteRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertRouteRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertRouteRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertRouteRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertRouteRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertRouteRequest, String>() {
                        @Override
                        public String extract(InsertRouteRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("routeResource", request.getRouteResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRoutesRequest, RouteList> listMethodDescriptor =
      ApiMethodDescriptor.<ListRoutesRequest, RouteList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routes.List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListRoutesRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/routes",
                      new FieldsExtractor<ListRoutesRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListRoutesRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListRoutesRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListRoutesRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListRoutesRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ListRoutesRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasFilter()) {
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                          }
                          if (request.hasMaxResults()) {
                            serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                          }
                          if (request.hasOrderBy()) {
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                          }
                          if (request.hasPageToken()) {
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                          }
                          if (request.hasReturnPartialSuccess()) {
                            serializer.putQueryParam(
                                fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ListRoutesRequest, String>() {
                        @Override
                        public String extract(ListRoutesRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<RouteList>newBuilder()
                  .setDefaultInstance(RouteList.getDefaultInstance())
                  .build())
          .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRouteRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRouteRequest, Route> getCallable;
  private final UnaryCallable<InsertRouteRequest, Operation> insertCallable;
  private final UnaryCallable<ListRoutesRequest, RouteList> listCallable;
  private final UnaryCallable<ListRoutesRequest, ListPagedResponse> listPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRoutesStub create(RoutesStubSettings settings) throws IOException {
    return new HttpJsonRoutesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRoutesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRoutesStub(RoutesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRoutesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRoutesStub(
        RoutesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRoutesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoutesStub(RoutesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRoutesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRoutesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoutesStub(
      RoutesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRouteRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRouteRequest, Route> getTransportSettings =
        HttpJsonCallSettings.<GetRouteRequest, Route>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRouteRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRoutesRequest, RouteList> listTransportSettings =
        HttpJsonCallSettings.<ListRoutesRequest, RouteList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteRouteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRouteRequest, Route> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertRouteRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListRoutesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRoutesRequest, RouteList> listCallable() {
    return listCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
