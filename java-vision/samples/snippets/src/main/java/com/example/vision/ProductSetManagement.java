/*
 * Copyright 2018 Google Inc.
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

import com.google.cloud.vision.v1.CreateProductSetRequest;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSet;

import java.io.IOException;
import java.io.PrintStream;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * This application demonstrates how to perform basic operations on Product Sets.
 *
 * <p>For more information, see the tutorial page at
 * https://cloud.google.com/vision/product-search/docs/
 */
public class ProductSetManagement {

  // [START vision_product_search_create_product_set]
  /**
   * Create a product set
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productSetId - Id of the product set.
   * @param productSetDisplayName - Display name of the product set.
   * @throws IOException - on I/O errors.
   */
  public static void createProductSet(
      String projectId, String computeRegion, String productSetId, String productSetDisplayName)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // A resource that represents Google Cloud Platform location.
      String formattedParent = ProductSearchClient.formatLocationName(projectId, computeRegion);

      // Create a product set with the product set specification in the region.
      ProductSet myProductSet =
          ProductSet.newBuilder().setDisplayName(productSetDisplayName).build();
      CreateProductSetRequest request =
          CreateProductSetRequest.newBuilder()
              .setParent(formattedParent)
              .setProductSet(myProductSet)
              .setProductSetId(productSetId)
              .build();
      ProductSet productSet = client.createProductSet(request);
      // Display the product set information
      System.out.println(String.format("Product set name: %s", productSet.getName()));
    }
  }
  // [END vision_product_search_create_product_set]

  // [START vision_product_search_list_product_sets]
  /**
   * List all product sets
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @throws IOException - on I/O errors.
   */
  public static void listProductSets(String projectId, String computeRegion) throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {
      // A resource that represents Google Cloud Platform location.
      String formattedParent = ProductSearchClient.formatLocationName(projectId, computeRegion);
      // List all the product sets available in the region.
      for (ProductSet productSet : client.listProductSets(formattedParent).iterateAll()) {
        // Display the product set information
        System.out.println(String.format("Product set name: %s", productSet.getName()));
        System.out.println(
            String.format(
                "Product set id: %s",
                productSet.getName().substring(productSet.getName().lastIndexOf('/') + 1)));
        System.out.println(
            String.format("Product set display name: %s", productSet.getDisplayName()));
        System.out.println("Product set index time:");
        System.out.println(String.format("\tseconds: %s", productSet.getIndexTime().getSeconds()));
        System.out.println(String.format("\tnanos: %s", productSet.getIndexTime().getNanos()));
      }
    }
  }
  // [END vision_product_search_list_product_sets]

  // [START vision_product_search_get_product_set]
  /**
   * Get info about the product set.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productSetId - Id of the product set.
   * @throws IOException - on I/O errors.
   */
  public static void getProductSet(String projectId, String computeRegion, String productSetId)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the product set.
      String formattedName =
          ProductSearchClient.formatProductSetName(projectId, computeRegion, productSetId);
      // Get complete detail of the product set.
      ProductSet productSet = client.getProductSet(formattedName);
      // Display the product set information
      System.out.println(String.format("Product set name: %s", productSet.getName()));
      System.out.println(
          String.format(
              "Product set id: %s",
              productSet.getName().substring(productSet.getName().lastIndexOf('/') + 1)));
      System.out.println(
          String.format("Product set display name: %s", productSet.getDisplayName()));
      System.out.println("Product set index time:");
      System.out.println(String.format("\tseconds: %s", productSet.getIndexTime().getSeconds()));
      System.out.println(String.format("\tnanos: %s", productSet.getIndexTime().getNanos()));
    }
  }
  // [END vision_product_search_get_product_set]

  // [START vision_product_search_delete_product_set]
  /**
   * Delete a product set.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productSetId - Id of the product set.
   * @throws IOException - on I/O errors.
   */
  public static void deleteProductSet(String projectId, String computeRegion, String productSetId)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the product set.
      String formattedName =
          ProductSearchClient.formatProductSetName(projectId, computeRegion, productSetId);
      // Delete the product set.
      client.deleteProductSet(formattedName);
      System.out.println(String.format("Product set deleted"));
    }
  }
  // [END vision_product_search_delete_product_set]

  public static void main(String[] args) throws Exception {
    ProductSetManagement productSetManagement = new ProductSetManagement();
    productSetManagement.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("Product Set Management").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser createProductSetParser = subparsers.addParser("create_product_set");
    createProductSetParser.addArgument("productSetId");
    createProductSetParser.addArgument("productSetDisplayName");

    subparsers.addParser("list_product_sets");

    Subparser getProductSetParser = subparsers.addParser("get_product_set");
    getProductSetParser.addArgument("productSetId");

    Subparser deleteProductSetParser = subparsers.addParser("delete_product_set");
    deleteProductSetParser.addArgument("productSetId");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("create_product_set")) {
        createProductSet(
            projectId,
            computeRegion,
            ns.getString("productSetId"),
            ns.getString("productSetDisplayName"));
      }
      if (ns.get("command").equals("list_product_sets")) {
        listProductSets(projectId, computeRegion);
      }
      if (ns.get("command").equals("get_product_set")) {
        getProductSet(projectId, computeRegion, ns.getString("productSetId"));
      }
      if (ns.get("command").equals("delete_product_set")) {
        deleteProductSet(projectId, computeRegion, ns.getString("productSetId"));
      }

    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
