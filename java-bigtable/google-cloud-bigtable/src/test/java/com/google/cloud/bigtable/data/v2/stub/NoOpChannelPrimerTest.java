/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import io.grpc.ManagedChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NoOpChannelPrimerTest {
  @Test
  public void primeChannelDoesNothing() {
    // Create an instance of NoOpChannelPrimer
    NoOpChannelPrimer primer = NoOpChannelPrimer.create();

    // Create a mock ManagedChannel
    ManagedChannel mockChannel = mock(ManagedChannel.class);

    // Call the primeChannel method
    primer.primeChannel(mockChannel);

    // Verify that no interactions occurred with the mock channel.
    // This confirms the "no-op" behavior.
    verifyNoInteractions(mockChannel);
  }
}
