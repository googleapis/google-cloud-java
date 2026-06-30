/*
 * Copyright 2019, Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;

/** Test case for {@link IdTokenCredentials}. */
class IdTokenCredentialsTest extends BaseSerializationTest {

  @Test
  void hashCode_equals() throws IOException {
    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport.setIdToken(ComputeEngineCredentialsTest.STANDARD_ID_TOKEN);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();

    IdTokenCredentials otherCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    otherCredential.refresh();
    assertEquals(tokenCredential, tokenCredential.toBuilder().build());
    assertEquals(tokenCredential.hashCode(), otherCredential.hashCode());
  }

  @Test
  void toString_equals() throws IOException {
    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport.setIdToken(ComputeEngineCredentialsTest.STANDARD_ID_TOKEN);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();

    IdTokenCredentials otherCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    otherCredential.refresh();

    assertEquals(tokenCredential.toString(), otherCredential.toString());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {

    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport.setIdToken(ComputeEngineCredentialsTest.STANDARD_ID_TOKEN);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();
    IdTokenCredentials deserializedCredentials = serializeAndDeserialize(tokenCredential);
    assertEquals(tokenCredential, deserializedCredentials);
  }
}
