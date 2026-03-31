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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static java.time.Duration.ofSeconds;

import org.junit.Test;

public final class ThroughputTest {

  @Test
  public void a() {
    assertThat(Throughput.bytesPerSecond(1).toBps()).isEqualTo(1);
  }

  @Test
  public void b() {
    assertThat(Throughput.of(10, ofSeconds(10)).toBps()).isEqualTo(1);
  }
}
