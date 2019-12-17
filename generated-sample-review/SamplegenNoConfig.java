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
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_no_config")
// sample-metadata:
//   title:
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.SamplegenNoConfig

package com.google.cloud.examples.vision.v1;

import com.google.cloud.vision.v1.CreateProductSetRequest;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSet;

public class SamplegenNoConfig {
  // [START ]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.vision.v1.CreateProductSetRequest;
   * import com.google.cloud.vision.v1.LocationName;
   * import com.google.cloud.vision.v1.ProductSearchClient;
   * import com.google.cloud.vision.v1.ProductSet;
   */

  public static void sampleCreateProductSet() {
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ProductSet productSet = ProductSet.newBuilder().build();
      CreateProductSetRequest request =
          CreateProductSetRequest.newBuilder()
              .setParent(parent.toString())
              .setProductSet(productSet)
              .build();
      ProductSet response = productSearchClient.createProductSet(request);
      System.out.println(response);
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END ]

  public static void main(String[] args) {
    sampleCreateProductSet();
  }
}
