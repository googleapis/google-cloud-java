/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigquery.storage.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.storage.v1.ConnectionWorker.Load;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionWorkerTest {
  @Test
  public void testLoadCompare_compareLoad() {
    // In flight bytes bucket is split as per 1024 requests per bucket.
    // When in flight bytes is in lower bucket, even destination count is higher and request count
    // is higher, the load is still smaller.
    Load load1 = ConnectionWorker.Load.create(1000, 2000, 100, 1000, 10);
    Load load2 = ConnectionWorker.Load.create(2000, 1000, 10, 1000, 10);
    assertThat(Load.LOAD_COMPARATOR.compare(load1, load2)).isLessThan(0);

    // In flight bytes in the same bucke of request bytes will compare request count.
    Load load3 = ConnectionWorker.Load.create(1, 300, 10, 0, 10);
    Load load4 = ConnectionWorker.Load.create(10, 1, 10, 0, 10);
    assertThat(Load.LOAD_COMPARATOR.compare(load3, load4)).isGreaterThan(0);

    // In flight request and bytes in the same bucket will compare the destination count.
    Load load5 = ConnectionWorker.Load.create(200, 1, 10, 1000, 10);
    Load load6 = ConnectionWorker.Load.create(100, 10, 10, 1000, 10);
    assertThat(Load.LOAD_COMPARATOR.compare(load5, load6) == 0).isTrue();
  }

  @Test
  public void testLoadIsOverWhelmed() {
    // Only in flight request is considered in current overwhelmed calculation.
    Load load1 = ConnectionWorker.Load.create(60, 10, 100, 90, 100);
    assertThat(load1.isOverwhelmed()).isTrue();

    Load load2 = ConnectionWorker.Load.create(1, 1, 100, 100, 100);
    assertThat(load2.isOverwhelmed()).isFalse();
  }
}
