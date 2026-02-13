/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.datastore.aggregation.Aggregation.avg;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.datastore.v1.AggregationQuery;
import org.junit.Test;

public class AvgAggregationTest {

  @Test
  public void shouldThrowExceptionWhenPropertyReferenceIsNull() {
    assertThrows(IllegalArgumentException.class, () -> avg(null).build());
  }

  @Test
  public void testAvgAggregationWithDefaultValues() {
    AggregationQuery.Aggregation avgAggregation = avg("marks").build().toPb();

    assertThat(avgAggregation.getAvg().getProperty().getName()).isEqualTo("marks");
    assertThat(avgAggregation.getAlias()).isEqualTo("");
  }

  @Test
  public void testCountAggregationWithAlias() {
    AggregationQuery.Aggregation avgAggregation = avg("marks").as("total_marks").build().toPb();

    assertThat(avgAggregation.getAvg().getProperty().getName()).isEqualTo("marks");
    assertThat(avgAggregation.getAlias()).isEqualTo("total_marks");
  }

  @Test
  public void testEqualsWithAliasVariations() {
    AvgAggregation.Builder aggregationWithAlias1 = avg("marks").as("total");
    AvgAggregation.Builder aggregationWithAlias2 = avg("marks").as("total");
    AvgAggregation.Builder aggregationWithoutAlias1 = avg("marks");
    AvgAggregation.Builder aggregationWithoutAlias2 = avg("marks");

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

  @Test
  public void testEqualsWithPropertyReferenceVariations() {
    AvgAggregation totalMarks1 = avg("marks").build();
    AvgAggregation totalMarks2 = avg("marks").build();

    AvgAggregation totalQuantities = avg("quantity").build();

    assertThat(totalMarks1).isEqualTo(totalMarks2);
    assertThat(totalMarks2).isEqualTo(totalMarks1);

    assertThat(totalMarks1).isNotEqualTo(totalQuantities);
    assertThat(totalQuantities).isNotEqualTo(totalMarks1);
  }
}
