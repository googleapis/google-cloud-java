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

import com.google.api.services.translate.model.DetectionsResourceItems;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/**
 * Information about a language detection. Objects of this class contain the detected language and
 * possibly a confidence level.
 *
 * @see <a href="https://cloud.google.com/translate/v2/detecting-language-with-rest">Detecting
 *     Language </a>
 */
public class Detection implements Serializable {

  private static final long serialVersionUID = 5767106557994900916L;

  private final String language;
  private final Float confidence;

  private Detection(String language, Float confidence) {
    this.language = language;
    this.confidence = confidence;
  }

  /**
   * Returns the code of the detected language.
   *
   * @see <a href="https://cloud.google.com/translate/v2/translate-reference#supported_languages">
   *     Supported Languages</a>
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Returns an optional confidence value in the interval [0,1]. The closer this value is to 1, the
   * higher the confidence level for the language detection. Note that this value is not always
   * available.
   */
  public float getConfidence() {
    return confidence;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("language", language)
        .add("confidence", confidence)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(language, confidence);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Detection.class)) {
      return false;
    }
    Detection other = (Detection) obj;
    return Objects.equals(language, other.language) && Objects.equals(confidence, other.confidence);
  }

  static Detection fromPb(DetectionsResourceItems detectionPb) {
    return new Detection(detectionPb.getLanguage(), detectionPb.getConfidence());
  }
}
