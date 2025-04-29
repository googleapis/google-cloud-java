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

package google.cloud.chronicle.v1.stub;

import static google.cloud.chronicle.v1.EntityServiceClient.ListWatchlistsPagedResponse;

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
import google.cloud.chronicle.v1.CreateWatchlistRequest;
import google.cloud.chronicle.v1.DeleteWatchlistRequest;
import google.cloud.chronicle.v1.GetWatchlistRequest;
import google.cloud.chronicle.v1.ListWatchlistsRequest;
import google.cloud.chronicle.v1.ListWatchlistsResponse;
import google.cloud.chronicle.v1.UpdateWatchlistRequest;
import google.cloud.chronicle.v1.Watchlist;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the EntityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonEntityServiceStub extends EntityServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetWatchlistRequest, Watchlist>
      getWatchlistMethodDescriptor =
          ApiMethodDescriptor.<GetWatchlistRequest, Watchlist>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/GetWatchlist")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWatchlistRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/watchlists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Watchlist>newBuilder()
                      .setDefaultInstance(Watchlist.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWatchlistsRequest, ListWatchlistsResponse>
      listWatchlistsMethodDescriptor =
          ApiMethodDescriptor.<ListWatchlistsRequest, ListWatchlistsResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/ListWatchlists")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWatchlistsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/watchlists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWatchlistsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWatchlistsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWatchlistsResponse>newBuilder()
                      .setDefaultInstance(ListWatchlistsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWatchlistRequest, Watchlist>
      createWatchlistMethodDescriptor =
          ApiMethodDescriptor.<CreateWatchlistRequest, Watchlist>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/CreateWatchlist")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWatchlistRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/watchlists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "watchlistId", request.getWatchlistId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("watchlist", request.getWatchlist(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Watchlist>newBuilder()
                      .setDefaultInstance(Watchlist.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateWatchlistRequest, Watchlist>
      updateWatchlistMethodDescriptor =
          ApiMethodDescriptor.<UpdateWatchlistRequest, Watchlist>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/UpdateWatchlist")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWatchlistRequest>newBuilder()
                      .setPath(
                          "/v1/{watchlist.name=projects/*/locations/*/instances/*/watchlists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "watchlist.name", request.getWatchlist().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("watchlist", request.getWatchlist(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Watchlist>newBuilder()
                      .setDefaultInstance(Watchlist.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWatchlistRequest, Empty>
      deleteWatchlistMethodDescriptor =
          ApiMethodDescriptor.<DeleteWatchlistRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/DeleteWatchlist")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWatchlistRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/watchlists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWatchlistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private final UnaryCallable<GetWatchlistRequest, Watchlist> getWatchlistCallable;
  private final UnaryCallable<ListWatchlistsRequest, ListWatchlistsResponse> listWatchlistsCallable;
  private final UnaryCallable<ListWatchlistsRequest, ListWatchlistsPagedResponse>
      listWatchlistsPagedCallable;
  private final UnaryCallable<CreateWatchlistRequest, Watchlist> createWatchlistCallable;
  private final UnaryCallable<UpdateWatchlistRequest, Watchlist> updateWatchlistCallable;
  private final UnaryCallable<DeleteWatchlistRequest, Empty> deleteWatchlistCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEntityServiceStub create(EntityServiceStubSettings settings)
      throws IOException {
    return new HttpJsonEntityServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEntityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEntityServiceStub(
        EntityServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEntityServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEntityServiceStub(
        EntityServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEntityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEntityServiceStub(
      EntityServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonEntityServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEntityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEntityServiceStub(
      EntityServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetWatchlistRequest, Watchlist> getWatchlistTransportSettings =
        HttpJsonCallSettings.<GetWatchlistRequest, Watchlist>newBuilder()
            .setMethodDescriptor(getWatchlistMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListWatchlistsRequest, ListWatchlistsResponse>
        listWatchlistsTransportSettings =
            HttpJsonCallSettings.<ListWatchlistsRequest, ListWatchlistsResponse>newBuilder()
                .setMethodDescriptor(listWatchlistsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateWatchlistRequest, Watchlist> createWatchlistTransportSettings =
        HttpJsonCallSettings.<CreateWatchlistRequest, Watchlist>newBuilder()
            .setMethodDescriptor(createWatchlistMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateWatchlistRequest, Watchlist> updateWatchlistTransportSettings =
        HttpJsonCallSettings.<UpdateWatchlistRequest, Watchlist>newBuilder()
            .setMethodDescriptor(updateWatchlistMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("watchlist.name", String.valueOf(request.getWatchlist().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteWatchlistRequest, Empty> deleteWatchlistTransportSettings =
        HttpJsonCallSettings.<DeleteWatchlistRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWatchlistMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getWatchlistCallable =
        callableFactory.createUnaryCallable(
            getWatchlistTransportSettings, settings.getWatchlistSettings(), clientContext);
    this.listWatchlistsCallable =
        callableFactory.createUnaryCallable(
            listWatchlistsTransportSettings, settings.listWatchlistsSettings(), clientContext);
    this.listWatchlistsPagedCallable =
        callableFactory.createPagedCallable(
            listWatchlistsTransportSettings, settings.listWatchlistsSettings(), clientContext);
    this.createWatchlistCallable =
        callableFactory.createUnaryCallable(
            createWatchlistTransportSettings, settings.createWatchlistSettings(), clientContext);
    this.updateWatchlistCallable =
        callableFactory.createUnaryCallable(
            updateWatchlistTransportSettings, settings.updateWatchlistSettings(), clientContext);
    this.deleteWatchlistCallable =
        callableFactory.createUnaryCallable(
            deleteWatchlistTransportSettings, settings.deleteWatchlistSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getWatchlistMethodDescriptor);
    methodDescriptors.add(listWatchlistsMethodDescriptor);
    methodDescriptors.add(createWatchlistMethodDescriptor);
    methodDescriptors.add(updateWatchlistMethodDescriptor);
    methodDescriptors.add(deleteWatchlistMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetWatchlistRequest, Watchlist> getWatchlistCallable() {
    return getWatchlistCallable;
  }

  @Override
  public UnaryCallable<ListWatchlistsRequest, ListWatchlistsResponse> listWatchlistsCallable() {
    return listWatchlistsCallable;
  }

  @Override
  public UnaryCallable<ListWatchlistsRequest, ListWatchlistsPagedResponse>
      listWatchlistsPagedCallable() {
    return listWatchlistsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWatchlistRequest, Watchlist> createWatchlistCallable() {
    return createWatchlistCallable;
  }

  @Override
  public UnaryCallable<UpdateWatchlistRequest, Watchlist> updateWatchlistCallable() {
    return updateWatchlistCallable;
  }

  @Override
  public UnaryCallable<DeleteWatchlistRequest, Empty> deleteWatchlistCallable() {
    return deleteWatchlistCallable;
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
