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

import static com.google.cloud.resourcemanager.v3.ProjectsClient.ListProjectsPagedResponse;
import static com.google.cloud.resourcemanager.v3.ProjectsClient.SearchProjectsPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateProjectMetadata;
import com.google.cloud.resourcemanager.v3.CreateProjectRequest;
import com.google.cloud.resourcemanager.v3.DeleteProjectMetadata;
import com.google.cloud.resourcemanager.v3.DeleteProjectRequest;
import com.google.cloud.resourcemanager.v3.GetProjectRequest;
import com.google.cloud.resourcemanager.v3.ListProjectsRequest;
import com.google.cloud.resourcemanager.v3.ListProjectsResponse;
import com.google.cloud.resourcemanager.v3.MoveProjectMetadata;
import com.google.cloud.resourcemanager.v3.MoveProjectRequest;
import com.google.cloud.resourcemanager.v3.Project;
import com.google.cloud.resourcemanager.v3.SearchProjectsRequest;
import com.google.cloud.resourcemanager.v3.SearchProjectsResponse;
import com.google.cloud.resourcemanager.v3.UndeleteProjectMetadata;
import com.google.cloud.resourcemanager.v3.UndeleteProjectRequest;
import com.google.cloud.resourcemanager.v3.UpdateProjectMetadata;
import com.google.cloud.resourcemanager.v3.UpdateProjectRequest;
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
 * REST stub implementation for the Projects service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonProjectsStub extends ProjectsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Project.getDescriptor())
          .add(CreateProjectMetadata.getDescriptor())
          .add(UpdateProjectMetadata.getDescriptor())
          .add(MoveProjectMetadata.getDescriptor())
          .add(UndeleteProjectMetadata.getDescriptor())
          .add(DeleteProjectMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetProjectRequest, Project> getProjectMethodDescriptor =
      ApiMethodDescriptor.<GetProjectRequest, Project>newBuilder()
          .setFullMethodName("google.cloud.resourcemanager.v3.Projects/GetProject")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProjectRequest>newBuilder()
                  .setPath(
                      "/v3/{name=projects/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProjectRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProjectRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Project>newBuilder()
                  .setDefaultInstance(Project.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListProjectsRequest, ListProjectsResponse>
      listProjectsMethodDescriptor =
          ApiMethodDescriptor.<ListProjectsRequest, ListProjectsResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/ListProjects")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProjectsRequest>newBuilder()
                      .setPath(
                          "/v3/projects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "parent", request.getParent());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProjectsResponse>newBuilder()
                      .setDefaultInstance(ListProjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchProjectsRequest, SearchProjectsResponse>
      searchProjectsMethodDescriptor =
          ApiMethodDescriptor.<SearchProjectsRequest, SearchProjectsResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/SearchProjects")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchProjectsRequest>newBuilder()
                      .setPath(
                          "/v3/projects:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchProjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchProjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchProjectsResponse>newBuilder()
                      .setDefaultInstance(SearchProjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateProjectRequest, Operation>
      createProjectMethodDescriptor =
          ApiMethodDescriptor.<CreateProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/CreateProject")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProjectRequest>newBuilder()
                      .setPath(
                          "/v3/projects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("project", request.getProject(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateProjectRequest, Operation>
      updateProjectMethodDescriptor =
          ApiMethodDescriptor.<UpdateProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/UpdateProject")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProjectRequest>newBuilder()
                      .setPath(
                          "/v3/{project.name=projects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "project.name", request.getProject().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("project", request.getProject(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<MoveProjectRequest, Operation>
      moveProjectMethodDescriptor =
          ApiMethodDescriptor.<MoveProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/MoveProject")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveProjectRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*}:move",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MoveProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MoveProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (MoveProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteProjectRequest, Operation>
      deleteProjectMethodDescriptor =
          ApiMethodDescriptor.<DeleteProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/DeleteProject")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProjectRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProjectRequest> serializer =
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
                  (DeleteProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeleteProjectRequest, Operation>
      undeleteProjectMethodDescriptor =
          ApiMethodDescriptor.<UndeleteProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/UndeleteProject")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteProjectRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeleteProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=projects/*}:getIamPolicy",
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=projects/*}:setIamPolicy",
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=projects/*}:testIamPermissions",
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

  private final UnaryCallable<GetProjectRequest, Project> getProjectCallable;
  private final UnaryCallable<ListProjectsRequest, ListProjectsResponse> listProjectsCallable;
  private final UnaryCallable<ListProjectsRequest, ListProjectsPagedResponse>
      listProjectsPagedCallable;
  private final UnaryCallable<SearchProjectsRequest, SearchProjectsResponse> searchProjectsCallable;
  private final UnaryCallable<SearchProjectsRequest, SearchProjectsPagedResponse>
      searchProjectsPagedCallable;
  private final UnaryCallable<CreateProjectRequest, Operation> createProjectCallable;
  private final OperationCallable<CreateProjectRequest, Project, CreateProjectMetadata>
      createProjectOperationCallable;
  private final UnaryCallable<UpdateProjectRequest, Operation> updateProjectCallable;
  private final OperationCallable<UpdateProjectRequest, Project, UpdateProjectMetadata>
      updateProjectOperationCallable;
  private final UnaryCallable<MoveProjectRequest, Operation> moveProjectCallable;
  private final OperationCallable<MoveProjectRequest, Project, MoveProjectMetadata>
      moveProjectOperationCallable;
  private final UnaryCallable<DeleteProjectRequest, Operation> deleteProjectCallable;
  private final OperationCallable<DeleteProjectRequest, Project, DeleteProjectMetadata>
      deleteProjectOperationCallable;
  private final UnaryCallable<UndeleteProjectRequest, Operation> undeleteProjectCallable;
  private final OperationCallable<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
      undeleteProjectOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProjectsStub create(ProjectsStubSettings settings)
      throws IOException {
    return new HttpJsonProjectsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProjectsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonProjectsStub(
        ProjectsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProjectsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProjectsStub(
        ProjectsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProjectsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonProjectsStub(ProjectsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonProjectsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProjectsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonProjectsStub(
      ProjectsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetProjectRequest, Project> getProjectTransportSettings =
        HttpJsonCallSettings.<GetProjectRequest, Project>newBuilder()
            .setMethodDescriptor(getProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListProjectsRequest, ListProjectsResponse> listProjectsTransportSettings =
        HttpJsonCallSettings.<ListProjectsRequest, ListProjectsResponse>newBuilder()
            .setMethodDescriptor(listProjectsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchProjectsRequest, SearchProjectsResponse>
        searchProjectsTransportSettings =
            HttpJsonCallSettings.<SearchProjectsRequest, SearchProjectsResponse>newBuilder()
                .setMethodDescriptor(searchProjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateProjectRequest, Operation> createProjectTransportSettings =
        HttpJsonCallSettings.<CreateProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(createProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateProjectRequest, Operation> updateProjectTransportSettings =
        HttpJsonCallSettings.<UpdateProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(updateProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<MoveProjectRequest, Operation> moveProjectTransportSettings =
        HttpJsonCallSettings.<MoveProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(moveProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteProjectRequest, Operation> deleteProjectTransportSettings =
        HttpJsonCallSettings.<DeleteProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeleteProjectRequest, Operation> undeleteProjectTransportSettings =
        HttpJsonCallSettings.<UndeleteProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteProjectMethodDescriptor)
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

    this.getProjectCallable =
        callableFactory.createUnaryCallable(
            getProjectTransportSettings, settings.getProjectSettings(), clientContext);
    this.listProjectsCallable =
        callableFactory.createUnaryCallable(
            listProjectsTransportSettings, settings.listProjectsSettings(), clientContext);
    this.listProjectsPagedCallable =
        callableFactory.createPagedCallable(
            listProjectsTransportSettings, settings.listProjectsSettings(), clientContext);
    this.searchProjectsCallable =
        callableFactory.createUnaryCallable(
            searchProjectsTransportSettings, settings.searchProjectsSettings(), clientContext);
    this.searchProjectsPagedCallable =
        callableFactory.createPagedCallable(
            searchProjectsTransportSettings, settings.searchProjectsSettings(), clientContext);
    this.createProjectCallable =
        callableFactory.createUnaryCallable(
            createProjectTransportSettings, settings.createProjectSettings(), clientContext);
    this.createProjectOperationCallable =
        callableFactory.createOperationCallable(
            createProjectTransportSettings,
            settings.createProjectOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateProjectCallable =
        callableFactory.createUnaryCallable(
            updateProjectTransportSettings, settings.updateProjectSettings(), clientContext);
    this.updateProjectOperationCallable =
        callableFactory.createOperationCallable(
            updateProjectTransportSettings,
            settings.updateProjectOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.moveProjectCallable =
        callableFactory.createUnaryCallable(
            moveProjectTransportSettings, settings.moveProjectSettings(), clientContext);
    this.moveProjectOperationCallable =
        callableFactory.createOperationCallable(
            moveProjectTransportSettings,
            settings.moveProjectOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteProjectCallable =
        callableFactory.createUnaryCallable(
            deleteProjectTransportSettings, settings.deleteProjectSettings(), clientContext);
    this.deleteProjectOperationCallable =
        callableFactory.createOperationCallable(
            deleteProjectTransportSettings,
            settings.deleteProjectOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeleteProjectCallable =
        callableFactory.createUnaryCallable(
            undeleteProjectTransportSettings, settings.undeleteProjectSettings(), clientContext);
    this.undeleteProjectOperationCallable =
        callableFactory.createOperationCallable(
            undeleteProjectTransportSettings,
            settings.undeleteProjectOperationSettings(),
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
    methodDescriptors.add(getProjectMethodDescriptor);
    methodDescriptors.add(listProjectsMethodDescriptor);
    methodDescriptors.add(searchProjectsMethodDescriptor);
    methodDescriptors.add(createProjectMethodDescriptor);
    methodDescriptors.add(updateProjectMethodDescriptor);
    methodDescriptors.add(moveProjectMethodDescriptor);
    methodDescriptors.add(deleteProjectMethodDescriptor);
    methodDescriptors.add(undeleteProjectMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetProjectRequest, Project> getProjectCallable() {
    return getProjectCallable;
  }

  @Override
  public UnaryCallable<ListProjectsRequest, ListProjectsResponse> listProjectsCallable() {
    return listProjectsCallable;
  }

  @Override
  public UnaryCallable<ListProjectsRequest, ListProjectsPagedResponse> listProjectsPagedCallable() {
    return listProjectsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchProjectsRequest, SearchProjectsResponse> searchProjectsCallable() {
    return searchProjectsCallable;
  }

  @Override
  public UnaryCallable<SearchProjectsRequest, SearchProjectsPagedResponse>
      searchProjectsPagedCallable() {
    return searchProjectsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateProjectRequest, Operation> createProjectCallable() {
    return createProjectCallable;
  }

  @Override
  public OperationCallable<CreateProjectRequest, Project, CreateProjectMetadata>
      createProjectOperationCallable() {
    return createProjectOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateProjectRequest, Operation> updateProjectCallable() {
    return updateProjectCallable;
  }

  @Override
  public OperationCallable<UpdateProjectRequest, Project, UpdateProjectMetadata>
      updateProjectOperationCallable() {
    return updateProjectOperationCallable;
  }

  @Override
  public UnaryCallable<MoveProjectRequest, Operation> moveProjectCallable() {
    return moveProjectCallable;
  }

  @Override
  public OperationCallable<MoveProjectRequest, Project, MoveProjectMetadata>
      moveProjectOperationCallable() {
    return moveProjectOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteProjectRequest, Operation> deleteProjectCallable() {
    return deleteProjectCallable;
  }

  @Override
  public OperationCallable<DeleteProjectRequest, Project, DeleteProjectMetadata>
      deleteProjectOperationCallable() {
    return deleteProjectOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteProjectRequest, Operation> undeleteProjectCallable() {
    return undeleteProjectCallable;
  }

  @Override
  public OperationCallable<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
      undeleteProjectOperationCallable() {
    return undeleteProjectOperationCallable;
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
