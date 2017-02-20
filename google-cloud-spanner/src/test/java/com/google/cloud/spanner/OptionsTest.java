/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link Options}. */
@RunWith(JUnit4.class)
public class OptionsTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void negativeLimitsNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.limit(-1);
  }

  @Test
  public void zeroLimitNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.limit(0);
  }

  @Test
  public void negativePrefetchChunksNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.prefetchChunks(-1);
  }

  @Test
  public void zeroPrefetchChunksNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.prefetchChunks(0);
  }

  @Test
  public void allOptionsPresent() {
    Options options = Options.fromReadOptions(Options.limit(10), Options.prefetchChunks(1));
    assertThat(options.hasLimit()).isTrue();
    assertThat(options.limit()).isEqualTo(10);
    assertThat(options.hasPrefetchChunks()).isTrue();
    assertThat(options.prefetchChunks()).isEqualTo(1);
  }

  @Test
  public void allOptionsAbsent() {
    Options options = Options.fromReadOptions();
    assertThat(options.hasLimit()).isFalse();
    assertThat(options.hasPrefetchChunks()).isFalse();
  }
}
