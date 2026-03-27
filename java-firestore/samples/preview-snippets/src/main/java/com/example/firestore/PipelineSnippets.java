/*
 * Copyright 2025 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.firestore;

import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.*;
import static com.google.cloud.firestore.pipeline.expressions.Expression.*;
import static com.google.cloud.firestore.pipeline.expressions.Ordering.*;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.ExplainMetrics;
import com.google.cloud.firestore.ExplainOptions;
import com.google.cloud.firestore.ExplainResults;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Pipeline;
import com.google.cloud.firestore.PlanSummary;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.pipeline.stages.Aggregate;
import com.google.cloud.firestore.pipeline.stages.FindNearest;
import com.google.cloud.firestore.pipeline.stages.FindNearestOptions;
import com.google.cloud.firestore.pipeline.stages.Sample;
import com.google.cloud.firestore.pipeline.stages.UnnestOptions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

class PipelineSnippets {
  private final Firestore firestore;

  PipelineSnippets(Firestore firestore) {
    this.firestore = firestore;
  }

  void queryExplain() throws ExecutionException, InterruptedException {
    // [START query_explain]
    Query q = firestore.collection("cities").whereGreaterThan("population", 1);
    ExplainOptions options = ExplainOptions.builder().build();

    ExplainResults<QuerySnapshot> explainResults = q.explain(options).get();
    ExplainMetrics metrics = explainResults.getMetrics();
    PlanSummary planSummary = metrics.getPlanSummary();
    // [END query_explain]
  }

  void pipelineConcepts() throws ExecutionException, InterruptedException {
    // [START pipeline_concepts]
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("cities")
            .where(field("population").greaterThan(100_000))
            .sort(ascending(field("name")))
            .limit(10);
    // [END pipeline_concepts]
    System.out.println(pipeline);
  }

  void basicRead() throws ExecutionException, InterruptedException {
    // [START basic_read]
    Pipeline pipeline = firestore.pipeline().collection("users");
    ApiFuture<Pipeline.Snapshot> future = pipeline.execute();
    for (com.google.cloud.firestore.PipelineResult result : future.get().getResults()) {
      System.out.println(result.getId() + " => " + result.getData());
    }
    // or, asynchronously
    pipeline.execute(
        new ApiStreamObserver<com.google.cloud.firestore.PipelineResult>() {
          @Override
          public void onNext(com.google.cloud.firestore.PipelineResult result) {
            System.out.println(result.getId() + " => " + result.getData());
          }

          @Override
          public void onError(Throwable t) {
            System.err.println(t);
          }

          @Override
          public void onCompleted() {
            System.out.println("done");
          }
        });
    // [END basic_read]
  }

  void pipelineInitialization() {
    // [START pipeline_initialization]
    FirestoreOptions firestoreOptions = firestore.getOptions();
    Firestore firestoreClient = firestoreOptions.getService();
    Pipeline pipeline = firestoreClient.pipeline().collection("books");
    // [END pipeline_initialization]
    System.out.println(pipeline);
  }

  void fieldVsConstants() {
    // [START field_or_constant]
    Pipeline pipeline =
        firestore.pipeline().collection("cities").where(field("name").equal(constant("Toronto")));
    // [END field_or_constant]
    System.out.println(pipeline);
  }

  void inputStages() throws ExecutionException, InterruptedException {
    // [START input_stages]
    // Return all restaurants in San Francisco
    Pipeline.Snapshot results1 =
        firestore.pipeline().collection("cities/sf/restaurants").execute().get();

    // Return all restaurants
    Pipeline.Snapshot results2 =
        firestore.pipeline().collectionGroup("restaurants").execute().get();

    // Return all documents across all collections in the database (the entire database)
    Pipeline.Snapshot results3 = firestore.pipeline().database().execute().get();

    // Batch read of 3 documents
    Pipeline.Snapshot results4 =
        firestore
            .pipeline()
            .documents(
                firestore.collection("cities").document("SF"),
                firestore.collection("cities").document("DC"),
                firestore.collection("cities").document("NY"))
            .execute()
            .get();
    // [END input_stages]
    System.out.println(results1.getResults());
    System.out.println(results2.getResults());
    System.out.println(results3.getResults());
    System.out.println(results4.getResults());
  }

  void wherePipeline() throws ExecutionException, InterruptedException {
    // [START pipeline_where]
    Pipeline.Snapshot results1 =
        firestore
            .pipeline()
            .collection("books")
            .where(field("rating").equal(5))
            .where(field("published").lessThan(1900))
            .execute()
            .get();

    Pipeline.Snapshot results2 =
        firestore
            .pipeline()
            .collection("books")
            .where(and(field("rating").equal(5), field("published").lessThan(1900)))
            .execute()
            .get();
    // [END pipeline_where]
    System.out.println(results1.getResults());
    System.out.println(results2.getResults());
  }

  void aggregateGroups() throws ExecutionException, InterruptedException {
    // [START aggregate_groups]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("books")
            .aggregate(
                Aggregate.withAccumulators(average("rating").as("avg_rating")).withGroups("genre"))
            .execute()
            .get();
    // [END aggregate_groups]
    System.out.println(results.getResults());
  }

  void aggregateDistinct() throws ExecutionException, InterruptedException {
    // [START aggregate_distinct]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("books")
            .distinct(toUpper(field("author")).as("author"), field("genre"))
            .execute()
            .get();
    // [END aggregate_distinct]
    System.out.println(results.getResults());
  }

  void sort() throws ExecutionException, InterruptedException {
    // [START sort]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("books")
            .sort(descending(field("release_date")), ascending(field("author")))
            .execute()
            .get();
    // [END sort]
    System.out.println(results.getResults());
  }

  void sortComparison() {
    // [START sort_comparison]
    Query query =
        firestore
            .collection("cities")
            .orderBy("state")
            .orderBy("population", Query.Direction.DESCENDING);

    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("books")
            .sort(descending(field("release_date")), ascending(field("author")));
    // [END sort_comparison]
    System.out.println(query);
    System.out.println(pipeline);
  }

  void functionsExample() throws ExecutionException, InterruptedException {
    // [START functions_example]
    // Type 1: Scalar (for use in non-aggregation stages)
    // Example: Return the min store price for each book.
    Pipeline.Snapshot results1 =
        firestore
            .pipeline()
            .collection("books")
            .select(logicalMinimum(field("current"), field("updated")).as("price_min"))
            .execute()
            .get();

    // Type 2: Aggregation (for use in aggregate stages)
    // Example: Return the min price of all books.
    Pipeline.Snapshot results2 =
        firestore
            .pipeline()
            .collection("books")
            .aggregate(minimum("price").as("min_price"))
            .execute()
            .get();
    // [END functions_example]
    System.out.println(results1.getResults());
    System.out.println(results2.getResults());
  }

  void creatingIndexes() throws ExecutionException, InterruptedException {
    // [START query_example]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("books")
            .where(field("published").lessThan(1900))
            .where(field("genre").equal("Science Fiction"))
            .where(field("rating").greaterThan(4.3))
            .sort(descending(field("published")))
            .execute()
            .get();
    // [END query_example]
    System.out.println(results.getResults());
  }

  void sparseIndexes() throws ExecutionException, InterruptedException {
    // [START sparse_index_example]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("books")
            .where(field("category").like("%fantasy%"))
            .execute()
            .get();
    // [END sparse_index_example]
    System.out.println(results.getResults());
  }

  void sparseIndexes2() throws ExecutionException, InterruptedException {
    // [START sparse_index_example_2]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("books")
            .sort(ascending(field("release_date")))
            .execute()
            .get();
    // [END sparse_index_example_2]
    System.out.println(results.getResults());
  }

  void coveredQuery() throws ExecutionException, InterruptedException {
    // [START covered_query]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("books")
            .where(field("category").like("%fantasy%"))
            .where(field("title").exists())
            .where(field("author").exists())
            .select("title", "author")
            .execute()
            .get();
    // [END covered_query]
    System.out.println(results.getResults());
  }

  void pagination() {
    // [START pagination_not_supported_preview]
    // Existing pagination via `start_at()`
    Query query = firestore.collection("cities").orderBy("population").startAt(1_000_000);

    // Private preview workaround using pipelines
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("cities")
            .where(field("population").greaterThanOrEqual(1_000_000))
            .sort(descending(field("population")));
    // [END pagination_not_supported_preview]
    System.out.println(query);
    System.out.println(pipeline);
  }

  void collectionStage() throws ExecutionException, InterruptedException {
    // [START collection_example]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("users/bob/games")
            .sort(ascending(field("name")))
            .execute()
            .get();
    // [END collection_example]
    System.out.println(results.getResults());
  }

  void collectionGroupStage() throws ExecutionException, InterruptedException {
    // [START collection_group_example]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collectionGroup("games")
            .sort(ascending(field("name")))
            .execute()
            .get();
    // [END collection_group_example]
    System.out.println(results.getResults());
  }

  void databaseStage() throws ExecutionException, InterruptedException {
    // [START database_example]
    // Count all documents in the database
    Pipeline.Snapshot results =
        firestore.pipeline().database().aggregate(countAll().as("total")).execute().get();
    // [END database_example]
    System.out.println(results.getResults());
  }

  void documentsStage() throws ExecutionException, InterruptedException {
    // [START documents_example]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .documents(
                firestore.collection("cities").document("SF"),
                firestore.collection("cities").document("DC"),
                firestore.collection("cities").document("NY"))
            .execute()
            .get();
    // [END documents_example]
    System.out.println(results.getResults());
  }

  void replaceWithStage() throws ExecutionException, InterruptedException {
    // [START initial_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("population", 800_000);
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "USA");
                        put("state", "California");
                      }
                    });
              }
            });
    firestore
        .collection("cities")
        .document("TO")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put("population", 3_000_000);
                put("province", "ON");
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "Canada");
                        put("province", "Ontario");
                      }
                    });
              }
            });
    firestore
        .collection("cities")
        .document("NY")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York");
                put("population", 8_500_000);
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "USA");
                        put("state", "New York");
                      }
                    });
              }
            });
    firestore
        .collection("cities")
        .document("AT")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Atlantis");
              }
            });
    // [END initial_data]

    // [START full_replace]
    Pipeline.Snapshot names =
        firestore.pipeline().collection("cities").replaceWith(field("location")).execute().get();
    // [END full_replace]

    // [START map_merge_overwrite]
    // unsupported in client SDKs for now
    // [END map_merge_overwrite]
    System.out.println(names.getResults());
  }

  void sampleStage() throws ExecutionException, InterruptedException {
    // [START sample_example]
    // Get a sample of 100 documents in a database
    Pipeline.Snapshot results1 = firestore.pipeline().database().sample(100).execute().get();

    // Randomly shuffle a list of 3 documents
    Pipeline.Snapshot results2 =
        firestore
            .pipeline()
            .documents(
                firestore.collection("cities").document("SF"),
                firestore.collection("cities").document("NY"),
                firestore.collection("cities").document("DC"))
            .sample(3)
            .execute()
            .get();
    // [END sample_example]
    System.out.println(results1.getResults());
    System.out.println(results2.getResults());
  }

  void samplePercent() throws ExecutionException, InterruptedException {
    // [START sample_percent]
    // Get a sample of on average 50% of the documents in the database
    Pipeline.Snapshot results =
        firestore.pipeline().database().sample(Sample.withPercentage(0.5)).execute().get();
    // [END sample_percent]
    System.out.println(results.getResults());
  }

  void unionStage() throws ExecutionException, InterruptedException {
    // [START union_stage]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities/SF/restaurants")
            .where(field("type").equal("Chinese"))
            .union(
                firestore
                    .pipeline()
                    .collection("cities/NY/restaurants")
                    .where(field("type").equal("Italian")))
            .where(field("rating").greaterThanOrEqual(4.5))
            .sort(descending(field("__name__")))
            .execute()
            .get();
    // [END union_stage]
    System.out.println(results.getResults());
  }

  void unionStageStable() throws ExecutionException, InterruptedException {
    // [START union_stage_stable]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities/SF/restaurants")
            .where(field("type").equal("Chinese"))
            .union(
                firestore
                    .pipeline()
                    .collection("cities/NY/restaurants")
                    .where(field("type").equal("Italian")))
            .where(field("rating").greaterThanOrEqual(4.5))
            .sort(descending(field("__name__")))
            .execute()
            .get();
    // [END union_stage_stable]
    System.out.println(results.getResults());
  }

  void unnestStage() throws ExecutionException, InterruptedException {
    // [START unnest_stage]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .database()
            .unnest("arrayField", "unnestedArrayField", new UnnestOptions().withIndexField("index"))
            .execute()
            .get();
    // [END unnest_stage]
    System.out.println(results.getResults());
  }

  void unnestStageEmptyOrNonArray() throws ExecutionException, InterruptedException {
    // [START unnest_edge_cases]
    // Input
    // { "identifier" : 1, "neighbors": [ "Alice", "Cathy" ] }
    // { "identifier" : 2, "neighbors": []                   }
    // { "identifier" : 3, "neighbors": "Bob"                }

    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .database()
            .unnest("neighbors", "unnestedNeighbors", new UnnestOptions().withIndexField("index"))
            .execute()
            .get();

    // Output
    // { "identifier": 1, "neighbors": [ "Alice", "Cathy" ],
    //   "unnestedNeighbors": "Alice", "index": 0 }
    // { "identifier": 1, "neighbors": [ "Alice", "Cathy" ],
    //   "unnestedNeighbors": "Cathy", "index": 1 }
    // { "identifier": 3, "neighbors": "Bob", "index": null}
    // [END unnest_edge_cases]
    System.out.println(results.getResults());
  }

  void countFunction() throws ExecutionException, InterruptedException {
    // [START count_function]
    // Total number of books in the collection
    Pipeline.Snapshot countAll =
        firestore.pipeline().collection("books").aggregate(countAll().as("count")).execute().get();

    // Number of books with nonnull `ratings` field
    Pipeline.Snapshot countField =
        firestore
            .pipeline()
            .collection("books")
            .aggregate(count("ratings").as("count"))
            .execute()
            .get();
    // [END count_function]
    System.out.println(countAll.getResults());
    System.out.println(countField.getResults());
  }

  void countIfFunction() throws ExecutionException, InterruptedException {
    // [START count_if]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .aggregate(countIf(field("rating").greaterThan(4)).as("filteredCount"))
            .execute()
            .get();
    // [END count_if]
    System.out.println(result.getResults());
  }

  void countDistinctFunction() throws ExecutionException, InterruptedException {
    // [START count_distinct]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .aggregate(countDistinct("author").as("unique_authors"))
            .execute()
            .get();
    // [END count_distinct]
    System.out.println(result.getResults());
  }

  void sumFunction() throws ExecutionException, InterruptedException {
    // [START sum_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("cities")
            .aggregate(sum("population").as("totalPopulation"))
            .execute()
            .get();
    // [END sum_function]
    System.out.println(result.getResults());
  }

  void avgFunction() throws ExecutionException, InterruptedException {
    // [START avg_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("cities")
            .aggregate(average("population").as("averagePopulation"))
            .execute()
            .get();
    // [END avg_function]
    System.out.println(result.getResults());
  }

  void minFunction() throws ExecutionException, InterruptedException {
    // [START min_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .aggregate(minimum("price").as("minimumPrice"))
            .execute()
            .get();
    // [END min_function]
    System.out.println(result.getResults());
  }

  void maxFunction() throws ExecutionException, InterruptedException {
    // [START max_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .aggregate(maximum("price").as("maximumPrice"))
            .execute()
            .get();
    // [END max_function]
    System.out.println(result.getResults());
  }

  void addFunction() throws ExecutionException, InterruptedException {
    // [START add_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(add(field("soldBooks"), field("unsoldBooks")).as("totalBooks"))
            .execute()
            .get();
    // [END add_function]
    System.out.println(result.getResults());
  }

  void subtractFunction() throws ExecutionException, InterruptedException {
    // [START subtract_function]
    int storeCredit = 7;
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(subtract(field("price"), storeCredit).as("totalCost"))
            .execute()
            .get();
    // [END subtract_function]
    System.out.println(result.getResults());
  }

  void multiplyFunction() throws ExecutionException, InterruptedException {
    // [START multiply_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(multiply(field("price"), field("soldBooks")).as("revenue"))
            .execute()
            .get();
    // [END multiply_function]
    System.out.println(result.getResults());
  }

  void divideFunction() throws ExecutionException, InterruptedException {
    // [START divide_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(divide(field("ratings"), field("soldBooks")).as("reviewRate"))
            .execute()
            .get();
    // [END divide_function]
    System.out.println(result.getResults());
  }

  void modFunction() throws ExecutionException, InterruptedException {
    // [START mod_function]
    int displayCapacity = 1000;
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(mod(field("unsoldBooks"), displayCapacity).as("warehousedBooks"))
            .execute()
            .get();
    // [END mod_function]
    System.out.println(result.getResults());
  }

  void ceilFunction() throws ExecutionException, InterruptedException {
    // [START ceil_function]
    int booksPerShelf = 100;
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(ceil(divide(field("unsoldBooks"), booksPerShelf)).as("requiredShelves"))
            .execute()
            .get();
    // [END ceil_function]
    System.out.println(result.getResults());
  }

  void floorFunction() throws ExecutionException, InterruptedException {
    // [START floor_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .addFields(floor(divide(field("wordCount"), field("pages"))).as("wordsPerPage"))
            .execute()
            .get();
    // [END floor_function]
    System.out.println(result.getResults());
  }

  void roundFunction() throws ExecutionException, InterruptedException {
    // [START round_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(round(multiply(field("soldBooks"), field("price"))).as("partialRevenue"))
            .aggregate(sum("partialRevenue").as("totalRevenue"))
            .execute()
            .get();
    // [END round_function]
    System.out.println(result.getResults());
  }

  void powFunction() throws ExecutionException, InterruptedException {
    // [START pow_function]
    double googleplexLat = 37.4221;
    double googleplexLng = -122.0853;
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("cities")
            .addFields(
                pow(multiply(subtract(field("lat"), googleplexLat), 111), 2)
                    .as("latitudeDifference"),
                pow(multiply(subtract(field("lng"), googleplexLng), 111), 2)
                    .as("longitudeDifference"))
            .select(
                sqrt(add(field("latitudeDifference"), field("longitudeDifference")))
                    // Inaccurate for large distances or close to poles
                    .as("approximateDistanceToGoogle"))
            .execute()
            .get();
    // [END pow_function]
    System.out.println(result.getResults());
  }

  void sqrtFunction() throws ExecutionException, InterruptedException {
    // [START sqrt_function]
    double googleplexLat = 37.4221;
    double googleplexLng = -122.0853;
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("cities")
            .addFields(
                pow(multiply(subtract(field("lat"), googleplexLat), 111), 2)
                    .as("latitudeDifference"),
                pow(multiply(subtract(field("lng"), googleplexLng), 111), 2)
                    .as("longitudeDifference"))
            .select(
                sqrt(add(field("latitudeDifference"), field("longitudeDifference")))
                    // Inaccurate for large distances or close to poles
                    .as("approximateDistanceToGoogle"))
            .execute()
            .get();
    // [END sqrt_function]
    System.out.println(result.getResults());
  }

  void expFunction() throws ExecutionException, InterruptedException {
    // [START exp_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(exp(field("rating")).as("expRating"))
            .execute()
            .get();
    // [END exp_function]
    System.out.println(result.getResults());
  }

  void lnFunction() throws ExecutionException, InterruptedException {
    // [START ln_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(ln(field("rating")).as("lnRating"))
            .execute()
            .get();
    // [END ln_function]
    System.out.println(result.getResults());
  }

  void logFunction() throws ExecutionException, InterruptedException {
    // [START log_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(log(field("rating"), 2).as("log2Rating"))
            .execute()
            .get();
    // [END log_function]
    System.out.println(result.getResults());
  }

  void arrayConcatFunction() throws ExecutionException, InterruptedException {
    // [START array_concat]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(arrayConcat(field("genre"), field("subGenre")).as("allGenres"))
            .execute()
            .get();
    // [END array_concat]
    System.out.println(result.getResults());
  }

  void arrayContainsFunction() throws ExecutionException, InterruptedException {
    // [START array_contains]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(arrayContains(field("genre"), "mystery").as("isMystery"))
            .execute()
            .get();
    // [END array_contains]
    System.out.println(result.getResults());
  }

  void arrayContainsAllFunction() throws ExecutionException, InterruptedException {
    // [START array_contains_all]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                arrayContainsAll(field("genre"), Arrays.asList("fantasy", "adventure"))
                    .as("isFantasyAdventure"))
            .execute()
            .get();
    // [END array_contains_all]
    System.out.println(result.getResults());
  }

  void arrayContainsAnyFunction() throws ExecutionException, InterruptedException {
    // [START array_contains_any]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                arrayContainsAny(field("genre"), Arrays.asList("fantasy", "nonfiction"))
                    .as("isMysteryOrFantasy"))
            .execute()
            .get();
    // [END array_contains_any]
    System.out.println(result.getResults());
  }

  void arrayLengthFunction() throws ExecutionException, InterruptedException {
    // [START array_length]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(arrayLength(field("genre")).as("genreCount"))
            .execute()
            .get();
    // [END array_length]
    System.out.println(result.getResults());
  }

  void arrayReverseFunction() throws ExecutionException, InterruptedException {
    // [START array_reverse]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(arrayReverse(field("genre")).as("reversedGenres"))
            .execute()
            .get();
    // [END array_reverse]
    System.out.println(result.getResults());
  }

  void equalFunction() throws ExecutionException, InterruptedException {
    // [START equal_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(equal(field("rating"), 5).as("hasPerfectRating"))
            .execute()
            .get();
    // [END equal_function]
    System.out.println(result.getResults());
  }

  void greaterThanFunction() throws ExecutionException, InterruptedException {
    // [START greater_than]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(greaterThan(field("rating"), 4).as("hasHighRating"))
            .execute()
            .get();
    // [END greater_than]
    System.out.println(result.getResults());
  }

  void greaterThanOrEqualToFunction() throws ExecutionException, InterruptedException {
    // [START greater_or_equal]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(greaterThanOrEqual(field("published"), 1900).as("publishedIn20thCentury"))
            .execute()
            .get();
    // [END greater_or_equal]
    System.out.println(result.getResults());
  }

  void lessThanFunction() throws ExecutionException, InterruptedException {
    // [START less_than]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(lessThan(field("published"), 1923).as("isPublicDomainProbably"))
            .execute()
            .get();
    // [END less_than]
    System.out.println(result.getResults());
  }

  void lessThanOrEqualToFunction() throws ExecutionException, InterruptedException {
    // [START less_or_equal]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(lessThanOrEqual(field("rating"), 2).as("hasBadRating"))
            .execute()
            .get();
    // [END less_or_equal]
    System.out.println(result.getResults());
  }

  void notEqualFunction() throws ExecutionException, InterruptedException {
    // [START not_equal]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(notEqual(field("title"), "1984").as("not1984"))
            .execute()
            .get();
    // [END not_equal]
    System.out.println(result.getResults());
  }

  void existsFunction() throws ExecutionException, InterruptedException {
    // [START exists_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(exists(field("rating")).as("hasRating"))
            .execute()
            .get();
    // [END exists_function]
    System.out.println(result.getResults());
  }

  void andFunction() throws ExecutionException, InterruptedException {
    // [START and_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                and(greaterThan(field("rating"), 4), lessThan(field("price"), 10))
                    .as("under10Recommendation"))
            .execute()
            .get();
    // [END and_function]
    System.out.println(result.getResults());
  }

  void orFunction() throws ExecutionException, InterruptedException {
    // [START or_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                or(equal(field("genre"), "Fantasy"), arrayContains(field("tags"), "adventure"))
                    .as("matchesSearchFilters"))
            .execute()
            .get();
    // [END or_function]
    System.out.println(result.getResults());
  }

  void xorFunction() throws ExecutionException, InterruptedException {
    // [START xor_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                xor(
                        arrayContains(field("tags"), "magic"),
                        arrayContains(field("tags"), "nonfiction"))
                    .as("matchesSearchFilters"))
            .execute()
            .get();
    // [END xor_function]
    System.out.println(result.getResults());
  }

  void notFunction() throws ExecutionException, InterruptedException {
    // [START not_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(not(arrayContains(field("tags"), "nonfiction")).as("isFiction"))
            .execute()
            .get();
    // [END not_function]
    System.out.println(result.getResults());
  }

  void condFunction() throws ExecutionException, InterruptedException {
    // [START cond_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                arrayConcat(
                        field("tags"),
                        conditional(
                            greaterThan(field("pages"), 100),
                            constant("longRead"),
                            constant("shortRead")))
                    .as("extendedTags"))
            .execute()
            .get();
    // [END cond_function]
    System.out.println(result.getResults());
  }

  void equalAnyFunction() throws ExecutionException, InterruptedException {
    // [START eq_any]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                equalAny(field("genre"), Arrays.asList("Science Fiction", "Psychological Thriller"))
                    .as("matchesGenreFilters"))
            .execute()
            .get();
    // [END eq_any]
    System.out.println(result.getResults());
  }

  void notEqualAnyFunction() throws ExecutionException, InterruptedException {
    // [START not_eq_any]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(
                notEqualAny(field("author"), Arrays.asList("George Orwell", "F. Scott Fitzgerald"))
                    .as("byExcludedAuthors"))
            .execute()
            .get();
    // [END not_eq_any]
    System.out.println(result.getResults());
  }

  void maxLogicalFunction() throws ExecutionException, InterruptedException {
    // [START max_logical_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(logicalMaximum(field("rating"), 1).as("flooredRating"))
            .execute()
            .get();
    // [END max_logical_function]
    System.out.println(result.getResults());
  }

  void minLogicalFunction() throws ExecutionException, InterruptedException {
    // [START min_logical_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(logicalMinimum(field("rating"), 5).as("cappedRating"))
            .execute()
            .get();
    // [END min_logical_function]
    System.out.println(result.getResults());
  }

  void mapGetFunction() throws ExecutionException, InterruptedException {
    // [START map_get]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(mapGet(field("awards"), "pulitzer").as("hasPulitzerAward"))
            .execute()
            .get();
    // [END map_get]
    System.out.println(result.getResults());
  }

  void mapSetFunction() throws ExecutionException, InterruptedException {
    // [START map_set]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(mapSet(field("awards"), "pulitzer", true).as("awards"))
            .execute()
            .get();
    // [END map_set]
    System.out.println(result.getResults());
  }

  void mapKeysFunction() throws ExecutionException, InterruptedException {
    // [START map_keys]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(mapKeys(field("awards")).as("award_categories"))
            .execute()
            .get();
    // [END map_keys]
    System.out.println(result.getResults());
  }

  void mapValuesFunction() throws ExecutionException, InterruptedException {
    // [START map_values]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(mapValues(field("awards")).as("award_details"))
            .execute()
            .get();
    // [END map_values]
    System.out.println(result.getResults());
  }

  void mapEntriesFunction() throws ExecutionException, InterruptedException {
    // [START map_entries]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(mapEntries(field("awards")).as("awards_list"))
            .execute()
            .get();
    // [END map_entries]
    System.out.println(result.getResults());
  }

  void byteLengthFunction() throws ExecutionException, InterruptedException {
    // [START byte_length]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(byteLength(field("title")).as("titleByteLength"))
            .execute()
            .get();
    // [END byte_length]
    System.out.println(result.getResults());
  }

  void charLengthFunction() throws ExecutionException, InterruptedException {
    // [START char_length]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(charLength(field("title")).as("titleCharLength"))
            .execute()
            .get();
    // [END char_length]
    System.out.println(result.getResults());
  }

  void startsWithFunction() throws ExecutionException, InterruptedException {
    // [START starts_with]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(startsWith(field("title"), "The").as("needsSpecialAlphabeticalSort"))
            .execute()
            .get();
    // [END starts_with]
    System.out.println(result.getResults());
  }

  void endsWithFunction() throws ExecutionException, InterruptedException {
    // [START ends_with]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("inventory/devices/laptops")
            .select(endsWith(field("name"), "16 inch").as("16InLaptops"))
            .execute()
            .get();
    // [END ends_with]
    System.out.println(result.getResults());
  }

  void likeFunction() throws ExecutionException, InterruptedException {
    // [START like]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(like(field("genre"), "%Fiction").as("anyFiction"))
            .execute()
            .get();
    // [END like]
    System.out.println(result.getResults());
  }

  void regexContainsFunction() throws ExecutionException, InterruptedException {
    // [START regex_contains]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(
                regexContains(field("title"), "Firestore (Enterprise|Standard)")
                    .as("isFirestoreRelated"))
            .execute()
            .get();
    // [END regex_contains]
    System.out.println(result.getResults());
  }

  void regexFindFunction() throws ExecutionException, InterruptedException {
    // [START regex_find]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(regexFind(field("email"), "@[A-Za-z0-9.-]+").as("domain"))
            .execute()
            .get();
    // [END regex_find]
    System.out.println(result.getResults());
  }

  void regexFindAllFunction() throws ExecutionException, InterruptedException {
    // [START regex_find_all]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(regexFindAll(field("comment"), "@[A-Za-z0-9_]+").as("mentions"))
            .execute()
            .get();
    // [END regex_find_all]
    System.out.println(result.getResults());
  }

  void regexMatchFunction() throws ExecutionException, InterruptedException {
    // [START regex_match]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(
                regexMatch(field("title"), "Firestore (Enterprise|Standard)")
                    .as("isFirestoreExactly"))
            .execute()
            .get();
    // [END regex_match]
    System.out.println(result.getResults());
  }

  void strConcatFunction() throws ExecutionException, InterruptedException {
    // [START str_concat]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(stringConcat(field("title"), " by ", field("author")).as("fullyQualifiedTitle"))
            .execute()
            .get();
    // [END str_concat]
    System.out.println(result.getResults());
  }

  void strContainsFunction() throws ExecutionException, InterruptedException {
    // [START string_contains]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("articles")
            .select(stringContains(field("body"), "Firestore").as("isFirestoreRelated"))
            .execute()
            .get();
    // [END string_contains]
    System.out.println(result.getResults());
  }

  void toUpperFunction() throws ExecutionException, InterruptedException {
    // [START to_upper]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("authors")
            .select(toUpper(field("name")).as("uppercaseName"))
            .execute()
            .get();
    // [END to_upper]
    System.out.println(result.getResults());
  }

  void toLowerFunction() throws ExecutionException, InterruptedException {
    // [START to_lower]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("authors")
            .select(equal(toLower(field("genre")), "fantasy").as("isFantasy"))
            .execute()
            .get();
    // [END to_lower]
    System.out.println(result.getResults());
  }

  void substrFunction() throws ExecutionException, InterruptedException {
    // [START substr_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .where(startsWith(field("title"), "The "))
            .select(
                substring(field("title"), constant(4), field("title").charLength())
                    .as("titleWithoutLeadingThe"))
            .execute()
            .get();
    // [END substr_function]
    System.out.println(result.getResults());
  }

  void strReverseFunction() throws ExecutionException, InterruptedException {
    // [START str_reverse]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(reverse(field("name")).as("reversedName"))
            .execute()
            .get();
    // [END str_reverse]
    System.out.println(result.getResults());
  }

  void strTrimFunction() throws ExecutionException, InterruptedException {
    // [START trim_function]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(trim(field("name")).as("whitespaceTrimmedName"))
            .execute()
            .get();
    // [END trim_function]
    System.out.println(result.getResults());
  }

  void unixMicrosToTimestampFunction() throws ExecutionException, InterruptedException {
    // [START unix_micros_timestamp]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(unixMicrosToTimestamp(field("createdAtMicros")).as("createdAtString"))
            .execute()
            .get();
    // [END unix_micros_timestamp]
    System.out.println(result.getResults());
  }

  void unixMillisToTimestampFunction() throws ExecutionException, InterruptedException {
    // [START unix_millis_timestamp]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(unixMillisToTimestamp(field("createdAtMillis")).as("createdAtString"))
            .execute()
            .get();
    // [END unix_millis_timestamp]
    System.out.println(result.getResults());
  }

  void unixSecondsToTimestampFunction() throws ExecutionException, InterruptedException {
    // [START unix_seconds_timestamp]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(unixSecondsToTimestamp(field("createdAtSeconds")).as("createdAtString"))
            .execute()
            .get();
    // [END unix_seconds_timestamp]
    System.out.println(result.getResults());
  }

  void timestampAddFunction() throws ExecutionException, InterruptedException {
    // [START timestamp_add]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(timestampAdd(field("createdAt"), "day", 3653).as("expiresAt"))
            .execute()
            .get();
    // [END timestamp_add]
    System.out.println(result.getResults());
  }

  void timestampSubFunction() throws ExecutionException, InterruptedException {
    // [START timestamp_sub]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(timestampSubtract(field("expiresAt"), "day", 14).as("sendWarningTimestamp"))
            .execute()
            .get();
    // [END timestamp_sub]
    System.out.println(result.getResults());
  }

  void timestampToUnixMicrosFunction() throws ExecutionException, InterruptedException {
    // [START timestamp_unix_micros]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(timestampToUnixMicros(field("dateString")).as("unixMicros"))
            .execute()
            .get();
    // [END timestamp_unix_micros]
    System.out.println(result.getResults());
  }

  void timestampToUnixMillisFunction() throws ExecutionException, InterruptedException {
    // [START timestamp_unix_millis]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(timestampToUnixMillis(field("dateString")).as("unixMillis"))
            .execute()
            .get();
    // [END timestamp_unix_millis]
    System.out.println(result.getResults());
  }

  void timestampToUnixSecondsFunction() throws ExecutionException, InterruptedException {
    // [START timestamp_unix_seconds]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("documents")
            .select(timestampToUnixSeconds(field("dateString")).as("unixSeconds"))
            .execute()
            .get();
    // [END timestamp_unix_seconds]
    System.out.println(result.getResults());
  }

  void cosineDistanceFunction() throws ExecutionException, InterruptedException {
    // [START cosine_distance]
    double[] sampleVector = new double[] {0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(cosineDistance(field("embedding"), sampleVector).as("cosineDistance"))
            .execute()
            .get();
    // [END cosine_distance]
    System.out.println(result.getResults());
  }

  void dotProductFunction() throws ExecutionException, InterruptedException {
    // [START dot_product]
    double[] sampleVector = new double[] {0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(dotProduct(field("embedding"), sampleVector).as("dotProduct"))
            .execute()
            .get();
    // [END dot_product]
    System.out.println(result.getResults());
  }

  void euclideanDistanceFunction() throws ExecutionException, InterruptedException {
    // [START euclidean_distance]
    double[] sampleVector = new double[] {0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(euclideanDistance(field("embedding"), sampleVector).as("euclideanDistance"))
            .execute()
            .get();
    // [END euclidean_distance]
    System.out.println(result.getResults());
  }

  void vectorLengthFunction() throws ExecutionException, InterruptedException {
    // [START vector_length]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collection("books")
            .select(vectorLength(field("embedding")).as("vectorLength"))
            .execute()
            .get();
    // [END vector_length]
    System.out.println(result.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/getting-started/stages-expressions
  void stagesExpressionsExample() throws ExecutionException, InterruptedException {
    // [START stages_expressions_example]
    com.google.cloud.firestore.pipeline.expressions.Expression trailing30Days =
        constant(com.google.cloud.Timestamp.now().toProto().getSeconds() * 1000)
            .unixMillisToTimestamp()
            .timestampSubtract("day", 30);
    Pipeline.Snapshot snapshot =
        firestore
            .pipeline()
            .collection("productViews")
            .where(field("viewedAt").greaterThan(trailing30Days))
            .aggregate(countDistinct("productId").as("uniqueProductViews"))
            .execute()
            .get();
    // [END stages_expressions_example]
    System.out.println(snapshot.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/where
  void createWhereData() {
    // [START create_where_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "CA");
                put("country", "USA");
                put("population", 870000);
              }
            });
    firestore
        .collection("cities")
        .document("LA")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Los Angeles");
                put("state", "CA");
                put("country", "USA");
                put("population", 3970000);
              }
            });
    firestore
        .collection("cities")
        .document("NY")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York");
                put("state", "NY");
                put("country", "USA");
                put("population", 8530000);
              }
            });
    firestore
        .collection("cities")
        .document("TOR")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put("state", null);
                put("country", "Canada");
                put("population", 2930000);
              }
            });
    firestore
        .collection("cities")
        .document("MEX")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Mexico City");
                put("state", null);
                put("country", "Mexico");
                put("population", 9200000);
              }
            });
    // [END create_where_data]
  }

  void whereEqualityExample() throws ExecutionException, InterruptedException {
    // [START where_equality_example]
    Pipeline.Snapshot cities =
        firestore.pipeline().collection("cities").where(field("state").equal("CA")).execute().get();
    // [END where_equality_example]
    System.out.println(cities.getResults());
  }

  void whereMultipleStagesExample() throws ExecutionException, InterruptedException {
    // [START where_multiple_stages]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .where(field("location.country").equal("USA"))
            .where(field("population").greaterThan(500000))
            .execute()
            .get();
    // [END where_multiple_stages]
    System.out.println(cities.getResults());
  }

  void whereComplexExample() throws ExecutionException, InterruptedException {
    // [START where_complex]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .where(
                or(
                    like(field("name"), "San%"),
                    and(
                        field("location.state").charLength().greaterThan(7),
                        field("location.country").equal("USA"))))
            .execute()
            .get();
    // [END where_complex]
    System.out.println(cities.getResults());
  }

  void whereStageOrderExample() throws ExecutionException, InterruptedException {
    // [START where_stage_order]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .limit(10)
            .where(field("location.country").equal("USA"))
            .execute()
            .get();
    // [END where_stage_order]
    System.out.println(cities.getResults());
  }

  void whereHavingExample() throws ExecutionException, InterruptedException {
    // [START where_having_example]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .aggregate(
                Aggregate.withAccumulators(sum("population").as("totalPopulation"))
                    .withGroups("location.state"))
            .where(field("totalPopulation").greaterThan(10000000))
            .execute()
            .get();
    // [END where_having_example]
    System.out.println(cities.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/unnest
  void unnestSyntaxExample() throws ExecutionException, InterruptedException {
    // [START unnest_syntax]
    Pipeline.Snapshot userScore =
        firestore
            .pipeline()
            .collection("users")
            .unnest("scores", "userScore", new UnnestOptions().withIndexField("attempt"))
            .execute()
            .get();
    // [END unnest_syntax]
    System.out.println(userScore.getResults());
  }

  void unnestAliasIndexDataExample() {
    // [START unnest_alias_index_data]
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "foo");
                put("scores", Arrays.asList(5, 4));
                put("userScore", 0);
              }
            });
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "bar");
                put("scores", Arrays.asList(1, 3));
                put("attempt", 5);
              }
            });
    // [END unnest_alias_index_data]
  }

  void unnestAliasIndexExample() throws ExecutionException, InterruptedException {
    // [START unnest_alias_index]
    Pipeline.Snapshot userScore =
        firestore
            .pipeline()
            .collection("users")
            .unnest("scores", "userScore", new UnnestOptions().withIndexField("attempt"))
            .execute()
            .get();
    // [END unnest_alias_index]
    System.out.println(userScore.getResults());
  }

  void unnestNonArrayDataExample() {
    // [START unnest_nonarray_data]
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "foo");
                put("scores", 1);
              }
            });
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "bar");
                put("scores", null);
              }
            });
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "qux");
                put(
                    "scores",
                    new HashMap<String, Object>() {
                      {
                        put("backupScores", 1);
                      }
                    });
              }
            });
    // [END unnest_nonarray_data]
  }

  void unnestNonArrayExample() throws ExecutionException, InterruptedException {
    // [START unnest_nonarray]
    Pipeline.Snapshot userScore =
        firestore
            .pipeline()
            .collection("users")
            .unnest("scores", "userScore", new UnnestOptions().withIndexField("attempt"))
            .execute()
            .get();
    // [END unnest_nonarray]
    System.out.println(userScore.getResults());
  }

  void unnestEmptyArrayDataExample() {
    // [START unnest_empty_array_data]
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "foo");
                put("scores", Arrays.asList(5, 4));
              }
            });
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "bar");
                put("scores", Arrays.asList());
              }
            });
    // [END unnest_empty_array_data]
  }

  void unnestEmptyArrayExample() throws ExecutionException, InterruptedException {
    // [START unnest_empty_array]
    Pipeline.Snapshot userScore =
        firestore
            .pipeline()
            .collection("users")
            .unnest("scores", "userScore", new UnnestOptions().withIndexField("attempt"))
            .execute()
            .get();
    // [END unnest_empty_array]
    System.out.println(userScore.getResults());
  }

  void unnestPreserveEmptyArrayExample() throws ExecutionException, InterruptedException {
    // [START unnest_preserve_empty_array]
    // Seems like the unnest method is missing:
    // https://github.com/googleapis/java-firestore/blob/742fab6583c9a6f9c47cf0496124c3c9b05fe0ee/google-cloud-firestore/src/main/java/com/google/cloud/firestore/Pipeline.java#L995
    // Pipeline.Snapshot userScore =
    //     firestore
    //         .pipeline()
    //         .collection("users")
    //         .unnest(
    //             conditional(
    //                 field("scores").equal(array()),
    //                 array(field("scores")),
    //                 field("scores")
    //             ).as("userScore"),
    //             new UnnestOptions().withIndexField("attempt"))
    //         .execute()
    //         .get();
    // [END unnest_preserve_empty_array]
    // System.out.println(userScore.getResults());
  }

  void unnestNestedDataExample() {
    // [START unnest_nested_data]
    firestore
        .collection("users")
        .add(
            new HashMap<String, Object>() {
              {
                put("name", "foo");
                put(
                    "record",
                    Arrays.asList(
                        new HashMap<String, Object>() {
                          {
                            put("scores", Arrays.asList(5, 4));
                            put("avg", 4.5);
                          }
                        },
                        new HashMap<String, Object>() {
                          {
                            put("scores", Arrays.asList(1, 3));
                            put("old_avg", 2);
                          }
                        }));
              }
            });
    // [END unnest_nested_data]
  }

  void unnestNestedExample() throws ExecutionException, InterruptedException {
    // [START unnest_nested]
    Pipeline.Snapshot userScore =
        firestore
            .pipeline()
            .collection("users")
            .unnest("record", "record")
            .unnest("record.scores", "userScore", new UnnestOptions().withIndexField("attempt"))
            .execute()
            .get();
    // [END unnest_nested]
    System.out.println(userScore.getResults());
  }

  // https://cloud.corp.google.com/firestore/docs/pipeline/stages/transformation/sample
  void sampleSyntaxExample() throws ExecutionException, InterruptedException {
    // [START sample_syntax]
    Pipeline.Snapshot sampled1 = firestore.pipeline().database().sample(50).execute().get();

    Pipeline.Snapshot sampled2 =
        firestore.pipeline().database().sample(Sample.withPercentage(0.5)).execute().get();
    // [END sample_syntax]
    System.out.println(sampled1.getResults());
    System.out.println(sampled2.getResults());
  }

  void sampleDocumentsDataExample() {
    // [START sample_documents_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "California");
              }
            });
    firestore
        .collection("cities")
        .document("NYC")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York City");
                put("state", "New York");
              }
            });
    firestore
        .collection("cities")
        .document("CHI")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Chicago");
                put("state", "Illinois");
              }
            });
    // [END sample_documents_data]
  }

  void sampleDocumentsExample() throws ExecutionException, InterruptedException {
    // [START sample_documents]
    Pipeline.Snapshot sampled = firestore.pipeline().collection("cities").sample(1).execute().get();
    // [END sample_documents]
    System.out.println(sampled.getResults());
  }

  void sampleAllDocumentsExample() throws ExecutionException, InterruptedException {
    // [START sample_all_documents]
    Pipeline.Snapshot sampled = firestore.pipeline().collection("cities").sample(5).execute().get();
    // [END sample_all_documents]
    System.out.println(sampled.getResults());
  }

  void samplePercentageDataExample() {
    // [START sample_percentage_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "California");
              }
            });
    firestore
        .collection("cities")
        .document("NYC")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York City");
                put("state", "New York");
              }
            });
    firestore
        .collection("cities")
        .document("CHI")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Chicago");
                put("state", "Illinois");
              }
            });
    firestore
        .collection("cities")
        .document("ATL")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Atlanta");
                put("state", "Georgia");
              }
            });
    // [END sample_percentage_data]
  }

  void samplePercentageExample() throws ExecutionException, InterruptedException {
    // [START sample_percentage]
    Pipeline.Snapshot sampled =
        firestore
            .pipeline()
            .collection("cities")
            .sample(Sample.withPercentage(0.5))
            .execute()
            .get();
    // [END sample_percentage]
    System.out.println(sampled.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/sort
  void sortSyntaxExample() throws ExecutionException, InterruptedException {
    // [START sort_syntax]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities")
            .sort(ascending(field("population")))
            .execute()
            .get();
    // [END sort_syntax]
    System.out.println(results.getResults());
  }

  void sortSyntaxExample2() throws ExecutionException, InterruptedException {
    // [START sort_syntax_2]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities")
            .sort(ascending(charLength(field("name"))))
            .execute()
            .get();
    // [END sort_syntax_2]
    System.out.println(results.getResults());
  }

  void sortDocumentIDExample() throws ExecutionException, InterruptedException {
    // [START sort_document_id]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities")
            .sort(ascending(field("country")), ascending(field("__name__")))
            .execute()
            .get();
    // [END sort_document_id]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/select
  void selectSyntaxExample() throws ExecutionException, InterruptedException {
    // [START select_syntax]
    Pipeline.Snapshot names =
        firestore
            .pipeline()
            .collection("cities")
            .select(
                stringConcat(field("name"), ", ", field("location.country")).as("name"),
                field("population"))
            .execute()
            .get();
    // [END select_syntax]
    System.out.println(names.getResults());
  }

  void selectPositionDataExample() {
    // [START select_position_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("population", 800000);
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "USA");
                        put("state", "California");
                      }
                    });
              }
            });
    firestore
        .collection("cities")
        .document("TO")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put("population", 3000000);
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "Canada");
                        put("province", "Ontario");
                      }
                    });
              }
            });
    // [END select_position_data]
  }

  void selectPositionExample() throws ExecutionException, InterruptedException {
    // [START select_position]
    Pipeline.Snapshot names =
        firestore
            .pipeline()
            .collection("cities")
            .where(field("location.country").equal("Canada"))
            .select(
                stringConcat(field("name"), ", ", field("location.country")).as("name"),
                field("population"))
            .execute()
            .get();
    // [END select_position]
    System.out.println(names.getResults());
  }

  void selectBadPositionExample() throws ExecutionException, InterruptedException {
    // [START select_bad_position]
    Pipeline.Snapshot names =
        firestore
            .pipeline()
            .collection("cities")
            .select(
                stringConcat(field("name"), ", ", field("location.country")).as("name"),
                field("population"))
            .where(field("location.country").equal("Canada"))
            .execute()
            .get();
    // [END select_bad_position]
    System.out.println(names.getResults());
  }

  void selectNestedDataExample() {
    // [START select_nested_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("population", 800000);
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "USA");
                        put("state", "California");
                      }
                    });
                put("landmarks", Arrays.asList("Golden Gate Bridge", "Alcatraz"));
              }
            });
    firestore
        .collection("cities")
        .document("TO")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put("population", 3000000);
                put("province", "ON");
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "Canada");
                        put("province", "Ontario");
                      }
                    });
                put("landmarks", Arrays.asList("CN Tower", "Casa Loma"));
              }
            });
    firestore
        .collection("cities")
        .document("AT")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Atlantis");
                put("population", null);
              }
            });
    // [END select_nested_data]
  }

  void selectNestedExample() throws ExecutionException, InterruptedException {
    // [START select_nested]
    Pipeline.Snapshot locations =
        firestore
            .pipeline()
            .collection("cities")
            .select(
                field("name").as("city"),
                field("location.country").as("country"),
                arrayGet(field("landmarks"), 0).as("topLandmark"))
            .execute()
            .get();
    // [END select_nested]
    System.out.println(locations.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/remove_fields
  void removeFieldsSyntaxExample() throws ExecutionException, InterruptedException {
    // [START remove_fields_syntax]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities")
            .removeFields("population", "location.state")
            .execute()
            .get();
    // [END remove_fields_syntax]
    System.out.println(results.getResults());
  }

  void removeFieldsNestedDataExample() {
    // [START remove_fields_nested_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "USA");
                        put("state", "California");
                      }
                    });
              }
            });
    firestore
        .collection("cities")
        .document("TO")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put(
                    "location",
                    new HashMap<String, Object>() {
                      {
                        put("country", "Canada");
                        put("province", "Ontario");
                      }
                    });
              }
            });
    // [END remove_fields_nested_data]
  }

  void removeFieldsNestedExample() throws ExecutionException, InterruptedException {
    // [START remove_fields_nested]
    Pipeline.Snapshot results =
        firestore.pipeline().collection("cities").removeFields("location.state").execute().get();
    // [END remove_fields_nested]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/limit
  void limitSyntaxExample() throws ExecutionException, InterruptedException {
    // [START limit_syntax]
    Pipeline.Snapshot results = firestore.pipeline().collection("cities").limit(10).execute().get();
    // [END limit_syntax]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/find_nearest
  void findNearestSyntaxExample() throws ExecutionException, InterruptedException {
    // [START find_nearest_syntax]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities")
            .findNearest(
                "embedding",
                new double[] {1.5, 2.345},
                FindNearest.DistanceMeasure.EUCLIDEAN,
                new FindNearestOptions())
            .execute()
            .get();
    // [END find_nearest_syntax]
    System.out.println(results.getResults());
  }

  void findNearestLimitExample() throws ExecutionException, InterruptedException {
    // [START find_nearest_limit]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities")
            .findNearest(
                "embedding",
                new double[] {1.5, 2.345},
                FindNearest.DistanceMeasure.EUCLIDEAN,
                new FindNearestOptions().withLimit(10))
            .execute()
            .get();
    // [END find_nearest_limit]
    System.out.println(results.getResults());
  }

  void findNearestDistanceDataExample() {
    // [START find_nearest_distance_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("embedding", Arrays.asList(1.0, -1.0));
              }
            });
    firestore
        .collection("cities")
        .document("TO")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put("embedding", Arrays.asList(5.0, -10.0));
              }
            });
    firestore
        .collection("cities")
        .document("AT")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Atlantis");
                put("embedding", Arrays.asList(2.0, -4.0));
              }
            });
    // [END find_nearest_distance_data]
  }

  void findNearestDistanceExample() throws ExecutionException, InterruptedException {
    // [START find_nearest_distance]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities")
            .findNearest(
                "embedding",
                new double[] {1.3, 2.345},
                FindNearest.DistanceMeasure.EUCLIDEAN,
                new FindNearestOptions().withDistanceField("computedDistance"))
            .execute()
            .get();
    // [END find_nearest_distance]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/offset
  void offsetSyntaxExample() throws ExecutionException, InterruptedException {
    // [START offset_syntax]
    Pipeline.Snapshot results =
        firestore.pipeline().collection("cities").offset(10).execute().get();
    // [END offset_syntax]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/add_fields
  void addFieldsSyntaxExample() throws ExecutionException, InterruptedException {
    // [START add_fields_syntax]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("users")
            .addFields(stringConcat(field("firstName"), " ", field("lastName")).as("fullName"))
            .execute()
            .get();
    // [END add_fields_syntax]
    System.out.println(results.getResults());
  }

  void addFieldsOverlapExample() throws ExecutionException, InterruptedException {
    // [START add_fields_overlap]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("users")
            .addFields(abs(field("age")).as("age"))
            .addFields(add(field("age"), 10).as("age"))
            .execute()
            .get();
    // [END add_fields_overlap]
    System.out.println(results.getResults());
  }

  void addFieldsNestingExample() throws ExecutionException, InterruptedException {
    // [START add_fields_nesting]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("users")
            .addFields(toLower(field("address.city")).as("address.city"))
            .execute()
            .get();
    // [END add_fields_nesting]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/input/collection
  void collectionInputSyntaxExample() throws ExecutionException, InterruptedException {
    // [START collection_input_syntax]
    Pipeline.Snapshot results =
        firestore.pipeline().collection("cities/SF/departments").execute().get();
    // [END collection_input_syntax]
    System.out.println(results.getResults());
  }

  void collectionInputExampleData() {
    // [START collection_input_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "California");
              }
            });
    firestore
        .collection("cities")
        .document("NYC")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York City");
                put("state", "New York");
              }
            });
    firestore
        .collection("cities")
        .document("CHI")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Chicago");
                put("state", "Illinois");
              }
            });
    firestore
        .collection("states")
        .document("CA")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "California");
              }
            });
    // [END collection_input_data]
  }

  void collectionInputExample() throws ExecutionException, InterruptedException {
    // [START collection_input]
    Pipeline.Snapshot results =
        firestore.pipeline().collection("cities").sort(ascending(field("name"))).execute().get();
    // [END collection_input]
    System.out.println(results.getResults());
  }

  void subcollectionInputExampleData() {
    // [START subcollection_input_data]
    firestore
        .collection("cities/SF/departments")
        .document("building")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "SF Building Department");
                put("employees", 750);
              }
            });
    firestore
        .collection("cities/NY/departments")
        .document("building")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "NY Building Department");
                put("employees", 1000);
              }
            });
    firestore
        .collection("cities/CHI/departments")
        .document("building")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "CHI Building Department");
                put("employees", 900);
              }
            });
    firestore
        .collection("cities/NY/departments")
        .document("finance")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "NY Finance Department");
                put("employees", 1200);
              }
            });
    // [END subcollection_input_data]
  }

  void subcollectionInputExample() throws ExecutionException, InterruptedException {
    // [START subcollection_input]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities/NY/departments")
            .sort(ascending(field("employees")))
            .execute()
            .get();
    // [END subcollection_input]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/input/collection_group
  void collectionGroupInputSyntaxExample() throws ExecutionException, InterruptedException {
    // [START collection_group_input_syntax]
    Pipeline.Snapshot results = firestore.pipeline().collectionGroup("departments").execute().get();
    // [END collection_group_input_syntax]
    System.out.println(results.getResults());
  }

  void collectionGroupInputExampleData() {
    // [START collection_group_data]
    firestore
        .collection("cities/SF/departments")
        .document("building")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "SF Building Department");
                put("employees", 750);
              }
            });
    firestore
        .collection("cities/NY/departments")
        .document("building")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "NY Building Department");
                put("employees", 1000);
              }
            });
    firestore
        .collection("cities/CHI/departments")
        .document("building")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "CHI Building Department");
                put("employees", 900);
              }
            });
    firestore
        .collection("cities/NY/departments")
        .document("finance")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "NY Finance Department");
                put("employees", 1200);
              }
            });
    // [END collection_group_data]
  }

  void collectionGroupInputExample() throws ExecutionException, InterruptedException {
    // [START collection_group_input]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collectionGroup("departments")
            .sort(ascending(field("employees")))
            .execute()
            .get();
    // [END collection_group_input]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/input/database
  void databaseInputSyntaxExample() throws ExecutionException, InterruptedException {
    // [START database_syntax]
    Pipeline.Snapshot results = firestore.pipeline().database().execute().get();
    // [END database_syntax]
    System.out.println(results.getResults());
  }

  void databaseInputSyntaxExampleData() {
    // [START database_input_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "California");
                put("population", 800000);
              }
            });
    firestore
        .collection("states")
        .document("CA")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "California");
                put("population", 39000000);
              }
            });
    firestore
        .collection("countries")
        .document("USA")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "United States of America");
                put("population", 340000000);
              }
            });
    // [END database_input_data]
  }

  void databaseInputExample() throws ExecutionException, InterruptedException {
    // [START database_input]
    Pipeline.Snapshot results =
        firestore.pipeline().database().sort(ascending(field("population"))).execute().get();
    // [END database_input]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/input/documents
  void documentInputSyntaxExample() throws ExecutionException, InterruptedException {
    // [START document_input_syntax]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .documents(
                firestore.collection("cities").document("SF"),
                firestore.collection("cities").document("NY"))
            .execute()
            .get();
    // [END document_input_syntax]
    System.out.println(results.getResults());
  }

  void documentInputExampleData() {
    // [START document_input_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "California");
              }
            });
    firestore
        .collection("cities")
        .document("NYC")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York City");
                put("state", "New York");
              }
            });
    firestore
        .collection("cities")
        .document("CHI")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Chicago");
                put("state", "Illinois");
              }
            });
    // [END document_input_data]
  }

  void documentInputExample() throws ExecutionException, InterruptedException {
    // [START document_input]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .documents(
                firestore.collection("cities").document("SF"),
                firestore.collection("cities").document("NYC"))
            .sort(ascending(field("name")))
            .execute()
            .get();
    // [END document_input]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/union
  void unionSyntaxExample() throws ExecutionException, InterruptedException {
    // [START union_syntax]
    Pipeline.Snapshot results =
        firestore
            .pipeline()
            .collection("cities/SF/restaurants")
            .union(firestore.pipeline().collection("cities/NYC/restaurants"))
            .execute()
            .get();
    // [END union_syntax]
    System.out.println(results.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/aggregate
  void aggregateSyntaxExample() throws ExecutionException, InterruptedException {
    // [START aggregate_syntax]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .aggregate(countAll().as("total"), average("population").as("averagePopulation"))
            .execute()
            .get();
    // [END aggregate_syntax]
    System.out.println(cities.getResults());
  }

  void aggregateGroupSyntax() throws ExecutionException, InterruptedException {
    // [START aggregate_group_syntax]
    Pipeline.Snapshot result =
        firestore
            .pipeline()
            .collectionGroup("cities")
            .aggregate(
                Aggregate.withAccumulators(
                        countAll().as("cities"), sum("population").as("totalPopulation"))
                    .withGroups(field("location.state").as("state")))
            .execute()
            .get();
    // [END aggregate_group_syntax]
    System.out.println(result.getResults());
  }

  void aggregateExampleData() {
    // [START aggregate_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "CA");
                put("country", "USA");
                put("population", 870000);
              }
            });
    firestore
        .collection("cities")
        .document("LA")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Los Angeles");
                put("state", "CA");
                put("country", "USA");
                put("population", 3970000);
              }
            });
    firestore
        .collection("cities")
        .document("NY")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York");
                put("state", "NY");
                put("country", "USA");
                put("population", 8530000);
              }
            });
    firestore
        .collection("cities")
        .document("TOR")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put("state", null);
                put("country", "Canada");
                put("population", 2930000);
              }
            });
    firestore
        .collection("cities")
        .document("MEX")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Mexico City");
                put("state", null);
                put("country", "Mexico");
                put("population", 9200000);
              }
            });
    // [END aggregate_data]
  }

  void aggregateWithoutGroupExample() throws ExecutionException, InterruptedException {
    // [START aggregate_without_group]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .aggregate(countAll().as("total"), average("population").as("averagePopulation"))
            .execute()
            .get();
    // [END aggregate_without_group]
    System.out.println(cities.getResults());
  }

  void aggregateGroupExample() throws ExecutionException, InterruptedException {
    // [START aggregate_group_example]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .aggregate(
                Aggregate.withAccumulators(
                        countAll().as("numberOfCities"), maximum("population").as("maxPopulation"))
                    .withGroups("country", "state"))
            .execute()
            .get();
    // [END aggregate_group_example]
    System.out.println(cities.getResults());
  }

  void aggregateGroupComplexExample() throws ExecutionException, InterruptedException {
    // [START aggregate_group_complex]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .aggregate(
                Aggregate.withAccumulators(sum("population").as("totalPopulation"))
                    .withGroups(field("state").equal(null).as("stateIsNull")))
            .execute()
            .get();
    // [END aggregate_group_complex]
    System.out.println(cities.getResults());
  }

  // https://cloud.google.com/firestore/docs/pipeline/stages/transformation/distinct
  void distinctSyntaxExample() throws ExecutionException, InterruptedException {
    // [START distinct_syntax]
    Pipeline.Snapshot cities1 =
        firestore.pipeline().collection("cities").distinct("country").execute().get();

    Pipeline.Snapshot cities2 =
        firestore
            .pipeline()
            .collection("cities")
            .distinct(toLower(field("state")).as("normalizedState"), field("country"))
            .execute()
            .get();
    // [END distinct_syntax]
    System.out.println(cities1.getResults());
    System.out.println(cities2.getResults());
  }

  void distinctExampleData() {
    // [START distinct_data]
    firestore
        .collection("cities")
        .document("SF")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "San Francisco");
                put("state", "CA");
                put("country", "USA");
              }
            });
    firestore
        .collection("cities")
        .document("LA")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Los Angeles");
                put("state", "CA");
                put("country", "USA");
              }
            });
    firestore
        .collection("cities")
        .document("NY")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "New York");
                put("state", "NY");
                put("country", "USA");
              }
            });
    firestore
        .collection("cities")
        .document("TOR")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Toronto");
                put("state", null);
                put("country", "Canada");
              }
            });
    firestore
        .collection("cities")
        .document("MEX")
        .set(
            new HashMap<String, Object>() {
              {
                put("name", "Mexico City");
                put("state", null);
                put("country", "Mexico");
              }
            });
    // [END distinct_data]
  }

  void distinctExample() throws ExecutionException, InterruptedException {
    // [START distinct_example]
    Pipeline.Snapshot cities =
        firestore.pipeline().collection("cities").distinct("country").execute().get();
    // [END distinct_example]
    System.out.println(cities.getResults());
  }

  void distinctExpressionsExample() throws ExecutionException, InterruptedException {
    // [START distinct_expressions]
    Pipeline.Snapshot cities =
        firestore
            .pipeline()
            .collection("cities")
            .distinct(toLower(field("state")).as("normalizedState"), field("country"))
            .execute()
            .get();
    // [END distinct_expressions]
    System.out.println(cities.getResults());
  }
}
