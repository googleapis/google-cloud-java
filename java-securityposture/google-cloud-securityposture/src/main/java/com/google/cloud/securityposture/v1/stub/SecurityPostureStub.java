/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.securityposture.v1.stub;

import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListLocationsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureDeploymentsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureRevisionsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureTemplatesPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPosturesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.CreatePostureRequest;
import com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.DeletePostureRequest;
import com.google.cloud.securityposture.v1.ExtractPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureDeploymentRequest;
import com.google.cloud.securityposture.v1.GetPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureTemplateRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse;
import com.google.cloud.securityposture.v1.ListPostureRevisionsRequest;
import com.google.cloud.securityposture.v1.ListPostureRevisionsResponse;
import com.google.cloud.securityposture.v1.ListPostureTemplatesRequest;
import com.google.cloud.securityposture.v1.ListPostureTemplatesResponse;
import com.google.cloud.securityposture.v1.ListPosturesRequest;
import com.google.cloud.securityposture.v1.ListPosturesResponse;
import com.google.cloud.securityposture.v1.OperationMetadata;
import com.google.cloud.securityposture.v1.Posture;
import com.google.cloud.securityposture.v1.PostureDeployment;
import com.google.cloud.securityposture.v1.PostureTemplate;
import com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.UpdatePostureRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SecurityPosture service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SecurityPostureStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListPosturesRequest, ListPosturesPagedResponse> listPosturesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPosturesPagedCallable()");
  }

  public UnaryCallable<ListPosturesRequest, ListPosturesResponse> listPosturesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPosturesCallable()");
  }

  public UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsPagedResponse>
      listPostureRevisionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPostureRevisionsPagedCallable()");
  }

  public UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPostureRevisionsCallable()");
  }

  public UnaryCallable<GetPostureRequest, Posture> getPostureCallable() {
    throw new UnsupportedOperationException("Not implemented: getPostureCallable()");
  }

  public OperationCallable<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createPostureOperationCallable()");
  }

  public UnaryCallable<CreatePostureRequest, Operation> createPostureCallable() {
    throw new UnsupportedOperationException("Not implemented: createPostureCallable()");
  }

  public OperationCallable<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePostureOperationCallable()");
  }

  public UnaryCallable<UpdatePostureRequest, Operation> updatePostureCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePostureCallable()");
  }

  public OperationCallable<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePostureOperationCallable()");
  }

  public UnaryCallable<DeletePostureRequest, Operation> deletePostureCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePostureCallable()");
  }

  public OperationCallable<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: extractPostureOperationCallable()");
  }

  public UnaryCallable<ExtractPostureRequest, Operation> extractPostureCallable() {
    throw new UnsupportedOperationException("Not implemented: extractPostureCallable()");
  }

  public UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPostureDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPostureDeploymentsCallable()");
  }

  public UnaryCallable<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getPostureDeploymentCallable()");
  }

  public OperationCallable<CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPostureDeploymentOperationCallable()");
  }

  public UnaryCallable<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createPostureDeploymentCallable()");
  }

  public OperationCallable<UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePostureDeploymentOperationCallable()");
  }

  public UnaryCallable<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePostureDeploymentCallable()");
  }

  public OperationCallable<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePostureDeploymentOperationCallable()");
  }

  public UnaryCallable<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePostureDeploymentCallable()");
  }

  public UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesPagedResponse>
      listPostureTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPostureTemplatesPagedCallable()");
  }

  public UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPostureTemplatesCallable()");
  }

  public UnaryCallable<GetPostureTemplateRequest, PostureTemplate> getPostureTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getPostureTemplateCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
