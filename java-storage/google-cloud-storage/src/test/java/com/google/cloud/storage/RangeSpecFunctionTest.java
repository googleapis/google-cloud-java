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

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public final class RangeSpecFunctionTest {
  private static final long KiB = 1024;
  private static final long MiB = 1024 * KiB;

  @SuppressWarnings("OptionalGetWithoutIsPresent")
  @Test
  public void linearExponential_withMaxLength() {
    RangeSpecFunction e =
        RangeSpecFunction.linearExponential()
            .withInitialMaxLength(KiB)
            .withMaxLengthScalar(4.0)
            .andThen(RangeSpecFunction.maxLength(64 * MiB));

    RangeSpec apply = null;

    apply = e.apply(0, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(0, KiB));
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(4 * KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(16 * KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(64 * KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(256 * KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(MiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(4 * MiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(16 * MiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(64 * MiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(64 * MiB);
  }

  @SuppressWarnings("OptionalGetWithoutIsPresent")
  @Test
  public void linearExponential_resetsIfNotSequential_forward() {
    RangeSpecFunction e =
        RangeSpecFunction.linearExponential().withInitialMaxLength(KiB).withMaxLengthScalar(4.0);

    RangeSpec apply = null;

    apply = e.apply(0, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(0, KiB));
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(4 * KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(16 * KiB);

    apply = e.apply(apply.begin() + apply.maxLength().getAsLong() + 1, apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(4 * KiB);
  }

  @SuppressWarnings("OptionalGetWithoutIsPresent")
  @Test
  public void linearExponential_resetsIfNotSequential_backward() {
    RangeSpecFunction e =
        RangeSpecFunction.linearExponential().withInitialMaxLength(KiB).withMaxLengthScalar(4.0);

    RangeSpec apply = null;

    apply = e.apply(0, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(0, KiB));
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(4 * KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(16 * KiB);

    apply = e.apply(apply.begin() + apply.maxLength().getAsLong() - 1, apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(KiB);
    apply = e.apply(apply.begin() + apply.maxLength().getAsLong(), apply);
    assertThat(apply.maxLength().getAsLong()).isEqualTo(4 * KiB);
  }

  @Test
  public void linearExponential_resetsIfNotSequential() {
    RangeSpecFunction e =
        RangeSpecFunction.linearExponential().withInitialMaxLength(1).withMaxLengthScalar(4.0);

    RangeSpec apply = null;

    apply = e.apply(0, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(0, 1));
    apply = e.apply(1, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(1, 4));
    apply = e.apply(5, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(5, 16));

    apply = e.apply(4, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(4, 1));
    apply = e.apply(5, apply);
    assertThat(apply).isEqualTo(RangeSpec.of(5, 4));
  }
}
