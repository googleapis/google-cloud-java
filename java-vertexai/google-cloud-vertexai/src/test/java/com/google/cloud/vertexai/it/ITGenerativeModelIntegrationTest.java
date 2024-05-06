/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vertexai.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.cloud.vertexai.Transport;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.CountTokensResponse;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.api.HarmCategory;
import com.google.cloud.vertexai.api.Part;
import com.google.cloud.vertexai.api.SafetySetting;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.PartMaker;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import com.google.cloud.vertexai.generativeai.ResponseStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITGenerativeModelIntegrationTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String MODEL_NAME_TEXT = "gemini-pro";
  private static final String MODEL_NAME_MULTIMODAL = "gemini-pro-vision";
  private static final String MODEL_NAME_LATEST_GEMINI = "gemini-1.5-pro-preview-0409";
  private static final String LOCATION = "us-central1";

  // Tested content
  private static final String TEXT = "What do you think about Google Pixel?";
  private static final String PIRATE_INSTRUCTION = "Speak like a pirate when answering questions.";
  private static final String IMAGE_INQUIRY = "Please describe this image: ";
  private static final String IMAGE_URL = "https://picsum.photos/id/1/200/300";
  private static final String VIDEO_INQUIRY = "Please summarize this video: ";
  private static final String GCS_VIDEO_URI = "gs://cloud-samples-data-us-central1/video/pizza.mp4";
  private static final String GCS_IMAGE_URI =
      "gs://cloud-samples-data-us-central1/vision/duck_and_truck.jpg";

  private static final Logger logger =
      Logger.getLogger(ITGenerativeModelIntegrationTest.class.getName());

  private VertexAI vertexAi;
  private GenerativeModel textModel;
  private GenerativeModel multiModalModel;
  private GenerativeModel latestGemini;

  @Rule public TestName name = new TestName();

  @Before
  public void setUp() throws IOException {
    vertexAi = new VertexAI(PROJECT_ID, LOCATION);
    // Set temperature to 0 to reduce randomness on model responses
    GenerationConfig defaultGenerationConfig =
        GenerationConfig.newBuilder().setTemperature(0).build();
    textModel =
        new GenerativeModel(MODEL_NAME_TEXT, vertexAi)
            .withGenerationConfig(defaultGenerationConfig);
    multiModalModel =
        new GenerativeModel(MODEL_NAME_MULTIMODAL, vertexAi)
            .withGenerationConfig(defaultGenerationConfig);
    latestGemini =
        new GenerativeModel(MODEL_NAME_LATEST_GEMINI, vertexAi)
            .withGenerationConfig(defaultGenerationConfig);
  }

  @After
  public void tearDown() throws IOException {
    vertexAi.close();
  }

  private static byte[] imageToBytes(URL imageUrl) throws Exception {
    BufferedImage bImage = ImageIO.read(imageUrl);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ImageIO.write(bImage, "jpeg", bos);
    byte[] data = bos.toByteArray();
    return data;
  }

  private static void assertNonEmptyAndLogResponse(
      String testCaseName, String prompt, GenerateContentResponse response) {
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    logger.info(
        String.format("%s: Print response for prompt \"%s\":\n%s", testCaseName, prompt, response));
    assertThat(response.getCandidatesList()).isNotEmpty();
  }

  private static void assertNonEmptyAndLogTextContentOfResponseStream(
      String testCaseName, String prompt, ResponseStream<GenerateContentResponse> stream) {
    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    for (GenerateContentResponse resp : stream) {
      assertThat(resp.getCandidatesList()).isNotEmpty();
      logger.info(
          String.format(
              "%s: Print streaming response for prompt \"%s\":\n%s",
              testCaseName, prompt, ResponseHandler.getText(resp)));
    }
  }

  @Test
  public void generateContent_restTransport_nonEmptyCandidateList() throws IOException {
    try (VertexAI vertexAiViaRest =
        new VertexAI.Builder()
            .setProjectId(PROJECT_ID)
            .setLocation(LOCATION)
            .setTransport(Transport.REST)
            .build()) {
      GenerativeModel textModelWithRest = new GenerativeModel(MODEL_NAME_TEXT, vertexAiViaRest);
      GenerateContentResponse response = textModelWithRest.generateContent(TEXT);

      assertNonEmptyAndLogResponse(name.getMethodName(), TEXT, response);
    }
  }

  @Test
  public void generateContent_withPlainText_nonEmptyCandidateList() throws IOException {
    GenerateContentResponse response = textModel.generateContent(TEXT);

    assertNonEmptyAndLogResponse(name.getMethodName(), TEXT, response);
  }

  @Test
  public void generateContent_withCompleteConfig_nonEmptyCandidateList() throws IOException {
    Integer maxOutputTokens = 50;
    GenerationConfig generationConfig =
        GenerationConfig.newBuilder()
            .setMaxOutputTokens(maxOutputTokens)
            .setTemperature(0)
            .setTopP(0.3f)
            .setTopK(2)
            .addStopSequences("<end_of_sentence>")
            .build();
    SafetySetting safetySetting =
        SafetySetting.newBuilder()
            .setCategory(HarmCategory.HARM_CATEGORY_DANGEROUS_CONTENT)
            .setThreshold(SafetySetting.HarmBlockThreshold.BLOCK_LOW_AND_ABOVE)
            .build();
    GenerativeModel newModel =
        textModel
            .withGenerationConfig(generationConfig)
            .withSafetySettings(Arrays.asList(safetySetting));

    GenerateContentResponse response = newModel.generateContent(TEXT);
    String contentText = ResponseHandler.getText(response);
    int numWords = contentText.split("\\s+").length;

    assertNonEmptyAndLogResponse(name.getMethodName(), TEXT, response);
    // We avoid calling the countTokens service and just assert that the number of words should be
    // less than the maxOutputTokens since each word on average results in more than one tokens.
    assertThat(numWords).isAtMost(maxOutputTokens);
  }

  @Test
  public void generateContentAsync_withPlainText_nonEmptyCandidateList() throws Exception {
    ApiFuture<GenerateContentResponse> responseFuture = textModel.generateContentAsync(TEXT);
    GenerateContentResponse response = responseFuture.get();

    assertNonEmptyAndLogResponse(name.getMethodName(), TEXT, response);
  }

  @Test
  public void generateContent_withContentList_nonEmptyCandidate() throws IOException {
    String followupPrompt = "Why do you think these two things are put together?";
    GenerateContentResponse response =
        latestGemini.generateContent(
            Arrays.asList(
                // First Content is from the user (default role is 'user')
                ContentMaker.fromMultiModalData(
                    "Please describe this image.",
                    PartMaker.fromMimeTypeAndData("image/jpeg", GCS_IMAGE_URI)),
                // Second Content is from the model
                ContentMaker.forRole("model")
                    .fromString(
                        "This is an image of a yellow rubber duck and a blue toy truck. The duck is"
                            + " on the left and the truck is on the right."),
                // Another followup question from the user; "user" is the default role so we omit
                // can it. Same for `fromMultiModalList`
                ContentMaker.fromString(followupPrompt)));

    assertNonEmptyAndLogResponse(name.getMethodName(), followupPrompt, response);
  }

  @Test
  public void generateContentStream_withPlainText_nonEmptyCandidateList() throws IOException {
    ResponseStream<GenerateContentResponse> stream = textModel.generateContentStream(TEXT);

    assertNonEmptyAndLogTextContentOfResponseStream(name.getMethodName(), TEXT, stream);
  }

  // TODO(b/333866041): Re-enable byteImage test
  @Ignore("TODO(b/333866041):The test is not compatible with GraalVM native image test on GitHub.")
  @Test
  public void generateContentStream_withByteImage_nonEmptyCandidateList() throws Exception {
    ResponseStream<GenerateContentResponse> stream =
        multiModalModel.generateContentStream(
            ContentMaker.fromMultiModalData(
                IMAGE_INQUIRY,
                PartMaker.fromMimeTypeAndData("image/jpeg", imageToBytes(new URL(IMAGE_URL)))));

    assertNonEmptyAndLogTextContentOfResponseStream(name.getMethodName(), IMAGE_INQUIRY, stream);
  }

  @Test
  public void generateContentStream_withGcsVideo_nonEmptyCandidateList() throws Exception {
    Part videoPart = PartMaker.fromMimeTypeAndData("video/mp4", GCS_VIDEO_URI);
    Content content = ContentMaker.fromMultiModalData(VIDEO_INQUIRY, videoPart);

    ResponseStream<GenerateContentResponse> stream = multiModalModel.generateContentStream(content);

    assertNonEmptyAndLogTextContentOfResponseStream(name.getMethodName(), VIDEO_INQUIRY, stream);
  }

  @Test
  public void generateContentStream_withGcsImage_nonEmptyCandidateList() throws Exception {
    Part imagePart = PartMaker.fromMimeTypeAndData("image/jpeg", GCS_IMAGE_URI);
    Content content = ContentMaker.fromMultiModalData(IMAGE_INQUIRY, imagePart);

    ResponseStream<GenerateContentResponse> stream = multiModalModel.generateContentStream(content);

    assertNonEmptyAndLogTextContentOfResponseStream(name.getMethodName(), IMAGE_INQUIRY, stream);
  }

  @Test
  public void countTokens_withPlainText_returnsNonZeroTokens() throws IOException {
    CountTokensResponse tokens = textModel.countTokens(TEXT);

    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    logger.info(String.format("Print number of tokens:\n%s", tokens));
    assertThat(tokens.getTotalTokens()).isGreaterThan(0);
  }

  @Test
  public void generateContent_withSystemInstruction() throws Exception {
    GenerativeModel pirateModel =
        textModel.withSystemInstruction(ContentMaker.fromString(PIRATE_INSTRUCTION));

    // GenAI output is flaky so we always print out the response.
    // For the same reason, we don't do assertions much.
    GenerateContentResponse pirateResponse = pirateModel.generateContent(TEXT);
    assertNonEmptyAndLogResponse(name.getMethodName(), TEXT, pirateResponse);
  }
}
