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

import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ReferenceImage;

import java.io.IOException;
import java.io.PrintStream;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * This application demonstrates how to perform basic operations on Reference Images in Cloud Vision
 * Product Search.
 *
 * <p>For more information, see the tutorial page at
 * https://cloud.google.com/vision/product-search/docs/
 */
public class ReferenceImageManagement {

  // [START vision_product_search_create_reference_image]
  /**
   * Create a reference image.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @param referenceImageId - Id of the image.
   * @param gcsUri - Google Cloud Storage path of the input image.
   * @throws IOException - on I/O errors.
   */
  public static void createReferenceImage(
      String projectId,
      String computeRegion,
      String productId,
      String referenceImageId,
      String gcsUri)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the product.
      String formattedParent =
          ProductSearchClient.formatProductName(projectId, computeRegion, productId);
      // Create a reference image.
      ReferenceImage referenceImage = ReferenceImage.newBuilder().setUri(gcsUri).build();

      ReferenceImage image =
          client.createReferenceImage(formattedParent, referenceImage, referenceImageId);
      // Display the reference image information.
      System.out.println(String.format("Reference image name: %s", image.getName()));
      System.out.println(String.format("Reference image uri: %s", image.getUri()));
    }
  }
  // [END vision_product_search_create_reference_image]

  // [START vision_product_search_list_reference_images]
  /**
   * List all images in a product.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @throws IOException - on I/O errors.
   */
  public static void listReferenceImagesOfProduct(
      String projectId, String computeRegion, String productId) throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the product.
      String formattedParent =
          ProductSearchClient.formatProductName(projectId, computeRegion, productId);
      for (ReferenceImage image : client.listReferenceImages(formattedParent).iterateAll()) {
        // Display the reference image information.
        System.out.println(String.format("Reference image name: %s", image.getName()));
        System.out.println(
            String.format(
                "Reference image id: %s",
                image.getName().substring(image.getName().lastIndexOf('/') + 1)));
        System.out.println(String.format("Reference image uri: %s", image.getUri()));
        System.out.println(
            String.format(
                "Reference image bounding polygons: %s \n",
                image.getBoundingPolysList().toString()));
      }
    }
  }
  // [END vision_product_search_list_reference_images]

  // [START vision_product_search_get_reference_image]
  /**
   * Get info about a reference image.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @param referenceImageId - Id of the image.
   * @throws IOException - on I/O errors.
   */
  public static void getReferenceImage(
      String projectId, String computeRegion, String productId, String referenceImageId)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the reference image.
      String formattedName =
          ProductSearchClient.formatImageName(
              projectId, computeRegion, productId, referenceImageId);
      // Get complete detail of the reference image.
      ReferenceImage image = client.getReferenceImage(formattedName);
      // Display the reference image information.
      System.out.println(String.format("Reference image name: %s", image.getName()));
      System.out.println(
          String.format(
              "Reference image id: %s",
              image.getName().substring(image.getName().lastIndexOf('/') + 1)));
      System.out.println(String.format("Reference image uri: %s", image.getUri()));
      System.out.println(
          String.format(
              "Reference image bounding polygons: %s \n", image.getBoundingPolysList().toString()));
    }
  }
  // [END vision_product_search_get_reference_image]

  // [START vision_product_search_delete_reference_image]
  /**
   * Delete a reference image.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @param referenceImageId - Id of the image.
   * @throws IOException - on I/O errors.
   */
  public static void deleteReferenceImage(
      String projectId, String computeRegion, String productId, String referenceImageId)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the reference image.
      String formattedName =
          ProductSearchClient.formatImageName(
              projectId, computeRegion, productId, referenceImageId);
      // Delete the reference image.
      client.deleteReferenceImage(formattedName);
      System.out.println("Reference image deleted from product.");
    }
  }
  // [END vision_product_search_delete_reference_image]

  public static void main(String[] args) throws Exception {
    ReferenceImageManagement referenceImageManagement = new ReferenceImageManagement();
    referenceImageManagement.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("Reference Image Management").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser createReferenceImageParser = subparsers.addParser("create_reference_image");
    createReferenceImageParser.addArgument("productId");
    createReferenceImageParser.addArgument("referenceImageId");
    createReferenceImageParser.addArgument("gcsUri");

    Subparser listReferenceImagesOfProductParser =
        subparsers.addParser("list_reference_images_of_product");
    listReferenceImagesOfProductParser.addArgument("productId");

    Subparser getReferenceImageParser = subparsers.addParser("get_reference_image");
    getReferenceImageParser.addArgument("productId");
    getReferenceImageParser.addArgument("referenceImageId");

    Subparser deleteReferenceImageParser = subparsers.addParser("delete_reference_image");
    deleteReferenceImageParser.addArgument("productId");
    deleteReferenceImageParser.addArgument("referenceImageId");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("create_reference_image")) {
        createReferenceImage(
            projectId,
            computeRegion,
            ns.getString("productId"),
            ns.getString("referenceImageId"),
            ns.getString("gcsUri"));
      }
      if (ns.get("command").equals("list_reference_images_of_product")) {
        listReferenceImagesOfProduct(projectId, computeRegion, ns.getString("productId"));
      }
      if (ns.get("command").equals("get_reference_image")) {
        getReferenceImage(
            projectId, computeRegion, ns.getString("productId"), ns.getString("referenceImageId"));
      }
      if (ns.get("command").equals("delete_reference_image")) {
        deleteReferenceImage(
            projectId, computeRegion, ns.getString("productId"), ns.getString("referenceImageId"));
      }

    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
