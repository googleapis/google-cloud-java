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

package com.google.cloud.visionai.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.AcquireLeaseRequest;
import com.google.cloud.visionai.v1.Lease;
import com.google.cloud.visionai.v1.ReceiveEventsRequest;
import com.google.cloud.visionai.v1.ReceiveEventsResponse;
import com.google.cloud.visionai.v1.ReceivePacketsRequest;
import com.google.cloud.visionai.v1.ReceivePacketsResponse;
import com.google.cloud.visionai.v1.ReleaseLeaseRequest;
import com.google.cloud.visionai.v1.ReleaseLeaseResponse;
import com.google.cloud.visionai.v1.RenewLeaseRequest;
import com.google.cloud.visionai.v1.SendPacketsRequest;
import com.google.cloud.visionai.v1.SendPacketsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the StreamingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class StreamingServiceStub implements BackgroundResource {

  public BidiStreamingCallable<SendPacketsRequest, SendPacketsResponse> sendPacketsCallable() {
    throw new UnsupportedOperationException("Not implemented: sendPacketsCallable()");
  }

  public BidiStreamingCallable<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsCallable() {
    throw new UnsupportedOperationException("Not implemented: receivePacketsCallable()");
  }

  public BidiStreamingCallable<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: receiveEventsCallable()");
  }

  public UnaryCallable<AcquireLeaseRequest, Lease> acquireLeaseCallable() {
    throw new UnsupportedOperationException("Not implemented: acquireLeaseCallable()");
  }

  public UnaryCallable<RenewLeaseRequest, Lease> renewLeaseCallable() {
    throw new UnsupportedOperationException("Not implemented: renewLeaseCallable()");
  }

  public UnaryCallable<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseCallable() {
    throw new UnsupportedOperationException("Not implemented: releaseLeaseCallable()");
  }

  @Override
  public abstract void close();
}
