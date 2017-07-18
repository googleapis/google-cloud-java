/**
 * Copyright 2017, Google, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dlp;

import com.google.cloud.dlp.v2beta1.DlpServiceClient;
import com.google.privacy.dlp.v2beta1.CategoryDescription;
import com.google.privacy.dlp.v2beta1.InfoTypeDescription;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.List;

public class Metadata {

  private static void listInfoTypes(String category, String languageCode) throws Exception {
    // [START dlp_list_info_types]
    // Instantiate a DLP client
    try (DlpServiceClient dlpClient = DlpServiceClient.create()) {
      // The category of info types to list, e.g. category = 'GOVERNMENT';
      // Optional BCP-47 language code for localized info type friendly names, e.g. 'en-US'
      ListInfoTypesResponse infoTypesResponse = dlpClient.listInfoTypes(category, languageCode);
      List<InfoTypeDescription> infoTypeDescriptions = infoTypesResponse.getInfoTypesList();
      for (InfoTypeDescription infoTypeDescription : infoTypeDescriptions) {
        System.out.println("Name : " + infoTypeDescription.getName());
        System.out.println("Display name : " + infoTypeDescription.getDisplayName());
      }
    }
    // [END dlp_list_info_types]
  }

  private static void listRootCategories(String languageCode) throws Exception {
    // [START dlp_list_root_categories]
    // Instantiate a DLP client
    try (DlpServiceClient dlpClient = DlpServiceClient.create()) {
      // The BCP-47 language code to use, e.g. 'en-US'
      // languageCode = 'en-US'
      ListRootCategoriesResponse rootCategoriesResponse = dlpClient
          .listRootCategories(languageCode);
      for (CategoryDescription categoryDescription : rootCategoriesResponse.getCategoriesList()) {
        System.out.println("Name : " + categoryDescription.getName());
        System.out.println("Display name : " + categoryDescription.getDisplayName());
      }
    }
    // [END dlp_list_root_categories]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    Option languageCodeOption = new Option("language", null, true, "BCP-47 language code");
    languageCodeOption.setRequired(false);
    options.addOption(languageCodeOption);

    Option categoryOption = new Option("category", null, true, "Category of info types to list.");
    categoryOption.setRequired(false);
    options.addOption(categoryOption);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;
    try {
      cmd = parser.parse(options, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp(Metadata.class.getName(), options);
      System.exit(1);
      return;
    }
    String languageCode = cmd.getOptionValue(languageCodeOption.getOpt(), "en-US");
    if (cmd.hasOption(categoryOption.getOpt())) {
      String category = cmd.getOptionValue(categoryOption.getOpt());
      listInfoTypes(category, languageCode);
    } else {
      listRootCategories(languageCode);
    }
  }
}
