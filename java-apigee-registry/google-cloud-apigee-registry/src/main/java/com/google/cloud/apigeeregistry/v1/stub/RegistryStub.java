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

package com.google.cloud.apigeeregistry.v1.stub;

import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiVersionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApisPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListArtifactsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigeeregistry.v1.Api;
import com.google.cloud.apigeeregistry.v1.ApiDeployment;
import com.google.cloud.apigeeregistry.v1.ApiSpec;
import com.google.cloud.apigeeregistry.v1.ApiVersion;
import com.google.cloud.apigeeregistry.v1.Artifact;
import com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.CreateArtifactRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest;
import com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.GetApiRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.GetApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApisRequest;
import com.google.cloud.apigeeregistry.v1.ListApisResponse;
import com.google.cloud.apigeeregistry.v1.ListArtifactsRequest;
import com.google.cloud.apigeeregistry.v1.ListArtifactsResponse;
import com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Registry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegistryStub implements BackgroundResource {

  public UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApisPagedCallable()");
  }

  public UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    throw new UnsupportedOperationException("Not implemented: listApisCallable()");
  }

  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiCallable()");
  }

  public UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiCallable()");
  }

  public UnaryCallable<UpdateApiRequest, Api> updateApiCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiCallable()");
  }

  public UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiCallable()");
  }

  public UnaryCallable<ListApiVersionsRequest, ListApiVersionsPagedResponse>
      listApiVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiVersionsPagedCallable()");
  }

  public UnaryCallable<ListApiVersionsRequest, ListApiVersionsResponse> listApiVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiVersionsCallable()");
  }

  public UnaryCallable<GetApiVersionRequest, ApiVersion> getApiVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiVersionCallable()");
  }

  public UnaryCallable<CreateApiVersionRequest, ApiVersion> createApiVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiVersionCallable()");
  }

  public UnaryCallable<UpdateApiVersionRequest, ApiVersion> updateApiVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiVersionCallable()");
  }

  public UnaryCallable<DeleteApiVersionRequest, Empty> deleteApiVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiVersionCallable()");
  }

  public UnaryCallable<ListApiSpecsRequest, ListApiSpecsPagedResponse> listApiSpecsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiSpecsPagedCallable()");
  }

  public UnaryCallable<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiSpecsCallable()");
  }

  public UnaryCallable<GetApiSpecRequest, ApiSpec> getApiSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiSpecCallable()");
  }

  public UnaryCallable<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiSpecContentsCallable()");
  }

  public UnaryCallable<CreateApiSpecRequest, ApiSpec> createApiSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiSpecCallable()");
  }

  public UnaryCallable<UpdateApiSpecRequest, ApiSpec> updateApiSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiSpecCallable()");
  }

  public UnaryCallable<DeleteApiSpecRequest, Empty> deleteApiSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiSpecCallable()");
  }

  public UnaryCallable<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: tagApiSpecRevisionCallable()");
  }

  public UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiSpecRevisionsPagedCallable()");
  }

  public UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiSpecRevisionsCallable()");
  }

  public UnaryCallable<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackApiSpecCallable()");
  }

  public UnaryCallable<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiSpecRevisionCallable()");
  }

  public UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsPagedResponse>
      listApiDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiDeploymentsCallable()");
  }

  public UnaryCallable<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiDeploymentCallable()");
  }

  public UnaryCallable<CreateApiDeploymentRequest, ApiDeployment> createApiDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiDeploymentCallable()");
  }

  public UnaryCallable<UpdateApiDeploymentRequest, ApiDeployment> updateApiDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiDeploymentCallable()");
  }

  public UnaryCallable<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiDeploymentCallable()");
  }

  public UnaryCallable<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: tagApiDeploymentRevisionCallable()");
  }

  public UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listApiDeploymentRevisionsPagedCallable()");
  }

  public UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listApiDeploymentRevisionsCallable()");
  }

  public UnaryCallable<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackApiDeploymentCallable()");
  }

  public UnaryCallable<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteApiDeploymentRevisionCallable()");
  }

  public UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listArtifactsPagedCallable()");
  }

  public UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable() {
    throw new UnsupportedOperationException("Not implemented: listArtifactsCallable()");
  }

  public UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: getArtifactCallable()");
  }

  public UnaryCallable<GetArtifactContentsRequest, HttpBody> getArtifactContentsCallable() {
    throw new UnsupportedOperationException("Not implemented: getArtifactContentsCallable()");
  }

  public UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: createArtifactCallable()");
  }

  public UnaryCallable<ReplaceArtifactRequest, Artifact> replaceArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: replaceArtifactCallable()");
  }

  public UnaryCallable<DeleteArtifactRequest, Empty> deleteArtifactCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteArtifactCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
