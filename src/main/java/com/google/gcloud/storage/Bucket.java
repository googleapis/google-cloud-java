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

import java.util.Iterator;

public interface Bucket {

  String id();

  String name();

  Cors cors();

  Acl acl();

  Acl defaultObjectAcl();

  void updateCors(Cors cors);

  void updateAcl(Acl acl);

  void updateDefaultObjectAcl();

  void delete(String... objectName);

  void compose(Iterable<String> sourceObjectNames, String destObjectName);

  void copy(String sourceObjectName, StorageObject.Key destObjectKey);


  // TODO (ozarov): consider replace with Object that has a reference to bucket and name
  // that object can return its own meta-data, update its own meta-data, replace its content
  // via a stream or byteBuffer, read its content (via stream or ByteBuffer),...
  //void copy(String source, String bucket, String dest);
  // Also consider read with an offset (and limit).

  // returns null if not exists
  StorageObject get(String objectName);

  Iterator<StorageObject> get(String... objectName);

  InputChannel getInputChannel(String ObjectName);

  OutputChannel getOutputChannel(String ObjectName);

  // TODO: add listing
}
