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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.NativeDashboardServiceClient.ListNativeDashboardsPagedResponse;

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
import com.google.cloud.chronicle.v1.AddChartRequest;
import com.google.cloud.chronicle.v1.AddChartResponse;
import com.google.cloud.chronicle.v1.CreateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DuplicateChartRequest;
import com.google.cloud.chronicle.v1.DuplicateChartResponse;
import com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.EditChartRequest;
import com.google.cloud.chronicle.v1.EditChartResponse;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.GetNativeDashboardRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.ListNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.NativeDashboard;
import com.google.cloud.chronicle.v1.RemoveChartRequest;
import com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest;
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
 * REST stub implementation for the NativeDashboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonNativeDashboardServiceStub extends NativeDashboardServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardMethodDescriptor =
          ApiMethodDescriptor.<CreateNativeDashboardRequest, NativeDashboard>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/CreateNativeDashboard")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNativeDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/nativeDashboards",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("nativeDashboard", request.getNativeDashboard(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NativeDashboard>newBuilder()
                      .setDefaultInstance(NativeDashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardMethodDescriptor =
          ApiMethodDescriptor.<GetNativeDashboardRequest, NativeDashboard>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/GetNativeDashboard")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNativeDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/nativeDashboards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NativeDashboard>newBuilder()
                      .setDefaultInstance(NativeDashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNativeDashboardsRequest, ListNativeDashboardsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/ListNativeDashboards")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNativeDashboardsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/nativeDashboards",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNativeDashboardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNativeDashboardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNativeDashboardsResponse>newBuilder()
                      .setDefaultInstance(ListNativeDashboardsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardMethodDescriptor =
          ApiMethodDescriptor.<UpdateNativeDashboardRequest, NativeDashboard>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/UpdateNativeDashboard")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNativeDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{nativeDashboard.name=projects/*/locations/*/instances/*/nativeDashboards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "nativeDashboard.name",
                                request.getNativeDashboard().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("nativeDashboard", request.getNativeDashboard(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NativeDashboard>newBuilder()
                      .setDefaultInstance(NativeDashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardMethodDescriptor =
          ApiMethodDescriptor.<DuplicateNativeDashboardRequest, NativeDashboard>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/DuplicateNativeDashboard")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DuplicateNativeDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/nativeDashboards/*}:duplicate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DuplicateNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DuplicateNativeDashboardRequest> serializer =
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
                  ProtoMessageResponseParser.<NativeDashboard>newBuilder()
                      .setDefaultInstance(NativeDashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNativeDashboardRequest, Empty>
      deleteNativeDashboardMethodDescriptor =
          ApiMethodDescriptor.<DeleteNativeDashboardRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/DeleteNativeDashboard")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNativeDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/nativeDashboards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNativeDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNativeDashboardRequest> serializer =
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

  private static final ApiMethodDescriptor<AddChartRequest, AddChartResponse>
      addChartMethodDescriptor =
          ApiMethodDescriptor.<AddChartRequest, AddChartResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/AddChart")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddChartRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/nativeDashboards/*}:addChart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddChartRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddChartRequest> serializer =
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
                  ProtoMessageResponseParser.<AddChartResponse>newBuilder()
                      .setDefaultInstance(AddChartResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveChartRequest, NativeDashboard>
      removeChartMethodDescriptor =
          ApiMethodDescriptor.<RemoveChartRequest, NativeDashboard>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/RemoveChart")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveChartRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/nativeDashboards/*}:removeChart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveChartRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveChartRequest> serializer =
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
                  ProtoMessageResponseParser.<NativeDashboard>newBuilder()
                      .setDefaultInstance(NativeDashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EditChartRequest, EditChartResponse>
      editChartMethodDescriptor =
          ApiMethodDescriptor.<EditChartRequest, EditChartResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/EditChart")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EditChartRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/nativeDashboards/*}:editChart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EditChartRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EditChartRequest> serializer =
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
                  ProtoMessageResponseParser.<EditChartResponse>newBuilder()
                      .setDefaultInstance(EditChartResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DuplicateChartRequest, DuplicateChartResponse>
      duplicateChartMethodDescriptor =
          ApiMethodDescriptor.<DuplicateChartRequest, DuplicateChartResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/DuplicateChart")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DuplicateChartRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/nativeDashboards/*}:duplicateChart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DuplicateChartRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DuplicateChartRequest> serializer =
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
                  ProtoMessageResponseParser.<DuplicateChartResponse>newBuilder()
                      .setDefaultInstance(DuplicateChartResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsMethodDescriptor =
          ApiMethodDescriptor
              .<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/ExportNativeDashboards")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportNativeDashboardsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/nativeDashboards:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportNativeDashboardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportNativeDashboardsRequest> serializer =
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
                  ProtoMessageResponseParser.<ExportNativeDashboardsResponse>newBuilder()
                      .setDefaultInstance(ExportNativeDashboardsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsMethodDescriptor =
          ApiMethodDescriptor
              .<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/ImportNativeDashboards")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportNativeDashboardsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/nativeDashboards:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportNativeDashboardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportNativeDashboardsRequest> serializer =
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
                  ProtoMessageResponseParser.<ImportNativeDashboardsResponse>newBuilder()
                      .setDefaultInstance(ImportNativeDashboardsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardCallable;
  private final UnaryCallable<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardCallable;
  private final UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsCallable;
  private final UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsPagedResponse>
      listNativeDashboardsPagedCallable;
  private final UnaryCallable<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardCallable;
  private final UnaryCallable<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardCallable;
  private final UnaryCallable<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardCallable;
  private final UnaryCallable<AddChartRequest, AddChartResponse> addChartCallable;
  private final UnaryCallable<RemoveChartRequest, NativeDashboard> removeChartCallable;
  private final UnaryCallable<EditChartRequest, EditChartResponse> editChartCallable;
  private final UnaryCallable<DuplicateChartRequest, DuplicateChartResponse> duplicateChartCallable;
  private final UnaryCallable<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsCallable;
  private final UnaryCallable<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNativeDashboardServiceStub create(
      NativeDashboardServiceStubSettings settings) throws IOException {
    return new HttpJsonNativeDashboardServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNativeDashboardServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNativeDashboardServiceStub(
        NativeDashboardServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonNativeDashboardServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNativeDashboardServiceStub(
        NativeDashboardServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNativeDashboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNativeDashboardServiceStub(
      NativeDashboardServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonNativeDashboardServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNativeDashboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNativeDashboardServiceStub(
      NativeDashboardServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateNativeDashboardRequest, NativeDashboard>
        createNativeDashboardTransportSettings =
            HttpJsonCallSettings.<CreateNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(createNativeDashboardMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetNativeDashboardRequest, NativeDashboard>
        getNativeDashboardTransportSettings =
            HttpJsonCallSettings.<GetNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(getNativeDashboardMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
        listNativeDashboardsTransportSettings =
            HttpJsonCallSettings
                .<ListNativeDashboardsRequest, ListNativeDashboardsResponse>newBuilder()
                .setMethodDescriptor(listNativeDashboardsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateNativeDashboardRequest, NativeDashboard>
        updateNativeDashboardTransportSettings =
            HttpJsonCallSettings.<UpdateNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(updateNativeDashboardMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "native_dashboard.name",
                          String.valueOf(request.getNativeDashboard().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DuplicateNativeDashboardRequest, NativeDashboard>
        duplicateNativeDashboardTransportSettings =
            HttpJsonCallSettings.<DuplicateNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(duplicateNativeDashboardMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<DeleteNativeDashboardRequest, Empty>
        deleteNativeDashboardTransportSettings =
            HttpJsonCallSettings.<DeleteNativeDashboardRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNativeDashboardMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<AddChartRequest, AddChartResponse> addChartTransportSettings =
        HttpJsonCallSettings.<AddChartRequest, AddChartResponse>newBuilder()
            .setMethodDescriptor(addChartMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<RemoveChartRequest, NativeDashboard> removeChartTransportSettings =
        HttpJsonCallSettings.<RemoveChartRequest, NativeDashboard>newBuilder()
            .setMethodDescriptor(removeChartMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<EditChartRequest, EditChartResponse> editChartTransportSettings =
        HttpJsonCallSettings.<EditChartRequest, EditChartResponse>newBuilder()
            .setMethodDescriptor(editChartMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DuplicateChartRequest, DuplicateChartResponse>
        duplicateChartTransportSettings =
            HttpJsonCallSettings.<DuplicateChartRequest, DuplicateChartResponse>newBuilder()
                .setMethodDescriptor(duplicateChartMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
        exportNativeDashboardsTransportSettings =
            HttpJsonCallSettings
                .<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>newBuilder()
                .setMethodDescriptor(exportNativeDashboardsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
        importNativeDashboardsTransportSettings =
            HttpJsonCallSettings
                .<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>newBuilder()
                .setMethodDescriptor(importNativeDashboardsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.createNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            createNativeDashboardTransportSettings,
            settings.createNativeDashboardSettings(),
            clientContext);
    this.getNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            getNativeDashboardTransportSettings,
            settings.getNativeDashboardSettings(),
            clientContext);
    this.listNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            listNativeDashboardsTransportSettings,
            settings.listNativeDashboardsSettings(),
            clientContext);
    this.listNativeDashboardsPagedCallable =
        callableFactory.createPagedCallable(
            listNativeDashboardsTransportSettings,
            settings.listNativeDashboardsSettings(),
            clientContext);
    this.updateNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            updateNativeDashboardTransportSettings,
            settings.updateNativeDashboardSettings(),
            clientContext);
    this.duplicateNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            duplicateNativeDashboardTransportSettings,
            settings.duplicateNativeDashboardSettings(),
            clientContext);
    this.deleteNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            deleteNativeDashboardTransportSettings,
            settings.deleteNativeDashboardSettings(),
            clientContext);
    this.addChartCallable =
        callableFactory.createUnaryCallable(
            addChartTransportSettings, settings.addChartSettings(), clientContext);
    this.removeChartCallable =
        callableFactory.createUnaryCallable(
            removeChartTransportSettings, settings.removeChartSettings(), clientContext);
    this.editChartCallable =
        callableFactory.createUnaryCallable(
            editChartTransportSettings, settings.editChartSettings(), clientContext);
    this.duplicateChartCallable =
        callableFactory.createUnaryCallable(
            duplicateChartTransportSettings, settings.duplicateChartSettings(), clientContext);
    this.exportNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            exportNativeDashboardsTransportSettings,
            settings.exportNativeDashboardsSettings(),
            clientContext);
    this.importNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            importNativeDashboardsTransportSettings,
            settings.importNativeDashboardsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createNativeDashboardMethodDescriptor);
    methodDescriptors.add(getNativeDashboardMethodDescriptor);
    methodDescriptors.add(listNativeDashboardsMethodDescriptor);
    methodDescriptors.add(updateNativeDashboardMethodDescriptor);
    methodDescriptors.add(duplicateNativeDashboardMethodDescriptor);
    methodDescriptors.add(deleteNativeDashboardMethodDescriptor);
    methodDescriptors.add(addChartMethodDescriptor);
    methodDescriptors.add(removeChartMethodDescriptor);
    methodDescriptors.add(editChartMethodDescriptor);
    methodDescriptors.add(duplicateChartMethodDescriptor);
    methodDescriptors.add(exportNativeDashboardsMethodDescriptor);
    methodDescriptors.add(importNativeDashboardsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardCallable() {
    return createNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<GetNativeDashboardRequest, NativeDashboard> getNativeDashboardCallable() {
    return getNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsCallable() {
    return listNativeDashboardsCallable;
  }

  @Override
  public UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsPagedResponse>
      listNativeDashboardsPagedCallable() {
    return listNativeDashboardsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardCallable() {
    return updateNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardCallable() {
    return duplicateNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardCallable() {
    return deleteNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<AddChartRequest, AddChartResponse> addChartCallable() {
    return addChartCallable;
  }

  @Override
  public UnaryCallable<RemoveChartRequest, NativeDashboard> removeChartCallable() {
    return removeChartCallable;
  }

  @Override
  public UnaryCallable<EditChartRequest, EditChartResponse> editChartCallable() {
    return editChartCallable;
  }

  @Override
  public UnaryCallable<DuplicateChartRequest, DuplicateChartResponse> duplicateChartCallable() {
    return duplicateChartCallable;
  }

  @Override
  public UnaryCallable<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsCallable() {
    return exportNativeDashboardsCallable;
  }

  @Override
  public UnaryCallable<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsCallable() {
    return importNativeDashboardsCallable;
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
