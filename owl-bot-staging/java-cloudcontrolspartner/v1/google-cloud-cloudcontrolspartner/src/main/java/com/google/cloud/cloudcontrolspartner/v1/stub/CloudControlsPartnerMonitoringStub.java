/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1.stub;

import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerMonitoringClient.ListViolationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1.GetViolationRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListViolationsRequest;
import com.google.cloud.cloudcontrolspartner.v1.ListViolationsResponse;
import com.google.cloud.cloudcontrolspartner.v1.Violation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudControlsPartnerMonitoring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudControlsPartnerMonitoringStub implements BackgroundResource {

  public UnaryCallable<ListViolationsRequest, ListViolationsPagedResponse>
      listViolationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listViolationsPagedCallable()");
  }

  public UnaryCallable<ListViolationsRequest, ListViolationsResponse> listViolationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listViolationsCallable()");
  }

  public UnaryCallable<GetViolationRequest, Violation> getViolationCallable() {
    throw new UnsupportedOperationException("Not implemented: getViolationCallable()");
  }

  @Override
  public abstract void close();
}
