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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.FoldersClient.ListFoldersPagedResponse;
import static com.google.cloud.resourcemanager.v3.FoldersClient.SearchFoldersPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateFolderMetadata;
import com.google.cloud.resourcemanager.v3.CreateFolderRequest;
import com.google.cloud.resourcemanager.v3.DeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.DeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.Folder;
import com.google.cloud.resourcemanager.v3.GetFolderRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersResponse;
import com.google.cloud.resourcemanager.v3.MoveFolderMetadata;
import com.google.cloud.resourcemanager.v3.MoveFolderRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersResponse;
import com.google.cloud.resourcemanager.v3.UndeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.UndeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.UpdateFolderMetadata;
import com.google.cloud.resourcemanager.v3.UpdateFolderRequest;
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
 * REST stub implementation for the Folders service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonFoldersStub extends FoldersStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(UndeleteFolderMetadata.getDescriptor())
          .add(Folder.getDescriptor())
          .add(UpdateFolderMetadata.getDescriptor())
          .add(DeleteFolderMetadata.getDescriptor())
          .add(MoveFolderMetadata.getDescriptor())
          .add(CreateFolderMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetFolderRequest, Folder> getFolderMethodDescriptor =
      ApiMethodDescriptor.<GetFolderRequest, Folder>newBuilder()
          .setFullMethodName("google.cloud.resourcemanager.v3.Folders/GetFolder")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFolderRequest>newBuilder()
                  .setPath(
                      "/v3/{name=folders/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFolderRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFolderRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Folder>newBuilder()
                  .setDefaultInstance(Folder.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListFoldersRequest, ListFoldersResponse>
      listFoldersMethodDescriptor =
          ApiMethodDescriptor.<ListFoldersRequest, ListFoldersResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/ListFolders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFoldersRequest>newBuilder()
                      .setPath(
                          "/v3/folders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFoldersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFoldersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "parent", request.getParent());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFoldersResponse>newBuilder()
                      .setDefaultInstance(ListFoldersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchFoldersRequest, SearchFoldersResponse>
      searchFoldersMethodDescriptor =
          ApiMethodDescriptor.<SearchFoldersRequest, SearchFoldersResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/SearchFolders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchFoldersRequest>newBuilder()
                      .setPath(
                          "/v3/folders:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchFoldersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchFoldersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchFoldersResponse>newBuilder()
                      .setDefaultInstance(SearchFoldersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFolderRequest, Operation>
      createFolderMethodDescriptor =
          ApiMethodDescriptor.<CreateFolderRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/CreateFolder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFolderRequest>newBuilder()
                      .setPath(
                          "/v3/folders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("folder", request.getFolder(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFolderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateFolderRequest, Operation>
      updateFolderMethodDescriptor =
          ApiMethodDescriptor.<UpdateFolderRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/UpdateFolder")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFolderRequest>newBuilder()
                      .setPath(
                          "/v3/{folder.name=folders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "folder.name", request.getFolder().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("folder", request.getFolder(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFolderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<MoveFolderRequest, Operation>
      moveFolderMethodDescriptor =
          ApiMethodDescriptor.<MoveFolderRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/MoveFolder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveFolderRequest>newBuilder()
                      .setPath(
                          "/v3/{name=folders/*}:move",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MoveFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MoveFolderRequest> serializer =
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
                  (MoveFolderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFolderRequest, Operation>
      deleteFolderMethodDescriptor =
          ApiMethodDescriptor.<DeleteFolderRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/DeleteFolder")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFolderRequest>newBuilder()
                      .setPath(
                          "/v3/{name=folders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFolderRequest> serializer =
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
                  (DeleteFolderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeleteFolderRequest, Operation>
      undeleteFolderMethodDescriptor =
          ApiMethodDescriptor.<UndeleteFolderRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/UndeleteFolder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteFolderRequest>newBuilder()
                      .setPath(
                          "/v3/{name=folders/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteFolderRequest> serializer =
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
                  (UndeleteFolderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=folders/*}:getIamPolicy",
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=folders/*}:setIamPolicy",
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
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=folders/*}:testIamPermissions",
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

  private final UnaryCallable<GetFolderRequest, Folder> getFolderCallable;
  private final UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable;
  private final UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse>
      listFoldersPagedCallable;
  private final UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable;
  private final UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable;
  private final UnaryCallable<CreateFolderRequest, Operation> createFolderCallable;
  private final OperationCallable<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationCallable;
  private final UnaryCallable<UpdateFolderRequest, Operation> updateFolderCallable;
  private final OperationCallable<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationCallable;
  private final UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable;
  private final OperationCallable<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationCallable;
  private final UnaryCallable<DeleteFolderRequest, Operation> deleteFolderCallable;
  private final OperationCallable<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationCallable;
  private final UnaryCallable<UndeleteFolderRequest, Operation> undeleteFolderCallable;
  private final OperationCallable<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFoldersStub create(FoldersStubSettings settings) throws IOException {
    return new HttpJsonFoldersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFoldersStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonFoldersStub(FoldersStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFoldersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFoldersStub(
        FoldersStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFoldersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFoldersStub(FoldersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFoldersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFoldersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFoldersStub(
      FoldersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetFolderRequest, Folder> getFolderTransportSettings =
        HttpJsonCallSettings.<GetFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(getFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFoldersRequest, ListFoldersResponse> listFoldersTransportSettings =
        HttpJsonCallSettings.<ListFoldersRequest, ListFoldersResponse>newBuilder()
            .setMethodDescriptor(listFoldersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchFoldersRequest, SearchFoldersResponse>
        searchFoldersTransportSettings =
            HttpJsonCallSettings.<SearchFoldersRequest, SearchFoldersResponse>newBuilder()
                .setMethodDescriptor(searchFoldersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateFolderRequest, Operation> createFolderTransportSettings =
        HttpJsonCallSettings.<CreateFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(createFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateFolderRequest, Operation> updateFolderTransportSettings =
        HttpJsonCallSettings.<UpdateFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<MoveFolderRequest, Operation> moveFolderTransportSettings =
        HttpJsonCallSettings.<MoveFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(moveFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteFolderRequest, Operation> deleteFolderTransportSettings =
        HttpJsonCallSettings.<DeleteFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeleteFolderRequest, Operation> undeleteFolderTransportSettings =
        HttpJsonCallSettings.<UndeleteFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getFolderCallable =
        callableFactory.createUnaryCallable(
            getFolderTransportSettings, settings.getFolderSettings(), clientContext);
    this.listFoldersCallable =
        callableFactory.createUnaryCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.listFoldersPagedCallable =
        callableFactory.createPagedCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.searchFoldersCallable =
        callableFactory.createUnaryCallable(
            searchFoldersTransportSettings, settings.searchFoldersSettings(), clientContext);
    this.searchFoldersPagedCallable =
        callableFactory.createPagedCallable(
            searchFoldersTransportSettings, settings.searchFoldersSettings(), clientContext);
    this.createFolderCallable =
        callableFactory.createUnaryCallable(
            createFolderTransportSettings, settings.createFolderSettings(), clientContext);
    this.createFolderOperationCallable =
        callableFactory.createOperationCallable(
            createFolderTransportSettings,
            settings.createFolderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateFolderCallable =
        callableFactory.createUnaryCallable(
            updateFolderTransportSettings, settings.updateFolderSettings(), clientContext);
    this.updateFolderOperationCallable =
        callableFactory.createOperationCallable(
            updateFolderTransportSettings,
            settings.updateFolderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.moveFolderCallable =
        callableFactory.createUnaryCallable(
            moveFolderTransportSettings, settings.moveFolderSettings(), clientContext);
    this.moveFolderOperationCallable =
        callableFactory.createOperationCallable(
            moveFolderTransportSettings,
            settings.moveFolderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFolderCallable =
        callableFactory.createUnaryCallable(
            deleteFolderTransportSettings, settings.deleteFolderSettings(), clientContext);
    this.deleteFolderOperationCallable =
        callableFactory.createOperationCallable(
            deleteFolderTransportSettings,
            settings.deleteFolderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeleteFolderCallable =
        callableFactory.createUnaryCallable(
            undeleteFolderTransportSettings, settings.undeleteFolderSettings(), clientContext);
    this.undeleteFolderOperationCallable =
        callableFactory.createOperationCallable(
            undeleteFolderTransportSettings,
            settings.undeleteFolderOperationSettings(),
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
    methodDescriptors.add(getFolderMethodDescriptor);
    methodDescriptors.add(listFoldersMethodDescriptor);
    methodDescriptors.add(searchFoldersMethodDescriptor);
    methodDescriptors.add(createFolderMethodDescriptor);
    methodDescriptors.add(updateFolderMethodDescriptor);
    methodDescriptors.add(moveFolderMethodDescriptor);
    methodDescriptors.add(deleteFolderMethodDescriptor);
    methodDescriptors.add(undeleteFolderMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    return getFolderCallable;
  }

  @Override
  public UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    return listFoldersCallable;
  }

  @Override
  public UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse> listFoldersPagedCallable() {
    return listFoldersPagedCallable;
  }

  @Override
  public UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable() {
    return searchFoldersCallable;
  }

  @Override
  public UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable() {
    return searchFoldersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateFolderRequest, Operation> createFolderCallable() {
    return createFolderCallable;
  }

  @Override
  public OperationCallable<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationCallable() {
    return createFolderOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFolderRequest, Operation> updateFolderCallable() {
    return updateFolderCallable;
  }

  @Override
  public OperationCallable<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationCallable() {
    return updateFolderOperationCallable;
  }

  @Override
  public UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable() {
    return moveFolderCallable;
  }

  @Override
  public OperationCallable<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationCallable() {
    return moveFolderOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFolderRequest, Operation> deleteFolderCallable() {
    return deleteFolderCallable;
  }

  @Override
  public OperationCallable<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationCallable() {
    return deleteFolderOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteFolderRequest, Operation> undeleteFolderCallable() {
    return undeleteFolderCallable;
  }

  @Override
  public OperationCallable<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationCallable() {
    return undeleteFolderOperationCallable;
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
