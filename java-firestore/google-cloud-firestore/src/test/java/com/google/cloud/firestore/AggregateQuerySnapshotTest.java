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

import com.google.cloud.Timestamp;
import com.google.firestore.v1.Value;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AggregateQuerySnapshotTest {

  @Mock private Query mockQuery;
  @Mock private Query mockQuery2;

  private AggregateQuery sampleAggregateQuery;
  private AggregateQuery sampleAggregateQuery2;
  private Timestamp sampleTimestamp;
  private Timestamp sampleTimestamp2;

  private Map<String, Value> data42;
  private Map<String, Value> data24;

  @Before
  public void initializeSampleObjects() {
    sampleAggregateQuery =
        new AggregateQuery(mockQuery, Collections.singletonList(AggregateField.count()));
    sampleAggregateQuery2 =
        new AggregateQuery(mockQuery2, Collections.singletonList(AggregateField.count()));
    sampleTimestamp = Timestamp.ofTimeSecondsAndNanos(42, 42);
    sampleTimestamp2 = Timestamp.ofTimeSecondsAndNanos(24, 24);
    data42 = new HashMap<>();
    data42.put("count", Value.newBuilder().setIntegerValue(42).build());
    data24 = new HashMap<>();
    data24.put("count", Value.newBuilder().setIntegerValue(24).build());
  }

  @Test
  public void getQueryShouldReturnTheAggregateQuerySpecifiedToTheConstructor() {
    AggregateQuerySnapshot snapshot =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot.getQuery()).isSameInstanceAs(sampleAggregateQuery);
  }

  @Test
  public void getReadTimeShouldReturnTheTimestampSpecifiedToTheConstructor() {
    AggregateQuerySnapshot snapshot =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot.getReadTime()).isSameInstanceAs(sampleTimestamp);
  }

  @Test
  public void getCountShouldReturnTheCountSpecifiedToTheConstructor() {
    AggregateQuerySnapshot snapshot =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot.getCount()).isEqualTo(42);
  }

  @Test
  public void hashCodeShouldReturnSameHashCodeWhenConstructedWithSameObjects() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot1.hashCode()).isEqualTo(snapshot2.hashCode());
  }

  @Test
  public void hashCodeShouldReturnDifferentHashCodeWhenConstructedDifferentAggregateQuery() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery2, sampleTimestamp, data42);
    assertThat(snapshot1.hashCode()).isNotEqualTo(snapshot2.hashCode());
  }

  @Test
  public void hashCodeShouldReturnSameHashCodeWhenConstructedDifferentTimestamp() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp2, data42);
    assertThat(snapshot1.hashCode()).isEqualTo(snapshot2.hashCode());
  }

  @Test
  public void hashCodeShouldReturnDifferentHashCodeWhenConstructedDifferentCount() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data24);
    assertThat(snapshot1.hashCode()).isNotEqualTo(snapshot2.hashCode());
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenNull() {
    AggregateQuerySnapshot snapshot =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot.equals(null)).isFalse();
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenADifferentObject() {
    AggregateQuerySnapshot snapshot =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot.equals("Not An AggregateQuerySnapshot")).isFalse();
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenAnAggregateQuerySnapshotWithADifferentQuery() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery2, sampleTimestamp, data42);
    assertThat(snapshot1.equals(snapshot2)).isFalse();
  }

  @Test
  public void equalsShouldReturnTrueWhenGivenAnAggregateQuerySnapshotWithADifferentReadTime() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp2, data42);
    assertThat(snapshot1.equals(snapshot2)).isTrue();
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenAnAggregateQuerySnapshotWithADifferentCount() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data24);
    assertThat(snapshot1.equals(snapshot2)).isFalse();
  }

  @Test
  public void equalsShouldReturnTrueWhenGivenTheSameAggregateQuerySnapshotInstance() {
    AggregateQuerySnapshot snapshot =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot.equals(snapshot)).isTrue();
  }

  @Test
  public void
      equalsShouldReturnTrueWhenGivenAnAggregateQuerySnapshotConstructedWithTheSameArguments() {
    AggregateQuerySnapshot snapshot1 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    AggregateQuerySnapshot snapshot2 =
        new AggregateQuerySnapshot(sampleAggregateQuery, sampleTimestamp, data42);
    assertThat(snapshot1.equals(snapshot2)).isTrue();
  }
}
