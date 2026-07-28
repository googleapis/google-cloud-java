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

import static com.google.cloud.firestore.AggregateField.average;
import static com.google.cloud.firestore.AggregateField.sum;
import static com.google.cloud.firestore.LocalFirestoreHelper.autoId;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.it.TestHelper.await;
import static com.google.cloud.firestore.it.TestHelper.isRunningAgainstFirestoreEmulator;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITQueryAggregationsTest extends ITBaseTest {
  private CollectionReference testCollection() {
    String collectionPath = "java-" + autoId();
    return firestore.collection(collectionPath);
  }

  private CollectionReference testCollection(String name) {
    return firestore.collection("java-" + name + "-" + autoId());
  }

  private CollectionReference testCollectionWithDocs(Map<String, Map<String, Object>> docs)
      throws InterruptedException {
    CollectionReference collection = testCollection();
    CollectionReference writer = firestore.collection(collection.getId());
    writeAllDocs(writer, docs);
    return collection;
  }

  public static AggregateQuerySnapshot verifyPipelineReturnsSameResult(AggregateQuery query)
      throws ExecutionException, InterruptedException {

    AggregateQuerySnapshot snapshot = query.get().get();

    if (getFirestoreEdition() != FirestoreEdition.ENTERPRISE) {
      return snapshot;
    }

    List<PipelineResult> pipelineResults =
        query.getQuery().getFirestore().pipeline().createFrom(query).execute().get().getResults();
    assertThat(pipelineResults).hasSize(1);
    assertThat(pipelineResults.get(0).getData())
        .isEqualTo(TestUtil.getAggregateSnapshotData(snapshot));

    return snapshot;
  }

  public static void writeAllDocs(
      CollectionReference collection, Map<String, Map<String, Object>> docs)
      throws InterruptedException {
    for (Map.Entry<String, Map<String, Object>> doc : docs.entrySet()) {
      await(collection.document(doc.getKey()).set(doc.getValue()));
    }
  }

  private static Map<String, Map<String, Object>> testDocs1 =
      map(
          "a",
          map("author", "authorA", "title", "titleA", "pages", 100, "foo", 1, "bar", 2, "baz", 3),
          "b",
          map("author", "authorB", "title", "titleB", "pages", 50, "foo", 1, "bar", 2, "baz", 3));

  @Test
  public void canRunCountUsingAggregationMethod() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(AggregateField.count()));
    assertThat(snapshot.getCount()).isEqualTo(2);
  }

  @Test
  public void allowsAliasesForLongestFieldNames() throws Exception {
    assumeFalse(
        "Skip this test when running against the Firestore emulator or enterprise backend because"
            + " they do not support long field names.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);

    // The longest field name allowed is 1499 characters long.
    // Ensure that sum(longestField) and average(longestField) work.
    StringBuilder builder = new StringBuilder(1500);
    for (int i = 0; i < 1499; i++) {
      builder.append("k");
    }
    String longestField = builder.toString();
    Map<String, Map<String, Object>> testDocs =
        map("a", map(longestField, 2), "b", map(longestField, 4));

    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(AggregateField.sum(longestField)));
    assertThat(snapshot.get(AggregateField.sum(longestField))).isEqualTo(6);
    AggregateQuerySnapshot snapshot2 =
        verifyPipelineReturnsSameResult(collection.aggregate(AggregateField.average(longestField)));
    assertThat(snapshot2.get(AggregateField.average(longestField))).isEqualTo(3.0);
  }

  @Test
  public void canGetDuplicateAggregations() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        collection
            .aggregate(AggregateField.count(), AggregateField.count(), sum("pages"), sum("pages"))
            .get()
            .get();
    assertThat(snapshot.getCount()).isEqualTo(2);
    assertThat(snapshot.get(sum("pages"))).isEqualTo(150);
  }

  @Test
  public void aggregateErrorMessageIfIndexIsMissing() throws Exception {
    assumeFalse(
        "Skip this test when running against emulator or Enterprise because they do not require"
            + " composite index creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);

    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuery aggregateQuery =
        collection
            .whereEqualTo("key1", 42)
            .whereLessThan("key2", 42)
            .aggregate(AggregateField.count());
    ExecutionException executionException =
        assertThrows(ExecutionException.class, () -> aggregateQuery.get().get());
    assertThat(executionException)
        .hasCauseThat()
        .hasMessageThat()
        .containsMatch("FAILED_PRECONDITION:.*index.*");
  }

  @Test
  public void canRunSumQuery() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("pages")));
    assertThat(snapshot.get(sum("pages"))).isEqualTo(150);
  }

  @Test
  public void canRunAverageQuery() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("pages")));
    assertThat(snapshot.get(average("pages"))).isEqualTo(75.0);
  }

  @Test
  public void canGetMultipleAggregationsInTheSameQuery() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.aggregate(sum("pages"), average("pages"), AggregateField.count()));
    assertThat(snapshot.get(sum("pages"))).isEqualTo(150);
    assertThat(snapshot.get(average("pages"))).isEqualTo(75.0);
    assertThat(snapshot.get(AggregateField.count())).isEqualTo(2);
  }

  @Test
  public void getCorrectTypeForSumLong() throws Exception {
    Map<String, Map<String, Object>> testDocs = map("a", map("foo", 100), "b", map("foo", 100));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("foo")));
    Object sum = snapshot.get(sum("foo"));
    assertThat(sum instanceof Long).isTrue();
  }

  @Test
  public void getCorrectTypeForSumDouble() throws Exception {
    Map<String, Map<String, Object>> testDocs = map("a", map("foo", 100.5), "b", map("foo", 100));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("foo")));
    Object sum = snapshot.get(sum("foo"));
    assertThat(sum instanceof Double).isTrue();
  }

  @Test
  public void getCorrectTypeForSumNaN() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map("a", map("foo", 100.5), "b", map("foo", Double.NaN));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("foo")));
    Object sum = snapshot.get(sum("foo"));
    assertThat(sum instanceof Double).isTrue();
    assertThat(sum.equals(Double.NaN));
  }

  @Test
  public void getCorrectTypeForAverageDouble() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("pages")));
    Object average = snapshot.get((AggregateField) average("pages"));
    assertThat(average instanceof Double).isTrue();
  }

  @Test
  public void getCorrectTypeForAverageNaN() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map("a", map("foo", 100.5), "b", map("foo", Double.NaN));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("foo")));
    Object sum = snapshot.get(average("foo"));
    assertThat(sum instanceof Double).isTrue();
    assertThat(sum.equals(Double.NaN));
  }

  @Test
  public void getCorrectTypeForAverageNull() throws Exception {
    CollectionReference collection = testCollection();
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("bar")));
    Object sum = snapshot.get(average("bar"));
    assertThat(sum == null).isTrue();
  }

  @Test
  public void canPerformMaxAggregations() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateField f1 = sum("pages");
    AggregateField f2 = average("pages");
    AggregateField f3 = AggregateField.count();
    AggregateField f4 = sum("foo");
    AggregateField f5 = sum("bar");
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(f1, f2, f3, f4, f5));
    assertThat(snapshot.get(f1)).isEqualTo(150);
    assertThat(snapshot.get(f2)).isEqualTo(75.0);
    assertThat(snapshot.get(f3)).isEqualTo(2);
    assertThat(snapshot.get(f4)).isEqualTo(2);
    assertThat(snapshot.get(f5)).isEqualTo(4);
  }

  @Test
  public void cannotPerformMoreThanMaxAggregations() throws Exception {
    // TODO: Update this test once aggregate de-duplication is implemented and more aggregation
    // types are available.
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateField f1 = sum("pages");
    AggregateField f2 = average("pages");
    AggregateField f3 = AggregateField.count();
    AggregateField f4 = sum("foo");
    AggregateField f5 = sum("bar");
    AggregateField f6 = sum("baz");
    Exception exception = null;
    try {
      collection.aggregate(f1, f2, f3, f4, f5, f6).get().get();
    } catch (Exception e) {
      exception = e;
    }

    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertThat(exception).isNotNull();
      if (!isRunningAgainstFirestoreEmulator(firestore)) {
        assertThat(exception.getMessage()).contains("maximum number of aggregations");
      }
    } else {
      assertThat(exception).isNull();
    }
  }

  @Test
  public void aggregateQueriesSupportCollectionGroups() throws Exception {
    assumeTrue(
        "Skip this test when running against prod because it requires composite index creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    String collectionGroupId = "myColGroupId" + autoId();
    Map<String, Object> data = map("x", 2);
    // Setting documents at the following paths:
    //   `${collectionGroupId}/cg-doc1`,
    //   `abc/123/${collectionGroupId}/cg-doc2`,
    //   `zzz${collectionGroupId}/cg-doc3`,
    //   `abc/123/zzz${collectionGroupId}/cg-doc4`,
    //   `abc/123/zzz/${collectionGroupId}`
    await(firestore.collection(collectionGroupId).document("cg-doc1").set(data));
    await(
        firestore
            .collection("abc")
            .document("123")
            .collection(collectionGroupId)
            .document("cg-doc2")
            .set(data));
    await(firestore.collection("zzz" + collectionGroupId).document("cg-doc3").set(data));
    await(
        firestore
            .collection("abc")
            .document("123")
            .collection("zzz" + collectionGroupId)
            .document("cg-doc4")
            .set(data));
    await(
        firestore
            .collection("abc")
            .document("123")
            .collection("zzz")
            .document(collectionGroupId)
            .set(data));
    CollectionGroup collectionGroup = firestore.collectionGroup(collectionGroupId);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collectionGroup.aggregate(AggregateField.count(), sum("x"), average("x")));
    assertThat(snapshot.get(AggregateField.count())).isEqualTo(2);
    assertThat(snapshot.get(sum("x"))).isEqualTo(4);
    assertThat(snapshot.get(average("x"))).isEqualTo(2);
  }

  @Test
  public void performsAggregationsOnDocumentsWithAllAggregatedFields() throws Exception {
    assumeTrue(
        "Skip if we are running against standard in prod",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    Map<String, Map<String, Object>> testDocs =
        map(
            "a",
            map("author", "authorA", "title", "titleA", "pages", 100, "year", 1980),
            "b",
            map("author", "authorB", "title", "titleB", "pages", 50, "year", 2020),
            "c",
            map("author", "authorC", "title", "titleC", "pages", 150, "year", 2021),
            "d",
            map("author", "authorD", "title", "titleD", "pages", 50));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.aggregate(
                sum("pages"), average("pages"), average("year"), AggregateField.count()));
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertThat(snapshot.get(sum("pages"))).isEqualTo(300);
      assertThat(snapshot.get(average("pages"))).isEqualTo(100);
      assertThat(snapshot.get(average("year"))).isEqualTo(2007);
      assertThat(snapshot.get(AggregateField.count())).isEqualTo(3);
    } else {
      assertThat(snapshot.get(sum("pages"))).isEqualTo(350);
      assertThat(snapshot.get(average("pages"))).isEqualTo(87.5);
      assertThat(snapshot.get(average("year"))).isEqualTo(2007);
      assertThat(snapshot.get(AggregateField.count())).isEqualTo(4);
    }
  }

  @Test
  public void performsAggregationsWhenNaNExistsForSomeFieldValues() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    Map<String, Map<String, Object>> testDocs =
        map(
            "a",
                map(
                    "author", "authorA", "title", "titleA", "pages", 100, "year", 1980, "rating",
                    5),
            "b",
                map("author", "authorB", "title", "titleB", "pages", 50, "year", 2020, "rating", 4),
            "c",
                map(
                    "author",
                    "authorC",
                    "title",
                    "titleC",
                    "pages",
                    100,
                    "year",
                    1980,
                    "rating",
                    Double.NaN),
            "d",
                map(
                    "author", "authorD", "title", "titleD", "pages", 50, "year", 2020, "rating",
                    0));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.aggregate(sum("rating"), sum("pages"), average("year")));
    assertThat(snapshot.get(sum("rating"))).isEqualTo(Double.NaN);
    assertThat(snapshot.get(sum("pages"))).isEqualTo(300);
    assertThat(snapshot.get(average("year"))).isEqualTo(2000);
  }

  @Test
  public void throwsAnErrorWhenGettingTheResultOfAnUnrequestedAggregation() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("pages")));
    Exception exception = null;
    try {
      snapshot.get(average("pages"));
    } catch (Exception e) {
      exception = e;
    }
    assertThat(exception).isNotNull();
    assertThat(exception.getMessage())
        .isEqualTo("'average(pages)' was not requested in the aggregation query.");
    exception = null;
    try {
      snapshot.get(sum("foo"));
    } catch (RuntimeException e) {
      exception = e;
    }
    assertThat(exception).isNotNull();
    assertThat(exception.getMessage())
        .isEqualTo("'sum(foo)' was not requested in the aggregation query.");
  }

  @Test
  public void performsAggregationWhenUsingInOperator() throws Exception {
    assumeTrue(
        "Skip this test when running against prod because it requires composite index creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    Map<String, Map<String, Object>> testDocs =
        map(
            "a",
                map(
                    "author", "authorA", "title", "titleA", "pages", 100, "year", 1980, "rating",
                    5),
            "b",
                map("author", "authorB", "title", "titleB", "pages", 50, "year", 2020, "rating", 4),
            "c",
                map(
                    "author", "authorC", "title", "titleC", "pages", 100, "year", 1980, "rating",
                    3),
            "d",
                map(
                    "author", "authorD", "title", "titleD", "pages", 50, "year", 2020, "rating",
                    0));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection
                .whereIn("rating", asList(5, 3))
                .aggregate(
                    sum("rating"),
                    average("rating"),
                    sum("pages"),
                    average("pages"),
                    AggregateField.count()));
    assertThat(snapshot.get(sum("rating"))).isEqualTo(8);
    assertThat(snapshot.get(average("rating"))).isEqualTo(4);
    assertThat(snapshot.get(sum("pages"))).isEqualTo(200);
    assertThat(snapshot.get(average("pages"))).isEqualTo(100);
    assertThat(snapshot.get(AggregateField.count())).isEqualTo(2);
  }

  @Test
  public void performsAggregationWhenUsingArrayContainsAnyOperator() throws Exception {
    assumeTrue(
        "Skip this test when running against prod because it requires composite index creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    Map<String, Map<String, Object>> testDocs =
        map(
            "a",
                map(
                    "author",
                    "authorA",
                    "title",
                    "titleA",
                    "pages",
                    100,
                    "year",
                    1980,
                    "rating",
                    asList(5, 1000)),
            "b",
                map(
                    "author", "authorB", "title", "titleB", "pages", 50, "year", 2020, "rating",
                    asList(4)),
            "c",
                map(
                    "author",
                    "authorC",
                    "title",
                    "titleC",
                    "pages",
                    100,
                    "year",
                    1980,
                    "rating",
                    asList(2222, 3)),
            "d",
                map(
                    "author", "authorD", "title", "titleD", "pages", 50, "year", 2020, "rating",
                    asList(0)));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection
                .whereArrayContainsAny("rating", asList(5, 3))
                .aggregate(
                    sum("rating"),
                    average("rating"),
                    sum("pages"),
                    average("pages"),
                    AggregateField.count()));

    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertThat(snapshot.get(sum("rating"))).isEqualTo(0);
      assertThat(snapshot.get(average("rating"))).isEqualTo(null);
      assertThat(snapshot.get(sum("pages"))).isEqualTo(200);
      assertThat(snapshot.get(average("pages"))).isEqualTo(100);
      assertThat(snapshot.get(AggregateField.count())).isEqualTo(2);
    } else {
      assertThat(snapshot.get(sum("rating"))).isNull();
      assertThat(snapshot.get(average("rating"))).isNull();
      assertThat(snapshot.get(sum("pages"))).isEqualTo(200);
      assertThat(snapshot.get(average("pages"))).isEqualTo(100);
      assertThat(snapshot.get(AggregateField.count())).isEqualTo(2);
    }
  }

  @Test
  public void performsAggregationsOnNestedMapValues() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a",
            map(
                "author",
                "authorA",
                "title",
                "titleA",
                "metadata",
                map("pages", 100, "rating", map("critic", 2, "user", 5))),
            "b",
            map(
                "author",
                "authorB",
                "title",
                "titleB",
                "metadata",
                map("pages", 50, "rating", map("critic", 4, "user", 4))));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.aggregate(
                sum("metadata.pages"), average("metadata.pages"), AggregateField.count()));
    assertThat(snapshot.get(sum("metadata.pages"))).isEqualTo(150);
    assertThat(snapshot.get(average("metadata.pages"))).isEqualTo(75);
    assertThat(snapshot.get(AggregateField.count())).isEqualTo(2);
  }

  @Test
  public void performsSumThatResultsInFloat() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 5),
            "b", map("author", "authorB", "title", "titleB", "rating", 4.5),
            "c", map("author", "authorC", "title", "titleC", "rating", 3));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("rating")));
    Object sum = snapshot.get(sum("rating"));
    assertThat(sum instanceof Double).isTrue();
    assertThat(sum).isEqualTo(12.5);
  }

  @Test
  public void performsSumOfIntsAndFloatsThatResultsInInt() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 5),
            "b", map("author", "authorB", "title", "titleB", "rating", 4.5),
            "c", map("author", "authorC", "title", "titleC", "rating", 3.5));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("rating")));
    Object sum = snapshot.get(sum("rating"));
    assertThat(sum instanceof Double).isTrue();
    assertThat(sum).isEqualTo(13.0);
  }

  @Test
  public void performsSumThatOverflowsMaxLong() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", Long.MAX_VALUE),
            "b", map("author", "authorB", "title", "titleB", "rating", Long.MAX_VALUE));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      AggregateQuerySnapshot snapshot = collection.aggregate(sum("rating")).get().get();
      Object sum = snapshot.get(sum("rating"));
      assertThat(sum instanceof Double).isTrue();
      assertThat(sum).isEqualTo((double) Long.MAX_VALUE + (double) Long.MAX_VALUE);
    } else {
      // enterprise will fail the operation
      assertThrows(ExecutionException.class, () -> collection.aggregate(sum("rating")).get().get());
    }
  }

  @Test
  public void performsSumThatCanOverflowIntegerValuesDuringAccumulation() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", Long.MAX_VALUE),
            "b", map("author", "authorB", "title", "titleB", "rating", 1),
            "c", map("author", "authorC", "title", "titleC", "rating", -101));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot = collection.aggregate(sum("rating")).get().get();
    Object sum = snapshot.get(sum("rating"));
    assertThat(sum instanceof Long).isTrue();
    assertThat(sum).isEqualTo(Long.MAX_VALUE - 100);
  }

  @Test
  public void performsSumThatIsNegative() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", Long.MAX_VALUE),
            "b", map("author", "authorB", "title", "titleB", "rating", -Long.MAX_VALUE),
            "c", map("author", "authorC", "title", "titleC", "rating", -101),
            "d", map("author", "authorD", "title", "titleD", "rating", -10000));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      AggregateQuerySnapshot snapshot =
          verifyPipelineReturnsSameResult(collection.aggregate(sum("rating")));
      assertThat(snapshot.get(sum("rating"))).isEqualTo(-10101);
    } else {
      // enterprise will fail the operation
      assertThrows(ExecutionException.class, () -> collection.aggregate(sum("rating")).get().get());
    }
  }

  @Test
  public void performsSumThatIsPositiveInfinity() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", Double.MAX_VALUE),
            "b", map("author", "authorB", "title", "titleB", "rating", Double.MAX_VALUE));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("rating")));
    Object sum = snapshot.get(sum("rating"));
    assertThat(sum instanceof Double).isTrue();
    assertThat(sum).isEqualTo(Double.POSITIVE_INFINITY);
    assertThat(snapshot.getDouble(sum("rating"))).isEqualTo(Double.POSITIVE_INFINITY);
    assertThat(snapshot.getLong(sum("rating"))).isEqualTo(Long.MAX_VALUE);
  }

  @Test
  public void performsSumThatIsNegativeInfinity() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", -Double.MAX_VALUE),
            "b", map("author", "authorB", "title", "titleB", "rating", -Double.MAX_VALUE));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("rating")));
    Object sum = snapshot.get(sum("rating"));
    assertThat(sum instanceof Double).isTrue();
    assertThat(sum).isEqualTo(Double.NEGATIVE_INFINITY);
    assertThat(snapshot.getDouble(sum("rating"))).isEqualTo(Double.NEGATIVE_INFINITY);
    assertThat(snapshot.getLong(sum("rating"))).isEqualTo(Long.MIN_VALUE);
  }

  @Test
  public void performsSumThatIsValidButCouldOverflowDuringAggregation() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", Double.MAX_VALUE),
            "b", map("author", "authorB", "title", "titleB", "rating", Double.MAX_VALUE),
            "c", map("author", "authorC", "title", "titleC", "rating", -Double.MAX_VALUE),
            "d", map("author", "authorD", "title", "titleD", "rating", -Double.MAX_VALUE),
            "e", map("author", "authorE", "title", "titleE", "rating", Double.MAX_VALUE),
            "f", map("author", "authorF", "title", "titleF", "rating", -Double.MAX_VALUE),
            "g", map("author", "authorG", "title", "titleG", "rating", -Double.MAX_VALUE),
            "h", map("author", "authorH", "title", "titleH", "rating", Double.MAX_VALUE));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot = collection.aggregate(sum("rating")).get().get();
    Object sum = snapshot.get(sum("rating"));
    assertThat(sum instanceof Double).isTrue();
    assertThat(sum).isAnyOf(0, 0.0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  @Test
  public void performsSumThatIncludesNaN() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 5),
            "b", map("author", "authorB", "title", "titleB", "rating", 4),
            "c", map("author", "authorC", "title", "titleC", "rating", Double.NaN),
            "d", map("author", "authorD", "title", "titleD", "rating", 0));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("rating")));
    assertThat(snapshot.get(sum("rating"))).isEqualTo(Double.NaN);
  }

  @Test
  public void performsSumOverResultSetOfZeroDocuments() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.whereGreaterThan("pages", 200).aggregate(sum("pages")));
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertThat(snapshot.get(sum("pages"))).isEqualTo(0);
    } else {
      assertThat(snapshot.get(sum("pages"))).isNull();
    }
  }

  @Test
  public void performsSumOnlyOnNumericFields() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 5),
            "b", map("author", "authorB", "title", "titleB", "rating", 4),
            "c", map("author", "authorC", "title", "titleC", "rating", "3"),
            "d", map("author", "authorD", "title", "titleD", "rating", 1));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.aggregate(sum("rating"), AggregateField.count()));
    assertThat(snapshot.get(sum("rating"))).isEqualTo(10);
    assertThat(snapshot.get(AggregateField.count())).isEqualTo(4);
  }

  @Test
  public void performsSumOfMinIEEE754() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map("a", map("author", "authorA", "title", "titleA", "rating", Double.MIN_VALUE));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(sum("rating")));
    assertThat(snapshot.get(sum("rating"))).isEqualTo(Double.MIN_VALUE);
  }

  @Test
  public void performsAverageOfIntsThatResultsInAnInt() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 10),
            "b", map("author", "authorB", "title", "titleB", "rating", 5),
            "c", map("author", "authorC", "title", "titleC", "rating", 0));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(5);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(5L);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(5.0);
  }

  @Test
  public void performsAverageOfFloatsThatResultsInAnInt() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 10.5),
            "b", map("author", "authorB", "title", "titleB", "rating", 9.5));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating")) instanceof Double).isTrue();
    assertThat(snapshot.get(average("rating"))).isEqualTo(10);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(10L);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(10.0);
  }

  @Test
  public void performsAverageOfFloatsAndIntsThatResultsInAnInt() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 10),
            "b", map("author", "authorB", "title", "titleB", "rating", 9.5),
            "c", map("author", "authorC", "title", "titleC", "rating", 10.5));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(10);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(10L);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(10.0);
  }

  @Test
  public void performsAverageOfFloatsThatResultsInAFloat() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 5.5),
            "b", map("author", "authorB", "title", "titleB", "rating", 4.5),
            "c", map("author", "authorC", "title", "titleC", "rating", 3.5));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(4.5);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(4.5);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(4L);
  }

  @Test
  public void performsAverageOfFloatsAndIntsThatResultsInAFloat() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 8.6),
            "b", map("author", "authorB", "title", "titleB", "rating", 9),
            "c", map("author", "authorC", "title", "titleC", "rating", 10));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(27.6 / 3);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(27.6 / 3);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(9L);
  }

  @Test
  public void performsAverageOfIntsThatResultsInAFloat() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 10),
            "b", map("author", "authorB", "title", "titleB", "rating", 9));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(9.5);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(9.5d);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(9L);
  }

  @Test
  public void performsAverageCausingUnderflow() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", Double.MIN_VALUE),
            "b", map("author", "authorB", "title", "titleB", "rating", 0));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(0);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(0.0d);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(0L);
  }

  @Test
  public void performsAverageOfMinIEEE754() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map("a", map("author", "authorA", "title", "titleA", "rating", Double.MIN_VALUE));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(Double.MIN_VALUE);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(Double.MIN_VALUE);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(0);
  }

  @Test
  public void performsAverageThatCouldOverflowIEEE754DuringAccumulation() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a",
            map("author", "authorA", "title", "titleA", "rating", Double.MAX_VALUE),
            "b",
            map("author", "authorB", "title", "titleB", "rating", Double.MAX_VALUE));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(Double.POSITIVE_INFINITY);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(Double.POSITIVE_INFINITY);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(Long.MAX_VALUE);
  }

  @Test
  public void performsAverageThatIncludesNaN() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a",
            map("author", "authorA", "title", "titleA", "rating", 5),
            "b",
            map("author", "authorB", "title", "titleB", "rating", 4),
            "c",
            map("author", "authorC", "title", "titleC", "rating", Double.NaN),
            "d",
            map("author", "authorD", "title", "titleD", "rating", 0));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(collection.aggregate(average("rating")));
    assertThat(snapshot.get(average("rating"))).isEqualTo(Double.NaN);
    assertThat(snapshot.getDouble(average("rating"))).isEqualTo(Double.NaN);
    assertThat(snapshot.getLong(average("rating"))).isEqualTo(0L);
  }

  @Test
  public void performsAverageOverResultSetOfZeroDocuments() throws Exception {
    CollectionReference collection = testCollectionWithDocs(testDocs1);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.whereGreaterThan("pages", 200).aggregate(average("pages")));
    assertThat(snapshot.get(average("pages"))).isEqualTo(null);
    assertThat(snapshot.getDouble(average("pages"))).isEqualTo(null);
    assertThat(snapshot.getLong(average("pages"))).isEqualTo(null);
  }

  @Test
  public void performsAverageOnlyOnNumericFields() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("author", "authorA", "title", "titleA", "rating", 5),
            "b", map("author", "authorB", "title", "titleB", "rating", 4),
            "c", map("author", "authorC", "title", "titleC", "rating", "3"),
            "d", map("author", "authorD", "title", "titleD", "rating", 6));
    CollectionReference collection = testCollectionWithDocs(testDocs);
    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection.aggregate(average("rating"), AggregateField.count()));
    assertThat(snapshot.get(average("rating"))).isEqualTo(5);
    assertThat(snapshot.get(AggregateField.count())).isEqualTo(4);
  }

  @Test
  public void aggregatesWithDocumentReferenceCursors() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("num", 1),
            "b", map("num", 2),
            "c", map("num", 3),
            "d", map("num", 4),
            "e", map("num", 5));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    AggregateQuerySnapshot snapshot =
        verifyPipelineReturnsSameResult(
            collection
                .orderBy(FieldPath.documentId())
                .startAfter(collection.document("c"))
                .aggregate(sum("num")));
    assertThat(snapshot.get(sum("num"))).isEqualTo(9);

    snapshot =
        verifyPipelineReturnsSameResult(
            collection
                .orderBy(FieldPath.documentId())
                .startAt(collection.document("c"))
                .aggregate(sum("num")));
    assertThat(snapshot.get(sum("num"))).isEqualTo(12);

    snapshot =
        verifyPipelineReturnsSameResult(
            collection
                .orderBy(FieldPath.documentId())
                .endBefore(collection.document("c"))
                .aggregate(sum("num")));
    assertThat(snapshot.get(sum("num"))).isEqualTo(3);

    snapshot =
        verifyPipelineReturnsSameResult(
            collection
                .orderBy(FieldPath.documentId())
                .endAt(collection.document("c"))
                .aggregate(sum("num")));
    assertThat(snapshot.get(sum("num"))).isEqualTo(6);
  }

  CollectionReference addTwoDocsForCursorTesting() throws InterruptedException {
    Map<String, Map<String, Object>> testDocs =
        map(
            "a", map("num", 5, "foo", 1),
            "b", map("num", 7, "foo", 2));
    return testCollectionWithDocs(testDocs);
  }

  @Test
  public void aggregateWithNoFilterNoOrderByNoCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query = collection.aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(12);
  }

  @Test
  public void aggregateWithEqualityFilterNoOrderByNoCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query = collection.whereEqualTo("num", 5).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(5);
  }

  @Test
  public void aggregateWithInequalityFilterNoOrderByNoCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query = collection.whereGreaterThan("num", 5).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateWithNoFilterExplicitOrderByNoCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query = collection.orderBy("num").aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(12);
  }

  @Test
  public void aggregateWithEqualityFilterExplicitOrderByNoCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query = collection.whereEqualTo("num", 5).orderBy("num").aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(5);
  }

  @Test
  public void aggregateWithInequalityFilterExplicitOrderByNoCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query =
        collection.whereGreaterThan("num", 5).orderBy("num").aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateNoFilterExplicitOrderByFieldValueCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query = collection.orderBy("num").startAfter(5).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateNoFilterExplicitOrderByDocumentReferenceCursor() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query =
        collection
            .orderBy(FieldPath.documentId())
            .startAfter(collection.document("a"))
            .aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateNoFilterNoOrderByDocumentReferenceCursor() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query = collection.startAfter(collection.document("a")).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateNoFilterExplicitOrderByDocumentSnapshotCursor() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    CollectionReference collection = addTwoDocsForCursorTesting();
    DocumentSnapshot docSnapshot = collection.document("a").get().get();
    AggregateQuery query = collection.orderBy("foo").startAfter(docSnapshot).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  // This just happens to work because the orderBy field matches the aggregation field.
  @Test
  public void aggregateNoFilterExplicitOrderByDocumentSnapshotCursor2() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    DocumentSnapshot docSnapshot = collection.document("a").get().get();
    AggregateQuery query = collection.orderBy("num").startAfter(docSnapshot).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateEqualityFilterExplicitOrderByFieldValueCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query =
        collection.whereEqualTo("num", 5).orderBy("num").startAt(5).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(5);
  }

  @Test
  public void aggregateInequalityFilterExplicitOrderByFieldValueCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query =
        collection.whereGreaterThan("num", 5).orderBy("num").startAt(6).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateEqualityFilterExplicitOrderByDocumentReferenceCursor() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query =
        collection
            .whereEqualTo("num", 7)
            .orderBy(FieldPath.documentId())
            .startAfter(collection.document("a"))
            .aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  // Full orderBy is provided.
  @Test
  public void aggregateInequalityFilterExplicitOrderByDocumentReferenceCursor() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    AggregateQuery query =
        collection
            .whereGreaterThan("num", 0)
            .orderBy("num")
            .orderBy(FieldPath.documentId())
            .startAfter(5, collection.document("a"))
            .aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateEqualityFilterNoOrderByDocumentSnapshotReference() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    CollectionReference collection = addTwoDocsForCursorTesting();
    DocumentSnapshot docSnapshot = collection.document("a").get().get();
    AggregateQuery query =
        collection.whereEqualTo("num", 7).startAfter(docSnapshot).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  // This just happens to work because the orderBy field matches the aggregation field.
  @Test
  public void aggregateInequalityFilterNoOrderByDocumentSnapshotReference() throws Exception {
    CollectionReference collection = addTwoDocsForCursorTesting();
    DocumentSnapshot docSnapshot = collection.document("a").get().get();
    AggregateQuery query =
        collection.whereGreaterThan("num", 0).startAfter(docSnapshot).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateInequalityFilterNoOrderByDocumentSnapshotReference2() throws Exception {
    assumeTrue(
        "Skip this test when running against standard prod because it requires composite index"
            + " creation.",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    CollectionReference collection = addTwoDocsForCursorTesting();
    DocumentSnapshot docSnapshot = collection.document("a").get().get();
    AggregateQuery query =
        collection.whereGreaterThan("foo", 0).startAfter(docSnapshot).aggregate(sum("num"));
    AggregateQuerySnapshot snapshot = verifyPipelineReturnsSameResult(query);
    assertThat(snapshot.get(sum("num"))).isEqualTo(7);
  }

  @Test
  public void aggregateQueryShouldFailWithMessageWithConsoleLinkIfMissingIndex() {
    assumeFalse(
        "Only run this test when running against the standard backend",
        isRunningAgainstFirestoreEmulator(firestore)
            || getFirestoreEdition() == FirestoreEdition.ENTERPRISE);

    CollectionReference collection = testCollection();
    Query compositeIndexQuery = collection.whereEqualTo("field1", 42).whereLessThan("field2", 99);
    AggregateQuery compositeIndexAggregateQuery =
        compositeIndexQuery.aggregate(
            AggregateField.count(), AggregateField.sum("pages"), AggregateField.average("pages"));
    ApiFuture<AggregateQuerySnapshot> future = compositeIndexAggregateQuery.get();

    ExecutionException executionException = assertThrows(ExecutionException.class, future::get);

    Throwable throwable = executionException.getCause();
    assertThat(throwable).hasMessageThat().ignoringCase().contains("index");
    // TODO(b/316359394) Remove this check for the default databases once cl/582465034 is rolled out
    //  to production.
    if (collection.getFirestore().getOptions().getDatabaseId().equals("(default)")) {
      assertThat(throwable).hasMessageThat().contains("https://console.firebase.google.com");
    }
  }
}
