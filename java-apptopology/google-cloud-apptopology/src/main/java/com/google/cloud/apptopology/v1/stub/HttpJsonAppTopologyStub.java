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

package com.google.cloud.apptopology.v1.stub;

import static com.google.cloud.apptopology.v1.AppTopologyClient.ListDomainsPagedResponse;
import static com.google.cloud.apptopology.v1.AppTopologyClient.ListLocationsPagedResponse;

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
import com.google.cloud.apptopology.v1.Domain;
import com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyRequest;
import com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse;
import com.google.cloud.apptopology.v1.GetDomainRequest;
import com.google.cloud.apptopology.v1.GetSchemaRequest;
import com.google.cloud.apptopology.v1.ListDomainsRequest;
import com.google.cloud.apptopology.v1.ListDomainsResponse;
import com.google.cloud.apptopology.v1.Schema;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the AppTopology service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonAppTopologyStub extends AppTopologyStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GenerateDiscoveredResourcesTopologyRequest, GenerateDiscoveredResourcesTopologyResponse>
      generateDiscoveredResourcesTopologyMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateDiscoveredResourcesTopologyRequest,
                  GenerateDiscoveredResourcesTopologyResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.apptopology.v1.AppTopology/GenerateDiscoveredResourcesTopology")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateDiscoveredResourcesTopologyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/discoveredResourcesTopology}:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateDiscoveredResourcesTopologyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateDiscoveredResourcesTopologyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<GenerateDiscoveredResourcesTopologyResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateDiscoveredResourcesTopologyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSchemaRequest, Schema> getSchemaMethodDescriptor =
      ApiMethodDescriptor.<GetSchemaRequest, Schema>newBuilder()
          .setFullMethodName("google.cloud.apptopology.v1.AppTopology/GetSchema")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSchemaRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/domains/*/schema}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSchemaRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSchemaRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Schema>newBuilder()
                  .setDefaultInstance(Schema.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetDomainRequest, Domain> getDomainMethodDescriptor =
      ApiMethodDescriptor.<GetDomainRequest, Domain>newBuilder()
          .setFullMethodName("google.cloud.apptopology.v1.AppTopology/GetDomain")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDomainRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/domains/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDomainRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDomainRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Domain>newBuilder()
                  .setDefaultInstance(Domain.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListDomainsRequest, ListDomainsResponse>
      listDomainsMethodDescriptor =
          ApiMethodDescriptor.<ListDomainsRequest, ListDomainsResponse>newBuilder()
              .setFullMethodName("google.cloud.apptopology.v1.AppTopology/ListDomains")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDomainsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/domains",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDomainsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDomainsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDomainsResponse>newBuilder()
                      .setDefaultInstance(ListDomainsResponse.getDefaultInstance())
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
                          "/v1/{name=projects/*}/locations",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                          "/v1/{name=projects/*/locations/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private final UnaryCallable<
          GenerateDiscoveredResourcesTopologyRequest, GenerateDiscoveredResourcesTopologyResponse>
      generateDiscoveredResourcesTopologyCallable;
  private final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable;
  private final UnaryCallable<GetDomainRequest, Domain> getDomainCallable;
  private final UnaryCallable<ListDomainsRequest, ListDomainsResponse> listDomainsCallable;
  private final UnaryCallable<ListDomainsRequest, ListDomainsPagedResponse>
      listDomainsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAppTopologyStub create(AppTopologyStubSettings settings)
      throws IOException {
    return new HttpJsonAppTopologyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAppTopologyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAppTopologyStub(
        AppTopologyStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAppTopologyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAppTopologyStub(
        AppTopologyStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAppTopologyStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAppTopologyStub(AppTopologyStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAppTopologyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAppTopologyStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAppTopologyStub(
      AppTopologyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            GenerateDiscoveredResourcesTopologyRequest, GenerateDiscoveredResourcesTopologyResponse>
        generateDiscoveredResourcesTopologyTransportSettings =
            HttpJsonCallSettings
                .<GenerateDiscoveredResourcesTopologyRequest,
                    GenerateDiscoveredResourcesTopologyResponse>
                    newBuilder()
                .setMethodDescriptor(generateDiscoveredResourcesTopologyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GetSchemaRequest, Schema> getSchemaTransportSettings =
        HttpJsonCallSettings.<GetSchemaRequest, Schema>newBuilder()
            .setMethodDescriptor(getSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetDomainRequest, Domain> getDomainTransportSettings =
        HttpJsonCallSettings.<GetDomainRequest, Domain>newBuilder()
            .setMethodDescriptor(getDomainMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListDomainsRequest, ListDomainsResponse> listDomainsTransportSettings =
        HttpJsonCallSettings.<ListDomainsRequest, ListDomainsResponse>newBuilder()
            .setMethodDescriptor(listDomainsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.generateDiscoveredResourcesTopologyCallable =
        callableFactory.createUnaryCallable(
            generateDiscoveredResourcesTopologyTransportSettings,
            settings.generateDiscoveredResourcesTopologySettings(),
            clientContext);
    this.getSchemaCallable =
        callableFactory.createUnaryCallable(
            getSchemaTransportSettings, settings.getSchemaSettings(), clientContext);
    this.getDomainCallable =
        callableFactory.createUnaryCallable(
            getDomainTransportSettings, settings.getDomainSettings(), clientContext);
    this.listDomainsCallable =
        callableFactory.createUnaryCallable(
            listDomainsTransportSettings, settings.listDomainsSettings(), clientContext);
    this.listDomainsPagedCallable =
        callableFactory.createPagedCallable(
            listDomainsTransportSettings, settings.listDomainsSettings(), clientContext);
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
    methodDescriptors.add(generateDiscoveredResourcesTopologyMethodDescriptor);
    methodDescriptors.add(getSchemaMethodDescriptor);
    methodDescriptors.add(getDomainMethodDescriptor);
    methodDescriptors.add(listDomainsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          GenerateDiscoveredResourcesTopologyRequest, GenerateDiscoveredResourcesTopologyResponse>
      generateDiscoveredResourcesTopologyCallable() {
    return generateDiscoveredResourcesTopologyCallable;
  }

  @Override
  public UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return getSchemaCallable;
  }

  @Override
  public UnaryCallable<GetDomainRequest, Domain> getDomainCallable() {
    return getDomainCallable;
  }

  @Override
  public UnaryCallable<ListDomainsRequest, ListDomainsResponse> listDomainsCallable() {
    return listDomainsCallable;
  }

  @Override
  public UnaryCallable<ListDomainsRequest, ListDomainsPagedResponse> listDomainsPagedCallable() {
    return listDomainsPagedCallable;
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
