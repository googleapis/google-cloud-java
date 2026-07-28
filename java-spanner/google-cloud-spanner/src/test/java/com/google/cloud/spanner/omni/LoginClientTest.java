/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.omni;

import static org.junit.Assert.assertNotNull;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoginClientTest {

  @Test
  public void testConstructor() {
    ManagedChannel channel =
        ManagedChannelBuilder.forTarget("localhost:15000").usePlaintext().build();
    LoginClient client = new LoginClient(channel);
    assertNotNull(client);
  }

  @Test
  public void testExpectedEnvelopeSize() {
    // The envelope size must match the sum of the public key, nonce, and auth tag lengths.
    // If the server changes the lengths in cl/940065095, this test will catch any mismatch.
    org.junit.Assert.assertEquals(
        "Envelope size should be 97 bytes (33 + 32 + 32)", 97, LoginClient.EXPECTED_ENVELOPE_SIZE);
  }
}
