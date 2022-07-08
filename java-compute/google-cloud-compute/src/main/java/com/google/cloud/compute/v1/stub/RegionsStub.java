/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetRegionRequest;
import com.google.cloud.compute.v1.ListRegionsRequest;
import com.google.cloud.compute.v1.Region;
import com.google.cloud.compute.v1.RegionList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Regions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionsStub implements BackgroundResource {

  public UnaryCallable<GetRegionRequest, Region> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<ListRegionsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionsRequest, RegionList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  @Override
  public abstract void close();
}
