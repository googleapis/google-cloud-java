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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.WorkerPoolsClient.ListWorkerPoolsPagedResponse;

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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.run.v2.CreateWorkerPoolRequest;
import com.google.cloud.run.v2.DeleteWorkerPoolRequest;
import com.google.cloud.run.v2.GetWorkerPoolRequest;
import com.google.cloud.run.v2.ListWorkerPoolsRequest;
import com.google.cloud.run.v2.ListWorkerPoolsResponse;
import com.google.cloud.run.v2.UpdateWorkerPoolRequest;
import com.google.cloud.run.v2.WorkerPool;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the WorkerPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonWorkerPoolsStub extends WorkerPoolsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(WorkerPool.getDescriptor()).build();

  private static final ApiMethodDescriptor<CreateWorkerPoolRequest, Operation>
      createWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkerPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/CreateWorkerPool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/workerPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(
                                fields, "workerPoolId", request.getWorkerPoolId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workerPool", request.getWorkerPool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateWorkerPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetWorkerPoolRequest, WorkerPool>
      getWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<GetWorkerPoolRequest, WorkerPool>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/GetWorkerPool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/workerPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkerPool>newBuilder()
                      .setDefaultInstance(WorkerPool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsMethodDescriptor =
          ApiMethodDescriptor.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/ListWorkerPools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkerPoolsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/workerPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkerPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkerPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkerPoolsResponse>newBuilder()
                      .setDefaultInstance(ListWorkerPoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateWorkerPoolRequest, Operation>
      updateWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkerPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/UpdateWorkerPool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v2/{workerPool.name=projects/*/locations/*/workerPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "workerPool.name", request.getWorkerPool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(
                                fields, "forceNewRevision", request.getForceNewRevision());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workerPool", request.getWorkerPool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateWorkerPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteWorkerPoolRequest, Operation>
      deleteWorkerPoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkerPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/DeleteWorkerPool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkerPoolRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/workerPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkerPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteWorkerPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=projects/*/locations/*/workerPools/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "options", request.getOptions());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=projects/*/locations/*/workerPools/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.run.v2.WorkerPools/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=projects/*/locations/*/workerPools/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable;
  private final OperationCallable<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationCallable;
  private final UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable;
  private final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsCallable;
  private final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable;
  private final UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable;
  private final OperationCallable<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationCallable;
  private final UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable;
  private final OperationCallable<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}");
  private static final PathTemplate GET_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");
  private static final PathTemplate LIST_WORKER_POOLS_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}");
  private static final PathTemplate UPDATE_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");
  private static final PathTemplate DELETE_WORKER_POOL_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");

  public static final HttpJsonWorkerPoolsStub create(WorkerPoolsStubSettings settings)
      throws IOException {
    return new HttpJsonWorkerPoolsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWorkerPoolsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWorkerPoolsStub(
        WorkerPoolsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWorkerPoolsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWorkerPoolsStub(
        WorkerPoolsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWorkerPoolsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWorkerPoolsStub(WorkerPoolsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonWorkerPoolsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWorkerPoolsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWorkerPoolsStub(
      WorkerPoolsStubSettings settings,
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
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v2/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v2/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v2/{name=projects/*/locations/*}/operations")
                        .build())
                .put(
                    "google.longrunning.Operations.WaitOperation",
                    HttpRule.newBuilder()
                        .setPost("/v2/{name=projects/*/locations/*/operations/*}:wait")
                        .build())
                .build());

    HttpJsonCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolTransportSettings =
        HttpJsonCallSettings.<CreateWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "location", CREATE_WORKER_POOL_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolTransportSettings =
        HttpJsonCallSettings.<GetWorkerPoolRequest, WorkerPool>newBuilder()
            .setMethodDescriptor(getWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", GET_WORKER_POOL_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
        listWorkerPoolsTransportSettings =
            HttpJsonCallSettings.<ListWorkerPoolsRequest, ListWorkerPoolsResponse>newBuilder()
                .setMethodDescriptor(listWorkerPoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "location", LIST_WORKER_POOLS_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolTransportSettings =
        HttpJsonCallSettings.<UpdateWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getWorkerPool() != null) {
                    builder.add(
                        request.getWorkerPool().getName(),
                        "location",
                        UPDATE_WORKER_POOL_0_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolTransportSettings =
        HttpJsonCallSettings.<DeleteWorkerPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkerPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", DELETE_WORKER_POOL_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            createWorkerPoolTransportSettings, settings.createWorkerPoolSettings(), clientContext);
    this.createWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            createWorkerPoolTransportSettings,
            settings.createWorkerPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            getWorkerPoolTransportSettings, settings.getWorkerPoolSettings(), clientContext);
    this.listWorkerPoolsCallable =
        callableFactory.createUnaryCallable(
            listWorkerPoolsTransportSettings, settings.listWorkerPoolsSettings(), clientContext);
    this.listWorkerPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkerPoolsTransportSettings, settings.listWorkerPoolsSettings(), clientContext);
    this.updateWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            updateWorkerPoolTransportSettings, settings.updateWorkerPoolSettings(), clientContext);
    this.updateWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkerPoolTransportSettings,
            settings.updateWorkerPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteWorkerPoolCallable =
        callableFactory.createUnaryCallable(
            deleteWorkerPoolTransportSettings, settings.deleteWorkerPoolSettings(), clientContext);
    this.deleteWorkerPoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkerPoolTransportSettings,
            settings.deleteWorkerPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createWorkerPoolMethodDescriptor);
    methodDescriptors.add(getWorkerPoolMethodDescriptor);
    methodDescriptors.add(listWorkerPoolsMethodDescriptor);
    methodDescriptors.add(updateWorkerPoolMethodDescriptor);
    methodDescriptors.add(deleteWorkerPoolMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable() {
    return createWorkerPoolCallable;
  }

  @Override
  public OperationCallable<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationCallable() {
    return createWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    return getWorkerPoolCallable;
  }

  @Override
  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> listWorkerPoolsCallable() {
    return listWorkerPoolsCallable;
  }

  @Override
  public UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable() {
    return listWorkerPoolsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable() {
    return updateWorkerPoolCallable;
  }

  @Override
  public OperationCallable<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationCallable() {
    return updateWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable() {
    return deleteWorkerPoolCallable;
  }

  @Override
  public OperationCallable<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationCallable() {
    return deleteWorkerPoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
