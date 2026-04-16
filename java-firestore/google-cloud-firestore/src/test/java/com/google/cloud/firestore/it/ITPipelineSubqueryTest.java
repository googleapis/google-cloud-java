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
import static com.google.cloud.firestore.pipeline.expressions.Expression.and;
import static com.google.cloud.firestore.pipeline.expressions.Expression.constant;
import static com.google.cloud.firestore.pipeline.expressions.Expression.currentDocument;
import static com.google.cloud.firestore.pipeline.expressions.Expression.equal;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.cloud.firestore.pipeline.expressions.Expression.or;
import static com.google.cloud.firestore.pipeline.expressions.Expression.variable;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.Pipeline;
import com.google.cloud.firestore.PipelineResult;
import com.google.cloud.firestore.PipelineSource;
import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITPipelineSubqueryTest extends ITBaseTest {
  private CollectionReference collection;

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

    collection = testCollectionWithDocs(ITPipelineTest.bookDocs);
  }

  @Test
  public void testZeroResultScalarReturnsNull() throws Exception {
    Map<String, Map<String, Object>> testDocs = map("book1", map("title", "A Book Title"));

    for (Map.Entry<String, Map<String, Object>> doc : testDocs.entrySet()) {
      collection.document(doc.getKey()).set(doc.getValue()).get(5, TimeUnit.SECONDS);
    }

    Pipeline emptyScalar =
        firestore
            .pipeline()
            .collection(collection.document("book1").collection("reviews").getPath())
            .where(equal("reviewer", "Alice"))
            .select(currentDocument().as("data"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .select(emptyScalar.toScalarExpression().as("first_review_data"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    // Expecting result_data field to gracefully produce null
    assertThat(data(results)).containsExactly(Collections.singletonMap("first_review_data", null));
  }

  @Test
  public void testArraySubqueryJoinAndEmptyResult() throws Exception {
    String reviewsCollName = "book_reviews_" + UUID.randomUUID().toString();
    Map<String, Map<String, Object>> reviewsDocs =
        map(
            "r1", map("bookTitle", "The Hitchhiker's Guide to the Galaxy", "reviewer", "Alice"),
            "r2", map("bookTitle", "The Hitchhiker's Guide to the Galaxy", "reviewer", "Bob"));

    for (Map.Entry<String, Map<String, Object>> doc : reviewsDocs.entrySet()) {
      firestore
          .collection(reviewsCollName)
          .document(doc.getKey())
          .set(doc.getValue())
          .get(5, TimeUnit.SECONDS);
    }

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .select(field("reviewer").as("reviewer"))
            .sort(field("reviewer").ascending());

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(
                or(
                    equal("title", "The Hitchhiker's Guide to the Galaxy"),
                    equal("title", "Pride and Prejudice")))
            .define(field("title").as("book_title"))
            .addFields(reviewsSub.toArrayExpression().as("reviews_data"))
            .select("title", "reviews_data")
            .sort(field("title").descending())
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(
            map(
                "title",
                "The Hitchhiker's Guide to the Galaxy",
                "reviews_data",
                ImmutableList.of("Alice", "Bob")),
            map("title", "Pride and Prejudice", "reviews_data", Collections.emptyList()))
        .inOrder();
  }

  @Test
  public void testMultipleArraySubqueriesOnBooks() throws Exception {
    String reviewsCollName = "reviews_multi_" + UUID.randomUUID().toString();
    String authorsCollName = "authors_multi_" + UUID.randomUUID().toString();

    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookTitle", "1984", "rating", 5))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(authorsCollName)
        .document("a1")
        .set(map("authorName", "George Orwell", "nationality", "British"))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .select(field("rating").as("rating"));

    Pipeline authorsSub =
        firestore
            .pipeline()
            .collection(authorsCollName)
            .where(equal("authorName", variable("author_name")))
            .select(field("nationality").as("nationality"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "1984"))
            .define(field("title").as("book_title"), field("author").as("author_name"))
            .addFields(
                reviewsSub.toArrayExpression().as("reviews_data"),
                authorsSub.toArrayExpression().as("authors_data"))
            .select("title", "reviews_data", "authors_data")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(
            map(
                "title", "1984",
                "reviews_data", Collections.singletonList(5L),
                "authors_data", Collections.singletonList("British")));
  }

  @Test
  public void testArraySubqueryJoinMultipleFieldsPreservesMap() throws Exception {
    String reviewsCollName = "reviews_map_" + UUID.randomUUID().toString();

    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookTitle", "1984", "reviewer", "Alice", "rating", 5))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(reviewsCollName)
        .document("r2")
        .set(map("bookTitle", "1984", "reviewer", "Bob", "rating", 4))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .select(field("reviewer").as("reviewer"), field("rating").as("rating"))
            .sort(field("reviewer").ascending());

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "1984"))
            .define(field("title").as("book_title"))
            .addFields(reviewsSub.toArrayExpression().as("reviews_data"))
            .select("title", "reviews_data")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(
            map(
                "title",
                "1984",
                "reviews_data",
                ImmutableList.of(
                    map("reviewer", "Alice", "rating", 5L), map("reviewer", "Bob", "rating", 4L))));
  }

  @Test
  public void testArraySubqueryInWhereStageOnBooks() throws Exception {
    String reviewsCollName = "reviews_where_" + UUID.randomUUID().toString();

    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookTitle", "Dune", "reviewer", "Paul"))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(reviewsCollName)
        .document("r2")
        .set(map("bookTitle", "Foundation", "reviewer", "Hari"))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .select(field("reviewer").as("reviewer"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(or(equal("title", "Dune"), equal("title", "The Great Gatsby")))
            .define(field("title").as("book_title"))
            .where(reviewsSub.toArrayExpression().arrayContains("Paul"))
            .select("title")
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).containsExactly(map("title", "Dune"));
  }

  @Test
  public void testScalarSubquerySingleAggregationUnwrapping() throws Exception {
    String reviewsCollName = "reviews_agg_single_" + UUID.randomUUID().toString();

    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookTitle", "1984", "rating", 4))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(reviewsCollName)
        .document("r2")
        .set(map("bookTitle", "1984", "rating", 5))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .aggregate(AggregateFunction.average("rating").as("val"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "1984"))
            .define(field("title").as("book_title"))
            .addFields(reviewsSub.toScalarExpression().as("average_rating"))
            .select("title", "average_rating")
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).containsExactly(map("title", "1984", "average_rating", 4.5));
  }

  @Test
  public void testScalarSubqueryMultipleAggregationsMapWrapping() throws Exception {
    String reviewsCollName = "reviews_agg_multi_" + UUID.randomUUID().toString();

    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookTitle", "1984", "rating", 4))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(reviewsCollName)
        .document("r2")
        .set(map("bookTitle", "1984", "rating", 5))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .aggregate(
                AggregateFunction.average("rating").as("avg"),
                AggregateFunction.countAll().as("count"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "1984"))
            .define(field("title").as("book_title"))
            .addFields(reviewsSub.toScalarExpression().as("stats"))
            .select("title", "stats")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(map("title", "1984", "stats", map("avg", 4.5, "count", 2L)));
  }

  @Test
  public void testScalarSubqueryZeroResults() throws Exception {
    String reviewsCollName = "reviews_zero_" + UUID.randomUUID().toString();

    // No reviews for "1984"

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .aggregate(AggregateFunction.average("rating").as("avg"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "1984")) // "1984" exists in the main collection from setup
            .define(field("title").as("book_title"))
            .addFields(reviewsSub.toScalarExpression().as("average_rating"))
            .select("title", "average_rating")
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).containsExactly(map("title", "1984", "average_rating", null));
  }

  @Test
  public void testScalarSubqueryMultipleResultsRuntimeError() throws Exception {
    String reviewsCollName = "reviews_multiple_" + UUID.randomUUID().toString();

    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookTitle", "1984", "rating", 4))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(reviewsCollName)
        .document("r2")
        .set(map("bookTitle", "1984", "rating", 5))
        .get(5, TimeUnit.SECONDS);

    // This subquery will return 2 documents, which is invalid for
    // toScalarExpression()
    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")));

    ExecutionException e =
        assertThrows(
            ExecutionException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .where(equal("title", "1984"))
                  .define(field("title").as("book_title"))
                  .addFields(reviewsSub.toScalarExpression().as("review_data"))
                  .execute()
                  .get();
            });

    // Assert that it's an API error from the backend complaining about multiple
    // results
    assertThat(e.getCause().getMessage()).contains("Subpipeline returned multiple results.");
  }

  @Test
  public void testMixedScalarAndArraySubqueries() throws Exception {
    String reviewsCollName = "reviews_mixed_" + UUID.randomUUID().toString();

    // Set up some reviews
    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookTitle", "1984", "reviewer", "Alice", "rating", 4))
        .get(5, TimeUnit.SECONDS);
    firestore
        .collection(reviewsCollName)
        .document("r2")
        .set(map("bookTitle", "1984", "reviewer", "Bob", "rating", 5))
        .get(5, TimeUnit.SECONDS);

    // Array subquery for all reviewers
    Pipeline arraySub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .select(field("reviewer").as("reviewer"))
            .sort(field("reviewer").ascending());

    // Scalar subquery for the average rating
    Pipeline scalarSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookTitle", variable("book_title")))
            .aggregate(AggregateFunction.average("rating").as("val"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collection.getPath())
            .where(equal("title", "1984"))
            .define(field("title").as("book_title"))
            .addFields(
                arraySub.toArrayExpression().as("all_reviewers"),
                scalarSub.toScalarExpression().as("average_rating"))
            .select("title", "all_reviewers", "average_rating")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(
            map(
                "title",
                "1984",
                "all_reviewers",
                ImmutableList.of("Alice", "Bob"),
                "average_rating",
                4.5));
  }

  @Test
  public void testSingleScopeVariableUsage() throws Exception {
    String collName = "single_scope_" + UUID.randomUUID().toString();
    firestore.collection(collName).document("doc1").set(map("price", 100)).get(5, TimeUnit.SECONDS);

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collName)
            .define(field("price").multiply(0.8).as("discount"))
            .where(variable("discount").lessThan(50.0))
            .select("price")
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).isEmpty();

    firestore.collection(collName).document("doc2").set(map("price", 50)).get(5, TimeUnit.SECONDS);

    results =
        firestore
            .pipeline()
            .collection(collName)
            .define(field("price").multiply(0.8).as("discount"))
            .where(variable("discount").lessThan(50.0))
            .select("price")
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).containsExactly(map("price", 50L));
  }

  @Test
  public void testExplicitFieldBindingScopeBridging() throws Exception {
    String outerCollName = "outer_scope_" + UUID.randomUUID().toString();
    firestore
        .collection(outerCollName)
        .document("doc1")
        .set(map("title", "1984", "id", "1"))
        .get(5, TimeUnit.SECONDS);

    String reviewsCollName = "reviews_scope_" + UUID.randomUUID().toString();
    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookId", "1", "reviewer", "Alice"))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookId", variable("rid")))
            .select(field("reviewer").as("reviewer"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(outerCollName)
            .where(equal("title", "1984"))
            .define(field("id").as("rid"))
            .addFields(reviewsSub.toArrayExpression().as("reviews"))
            .select("title", "reviews")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(map("title", "1984", "reviews", ImmutableList.of("Alice")));
  }

  @Test
  public void testMultipleVariableBindings() throws Exception {
    String outerCollName = "outer_multi_" + UUID.randomUUID().toString();
    firestore
        .collection(outerCollName)
        .document("doc1")
        .set(map("title", "1984", "id", "1", "category", "sci-fi"))
        .get(5, TimeUnit.SECONDS);

    String reviewsCollName = "reviews_multi_" + UUID.randomUUID().toString();
    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookId", "1", "category", "sci-fi", "reviewer", "Alice"))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(and(equal("bookId", variable("rid")), equal("category", variable("rcat"))))
            .select(field("reviewer").as("reviewer"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(outerCollName)
            .where(equal("title", "1984"))
            .define(field("id").as("rid"), field("category").as("rcat"))
            .addFields(reviewsSub.toArrayExpression().as("reviews"))
            .select("title", "reviews")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(map("title", "1984", "reviews", ImmutableList.of("Alice")));
  }

  @Test
  public void testCurrentDocumentBinding() throws Exception {
    String outerCollName = "outer_currentdoc_" + UUID.randomUUID().toString();
    firestore
        .collection(outerCollName)
        .document("doc1")
        .set(map("title", "1984", "author", "George Orwell"))
        .get(5, TimeUnit.SECONDS);

    String reviewsCollName = "reviews_currentdoc_" + UUID.randomUUID().toString();
    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("authorName", "George Orwell", "reviewer", "Alice"))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("authorName", variable("doc").getField("author")))
            .select(field("reviewer").as("reviewer"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(outerCollName)
            .where(equal("title", "1984"))
            .define(currentDocument().as("doc"))
            .addFields(reviewsSub.toArrayExpression().as("reviews"))
            .select("title", "reviews")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(map("title", "1984", "reviews", ImmutableList.of("Alice")));
  }

  @Test
  public void testUnboundVariableCornerCase() throws Exception {
    String outerCollName = "outer_unbound_" + UUID.randomUUID().toString();
    ExecutionException e =
        assertThrows(
            ExecutionException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(outerCollName)
                  .where(equal("title", variable("unknown_var")))
                  .execute()
                  .get();
            });

    // Assert that it's an API error from the backend complaining about unknown
    // variable
    assertThat(e.getCause().getMessage()).contains("unknown variable");
  }

  @Test
  public void testVariableShadowingCollision() throws Exception {
    String outerCollName = "outer_shadow_" + UUID.randomUUID().toString();
    firestore
        .collection(outerCollName)
        .document("doc1")
        .set(map("title", "1984"))
        .get(5, TimeUnit.SECONDS);

    String innerCollName = "inner_shadow_" + UUID.randomUUID().toString();
    firestore
        .collection(innerCollName)
        .document("i1")
        .set(map("id", "test"))
        .get(5, TimeUnit.SECONDS);

    // Inner subquery re-defines variable "x" to be "inner_val"
    Pipeline sub =
        firestore
            .pipeline()
            .collection(innerCollName)
            .define(constant("inner_val").as("x"))
            .select(variable("x").as("val"));

    // Outer pipeline defines variable "x" to be "outer_val"
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(outerCollName)
            .where(equal("title", "1984"))
            .limit(1)
            .define(constant("outer_val").as("x"))
            .addFields(sub.toArrayExpression().as("shadowed"))
            .select("shadowed")
            .execute()
            .get()
            .getResults();

    // Due to innermost scope winning, the result should use "inner_val"
    // Scalar unwrapping applies because it's a single field
    assertThat(data(results)).containsExactly(map("shadowed", ImmutableList.of("inner_val")));
  }

  @Test
  public void testMissingFieldOnCurrentDocument() throws Exception {
    String outerCollName = "outer_missing_" + UUID.randomUUID().toString();
    firestore
        .collection(outerCollName)
        .document("doc1")
        .set(map("title", "1984"))
        .get(5, TimeUnit.SECONDS);

    String reviewsCollName = "reviews_missing_" + UUID.randomUUID().toString();
    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookId", "1", "reviewer", "Alice"))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(equal("bookId", variable("doc").getField("does_not_exist")))
            .select(field("reviewer").as("reviewer"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(outerCollName)
            .where(equal("title", "1984"))
            .define(currentDocument().as("doc"))
            .addFields(reviewsSub.toArrayExpression().as("reviews"))
            .select("title", "reviews")
            .execute()
            .get()
            .getResults();

    // Evaluating undefined properties acts safely
    assertThat(data(results))
        .containsExactly(map("title", "1984", "reviews", Collections.emptyList()));
  }

  @Test
  public void test3LevelDeepJoin() throws Exception {
    String publishersCollName = "publishers_" + UUID.randomUUID().toString();
    String booksCollName = "books_" + UUID.randomUUID().toString();
    String reviewsCollName = "reviews_" + UUID.randomUUID().toString();

    firestore
        .collection(publishersCollName)
        .document("p1")
        .set(map("publisherId", "pub1", "name", "Penguin"))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(booksCollName)
        .document("b1")
        .set(map("bookId", "book1", "publisherId", "pub1", "title", "1984"))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(reviewsCollName)
        .document("r1")
        .set(map("bookId", "book1", "reviewer", "Alice"))
        .get(5, TimeUnit.SECONDS);

    // reviews need to know if the publisher is Penguin
    Pipeline reviewsSub =
        firestore
            .pipeline()
            .collection(reviewsCollName)
            .where(
                and(
                    equal("bookId", variable("book_id")),
                    equal(variable("pub_name"), "Penguin") // accessing top-level pub_name
                    ))
            .select(field("reviewer").as("reviewer"));

    Pipeline booksSub =
        firestore
            .pipeline()
            .collection(booksCollName)
            .where(equal("publisherId", variable("pub_id")))
            .define(field("bookId").as("book_id"))
            .addFields(reviewsSub.toArrayExpression().as("reviews"))
            .select("title", "reviews");

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(publishersCollName)
            .where(equal("publisherId", "pub1"))
            .define(field("publisherId").as("pub_id"), field("name").as("pub_name"))
            .addFields(booksSub.toArrayExpression().as("books"))
            .select("name", "books")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(
            map(
                "name",
                "Penguin",
                "books",
                ImmutableList.of(map("title", "1984", "reviews", ImmutableList.of("Alice")))));
  }

  @Test
  public void testDeepAggregation() throws Exception {
    String outerColl = "outer_agg_" + UUID.randomUUID().toString();
    String innerColl = "inner_agg_" + UUID.randomUUID().toString();

    firestore.collection(outerColl).document("doc1").set(map("id", "1")).get(5, TimeUnit.SECONDS);
    firestore.collection(outerColl).document("doc2").set(map("id", "2")).get(5, TimeUnit.SECONDS);

    firestore
        .collection(innerColl)
        .document("i1")
        .set(map("outer_id", "1", "score", 10))
        .get(5, TimeUnit.SECONDS);
    firestore
        .collection(innerColl)
        .document("i2")
        .set(map("outer_id", "2", "score", 20))
        .get(5, TimeUnit.SECONDS);
    firestore
        .collection(innerColl)
        .document("i3")
        .set(map("outer_id", "1", "score", 30))
        .get(5, TimeUnit.SECONDS);

    // subquery calculates the score for the outer doc
    Pipeline innerSub =
        firestore
            .pipeline()
            .collection(innerColl)
            .where(equal("outer_id", variable("oid")))
            .aggregate(AggregateFunction.average("score").as("s"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(outerColl)
            .define(field("id").as("oid"))
            .addFields(innerSub.toScalarExpression().as("doc_score"))
            // Now we aggregate over the calculated subquery results
            .aggregate(AggregateFunction.sum("doc_score").as("total_score"))
            .execute()
            .get()
            .getResults();

    assertThat(data(results)).containsExactly(map("total_score", 40.0));
  }

  @Test
  public void testPipelineStageSupport10Layers() throws Exception {
    String collName = "depth_" + UUID.randomUUID().toString();
    firestore
        .collection(collName)
        .document("doc1")
        .set(map("val", "hello"))
        .get(5, TimeUnit.SECONDS);

    // Create a nested pipeline of depth 10
    Pipeline currentSubquery =
        firestore.pipeline().collection(collName).limit(1).select(field("val").as("val"));

    for (int i = 0; i < 9; i++) {
      currentSubquery =
          firestore
              .pipeline()
              .collection(collName)
              .limit(1)
              .addFields(currentSubquery.toArrayExpression().as("nested_" + i))
              .select("nested_" + i);
    }

    List<PipelineResult> results = currentSubquery.execute().get().getResults();
    assertThat(data(results)).isNotEmpty();
  }

  @Test
  public void testStandardSubcollectionQuery() throws Exception {
    String collName = "subcoll_test_" + UUID.randomUUID().toString();

    firestore
        .collection(collName)
        .document("doc1")
        .set(map("title", "1984"))
        .get(5, TimeUnit.SECONDS);

    firestore
        .collection(collName)
        .document("doc1")
        .collection("reviews")
        .document("r1")
        .set(map("reviewer", "Alice"))
        .get(5, TimeUnit.SECONDS);

    Pipeline reviewsSub =
        PipelineSource.subcollection("reviews").select(field("reviewer").as("reviewer"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collName)
            .where(equal("title", "1984"))
            .addFields(reviewsSub.toArrayExpression().as("reviews"))
            .select("title", "reviews")
            .execute()
            .get()
            .getResults();

    assertThat(data(results))
        .containsExactly(map("title", "1984", "reviews", ImmutableList.of("Alice")));
  }

  @Test
  public void testMissingSubcollection() throws Exception {
    String collName = "subcoll_missing_" + UUID.randomUUID().toString();

    firestore
        .collection(collName)
        .document("doc1")
        .set(map("id", "no_subcollection_here"))
        .get(5, TimeUnit.SECONDS);

    // Notably NO subcollections are added to doc1

    Pipeline missingSub =
        PipelineSource.subcollection("does_not_exist").select(variable("p").as("sub_p"));

    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(collName)
            .define(currentDocument().as("p"))
            .select(missingSub.toArrayExpression().as("missing_data"))
            .limit(1)
            .execute()
            .get()
            .getResults();

    // Ensure it's not null and evaluates properly to an empty array []
    assertThat(data(results)).containsExactly(map("missing_data", Collections.emptyList()));
  }

  @Test
  public void testDirectExecutionOfSubcollectionPipeline() throws Exception {
    Pipeline sub = PipelineSource.subcollection("reviews");

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> {
              // Attempting to execute a relative subcollection pipeline directly should fail
              sub.execute();
            });

    assertThat(exception)
        .hasMessageThat()
        .contains(
            "This pipeline was created without a database (e.g., as a subcollection pipeline) and"
                + " cannot be executed directly. It can only be used as part of another pipeline.");
  }

  @Test
  public void testUnionWithSubqueryThrows() throws Exception {
    ExecutionException e =
        assertThrows(
            ExecutionException.class,
            () -> {
              firestore
                  .pipeline()
                  .collection(collection.getPath())
                  .union(PipelineSource.subcollection("subcollection"))
                  .execute()
                  .get();
            });

    assertThat(e.getCause().getMessage())
        .contains(
            "The 'subcollection(...)' stage can only be used at the start of a nested pipeline.");
  }
}
