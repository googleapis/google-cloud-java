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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.PartnerLinkServiceClient.SearchPartnerLinksPagedResponse;

import com.google.ads.datamanager.v1.CreatePartnerLinkRequest;
import com.google.ads.datamanager.v1.DeletePartnerLinkRequest;
import com.google.ads.datamanager.v1.PartnerLink;
import com.google.ads.datamanager.v1.SearchPartnerLinksRequest;
import com.google.ads.datamanager.v1.SearchPartnerLinksResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PartnerLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PartnerLinkServiceStub implements BackgroundResource {

  public UnaryCallable<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createPartnerLinkCallable()");
  }

  public UnaryCallable<DeletePartnerLinkRequest, Empty> deletePartnerLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePartnerLinkCallable()");
  }

  public UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksPagedResponse>
      searchPartnerLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchPartnerLinksPagedCallable()");
  }

  public UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: searchPartnerLinksCallable()");
  }

  @Override
  public abstract void close();
}
