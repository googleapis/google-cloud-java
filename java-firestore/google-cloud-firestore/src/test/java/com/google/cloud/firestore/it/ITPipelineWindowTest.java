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

import static com.google.cloud.firestore.pipeline.expressions.Expression.constant;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.cloud.firestore.pipeline.expressions.Expression.multiply;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.PipelineResult;
import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.cloud.firestore.pipeline.expressions.Ordering;
import com.google.cloud.firestore.pipeline.expressions.WindowBound;
import com.google.cloud.firestore.pipeline.expressions.WindowFunction;
import com.google.cloud.firestore.pipeline.expressions.WindowSpec;
import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITPipelineWindowTest extends ITBaseTest {

  @Before
  @Override
  public void before() throws Exception {
    assumeTrue(
        "This test suite only runs against the Enterprise edition.",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    super.before();
  }

  @After
  @Override
  public void after() throws Exception {
    if (firestore != null) {
      super.after();
    }
  }

  private CollectionReference testCollectionWithDocs(Map<String, Map<String, Object>> docs)
      throws ExecutionException, InterruptedException, TimeoutException {
    CollectionReference collection = firestore.collection(LocalFirestoreHelper.autoId());
    for (Map.Entry<String, Map<String, Object>> doc : docs.entrySet()) {
      collection.document(doc.getKey()).set(doc.getValue()).get(5, TimeUnit.SECONDS);
    }
    return collection;
  }

  private static <K, V> Map.Entry<K, V> entry(K key, V value) {
    return new AbstractMap.SimpleImmutableEntry<>(key, value);
  }

  @SafeVarargs
  private static <K, V> Map<K, V> mapOfEntries(Map.Entry<K, V>... entries) {
    Map<K, V> res = new HashMap<>();
    for (Map.Entry<K, V> entry : entries) {
      res.put(entry.getKey(), entry.getValue());
    }
    return Collections.unmodifiableMap(res);
  }

  private static Ordering ascending(String fieldName) {
    return field(fieldName).ascending();
  }

  private static Ordering descending(String fieldName) {
    return field(fieldName).descending();
  }

  // -----------------------------------------------------------------------------------------
  // addWindowFields
  // -----------------------------------------------------------------------------------------

  /**
   * Shared fixture for the window tests.
   *
   * <p>The sales are deliberately constructed so that:
   *
   * <ul>
   *   <li>{@code product} and {@code region} give overlapping, non-nested partitions,
   *   <li>{@code salesPrice} has ties (30 and 60 both appear twice), which exercises {@code range}
   *       framing and ranking peers, and
   *   <li>{@code date} is strictly increasing and has an 11 day gap before the final sale, which
   *       exercises time based {@code range} framing.
   * </ul>
   *
   * <p>Sorted by {@code date} the document order is always sale1, sale2, sale3, sale4, sale5.
   */
  private static Map<String, Map<String, Object>> windowTestDocs() {
    return mapOfEntries(
        // 2026-07-01T12:00:00Z
        entry(
            "sale1",
            mapOfEntries(
                entry("product", "phone"),
                entry("region", "east"),
                entry("salesPrice", 12),
                entry("quantity", 1),
                entry("date", Timestamp.ofTimeSecondsAndNanos(1782907200L, 0)))),
        // 2026-07-02T12:00:00Z
        entry(
            "sale2",
            mapOfEntries(
                entry("product", "phone"),
                entry("region", "west"),
                entry("salesPrice", 30),
                entry("quantity", 2),
                entry("date", Timestamp.ofTimeSecondsAndNanos(1782993600L, 0)))),
        // 2026-07-02T18:00:00Z
        entry(
            "sale3",
            mapOfEntries(
                entry("product", "tablet"),
                entry("region", "east"),
                entry("salesPrice", 30),
                entry("quantity", 3),
                entry("date", Timestamp.ofTimeSecondsAndNanos(1783015200L, 0)))),
        // 2026-07-04T12:00:00Z
        entry(
            "sale4",
            mapOfEntries(
                entry("product", "tablet"),
                entry("region", "west"),
                entry("salesPrice", 60),
                entry("quantity", 4),
                entry("date", Timestamp.ofTimeSecondsAndNanos(1783166400L, 0)))),
        // 2026-07-15T12:00:00Z
        entry(
            "sale5",
            mapOfEntries(
                entry("product", "tablet"),
                entry("region", "east"),
                entry("salesPrice", 60),
                entry("quantity", 5),
                entry("date", Timestamp.ofTimeSecondsAndNanos(1784116800L, 0)))));
  }

  private CollectionReference windowTestCollection()
      throws ExecutionException, InterruptedException, TimeoutException {
    return testCollectionWithDocs(windowTestDocs());
  }

  /**
   * Asserts that {@code results} contains exactly {@code expected}, in order, comparing whole
   * documents.
   */
  private static void expectResults(
      List<PipelineResult> results, List<Map<String, Object>> expected) {
    assertThat(results).hasSize(expected.size());
    for (int i = 0; i < expected.size(); i++) {
      assertThat(results.get(i).getData()).isEqualTo(expected.get(i));
    }
  }

  static boolean runComprehensiveTests() {
    String propertyName = "FIRESTORE_RUN_COMPREHENSIVE_TESTS";
    String runComprehensive = System.getProperty(propertyName);
    if (runComprehensive == null) {
      runComprehensive = System.getenv(propertyName);
    }
    return "YES".equalsIgnoreCase(runComprehensive) || "true".equalsIgnoreCase(runComprehensive);
  }

  private static void assumeComprehensiveTestsEnabled() {
    assumeTrue(
        "Set FIRESTORE_RUN_COMPREHENSIVE_TESTS=true to run comprehensive window function tests.",
        runComprehensiveTests());
  }

  // -----------------------------------------------------------------------------------------
  // Default window function suite
  // -----------------------------------------------------------------------------------------

  @Test
  public void
      testWindowFieldsComputesRunningAggregatesOverADocumentsFramePartitionedByAFieldAndAnExpressionAndSortedByMultipleKeys()
          throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .partition("product", Expression.toUpper("region"))
                    .sort(ascending("date"), descending("salesPrice"))
                    .documents(WindowBound.UNBOUNDED, constant(0)),
                AggregateFunction.sum("salesPrice").as("stats.runningTotal"),
                AggregateFunction.arrayAgg("quantity").as("quantities"),
                AggregateFunction.countAll().as("count"))
            .sort(ascending("date"))
            .select("product", "stats", "quantities", "count")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"),
                entry("stats", mapOfEntries(entry("runningTotal", 12L))),
                entry("quantities", Arrays.asList(1L)),
                entry("count", 1L)),
            mapOfEntries(
                entry("product", "phone"),
                entry("stats", mapOfEntries(entry("runningTotal", 30L))),
                entry("quantities", Arrays.asList(2L)),
                entry("count", 1L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("stats", mapOfEntries(entry("runningTotal", 30L))),
                entry("quantities", Arrays.asList(3L)),
                entry("count", 1L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("stats", mapOfEntries(entry("runningTotal", 60L))),
                entry("quantities", Arrays.asList(4L)),
                entry("count", 1L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("stats", mapOfEntries(entry("runningTotal", 90L))),
                entry("quantities", Arrays.asList(3L, 5L)),
                entry("count", 2L))));
  }

  @Test
  public void testWindowFieldsCountsDocumentsInATimeUnitRangeFrame() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection().getPath())
            .addWindowFields(
                new WindowSpec().sort(ascending("date")).range(12, WindowBound.CURRENT, "hour"),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L))));
  }

  @Test
  public void testWindowFieldsComputesLookAheadAndNearbyAggregatesWithAccumulatorLevelFrames()
      throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().sort(ascending("quantity")),
                AggregateFunction.average("salesPrice")
                    .over(new WindowSpec().documents(-1, 2))
                    .as("lookAheadAverage"),
                AggregateFunction.sum("salesPrice")
                    .over(new WindowSpec().range(1.5, 0.5))
                    .as("nearbyTotal"))
            .sort(ascending("date"))
            .select("product", "lookAheadAverage", "nearbyTotal")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"),
                entry("lookAheadAverage", 30.0),
                entry("nearbyTotal", 12L)),
            mapOfEntries(
                entry("product", "phone"),
                entry("lookAheadAverage", 45.0),
                entry("nearbyTotal", 42L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("lookAheadAverage", 60.0),
                entry("nearbyTotal", 60L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("lookAheadAverage", 60.0),
                entry("nearbyTotal", 90L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("lookAheadAverage", null),
                entry("nearbyTotal", 120L))));
  }

  @Test
  public void testWindowFieldsComputesRank() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().sort(ascending("salesPrice")),
                WindowFunction.rank().as("priceRank"))
            .sort(ascending("date"))
            .select("salesPrice", "priceRank")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("salesPrice", 12L), entry("priceRank", 1L)),
            mapOfEntries(entry("salesPrice", 30L), entry("priceRank", 2L)),
            mapOfEntries(entry("salesPrice", 30L), entry("priceRank", 2L)),
            mapOfEntries(entry("salesPrice", 60L), entry("priceRank", 4L)),
            mapOfEntries(entry("salesPrice", 60L), entry("priceRank", 4L))));
  }

  @Test
  public void testWindowFieldsRejectsARangeFrameWithoutASort() throws Exception {
    CollectionReference salesCol = windowTestCollection();
    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () ->
                firestore
                    .pipeline()
                    .collection(salesCol)
                    .addWindowFields(
                        new WindowSpec().range(WindowBound.UNBOUNDED, WindowBound.CURRENT),
                        AggregateFunction.count("quantity").as("windowCount"))
                    .execute()
                    .get());
    assertThat(exception.getMessage().toLowerCase()).contains("range");
  }

  @Test
  public void testWindowFieldsRejectsDuplicateAliasesAndUnsupportedFieldValues() throws Exception {
    CollectionReference salesCol = firestore.collection("sales");
    IllegalArgumentException duplicateError =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                firestore
                    .pipeline()
                    .collection(salesCol)
                    .addWindowFields(
                        new WindowSpec().partition("product"),
                        AggregateFunction.sum("salesPrice").as("total"),
                        AggregateFunction.average("salesPrice").as("total")));
    assertThat(duplicateError).hasMessageThat().contains("Duplicate alias: 'total'");

    FirestoreException valueError =
        assertThrows(
            FirestoreException.class,
            () ->
                firestore
                    .pipeline()
                    .collection(salesCol)
                    .addWindowFields(
                        new WindowSpec().partition(constant(new BigDecimal("1.5"))),
                        AggregateFunction.countAll().as("windowCount"))
                    .execute());
    assertThat(valueError).hasMessageThat().contains("Cannot convert");
  }

  // -----------------------------------------------------------------------------------------
  // Comprehensive window function tests (count)
  //
  // Skipped by default on CI and local runs because the backend already tests window function
  // semantics, and the active suite above exercises the SDK's window function code paths, server
  // errors, and client-side validation. Set FIRESTORE_RUN_COMPREHENSIVE_TESTS=true to run the
  // full matrix.
  // -----------------------------------------------------------------------------------------

  // --- partitioning --------------------------------------------------------------------------

  @Test
  public void testWindowFieldsEmptySpecIsASingleGlobalWindow() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec(), AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 5L))));
  }

  @Test
  public void testWindowFieldsOmittedSpecIsASingleGlobalWindow() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 5L))));
  }

  @Test
  public void testWindowFieldsPartitionsBySingleFieldName() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L))));
  }

  @Test
  public void testWindowFieldsPartitionsByMultipleFields() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product", "region"),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "region", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("region", "east"), entry("windowCount", 1L)),
            mapOfEntries(
                entry("product", "phone"), entry("region", "west"), entry("windowCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("region", "east"), entry("windowCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"), entry("region", "west"), entry("windowCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("region", "east"), entry("windowCount", 2L))));
  }

  @Test
  public void testWindowFieldsPartitionsByExpression() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition(Expression.toUpper("region")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("region", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("region", "east"), entry("windowCount", 3L)),
            mapOfEntries(entry("region", "west"), entry("windowCount", 2L)),
            mapOfEntries(entry("region", "east"), entry("windowCount", 3L)),
            mapOfEntries(entry("region", "west"), entry("windowCount", 2L)),
            mapOfEntries(entry("region", "east"), entry("windowCount", 3L))));
  }

  // --- sorting and default framing -----------------------------------------------------------

  @Test
  public void testWindowFieldsRunningCountWithTheDefaultFrame() throws Exception {
    assumeComprehensiveTestsEnabled();
    // The implicit default frame when `sort` is specified is `range(UNBOUNDED, CURRENT)`.
    // `quantity` is 1..5 in the same order as `date`, and has no ties, so the running count is
    // unambiguous.
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().sort(ascending("quantity")),
                AggregateFunction.count("quantity").as("runningCount"))
            .sort(ascending("date"))
            .select("product", "runningCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("runningCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("runningCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 4L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 5L))));
  }

  @Test
  public void testWindowFieldsRunningCountWithinEachPartition() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product").sort(ascending("quantity")),
                AggregateFunction.count("quantity").as("runningCount"))
            .sort(ascending("date"))
            .select("product", "runningCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("runningCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("runningCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 3L))));
  }

  @Test
  public void testWindowFieldsHonorsADescendingSort() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .sort(descending("date"))
                    .documents(WindowBound.UNBOUNDED, WindowBound.CURRENT),
                AggregateFunction.count("quantity").as("runningCount"))
            .sort(ascending("date"))
            .select("product", "runningCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("runningCount", 5L)),
            mapOfEntries(entry("product", "phone"), entry("runningCount", 4L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 1L))));
  }

  @Test
  public void testWindowFieldsHonorsMultipleSortOrderings() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .sort(ascending("product"), ascending("date"))
                    .documents(WindowBound.UNBOUNDED, WindowBound.CURRENT),
                AggregateFunction.count("quantity").as("runningCount"))
            .sort(ascending("date"))
            .select("product", "runningCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("runningCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("runningCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 4L)),
            mapOfEntries(entry("product", "tablet"), entry("runningCount", 5L))));
  }

  // --- documents framing ---------------------------------------------------------------------

  @Test
  public void testWindowFieldsDocumentsUnboundedToCurrent() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.UNBOUNDED, WindowBound.CURRENT)
                    .sort(ascending("date")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 4L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 5L))));
  }

  @Test
  public void testWindowFieldsDocumentsUnboundedToUnbounded() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)
                    .partition("product")
                    .sort(ascending("date")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L))));
  }

  @Test
  public void testWindowFieldsDocumentsCurrentToCurrent() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.CURRENT, WindowBound.CURRENT)
                    .sort(ascending("date")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L))));
  }

  @Test
  public void testWindowFieldsDocumentsUnboundedToCurrentDoesNotIncludeTiedPeers()
      throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.UNBOUNDED, WindowBound.CURRENT)
                    .sort(ascending("salesPrice")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("windowCount"))
            .select("salesPrice", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("salesPrice", 12L), entry("windowCount", 1L)),
            mapOfEntries(entry("salesPrice", 30L), entry("windowCount", 2L)),
            mapOfEntries(entry("salesPrice", 30L), entry("windowCount", 3L)),
            mapOfEntries(entry("salesPrice", 60L), entry("windowCount", 4L)),
            mapOfEntries(entry("salesPrice", 60L), entry("windowCount", 5L))));
  }

  // --- range framing -------------------------------------------------------------------------
  //
  // In a `range` frame, both the symbolic `CURRENT` bound and a numeric `0` offset are
  // peer-inclusive (like SQL `CURRENT ROW` in `RANGE` mode): the frame includes all documents whose
  // sort value(s) tie with the current document. Symbolic `range` frames (bounds of only `CURRENT`
  // or `UNBOUNDED` without a time `unit`) also support multiple sort orderings and non-numeric sort
  // keys (such as strings or booleans).

  @Test
  public void testWindowFieldsRangeCurrentToCurrentCountsTiedPeers() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .range(WindowBound.CURRENT, WindowBound.CURRENT)
                    .partition("product")
                    .sort(ascending("salesPrice")),
                AggregateFunction.count("quantity").as("samePriceCount"))
            .sort(ascending("date"))
            .select("product", "salesPrice", "samePriceCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("salesPrice", 12L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "phone"), entry("salesPrice", 30L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("salesPrice", 30L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("salesPrice", 60L), entry("samePriceCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("salesPrice", 60L),
                entry("samePriceCount", 2L))));
  }

  @Test
  public void testWindowFieldsRangeZeroOffsetCountsTiedPeers() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().range(0, 0).partition("product").sort(ascending("salesPrice")),
                AggregateFunction.count("quantity").as("samePriceCount"))
            .sort(ascending("date"))
            .select("product", "salesPrice", "samePriceCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("salesPrice", 12L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "phone"), entry("salesPrice", 30L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("salesPrice", 30L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("salesPrice", 60L), entry("samePriceCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("salesPrice", 60L),
                entry("samePriceCount", 2L))));
  }

  @Test
  public void testWindowFieldsRangeUnboundedToCurrentIncludesTiedPeers() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .range(WindowBound.UNBOUNDED, WindowBound.CURRENT)
                    .sort(ascending("salesPrice")),
                AggregateFunction.count("quantity").as("cumulativeCount"))
            .sort(ascending("date"))
            .select("salesPrice", "cumulativeCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("salesPrice", 12L), entry("cumulativeCount", 1L)),
            mapOfEntries(entry("salesPrice", 30L), entry("cumulativeCount", 3L)),
            mapOfEntries(entry("salesPrice", 30L), entry("cumulativeCount", 3L)),
            mapOfEntries(entry("salesPrice", 60L), entry("cumulativeCount", 5L)),
            mapOfEntries(entry("salesPrice", 60L), entry("cumulativeCount", 5L))));
  }

  @Test
  public void testWindowFieldsRangeUnboundedToZeroOffsetIncludesTiedPeers() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().range(WindowBound.UNBOUNDED, 0).sort(ascending("salesPrice")),
                AggregateFunction.count("quantity").as("cumulativeCount"))
            .sort(ascending("date"))
            .select("salesPrice", "cumulativeCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("salesPrice", 12L), entry("cumulativeCount", 1L)),
            mapOfEntries(entry("salesPrice", 30L), entry("cumulativeCount", 3L)),
            mapOfEntries(entry("salesPrice", 30L), entry("cumulativeCount", 3L)),
            mapOfEntries(entry("salesPrice", 60L), entry("cumulativeCount", 5L)),
            mapOfEntries(entry("salesPrice", 60L), entry("cumulativeCount", 5L))));
  }

  @Test
  public void testWindowFieldsRangeUnboundedToCurrentWithStringSortKey() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .range(WindowBound.UNBOUNDED, WindowBound.CURRENT)
                    .sort(ascending("product")),
                AggregateFunction.count("quantity").as("cumulativeCount"))
            .sort(ascending("date"))
            .select("product", "cumulativeCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("cumulativeCount", 2L)),
            mapOfEntries(entry("product", "phone"), entry("cumulativeCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("cumulativeCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("cumulativeCount", 5L)),
            mapOfEntries(entry("product", "tablet"), entry("cumulativeCount", 5L))));
  }

  @Test
  public void testWindowFieldsRangeUnboundedToCurrentWithMultipleSortOrderings() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .range(WindowBound.UNBOUNDED, WindowBound.CURRENT)
                    .sort(ascending("product"), ascending("region")),
                AggregateFunction.count("quantity").as("cumulativeCount"))
            .sort(ascending("date"))
            .select("product", "region", "cumulativeCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("region", "east"), entry("cumulativeCount", 1L)),
            mapOfEntries(
                entry("product", "phone"), entry("region", "west"), entry("cumulativeCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"), entry("region", "east"), entry("cumulativeCount", 4L)),
            mapOfEntries(
                entry("product", "tablet"), entry("region", "west"), entry("cumulativeCount", 5L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("region", "east"),
                entry("cumulativeCount", 4L))));
  }

  @Test
  public void testWindowFieldsRangeUnboundedToUnbounded() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .range(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)
                    .partition("product")
                    .sort(ascending("salesPrice")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L))));
  }

  @Test
  public void testWindowFieldsAppliesTheTimeUnitToARangeFrameOffset() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().sort(ascending("date")).range(12, WindowBound.CURRENT, "hour"),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L))));
  }

  // --- accumulator level framing ---------------------------------------------------------------

  @Test
  public void testWindowFieldsEvaluatesEachAccumulatorOverItsOwnFrame() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product").sort(ascending("date")),
                AggregateFunction.count("quantity")
                    .over(new WindowSpec().documents(WindowBound.UNBOUNDED, WindowBound.CURRENT))
                    .as("runningCount"),
                AggregateFunction.count("quantity")
                    .over(new WindowSpec().documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED))
                    .as("partitionCount"))
            .sort(ascending("date"))
            .select("product", "runningCount", "partitionCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("runningCount", 1L), entry("partitionCount", 2L)),
            mapOfEntries(
                entry("product", "phone"), entry("runningCount", 2L), entry("partitionCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"), entry("runningCount", 1L), entry("partitionCount", 3L)),
            mapOfEntries(
                entry("product", "tablet"), entry("runningCount", 2L), entry("partitionCount", 3L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("runningCount", 3L),
                entry("partitionCount", 3L))));
  }

  @Test
  public void testWindowFieldsSupportsARangeFrameInOver() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product").sort(ascending("salesPrice")),
                AggregateFunction.count("quantity")
                    .over(new WindowSpec().range(0, 0))
                    .as("samePriceCount"))
            .sort(ascending("date"))
            .select("product", "salesPrice", "samePriceCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("salesPrice", 12L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "phone"), entry("salesPrice", 30L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("salesPrice", 30L), entry("samePriceCount", 1L)),
            mapOfEntries(
                entry("product", "tablet"), entry("salesPrice", 60L), entry("samePriceCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("salesPrice", 60L),
                entry("samePriceCount", 2L))));
  }

  // --- output fields and composition -----------------------------------------------------------

  @Test
  public void testWindowFieldsSupportsMultipleOutputFieldsInASingleStage() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.count("quantity").as("productCount"),
                AggregateFunction.count("quantity").as("productCountCopy"))
            .sort(ascending("date"))
            .select("product", "productCount", "productCountCopy")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"),
                entry("productCount", 2L),
                entry("productCountCopy", 2L)),
            mapOfEntries(
                entry("product", "phone"),
                entry("productCount", 2L),
                entry("productCountCopy", 2L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("productCount", 3L),
                entry("productCountCopy", 3L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("productCount", 3L),
                entry("productCountCopy", 3L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("productCount", 3L),
                entry("productCountCopy", 3L))));
  }

  @Test
  public void testWindowFieldsSupportsNestedOutputFieldPaths() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.count("quantity").as("stats.productCount"))
            .sort(ascending("date"))
            .select("product", "stats")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("stats", mapOfEntries(entry("productCount", 2L)))),
            mapOfEntries(
                entry("product", "phone"), entry("stats", mapOfEntries(entry("productCount", 2L)))),
            mapOfEntries(
                entry("product", "tablet"),
                entry("stats", mapOfEntries(entry("productCount", 3L)))),
            mapOfEntries(
                entry("product", "tablet"),
                entry("stats", mapOfEntries(entry("productCount", 3L)))),
            mapOfEntries(
                entry("product", "tablet"),
                entry("stats", mapOfEntries(entry("productCount", 3L))))));
  }

  @Test
  public void testWindowFieldsSupportsChainingMultipleStages() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.count("quantity").as("productCount"))
            .addWindowFields(
                new WindowSpec().partition("region"),
                AggregateFunction.count("quantity").as("regionCount"))
            .sort(ascending("date"))
            .select("product", "region", "productCount", "regionCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"),
                entry("region", "east"),
                entry("productCount", 2L),
                entry("regionCount", 3L)),
            mapOfEntries(
                entry("product", "phone"),
                entry("region", "west"),
                entry("productCount", 2L),
                entry("regionCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("region", "east"),
                entry("productCount", 3L),
                entry("regionCount", 3L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("region", "west"),
                entry("productCount", 3L),
                entry("regionCount", 2L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("region", "east"),
                entry("productCount", 3L),
                entry("regionCount", 3L))));
  }

  @Test
  public void testWindowFieldsSupportsFilteringOnAWindowFieldInALaterStage() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.count("quantity").as("productCount"))
            .where(field("productCount").greaterThan(2))
            .sort(ascending("date"))
            .select("product", "productCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "tablet"), entry("productCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("productCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("productCount", 3L))));
  }

  @Test
  public void testWindowFieldsSupportsSortingOnAWindowFieldInALaterStage() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.count("quantity").as("productCount"))
            .sort(ascending("productCount"), ascending("date"))
            .select("product", "productCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("productCount", 2L)),
            mapOfEntries(entry("product", "phone"), entry("productCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("productCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("productCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("productCount", 3L))));
  }

  // --- error handling ----------------------------------------------------------------------------

  @Test
  public void testWindowFieldsRejectsMixingStageAndAccumulatorFraming() throws Exception {
    assumeComprehensiveTestsEnabled();
    CollectionReference salesCol = windowTestCollection();
    assertThrows(
        ExecutionException.class,
        () ->
            firestore
                .pipeline()
                .collection(salesCol)
                .addWindowFields(
                    new WindowSpec()
                        .sort(ascending("date"))
                        .documents(WindowBound.UNBOUNDED, WindowBound.CURRENT),
                    AggregateFunction.count("quantity")
                        .over(
                            new WindowSpec()
                                .documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED))
                        .as("windowCount"))
                .execute()
                .get());
  }

  @Test
  public void
      testWindowFieldsEvaluatesAccumulatorsWithoutOverUsingTheDefaultFrameWhenOthersUseOver()
          throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().sort(ascending("date")),
                AggregateFunction.count("quantity")
                    .over(new WindowSpec().documents(0, 0))
                    .as("framed"),
                AggregateFunction.count("quantity").as("unframed"))
            .sort(ascending("date"))
            .select("product", "framed", "unframed")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("framed", 1L), entry("unframed", 1L)),
            mapOfEntries(entry("product", "phone"), entry("framed", 1L), entry("unframed", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("framed", 1L), entry("unframed", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("framed", 1L), entry("unframed", 4L)),
            mapOfEntries(entry("product", "tablet"), entry("framed", 1L), entry("unframed", 5L))));
  }

  @Test
  public void testWindowFieldsRejectsAPartitionSuppliedToAnAccumulatorLevelOver() throws Exception {
    assumeComprehensiveTestsEnabled();
    CollectionReference salesCol = windowTestCollection();
    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () ->
                firestore
                    .pipeline()
                    .collection(salesCol)
                    .addWindowFields(
                        new WindowSpec().sort(ascending("quantity")),
                        AggregateFunction.count("quantity")
                            .over(
                                new WindowSpec()
                                    .partition("product")
                                    .documents(WindowBound.UNBOUNDED, WindowBound.CURRENT))
                            .as("windowCount"))
                    .execute()
                    .get());
    assertThat(exception.getMessage().toLowerCase()).contains("unexpected field");
  }

  // -----------------------------------------------------------------------------------------
  // Comprehensive window function tests (aggregators)
  // -----------------------------------------------------------------------------------------

  @Test
  public void testWindowFieldsComputesSumAverageMinimumAndMaximum() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.sum("salesPrice").as("total"),
                AggregateFunction.average("salesPrice").as("averagePrice"),
                AggregateFunction.minimum("salesPrice").as("minimumPrice"),
                AggregateFunction.maximum("salesPrice").as("maximumPrice"))
            .sort(ascending("date"))
            .select("product", "total", "averagePrice", "minimumPrice", "maximumPrice")
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(5);

    assertThat(results.get(0).getData().get("total")).isEqualTo(42L);
    assertThat(results.get(0).getData().get("averagePrice")).isEqualTo(21.0);
    assertThat(results.get(0).getData().get("minimumPrice")).isEqualTo(12L);
    assertThat(results.get(0).getData().get("maximumPrice")).isEqualTo(30L);

    assertThat(results.get(2).getData().get("total")).isEqualTo(150L);
    assertThat(results.get(2).getData().get("averagePrice")).isEqualTo(50.0);
    assertThat(results.get(2).getData().get("minimumPrice")).isEqualTo(30L);
    assertThat(results.get(2).getData().get("maximumPrice")).isEqualTo(60L);
  }

  @Test
  @Ignore("Pending backend support for count_if in add_window_fields")
  public void testWindowFieldsComputesCountIf() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.countIf(field("salesPrice").greaterThan(20)).as("expensiveCount"))
            .sort(ascending("date"))
            .select("product", "expensiveCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("expensiveCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("expensiveCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("expensiveCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("expensiveCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("expensiveCount", 3L))));
  }

  @Test
  @Ignore("Pending backend support for count_distinct in add_window_fields")
  public void testWindowFieldsComputesCountDistinct() throws Exception {
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.countDistinct("salesPrice").as("distinctPriceCount"))
            .sort(ascending("date"))
            .select("product", "distinctPriceCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("distinctPriceCount", 2L)),
            mapOfEntries(entry("product", "phone"), entry("distinctPriceCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("distinctPriceCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("distinctPriceCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("distinctPriceCount", 2L))));
  }

  @Test
  public void testWindowFieldsAggregatesOverAComputedExpression() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.sum(multiply(field("salesPrice"), field("quantity")))
                    .as("totalRevenue"))
            .sort(ascending("date"))
            .select("product", "totalRevenue")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("totalRevenue", 72L)),
            mapOfEntries(entry("product", "phone"), entry("totalRevenue", 72L)),
            mapOfEntries(entry("product", "tablet"), entry("totalRevenue", 630L)),
            mapOfEntries(entry("product", "tablet"), entry("totalRevenue", 630L)),
            mapOfEntries(entry("product", "tablet"), entry("totalRevenue", 630L))));
  }

  @Test
  public void testWindowFieldsComputesFirstAndLastOverThePartition() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)
                    .partition("product")
                    .sort(ascending("date")),
                AggregateFunction.first("salesPrice").as("firstPrice"),
                AggregateFunction.last("salesPrice").as("lastPrice"))
            .sort(ascending("date"))
            .select("product", "firstPrice", "lastPrice")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("firstPrice", 12L), entry("lastPrice", 30L)),
            mapOfEntries(
                entry("product", "phone"), entry("firstPrice", 12L), entry("lastPrice", 30L)),
            mapOfEntries(
                entry("product", "tablet"), entry("firstPrice", 30L), entry("lastPrice", 60L)),
            mapOfEntries(
                entry("product", "tablet"), entry("firstPrice", 30L), entry("lastPrice", 60L)),
            mapOfEntries(
                entry("product", "tablet"), entry("firstPrice", 30L), entry("lastPrice", 60L))));
  }

  @Test
  public void testWindowFieldsComputesArrayAgg() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)
                    .partition("product")
                    .sort(ascending("date")),
                AggregateFunction.arrayAgg("salesPrice").as("allPrices"))
            .sort(ascending("date"))
            .select("product", "allPrices")
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(5);

    assertThat(results.get(0).getData().get("allPrices")).isEqualTo(Arrays.asList(12L, 30L));
    assertThat(results.get(2).getData().get("allPrices")).isEqualTo(Arrays.asList(30L, 60L, 60L));
  }

  @Test
  public void testWindowFieldsComputesArrayAggDistinct() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.UNBOUNDED, WindowBound.UNBOUNDED)
                    .partition("product")
                    .sort(ascending("date")),
                AggregateFunction.arrayAggDistinct("salesPrice").as("distinctPrices"))
            .sort(ascending("date"))
            .select("product", "distinctPrices")
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(5);

    assertThat((List<?>) results.get(0).getData().get("distinctPrices")).containsExactly(12L, 30L);
    assertThat((List<?>) results.get(2).getData().get("distinctPrices")).containsExactly(30L, 60L);
  }

  @Test
  public void testWindowFieldsComputesARunningTotal() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec()
                    .documents(WindowBound.UNBOUNDED, WindowBound.CURRENT)
                    .sort(ascending("date")),
                AggregateFunction.sum("salesPrice").as("runningTotal"))
            .sort(ascending("date"))
            .select("product", "runningTotal")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("runningTotal", 12L)),
            mapOfEntries(entry("product", "phone"), entry("runningTotal", 42L)),
            mapOfEntries(entry("product", "tablet"), entry("runningTotal", 72L)),
            mapOfEntries(entry("product", "tablet"), entry("runningTotal", 132L)),
            mapOfEntries(entry("product", "tablet"), entry("runningTotal", 192L))));
  }

  @Test
  public void testWindowFieldsComputesACenteredMovingAverage() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().documents(1, 1).sort(ascending("date")),
                AggregateFunction.average("salesPrice").as("movingAverage"),
                AggregateFunction.countAll().as("windowCount"))
            .sort(ascending("date"))
            .select("product", "movingAverage", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(
                entry("product", "phone"), entry("movingAverage", 21.0), entry("windowCount", 2L)),
            mapOfEntries(
                entry("product", "phone"), entry("movingAverage", 24.0), entry("windowCount", 3L)),
            mapOfEntries(
                entry("product", "tablet"), entry("movingAverage", 40.0), entry("windowCount", 3L)),
            mapOfEntries(
                entry("product", "tablet"), entry("movingAverage", 50.0), entry("windowCount", 3L)),
            mapOfEntries(
                entry("product", "tablet"),
                entry("movingAverage", 60.0),
                entry("windowCount", 2L))));
  }

  @Test
  public void testWindowFieldsComputesATrailingSum() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().documents(2, 0).sort(ascending("date")),
                AggregateFunction.sum("salesPrice").as("trailingTotal"))
            .sort(ascending("date"))
            .select("product", "trailingTotal")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("trailingTotal", 12L)),
            mapOfEntries(entry("product", "phone"), entry("trailingTotal", 42L)),
            mapOfEntries(entry("product", "tablet"), entry("trailingTotal", 72L)),
            mapOfEntries(entry("product", "tablet"), entry("trailingTotal", 120L)),
            mapOfEntries(entry("product", "tablet"), entry("trailingTotal", 150L))));
  }

  @Test
  public void testWindowFieldsComputesALookAheadAverageWithANegativePrecedingBound()
      throws Exception {
    assumeComprehensiveTestsEnabled();
    // Equivalent to "documents between 1 following and 2 following": the window is
    // [index - preceding, index + following].
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().documents(-1, 2).sort(ascending("date")),
                AggregateFunction.average("salesPrice").as("lookAheadAverage"),
                AggregateFunction.countAll().as("windowCount"))
            .sort(ascending("date"))
            .select("product", "lookAheadAverage", "windowCount")
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(5);

    assertThat(results.get(0).getData().get("lookAheadAverage")).isEqualTo(30.0);
    assertThat(results.get(0).getData().get("windowCount")).isEqualTo(2L);

    assertThat(results.get(1).getData().get("lookAheadAverage")).isEqualTo(45.0);
    assertThat(results.get(1).getData().get("windowCount")).isEqualTo(2L);

    assertThat(results.get(2).getData().get("lookAheadAverage")).isEqualTo(60.0);
    assertThat(results.get(2).getData().get("windowCount")).isEqualTo(2L);

    assertThat(results.get(3).getData().get("lookAheadAverage")).isEqualTo(60.0);
    assertThat(results.get(3).getData().get("windowCount")).isEqualTo(1L);

    // The last document has an empty window.
    assertThat(results.get(4).getData().get("lookAheadAverage")).isNull();
    assertThat(results.get(4).getData().get("windowCount")).isEqualTo(0L);
  }

  @Test
  public void testWindowFieldsComputesALookBehindAverageWithANegativeFollowingBound()
      throws Exception {
    assumeComprehensiveTestsEnabled();
    // Equivalent to "documents between 2 preceding and 1 preceding": the window is
    // [index - preceding, index + following].
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().documents(2, -1).sort(ascending("date")),
                AggregateFunction.average("salesPrice").as("lookBehindAverage"),
                AggregateFunction.countAll().as("windowCount"))
            .sort(ascending("date"))
            .select("product", "lookBehindAverage", "windowCount")
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(5);

    // The first document has an empty window.
    assertThat(results.get(0).getData().get("lookBehindAverage")).isNull();
    assertThat(results.get(0).getData().get("windowCount")).isEqualTo(0L);

    assertThat(results.get(1).getData().get("lookBehindAverage")).isEqualTo(12.0);
    assertThat(results.get(1).getData().get("windowCount")).isEqualTo(1L);

    assertThat(results.get(2).getData().get("lookBehindAverage")).isEqualTo(21.0);
    assertThat(results.get(2).getData().get("windowCount")).isEqualTo(2L);

    assertThat(results.get(3).getData().get("lookBehindAverage")).isEqualTo(30.0);
    assertThat(results.get(3).getData().get("windowCount")).isEqualTo(2L);

    assertThat(results.get(4).getData().get("lookBehindAverage")).isEqualTo(45.0);
    assertThat(results.get(4).getData().get("windowCount")).isEqualTo(2L);
  }

  @Test
  public void testWindowFieldsComputesARangeLookBehindAverageWithANegativeFollowingBound()
      throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().range(WindowBound.UNBOUNDED, -1).sort(ascending("salesPrice")),
                AggregateFunction.average("salesPrice").as("lookBehindAverage"),
                AggregateFunction.countAll().as("windowCount"))
            .sort(ascending("date"))
            .select("product", "lookBehindAverage", "windowCount")
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(5);

    assertThat(results.get(0).getData().get("lookBehindAverage")).isNull();
    assertThat(results.get(0).getData().get("windowCount")).isEqualTo(0L);

    assertThat(results.get(1).getData().get("lookBehindAverage")).isEqualTo(12.0);
    assertThat(results.get(1).getData().get("windowCount")).isEqualTo(1L);

    assertThat(results.get(2).getData().get("lookBehindAverage")).isEqualTo(12.0);
    assertThat(results.get(2).getData().get("windowCount")).isEqualTo(1L);

    assertThat(results.get(3).getData().get("lookBehindAverage")).isEqualTo(24.0);
    assertThat(results.get(3).getData().get("windowCount")).isEqualTo(3L);

    assertThat(results.get(4).getData().get("lookBehindAverage")).isEqualTo(24.0);
    assertThat(results.get(4).getData().get("windowCount")).isEqualTo(3L);
  }

  @Test
  public void testWindowFieldsComputesARangeLookAheadAverageWithANegativePrecedingBound()
      throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().range(-1, WindowBound.UNBOUNDED).sort(ascending("salesPrice")),
                AggregateFunction.average("salesPrice").as("lookAheadAverage"),
                AggregateFunction.countAll().as("windowCount"))
            .sort(ascending("date"))
            .select("product", "lookAheadAverage", "windowCount")
            .execute()
            .get()
            .getResults();
    assertThat(results).hasSize(5);

    assertThat(results.get(0).getData().get("lookAheadAverage")).isEqualTo(45.0);
    assertThat(results.get(0).getData().get("windowCount")).isEqualTo(4L);

    assertThat(results.get(1).getData().get("lookAheadAverage")).isEqualTo(60.0);
    assertThat(results.get(1).getData().get("windowCount")).isEqualTo(2L);

    assertThat(results.get(2).getData().get("lookAheadAverage")).isEqualTo(60.0);
    assertThat(results.get(2).getData().get("windowCount")).isEqualTo(2L);

    assertThat(results.get(3).getData().get("lookAheadAverage")).isNull();
    assertThat(results.get(3).getData().get("windowCount")).isEqualTo(0L);

    assertThat(results.get(4).getData().get("lookAheadAverage")).isNull();
    assertThat(results.get(4).getData().get("windowCount")).isEqualTo(0L);
  }

  @Test
  public void testWindowFieldsComputesAValueBasedRangeWindow() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().range(20, 0).sort(ascending("salesPrice")),
                AggregateFunction.sum("salesPrice").as("nearbyTotal"))
            .sort(ascending("date"))
            .select("salesPrice", "nearbyTotal")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("salesPrice", 12L), entry("nearbyTotal", 12L)),
            mapOfEntries(entry("salesPrice", 30L), entry("nearbyTotal", 72L)),
            mapOfEntries(entry("salesPrice", 30L), entry("nearbyTotal", 72L)),
            mapOfEntries(entry("salesPrice", 60L), entry("nearbyTotal", 120L)),
            mapOfEntries(entry("salesPrice", 60L), entry("nearbyTotal", 120L))));
  }

  @Test
  public void testWindowFieldsComputesAValueBasedRangeWindowWithDoubleOffsets() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().range(17.5, 0.5).sort(ascending("salesPrice")),
                AggregateFunction.sum("salesPrice").as("nearbyTotal"))
            .sort(ascending("date"))
            .select("salesPrice", "nearbyTotal")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("salesPrice", 12L), entry("nearbyTotal", 12L)),
            mapOfEntries(entry("salesPrice", 30L), entry("nearbyTotal", 60L)),
            mapOfEntries(entry("salesPrice", 30L), entry("nearbyTotal", 60L)),
            mapOfEntries(entry("salesPrice", 60L), entry("nearbyTotal", 120L)),
            mapOfEntries(entry("salesPrice", 60L), entry("nearbyTotal", 120L))));
  }

  @Test
  public void testWindowFieldsComputesATrailingThreeDayTotal() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().range(3, WindowBound.CURRENT, "day").sort(ascending("date")),
                AggregateFunction.sum("salesPrice").as("threeDayTotal"))
            .sort(ascending("date"))
            .select("product", "threeDayTotal")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("threeDayTotal", 12L)),
            mapOfEntries(entry("product", "phone"), entry("threeDayTotal", 42L)),
            mapOfEntries(entry("product", "tablet"), entry("threeDayTotal", 72L)),
            mapOfEntries(entry("product", "tablet"), entry("threeDayTotal", 132L)),
            mapOfEntries(entry("product", "tablet"), entry("threeDayTotal", 60L))));
  }

  @Test
  public void testWindowFieldsCountAllCountsEveryDocumentInTheWindow() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().partition("product"),
                AggregateFunction.countAll().as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L))));
  }

  @Test
  public void testWindowFieldsDocumentsZeroPrecedingAndZeroFollowing() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().documents(0, 0).sort(ascending("date")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L))));
  }

  @Test
  public void testWindowFieldsDocumentsZeroPrecedingToUnboundedFollowing() throws Exception {
    assumeComprehensiveTestsEnabled();
    List<PipelineResult> results =
        firestore
            .pipeline()
            .collection(windowTestCollection())
            .addWindowFields(
                new WindowSpec().documents(0, WindowBound.UNBOUNDED).sort(ascending("date")),
                AggregateFunction.count("quantity").as("windowCount"))
            .sort(ascending("date"))
            .select("product", "windowCount")
            .execute()
            .get()
            .getResults();
    expectResults(
        results,
        Arrays.asList(
            mapOfEntries(entry("product", "phone"), entry("windowCount", 5L)),
            mapOfEntries(entry("product", "phone"), entry("windowCount", 4L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 3L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 2L)),
            mapOfEntries(entry("product", "tablet"), entry("windowCount", 1L))));
  }
}
