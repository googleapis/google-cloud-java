/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.SiteServiceClient.ListSitesPagedResponse;

import com.google.ads.admanager.v1.BatchCreateSitesRequest;
import com.google.ads.admanager.v1.BatchCreateSitesResponse;
import com.google.ads.admanager.v1.BatchDeactivateSitesRequest;
import com.google.ads.admanager.v1.BatchDeactivateSitesResponse;
import com.google.ads.admanager.v1.BatchSubmitSitesForApprovalRequest;
import com.google.ads.admanager.v1.BatchSubmitSitesForApprovalResponse;
import com.google.ads.admanager.v1.BatchUpdateSitesRequest;
import com.google.ads.admanager.v1.BatchUpdateSitesResponse;
import com.google.ads.admanager.v1.CreateSiteRequest;
import com.google.ads.admanager.v1.GetSiteRequest;
import com.google.ads.admanager.v1.ListSitesRequest;
import com.google.ads.admanager.v1.ListSitesResponse;
import com.google.ads.admanager.v1.Site;
import com.google.ads.admanager.v1.UpdateSiteRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SiteService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SiteServiceStub implements BackgroundResource {

  public UnaryCallable<GetSiteRequest, Site> getSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: getSiteCallable()");
  }

  public UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSitesPagedCallable()");
  }

  public UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSitesCallable()");
  }

  public UnaryCallable<CreateSiteRequest, Site> createSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: createSiteCallable()");
  }

  public UnaryCallable<BatchCreateSitesRequest, BatchCreateSitesResponse>
      batchCreateSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateSitesCallable()");
  }

  public UnaryCallable<UpdateSiteRequest, Site> updateSiteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSiteCallable()");
  }

  public UnaryCallable<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
      batchUpdateSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateSitesCallable()");
  }

  public UnaryCallable<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
      batchDeactivateSitesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeactivateSitesCallable()");
  }

  public UnaryCallable<BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
      batchSubmitSitesForApprovalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchSubmitSitesForApprovalCallable()");
  }

  @Override
  public abstract void close();
}
