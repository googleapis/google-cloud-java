/*
 * Copyright 2018 Google LLC
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

package com.example.vision;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link ProductSearch}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ProductSearchIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String COMPUTE_REGION = "us-west1";
  private static final String GCS_URI =
      "gs://java-docs-samples-testing/product-search/indexed_product_sets.csv";
  private static final String PRODUCT_SET_ID = "indexed_product_set_id_for_testing";
  private static final String PRODUCT_CATEGORY = "apparel";
  private static final String PRODUCT_ID_1 = "indexed_product_id_for_testing_1";
  private static final String PRODUCT_ID_2 = "indexed_product_id_for_testing_2";
  private static final String IMAGE_URI_1 =
      "gs://java-docs-samples-testing/product-search/shoes_1.jpg";
  private static final String FILE_PATH_1 = "./resources/shoes_1.jpg";
  private static final String FILTER = "style=womens";
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() throws Exception {

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    ImportProductSets.importProductSets(PROJECT_ID, COMPUTE_REGION, GCS_URI);
    bout.reset();
  }

  @After
  public void tearDown() throws Exception {
    ProductManagement.deleteProduct(PROJECT_ID,COMPUTE_REGION,PRODUCT_ID_1);
    ProductManagement.deleteProduct(PROJECT_ID,COMPUTE_REGION,PRODUCT_ID_2);
    ProductSetManagement.deleteProductSet(PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);
    System.setOut(null);
  }

  @Test
  public void testGetSimilarProductsFile() throws Exception {
    // Act
    ProductSearch.getSimilarProductsFile(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID, PRODUCT_CATEGORY, FILE_PATH_1, "");

    // Assert
    String got = bout.toString();
    assertThat(got).contains(PRODUCT_ID_1);
    assertThat(got).contains(PRODUCT_ID_2);
  }

  @Test
  public void testGetSimilarProductsGcs() throws Exception {
    // Act
    ProductSearch.getSimilarProductsGcs(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID, PRODUCT_CATEGORY, IMAGE_URI_1, "");

    // Assert
    String got = bout.toString();
    assertThat(got).contains(PRODUCT_ID_1);
    assertThat(got).contains(PRODUCT_ID_2);
  }

  @Test
  public void testGetSimilarProductsFileWithFilter() throws Exception {
    // Act
    ProductSearch.getSimilarProductsFile(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID, PRODUCT_CATEGORY, FILE_PATH_1, FILTER);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(PRODUCT_ID_1);
    assertThat(got).doesNotContain(PRODUCT_ID_2);
  }

  @Test
  public void testGetSimilarProductsGcsWithFilter() throws Exception {
    // Act
    ProductSearch.getSimilarProductsGcs(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID, PRODUCT_CATEGORY, IMAGE_URI_1, FILTER);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(PRODUCT_ID_1);
    assertThat(got).doesNotContain(PRODUCT_ID_2);
  }
}
