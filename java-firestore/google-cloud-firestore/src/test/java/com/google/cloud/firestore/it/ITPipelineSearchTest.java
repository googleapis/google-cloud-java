/*
 * Copyright 2026 Google LLC
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
import static com.google.cloud.firestore.pipeline.expressions.Expression.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.GeoPoint;
import com.google.cloud.firestore.Pipeline;
import com.google.cloud.firestore.PipelineResult;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.pipeline.stages.Search;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITPipelineSearchTest extends ITBaseTest {

  private static final String COLLECTION_NAME = "TextSearchIntegrationTests";

  private static final Map<String, Map<String, Object>> restaurantDocs = new HashMap<>();

  static {
    restaurantDocs.put(
        "sunnySideUp",
        map(
            "name",
            "The Sunny Side Up",
            "description",
            "A cozy neighborhood diner serving classic breakfast favorites all day long, from"
                + " fluffy pancakes to savory omelets.",
            "location",
            new GeoPoint(39.7541, -105.0002),
            "menu",
            "<h3>Breakfast Classics</h3><ul><li>Denver Omelet - $12</li><li>Buttermilk Pancakes"
                + " - $10</li><li>Steak and Eggs - $16</li></ul><h3>Sides</h3><ul><li>Hash"
                + " Browns - $4</li><li>Thick-cut Bacon - $5</li><li>Drip Coffee -"
                + " $2</li></ul>",
            "average_price_per_person",
            15));
    restaurantDocs.put(
        "goldenWaffle",
        map(
            "name",
            "The Golden Waffle",
            "description",
            "Specializing exclusively in Belgian-style waffles. Open daily from 6:00 AM to"
                + " 11:00 AM.",
            "location",
            new GeoPoint(39.7183, -104.9621),
            "menu",
            "<h3>Signature Waffles</h3><ul><li>Strawberry Delight - $11</li><li>Chicken and"
                + " Waffles - $14</li><li>Chocolate Chip Crunch -"
                + " $10</li></ul><h3>Drinks</h3><ul><li>Fresh OJ - $4</li><li>Artisan Coffee -"
                + " $3</li></ul>",
            "average_price_per_person",
            13));
    restaurantDocs.put(
        "lotusBlossomThai",
        map(
            "name",
            "Lotus Blossom Thai",
            "description",
            "Authentic Thai cuisine featuring hand-crushed spices and traditional family"
                + " recipes from the Chiang Mai region.",
            "location",
            new GeoPoint(39.7315, -104.9847),
            "menu",
            "<h3>Appetizers</h3><ul><li>Spring Rolls - $7</li><li>Chicken Satay -"
                + " $9</li></ul><h3>Main Course</h3><ul><li>Pad Thai - $15</li><li>Green Curry"
                + " - $16</li><li>Drunken Noodles - $15</li></ul>",
            "average_price_per_person",
            22));
    restaurantDocs.put(
        "mileHighCatch",
        map(
            "name",
            "Mile High Catch",
            "description",
            "Freshly sourced seafood offering a wide variety of Pacific fish and Atlantic"
                + " shellfish in an upscale atmosphere.",
            "location",
            new GeoPoint(39.7401, -104.9903),
            "menu",
            "<h3>From the Raw Bar</h3><ul><li>Oysters (Half Dozen) - $18</li><li>Lobster"
                + " Cocktail - $22</li></ul><h3>Entrees</h3><ul><li>Pan-Seared Salmon -"
                + " $28</li><li>King Crab Legs - $45</li><li>Fish and Chips - $19</li></ul>",
            "average_price_per_person",
            45));
    restaurantDocs.put(
        "peakBurgers",
        map(
            "name",
            "Peak Burgers",
            "description",
            "Casual burger joint focused on locally sourced Colorado beef and hand-cut fries.",
            "location",
            new GeoPoint(39.7622, -105.0125),
            "menu",
            "<h3>Burgers</h3><ul><li>The Peak Double - $12</li><li>Bison Burger -"
                + " $15</li><li>Veggie Stack - $11</li></ul><h3>Sides</h3><ul><li>Truffle Fries"
                + " - $6</li><li>Onion Rings - $5</li></ul>",
            "average_price_per_person",
            18));
    restaurantDocs.put(
        "solTacos",
        map(
            "name",
            "El Sol Tacos",
            "description",
            "A vibrant street-side taco stand serving up quick, delicious, and traditional"
                + " Mexican street food.",
            "location",
            new GeoPoint(39.6952, -105.0274),
            "menu",
            "<h3>Tacos ($3.50 each)</h3><ul><li>Al Pastor</li><li>Carne Asada</li><li>Pollo"
                + " Asado</li><li>Nopales (Cactus)</li></ul><h3>Beverages</h3><ul><li>Horchata"
                + " - $4</li><li>Mexican Coke - $3</li></ul>",
            "average_price_per_person",
            12));
    restaurantDocs.put(
        "eastsideTacos",
        map(
            "name",
            "Eastside Cantina",
            "description",
            "Authentic street tacos and hand-shaken margaritas on the vibrant east side of the"
                + " city.",
            "location",
            new GeoPoint(39.735, -104.885),
            "menu",
            "<h3>Tacos</h3><ul><li>Carnitas Tacos - $4</li><li>Barbacoa Tacos -"
                + " $4.50</li><li>Shrimp Tacos - $5</li></ul><h3>Drinks</h3><ul><li>House"
                + " Margarita - $9</li><li>Jarritos - $3</li></ul>",
            "average_price_per_person",
            18));
    restaurantDocs.put(
        "eastsideChicken",
        map(
            "name",
            "Eastside Chicken",
            "description",
            "Fried chicken to go - next to Eastside Cantina.",
            "location",
            new GeoPoint(39.735, -104.885),
            "menu",
            "<h3>Fried Chicken</h3><ul><li>Drumstick - $4</li><li>Wings - $1</li><li>Sandwich -"
                + " $9</li></ul><h3>Drinks</h3><ul><li>House Margarita - $9</li><li>Jarritos -"
                + " $3</li></ul>",
            "average_price_per_person",
            12));
  }

  @Override
  public void primeBackend() throws Exception {
    // Disable priming as it uses Watch/Listen
  }

  @BeforeClass
  public static void setupRestaurantDocs() throws Exception {
    assumeTrue(
        "This test suite only runs against the Enterprise edition in Nightly.",
        getFirestoreEdition().equals(FirestoreEdition.ENTERPRISE)
            && "NIGHTLY".equalsIgnoreCase(getTargetBackend()));

    // Initialize a temporary Firestore instance for class-level setup.
    Firestore db = getOptionsBuilder().build().getService();

    // Setup restaurant docs
    try {
      // Get the existing contents of the test collection
      CollectionReference collection = db.collection(COLLECTION_NAME);
      QuerySnapshot snapshot = collection.get().get();

      // A batch will be used to update the test collection to the desired state
      WriteBatch batch = db.batch();

      // Delete unexpected documents
      for (DocumentSnapshot doc : snapshot.getDocuments()) {
        if (!restaurantDocs.containsKey(doc.getId())) {
          batch.delete(doc.getReference());
        }
      }

      // Add/overwrite expected documents
      for (Map.Entry<String, Map<String, Object>> entry : restaurantDocs.entrySet()) {
        batch.set(collection.document(entry.getKey()), entry.getValue());
      }

      batch.commit().get(10, TimeUnit.SECONDS);
    } finally {
      db.close();
    }
  }

  private void assertResultIds(Pipeline.Snapshot snapshot, String... ids) {
    List<String> resultIds =
        snapshot.getResults().stream()
            .map(PipelineResult::getId)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    assertThat(resultIds).containsExactlyElementsIn(Arrays.asList(ids)).inOrder();
  }

  // =========================================================================
  // Search stage
  // =========================================================================

  // --- DISABLE query expansion ---

  // query
  @Test
  public void searchWithLanguageCode() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(Search.withQuery("waffles").withLanguageCode("en"));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "goldenWaffle");
  }

  @Test
  public void searchWithInvalidLanguageCode() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(Search.withQuery("waffles").withLanguageCode("unknown"));

    Assert.assertThrows(ExecutionException.class, () -> pipeline.execute().get());
  }

  @Test
  public void searchFullDocument() throws Exception {
    Pipeline pipeline =
        firestore.pipeline().collection(COLLECTION_NAME).search(Search.withQuery("waffles"));
    //
    // Search.withQuery("waffles").withQueryEnhancement(Search.QueryEnhancement.DISABLED));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "goldenWaffle");
  }

  // @Test
  // public void searchSpecificField() throws Exception {
  //   Pipeline pipeline =
  //       firestore
  //           .pipeline()
  //           .collection(COLLECTION_NAME)
  //           .search(
  //               Search.withQuery(field("menu").matches("waffles"))
  //                   .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //   Pipeline.Snapshot snapshot = pipeline.execute().get();
  //   assertResultIds(snapshot, "goldenWaffle");
  // }

  @Test
  public void geoNearQuery() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(
                Search.withQuery(
                    field("location")
                        .geoDistance(new GeoPoint(39.6985, -105.024))
                        .lessThanOrEqual(1000)));
    //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "solTacos");
  }

  //  TODO(search) enable with backend support
  //  @Test
  //  public void conjunctionOfTextSearchPredicates() throws Exception {
  //    Pipeline pipeline =
  //        firestore
  //            .pipeline()
  //            .collection(COLLECTION_NAME)
  //            .search(
  //                Search.withQuery(
  //                        and(field("menu").matches("waffles"),
  //                            field("description").matches("diner")))
  //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //    Pipeline.Snapshot snapshot = pipeline.execute().get();
  //    assertResultIds(snapshot, "goldenWaffle", "sunnySideUp");
  //  }

  // TODO(search) enable test when geo+text search indexes are supported
  // @Test
  // public void conjunctionOfTextSearchAndGeoNear() throws Exception {
  //   Pipeline pipeline =
  //       firestore
  //           .pipeline()
  //           .collection(COLLECTION_NAME)
  //           .search(
  //               Search.withQuery(
  //                       and(
  //                           field("menu").matches("tacos"),
  //                           field("location")
  //                               .geoDistance(new GeoPoint(39.6985, -105.024))
  //                               .lessThan(10000)))
  //                   .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //   Pipeline.Snapshot snapshot = pipeline.execute().get();
  //   assertResultIds(snapshot, "solTacos");
  // }

  @Test
  public void negateMatch() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(Search.withQuery(documentMatches("coffee -waffles")));
    //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "sunnySideUp");
  }

  //  TODO(search) enable with backend support
  //  @Test
  //  public void rquerySearchTheDocumentWithConjunctionAndDisjunction() throws Exception {
  //    Pipeline pipeline =
  //        firestore
  //            .pipeline()
  //            .collection(COLLECTION_NAME)
  //            .search(
  //                Search.withQuery(documentMatches("(waffles OR pancakes) AND coffee"))
  //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //    Pipeline.Snapshot snapshot = pipeline.execute().get();
  //    assertResultIds(snapshot, "goldenWaffle", "sunnySideUp");
  //  }

  @Test
  public void rqueryAsQueryParam() throws Exception {
    Pipeline pipeline =
        firestore.pipeline().collection(COLLECTION_NAME).search(Search.withQuery("chicken wings"));
    //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "eastsideChicken");
  }

  // TODO(search) enable when rquery supports field paths
  // @Test
  // public void rquerySupportsFieldPaths() throws Exception {
  //  Pipeline pipeline =
  //      firestore
  //          .pipeline()
  //          .collection(COLLECTION_NAME)
  //          .search(
  //              Search.withQuery("menu:(waffles OR pancakes) AND description:\"breakfast all
  // day\"")
  //                  .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //  Pipeline.Snapshot snapshot = pipeline.execute().get();
  //  assertResultIds(snapshot, "sunnySideUp");
  // }

  //  TODO(search) enable with backend support
  //  @Test
  //  public void conjunctionOfRqueryAndExpression() throws Exception {
  //    Pipeline pipeline =
  //        firestore
  //            .pipeline()
  //            .collection(COLLECTION_NAME)
  //            .search(
  //                Search.withQuery(
  //                        and(
  //                            documentMatches("tacos"),
  //                            greaterThanOrEqual("average_price_per_person", 8),
  //                            lessThanOrEqual("average_price_per_person", 15)))
  //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //    Pipeline.Snapshot snapshot = pipeline.execute().get();
  //    assertResultIds(snapshot, "solTacos");
  //  }

  // --- REQUIRE query expansion ---

  //  TODO(search) enable with backend support
  //  @Test
  //  public void requireQueryExpansion_searchFullDocument() throws Exception {
  //    Pipeline pipeline =
  //        firestore
  //            .pipeline()
  //            .collection(COLLECTION_NAME)
  //            .search(
  //                Search.withQuery(documentMatches("waffles"))
  //                    .withQueryEnhancement(Search.QueryEnhancement.REQUIRED));
  //
  //    Pipeline.Snapshot snapshot = pipeline.execute().get();
  //    assertResultIds(snapshot, "goldenWaffle", "sunnySideUp");
  //  }

  // TODO(search) re-enable when backend supports field matches and QueryEnhancement
  // @Test
  // public void requireQueryExpansion_searchSpecificField() throws Exception {
  //   Pipeline pipeline =
  //       firestore
  //           .pipeline()
  //           .collection(COLLECTION_NAME)
  //           .search(
  //               Search.withQuery(field("menu").matches("waffles"))
  //                   .withQueryEnhancement(Search.QueryEnhancement.REQUIRED));
  //
  //   Pipeline.Snapshot snapshot = pipeline.execute().get();
  //   assertResultIds(snapshot, "goldenWaffle", "sunnySideUp");
  // }

  // add fields
  @Test
  public void addFields_score() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(
                Search.withQuery(documentMatches("waffles"))
                    .withAddFields(score().as("searchScore")))
            //
            // .withQueryEnhancement(Search.QueryEnhancement.DISABLED))
            .select("name", "searchScore");

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertThat(snapshot.getResults()).hasSize(1);
    PipelineResult result = snapshot.getResults().get(0);
    assertThat(result.getData().get("name")).isEqualTo("The Golden Waffle");
    assertThat((Double) result.getData().get("searchScore")).isGreaterThan(0.0);
  }

  //    @Test
  //    public void addFields_geoDistance() throws Exception {
  //        Pipeline pipeline =
  //                firestore
  //                        .pipeline()
  //                        .collection(COLLECTION_NAME)
  //                        .search(
  //                                Search.withQuery(documentMatches("waffles"))
  //                                        .withAddFields(
  //                                                field("location").geoDistance(new
  // GeoPoint(39.6985, -105.024)).as("geoDistance")))
  ////                                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED))
  //                        .select("name", "geoDistance");
  //
  //        Pipeline.Snapshot snapshot = pipeline.execute().get();
  //        assertThat(snapshot.getResults()).hasSize(1);
  //        PipelineResult result = snapshot.getResults().get(0);
  //        assertThat(result.getData().get("name")).isEqualTo("The Golden Waffle");
  //        assertThat((Double) result.getData().get("geoDistance")).isGreaterThan(0.0);
  //    }

  // TODO(search) enable with backend support
  //  @Test
  //  public void addFields_multipleFields() throws Exception {
  //    Pipeline pipeline =
  //            firestore
  //                    .pipeline()
  //                    .collection(COLLECTION_NAME)
  //                    .search(
  //                            Search.withQuery(documentMatches("waffles"))
  //                                    .withAddFields(
  //                                            score().as("searchScore"), snippet("menu",
  // "waffles").as("snippet"))
  //                                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED))
  //                    .select("name", "searchScore", "snippet");
  //
  //    Pipeline.Snapshot snapshot = pipeline.execute().get();
  //    assertThat(snapshot.getResults()).hasSize(1);
  //    PipelineResult result = snapshot.getResults().get(0);
  //    assertThat(result.getData().get("name")).isEqualTo("The Golden Waffle");
  //    assertThat((Double) result.getData().get("searchScore")).isGreaterThan(0.0);
  //    assertThat(((String) result.getData().get("snippet")).length()).isGreaterThan(0);
  //  }

  // select
  // TODO(search) enable with backend support
  //  @Test
  //  public void select_topicalityScoreAndSnippet() throws Exception {
  //    Pipeline pipeline =
  //        firestore
  //            .pipeline()
  //            .collection(COLLECTION_NAME)
  //            .search(
  //                Search.withQuery(documentMatches("waffles"))
  //                    .withSelect(
  //                        field("name"),
  //                        field("location"),
  //                        score().as("searchScore"),
  //                        snippet("menu", "waffles").as("snippet"))
  //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //    Pipeline.Snapshot snapshot = pipeline.execute().get();
  //    assertThat(snapshot.getResults()).hasSize(1);
  //    PipelineResult result = snapshot.getResults().get(0);
  //    assertThat(result.getData().get("name")).isEqualTo("The Golden Waffle");
  //    assertThat(result.getData().get("location")).isEqualTo(new GeoPoint(39.7183, -104.9621));
  //    assertThat((Double) result.getData().get("searchScore")).isGreaterThan(0.0);
  //    assertThat(((String) result.getData().get("snippet")).length()).isGreaterThan(0);
  //
  //    List<String> sortedKeys =
  //        result.getData().keySet().stream().sorted().collect(Collectors.toList());
  //    assertThat(sortedKeys).containsExactly("location", "name", "searchScore",
  // "snippet").inOrder();
  //  }

  // sort
  @Test
  public void sort_byScore() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(Search.withQuery(documentMatches("tacos")).withSort(score().descending()));
    //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "eastsideTacos", "solTacos");
  }

  @Test
  public void sort_byDistance() throws Exception {
    GeoPoint queryLocation = new GeoPoint(39.6985, -105.024);
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(
                Search.withQuery(field("location").geoDistance(queryLocation).lessThanOrEqual(5600))
                    .withSort(geoDistance("location", queryLocation).ascending()));
    //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "solTacos", "lotusBlossomThai", "mileHighCatch");
  }

  // TODO(search) re-enable when geo+text search indexes are supported
  // @Test
  // public void sort_byMultipleOrderings() throws Exception {
  //   Pipeline pipeline =
  //       firestore
  //           .pipeline()
  //           .collection(COLLECTION_NAME)
  //           .search(
  //               Search.withQuery(field("menu").matches("tacos OR chicken"))
  //                   .withSort(
  //                       field("location").geoDistance(new GeoPoint(39.6985,
  // -105.024)).ascending(),
  //                       score().descending())
  //                   .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //   Pipeline.Snapshot snapshot = pipeline.execute().get();
  //   assertResultIds(snapshot, "solTacos", "eastsideTacos", "eastsideChicken");
  // }

  // limit
  @Test
  public void limit_limitsTheNumberOfDocumentsReturned() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(
                Search.withQuery(
                        field("location")
                            .geoDistance(new GeoPoint(39.6985, -105.024))
                            .lessThanOrEqual(100000000))
                    .withSort(geoDistance("location", new GeoPoint(39.6985, -105.024)).ascending())
                    .withLimit(3));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "solTacos", "lotusBlossomThai", "mileHighCatch");
  }

  @Test
  public void limit_limitsTheNumberOfDocumentsScoredViaRetrievalDepth() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(
                Search.withQuery(documentMatches("taco"))
                    .withAddFields(score().as("score"))
                    .withSort(score().descending())
                    .withRetrievalDepth(2));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "solTacos", "eastsideTacos");

    pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(
                Search.withQuery(documentMatches("taco"))
                    .withAddFields(score().as("score"))
                    .withSort(score().descending())
                    .withRetrievalDepth(1));

    snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "eastsideTacos");
  }

  @Test
  public void offset_skipsNDocuments() throws Exception {
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection(COLLECTION_NAME)
            .search(Search.withQuery("chicken").withLimit(2).withOffset(2));

    Pipeline.Snapshot snapshot = pipeline.execute().get();
    assertResultIds(snapshot, "goldenWaffle");
  }

  // =========================================================================
  // Snippet
  // =========================================================================

  // TODO(search) enable with backend support
  //  @Test
  //  public void snippetOnMultipleFields() throws Exception {
  //    // Get snippet from 1 field
  //    Pipeline pipeline1 =
  //        firestore
  //            .pipeline()
  //            .collection(COLLECTION_NAME)
  //            .search(
  //                Search.withQuery(documentMatches("waffle"))
  //                    .withAddFields(snippet("menu", "waffles").as("snippet"))
  //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //    Pipeline.Snapshot snapshot1 = pipeline1.execute().get();
  //    assertThat(snapshot1.getResults()).hasSize(1);
  //    assertThat(snapshot1.getResults().get(0).getData().get("name")).isEqualTo("The Golden
  // Waffle");
  //    String snip1 = (String) snapshot1.getResults().get(0).getData().get("snippet");
  //    assertThat(snip1.length()).isGreaterThan(0);
  //
  //    // Get snippet from 2 fields
  //    Pipeline pipeline2 =
  //        firestore
  //            .pipeline()
  //            .collection(COLLECTION_NAME)
  //            .search(
  //                Search.withQuery(documentMatches("waffle"))
  //                    .withAddFields(
  //                        concat(field("menu"), field("description"))
  //                            .snippet("waffles") // Without SnippetOptions in Java
  //                            .as("snippet"))
  //                    .withQueryEnhancement(Search.QueryEnhancement.DISABLED));
  //
  //    Pipeline.Snapshot snapshot2 = pipeline2.execute().get();
  //    assertThat(snapshot2.getResults()).hasSize(1);
  //    assertThat(snapshot2.getResults().get(0).getData().get("name")).isEqualTo("The Golden
  // Waffle");
  //    String snip2 = (String) snapshot2.getResults().get(0).getData().get("snippet");
  //    assertThat(snip2.length()).isGreaterThan(snip1.length());
  //  }
}
