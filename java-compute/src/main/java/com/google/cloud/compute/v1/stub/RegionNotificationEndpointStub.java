/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.RegionNotificationEndpointClient.ListRegionNotificationEndpointsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionNotificationEndpointHttpRequest;
import com.google.cloud.compute.v1.GetRegionNotificationEndpointHttpRequest;
import com.google.cloud.compute.v1.InsertRegionNotificationEndpointHttpRequest;
import com.google.cloud.compute.v1.ListRegionNotificationEndpointsHttpRequest;
import com.google.cloud.compute.v1.NotificationEndpoint;
import com.google.cloud.compute.v1.NotificationEndpointList;
import com.google.cloud.compute.v1.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionNotificationEndpointStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionNotificationEndpointHttpRequest, Operation>
      deleteRegionNotificationEndpointCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegionNotificationEndpointCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
      getRegionNotificationEndpointCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getRegionNotificationEndpointCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionNotificationEndpointHttpRequest, Operation>
      insertRegionNotificationEndpointCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertRegionNotificationEndpointCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListRegionNotificationEndpointsHttpRequest, ListRegionNotificationEndpointsPagedResponse>
      listRegionNotificationEndpointsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionNotificationEndpointsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>
      listRegionNotificationEndpointsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionNotificationEndpointsCallable()");
  }

  @Override
  public abstract void close();
}
