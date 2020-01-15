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

package com.example.translate;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.translate.v3.CreateGlossaryMetadata;
import com.google.cloud.translate.v3.CreateGlossaryRequest;
import com.google.cloud.translate.v3.DeleteGlossaryMetadata;
import com.google.cloud.translate.v3.DeleteGlossaryRequest;
import com.google.cloud.translate.v3.DeleteGlossaryResponse;
import com.google.cloud.translate.v3.GcsSource;
import com.google.cloud.translate.v3.Glossary;
import com.google.cloud.translate.v3.GlossaryInputConfig;
import com.google.cloud.translate.v3.GlossaryName;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslationServiceClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for Batch Translate Text With Glossary sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class BatchTranslateTextWithGlossaryAndModelTests {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String INPUT_URI =
      "gs://cloud-samples-data/translation/text_with_custom_model_and_glossary.txt";
  private static final String GLOSSARY_ID =
      String.format("test_%s", UUID.randomUUID().toString().replace("-", "_").substring(0, 26));
  private static final String MODEL_ID = "TRL2188848820815848149";
  private static final String GLOSSARY_INPUT_URI =
      "gs://cloud-samples-data/translation/glossary_ja.csv";

  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final void cleanUpBucket() {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    Page<Blob> blobs =
        storage.list(
            PROJECT_ID,
            Storage.BlobListOption.currentDirectory(),
            Storage.BlobListOption.prefix("BATCH_TRANSLATION_OUTPUT/"));

    deleteDirectory(storage, blobs);
  }

  private static void deleteDirectory(Storage storage, Page<Blob> blobs) {
    for (Blob blob : blobs.iterateAll()) {
      System.out.println(blob.getBlobId());
      if (!blob.delete()) {
        Page<Blob> subBlobs =
            storage.list(
                PROJECT_ID,
                Storage.BlobListOption.currentDirectory(),
                Storage.BlobListOption.prefix(blob.getName()));

        deleteDirectory(storage, subBlobs);
      }
    }
  }

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable '%s' is required to perform these tests.".format(varName),
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws InterruptedException, ExecutionException, IOException {
    // Create a glossary that can be used in the test
    PrintStream temp = new PrintStream(new ByteArrayOutputStream());
    System.setOut(temp);
    List<String> languageCodes = new ArrayList<>();
    languageCodes.add("en");
    languageCodes.add("ja");
    CreateGlossary.createGlossary(PROJECT_ID, GLOSSARY_ID, languageCodes, GLOSSARY_INPUT_URI);

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() throws InterruptedException, ExecutionException, IOException {
    cleanUpBucket();
    // Delete the created glossary
    DeleteGlossary.deleteGlossary(PROJECT_ID, GLOSSARY_ID);
    System.setOut(null);
  }

  @Test
  public void testBatchTranslateTextWithGlossaryAndModel()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {
    BatchTranslateTextWithGlossaryAndModel.batchTranslateTextWithGlossaryAndModel(
        PROJECT_ID,
        "en",
        "ja",
        INPUT_URI,
        "gs://" + PROJECT_ID + "/BATCH_TRANSLATION_OUTPUT/",
        GLOSSARY_ID,
        MODEL_ID);
    String got = bout.toString();
    assertThat(got).contains("Total Characters: 25");
  }
}
