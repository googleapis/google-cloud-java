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

import static com.google.ads.admanager.v1.CreativeSetServiceClient.ListCreativeSetsPagedResponse;

import com.google.ads.admanager.v1.CreateCreativeSetRequest;
import com.google.ads.admanager.v1.CreativeSet;
import com.google.ads.admanager.v1.GetCreativeSetRequest;
import com.google.ads.admanager.v1.ListCreativeSetsRequest;
import com.google.ads.admanager.v1.ListCreativeSetsResponse;
import com.google.ads.admanager.v1.UpdateCreativeSetRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CreativeSetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class CreativeSetServiceStub implements BackgroundResource {

  public UnaryCallable<GetCreativeSetRequest, CreativeSet> getCreativeSetCallable() {
    throw new UnsupportedOperationException("Not implemented: getCreativeSetCallable()");
  }

  public UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsPagedResponse>
      listCreativeSetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCreativeSetsPagedCallable()");
  }

  public UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsResponse>
      listCreativeSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCreativeSetsCallable()");
  }

  public UnaryCallable<CreateCreativeSetRequest, CreativeSet> createCreativeSetCallable() {
    throw new UnsupportedOperationException("Not implemented: createCreativeSetCallable()");
  }

  public UnaryCallable<UpdateCreativeSetRequest, CreativeSet> updateCreativeSetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCreativeSetCallable()");
  }

  @Override
  public abstract void close();
}
