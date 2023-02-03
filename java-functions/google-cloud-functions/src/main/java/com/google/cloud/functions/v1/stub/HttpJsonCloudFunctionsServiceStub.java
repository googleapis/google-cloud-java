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

package com.google.cloud.functions.v1.stub;

import static com.google.cloud.functions.v1.CloudFunctionsServiceClient.ListFunctionsPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.functions.v1.CallFunctionRequest;
import com.google.cloud.functions.v1.CallFunctionResponse;
import com.google.cloud.functions.v1.CloudFunction;
import com.google.cloud.functions.v1.CreateFunctionRequest;
import com.google.cloud.functions.v1.DeleteFunctionRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v1.GenerateUploadUrlRequest;
import com.google.cloud.functions.v1.GenerateUploadUrlResponse;
import com.google.cloud.functions.v1.GetFunctionRequest;
import com.google.cloud.functions.v1.ListFunctionsRequest;
import com.google.cloud.functions.v1.ListFunctionsResponse;
import com.google.cloud.functions.v1.OperationMetadataV1;
import com.google.cloud.functions.v1.UpdateFunctionRequest;
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
 * REST stub implementation for the CloudFunctionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudFunctionsServiceStub extends CloudFunctionsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(CloudFunction.getDescriptor())
          .add(OperationMetadataV1.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListFunctionsRequest, ListFunctionsResponse>
      listFunctionsMethodDescriptor =
          ApiMethodDescriptor.<ListFunctionsRequest, ListFunctionsResponse>newBuilder()
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/ListFunctions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFunctionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/functions",
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
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<GetFunctionRequest, CloudFunction>
      getFunctionMethodDescriptor =
          ApiMethodDescriptor.<GetFunctionRequest, CloudFunction>newBuilder()
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/GetFunction")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFunctionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/functions/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudFunction>newBuilder()
                      .setDefaultInstance(CloudFunction.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFunctionRequest, Operation>
      createFunctionMethodDescriptor =
          ApiMethodDescriptor.<CreateFunctionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/CreateFunction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFunctionRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}/functions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("function", request.getFunction(), true))
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
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/UpdateFunction")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFunctionRequest>newBuilder()
                      .setPath(
                          "/v1/{function.name=projects/*/locations/*/functions/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("function", request.getFunction(), true))
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
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/DeleteFunction")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFunctionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/functions/*}",
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
                  (DeleteFunctionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CallFunctionRequest, CallFunctionResponse>
      callFunctionMethodDescriptor =
          ApiMethodDescriptor.<CallFunctionRequest, CallFunctionResponse>newBuilder()
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/CallFunction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CallFunctionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/functions/*}:call",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CallFunctionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CallFunctionRequest> serializer =
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
                  ProtoMessageResponseParser.<CallFunctionResponse>newBuilder()
                      .setDefaultInstance(CallFunctionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlMethodDescriptor =
          ApiMethodDescriptor.<GenerateUploadUrlRequest, GenerateUploadUrlResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.functions.v1.CloudFunctionsService/GenerateUploadUrl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateUploadUrlRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/functions:generateUploadUrl",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
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
                  "google.cloud.functions.v1.CloudFunctionsService/GenerateDownloadUrl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateDownloadUrlRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/functions/*}:generateDownloadUrl",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateDownloadUrlResponse>newBuilder()
                      .setDefaultInstance(GenerateDownloadUrlResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/functions/*}:setIamPolicy",
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

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.functions.v1.CloudFunctionsService/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/functions/*}:getIamPolicy",
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.functions.v1.CloudFunctionsService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/functions/*}:testIamPermissions",
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

  private final UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable;
  private final UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable;
  private final UnaryCallable<GetFunctionRequest, CloudFunction> getFunctionCallable;
  private final UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable;
  private final OperationCallable<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationCallable;
  private final UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable;
  private final OperationCallable<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationCallable;
  private final UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable;
  private final OperationCallable<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationCallable;
  private final UnaryCallable<CallFunctionRequest, CallFunctionResponse> callFunctionCallable;
  private final UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable;
  private final UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudFunctionsServiceStub create(
      CloudFunctionsServiceStubSettings settings) throws IOException {
    return new HttpJsonCloudFunctionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudFunctionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudFunctionsServiceStub(
        CloudFunctionsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudFunctionsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudFunctionsServiceStub(
        CloudFunctionsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudFunctionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudFunctionsServiceStub(
      CloudFunctionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCloudFunctionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudFunctionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudFunctionsServiceStub(
      CloudFunctionsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListFunctionsRequest, ListFunctionsResponse>
        listFunctionsTransportSettings =
            HttpJsonCallSettings.<ListFunctionsRequest, ListFunctionsResponse>newBuilder()
                .setMethodDescriptor(listFunctionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetFunctionRequest, CloudFunction> getFunctionTransportSettings =
        HttpJsonCallSettings.<GetFunctionRequest, CloudFunction>newBuilder()
            .setMethodDescriptor(getFunctionMethodDescriptor)
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
    HttpJsonCallSettings<CallFunctionRequest, CallFunctionResponse> callFunctionTransportSettings =
        HttpJsonCallSettings.<CallFunctionRequest, CallFunctionResponse>newBuilder()
            .setMethodDescriptor(callFunctionMethodDescriptor)
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

    this.listFunctionsCallable =
        callableFactory.createUnaryCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.listFunctionsPagedCallable =
        callableFactory.createPagedCallable(
            listFunctionsTransportSettings, settings.listFunctionsSettings(), clientContext);
    this.getFunctionCallable =
        callableFactory.createUnaryCallable(
            getFunctionTransportSettings, settings.getFunctionSettings(), clientContext);
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
    this.callFunctionCallable =
        callableFactory.createUnaryCallable(
            callFunctionTransportSettings, settings.callFunctionSettings(), clientContext);
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
    methodDescriptors.add(listFunctionsMethodDescriptor);
    methodDescriptors.add(getFunctionMethodDescriptor);
    methodDescriptors.add(createFunctionMethodDescriptor);
    methodDescriptors.add(updateFunctionMethodDescriptor);
    methodDescriptors.add(deleteFunctionMethodDescriptor);
    methodDescriptors.add(callFunctionMethodDescriptor);
    methodDescriptors.add(generateUploadUrlMethodDescriptor);
    methodDescriptors.add(generateDownloadUrlMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
  public UnaryCallable<GetFunctionRequest, CloudFunction> getFunctionCallable() {
    return getFunctionCallable;
  }

  @Override
  public UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    return createFunctionCallable;
  }

  @Override
  public OperationCallable<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationCallable() {
    return createFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    return updateFunctionCallable;
  }

  @Override
  public OperationCallable<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationCallable() {
    return updateFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    return deleteFunctionCallable;
  }

  @Override
  public OperationCallable<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationCallable() {
    return deleteFunctionOperationCallable;
  }

  @Override
  public UnaryCallable<CallFunctionRequest, CallFunctionResponse> callFunctionCallable() {
    return callFunctionCallable;
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
