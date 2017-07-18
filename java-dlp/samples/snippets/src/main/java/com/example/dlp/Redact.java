/**
 * Copyright 2017, Google, Inc.
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

import com.google.cloud.dlp.v2beta1.DlpServiceClient;
import com.google.privacy.dlp.v2beta1.ContentItem;
import com.google.privacy.dlp.v2beta1.InfoType;
import com.google.privacy.dlp.v2beta1.InspectConfig;
import com.google.privacy.dlp.v2beta1.Likelihood;
import com.google.privacy.dlp.v2beta1.RedactContentRequest.ReplaceConfig;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.protobuf.ByteString;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Redact {

  private static void redactString(String string, String replacement, Likelihood minLikelihood,
      List<InfoType> infoTypes) throws Exception {
    // [START dlp_redact_string]
    // Instantiate the DLP client
    try (DlpServiceClient dlpClient = DlpServiceClient.create()) {
      // The minimum likelihood required before returning a match
      // eg.minLikelihood = LIKELIHOOD_VERY_LIKELY;
      InspectConfig inspectConfig = InspectConfig.newBuilder()
          .addAllInfoTypes(infoTypes)
          .setMinLikelihood(minLikelihood)
          .build();

      ContentItem contentItem = ContentItem.newBuilder()
          .setType("text/plain")
          .setData(ByteString.copyFrom(string.getBytes()))
          .build();

      List<ReplaceConfig> replaceConfigs = new ArrayList<>();

      if (infoTypes.isEmpty()) {
        // replace all detected sensitive elements with replacement string
        replaceConfigs.add(
            ReplaceConfig.newBuilder()
                .setReplaceWith(replacement)
                .build());
      } else {
        // Replace select info types with chosen replacement string
        for (InfoType infoType : infoTypes) {
          replaceConfigs.add(
              ReplaceConfig.newBuilder()
                  .setInfoType(infoType)
                  .setReplaceWith(replacement)
                  .build());
        }
      }

      RedactContentResponse contentResponse = dlpClient.redactContent(
          inspectConfig, Collections.singletonList(contentItem), replaceConfigs);
      for (ContentItem responseItem : contentResponse.getItemsList()) {
        // print out string with redacted content
        System.out.println(responseItem.getData().toStringUtf8());
      }
    }
    // [END dlp_redact_string]
  }

  // Command line application to redact strings using the Data Loss Prevention API
  public static void main(String[] args) throws Exception {
    Options commandLineOptions = new Options();

    Option stringOption = Option.builder("s")
        .longOpt("source string")
        .hasArg(true)
        .required(true)
        .build();
    commandLineOptions.addOption(stringOption);

    Option replaceOption = Option.builder("r")
        .longOpt("replace string")
        .hasArg(true)
        .required(true)
        .build();
    commandLineOptions.addOption(replaceOption);

    Option minLikelihoodOption = Option.builder("minLikelihood")
        .hasArg(true)
        .required(false)
        .build();
    commandLineOptions.addOption(minLikelihoodOption);

    Option infoTypesOption = Option.builder("infoTypes")
        .hasArg(true)
        .required(false)
        .build();
    infoTypesOption.setArgs(Option.UNLIMITED_VALUES);
    commandLineOptions.addOption(infoTypesOption);

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

    String source = cmd.getOptionValue(stringOption.getOpt());
    String replacement = cmd.getOptionValue(replaceOption.getOpt());

    List<InfoType> infoTypesList = new ArrayList<>();
    String[] infoTypes = cmd.getOptionValues(infoTypesOption.getOpt());
    if (infoTypes != null) {
      for (String infoType : infoTypes) {
        infoTypesList.add(InfoType.newBuilder().setName(infoType).build());
      }
    }
    redactString(source, replacement, Likelihood.LIKELIHOOD_UNSPECIFIED, infoTypesList);
  }
}
