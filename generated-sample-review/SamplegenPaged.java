/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// DO NOT EDIT! This is a generated sample ("RequestPaged",  "samplegen_paged")
// sample-metadata:
//   title: List product sets
//   description: List product sets
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.SamplegenPaged

package com.google.cloud.examples.vision.v1;

import com.google.cloud.vision.v1.ListProductSetsRequest;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSet;

public class SamplegenPaged {
  // [START samplegen_paged]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.vision.v1.ListProductSetsRequest;
   * import com.google.cloud.vision.v1.LocationName;
   * import com.google.cloud.vision.v1.ProductSearchClient;
   * import com.google.cloud.vision.v1.ProductSet;
   */

  /** List product sets */
  public static void sampleListProductSets() {
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {

      // The project and location where the product sets are contained.
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ListProductSetsRequest request =
          ListProductSetsRequest.newBuilder().setParent(parent.toString()).build();
      for (ProductSet responseItem : productSearchClient.listProductSets(request).iterateAll()) {
        // The entity in this iteration represents a product set
        ProductSet productSet = responseItem;
        System.out.printf("The full name of this product set: %s\n", productSet.getName());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_paged]

  public static void main(String[] args) {
    sampleListProductSets();
  }
}
