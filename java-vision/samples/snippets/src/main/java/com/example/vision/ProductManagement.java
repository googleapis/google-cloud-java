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

import com.google.cloud.vision.v1.Product;
import com.google.cloud.vision.v1.Product.KeyValue;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.protobuf.FieldMask;

import java.io.IOException;
import java.io.PrintStream;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * This application demonstrates how to perform basic operations on Products.
 *
 * <p>For more information, see the tutorial page at
 * https://cloud.google.com/vision/product-search/docs/
 */
public class ProductManagement {

  // [START vision_product_search_create_product]
  /**
   * Create one product.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @param productDisplayName - Display name of the product.
   * @param productCategory - Category of the product.
   * @throws IOException - on I/O errors.
   */
  public static void createProduct(
      String projectId,
      String computeRegion,
      String productId,
      String productDisplayName,
      String productCategory)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // A resource that represents Google Cloud Platform location.
      String formattedParent = ProductSearchClient.formatLocationName(projectId, computeRegion);
      // Create a product with the product specification in the region.
      // Multiple labels are also supported.
      Product myProduct =
          Product.newBuilder()
              .setName(productId)
              .setDisplayName(productDisplayName)
              .setProductCategory(productCategory)
              .build();
      Product product = client.createProduct(formattedParent, myProduct, productId);
      // Display the product information
      System.out.println(String.format("Product name: %s", product.getName()));
    }
  }
  // [END vision_product_search_create_product]

  // [START vision_product_search_list_products]
  /**
   * List all products.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @throws IOException - on I/O errors.
   */
  public static void listProducts(String projectId, String computeRegion) throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // A resource that represents Google Cloud Platform location.
      String formattedParent = ProductSearchClient.formatLocationName(projectId, computeRegion);

      // List all the products available in the region.
      for (Product product : client.listProducts(formattedParent).iterateAll()) {
        // Display the product information
        System.out.println(String.format("\nProduct name: %s", product.getName()));
        System.out.println(
            String.format(
                "Product id: %s",
                product.getName().substring(product.getName().lastIndexOf('/') + 1)));
        System.out.println(String.format("Product display name: %s", product.getDisplayName()));
        System.out.println(String.format("Product category: %s", product.getProductCategory()));
        System.out.println("Product labels:");
        System.out.println(
            String.format("Product labels: %s", product.getProductLabelsList().toString()));
      }
    }
  }
  // [END vision_product_search_list_products]

  // [START vision_product_search_get_product]
  /**
   * Get information about a product.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @throws IOException - on I/O errors.
   */
  public static void getProduct(String projectId, String computeRegion, String productId)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the product.
      String formattedName =
          ProductSearchClient.formatProductName(projectId, computeRegion, productId);
      // Get complete detail of the product.
      Product product = client.getProduct(formattedName);
      // Display the product information
      System.out.println(String.format("Product name: %s", product.getName()));
      System.out.println(
          String.format(
              "Product id: %s",
              product.getName().substring(product.getName().lastIndexOf('/') + 1)));
      System.out.println(String.format("Product display name: %s", product.getDisplayName()));
      System.out.println(String.format("Product description: %s", product.getDescription()));
      System.out.println(String.format("Product category: %s", product.getProductCategory()));
      System.out.println(String.format("Product labels: "));
      for (Product.KeyValue element : product.getProductLabelsList()) {
        System.out.println(String.format("%s: %s", element.getKey(), element.getValue()));
      }
    }
  }
  // [END vision_product_search_get_product]

  // [START vision_product_search_update_product_labels]
  /**
   * Update the product labels.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId -Id of the product.
   * @param productLabels - Labels of the product.
   * @throws IOException - on I/O errors.
   */
  public static void updateProductLabels(
      String projectId, String computeRegion, String productId, String productLabels)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the product.
      String formattedName =
          ProductSearchClient.formatProductName(projectId, computeRegion, productId);

      // Set product name, product labels and product display name.
      // Multiple labels are also supported.
      Product product =
          Product.newBuilder()
              .setName(formattedName)
              .addProductLabels(
                  KeyValue.newBuilder()
                      .setKey(productLabels.split(",")[0].split("=")[0])
                      .setValue(productLabels.split(",")[0].split("=")[1])
                      .build())
              .build();

      // Set product update field name.
      FieldMask updateMask = FieldMask.newBuilder().addPaths("product_labels").build();

      // Update the product.
      Product updatedProduct = client.updateProduct(product, updateMask);
      // Display the product information
      System.out.println(String.format("Product name: %s", updatedProduct.getName()));
      System.out.println(String.format("Updated product labels: "));
      for (Product.KeyValue element : updatedProduct.getProductLabelsList()) {
        System.out.println(String.format("%s: %s", element.getKey(), element.getValue()));
      }
    }
  }
  // [END vision_product_search_update_product_labels]

  // [START vision_product_search_delete_product]
  /**
   * Delete the product and all its reference images.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productId - Id of the product.
   * @throws IOException - on I/O errors.
   */
  public static void deleteProduct(String projectId, String computeRegion, String productId)
      throws IOException {
    try (ProductSearchClient client = ProductSearchClient.create()) {

      // Get the full path of the product.
      String formattedName =
          ProductSearchClient.formatProductName(projectId, computeRegion, productId);

      // Delete a product.
      client.deleteProduct(formattedName);
      System.out.println("Product deleted.");
    }
  }
  // [END vision_product_search_delete_product]

  public static void main(String[] args) throws Exception {
    ProductManagement productManagement = new ProductManagement();
    productManagement.argsHelper(args, System.out);
  }

  public void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("Product Management").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser createProductParser = subparsers.addParser("create_product");
    createProductParser.addArgument("productId");
    createProductParser.addArgument("productDisplayName");
    createProductParser.addArgument("productCategory");
    createProductParser.addArgument("productDescription");
    createProductParser.addArgument("productLabels").nargs("?").setDefault("");

    subparsers.addParser("list_products");

    Subparser getProductParser = subparsers.addParser("get_product");
    getProductParser.addArgument("productId");

    Subparser updateProductLabelsParser = subparsers.addParser("update_product_labels");
    updateProductLabelsParser.addArgument("productId");
    updateProductLabelsParser.addArgument("productLabels");

    Subparser deleteProductParser = subparsers.addParser("delete_product");
    deleteProductParser.addArgument("productId");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("create_product")) {
        createProduct(
            projectId,
            computeRegion,
            ns.getString("productId"),
            ns.getString("productDisplayName"),
            ns.getString("productCategory"));
      }
      if (ns.get("command").equals("list_products")) {
        listProducts(projectId, computeRegion);
      }
      if (ns.get("command").equals("get_product")) {
        getProduct(projectId, computeRegion, ns.getString("productId"));
      }
      if (ns.get("command").equals("update_product_labels")) {
        updateProductLabels(
            projectId, computeRegion, ns.getString("productId"), ns.getString("productLabels"));
      }
      if (ns.get("command").equals("delete_product")) {
        deleteProduct(projectId, computeRegion, ns.getString("productId"));
      }

    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
