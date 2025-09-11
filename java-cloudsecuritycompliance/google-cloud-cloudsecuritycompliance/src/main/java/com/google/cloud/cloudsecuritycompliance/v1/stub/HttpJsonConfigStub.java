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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListCloudControlsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListFrameworksPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.CloudControl;
import com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.Framework;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest;
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
 * REST stub implementation for the Config service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonConfigStub extends ConfigStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListFrameworksRequest, ListFrameworksResponse>
      listFrameworksMethodDescriptor =
          ApiMethodDescriptor.<ListFrameworksRequest, ListFrameworksResponse>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/ListFrameworks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFrameworksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/frameworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFrameworksResponse>newBuilder()
                      .setDefaultInstance(ListFrameworksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFrameworkRequest, Framework>
      getFrameworkMethodDescriptor =
          ApiMethodDescriptor.<GetFrameworkRequest, Framework>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/GetFramework")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFrameworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/frameworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFrameworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFrameworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "majorRevisionId", request.getMajorRevisionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Framework>newBuilder()
                      .setDefaultInstance(Framework.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFrameworkRequest, Framework>
      createFrameworkMethodDescriptor =
          ApiMethodDescriptor.<CreateFrameworkRequest, Framework>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/CreateFramework")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFrameworkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/frameworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFrameworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFrameworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "frameworkId", request.getFrameworkId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("framework", request.getFramework(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Framework>newBuilder()
                      .setDefaultInstance(Framework.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFrameworkRequest, Framework>
      updateFrameworkMethodDescriptor =
          ApiMethodDescriptor.<UpdateFrameworkRequest, Framework>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/UpdateFramework")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFrameworkRequest>newBuilder()
                      .setPath(
                          "/v1/{framework.name=organizations/*/locations/*/frameworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFrameworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "framework.name", request.getFramework().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFrameworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "majorRevisionId", request.getMajorRevisionId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("framework", request.getFramework(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Framework>newBuilder()
                      .setDefaultInstance(Framework.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteFrameworkRequest, Empty>
      deleteFrameworkMethodDescriptor =
          ApiMethodDescriptor.<DeleteFrameworkRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/DeleteFramework")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFrameworkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/frameworks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFrameworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFrameworkRequest> serializer =
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

  private static final ApiMethodDescriptor<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsMethodDescriptor =
          ApiMethodDescriptor.<ListCloudControlsRequest, ListCloudControlsResponse>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/ListCloudControls")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCloudControlsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/cloudControls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudControlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudControlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCloudControlsResponse>newBuilder()
                      .setDefaultInstance(ListCloudControlsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCloudControlRequest, CloudControl>
      getCloudControlMethodDescriptor =
          ApiMethodDescriptor.<GetCloudControlRequest, CloudControl>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/GetCloudControl")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCloudControlRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/cloudControls/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudControl>newBuilder()
                      .setDefaultInstance(CloudControl.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCloudControlRequest, CloudControl>
      createCloudControlMethodDescriptor =
          ApiMethodDescriptor.<CreateCloudControlRequest, CloudControl>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Config/CreateCloudControl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCloudControlRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/cloudControls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloudControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloudControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cloudControlId", request.getCloudControlId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cloudControl", request.getCloudControl(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudControl>newBuilder()
                      .setDefaultInstance(CloudControl.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCloudControlRequest, CloudControl>
      updateCloudControlMethodDescriptor =
          ApiMethodDescriptor.<UpdateCloudControlRequest, CloudControl>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Config/UpdateCloudControl")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCloudControlRequest>newBuilder()
                      .setPath(
                          "/v1/{cloudControl.name=organizations/*/locations/*/cloudControls/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCloudControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "cloudControl.name", request.getCloudControl().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCloudControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cloudControl", request.getCloudControl(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudControl>newBuilder()
                      .setDefaultInstance(CloudControl.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCloudControlRequest, Empty>
      deleteCloudControlMethodDescriptor =
          ApiMethodDescriptor.<DeleteCloudControlRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Config/DeleteCloudControl")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCloudControlRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/cloudControls/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCloudControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCloudControlRequest> serializer =
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*}/locations",
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
                          "/v1/{name=organizations/*/locations/*}",
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

  private final UnaryCallable<ListFrameworksRequest, ListFrameworksResponse> listFrameworksCallable;
  private final UnaryCallable<ListFrameworksRequest, ListFrameworksPagedResponse>
      listFrameworksPagedCallable;
  private final UnaryCallable<GetFrameworkRequest, Framework> getFrameworkCallable;
  private final UnaryCallable<CreateFrameworkRequest, Framework> createFrameworkCallable;
  private final UnaryCallable<UpdateFrameworkRequest, Framework> updateFrameworkCallable;
  private final UnaryCallable<DeleteFrameworkRequest, Empty> deleteFrameworkCallable;
  private final UnaryCallable<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsCallable;
  private final UnaryCallable<ListCloudControlsRequest, ListCloudControlsPagedResponse>
      listCloudControlsPagedCallable;
  private final UnaryCallable<GetCloudControlRequest, CloudControl> getCloudControlCallable;
  private final UnaryCallable<CreateCloudControlRequest, CloudControl> createCloudControlCallable;
  private final UnaryCallable<UpdateCloudControlRequest, CloudControl> updateCloudControlCallable;
  private final UnaryCallable<DeleteCloudControlRequest, Empty> deleteCloudControlCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConfigStub create(ConfigStubSettings settings) throws IOException {
    return new HttpJsonConfigStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConfigStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonConfigStub(ConfigStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConfigStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConfigStub(
        ConfigStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConfigStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonConfigStub(ConfigStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonConfigCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConfigStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonConfigStub(
      ConfigStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListFrameworksRequest, ListFrameworksResponse>
        listFrameworksTransportSettings =
            HttpJsonCallSettings.<ListFrameworksRequest, ListFrameworksResponse>newBuilder()
                .setMethodDescriptor(listFrameworksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFrameworkRequest, Framework> getFrameworkTransportSettings =
        HttpJsonCallSettings.<GetFrameworkRequest, Framework>newBuilder()
            .setMethodDescriptor(getFrameworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateFrameworkRequest, Framework> createFrameworkTransportSettings =
        HttpJsonCallSettings.<CreateFrameworkRequest, Framework>newBuilder()
            .setMethodDescriptor(createFrameworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateFrameworkRequest, Framework> updateFrameworkTransportSettings =
        HttpJsonCallSettings.<UpdateFrameworkRequest, Framework>newBuilder()
            .setMethodDescriptor(updateFrameworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("framework.name", String.valueOf(request.getFramework().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteFrameworkRequest, Empty> deleteFrameworkTransportSettings =
        HttpJsonCallSettings.<DeleteFrameworkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFrameworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCloudControlsRequest, ListCloudControlsResponse>
        listCloudControlsTransportSettings =
            HttpJsonCallSettings.<ListCloudControlsRequest, ListCloudControlsResponse>newBuilder()
                .setMethodDescriptor(listCloudControlsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCloudControlRequest, CloudControl> getCloudControlTransportSettings =
        HttpJsonCallSettings.<GetCloudControlRequest, CloudControl>newBuilder()
            .setMethodDescriptor(getCloudControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCloudControlRequest, CloudControl>
        createCloudControlTransportSettings =
            HttpJsonCallSettings.<CreateCloudControlRequest, CloudControl>newBuilder()
                .setMethodDescriptor(createCloudControlMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCloudControlRequest, CloudControl>
        updateCloudControlTransportSettings =
            HttpJsonCallSettings.<UpdateCloudControlRequest, CloudControl>newBuilder()
                .setMethodDescriptor(updateCloudControlMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "cloud_control.name",
                          String.valueOf(request.getCloudControl().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCloudControlRequest, Empty> deleteCloudControlTransportSettings =
        HttpJsonCallSettings.<DeleteCloudControlRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCloudControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
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

    this.listFrameworksCallable =
        callableFactory.createUnaryCallable(
            listFrameworksTransportSettings, settings.listFrameworksSettings(), clientContext);
    this.listFrameworksPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworksTransportSettings, settings.listFrameworksSettings(), clientContext);
    this.getFrameworkCallable =
        callableFactory.createUnaryCallable(
            getFrameworkTransportSettings, settings.getFrameworkSettings(), clientContext);
    this.createFrameworkCallable =
        callableFactory.createUnaryCallable(
            createFrameworkTransportSettings, settings.createFrameworkSettings(), clientContext);
    this.updateFrameworkCallable =
        callableFactory.createUnaryCallable(
            updateFrameworkTransportSettings, settings.updateFrameworkSettings(), clientContext);
    this.deleteFrameworkCallable =
        callableFactory.createUnaryCallable(
            deleteFrameworkTransportSettings, settings.deleteFrameworkSettings(), clientContext);
    this.listCloudControlsCallable =
        callableFactory.createUnaryCallable(
            listCloudControlsTransportSettings,
            settings.listCloudControlsSettings(),
            clientContext);
    this.listCloudControlsPagedCallable =
        callableFactory.createPagedCallable(
            listCloudControlsTransportSettings,
            settings.listCloudControlsSettings(),
            clientContext);
    this.getCloudControlCallable =
        callableFactory.createUnaryCallable(
            getCloudControlTransportSettings, settings.getCloudControlSettings(), clientContext);
    this.createCloudControlCallable =
        callableFactory.createUnaryCallable(
            createCloudControlTransportSettings,
            settings.createCloudControlSettings(),
            clientContext);
    this.updateCloudControlCallable =
        callableFactory.createUnaryCallable(
            updateCloudControlTransportSettings,
            settings.updateCloudControlSettings(),
            clientContext);
    this.deleteCloudControlCallable =
        callableFactory.createUnaryCallable(
            deleteCloudControlTransportSettings,
            settings.deleteCloudControlSettings(),
            clientContext);
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
    methodDescriptors.add(listFrameworksMethodDescriptor);
    methodDescriptors.add(getFrameworkMethodDescriptor);
    methodDescriptors.add(createFrameworkMethodDescriptor);
    methodDescriptors.add(updateFrameworkMethodDescriptor);
    methodDescriptors.add(deleteFrameworkMethodDescriptor);
    methodDescriptors.add(listCloudControlsMethodDescriptor);
    methodDescriptors.add(getCloudControlMethodDescriptor);
    methodDescriptors.add(createCloudControlMethodDescriptor);
    methodDescriptors.add(updateCloudControlMethodDescriptor);
    methodDescriptors.add(deleteCloudControlMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListFrameworksRequest, ListFrameworksResponse> listFrameworksCallable() {
    return listFrameworksCallable;
  }

  @Override
  public UnaryCallable<ListFrameworksRequest, ListFrameworksPagedResponse>
      listFrameworksPagedCallable() {
    return listFrameworksPagedCallable;
  }

  @Override
  public UnaryCallable<GetFrameworkRequest, Framework> getFrameworkCallable() {
    return getFrameworkCallable;
  }

  @Override
  public UnaryCallable<CreateFrameworkRequest, Framework> createFrameworkCallable() {
    return createFrameworkCallable;
  }

  @Override
  public UnaryCallable<UpdateFrameworkRequest, Framework> updateFrameworkCallable() {
    return updateFrameworkCallable;
  }

  @Override
  public UnaryCallable<DeleteFrameworkRequest, Empty> deleteFrameworkCallable() {
    return deleteFrameworkCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsCallable() {
    return listCloudControlsCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlsRequest, ListCloudControlsPagedResponse>
      listCloudControlsPagedCallable() {
    return listCloudControlsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudControlRequest, CloudControl> getCloudControlCallable() {
    return getCloudControlCallable;
  }

  @Override
  public UnaryCallable<CreateCloudControlRequest, CloudControl> createCloudControlCallable() {
    return createCloudControlCallable;
  }

  @Override
  public UnaryCallable<UpdateCloudControlRequest, CloudControl> updateCloudControlCallable() {
    return updateCloudControlCallable;
  }

  @Override
  public UnaryCallable<DeleteCloudControlRequest, Empty> deleteCloudControlCallable() {
    return deleteCloudControlCallable;
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
