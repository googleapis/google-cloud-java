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

// [START product_search_import]
import com.google.cloud.vision.v1p3beta1.AnnotateImageRequest;
import com.google.cloud.vision.v1p3beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p3beta1.Feature;
import com.google.cloud.vision.v1p3beta1.Feature.Type;
import com.google.cloud.vision.v1p3beta1.Image;
import com.google.cloud.vision.v1p3beta1.ImageAnnotatorClient;
import com.google.cloud.vision.v1p3beta1.ImageContext;
import com.google.cloud.vision.v1p3beta1.ProductSearchParams;
import com.google.cloud.vision.v1p3beta1.ProductSearchResults.Result;
import com.google.cloud.vision.v1p3beta1.ProductSetName;
import com.google.protobuf.ByteString;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;
// [END product_search_import]

/**
 * This application demonstrates how to perform similar product search operation in Cloud Vision
 * Product Search.
 *
 * For more information, see the tutorial page at
 * https://cloud.google.com/vision/product-search/docs/
 */

public class ProductSearch {

  // [START product_search_get_similar_products_file]
  /**
   * Search similar products to image.
   *
   * @param projectId - Id of the project.
   * @param computeRegion - Region name.
   * @param productSetId - Id of the product set.
   * @param productCategory - Category of the product.
   * @param filePath - Local file path of the image to be searched
   * @param filter - Condition to be applied on the labels. Example for filter: (color = red OR
   *     color = blue) AND style = kids It will search on all products with the following labels:
   *     color:red AND style:kids color:blue AND style:kids
   * @throws IOException - on I/O errors.
   */
  public static void getSimilarProducts(
      String projectId,
      String computeRegion,
      String productSetId,
      String productCategory,
      String filePath,
      String filter)
      throws IOException {
    ImageAnnotatorClient queryImageClient = ImageAnnotatorClient.create();

    // Get the full path of the product set.
    String productSetPath = ProductSetName.of(projectId, computeRegion, productSetId).toString();

    // Read the image as a stream of bytes.
    File imgPath = new File(filePath);
    byte[] content = Files.readAllBytes(imgPath.toPath());

    // Create annotate image request along with product search feature.
    Feature featuresElement = Feature.newBuilder().setType(Type.PRODUCT_SEARCH).build();
    // The input image can be a GCS link or HTTPS link or Raw image bytes.
    // Example:
    // To use GCS link replace with below code
    // ImageSource source = ImageSource.newBuilder().setGcsImageUri(gcsUri).build();
    // Image image = Image.newBuilder().setSource(source).build();
    // To use HTTP link replace with below code
    //  ImageSource source = ImageSource.newBuilder().setImageUri(imageUri).build();
    //  Image image = Image.newBuilder().setSource(source).build();
    Image image = Image.newBuilder().setContent(ByteString.copyFrom(content)).build();
    ImageContext imageContext =
        ImageContext.newBuilder()
            .setProductSearchParams(
                ProductSearchParams.newBuilder()
                    .setProductSet(productSetPath)
                    .addProductCategories(productCategory)
                    .setFilter(filter))
            .build();

    AnnotateImageRequest annotateImageRequest =
        AnnotateImageRequest.newBuilder()
            .addFeatures(featuresElement)
            .setImage(image)
            .setImageContext(imageContext)
            .build();
    List<AnnotateImageRequest> requests = Arrays.asList(annotateImageRequest);

    // Search products similar to the image.
    BatchAnnotateImagesResponse response = queryImageClient.batchAnnotateImages(requests);

    List<Result> similarProducts =
        response.getResponses(0).getProductSearchResults().getResultsList();

    System.out.println("Similar Products: ");
    for (Result product : similarProducts) {
      System.out.println(String.format("\nProduct name: %s", product.getProduct().getName()));
      System.out.println(
          String.format("Product display name: %s", product.getProduct().getDisplayName()));
      System.out.println(
          String.format("Product description: %s", product.getProduct().getDescription()));
      System.out.println(String.format("Score(Confidence): %s", product.getScore()));
      System.out.println(String.format("Image name: %s", product.getImage()));
    }
  }
  // [END product_search_get_similar_products_file]

  public static void main(String[] args) throws Exception {
    ProductSearch productSearch = new ProductSearch();
    productSearch.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("Product Search").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser getSimilarProductsParser = subparsers.addParser("get_similar_products");
    getSimilarProductsParser.addArgument("productSetId");
    getSimilarProductsParser.addArgument("productCategory");
    getSimilarProductsParser.addArgument("filePath");
    getSimilarProductsParser.addArgument("filter").nargs("?").setDefault("");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("get_similar_products")) {
        getSimilarProducts(
            projectId,
            computeRegion,
            ns.getString("productSetId"),
            ns.getString("productCategory"),
            ns.getString("filePath"),
            ns.getString("filter"));
      }

    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
