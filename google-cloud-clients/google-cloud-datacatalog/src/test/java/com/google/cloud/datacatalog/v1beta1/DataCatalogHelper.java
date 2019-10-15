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
package com.google.cloud.datacatalog.v1beta1;

import java.util.UUID;

public class DataCatalogHelper {

  private static final String TAG_TEMPLATE_ID = "test_tag_template_id_";
  private static final String TAG_TEMPLATE_FIELD_ID = "test_tag_template_field_id_";
  private static final String ENTRY_GROUP_ID = "test_entry_group_id_";

  /** Returns a tag temple id generated using a random UUID. */
  public static String generateTagTemplateId() {
    return TAG_TEMPLATE_ID + UUID.randomUUID().toString().substring(0, 8);
  }

  /** Returns a tag temple field id generated using a random UUID. */
  public static String generateTagTempleFieldId() {
    return TAG_TEMPLATE_FIELD_ID + UUID.randomUUID().toString().substring(0, 8);
  }

  /** Returns a entity group id generated using a random UUID. */
  public static String generateEntryGroupId() {
    return ENTRY_GROUP_ID + UUID.randomUUID().toString().substring(0, 8);
  }
}
