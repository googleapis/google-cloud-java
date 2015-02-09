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

import java.nio.ByteBuffer;

// TODO: add  equals,hashCode, toString, serializable
public interface StorageObject {

  class Key {

    // TODO: add builder, factory method, toURL, from URL, equals,hashCode, toString, serializable
    private final String bucket;
    private final String name;


    Key(Bucket bucket, String name) {
      this.bucket = bucket.name();
      this.name = name;
    }

    public String bucket() {
      return bucket;
    }

    public String name() {
      return name;
    }
  }

  abstract class Builder {

    private Bucket bucket;
    private Acl acl;
    private String name;
    private ByteBuffer content;

    public Builder() {

    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder bucket(Bucket bucket) {
      this.bucket = bucket;
      return this;
    }

    public Builder acl(Acl acl) {
      this.acl = acl;
      return this;
    }

    public Builder content(ByteBuffer content) {
      this.content = content;
      return this;
    }

    public abstract StorageObject build();
  }

  boolean exists();

  Key key();

  Acl acl();

  ByteBuffer content();

  void save();

  void delete();

  InputChannel getInputChannel();

  OutputChannel getOutputChannel();
}
