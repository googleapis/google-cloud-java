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

import com.google.cloud.dlp.v2beta1.DlpServiceClient;
import com.google.common.io.BaseEncoding;
import com.google.privacy.dlp.v2beta1.CharacterMaskConfig;
import com.google.privacy.dlp.v2beta1.ContentItem;
import com.google.privacy.dlp.v2beta1.CryptoKey;
import com.google.privacy.dlp.v2beta1.CryptoReplaceFfxFpeConfig;
import com.google.privacy.dlp.v2beta1.CryptoReplaceFfxFpeConfig.FfxCommonNativeAlphabet;
import com.google.privacy.dlp.v2beta1.DeidentifyConfig;
import com.google.privacy.dlp.v2beta1.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta1.InfoTypeTransformations;
import com.google.privacy.dlp.v2beta1.InfoTypeTransformations.InfoTypeTransformation;
import com.google.privacy.dlp.v2beta1.KmsWrappedCryptoKey;
import com.google.privacy.dlp.v2beta1.PrimitiveTransformation;
import com.google.protobuf.ByteString;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class DeIdentification {

  private static void deIdentifyWithMask(
      String string,
      Character maskingCharacter,
      int numberToMask) {
    // [START dlp_deidentify_mask]
    /**
     * Deidentify a string by masking sensitive information with a character using the DLP API.
     * @param string The string to deidentify.
     * @param maskingCharacter (Optional) The character to mask sensitive data with.
     * @param numberToMask (Optional) The number of characters' worth of sensitive data to mask.
     *                     Omitting this value or setting it to 0 masks all sensitive chars.
     */

    // instantiate a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // string = "My SSN is 372819127";
      // numberToMask = 5;
      // maskingCharacter = 'x';

      ContentItem contentItem =
          ContentItem.newBuilder()
              .setType("text/plain")
              .setValue(string)
              .build();

      CharacterMaskConfig characterMaskConfig =
          CharacterMaskConfig.newBuilder()
              .setMaskingCharacter(maskingCharacter.toString())
              .setNumberToMask(numberToMask)
              .build();

      // Create the deidentification transformation configuration
      PrimitiveTransformation primitiveTransformation =
          PrimitiveTransformation.newBuilder()
              .setCharacterMaskConfig(characterMaskConfig)
              .build();

      InfoTypeTransformation infoTypeTransformationObject =
          InfoTypeTransformation.newBuilder()
              .setPrimitiveTransformation(primitiveTransformation)
              .build();

      InfoTypeTransformations infoTypeTransformationArray =
          InfoTypeTransformations.newBuilder()
              .addTransformations(infoTypeTransformationObject)
              .build();

      // Create the deidentification request object
      DeidentifyConfig deidentifyConfig =
          DeidentifyConfig.newBuilder()
              .setInfoTypeTransformations(infoTypeTransformationArray)
              .build();

      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder()
              .setDeidentifyConfig(deidentifyConfig)
              .addItems(contentItem)
              .build();

      // Execute the deidentification request
      DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(request);

      // Print the character-masked input value
      // e.g. "My SSN is 123456789" --> "My SSN is *********"
      for (ContentItem item : response.getItemsList()) {
        System.out.println(item.getValue());
      }
    } catch (Exception e) {
      System.out.println("Error in deidentifyWithMask: " + e.getMessage());
    }
    // [END dlp_deidentify_mask]
  }

  private static void deIdentifyWithFpe(
      String string, FfxCommonNativeAlphabet alphabet, String keyName, String wrappedKey) {
    // [START dlp_deidentify_fpe]
    /**
     * Deidentify a string by encrypting sensitive information while preserving format.
     * @param string The string to deidentify.
     * @param alphabet The set of characters to use when encrypting the input. For more information,
     *                 see cloud.google.com/dlp/docs/reference/rest/v2beta1/content/deidentify
     * @param keyName The name of the Cloud KMS key to use when decrypting the wrapped key.
     * @param wrappedKey The encrypted (or "wrapped") AES-256 encryption key.
     */

    // instantiate a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // string = "My SSN is 372819127";
      // alphabet = FfxCommonNativeAlphabet.ALPHA_NUMERIC;
      // keyName = "projects/GCP_PROJECT/locations/REGION/keyRings/KEYRING_ID/cryptoKeys/KEY_NAME";
      // wrappedKey = "YOUR_ENCRYPTED_AES_256_KEY"

      ContentItem contentItem =
          ContentItem.newBuilder()
              .setType("text/plain")
              .setValue(string)
              .build();

      // Create the format-preserving encryption (FPE) configuration
      KmsWrappedCryptoKey kmsWrappedCryptoKey =
          KmsWrappedCryptoKey.newBuilder()
              .setWrappedKey(ByteString.copyFrom(BaseEncoding.base64().decode(wrappedKey)))
              .setCryptoKeyName(keyName)
              .build();

      CryptoKey cryptoKey =
          CryptoKey.newBuilder()
              .setKmsWrapped(kmsWrappedCryptoKey)
              .build();

      CryptoReplaceFfxFpeConfig cryptoReplaceFfxFpeConfig =
          CryptoReplaceFfxFpeConfig.newBuilder()
              .setCryptoKey(cryptoKey)
              .setCommonAlphabet(alphabet)
              .build();

      // Create the deidentification transformation configuration
      PrimitiveTransformation primitiveTransformation =
          PrimitiveTransformation.newBuilder()
              .setCryptoReplaceFfxFpeConfig(cryptoReplaceFfxFpeConfig)
              .build();

      InfoTypeTransformation infoTypeTransformationObject =
          InfoTypeTransformation.newBuilder()
              .setPrimitiveTransformation(primitiveTransformation)
              .build();

      InfoTypeTransformations infoTypeTransformationArray =
          InfoTypeTransformations.newBuilder()
              .addTransformations(infoTypeTransformationObject)
              .build();

      // Create the deidentification request object
      DeidentifyConfig deidentifyConfig =
          DeidentifyConfig.newBuilder()
              .setInfoTypeTransformations(infoTypeTransformationArray)
              .build();

      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder()
              .setDeidentifyConfig(deidentifyConfig)
              .addItems(contentItem)
              .build();

      // Execute the deidentification request
      DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(request);

      // Print the deidentified input value
      // e.g. "My SSN is 123456789" --> "My SSN is 7261298621"
      for (ContentItem item : response.getItemsList()) {
        System.out.println(item.getValue());
      }
    } catch (Exception e) {
      System.out.println("Error in deidentifyWithFpe: " + e.getMessage());
    }
    // [END dlp_deidentify_fpe]
  }

  /**
   * Command line application to de-identify data using the Data Loss Prevention API.
   * Supported data format: strings
   */
  public static void main(String[] args) throws Exception {

    OptionGroup optionsGroup = new OptionGroup();
    optionsGroup.setRequired(true);

    Option deidentifyMaskingOption = new Option("m", "mask", true, "deid with character masking");
    optionsGroup.addOption(deidentifyMaskingOption);

    Option deidentifyFpeOption = new Option("f", "fpe", true, "deid with FFX FPE");
    optionsGroup.addOption(deidentifyFpeOption);

    Options commandLineOptions = new Options();
    commandLineOptions.addOptionGroup(optionsGroup);

    Option maskingCharacterOption =
        Option.builder("maskingCharacter").hasArg(true).required(false).build();
    commandLineOptions.addOption(maskingCharacterOption);

    Option numberToMaskOption =
        Option.builder("numberToMask").hasArg(true).required(false).build();
    commandLineOptions.addOption(numberToMaskOption);

    Option alphabetOption =
        Option.builder("commonAlphabet").hasArg(true).required(false).build();
    commandLineOptions.addOption(alphabetOption);

    Option wrappedKeyOption =
        Option.builder("wrappedKey").hasArg(true).required(false).build();
    commandLineOptions.addOption(wrappedKeyOption);

    Option keyNameOption =
        Option.builder("keyName").hasArg(true).required(false).build();
    commandLineOptions.addOption(keyNameOption);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;

    try {
      cmd = parser.parse(commandLineOptions, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp(DeIdentification.class.getName(), commandLineOptions);
      System.exit(1);
      return;
    }

    if (cmd.hasOption("m")) {
      // deidentification with character masking
      int numberToMask = Integer.parseInt(cmd.getOptionValue(numberToMaskOption.getOpt(), "0"));
      char maskingCharacter = cmd.getOptionValue(maskingCharacterOption.getOpt(), "*").charAt(0);
      String val = cmd.getOptionValue(deidentifyMaskingOption.getOpt());
      deIdentifyWithMask(val, maskingCharacter, numberToMask);
    } else if (cmd.hasOption("f")) {
      // deidentification with FPE
      String wrappedKey = cmd.getOptionValue(wrappedKeyOption.getOpt());
      String keyName = cmd.getOptionValue(keyNameOption.getOpt());
      String val = cmd.getOptionValue(deidentifyFpeOption.getOpt());
      FfxCommonNativeAlphabet alphabet =
          FfxCommonNativeAlphabet.valueOf(
              cmd.getOptionValue(
                  alphabetOption.getOpt(), FfxCommonNativeAlphabet.ALPHA_NUMERIC.name()));
      deIdentifyWithFpe(val, alphabet, keyName, wrappedKey);
    }
  }
}
