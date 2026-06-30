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

import static com.google.cloud.storage.Maths.sub;
import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

@SuppressWarnings("ConstantConditions")
public final class MathsTest {

  @Test
  public void sub_bothNull() {
    assertThat(sub((Long) null, null)).isNull();
  }

  @Test
  public void sub_lNull_rNonNull() {
    assertThat(sub(null, 3L)).isNull();
  }

  @Test
  public void sub_lNonNull_rNull() {
    assertThat(sub(3L, null)).isEqualTo(3L);
  }

  @Test
  public void sub_bothNonNull() {
    assertThat(sub(5L, 3L)).isEqualTo(2L);
  }
}
