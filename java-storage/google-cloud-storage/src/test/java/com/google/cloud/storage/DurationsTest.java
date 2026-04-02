/*
 * Copyright 2024 Google LLC
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
import static java.time.Duration.ZERO;

import java.time.Duration;
import org.junit.Test;

public final class DurationsTest {

  private static final Duration ONE_SECOND = Duration.ofSeconds(1);
  private static final Duration TWO_SECONDS = Duration.ofSeconds(2);

  @Test
  public void eq() throws Exception {
    assertAll(
        () -> assertThat(Durations.eq(ZERO, ZERO)).isTrue(),
        () -> assertThat(Durations.eq(ONE_SECOND, ONE_SECOND)).isTrue(),
        () -> assertThat(Durations.eq(ZERO, ONE_SECOND)).isFalse(),
        () -> assertThat(Durations.eq(ONE_SECOND, ZERO)).isFalse());
  }

  @Test
  public void ltEq() throws Exception {
    assertAll(
        () -> assertThat(Durations.ltEq(ZERO, ZERO)).isTrue(),
        () -> assertThat(Durations.ltEq(ONE_SECOND, ONE_SECOND)).isTrue(),
        () -> assertThat(Durations.ltEq(ZERO, ONE_SECOND)).isTrue(),
        () -> assertThat(Durations.ltEq(ONE_SECOND, ZERO)).isFalse());
  }

  @Test
  public void gtEq() throws Exception {
    assertAll(
        () -> assertThat(Durations.gtEq(ZERO, ZERO)).isTrue(),
        () -> assertThat(Durations.gtEq(ONE_SECOND, ONE_SECOND)).isTrue(),
        () -> assertThat(Durations.gtEq(ZERO, ONE_SECOND)).isFalse(),
        () -> assertThat(Durations.gtEq(ONE_SECOND, ZERO)).isTrue());
  }

  @Test
  public void gt() throws Exception {
    assertAll(
        () -> assertThat(Durations.gt(ZERO, ZERO)).isFalse(),
        () -> assertThat(Durations.gt(ONE_SECOND, ONE_SECOND)).isFalse(),
        () -> assertThat(Durations.gt(ZERO, ONE_SECOND)).isFalse(),
        () -> assertThat(Durations.gt(ONE_SECOND, ZERO)).isTrue());
  }

  @Test
  public void min() throws Exception {
    assertAll(
        () -> assertThat(Durations.min(ZERO, ZERO)).isEqualTo(ZERO),
        () -> assertThat(Durations.min(ONE_SECOND, ONE_SECOND)).isEqualTo(ONE_SECOND),
        () -> assertThat(Durations.min(ZERO, ONE_SECOND)).isEqualTo(ZERO),
        () -> assertThat(Durations.min(ONE_SECOND, ZERO)).isEqualTo(ZERO),
        () -> assertThat(Durations.min(ONE_SECOND, TWO_SECONDS, ZERO)).isEqualTo(ZERO));
  }
}
