/*
 * Copyright 2025 Google LLC
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

package com.example.storage;

import com.google.cloud.storage.Acl.User;

public final class Env {

  public static final String IT_SERVICE_ACCOUNT_EMAIL = System.getenv("IT_SERVICE_ACCOUNT_EMAIL");
  public static final User IT_SERVICE_ACCOUNT_USER = new User(IT_SERVICE_ACCOUNT_EMAIL);
  public static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");
  public static final String GOOGLE_CLOUD_PROJECT_NUMBER =
      System.getenv("GOOGLE_CLOUD_PROJECT_NUMBER");
  public static final String JOB_TYPE = System.getenv("JOB_TYPE");

  private Env() {}
}
