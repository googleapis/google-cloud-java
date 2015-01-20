/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

public class Key {

  // TODO: add builder, factory method, toURL, from URL, equals,hashCode, toString
  private final String bucket;
  private final String name;

  /*
  Builder() {

  }*/

  Key(String bucket, String name) {
    this.bucket = bucket;
    this.name = name;
  }

  public String bucket() {
    return bucket;
  }

  public String name() {
    return name;
  }
}
