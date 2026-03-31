/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.storage.v2.Object;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public final class ObjectReadSessionLifeCycleTest {

  @Test
  public void seekableChannel_closeOnlyExecutesOnce() throws Exception {

    AtomicInteger sessionCloseCount = new AtomicInteger(0);
    AtomicInteger closeAlongCount = new AtomicInteger(0);

    ObjectReadSession session =
        new ObjectReadSession() {
          @Override
          public Object getResource() {
            return Object.getDefaultInstance();
          }

          @Override
          public <Projection> Projection readAs(ReadProjectionConfig<Projection> config) {
            return null;
          }

          @Override
          public void close() throws IOException {
            sessionCloseCount.getAndIncrement();
          }
        };
    ObjectReadSessionSeekableByteChannel channel =
        new ObjectReadSessionSeekableByteChannel(
            session,
            ReadAsSeekableChannel.INSTANCE,
            session.andThen(closeAlongCount::getAndIncrement));

    channel.close();
    channel.close();
    channel.close();

    assertAll(
        () -> assertThat(sessionCloseCount.get()).isEqualTo(1),
        () -> assertThat(closeAlongCount.get()).isEqualTo(1));
  }
}
