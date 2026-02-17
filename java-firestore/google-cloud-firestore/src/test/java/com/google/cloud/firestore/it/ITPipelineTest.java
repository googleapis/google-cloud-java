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

import static com.google.cloud.firestore.FieldValue.vector;
import static com.google.cloud.firestore.it.ITQueryTest.map;
import static com.google.cloud.firestore.it.TestHelper.isRunningAgainstFirestoreEmulator;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.count;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.countAll;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.countDistinct;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.countIf;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.sum;
import static com.google.cloud.firestore.pipeline.expressions.Expression.add;
import static com.google.cloud.firestore.pipeline.expressions.Expression.and;
import static com.google.cloud.firestore.pipeline.expressions.Expression.array;
import static com.google.cloud.firestore.pipeline.expressions.Expression.arrayContains;
import static com.google.cloud.firestore.pipeline.expressions.Expression.arrayContainsAll;
import static com.google.cloud.firestore.pipeline.expressions.Expression.arrayContainsAny;
import static com.google.cloud.firestore.pipeline.expressions.Expression.arrayGet;
import static com.google.cloud.firestore.pipeline.expressions.Expression.arrayReverse;
import static com.google.cloud.firestore.pipeline.expressions.Expression.ceil;
import static com.google.cloud.firestore.pipeline.expressions.Expression.concat;
import static com.google.cloud.firestore.pipeline.expressions.Expression.conditional;
import static com.google.cloud.firestore.pipeline.expressions.Expression.constant;
import static com.google.cloud.firestore.pipeline.expressions.Expression.cosineDistance;
import static com.google.cloud.firestore.pipeline.expressions.Expression.dotProduct;
import static com.google.cloud.firestore.pipeline.expressions.Expression.endsWith;
import static com.google.cloud.firestore.pipeline.expressions.Expression.equal;
import static com.google.cloud.firestore.pipeline.expressions.Expression.euclideanDistance;
import static com.google.cloud.firestore.pipeline.expressions.Expression.exp;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.cloud.firestore.pipeline.expressions.Expression.floor;
import static com.google.cloud.firestore.pipeline.expressions.Expression.greaterThan;
import static com.google.cloud.firestore.pipeline.expressions.Expression.lessThan;
import static com.google.cloud.firestore.pipeline.expressions.Expression.ln;
import static com.google.cloud.firestore.pipeline.expressions.Expression.log;
import static com.google.cloud.firestore.pipeline.expressions.Expression.logicalMaximum;
import static com.google.cloud.firestore.pipeline.expressions.Expression.logicalMinimum;
import static com.google.cloud.firestore.pipeline.expressions.Expression.mapMerge;
import static com.google.cloud.firestore.pipeline.expressions.Expression.mapRemove;
import static com.google.cloud.firestore.pipeline.expressions.Expression.notEqual;
import static com.google.cloud.firestore.pipeline.expressions.Expression.nullValue;
import static com.google.cloud.firestore.pipeline.expressions.Expression.or;
import static com.google.cloud.firestore.pipeline.expressions.Expression.pow;
import static com.google.cloud.firestore.pipeline.expressions.Expression.regexMatch;
import static com.google.cloud.firestore.pipeline.expressions.Expression.round;
import static com.google.cloud.firestore.pipeline.expressions.Expression.sqrt;
import static com.google.cloud.firestore.pipeline.expressions.Expression.startsWith;
import static com.google.cloud.firestore.pipeline.expressions.Expression.stringConcat;
import static com.google.cloud.firestore.pipeline.expressions.Expression.substring;
import static com.google.cloud.firestore.pipeline.expressions.Expression.subtract;
import static com.google.cloud.firestore.pipeline.expressions.Expression.timestampAdd;
import static com.google.cloud.firestore.pipeline.expressions.Expression.timestampToUnixMicros;
import static com.google.cloud.firestore.pipeline.expressions.Expression.timestampToUnixMillis;
import static com.google.cloud.firestore.pipeline.expressions.Expression.timestampToUnixSeconds;
import static com.google.cloud.firestore.pipeline.expressions.Expression.unixMicrosToTimestamp;
import static com.google.cloud.firestore.pipeline.expressions.Expression.unixMillisToTimestamp;
import static com.google.cloud.firestore.pipeline.expressions.Expression.unixSecondsToTimestamp;
import static com.google.cloud.firestore.pipeline.expressions.Expression.vectorLength;
import static com.google.cloud.firestore.pipeline.expressions.Expression.xor;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Blob;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.GeoPoint;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.Pipeline;
import com.google.cloud.firestore.PipelineResult;
import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.cloud.firestore.pipeline.expressions.Field;
import com.google.cloud.firestore.pipeline.stages.Aggregate;
import com.google.cloud.firestore.pipeline.stages.AggregateHints;
import com.google.cloud.firestore.pipeline.stages.AggregateOptions;
import com.google.cloud.firestore.pipeline.stages.CollectionHints;
import com.google.cloud.firestore.pipeline.stages.CollectionOptions;
import com.google.cloud.firestore.pipeline.stages.ExplainOptions;
import com.google.cloud.firestore.pipeline.stages.FindNearest;
import com.google.cloud.firestore.pipeline.stages.FindNearestOptions;
import com.google.cloud.firestore.pipeline.stages.PipelineExecuteOptions;
import com.google.cloud.firestore.pipeline.stages.RawOptions;
import com.google.cloud.firestore.pipeline.stages.RawStage;
import com.google.cloud.firestore.pipeline.stages.Sample;
import com.google.cloud.firestore.pipeline.stages.UnnestOptions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Date;
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
public class ITPipelineTest extends ITBaseTest {
  private CollectionReference collection;
  private Map<String, Map<String, Object>> bookDocs;

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
    assumeFalse(
        "This test suite only runs against the Enterprise edition.",
        !getFirestoreEdition().equals(FirestoreEdition.ENTERPRISE));
    if (collection != null) {
      return;
    }

    bookDocs =
        ImmutableMap.<String, Map<String, Object>>builder()
            .put(
                "book1",
                ImmutableMap.<String, Object>builder()
                    .put("title", "The Hitchhiker's Guide to the Galaxy")
                    .put("author", "Douglas Adams")
                    .put("genre", "Science Fiction")
                    .put("published", 1979)
                    .put("rating", 4.2)
                    .put("tags", ImmutableList.of("comedy", "space", "adventure"))
                    .put("awards", ImmutableMap.of("hugo", true, "nebula", false))
                    .put(
                        "embedding",
                        vector(new double[] {10.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0}))
                    .build())
            .put(
                "book2",
                ImmutableMap.<String, Object>builder()
                    .put("title", "Pride and Prejudice")
                    .put("author", "Jane Austen")
                    .put("genre", "Romance")
                    .put("published", 1813)
                    .put("rating", 4.5)
                    .put("tags", ImmutableList.of("classic", "social commentary", "love"))
                    .put("awards", ImmutableMap.of("none", true))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 10.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0}))
                    .build())
            .put(
                "book3",
                ImmutableMap.<String, Object>builder()
                    .put("title", "One Hundred Years of Solitude")
                    .put("author", "Gabriel García Márquez")
                    .put("genre", "Magical Realism")
                    .put("published", 1967)
                    .put("rating", 4.3)
                    .put("tags", ImmutableList.of("family", "history", "fantasy"))
                    .put("awards", ImmutableMap.of("nobel", true, "nebula", false))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 10.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0}))
                    .build())
            .put(
                "book4",
                ImmutableMap.<String, Object>builder()
                    .put("title", "The Lord of the Rings")
                    .put("author", "J.R.R. Tolkien")
                    .put("genre", "Fantasy")
                    .put("published", 1954)
                    .put("rating", 4.7)
                    .put("tags", ImmutableList.of("adventure", "magic", "epic"))
                    .put("awards", ImmutableMap.of("hugo", false, "nebula", false))
                    .put("cost", Double.NaN)
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 1.0, 10.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0}))
                    .build())
            .put(
                "book5",
                ImmutableMap.<String, Object>builder()
                    .put("title", "The Handmaid's Tale")
                    .put("author", "Margaret Atwood")
                    .put("genre", "Dystopian")
                    .put("published", 1985)
                    .put("rating", 4.1)
                    .put("tags", ImmutableList.of("feminism", "totalitarianism", "resistance"))
                    .put("awards", ImmutableMap.of("arthur c. clarke", true, "booker prize", false))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 1.0, 1.0, 10.0, 1.0, 1.0, 1.0, 1.0, 1.0}))
                    .build())
            .put(
                "book6",
                ImmutableMap.<String, Object>builder()
                    .put("title", "Crime and Punishment")
                    .put("author", "Fyodor Dostoevsky")
                    .put("genre", "Psychological Thriller")
                    .put("published", 1866)
                    .put("rating", 4.3)
                    .put("tags", ImmutableList.of("philosophy", "crime", "redemption"))
                    .put("awards", ImmutableMap.of("none", true))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 10.0, 1.0, 1.0, 1.0, 1.0}))
                    .build())
            .put(
                "book7",
                ImmutableMap.<String, Object>builder()
                    .put("title", "To Kill a Mockingbird")
                    .put("author", "Harper Lee")
                    .put("genre", "Southern Gothic")
                    .put("published", 1960)
                    .put("rating", 4.2)
                    .put("tags", ImmutableList.of("racism", "injustice", "coming-of-age"))
                    .put("awards", ImmutableMap.of("pulitzer", true))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 10.0, 1.0, 1.0, 1.0}))
                    .build())
            .put(
                "book8",
                ImmutableMap.<String, Object>builder()
                    .put("title", "1984")
                    .put("author", "George Orwell")
                    .put("genre", "Dystopian")
                    .put("published", 1949)
                    .put("rating", 4.2)
                    .put("tags", ImmutableList.of("surveillance", "totalitarianism", "propaganda"))
                    .put("awards", ImmutableMap.of("prometheus", true))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 10.0, 1.0, 1.0}))
                    .build())
            .put(
                "book9",
                ImmutableMap.<String, Object>builder()
                    .put("title", "The Great Gatsby")
                    .put("author", "F. Scott Fitzgerald")
                    .put("genre", "Modernist")
                    .put("published", 1925)
                    .put("rating", 4.0)
                    .put("tags", ImmutableList.of("wealth", "american dream", "love"))
                    .put("awards", ImmutableMap.of("none", true))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 10.0, 1.0}))
                    .build())
            .put(
                "book10",
                ImmutableMap.<String, Object>builder()
                    .put("title", "Dune")
                    .put("author", "Frank Herbert")
                    .put("genre", "Science Fiction")
                    .put("published", 1965)
                    .put("rating", 4.6)
                    .put("tags", ImmutableList.of("politics", "desert", "ecology"))
                    .put("awards", ImmutableMap.of("hugo", true, "nebula", true))
                    .put(
                        "embedding",
                        vector(new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 10.0}))
                    .build())
            .put(
                "book11",
                ImmutableMap.<String, Object>builder()
                    .put("title", "Timestamp Book")
                    .put("author", "Timestamp Author")
                    .put("timestamp", new Date())
                    .build())
            .build();
    collection = testCollectionWithDocs(bookDocs);
  }

  @Test
  public void testAllDataTypes() throws Exception {
    Date refDate = new Date();
    Timestamp refTimestamp = Timestamp.now();
    GeoPoint refGeoPoint = new GeoPoint(1, 2);
    byte[] refBytes = new byte[] {1, 2, 3};
    double[] refVector = new double[] {1.0, 2.0, 3.0};

    Map<String, Object> refMap =
        map(
            "number",
            1,
            "string",
            "a string",
            "boolean",
            true,
            "null",
            null,
            "geoPoint",
            refGeoPoint,
            "timestamp",
            refTimestamp,
            "date",
            Timestamp.of(refDate),
            "bytes",
            com.google.cloud.firestore.Blob.fromBytes(refBytes),
            "vector",
            vector(refVector));

    List<Object> refArray =
        Lists.newArrayList(
            1,
            "a string",
            true,
            null,
            refTimestamp,
            refGeoPoint,
            Timestamp.of(refDate),
            com.google.cloud.firestore.Blob.fromBytes(refBytes),
            vector(refVector));

    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .limit(1)
            .select(
                constant(1L).as("number"),
                constant("a string").as("string"),
                constant(true).as("boolean"),
                nullValue().as("null"),
                constant(refTimestamp).as("timestamp"),
                constant(refDate).as("date"),
                constant(refGeoPoint).as("geoPoint"),
                constant(com.google.cloud.firestore.Blob.fromBytes(refBytes)).as("bytes"),
                constant(vector(refVector)).as("vector"),
                Expression.map(refMap).as("map"),
                array(refArray).as("array"));

    List<PipelineResult> results = pipeline.execute().get().getResults();
    assertThat(results).hasSize(1);
    Map<String, Object> data = results.get(0).getData();

    assertThat(data.get("number")).isEqualTo(1L);
    assertThat(data.get("string")).isEqualTo("a string");
    assertThat(data.get("boolean")).isEqualTo(true);
    assertThat(data.get("null")).isNull();
    assertThat(data.get("geoPoint")).isEqualTo(refGeoPoint);
    assertThat(data.get("timestamp")).isEqualTo(refTimestamp);
    assertThat(data.get("date")).isEqualTo(Timestamp.of(refDate));
    assertThat(data.get("bytes")).isEqualTo(com.google.cloud.firestore.Blob.fromBytes(refBytes));
    assertThat(data.get("vector")).isEqualTo(vector(refVector));
    assertThat(stringOfOrderedKeyValues((Map<String, Object>) data.get("map")))
        .isEqualTo(stringOfOrderedKeyValues(refMap));
    assertThat(data.get("array").toString()).isEqualTo(refArray.toString());
  }

  private String stringOfOrderedKeyValues(Map<String, Object> map) {
    return map.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .map(e -> e.getKey() + "=" + e.getValue())
        .collect(Collectors.joining(", "));
  }

  @Test
  public void testResultMetadata() throws Exception {
    Pipeline pipeline = firestore.pipeline().collection(collection.getPath());
    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertThat(snapshot.getExecutionTime()).isNotNull();

    for (PipelineResult result : snapshot.getResults()) {
      assertThat(result.getCreateTime()).isAtMost(result.getUpdateTime());
      assertThat(result.getUpdateTime()).isLessThan(result.getExecutionTime());
    }

    collection.document("book1").update("rating", 5.0).get();
    snapshot =
        pipeline.where(equal("title", "The Hitchhiker's Guide to the Galaxy")).execute().get();
    for (PipelineResult result : snapshot.getResults()) {
      assertThat(result.getCreateTime()).isLessThan(result.getUpdateTime());
    }
  }

  @Test
  public void testResultIsEqual() throws Exception {
    Pipeline pipeline =
        firestore.pipeline().collection(collection.getPath()).sort(field("title").ascending());
    Pipeline.Snapshot snapshot1 = pipeline.limit(1).execute().get();
    Pipeline.Snapshot snapshot2 = pipeline.limit(1).execute().get();
    Pipeline.Snapshot snapshot3 = pipeline.offset(1).limit(1).execute().get();

    assertThat(snapshot1.getResults()).hasSize(1);
    assertThat(snapshot2.getResults()).hasSize(1);
    assertThat(snapshot3.getResults()).hasSize(1);
    assertThat(snapshot1.getResults().get(0)).isEqualTo(snapshot2.getResults().get(0));
    assertThat(snapshot1.getResults().get(0)).isNotEqualTo(snapshot3.getResults().get(0));
  }

  @Test
  public void testEmptyResultMetadata() throws Exception {
    Pipeline pipeline = firestore.pipeline().collection(collection.getPath()).limit(0);
    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertThat(snapshot.getResults()).isEmpty();
    assertThat(snapshot.getExecutionTime()).isNotNull();
    // Ensure execution time is recent, within a tolerance.
    long now = Timestamp.now().toDate().getTime();
    long executionTime = snapshot.getExecutionTime().toDate().getTime();
    assertThat(now - executionTime).isLessThan(3000); // 3 seconds tolerance
  }

  @Test
  public void testAggregateResultMetadata() throws Exception {
    Pipeline pipeline =
        firestore.pipeline().collection(collection.getPath()).aggregate(countAll().as("count"));
    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertThat(snapshot.getResults()).hasSize(1);
    assertThat(snapshot.getExecutionTime()).isNotNull();

    PipelineResult aggregateResult = snapshot.getResults().get(0);
    assertThat(aggregateResult.getCreateTime()).isNull();
    assertThat(aggregateResult.getUpdateTime()).isNull();

    // Ensure execution time is recent, within a tolerance.
    long now = Timestamp.now().toDate().getTime();
    long executionTime = snapshot.getExecutionTime().toDate().getTime();
    assertThat(now - executionTime).isLessThan(3000); // 3 seconds tolerance
  }

  @Test
  public void testAggregates() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .aggregate(countAll().as("count"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).isEqualTo(Lists.newArrayList(map("count", 11L)));

    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("genre", "Science Fiction"))
            .aggregate(
                countAll().as("count"),
                AggregateFunction.average("rating").as("avg_rating"),
                field("rating").maximum().as("max_rating"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(Lists.newArrayList(map("count", 2L, "avg_rating", 4.4, "max_rating", 4.6)));
  }

  @Test
  public void testMoreAggregates() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .aggregate(
                sum("rating").as("sum_rating"),
                count("rating").as("count_rating"),
                countDistinct("genre").as("distinct_genres"))
            .execute()
            .get()
            .getResults();
    Map<String, Object> result = data(results).get(0);
    assertThat((Double) result.get("sum_rating")).isWithin(0.00001).of(43.1);
    assertThat(result.get("count_rating")).isEqualTo(10L);
    assertThat(result.get("distinct_genres")).isEqualTo(8L);
  }

  @Test
  public void testCountIfAggregate() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .aggregate(countIf(Expression.greaterThan(field("rating"), 4.3)).as("count"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).isEqualTo(Lists.newArrayList(map("count", 3L)));
  }

  @Test
  public void testGroupBysWithoutAccumulators() throws Exception {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          firestore
              .pipeline()
              .createFrom(collection)
              .where(lessThan("published", 1900))
              .aggregate(Aggregate.withAccumulators().withGroups("genre"));
        });
  }

  @Test
  public void testDistinct() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(lessThan("published", 1900))
            .distinct(field("genre").toLower().as("lower_genre"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map("lower_genre", "romance"), map("lower_genre", "psychological thriller"));
  }

  @Test
  public void testGroupBysAndAggregate() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(lessThan("published", 1984))
            .aggregate(
                Aggregate.withAccumulators(AggregateFunction.average("rating").as("avg_rating"))
                    .withGroups("genre"))
            .where(greaterThan("avg_rating", 4.3))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map("avg_rating", 4.7, "genre", "Fantasy"),
            map("avg_rating", 4.5, "genre", "Romance"),
            map("avg_rating", 4.4, "genre", "Science Fiction"));
  }

  @Test
  public void testMinMax() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .aggregate(
                countAll().as("count"),
                field("rating").maximum().as("max_rating"),
                field("published").minimum().as("min_published"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "count", 11L,
                    "max_rating", 4.7,
                    "min_published", 1813L)));
  }

  @Test
  public void selectSpecificFields() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select("title", "author")
            .sort(field("author").ascending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "The Hitchhiker's Guide to the Galaxy", "author", "Douglas Adams"),
                map("title", "The Great Gatsby", "author", "F. Scott Fitzgerald"),
                map("title", "Dune", "author", "Frank Herbert"),
                map("title", "Crime and Punishment", "author", "Fyodor Dostoevsky"),
                map("title", "One Hundred Years of Solitude", "author", "Gabriel García Márquez"),
                map("title", "1984", "author", "George Orwell"),
                map("title", "To Kill a Mockingbird", "author", "Harper Lee"),
                map("title", "The Lord of the Rings", "author", "J.R.R. Tolkien"),
                map("title", "Pride and Prejudice", "author", "Jane Austen"),
                map("title", "The Handmaid's Tale", "author", "Margaret Atwood"),
                map("title", "Timestamp Book", "author", "Timestamp Author")));
  }

  @Test
  public void addAndRemoveFields() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(field("author").notEqual("Timestamp Author"))
            .addFields(
                Expression.stringConcat(field("author"), "_", field("title")).as("author_title"),
                Expression.stringConcat(field("title"), "_", field("author")).as("title_author"))
            .removeFields("title_author", "tags", "awards", "rating", "title", "embedding", "cost")
            .removeFields(field("published"), field("genre"), field("nestedField"))
            .sort(field("author_title").ascending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "author_title",
                    "Douglas Adams_The Hitchhiker's Guide to the Galaxy",
                    "author",
                    "Douglas Adams"),
                map(
                    "author_title",
                    "F. Scott Fitzgerald_The Great Gatsby",
                    "author",
                    "F. Scott Fitzgerald"),
                map("author_title", "Frank Herbert_Dune", "author", "Frank Herbert"),
                map(
                    "author_title",
                    "Fyodor Dostoevsky_Crime and Punishment",
                    "author",
                    "Fyodor Dostoevsky"),
                map(
                    "author_title",
                    "Gabriel García Márquez_One Hundred Years of Solitude",
                    "author",
                    "Gabriel García Márquez"),
                map("author_title", "George Orwell_1984", "author", "George Orwell"),
                map("author_title", "Harper Lee_To Kill a Mockingbird", "author", "Harper Lee"),
                map(
                    "author_title",
                    "J.R.R. Tolkien_The Lord of the Rings",
                    "author",
                    "J.R.R. Tolkien"),
                map("author_title", "Jane Austen_Pride and Prejudice", "author", "Jane Austen"),
                map(
                    "author_title",
                    "Margaret Atwood_The Handmaid's Tale",
                    "author",
                    "Margaret Atwood")));
  }

  @Test
  public void whereByMultipleConditions() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(and(greaterThan("rating", 4.5), equal("genre", "Science Fiction")))
            .execute()
            .get()
            .getResults();

    // It's Dune
    assertThat(data(results))
        .isEqualTo(Lists.newArrayList(collection.document("book10").get().get().getData()));
    assertThat(results.get(0).getReference()).isEqualTo(collection.document("book10"));
  }

  @Test
  public void whereByOrCondition() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(or(equal("genre", "Romance"), equal("genre", "Dystopian")))
            .select("title")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "Pride and Prejudice"),
                map("title", "The Handmaid's Tale"),
                map("title", "1984")));
  }

  @Test
  public void testPipelineWithOffsetAndLimit() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .sort(field("author").ascending())
            .offset(5)
            .limit(3)
            .select("title", "author")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "1984", "author", "George Orwell"),
                map("title", "To Kill a Mockingbird", "author", "Harper Lee"),
                map("title", "The Lord of the Rings", "author", "J.R.R. Tolkien")));
  }

  @Test
  public void testArrayContains() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(arrayContains("tags", "comedy"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        // The Hitchhiker's Guide to the Galaxy
        .isEqualTo(Lists.newArrayList(collection.document("book1").get().get().getData()));
  }

  @Test
  public void testArrayContainsAny() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(arrayContainsAny("tags", Lists.newArrayList("comedy", "classic")))
            .select("title")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "The Hitchhiker's Guide to the Galaxy"),
                map("title", "Pride and Prejudice")));
  }

  @Test
  public void testArrayContainsAll() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(arrayContainsAll("tags", Lists.newArrayList("adventure", "magic")))
            .select("title")
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).isEqualTo(Lists.newArrayList(map("title", "The Lord of the Rings")));
  }

  @Test
  public void testArrayLength() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("tags").arrayLength().as("tagsCount"))
            .where(equal("tagsCount", 3))
            .execute()
            .get()
            .getResults();

    // All documents have 3 tags in the test dataset
    assertThat(data(results)).hasSize(10);
  }

  @Test
  public void testArrayConcat() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("tags").arrayConcat(array("newTag1", "newTag2")).as("modifiedTags"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "modifiedTags",
                    Lists.newArrayList("comedy", "space", "adventure", "newTag1", "newTag2"))));
  }

  @Test
  public void testStrConcat() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(Expression.stringConcat(field("author"), " - ", field("title")).as("bookInfo"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("bookInfo", "Douglas Adams - The Hitchhiker's Guide to the Galaxy")));
  }

  @Test
  public void testStartsWith() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(startsWith("title", "The"))
            .select("title")
            .sort(field("title").ascending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "The Great Gatsby"),
                map("title", "The Handmaid's Tale"),
                map("title", "The Hitchhiker's Guide to the Galaxy"),
                map("title", "The Lord of the Rings")));
  }

  @Test
  public void testEndsWith() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(endsWith(field("title"), constant("y")))
            .select("title")
            .sort(field("title").descending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "The Hitchhiker's Guide to the Galaxy"),
                map("title", "The Great Gatsby")));
  }

  @Test
  public void testLength() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("title").charLength().as("titleLength"), field("title"))
            .where(greaterThan("titleLength", 21))
            .sort(field("titleLength").descending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("titleLength", 36L, "title", "The Hitchhiker's Guide to the Galaxy"),
                map("titleLength", 29L, "title", "One Hundred Years of Solitude")));
  }

  @Test
  public void testStringFunctions() throws Exception {
    List<PipelineResult> results;

    // Reverse
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select(field("title").reverse().as("reversed_title"), field("author"))
            .where(field("author").equal("Douglas Adams"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results).get(0).get("reversed_title"))
        .isEqualTo("yxalaG eht ot ediuG s'rekihhctiH ehT");

    // CharLength
    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("title").charLength().as("title_length"), field("author"))
            .where(field("author").equal("Douglas Adams"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results).get(0).get("title_length")).isEqualTo(36L);

    // ByteLength
    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(
                field("author"),
                field("title").stringConcat("_银河系漫游指南").byteLength().as("title_byte_length"))
            .where(field("author").equal("Douglas Adams"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results).get(0).get("title_byte_length")).isEqualTo(58L);
  }

  @Test
  public void testToLowercase() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("title").toLower().as("lowercaseTitle"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(map("lowercaseTitle", "the hitchhiker's guide to the galaxy")));
  }

  @Test
  public void testToUppercase() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("author").toUpper().as("uppercaseAuthor"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(Lists.newArrayList(map("uppercaseAuthor", "DOUGLAS ADAMS")));
  }

  @Test
  public void testTrim() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .addFields(stringConcat(constant(" "), field("title"), constant(" ")).as("spacedTitle"))
            .select(field("spacedTitle").trim().as("trimmedTitle"), field("spacedTitle"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "spacedTitle", " The Hitchhiker's Guide to the Galaxy ",
                    "trimmedTitle", "The Hitchhiker's Guide to the Galaxy")));
  }

  @Test
  public void testTrimWithCharacters() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .addFields(concat(constant("_-"), field("title"), constant("-_")).as("paddedTitle"))
            .select(field("paddedTitle").trimValue("_-").as("trimmedTitle"), field("paddedTitle"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "paddedTitle",
                    "_-The Hitchhiker's Guide to the Galaxy-_",
                    "trimmedTitle",
                    "The Hitchhiker's Guide to the Galaxy")));
  }

  @Test
  public void testLike() throws Exception {
    assumeFalse(
        "LIKE is not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(field("title").like("%Guide%"))
            .select("title")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(Lists.newArrayList(map("title", "The Hitchhiker's Guide to the Galaxy")));
  }

  @Test
  public void testRegexContains() throws Exception {
    assumeFalse(
        "LIKE is not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    // Find titles that contain either "the" or "of" (case-insensitive)
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(field("title").regexContains("(?i)(the|of)"))
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).hasSize(5);
  }

  @Test
  public void testRegexFind() throws Exception {
    assumeFalse(
        "Regexes are not supported against the emulator",
        isRunningAgainstFirestoreEmulator(firestore));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("title").regexFind("^\\w+").as("firstWordInTitle"))
            .sort(field("firstWordInTitle").ascending())
            .limit(3)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("firstWordInTitle", "1984"),
                map("firstWordInTitle", "Crime"),
                map("firstWordInTitle", "Dune")));
  }

  @Test
  public void testRegexFindAll() throws Exception {
    assumeFalse(
        "Regexes are not supported against the emulator",
        isRunningAgainstFirestoreEmulator(firestore));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("title").regexFindAll("\\w+").as("wordsInTitle"))
            .sort(field("wordsInTitle").ascending())
            .limit(3)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("wordsInTitle", Lists.newArrayList("1984")),
                map("wordsInTitle", Lists.newArrayList("Crime", "and", "Punishment")),
                map("wordsInTitle", Lists.newArrayList("Dune"))));
  }

  @Test
  public void testRegexMatches() throws Exception {
    assumeFalse(
        "LIKE is not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    // Find titles that contain either "the" or "of" (case-insensitive)
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(regexMatch("title", ".*(?i)(the|of).*"))
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).hasSize(5);
  }

  @Test
  public void testArithmeticOperations() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(
                add(field("rating"), 1).as("ratingPlusOne"),
                subtract(field("published"), 1900).as("yearsSince1900"),
                field("rating").multiply(10).as("ratingTimesTen"),
                field("rating").divide(2).as("ratingDividedByTwo"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "ratingPlusOne",
                    5.2,
                    "yearsSince1900",
                    79L,
                    "ratingTimesTen",
                    42.0,
                    "ratingDividedByTwo",
                    2.1)));
  }

  @Test
  public void testComparisonOperators() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(
                and(
                    greaterThan("rating", 4.2),
                    field("rating").lessThanOrEqual(4.5),
                    notEqual("genre", "Science Fiction")))
            .select("rating", "title")
            .sort(field("title").ascending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("rating", 4.3, "title", "Crime and Punishment"),
                map("rating", 4.3, "title", "One Hundred Years of Solitude"),
                map("rating", 4.5, "title", "Pride and Prejudice")));
  }

  @Test
  public void testLogicalAndComparisonOperators() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(
                xor(
                    equal("genre", "Romance"),
                    equal("genre", "Dystopian"),
                    equal("genre", "Fantasy"),
                    equal("published", 1949)))
            .select("title")
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map("title", "Pride and Prejudice"),
            map("title", "The Lord of the Rings"),
            map("title", "The Handmaid's Tale"));

    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(Expression.equalAny("genre", Lists.newArrayList("Romance", "Dystopian")))
            .select("title")
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map("title", "Pride and Prejudice"),
            map("title", "The Handmaid's Tale"),
            map("title", "1984"));

    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(
                Expression.notEqualAny(
                    "genre", Lists.newArrayList("Science Fiction", "Romance", "Dystopian", null)))
            .select("genre")
            .distinct("genre")
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            // This is somewhat surprising because the pipeline did ask specifically for genre not
            // equal to null,
            // however at the later distinct stage, UNSET is grouped as null and thus null appears
            // in the result.
            map("genre", null),
            map("genre", "Magical Realism"),
            map("genre", "Fantasy"),
            map("genre", "Psychological Thriller"),
            map("genre", "Southern Gothic"),
            map("genre", "Modernist"));
  }

  @Test
  public void testCondExpression() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(field("title").notEqual("Timestamp Book"))
            .select(
                conditional(Expression.greaterThan(field("published"), 1980), "Modern", "Classic")
                    .as("era"),
                field("title"),
                field("published"))
            .sort(field("published").ascending())
            .limit(2)
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("era", "Classic", "title", "Pride and Prejudice", "published", 1813L),
                map("era", "Classic", "title", "Crime and Punishment", "published", 1866L)));
  }

  @Test
  public void testLogicalOperators() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(
                or(
                    and(greaterThan("rating", 4.5), equal("genre", "Science Fiction")),
                    lessThan("published", 1900)))
            .select("title")
            .sort(field("title").ascending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "Crime and Punishment"),
                map("title", "Dune"),
                map("title", "Pride and Prejudice")));
  }

  @Test
  public void testChecks() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .sort(field("rating").descending())
            .limit(1)
            .select(
                field("rating").equal(nullValue()).as("ratingIsNull"),
                field("rating").equal(Double.NaN).as("ratingIsNaN"),
                // arrayGet("title", 0) evaluates to UNSET so it is not an error
                arrayGet("title", 0).isError().as("isError"),
                arrayGet("title", 0).ifError(constant("was error")).as("ifError"),
                field("foo").isAbsent().as("isAbsent"),
                field("title").notEqual(nullValue()).as("titleIsNotNull"),
                field("cost").notEqual(Double.NaN).as("costIsNotNan"),
                field("fooBarBaz").exists().as("fooBarBazExists"),
                field("title").exists().as("titleExists"))
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "ratingIsNull",
                    false,
                    "ratingIsNaN",
                    false,
                    "isError",
                    false,
                    "isAbsent",
                    true,
                    "titleIsNotNull",
                    true,
                    "costIsNotNan",
                    false,
                    "fooBarBazExists",
                    false,
                    "titleExists",
                    true)));
  }

  @Test
  public void testLogicalMinMax() throws Exception {
    List<PipelineResult> results;

    // logicalMax
    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(field("author").equal("Douglas Adams"))
            .select(
                field("rating").logicalMaximum(4.5).as("max_rating"),
                logicalMaximum(field("published"), 1900).as("max_published"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("max_rating", 4.5, "max_published", 1979L));

    // logicalMin
    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(field("author").equal("Douglas Adams"))
            .select(
                field("rating").logicalMinimum(4.5).as("min_rating"),
                logicalMinimum(field("published"), 1900).as("min_published"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("min_rating", 4.2, "min_published", 1900L));
  }

  @Test
  public void testMapGet() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .select(field("awards").mapGet("hugo").as("hugoAward"), field("title"))
            .where(equal("hugoAward", true))
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("hugoAward", true, "title", "The Hitchhiker's Guide to the Galaxy"),
                map("hugoAward", true, "title", "Dune")));
  }

  @Test
  public void testDataManipulationExpressions() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "Timestamp Book"))
            .select(
                timestampAdd(field("timestamp"), "day", 1).as("timestamp_plus_day"),
                Expression.timestampSubtract(field("timestamp"), "hour", 1)
                    .as("timestamp_minus_hour"))
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(1);
    Date originalTimestamp = (Date) bookDocs.get("book11").get("timestamp");
    Timestamp timestampPlusDay = (Timestamp) results.get(0).getData().get("timestamp_plus_day");
    Timestamp timestampMinusHour = (Timestamp) results.get(0).getData().get("timestamp_minus_hour");
    assertThat(timestampPlusDay.toDate().getTime() - originalTimestamp.getTime())
        .isEqualTo(24 * 60 * 60 * 1000);
    assertThat(originalTimestamp.getTime() - timestampMinusHour.toDate().getTime())
        .isEqualTo(60 * 60 * 1000);

    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(
                arrayGet("tags", 1).as("second_tag"),
                mapMerge(field("awards"), Expression.map(map("new_award", true)))
                    .as("merged_awards"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "second_tag",
                    "space",
                    "merged_awards",
                    map("hugo", true, "nebula", false, "new_award", true))));

    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(
                arrayReverse("tags").as("reversed_tags"),
                mapRemove(field("awards"), "nebula").as("removed_awards"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "reversed_tags",
                    Lists.newArrayList("adventure", "space", "comedy"),
                    "removed_awards",
                    map("hugo", true))));
  }

  @Test
  public void testTimestampTrunc() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "Timestamp Book"))
            .select(
                Expression.timestampTruncate(field("timestamp"), "year").as("trunc_year"),
                Expression.timestampTruncate(field("timestamp"), "month").as("trunc_month"),
                Expression.timestampTruncate(field("timestamp"), "day").as("trunc_day"),
                Expression.timestampTruncate(field("timestamp"), "hour").as("trunc_hour"),
                Expression.timestampTruncate(field("timestamp"), "minute").as("trunc_minute"),
                Expression.timestampTruncate(field("timestamp"), "second").as("trunc_second"))
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(1);
    Map<String, Object> data = results.get(0).getData();
    Date originalDate = (Date) bookDocs.get("book11").get("timestamp");
    java.util.Calendar cal = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
    cal.setTime(originalDate);

    cal.set(java.util.Calendar.MONTH, java.util.Calendar.JANUARY);
    cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
    cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
    cal.set(java.util.Calendar.MINUTE, 0);
    cal.set(java.util.Calendar.SECOND, 0);
    cal.set(java.util.Calendar.MILLISECOND, 0);
    assertThat(data.get("trunc_year")).isEqualTo(Timestamp.of(cal.getTime()));

    cal.setTime(originalDate);
    cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
    cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
    cal.set(java.util.Calendar.MINUTE, 0);
    cal.set(java.util.Calendar.SECOND, 0);
    cal.set(java.util.Calendar.MILLISECOND, 0);
    assertThat(data.get("trunc_month")).isEqualTo(Timestamp.of(cal.getTime()));

    cal.setTime(originalDate);
    cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
    cal.set(java.util.Calendar.MINUTE, 0);
    cal.set(java.util.Calendar.SECOND, 0);
    cal.set(java.util.Calendar.MILLISECOND, 0);
    assertThat(data.get("trunc_day")).isEqualTo(Timestamp.of(cal.getTime()));

    cal.setTime(originalDate);
    cal.set(java.util.Calendar.MINUTE, 0);
    cal.set(java.util.Calendar.SECOND, 0);
    cal.set(java.util.Calendar.MILLISECOND, 0);
    assertThat(data.get("trunc_hour")).isEqualTo(Timestamp.of(cal.getTime()));

    cal.setTime(originalDate);
    cal.set(java.util.Calendar.SECOND, 0);
    cal.set(java.util.Calendar.MILLISECOND, 0);
    assertThat(data.get("trunc_minute")).isEqualTo(Timestamp.of(cal.getTime()));

    cal.setTime(originalDate);
    cal.set(java.util.Calendar.MILLISECOND, 0);
    assertThat(data.get("trunc_second")).isEqualTo(Timestamp.of(cal.getTime()));
  }

  @Test
  public void testMathExpressions() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(
                ceil(field("rating")).as("ceil_rating"),
                floor(field("rating")).as("floor_rating"),
                pow(field("rating"), 2).as("pow_rating"),
                round(field("rating")).as("round_rating"),
                sqrt(field("rating")).as("sqrt_rating"),
                field("published").mod(10).as("mod_published"))
            .execute()
            .get()
            .getResults();
    Map<String, Object> result = data(results).get(0);
    assertThat((Double) result.get("ceil_rating")).isEqualTo(5.0);
    assertThat((Double) result.get("floor_rating")).isEqualTo(4.0);
    assertThat((Double) result.get("pow_rating")).isWithin(0.00001).of(17.64);
    assertThat((Double) result.get("round_rating")).isEqualTo(4.0);
    assertThat((Double) result.get("sqrt_rating")).isWithin(0.00001).of(2.04939);
    assertThat((Long) result.get("mod_published")).isEqualTo(9L);
  }

  @Test
  public void testAdvancedMathExpressions() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "The Lord of the Rings"))
            .select(
                exp(field("rating")).as("exp_rating"),
                ln(field("rating")).as("ln_rating"),
                log(field("rating"), 10).as("log_rating"),
                field("rating").log10().as("log10_rating"))
            .execute()
            .get()
            .getResults();
    Map<String, Object> result = data(results).get(0);
    assertThat((Double) result.get("exp_rating")).isWithin(0.00001).of(109.94717);
    assertThat((Double) result.get("ln_rating")).isWithin(0.00001).of(1.54756);
    assertThat((Double) result.get("log_rating")).isWithin(0.00001).of(0.67209);
    assertThat((Double) result.get("log10_rating")).isWithin(0.00001).of(0.67209);
  }

  @Test
  public void testConcat() throws Exception {
    // String concat
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(concat(field("author"), " ", field("title")).as("author_title"))
            .execute()
            .get()
            .getResults();
    Map<String, Object> result = data(results).get(0);
    assertThat(result.get("author_title"))
        .isEqualTo("Douglas Adams The Hitchhiker's Guide to the Galaxy");

    // Array concat
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(concat(field("tags"), ImmutableList.of("newTag")).as("new_tags"))
            .execute()
            .get()
            .getResults();
    result = data(results).get(0);
    assertThat((List<Object>) result.get("new_tags"))
        .containsExactly("comedy", "space", "adventure", "newTag");

    // Blob concat
    byte[] bytes1 = new byte[] {1, 2};
    byte[] bytes2 = new byte[] {3, 4};
    byte[] expected = new byte[] {1, 2, 3, 4};
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .limit(1)
            .select(
                concat(
                        constant(com.google.cloud.firestore.Blob.fromBytes(bytes1)),
                        com.google.cloud.firestore.Blob.fromBytes(bytes2))
                    .as("concatenated_blob"))
            .execute()
            .get()
            .getResults();
    result = data(results).get(0);
    assertThat(((com.google.cloud.firestore.Blob) result.get("concatenated_blob")).toBytes())
        .isEqualTo(expected);

    // Mismatched types should just fail.
    assertThrows(
        ExecutionException.class,
        () ->
            firestore
                .pipeline()
                .collection(collection.getPath())
                .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
                .select(concat(field("title"), field("tags")).as("mismatched"))
                .execute()
                .get()
                .getResults());
  }

  @Test
  public void testCurrentTimestamp() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .limit(1)
            .select(Expression.currentTimestamp().as("now"))
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(1);
    Object nowValue = results.get(0).getData().get("now");
    assertThat(nowValue).isInstanceOf(Timestamp.class);
    Timestamp nowTimestamp = (Timestamp) nowValue;
    // Check that the timestamp is recent (e.g., within the last 5 seconds)
    long diff = new Date().getTime() - nowTimestamp.toDate().getTime();
    assertThat(diff).isAtMost(5000L);
  }

  @Test
  public void testIfAbsent() throws Exception {
    // Case 1: Field is present, should return the field value.
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(field("rating").ifAbsent(0.0).as("rating_or_default"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("rating_or_default", 4.2));

    // Case 2: Field is absent, should return the default value.
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(
                Expression.ifAbsent(field("non_existent_field"), "default").as("field_or_default"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("field_or_default", "default"));

    // Case 3: Field is present and null, should return null.
    collection
        .document("bookWithNull")
        .set(map("title", "Book With Null", "optional_field", null))
        .get();
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "Book With Null"))
            .select(Expression.ifAbsent(field("optional_field"), "default").as("field_or_default"))
            .execute()
            .get()
            .getResults();
    assertThat(results.get(0).get("field_or_default")).isNull();
    collection.document("bookWithNull").delete().get();

    // Case 4: Test different overloads.
    // ifAbsent(String, Any)
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "Dune"))
            .select(Expression.ifAbsent("non_existent_field", "default_string").as("res"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("res", "default_string"));

    // ifAbsent(String, Expression)
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "Dune"))
            .select(Expression.ifAbsent("non_existent_field", field("author")).as("res"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("res", "Frank Herbert"));

    // ifAbsent(Expression, Expression)
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "Dune"))
            .select(Expression.ifAbsent(field("non_existent_field"), field("author")).as("res"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("res", "Frank Herbert"));
  }

  @Test
  public void testJoin() throws Exception {
    // Test join with a constant delimiter
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(Expression.join("tags", ", ").as("joined_tags"))
            .execute()
            .get()
            .getResults();
    Map<String, Object> result = data(results).get(0);
    assertThat(result.get("joined_tags")).isEqualTo("comedy, space, adventure");

    // Test join with an expression delimiter
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(Expression.join(field("tags"), constant(" | ")).as("joined_tags"))
            .execute()
            .get()
            .getResults();
    result = data(results).get(0);
    assertThat(result.get("joined_tags")).isEqualTo("comedy | space | adventure");

    // Test extension method
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(field("tags").join(" - ").as("joined_tags"))
            .execute()
            .get()
            .getResults();
    result = data(results).get(0);
    assertThat(result.get("joined_tags")).isEqualTo("comedy - space - adventure");
  }

  @Test
  public void testArraySum() throws Exception {
    collection.document("book4").update("sales", ImmutableList.of(100, 200, 50)).get();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Lord of the Rings"))
            .select(Expression.arraySum("sales").as("totalSales"))
            .limit(1)
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).containsExactly(map("totalSales", 350L));
  }

  @Test
  public void testTimestampConversions() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .limit(1)
            .select(
                unixSecondsToTimestamp(constant(1741380235L)).as("unixSecondsToTimestamp"),
                unixMillisToTimestamp(constant(1741380235123L)).as("unixMillisToTimestamp"),
                unixMicrosToTimestamp(constant(1741380235123456L)).as("unixMicrosToTimestamp"),
                timestampToUnixSeconds(
                        constant(Timestamp.ofTimeSecondsAndNanos(1741380235L, 123456789)))
                    .as("timestampToUnixSeconds"),
                timestampToUnixMicros(
                        constant(Timestamp.ofTimeSecondsAndNanos(1741380235L, 123456789)))
                    .as("timestampToUnixMicros"),
                timestampToUnixMillis(
                        constant(Timestamp.ofTimeSecondsAndNanos(1741380235L, 123456789)))
                    .as("timestampToUnixMillis"))
            .execute()
            .get()
            .getResults();
    Map<String, Object> result = data(results).get(0);
    assertThat(result.get("unixSecondsToTimestamp"))
        .isEqualTo(Timestamp.ofTimeSecondsAndNanos(1741380235L, 0));
    assertThat(result.get("unixMillisToTimestamp"))
        .isEqualTo(Timestamp.ofTimeSecondsAndNanos(1741380235L, 123000000));
    assertThat(result.get("unixMicrosToTimestamp"))
        .isEqualTo(Timestamp.ofTimeSecondsAndNanos(1741380235L, 123456000));
    assertThat(result.get("timestampToUnixSeconds")).isEqualTo(1741380235L);
    assertThat(result.get("timestampToUnixMicros")).isEqualTo(1741380235123456L);
    assertThat(result.get("timestampToUnixMillis")).isEqualTo(1741380235123L);
  }

  @Test
  public void testVectorLength() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .limit(1)
            .select(vectorLength(constant(vector(new double[] {1.0, 2.0, 3.0}))).as("vectorLength"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).isEqualTo(Lists.newArrayList(map("vectorLength", 3L)));
  }

  @Test
  public void testStrContains() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(Expression.stringContains(field("title"), "'s"))
            .select("title")
            .sort(field("title").ascending())
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map("title", "The Handmaid's Tale"),
            map("title", "The Hitchhiker's Guide to the Galaxy"));
  }

  @Test
  public void testSubstring() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "The Lord of the Rings"))
            .select(
                Expression.substring(field("title"), constant(9), constant(2)).as("of"),
                substring("title", 16, 5).as("Rings"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).isEqualTo(Lists.newArrayList(map("of", "of", "Rings", "Rings")));
  }

  @Test
  public void testSplitStringByStringDelimiter() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(Expression.split(field("title"), " ").as("split_title"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_title",
                ImmutableList.of("The", "Hitchhiker's", "Guide", "to", "the", "Galaxy")));

    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(field("title").split(" ").as("split_title"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_title",
                ImmutableList.of("The", "Hitchhiker's", "Guide", "to", "the", "Galaxy")));
  }

  @Test
  public void testSplitStringByExpressionDelimiter() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(Expression.split(field("title"), constant(" ")).as("split_title"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_title",
                ImmutableList.of("The", "Hitchhiker's", "Guide", "to", "the", "Galaxy")));

    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(field("title").split(constant(" ")).as("split_title"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_title",
                ImmutableList.of("The", "Hitchhiker's", "Guide", "to", "the", "Galaxy")));
  }

  @Test
  public void testSplitBlobByByteArrayDelimiter() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .limit(1)
            .addFields(
                constant(Blob.fromBytes(new byte[] {0x01, 0x02, 0x03, 0x04, 0x01, 0x05}))
                    .as("data"))
            .select(
                Expression.split(field("data"), constant(Blob.fromBytes(new byte[] {0x01})))
                    .as("split_data"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_data",
                ImmutableList.of(
                    Blob.fromBytes(new byte[] {}),
                    Blob.fromBytes(new byte[] {0x02, 0x03, 0x04}),
                    Blob.fromBytes(new byte[] {0x05}))));

    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .limit(1)
            .addFields(
                constant(Blob.fromBytes(new byte[] {0x01, 0x02, 0x03, 0x04, 0x01, 0x05}))
                    .as("data"))
            .select(
                field("data").split(constant(Blob.fromBytes(new byte[] {0x01}))).as("split_data"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_data",
                ImmutableList.of(
                    Blob.fromBytes(new byte[] {}),
                    Blob.fromBytes(new byte[] {0x02, 0x03, 0x04}),
                    Blob.fromBytes(new byte[] {0x05}))));
  }

  @Test
  public void testSplitStringFieldByStringDelimiter() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(Expression.split("title", " ").as("split_title"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_title",
                ImmutableList.of("The", "Hitchhiker's", "Guide", "to", "the", "Galaxy")));
  }

  @Test
  public void testSplitStringFieldByExpressionDelimiter() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .select(Expression.split("title", constant(" ")).as("split_title"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "split_title",
                ImmutableList.of("The", "Hitchhiker's", "Guide", "to", "the", "Galaxy")));
  }

  @Test
  public void testSplitWithMismatchedTypesShouldFail() {
    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () ->
                firestore
                    .pipeline()
                    .collection(collection.getPath())
                    .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
                    .select(
                        Expression.split(
                                field("title"), constant(Blob.fromBytes(new byte[] {0x01})))
                            .as("mismatched_split"))
                    .execute()
                    .get());
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    ApiException apiException = (ApiException) exception.getCause();
    assertThat(apiException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
  }

  @Test
  public void testDistanceFunctions() throws Exception {
    double[] sourceVector = {0.1, 0.1};
    double[] targetVector = {0.5, 0.8};
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select(
                cosineDistance(constant(vector(sourceVector)), targetVector).as("cosineDistance"),
                dotProduct(constant(vector(sourceVector)), targetVector).as("dotProductDistance"),
                euclideanDistance(constant(vector(sourceVector)), targetVector)
                    .as("euclideanDistance"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "cosineDistance", 0.02560880430538015,
                    "dotProductDistance", 0.13,
                    "euclideanDistance", 0.806225774829855)));
  }

  @Test
  public void testNestedFields() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("awards.hugo", true))
            .select("title", "awards.hugo")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "The Hitchhiker's Guide to the Galaxy", "awards.hugo", true),
                map("title", "Dune", "awards.hugo", true)));
  }

  @Test
  public void testPipelineInTransactions() throws Exception {
    assumeFalse(
        "Transactions are not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    Pipeline pipeline =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("awards.hugo", true))
            .select("title", "awards.hugo", Field.DOCUMENT_ID);

    firestore
        .runTransaction(
            transaction -> {
              List<PipelineResult> results = transaction.execute(pipeline).get().getResults();

              assertThat(data(results))
                  .isEqualTo(
                      Lists.newArrayList(
                          map("title", "The Hitchhiker's Guide to the Galaxy", "awards.hugo", true),
                          map("title", "Dune", "awards.hugo", true)));

              transaction.update(collection.document("book1"), map("foo", "bar"));

              return "done";
            })
        .get();

    List<PipelineResult> result =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("foo", "bar"))
            .select("title")
            .execute()
            .get()
            .getResults();
    assertThat(data(result))
        .isEqualTo(Lists.newArrayList(map("title", "The Hitchhiker's Guide to the Galaxy")));
  }

  @Test
  public void testPipelineInTransactionsWithOptions() throws Exception {
    assumeFalse(
        "Transactions are not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    Pipeline pipeline = firestore.pipeline().createFrom(collection).limit(1);

    firestore
        .runTransaction(
            transaction -> {
              PipelineExecuteOptions options = new PipelineExecuteOptions().with("foo", "bar");
              List<PipelineResult> results =
                  transaction.execute(pipeline, options).get().getResults();
              assertThat(results).hasSize(1);
              return "done";
            })
        .get();
  }

  @Test
  public void testRawStage() throws Exception {
    // can select fields
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            // .select(field("title"), Expression.map(map("author",
            // field("author"))).as("metadata"))
            .rawStage(
                RawStage.ofName("select")
                    .withArguments(
                        map(
                            "title",
                            field("title"),
                            "metadata",
                            Expression.map(map("author", field("author"))))))
            .sort(field("metadata.author").ascending())
            .limit(1)
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "title",
                    "The Hitchhiker's Guide to the Galaxy",
                    "metadata",
                    map("author", "Douglas Adams"))));

    // can add fields
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .sort(field("author").ascending())
            .limit(1)
            .select("title", "author")
            .rawStage(
                RawStage.ofName("add_fields")
                    .withArguments(
                        map(
                            "display",
                            Expression.stringConcat(field("title"), " - ", field("author")))))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map(
                    "title",
                    "The Hitchhiker's Guide to the Galaxy",
                    "author",
                    "Douglas Adams",
                    "display",
                    "The Hitchhiker's Guide to the Galaxy - Douglas Adams")));

    // can filter with where
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select("title", "author")
            .rawStage(RawStage.ofName("where").withArguments(equal("author", "Douglas Adams")))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("title", "The Hitchhiker's Guide to the Galaxy", "author", "Douglas Adams")));

    // can limit, offset, and sort
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select("title", "author")
            .rawStage(
                RawStage.ofName("sort")
                    .withArguments(map("direction", "ascending", "expression", field("author"))))
            .rawStage(RawStage.ofName("offset").withArguments(3))
            .rawStage(RawStage.ofName("limit").withArguments(1))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("author", "Fyodor Dostoevsky", "title", "Crime and Punishment")));

    // can perform aggregate query
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select("title", "author", "rating")
            .rawStage(
                RawStage.ofName("aggregate")
                    .withArguments(
                        map("averageRating", AggregateFunction.average("rating")), map()))
            .execute()
            .get()
            .getResults();
    Map<String, Object> aggregateResult = data(results).get(0);
    assertThat((Double) aggregateResult.get("averageRating")).isWithin(0.00001).of(4.31);

    // can perform distinct query
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select("title", "author", "rating")
            .rawStage(RawStage.ofName("distinct").withArguments(map("rating", field("rating"))))
            .sort(field("rating").descending())
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map("rating", 4.7),
            map("rating", 4.6),
            map("rating", 4.5),
            map("rating", 4.3),
            map("rating", 4.2),
            map("rating", 4.1),
            map("rating", 4.0),
            map("rating", null));

    // can perform FindNearest query
    results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .rawStage(
                RawStage.ofName("find_nearest")
                    .withArguments(
                        field("embedding"),
                        constant(
                            vector(
                                new double[] {10.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0})),
                        "euclidean")
                    .withOptions(
                        new RawOptions()
                            .with("distance_field", field("computedDistance"))
                            .with("limit", 2)))
            .select("title", "computedDistance")
            .execute()
            .get()
            .getResults();
    assertThat(results.size()).isEqualTo(2);
    assertThat(results.get(0).getData().get("title"))
        .isEqualTo("The Hitchhiker's Guide to the Galaxy");
    assertThat((Double) results.get(0).getData().get("computedDistance")).isWithin(0.00001).of(1.0);
    assertThat(results.get(1).getData().get("title")).isEqualTo("One Hundred Years of Solitude");
    assertThat((Double) results.get(1).getData().get("computedDistance"))
        .isWithin(0.00001)
        .of(12.041594578792296);
  }

  @Test
  public void testReplaceWith() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .replaceWith("awards")
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).isEqualTo(Lists.newArrayList(map("hugo", true, "nebula", false)));

    results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(equal("title", "The Hitchhiker's Guide to the Galaxy"))
            .replaceWith(
                Expression.map(
                    map("foo", "bar", "baz", Expression.map(map("title", field("title"))))))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("foo", "bar", "baz", map("title", "The Hitchhiker's Guide to the Galaxy"))));
  }

  @Test
  public void testSampleLimit() throws Exception {
    List<PipelineResult> results =
        firestore.pipeline().createFrom(collection).sample(3).execute().get().getResults();

    assertThat(results).hasSize(3);
  }

  @Test
  public void testSamplePercentage() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .sample(Sample.withPercentage(0.6))
            .execute()
            .get()
            .getResults();

    assertThat(results).isNotEmpty();
  }

  @Test
  public void testUnion() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .union(firestore.pipeline().createFrom(collection))
            .execute()
            .get()
            .getResults();

    assertThat(results).hasSize(22);
  }

  @Test
  public void testUnnest() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(Expression.equal(field("title"), "The Hitchhiker's Guide to the Galaxy"))
            .unnest("tags", "tag")
            .execute()
            .get()
            .getResults();

    assertThat(results).hasSize(3);
  }

  @Test
  public void testUnnestWithIndexField() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(Expression.equal(field("title"), "The Hitchhiker's Guide to the Galaxy"))
            .unnest("tags", "tag", new UnnestOptions().withIndexField("tagsIndex"))
            .execute()
            .get()
            .getResults();

    assertThat(results).hasSize(3);
    for (int i = 0; i < results.size(); i++) {
      assertThat(results.get(i).getData().get("tagsIndex")).isEqualTo((long) i);
    }
  }

  @Test
  public void testUnnestWithExpr() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .createFrom(collection)
            .where(Expression.equal(field("title"), "The Hitchhiker's Guide to the Galaxy"))
            .unnest(array(1L, 2L, 3L).as("copy"))
            .execute()
            .get()
            .getResults();

    assertThat(results).hasSize(3);
    for (int i = 0; i < results.size(); i++) {
      assertThat(results.get(i).getData().get("copy")).isEqualTo((long) i + 1);
    }
  }

  @Test
  public void testPaginationWithStartAfter() throws Exception {
    CollectionReference paginationCollection =
        testCollectionWithDocs(
            ImmutableMap.<String, Map<String, Object>>builder()
                .put("doc1", map("order", 1))
                .put("doc2", map("order", 2))
                .put("doc3", map("order", 3))
                .put("doc4", map("order", 4))
                .build());

    Pipeline pipeline =
        firestore.pipeline().createFrom(paginationCollection.orderBy("order").limit(2));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertThat(data(snapshot.getResults())).containsExactly(map("order", 1L), map("order", 2L));

    PipelineResult lastResult = snapshot.getResults().get(snapshot.getResults().size() - 1);
    snapshot =
        firestore
            .pipeline()
            .createFrom(paginationCollection.orderBy("order").startAfter(lastResult.get("order")))
            .execute()
            .get();
    assertThat(data(snapshot.getResults())).containsExactly(map("order", 3L), map("order", 4L));
  }

  @Test
  public void testDocumentsAsSource() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .documents(
                collection.document("book1"),
                collection.document("book2"),
                collection.document("book3"))
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(3);
  }

  @Test
  public void testCollectionGroupAsSource() throws Exception {
    String subcollectionId = LocalFirestoreHelper.autoId();
    collection.document("book1").collection(subcollectionId).add(map("order", 1)).get();
    collection.document("book2").collection(subcollectionId).add(map("order", 2)).get();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collectionGroup(subcollectionId)
            .sort(field("order").ascending())
            .execute()
            .get()
            .getResults();
    assertThat(data(results)).isEqualTo(Lists.newArrayList(map("order", 1L), map("order", 2L)));
  }

  @Test
  public void testDatabaseAsSource() throws Exception {
    String randomId = LocalFirestoreHelper.autoId();
    collection.document("book1").collection("sub").add(map("order", 1, "randomId", randomId)).get();
    collection.document("book2").collection("sub").add(map("order", 2, "randomId", randomId)).get();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .database()
            .where(equal("randomId", randomId))
            .sort(field("order").ascending())
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .isEqualTo(
            Lists.newArrayList(
                map("order", 1L, "randomId", randomId), map("order", 2L, "randomId", randomId)));
  }

  @Test
  public void testFindNearest() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .findNearest(
                "embedding",
                new double[] {10.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
                FindNearest.DistanceMeasure.EUCLIDEAN,
                new FindNearestOptions().withLimit(2).withDistanceField("computedDistance"))
            .select("title", "computedDistance")
            .execute()
            .get()
            .getResults();
    assertThat(results.size()).isEqualTo(2);
    assertThat(results.get(0).getData().get("title"))
        .isEqualTo("The Hitchhiker's Guide to the Galaxy");
    assertThat((Double) results.get(0).getData().get("computedDistance")).isWithin(0.00001).of(1.0);
    assertThat(results.get(1).getData().get("title")).isEqualTo("One Hundred Years of Solitude");
    assertThat((Double) results.get(1).getData().get("computedDistance"))
        .isWithin(0.00001)
        .of(12.041594578792296);
  }

  @Test
  public void testExplain() throws Exception {
    assumeFalse(
        "Explain is not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    Pipeline pipeline =
        firestore.pipeline().createFrom(collection).sort(field("__name__").ascending());
    Pipeline.Snapshot snapshot =
        pipeline
            .execute(
                new PipelineExecuteOptions()
                    .withExplainOptions(
                        new ExplainOptions()
                            .withExecutionMode(ExplainOptions.ExecutionMode.ANALYZE)))
            .get();
    assertThat(snapshot.getResults()).isNotEmpty();
    assertThat(snapshot.getExplainStats().getText()).isNotEmpty();

    snapshot =
        pipeline
            .execute(new PipelineExecuteOptions().withExplainOptions(new ExplainOptions()))
            .get();
    assertThat(snapshot.getResults()).isNotEmpty();
    assertThat(snapshot.getExplainStats()).isNull();
  }

  @Test
  public void testOptions() throws ExecutionException, InterruptedException {
    assumeFalse(
        "Certain options are not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    PipelineExecuteOptions opts =
        new PipelineExecuteOptions()
            .withIndexMode("recommended")
            .withExplainOptions(
                new ExplainOptions().withExecutionMode(ExplainOptions.ExecutionMode.ANALYZE));

    double[] vector = {1.0, 2.0, 3.0};

    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(
                "/k",
                new CollectionOptions().withHints(new CollectionHints().withForceIndex("title")))
            .findNearest(
                "topicVectors",
                vector,
                FindNearest.DistanceMeasure.COSINE,
                new FindNearestOptions().withLimit(10).withDistanceField("distance"))
            .aggregate(
                Aggregate.withAccumulators(AggregateFunction.average("rating").as("avg_rating"))
                    .withGroups("genre"),
                new AggregateOptions()
                    .withHints(new AggregateHints().with("test_option", "test_value")));

    assertThrows(ExecutionException.class, () -> pipeline.execute(opts).get());
  }

  @Test
  public void testErrorHandling() {
    assumeFalse(
        "Error handling is not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .rawStage(RawStage.ofName("invalidStage"))
                  .execute()
                  .get();
            });
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    ApiException apiException = (ApiException) exception.getCause();
    assertThat(apiException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
  }

  @Test
  public void testType() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(field("author").equal("Douglas Adams"))
            .limit(1)
            .select(
                Expression.type("title").as("string_type"),
                Expression.type("published").as("number_type"),
                Expression.type(field("awards").mapGet("hugo")).as("boolean_type"),
                Expression.type(nullValue()).as("null_type"),
                Expression.type("embedding").as("vector_type"))
            .execute()
            .get()
            .getResults();
    assertThat(data(results))
        .containsExactly(
            map(
                "string_type",
                "string",
                "number_type",
                "int64",
                "boolean_type",
                "boolean",
                "null_type",
                "null",
                "vector_type",
                "vector"));
  }

  @Test
  public void testExplainWithError() {
    assumeFalse(
        "Explain with error is not supported against the emulator.",
        isRunningAgainstFirestoreEmulator(firestore));
    Pipeline pipeline =
        firestore.pipeline().createFrom(collection).sort(field("rating").ascending());
    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> {
              pipeline
                  .execute(
                      new PipelineExecuteOptions()
                          .withExplainOptions(
                              new ExplainOptions()
                                  .withExecutionMode(ExplainOptions.ExecutionMode.ANALYZE))
                          .with("memory_limit", 1))
                  .get();
            });
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    ApiException apiException = (ApiException) exception.getCause();
    assertThat(apiException.getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.RESOURCE_EXHAUSTED);
  }

  @Test
  public void testCrossDatabaseRejection() throws Exception {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder().setProjectId("test-project-2").build();
    try (Firestore firestore2 = firestoreOptions.getService()) {
      CollectionReference collection2 = firestore2.collection("test-collection");
      IllegalArgumentException exception =
          assertThrows(
              IllegalArgumentException.class,
              () -> {
                firestore.pipeline().collection(collection2);
              });
      assertThat(exception.getMessage()).contains("Invalid CollectionReference");
    }
  }

  @Test
  public void disallowDuplicateAliasesInAggregate() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .aggregate(countAll().as("dup"), AggregateFunction.average("rating").as("dup"));
            });
    assertThat(exception).hasMessageThat().contains("Duplicate alias or field name");
  }

  @Test
  public void disallowDuplicateAliasesInSelect() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .select(field("title").as("dup"), field("author").as("dup"));
            });
    assertThat(exception).hasMessageThat().contains("Duplicate alias or field name");
  }

  @Test
  public void disallowDuplicateAliasesInAddFields() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .addFields(field("title").as("dup"), field("author").as("dup"));
            });
    assertThat(exception).hasMessageThat().contains("Duplicate alias or field name");
  }

  @Test
  public void disallowDuplicateAliasesInDistinct() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .distinct(field("genre").as("dup"), field("author").as("dup"));
            });
    assertThat(exception).hasMessageThat().contains("Duplicate alias or field name");
  }

  @Test
  public void disallowDuplicateAliasesAcrossStages() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .select(field("title").as("title_dup"))
                  .addFields(field("author").as("author_dup"))
                  .distinct(field("genre").as("genre_dup"))
                  .select(field("title_dup").as("final_dup"), field("author_dup").as("final_dup"));
            });
    assertThat(exception).hasMessageThat().contains("Duplicate alias or field name");
  }
}
