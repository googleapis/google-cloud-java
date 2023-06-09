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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckConfigsPagedResponse;
import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckIpsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.DeleteUptimeCheckConfigRequest;
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UptimeCheckService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class UptimeCheckServiceStub implements BackgroundResource {

  public UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUptimeCheckConfigsPagedCallable()");
  }

  public UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
      listUptimeCheckConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUptimeCheckConfigsCallable()");
  }

  public UnaryCallable<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getUptimeCheckConfigCallable()");
  }

  public UnaryCallable<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createUptimeCheckConfigCallable()");
  }

  public UnaryCallable<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUptimeCheckConfigCallable()");
  }

  public UnaryCallable<DeleteUptimeCheckConfigRequest, Empty> deleteUptimeCheckConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUptimeCheckConfigCallable()");
  }

  public UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUptimeCheckIpsPagedCallable()");
  }

  public UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
      listUptimeCheckIpsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUptimeCheckIpsCallable()");
  }

  @Override
  public abstract void close();
}
