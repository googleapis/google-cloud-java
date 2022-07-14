/*
 * Copyright 2020 Google LLC
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

// [START dlp_deidentify_table_fpe]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.common.io.BaseEncoding;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.CryptoKey;
import com.google.privacy.dlp.v2.CryptoReplaceFfxFpeConfig;
import com.google.privacy.dlp.v2.CryptoReplaceFfxFpeConfig.FfxCommonNativeAlphabet;
import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.FieldId;
import com.google.privacy.dlp.v2.FieldTransformation;
import com.google.privacy.dlp.v2.KmsWrappedCryptoKey;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.PrimitiveTransformation;
import com.google.privacy.dlp.v2.RecordTransformations;
import com.google.privacy.dlp.v2.Table;
import com.google.privacy.dlp.v2.Table.Row;
import com.google.privacy.dlp.v2.Value;
import com.google.protobuf.ByteString;
import java.io.IOException;

public class DeIdentifyTableWithFpe {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String kmsKeyName =
        "projects/YOUR_PROJECT/"
            + "locations/YOUR_KEYRING_REGION/"
            + "keyRings/YOUR_KEYRING_NAME/"
            + "cryptoKeys/YOUR_KEY_NAME";
    String wrappedAesKey = "YOUR_ENCRYPTED_AES_256_KEY";
    Table tableToDeIdentify =
        Table.newBuilder()
            .addHeaders(FieldId.newBuilder().setName("Employee ID").build())
            .addHeaders(FieldId.newBuilder().setName("Date").build())
            .addHeaders(FieldId.newBuilder().setName("Compensation").build())
            .addRows(
                Row.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("11111").build())
                    .addValues(Value.newBuilder().setStringValue("2015").build())
                    .addValues(Value.newBuilder().setStringValue("$10").build())
                    .build())
            .addRows(
                Row.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("11111").build())
                    .addValues(Value.newBuilder().setStringValue("2016").build())
                    .addValues(Value.newBuilder().setStringValue("$20").build())
                    .build())
            .addRows(
                Row.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("22222").build())
                    .addValues(Value.newBuilder().setStringValue("2016").build())
                    .addValues(Value.newBuilder().setStringValue("$15").build())
                    .build())
            .build();
    deIdentifyTableWithFpe(projectId, tableToDeIdentify, kmsKeyName, wrappedAesKey);
  }

  public static void deIdentifyTableWithFpe(
      String projectId, Table tableToDeIdentify, String kmsKeyName, String wrappedAesKey)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify what content you want the service to de-identify.
      ContentItem contentItem = ContentItem.newBuilder().setTable(tableToDeIdentify).build();

      // Specify an encrypted AES-256 key and the name of the Cloud KMS key that encrypted it
      KmsWrappedCryptoKey kmsWrappedCryptoKey =
          KmsWrappedCryptoKey.newBuilder()
              .setWrappedKey(ByteString.copyFrom(BaseEncoding.base64().decode(wrappedAesKey)))
              .setCryptoKeyName(kmsKeyName)
              .build();
      CryptoKey cryptoKey = CryptoKey.newBuilder().setKmsWrapped(kmsWrappedCryptoKey).build();

      // Specify how the content should be encrypted.
      CryptoReplaceFfxFpeConfig cryptoReplaceFfxFpeConfig =
          CryptoReplaceFfxFpeConfig.newBuilder()
              .setCryptoKey(cryptoKey)
              // Set of characters in the input text. For more info, see
              // https://cloud.google.com/dlp/docs/reference/rest/v2/organizations.deidentifyTemplates#DeidentifyTemplate.FfxCommonNativeAlphabet
              .setCommonAlphabet(FfxCommonNativeAlphabet.NUMERIC)
              .build();
      PrimitiveTransformation primitiveTransformation =
          PrimitiveTransformation.newBuilder()
              .setCryptoReplaceFfxFpeConfig(cryptoReplaceFfxFpeConfig)
              .build();

      // Specify field to be encrypted.
      FieldId fieldId = FieldId.newBuilder().setName("Employee ID").build();

      // Associate the encryption with the specified field.
      FieldTransformation fieldTransformation =
          FieldTransformation.newBuilder()
              .setPrimitiveTransformation(primitiveTransformation)
              .addFields(fieldId)
              .build();
      RecordTransformations transformations =
          RecordTransformations.newBuilder().addFieldTransformations(fieldTransformation).build();

      DeidentifyConfig deidentifyConfig =
          DeidentifyConfig.newBuilder().setRecordTransformations(transformations).build();

      // Combine configurations into a request for the service.
      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setItem(contentItem)
              .setDeidentifyConfig(deidentifyConfig)
              .build();

      // Send the request and receive response from the service.
      DeidentifyContentResponse response = dlp.deidentifyContent(request);

      // Print the results.
      System.out.println(
          "Table after format-preserving encryption: " + response.getItem().getTable());
    }
  }
}
// [END dlp_deidentify_table_fpe]
