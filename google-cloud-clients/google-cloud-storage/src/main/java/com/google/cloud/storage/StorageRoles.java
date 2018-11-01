/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.storage;

import com.google.cloud.Role;

/**
 * IAM roles specific to Storage. An overview of the permissions available to Storage and the
 * capabilities they grant can be found in the 
 * <a href="https://cloud.google.com/storage/docs/access-control/iam">Google Cloud Storage IAM documentation.</a>
 */
public class StorageRoles {

  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.buckets.*</li>
   * <li>storage.objects.*</li>
   * </ul>
   */
  public static Role admin() {
    return Role.of("roles/storage.admin");
  }

  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.objects.list</li>
   * <li>storage.objects.get</li>
   * </ul>
   */
  public static Role objectViewer() {
    return Role.of("roles/storage.objectViewer");
  }
  
  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.objects.create</li>
   * </ul>
   */
  public static Role objectCreator() {
    return Role.of("roles/storage.objectCreator");
  }
  
  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.objects.*</li>
   * </ul>
   */
  public static Role objectAdmin() {
    return Role.of("roles/storage.objectAdmin");
  }
  
  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.buckets.get</li>
   * <li>storage.buckets.update</li>
   * <li>storage.buckets.setIamPolicy</li>
   * <li>storage.buckets.getIamPolicy</li>
   * <li>storage.objects.list</li>
   * <li>storage.objects.create</li>
   * <li>storage.objects.delete</li>
   * </ul>
   */
  public static Role legacyBucketOwner() {
    return Role.of("roles/storage.legacyBucketOwner");
  }

  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.buckets.get</li>
   * <li>storage.objects.list</li>
   * <li>storage.objects.create</li>
   * <li>storage.objects.delete</li>
   * </ul>
   */
  public static Role legacyBucketWriter() {
    return Role.of("roles/storage.legacyBucketWriter");
  }

  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.buckets.get</li>
   * <li>storage.objects.list</li>
   * </ul>
   */
  public static Role legacyBucketReader() {
    return Role.of("roles/storage.legacyBucketReader");
  }

  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.objects.get</li>
   * <li>storage.objects.update</li>
   * <li>storage.objects.getIamPolicy</li>
   * <li>storage.objects.setIamPolicy</li>
   * </ul>
   */
  public static Role legacyObjectOwner() {
    return Role.of("roles/storage.legacyObjectOwner");
  }

  /**
   * Grants the following permissions:
   * <ul>
   * <li>storage.objects.get</li>
   * </ul>
   */
  public static Role legacyObjectReader() {
    return Role.of("roles/storage.legacyObjectReader");
  }

  private StorageRoles() {
    // Intentionally left blank.
  }
}
