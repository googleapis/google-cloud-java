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
import static org.junit.Assert.assertNull;

import com.google.api.services.translate.model.LanguagesResource;
import org.junit.Test;

public class LanguageTest {

  private static final String CODE = "en";
  private static final String NAME = "English";
  private static final LanguagesResource LANGUAGE_PB =
      new LanguagesResource().setLanguage(CODE).setName(NAME);
  private static final Language LANGUAGE = Language.fromPb(LANGUAGE_PB);

  @Test
  public void testFromPb() {
    assertEquals(CODE, LANGUAGE.getCode());
    assertEquals(NAME, LANGUAGE.getName());
    Language language = Language.fromPb(new LanguagesResource().setLanguage(CODE));
    assertEquals(CODE, language.getCode());
    assertNull(language.getName());
    compareLanguage(LANGUAGE, Language.fromPb(LANGUAGE_PB));
  }

  private void compareLanguage(Language expected, Language value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getCode(), value.getCode());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
