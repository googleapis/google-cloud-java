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

package com.google.cloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

public class TagsTest {

  private static final Tags TAGS = Tags.of("tag1", "tag2");

  @Test
  public void testToBuilder() {
    Tags tags = TAGS.toBuilder().values("tag1").build();
    assertEquals(ImmutableList.of("tag1"), tags.values());
    compareTags(TAGS, tags.toBuilder().values("tag1", "tag2").build());
  }

  @Test
  public void testBuilder() {
    Tags tags = Tags.builder().values(ImmutableList.of("tag1", "tag2")).build();
    assertEquals(ImmutableList.of("tag1", "tag2"), tags.values());
    assertNull(tags.fingerprint());
    tags = Tags.builder().add("tag1").add("tag2").build();
    assertEquals(ImmutableList.of("tag1", "tag2"), tags.values());
    assertNull(tags.fingerprint());
    tags = Tags.builder().add("tag1").add("tag2").fingerprint("fingerprint").build();
    assertEquals(ImmutableList.of("tag1", "tag2"), tags.values());
    assertEquals("fingerprint", tags.fingerprint());
  }

  @Test
  public void testOf() {
    compareTags(TAGS, Tags.of("tag1", "tag2"));
    compareTags(TAGS, Tags.of(ImmutableList.of("tag1", "tag2")));
  }

  @Test
  public void testToAndFromPb() {
    compareTags(TAGS, Tags.fromPb(TAGS.toPb()));
    Tags tags = Tags.builder().add("tag1").add("tag2").fingerprint("fingerprint").build();
    compareTags(tags, Tags.fromPb(tags.toPb()));
  }

  public void compareTags(Tags expected, Tags value) {
    assertEquals(expected, value);
    assertEquals(expected.fingerprint(), value.fingerprint());
    assertEquals(expected.values(), value.values());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
