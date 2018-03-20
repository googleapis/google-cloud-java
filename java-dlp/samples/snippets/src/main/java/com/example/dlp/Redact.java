/*
 * Copyright 2017 Google Inc.
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

package com.example.dlp;

import com.google.cloud.ServiceOptions;
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.Likelihood;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.protobuf.ByteString;
import java.io.FileOutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.activation.MimetypesFileTypeMap;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Redact {

  // [START dlp_redact_image]
  /*
   * Redact sensitive data from an image using the Data Loss Prevention API.
   *
   * @param filePath The path to a local file to inspect. Can be a JPG or PNG image file.
   * @param minLikelihood The minimum likelihood required before redacting a match.
   * @param infoTypes The infoTypes of information to redact.
   * @param outputPath The local path to save the resulting image to.
   * @param projectId The project ID to run the API call under.
   */
  private static void redactImage(
      String filePath,
      Likelihood minLikelihood,
      List<InfoType> infoTypes,
      String outputPath,
      String projectId)
      throws Exception {

    // Instantiate the DLP client
    try (DlpServiceClient dlpClient = DlpServiceClient.create()) {
      String mimeType = URLConnection.guessContentTypeFromName(filePath);
      if (mimeType == null) {
        mimeType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(filePath);
      }

      ByteContentItem.BytesType bytesType;
      switch (mimeType) {
        case "image/jpeg":
          bytesType = ByteContentItem.BytesType.IMAGE_JPEG;
          break;
        case "image/bmp":
          bytesType = ByteContentItem.BytesType.IMAGE_BMP;
          break;
        case "image/png":
          bytesType = ByteContentItem.BytesType.IMAGE_PNG;
          break;
        case "image/svg":
          bytesType = ByteContentItem.BytesType.IMAGE_SVG;
          break;
        default:
          bytesType = ByteContentItem.BytesType.BYTES_TYPE_UNSPECIFIED;
          break;
      }

      byte[] data = Files.readAllBytes(Paths.get(filePath));

      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .build();

      ByteContentItem byteContentItem =
          ByteContentItem.newBuilder()
              .setType(bytesType)
              .setData(ByteString.copyFrom(data))
              .build();

      List<RedactImageRequest.ImageRedactionConfig> imageRedactionConfigs =
          infoTypes
              .stream()
              .map(
                  infoType ->
                      RedactImageRequest.ImageRedactionConfig.newBuilder()
                          .setInfoType(infoType)
                          .build())
              .collect(Collectors.toList());

      RedactImageRequest redactImageRequest =
          RedactImageRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .addAllImageRedactionConfigs(imageRedactionConfigs)
              .setByteItem(byteContentItem)
              .setInspectConfig(inspectConfig)
              .build();

      RedactImageResponse redactImageResponse = dlpClient.redactImage(redactImageRequest);

      // redacted image data
      ByteString redactedImageData = redactImageResponse.getRedactedImage();
      FileOutputStream outputStream = new FileOutputStream(outputPath);
      outputStream.write(redactedImageData.toByteArray());
      outputStream.close();
    }
  }
  // [END dlp_redact_image]

  /** Command line application to redact strings, images using the Data Loss Prevention API. */
  public static void main(String[] args) throws Exception {

    Options commandLineOptions = new Options();

    Option minLikelihoodOption =
        Option.builder("minLikelihood").hasArg(true).required(false).build();

    commandLineOptions.addOption(minLikelihoodOption);

    Option infoTypesOption = Option.builder("infoTypes").hasArg(true).required(false).build();
    infoTypesOption.setArgs(Option.UNLIMITED_VALUES);
    commandLineOptions.addOption(infoTypesOption);

    Option inputFilePathOption =
        Option.builder("f").hasArg(true).longOpt("inputFilePath").required(false).build();
    commandLineOptions.addOption(inputFilePathOption);

    Option outputFilePathOption =
        Option.builder("o").hasArg(true).longOpt("outputFilePath").required(false).build();

    commandLineOptions.addOption(outputFilePathOption);

    Option projectIdOption = Option.builder("projectId").hasArg(true).required(false).build();
    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;

    try {
      cmd = parser.parse(commandLineOptions, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp(Redact.class.getName(), commandLineOptions);
      System.exit(1);
      return;
    }

    List<InfoType> infoTypesList = new ArrayList<>();
    String[] infoTypes = cmd.getOptionValues(infoTypesOption.getOpt());
    if (infoTypes != null) {
      for (String infoType : infoTypes) {
        infoTypesList.add(InfoType.newBuilder().setName(infoType).build());
      }
    }
    Likelihood minLikelihood =
        Likelihood.valueOf(
            cmd.getOptionValue(
                minLikelihoodOption.getOpt(), Likelihood.LIKELIHOOD_UNSPECIFIED.name()));

    String inputFilePath = cmd.getOptionValue(inputFilePathOption.getOpt());
    String outputFilePath = cmd.getOptionValue(outputFilePathOption.getOpt());
    String projectId =
        cmd.getOptionValue(projectIdOption.getOpt(), ServiceOptions.getDefaultProjectId());
    redactImage(inputFilePath, minLikelihood, infoTypesList, outputFilePath, projectId);
  }
}
