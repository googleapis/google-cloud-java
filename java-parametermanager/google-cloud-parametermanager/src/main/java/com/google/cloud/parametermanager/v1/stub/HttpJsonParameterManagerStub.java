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

package com.google.cloud.parametermanager.v1.stub;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.parametermanager.v1.CreateParameterRequest;
import com.google.cloud.parametermanager.v1.CreateParameterVersionRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest;
import com.google.cloud.parametermanager.v1.GetParameterRequest;
import com.google.cloud.parametermanager.v1.GetParameterVersionRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsResponse;
import com.google.cloud.parametermanager.v1.ListParametersRequest;
import com.google.cloud.parametermanager.v1.ListParametersResponse;
import com.google.cloud.parametermanager.v1.Parameter;
import com.google.cloud.parametermanager.v1.ParameterVersion;
import com.google.cloud.parametermanager.v1.RenderParameterVersionRequest;
import com.google.cloud.parametermanager.v1.RenderParameterVersionResponse;
import com.google.cloud.parametermanager.v1.UpdateParameterRequest;
import com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest;
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
 * REST stub implementation for the ParameterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonParameterManagerStub extends ParameterManagerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListParametersRequest, ListParametersResponse>
      listParametersMethodDescriptor =
          ApiMethodDescriptor.<ListParametersRequest, ListParametersResponse>newBuilder()
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/ListParameters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListParametersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/parameters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListParametersResponse>newBuilder()
                      .setDefaultInstance(ListParametersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetParameterRequest, Parameter>
      getParameterMethodDescriptor =
          ApiMethodDescriptor.<GetParameterRequest, Parameter>newBuilder()
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/GetParameter")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetParameterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/parameters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Parameter>newBuilder()
                      .setDefaultInstance(Parameter.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateParameterRequest, Parameter>
      createParameterMethodDescriptor =
          ApiMethodDescriptor.<CreateParameterRequest, Parameter>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/CreateParameter")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateParameterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/parameters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "parameterId", request.getParameterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("parameter", request.getParameter(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Parameter>newBuilder()
                      .setDefaultInstance(Parameter.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateParameterRequest, Parameter>
      updateParameterMethodDescriptor =
          ApiMethodDescriptor.<UpdateParameterRequest, Parameter>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/UpdateParameter")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateParameterRequest>newBuilder()
                      .setPath(
                          "/v1/{parameter.name=projects/*/locations/*/parameters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "parameter.name", request.getParameter().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("parameter", request.getParameter(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Parameter>newBuilder()
                      .setDefaultInstance(Parameter.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteParameterRequest, Empty>
      deleteParameterMethodDescriptor =
          ApiMethodDescriptor.<DeleteParameterRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/DeleteParameter")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteParameterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/parameters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteParameterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<
          ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListParameterVersionsRequest, ListParameterVersionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/ListParameterVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListParameterVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/parameters/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListParameterVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListParameterVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListParameterVersionsResponse>newBuilder()
                      .setDefaultInstance(ListParameterVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionMethodDescriptor =
          ApiMethodDescriptor.<GetParameterVersionRequest, ParameterVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/GetParameterVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetParameterVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/parameters/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ParameterVersion>newBuilder()
                      .setDefaultInstance(ParameterVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionMethodDescriptor =
          ApiMethodDescriptor
              .<RenderParameterVersionRequest, RenderParameterVersionResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/RenderParameterVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenderParameterVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/parameters/*/versions/*}:render",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenderParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenderParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RenderParameterVersionResponse>newBuilder()
                      .setDefaultInstance(RenderParameterVersionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionMethodDescriptor =
          ApiMethodDescriptor.<CreateParameterVersionRequest, ParameterVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/CreateParameterVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateParameterVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/parameters/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "parameterVersionId", request.getParameterVersionId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("parameterVersion", request.getParameterVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ParameterVersion>newBuilder()
                      .setDefaultInstance(ParameterVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionMethodDescriptor =
          ApiMethodDescriptor.<UpdateParameterVersionRequest, ParameterVersion>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/UpdateParameterVersion")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateParameterVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parameterVersion.name=projects/*/locations/*/parameters/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "parameterVersion.name",
                                request.getParameterVersion().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("parameterVersion", request.getParameterVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ParameterVersion>newBuilder()
                      .setDefaultInstance(ParameterVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteParameterVersionRequest, Empty>
      deleteParameterVersionMethodDescriptor =
          ApiMethodDescriptor.<DeleteParameterVersionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/DeleteParameterVersion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteParameterVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/parameters/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteParameterVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private final UnaryCallable<ListParametersRequest, ListParametersResponse> listParametersCallable;
  private final UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable;
  private final UnaryCallable<GetParameterRequest, Parameter> getParameterCallable;
  private final UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable;
  private final UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable;
  private final UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable;
  private final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable;
  private final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable;
  private final UnaryCallable<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionCallable;
  private final UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable;
  private final UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable;
  private final UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable;
  private final UnaryCallable<DeleteParameterVersionRequest, Empty> deleteParameterVersionCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonParameterManagerStub create(ParameterManagerStubSettings settings)
      throws IOException {
    return new HttpJsonParameterManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonParameterManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonParameterManagerStub(
        ParameterManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonParameterManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonParameterManagerStub(
        ParameterManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonParameterManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonParameterManagerStub(
      ParameterManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonParameterManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonParameterManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonParameterManagerStub(
      ParameterManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListParametersRequest, ListParametersResponse>
        listParametersTransportSettings =
            HttpJsonCallSettings.<ListParametersRequest, ListParametersResponse>newBuilder()
                .setMethodDescriptor(listParametersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetParameterRequest, Parameter> getParameterTransportSettings =
        HttpJsonCallSettings.<GetParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(getParameterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateParameterRequest, Parameter> createParameterTransportSettings =
        HttpJsonCallSettings.<CreateParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(createParameterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateParameterRequest, Parameter> updateParameterTransportSettings =
        HttpJsonCallSettings.<UpdateParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(updateParameterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parameter.name", String.valueOf(request.getParameter().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteParameterRequest, Empty> deleteParameterTransportSettings =
        HttpJsonCallSettings.<DeleteParameterRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteParameterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListParameterVersionsRequest, ListParameterVersionsResponse>
        listParameterVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListParameterVersionsRequest, ListParameterVersionsResponse>newBuilder()
                .setMethodDescriptor(listParameterVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetParameterVersionRequest, ParameterVersion>
        getParameterVersionTransportSettings =
            HttpJsonCallSettings.<GetParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(getParameterVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RenderParameterVersionRequest, RenderParameterVersionResponse>
        renderParameterVersionTransportSettings =
            HttpJsonCallSettings
                .<RenderParameterVersionRequest, RenderParameterVersionResponse>newBuilder()
                .setMethodDescriptor(renderParameterVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateParameterVersionRequest, ParameterVersion>
        createParameterVersionTransportSettings =
            HttpJsonCallSettings.<CreateParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(createParameterVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateParameterVersionRequest, ParameterVersion>
        updateParameterVersionTransportSettings =
            HttpJsonCallSettings.<UpdateParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(updateParameterVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "parameter_version.name",
                          String.valueOf(request.getParameterVersion().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteParameterVersionRequest, Empty>
        deleteParameterVersionTransportSettings =
            HttpJsonCallSettings.<DeleteParameterVersionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteParameterVersionMethodDescriptor)
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

    this.listParametersCallable =
        callableFactory.createUnaryCallable(
            listParametersTransportSettings, settings.listParametersSettings(), clientContext);
    this.listParametersPagedCallable =
        callableFactory.createPagedCallable(
            listParametersTransportSettings, settings.listParametersSettings(), clientContext);
    this.getParameterCallable =
        callableFactory.createUnaryCallable(
            getParameterTransportSettings, settings.getParameterSettings(), clientContext);
    this.createParameterCallable =
        callableFactory.createUnaryCallable(
            createParameterTransportSettings, settings.createParameterSettings(), clientContext);
    this.updateParameterCallable =
        callableFactory.createUnaryCallable(
            updateParameterTransportSettings, settings.updateParameterSettings(), clientContext);
    this.deleteParameterCallable =
        callableFactory.createUnaryCallable(
            deleteParameterTransportSettings, settings.deleteParameterSettings(), clientContext);
    this.listParameterVersionsCallable =
        callableFactory.createUnaryCallable(
            listParameterVersionsTransportSettings,
            settings.listParameterVersionsSettings(),
            clientContext);
    this.listParameterVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listParameterVersionsTransportSettings,
            settings.listParameterVersionsSettings(),
            clientContext);
    this.getParameterVersionCallable =
        callableFactory.createUnaryCallable(
            getParameterVersionTransportSettings,
            settings.getParameterVersionSettings(),
            clientContext);
    this.renderParameterVersionCallable =
        callableFactory.createUnaryCallable(
            renderParameterVersionTransportSettings,
            settings.renderParameterVersionSettings(),
            clientContext);
    this.createParameterVersionCallable =
        callableFactory.createUnaryCallable(
            createParameterVersionTransportSettings,
            settings.createParameterVersionSettings(),
            clientContext);
    this.updateParameterVersionCallable =
        callableFactory.createUnaryCallable(
            updateParameterVersionTransportSettings,
            settings.updateParameterVersionSettings(),
            clientContext);
    this.deleteParameterVersionCallable =
        callableFactory.createUnaryCallable(
            deleteParameterVersionTransportSettings,
            settings.deleteParameterVersionSettings(),
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
    methodDescriptors.add(listParametersMethodDescriptor);
    methodDescriptors.add(getParameterMethodDescriptor);
    methodDescriptors.add(createParameterMethodDescriptor);
    methodDescriptors.add(updateParameterMethodDescriptor);
    methodDescriptors.add(deleteParameterMethodDescriptor);
    methodDescriptors.add(listParameterVersionsMethodDescriptor);
    methodDescriptors.add(getParameterVersionMethodDescriptor);
    methodDescriptors.add(renderParameterVersionMethodDescriptor);
    methodDescriptors.add(createParameterVersionMethodDescriptor);
    methodDescriptors.add(updateParameterVersionMethodDescriptor);
    methodDescriptors.add(deleteParameterVersionMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListParametersRequest, ListParametersResponse> listParametersCallable() {
    return listParametersCallable;
  }

  @Override
  public UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable() {
    return listParametersPagedCallable;
  }

  @Override
  public UnaryCallable<GetParameterRequest, Parameter> getParameterCallable() {
    return getParameterCallable;
  }

  @Override
  public UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable() {
    return createParameterCallable;
  }

  @Override
  public UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable() {
    return updateParameterCallable;
  }

  @Override
  public UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable() {
    return deleteParameterCallable;
  }

  @Override
  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable() {
    return listParameterVersionsCallable;
  }

  @Override
  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable() {
    return listParameterVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetParameterVersionRequest, ParameterVersion> getParameterVersionCallable() {
    return getParameterVersionCallable;
  }

  @Override
  public UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable() {
    return renderParameterVersionCallable;
  }

  @Override
  public UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable() {
    return createParameterVersionCallable;
  }

  @Override
  public UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable() {
    return updateParameterVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteParameterVersionRequest, Empty> deleteParameterVersionCallable() {
    return deleteParameterVersionCallable;
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
