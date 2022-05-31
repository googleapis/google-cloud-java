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

package com.google.cloud.translate.automl;

// Imports the Google Cloud client library
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.DatasetName;
import com.google.cloud.automl.v1.GcsSource;
import com.google.cloud.automl.v1.InputConfig;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * Google Cloud AutoML Translate API sample application. Example usage: mvn package exec:java
 * -Dexec.mainClass ='com.google.cloud.translate.samples.DatasetAPI' -Dexec.args='create_dataset
 * test_dataset'
 */
public class DatasetApi {

  // [START automl_translate_import_data]
  /**
   * Import sentence pairs to the dataset.
   *
   * @param projectId the Google Cloud Project ID.
   * @param computeRegion the Region name. (e.g., "us-central1").
   * @param datasetId the Id of the dataset.
   * @param path the remote Path of the training data csv file.
   */
  public static void importData(
      String projectId, String computeRegion, String datasetId, String path)
      throws IOException, InterruptedException, ExecutionException {
    // Instantiates a client
    try (AutoMlClient client = AutoMlClient.create()) {

      // Get the complete path of the dataset.
      DatasetName datasetFullId = DatasetName.of(projectId, computeRegion, datasetId);

      GcsSource.Builder gcsSource = GcsSource.newBuilder();

      // Get multiple Google Cloud Storage URIs to import data from
      String[] inputUris = path.split(",");
      for (String inputUri : inputUris) {
        gcsSource.addInputUris(inputUri);
      }

      // Import data from the input URI
      InputConfig inputConfig = InputConfig.newBuilder().setGcsSource(gcsSource).build();
      System.out.println("Processing import...");

      Empty response = client.importDataAsync(datasetFullId, inputConfig).get();
      System.out.println(String.format("Dataset imported. %s", response));
    }
  }
  // [END automl_translate_import_data]

  public static void main(String[] args) throws Exception {
    DatasetApi datasetApi = new DatasetApi();
    datasetApi.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser importDataParser = subparsers.addParser("import_data");
    importDataParser.addArgument("datasetId");
    importDataParser.addArgument("path");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("import_data")) {
        importData(projectId, computeRegion, ns.getString("datasetId"), ns.getString("path"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
