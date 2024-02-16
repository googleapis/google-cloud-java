/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1beta.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.BatchCreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.BatchCreateTargetSitesRequest;
import com.google.cloud.discoveryengine.v1beta.BatchCreateTargetSitesResponse;
import com.google.cloud.discoveryengine.v1beta.BatchVerifyTargetSitesMetadata;
import com.google.cloud.discoveryengine.v1beta.BatchVerifyTargetSitesRequest;
import com.google.cloud.discoveryengine.v1beta.BatchVerifyTargetSitesResponse;
import com.google.cloud.discoveryengine.v1beta.CreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.CreateTargetSiteRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.DeleteTargetSiteRequest;
import com.google.cloud.discoveryengine.v1beta.DisableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1beta.DisableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1beta.DisableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1beta.EnableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1beta.EnableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1beta.EnableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1beta.FetchDomainVerificationStatusRequest;
import com.google.cloud.discoveryengine.v1beta.FetchDomainVerificationStatusResponse;
import com.google.cloud.discoveryengine.v1beta.GetSiteSearchEngineRequest;
import com.google.cloud.discoveryengine.v1beta.GetTargetSiteRequest;
import com.google.cloud.discoveryengine.v1beta.ListTargetSitesRequest;
import com.google.cloud.discoveryengine.v1beta.ListTargetSitesResponse;
import com.google.cloud.discoveryengine.v1beta.RecrawlUrisMetadata;
import com.google.cloud.discoveryengine.v1beta.RecrawlUrisRequest;
import com.google.cloud.discoveryengine.v1beta.RecrawlUrisResponse;
import com.google.cloud.discoveryengine.v1beta.SiteSearchEngine;
import com.google.cloud.discoveryengine.v1beta.TargetSite;
import com.google.cloud.discoveryengine.v1beta.UpdateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.UpdateTargetSiteRequest;
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
