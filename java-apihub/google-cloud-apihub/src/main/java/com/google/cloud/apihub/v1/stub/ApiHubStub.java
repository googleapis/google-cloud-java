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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubClient.ListApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListAttributesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListDeploymentsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListExternalApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListSpecsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListVersionsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.SearchResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.Api;
import com.google.cloud.apihub.v1.ApiOperation;
import com.google.cloud.apihub.v1.Attribute;
import com.google.cloud.apihub.v1.CreateApiRequest;
import com.google.cloud.apihub.v1.CreateAttributeRequest;
import com.google.cloud.apihub.v1.CreateDeploymentRequest;
import com.google.cloud.apihub.v1.CreateExternalApiRequest;
import com.google.cloud.apihub.v1.CreateSpecRequest;
import com.google.cloud.apihub.v1.CreateVersionRequest;
import com.google.cloud.apihub.v1.Definition;
import com.google.cloud.apihub.v1.DeleteApiRequest;
import com.google.cloud.apihub.v1.DeleteAttributeRequest;
import com.google.cloud.apihub.v1.DeleteDeploymentRequest;
import com.google.cloud.apihub.v1.DeleteExternalApiRequest;
import com.google.cloud.apihub.v1.DeleteSpecRequest;
import com.google.cloud.apihub.v1.DeleteVersionRequest;
import com.google.cloud.apihub.v1.Deployment;
import com.google.cloud.apihub.v1.ExternalApi;
import com.google.cloud.apihub.v1.GetApiOperationRequest;
import com.google.cloud.apihub.v1.GetApiRequest;
import com.google.cloud.apihub.v1.GetAttributeRequest;
import com.google.cloud.apihub.v1.GetDefinitionRequest;
import com.google.cloud.apihub.v1.GetDeploymentRequest;
import com.google.cloud.apihub.v1.GetExternalApiRequest;
import com.google.cloud.apihub.v1.GetSpecContentsRequest;
import com.google.cloud.apihub.v1.GetSpecRequest;
import com.google.cloud.apihub.v1.GetVersionRequest;
import com.google.cloud.apihub.v1.ListApiOperationsRequest;
import com.google.cloud.apihub.v1.ListApiOperationsResponse;
import com.google.cloud.apihub.v1.ListApisRequest;
import com.google.cloud.apihub.v1.ListApisResponse;
import com.google.cloud.apihub.v1.ListAttributesRequest;
import com.google.cloud.apihub.v1.ListAttributesResponse;
import com.google.cloud.apihub.v1.ListDeploymentsRequest;
import com.google.cloud.apihub.v1.ListDeploymentsResponse;
import com.google.cloud.apihub.v1.ListExternalApisRequest;
import com.google.cloud.apihub.v1.ListExternalApisResponse;
import com.google.cloud.apihub.v1.ListSpecsRequest;
import com.google.cloud.apihub.v1.ListSpecsResponse;
import com.google.cloud.apihub.v1.ListVersionsRequest;
import com.google.cloud.apihub.v1.ListVersionsResponse;
import com.google.cloud.apihub.v1.SearchResourcesRequest;
import com.google.cloud.apihub.v1.SearchResourcesResponse;
import com.google.cloud.apihub.v1.Spec;
import com.google.cloud.apihub.v1.SpecContents;
import com.google.cloud.apihub.v1.UpdateApiRequest;
import com.google.cloud.apihub.v1.UpdateAttributeRequest;
import com.google.cloud.apihub.v1.UpdateDeploymentRequest;
import com.google.cloud.apihub.v1.UpdateExternalApiRequest;
import com.google.cloud.apihub.v1.UpdateSpecRequest;
import com.google.cloud.apihub.v1.UpdateVersionRequest;
import com.google.cloud.apihub.v1.Version;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ApiHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ApiHubStub implements BackgroundResource {

  public UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    throw new UnsupportedOperationException("Not implemented: createApiCallable()");
  }

  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiCallable()");
  }

  public UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApisPagedCallable()");
  }

  public UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    throw new UnsupportedOperationException("Not implemented: listApisCallable()");
  }

  public UnaryCallable<UpdateApiRequest, Api> updateApiCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApiCallable()");
  }

  public UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApiCallable()");
  }

  public UnaryCallable<CreateVersionRequest, Version> createVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createVersionCallable()");
  }

  public UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getVersionCallable()");
  }

  public UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse> listVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVersionsPagedCallable()");
  }

  public UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVersionsCallable()");
  }

  public UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVersionCallable()");
  }

  public UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVersionCallable()");
  }

  public UnaryCallable<CreateSpecRequest, Spec> createSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpecCallable()");
  }

  public UnaryCallable<GetSpecRequest, Spec> getSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpecCallable()");
  }

  public UnaryCallable<GetSpecContentsRequest, SpecContents> getSpecContentsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpecContentsCallable()");
  }

  public UnaryCallable<ListSpecsRequest, ListSpecsPagedResponse> listSpecsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpecsPagedCallable()");
  }

  public UnaryCallable<ListSpecsRequest, ListSpecsResponse> listSpecsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpecsCallable()");
  }

  public UnaryCallable<UpdateSpecRequest, Spec> updateSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpecCallable()");
  }

  public UnaryCallable<DeleteSpecRequest, Empty> deleteSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSpecCallable()");
  }

  public UnaryCallable<GetApiOperationRequest, ApiOperation> getApiOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: getApiOperationCallable()");
  }

  public UnaryCallable<ListApiOperationsRequest, ListApiOperationsPagedResponse>
      listApiOperationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiOperationsPagedCallable()");
  }

  public UnaryCallable<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApiOperationsCallable()");
  }

  public UnaryCallable<GetDefinitionRequest, Definition> getDefinitionCallable() {
    throw new UnsupportedOperationException("Not implemented: getDefinitionCallable()");
  }

  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeploymentCallable()");
  }

  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeploymentCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsCallable()");
  }

  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeploymentCallable()");
  }

  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeploymentCallable()");
  }

  public UnaryCallable<CreateAttributeRequest, Attribute> createAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: createAttributeCallable()");
  }

  public UnaryCallable<GetAttributeRequest, Attribute> getAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttributeCallable()");
  }

  public UnaryCallable<UpdateAttributeRequest, Attribute> updateAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAttributeCallable()");
  }

  public UnaryCallable<DeleteAttributeRequest, Empty> deleteAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAttributeCallable()");
  }

  public UnaryCallable<ListAttributesRequest, ListAttributesPagedResponse>
      listAttributesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttributesPagedCallable()");
  }

  public UnaryCallable<ListAttributesRequest, ListAttributesResponse> listAttributesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttributesCallable()");
  }

  public UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchResourcesPagedCallable()");
  }

  public UnaryCallable<SearchResourcesRequest, SearchResourcesResponse> searchResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchResourcesCallable()");
  }

  public UnaryCallable<CreateExternalApiRequest, ExternalApi> createExternalApiCallable() {
    throw new UnsupportedOperationException("Not implemented: createExternalApiCallable()");
  }

  public UnaryCallable<GetExternalApiRequest, ExternalApi> getExternalApiCallable() {
    throw new UnsupportedOperationException("Not implemented: getExternalApiCallable()");
  }

  public UnaryCallable<UpdateExternalApiRequest, ExternalApi> updateExternalApiCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExternalApiCallable()");
  }

  public UnaryCallable<DeleteExternalApiRequest, Empty> deleteExternalApiCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExternalApiCallable()");
  }

  public UnaryCallable<ListExternalApisRequest, ListExternalApisPagedResponse>
      listExternalApisPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExternalApisPagedCallable()");
  }

  public UnaryCallable<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisCallable() {
    throw new UnsupportedOperationException("Not implemented: listExternalApisCallable()");
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
