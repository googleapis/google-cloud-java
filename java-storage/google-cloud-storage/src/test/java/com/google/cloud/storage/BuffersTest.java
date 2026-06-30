/*
 * Copyright 2022 Google LLC
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

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import org.junit.Test;

public final class BuffersTest {

  @Test
  public void copy() {
    SecureRandom rand = new SecureRandom();
    ByteBuffer content = DataGenerator.rand(rand).genByteBuffer(2048);

    ByteBuffer[] bufs = {
      ByteBuffer.allocate(1),
      ByteBuffer.allocate(2),
      ByteBuffer.allocate(4),
      ByteBuffer.allocate(8),
      ByteBuffer.allocate(27),
    };

    long copy = 0;
    for (long read = 0; content.hasRemaining() && (read = Buffers.copy(content, bufs)) != -1; ) {
      for (ByteBuffer buf : bufs) {
        if (!buf.hasRemaining()) {
          buf.clear();
        }
      }
      copy += read;
    }
    assertThat(copy).isEqualTo(2048);
  }

  @Test
  public void allocateAligned_nonDivisible_capacityGtAlignment() {
    ByteBuffer b1 = Buffers.allocateAligned(3, 2);
    assertThat(b1.capacity()).isEqualTo(4);
  }

  @Test
  public void allocateAligned_nonDivisible_capacityLtAlignment() {
    ByteBuffer b1 = Buffers.allocateAligned(1, 2);
    assertThat(b1.capacity()).isEqualTo(2);
  }

  @Test
  public void allocateAligned_evenlyDivisible_capacityLtAlignment() {
    ByteBuffer b1 = Buffers.allocateAligned(2, 4);
    assertThat(b1.capacity()).isEqualTo(4);
  }

  @Test
  public void allocateAligned_evenlyDivisible_capacityGtAlignment() {
    ByteBuffer b1 = Buffers.allocateAligned(8, 4);
    assertThat(b1.capacity()).isEqualTo(8);
  }
}
