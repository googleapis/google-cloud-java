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
import com.google.api.services.translate.model.TranslationsResource;
import com.google.cloud.BaseSerializationTest;
import com.google.cloud.NoCredentials;
import com.google.cloud.Restorable;
import java.io.Serializable;

public class SerializationTest extends BaseSerializationTest {

  private static final String LANGUAGE = "en";
  private static final float CONFIDENCE = 0.42F;
  private static final DetectionsResourceItems DETECTION_PB =
      new DetectionsResourceItems().setLanguage(LANGUAGE).setConfidence(CONFIDENCE);
  private static final Detection DETECTION = Detection.fromPb(DETECTION_PB);
  private static final String TRANSLATED_TEXT = "Hello world";
  private static final TranslationsResource TRANSLATION_PB =
      new TranslationsResource()
          .setTranslatedText(TRANSLATED_TEXT)
          .setDetectedSourceLanguage(LANGUAGE);
  private static final Translation TRANSLATION = Translation.fromPb(TRANSLATION_PB);
  private static final TranslateException TRANSLATE_EXCEPTION =
      new TranslateException(42, "message");
  private static final Translate.LanguageListOption LANGUAGE_LIST_OPTION =
      Translate.LanguageListOption.targetLanguage(LANGUAGE);
  private static final Translate.TranslateOption TRANSLATE_OPTION =
      Translate.TranslateOption.sourceLanguage(LANGUAGE);

  @Override
  protected Serializable[] serializableObjects() {
    TranslateOptions options =
        TranslateOptions.newBuilder().setCredentials(NoCredentials.getInstance()).build();
    TranslateOptions otherOptions = options.toBuilder().build();
    return new Serializable[] {
      DETECTION,
      TRANSLATION,
      TRANSLATE_EXCEPTION,
      LANGUAGE_LIST_OPTION,
      TRANSLATE_OPTION,
      options,
      otherOptions
    };
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return null;
  }
}
