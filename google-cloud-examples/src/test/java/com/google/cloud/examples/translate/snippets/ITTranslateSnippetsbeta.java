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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
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
import com.google.cloud.translate.v3beta1.OutputConfig;
import com.google.cloud.translate.v3beta1.SupportedLanguage;
import com.google.cloud.translate.v3beta1.SupportedLanguages;
import com.google.cloud.translate.v3beta1.TranslateTextGlossaryConfig;
import com.google.cloud.translate.v3beta1.TranslateTextRequest;
import com.google.cloud.translate.v3beta1.TranslateTextResponse;
import com.google.cloud.translate.v3beta1.TranslationServiceClient;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.concurrent.TimeUnit;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * After modifying snippets in this file, run {@code ./utilities/snippets
 * ./google-cloud-examples/src/test/java/com/google/cloud/examples/translate/snippets/ITTranslateSnippetsv3beta1.java
 * ./google-cloud-clients/google-cloud-translate/src/main/java/com/google/cloud/translate/Translate.java}
 * to include the snippets in the Javadoc.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITTranslateSnippetsbeta {

  private static final String projectId = System.getenv("PROJECT_ID");

  private static final String[] LANGUAGES = {
      "af", "sq", "ar", "hy", "az", "eu", "be", "bn", "bs", "bg", "ca", "ceb", "ny", "zh-TW", "hr",
      "cs", "da", "nl", "en", "eo", "et", "tl", "fi", "fr", "gl", "ka", "de", "el", "gu", "ht", "ha",
      "iw", "hi", "hmn", "hu", "is", "ig", "id", "ga", "it", "ja", "jw", "kn", "kk", "km", "ko", "lo",
      "la", "lv", "lt", "mk", "mg", "ms", "ml", "mt", "mi", "mr", "mn", "my", "ne", "no", "fa", "pl",
      "pt", "ro", "ru", "sr", "st", "si", "sk", "sl", "so", "es", "su", "sw", "sv", "tg", "ta", "te",
      "th", "tr", "uk", "ur", "uz", "vi", "cy", "yi", "yo", "zu"
  };

  @Test
  public void test1_testListSupportedLanguages() {
    // [START translate_list_codes_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.v3beta1.*;

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      String location = "global";

      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      GetSupportedLanguagesRequest getSupportedLanguagesRequest =
          GetSupportedLanguagesRequest.newBuilder().setParent(formattedParent).build();
      ApiFuture<SupportedLanguages> future =
          translationServiceClient
              .getSupportedLanguagesCallable()
              .futureCall(getSupportedLanguagesRequest);

      SupportedLanguages response = future.get();
      List<SupportedLanguage> languages = response.getLanguagesList();
      System.out.println(projectId);
      for (SupportedLanguage language : languages) {
        System.out.printf("Code: %s\n", language.getLanguageCode());
      }
      // [END translate_list_codes_beta]
      Set<String> supportedLanguages = new HashSet<>();
      for (SupportedLanguage language : languages) {
        supportedLanguages.add(language.getLanguageCode());
      }
      for (String code : LANGUAGES) {
        assertTrue(supportedLanguages.contains(code));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test1_testListSupportedLanguagesWithTarget() {
    // [START translate_list_language_names_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.v3beta1*;

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      String location = "global";

      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      GetSupportedLanguagesRequest getSupportedLanguagesRequest =
          GetSupportedLanguagesRequest.newBuilder()
              .setParent(formattedParent)
              .setDisplayLanguageCode("en-US")
              .build();
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
      // [END translate_list_language_names_beta]
      Set<String> supportedLanguages = new HashSet<>();
      for (SupportedLanguage language : languages) {
        supportedLanguages.add(language.getLanguageCode());
        assertNotNull(language.getDisplayName());
      }
      for (String code : LANGUAGES) {
        assertTrue(supportedLanguages.contains(code));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test1_testDetectLanguageOfText() {
    // [START translate_detect_language_beta]
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {

      String location = "global";
      String text = "Hæ sæta";

      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      DetectLanguageRequest detectLanguageRequest =
          DetectLanguageRequest.newBuilder()
              .setParent(formattedParent)
              .setMimeType("text/plain")
              .setContent(text)
              .build();
      DetectLanguageResponse response =
          translationServiceClient.detectLanguage(detectLanguageRequest);
      // [END translate_detect_language_beta]
      assertEquals("is", response.getLanguages(0).getLanguageCode());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test1_testTranslateText() {
    // [START translate_translate_text_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      String location = "global";
      String content = "Hello World!";

      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);

      TranslateTextRequest translateTextRequest =
          TranslateTextRequest.newBuilder()
              .setParent(formattedParent)
              .setMimeType("text/plain")
              .setSourceLanguageCode("en")
              .setTargetLanguageCode("sr")
              .addContents(content)
              .build();

      TranslateTextResponse response = translationServiceClient.translateText(translateTextRequest);
      // [END translate_translate_text_beta]
      assertEquals("Здраво Свете!", response.getTranslationsList().get(0).getTranslatedText());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test1_testBatchTranslateText() {
    // [START translate_batch_translate_text_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      String location = "us-central1";

      String OUTPUT_PREFIX = "gs://" + projectId + "/BATCH_TRANSLATION_OUTPUT/";
      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      GcsSource gcsSource =
          GcsSource.newBuilder()
              .setInputUri("gs://cloud-samples-data/translation/text.txt")
              .build();
      InputConfig inputConfig =
          InputConfig.newBuilder().setGcsSource(gcsSource).setMimeType("text/plain").build();
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(OUTPUT_PREFIX).build();
      OutputConfig outputConfig =
          OutputConfig.newBuilder().setGcsDestination(gcsDestination).build();
      BatchTranslateTextRequest batchTranslateTextRequest =
          BatchTranslateTextRequest.newBuilder()
              .setParent(formattedParent)
              .setSourceLanguageCode("en")
              .addTargetLanguageCodes("sr")
              .addInputConfigs(inputConfig)
              .setOutputConfig(outputConfig)
              .build();
      BatchTranslateResponse response =
          translationServiceClient
              .batchTranslateTextAsync(batchTranslateTextRequest)
              .get(300, TimeUnit.SECONDS);

      System.out.printf("Total Characters: %d\n", response.getTotalCharacters());
      System.out.printf("Translated Characters: %d\n", response.getTranslatedCharacters());
      assertEquals(13, response.getTotalCharacters());
      assertEquals(13, response.getTranslatedCharacters());
      Storage storage = StorageOptions.getDefaultInstance().getService();

      Page<Blob> blobs =
          storage.list(
              projectId,
              BlobListOption.currentDirectory(),
              BlobListOption.prefix("BATCH_TRANSLATION_OUTPUT/"));

      deleteDirectory(storage, blobs);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void deleteDirectory(Storage storage, Page<Blob> blobs) {
    for (Blob blob : blobs.iterateAll()) {
      System.out.println(blob.getBlobId());
      if (!blob.delete()) {
        Page<Blob> subBlobs =
            storage.list(
                projectId,
                BlobListOption.currentDirectory(),
                BlobListOption.prefix(blob.getName()));

        deleteDirectory(storage, subBlobs);
      }
    }
  }

  @Test
  public void test1_testCreateGlossary() {
    // [START translate_create_glossary_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      String location = "us-central1";
      String inputUri = "gs://cloud-samples-data/translation/glossary.csv";
      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      LanguageCodesSet languageCodesSet =
          LanguageCodesSet.newBuilder().addLanguageCodes("en").addLanguageCodes("es").build();
      GcsSource gcsSource = GcsSource.newBuilder().setInputUri(inputUri).build();
      GlossaryInputConfig glossaryInputConfig =
          GlossaryInputConfig.newBuilder().setGcsSource(gcsSource).build();
      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary("glossary-testing")
              .build();
      Glossary glossary =
          Glossary.newBuilder()
              .setLanguageCodesSet(languageCodesSet)
              .setInputConfig(glossaryInputConfig)
              .setName(glossaryName.toString())
              .build();
      CreateGlossaryRequest request =
          CreateGlossaryRequest.newBuilder()
              .setParent(formattedParent)
              .setGlossary(glossary)
              .build();
      Glossary response =
          translationServiceClient.createGlossaryAsync(request).get(300, TimeUnit.SECONDS);
      System.out.format("Created: %s\n", response.getName());
      System.out.format("Input Uri: %s\n", response.getInputConfig().getGcsSource());
      // [END translate_create_glossary_beta]
      assertEquals(glossaryName.toString(), response.getName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test2_testListGlossary() {
    // [START translate_list_glossary_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      String location = "us-central1";
      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      String filter = "";
      for (Glossary element :
          translationServiceClient.listGlossaries(formattedParent, filter).iterateAll()) {
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
      // [END translate_list_glossary_beta]
      assertEquals(
          "projects/" + projectId + "/locations/us-central1/glossaries/glossary-testing",
          translationServiceClient
              .listGlossaries(formattedParent, filter)
              .iterateAll()
              .iterator()
              .next()
              .getName());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test2_testGetGlossary() {
    // [START translate_get_glossary_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;

    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      String location = "us-central1";
      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary("glossary-testing")
              .build();

      Glossary response = translationServiceClient.getGlossary(glossaryName.toString());
      System.out.format("Got: %s\n", response.getName());
      // [END translate_get_glossary_beta]
      assertEquals(glossaryName.toString(), response.getName());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test3_testDeleteGlossary() {
    // [START translate_delete_glossary_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      String location = "us-central1";
      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary("glossary-testing")
              .build();

      DeleteGlossaryResponse response =
          translationServiceClient
              .deleteGlossaryAsync(glossaryName.toString())
              .get(300, TimeUnit.SECONDS);

      System.out.format("Deleted: %s\n", response.getName());
      // [END translate_delete_glossary_beta]
      assertEquals(glossaryName.toString(), response.getName());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test2_testTranslateTextWithGlossary() {
    // [START translate_translate_text_with_glossary_beta]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      String location = "us-central1";
      String content = "directions";
      String formattedParent = TranslationServiceClient.formatLocationName(projectId, location);
      GlossaryName glossaryName =
          GlossaryName.newBuilder()
              .setProject(projectId)
              .setLocation(location)
              .setGlossary("glossary-testing")
              .build();
      TranslateTextGlossaryConfig translateTextGlossaryConfig =
          TranslateTextGlossaryConfig.newBuilder().setGlossary(glossaryName.toString()).build();
      TranslateTextRequest translateTextRequest =
          TranslateTextRequest.newBuilder()
              .setParent(formattedParent)
              .setMimeType("text/plain")
              .setSourceLanguageCode("en")
              .setTargetLanguageCode("es")
              .addContents(content)
              .setGlossaryConfig(translateTextGlossaryConfig)
              .build();

      TranslateTextResponse response = translationServiceClient.translateText(translateTextRequest);
      // [END translate_translate_text_with_glossary_beta]
      assertEquals("direcciones", response.getTranslationsList().get(0).getTranslatedText());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
