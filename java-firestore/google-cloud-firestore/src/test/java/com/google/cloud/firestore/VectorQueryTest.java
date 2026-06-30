/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.firestore.LocalFirestoreHelper.COLLECTION_ID;
import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.findNearest;
import static com.google.cloud.firestore.LocalFirestoreHelper.query;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponseWithDone;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import com.google.api.gax.rpc.ResponseObserver;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.StructuredQuery;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VectorQueryTest {

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<RunQueryRequest> runQuery;

  @Captor private ArgumentCaptor<ResponseObserver<RunQueryResponse>> streamObserverCapture;

  private Query queryA;
  private Query queryB;

  private QueryTest.MockClock clock;

  @Before
  public void before() {
    clock = new QueryTest.MockClock();
    doReturn(clock).when(firestoreMock).getClock();

    queryA = firestoreMock.collection(COLLECTION_ID);
    queryB = firestoreMock.collection(COLLECTION_ID).whereEqualTo("foo", "bar");
  }

  @Test
  public void isEqual() {
    Query queryA = firestoreMock.collection("collectionId").whereEqualTo("foo", "bar");
    Query queryB = firestoreMock.collection("collectionId").whereEqualTo("foo", "bar");
    Query queryC = firestoreMock.collection("collectionId");

    assertEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.COSINE),
        queryB.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.COSINE));

    assertEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN),
        queryB.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN));

    assertEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceThreshold(0.125).build()),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceThreshold(0.125).build()));

    assertEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder()
                .setDistanceThreshold(0.125)
                .setDistanceResultField(FieldPath.of("foo"))
                .build()),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder()
                .setDistanceThreshold(0.125)
                .setDistanceResultField(FieldPath.of("foo"))
                .build()));

    assertEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceResultField("distance").build()),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder()
                .setDistanceResultField(FieldPath.of("distance"))
                .build()));

    assertNotEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.COSINE),
        queryC.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.COSINE));

    assertNotEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.COSINE),
        queryB.findNearest(
            "embedding", new double[] {40, 42}, 10, VectorQuery.DistanceMeasure.COSINE));

    assertNotEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.COSINE),
        queryB.findNearest(
            "embedding", new double[] {40, 41, 42}, 1000, VectorQuery.DistanceMeasure.COSINE));

    assertNotEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.COSINE),
        queryB.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN));

    assertNotEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceThreshold(0.125).build()),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceThreshold(1.125).build()));

    assertNotEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceThreshold(1.0).build()));

    assertNotEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceThreshold(1.0).build()),
        queryB.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN));

    assertNotEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceResultField("distance").build()),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceResultField("result").build()));

    assertNotEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder()
                .setDistanceResultField(FieldPath.of("distance"))
                .build()),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder()
                .setDistanceResultField(FieldPath.of("result"))
                .build()));

    assertNotEquals(
        queryA.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN),
        queryB.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceResultField("result").build()));

    assertNotEquals(
        queryA.findNearest(
            "embedding",
            new double[] {40, 41, 42},
            10,
            VectorQuery.DistanceMeasure.EUCLIDEAN,
            VectorQueryOptions.newBuilder().setDistanceResultField("distance").build()),
        queryB.findNearest(
            "embedding", new double[] {40, 41, 42}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN));
  }

  @Test
  public void validatesInputsLimit() {
    String expectedExceptionMessage = ".*Not a valid positive `limit` number.*";
    Throwable exception =
        assertThrows(
            RuntimeException.class,
            () ->
                queryA.findNearest(
                    "embedding", new double[] {10, 100}, 0, VectorQuery.DistanceMeasure.EUCLIDEAN));
    assertTrue(exception.getMessage().matches(expectedExceptionMessage));
  }

  @Test
  public void validatesInputsVectorSize() {
    String expectedExceptionMessage = ".*Not a valid vector size.*";
    Throwable exception =
        assertThrows(
            RuntimeException.class,
            () ->
                queryA.findNearest(
                    "embedding", new double[0], 10, VectorQuery.DistanceMeasure.EUCLIDEAN));
    assertTrue(exception.getMessage().matches(expectedExceptionMessage));
  }

  @Test
  public void successfulReturnWithoutOnComplete() throws Exception {
    doAnswer(
            queryResponseWithDone(
                /* callWithoutOnComplete */ true, DOCUMENT_NAME + "1", DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    VectorQuerySnapshot snapshot =
        queryA
            .findNearest("vector", new double[] {1, -9.5}, 10, VectorQuery.DistanceMeasure.COSINE)
            .get()
            .get();

    assertEquals(2, snapshot.size());
    assertEquals(false, snapshot.isEmpty());
    assertTrue((DOCUMENT_NAME + "1").endsWith(snapshot.getDocuments().get(0).getId()));
    assertTrue((DOCUMENT_NAME + "2").endsWith(snapshot.getDocuments().get(1).getId()));
    assertEquals(2, snapshot.getDocumentChanges().size());
    assertEquals(1, snapshot.getReadTime().getSeconds());
    assertEquals(2, snapshot.getReadTime().getNanos());

    assertEquals(1, runQuery.getAllValues().size());
    assertEquals(
        query(
            findNearest(
                "vector",
                new double[] {1, -9.5},
                10,
                StructuredQuery.FindNearest.DistanceMeasure.COSINE)),
        runQuery.getValue());
  }

  @Test
  public void successfulReturn() throws Exception {
    doAnswer(queryResponse(DOCUMENT_NAME + "1", DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    VectorQuerySnapshot snapshot =
        queryA
            .findNearest(
                "vector", new double[] {1, -9.5}, 10, VectorQuery.DistanceMeasure.DOT_PRODUCT)
            .get()
            .get();

    assertEquals(2, snapshot.size());
    assertEquals(false, snapshot.isEmpty());
    assertTrue((DOCUMENT_NAME + "1").endsWith(snapshot.getDocuments().get(0).getId()));
    assertTrue((DOCUMENT_NAME + "2").endsWith(snapshot.getDocuments().get(1).getId()));
    assertEquals(2, snapshot.getDocumentChanges().size());
    assertEquals(1, snapshot.getReadTime().getSeconds());
    assertEquals(2, snapshot.getReadTime().getNanos());

    assertEquals(1, runQuery.getAllValues().size());
    assertEquals(
        query(
            findNearest(
                "vector",
                new double[] {1, -9.5},
                10,
                StructuredQuery.FindNearest.DistanceMeasure.DOT_PRODUCT)),
        runQuery.getValue());
  }

  @Test
  public void handlesStreamExceptionRetryableError() {
    final boolean[] returnError = new boolean[] {true};

    doAnswer(
            invocation -> {
              if (returnError[0]) {
                returnError[0] = false;
                return queryResponse(
                        FirestoreException.forServerRejection(
                            Status.DEADLINE_EXCEEDED, "Simulated test failure"),
                        DOCUMENT_NAME + "1",
                        DOCUMENT_NAME + "2")
                    .answer(invocation);
              } else {
                return queryResponse(DOCUMENT_NAME + "3").answer(invocation);
              }
            })
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    ExecutionException e =
        assertThrows(
            ExecutionException.class,
            () ->
                queryA
                    .findNearest(
                        "vector",
                        new double[] {1, -9.5},
                        10,
                        VectorQuery.DistanceMeasure.DOT_PRODUCT)
                    .get()
                    .get());

    // Verify the requests
    List<RunQueryRequest> requests = runQuery.getAllValues();
    assertEquals(1, requests.size());

    assertTrue(requests.get(0).getStructuredQuery().hasFindNearest());

    assertEquals(e.getCause().getClass(), FirestoreException.class);
    assertTrue(e.getCause().getMessage().matches(".*Simulated test failure.*"));
  }

  @Test
  public void handlesStreamExceptionNonRetryableError() {
    final boolean[] returnError = new boolean[] {true};

    doAnswer(
            invocation -> {
              if (returnError[0]) {
                returnError[0] = false;
                return queryResponse(
                        FirestoreException.forServerRejection(
                            Status.PERMISSION_DENIED, "Simulated test failure"))
                    .answer(invocation);
              } else {
                return queryResponse(DOCUMENT_NAME + "3").answer(invocation);
              }
            })
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    ExecutionException e =
        assertThrows(
            ExecutionException.class,
            () ->
                queryA
                    .findNearest(
                        "vector",
                        new double[] {1, -9.5},
                        10,
                        VectorQuery.DistanceMeasure.DOT_PRODUCT)
                    .get()
                    .get());

    // Verify the requests
    List<RunQueryRequest> requests = runQuery.getAllValues();
    assertEquals(1, requests.size());

    assertTrue(requests.get(0).getStructuredQuery().hasFindNearest());

    assertEquals(e.getCause().getClass(), FirestoreException.class);
    assertTrue(e.getCause().getMessage().matches(".*Simulated test failure.*"));
  }

  @Test
  public void vectorQuerySnapshotEquality() throws Exception {
    final int[] count = {0};

    doAnswer(
            invocation -> {
              switch (count[0]++) {
                case 0:
                  return queryResponse(DOCUMENT_NAME + "3", DOCUMENT_NAME + "4").answer(invocation);
                case 1:
                  return queryResponse(DOCUMENT_NAME + "3", DOCUMENT_NAME + "4").answer(invocation);
                case 2:
                  return queryResponse(DOCUMENT_NAME + "3", DOCUMENT_NAME + "4").answer(invocation);
                case 3:
                  return queryResponse(DOCUMENT_NAME + "4").answer(invocation);
                default:
                  return queryResponse().answer(invocation);
              }
            })
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    VectorQuerySnapshot snapshotA =
        queryA
            .findNearest(
                "vector", new double[] {1, -9.5}, 10, VectorQuery.DistanceMeasure.DOT_PRODUCT)
            .get()
            .get();
    VectorQuerySnapshot snapshotB =
        queryA
            .findNearest(
                "vector", new double[] {1, -9.5}, 10, VectorQuery.DistanceMeasure.DOT_PRODUCT)
            .get()
            .get();
    VectorQuerySnapshot snapshotC =
        queryB
            .findNearest(
                "vector", new double[] {1, -9.5}, 10, VectorQuery.DistanceMeasure.DOT_PRODUCT)
            .get()
            .get();
    VectorQuerySnapshot snapshotD =
        queryA
            .findNearest(
                "vector", new double[] {1, -9.5}, 10, VectorQuery.DistanceMeasure.DOT_PRODUCT)
            .get()
            .get();

    assertEquals(snapshotA, snapshotB);
    assertNotEquals(snapshotA, snapshotC);
    assertNotEquals(snapshotA, snapshotD);
  }
}
