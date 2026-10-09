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

import static com.google.ads.admanager.v1.CreativeWrapperServiceClient.ListCreativeWrappersPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchActivateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchCreateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchCreateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchDeactivateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchDeactivateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchUpdateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchUpdateCreativeWrappersResponse;
import com.google.ads.admanager.v1.CreateCreativeWrapperRequest;
import com.google.ads.admanager.v1.CreativeWrapper;
import com.google.ads.admanager.v1.GetCreativeWrapperRequest;
import com.google.ads.admanager.v1.ListCreativeWrappersRequest;
import com.google.ads.admanager.v1.ListCreativeWrappersResponse;
import com.google.ads.admanager.v1.UpdateCreativeWrapperRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CreativeWrapperService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class CreativeWrapperServiceStub implements BackgroundResource {

  public UnaryCallable<GetCreativeWrapperRequest, CreativeWrapper> getCreativeWrapperCallable() {
    throw new UnsupportedOperationException("Not implemented: getCreativeWrapperCallable()");
  }

  public UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersPagedResponse>
      listCreativeWrappersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCreativeWrappersPagedCallable()");
  }

  public UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersResponse>
      listCreativeWrappersCallable() {
    throw new UnsupportedOperationException("Not implemented: listCreativeWrappersCallable()");
  }

  public UnaryCallable<CreateCreativeWrapperRequest, CreativeWrapper>
      createCreativeWrapperCallable() {
    throw new UnsupportedOperationException("Not implemented: createCreativeWrapperCallable()");
  }

  public UnaryCallable<BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
      batchCreateCreativeWrappersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateCreativeWrappersCallable()");
  }

  public UnaryCallable<UpdateCreativeWrapperRequest, CreativeWrapper>
      updateCreativeWrapperCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCreativeWrapperCallable()");
  }

  public UnaryCallable<BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
      batchUpdateCreativeWrappersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateCreativeWrappersCallable()");
  }

  public UnaryCallable<BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
      batchActivateCreativeWrappersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchActivateCreativeWrappersCallable()");
  }

  public UnaryCallable<
          BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
      batchDeactivateCreativeWrappersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateCreativeWrappersCallable()");
  }

  @Override
  public abstract void close();
}
