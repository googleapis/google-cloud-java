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

package com.google.maps.mapmanagement.v2beta.stub;

import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapContextConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListStyleConfigsPagedResponse;

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
import com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse;
import com.google.maps.mapmanagement.v2beta.MapConfig;
import com.google.maps.mapmanagement.v2beta.MapContextConfig;
import com.google.maps.mapmanagement.v2beta.StyleConfig;
import com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest;
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
 * REST stub implementation for the MapManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMapManagementStub extends MapManagementStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateMapConfigRequest, MapConfig>
      createMapConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateMapConfigRequest, MapConfig>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/CreateMapConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMapConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*}/mapConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMapConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMapConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("mapConfig", request.getMapConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MapConfig>newBuilder()
                      .setDefaultInstance(MapConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMapConfigRequest, MapConfig>
      getMapConfigMethodDescriptor =
          ApiMethodDescriptor.<GetMapConfigRequest, MapConfig>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/GetMapConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMapConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/mapConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMapConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMapConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MapConfig>newBuilder()
                      .setDefaultInstance(MapConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMapConfigsRequest, ListMapConfigsResponse>
      listMapConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListMapConfigsRequest, ListMapConfigsResponse>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/ListMapConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMapConfigsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*}/mapConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMapConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMapConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMapConfigsResponse>newBuilder()
                      .setDefaultInstance(ListMapConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateMapConfigRequest, MapConfig>
      updateMapConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateMapConfigRequest, MapConfig>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/UpdateMapConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMapConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{mapConfig.name=projects/*/mapConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMapConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "mapConfig.name", request.getMapConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMapConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("mapConfig", request.getMapConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MapConfig>newBuilder()
                      .setDefaultInstance(MapConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMapConfigRequest, Empty>
      deleteMapConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteMapConfigRequest, Empty>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/DeleteMapConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMapConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/mapConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMapConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMapConfigRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateStyleConfigRequest, StyleConfig>
      createStyleConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateStyleConfigRequest, StyleConfig>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/CreateStyleConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateStyleConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*}/styleConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStyleConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStyleConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("styleConfig", request.getStyleConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StyleConfig>newBuilder()
                      .setDefaultInstance(StyleConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetStyleConfigRequest, StyleConfig>
      getStyleConfigMethodDescriptor =
          ApiMethodDescriptor.<GetStyleConfigRequest, StyleConfig>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/GetStyleConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStyleConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/styleConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetStyleConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetStyleConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StyleConfig>newBuilder()
                      .setDefaultInstance(StyleConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListStyleConfigsRequest, ListStyleConfigsResponse>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/ListStyleConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListStyleConfigsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*}/styleConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListStyleConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListStyleConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListStyleConfigsResponse>newBuilder()
                      .setDefaultInstance(ListStyleConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateStyleConfigRequest, StyleConfig>
      updateStyleConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateStyleConfigRequest, StyleConfig>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/UpdateStyleConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateStyleConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{styleConfig.name=projects/*/styleConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStyleConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "styleConfig.name", request.getStyleConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStyleConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("styleConfig", request.getStyleConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StyleConfig>newBuilder()
                      .setDefaultInstance(StyleConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteStyleConfigRequest, Empty>
      deleteStyleConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteStyleConfigRequest, Empty>newBuilder()
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/DeleteStyleConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteStyleConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/styleConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStyleConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStyleConfigRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateMapContextConfigRequest, MapContextConfig>newBuilder()
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/CreateMapContextConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMapContextConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/mapConfigs/*}/mapContextConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMapContextConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMapContextConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("mapContextConfig", request.getMapContextConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MapContextConfig>newBuilder()
                      .setDefaultInstance(MapContextConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigMethodDescriptor =
          ApiMethodDescriptor.<GetMapContextConfigRequest, MapContextConfig>newBuilder()
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/GetMapContextConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMapContextConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/mapConfigs/*/mapContextConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMapContextConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMapContextConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MapContextConfig>newBuilder()
                      .setDefaultInstance(MapContextConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListMapContextConfigsRequest, ListMapContextConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/ListMapContextConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMapContextConfigsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/mapConfigs/*}/mapContextConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMapContextConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMapContextConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMapContextConfigsResponse>newBuilder()
                      .setDefaultInstance(ListMapContextConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateMapContextConfigRequest, MapContextConfig>newBuilder()
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/UpdateMapContextConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMapContextConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{mapContextConfig.name=projects/*/mapConfigs/*/mapContextConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMapContextConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "mapContextConfig.name",
                                request.getMapContextConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMapContextConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("mapContextConfig", request.getMapContextConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MapContextConfig>newBuilder()
                      .setDefaultInstance(MapContextConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMapContextConfigRequest, Empty>
      deleteMapContextConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteMapContextConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/DeleteMapContextConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMapContextConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/mapConfigs/*/mapContextConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMapContextConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMapContextConfigRequest> serializer =
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

  private final UnaryCallable<CreateMapConfigRequest, MapConfig> createMapConfigCallable;
  private final UnaryCallable<GetMapConfigRequest, MapConfig> getMapConfigCallable;
  private final UnaryCallable<ListMapConfigsRequest, ListMapConfigsResponse> listMapConfigsCallable;
  private final UnaryCallable<ListMapConfigsRequest, ListMapConfigsPagedResponse>
      listMapConfigsPagedCallable;
  private final UnaryCallable<UpdateMapConfigRequest, MapConfig> updateMapConfigCallable;
  private final UnaryCallable<DeleteMapConfigRequest, Empty> deleteMapConfigCallable;
  private final UnaryCallable<CreateStyleConfigRequest, StyleConfig> createStyleConfigCallable;
  private final UnaryCallable<GetStyleConfigRequest, StyleConfig> getStyleConfigCallable;
  private final UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsCallable;
  private final UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsPagedResponse>
      listStyleConfigsPagedCallable;
  private final UnaryCallable<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigCallable;
  private final UnaryCallable<DeleteStyleConfigRequest, Empty> deleteStyleConfigCallable;
  private final UnaryCallable<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigCallable;
  private final UnaryCallable<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigCallable;
  private final UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsCallable;
  private final UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsPagedResponse>
      listMapContextConfigsPagedCallable;
  private final UnaryCallable<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigCallable;
  private final UnaryCallable<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMapManagementStub create(MapManagementStubSettings settings)
      throws IOException {
    return new HttpJsonMapManagementStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMapManagementStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMapManagementStub(
        MapManagementStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMapManagementStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMapManagementStub(
        MapManagementStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMapManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMapManagementStub(
      MapManagementStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMapManagementCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMapManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMapManagementStub(
      MapManagementStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateMapConfigRequest, MapConfig> createMapConfigTransportSettings =
        HttpJsonCallSettings.<CreateMapConfigRequest, MapConfig>newBuilder()
            .setMethodDescriptor(createMapConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetMapConfigRequest, MapConfig> getMapConfigTransportSettings =
        HttpJsonCallSettings.<GetMapConfigRequest, MapConfig>newBuilder()
            .setMethodDescriptor(getMapConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListMapConfigsRequest, ListMapConfigsResponse>
        listMapConfigsTransportSettings =
            HttpJsonCallSettings.<ListMapConfigsRequest, ListMapConfigsResponse>newBuilder()
                .setMethodDescriptor(listMapConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateMapConfigRequest, MapConfig> updateMapConfigTransportSettings =
        HttpJsonCallSettings.<UpdateMapConfigRequest, MapConfig>newBuilder()
            .setMethodDescriptor(updateMapConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("map_config.name", String.valueOf(request.getMapConfig().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMapConfigRequest, Empty> deleteMapConfigTransportSettings =
        HttpJsonCallSettings.<DeleteMapConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMapConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateStyleConfigRequest, StyleConfig> createStyleConfigTransportSettings =
        HttpJsonCallSettings.<CreateStyleConfigRequest, StyleConfig>newBuilder()
            .setMethodDescriptor(createStyleConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetStyleConfigRequest, StyleConfig> getStyleConfigTransportSettings =
        HttpJsonCallSettings.<GetStyleConfigRequest, StyleConfig>newBuilder()
            .setMethodDescriptor(getStyleConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListStyleConfigsRequest, ListStyleConfigsResponse>
        listStyleConfigsTransportSettings =
            HttpJsonCallSettings.<ListStyleConfigsRequest, ListStyleConfigsResponse>newBuilder()
                .setMethodDescriptor(listStyleConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigTransportSettings =
        HttpJsonCallSettings.<UpdateStyleConfigRequest, StyleConfig>newBuilder()
            .setMethodDescriptor(updateStyleConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "style_config.name", String.valueOf(request.getStyleConfig().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteStyleConfigRequest, Empty> deleteStyleConfigTransportSettings =
        HttpJsonCallSettings.<DeleteStyleConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStyleConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateMapContextConfigRequest, MapContextConfig>
        createMapContextConfigTransportSettings =
            HttpJsonCallSettings.<CreateMapContextConfigRequest, MapContextConfig>newBuilder()
                .setMethodDescriptor(createMapContextConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetMapContextConfigRequest, MapContextConfig>
        getMapContextConfigTransportSettings =
            HttpJsonCallSettings.<GetMapContextConfigRequest, MapContextConfig>newBuilder()
                .setMethodDescriptor(getMapContextConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
        listMapContextConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListMapContextConfigsRequest, ListMapContextConfigsResponse>newBuilder()
                .setMethodDescriptor(listMapContextConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateMapContextConfigRequest, MapContextConfig>
        updateMapContextConfigTransportSettings =
            HttpJsonCallSettings.<UpdateMapContextConfigRequest, MapContextConfig>newBuilder()
                .setMethodDescriptor(updateMapContextConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "map_context_config.name",
                          String.valueOf(request.getMapContextConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteMapContextConfigRequest, Empty>
        deleteMapContextConfigTransportSettings =
            HttpJsonCallSettings.<DeleteMapContextConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMapContextConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.createMapConfigCallable =
        callableFactory.createUnaryCallable(
            createMapConfigTransportSettings, settings.createMapConfigSettings(), clientContext);
    this.getMapConfigCallable =
        callableFactory.createUnaryCallable(
            getMapConfigTransportSettings, settings.getMapConfigSettings(), clientContext);
    this.listMapConfigsCallable =
        callableFactory.createUnaryCallable(
            listMapConfigsTransportSettings, settings.listMapConfigsSettings(), clientContext);
    this.listMapConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listMapConfigsTransportSettings, settings.listMapConfigsSettings(), clientContext);
    this.updateMapConfigCallable =
        callableFactory.createUnaryCallable(
            updateMapConfigTransportSettings, settings.updateMapConfigSettings(), clientContext);
    this.deleteMapConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMapConfigTransportSettings, settings.deleteMapConfigSettings(), clientContext);
    this.createStyleConfigCallable =
        callableFactory.createUnaryCallable(
            createStyleConfigTransportSettings,
            settings.createStyleConfigSettings(),
            clientContext);
    this.getStyleConfigCallable =
        callableFactory.createUnaryCallable(
            getStyleConfigTransportSettings, settings.getStyleConfigSettings(), clientContext);
    this.listStyleConfigsCallable =
        callableFactory.createUnaryCallable(
            listStyleConfigsTransportSettings, settings.listStyleConfigsSettings(), clientContext);
    this.listStyleConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listStyleConfigsTransportSettings, settings.listStyleConfigsSettings(), clientContext);
    this.updateStyleConfigCallable =
        callableFactory.createUnaryCallable(
            updateStyleConfigTransportSettings,
            settings.updateStyleConfigSettings(),
            clientContext);
    this.deleteStyleConfigCallable =
        callableFactory.createUnaryCallable(
            deleteStyleConfigTransportSettings,
            settings.deleteStyleConfigSettings(),
            clientContext);
    this.createMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            createMapContextConfigTransportSettings,
            settings.createMapContextConfigSettings(),
            clientContext);
    this.getMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            getMapContextConfigTransportSettings,
            settings.getMapContextConfigSettings(),
            clientContext);
    this.listMapContextConfigsCallable =
        callableFactory.createUnaryCallable(
            listMapContextConfigsTransportSettings,
            settings.listMapContextConfigsSettings(),
            clientContext);
    this.listMapContextConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listMapContextConfigsTransportSettings,
            settings.listMapContextConfigsSettings(),
            clientContext);
    this.updateMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            updateMapContextConfigTransportSettings,
            settings.updateMapContextConfigSettings(),
            clientContext);
    this.deleteMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMapContextConfigTransportSettings,
            settings.deleteMapContextConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createMapConfigMethodDescriptor);
    methodDescriptors.add(getMapConfigMethodDescriptor);
    methodDescriptors.add(listMapConfigsMethodDescriptor);
    methodDescriptors.add(updateMapConfigMethodDescriptor);
    methodDescriptors.add(deleteMapConfigMethodDescriptor);
    methodDescriptors.add(createStyleConfigMethodDescriptor);
    methodDescriptors.add(getStyleConfigMethodDescriptor);
    methodDescriptors.add(listStyleConfigsMethodDescriptor);
    methodDescriptors.add(updateStyleConfigMethodDescriptor);
    methodDescriptors.add(deleteStyleConfigMethodDescriptor);
    methodDescriptors.add(createMapContextConfigMethodDescriptor);
    methodDescriptors.add(getMapContextConfigMethodDescriptor);
    methodDescriptors.add(listMapContextConfigsMethodDescriptor);
    methodDescriptors.add(updateMapContextConfigMethodDescriptor);
    methodDescriptors.add(deleteMapContextConfigMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateMapConfigRequest, MapConfig> createMapConfigCallable() {
    return createMapConfigCallable;
  }

  @Override
  public UnaryCallable<GetMapConfigRequest, MapConfig> getMapConfigCallable() {
    return getMapConfigCallable;
  }

  @Override
  public UnaryCallable<ListMapConfigsRequest, ListMapConfigsResponse> listMapConfigsCallable() {
    return listMapConfigsCallable;
  }

  @Override
  public UnaryCallable<ListMapConfigsRequest, ListMapConfigsPagedResponse>
      listMapConfigsPagedCallable() {
    return listMapConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateMapConfigRequest, MapConfig> updateMapConfigCallable() {
    return updateMapConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteMapConfigRequest, Empty> deleteMapConfigCallable() {
    return deleteMapConfigCallable;
  }

  @Override
  public UnaryCallable<CreateStyleConfigRequest, StyleConfig> createStyleConfigCallable() {
    return createStyleConfigCallable;
  }

  @Override
  public UnaryCallable<GetStyleConfigRequest, StyleConfig> getStyleConfigCallable() {
    return getStyleConfigCallable;
  }

  @Override
  public UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsCallable() {
    return listStyleConfigsCallable;
  }

  @Override
  public UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsPagedResponse>
      listStyleConfigsPagedCallable() {
    return listStyleConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigCallable() {
    return updateStyleConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteStyleConfigRequest, Empty> deleteStyleConfigCallable() {
    return deleteStyleConfigCallable;
  }

  @Override
  public UnaryCallable<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigCallable() {
    return createMapContextConfigCallable;
  }

  @Override
  public UnaryCallable<GetMapContextConfigRequest, MapContextConfig> getMapContextConfigCallable() {
    return getMapContextConfigCallable;
  }

  @Override
  public UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsCallable() {
    return listMapContextConfigsCallable;
  }

  @Override
  public UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsPagedResponse>
      listMapContextConfigsPagedCallable() {
    return listMapContextConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigCallable() {
    return updateMapContextConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigCallable() {
    return deleteMapContextConfigCallable;
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
