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

package com.google.cloud.devicestreaming.v1.stub;

import static com.google.cloud.devicestreaming.v1.DirectAccessServiceClient.ListDeviceSessionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.devicestreaming.v1.AdbMessage;
import com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.DeviceMessage;
import com.google.cloud.devicestreaming.v1.DeviceSession;
import com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest;
import com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse;
import com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DirectAccessService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DirectAccessServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDeviceSessionRequest, DeviceSession> createDeviceSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeviceSessionCallable()");
  }

  public UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsPagedResponse>
      listDeviceSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceSessionsPagedCallable()");
  }

  public UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceSessionsCallable()");
  }

  public UnaryCallable<GetDeviceSessionRequest, DeviceSession> getDeviceSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeviceSessionCallable()");
  }

  public UnaryCallable<CancelDeviceSessionRequest, Empty> cancelDeviceSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelDeviceSessionCallable()");
  }

  public UnaryCallable<UpdateDeviceSessionRequest, DeviceSession> updateDeviceSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeviceSessionCallable()");
  }

  public BidiStreamingCallable<AdbMessage, DeviceMessage> adbConnectCallable() {
    throw new UnsupportedOperationException("Not implemented: adbConnectCallable()");
  }

  @Override
  public abstract void close();
}
