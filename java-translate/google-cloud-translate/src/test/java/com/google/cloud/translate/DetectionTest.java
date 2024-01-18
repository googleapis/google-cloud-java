/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.translate;

import static org.junit.Assert.assertEquals;

import com.google.api.services.translate.model.DetectionsResourceItems;
import org.junit.Test;

public class DetectionTest {

  private static final String LANGUAGE = "en";
  private static final float CONFIDENCE = 0.42F;
  private static final DetectionsResourceItems DETECTION_PB =
      new DetectionsResourceItems().setLanguage(LANGUAGE).setConfidence(CONFIDENCE);
  private static final Detection DETECTION = Detection.fromPb(DETECTION_PB);

  @Test
  public void testFromPb() {
    assertEquals(LANGUAGE, DETECTION.getLanguage());
    assertEquals(CONFIDENCE, DETECTION.getConfidence(), 0);
    compareDetection(DETECTION, Detection.fromPb(DETECTION_PB));
  }

  private void compareDetection(Detection expected, Detection value) {
    assertEquals(expected, value);
    assertEquals(expected.getLanguage(), value.getLanguage());
    assertEquals(expected.getConfidence(), value.getConfidence(), 0);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
