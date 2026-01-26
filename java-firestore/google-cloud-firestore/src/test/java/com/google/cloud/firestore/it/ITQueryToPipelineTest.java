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

package com.google.cloud.firestore.it;

import static com.google.cloud.firestore.it.ITQueryTest.map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.Filter;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.PipelineResult;
import com.google.cloud.firestore.Query;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITQueryToPipelineTest extends ITBaseTest {

  public CollectionReference testCollectionWithDocs(Map<String, Map<String, Object>> docs)
      throws ExecutionException, InterruptedException, TimeoutException {
    CollectionReference collection = firestore.collection(LocalFirestoreHelper.autoId());
    for (Map.Entry<String, Map<String, Object>> doc : docs.entrySet()) {
      collection.document(doc.getKey()).set(doc.getValue()).get(5, TimeUnit.SECONDS);
    }
    return collection;
  }

  List<Map<String, Object>> data(List<PipelineResult> results) {
    return results.stream().map(PipelineResult::getData).collect(Collectors.toList());
  }

  @Before
  public void setup() throws Exception {
    assumeTrue(
        "This test suite only runs against the Enterprise edition.",
        getFirestoreEdition().equals(FirestoreEdition.ENTERPRISE));
  }

  private Object normalizeNumbers(Object value) {
    if (value instanceof Number) {
      if (value instanceof Double || value instanceof Float) {
        return ((Number) value).doubleValue();
      }
      return ((Number) value).longValue();
    }
    if (value instanceof List) {
      return ((List<?>) value).stream().map(this::normalizeNumbers).collect(Collectors.toList());
    }
    if (value instanceof Map) {
      Map<String, Object> newMap = new HashMap<>();
      ((Map<?, ?>) value).forEach((k, v) -> newMap.put((String) k, normalizeNumbers(v)));
      return newMap;
    }
    return value;
  }

  private Map<String, Object> normalizeMap(Map<String, Object> map) {
    Map<String, Object> newMap = new HashMap<>();
    map.forEach((key, value) -> newMap.put(key, normalizeNumbers(value)));
    return newMap;
  }

  private void verifyResults(List<PipelineResult> actual, Map<String, Object>... expected) {
    List<Map<String, Object>> actualData = data(actual);
    assertEquals(expected.length, actualData.size());
    for (int i = 0; i < expected.length; ++i) {
      Map<String, Object> expectedMap = normalizeMap(expected[i]);
      Map<String, Object> actualMap = normalizeMap(actualData.get(i));
      assertEquals(expectedMap, actualMap);
    }
  }

  @Test
  public void supportsDefaultQuery() throws Exception {
    CollectionReference collRef = testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L)));
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(collRef).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));
  }

  @Test
  public void supportsFilteredQuery() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.whereEqualTo("foo", 1L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));
  }

  @Test
  public void supportsFilteredQueryWithFieldPath() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.whereEqualTo(FieldPath.of("foo"), 1L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));
  }

  @Test
  public void supportsOrderedQueryWithDefaultOrder() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo");
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L), map("foo", 2L));
  }

  @Test
  public void supportsOrderedQueryWithAsc() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo", Query.Direction.ASCENDING);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L), map("foo", 2L));
  }

  @Test
  public void supportsOrderedQueryWithDesc() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo", Query.Direction.DESCENDING);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L), map("foo", 1L));
  }

  @Test
  public void supportsLimitQuery() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo").limit(1);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));
  }

  @Test
  public void supportsLimitToLastQuery() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L), "3", map("foo", 3L)));
    Query query1 = collRef.orderBy("foo").limitToLast(2);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L), map("foo", 3L));
  }

  @Test
  public void supportsStartAt() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo").startAt(2L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L));
  }

  @Test
  public void supportsStartAtWithLimitToLast() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L),
                "2", map("foo", 2L),
                "3", map("foo", 3L),
                "4", map("foo", 4L),
                "5", map("foo", 5L)));
    Query query1 = collRef.orderBy("foo").startAt(3L).limitToLast(4);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 3L), map("foo", 4L), map("foo", 5L));
  }

  @Test
  public void supportsEndAtWithLimitToLast() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L),
                "2", map("foo", 2L),
                "3", map("foo", 3L),
                "4", map("foo", 4L),
                "5", map("foo", 5L)));
    Query query1 = collRef.orderBy("foo").endAt(3L).limitToLast(2);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L), map("foo", 3L));
  }

  @Test
  public void supportsStartAfterWithDocumentSnapshot() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.<String, Map<String, Object>>builder()
                .put("1", map("id", 1L, "foo", 1L, "bar", 1L, "baz", 1L))
                .put("2", map("id", 2L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("3", map("id", 3L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("4", map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L))
                .put("5", map("id", 5L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("6", map("id", 6L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("7", map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L))
                .put("8", map("id", 8L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("9", map("id", 9L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("10", map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L))
                .put("11", map("id", 11L, "foo", 2L, "bar", 2L, "baz", 2L))
                .put("12", map("id", 12L, "foo", 2L, "bar", 2L, "baz", 2L))
                .build());
    DocumentSnapshot docRef = collRef.document("2").get().get();
    Query query1 = collRef.orderBy("foo").orderBy("bar").orderBy("baz").startAfter(docRef);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(
        snapshot,
        map("id", 3L, "foo", 1L, "bar", 1L, "baz", 2L),
        map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L),
        map("id", 5L, "foo", 1L, "bar", 2L, "baz", 2L),
        map("id", 6L, "foo", 1L, "bar", 2L, "baz", 2L),
        map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L),
        map("id", 8L, "foo", 2L, "bar", 1L, "baz", 2L),
        map("id", 9L, "foo", 2L, "bar", 1L, "baz", 2L),
        map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L),
        map("id", 11L, "foo", 2L, "bar", 2L, "baz", 2L),
        map("id", 12L, "foo", 2L, "bar", 2L, "baz", 2L));
  }

  @Test
  public void supportsStartAtWithDocumentSnapshot() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.<String, Map<String, Object>>builder()
                .put("1", map("id", 1L, "foo", 1L, "bar", 1L, "baz", 1L))
                .put("2", map("id", 2L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("3", map("id", 3L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("4", map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L))
                .put("5", map("id", 5L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("6", map("id", 6L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("7", map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L))
                .put("8", map("id", 8L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("9", map("id", 9L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("10", map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L))
                .put("11", map("id", 11L, "foo", 2L, "bar", 2L, "baz", 2L))
                .put("12", map("id", 12L, "foo", 2L, "bar", 2L, "baz", 2L))
                .build());
    DocumentSnapshot docRef = collRef.document("2").get().get();
    Query query1 = collRef.orderBy("foo").orderBy("bar").orderBy("baz").startAt(docRef);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(
        snapshot,
        map("id", 2L, "foo", 1L, "bar", 1L, "baz", 2L),
        map("id", 3L, "foo", 1L, "bar", 1L, "baz", 2L),
        map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L),
        map("id", 5L, "foo", 1L, "bar", 2L, "baz", 2L),
        map("id", 6L, "foo", 1L, "bar", 2L, "baz", 2L),
        map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L),
        map("id", 8L, "foo", 2L, "bar", 1L, "baz", 2L),
        map("id", 9L, "foo", 2L, "bar", 1L, "baz", 2L),
        map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L),
        map("id", 11L, "foo", 2L, "bar", 2L, "baz", 2L),
        map("id", 12L, "foo", 2L, "bar", 2L, "baz", 2L));
  }

  @Test
  public void supportsStartAfter() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo").startAfter(1L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L));
  }

  @Test
  public void supportsEndAt() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo").endAt(1L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));
  }

  @Test
  public void supportsEndBefore() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo").endBefore(2L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));
  }

  @Test
  public void supportsPagination() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo").limit(1);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));

    Query query2 = query1.startAfter(snapshot.get(0).get("foo"));
    snapshot = firestore.pipeline().createFrom(query2).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L));
  }

  @Test
  public void supportsPaginationOnDocumentIds() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L), "2", map("foo", 2L)));
    Query query1 = collRef.orderBy("foo").orderBy(FieldPath.documentId()).limit(1);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L));

    Query query2 =
        query1.startAfter(snapshot.get(0).get("foo"), snapshot.get(0).getReference().getId());
    snapshot = firestore.pipeline().createFrom(query2).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L));
  }

  @Test
  public void supportsCollectionGroups() throws Exception {
    CollectionReference collRef = testCollectionWithDocs(ImmutableMap.of());
    String collectionGroupId = collRef.getId() + "group";

    firestore
        .document(collRef.getId() + "/foo/" + collectionGroupId + "/doc1")
        .set(map("foo", 1L))
        .get();
    firestore
        .document(collRef.getId() + "/bar/baz/boo/" + collectionGroupId + "/doc2")
        .set(map("bar", 1L))
        .get();

    Query query1 = firestore.collectionGroup(collectionGroupId).orderBy(FieldPath.documentId());
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();

    verifyResults(snapshot, map("bar", 1L), map("foo", 1L));
  }

  @Test
  public void supportsQueryOverCollectionPathWithSpecialCharacters() throws Exception {
    CollectionReference collRef = testCollectionWithDocs(ImmutableMap.of());
    CollectionReference collectionWithSpecials =
        collRef.document("so!@#$%^&*()_+special").collection("so!@#$%^&*()_+special");
    collectionWithSpecials.add(map("foo", 1L)).get();
    collectionWithSpecials.add(map("foo", 2L)).get();

    Query query = collectionWithSpecials.orderBy("foo", Query.Direction.ASCENDING);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query).execute().get().getResults();

    verifyResults(snapshot, map("foo", 1L), map("foo", 2L));
  }

  @Test
  public void supportsMultipleInequalityOnSameField() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.<String, Map<String, Object>>builder()
                .put("01", map("id", 1L, "foo", 1L, "bar", 1L, "baz", 1L))
                .put("02", map("id", 2L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("03", map("id", 3L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("04", map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L))
                .put("05", map("id", 5L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("06", map("id", 6L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("07", map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L))
                .put("08", map("id", 8L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("09", map("id", 9L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("10", map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L))
                .put("11", map("id", 11L, "foo", 2L, "bar", 2L, "baz", 2L))
                .put("12", map("id", 12L, "foo", 2L, "bar", 2L, "baz", 2L))
                .build());
    Query query1 =
        collRef.where(
            Filter.and(Filter.greaterThan("id", 2L), Filter.lessThanOrEqualTo("id", 10L)));
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1.orderBy("id")).execute().get().getResults();
    verifyResults(
        snapshot,
        map("id", 3L, "foo", 1L, "bar", 1L, "baz", 2L),
        map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L),
        map("id", 5L, "foo", 1L, "bar", 2L, "baz", 2L),
        map("id", 6L, "foo", 1L, "bar", 2L, "baz", 2L),
        map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L),
        map("id", 8L, "foo", 2L, "bar", 1L, "baz", 2L),
        map("id", 9L, "foo", 2L, "bar", 1L, "baz", 2L),
        map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L));
  }

  @Test
  public void supportsMultipleInequalityOnDifferentFields() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.<String, Map<String, Object>>builder()
                .put("01", map("id", 1L, "foo", 1L, "bar", 1L, "baz", 1L))
                .put("02", map("id", 2L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("03", map("id", 3L, "foo", 1L, "bar", 1L, "baz", 2L))
                .put("04", map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L))
                .put("05", map("id", 5L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("06", map("id", 6L, "foo", 1L, "bar", 2L, "baz", 2L))
                .put("07", map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L))
                .put("08", map("id", 8L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("09", map("id", 9L, "foo", 2L, "bar", 1L, "baz", 2L))
                .put("10", map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L))
                .put("11", map("id", 11L, "foo", 2L, "bar", 2L, "baz", 2L))
                .put("12", map("id", 12L, "foo", 2L, "bar", 2L, "baz", 2L))
                .build());
    Query query1 =
        collRef.where(
            Filter.and(Filter.greaterThanOrEqualTo("id", 2L), Filter.lessThan("baz", 2L)));
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1.orderBy("id")).execute().get().getResults();
    verifyResults(
        snapshot,
        map("id", 4L, "foo", 1L, "bar", 2L, "baz", 1L),
        map("id", 7L, "foo", 2L, "bar", 1L, "baz", 1L),
        map("id", 10L, "foo", 2L, "bar", 2L, "baz", 1L));
  }

  @Test
  public void supportsCollectionGroupQuery() throws Exception {
    CollectionReference collRef = testCollectionWithDocs(ImmutableMap.of("1", map("foo", 1L)));
    List<PipelineResult> snapshot =
        firestore
            .pipeline()
            .createFrom(firestore.collectionGroup(collRef.getId()))
            .execute()
            .get()
            .getResults();
    verifyResults(snapshot, map("foo", 1L));
  }

  @Test
  public void supportsEqNan() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", Double.NaN),
                "2", map("foo", 2L, "bar", 1L),
                "3", map("foo", 3L, "bar", "bar")));
    Query query1 = collRef.whereEqualTo("bar", Double.NaN);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L, "bar", Double.NaN));
  }

  @Test
  public void supportsNeqNan() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", Double.NaN),
                "2", map("foo", 2L, "bar", 1L),
                "3", map("foo", 3L, "bar", "bar")));
    Query query1 = collRef.whereNotEqualTo("bar", Double.NaN).orderBy("foo");
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L, "bar", 1L), map("foo", 3L, "bar", "bar"));
  }

  @Test
  public void supportsEqNull() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of("1", map("foo", 1L, "bar", null), "2", map("foo", 2L, "bar", 1L)));
    Query query1 = collRef.whereEqualTo("bar", null);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L, "bar", null));
  }

  @Test
  public void supportsNeqNull() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of("1", map("foo", 1L, "bar", null), "2", map("foo", 2L, "bar", 1L)));
    Query query1 = collRef.whereNotEqualTo("bar", null);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L, "bar", 1L));
  }

  @Test
  public void supportsNeq() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of("1", map("foo", 1L, "bar", 0L), "2", map("foo", 2L, "bar", 1L)));
    Query query1 = collRef.whereNotEqualTo("bar", 0L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 2L, "bar", 1L));
  }

  @Test
  public void supportsArrayContains() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", Arrays.asList(0L, 2L, 4L, 6L)),
                "2", map("foo", 2L, "bar", Arrays.asList(1L, 3L, 5L, 7L))));
    Query query1 = collRef.whereArrayContains("bar", 4L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L, "bar", Arrays.asList(0L, 2L, 4L, 6L)));
  }

  @Test
  public void supportsArrayContainsAny() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", Arrays.asList(0L, 2L, 4L, 6L)),
                "2", map("foo", 2L, "bar", Arrays.asList(1L, 3L, 5L, 7L)),
                "3", map("foo", 3L, "bar", Arrays.asList(10L, 20L, 30L, 40L))));
    Query query1 = collRef.whereArrayContainsAny("bar", Arrays.asList(4L, 5L));
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1.orderBy("foo")).execute().get().getResults();
    verifyResults(
        snapshot,
        map("foo", 1L, "bar", Arrays.asList(0L, 2L, 4L, 6L)),
        map("foo", 2L, "bar", Arrays.asList(1L, 3L, 5L, 7L)));
  }

  @Test
  public void supportsIn() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 2L),
                "2", map("foo", 2L),
                "3", map("foo", 3L, "bar", 10L)));
    Query query1 = collRef.whereIn("bar", Arrays.asList(0L, 10L, 20L));
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 3L, "bar", 10L));
  }

  @Test
  public void supportsInWith1() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 2L),
                "2", map("foo", 2L),
                "3", map("foo", 3L, "bar", 10L)));
    Query query1 = collRef.whereIn("bar", Arrays.asList(2L));
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L, "bar", 2L));
  }

  @Test
  public void supportsNotIn() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 2L),
                "2", map("foo", 2L, "bar", 1L),
                "3", map("foo", 3L, "bar", 10L)));
    Query query1 = collRef.whereNotIn("bar", Arrays.asList(0L, 10L, 20L)).orderBy("foo");
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L, "bar", 2L), map("foo", 2L, "bar", 1L));
  }

  @Test
  public void supportsNotInWith1() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 2L),
                "2", map("foo", 2L),
                "3", map("foo", 3L, "bar", 10L)));
    Query query1 = collRef.whereNotIn("bar", Arrays.asList(2L)).orderBy("foo");
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 3L, "bar", 10L));
  }

  @Test
  public void supportsOrOperator() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 2L),
                "2", map("foo", 2L, "bar", 0L),
                "3", map("foo", 3L, "bar", 10L)));
    Query query1 =
        collRef
            .where(Filter.or(Filter.equalTo("bar", 2L), Filter.equalTo("foo", 3L)))
            .orderBy("foo");
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    verifyResults(snapshot, map("foo", 1L, "bar", 2L), map("foo", 3L, "bar", 10L));
  }

  @Test
  public void testNotEqualIncludesMissingField() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 1L),
                "2", map("foo", 2L) // Missing "bar"
                ));
    Query query1 = collRef.whereNotEqualTo("bar", 1L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    // document "2" should be included because "bar" is missing, which is not equal to 1.
    verifyResults(snapshot, map("foo", 2L));
  }

  @Test
  public void testNotInIncludesMissingField() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 1L),
                "2", map("foo", 2L) // Missing "bar"
                ));
    Query query1 = collRef.whereNotIn("bar", Arrays.asList(1L));
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    // document "2" should be included because "bar" is missing, which is not in [1].
    verifyResults(snapshot, map("foo", 2L));
  }

  @Test
  public void testInequalityMaintainsExistenceFilter() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 0L),
                "2", map("foo", 2L) // Missing "bar"
                ));
    Query query1 = collRef.whereLessThan("bar", 1L);
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    // document "2" should be excluded because "bar" is missing.
    verifyResults(snapshot, map("foo", 1L, "bar", 0L));
  }

  @Test
  public void testExplicitOrderMaintainsExistenceFilter() throws Exception {
    CollectionReference collRef =
        testCollectionWithDocs(
            ImmutableMap.of(
                "1", map("foo", 1L, "bar", 1L),
                "2", map("foo", 2L) // Missing "bar"
                ));
    Query query1 = collRef.orderBy("bar");
    List<PipelineResult> snapshot =
        firestore.pipeline().createFrom(query1).execute().get().getResults();
    // document "2" should be excluded because "bar" is missing and we have explicit order.
    verifyResults(snapshot, map("foo", 1L, "bar", 1L));
  }
}
