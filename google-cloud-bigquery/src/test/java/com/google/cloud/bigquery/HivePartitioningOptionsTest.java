/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class HivePartitioningOptionsTest {

  private static final String MODE = "STRING";
  private static final String SOURCE_URI_PREFIX = "gs://bucket/path_to_table";
  private static final Boolean REQUIRE_PARTITION_FILTER = true;
  private static final List<String> FIELDS = Arrays.asList("FIELD1", "FIELD2");
  private static final HivePartitioningOptions HIVE_PARTITIONING_OPTIONS =
      HivePartitioningOptions.newBuilder()
          .setMode(MODE)
          .setRequirePartitionFilter(REQUIRE_PARTITION_FILTER)
          .setSourceUriPrefix(SOURCE_URI_PREFIX)
          .setFields(FIELDS)
          .build();

  @Test
  public void testToBuilder() {
    compareHivePartitioningOptions(
        HIVE_PARTITIONING_OPTIONS, HIVE_PARTITIONING_OPTIONS.toBuilder().build());
    HivePartitioningOptions options = HIVE_PARTITIONING_OPTIONS.toBuilder().setMode("AUTO").build();
    assertThat(options.getMode()).isEqualTo("AUTO");
    options = HIVE_PARTITIONING_OPTIONS.toBuilder().setMode(MODE).build();
    compareHivePartitioningOptions(HIVE_PARTITIONING_OPTIONS, options);
  }

  @Test
  public void testToBuilderIncomplete() {
    HivePartitioningOptions options = HivePartitioningOptions.newBuilder().build();
    compareHivePartitioningOptions(options, options.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertThat(HIVE_PARTITIONING_OPTIONS.getMode()).isEqualTo(MODE);
    assertThat(HIVE_PARTITIONING_OPTIONS.getRequirePartitionFilter())
        .isEqualTo(REQUIRE_PARTITION_FILTER);
    assertThat(HIVE_PARTITIONING_OPTIONS.getSourceUriPrefix()).isEqualTo(SOURCE_URI_PREFIX);
  }

  @Test
  public void testToAndFromPb() {
    compareHivePartitioningOptions(
        HIVE_PARTITIONING_OPTIONS,
        HivePartitioningOptions.fromPb(HIVE_PARTITIONING_OPTIONS.toPb()));
  }

  private void compareHivePartitioningOptions(
      HivePartitioningOptions expected, HivePartitioningOptions value) {
    assertThat(value.getMode()).isEqualTo(expected.getMode());
    assertThat(value.getRequirePartitionFilter()).isEqualTo(expected.getRequirePartitionFilter());
    assertThat(value.getSourceUriPrefix()).isEqualTo(expected.getSourceUriPrefix());
    assertThat(value.toString()).isEqualTo(expected.toString());
    assertThat(value.hashCode()).isEqualTo(expected.hashCode());
  }
}
