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
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.translate.v3beta1.BatchTranslateResponse;
import com.google.cloud.translate.v3beta1.DeleteGlossaryResponse;
import com.google.cloud.translate.v3beta1.Glossary;
import com.google.cloud.translate.v3beta1.TranslateTextResponse;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITTranslateSnippetsBeta {

  private static final String projectId = System.getenv("PROJECT_ID");
  private static final String glossaryName = "glossary-testing";

  @Test
  public void test1_testListSupportedLanguages() {

    assertTrue(
        10
            <= TranslateSnippetsBeta.listSupportedLanguages(projectId, "global")
                .getLanguagesList()
                .size());
  }

  @Test
  public void test1_testListSupportedLanguagesWithTarget() {

    assertTrue(
        0
            < TranslateSnippetsBeta.listSupportedLanguagesWithTarget(projectId, "global")
                .getLanguagesList()
                .size());
  }

  @Test
  public void test1_testDetectLanguageOfText() {

    assertEquals(
        "is",
        TranslateSnippetsBeta.detectLanguageOfText(projectId, "global", "Hæ sæta")
            .getLanguages(0)
            .getLanguageCode());
  }

  @Test
  public void test1_testTranslateText() {

    assertEquals(
        "Здраво Свете!",
        TranslateSnippetsBeta.translateText(projectId, "global", "Hello World!", "en", "sr")
            .getTranslationsList()
            .get(0)
            .getTranslatedText());
  }

  @Test
  public void test1_testBatchTranslateText() {

    BatchTranslateResponse response =
        TranslateSnippetsBeta.batchTranslateText(
            projectId,
            "us-central1",
            "gs://cloud-samples-data/translation/text.txt",
            "gs://" + projectId + "/BATCH_TRANSLATION_OUTPUT/");
    assertEquals(13, response.getTotalCharacters());
    assertEquals(13, response.getTranslatedCharacters());
    Storage storage = StorageOptions.getDefaultInstance().getService();

    Page<Blob> blobs =
        storage.list(
            projectId,
            BlobListOption.currentDirectory(),
            BlobListOption.prefix("BATCH_TRANSLATION_OUTPUT/"));

    deleteDirectory(storage, blobs);
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
    Glossary response =
        TranslateSnippetsBeta.createGlossary(
            projectId,
            "us-central1",
            glossaryName,
            "gs://cloud-samples-data/translation/glossary.csv");
    assertTrue(response.toString(), response.toString().contains("glossary-testing"));
  }

  @Test
  public void test2_testListGlossary() {
    assertEquals(
        "projects/" + projectId + "/locations/us-central1/glossaries/glossary-testing",
        TranslateSnippetsBeta.listGlossary(projectId, "us-central1", "")
            .iterateAll()
            .iterator()
            .next()
            .getName());
  }

  @Test
  public void test2_testGetGlossary() {

    Glossary response =
        TranslateSnippetsBeta.getGlossary(projectId, "us-central1", "glossary-testing");
    assertTrue(response.toString(), response.toString().contains("glossary-testing"));
  }

  @Test
  public void test2_testTranslateTextWithGlossary() {

    TranslateTextResponse response =
        TranslateSnippetsBeta.translateTextWithGlossary(
            projectId, "us-central1", "glossary-testing", "directions", "en", "es");
    assertEquals("indicaciones", response.getGlossaryTranslationsList().get(0).getTranslatedText());
  }

  @Test
  public void test3_testDeleteGlossary() {

    DeleteGlossaryResponse response =
        TranslateSnippetsBeta.deleteGlossary(projectId, "us-central1", "glossary-testing");
    assertTrue(response.toString(), response.toString().contains("glossary-testing"));
  }
}
