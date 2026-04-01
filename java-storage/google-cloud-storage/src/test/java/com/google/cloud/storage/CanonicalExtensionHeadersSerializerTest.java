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

  private CanonicalExtensionHeadersSerializer v2Serializer;
  private CanonicalExtensionHeadersSerializer v4Serializer;

  @Before
  public void setUp() {
    v2Serializer =
        new CanonicalExtensionHeadersSerializer(Storage.SignUrlOption.SignatureVersion.V2);
    v4Serializer =
        new CanonicalExtensionHeadersSerializer(Storage.SignUrlOption.SignatureVersion.V4);
  }

  @Test
  public void givenNoHeadersWhenSerializeThenProduceNothing() {

    StringBuilder sb = v2Serializer.serialize(Collections.<String, String>emptyMap());

    assertEquals(sb.toString(), "");
  }

  @Test
  public void givenNullHeadersWhenSerializeThenProduceNothing() {

    StringBuilder sb = v2Serializer.serialize(null);

    assertEquals(sb.toString(), "");
  }

  @Test
  public void givenEncryptionHeadersWhenSerializeThenAreRemvoed() {

    Map<String, String> encryptionHeaders = new HashMap<>();
    encryptionHeaders.put("x-goog-encryption-key", "");
    encryptionHeaders.put("x-goog-encryption-key-sha256", "");

    StringBuilder sb = v2Serializer.serialize(encryptionHeaders);

    assertEquals(sb.toString(), "");
  }

  @Test
  public void givenHeadersWhenSerializeThenSuccess() {

    Map<String, String> encryptionHeaders = new HashMap<>();
    encryptionHeaders.put("x-goog-encryption-key", "");
    encryptionHeaders.put("x-GOOg-acl", " \n public-read ");
    encryptionHeaders.put("x-goog-encryption-key-sha256", "");
    encryptionHeaders.put("X-goog-meta-OWNER", "   myself    and   others   \n");

    StringBuilder sb = v2Serializer.serialize(encryptionHeaders);

    assertEquals(sb.toString(), "x-goog-acl:public-read\nx-goog-meta-owner:myself and others\n");
  }

  @Test
  public void testV4Serialization() {
    Map<String, String> encryptionHeaders = new HashMap<>();
    encryptionHeaders.put("x-goog-encryption-key", "key");
    encryptionHeaders.put("x-GOOg-acl", " \n public-read ");
    encryptionHeaders.put("x-goog-encryption-key-sha256", "sha");
    encryptionHeaders.put("X-goog-meta-OWNER", "   myself    and   others   \n");

    StringBuilder sb = v4Serializer.serialize(encryptionHeaders);

    assertEquals(
        "x-goog-acl:public-read\nx-goog-encryption-key:key\nx-goog-encryption-key-sha256:sha"
            + "\nx-goog-meta-owner:myself and others\n",
        sb.toString());
  }
}
