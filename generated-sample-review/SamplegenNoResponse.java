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
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_no_response")
// sample-metadata:
//   title: Delete Product Set (returns Empty)
//   description: Delete Product Set (returns Empty)
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.SamplegenNoResponse

package com.google.cloud.examples.vision.v1;

import com.google.cloud.vision.v1.DeleteProductSetRequest;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSetName;

public class SamplegenNoResponse {
  // [START samplegen_no_response]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.vision.v1.DeleteProductSetRequest;
   * import com.google.cloud.vision.v1.ProductSearchClient;
   * import com.google.cloud.vision.v1.ProductSetName;
   */

  /** Delete Product Set (returns Empty) */
  public static void sampleDeleteProductSet() {
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {

      // The full name of the product set to delete
      ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
      DeleteProductSetRequest request =
          DeleteProductSetRequest.newBuilder().setName(name.toString()).build();
      productSearchClient.deleteProductSet(request);
      System.out.println("Deleted product set.");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_no_response]

  public static void main(String[] args) {
    sampleDeleteProductSet();
  }
}
