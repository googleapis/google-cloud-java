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

import com.google.api.gax.rpc.OperationFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.dlp.v2beta1.DlpServiceClient;
import com.google.longrunning.Operation;
import com.google.privacy.dlp.v2beta1.CloudStorageOptions;
import com.google.privacy.dlp.v2beta1.CloudStorageOptions.FileSet;
import com.google.privacy.dlp.v2beta1.ContentItem;
import com.google.privacy.dlp.v2beta1.DatastoreOptions;
import com.google.privacy.dlp.v2beta1.Finding;
import com.google.privacy.dlp.v2beta1.InfoType;
import com.google.privacy.dlp.v2beta1.InspectConfig;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.InspectResult;
import com.google.privacy.dlp.v2beta1.KindExpression;
import com.google.privacy.dlp.v2beta1.Likelihood;
import com.google.privacy.dlp.v2beta1.OutputStorageConfig;
import com.google.privacy.dlp.v2beta1.PartitionId;
import com.google.privacy.dlp.v2beta1.ResultName;
import com.google.privacy.dlp.v2beta1.StorageConfig;
import com.google.protobuf.ByteString;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;

public class Inspect {

  private static void inspectString(String string, Likelihood minLikelihood, int maxFindings,
      List<InfoType> infoTypes, boolean includeQuote) {
    // [START dlp_inspect_string]
    // instantiate a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // The minimum likelihood required before returning a match
      // minLikelihood = LIKELIHOOD_UNSPECIFIED;

      // The maximum number of findings to report (0 = server maximum)
      // maxFindings = 0;

      // The infoTypes of information to match
      // infoTypes = ['US_MALE_NAME', 'US_FEMALE_NAME'];

      // Whether to include the matching string
      // includeQuote = true;
      InspectConfig inspectConfig = InspectConfig.newBuilder()
          .addAllInfoTypes(infoTypes)
          .setMinLikelihood(minLikelihood)
          .setMaxFindings(maxFindings)
          .setIncludeQuote(includeQuote)
          .build();

      // The string to inspect
      // string = 'My name is Gary and my email is gary@example.com';
      ContentItem contentItem = ContentItem.newBuilder()
          .setType("text/plain")
          .setValue(string)
          .build();

      InspectContentRequest request = InspectContentRequest.newBuilder()
          .setInspectConfig(inspectConfig)
          .addItems(contentItem)
          .build();
      InspectContentResponse response = dlpServiceClient.inspectContent(request);

      for (InspectResult result : response.getResultsList()) {
        if (result.getFindingsCount() > 0) {
          System.out.println("Findings: ");
          for (Finding finding : result.getFindingsList()) {
            if (includeQuote) {
              System.out.print("Quote: " + finding.getQuote());
            }
            System.out.print("\tInfo type: " + finding.getInfoType().getName());
            System.out.println("\tLikelihood: " + finding.getLikelihood());
          }
        } else {
          System.out.println("No findings.");
        }
      }
    } catch (Exception e) {
      System.out.println("Error in inspectString: " + e.getMessage());
    }
    // [END dlp_inspect_string]
  }

  private static void inspectFile(String filePath, Likelihood minLikelihood, int maxFindings,
      List<InfoType> infoTypes, boolean includeQuote) {
    // [START dlp_inspect_file]
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // The path to a local file to inspect. Can be a text, JPG, or PNG file.
      // fileName = 'path/to/image.png';

      // The minimum likelihood required before returning a match
      // minLikelihood = LIKELIHOOD_UNSPECIFIED;

      // The maximum number of findings to report (0 = server maximum)
      // maxFindings = 0;

      // The infoTypes of information to match
      // infoTypes = ['US_MALE_NAME', 'US_FEMALE_NAME'];

      // Whether to include the matching string
      // includeQuote = true;
      Path path = Paths.get(filePath);

      // detect file mime type, default to application/octet-stream
      String mimeType = URLConnection.guessContentTypeFromName(filePath);
      if (mimeType == null) {
        mimeType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(filePath);
      }
      if (mimeType == null) {
        mimeType = "application/octet-stream";
      }

      byte[] data = Files.readAllBytes(path);
      ContentItem contentItem = ContentItem.newBuilder()
          .setType(mimeType)
          .setData(ByteString.copyFrom(data))
          .build();

      InspectConfig inspectConfig = InspectConfig.newBuilder()
          .addAllInfoTypes(infoTypes)
          .setMinLikelihood(minLikelihood)
          .setMaxFindings(maxFindings)
          .setIncludeQuote(includeQuote)
          .build();

      InspectContentRequest request = InspectContentRequest.newBuilder()
          .setInspectConfig(inspectConfig)
          .addItems(contentItem)
          .build();
      InspectContentResponse response = dlpServiceClient.inspectContent(request);

      for (InspectResult result : response.getResultsList()) {
        if (result.getFindingsCount() > 0) {
          System.out.println("Findings: ");
          for (Finding finding : result.getFindingsList()) {
            if (includeQuote) {
              System.out.print("Quote: " + finding.getQuote());
            }
            System.out.print("\tInfo type: " + finding.getInfoType().getName());
            System.out.println("\tLikelihood: " + finding.getLikelihood());
          }
        } else {
          System.out.println("No findings.");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error in inspectFile: " + e.getMessage());
    }
    // [END dlp_inspect_file]
  }

  private static void inspectGcsFile(String bucketName, String fileName,
      Likelihood minLikelihood, List<InfoType> infoTypes)
      throws Exception {
    // [START dlp_inspect_gcs]
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
// The name of the bucket where the file resides.
      // bucketName = 'YOUR-BUCKET';

      // The path to the file within the bucket to inspect.
      // Can contain wildcards, e.g. "my-image.*"
      // fileName = 'my-image.png';

      // The minimum likelihood required before returning a match
      // minLikelihood = LIKELIHOOD_UNSPECIFIED;

      // The maximum number of findings to report (0 = server maximum)
      // maxFindings = 0;

      // The infoTypes of information to match
      // infoTypes = ['US_MALE_NAME', 'US_FEMALE_NAME'];

      CloudStorageOptions cloudStorageOptions = CloudStorageOptions
          .newBuilder()
          .setFileSet(FileSet.newBuilder().setUrl(
              "gs://" + bucketName + "/" + fileName
          ))
          .build();

      StorageConfig storageConfig = StorageConfig.newBuilder()
          .setCloudStorageOptions(cloudStorageOptions)
          .build();

      InspectConfig inspectConfig = InspectConfig.newBuilder()
          .addAllInfoTypes(infoTypes)
          .setMinLikelihood(minLikelihood)
          .build();

      // optionally provide an output configuration to store results, default : none
      OutputStorageConfig outputConfig = OutputStorageConfig.getDefaultInstance();

      // asynchronously submit an inspect operation
      OperationFuture<InspectOperationResult, InspectOperationMetadata, Operation> responseFuture =
          dlpServiceClient.createInspectOperationAsync(inspectConfig, storageConfig, outputConfig);

      // ...
      // block on response, returning job id of the operation
      InspectOperationResult inspectOperationResult = responseFuture.get();
      ResultName resultName = inspectOperationResult.getNameAsResultName();
      InspectResult inspectResult = dlpServiceClient.listInspectFindings(resultName).getResult();

      if (inspectResult.getFindingsCount() > 0) {
        System.out.println("Findings: ");
        for (Finding finding : inspectResult.getFindingsList()) {
          System.out.print("\tInfo type: " + finding.getInfoType().getName());
          System.out.println("\tLikelihood: " + finding.getLikelihood());
        }
      } else {
        System.out.println("No findings.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error in inspectGCSFileAsync: " + e.getMessage());
    }
    // [END dlp_inspect_gcs]
  }

  private static void inspectDatastore(String projectId, String namespaceId, String kind,
      Likelihood minLikelihood, List<InfoType> infoTypes) {
    // [START dlp_inspect_datastore]
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // (Optional) The project ID containing the target Datastore
      // projectId =  my-project-id

      // (Optional) The ID namespace of the Datastore document to inspect.
      // To ignore Datastore namespaces, set this to an empty string ('')
      // namespaceId = '';

      // The kind of the Datastore entity to inspect.
      // kind = 'Person';

      // The minimum likelihood required before returning a match
      // minLikelihood = LIKELIHOOD_UNSPECIFIED;

      // The infoTypes of information to match
      // infoTypes = ['US_MALE_NAME', 'US_FEMALE_NAME'];

      // Get reference to the file to be inspected
      PartitionId partitionId = PartitionId.newBuilder().setProjectId(projectId)
          .setNamespaceId(namespaceId).build();
      KindExpression kindExpression = KindExpression.newBuilder().setName(kind).build();
      DatastoreOptions datastoreOptions = DatastoreOptions.newBuilder()
          .setKind(kindExpression).setPartitionId(partitionId).build();
      StorageConfig storageConfig = StorageConfig.newBuilder()
          .setDatastoreOptions(datastoreOptions).build();

      InspectConfig inspectConfig = InspectConfig.newBuilder()
          .addAllInfoTypes(infoTypes)
          .setMinLikelihood(minLikelihood)
          .build();

      // optionally provide an output configuration to store results, default : none
      OutputStorageConfig outputConfig = OutputStorageConfig.getDefaultInstance();

      // asynchronously submit an inspect operation
      OperationFuture<InspectOperationResult, InspectOperationMetadata, Operation> responseFuture =
          dlpServiceClient.createInspectOperationAsync(inspectConfig, storageConfig, outputConfig);

      // ...
      // block on response, returning job id of the operation
      InspectOperationResult inspectOperationResult = responseFuture.get();
      ResultName resultName = inspectOperationResult.getNameAsResultName();
      InspectResult inspectResult = dlpServiceClient.listInspectFindings(resultName).getResult();

      if (inspectResult.getFindingsCount() > 0) {
        System.out.println("Findings: ");
        for (Finding finding : inspectResult.getFindingsList()) {
          System.out.print("\tInfo type: " + finding.getInfoType().getName());
          System.out.println("\tLikelihood: " + finding.getLikelihood());
        }
      } else {
        System.out.println("No findings.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error in inspectDatastore: " + e.getMessage());
    }
    // [END dlp_inspect_datastore]
  }

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

    Options commandLineOptions = new Options();
    commandLineOptions.addOptionGroup(optionsGroup);

    Option minLikelihoodOption = Option.builder("minLikelihood")
        .hasArg(true)
        .required(false)
        .build();

    commandLineOptions.addOption(minLikelihoodOption);

    Option maxFindingsOption = Option.builder("maxFindings")
        .hasArg(true)
        .required(false)
        .build();

    commandLineOptions.addOption(maxFindingsOption);

    Option infoTypesOption = Option.builder("infoTypes")
        .hasArg(true)
        .required(false)
        .build();
    infoTypesOption.setArgs(Option.UNLIMITED_VALUES);
    commandLineOptions.addOption(infoTypesOption);

    Option includeQuoteOption = Option.builder("includeQuote")
        .hasArg(true)
        .required(false)
        .build();
    commandLineOptions.addOption(includeQuoteOption);

    Option bucketNameOption = Option.builder("bucketName")
        .hasArg(true)
        .required(false)
        .build();
    commandLineOptions.addOption(bucketNameOption);

    Option gcsFileNameOption = Option.builder("fileName")
        .hasArg(true)
        .required(false)
        .build();
    commandLineOptions.addOption(gcsFileNameOption);

    Option datastoreProjectIdOption = Option.builder("projectId")
        .hasArg(true)
        .required(false)
        .build();
    commandLineOptions.addOption(datastoreProjectIdOption);

    Option datastoreNamespaceOption = Option.builder("namespace")
        .hasArg(true)
        .required(false)
        .build();
    commandLineOptions.addOption(datastoreNamespaceOption);

    Option datastoreKindOption = Option.builder("kind")
        .hasArg(true)
        .required(false)
        .build();
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

    Likelihood minLikelihood = Likelihood.valueOf(cmd.getOptionValue(minLikelihoodOption.getOpt(),
        Likelihood.LIKELIHOOD_UNSPECIFIED.name()));
    int maxFindings = Integer.parseInt(cmd.getOptionValue(maxFindingsOption.getOpt(), "0"));
    boolean includeQuote = Boolean
        .parseBoolean(cmd.getOptionValue(includeQuoteOption.getOpt(), "true"));

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
      inspectString(val, minLikelihood, maxFindings, infoTypesList, includeQuote);
    } else if (cmd.hasOption("f")) {
      String filePath = cmd.getOptionValue(fileOption.getOpt());
      inspectFile(filePath, minLikelihood, maxFindings, infoTypesList, includeQuote);
      // gcs file inspection
    } else if (cmd.hasOption("gcs")) {
      String bucketName = cmd.getOptionValue(bucketNameOption.getOpt());
      String fileName = cmd.getOptionValue(gcsFileNameOption.getOpt());
      inspectGcsFile(bucketName, fileName, minLikelihood, infoTypesList);
      // datastore kind inspection
    } else if (cmd.hasOption("ds")) {
      String namespaceId = cmd.getOptionValue(datastoreNamespaceOption.getOpt(), "");
      String kind = cmd.getOptionValue(datastoreKindOption.getOpt());
      // use default project id when project id is not specified
      String projectId = cmd.getOptionValue(datastoreProjectIdOption.getOpt(),
          ServiceOptions.getDefaultProjectId());
      inspectDatastore(projectId, namespaceId, kind, minLikelihood, infoTypesList);
    }
  }
}
