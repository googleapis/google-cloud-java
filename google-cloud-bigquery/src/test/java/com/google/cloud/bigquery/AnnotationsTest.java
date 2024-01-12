/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.bigquery;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.api.client.util.Data;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class AnnotationsTest {
  @Test
  public void testFromUser() {
    assertThat(Annotations.fromUser(null).userMap()).isNull();

    HashMap<String, String> user = new HashMap<>();
    assertThat(Annotations.fromUser(user).userMap()).isEmpty();

    user.put("a", "b");
    Annotations annotations = Annotations.fromUser(user);
    assertThat(annotations.userMap()).containsExactly("a", "b");

    // Changing map afterwards does not change the annotation.
    user.put("c", "d");
    assertThat(annotations.userMap()).containsExactly("a", "b");
  }

  @Test
  public void testFromToPb() {
    assertThat(Annotations.fromPb(null).toPb()).isNull();

    HashMap<String, String> pb = new HashMap<>();
    assertThat(Annotations.fromPb(pb).toPb()).isNull();

    pb.put("a", "b");
    assertThat(Annotations.fromPb(pb).toPb()).isEqualTo(pb);

    pb.put("c", Data.NULL_STRING);
    assertThat(Annotations.fromPb(pb).toPb()).isEqualTo(pb);

    Map<String, String> jsonNullMap = Data.nullOf(HashMap.class);
    assertThat(Data.isNull(Annotations.fromPb(jsonNullMap).toPb())).isTrue();
  }

  @Test
  public void testNullKey() {
    try {
      Annotations.fromUser(Collections.singletonMap((String) null, "foo"));
      fail("null key shouldn't work");
    } catch (IllegalArgumentException e) {
    }

    try {
      Annotations.fromPb(Collections.singletonMap((String) null, "foo"));
      fail("null key shouldn't work");
    } catch (IllegalArgumentException e) {
    }
  }
}
