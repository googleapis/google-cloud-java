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
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link ImportProductSets}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ImportProductSetsIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String COMPUTE_REGION = "us-west1";
  private static final String GCS_URI =
      "gs://java-docs-samples-testing/product-search/product_sets.csv";
  private static final String PRODUCT_SET_ID = "fake_product_set_id_for_testing";
  private static final String PRODUCT_ID_1 = "fake_product_id_for_testing_1";
  private static final String PRODUCT_ID_2 = "fake_product_id_for_testing_2";
  private static final String IMAGE_URI_1 = "shoes_1.jpg";
  private static final String IMAGE_URI_2 = "shoes_2.jpg";
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() throws IOException {
    ProductManagement.deleteProduct(PROJECT_ID,COMPUTE_REGION,PRODUCT_ID_1);
    ProductManagement.deleteProduct(PROJECT_ID,COMPUTE_REGION,PRODUCT_ID_2);
    ProductSetManagement.deleteProductSet(PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);
    System.setOut(null);
  }

  @Test
  public void testImportProductSets() throws Exception {
    // Act
    ProductSetManagement.listProductSets(PROJECT_ID, COMPUTE_REGION);

    // Assert
    String got = bout.toString();
    System.out.println(got);
    assertThat(got).doesNotContain(PRODUCT_SET_ID);

    // Act
    ProductManagement.listProducts(PROJECT_ID, COMPUTE_REGION);

    // Assert
    assertThat(got).doesNotContain(PRODUCT_ID_1);
    assertThat(got).doesNotContain(PRODUCT_ID_2);

    // Act
    ProductInProductSetManagement.listProductsInProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);

    // Assert
    assertThat(got).doesNotContain(PRODUCT_ID_1);
    assertThat(got).doesNotContain(PRODUCT_ID_2);

    // Act
    ReferenceImageManagement.listReferenceImagesOfProduct(PROJECT_ID, COMPUTE_REGION, PRODUCT_ID_1);

    // Assert
    assertThat(got).doesNotContain(IMAGE_URI_1);

    // Act
    ReferenceImageManagement.listReferenceImagesOfProduct(PROJECT_ID, COMPUTE_REGION, PRODUCT_ID_2);

    // Assert
    assertThat(got).doesNotContain(IMAGE_URI_2);

    // Act
    ImportProductSets.importProductSets(PROJECT_ID, COMPUTE_REGION, GCS_URI);
    ProductSetManagement.listProductSets(PROJECT_ID, COMPUTE_REGION);

    // Assert
    got = bout.toString();
    assertThat(got).contains(PRODUCT_SET_ID);

    // Act
    ProductManagement.listProducts(PROJECT_ID, COMPUTE_REGION);

    // Assert
    assertThat(got).contains(PRODUCT_ID_1);
    assertThat(got).contains(PRODUCT_ID_2);

    // Act
    ProductInProductSetManagement.listProductsInProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);

    // Assert
    assertThat(got).contains(PRODUCT_ID_1);
    assertThat(got).contains(PRODUCT_ID_2);

    // Act
    ReferenceImageManagement.listReferenceImagesOfProduct(PROJECT_ID, COMPUTE_REGION, PRODUCT_ID_1);

    // Assert
    assertThat(got).contains(IMAGE_URI_1);

    // Act
    ReferenceImageManagement.listReferenceImagesOfProduct(PROJECT_ID, COMPUTE_REGION, PRODUCT_ID_2);

    // Assert
    assertThat(got).contains(IMAGE_URI_2);
  }
}
