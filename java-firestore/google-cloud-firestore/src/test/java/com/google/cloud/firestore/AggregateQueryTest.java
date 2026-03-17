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

import static com.google.cloud.firestore.AggregateField.average;
import static com.google.cloud.firestore.AggregateField.count;
import static com.google.cloud.firestore.AggregateField.sum;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.StructuredQuery;
import java.util.List;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AggregateQueryTest {

  private final FirestoreRpc firestoreRpc = Mockito.mock(FirestoreRpc.class);

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(), firestoreRpc);

  @Captor private ArgumentCaptor<RunAggregationQueryRequest> runQuery;

  private Query mockQuery;
  private Query mockQuery2;

  @org.junit.Before
  public void before() {
    mockQuery = firestoreMock.collection("coll");
    mockQuery2 = firestoreMock.collection("coll2");
  }

  @Test
  public void getQueryShouldReturnTheQuerySpecifiedToTheConstructor() {
    AggregateQuery aggregateQuery = new AggregateQuery(mockQuery, singletonList(count()));
    assertThat(aggregateQuery.getQuery()).isSameInstanceAs(mockQuery);
  }

  @Test
  public void hashCodeShouldReturnHashCodeOfUnderlyingQueryAndAggregateFieldList() {
    List<AggregateField> list = asList(count(), sum("foo"), average("bar"));
    AggregateQuery aggregateQuery = new AggregateQuery(mockQuery, list);
    assertThat(aggregateQuery.hashCode()).isEqualTo(Objects.hash(mockQuery, list));
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenNull() {
    AggregateQuery aggregateQuery =
        new AggregateQuery(mockQuery, asList(count(), sum("foo"), average("bar")));
    assertThat(aggregateQuery.equals(null)).isFalse();
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenADifferentObject() {
    AggregateQuery aggregateQuery =
        new AggregateQuery(mockQuery, asList(count(), sum("foo"), average("bar")));
    assertThat(aggregateQuery.equals("Not An AggregateQuery")).isFalse();
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenAnAggregateQueryWithADifferentQuery() {
    AggregateQuery aggregateQuery1 = new AggregateQuery(mockQuery, singletonList(count()));
    AggregateQuery aggregateQuery2 = new AggregateQuery(mockQuery2, singletonList(count()));
    assertThat(aggregateQuery1.equals(aggregateQuery2)).isFalse();
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenAnAggregateQueryWithDifferentAggregations() {
    AggregateQuery aggregateQuery1 = new AggregateQuery(mockQuery, singletonList(count()));
    AggregateQuery aggregateQuery2 = new AggregateQuery(mockQuery, singletonList(sum("foo")));
    assertThat(aggregateQuery1.equals(aggregateQuery2)).isFalse();
  }

  @Test
  public void equalsShouldReturnFalseWhenGivenAnAggregateQueryWithDifferentAggregationOrder() {
    AggregateQuery aggregateQuery1 =
        new AggregateQuery(mockQuery, asList(sum("foo"), average("bar")));
    AggregateQuery aggregateQuery2 =
        new AggregateQuery(mockQuery, asList(average("bar"), sum("foo")));
    assertThat(aggregateQuery1.equals(aggregateQuery2)).isFalse();
  }

  @Test
  public void equalsShouldReturnTrueWhenGivenTheSameAggregateQueryInstance() {
    AggregateQuery aggregateQuery = new AggregateQuery(mockQuery, singletonList(count()));
    assertThat(aggregateQuery.equals(aggregateQuery)).isTrue();
  }

  @Test
  public void equalsShouldReturnTrueWhenGivenAnAggregateQueryWithTheSameQuery() {
    AggregateQuery aggregateQuery1 = new AggregateQuery(mockQuery, singletonList(count()));
    AggregateQuery aggregateQuery2 = new AggregateQuery(mockQuery, singletonList(count()));
    assertThat(aggregateQuery1.equals(aggregateQuery2)).isTrue();
  }

  @Test
  public void equalsShouldReturnTrueWhenGivenMultipleAggregationsWithTheSameQuery() {
    AggregateQuery aggregateQuery1 =
        new AggregateQuery(mockQuery, asList(count(), sum("foo"), average("bar")));
    AggregateQuery aggregateQuery2 =
        new AggregateQuery(mockQuery, asList(count(), sum("foo"), average("bar")));
    assertThat(aggregateQuery1.equals(aggregateQuery2)).isTrue();
  }

  @Test
  public void toProtoFromProtoRoundTripShouldProduceEqualAggregateQueryObjects() {
    FirestoreImpl firestore =
        new FirestoreImpl(
            FirestoreOptions.newBuilder().setProjectId("test-project").build(),
            mock(FirestoreRpc.class));
    Query query1 = firestore.collection("abc");
    Query query2 = firestore.collection("def").whereEqualTo("age", 42).limit(5000).orderBy("name");
    AggregateQuery countQuery1 = query1.count();
    AggregateQuery countQuery2 = query2.count();
    AggregateQuery countQuery1Recreated =
        AggregateQuery.fromProto(firestore, countQuery1.toProto());
    AggregateQuery countQuery2Recreated =
        AggregateQuery.fromProto(firestore, countQuery2.toProto());
    assertThat(countQuery1).isNotSameInstanceAs(countQuery1Recreated);
    assertThat(countQuery2).isNotSameInstanceAs(countQuery2Recreated);
    assertThat(countQuery1).isEqualTo(countQuery1Recreated);
    assertThat(countQuery2).isEqualTo(countQuery2Recreated);
    assertThat(countQuery1).isNotEqualTo(countQuery2);
  }

  @Test
  public void withAlwaysUseImplicitOrderBy() throws Exception {
    doAnswer(
            invocation -> {
              com.google.api.gax.rpc.ResponseObserver<
                      com.google.firestore.v1.RunAggregationQueryResponse>
                  observer = invocation.getArgument(1);
              observer.onResponse(
                  com.google.firestore.v1.RunAggregationQueryResponse.newBuilder()
                      .setResult(
                          com.google.firestore.v1.AggregationResult.newBuilder()
                              .putAggregateFields(
                                  "aggregate_0",
                                  com.google.firestore.v1.Value.newBuilder()
                                      .setIntegerValue(1)
                                      .build()))
                      .build());
              observer.onComplete();
              return null;
            })
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), any(), any());

    doReturn(
            FirestoreOptions.newBuilder()
                .setProjectId("test-project")
                .setAlwaysUseImplicitOrderBy(true)
                .build())
        .when(firestoreMock)
        .getOptions();

    mockQuery.whereGreaterThan("a", "b").count().get().get();

    RunAggregationQueryRequest queryRequest = runQuery.getValue();
    StructuredQuery query = queryRequest.getStructuredAggregationQuery().getStructuredQuery();

    assertThat(query.getOrderByCount()).isEqualTo(2);
    assertThat(query.getOrderBy(0).getField().getFieldPath()).isEqualTo("a");
    assertThat(query.getOrderBy(1).getField().getFieldPath()).isEqualTo("__name__");
  }
}
