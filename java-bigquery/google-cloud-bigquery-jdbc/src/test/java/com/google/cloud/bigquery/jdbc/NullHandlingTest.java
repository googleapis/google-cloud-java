/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class NullHandlingTest {

  @Test
  public void shouldReturnNullForNullByDefault() {
    assertThat(BigQueryTypeCoercer.INSTANCE.coerceTo(Integer.class, null)).isNull();
  }

  @Test
  public void shouldReturnCustomValueForNull() {
    BigQueryTypeCoercer bigQueryTypeCoercer =
        new BigQueryTypeCoercerBuilder().registerTypeCoercion(new NullToIntegerCoercion()).build();

    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, null)).isEqualTo(0);
  }

  private static class NullToIntegerCoercion implements BigQueryCoercion<Void, Integer> {
    @Override
    public Integer coerce(Void value) {
      return 0; // returning zero as the default value
    }
  }
}
