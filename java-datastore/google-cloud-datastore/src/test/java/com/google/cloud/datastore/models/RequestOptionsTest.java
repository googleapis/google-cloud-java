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

package com.google.cloud.datastore.models;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.common.collect.ImmutableList;
import com.google.common.testing.EqualsTester;
import java.util.Arrays;
import org.junit.Test;

public class RequestOptionsTest {

  @Test
  public void testDefaultInstance() {
    RequestOptions options = RequestOptions.getDefaultInstance();

    assertThat(options.getRequestTags()).isEmpty();
    assertThat(options.toPb())
        .isEqualTo(com.google.datastore.v1.RequestOptions.getDefaultInstance());
  }

  @Test
  public void testBuilder() {
    RequestOptions options =
        RequestOptions.newBuilder()
            .setRequestTags(Arrays.asList("tag1", "tag2", "tag3"))
            .build();

    assertThat(options.getRequestTags()).containsExactly("tag1", "tag2", "tag3").inOrder();
    assertThat(options.toPb())
        .isEqualTo(
            com.google.datastore.v1.RequestOptions.newBuilder()
                .addRequestTags("tag1")
                .addRequestTags("tag2")
                .addRequestTags("tag3")
                .build());
  }

  @Test
  public void testNullChecks() {
    assertThrows(
        NullPointerException.class, () -> RequestOptions.newBuilder().setRequestTags(null));
  }

  @Test
  public void testEqualsAndHashCode() {
    RequestOptions options1 =
        RequestOptions.newBuilder().setRequestTags(ImmutableList.of("tag1")).build();
    RequestOptions options2 =
        RequestOptions.newBuilder().setRequestTags(ImmutableList.of("tag1")).build();
    RequestOptions options3 =
        RequestOptions.newBuilder().setRequestTags(ImmutableList.of("tag2")).build();
    RequestOptions defaultOptions = RequestOptions.getDefaultInstance();

    new EqualsTester()
        .addEqualityGroup(options1, options2)
        .addEqualityGroup(options3)
        .addEqualityGroup(defaultOptions, RequestOptions.newBuilder().build())
        .testEquals();
  }
}
