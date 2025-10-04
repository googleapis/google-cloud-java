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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.AdBreakServiceClient.ListAdBreaksPagedResponse;

import com.google.ads.admanager.v1.AdBreak;
import com.google.ads.admanager.v1.CreateAdBreakRequest;
import com.google.ads.admanager.v1.DeleteAdBreakRequest;
import com.google.ads.admanager.v1.GetAdBreakRequest;
import com.google.ads.admanager.v1.ListAdBreaksRequest;
import com.google.ads.admanager.v1.ListAdBreaksResponse;
import com.google.ads.admanager.v1.UpdateAdBreakRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AdBreakService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AdBreakServiceStub implements BackgroundResource {

  public UnaryCallable<GetAdBreakRequest, AdBreak> getAdBreakCallable() {
    throw new UnsupportedOperationException("Not implemented: getAdBreakCallable()");
  }

  public UnaryCallable<ListAdBreaksRequest, ListAdBreaksPagedResponse> listAdBreaksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdBreaksPagedCallable()");
  }

  public UnaryCallable<ListAdBreaksRequest, ListAdBreaksResponse> listAdBreaksCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdBreaksCallable()");
  }

  public UnaryCallable<CreateAdBreakRequest, AdBreak> createAdBreakCallable() {
    throw new UnsupportedOperationException("Not implemented: createAdBreakCallable()");
  }

  public UnaryCallable<UpdateAdBreakRequest, AdBreak> updateAdBreakCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAdBreakCallable()");
  }

  public UnaryCallable<DeleteAdBreakRequest, Empty> deleteAdBreakCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAdBreakCallable()");
  }

  @Override
  public abstract void close();
}
