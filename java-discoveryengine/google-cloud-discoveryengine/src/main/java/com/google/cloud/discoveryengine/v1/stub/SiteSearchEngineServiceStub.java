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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.BatchCreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.BatchCreateTargetSitesRequest;
import com.google.cloud.discoveryengine.v1.BatchCreateTargetSitesResponse;
import com.google.cloud.discoveryengine.v1.BatchVerifyTargetSitesMetadata;
import com.google.cloud.discoveryengine.v1.BatchVerifyTargetSitesRequest;
import com.google.cloud.discoveryengine.v1.BatchVerifyTargetSitesResponse;
import com.google.cloud.discoveryengine.v1.CreateSitemapMetadata;
import com.google.cloud.discoveryengine.v1.CreateSitemapRequest;
import com.google.cloud.discoveryengine.v1.CreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.CreateTargetSiteRequest;
import com.google.cloud.discoveryengine.v1.DeleteSitemapMetadata;
import com.google.cloud.discoveryengine.v1.DeleteSitemapRequest;
import com.google.cloud.discoveryengine.v1.DeleteTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.DeleteTargetSiteRequest;
import com.google.cloud.discoveryengine.v1.DisableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1.DisableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1.DisableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1.EnableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1.EnableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1.EnableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1.FetchDomainVerificationStatusRequest;
import com.google.cloud.discoveryengine.v1.FetchDomainVerificationStatusResponse;
import com.google.cloud.discoveryengine.v1.FetchSitemapsRequest;
import com.google.cloud.discoveryengine.v1.FetchSitemapsResponse;
import com.google.cloud.discoveryengine.v1.GetSiteSearchEngineRequest;
import com.google.cloud.discoveryengine.v1.GetTargetSiteRequest;
import com.google.cloud.discoveryengine.v1.ListTargetSitesRequest;
import com.google.cloud.discoveryengine.v1.ListTargetSitesResponse;
import com.google.cloud.discoveryengine.v1.RecrawlUrisMetadata;
import com.google.cloud.discoveryengine.v1.RecrawlUrisRequest;
import com.google.cloud.discoveryengine.v1.RecrawlUrisResponse;
import com.google.cloud.discoveryengine.v1.SiteSearchEngine;
import com.google.cloud.discoveryengine.v1.Sitemap;
import com.google.cloud.discoveryengine.v1.TargetSite;
import com.google.cloud.discoveryengine.v1.UpdateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.UpdateTargetSiteRequest;
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

  public OperationCallable<CreateSitemapRequest, Sitemap, CreateSitemapMetadata>
      createSitemapOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSitemapOperationCallable()");
  }

  public UnaryCallable<CreateSitemapRequest, Operation> createSitemapCallable() {
    throw new UnsupportedOperationException("Not implemented: createSitemapCallable()");
  }

  public OperationCallable<DeleteSitemapRequest, Empty, DeleteSitemapMetadata>
      deleteSitemapOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSitemapOperationCallable()");
  }

  public UnaryCallable<DeleteSitemapRequest, Operation> deleteSitemapCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSitemapCallable()");
  }

  public UnaryCallable<FetchSitemapsRequest, FetchSitemapsResponse> fetchSitemapsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchSitemapsCallable()");
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
