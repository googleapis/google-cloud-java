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
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Projects service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ProjectsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetProjectRequest, Project> getProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: getProjectCallable()");
  }

  public UnaryCallable<ListProjectsRequest, ListProjectsPagedResponse> listProjectsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProjectsPagedCallable()");
  }

  public UnaryCallable<ListProjectsRequest, ListProjectsResponse> listProjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProjectsCallable()");
  }

  public UnaryCallable<SearchProjectsRequest, SearchProjectsPagedResponse>
      searchProjectsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchProjectsPagedCallable()");
  }

  public UnaryCallable<SearchProjectsRequest, SearchProjectsResponse> searchProjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchProjectsCallable()");
  }

  public OperationCallable<CreateProjectRequest, Project, CreateProjectMetadata>
      createProjectOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createProjectOperationCallable()");
  }

  public UnaryCallable<CreateProjectRequest, Operation> createProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: createProjectCallable()");
  }

  public OperationCallable<UpdateProjectRequest, Project, UpdateProjectMetadata>
      updateProjectOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProjectOperationCallable()");
  }

  public UnaryCallable<UpdateProjectRequest, Operation> updateProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProjectCallable()");
  }

  public OperationCallable<MoveProjectRequest, Project, MoveProjectMetadata>
      moveProjectOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: moveProjectOperationCallable()");
  }

  public UnaryCallable<MoveProjectRequest, Operation> moveProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: moveProjectCallable()");
  }

  public OperationCallable<DeleteProjectRequest, Project, DeleteProjectMetadata>
      deleteProjectOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProjectOperationCallable()");
  }

  public UnaryCallable<DeleteProjectRequest, Operation> deleteProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProjectCallable()");
  }

  public OperationCallable<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
      undeleteProjectOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteProjectOperationCallable()");
  }

  public UnaryCallable<UndeleteProjectRequest, Operation> undeleteProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteProjectCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
