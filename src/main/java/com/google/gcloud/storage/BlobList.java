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

import java.io.Serializable;
import java.util.List;

/**
 * Created by ozarov on 4/24/15.
 */
public class BlobList  implements Serializable{

  private final List<Blob> blobs;
  private final String cursor;

  BlobList(List<Blob> blobs, String cursor) {
    this.blobs = blobs;
    this.cursor = cursor;
  }

  public List<Blob> result() {
    return blobs;
  }

  public String cursor() {
    return cursor;
  }
}
