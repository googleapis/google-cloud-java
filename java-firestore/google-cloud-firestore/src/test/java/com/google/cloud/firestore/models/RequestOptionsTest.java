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

package com.google.cloud.firestore.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RequestOptionsTest {

  @Test
  public void testDefaultInstance() {
    RequestOptions options = RequestOptions.getDefaultInstance();
    assertNotNull(options);
    assertTrue(options.getTags().isEmpty());
    assertEquals(com.google.firestore.v1.RequestOptions.getDefaultInstance(), options.toProto());
  }

  @Test
  public void testBuilderWithTags() {
    List<String> tags = Arrays.asList("tag1", "tag2");
    RequestOptions options = RequestOptions.newBuilder().setTags(tags).build();
    assertEquals(tags, options.getTags());

    com.google.firestore.v1.RequestOptions proto = options.toProto();
    assertEquals(tags, proto.getRequestTagsList());
  }

  @Test
  public void testBuilderWithAddTag() {
    RequestOptions options = RequestOptions.newBuilder().addTag("tag1").addTag("tag2").build();
    assertEquals(Arrays.asList("tag1", "tag2"), options.getTags());
  }

  @Test
  public void testToBuilder() {
    RequestOptions options = RequestOptions.newBuilder().addTag("tag1").build();
    RequestOptions updated = options.toBuilder().addTag("tag2").build();
    assertEquals(Arrays.asList("tag1", "tag2"), updated.getTags());
  }

  @Test
  public void testFromProto() {
    com.google.firestore.v1.RequestOptions proto =
        com.google.firestore.v1.RequestOptions.newBuilder()
            .addAllRequestTags(Arrays.asList("tag1", "tag2"))
            .build();
    RequestOptions options = RequestOptions.fromProto(proto);
    assertEquals(Arrays.asList("tag1", "tag2"), options.getTags());
    assertEquals(proto, options.toProto());
  }

  @Test
  public void testEqualsAndHashCode() {
    RequestOptions options1 = RequestOptions.newBuilder().addTag("tag1").addTag("tag2").build();
    RequestOptions options2 =
        RequestOptions.newBuilder().setTags(Arrays.asList("tag1", "tag2")).build();
    RequestOptions options3 = RequestOptions.newBuilder().addTag("tag3").build();

    assertEquals(options1, options2);
    assertEquals(options1.hashCode(), options2.hashCode());
    assertNotEquals(options1, options3);
    assertNotEquals(options1.hashCode(), options3.hashCode());
  }

  @Test
  public void testToString() {
    RequestOptions options = RequestOptions.newBuilder().addTag("tag1").build();
    assertTrue(options.toString().contains("tag1"));
  }
}
