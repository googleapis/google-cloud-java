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

package com.google.ads.marketingplatform.admin.v1alpha.stub;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;

import com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse;
import com.google.ads.marketingplatform.admin.v1alpha.Organization;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MarketingplatformAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MarketingplatformAdminServiceStub implements BackgroundResource {

  public UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrganizationCallable()");
  }

  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAnalyticsAccountLinksPagedCallable()");
  }

  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalyticsAccountLinksCallable()");
  }

  public UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAnalyticsAccountLinkCallable()");
  }

  public UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAnalyticsAccountLinkCallable()");
  }

  public UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable() {
    throw new UnsupportedOperationException("Not implemented: setPropertyServiceLevelCallable()");
  }

  @Override
  public abstract void close();
}
