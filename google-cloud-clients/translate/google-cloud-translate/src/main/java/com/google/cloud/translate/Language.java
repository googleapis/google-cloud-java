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

import com.google.api.services.translate.model.LanguagesResource;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/**
 * Information about a language supported by Google Translation. Objects of this class contain the
 * language's code and the language name.
 *
 * @see <a href="https://cloud.google.com/translate/v2/discovering-supported-languages-with-rest">
 *     Discovering Supported Languages</a>
 * @see <a href="https://cloud.google.com/translate/docs/languages">Supported Languages</a>
 */
public class Language implements Serializable {

  private static final long serialVersionUID = 5205240279371907020L;
  static final Function<LanguagesResource, Language> FROM_PB_FUNCTION =
      new Function<LanguagesResource, Language>() {
        @Override
        public Language apply(LanguagesResource languagePb) {
          return Language.fromPb(languagePb);
        }
      };

  private final String code;
  private final String name;

  private Language(String code, String name) {
    this.code = code;
    this.name = name;
  }

  /** Returns the code of the language. */
  public String getCode() {
    return code;
  }

  /** Returns the name of the language. */
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("code", code).add("name", name).toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(code, name);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Language.class)) {
      return false;
    }
    Language other = (Language) obj;
    return Objects.equals(code, other.code) && Objects.equals(name, other.name);
  }

  static Language fromPb(LanguagesResource languagePb) {
    return new Language(languagePb.getLanguage(), languagePb.getName());
  }
}
