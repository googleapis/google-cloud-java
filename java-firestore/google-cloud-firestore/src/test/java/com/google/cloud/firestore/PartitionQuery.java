/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPage;
import com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.Value;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PartitionQuery {
  public static final String DATABASE_NAME = "projects/test-project/databases/(default)/documents";
  public static final Cursor CURSOR1 =
      Cursor.newBuilder()
          .addValues(Value.newBuilder().setReferenceValue(DATABASE_NAME + "/collection/doc1"))
          .build();
  public static final Cursor PARTITION1 = CURSOR1.toBuilder().setBefore(true).build();
  public static final Cursor CURSOR2 =
      Cursor.newBuilder()
          .addValues(Value.newBuilder().setReferenceValue(DATABASE_NAME + "/collection/doc2"))
          .build();
  public static final Cursor PARTITION2 = CURSOR2.toBuilder().setBefore(true).build();

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Mock private UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse> callable;
  @Mock private PartitionQueryPagedResponse pagedResponse;
  @Mock private PartitionQueryPage queryPage;

  @Captor private ArgumentCaptor<RunQueryRequest> runQuery;
  @Captor private ArgumentCaptor<ResponseObserver<PartitionQueryResponse>> streamObserverCapture;
  @Captor private ArgumentCaptor<PartitionQueryRequest> requestCaptor;

  @Test
  public void requestsOneLessThanDesired() throws Exception {
    int desiredPartitionsCount = 2;

    PartitionQueryRequest expectedRequest =
        PartitionQueryRequest.newBuilder()
            .setParent(DATABASE_NAME)
            .setStructuredQuery(
                StructuredQuery.newBuilder()
                    .addFrom(
                        StructuredQuery.CollectionSelector.newBuilder()
                            .setAllDescendants(true)
                            .setCollectionId("collectionId"))
                    .addOrderBy(
                        StructuredQuery.Order.newBuilder()
                            .setField(
                                StructuredQuery.FieldReference.newBuilder()
                                    .setFieldPath("__name__"))
                            .setDirection(StructuredQuery.Direction.ASCENDING)))
            .setPartitionCount(desiredPartitionsCount - 1)
            .build();

    PartitionQueryResponse response =
        PartitionQueryResponse.newBuilder().addPartitions(CURSOR1).build();

    when(pagedResponse.iterateAll()).thenReturn(ImmutableList.of(CURSOR1));
    when(queryPage.getResponse()).thenReturn(response);
    doReturn(ApiFutures.immediateFuture(pagedResponse))
        .when(firestoreMock)
        .sendRequest(
            requestCaptor.capture(),
            ArgumentMatchers
                .<UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>>any());

    firestoreMock.collectionGroup("collectionId").getPartitions(desiredPartitionsCount).get();

    PartitionQueryRequest actualRequest = requestCaptor.getValue();
    assertEquals(actualRequest, expectedRequest);
  }

  @Test
  public void doesNotIssueRpcIfOnlyASinglePartitionIsRequested() throws Exception {
    int desiredPartitionsCount = 1;

    List<QueryPartition> partitions =
        firestoreMock.collectionGroup("collectionId").getPartitions(desiredPartitionsCount).get();

    assertEquals(partitions.size(), 1);
    assertNull(partitions.get(0).getStartAt());
    assertNull(partitions.get(0).getEndBefore());
  }

  @Test
  public void validatesPartitionCount() {
    int desiredPartitionsCount = 0;
    try {
      firestoreMock.collectionGroup("collectionId").getPartitions(desiredPartitionsCount);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Desired partition count must be one or greater");
    }
  }

  @Test
  public void convertsPartitionsToQueries() throws Exception {
    int desiredPartitionsCount = 3;

    PartitionQueryResponse response =
        PartitionQueryResponse.newBuilder().addPartitions(CURSOR1).build();

    when(pagedResponse.iterateAll()).thenReturn(ImmutableList.of(CURSOR1, CURSOR2));
    when(queryPage.getResponse()).thenReturn(response);
    doReturn(ApiFutures.immediateFuture(pagedResponse))
        .when(firestoreMock)
        .sendRequest(
            requestCaptor.capture(),
            ArgumentMatchers
                .<UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>>any());

    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    List<QueryPartition> partitions =
        firestoreMock.collectionGroup("collectionId").getPartitions(desiredPartitionsCount).get();

    assertEquals(partitions.size(), 3);
    for (QueryPartition partition : partitions) {
      partition.createQuery().get();
    }

    assertEquals(runQuery.getAllValues().size(), 3);

    assertFalse(runQuery.getAllValues().get(0).getStructuredQuery().hasStartAt());
    assertEquals(runQuery.getAllValues().get(0).getStructuredQuery().getEndAt(), PARTITION1);
    assertEquals(runQuery.getAllValues().get(1).getStructuredQuery().getStartAt(), PARTITION1);
    assertEquals(runQuery.getAllValues().get(1).getStructuredQuery().getEndAt(), PARTITION2);
    assertEquals(runQuery.getAllValues().get(2).getStructuredQuery().getStartAt(), PARTITION2);
    assertFalse(runQuery.getAllValues().get(2).getStructuredQuery().hasEndAt());
  }

  @Test
  public void sortsPartitions() throws Exception {
    int desiredPartitionsCount = 3;

    PartitionQueryResponse response =
        PartitionQueryResponse.newBuilder().addPartitions(CURSOR1).build();

    when(pagedResponse.iterateAll()).thenReturn(ImmutableList.of(CURSOR2, CURSOR1));
    when(queryPage.getResponse()).thenReturn(response);
    doReturn(ApiFutures.immediateFuture(pagedResponse))
        .when(firestoreMock)
        .sendRequest(
            requestCaptor.capture(),
            ArgumentMatchers
                .<UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>>any());

    List<QueryPartition> partitions =
        firestoreMock.collectionGroup("collectionId").getPartitions(desiredPartitionsCount).get();

    assertEquals(((DocumentReference) partitions.get(0).getEndBefore()[0]).getId(), "doc1");
    assertEquals(((DocumentReference) partitions.get(1).getEndBefore()[0]).getId(), "doc2");
  }
}
