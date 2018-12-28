/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CanonicalExtensionHeadersSerializerTest {

  private CanonicalExtensionHeadersSerializer serializer;

  @Before
  public void setUp() {
    serializer = new CanonicalExtensionHeadersSerializer();
  }

  @Test
  public void givenNoHeadersWhenSerializeThenProduceNothing() {

    StringBuilder sb = serializer.serialize(Collections.<String, String>emptyMap());

    assertEquals(sb.toString(), "");
  }

  @Test
  public void givenNullHeadersWhenSerializeThenProduceNothing() {

    StringBuilder sb = serializer.serialize(null);

    assertEquals(sb.toString(), "");
  }

  @Test
  public void givenEncryptionHeadersWhenSerializeThenAreRemvoed() {

    Map<String, String> encryptionHeaders = new HashMap<>();
    encryptionHeaders.put("x-goog-encryption-key", "");
    encryptionHeaders.put("x-goog-encryption-key-sha256", "");

    StringBuilder sb = serializer.serialize(encryptionHeaders);

    assertEquals(sb.toString(), "");
  }

  @Test
  public void givenHeadersWhenSerializeThenSuccess() {

    Map<String, String> encryptionHeaders = new HashMap<>();
    encryptionHeaders.put("x-goog-encryption-key", "");
    encryptionHeaders.put("x-GOOg-acl", " \n public-read ");
    encryptionHeaders.put("x-goog-encryption-key-sha256", "");
    encryptionHeaders.put("X-goog-meta-OWNER", "   myself    and   others   \n");

    StringBuilder sb = serializer.serialize(encryptionHeaders);

    assertEquals(sb.toString(), "x-goog-acl:public-read\nx-goog-meta-owner:myself and others\n");
  }
}
