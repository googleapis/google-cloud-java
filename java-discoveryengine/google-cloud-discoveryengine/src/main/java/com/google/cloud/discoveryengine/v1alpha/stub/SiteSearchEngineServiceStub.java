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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest;
import com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesResponse;
import com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesMetadata;
import com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest;
import com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesResponse;
import com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest;
import com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest;
import com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse;
import com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest;
import com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest;
import com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse;
import com.google.cloud.discoveryengine.v1alpha.RecrawlUrisMetadata;
import com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest;
import com.google.cloud.discoveryengine.v1alpha.RecrawlUrisResponse;
import com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine;
import com.google.cloud.discoveryengine.v1alpha.TargetSite;
import com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SiteSearchEngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SiteSearchEngineServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetSiteSearchEngineRequest, SiteSearchEngine> getSiteSearchEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: getSiteSearchEngineCallable()");
  }

  public OperationCallable<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTargetSiteOperationCallable()");
  }

  public UnaryCallable<CreateTargetSiteRequest, Operation> createTargetSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: createTargetSiteCallable()");
  }

  public OperationCallable<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateTargetSitesOperationCallable()");
  }

  public UnaryCallable<BatchCreateTargetSitesRequest, Operation> batchCreateTargetSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateTargetSitesCallable()");
  }

  public UnaryCallable<GetTargetSiteRequest, TargetSite> getTargetSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetSiteCallable()");
  }

  public OperationCallable<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTargetSiteOperationCallable()");
  }

  public UnaryCallable<UpdateTargetSiteRequest, Operation> updateTargetSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTargetSiteCallable()");
  }

  public OperationCallable<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetSiteOperationCallable()");
  }

  public UnaryCallable<DeleteTargetSiteRequest, Operation> deleteTargetSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetSiteCallable()");
  }

  public UnaryCallable<ListTargetSitesRequest, ListTargetSitesPagedResponse>
      listTargetSitesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetSitesPagedCallable()");
  }

  public UnaryCallable<ListTargetSitesRequest, ListTargetSitesResponse> listTargetSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetSitesCallable()");
  }

  public OperationCallable<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enableAdvancedSiteSearchOperationCallable()");
  }

  public UnaryCallable<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchCallable() {
    throw new UnsupportedOperationException("Not implemented: enableAdvancedSiteSearchCallable()");
  }

  public OperationCallable<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableAdvancedSiteSearchOperationCallable()");
  }

  public UnaryCallable<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchCallable() {
    throw new UnsupportedOperationException("Not implemented: disableAdvancedSiteSearchCallable()");
  }

  public OperationCallable<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: recrawlUrisOperationCallable()");
  }

  public UnaryCallable<RecrawlUrisRequest, Operation> recrawlUrisCallable() {
    throw new UnsupportedOperationException("Not implemented: recrawlUrisCallable()");
  }

  public OperationCallable<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchVerifyTargetSitesOperationCallable()");
  }

  public UnaryCallable<BatchVerifyTargetSitesRequest, Operation> batchVerifyTargetSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchVerifyTargetSitesCallable()");
  }

  public UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchDomainVerificationStatusPagedCallable()");
  }

  public UnaryCallable<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchDomainVerificationStatusCallable()");
  }

  @Override
  public abstract void close();
}
