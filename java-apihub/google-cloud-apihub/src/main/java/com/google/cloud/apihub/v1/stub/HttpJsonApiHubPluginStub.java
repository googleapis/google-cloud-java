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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginInstancesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginsPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreatePluginInstanceRequest;
import com.google.cloud.apihub.v1.CreatePluginRequest;
import com.google.cloud.apihub.v1.DeletePluginInstanceRequest;
import com.google.cloud.apihub.v1.DeletePluginRequest;
import com.google.cloud.apihub.v1.DisablePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.DisablePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.DisablePluginRequest;
import com.google.cloud.apihub.v1.EnablePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.EnablePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.EnablePluginRequest;
import com.google.cloud.apihub.v1.ExecutePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.ExecutePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.GetPluginInstanceRequest;
import com.google.cloud.apihub.v1.GetPluginRequest;
import com.google.cloud.apihub.v1.ListPluginInstancesRequest;
import com.google.cloud.apihub.v1.ListPluginInstancesResponse;
import com.google.cloud.apihub.v1.ListPluginsRequest;
import com.google.cloud.apihub.v1.ListPluginsResponse;
import com.google.cloud.apihub.v1.OperationMetadata;
import com.google.cloud.apihub.v1.Plugin;
import com.google.cloud.apihub.v1.PluginInstance;
import com.google.cloud.apihub.v1.UpdatePluginInstanceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the ApiHubPlugin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonApiHubPluginStub extends ApiHubPluginStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ExecutePluginInstanceActionResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(DisablePluginInstanceActionResponse.getDescriptor())
          .add(PluginInstance.getDescriptor())
          .add(EnablePluginInstanceActionResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetPluginRequest, Plugin> getPluginMethodDescriptor =
      ApiMethodDescriptor.<GetPluginRequest, Plugin>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/GetPlugin")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPluginRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/plugins/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPluginRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPluginRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Plugin>newBuilder()
                  .setDefaultInstance(Plugin.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<EnablePluginRequest, Plugin>
      enablePluginMethodDescriptor =
          ApiMethodDescriptor.<EnablePluginRequest, Plugin>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/EnablePlugin")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnablePluginRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnablePluginRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnablePluginRequest> serializer =
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
                  ProtoMessageResponseParser.<Plugin>newBuilder()
                      .setDefaultInstance(Plugin.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DisablePluginRequest, Plugin>
      disablePluginMethodDescriptor =
          ApiMethodDescriptor.<DisablePluginRequest, Plugin>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/DisablePlugin")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisablePluginRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisablePluginRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisablePluginRequest> serializer =
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
                  ProtoMessageResponseParser.<Plugin>newBuilder()
                      .setDefaultInstance(Plugin.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePluginRequest, Plugin>
      createPluginMethodDescriptor =
          ApiMethodDescriptor.<CreatePluginRequest, Plugin>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/CreatePlugin")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePluginRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/plugins",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePluginRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePluginRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pluginId", request.getPluginId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("plugin", request.getPlugin(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Plugin>newBuilder()
                      .setDefaultInstance(Plugin.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPluginsRequest, ListPluginsResponse>
      listPluginsMethodDescriptor =
          ApiMethodDescriptor.<ListPluginsRequest, ListPluginsResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/ListPlugins")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPluginsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/plugins",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPluginsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPluginsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPluginsResponse>newBuilder()
                      .setDefaultInstance(ListPluginsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePluginRequest, Operation>
      deletePluginMethodDescriptor =
          ApiMethodDescriptor.<DeletePluginRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/DeletePlugin")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePluginRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePluginRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePluginRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeletePluginRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreatePluginInstanceRequest, Operation>
      createPluginInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreatePluginInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/CreatePluginInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePluginInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/plugins/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "pluginInstanceId", request.getPluginInstanceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("pluginInstance", request.getPluginInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePluginInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionMethodDescriptor =
          ApiMethodDescriptor.<ExecutePluginInstanceActionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/ExecutePluginInstanceAction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExecutePluginInstanceActionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*/instances/*}:executeAction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecutePluginInstanceActionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecutePluginInstanceActionRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExecutePluginInstanceActionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPluginInstanceRequest, PluginInstance>
      getPluginInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetPluginInstanceRequest, PluginInstance>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/GetPluginInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPluginInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PluginInstance>newBuilder()
                      .setDefaultInstance(PluginInstance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPluginInstancesRequest, ListPluginInstancesResponse>
      listPluginInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListPluginInstancesRequest, ListPluginInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/ListPluginInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPluginInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/plugins/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPluginInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPluginInstancesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPluginInstancesResponse>newBuilder()
                      .setDefaultInstance(ListPluginInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionMethodDescriptor =
          ApiMethodDescriptor.<EnablePluginInstanceActionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/EnablePluginInstanceAction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnablePluginInstanceActionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*/instances/*}:enableAction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnablePluginInstanceActionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnablePluginInstanceActionRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (EnablePluginInstanceActionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionMethodDescriptor =
          ApiMethodDescriptor.<DisablePluginInstanceActionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/DisablePluginInstanceAction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisablePluginInstanceActionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*/instances/*}:disableAction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisablePluginInstanceActionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisablePluginInstanceActionRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DisablePluginInstanceActionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePluginInstanceRequest, PluginInstance>
      updatePluginInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpdatePluginInstanceRequest, PluginInstance>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/UpdatePluginInstance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePluginInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{pluginInstance.name=projects/*/locations/*/plugins/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "pluginInstance.name",
                                request.getPluginInstance().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("pluginInstance", request.getPluginInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PluginInstance>newBuilder()
                      .setDefaultInstance(PluginInstance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePluginInstanceRequest, Operation>
      deletePluginInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeletePluginInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/DeletePluginInstance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePluginInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/plugins/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePluginInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeletePluginInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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

  private final UnaryCallable<GetPluginRequest, Plugin> getPluginCallable;
  private final UnaryCallable<EnablePluginRequest, Plugin> enablePluginCallable;
  private final UnaryCallable<DisablePluginRequest, Plugin> disablePluginCallable;
  private final UnaryCallable<CreatePluginRequest, Plugin> createPluginCallable;
  private final UnaryCallable<ListPluginsRequest, ListPluginsResponse> listPluginsCallable;
  private final UnaryCallable<ListPluginsRequest, ListPluginsPagedResponse>
      listPluginsPagedCallable;
  private final UnaryCallable<DeletePluginRequest, Operation> deletePluginCallable;
  private final OperationCallable<DeletePluginRequest, Empty, OperationMetadata>
      deletePluginOperationCallable;
  private final UnaryCallable<CreatePluginInstanceRequest, Operation> createPluginInstanceCallable;
  private final OperationCallable<CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
      createPluginInstanceOperationCallable;
  private final UnaryCallable<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionCallable;
  private final OperationCallable<
          ExecutePluginInstanceActionRequest,
          ExecutePluginInstanceActionResponse,
          OperationMetadata>
      executePluginInstanceActionOperationCallable;
  private final UnaryCallable<GetPluginInstanceRequest, PluginInstance> getPluginInstanceCallable;
  private final UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesResponse>
      listPluginInstancesCallable;
  private final UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesPagedResponse>
      listPluginInstancesPagedCallable;
  private final UnaryCallable<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionCallable;
  private final OperationCallable<
          EnablePluginInstanceActionRequest, EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionOperationCallable;
  private final UnaryCallable<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionCallable;
  private final OperationCallable<
          DisablePluginInstanceActionRequest,
          DisablePluginInstanceActionResponse,
          OperationMetadata>
      disablePluginInstanceActionOperationCallable;
  private final UnaryCallable<UpdatePluginInstanceRequest, PluginInstance>
      updatePluginInstanceCallable;
  private final UnaryCallable<DeletePluginInstanceRequest, Operation> deletePluginInstanceCallable;
  private final OperationCallable<DeletePluginInstanceRequest, Empty, OperationMetadata>
      deletePluginInstanceOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonApiHubPluginStub create(ApiHubPluginStubSettings settings)
      throws IOException {
    return new HttpJsonApiHubPluginStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonApiHubPluginStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonApiHubPluginStub(
        ApiHubPluginStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonApiHubPluginStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonApiHubPluginStub(
        ApiHubPluginStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonApiHubPluginStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApiHubPluginStub(ApiHubPluginStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonApiHubPluginCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonApiHubPluginStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApiHubPluginStub(
      ApiHubPluginStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<GetPluginRequest, Plugin> getPluginTransportSettings =
        HttpJsonCallSettings.<GetPluginRequest, Plugin>newBuilder()
            .setMethodDescriptor(getPluginMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EnablePluginRequest, Plugin> enablePluginTransportSettings =
        HttpJsonCallSettings.<EnablePluginRequest, Plugin>newBuilder()
            .setMethodDescriptor(enablePluginMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DisablePluginRequest, Plugin> disablePluginTransportSettings =
        HttpJsonCallSettings.<DisablePluginRequest, Plugin>newBuilder()
            .setMethodDescriptor(disablePluginMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePluginRequest, Plugin> createPluginTransportSettings =
        HttpJsonCallSettings.<CreatePluginRequest, Plugin>newBuilder()
            .setMethodDescriptor(createPluginMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPluginsRequest, ListPluginsResponse> listPluginsTransportSettings =
        HttpJsonCallSettings.<ListPluginsRequest, ListPluginsResponse>newBuilder()
            .setMethodDescriptor(listPluginsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePluginRequest, Operation> deletePluginTransportSettings =
        HttpJsonCallSettings.<DeletePluginRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePluginMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePluginInstanceRequest, Operation>
        createPluginInstanceTransportSettings =
            HttpJsonCallSettings.<CreatePluginInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(createPluginInstanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExecutePluginInstanceActionRequest, Operation>
        executePluginInstanceActionTransportSettings =
            HttpJsonCallSettings.<ExecutePluginInstanceActionRequest, Operation>newBuilder()
                .setMethodDescriptor(executePluginInstanceActionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPluginInstanceRequest, PluginInstance>
        getPluginInstanceTransportSettings =
            HttpJsonCallSettings.<GetPluginInstanceRequest, PluginInstance>newBuilder()
                .setMethodDescriptor(getPluginInstanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPluginInstancesRequest, ListPluginInstancesResponse>
        listPluginInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListPluginInstancesRequest, ListPluginInstancesResponse>newBuilder()
                .setMethodDescriptor(listPluginInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<EnablePluginInstanceActionRequest, Operation>
        enablePluginInstanceActionTransportSettings =
            HttpJsonCallSettings.<EnablePluginInstanceActionRequest, Operation>newBuilder()
                .setMethodDescriptor(enablePluginInstanceActionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DisablePluginInstanceActionRequest, Operation>
        disablePluginInstanceActionTransportSettings =
            HttpJsonCallSettings.<DisablePluginInstanceActionRequest, Operation>newBuilder()
                .setMethodDescriptor(disablePluginInstanceActionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePluginInstanceRequest, PluginInstance>
        updatePluginInstanceTransportSettings =
            HttpJsonCallSettings.<UpdatePluginInstanceRequest, PluginInstance>newBuilder()
                .setMethodDescriptor(updatePluginInstanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "plugin_instance.name",
                          String.valueOf(request.getPluginInstance().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePluginInstanceRequest, Operation>
        deletePluginInstanceTransportSettings =
            HttpJsonCallSettings.<DeletePluginInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePluginInstanceMethodDescriptor)
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

    this.getPluginCallable =
        callableFactory.createUnaryCallable(
            getPluginTransportSettings, settings.getPluginSettings(), clientContext);
    this.enablePluginCallable =
        callableFactory.createUnaryCallable(
            enablePluginTransportSettings, settings.enablePluginSettings(), clientContext);
    this.disablePluginCallable =
        callableFactory.createUnaryCallable(
            disablePluginTransportSettings, settings.disablePluginSettings(), clientContext);
    this.createPluginCallable =
        callableFactory.createUnaryCallable(
            createPluginTransportSettings, settings.createPluginSettings(), clientContext);
    this.listPluginsCallable =
        callableFactory.createUnaryCallable(
            listPluginsTransportSettings, settings.listPluginsSettings(), clientContext);
    this.listPluginsPagedCallable =
        callableFactory.createPagedCallable(
            listPluginsTransportSettings, settings.listPluginsSettings(), clientContext);
    this.deletePluginCallable =
        callableFactory.createUnaryCallable(
            deletePluginTransportSettings, settings.deletePluginSettings(), clientContext);
    this.deletePluginOperationCallable =
        callableFactory.createOperationCallable(
            deletePluginTransportSettings,
            settings.deletePluginOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createPluginInstanceCallable =
        callableFactory.createUnaryCallable(
            createPluginInstanceTransportSettings,
            settings.createPluginInstanceSettings(),
            clientContext);
    this.createPluginInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createPluginInstanceTransportSettings,
            settings.createPluginInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.executePluginInstanceActionCallable =
        callableFactory.createUnaryCallable(
            executePluginInstanceActionTransportSettings,
            settings.executePluginInstanceActionSettings(),
            clientContext);
    this.executePluginInstanceActionOperationCallable =
        callableFactory.createOperationCallable(
            executePluginInstanceActionTransportSettings,
            settings.executePluginInstanceActionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPluginInstanceCallable =
        callableFactory.createUnaryCallable(
            getPluginInstanceTransportSettings,
            settings.getPluginInstanceSettings(),
            clientContext);
    this.listPluginInstancesCallable =
        callableFactory.createUnaryCallable(
            listPluginInstancesTransportSettings,
            settings.listPluginInstancesSettings(),
            clientContext);
    this.listPluginInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listPluginInstancesTransportSettings,
            settings.listPluginInstancesSettings(),
            clientContext);
    this.enablePluginInstanceActionCallable =
        callableFactory.createUnaryCallable(
            enablePluginInstanceActionTransportSettings,
            settings.enablePluginInstanceActionSettings(),
            clientContext);
    this.enablePluginInstanceActionOperationCallable =
        callableFactory.createOperationCallable(
            enablePluginInstanceActionTransportSettings,
            settings.enablePluginInstanceActionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.disablePluginInstanceActionCallable =
        callableFactory.createUnaryCallable(
            disablePluginInstanceActionTransportSettings,
            settings.disablePluginInstanceActionSettings(),
            clientContext);
    this.disablePluginInstanceActionOperationCallable =
        callableFactory.createOperationCallable(
            disablePluginInstanceActionTransportSettings,
            settings.disablePluginInstanceActionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePluginInstanceCallable =
        callableFactory.createUnaryCallable(
            updatePluginInstanceTransportSettings,
            settings.updatePluginInstanceSettings(),
            clientContext);
    this.deletePluginInstanceCallable =
        callableFactory.createUnaryCallable(
            deletePluginInstanceTransportSettings,
            settings.deletePluginInstanceSettings(),
            clientContext);
    this.deletePluginInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deletePluginInstanceTransportSettings,
            settings.deletePluginInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(getPluginMethodDescriptor);
    methodDescriptors.add(enablePluginMethodDescriptor);
    methodDescriptors.add(disablePluginMethodDescriptor);
    methodDescriptors.add(createPluginMethodDescriptor);
    methodDescriptors.add(listPluginsMethodDescriptor);
    methodDescriptors.add(deletePluginMethodDescriptor);
    methodDescriptors.add(createPluginInstanceMethodDescriptor);
    methodDescriptors.add(executePluginInstanceActionMethodDescriptor);
    methodDescriptors.add(getPluginInstanceMethodDescriptor);
    methodDescriptors.add(listPluginInstancesMethodDescriptor);
    methodDescriptors.add(enablePluginInstanceActionMethodDescriptor);
    methodDescriptors.add(disablePluginInstanceActionMethodDescriptor);
    methodDescriptors.add(updatePluginInstanceMethodDescriptor);
    methodDescriptors.add(deletePluginInstanceMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetPluginRequest, Plugin> getPluginCallable() {
    return getPluginCallable;
  }

  @Override
  public UnaryCallable<EnablePluginRequest, Plugin> enablePluginCallable() {
    return enablePluginCallable;
  }

  @Override
  public UnaryCallable<DisablePluginRequest, Plugin> disablePluginCallable() {
    return disablePluginCallable;
  }

  @Override
  public UnaryCallable<CreatePluginRequest, Plugin> createPluginCallable() {
    return createPluginCallable;
  }

  @Override
  public UnaryCallable<ListPluginsRequest, ListPluginsResponse> listPluginsCallable() {
    return listPluginsCallable;
  }

  @Override
  public UnaryCallable<ListPluginsRequest, ListPluginsPagedResponse> listPluginsPagedCallable() {
    return listPluginsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePluginRequest, Operation> deletePluginCallable() {
    return deletePluginCallable;
  }

  @Override
  public OperationCallable<DeletePluginRequest, Empty, OperationMetadata>
      deletePluginOperationCallable() {
    return deletePluginOperationCallable;
  }

  @Override
  public UnaryCallable<CreatePluginInstanceRequest, Operation> createPluginInstanceCallable() {
    return createPluginInstanceCallable;
  }

  @Override
  public OperationCallable<CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
      createPluginInstanceOperationCallable() {
    return createPluginInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionCallable() {
    return executePluginInstanceActionCallable;
  }

  @Override
  public OperationCallable<
          ExecutePluginInstanceActionRequest,
          ExecutePluginInstanceActionResponse,
          OperationMetadata>
      executePluginInstanceActionOperationCallable() {
    return executePluginInstanceActionOperationCallable;
  }

  @Override
  public UnaryCallable<GetPluginInstanceRequest, PluginInstance> getPluginInstanceCallable() {
    return getPluginInstanceCallable;
  }

  @Override
  public UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesResponse>
      listPluginInstancesCallable() {
    return listPluginInstancesCallable;
  }

  @Override
  public UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesPagedResponse>
      listPluginInstancesPagedCallable() {
    return listPluginInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionCallable() {
    return enablePluginInstanceActionCallable;
  }

  @Override
  public OperationCallable<
          EnablePluginInstanceActionRequest, EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionOperationCallable() {
    return enablePluginInstanceActionOperationCallable;
  }

  @Override
  public UnaryCallable<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionCallable() {
    return disablePluginInstanceActionCallable;
  }

  @Override
  public OperationCallable<
          DisablePluginInstanceActionRequest,
          DisablePluginInstanceActionResponse,
          OperationMetadata>
      disablePluginInstanceActionOperationCallable() {
    return disablePluginInstanceActionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePluginInstanceRequest, PluginInstance> updatePluginInstanceCallable() {
    return updatePluginInstanceCallable;
  }

  @Override
  public UnaryCallable<DeletePluginInstanceRequest, Operation> deletePluginInstanceCallable() {
    return deletePluginInstanceCallable;
  }

  @Override
  public OperationCallable<DeletePluginInstanceRequest, Empty, OperationMetadata>
      deletePluginInstanceOperationCallable() {
    return deletePluginInstanceOperationCallable;
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
