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
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_resource_path")
// sample-metadata:
//   title: Create product set (demonstrate resource paths)
//   description: Create product set (demonstrate resource paths)
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.SamplegenResourcePath [--args='[--project "[PROJECT ID]"]']

package com.google.cloud.examples.vision.v1;

import com.google.cloud.vision.v1.CreateProductSetRequest;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSet;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SamplegenResourcePath {
  // [START samplegen_resource_path]
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
    String project = "[PROJECT ID]";
    sampleCreateProductSet(project);
  }

  /**
   * Create product set (demonstrate resource paths)
   *
   * @param project The Google Cloud Project for creating this product set
   */
  public static void sampleCreateProductSet(String project) {
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
      LocationName parent = LocationName.of(project, "us-central1");
      String displayName = "[DISPLAY NAME]";
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
  // [END samplegen_resource_path]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("project").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String project = cl.getOptionValue("project", "[PROJECT ID]");

    sampleCreateProductSet(project);
  }
}
