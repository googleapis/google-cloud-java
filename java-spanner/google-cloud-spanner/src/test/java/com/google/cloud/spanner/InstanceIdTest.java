/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link InstanceId}. */
@RunWith(JUnit4.class)
public class InstanceIdTest {

  @Test
  public void basic() {
    String name = "projects/test-project/instances/test-instance";
    InstanceId instance = InstanceId.of(name);
    assertThat(instance.getProject()).isEqualTo("test-project");
    assertThat(instance.getInstance()).isEqualTo("test-instance");
    assertThat(instance.getName()).isEqualTo(name);
    assertThat(InstanceId.of(name)).isEqualTo(instance);
    assertThat(InstanceId.of("test-project", "test-instance")).isEqualTo(instance);
    assertThat(InstanceId.of(name).hashCode()).isEqualTo(instance.hashCode());
  }

  @Test
  public void badName() {
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> InstanceId.of("bad name"));
    assertNotNull(e.getMessage());
  }
}
