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

package com.google.cloud.firestore;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AggregateFieldTest {

  @Test
  public void staticCountCreatesCountAggregateField() {
    Object count = AggregateField.count();
    assertThat(count instanceof AggregateField.CountAggregateField).isTrue();
  }

  @Test
  public void staticSumCreatesSumAggregateField() {
    Object sum = AggregateField.sum("foo");
    assertThat(sum instanceof AggregateField.SumAggregateField).isTrue();
  }

  @Test
  public void staticAverageCreatesAverageAggregateField() {
    Object average = AggregateField.average("foo");
    assertThat(average instanceof AggregateField.AverageAggregateField).isTrue();
  }

  @Test
  public void setsProperFieldPathForSum() {
    AggregateField.SumAggregateField sum = AggregateField.sum("foo");
    assertThat(sum.getFieldPath().equals("foo")).isTrue();
  }

  @Test
  public void setsProperFieldPathForAverage() {
    AggregateField.AverageAggregateField average = AggregateField.average("foo");
    assertThat(average.getFieldPath().equals("foo")).isTrue();
  }

  @Test
  public void setsProperOperatorForCount() {
    AggregateField.CountAggregateField count = AggregateField.count();
    assertThat(count.getOperator().equals("count")).isTrue();
  }

  @Test
  public void setsProperOperatorForSum() {
    AggregateField.SumAggregateField sum = AggregateField.sum("foo");
    assertThat(sum.getOperator().equals("sum")).isTrue();
  }

  @Test
  public void setsProperOperatorForAverage() {
    AggregateField.AverageAggregateField average = AggregateField.average("foo");
    assertThat(average.getOperator().equals("average")).isTrue();
  }

  @Test
  public void setsProperFieldPathWithEscapeChars() {
    AggregateField.SumAggregateField sum = AggregateField.sum("has`invalid");
    assertThat(sum.getFieldPath().equals("`has\\`invalid`")).isTrue();
  }

  @Test
  public void sumSetsProperAliasWithEscapeChars() {
    AggregateField.SumAggregateField sum = AggregateField.sum("has`invalid");
    assertThat(sum.getAlias().equals("sum_`has\\`invalid`")).isTrue();
  }

  @Test
  public void averageSetsProperAliasWithEscapeChars() {
    AggregateField.AverageAggregateField average = AggregateField.average("has`invalid");
    assertThat(average.getAlias().equals("average_`has\\`invalid`")).isTrue();
  }
}
