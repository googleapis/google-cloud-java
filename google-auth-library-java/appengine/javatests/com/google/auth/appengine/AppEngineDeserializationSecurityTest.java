/*
 * Copyright 2026, Google Inc. All rights reserved.
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

package com.google.auth.appengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class AppEngineDeserializationSecurityTest {

  /** A class that does not implement HttpTransportFactory. */
  static class ArbitraryClass {}

  @Test
  void testArbitraryClassInstantiationPrevented() throws Exception {
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder().setScopes(Collections.singleton("scope")).build();

    // Use reflection to set appIdentityServiceClassName to ArbitraryClass
    // as the setter must be of AppIdentityService
    Field classNameField =
        AppEngineCredentials.class.getDeclaredField("appIdentityServiceClassName");
    classNameField.setAccessible(true);
    classNameField.set(credentials, ArbitraryClass.class.getName());

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(credentials);

    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);

    assertThrows(IOException.class, ois::readObject);

    bos.close();
    oos.close();
    bis.close();
    ois.close();
  }

  @Test
  void testValidServiceDeserialization() throws Exception {
    MockAppIdentityService mockService = new MockAppIdentityService();
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(Collections.singleton("scope"))
            .setAppIdentityService(mockService)
            .build();

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(credentials);
    oos.close();

    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);

    AppEngineCredentials deserialized = (AppEngineCredentials) ois.readObject();

    assertNotNull(deserialized);
    Field serviceField = AppEngineCredentials.class.getDeclaredField("appIdentityService");
    serviceField.setAccessible(true);
    Object service = serviceField.get(deserialized);
    assertEquals(MockAppIdentityService.class, service.getClass());

    bos.close();
    oos.close();
    bis.close();
    ois.close();
  }

  @Test
  void testNonExistentClassDeserialization() throws Exception {
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder().setScopes(Collections.singleton("scope")).build();

    // 2. Use reflection to set appIdentityServiceClassName to non-existent class
    Field classNameField =
        AppEngineCredentials.class.getDeclaredField("appIdentityServiceClassName");
    classNameField.setAccessible(true);
    classNameField.set(credentials, "com.google.nonexistent.Class");

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(credentials);
    oos.close();

    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);

    assertThrows(ClassNotFoundException.class, ois::readObject);

    bos.close();
    oos.close();
    bis.close();
    ois.close();
  }
}
