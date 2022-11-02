/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.functions.v2beta.stub;

import static com.google.cloud.functions.v2beta.FunctionServiceClient.ListFunctionsPagedResponse;
import static com.google.cloud.functions.v2beta.FunctionServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.functions.v2beta.CreateFunctionRequest;
import com.google.cloud.functions.v2beta.DeleteFunctionRequest;
import com.google.cloud.functions.v2beta.Function;
import com.google.cloud.functions.v2beta.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v2beta.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v2beta.GenerateUploadUrlRequest;
import com.google.cloud.functions.v2beta.GenerateUploadUrlResponse;
import com.google.cloud.functions.v2beta.GetFunctionRequest;
import com.google.cloud.functions.v2beta.ListFunctionsRequest;
import com.google.cloud.functions.v2beta.ListFunctionsResponse;
import com.google.cloud.functions.v2beta.ListRuntimesRequest;
import com.google.cloud.functions.v2beta.ListRuntimesResponse;
import com.google.cloud.functions.v2beta.OperationMetadata;
import com.google.cloud.functions.v2beta.UpdateFunctionRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the FunctionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonFunctionServiceStub extends FunctionServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Function.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetFunctionRequest, Function>
      getFunctionMethodDescriptor =
          ApiMethodDescriptor.<GetFunctionRequest, Function>newBuilder()
              .setFullMethodName("google.cloud.functions.v2beta.FunctionService/GetFunction")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFunctionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/locations/*/functions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Function>newBuilder()
                      .setDefaultInstance(Function.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFunctionsRequest, ListFunctionsResponse>
      listFunctionsMethodDescriptor =
          ApiMethodDescriptor.<ListFunctionsRequest, ListFunctionsResponse>newBuilder()
              .setFullMethodName("google.cloud.functions.v2beta.FunctionService/ListFunctions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFunctionsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*}/functions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFunctionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFunctionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFunctionsResponse>newBuilder()
                      .setDefaultInstance(ListFunctionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFunctionRequest, Operation>
      createFunctionMethodDescriptor =
          ApiMethodDescriptor.<CreateFunctionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.functions.v2beta.FunctionService/CreateFunction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFunctionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*}/functions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "functionId", request.getFunctionId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("function", request.getFunction(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFunctionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateFunctionRequest, Operation>
      updateFunctionMethodDescriptor =
          ApiMethodDescriptor.<UpdateFunctionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.functions.v2beta.FunctionService/UpdateFunction")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFunctionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{function.name=projects/*/locations/*/functions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "function.name", request.getFunction().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("function", request.getFunction(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFunctionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFunctionRequest, Operation>
      deleteFunctionMethodDescriptor =
          ApiMethodDescriptor.<DeleteFunctionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.functions.v2beta.FunctionService/DeleteFunction")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFunctionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/locations/*/functions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFunctionRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteFunctionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlMethodDescriptor =
          ApiMethodDescriptor.<GenerateUploadUrlRequest, GenerateUploadUrlResponse>newBuilder()
              .setFullMethodName("google.cloud.functions.v2beta.FunctionService/GenerateUploadUrl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateUploadUrlRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*}/functions:generateUploadUrl",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateUploadUrlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateUploadUrlRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateUploadUrlResponse>newBuilder()
                      .setDefaultInstance(GenerateUploadUrlResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlMethodDescriptor =
          ApiMethodDescriptor.<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.functions.v2beta.FunctionService/GenerateDownloadUrl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateDownloadUrlRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=projects/*/locations/*/functions/*}:generateDownloadUrl",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateDownloadUrlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateDownloadUrlRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateDownloadUrlResponse>newBuilder()
                      .setDefaultInstance(GenerateDownloadUrlResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRuntimesRequest, ListRuntimesResponse>
      listRuntimesMethodDescriptor =
          ApiMethodDescriptor.<ListRuntimesRequest, ListRuntimesResponse>newBuilder()
              .setFullMethodName("google.cloud.functions.v2beta.FunctionService/ListRuntimes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRuntimesRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*}/runtimes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuntimesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuntimesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRuntimesResponse>newBuilder()
                      .setDefaultInstance(ListRuntimesResponse.getDefaultInstance())
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
                          "/v2beta/{name=projects/*}/locations",
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta/{resource=projects/*/locations/*/functions/*}:setIamPolicy",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta/{resource=projects/*/locations/*/functions/*}:getIamPolicy",
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{resource=projects/*/locations/*/functions/*}:testIamPermissions",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetFunctionRequest, Function> getFunctionCallable;
  private final UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable;
  private final UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable;
  private final UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable;
  private final OperationCallable<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationCallable;
  private final UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable;
  private final OperationCallable<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationCallable;
  private final UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable;
  private final OperationCallable<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationCallable;
  private final UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable;
  private final UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable;
  private final UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFunctionServiceStub create(FunctionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonFunctionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFunctionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonFunctionServiceStub(
        FunctionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFunctionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFunctionServiceStub(
        FunctionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFunctionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFunctionServiceStub(
      FunctionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonFunctionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFunctionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFunctionServiceStub(
      FunctionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetFunctionRequest, Function> getFunctionTransportSettings =
        HttpJsonCallSettings.<GetFunctionRequest, Function>newBuilder()
            .setMethodDescriptor(getFunctionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFunctionsRequest, ListFunctionsResponse>
        listFunctionsTransportSettings =
            HttpJsonCallSettings.<ListFunctionsRequest, ListFunctionsResponse>newBuilder()
                .setMethodDescriptor(listFunctionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateFunctionRequest, Operation> createFunctionTransportSettings =
        HttpJsonCallSettings.<CreateFunctionRequest, Operation>newBuilder()
            .setMethodDescriptor(createFunctionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateFunctionRequest, Operation> updateFunctionTransportSettings =
        HttpJsonCallSettings.<UpdateFunctionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFunctionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteFunctionRequest, Operation> deleteFunctionTransportSettings =
        HttpJsonCallSettings.<DeleteFunctionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFunctionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
        generateUploadUrlTransportSettings =
            HttpJsonCallSettings.<GenerateUploadUrlRequest, GenerateUploadUrlResponse>newBuilder()
                .setMethodDescriptor(generateUploadUrlMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
        generateDownloadUrlTransportSettings =
            HttpJsonCallSettings
                .<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>newBuilder()
                .setMethodDescriptor(generateDownloadUrlMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListRuntimesRequest, ListRuntimesResponse> listRuntimesTransportSettings =
        HttpJsonCallSettings.<ListRuntimesRequest, ListRuntimesResponse>newBuilder()
            .setMethodDescriptor(listRuntimesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getFunctionCallable =
        callableFactory.createUnaryCallable(
            getFunctionTransportSettings, settings.getFunctionSettings(), clientContext);
    this.listFunctionsCallable =
        callableFactory.createUnaryCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.listFunctionsPagedCallable =
        callableFactory.createPagedCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.createFunctionCallable =
        callableFactory.createUnaryCallable(
            createFunctionTransportSettings, settings.createFunctionSettings(), clientContext);
    this.createFunctionOperationCallable =
        callableFactory.createOperationCallable(
            createFunctionTransportSettings,
            settings.createFunctionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateFunctionCallable =
        callableFactory.createUnaryCallable(
            updateFunctionTransportSettings, settings.updateFunctionSettings(), clientContext);
    this.updateFunctionOperationCallable =
        callableFactory.createOperationCallable(
            updateFunctionTransportSettings,
            settings.updateFunctionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFunctionCallable =
        callableFactory.createUnaryCallable(
            deleteFunctionTransportSettings, settings.deleteFunctionSettings(), clientContext);
    this.deleteFunctionOperationCallable =
        callableFactory.createOperationCallable(
            deleteFunctionTransportSettings,
            settings.deleteFunctionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateUploadUrlCallable =
        callableFactory.createUnaryCallable(
            generateUploadUrlTransportSettings,
            settings.generateUploadUrlSettings(),
            clientContext);
    this.generateDownloadUrlCallable =
        callableFactory.createUnaryCallable(
            generateDownloadUrlTransportSettings,
            settings.generateDownloadUrlSettings(),
            clientContext);
    this.listRuntimesCallable =
        callableFactory.createUnaryCallable(
            listRuntimesTransportSettings, settings.listRuntimesSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    methodDescriptors.add(getFunctionMethodDescriptor);
    methodDescriptors.add(listFunctionsMethodDescriptor);
    methodDescriptors.add(createFunctionMethodDescriptor);
    methodDescriptors.add(updateFunctionMethodDescriptor);
    methodDescriptors.add(deleteFunctionMethodDescriptor);
    methodDescriptors.add(generateUploadUrlMethodDescriptor);
    methodDescriptors.add(generateDownloadUrlMethodDescriptor);
    methodDescriptors.add(listRuntimesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetFunctionRequest, Function> getFunctionCallable() {
    return getFunctionCallable;
  }

  @Override
  public UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable() {
    return listFunctionsCallable;
  }

  @Override
  public UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable() {
    return listFunctionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    return createFunctionCallable;
  }

  @Override
  public OperationCallable<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationCallable() {
    return createFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    return updateFunctionCallable;
  }

  @Override
  public OperationCallable<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationCallable() {
    return updateFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    return deleteFunctionCallable;
  }

  @Override
  public OperationCallable<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationCallable() {
    return deleteFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable() {
    return generateUploadUrlCallable;
  }

  @Override
  public UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable() {
    return generateDownloadUrlCallable;
  }

  @Override
  public UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    return listRuntimesCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
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
