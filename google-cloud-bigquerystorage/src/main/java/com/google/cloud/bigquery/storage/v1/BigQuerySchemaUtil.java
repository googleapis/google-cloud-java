/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigquery.storage.v1;

import com.google.protobuf.Descriptors.FieldDescriptor;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BigQuerySchemaUtil {

  private static final String PLACEHOLDER_FILED_NAME_PREFIX = "col_";

  /**
   * * Checks if the field name is compatible with proto field naming convention.
   *
   * @param fieldName name for the field
   * @return true if the field name is comptaible with proto naming convention, otherwise, returns
   *     false.
   */
  public static boolean isProtoCompatible(String fieldName) {
    int length = fieldName.length();
    if (length < 1) {
      return false;
    }
    char ch = fieldName.charAt(0);
    if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '_')) {
      return false;
    }
    for (int i = 1; i < length; i++) {
      ch = fieldName.charAt(i);
      if (!((ch >= 'a' && ch <= 'z')
          || (ch >= 'A' && ch <= 'Z')
          || ch == '_'
          || (ch >= '0' && ch <= '9'))) {
        return false;
      }
    }

    return true;
  }

  /**
   * * Generates a placeholder name that consists of a prefix + base64 encoded field name. We
   * replace all dashes with underscores as they are not allowed for proto field names.
   *
   * @param fieldName name for the field
   * @return the generated placeholder field name
   */
  public static String generatePlaceholderFieldName(String fieldName) {
    return PLACEHOLDER_FILED_NAME_PREFIX
        + Base64.getUrlEncoder()
            .withoutPadding()
            .encodeToString(fieldName.getBytes(StandardCharsets.UTF_8))
            .replace('-', '_');
  }

  /**
   * * Gets the user-facing field name from the descriptor
   *
   * @param fieldDescriptor
   * @return columnName annotation if present, otherwise return the field name.
   */
  public static String getFieldName(FieldDescriptor fieldDescriptor) {
    return fieldDescriptor.getOptions().hasExtension(AnnotationsProto.columnName)
        ? fieldDescriptor.getOptions().getExtension(AnnotationsProto.columnName)
        : fieldDescriptor.getName();
  }
}
