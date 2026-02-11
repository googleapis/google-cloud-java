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

import static com.google.ads.admanager.v1.BrowserServiceClient.ListBrowsersPagedResponse;

import com.google.ads.admanager.v1.Browser;
import com.google.ads.admanager.v1.GetBrowserRequest;
import com.google.ads.admanager.v1.ListBrowsersRequest;
import com.google.ads.admanager.v1.ListBrowsersResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BrowserService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BrowserServiceStub implements BackgroundResource {

  public UnaryCallable<GetBrowserRequest, Browser> getBrowserCallable() {
    throw new UnsupportedOperationException("Not implemented: getBrowserCallable()");
  }

  public UnaryCallable<ListBrowsersRequest, ListBrowsersPagedResponse> listBrowsersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBrowsersPagedCallable()");
  }

  public UnaryCallable<ListBrowsersRequest, ListBrowsersResponse> listBrowsersCallable() {
    throw new UnsupportedOperationException("Not implemented: listBrowsersCallable()");
  }

  @Override
  public abstract void close();
}
