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

import static com.google.ads.admanager.v1.CdnConfigServiceClient.ListCdnConfigsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchActivateCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchArchiveCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchArchiveCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchCreateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchCreateCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchUpdateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchUpdateCdnConfigsResponse;
import com.google.ads.admanager.v1.CdnConfig;
import com.google.ads.admanager.v1.CreateCdnConfigRequest;
import com.google.ads.admanager.v1.GetCdnConfigRequest;
import com.google.ads.admanager.v1.ListCdnConfigsRequest;
import com.google.ads.admanager.v1.ListCdnConfigsResponse;
import com.google.ads.admanager.v1.UpdateCdnConfigRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CdnConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class CdnConfigServiceStub implements BackgroundResource {

  public UnaryCallable<GetCdnConfigRequest, CdnConfig> getCdnConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getCdnConfigCallable()");
  }

  public UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsPagedResponse>
      listCdnConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCdnConfigsPagedCallable()");
  }

  public UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsResponse> listCdnConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCdnConfigsCallable()");
  }

  public UnaryCallable<CreateCdnConfigRequest, CdnConfig> createCdnConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createCdnConfigCallable()");
  }

  public UnaryCallable<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateCdnConfigsCallable()");
  }

  public UnaryCallable<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCdnConfigCallable()");
  }

  public UnaryCallable<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateCdnConfigsCallable()");
  }

  public UnaryCallable<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateCdnConfigsCallable()");
  }

  public UnaryCallable<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveCdnConfigsCallable()");
  }

  @Override
  public abstract void close();
}
