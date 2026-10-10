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

import static com.google.ads.admanager.v1.ViewabilityProviderServiceClient.ListViewabilityProvidersPagedResponse;

import com.google.ads.admanager.v1.BatchCreateViewabilityProvidersRequest;
import com.google.ads.admanager.v1.BatchCreateViewabilityProvidersResponse;
import com.google.ads.admanager.v1.BatchUpdateViewabilityProvidersRequest;
import com.google.ads.admanager.v1.BatchUpdateViewabilityProvidersResponse;
import com.google.ads.admanager.v1.CreateViewabilityProviderRequest;
import com.google.ads.admanager.v1.GetViewabilityProviderRequest;
import com.google.ads.admanager.v1.ListViewabilityProvidersRequest;
import com.google.ads.admanager.v1.ListViewabilityProvidersResponse;
import com.google.ads.admanager.v1.UpdateViewabilityProviderRequest;
import com.google.ads.admanager.v1.ViewabilityProvider;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ViewabilityProviderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class ViewabilityProviderServiceStub implements BackgroundResource {

  public UnaryCallable<GetViewabilityProviderRequest, ViewabilityProvider>
      getViewabilityProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: getViewabilityProviderCallable()");
  }

  public UnaryCallable<ListViewabilityProvidersRequest, ListViewabilityProvidersPagedResponse>
      listViewabilityProvidersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listViewabilityProvidersPagedCallable()");
  }

  public UnaryCallable<ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>
      listViewabilityProvidersCallable() {
    throw new UnsupportedOperationException("Not implemented: listViewabilityProvidersCallable()");
  }

  public UnaryCallable<CreateViewabilityProviderRequest, ViewabilityProvider>
      createViewabilityProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: createViewabilityProviderCallable()");
  }

  public UnaryCallable<
          BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
      batchCreateViewabilityProvidersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateViewabilityProvidersCallable()");
  }

  public UnaryCallable<UpdateViewabilityProviderRequest, ViewabilityProvider>
      updateViewabilityProviderCallable() {
    throw new UnsupportedOperationException("Not implemented: updateViewabilityProviderCallable()");
  }

  public UnaryCallable<
          BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
      batchUpdateViewabilityProvidersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateViewabilityProvidersCallable()");
  }

  @Override
  public abstract void close();
}
