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

package com.google.cloud.datastore.aggregation;

import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.common.truth.Truth.assertThat;

import com.google.datastore.v1.AggregationQuery;
import org.junit.Test;

public class CountAggregationTest {

  @Test
  public void testCountAggregationWithDefaultValues() {
    AggregationQuery.Aggregation countAggregationPb = count().build().toPb();

    assertThat(countAggregationPb.getCount().getUpTo().getValue()).isEqualTo(0L);
    assertThat(countAggregationPb.getAlias()).isEqualTo("");
  }

  @Test
  public void testCountAggregationWithAlias() {
    AggregationQuery.Aggregation countAggregationPb = count().as("column_1").build().toPb();

    assertThat(countAggregationPb.getCount().getUpTo().getValue()).isEqualTo(0L);
    assertThat(countAggregationPb.getAlias()).isEqualTo("column_1");
  }

  @Test
  public void testEquals() {
    CountAggregation.Builder aggregationWithAlias1 = count().as("total");
    CountAggregation.Builder aggregationWithAlias2 = count().as("total");
    CountAggregation.Builder aggregationWithoutAlias1 = count();
    CountAggregation.Builder aggregationWithoutAlias2 = count();

    // same aliases
    assertThat(aggregationWithAlias1.build()).isEqualTo(aggregationWithAlias2.build());
    assertThat(aggregationWithAlias2.build()).isEqualTo(aggregationWithAlias1.build());

    // with and without aliases
    assertThat(aggregationWithAlias1.build()).isNotEqualTo(aggregationWithoutAlias1.build());
    assertThat(aggregationWithoutAlias1.build()).isNotEqualTo(aggregationWithAlias1.build());

    // no aliases
    assertThat(aggregationWithoutAlias1.build()).isEqualTo(aggregationWithoutAlias2.build());
    assertThat(aggregationWithoutAlias2.build()).isEqualTo(aggregationWithoutAlias1.build());

    // different aliases
    assertThat(aggregationWithAlias1.as("new-alias").build())
        .isNotEqualTo(aggregationWithAlias2.build());
    assertThat(aggregationWithAlias2.build())
        .isNotEqualTo(aggregationWithAlias1.as("new-alias").build());
  }
}
