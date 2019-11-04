/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ZoneClient.ListZonesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetZoneHttpRequest;
import com.google.cloud.compute.v1.ListZonesHttpRequest;
import com.google.cloud.compute.v1.Zone;
import com.google.cloud.compute.v1.ZoneList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ZoneStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<GetZoneHttpRequest, Zone> getZoneCallable() {
    throw new UnsupportedOperationException("Not implemented: getZoneCallable()");
  }

  @BetaApi
  public UnaryCallable<ListZonesHttpRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listZonesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListZonesHttpRequest, ZoneList> listZonesCallable() {
    throw new UnsupportedOperationException("Not implemented: listZonesCallable()");
  }

  @Override
  public abstract void close();
}
