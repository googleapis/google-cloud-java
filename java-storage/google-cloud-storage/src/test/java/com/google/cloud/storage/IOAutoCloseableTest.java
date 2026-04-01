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
import static com.google.common.truth.Truth.assertWithMessage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class IOAutoCloseableTest {

  @Test
  public void andThenCorrectlyOrdered() throws Exception {

    AtomicInteger counter = new AtomicInteger(1);

    TestIOAutoClosable t1 = TestIOAutoClosable.of(counter);
    TestIOAutoClosable t2 = TestIOAutoClosable.of(counter);
    TestIOAutoClosable t3 = TestIOAutoClosable.of(counter);

    final IOAutoCloseable then = t1.andThen(t2).andThen(t3);

    then.close();

    assertAll(
        () -> assertWithMessage("t1.closeValue").that(t1.closeValue).isEqualTo(1),
        () -> assertWithMessage("t2.closeValue").that(t2.closeValue).isEqualTo(2),
        () -> assertWithMessage("t3.closeValue").that(t3.closeValue).isEqualTo(3));
  }

  static final class TestIOAutoClosable implements IOAutoCloseable {
    private final AtomicInteger counter;
    private long closeValue;

    private TestIOAutoClosable(AtomicInteger counter) {
      this.counter = counter;
    }

    @Override
    public void close() throws IOException {
      if (closeValue == 0) {
        closeValue = counter.getAndIncrement();
      }
    }

    private static TestIOAutoClosable of(AtomicInteger counter) {
      return new TestIOAutoClosable(counter);
    }
  }
}
