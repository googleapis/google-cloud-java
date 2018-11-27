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

// [START vision_product_search_tutorial_import]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vision.v1.BatchOperationMetadata;
import com.google.cloud.vision.v1.ImportProductSetsGcsSource;
import com.google.cloud.vision.v1.ImportProductSetsGcsSource.Builder;
import com.google.cloud.vision.v1.ImportProductSetsInputConfig;
import com.google.cloud.vision.v1.ImportProductSetsResponse;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ReferenceImage;
// [END vision_product_search_tutorial_import]
import java.io.PrintStream;
import javax.swing.JPanel;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * This application demonstrates how to Import Product Sets in Cloud Vision Product Search.
 *
 * <p>For more information, see the tutorial page at
 * https://cloud.google.com/vision/product-search/docs/
 */
public class ImportProductSets extends JPanel {
  // [START vision_product_search_import_product_images]
  /**
   * Import images of different products in the product set.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param gcsUri - Google Cloud Storage URI.Target files must be in Product Search CSV format.
   * @throws Exception - on client errors.
   */
  public static void importProductSets(String projectId, String computeRegion, String gcsUri)
      throws Exception {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // A resource that represents Google Cloud Platform location.
      String formattedParent = ProductSearchClient.formatLocationName(projectId, computeRegion);
      Builder gcsSource = ImportProductSetsGcsSource.newBuilder().setCsvFileUri(gcsUri);

      // Set the input configuration along with Google Cloud Storage URI
      ImportProductSetsInputConfig inputConfig =
          ImportProductSetsInputConfig.newBuilder().setGcsSource(gcsSource).build();

      // Import the product sets from the input URI.
      OperationFuture<ImportProductSetsResponse, BatchOperationMetadata> response =
          client.importProductSetsAsync(formattedParent, inputConfig);

      System.out.println(String.format("Processing operation name: %s", response.getName()));
      ImportProductSetsResponse results = response.get();
      System.out.println("Processing done.");
      System.out.println("Results of the processing:");

      for (int i = 0; i < results.getStatusesCount(); i++) {
        System.out.println(
            String.format(
                "Status of processing line %s of the csv: %s", i, results.getStatuses(i)));
        // Check the status of reference image.
        if (results.getStatuses(i).getCode() == 0) {
          ReferenceImage referenceImage = results.getReferenceImages(i);
          System.out.println(referenceImage);
        } else {
          System.out.println("No reference image.");
        }
      }
    }
  }
  // [END vision_product_search_import_product_images]

  public static void main(String[] args) throws Exception {
    ImportProductSets importProductSet = new ImportProductSets();
    importProductSet.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("Import Product Sets").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser importProductSetsParser = subparsers.addParser("import_product_sets");
    importProductSetsParser.addArgument("gcsUri");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("import_product_sets")) {
        importProductSets(projectId, computeRegion, ns.getString("gcsUri"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
