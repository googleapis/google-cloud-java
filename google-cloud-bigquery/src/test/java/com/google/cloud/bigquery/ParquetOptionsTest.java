/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParquetOptionsTest {

  private static final ParquetOptions OPTIONS =
      ParquetOptions.newBuilder().setEnableListInference(true).setEnumAsString(true).build();

  @Test
  public void testToBuilder() {
    compareParquetOptions(OPTIONS, OPTIONS.toBuilder().build());
    ParquetOptions parquetOptions = OPTIONS.toBuilder().setEnableListInference(true).build();
    assertEquals(true, parquetOptions.getEnableListInference());
    parquetOptions = parquetOptions.toBuilder().setEnumAsString(true).build();
    compareParquetOptions(OPTIONS, parquetOptions);
  }

  @Test
  public void testToBuilderIncomplete() {
    ParquetOptions parquetOptions =
        ParquetOptions.newBuilder().setEnableListInference(true).build();
    assertEquals(parquetOptions, parquetOptions.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(FormatOptions.PARQUET, OPTIONS.getType());
    assertEquals(true, OPTIONS.getEnableListInference());
    assertEquals(true, OPTIONS.getEnumAsString());
  }

  @Test
  public void testToAndFromPb() {
    compareParquetOptions(OPTIONS, ParquetOptions.fromPb(OPTIONS.toPb()));
    ParquetOptions parquetOptions =
        ParquetOptions.newBuilder().setEnableListInference(true).build();
    compareParquetOptions(parquetOptions, ParquetOptions.fromPb(parquetOptions.toPb()));
  }

  private void compareParquetOptions(ParquetOptions expected, ParquetOptions actual) {
    assertThat(expected).isEqualTo(actual);
    assertThat(expected.getEnableListInference()).isEqualTo(actual.getEnableListInference());
    assertThat(expected.getEnumAsString()).isEqualTo(actual.getEnumAsString());
    assertThat(expected.hashCode()).isEqualTo(actual.hashCode());
    assertThat(expected.toString()).isEqualTo(actual.toString());
  }
}
