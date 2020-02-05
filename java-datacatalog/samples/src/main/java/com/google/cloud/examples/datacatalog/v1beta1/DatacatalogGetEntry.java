/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// DO NOT EDIT! This is a generated sample ("Request",  "datacatalog_get_entry")
// sample-metadata:
//   title:
//   description: Get Entry
//   usage: gradle run -PmainClass=com.google.cloud.examples.datacatalog.v1beta1.DatacatalogGetEntry
// [--args='[--project_id "[Google Cloud Project ID]"] [--location_id "[Google Cloud Location ID]"]
// [--entry_group_id "[Entry Group ID]"] [--entry_id "[Entry ID]"]']

package com.google.cloud.examples.datacatalog.v1beta1;

import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import com.google.cloud.datacatalog.v1beta1.Entry;
import com.google.cloud.datacatalog.v1beta1.GetEntryRequest;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class DatacatalogGetEntry {
  // [START datacatalog_get_entry]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
   * import com.google.cloud.datacatalog.v1beta1.Entry;
   * import com.google.cloud.datacatalog.v1beta1.GetEntryRequest;
   */

  public static void sampleGetEntry() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "[Google Cloud Project ID]";
    String locationId = "[Google Cloud Location ID]";
    String entryGroupId = "[Entry Group ID]";
    String entryId = "[Entry ID]";
    sampleGetEntry(projectId, locationId, entryGroupId, entryId);
  }

  /**
   * Get Entry
   *
   * @param projectId Your Google Cloud project ID
   * @param locationId Google Cloud region, e.g. us-central1
   * @param entryGroupId ID of the Entry Group, e.g. {@literal @}bigquery, {@literal @}pubsub,
   *     my_entry_group
   * @param entryId ID of the Entry
   */
  public static void sampleGetEntry(
      String projectId, String locationId, String entryGroupId, String entryId) {
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      String formattedName =
          DataCatalogClient.formatEntryName(projectId, locationId, entryGroupId, entryId);
      GetEntryRequest request = GetEntryRequest.newBuilder().setName(formattedName).build();
      Entry response = dataCatalogClient.getEntry(request);
      Entry entry = response;
      System.out.printf("Entry name: %s\n", entry.getName());
      System.out.printf("Entry type: %s\n", entry.getType());
      System.out.printf("Linked resource: %s\n", entry.getLinkedResource());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END datacatalog_get_entry]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("location_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("entry_group_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("entry_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "[Google Cloud Project ID]");
    String locationId = cl.getOptionValue("location_id", "[Google Cloud Location ID]");
    String entryGroupId = cl.getOptionValue("entry_group_id", "[Entry Group ID]");
    String entryId = cl.getOptionValue("entry_id", "[Entry ID]");

    sampleGetEntry(projectId, locationId, entryGroupId, entryId);
  }
}
