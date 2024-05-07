/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.AppPlatformClient.ListApplicationsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListDraftsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListInstancesPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListProcessorsPagedResponse;

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
import com.google.cloud.visionai.v1.AddApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.AddApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.Application;
import com.google.cloud.visionai.v1.CreateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.CreateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.CreateApplicationRequest;
import com.google.cloud.visionai.v1.CreateDraftRequest;
import com.google.cloud.visionai.v1.CreateProcessorRequest;
import com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest;
import com.google.cloud.visionai.v1.DeleteApplicationRequest;
import com.google.cloud.visionai.v1.DeleteDraftRequest;
import com.google.cloud.visionai.v1.DeleteProcessorRequest;
import com.google.cloud.visionai.v1.DeployApplicationRequest;
import com.google.cloud.visionai.v1.DeployApplicationResponse;
import com.google.cloud.visionai.v1.Draft;
import com.google.cloud.visionai.v1.GetApplicationRequest;
import com.google.cloud.visionai.v1.GetDraftRequest;
import com.google.cloud.visionai.v1.GetInstanceRequest;
import com.google.cloud.visionai.v1.GetProcessorRequest;
import com.google.cloud.visionai.v1.Instance;
import com.google.cloud.visionai.v1.ListApplicationsRequest;
import com.google.cloud.visionai.v1.ListApplicationsResponse;
import com.google.cloud.visionai.v1.ListDraftsRequest;
import com.google.cloud.visionai.v1.ListDraftsResponse;
import com.google.cloud.visionai.v1.ListInstancesRequest;
import com.google.cloud.visionai.v1.ListInstancesResponse;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse;
import com.google.cloud.visionai.v1.ListProcessorsRequest;
import com.google.cloud.visionai.v1.ListProcessorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Processor;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UndeployApplicationRequest;
import com.google.cloud.visionai.v1.UndeployApplicationResponse;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.UpdateApplicationRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UpdateDraftRequest;
import com.google.cloud.visionai.v1.UpdateProcessorRequest;
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
 * REST stub implementation for the AppPlatform service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAppPlatformStub extends AppPlatformStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Draft.getDescriptor())
          .add(Instance.getDescriptor())
          .add(UndeployApplicationResponse.getDescriptor())
          .add(AddApplicationStreamInputResponse.getDescriptor())
          .add(UpdateApplicationStreamInputResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(RemoveApplicationStreamInputResponse.getDescriptor())
          .add(Empty.getDescriptor())
          .add(DeployApplicationResponse.getDescriptor())
          .add(CreateApplicationInstancesResponse.getDescriptor())
          .add(Processor.getDescriptor())
          .add(Application.getDescriptor())
          .add(UpdateApplicationInstancesResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsMethodDescriptor =
          ApiMethodDescriptor.<ListApplicationsRequest, ListApplicationsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListApplications")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/applications",
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

  private static final ApiMethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          ApiMethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetApplication")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}",
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

  private static final ApiMethodDescriptor<CreateApplicationRequest, Operation>
      createApplicationMethodDescriptor =
          ApiMethodDescriptor.<CreateApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/applications",
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
                            serializer.putQueryParam(
                                fields, "applicationId", request.getApplicationId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("application", request.getApplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateApplicationRequest, Operation>
      updateApplicationMethodDescriptor =
          ApiMethodDescriptor.<UpdateApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateApplication")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{application.name=projects/*/locations/*/applications/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteApplicationRequest, Operation>
      deleteApplicationMethodDescriptor =
          ApiMethodDescriptor.<DeleteApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteApplication")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeployApplicationRequest, Operation>
      deployApplicationMethodDescriptor =
          ApiMethodDescriptor.<DeployApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeployApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:deploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployApplicationRequest> serializer =
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
                  (DeployApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeployApplicationRequest, Operation>
      undeployApplicationMethodDescriptor =
          ApiMethodDescriptor.<UndeployApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UndeployApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeployApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:undeploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployApplicationRequest> serializer =
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
                  (UndeployApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputMethodDescriptor =
          ApiMethodDescriptor.<AddApplicationStreamInputRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/AddApplicationStreamInput")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddApplicationStreamInputRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:addStreamInput",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddApplicationStreamInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddApplicationStreamInputRequest> serializer =
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
                  (AddApplicationStreamInputRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputMethodDescriptor =
          ApiMethodDescriptor.<RemoveApplicationStreamInputRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.visionai.v1.AppPlatform/RemoveApplicationStreamInput")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveApplicationStreamInputRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:removeStreamInput",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveApplicationStreamInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveApplicationStreamInputRequest> serializer =
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
                  (RemoveApplicationStreamInputRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputMethodDescriptor =
          ApiMethodDescriptor.<UpdateApplicationStreamInputRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.visionai.v1.AppPlatform/UpdateApplicationStreamInput")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApplicationStreamInputRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:updateStreamInput",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationStreamInputRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationStreamInputRequest> serializer =
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
                  (UpdateApplicationStreamInputRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/applications/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInstancesResponse>newBuilder()
                      .setDefaultInstance(ListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance>
      getInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesMethodDescriptor =
          ApiMethodDescriptor.<CreateApplicationInstancesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateApplicationInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApplicationInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:createApplicationInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationInstancesRequest> serializer =
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
                  (CreateApplicationInstancesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesMethodDescriptor =
          ApiMethodDescriptor.<DeleteApplicationInstancesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteApplicationInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApplicationInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:deleteApplicationInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApplicationInstancesRequest> serializer =
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
                  (DeleteApplicationInstancesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesMethodDescriptor =
          ApiMethodDescriptor.<UpdateApplicationInstancesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateApplicationInstances")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApplicationInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*}:updateApplicationInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationInstancesRequest> serializer =
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
                  (UpdateApplicationInstancesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListDraftsRequest, ListDraftsResponse>
      listDraftsMethodDescriptor =
          ApiMethodDescriptor.<ListDraftsRequest, ListDraftsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListDrafts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDraftsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/applications/*}/drafts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDraftsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDraftsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDraftsResponse>newBuilder()
                      .setDefaultInstance(ListDraftsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDraftRequest, Draft> getDraftMethodDescriptor =
      ApiMethodDescriptor.<GetDraftRequest, Draft>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetDraft")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDraftRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/applications/*/drafts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDraftRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDraftRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Draft>newBuilder()
                  .setDefaultInstance(Draft.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateDraftRequest, Operation>
      createDraftMethodDescriptor =
          ApiMethodDescriptor.<CreateDraftRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateDraft")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDraftRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/applications/*}/drafts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDraftRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDraftRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "draftId", request.getDraftId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("draft", request.getDraft(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDraftRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDraftRequest, Operation>
      updateDraftMethodDescriptor =
          ApiMethodDescriptor.<UpdateDraftRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateDraft")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDraftRequest>newBuilder()
                      .setPath(
                          "/v1/{draft.name=projects/*/locations/*/applications/*/drafts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDraftRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "draft.name", request.getDraft().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDraftRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("draft", request.getDraft(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDraftRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDraftRequest, Operation>
      deleteDraftMethodDescriptor =
          ApiMethodDescriptor.<DeleteDraftRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteDraft")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDraftRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/applications/*/drafts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDraftRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDraftRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteDraftRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListProcessorsRequest, ListProcessorsResponse>
      listProcessorsMethodDescriptor =
          ApiMethodDescriptor.<ListProcessorsRequest, ListProcessorsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListProcessors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProcessorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/processors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProcessorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProcessorsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListProcessorsResponse>newBuilder()
                      .setDefaultInstance(ListProcessorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/ListPrebuiltProcessors")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrebuiltProcessorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/processors:prebuilt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrebuiltProcessorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrebuiltProcessorsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPrebuiltProcessorsResponse>newBuilder()
                      .setDefaultInstance(ListPrebuiltProcessorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProcessorRequest, Processor>
      getProcessorMethodDescriptor =
          ApiMethodDescriptor.<GetProcessorRequest, Processor>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/GetProcessor")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProcessorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/processors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Processor>newBuilder()
                      .setDefaultInstance(Processor.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateProcessorRequest, Operation>
      createProcessorMethodDescriptor =
          ApiMethodDescriptor.<CreateProcessorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/CreateProcessor")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProcessorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/processors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "processorId", request.getProcessorId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("processor", request.getProcessor(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateProcessorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateProcessorRequest, Operation>
      updateProcessorMethodDescriptor =
          ApiMethodDescriptor.<UpdateProcessorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/UpdateProcessor")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProcessorRequest>newBuilder()
                      .setPath(
                          "/v1/{processor.name=projects/*/locations/*/processors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "processor.name", request.getProcessor().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("processor", request.getProcessor(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateProcessorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteProcessorRequest, Operation>
      deleteProcessorMethodDescriptor =
          ApiMethodDescriptor.<DeleteProcessorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.AppPlatform/DeleteProcessor")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProcessorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/processors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProcessorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteProcessorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable;
  private final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable;
  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable;
  private final OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable;
  private final UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable;
  private final OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable;
  private final UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable;
  private final OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable;
  private final UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable;
  private final OperationCallable<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable;
  private final UnaryCallable<UndeployApplicationRequest, Operation> undeployApplicationCallable;
  private final OperationCallable<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationCallable;
  private final UnaryCallable<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputCallable;
  private final OperationCallable<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationCallable;
  private final UnaryCallable<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputCallable;
  private final OperationCallable<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationCallable;
  private final UnaryCallable<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputCallable;
  private final OperationCallable<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesCallable;
  private final OperationCallable<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationCallable;
  private final UnaryCallable<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesCallable;
  private final OperationCallable<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationCallable;
  private final UnaryCallable<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesCallable;
  private final OperationCallable<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationCallable;
  private final UnaryCallable<ListDraftsRequest, ListDraftsResponse> listDraftsCallable;
  private final UnaryCallable<ListDraftsRequest, ListDraftsPagedResponse> listDraftsPagedCallable;
  private final UnaryCallable<GetDraftRequest, Draft> getDraftCallable;
  private final UnaryCallable<CreateDraftRequest, Operation> createDraftCallable;
  private final OperationCallable<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationCallable;
  private final UnaryCallable<UpdateDraftRequest, Operation> updateDraftCallable;
  private final OperationCallable<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationCallable;
  private final UnaryCallable<DeleteDraftRequest, Operation> deleteDraftCallable;
  private final OperationCallable<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationCallable;
  private final UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable;
  private final UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable;
  private final UnaryCallable<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsCallable;
  private final UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable;
  private final UnaryCallable<CreateProcessorRequest, Operation> createProcessorCallable;
  private final OperationCallable<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationCallable;
  private final UnaryCallable<UpdateProcessorRequest, Operation> updateProcessorCallable;
  private final OperationCallable<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationCallable;
  private final UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable;
  private final OperationCallable<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAppPlatformStub create(AppPlatformStubSettings settings)
      throws IOException {
    return new HttpJsonAppPlatformStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAppPlatformStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAppPlatformStub(
        AppPlatformStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAppPlatformStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAppPlatformStub(
        AppPlatformStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAppPlatformStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAppPlatformStub(AppPlatformStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAppPlatformCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAppPlatformStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAppPlatformStub(
      AppPlatformStubSettings settings,
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
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/warehouseOperations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/assets/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/imageIndexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/indexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/corpora/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/indexEndpoints/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

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
                .build();
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
            .build();
    HttpJsonCallSettings<CreateApplicationRequest, Operation> createApplicationTransportSettings =
        HttpJsonCallSettings.<CreateApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateApplicationRequest, Operation> updateApplicationTransportSettings =
        HttpJsonCallSettings.<UpdateApplicationRequest, Operation>newBuilder()
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
    HttpJsonCallSettings<DeleteApplicationRequest, Operation> deleteApplicationTransportSettings =
        HttpJsonCallSettings.<DeleteApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeployApplicationRequest, Operation> deployApplicationTransportSettings =
        HttpJsonCallSettings.<DeployApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deployApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UndeployApplicationRequest, Operation>
        undeployApplicationTransportSettings =
            HttpJsonCallSettings.<UndeployApplicationRequest, Operation>newBuilder()
                .setMethodDescriptor(undeployApplicationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AddApplicationStreamInputRequest, Operation>
        addApplicationStreamInputTransportSettings =
            HttpJsonCallSettings.<AddApplicationStreamInputRequest, Operation>newBuilder()
                .setMethodDescriptor(addApplicationStreamInputMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveApplicationStreamInputRequest, Operation>
        removeApplicationStreamInputTransportSettings =
            HttpJsonCallSettings.<RemoveApplicationStreamInputRequest, Operation>newBuilder()
                .setMethodDescriptor(removeApplicationStreamInputMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateApplicationStreamInputRequest, Operation>
        updateApplicationStreamInputTransportSettings =
            HttpJsonCallSettings.<UpdateApplicationStreamInputRequest, Operation>newBuilder()
                .setMethodDescriptor(updateApplicationStreamInputMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListInstancesRequest, ListInstancesResponse>
        listInstancesTransportSettings =
            HttpJsonCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateApplicationInstancesRequest, Operation>
        createApplicationInstancesTransportSettings =
            HttpJsonCallSettings.<CreateApplicationInstancesRequest, Operation>newBuilder()
                .setMethodDescriptor(createApplicationInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteApplicationInstancesRequest, Operation>
        deleteApplicationInstancesTransportSettings =
            HttpJsonCallSettings.<DeleteApplicationInstancesRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteApplicationInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateApplicationInstancesRequest, Operation>
        updateApplicationInstancesTransportSettings =
            HttpJsonCallSettings.<UpdateApplicationInstancesRequest, Operation>newBuilder()
                .setMethodDescriptor(updateApplicationInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDraftsRequest, ListDraftsResponse> listDraftsTransportSettings =
        HttpJsonCallSettings.<ListDraftsRequest, ListDraftsResponse>newBuilder()
            .setMethodDescriptor(listDraftsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDraftRequest, Draft> getDraftTransportSettings =
        HttpJsonCallSettings.<GetDraftRequest, Draft>newBuilder()
            .setMethodDescriptor(getDraftMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDraftRequest, Operation> createDraftTransportSettings =
        HttpJsonCallSettings.<CreateDraftRequest, Operation>newBuilder()
            .setMethodDescriptor(createDraftMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDraftRequest, Operation> updateDraftTransportSettings =
        HttpJsonCallSettings.<UpdateDraftRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDraftMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("draft.name", String.valueOf(request.getDraft().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDraftRequest, Operation> deleteDraftTransportSettings =
        HttpJsonCallSettings.<DeleteDraftRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDraftMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProcessorsRequest, ListProcessorsResponse>
        listProcessorsTransportSettings =
            HttpJsonCallSettings.<ListProcessorsRequest, ListProcessorsResponse>newBuilder()
                .setMethodDescriptor(listProcessorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
        listPrebuiltProcessorsTransportSettings =
            HttpJsonCallSettings
                .<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>newBuilder()
                .setMethodDescriptor(listPrebuiltProcessorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetProcessorRequest, Processor> getProcessorTransportSettings =
        HttpJsonCallSettings.<GetProcessorRequest, Processor>newBuilder()
            .setMethodDescriptor(getProcessorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateProcessorRequest, Operation> createProcessorTransportSettings =
        HttpJsonCallSettings.<CreateProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(createProcessorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateProcessorRequest, Operation> updateProcessorTransportSettings =
        HttpJsonCallSettings.<UpdateProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateProcessorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("processor.name", String.valueOf(request.getProcessor().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteProcessorRequest, Operation> deleteProcessorTransportSettings =
        HttpJsonCallSettings.<DeleteProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProcessorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listApplicationsCallable =
        callableFactory.createUnaryCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.listApplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listApplicationsTransportSettings, settings.listApplicationsSettings(), clientContext);
    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
    this.createApplicationCallable =
        callableFactory.createUnaryCallable(
            createApplicationTransportSettings,
            settings.createApplicationSettings(),
            clientContext);
    this.createApplicationOperationCallable =
        callableFactory.createOperationCallable(
            createApplicationTransportSettings,
            settings.createApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateApplicationCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationSettings(),
            clientContext);
    this.updateApplicationOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteApplicationCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationTransportSettings,
            settings.deleteApplicationSettings(),
            clientContext);
    this.deleteApplicationOperationCallable =
        callableFactory.createOperationCallable(
            deleteApplicationTransportSettings,
            settings.deleteApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deployApplicationCallable =
        callableFactory.createUnaryCallable(
            deployApplicationTransportSettings,
            settings.deployApplicationSettings(),
            clientContext);
    this.deployApplicationOperationCallable =
        callableFactory.createOperationCallable(
            deployApplicationTransportSettings,
            settings.deployApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeployApplicationCallable =
        callableFactory.createUnaryCallable(
            undeployApplicationTransportSettings,
            settings.undeployApplicationSettings(),
            clientContext);
    this.undeployApplicationOperationCallable =
        callableFactory.createOperationCallable(
            undeployApplicationTransportSettings,
            settings.undeployApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addApplicationStreamInputCallable =
        callableFactory.createUnaryCallable(
            addApplicationStreamInputTransportSettings,
            settings.addApplicationStreamInputSettings(),
            clientContext);
    this.addApplicationStreamInputOperationCallable =
        callableFactory.createOperationCallable(
            addApplicationStreamInputTransportSettings,
            settings.addApplicationStreamInputOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeApplicationStreamInputCallable =
        callableFactory.createUnaryCallable(
            removeApplicationStreamInputTransportSettings,
            settings.removeApplicationStreamInputSettings(),
            clientContext);
    this.removeApplicationStreamInputOperationCallable =
        callableFactory.createOperationCallable(
            removeApplicationStreamInputTransportSettings,
            settings.removeApplicationStreamInputOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateApplicationStreamInputCallable =
        callableFactory.createUnaryCallable(
            updateApplicationStreamInputTransportSettings,
            settings.updateApplicationStreamInputSettings(),
            clientContext);
    this.updateApplicationStreamInputOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationStreamInputTransportSettings,
            settings.updateApplicationStreamInputOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createApplicationInstancesCallable =
        callableFactory.createUnaryCallable(
            createApplicationInstancesTransportSettings,
            settings.createApplicationInstancesSettings(),
            clientContext);
    this.createApplicationInstancesOperationCallable =
        callableFactory.createOperationCallable(
            createApplicationInstancesTransportSettings,
            settings.createApplicationInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteApplicationInstancesCallable =
        callableFactory.createUnaryCallable(
            deleteApplicationInstancesTransportSettings,
            settings.deleteApplicationInstancesSettings(),
            clientContext);
    this.deleteApplicationInstancesOperationCallable =
        callableFactory.createOperationCallable(
            deleteApplicationInstancesTransportSettings,
            settings.deleteApplicationInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateApplicationInstancesCallable =
        callableFactory.createUnaryCallable(
            updateApplicationInstancesTransportSettings,
            settings.updateApplicationInstancesSettings(),
            clientContext);
    this.updateApplicationInstancesOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationInstancesTransportSettings,
            settings.updateApplicationInstancesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDraftsCallable =
        callableFactory.createUnaryCallable(
            listDraftsTransportSettings, settings.listDraftsSettings(), clientContext);
    this.listDraftsPagedCallable =
        callableFactory.createPagedCallable(
            listDraftsTransportSettings, settings.listDraftsSettings(), clientContext);
    this.getDraftCallable =
        callableFactory.createUnaryCallable(
            getDraftTransportSettings, settings.getDraftSettings(), clientContext);
    this.createDraftCallable =
        callableFactory.createUnaryCallable(
            createDraftTransportSettings, settings.createDraftSettings(), clientContext);
    this.createDraftOperationCallable =
        callableFactory.createOperationCallable(
            createDraftTransportSettings,
            settings.createDraftOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDraftCallable =
        callableFactory.createUnaryCallable(
            updateDraftTransportSettings, settings.updateDraftSettings(), clientContext);
    this.updateDraftOperationCallable =
        callableFactory.createOperationCallable(
            updateDraftTransportSettings,
            settings.updateDraftOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDraftCallable =
        callableFactory.createUnaryCallable(
            deleteDraftTransportSettings, settings.deleteDraftSettings(), clientContext);
    this.deleteDraftOperationCallable =
        callableFactory.createOperationCallable(
            deleteDraftTransportSettings,
            settings.deleteDraftOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listProcessorsCallable =
        callableFactory.createUnaryCallable(
            listProcessorsTransportSettings, settings.listProcessorsSettings(), clientContext);
    this.listProcessorsPagedCallable =
        callableFactory.createPagedCallable(
            listProcessorsTransportSettings, settings.listProcessorsSettings(), clientContext);
    this.listPrebuiltProcessorsCallable =
        callableFactory.createUnaryCallable(
            listPrebuiltProcessorsTransportSettings,
            settings.listPrebuiltProcessorsSettings(),
            clientContext);
    this.getProcessorCallable =
        callableFactory.createUnaryCallable(
            getProcessorTransportSettings, settings.getProcessorSettings(), clientContext);
    this.createProcessorCallable =
        callableFactory.createUnaryCallable(
            createProcessorTransportSettings, settings.createProcessorSettings(), clientContext);
    this.createProcessorOperationCallable =
        callableFactory.createOperationCallable(
            createProcessorTransportSettings,
            settings.createProcessorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateProcessorCallable =
        callableFactory.createUnaryCallable(
            updateProcessorTransportSettings, settings.updateProcessorSettings(), clientContext);
    this.updateProcessorOperationCallable =
        callableFactory.createOperationCallable(
            updateProcessorTransportSettings,
            settings.updateProcessorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteProcessorCallable =
        callableFactory.createUnaryCallable(
            deleteProcessorTransportSettings, settings.deleteProcessorSettings(), clientContext);
    this.deleteProcessorOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessorTransportSettings,
            settings.deleteProcessorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listApplicationsMethodDescriptor);
    methodDescriptors.add(getApplicationMethodDescriptor);
    methodDescriptors.add(createApplicationMethodDescriptor);
    methodDescriptors.add(updateApplicationMethodDescriptor);
    methodDescriptors.add(deleteApplicationMethodDescriptor);
    methodDescriptors.add(deployApplicationMethodDescriptor);
    methodDescriptors.add(undeployApplicationMethodDescriptor);
    methodDescriptors.add(addApplicationStreamInputMethodDescriptor);
    methodDescriptors.add(removeApplicationStreamInputMethodDescriptor);
    methodDescriptors.add(updateApplicationStreamInputMethodDescriptor);
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(createApplicationInstancesMethodDescriptor);
    methodDescriptors.add(deleteApplicationInstancesMethodDescriptor);
    methodDescriptors.add(updateApplicationInstancesMethodDescriptor);
    methodDescriptors.add(listDraftsMethodDescriptor);
    methodDescriptors.add(getDraftMethodDescriptor);
    methodDescriptors.add(createDraftMethodDescriptor);
    methodDescriptors.add(updateDraftMethodDescriptor);
    methodDescriptors.add(deleteDraftMethodDescriptor);
    methodDescriptors.add(listProcessorsMethodDescriptor);
    methodDescriptors.add(listPrebuiltProcessorsMethodDescriptor);
    methodDescriptors.add(getProcessorMethodDescriptor);
    methodDescriptors.add(createProcessorMethodDescriptor);
    methodDescriptors.add(updateProcessorMethodDescriptor);
    methodDescriptors.add(deleteProcessorMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    return createApplicationCallable;
  }

  @Override
  public OperationCallable<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationCallable() {
    return createApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    return updateApplicationCallable;
  }

  @Override
  public OperationCallable<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationCallable() {
    return updateApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable() {
    return deleteApplicationCallable;
  }

  @Override
  public OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable() {
    return deleteApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable() {
    return deployApplicationCallable;
  }

  @Override
  public OperationCallable<DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable() {
    return deployApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployApplicationRequest, Operation> undeployApplicationCallable() {
    return undeployApplicationCallable;
  }

  @Override
  public OperationCallable<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationCallable() {
    return undeployApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputCallable() {
    return addApplicationStreamInputCallable;
  }

  @Override
  public OperationCallable<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationCallable() {
    return addApplicationStreamInputOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputCallable() {
    return removeApplicationStreamInputCallable;
  }

  @Override
  public OperationCallable<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationCallable() {
    return removeApplicationStreamInputOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputCallable() {
    return updateApplicationStreamInputCallable;
  }

  @Override
  public OperationCallable<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationCallable() {
    return updateApplicationStreamInputOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesCallable() {
    return createApplicationInstancesCallable;
  }

  @Override
  public OperationCallable<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationCallable() {
    return createApplicationInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesCallable() {
    return deleteApplicationInstancesCallable;
  }

  @Override
  public OperationCallable<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationCallable() {
    return deleteApplicationInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesCallable() {
    return updateApplicationInstancesCallable;
  }

  @Override
  public OperationCallable<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationCallable() {
    return updateApplicationInstancesOperationCallable;
  }

  @Override
  public UnaryCallable<ListDraftsRequest, ListDraftsResponse> listDraftsCallable() {
    return listDraftsCallable;
  }

  @Override
  public UnaryCallable<ListDraftsRequest, ListDraftsPagedResponse> listDraftsPagedCallable() {
    return listDraftsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDraftRequest, Draft> getDraftCallable() {
    return getDraftCallable;
  }

  @Override
  public UnaryCallable<CreateDraftRequest, Operation> createDraftCallable() {
    return createDraftCallable;
  }

  @Override
  public OperationCallable<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationCallable() {
    return createDraftOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDraftRequest, Operation> updateDraftCallable() {
    return updateDraftCallable;
  }

  @Override
  public OperationCallable<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationCallable() {
    return updateDraftOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDraftRequest, Operation> deleteDraftCallable() {
    return deleteDraftCallable;
  }

  @Override
  public OperationCallable<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationCallable() {
    return deleteDraftOperationCallable;
  }

  @Override
  public UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable() {
    return listProcessorsCallable;
  }

  @Override
  public UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    return listProcessorsPagedCallable;
  }

  @Override
  public UnaryCallable<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsCallable() {
    return listPrebuiltProcessorsCallable;
  }

  @Override
  public UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable() {
    return getProcessorCallable;
  }

  @Override
  public UnaryCallable<CreateProcessorRequest, Operation> createProcessorCallable() {
    return createProcessorCallable;
  }

  @Override
  public OperationCallable<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationCallable() {
    return createProcessorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateProcessorRequest, Operation> updateProcessorCallable() {
    return updateProcessorCallable;
  }

  @Override
  public OperationCallable<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationCallable() {
    return updateProcessorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable() {
    return deleteProcessorCallable;
  }

  @Override
  public OperationCallable<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationCallable() {
    return deleteProcessorOperationCallable;
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
