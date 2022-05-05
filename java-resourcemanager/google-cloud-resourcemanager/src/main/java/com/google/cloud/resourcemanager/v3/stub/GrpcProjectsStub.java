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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Projects service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcProjectsStub extends ProjectsStub {
  private static final MethodDescriptor<GetProjectRequest, Project> getProjectMethodDescriptor =
      MethodDescriptor.<GetProjectRequest, Project>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Projects/GetProject")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Project.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListProjectsRequest, ListProjectsResponse>
      listProjectsMethodDescriptor =
          MethodDescriptor.<ListProjectsRequest, ListProjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/ListProjects")
              .setRequestMarshaller(ProtoUtils.marshaller(ListProjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProjectsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchProjectsRequest, SearchProjectsResponse>
      searchProjectsMethodDescriptor =
          MethodDescriptor.<SearchProjectsRequest, SearchProjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/SearchProjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchProjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchProjectsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateProjectRequest, Operation>
      createProjectMethodDescriptor =
          MethodDescriptor.<CreateProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/CreateProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProjectRequest, Operation>
      updateProjectMethodDescriptor =
          MethodDescriptor.<UpdateProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/UpdateProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MoveProjectRequest, Operation> moveProjectMethodDescriptor =
      MethodDescriptor.<MoveProjectRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Projects/MoveProject")
          .setRequestMarshaller(ProtoUtils.marshaller(MoveProjectRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteProjectRequest, Operation>
      deleteProjectMethodDescriptor =
          MethodDescriptor.<DeleteProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/DeleteProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteProjectRequest, Operation>
      undeleteProjectMethodDescriptor =
          MethodDescriptor.<UndeleteProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/UndeleteProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Projects/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Projects/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Projects/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProjectsStub create(ProjectsStubSettings settings) throws IOException {
    return new GrpcProjectsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProjectsStub create(ClientContext clientContext) throws IOException {
    return new GrpcProjectsStub(ProjectsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProjectsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProjectsStub(
        ProjectsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProjectsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcProjectsStub(ProjectsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcProjectsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProjectsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcProjectsStub(
      ProjectsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetProjectRequest, Project> getProjectTransportSettings =
        GrpcCallSettings.<GetProjectRequest, Project>newBuilder()
            .setMethodDescriptor(getProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListProjectsRequest, ListProjectsResponse> listProjectsTransportSettings =
        GrpcCallSettings.<ListProjectsRequest, ListProjectsResponse>newBuilder()
            .setMethodDescriptor(listProjectsMethodDescriptor)
            .build();
    GrpcCallSettings<SearchProjectsRequest, SearchProjectsResponse>
        searchProjectsTransportSettings =
            GrpcCallSettings.<SearchProjectsRequest, SearchProjectsResponse>newBuilder()
                .setMethodDescriptor(searchProjectsMethodDescriptor)
                .build();
    GrpcCallSettings<CreateProjectRequest, Operation> createProjectTransportSettings =
        GrpcCallSettings.<CreateProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(createProjectMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateProjectRequest, Operation> updateProjectTransportSettings =
        GrpcCallSettings.<UpdateProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(updateProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("project.name", String.valueOf(request.getProject().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<MoveProjectRequest, Operation> moveProjectTransportSettings =
        GrpcCallSettings.<MoveProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(moveProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteProjectRequest, Operation> deleteProjectTransportSettings =
        GrpcCallSettings.<DeleteProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeleteProjectRequest, Operation> undeleteProjectTransportSettings =
        GrpcCallSettings.<UndeleteProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
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
            operationsStub);
    this.updateProjectCallable =
        callableFactory.createUnaryCallable(
            updateProjectTransportSettings, settings.updateProjectSettings(), clientContext);
    this.updateProjectOperationCallable =
        callableFactory.createOperationCallable(
            updateProjectTransportSettings,
            settings.updateProjectOperationSettings(),
            clientContext,
            operationsStub);
    this.moveProjectCallable =
        callableFactory.createUnaryCallable(
            moveProjectTransportSettings, settings.moveProjectSettings(), clientContext);
    this.moveProjectOperationCallable =
        callableFactory.createOperationCallable(
            moveProjectTransportSettings,
            settings.moveProjectOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteProjectCallable =
        callableFactory.createUnaryCallable(
            deleteProjectTransportSettings, settings.deleteProjectSettings(), clientContext);
    this.deleteProjectOperationCallable =
        callableFactory.createOperationCallable(
            deleteProjectTransportSettings,
            settings.deleteProjectOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteProjectCallable =
        callableFactory.createUnaryCallable(
            undeleteProjectTransportSettings, settings.undeleteProjectSettings(), clientContext);
    this.undeleteProjectOperationCallable =
        callableFactory.createOperationCallable(
            undeleteProjectTransportSettings,
            settings.undeleteProjectOperationSettings(),
            clientContext,
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
