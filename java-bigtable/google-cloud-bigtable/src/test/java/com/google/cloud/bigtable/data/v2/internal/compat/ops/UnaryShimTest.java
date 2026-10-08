/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import org.junit.jupiter.api.Test;

class UnaryShimTest {

  @Test
  void shouldRouteToSession_belowThreshold_returnsTrue() {
    SessionPool<?> pool = mock(SessionPool.class);
    when(pool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES - 1);

    assertThat(UnaryShim.shouldRouteToSession(pool)).isTrue();
  }

  @Test
  void shouldRouteToSession_atThresholdNoSession_returnsFalse() {
    SessionPool<?> pool = mock(SessionPool.class);
    when(pool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(pool.hasSession()).thenReturn(false);

    assertThat(UnaryShim.shouldRouteToSession(pool)).isFalse();
  }

  @Test
  void shouldRouteToSession_atThresholdButHasSession_returnsTrue() {
    SessionPool<?> pool = mock(SessionPool.class);
    when(pool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(pool.hasSession()).thenReturn(true);

    assertThat(UnaryShim.shouldRouteToSession(pool)).isTrue();
  }
}
