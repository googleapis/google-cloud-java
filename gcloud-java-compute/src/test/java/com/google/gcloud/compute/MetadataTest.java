/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.Map;

public class MetadataTest {

  private static final Metadata METADATA = Metadata.builder()
      .add("key1", "value1")
      .add("key2", "value2")
      .build();

  @Test
  public void testToBuilder() {
    Metadata metadata = METADATA.toBuilder().fingerprint("newFingerprint").build();
    assertEquals("newFingerprint", metadata.fingerprint());
    compareMetadata(METADATA, metadata.toBuilder().fingerprint(null).build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ImmutableMap.of("key1", "value1", "key2", "value2"), METADATA.values());
    assertNull(METADATA.fingerprint());
    Metadata metadata = Metadata.builder()
        .values(ImmutableMap.of("key1", "value1", "key2", "value2"))
        .build();
    assertEquals(ImmutableMap.of("key1", "value1", "key2", "value2"), metadata.values());
    assertNull(metadata.fingerprint());
    metadata = Metadata.builder()
        .values(ImmutableMap.of("key1", "value1", "key2", "value2"))
        .fingerprint("fingerprint")
        .build();
    assertEquals(ImmutableMap.of("key1", "value1", "key2", "value2"), metadata.values());
    assertEquals("fingerprint", metadata.fingerprint());
  }

  @Test
  public void testOf() {
    Map<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
    compareMetadata(METADATA, Metadata.of(map));
  }

  @Test
  public void testToAndFromPb() {
    compareMetadata(METADATA, Metadata.fromPb(METADATA.toPb()));
    Metadata metadata = Metadata.builder()
        .values(ImmutableMap.of("key1", "value1", "key2", "value2"))
        .fingerprint("fingerprint")
        .build();
    compareMetadata(metadata, Metadata.fromPb(metadata.toPb()));
  }

  public void compareMetadata(Metadata expected, Metadata value) {
    assertEquals(expected, value);
    assertEquals(expected.fingerprint(), value.fingerprint());
    assertEquals(expected.values(), value.values());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
