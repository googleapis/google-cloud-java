/*
 * Copyright 2015, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.util.Clock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.jupiter.api.Test;

/** Unit tests for CloudShellCredentials */
class CloudShellCredentialsTest extends BaseSerializationTest {

  @Test
  void refreshAccessToken() throws IOException {
    final ServerSocket authSocket = new ServerSocket(0);
    try {
      Runnable serverTask =
          new Runnable() {
            @Override
            public void run() {
              try {
                Socket clientSocket = authSocket.accept();
                BufferedReader input =
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String lines = input.readLine();
                lines += '\n' + input.readLine();
                assertEquals(lines, CloudShellCredentials.GET_AUTH_TOKEN_REQUEST);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("32\n[\"email\", \"project-id\", \"token\"]");
              } catch (Exception reThrown) {
                throw new RuntimeException(reThrown);
              }
            }
          };
      Thread serverThread = new Thread(serverTask);
      serverThread.start();

      GoogleCredentials creds =
          CloudShellCredentials.newBuilder().setAuthPort(authSocket.getLocalPort()).build();
      assertEquals("token", creds.refreshAccessToken().getTokenValue());
    } finally {
      authSocket.close();
    }
  }

  @Test
  void equals_true() throws IOException {
    GoogleCredentials credentials = CloudShellCredentials.newBuilder().setAuthPort(42).build();
    GoogleCredentials otherCredentials = CloudShellCredentials.newBuilder().setAuthPort(42).build();
    assertTrue(credentials.equals(otherCredentials));
    assertTrue(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_authPort() throws IOException {
    GoogleCredentials credentials = CloudShellCredentials.newBuilder().setAuthPort(42).build();
    GoogleCredentials otherCredentials = CloudShellCredentials.newBuilder().setAuthPort(43).build();
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void toString_containsFields() throws IOException {
    String expectedToString = String.format("CloudShellCredentials{authPort=%d}", 42);
    GoogleCredentials credentials = CloudShellCredentials.newBuilder().setAuthPort(42).build();
    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void hashCode_equals() throws IOException {
    GoogleCredentials credentials = CloudShellCredentials.newBuilder().setAuthPort(42).build();
    GoogleCredentials otherCredentials = CloudShellCredentials.newBuilder().setAuthPort(42).build();
    assertEquals(credentials.hashCode(), otherCredentials.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    GoogleCredentials credentials = CloudShellCredentials.newBuilder().setAuthPort(42).build();
    GoogleCredentials deserializedCredentials = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
    assertSame(deserializedCredentials.clock, Clock.SYSTEM);
  }

  @Test
  void toBuilder() {
    CloudShellCredentials credentials =
        CloudShellCredentials.newBuilder()
            .setAuthPort(42)
            .setQuotaProjectId("quota-project")
            .build();

    assertEquals(42, credentials.getAuthPort());
    assertEquals("quota-project", credentials.getQuotaProjectId());

    CloudShellCredentials secondCredentials = credentials.toBuilder().build();

    assertEquals(credentials, secondCredentials);
  }
}
