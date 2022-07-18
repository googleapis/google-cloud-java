/*
 * Copyright 2019 Google LLC
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

package dlp.snippets;

// [START dlp_deidentify_date_shift]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.common.base.Splitter;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.DateShiftConfig;
import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.FieldId;
import com.google.privacy.dlp.v2.FieldTransformation;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.PrimitiveTransformation;
import com.google.privacy.dlp.v2.RecordTransformations;
import com.google.privacy.dlp.v2.Table;
import com.google.privacy.dlp.v2.Value;
import com.google.type.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeIdentifyWithDateShift {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    Path inputCsvFile = Paths.get("path/to/your/input/file.csv");
    Path outputCsvFile = Paths.get("path/to/your/output/file.csv");
    deIdentifyWithDateShift(projectId, inputCsvFile, outputCsvFile);
  }

  public static void deIdentifyWithDateShift(
      String projectId, Path inputCsvFile, Path outputCsvFile) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Read the contents of the CSV file into a Table
      List<FieldId> headers;
      List<Table.Row> rows;
      try (BufferedReader input = Files.newBufferedReader(inputCsvFile)) {
        // Parse and convert the first line into header names
        headers =
            Arrays.stream(input.readLine().split(","))
                .map(header -> FieldId.newBuilder().setName(header).build())
                .collect(Collectors.toList());
        // Parse the remainder of the file as Table.Rows
        rows =
            input.lines().map(DeIdentifyWithDateShift::parseLineAsRow).collect(Collectors.toList());
      }
      Table table = Table.newBuilder().addAllHeaders(headers).addAllRows(rows).build();
      ContentItem item = ContentItem.newBuilder().setTable(table).build();

      // Set the maximum days to shift dates backwards (lower bound) or forward (upper bound)
      DateShiftConfig dateShiftConfig =
          DateShiftConfig.newBuilder().setLowerBoundDays(5).setUpperBoundDays(5).build();
      PrimitiveTransformation transformation =
          PrimitiveTransformation.newBuilder().setDateShiftConfig(dateShiftConfig).build();
      // Specify which fields the DateShift should apply too
      List<FieldId> dateFields = Arrays.asList(headers.get(1), headers.get(3));
      FieldTransformation fieldTransformation =
          FieldTransformation.newBuilder()
              .addAllFields(dateFields)
              .setPrimitiveTransformation(transformation)
              .build();
      RecordTransformations recordTransformations =
          RecordTransformations.newBuilder().addFieldTransformations(fieldTransformation).build();
      // Specify the config for the de-identify request
      DeidentifyConfig deidentifyConfig =
          DeidentifyConfig.newBuilder().setRecordTransformations(recordTransformations).build();

      // Combine configurations into a request for the service.
      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setItem(item)
              .setDeidentifyConfig(deidentifyConfig)
              .build();

      // Send the request and receive response from the service
      DeidentifyContentResponse response = dlp.deidentifyContent(request);

      // Write the results to the target CSV file
      try (BufferedWriter writer = Files.newBufferedWriter(outputCsvFile)) {
        Table outTable = response.getItem().getTable();
        String headerOut =
            outTable.getHeadersList().stream()
                .map(FieldId::getName)
                .collect(Collectors.joining(","));
        writer.write(headerOut + "\n");

        List<String> rowOutput =
            outTable.getRowsList().stream()
                .map(row -> joinRow(row.getValuesList()))
                .collect(Collectors.toList());
        for (String line : rowOutput) {
          writer.write(line + "\n");
        }
        System.out.println("Content written to file: " + outputCsvFile.toString());
      }
    }
  }

  // Convert the string from the csv file into com.google.type.Date
  public static Date parseAsDate(String s) {
    LocalDate date = LocalDate.parse(s, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    return Date.newBuilder()
        .setDay(date.getDayOfMonth())
        .setMonth(date.getMonthValue())
        .setYear(date.getYear())
        .build();
  }

  // Each row is in the format: Name,BirthDate,CreditCardNumber,RegisterDate
  public static Table.Row parseLineAsRow(String line) {
    List<String> values = Splitter.on(",").splitToList(line);
    Value name = Value.newBuilder().setStringValue(values.get(0)).build();
    Value birthDate = Value.newBuilder().setDateValue(parseAsDate(values.get(1))).build();
    Value creditCardNumber = Value.newBuilder().setStringValue(values.get(2)).build();
    Value registerDate = Value.newBuilder().setDateValue(parseAsDate(values.get(3))).build();
    return Table.Row.newBuilder()
        .addValues(name)
        .addValues(birthDate)
        .addValues(creditCardNumber)
        .addValues(registerDate)
        .build();
  }

  public static String formatDate(Date d) {
    return String.format("%s/%s/%s", d.getMonth(), d.getDay(), d.getYear());
  }

  public static String joinRow(List<Value> values) {
    String name = values.get(0).getStringValue();
    String birthDate = formatDate(values.get(1).getDateValue());
    String creditCardNumber = values.get(2).getStringValue();
    String registerDate = formatDate(values.get(3).getDateValue());
    return String.join(",", name, birthDate, creditCardNumber, registerDate);
  }
}
// [END dlp_deidentify_date_shift]
