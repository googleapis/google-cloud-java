/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.firestore.it;

import static com.google.cloud.firestore.LocalFirestoreHelper.autoId;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.it.TestHelper.await;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.*;

import com.google.cloud.firestore.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITQueryFindNearestTest extends ITBaseTest {
  static String testId = autoId();

  @Rule public TestName testName = new TestName();

  private String getUniqueTestId() {
    return testId + "-" + testName.getMethodName();
  }

  private CollectionReference testCollection() {
    String collectionPath = "index-test-collection";
    return firestore.collection(collectionPath);
  }

  private CollectionReference testCollectionWithDocs(Map<String, Map<String, Object>> docs)
      throws InterruptedException {
    CollectionReference collection = testCollection();
    CollectionReference writer = firestore.collection(collection.getId());
    writeAllDocs(writer, docs);
    return collection;
  }

  private String getUniqueDocId(String docId) {
    return testId + docId;
  }

  public void writeAllDocs(CollectionReference collection, Map<String, Map<String, Object>> docs)
      throws InterruptedException {
    for (Map.Entry<String, Map<String, Object>> doc : docs.entrySet()) {
      Map<String, Object> data = doc.getValue();
      data.put("testId", getUniqueTestId());
      data.put("docId", getUniqueDocId(doc.getKey()));
      await(collection.add(data));
    }
  }

  @Test
  public void findNearestWithEuclideanDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a", map("foo", "bar"),
                "b", map("foo", "xxx", "embedding", FieldValue.vector(new double[] {10, 10})),
                "c", map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 1})),
                "d", map("foo", "bar", "embedding", FieldValue.vector(new double[] {10, 0})),
                "e", map("foo", "bar", "embedding", FieldValue.vector(new double[] {20, 0})),
                "f", map("foo", "bar", "embedding", FieldValue.vector(new double[] {100, 100}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {10, 10}, 3, VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("d"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("c"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("e"));
  }

  @Test
  public void findNearestWithEuclideanDistanceFirestoreTypeOverride() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a", map("foo", "bar"),
                "b", map("foo", "xxx", "embedding", FieldValue.vector(new double[] {10, 10})),
                "c", map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 1})),
                "d", map("foo", "bar", "embedding", FieldValue.vector(new double[] {10, 0})),
                "e", map("foo", "bar", "embedding", FieldValue.vector(new double[] {20, 0})),
                "f", map("foo", "bar", "embedding", FieldValue.vector(new double[] {100, 100}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                FieldPath.of("embedding"),
                FieldValue.vector(new double[] {10, 10}),
                3,
                VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("d"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("c"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("e"));
  }

  @Test
  public void findNearestWithCosineDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a",
                map("foo", "bar"),
                "b",
                map("foo", "xxx", "embedding", FieldValue.vector(new double[] {10, 10})),
                "c",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 1})),
                "d",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {20, 0})),
                "e",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {10, 0})),
                "f",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {100, 100}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest("embedding", new double[] {10, 10}, 3, VectorQuery.DistanceMeasure.COSINE);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertTrue(
        Arrays.asList(getUniqueDocId("f"), getUniqueDocId("c"))
            .contains(snapshot.getDocuments().get(0).get("docId")));
    assertTrue(
        Arrays.asList(getUniqueDocId("f"), getUniqueDocId("c"))
            .contains(snapshot.getDocuments().get(1).get("docId")));
    assertTrue(
        Arrays.asList(getUniqueDocId("d"), getUniqueDocId("e"))
            .contains(snapshot.getDocuments().get(2).get("docId")));
  }

  @Test
  public void findNearestWithDotProductDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a",
                map("foo", "bar"),
                "b",
                map("foo", "xxx", "embedding", FieldValue.vector(new double[] {10, 10})),
                "c",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 1})),
                "d",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {10, 0})),
                "e",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {20, 0})),
                "f",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {100, 100}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {10, 10}, 3, VectorQuery.DistanceMeasure.DOT_PRODUCT);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("f"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("e"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("d"));
  }

  @Test
  public void findNearestSkipsFieldsOfWrongTypes() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a",
                map("foo", "bar"),
                "b",
                map("foo", "bar", "embedding", Arrays.asList(10.0, 10.0)),
                "c",
                map("foo", "bar", "embedding", "not actually a vector"),
                "d",
                map("foo", "bar", "embedding", null),
                "e",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {9, 9})),
                "f",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {50, 50})),
                "g",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {100, 100}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {10, 10}, 100, VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("e"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("f"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("g"));
  }

  @Test
  public void findNearestIgnoresMismatchingDimensions() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a",
                map("foo", "bar"),
                "b",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {10})),
                "c",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {9, 9})),
                "d",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {50, 50}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {10, 10}, 3, VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("c"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("d"));
  }

  @Test
  public void findNearestOnNonExistentField() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a",
                map("foo", "bar"),
                "b",
                map("foo", "bar", "otherField", Arrays.asList(10.0, 10.0)),
                "c",
                map("foo", "bar", "otherField", "not actually a vector"),
                "d",
                map("foo", "bar", "otherField", null)));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {10, 10}, 3, VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(0);
  }

  @Test
  public void findNearestOnVectorNestedInAMap() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a",
                map("nested", map("foo", "bar")),
                "b",
                map(
                    "nested",
                    map("foo", "xxx", "embedding", FieldValue.vector(new double[] {10, 10}))),
                "c",
                map(
                    "nested",
                    map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 1}))),
                "d",
                map(
                    "nested",
                    map("foo", "bar", "embedding", FieldValue.vector(new double[] {10, 0}))),
                "e",
                map(
                    "nested",
                    map("foo", "bar", "embedding", FieldValue.vector(new double[] {20, 0}))),
                "f",
                map(
                    "nested",
                    map("foo", "bar", "embedding", FieldValue.vector(new double[] {100, 100})))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "nested.embedding",
                new double[] {10, 10},
                3,
                VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("b"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("d"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("c"));
  }

  @Test
  public void findNearestWithSelectToExcludeVectorDataInResponse() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a",
                map("foo", 1),
                "b",
                map("foo", 2, "embedding", FieldValue.vector(new double[] {10, 10})),
                "c",
                map("foo", 3, "embedding", FieldValue.vector(new double[] {1, 1})),
                "d",
                map("foo", 4, "embedding", FieldValue.vector(new double[] {10, 0})),
                "e",
                map("foo", 5, "embedding", FieldValue.vector(new double[] {20, 0})),
                "f",
                map("foo", 6, "embedding", FieldValue.vector(new double[] {100, 100}))));

    VectorQuery vectorQuery =
        collection
            .whereIn("foo", Arrays.asList(1, 2, 3, 4, 5, 6))
            .whereEqualTo("testId", getUniqueTestId())
            .select("foo", "docId")
            .findNearest(
                "embedding", new double[] {10, 10}, 10, VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(5);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("b"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("d"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("c"));
    assertThat(snapshot.getDocuments().get(3).get("docId")).isEqualTo(getUniqueDocId("e"));
    assertThat(snapshot.getDocuments().get(4).get("docId")).isEqualTo(getUniqueDocId("f"));

    for (QueryDocumentSnapshot doc : snapshot.getDocuments()) {
      assertThat(doc.get("embedding")).isNull();
    }
  }

  @Test
  public void findNearestLimits() throws Exception {
    double[] embeddingVector = new double[2048];
    double[] queryVector = new double[2048];
    for (int i = 0; i < 2048; i++) {
      embeddingVector[i] = i + 1;
      queryVector[i] = i - 1;
    }

    CollectionReference collection =
        testCollectionWithDocs(map("a", map("embedding", FieldValue.vector(embeddingVector))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest("embedding", queryVector, 1000, VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(1);

    assertThat(((VectorValue) snapshot.getDocuments().get(0).get("embedding")).toArray())
        .isEqualTo(embeddingVector);
  }

  @Test
  public void requestingComputedCosineDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0, 1})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0, -0.1})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-1, 0}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.COSINE,
                VectorQueryOptions.newBuilder().setDistanceResultField("distance").build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(4);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(0).getDouble("distance")).isEqualTo(0);

    assertThat(snapshot.getDocuments().get(1).getDouble("distance")).isEqualTo(1);
    assertThat(snapshot.getDocuments().get(2).getDouble("distance")).isEqualTo(1);

    assertThat(snapshot.getDocuments().get(3).get("docId")).isEqualTo(getUniqueDocId("5"));
    assertThat(snapshot.getDocuments().get(3).getDouble("distance")).isEqualTo(2);
  }

  @Test
  public void requestingComputedEuclideanDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, -0.1})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {4, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.EUCLIDEAN,
                VectorQueryOptions.newBuilder().setDistanceResultField("distance").build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(4);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("4"));
    assertThat(snapshot.getDocuments().get(0).getDouble("distance")).isEqualTo(0.1);

    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(1).getDouble("distance")).isEqualTo(1);

    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("5"));
    assertThat(snapshot.getDocuments().get(2).getDouble("distance")).isEqualTo(5);

    assertThat(snapshot.getDocuments().get(3).get("docId")).isEqualTo(getUniqueDocId("3"));
    assertThat(snapshot.getDocuments().get(3).getDouble("distance")).isEqualTo(100);
  }

  @Test
  public void requestingComputedDotProductDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-20, 0})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0.1, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.DOT_PRODUCT,
                VectorQueryOptions.newBuilder().setDistanceResultField("distance").build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(4);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(0).getDouble("distance")).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("3"));
    assertThat(snapshot.getDocuments().get(1).getDouble("distance")).isEqualTo(1);

    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("5"));
    assertThat(snapshot.getDocuments().get(2).getDouble("distance")).isEqualTo(0.1);

    assertThat(snapshot.getDocuments().get(3).get("docId")).isEqualTo(getUniqueDocId("4"));
    assertThat(snapshot.getDocuments().get(3).getDouble("distance")).isEqualTo(-20);
  }

  @Test
  public void overwritesDistanceResultFieldOnConflict() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map(
                    "foo",
                    "bar",
                    "embedding",
                    FieldValue.vector(new double[] {0, 1}),
                    "distance",
                    "100 miles")));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.COSINE,
                VectorQueryOptions.newBuilder().setDistanceResultField("distance").build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(1);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("1"));
    assertThat(snapshot.getDocuments().get(0).getDouble("distance")).isEqualTo(1);
  }

  @Test
  public void requestingComputedDistanceInSelectQueries() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0, 1})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0, -0.1})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-1, 0}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .select("embedding", "distance", "docId")
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.COSINE,
                VectorQueryOptions.newBuilder().setDistanceResultField("distance").build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(4);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(0).getDouble("distance")).isEqualTo(0);

    assertThat(snapshot.getDocuments().get(1).getDouble("distance")).isEqualTo(1);
    assertThat(snapshot.getDocuments().get(2).getDouble("distance")).isEqualTo(1);

    assertThat(snapshot.getDocuments().get(3).get("docId")).isEqualTo(getUniqueDocId("5"));
    assertThat(snapshot.getDocuments().get(3).getDouble("distance")).isEqualTo(2);
  }

  @Test
  public void queryingWithDistanceThresholdUsingCosineDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 1})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0, -0.1})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-1, 0}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.COSINE,
                VectorQueryOptions.newBuilder().setDistanceThreshold(1.0).build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("3"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("4"));
  }

  @Test
  public void queryingWithDistanceThresholdUsingEuclideanDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, -0.1})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {4, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.EUCLIDEAN,
                VectorQueryOptions.newBuilder().setDistanceThreshold(5.0).build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(3);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("4"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(2).get("docId")).isEqualTo(getUniqueDocId("5"));
  }

  @Test
  public void queryingWithDistanceThresholdUsingDotProductDistance() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-20, 0})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0.1, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.DOT_PRODUCT,
                VectorQueryOptions.newBuilder().setDistanceThreshold(1.0).build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("3"));
  }

  @Test
  public void queryWithDistanceResultFieldAndDistanceThreshold() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-20, 0})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0.1, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                5,
                VectorQuery.DistanceMeasure.DOT_PRODUCT,
                VectorQueryOptions.newBuilder()
                    .setDistanceThreshold(0.11)
                    .setDistanceResultField("foo")
                    .build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(0).getDouble("foo")).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("3"));
    assertThat(snapshot.getDocuments().get(1).getDouble("foo")).isEqualTo(1);
  }

  @Test
  public void queryWithDistanceResultFieldAndDistanceThresholdWithFirestoreTypes()
      throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-20, 0})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0.1, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                FieldPath.of("embedding"),
                FieldValue.vector(new double[] {1, 0}),
                5,
                VectorQuery.DistanceMeasure.DOT_PRODUCT,
                VectorQueryOptions.newBuilder()
                    .setDistanceThreshold(0.11)
                    .setDistanceResultField("foo")
                    .build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(0).getDouble("foo")).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("3"));
    assertThat(snapshot.getDocuments().get(1).getDouble("foo")).isEqualTo(1);
  }

  @Test
  public void willNotExceedLimitEvenIfThereAreMoreResultsMoreSimilarThanDistanceThreshold()
      throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-20, 0})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0.1, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding",
                new double[] {1, 0},
                2, // limit set to 2
                VectorQuery.DistanceMeasure.DOT_PRODUCT,
                VectorQueryOptions.newBuilder().setDistanceThreshold(0.0).build());

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertThat(snapshot.size()).isEqualTo(2);

    assertThat(snapshot.getDocuments().get(0).get("docId")).isEqualTo(getUniqueDocId("2"));
    assertThat(snapshot.getDocuments().get(1).get("docId")).isEqualTo(getUniqueDocId("3"));
  }

  @Test
  public void testVectorQueryPlan() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-20, 0})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0.1, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {1, 0}, 5, VectorQuery.DistanceMeasure.DOT_PRODUCT);

    ExplainResults<VectorQuerySnapshot> explainResults =
        vectorQuery.explain(ExplainOptions.builder().setAnalyze(false).build()).get();

    @Nullable VectorQuerySnapshot snapshot = explainResults.getSnapshot();
    assertThat(snapshot).isNull();

    ExplainMetrics metrics = explainResults.getMetrics();
    assertThat(metrics).isNotNull();

    PlanSummary planSummary = metrics.getPlanSummary();
    assertThat(planSummary).isNotNull();
    assertThat(planSummary.getIndexesUsed()).isNotEmpty();

    ExecutionStats stats = metrics.getExecutionStats();
    assertThat(stats).isNull();
  }

  @Test
  public void testVectorQueryProfile() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "1",
                map("foo", "bar"),
                "2",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {2, 0})),
                "3",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 100})),
                "4",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {-20, 0})),
                "5",
                map("foo", "bar", "embedding", FieldValue.vector(new double[] {0.1, 4}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {1, 0}, 5, VectorQuery.DistanceMeasure.DOT_PRODUCT);

    ExplainResults<VectorQuerySnapshot> explainResults =
        vectorQuery.explain(ExplainOptions.builder().setAnalyze(true).build()).get();

    @Nullable VectorQuerySnapshot snapshot = explainResults.getSnapshot();
    assertThat(snapshot).isNotNull();
    assertThat(snapshot.size()).isEqualTo(4);

    ExplainMetrics metrics = explainResults.getMetrics();
    assertThat(metrics).isNotNull();

    PlanSummary planSummary = metrics.getPlanSummary();
    assertThat(planSummary).isNotNull();
    assertThat(planSummary.getIndexesUsed()).isNotEmpty();

    ExecutionStats stats = metrics.getExecutionStats();
    assertThat(stats).isNotNull();
    assertThat(stats.getDebugStats()).isNotEmpty();
    assertThat(stats.getReadOperations()).isEqualTo(5);
    assertThat(stats.getResultsReturned()).isEqualTo(4);
    assertThat(stats.getExecutionDuration()).isGreaterThan(Duration.ZERO);
  }

  @Test
  public void vectorQuerySnapshotReturnsVectorQuery() throws Exception {
    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "a", map("foo", "bar"),
                "b", map("foo", "xxx", "embedding", FieldValue.vector(new double[] {10, 10})),
                "c", map("foo", "bar", "embedding", FieldValue.vector(new double[] {1, 1})),
                "d", map("foo", "bar", "embedding", FieldValue.vector(new double[] {10, 0})),
                "e", map("foo", "bar", "embedding", FieldValue.vector(new double[] {20, 0})),
                "f", map("foo", "bar", "embedding", FieldValue.vector(new double[] {100, 100}))));

    VectorQuery vectorQuery =
        collection
            .whereEqualTo("foo", "bar")
            .whereEqualTo("testId", getUniqueTestId())
            .findNearest(
                "embedding", new double[] {10, 10}, 3, VectorQuery.DistanceMeasure.EUCLIDEAN);

    VectorQuerySnapshot snapshot = vectorQuery.get().get();

    assertTrue(snapshot.getQuery() == vectorQuery);
  }
}
