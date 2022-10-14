/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.translate.snippets;

import com.google.api.core.ApiFuture;
import com.google.cloud.translate.v3beta1.BatchTranslateResponse;
import com.google.cloud.translate.v3beta1.BatchTranslateTextRequest;
import com.google.cloud.translate.v3beta1.CreateGlossaryRequest;
import com.google.cloud.translate.v3beta1.DeleteGlossaryResponse;
import com.google.cloud.translate.v3beta1.DetectLanguageRequest;
import com.google.cloud.translate.v3beta1.DetectLanguageResponse;
import com.google.cloud.translate.v3beta1.GcsDestination;
import com.google.cloud.translate.v3beta1.GcsSource;
import com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest;
import com.google.cloud.translate.v3beta1.Glossary;
import com.google.cloud.translate.v3beta1.Glossary.LanguageCodesSet;
import com.google.cloud.translate.v3beta1.GlossaryInputConfig;
import com.google.cloud.translate.v3beta1.GlossaryName;
import com.google.cloud.translate.v3beta1.InputConfig;
import com.google.cloud.translate.v3beta1.LocationName;
import com.google.cloud.translate.v3beta1.OutputConfig;
import com.google.cloud.translate.v3beta1.SupportedLanguage;
import com.google.cloud.translate.v3beta1.SupportedLanguages;
import com.google.cloud.translate.v3beta1.TranslateTextGlossaryConfig;
import com.google.cloud.translate.v3beta1.TranslateTextRequest;
import com.google.cloud.translate.v3beta1.TranslateTextResponse;
import com.google.cloud.translate.v3beta1.TranslationServiceClient;
import com.google.cloud.translate.v3beta1.TranslationServiceClient.ListGlossariesPagedResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** Snippets for the beta features */
public class TranslateSnippetsBeta {
  private TranslateSnippetsBeta() {}

  /**
   * Lists all the supported language codes.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   */
  // [START translate_list_codes_beta]
  static SupportedLanguages listSupportedLanguages(String projectId, String location) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();
      GetSupportedLanguagesRequest getSupportedLanguagesRequest =
          GetSupportedLanguagesRequest.newBuilder().setParent(locationName.toString()).build();

      // Call the API
      ApiFuture<SupportedLanguages> future =
          translationServiceClient
              .getSupportedLanguagesCallable()
              .futureCall(getSupportedLanguagesRequest);

      SupportedLanguages response = future.get();
      List<SupportedLanguage> languages = response.getLanguagesList();
      for (SupportedLanguage language : languages) {
        System.out.printf("Code: %s\n", language.getLanguageCode());
      }

      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_list_codes_beta]

  /**
   * Lists all the supported language names and codes.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   */
  // [START translate_list_language_names_beta]
  static SupportedLanguages listSupportedLanguagesWithTarget(String projectId, String location) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();
      GetSupportedLanguagesRequest getSupportedLanguagesRequest =
          GetSupportedLanguagesRequest.newBuilder()
              .setParent(locationName.toString())
              .setDisplayLanguageCode("en-US")
              .build();

      // Call the API
      ApiFuture<SupportedLanguages> future =
          translationServiceClient
              .getSupportedLanguagesCallable()
              .futureCall(getSupportedLanguagesRequest);

      SupportedLanguages response = future.get();
      List<SupportedLanguage> languages = response.getLanguagesList();

      for (SupportedLanguage language : languages) {
        System.out.printf(
            "Name: %s, Code: %s\n", language.getDisplayName(), language.getLanguageCode());
      }
      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_list_language_names_beta]

  /**
   * Detects the language of a given text.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param text - Text for detection
   */
  // [START translate_detect_language_beta]
  static DetectLanguageResponse detectLanguageOfText(
      String projectId, String location, String text) {

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();
      DetectLanguageRequest detectLanguageRequest =
          DetectLanguageRequest.newBuilder()
              .setParent(locationName.toString())
              .setMimeType("text/plain")
              .setContent(text)
              .build();

      // Call the API
      DetectLanguageResponse response =
          translationServiceClient.detectLanguage(detectLanguageRequest);
      System.out.format("Detected Language Code: %s", response.getLanguages(0).getLanguageCode());
      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_detect_language_beta]

  // [START translate_translate_text_beta]

  /**
   * Translates a given text to a target language.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param text - Text for translation.
   * @param sourceLanguageCode - Language code of text. e.g. "en"
   * @param targetLanguageCode - Language code for translation. e.g. "sr"
   */
  static TranslateTextResponse translateText(
      String projectId,
      String location,
      String text,
      String sourceLanguageCode,
      String targetLanguageCode) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();

      TranslateTextRequest translateTextRequest =
          TranslateTextRequest.newBuilder()
              .setParent(locationName.toString())
              .setMimeType("text/plain")
              .setSourceLanguageCode(sourceLanguageCode)
              .setTargetLanguageCode(targetLanguageCode)
              .addContents(text)
              .build();

      // Call the API
      TranslateTextResponse response = translationServiceClient.translateText(translateTextRequest);
      System.out.format(
          "Translated Text: %s", response.getTranslationsList().get(0).getTranslatedText());
      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_translate_text_beta]

  /**
   * Translates a batch of texts on GCS and stores the result in a GCS location.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param sourceUri - Google Cloud Storage URI. Location where text is stored.
   * @param destinationUri - Google Cloud Storage URI where result will be stored.
   */
  // [START translate_batch_translate_text_beta]
  static BatchTranslateResponse batchTranslateText(
      String projectId, String location, String sourceUri, String destinationUri) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();
      GcsSource gcsSource = GcsSource.newBuilder().setInputUri(sourceUri).build();
      InputConfig inputConfig =
          InputConfig.newBuilder().setGcsSource(gcsSource).setMimeType("text/plain").build();
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(destinationUri).build();
      OutputConfig outputConfig =
          OutputConfig.newBuilder().setGcsDestination(gcsDestination).build();
      BatchTranslateTextRequest batchTranslateTextRequest =
          BatchTranslateTextRequest.newBuilder()
              .setParent(locationName.toString())
              .setSourceLanguageCode("en")
              .addTargetLanguageCodes("sr")
              .addInputConfigs(inputConfig)
              .setOutputConfig(outputConfig)
              .build();

      // Call the API
      BatchTranslateResponse response =
          translationServiceClient
              .batchTranslateTextAsync(batchTranslateTextRequest)
              .get(300, TimeUnit.SECONDS);

      System.out.printf("Total Characters: %d\n", response.getTotalCharacters());
      System.out.printf("Translated Characters: %d\n", response.getTranslatedCharacters());
      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_batch_translate_text_beta]

  /**
   * Creates a glossary.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param name - Glossary name.
   * @param gcsUri - Google Cloud Storage URI where glossary is stored in csv format.
   */
  // [START translate_create_glossary_beta]
  static Glossary createGlossary(String projectId, String location, String name, String gcsUri) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();
      LanguageCodesSet languageCodesSet =
          LanguageCodesSet.newBuilder().addLanguageCodes("en").addLanguageCodes("es").build();
      GcsSource gcsSource = GcsSource.newBuilder().setInputUri(gcsUri).build();
      GlossaryInputConfig glossaryInputConfig =
          GlossaryInputConfig.newBuilder().setGcsSource(gcsSource).build();
      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary(name)
              .build();
      Glossary glossary =
          Glossary.newBuilder()
              .setLanguageCodesSet(languageCodesSet)
              .setInputConfig(glossaryInputConfig)
              .setName(glossaryName.toString())
              .build();
      CreateGlossaryRequest request =
          CreateGlossaryRequest.newBuilder()
              .setParent(locationName.toString())
              .setGlossary(glossary)
              .build();

      // Call the API
      Glossary response =
          translationServiceClient.createGlossaryAsync(request).get(300, TimeUnit.SECONDS);
      System.out.format("Created: %s\n", response.getName());
      System.out.format("Input Uri: %s\n", response.getInputConfig().getGcsSource());
      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_create_glossary_beta]

  /**
   * Lists all the glossaries for a given project.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param filter - criteria for listing glossaries.
   */
  // [START translate_list_glossary_beta]
  static ListGlossariesPagedResponse listGlossary(
      String projectId, String location, String filter) {

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();

      ListGlossariesPagedResponse response =
          translationServiceClient.listGlossaries(locationName.toString(), filter);

      // Call the API
      for (Glossary element : response.iterateAll()) {
        System.out.format("Name: %s\n", element.getName());
        System.out.format("Language Codes Set:\n");
        System.out.format(
            "Source Language Code: %s\n",
            element.getLanguageCodesSet().getLanguageCodesList().get(0));
        System.out.format(
            "Target Language Code: %s\n",
            element.getLanguageCodesSet().getLanguageCodesList().get(1));
        System.out.format("Input Uri: %s\n", element.getInputConfig().getGcsSource());
      }
      return response;
    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_list_glossary_beta]

  /**
   * Retrieves a glossary.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param name - Glossary name.
   */
  // [START translate_get_glossary_beta]
  static Glossary getGlossary(String projectId, String location, String name) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary(name)
              .build();

      // Call the API
      Glossary response = translationServiceClient.getGlossary(glossaryName.toString());
      System.out.format("Got: %s\n", response.getName());
      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_get_glossary_beta]

  /**
   * Translates a given text using a glossary.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param name - Glossary name.
   * @param text - Text to be translated. e.g. "Hello World!"
   * @param sourceLanguageCode - Language code of text. e.g. "en"
   * @param targetLanguageCode - Language code for translation. e.g. "sr"
   */
  // [START translate_translate_text_with_glossary_beta]
  static TranslateTextResponse translateTextWithGlossary(
      String projectId,
      String location,
      String name,
      String text,
      String sourceLanguageCode,
      String targetLanguageCode) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      LocationName locationName =
          LocationName.newBuilder().setProject(projectId).setLocation(location).build();
      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary(name)
              .build();
      TranslateTextGlossaryConfig translateTextGlossaryConfig =
          TranslateTextGlossaryConfig.newBuilder().setGlossary(glossaryName.toString()).build();
      TranslateTextRequest translateTextRequest =
          TranslateTextRequest.newBuilder()
              .setParent(locationName.toString())
              .setMimeType("text/plain")
              .setSourceLanguageCode(sourceLanguageCode)
              .setTargetLanguageCode(targetLanguageCode)
              .addContents(text)
              .setGlossaryConfig(translateTextGlossaryConfig)
              .build();

      // Call the API
      TranslateTextResponse response = translationServiceClient.translateText(translateTextRequest);
      System.out.format(
          "Translated text: %s", response.getGlossaryTranslationsList().get(0).getTranslatedText());
      return response;

    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_translate_text_with_glossary_beta]

  /**
   * Deletes a glossary.
   *
   * @param projectId - Id of the project.
   * @param location - location name.
   * @param name - Glossary name.
   */
  // [START translate_delete_glossary_beta]
  static DeleteGlossaryResponse deleteGlossary(String projectId, String location, String name) {
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary(name)
              .build();

      // Call the API
      DeleteGlossaryResponse response =
          translationServiceClient
              .deleteGlossaryAsync(glossaryName.toString())
              .get(300, TimeUnit.SECONDS);

      System.out.format("Deleted: %s\n", response.getName());
      return response;
    } catch (Exception e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END translate_delete_glossary_beta]
}
