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

package com.example.dlp;

import com.google.cloud.ServiceOptions;
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPage;
import com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectConfig.FindingLimits;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.Likelihood;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ProjectName;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Templates {

  // [START dlp_create_inspect_template]
  /**
   * Create a new DLP inspection configuration template.
   *
   * @param displayName (Optional) The human-readable name to give the template
   * @param projectId Google Cloud Project ID to call the API under
   * @param templateId (Optional) The name of the template to be created
   * @param infoTypeList The infoTypes of information to match
   * @param minLikelihood The minimum likelihood required before returning a match
   * @param maxFindings The maximum number of findings to report per request (0 = server maximum)
   */
  private static void createInspectTemplate(
      String displayName,
      String templateId,
      String description,
      String projectId,
      List<InfoType> infoTypeList,
      Likelihood minLikelihood,
      int maxFindings) {
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      FindingLimits findingLimits =
          FindingLimits.newBuilder().setMaxFindingsPerRequest(maxFindings).build();

      // Construct the inspection configuration for the template
      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypeList)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .build();

      InspectTemplate inspectTemplate =
          InspectTemplate.newBuilder()
              .setInspectConfig(inspectConfig)
              .setDisplayName(displayName)
              .setDescription(description)
              .build();

      CreateInspectTemplateRequest createInspectTemplateRequest =
          CreateInspectTemplateRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectTemplate(inspectTemplate)
              .setTemplateId(templateId)
              .build();

      InspectTemplate response =
          dlpServiceClient.createInspectTemplate(createInspectTemplateRequest);
      System.out.printf("Template created: %s", response.getName());
    } catch (Exception e) {
      System.out.printf("Error creating template: %s", e.getMessage());
    }
  }
  // [END dlp_create_inspect_template]

  // [START dlp_list_inspect_templates]
  /**
   * List DLP inspection templates created in a given project
   *
   * @param projectId Google Cloud Project ID
   */
  private static void listInspectTemplates(String projectId) {

    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      ListInspectTemplatesRequest request =
          ListInspectTemplatesRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setPageSize(1)
              .build();

      ListInspectTemplatesPagedResponse response = dlpServiceClient.listInspectTemplates(request);
      ListInspectTemplatesPage page = response.getPage();
      ListInspectTemplatesResponse templatesResponse = page.getResponse();

      for (InspectTemplate template : templatesResponse.getInspectTemplatesList()) {
        System.out.printf("Template name: %s\n", template.getName());
        if (template.getDisplayName() != null) {
          System.out.printf("\tDisplay name: %s \n", template.getDisplayName());
          System.out.printf("\tCreate time: %s \n", template.getCreateTime());
          System.out.printf("\tUpdate time: %s \n", template.getUpdateTime());

          // print inspection config
          InspectConfig inspectConfig = template.getInspectConfig();
          for (InfoType infoType : inspectConfig.getInfoTypesList()) {
            System.out.printf("\tInfoType: %s\n", infoType.getName());
          }
          System.out.printf("\tMin likelihood: %s\n", inspectConfig.getMinLikelihood());
          System.out.printf("\tLimits: %s\n", inspectConfig.getLimits().getMaxFindingsPerRequest());
        }
      }
    } catch (Exception e) {
      System.out.printf("Error creating template: %s", e.getMessage());
    }
  }
  // [END dlp_list_inspect_templates]

  // [START dlp_delete_inspect_template]
  /**
   * Delete the DLP inspection configuration template with the specified name.
   *
   * @param projectId Google Cloud Project ID
   * @param templateId Template ID to be deleted
   */
  private static void deleteInspectTemplate(String projectId, String templateId) {

    // construct the template name to be deleted
    String templateName = String.format("projects/%s/inspectTemplates/%s", projectId, templateId);
    // instantiate the client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // create delete template request
      DeleteInspectTemplateRequest request =
          DeleteInspectTemplateRequest.newBuilder().setName(templateName).build();

      dlpServiceClient.deleteInspectTemplate(request);
      System.out.printf("Deleted template: %s\n", templateName);
    } catch (Exception e) {
      System.err.printf("Error deleting template: %s\n", templateName);
    }
  }
  // [END dlp_delete_inspect_template]

  /** Command line application to create, list and delete DLP inspect templates. */
  public static void main(String[] args) throws Exception {

    OptionGroup optionsGroup = new OptionGroup();
    optionsGroup.setRequired(true);

    Option createOption = new Option("c", "create", false, "Create inspect template");
    optionsGroup.addOption(createOption);

    Option listOption = new Option("l", "list", false, "List inspect templates");
    optionsGroup.addOption(listOption);

    Option deleteOption = new Option("d", "delete", false, "Delete inspect template");
    optionsGroup.addOption(deleteOption);

    Options commandLineOptions = new Options();
    commandLineOptions.addOptionGroup(optionsGroup);

    Option projectIdOption = Option.builder("projectId").hasArg(true).required(false).build();
    commandLineOptions.addOption(projectIdOption);

    Option minLikelihoodOption =
        Option.builder("minLikelihood").hasArg(true).required(false).build();
    commandLineOptions.addOption(minLikelihoodOption);

    Option infoTypesOption = Option.builder("infoTypes").hasArg(true).required(false).build();
    infoTypesOption.setArgs(Option.UNLIMITED_VALUES);
    commandLineOptions.addOption(infoTypesOption);

    Option templateIdOption = Option.builder("templateId").hasArg(true).required(false).build();
    commandLineOptions.addOption(templateIdOption);

    Option templateDescription = Option.builder("description").hasArg(true).required(false).build();
    commandLineOptions.addOption(templateDescription);

    Option templateDisplayNameOption =
        Option.builder("displayName").hasArg(true).required(false).build();
    commandLineOptions.addOption(templateDisplayNameOption);

    Option includeQuoteOption = Option.builder("includeQuote").hasArg(true).required(false).build();
    commandLineOptions.addOption(includeQuoteOption);

    Option maxFindingsOption = Option.builder("maxFindings").hasArg(true).required(false).build();
    commandLineOptions.addOption(maxFindingsOption);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;

    try {
      cmd = parser.parse(commandLineOptions, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp("dlp_snippets", commandLineOptions);
      System.exit(1);
      return;
    }

    String projectId =
        cmd.getOptionValue(projectIdOption.getOpt(), ServiceOptions.getDefaultProjectId());

    if (cmd.hasOption(createOption.getOpt())) {
      String templateId = cmd.getOptionValue(templateIdOption.getOpt());
      String displayName = cmd.getOptionValue(templateDisplayNameOption.getOpt());
      String description = cmd.getOptionValue(templateDescription.getOpt());

      Likelihood minLikelihood =
          Likelihood.valueOf(
              cmd.getOptionValue(
                  minLikelihoodOption.getOpt(), Likelihood.LIKELIHOOD_UNSPECIFIED.name()));

      List<InfoType> infoTypesList = new ArrayList<>();
      String[] infoTypes = cmd.getOptionValues(infoTypesOption.getOpt());
      if (infoTypes != null) {
        for (String infoType : infoTypes) {
          infoTypesList.add(InfoType.newBuilder().setName(infoType).build());
        }
      }
      int maxFindings = Integer.valueOf(cmd.getOptionValue(maxFindingsOption.getOpt(), "0"));
      createInspectTemplate(
          displayName,
          templateId,
          description,
          projectId,
          infoTypesList,
          minLikelihood,
          maxFindings);

    } else if (cmd.hasOption(listOption.getOpt())) {
      listInspectTemplates(projectId);
    } else if (cmd.hasOption(deleteOption.getOpt())) {
      String templateId = cmd.getOptionValue(templateIdOption.getOpt());
      deleteInspectTemplate(projectId, templateId);
    }
  }
}
