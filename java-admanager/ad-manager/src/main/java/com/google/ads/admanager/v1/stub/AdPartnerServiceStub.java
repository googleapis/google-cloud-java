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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.AdPartnerServiceClient.ListAdPartnersPagedResponse;

import com.google.ads.admanager.v1.AdPartner;
import com.google.ads.admanager.v1.GetAdPartnerRequest;
import com.google.ads.admanager.v1.ListAdPartnersRequest;
import com.google.ads.admanager.v1.ListAdPartnersResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AdPartnerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AdPartnerServiceStub implements BackgroundResource {

  public UnaryCallable<GetAdPartnerRequest, AdPartner> getAdPartnerCallable() {
    throw new UnsupportedOperationException("Not implemented: getAdPartnerCallable()");
  }

  public UnaryCallable<ListAdPartnersRequest, ListAdPartnersPagedResponse>
      listAdPartnersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdPartnersPagedCallable()");
  }

  public UnaryCallable<ListAdPartnersRequest, ListAdPartnersResponse> listAdPartnersCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdPartnersCallable()");
  }

  @Override
  public abstract void close();
}
