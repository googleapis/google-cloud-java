/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.datastore;

import static com.google.cloud.datastore.DatastoreUtils.isLocalHost;
import static com.google.cloud.datastore.DatastoreUtils.removeScheme;
import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class DatastoreUtilsTest {

  @Test
  public void testIsLocalHost() {
    assertThat(isLocalHost(null)).isFalse();
    assertThat(isLocalHost("")).isFalse();
    assertThat(isLocalHost("http://localhost:9090")).isTrue();
    assertThat(isLocalHost("https://localhost:9090")).isTrue();
    assertThat(isLocalHost("10.10.10.10:9090")).isFalse();
  }

  @Test
  public void testRemoveScheme() {
    assertThat(removeScheme("http://localhost:9090")).isEqualTo("localhost:9090");
    assertThat(removeScheme("https://localhost:9090")).isEqualTo("localhost:9090");
    assertThat(removeScheme("https://localhost:9090")).isEqualTo("localhost:9090");
    assertThat(removeScheme("Https://localhost:9090")).isEqualTo("localhost:9090");
  }
}
