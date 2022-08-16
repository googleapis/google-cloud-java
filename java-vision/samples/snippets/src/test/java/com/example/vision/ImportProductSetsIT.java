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

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
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
  private static final String PRODUCT_SET_ID =
      String.format("test_%s", UUID.randomUUID().toString());
  private static final String PRODUCT_ID_1 = String.format("test_%s", UUID.randomUUID().toString());
  private static final String IMAGE_URI_1 = "shoes_1.jpg";
  private static final String FILEPATH =
      String.format("vision/%s.csv", UUID.randomUUID().toString());
  private static final String GCS_URI = String.format("gs://%s/%s", PROJECT_ID, FILEPATH);
  private Blob blob;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    // Create the product set csv file locally and upload it to GCS
    // This is so that there is a unique product set ID for all java version tests.
    Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
    BlobId blobId = BlobId.of(PROJECT_ID, FILEPATH);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    String csvContents =
        "\"gs://cloud-samples-data/vision/product_search/shoes_1.jpg\","
            + String.format("\"%s\",", IMAGE_URI_1)
            + String.format("\"%s\",", PRODUCT_SET_ID)
            + String.format("\"%s\",", PRODUCT_ID_1)
            + "\"apparel\",,\"style=womens\",\"0.1,0.1,0.9,0.1,0.9,0.9,0.1,0.9\"";
    blob = storage.create(blobInfo, csvContents.getBytes());

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() throws IOException {
    ProductManagement.deleteProduct(PROJECT_ID, COMPUTE_REGION, PRODUCT_ID_1);
    ProductSetManagement.deleteProductSet(PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);
    Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
    // Delete the created blob
    storage.delete(blob.getBlobId());
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testImportProductSets() throws Exception {
    // Act
    ImportProductSets.importProductSets(PROJECT_ID, COMPUTE_REGION, GCS_URI);
    ProductSetManagement.listProductSets(PROJECT_ID, COMPUTE_REGION);

    // Assert
    String got = bout.toString();
    assertThat(got).contains(PRODUCT_SET_ID);

    // Act
    ProductManagement.listProducts(PROJECT_ID, COMPUTE_REGION);

    // Assert
    assertThat(got).contains(PRODUCT_ID_1);

    // Act
    ProductInProductSetManagement.listProductsInProductSet(
        PROJECT_ID, COMPUTE_REGION, PRODUCT_SET_ID);

    // Assert
    assertThat(got).contains(PRODUCT_ID_1);

    // Act
    ReferenceImageManagement.listReferenceImagesOfProduct(PROJECT_ID, COMPUTE_REGION, PRODUCT_ID_1);

    // Assert
    assertThat(got).contains(IMAGE_URI_1);
  }
}
