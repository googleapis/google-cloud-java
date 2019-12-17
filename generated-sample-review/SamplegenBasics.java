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
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_basics")
// sample-metadata:
//   title: This is the sample title
//   description: This is the sample description
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.SamplegenBasics [--args='[--display_name "This is the default value of the display_name request field"]']

package com.google.cloud.examples.vision.v1;

import com.google.cloud.vision.v1.CreateProductSetRequest;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSet;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SamplegenBasics {
  // [START samplegen_basics]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.vision.v1.CreateProductSetRequest;
   * import com.google.cloud.vision.v1.LocationName;
   * import com.google.cloud.vision.v1.ProductSearchClient;
   * import com.google.cloud.vision.v1.ProductSet;
   */

  public static void sampleCreateProductSet() {
    // TODO(developer): Replace these variables before running the sample.
    String displayName = "This is the default value of the display_name request field";
    sampleCreateProductSet(displayName);
  }

  /**
   * This is the sample description
   *
   * @param displayName Description of the parameter
   */
  public static void sampleCreateProductSet(String displayName) {
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {

      // The project and location in which the product set should be created.
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ProductSet productSet = ProductSet.newBuilder().setDisplayName(displayName).build();
      CreateProductSetRequest request =
          CreateProductSetRequest.newBuilder()
              .setParent(parent.toString())
              .setProductSet(productSet)
              .build();
      ProductSet response = productSearchClient.createProductSet(request);
      // The API response represents the created product set
      ProductSet productSet = response;
      System.out.printf("The full name of the created product set: %s\n", productSet.getName());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_basics]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("display_name").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String displayName =
        cl.getOptionValue(
            "display_name", "This is the default value of the display_name request field");

    sampleCreateProductSet(displayName);
  }
}
