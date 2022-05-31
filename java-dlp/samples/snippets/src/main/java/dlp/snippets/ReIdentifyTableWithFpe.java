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

// [START dlp_reidentify_table_fpe]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.common.io.BaseEncoding;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.CryptoKey;
import com.google.privacy.dlp.v2.CryptoReplaceFfxFpeConfig;
import com.google.privacy.dlp.v2.CryptoReplaceFfxFpeConfig.FfxCommonNativeAlphabet;
import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.FieldId;
import com.google.privacy.dlp.v2.FieldTransformation;
import com.google.privacy.dlp.v2.KmsWrappedCryptoKey;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.PrimitiveTransformation;
import com.google.privacy.dlp.v2.RecordTransformations;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.Table;
import com.google.privacy.dlp.v2.Table.Row;
import com.google.privacy.dlp.v2.Value;
import com.google.protobuf.ByteString;
import java.io.IOException;

public class ReIdentifyTableWithFpe {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String kmsKeyName =
        "projects/YOUR_PROJECT/"
            + "locations/YOUR_KEYRING_REGION/"
            + "keyRings/YOUR_KEYRING_NAME/"
            + "cryptoKeys/YOUR_KEY_NAME";
    String wrappedAesKey = "YOUR_ENCRYPTED_AES_256_KEY";
    Table tableToReIdentify =
        Table.newBuilder()
            .addHeaders(FieldId.newBuilder().setName("Employee ID").build())
            .addRows(
                Row.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("28777").build())
                    .build())
            .build();
    reIdentifyTableWithFpe(projectId, tableToReIdentify, kmsKeyName, wrappedAesKey);
  }

  public static void reIdentifyTableWithFpe(
      String projectId, Table tableToReIdentify, String kmsKeyName, String wrappedAesKey)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify what content you want the service to re-identify.
      ContentItem contentItem = ContentItem.newBuilder().setTable(tableToReIdentify).build();

      // Specify an encrypted AES-256 key and the name of the Cloud KMS key that encrypted it.
      KmsWrappedCryptoKey kmsWrappedCryptoKey =
          KmsWrappedCryptoKey.newBuilder()
              .setWrappedKey(ByteString.copyFrom(BaseEncoding.base64().decode(wrappedAesKey)))
              .setCryptoKeyName(kmsKeyName)
              .build();
      CryptoKey cryptoKey = CryptoKey.newBuilder().setKmsWrapped(kmsWrappedCryptoKey).build();

      // Specify how to un-encrypt the previously de-identified information.
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

      // Specify field to be decrypted.
      FieldId fieldId = FieldId.newBuilder().setName("Employee ID").build();

      // Associate the decryption with the specified field.
      FieldTransformation fieldTransformation =
          FieldTransformation.newBuilder()
              .setPrimitiveTransformation(primitiveTransformation)
              .addFields(fieldId)
              .build();
      RecordTransformations transformations =
          RecordTransformations.newBuilder().addFieldTransformations(fieldTransformation).build();

      DeidentifyConfig reidentifyConfig =
          DeidentifyConfig.newBuilder().setRecordTransformations(transformations).build();

      // Combine configurations into a request for the service.
      ReidentifyContentRequest request =
          ReidentifyContentRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setItem(contentItem)
              .setReidentifyConfig(reidentifyConfig)
              .build();

      // Send the request and receive response from the service
      ReidentifyContentResponse response = dlp.reidentifyContent(request);

      // Print the results
      System.out.println("Table after re-identification: " + response.getItem().getValue());
    }
  }
}
// [END dlp_reidentify_table_fpe]
