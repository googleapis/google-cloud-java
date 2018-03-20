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

import com.google.api.core.SettableApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.privacy.dlp.v2.Action;
import com.google.privacy.dlp.v2.BigQueryOptions;
import com.google.privacy.dlp.v2.BigQueryTable;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.CloudStorageOptions;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.DatastoreOptions;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.Finding;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InfoTypeStats;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectConfig.FindingLimits;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectDataSourceDetails;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.InspectResult;
import com.google.privacy.dlp.v2.KindExpression;
import com.google.privacy.dlp.v2.Likelihood;
import com.google.privacy.dlp.v2.PartitionId;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.StorageConfig;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.activation.MimetypesFileTypeMap;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Inspect {

  /**
   * [START dlp_inspect_string] Inspect a text for given InfoTypes
   *
   * @param string String to instpect
   * @param minLikelihood The minimum likelihood required before returning a match
   * @param maxFindings The maximum number of findings to report (0 = server maximum)
   * @param infoTypes The infoTypes of information to match
   * @param includeQuote Whether to include the matching string
   * @param projectId Google Cloud project ID
   */
  private static void inspectString(
      String string,
      Likelihood minLikelihood,
      int maxFindings,
      List<InfoType> infoTypes,
      boolean includeQuote,
      String projectId) {
    // instantiate a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      FindingLimits findingLimits =
          FindingLimits.newBuilder().setMaxFindingsPerRequest(maxFindings).build();
      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .setIncludeQuote(includeQuote)
              .build();

      ByteContentItem byteContentItem =
          ByteContentItem.newBuilder()
              .setType(ByteContentItem.BytesType.TEXT_UTF8)
              .setData(ByteString.copyFromUtf8(string))
              .build();

      ContentItem contentItem = ContentItem.newBuilder().setByteItem(byteContentItem).build();

      InspectContentRequest request =
          InspectContentRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectConfig(inspectConfig)
              .setItem(contentItem)
              .build();
      InspectContentResponse response = dlpServiceClient.inspectContent(request);

      if (response.getResult().getFindingsCount() > 0) {
        System.out.println("Findings: ");
        for (Finding finding : response.getResult().getFindingsList()) {
          if (includeQuote) {
            System.out.print("\tQuote: " + finding.getQuote());
          }
          System.out.print("\tInfo type: " + finding.getInfoType().getName());
          System.out.println("\tLikelihood: " + finding.getLikelihood());
        }
      } else {
        System.out.println("No findings.");
      }
    } catch (Exception e) {
      System.out.println("Error in inspectString: " + e.getMessage());
    }
  }
  // [END dlp_inspect_string]

  // [START dlp_inspect_file]
  /**
   * Inspect a local file
   *
   * @param filePath The path to a local file to inspect. Can be a text, JPG, or PNG file.
   * @param minLikelihood The minimum likelihood required before returning a match
   * @param maxFindings The maximum number of findings to report (0 = server maximum)
   * @param infoTypes The infoTypes of information to match
   * @param includeQuote Whether to include the matching string
   * @param projectId Google Cloud project ID
   */
  private static void inspectFile(
      String filePath,
      Likelihood minLikelihood,
      int maxFindings,
      List<InfoType> infoTypes,
      boolean includeQuote,
      String projectId) {
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // detect file mime type, default to application/octet-stream
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
      ByteContentItem byteContentItem =
          ByteContentItem.newBuilder()
              .setType(bytesType)
              .setData(ByteString.copyFrom(data))
              .build();
      ContentItem contentItem = ContentItem.newBuilder().setByteItem(byteContentItem).build();

      FindingLimits findingLimits =
          FindingLimits.newBuilder().setMaxFindingsPerRequest(maxFindings).build();

      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .setIncludeQuote(includeQuote)
              .build();

      InspectContentRequest request =
          InspectContentRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectConfig(inspectConfig)
              .setItem(contentItem)
              .build();

      InspectContentResponse response = dlpServiceClient.inspectContent(request);

      InspectResult result = response.getResult();
      if (result.getFindingsCount() > 0) {
        System.out.println("Findings: ");
        for (Finding finding : result.getFindingsList()) {
          if (includeQuote) {
            System.out.print("\tQuote: " + finding.getQuote());
          }
          System.out.print("\tInfo type: " + finding.getInfoType().getName());
          System.out.println("\tLikelihood: " + finding.getLikelihood());
        }
      } else {
        System.out.println("No findings.");
      }
    } catch (Exception e) {
      System.out.println("Error in inspectFile: " + e.getMessage());
    }
  }
  // [END dlp_inspect_file]

  // [START dlp_inspect_gcs]
  /**
   * Inspect GCS file for Info types and wait on job completion using Google Cloud Pub/Sub
   * notification
   *
   * @param bucketName The name of the bucket where the file resides.
   * @param fileName The path to the file within the bucket to inspect (can include wildcards, eg.
   *     my-image.*)
   * @param minLikelihood The minimum likelihood required before returning a match
   * @param infoTypes The infoTypes of information to match
   * @param maxFindings The maximum number of findings to report (0 = server maximum)
   * @param topicId Google Cloud Pub/Sub topic Id to notify of job status
   * @param subscriptionId Google Cloud Subscription to above topic to listen for job status updates
   * @param projectId Google Cloud project ID
   */
  private static void inspectGcsFile(
      String bucketName,
      String fileName,
      Likelihood minLikelihood,
      List<InfoType> infoTypes,
      int maxFindings,
      String topicId,
      String subscriptionId,
      String projectId)
      throws Exception {
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      CloudStorageOptions cloudStorageOptions =
          CloudStorageOptions.newBuilder()
              .setFileSet(
                  CloudStorageOptions.FileSet.newBuilder()
                      .setUrl("gs://" + bucketName + "/" + fileName))
              .build();

      StorageConfig storageConfig =
          StorageConfig.newBuilder().setCloudStorageOptions(cloudStorageOptions).build();

      FindingLimits findingLimits =
          FindingLimits.newBuilder().setMaxFindingsPerRequest(maxFindings).build();

      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .build();

      String pubSubTopic = String.format("projects/%s/topics/%s", projectId, topicId);
      Action.PublishToPubSub publishToPubSub =
          Action.PublishToPubSub.newBuilder().setTopic(pubSubTopic).build();

      Action action = Action.newBuilder().setPubSub(publishToPubSub).build();

      InspectJobConfig inspectJobConfig =
          InspectJobConfig.newBuilder()
              .setStorageConfig(storageConfig)
              .setInspectConfig(inspectConfig)
              .addActions(action)
              .build();

      // Semi-synchronously submit an inspect job, and wait on results
      CreateDlpJobRequest createDlpJobRequest =
          CreateDlpJobRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectJob(inspectJobConfig)
              .build();

      DlpJob dlpJob = dlpServiceClient.createDlpJob(createDlpJobRequest);

      System.out.println("Job created with ID:" + dlpJob.getName());

      final SettableApiFuture<Boolean> done = SettableApiFuture.create();

      // Set up a Pub/Sub subscriber to listen on the job completion status
      Subscriber subscriber =
          Subscriber.newBuilder(
                  ProjectSubscriptionName.of(projectId, subscriptionId),
            (pubsubMessage, ackReplyConsumer) -> {
              if (pubsubMessage.getAttributesCount() > 0
                  && pubsubMessage
                      .getAttributesMap()
                      .get("DlpJobName")
                      .equals(dlpJob.getName())) {
                // notify job completion
                done.set(true);
                ackReplyConsumer.ack();
              }
            })
              .build();
      subscriber.startAsync();

      // Wait for job completion semi-synchronously
      // For long jobs, consider using a truly asynchronous execution model such as Cloud Functions
      try {
        done.get(1, TimeUnit.MINUTES);
        Thread.sleep(500); // Wait for the job to become available
      } catch (Exception e) {
        System.out.println("Unable to verify job completion.");
      }

      DlpJob completedJob =
          dlpServiceClient.getDlpJob(
              GetDlpJobRequest.newBuilder().setName(dlpJob.getName()).build());

      System.out.println("Job status: " + completedJob.getState());
      InspectDataSourceDetails inspectDataSourceDetails = completedJob.getInspectDetails();
      InspectDataSourceDetails.Result result = inspectDataSourceDetails.getResult();
      if (result.getInfoTypeStatsCount() > 0) {
        System.out.println("Findings: ");
        for (InfoTypeStats infoTypeStat : result.getInfoTypeStatsList()) {
          System.out.print("\tInfo type: " + infoTypeStat.getInfoType().getName());
          System.out.println("\tCount: " + infoTypeStat.getCount());
        }
      } else {
        System.out.println("No findings.");
      }
    }
  }
  // [END dlp_inspect_gcs]

  // [START dlp_inspect_datastore]
  /**
   * Inspect a Datastore kind
   *
   * @param projectId The project ID containing the target Datastore
   * @param namespaceId The ID namespace of the Datastore document to inspect
   * @param kind The kind of the Datastore entity to inspect
   * @param minLikelihood The minimum likelihood required before returning a match
   * @param infoTypes The infoTypes of information to match
   * @param maxFindings max number of findings
   * @param topicId Google Cloud Pub/Sub topic to notify job status updates
   * @param subscriptionId Google Cloud Pub/Sub subscription to above topic to receive status
   *     updates
   */
  private static void inspectDatastore(
      String projectId,
      String namespaceId,
      String kind,
      Likelihood minLikelihood,
      List<InfoType> infoTypes,
      int maxFindings,
      String topicId,
      String subscriptionId) {
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // Reference to the Datastore namespace
      PartitionId partitionId =
          PartitionId.newBuilder().setProjectId(projectId).setNamespaceId(namespaceId).build();

      // Reference to the Datastore kind
      KindExpression kindExpression = KindExpression.newBuilder().setName(kind).build();
      DatastoreOptions datastoreOptions =
          DatastoreOptions.newBuilder().setKind(kindExpression).setPartitionId(partitionId).build();

      // Construct Datastore configuration to be inspected
      StorageConfig storageConfig =
          StorageConfig.newBuilder().setDatastoreOptions(datastoreOptions).build();

      FindingLimits findingLimits =
          FindingLimits.newBuilder().setMaxFindingsPerRequest(maxFindings).build();

      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .build();

      String pubSubTopic = String.format("projects/%s/topics/%s", projectId, topicId);
      Action.PublishToPubSub publishToPubSub =
          Action.PublishToPubSub.newBuilder().setTopic(pubSubTopic).build();

      Action action = Action.newBuilder().setPubSub(publishToPubSub).build();

      InspectJobConfig inspectJobConfig =
          InspectJobConfig.newBuilder()
              .setStorageConfig(storageConfig)
              .setInspectConfig(inspectConfig)
              .addActions(action)
              .build();

      // Asynchronously submit an inspect job, and wait on results
      CreateDlpJobRequest createDlpJobRequest =
          CreateDlpJobRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectJob(inspectJobConfig)
              .build();

      DlpJob dlpJob = dlpServiceClient.createDlpJob(createDlpJobRequest);

      System.out.println("Job created with ID:" + dlpJob.getName());

      final SettableApiFuture<Boolean> done = SettableApiFuture.create();

      // Set up a Pub/Sub subscriber to listen on the job completion status
      Subscriber subscriber =
          Subscriber.newBuilder(
                  ProjectSubscriptionName.of(projectId, subscriptionId),
            (pubsubMessage, ackReplyConsumer) -> {
              if (pubsubMessage.getAttributesCount() > 0
                  && pubsubMessage
                      .getAttributesMap()
                      .get("DlpJobName")
                      .equals(dlpJob.getName())) {
                // notify job completion
                done.set(true);
                ackReplyConsumer.ack();
              }
            })
              .build();
      subscriber.startAsync();

      // Wait for job completion semi-synchronously
      // For long jobs, consider using a truly asynchronous execution model such as Cloud Functions
      try {
        done.get(1, TimeUnit.MINUTES);
        Thread.sleep(500); // Wait for the job to become available
      } catch (Exception e) {
        System.out.println("Unable to verify job completion.");
      }

      DlpJob completedJob =
          dlpServiceClient.getDlpJob(
              GetDlpJobRequest.newBuilder().setName(dlpJob.getName()).build());

      System.out.println("Job status: " + completedJob.getState());
      InspectDataSourceDetails inspectDataSourceDetails = completedJob.getInspectDetails();
      InspectDataSourceDetails.Result result = inspectDataSourceDetails.getResult();
      if (result.getInfoTypeStatsCount() > 0) {
        System.out.println("Findings: ");
        for (InfoTypeStats infoTypeStat : result.getInfoTypeStatsList()) {
          System.out.print("\tInfo type: " + infoTypeStat.getInfoType().getName());
          System.out.println("\tCount: " + infoTypeStat.getCount());
        }
      } else {
        System.out.println("No findings.");
      }
    } catch (Exception e) {
      System.out.println("inspectDatastore Problems: " + e.getMessage());
    }
  }
  // [END dlp_inspect_datastore]

  // [START dlp_inspect_bigquery]
  /**
   * Inspect a BigQuery table
   *
   * @param projectId The project ID to run the API call under
   * @param datasetId The ID of the dataset to inspect, e.g. 'my_dataset'
   * @param tableId The ID of the table to inspect, e.g. 'my_table'
   * @param minLikelihood The minimum likelihood required before returning a match
   * @param infoTypes The infoTypes of information to match
   * @param maxFindings The maximum number of findings to report (0 = server maximum)
   * @param topicId Topic ID for pubsub.
   * @param subscriptionId Subscription ID for pubsub.
   */
  private static void inspectBigquery(
      String projectId,
      String datasetId,
      String tableId,
      Likelihood minLikelihood,
      List<InfoType> infoTypes,
      int maxFindings,
      String topicId,
      String subscriptionId) {
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // Reference to the BigQuery table
      BigQueryTable tableReference =
          BigQueryTable.newBuilder()
              .setProjectId(projectId)
              .setDatasetId(datasetId)
              .setTableId(tableId)
              .build();
      BigQueryOptions bigQueryOptions =
          BigQueryOptions.newBuilder().setTableReference(tableReference).build();

      // Construct BigQuery configuration to be inspected
      StorageConfig storageConfig =
          StorageConfig.newBuilder().setBigQueryOptions(bigQueryOptions).build();

      FindingLimits findingLimits =
          FindingLimits.newBuilder().setMaxFindingsPerRequest(maxFindings).build();

      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .build();

      ProjectTopicName topic = ProjectTopicName.of(projectId, topicId);
      Action.PublishToPubSub publishToPubSub =
          Action.PublishToPubSub.newBuilder().setTopic(topic.toString()).build();

      Action action = Action.newBuilder().setPubSub(publishToPubSub).build();

      InspectJobConfig inspectJobConfig =
          InspectJobConfig.newBuilder()
              .setStorageConfig(storageConfig)
              .setInspectConfig(inspectConfig)
              .addActions(action)
              .build();

      // Asynchronously submit an inspect job, and wait on results
      CreateDlpJobRequest createDlpJobRequest =
          CreateDlpJobRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectJob(inspectJobConfig)
              .build();

      DlpJob dlpJob = dlpServiceClient.createDlpJob(createDlpJobRequest);

      System.out.println("Job created with ID:" + dlpJob.getName());

      // Wait for job completion semi-synchronously
      // For long jobs, consider using a truly asynchronous execution model such as Cloud Functions
      final SettableApiFuture<Boolean> done = SettableApiFuture.create();

      // Set up a Pub/Sub subscriber to listen on the job completion status
      Subscriber subscriber =
          Subscriber.newBuilder(
                  ProjectSubscriptionName.of(projectId, subscriptionId),
            (pubsubMessage, ackReplyConsumer) -> {
              if (pubsubMessage.getAttributesCount() > 0
                  && pubsubMessage
                      .getAttributesMap()
                      .get("DlpJobName")
                      .equals(dlpJob.getName())) {
                // notify job completion
                done.set(true);
                ackReplyConsumer.ack();
              }
            })
              .build();
      subscriber.startAsync();

      try {
        done.get(1, TimeUnit.MINUTES);
        Thread.sleep(500); // Wait for the job to become available
      } catch (Exception e) {
        System.out.println("Unable to verify job completion.");
      }

      DlpJob completedJob =
          dlpServiceClient.getDlpJob(
              GetDlpJobRequest.newBuilder().setName(dlpJob.getName()).build());

      System.out.println("Job status: " + completedJob.getState());
      InspectDataSourceDetails inspectDataSourceDetails = completedJob.getInspectDetails();
      InspectDataSourceDetails.Result result = inspectDataSourceDetails.getResult();
      if (result.getInfoTypeStatsCount() > 0) {
        System.out.println("Findings: ");
        for (InfoTypeStats infoTypeStat : result.getInfoTypeStatsList()) {
          System.out.print("\tInfo type: " + infoTypeStat.getInfoType().getName());
          System.out.println("\tCount: " + infoTypeStat.getCount());
        }
      } else {
        System.out.println("No findings.");
      }
    } catch (Exception e) {
      System.out.println("inspectBigquery Problems: " + e.getMessage());
    }
  }
  // [END dlp_inspect_bigquery]

  /**
   * Command line application to inspect data using the Data Loss Prevention API. Supported data
   * formats: string, file, text file on GCS, BigQuery table, and Datastore entity
   */
  public static void main(String[] args) throws Exception {

    OptionGroup optionsGroup = new OptionGroup();
    optionsGroup.setRequired(true);
    Option stringOption = new Option("s", "string", true, "inspect string");
    optionsGroup.addOption(stringOption);

    Option fileOption = new Option("f", "file path", true, "inspect input file path");
    optionsGroup.addOption(fileOption);

    Option gcsOption = new Option("gcs", "Google Cloud Storage", false, "inspect GCS file");
    optionsGroup.addOption(gcsOption);

    Option datastoreOption = new Option("ds", "Google Datastore", false, "inspect Datastore kind");
    optionsGroup.addOption(datastoreOption);

    Option bigqueryOption = new Option("bq", "Google BigQuery", false, "inspect BigQuery table");
    optionsGroup.addOption(bigqueryOption);

    Options commandLineOptions = new Options();
    commandLineOptions.addOptionGroup(optionsGroup);

    Option minLikelihoodOption =
        Option.builder("minLikelihood").hasArg(true).required(false).build();

    commandLineOptions.addOption(minLikelihoodOption);

    Option maxFindingsOption = Option.builder("maxFindings").hasArg(true).required(false).build();

    commandLineOptions.addOption(maxFindingsOption);

    Option infoTypesOption = Option.builder("infoTypes").hasArg(true).required(false).build();
    infoTypesOption.setArgs(Option.UNLIMITED_VALUES);
    commandLineOptions.addOption(infoTypesOption);

    Option includeQuoteOption = Option.builder("includeQuote").hasArg(true).required(false).build();
    commandLineOptions.addOption(includeQuoteOption);

    Option bucketNameOption = Option.builder("bucketName").hasArg(true).required(false).build();
    commandLineOptions.addOption(bucketNameOption);

    Option gcsFileNameOption = Option.builder("fileName").hasArg(true).required(false).build();
    commandLineOptions.addOption(gcsFileNameOption);

    Option datasetIdOption = Option.builder("datasetId").hasArg(true).required(false).build();
    commandLineOptions.addOption(datasetIdOption);

    Option tableIdOption = Option.builder("tableId").hasArg(true).required(false).build();
    commandLineOptions.addOption(tableIdOption);

    Option projectIdOption = Option.builder("projectId").hasArg(true).required(false).build();
    commandLineOptions.addOption(projectIdOption);

    Option topicIdOption = Option.builder("topicId").hasArg(true).required(false).build();
    commandLineOptions.addOption(topicIdOption);

    Option subscriptionIdOption =
        Option.builder("subscriptionId").hasArg(true).required(false).build();
    commandLineOptions.addOption(subscriptionIdOption);

    Option datastoreNamespaceOption =
        Option.builder("namespace").hasArg(true).required(false).build();
    commandLineOptions.addOption(datastoreNamespaceOption);

    Option datastoreKindOption = Option.builder("kind").hasArg(true).required(false).build();
    commandLineOptions.addOption(datastoreKindOption);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;

    try {
      cmd = parser.parse(commandLineOptions, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp(Inspect.class.getName(), commandLineOptions);
      System.exit(1);
      return;
    }

    Likelihood minLikelihood =
        Likelihood.valueOf(
            cmd.getOptionValue(
                minLikelihoodOption.getOpt(), Likelihood.LIKELIHOOD_UNSPECIFIED.name()));
    int maxFindings = Integer.parseInt(cmd.getOptionValue(maxFindingsOption.getOpt(), "0"));
    boolean includeQuote =
        Boolean.parseBoolean(cmd.getOptionValue(includeQuoteOption.getOpt(), "true"));

    String projectId =
        cmd.getOptionValue(projectIdOption.getOpt(), ServiceOptions.getDefaultProjectId());
    String topicId = cmd.getOptionValue(topicIdOption.getOpt());
    String subscriptionId = cmd.getOptionValue(subscriptionIdOption.getOpt());

    List<InfoType> infoTypesList = Collections.emptyList();
    if (cmd.hasOption(infoTypesOption.getOpt())) {
      infoTypesList = new ArrayList<>();
      String[] infoTypes = cmd.getOptionValues(infoTypesOption.getOpt());
      for (String infoType : infoTypes) {
        infoTypesList.add(InfoType.newBuilder().setName(infoType).build());
      }
    }
    // string inspection
    if (cmd.hasOption("s")) {
      String val = cmd.getOptionValue(stringOption.getOpt());
      inspectString(val, minLikelihood, maxFindings, infoTypesList, includeQuote, projectId);
    } else if (cmd.hasOption("f")) {
      String filePath = cmd.getOptionValue(fileOption.getOpt());
      inspectFile(filePath, minLikelihood, maxFindings, infoTypesList, includeQuote, projectId);
      // gcs file inspection
    } else if (cmd.hasOption("gcs")) {
      String bucketName = cmd.getOptionValue(bucketNameOption.getOpt());
      String fileName = cmd.getOptionValue(gcsFileNameOption.getOpt());
      inspectGcsFile(
          bucketName,
          fileName,
          minLikelihood,
          infoTypesList,
          maxFindings,
          topicId,
          subscriptionId,
          projectId);
      // datastore kind inspection
    } else if (cmd.hasOption("ds")) {
      String namespaceId = cmd.getOptionValue(datastoreNamespaceOption.getOpt(), "");
      String kind = cmd.getOptionValue(datastoreKindOption.getOpt());
      // use default project id when project id is not specified
      inspectDatastore(
          projectId,
          namespaceId,
          kind,
          minLikelihood,
          infoTypesList,
          maxFindings,
          topicId,
          subscriptionId);
    } else if (cmd.hasOption("bq")) {
      String datasetId = cmd.getOptionValue(datasetIdOption.getOpt());
      String tableId = cmd.getOptionValue(tableIdOption.getOpt());
      // use default project id when project id is not specified
      inspectBigquery(
          projectId,
          datasetId,
          tableId,
          minLikelihood,
          infoTypesList,
          maxFindings,
          topicId,
          subscriptionId);
    }
  }
}
