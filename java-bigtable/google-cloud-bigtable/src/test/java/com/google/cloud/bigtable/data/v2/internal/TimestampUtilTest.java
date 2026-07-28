/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.common.truth.Truth.assertThat;

import com.google.protobuf.Timestamp;
import java.time.Instant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TimestampUtilTest {

  @Test
  public void testToInstant() {
    assertThat(TimestampUtil.toInstant(Timestamp.getDefaultInstance()))
        .isEqualTo(Instant.ofEpochSecond(0));
    assertThat(TimestampUtil.toInstant(Timestamp.newBuilder().setSeconds(1000).build()))
        .isEqualTo(Instant.ofEpochSecond(1000));
    assertThat(
            TimestampUtil.toInstant(Timestamp.newBuilder().setSeconds(2000).setNanos(3000).build()))
        .isEqualTo(Instant.ofEpochSecond(2000, 3000));
    assertThat(TimestampUtil.toInstant(Timestamp.newBuilder().setNanos(3000).build()))
        .isEqualTo(Instant.ofEpochSecond(0, 3000));
  }
}
