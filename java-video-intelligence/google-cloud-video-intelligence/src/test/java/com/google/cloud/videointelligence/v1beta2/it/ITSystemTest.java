/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.videointelligence.v1beta2.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.videointelligence.v1beta2.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1beta2.Feature;
import com.google.cloud.videointelligence.v1beta2.VideoAnnotationResults;
import com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceClient;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static VideoIntelligenceServiceClient client;
  private static final String BUCKET_URI = "gs://cloud-samples-data/video/cat.mp4";
  private static final Feature FEATURE_ELEMENT = Feature.LABEL_DETECTION;
  private static final List<Feature> FEATURE_LIST = Arrays.asList(FEATURE_ELEMENT);

  @BeforeClass
  public static void beforeClass() throws Exception {
    client = VideoIntelligenceServiceClient.create();
  }

  @AfterClass
  public static void afterClass() {
    client.close();
  }

  @Test
  public void annotateVideoTest() throws ExecutionException, InterruptedException {
    AnnotateVideoResponse response = client.annotateVideoAsync(BUCKET_URI, FEATURE_LIST).get();
    List<VideoAnnotationResults> videoAnnotationResults = response.getAnnotationResultsList();
    for (VideoAnnotationResults result : videoAnnotationResults) {
      assertEquals(BUCKET_URI.substring(4), result.getInputUri());
      assertTrue(result.getSegmentLabelAnnotationsList().size() > 0);
    }
  }

  @Test(expected = ExecutionException.class)
  public void annotateVideoExceptionTest() throws Exception {
    String invalidUri = "gs://bucket-id/object-id";
    client.annotateVideoAsync(invalidUri, FEATURE_LIST).get();
  }
}
