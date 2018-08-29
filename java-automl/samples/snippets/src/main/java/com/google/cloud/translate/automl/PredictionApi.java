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

/*
 * This application demonstrates how to perform basic operations on prediction
 * with the Google AutoML Vision API.
 *
 * For more information, the documentation at
 * https://cloud.google.com/vision/automl/docs.
 */

package com.google.cloud.translate.automl;

// Imports the Google Cloud client library
import com.google.cloud.automl.v1beta1.ExamplePayload;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.PredictResponse;
import com.google.cloud.automl.v1beta1.PredictionServiceClient;

import com.google.cloud.automl.v1beta1.TextSnippet;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * Google Cloud AutoML Translate API sample application. Example usage: mvn package exec:java
 * -Dexec.mainClass ='com.google.cloud.translate.automl.PredictionApi' -Dexec.args='predict
 * [modelId] [file-path]'
 */
public class PredictionApi {

  // [START automl_translate_predict]

  /**
   * Demonstrates using the AutoML client to predict an image.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param modelId the Id of the model which will be used for text classification.
   * @param filePath the Local text file path of the content to be classified.
   * @throws IOException on Input/Output errors.
   */
  public static void predict(
      String projectId, String computeRegion, String modelId, String filePath) throws IOException {

    // Instantiate client for prediction service.
    PredictionServiceClient predictionClient = PredictionServiceClient.create();

    // Get the full path of the model.
    ModelName name = ModelName.of(projectId, computeRegion, modelId);

    // Read the file content for translation.
    String content = new String(Files.readAllBytes(Paths.get(filePath)));

    TextSnippet textSnippet = TextSnippet.newBuilder().setContent(content).build();

    // Set the payload by giving the content of the file.
    ExamplePayload payload = ExamplePayload.newBuilder().setTextSnippet(textSnippet).build();

    // Additional parameters that can be provided for prediction
    Map<String, String> params = new HashMap<>();

    PredictResponse response = predictionClient.predict(name, payload, params);
    TextSnippet translatedContent = response.getPayload(0).getTranslation().getTranslatedContent();

    System.out.println(String.format("Translated Content: %s", translatedContent.getContent()));
  }
  // [END automl_translate_predict]

  public static void main(String[] args) throws IOException {
    PredictionApi predictApi = new PredictionApi();
    predictApi.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws IOException {
    ArgumentParser parser =
        ArgumentParsers.newFor("PredictionApi")
            .build()
            .defaultHelp(true)
            .description("Prediction API Operation");

    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser predictParser = subparsers.addParser("predict");
    predictParser.addArgument("modelId");
    predictParser.addArgument("filePath");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("predict")) {
        predict(projectId, computeRegion, ns.getString("modelId"), ns.getString("filePath"));

      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
