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

import static com.google.ads.admanager.v1.NativeStyleServiceClient.ListNativeStylesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchActivateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchArchiveNativeStylesRequest;
import com.google.ads.admanager.v1.BatchArchiveNativeStylesResponse;
import com.google.ads.admanager.v1.BatchCreateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchCreateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchDeactivateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchDeactivateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchUpdateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchUpdateNativeStylesResponse;
import com.google.ads.admanager.v1.GetNativeStyleRequest;
import com.google.ads.admanager.v1.ListNativeStylesRequest;
import com.google.ads.admanager.v1.ListNativeStylesResponse;
import com.google.ads.admanager.v1.NativeStyle;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NativeStyleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class NativeStyleServiceStub implements BackgroundResource {

  public UnaryCallable<GetNativeStyleRequest, NativeStyle> getNativeStyleCallable() {
    throw new UnsupportedOperationException("Not implemented: getNativeStyleCallable()");
  }

  public UnaryCallable<ListNativeStylesRequest, ListNativeStylesPagedResponse>
      listNativeStylesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNativeStylesPagedCallable()");
  }

  public UnaryCallable<ListNativeStylesRequest, ListNativeStylesResponse>
      listNativeStylesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNativeStylesCallable()");
  }

  public UnaryCallable<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateNativeStylesCallable()");
  }

  public UnaryCallable<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateNativeStylesCallable()");
  }

  public UnaryCallable<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateNativeStylesCallable()");
  }

  public UnaryCallable<BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateNativeStylesCallable()");
  }

  public UnaryCallable<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveNativeStylesCallable()");
  }

  @Override
  public abstract void close();
}
