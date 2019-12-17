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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.ChannelPrimer;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import java.util.concurrent.TimeUnit;

/**
 * Establish a connection to the Cloud Bigtable service on managedChannel
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@BetaApi("This API depends on gRPC experimental API")
@InternalApi
public final class RefreshChannel implements ChannelPrimer {

  /**
   * primeChannel establishes a connection to Cloud Bigtable service. This typically take less than
   * 1s. In case of service failure, an upper limit of 10s prevents primeChannel from looping
   * forever.
   */
  @Override
  public void primeChannel(ManagedChannel managedChannel) {
    for (int i = 0; i < 10; i++) {
      ConnectivityState connectivityState = managedChannel.getState(true);
      if (connectivityState == ConnectivityState.READY) {
        break;
      }
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        break;
      }
    }
  }
}
