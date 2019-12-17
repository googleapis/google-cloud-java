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

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class RefreshChannelTest {
  // RefreshChannel should establish connection to the server through managedChannel.getState(true)
  @Test
  public void testGetStateIsCalled() {
    RefreshChannel refreshChannel = new RefreshChannel();
    ManagedChannel managedChannel = Mockito.mock(ManagedChannel.class);

    Mockito.doReturn(ConnectivityState.READY).when(managedChannel).getState(true);

    refreshChannel.primeChannel(managedChannel);
    Mockito.verify(managedChannel, Mockito.atLeastOnce()).getState(true);
  }
}
