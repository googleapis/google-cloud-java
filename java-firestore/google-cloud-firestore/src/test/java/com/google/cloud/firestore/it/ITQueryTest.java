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

package com.google.cloud.firestore.it;

import static com.google.cloud.firestore.it.TestHelper.isRunningAgainstFirestoreEmulator;
import static com.google.common.primitives.Ints.asList;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.*;
import com.google.cloud.firestore.Query.Direction;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITQueryTest extends ITBaseTest {

  @Rule public TestName testName = new TestName();

  private CollectionReference createEmptyCollection() {
    String collectionPath =
        "java-" + testName.getMethodName() + "-" + LocalFirestoreHelper.autoId();
    return firestore.collection(collectionPath);
  }

  public static <T> Map<String, T> map(Object... entries) {
    Map<String, T> res = new LinkedHashMap<>();
    for (int i = 0; i < entries.length; i += 2) {
      res.put((String) entries[i], (T) entries[i + 1]);
    }
    return res;
  }

  public CollectionReference testCollectionWithDocs(Map<String, Map<String, Object>> docs)
      throws ExecutionException, InterruptedException, TimeoutException {
    CollectionReference collection = firestore.collection(LocalFirestoreHelper.autoId());
    for (Map.Entry<String, Map<String, Object>> doc : docs.entrySet()) {
      collection.document(doc.getKey()).set(doc.getValue()).get(5, TimeUnit.SECONDS);
    }
    return collection;
  }

  public static void checkQuerySnapshotContainsDocuments(Query query, String... docs)
      throws ExecutionException, InterruptedException {
    QuerySnapshot snapshot = query.get().get();
    List<String> result =
        snapshot.getDocuments().stream()
            .map(queryDocumentSnapshot -> queryDocumentSnapshot.getReference().getId())
            .collect(Collectors.toList());
    assertThat(result).isEqualTo(Arrays.asList(docs));
  }

  @Test
  public void orQueries() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", 0),
            "doc2", map("a", 2, "b", 1),
            "doc3", map("a", 3, "b", 2),
            "doc4", map("a", 1, "b", 3),
            "doc5", map("a", 1, "b", 1));

    CollectionReference collection = testCollectionWithDocs(testDocs);

    // Two equalities: a==1 || b==1.
    checkQuerySnapshotContainsDocuments(
        collection.where(Filter.or(Filter.equalTo("a", 1), Filter.equalTo("b", 1))),
        "doc1",
        "doc2",
        "doc4",
        "doc5");

    // (a==1 && b==0) || (a==3 && b==2)
    checkQuerySnapshotContainsDocuments(
        collection.where(
            Filter.or(
                Filter.and(Filter.equalTo("a", 1), Filter.equalTo("b", 0)),
                Filter.and(Filter.equalTo("a", 3), Filter.equalTo("b", 2)))),
        "doc1",
        "doc3");

    // a==1 && (b==0 || b==3).
    checkQuerySnapshotContainsDocuments(
        collection.where(
            Filter.and(
                Filter.equalTo("a", 1), Filter.or(Filter.equalTo("b", 0), Filter.equalTo("b", 3)))),
        "doc1",
        "doc4");

    // (a==2 || b==2) && (a==3 || b==3)
    checkQuerySnapshotContainsDocuments(
        collection.where(
            Filter.and(
                Filter.or(Filter.equalTo("a", 2), Filter.equalTo("b", 2)),
                Filter.or(Filter.equalTo("a", 3), Filter.equalTo("b", 3)))),
        "doc3");

    // Test with limits without orderBy (the __name__ ordering is the tiebreaker).
    checkQuerySnapshotContainsDocuments(
        collection.where(Filter.or(Filter.equalTo("a", 2), Filter.equalTo("b", 1))).limit(1),
        "doc2");
  }

  @Test
  public void orQueriesWithCompositeIndexes() throws Exception {
    assumeTrue(
        "Skip this test when running against production because these queries require a composite"
            + " index.",
        isRunningAgainstFirestoreEmulator(firestore));
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", 0),
            "doc2", map("a", 2, "b", 1),
            "doc3", map("a", 3, "b", 2),
            "doc4", map("a", 1, "b", 3),
            "doc5", map("a", 1, "b", 1));

    CollectionReference collection = testCollectionWithDocs(testDocs);

    // with one inequality: a>2 || b==1.
    checkQuerySnapshotContainsDocuments(
        collection.where(Filter.or(Filter.greaterThan("a", 2), Filter.equalTo("b", 1))),
        "doc5",
        "doc2",
        "doc3");

    // Test with limits (implicit order by ASC): (a==1) || (b > 0) LIMIT 2
    checkQuerySnapshotContainsDocuments(
        collection.where(Filter.or(Filter.equalTo("a", 1), Filter.greaterThan("b", 0))).limit(2),
        "doc1",
        "doc2");

    // Test with limits (explicit order by): (a==1) || (b > 0) LIMIT_TO_LAST 2
    // Note: The public query API does not allow implicit ordering when limitToLast is used.
    checkQuerySnapshotContainsDocuments(
        collection
            .where(Filter.or(Filter.equalTo("a", 1), Filter.greaterThan("b", 0)))
            .limitToLast(2)
            .orderBy("b"),
        "doc3",
        "doc4");

    // Test with limits (explicit order by ASC): (a==2) || (b == 1) ORDER BY a LIMIT 1
    checkQuerySnapshotContainsDocuments(
        collection
            .where(Filter.or(Filter.equalTo("a", 2), Filter.equalTo("b", 1)))
            .limit(1)
            .orderBy("a"),
        "doc5");

    // Test with limits (explicit order by DESC): (a==2) || (b == 1) ORDER BY a LIMIT_TO_LAST 1
    checkQuerySnapshotContainsDocuments(
        collection
            .where(Filter.or(Filter.equalTo("a", 2), Filter.equalTo("b", 1)))
            .limitToLast(1)
            .orderBy("a"),
        "doc2");

    // Test with limits (explicit order by DESC): (a==2) || (b == 1) ORDER BY a DESC LIMIT 1
    checkQuerySnapshotContainsDocuments(
        collection
            .where(Filter.or(Filter.equalTo("a", 2), Filter.equalTo("b", 1)))
            .limit(1)
            .orderBy("a", Direction.DESCENDING),
        "doc2");
  }

  @Test
  public void orQueryDoesNotIncludeDocumentsWithMissingFields() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", 0),
            "doc2", map("b", 1),
            "doc3", map("a", 3, "b", 2),
            "doc4", map("a", 1, "b", 3),
            "doc5", map("a", 1),
            "doc6", map("a", 2));

    CollectionReference collection = testCollectionWithDocs(testDocs);

    // Query: a==1 || b==1
    // There's no explicit nor implicit orderBy. Documents with missing 'a' or missing 'b' should be
    // allowed if the document matches at least one disjunction term.
    Query query = collection.where(Filter.or(Filter.equalTo("a", 1), Filter.equalTo("b", 1)));
    checkQuerySnapshotContainsDocuments(query, "doc1", "doc2", "doc4", "doc5");
  }

  @Test
  public void orQueryDoesNotIncludeDocumentsWithMissingFields2() throws Exception {
    assumeTrue(
        "Skip this test when running against production because these queries require a composite"
            + " index.",
        isRunningAgainstFirestoreEmulator(firestore));
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", 0),
            "doc2", map("b", 1),
            "doc3", map("a", 3, "b", 2),
            "doc4", map("a", 1, "b", 3),
            "doc5", map("a", 1),
            "doc6", map("a", 2));

    CollectionReference collection = testCollectionWithDocs(testDocs);

    // Query: a==1 || b==1 order by a.
    // doc2 should not be included because it's missing the field 'a', and we have "orderBy a".
    Query query1 =
        collection.where(Filter.or(Filter.equalTo("a", 1), Filter.equalTo("b", 1))).orderBy("a");
    checkQuerySnapshotContainsDocuments(query1, "doc1", "doc4", "doc5");

    // Query: a==1 || b==1 order by b.
    // doc5 should not be included because it's missing the field 'b', and we have "orderBy b".
    Query query2 =
        collection.where(Filter.or(Filter.equalTo("a", 1), Filter.equalTo("b", 1))).orderBy("b");
    checkQuerySnapshotContainsDocuments(query2, "doc1", "doc2", "doc4");

    // Query: a>2 || b==1.
    // This query has an implicit 'order by a'.
    // doc2 should not be included because it's missing the field 'a'.
    Query query3 = collection.where(Filter.or(Filter.greaterThan("a", 2), Filter.equalTo("b", 1)));
    checkQuerySnapshotContainsDocuments(query3, "doc3");

    // Query: a>1 || b==1 order by a order by b.
    // doc6 should not be included because it's missing the field 'b'.
    // doc2 should not be included because it's missing the field 'a'.
    Query query4 =
        collection
            .where(Filter.or(Filter.greaterThan("a", 1), Filter.equalTo("b", 1)))
            .orderBy("a")
            .orderBy("b");
    checkQuerySnapshotContainsDocuments(query4, "doc3");
  }

  @Test
  public void orQueriesWithIn() throws ExecutionException, InterruptedException, TimeoutException {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", 0),
            "doc2", map("b", 1),
            "doc3", map("a", 3, "b", 2),
            "doc4", map("a", 1, "b", 3),
            "doc5", map("a", 1),
            "doc6", map("a", 2));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    // a==2 || b in [2,3]
    checkQuerySnapshotContainsDocuments(
        collection.where(Filter.or(Filter.equalTo("a", 2), Filter.inArray("b", asList(2, 3)))),
        "doc3",
        "doc4",
        "doc6");
  }

  @Test
  public void orQueriesWithNotIn()
      throws ExecutionException, InterruptedException, TimeoutException {
    assumeTrue(
        "Skip this test when running against production because it is currently not supported.",
        isRunningAgainstFirestoreEmulator(firestore));
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", 0),
            "doc2", map("b", 1),
            "doc3", map("a", 3, "b", 2),
            "doc4", map("a", 1, "b", 3),
            "doc5", map("a", 1),
            "doc6", map("a", 2));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    // a==2 || b not-in [2,3]
    // Has implicit orderBy b.
    checkQuerySnapshotContainsDocuments(
        collection.where(Filter.or(Filter.equalTo("a", 2), Filter.notInArray("b", asList(2, 3)))),
        "doc1",
        "doc2");
  }

  @Test
  public void orQueriesWithArrayMembership()
      throws ExecutionException, InterruptedException, TimeoutException {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7)),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    // a==2 || b array-contains 7
    checkQuerySnapshotContainsDocuments(
        collection.where(Filter.or(Filter.equalTo("a", 2), Filter.arrayContains("b", 7))),
        "doc3",
        "doc4",
        "doc6");

    // a==2 || b array-contains-any [0, 3]
    checkQuerySnapshotContainsDocuments(
        collection.where(
            Filter.or(Filter.equalTo("a", 2), Filter.arrayContainsAny("b", asList(0, 3)))),
        "doc1",
        "doc4",
        "doc6");
  }

  @Test
  public void testUsingInWithArrayContains()
      throws ExecutionException, InterruptedException, TimeoutException {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7)),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    Query query1 =
        collection.where(
            Filter.or(Filter.inArray("a", asList(2, 3)), Filter.arrayContains("b", 3)));
    checkQuerySnapshotContainsDocuments(query1, "doc3", "doc4", "doc6");

    Query query2 =
        collection.where(
            Filter.and(Filter.inArray("a", asList(2, 3)), Filter.arrayContains("b", 7)));
    checkQuerySnapshotContainsDocuments(query2, "doc3");

    Query query3 =
        collection.where(
            Filter.or(
                Filter.inArray("a", asList(2, 3)),
                Filter.and(Filter.arrayContains("b", 3), Filter.equalTo("a", 1))));
    checkQuerySnapshotContainsDocuments(query3, "doc3", "doc4", "doc6");

    Query query4 =
        collection.where(
            Filter.and(
                Filter.inArray("a", asList(2, 3)),
                Filter.or(Filter.arrayContains("b", 7), Filter.equalTo("a", 1))));
    checkQuerySnapshotContainsDocuments(query4, "doc3");
  }

  @Test
  public void testOrderByEquality()
      throws ExecutionException, InterruptedException, TimeoutException {
    assumeTrue(
        "Skip this test if running against production because order-by-equality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7), "c", 10),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2, "c", 20));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    Query query1 = collection.where(Filter.equalTo("a", 1)).orderBy("a");
    checkQuerySnapshotContainsDocuments(query1, "doc1", "doc4", "doc5");

    Query query2 = collection.where(Filter.inArray("a", asList(2, 3))).orderBy("a");
    checkQuerySnapshotContainsDocuments(query2, "doc6", "doc3");
  }

  /** Multiple Inequality */
  @Test
  public void multipleInequalityOnDifferentFields() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1", map("key", "a", "sort", 0, "v", 0),
                "doc2", map("key", "b", "sort", 3, "v", 1),
                "doc3", map("key", "c", "sort", 1, "v", 3),
                "doc4", map("key", "d", "sort", 2, "v", 2)));

    Query query1 =
        collection
            .whereNotEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .whereGreaterThan("v", 2);
    checkQuerySnapshotContainsDocuments(query1, "doc3");

    // Duplicate inequality fields
    Query query2 =
        collection
            .whereNotEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .whereGreaterThan("sort", 1);
    checkQuerySnapshotContainsDocuments(query2, "doc4");

    // With multiple IN
    Query query3 =
        collection
            .whereGreaterThanOrEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .whereIn("v", asList(2, 3, 4))
            .whereIn("sort", asList(2, 3));
    checkQuerySnapshotContainsDocuments(query3, "doc4");

    // With NOT-IN
    Query query4 =
        collection
            .whereGreaterThanOrEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .whereNotIn("v", asList(2, 4, 5));
    checkQuerySnapshotContainsDocuments(query4, "doc1", "doc3");

    // With orderby
    Query query5 =
        collection
            .whereGreaterThanOrEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .orderBy("v", Direction.DESCENDING);
    checkQuerySnapshotContainsDocuments(query5, "doc3", "doc4", "doc1");

    // With limit
    Query query6 =
        collection
            .whereGreaterThanOrEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .orderBy("v", Direction.DESCENDING)
            .limit(2);
    checkQuerySnapshotContainsDocuments(query6, "doc3", "doc4");

    // With limitToLast
    Query query7 =
        collection
            .whereGreaterThanOrEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .orderBy("v", Direction.DESCENDING)
            .limitToLast(2);
    checkQuerySnapshotContainsDocuments(query7, "doc4", "doc1");
  }

  @Test
  public void multipleInequalityOnSpecialValues() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1", map("key", "a", "sort", 0, "v", 0),
                "doc2", map("key", "b", "sort", Double.NaN, "v", 1),
                "doc3", map("key", "c", "sort", null, "v", 3),
                "doc4", map("key", "d", "v", 2),
                "doc5", map("key", "e", "sort", 0),
                "doc6", map("key", "f", "sort", 1, "v", 1)));

    Query query1 = collection.whereNotEqualTo("key", "a").whereLessThanOrEqualTo("sort", 2);
    checkQuerySnapshotContainsDocuments(query1, "doc5", "doc6");

    Query query2 =
        collection
            .whereNotEqualTo("key", "a")
            .whereLessThanOrEqualTo("sort", 2)
            .whereLessThanOrEqualTo("v", 1);
    checkQuerySnapshotContainsDocuments(query2, "doc6");
  }

  @Test
  public void multipleInequalityWithArrayMembership() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1",
                map("key", "a", "sort", 0, "v", asList(0)),
                "doc2",
                map("key", "b", "sort", 1, "v", asList(0, 1, 3)),
                "doc3",
                map("key", "c", "sort", 1, "v", asList()),
                "doc4",
                map("key", "d", "sort", 2, "v", asList(1)),
                "doc5",
                map("key", "e", "sort", 3, "v", asList(2, 4)),
                "doc6",
                map("key", "f", "sort", 4, "v", Arrays.asList(Double.NaN)),
                "doc7",
                map("key", "g", "sort", 4, "v", Collections.singletonList(null))));

    Query query1 =
        collection
            .whereNotEqualTo("key", "a")
            .whereGreaterThanOrEqualTo("sort", 1)
            .whereArrayContains("v", 0);
    checkQuerySnapshotContainsDocuments(query1, "doc2");

    Query query2 =
        collection
            .whereNotEqualTo("key", "a")
            .whereGreaterThanOrEqualTo("sort", 1)
            .whereArrayContainsAny("v", asList(0, 1));
    checkQuerySnapshotContainsDocuments(query2, "doc2", "doc4");
  }

  private static Map<String, Object> nestedObject(int number) {
    return map(
        "name",
        String.format("room %d", number),
        "metadata",
        map("createdAt", number),
        "field",
        String.format("field %d", number),
        "field.dot",
        number,
        "field\\slash",
        number);
  }

  // Use cursor in following test cases to add implicit order by fields in the sdk and compare the
  // result with the query fields normalized in the server.
  @Test
  public void multipleInequalityWithNestedField() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1", nestedObject(400),
                "doc2", nestedObject(200),
                "doc3", nestedObject(100),
                "doc4", nestedObject(300)));

    // ordered by: name asc, metadata.createdAt asc, __name__ asc
    Query query1 =
        collection
            .whereLessThanOrEqualTo("metadata.createdAt", 500)
            .whereGreaterThan("metadata.createdAt", 100)
            .whereNotEqualTo("name", "room 200")
            .orderBy("name");
    DocumentSnapshot docSnap = collection.document("doc4").get().get();
    Query query1WithCursor = query1.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query1, "doc4", "doc1");
    checkQuerySnapshotContainsDocuments(query1WithCursor, "doc4", "doc1");

    // ordered by: name desc, field desc, field.dot desc, field\\slash desc, __name__ desc
    Query query2 =
        collection
            .whereGreaterThanOrEqualTo("field", "field 100")
            .whereNotEqualTo(FieldPath.of("field.dot"), 300)
            .whereLessThan("field\\slash", 400)
            .orderBy("name", Direction.DESCENDING);
    docSnap = collection.document("doc2").get().get();
    Query query2WithCursor = query2.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query2, "doc2", "doc3");
    checkQuerySnapshotContainsDocuments(query2WithCursor, "doc2", "doc3");
  }

  @Test
  public void multipleInequalityWithCompositeFilters() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1",
                map("key", "a", "sort", 0, "v", 5),
                "doc2",
                map("key", "aa", "sort", 4, "v", 4),
                "doc3",
                map("key", "c", "sort", 3, "v", 3),
                "doc4",
                map("key", "b", "sort", 2, "v", 2),
                "doc5",
                map("key", "b", "sort", 2, "v", 1),
                "doc6",
                map("key", "b", "sort", 0, "v", 0)));

    // Implicitly ordered by: 'key' asc, 'sort' asc, 'v' asc, __name__ asc
    Query query1 =
        collection.where(
            Filter.or(
                Filter.and(Filter.equalTo("key", "b"), Filter.lessThanOrEqualTo("sort", 2)),
                Filter.and(Filter.notEqualTo("key", "b"), Filter.greaterThan("v", 4))));
    DocumentSnapshot docSnap = collection.document("doc1").get().get();
    Query query1WithCursor = query1.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query1, "doc1", "doc6", "doc5", "doc4");
    checkQuerySnapshotContainsDocuments(query1WithCursor, "doc1", "doc6", "doc5", "doc4");

    // Ordered by: 'sort' desc, 'key' asc, 'v' asc, __name__ asc
    Query query2 =
        collection
            .where(
                Filter.or(
                    Filter.and(Filter.equalTo("key", "b"), Filter.lessThanOrEqualTo("sort", 2)),
                    Filter.and(Filter.notEqualTo("key", "b"), Filter.greaterThan("v", 4))))
            .orderBy("sort", Direction.DESCENDING)
            .orderBy("key");
    docSnap = collection.document("doc5").get().get();
    Query query2WithCursor = query2.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query2, "doc5", "doc4", "doc1", "doc6");
    checkQuerySnapshotContainsDocuments(query2WithCursor, "doc5", "doc4", "doc1", "doc6");

    // Implicitly ordered by: 'key' asc, 'sort' asc, 'v' asc, __name__ asc
    Query query3 =
        collection.where(
            Filter.and(
                Filter.or(
                    Filter.and(Filter.equalTo("key", "b"), Filter.lessThanOrEqualTo("sort", 4)),
                    Filter.and(Filter.notEqualTo("key", "b"), Filter.greaterThanOrEqualTo("v", 4))),
                Filter.or(
                    Filter.and(
                        Filter.greaterThan("key", "b"), Filter.greaterThanOrEqualTo("sort", 1)),
                    Filter.and(Filter.lessThan("key", "b"), Filter.greaterThan("v", 0)))));
    docSnap = collection.document("doc1").get().get();
    Query query3WithCursor = query3.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query3, "doc1", "doc2");
    checkQuerySnapshotContainsDocuments(query3WithCursor, "doc1", "doc2");
  }

  @Test
  public void multipleInequalityFieldsWillBeImplicitlyOrderedLexicographicallyByServer()
      throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1",
                map("key", "a", "sort", 0, "v", 5),
                "doc2",
                map("key", "aa", "sort", 4, "v", 4),
                "doc3",
                map("key", "b", "sort", 3, "v", 3),
                "doc4",
                map("key", "b", "sort", 2, "v", 2),
                "doc5",
                map("key", "b", "sort", 2, "v", 1),
                "doc6",
                map("key", "b", "sort", 0, "v", 0)));

    DocumentSnapshot docSnap = collection.document("doc2").get().get();

    // Implicitly ordered by: 'key' asc, 'sort' asc, __name__ asc
    Query query1 =
        collection
            .whereNotEqualTo("key", "a")
            .whereGreaterThan("sort", 1)
            .whereIn("v", asList(1, 2, 3, 4));
    Query query1WithCursor = query1.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query1, "doc2", "doc4", "doc5", "doc3");
    checkQuerySnapshotContainsDocuments(query1WithCursor, "doc2", "doc4", "doc5", "doc3");

    // Implicitly ordered by: 'key' asc, 'sort' asc, __name__ asc
    Query query2 =
        collection
            .whereGreaterThan("sort", 1)
            .whereNotEqualTo("key", "a")
            .whereIn("v", asList(1, 2, 3, 4));
    Query query2WithCursor = query2.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query2, "doc2", "doc4", "doc5", "doc3");
    checkQuerySnapshotContainsDocuments(query2WithCursor, "doc2", "doc4", "doc5", "doc3");
  }

  @Test
  public void multipleInequalityWithMultipleExplicitOrderBy() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1",
                map("key", "a", "sort", 5, "v", 0),
                "doc2",
                map("key", "aa", "sort", 4, "v", 0),
                "doc3",
                map("key", "b", "sort", 3, "v", 1),
                "doc4",
                map("key", "b", "sort", 2, "v", 1),
                "doc5",
                map("key", "bb", "sort", 1, "v", 1),
                "doc6",
                map("key", "c", "sort", 0, "v", 2)));

    DocumentSnapshot docSnap = collection.document("doc2").get().get();

    // Ordered by: 'v' asc, 'key' asc, 'sort' asc, __name__ asc
    Query query1 =
        collection.whereGreaterThan("key", "a").whereGreaterThanOrEqualTo("sort", 1).orderBy("v");
    Query query1WithCursor = query1.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query1, "doc2", "doc4", "doc3", "doc5");
    checkQuerySnapshotContainsDocuments(query1WithCursor, "doc2", "doc4", "doc3", "doc5");

    // Ordered by: 'v asc, 'sort' asc, 'key' asc,  __name__ asc
    Query query2 =
        collection
            .whereGreaterThan("key", "a")
            .whereGreaterThanOrEqualTo("sort", 1)
            .orderBy("v")
            .orderBy("sort");
    Query query2WithCursor = query2.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query2, "doc2", "doc5", "doc4", "doc3");
    checkQuerySnapshotContainsDocuments(query2WithCursor, "doc2", "doc5", "doc4", "doc3");

    docSnap = collection.document("doc5").get().get();

    // Implicit order by matches the direction of last explicit order by.
    // Ordered by: 'v' desc, 'key' desc, 'sort' desc, __name__ desc
    Query query3 =
        collection
            .whereGreaterThan("key", "a")
            .whereGreaterThanOrEqualTo("sort", 1)
            .orderBy("v", Direction.DESCENDING);
    Query query3WithCursor = query3.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query3, "doc5", "doc3", "doc4", "doc2");
    checkQuerySnapshotContainsDocuments(query3WithCursor, "doc5", "doc3", "doc4", "doc2");

    // Ordered by: 'v desc, 'sort' asc, 'key' asc,  __name__ asc
    Query query4 =
        collection
            .whereGreaterThan("key", "a")
            .whereGreaterThanOrEqualTo("sort", 1)
            .orderBy("v", Direction.DESCENDING)
            .orderBy("sort");
    Query query4WithCursor = query4.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query4, "doc5", "doc4", "doc3", "doc2");
    checkQuerySnapshotContainsDocuments(query4WithCursor, "doc5", "doc4", "doc3", "doc2");
  }

  @Test
  public void multipleInequalityFieldsInAggregateQuery() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1",
                map("key", "a", "sort", 5, "v", 0),
                "doc2",
                map("key", "aa", "sort", 4, "v", 0),
                "doc3",
                map("key", "b", "sort", 3, "v", 1),
                "doc4",
                map("key", "b", "sort", 2, "v", 1),
                "doc5",
                map("key", "bb", "sort", 1, "v", 1)));

    AggregateQuery query =
        collection
            .whereGreaterThan("key", "a")
            .whereGreaterThanOrEqualTo("sort", 1)
            .orderBy("v")
            .count();
    assertThat(query.get().get().getCount()).isEqualTo(4);
    // TODO(MIEQ): Add sum and average when they are public.
  }

  @Test
  public void multipleInequalityFieldsWithDocumentKey() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    CollectionReference collection =
        testCollectionWithDocs(
            map(
                "doc1",
                map("key", "a", "sort", 5),
                "doc2",
                map("key", "aa", "sort", 4),
                "doc3",
                map("key", "b", "sort", 3),
                "doc4",
                map("key", "b", "sort", 2),
                "doc5",
                map("key", "bb", "sort", 1)));

    DocumentSnapshot docSnap = collection.document("doc2").get().get();

    // Document Key in inequality field will implicitly ordered to the last.
    // Implicitly ordered by: 'key' asc, 'sort' asc, __name__ asc
    Query query1 =
        collection
            .whereGreaterThan("sort", 1)
            .whereNotEqualTo("key", "a")
            .whereLessThan(FieldPath.documentId(), "doc5");
    Query query1WithCursor = query1.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query1, "doc2", "doc4", "doc3");
    checkQuerySnapshotContainsDocuments(query1WithCursor, "doc2", "doc4", "doc3");

    // Changing filters order will not affect implicit order.
    // Implicitly ordered by: 'key' asc, 'sort' asc, __name__ asc
    Query query2 =
        collection
            .whereLessThan(FieldPath.documentId(), "doc5")
            .whereGreaterThan("sort", 1)
            .whereNotEqualTo("key", "a");
    Query query2WithCursor = query2.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query2, "doc2", "doc4", "doc3");
    checkQuerySnapshotContainsDocuments(query2WithCursor, "doc2", "doc4", "doc3");

    // Ordered by: 'sort' desc, 'key' desc, __name__ desc
    Query query3 =
        collection
            .whereLessThan(FieldPath.documentId(), "doc5")
            .whereGreaterThan("sort", 1)
            .whereNotEqualTo("key", "a")
            .orderBy("sort", Direction.DESCENDING);
    Query query3WithCursor = query3.startAt(docSnap);
    checkQuerySnapshotContainsDocuments(query3, "doc2", "doc3", "doc4");
    checkQuerySnapshotContainsDocuments(query3WithCursor, "doc2", "doc3", "doc4");
  }

  @Test
  public void testQueryPlan() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7), "c", 10),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2, "c", 20));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    Query query = collection.where(Filter.equalTo("a", 1)).orderBy("a");
    ExplainResults<QuerySnapshot> explainResults =
        query.explain(ExplainOptions.builder().setAnalyze(false).build()).get();

    @Nullable QuerySnapshot snapshot = explainResults.getSnapshot();
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
  public void testQueryProfile() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7), "c", 10),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2, "c", 20));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    Query query = collection.where(Filter.equalTo("a", 1)).orderBy("a");
    ExplainResults<QuerySnapshot> explainResults =
        query.explain(ExplainOptions.builder().setAnalyze(true).build()).get();

    @Nullable QuerySnapshot snapshot = explainResults.getSnapshot();
    assertThat(snapshot).isNotNull();
    assertThat(snapshot.size()).isEqualTo(3);

    ExplainMetrics metrics = explainResults.getMetrics();
    assertThat(metrics).isNotNull();

    PlanSummary planSummary = metrics.getPlanSummary();
    assertThat(planSummary).isNotNull();
    assertThat(planSummary.getIndexesUsed()).isNotEmpty();

    ExecutionStats stats = metrics.getExecutionStats();
    assertThat(stats).isNotNull();
    assertThat(stats.getDebugStats()).isNotEmpty();
    assertThat(stats.getReadOperations()).isEqualTo(3);
    assertThat(stats.getResultsReturned()).isEqualTo(3);
    assertThat(stats.getExecutionDuration()).isGreaterThan(Duration.ZERO);
  }

  @Test
  public void testQueryProfileForQueryWithNoResultSet() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7), "c", 10),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2, "c", 20));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    Query query = collection.where(Filter.equalTo("a", 100)).orderBy("a");

    // Regular query execution (get).
    QuerySnapshot getSnapshot = query.get().get();
    assertThat(getSnapshot.size()).isEqualTo(0);

    // Explain.
    ExplainResults<QuerySnapshot> explainResults =
        query.explain(ExplainOptions.builder().setAnalyze(true).build()).get();

    @Nullable QuerySnapshot snapshot = explainResults.getSnapshot();
    assertThat(snapshot).isNotNull();
    assertThat(snapshot.size()).isEqualTo(0);

    ExplainMetrics metrics = explainResults.getMetrics();
    assertThat(metrics).isNotNull();

    PlanSummary planSummary = metrics.getPlanSummary();
    assertThat(planSummary).isNotNull();
    assertThat(planSummary.getIndexesUsed()).isNotEmpty();

    ExecutionStats stats = metrics.getExecutionStats();
    assertThat(stats).isNotNull();
    assertThat(stats.getDebugStats()).isNotEmpty();
    assertThat(stats.getReadOperations()).isGreaterThan(0);
    assertThat(stats.getResultsReturned()).isEqualTo(0);
    assertThat(stats.getExecutionDuration()).isGreaterThan(Duration.ZERO);
  }

  @Test
  public void testExplainStreamWithoutAnalyze() throws Exception {
    CollectionReference collection = testCollectionWithDocs(Collections.emptyMap());
    Query query = collection.where(Filter.equalTo("a", 1)).orderBy("a");

    ApiFuture<ExplainMetrics> metricsFuture =
        query.explainStream(
            ExplainOptions.builder().setAnalyze(false).build(),
            new ApiStreamObserver<DocumentSnapshot>() {
              @Override
              public void onNext(DocumentSnapshot documentSnapshot) {
                fail("No DocumentSnapshot should be received because analyze option was disabled.");
              }

              @Override
              public void onError(Throwable throwable) {
                fail(throwable.getMessage());
              }

              @Override
              public void onCompleted() {}
            });

    ExplainMetrics metrics = metricsFuture.get();
    assertThat(metrics.getPlanSummary().getIndexesUsed().size()).isGreaterThan(0);
    assertThat(metrics.getExecutionStats()).isNull();
  }

  @Test
  public void testExplainStreamWithAnalyze() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7), "c", 10),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2, "c", 20));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    Query query = collection.where(Filter.equalTo("a", 1)).orderBy("a");

    final Iterator<String> iterator = Arrays.asList("doc1", "doc4", "doc5").iterator();

    ApiFuture<ExplainMetrics> metricsFuture =
        query.explainStream(
            ExplainOptions.builder().setAnalyze(true).build(),
            new ApiStreamObserver<DocumentSnapshot>() {
              @Override
              public void onNext(DocumentSnapshot documentSnapshot) {
                assertEquals(iterator.next(), documentSnapshot.getId());
              }

              @Override
              public void onError(Throwable throwable) {
                fail(throwable.getMessage());
              }

              @Override
              public void onCompleted() {}
            });

    ExplainMetrics metrics = metricsFuture.get();
    assertThat(metrics.getPlanSummary().getIndexesUsed().size()).isGreaterThan(0);
    assertThat(metrics.getExecutionStats()).isNotNull();
    assertThat(metrics.getExecutionStats().getResultsReturned()).isEqualTo(3);
  }

  @Test
  public void testAggregateQueryPlan() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7), "c", 10),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2, "c", 20));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    AggregateQuery query = collection.where(Filter.equalTo("a", 1)).orderBy("a").count();

    ExplainResults<AggregateQuerySnapshot> explainResults =
        query.explain(ExplainOptions.builder().setAnalyze(false).build()).get();

    @Nullable AggregateQuerySnapshot snapshot = explainResults.getSnapshot();
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
  public void testAggregateQueryProfile() throws Exception {
    Map<String, Map<String, Object>> testDocs =
        map(
            "doc1", map("a", 1, "b", asList(0)),
            "doc2", map("b", asList(1)),
            "doc3", map("a", 3, "b", asList(2, 7), "c", 10),
            "doc4", map("a", 1, "b", asList(3, 7)),
            "doc5", map("a", 1),
            "doc6", map("a", 2, "c", 20));
    CollectionReference collection = testCollectionWithDocs(testDocs);

    AggregateQuery query = collection.where(Filter.equalTo("a", 1)).orderBy("a").count();

    ExplainResults<AggregateQuerySnapshot> explainResults =
        query.explain(ExplainOptions.builder().setAnalyze(true).build()).get();

    @Nullable AggregateQuerySnapshot snapshot = explainResults.getSnapshot();
    assertThat(snapshot).isNotNull();
    assertThat(snapshot.getCount()).isEqualTo(3);

    ExplainMetrics metrics = explainResults.getMetrics();
    assertThat(metrics).isNotNull();

    PlanSummary planSummary = metrics.getPlanSummary();
    assertThat(planSummary).isNotNull();
    assertThat(planSummary.getIndexesUsed()).isNotEmpty();

    ExecutionStats stats = metrics.getExecutionStats();
    assertThat(stats).isNotNull();
    assertThat(stats.getDebugStats()).isNotEmpty();
    assertThat(stats.getReadOperations()).isEqualTo(1);
    assertThat(stats.getResultsReturned()).isEqualTo(1);
    assertThat(stats.getExecutionDuration()).isGreaterThan(Duration.ZERO);
  }

  @Test
  public void snapshotListenerSortsNumbersSameWayAsServer() throws Exception {
    CollectionReference col = createEmptyCollection();
    firestore
        .batch()
        .set(col.document("intMin"), map("value", Long.MIN_VALUE))
        .set(col.document("doubleMin"), map("value", ((double) Long.MIN_VALUE) - 100))
        .set(col.document("intMax"), map("value", Long.MAX_VALUE))
        .set(col.document("doubleMax"), map("value", ((double) Long.MAX_VALUE) + 100))
        .set(col.document("NaN"), map("value", Double.NaN))
        .set(col.document("integerMax"), map("value", (long) Integer.MAX_VALUE))
        .set(col.document("integerMin"), map("value", (long) Integer.MIN_VALUE))
        .set(col.document("negativeInfinity"), map("value", Double.NEGATIVE_INFINITY))
        .set(col.document("positiveInfinity"), map("value", Double.POSITIVE_INFINITY))
        .commit()
        .get();

    Query query = col.orderBy("value", Direction.ASCENDING);

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();
    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));
              latch.countDown();
            });
    latch.await();
    registration.remove();

    assertEquals(queryOrder, listenerOrder); // Assert order in the SDK
  }

  @Test
  public void snapshotListenerSortsUnicodeStringsSameWayAsServer() throws Exception {
    CollectionReference col = createEmptyCollection();

    firestore
        .batch()
        .set(col.document("a"), map("value", "Łukasiewicz"))
        .set(col.document("b"), map("value", "Sierpiński"))
        .set(col.document("c"), map("value", "岩澤"))
        .set(col.document("d"), map("value", "🄟"))
        .set(col.document("e"), map("value", "Ｐ"))
        .set(col.document("f"), map("value", "︒"))
        .set(col.document("g"), map("value", "🐵"))
        .set(col.document("h"), map("value", "你好"))
        .set(col.document("i"), map("value", "你顥"))
        .set(col.document("j"), map("value", "😁"))
        .set(col.document("k"), map("value", "😀"))
        .commit()
        .get();

    Query query = col.orderBy("value", Direction.ASCENDING);

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();
    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));
              latch.countDown();
            });
    latch.await();
    registration.remove();

    assertEquals(queryOrder, Arrays.asList("b", "a", "h", "i", "c", "f", "e", "d", "g", "k", "j"));
    assertEquals(queryOrder, listenerOrder);
  }

  @Test
  public void snapshotListenerSortsUnicodeStringsInArraySameWayAsServer() throws Exception {
    CollectionReference col = createEmptyCollection();

    firestore
        .batch()
        .set(col.document("a"), map("value", Arrays.asList("Łukasiewicz")))
        .set(col.document("b"), map("value", Arrays.asList("Sierpiński")))
        .set(col.document("c"), map("value", Arrays.asList("岩澤")))
        .set(col.document("d"), map("value", Arrays.asList("🄟")))
        .set(col.document("e"), map("value", Arrays.asList("Ｐ")))
        .set(col.document("f"), map("value", Arrays.asList("︒")))
        .set(col.document("g"), map("value", Arrays.asList("🐵")))
        .set(col.document("h"), map("value", Arrays.asList("你好")))
        .set(col.document("i"), map("value", Arrays.asList("你顥")))
        .set(col.document("j"), map("value", Arrays.asList("😁")))
        .set(col.document("k"), map("value", Arrays.asList("😀")))
        .commit()
        .get();

    Query query = col.orderBy("value", Direction.ASCENDING);

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();
    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));
              latch.countDown();
            });
    latch.await();
    registration.remove();

    assertEquals(queryOrder, Arrays.asList("b", "a", "h", "i", "c", "f", "e", "d", "g", "k", "j"));
    assertEquals(queryOrder, listenerOrder);
  }

  @Test
  public void snapshotListenerSortsUnicodeStringsInMapSameWayAsServer() throws Exception {
    CollectionReference col = createEmptyCollection();

    firestore
        .batch()
        .set(col.document("a"), map("value", map("foo", "Łukasiewicz")))
        .set(col.document("b"), map("value", map("foo", "Sierpiński")))
        .set(col.document("c"), map("value", map("foo", "岩澤")))
        .set(col.document("d"), map("value", map("foo", "🄟")))
        .set(col.document("e"), map("value", map("foo", "Ｐ")))
        .set(col.document("f"), map("value", map("foo", "︒")))
        .set(col.document("g"), map("value", map("foo", "🐵")))
        .set(col.document("h"), map("value", map("foo", "你好")))
        .set(col.document("i"), map("value", map("foo", "你顥")))
        .set(col.document("j"), map("value", map("foo", "😁")))
        .set(col.document("k"), map("value", map("foo", "😀")))
        .commit()
        .get();

    Query query = col.orderBy("value", Direction.ASCENDING);

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();
    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));
              latch.countDown();
            });
    latch.await();
    registration.remove();

    assertEquals(queryOrder, Arrays.asList("b", "a", "h", "i", "c", "f", "e", "d", "g", "k", "j"));
    assertEquals(queryOrder, listenerOrder);
  }

  @Test
  public void snapshotListenerSortsUnicodeStringsInMapKeySameWayAsServer() throws Exception {
    CollectionReference col = createEmptyCollection();

    firestore
        .batch()
        .set(col.document("a"), map("value", map("Łukasiewicz", "foo")))
        .set(col.document("b"), map("value", map("Sierpiński", "foo")))
        .set(col.document("c"), map("value", map("岩澤", "foo")))
        .set(col.document("d"), map("value", map("🄟", "foo")))
        .set(col.document("e"), map("value", map("Ｐ", "foo")))
        .set(col.document("f"), map("value", map("︒", "foo")))
        .set(col.document("g"), map("value", map("🐵", "foo")))
        .set(col.document("h"), map("value", map("你好", "foo")))
        .set(col.document("i"), map("value", map("你顥", "foo")))
        .set(col.document("j"), map("value", map("😁", "foo")))
        .set(col.document("k"), map("value", map("😀", "foo")))
        .commit()
        .get();

    Query query = col.orderBy("value", Direction.ASCENDING);

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();
    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));
              latch.countDown();
            });
    latch.await();
    registration.remove();

    assertEquals(queryOrder, Arrays.asList("b", "a", "h", "i", "c", "f", "e", "d", "g", "k", "j"));
    assertEquals(queryOrder, listenerOrder);
  }

  @Test
  public void snapshotListenerSortsUnicodeStringsInDocumentKeySameWayAsServer() throws Exception {
    CollectionReference col = createEmptyCollection();

    firestore
        .batch()
        .set(col.document("Łukasiewicz"), map("value", "foo"))
        .set(col.document("Sierpiński"), map("value", "foo"))
        .set(col.document("岩澤"), map("value", "foo"))
        .set(col.document("🄟"), map("value", "foo"))
        .set(col.document("Ｐ"), map("value", "foo"))
        .set(col.document("︒"), map("value", "foo"))
        .set(col.document("🐵"), map("value", "foo"))
        .set(col.document("你好"), map("value", "你好"))
        .set(col.document("你顥"), map("value", "你顥"))
        .set(col.document("😁"), map("value", "😁"))
        .set(col.document("😀"), map("value", "😀"))
        .commit()
        .get();

    Query query = col.orderBy(FieldPath.documentId());

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();
    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));
              latch.countDown();
            });
    latch.await();
    registration.remove();

    assertEquals(
        queryOrder,
        Arrays.asList(
            "Sierpiński", "Łukasiewicz", "你好", "你顥", "岩澤", "︒", "Ｐ", "🄟", "🐵", "😀", "😁"));
    assertEquals(queryOrder, listenerOrder);
  }

  @Test
  public void snapshotListenerSortsInvalidUnicodeStringsSameWayAsServer() throws Exception {
    CollectionReference col = createEmptyCollection();

    // Note: Protocol Buffer converts any invalid surrogates to "?".
    firestore
        .batch()
        .set(col.document("a"), map("value", "Z"))
        .set(col.document("b"), map("value", "你好"))
        .set(col.document("c"), map("value", "😀"))
        .set(col.document("d"), map("value", "ab\uD800")) // Lone high surrogate
        .set(col.document("e"), map("value", "ab\uDC00")) // Lone low surrogate
        .set(col.document("f"), map("value", "ab\uD800\uD800")) // Unpaired high surrogate
        .set(col.document("g"), map("value", "ab\uDC00\uDC00")) // Unpaired low surrogate
        .commit()
        .get();

    Query query = col.orderBy("value", Direction.ASCENDING);

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();
    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));
              latch.countDown();
            });
    latch.await();
    registration.remove();

    assertEquals(queryOrder, Arrays.asList("a", "d", "e", "f", "g", "b", "c"));
    assertEquals(queryOrder, listenerOrder);
  }
}
