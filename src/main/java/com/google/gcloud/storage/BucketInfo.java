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

public final class BucketInfo {

  private final String id;
  private final String name;
  private final long createTime;
  private final long metageneration;
  private final Cors cors;
  private final Acl acl;
  private final Acl defaultAcl;

  public enum StorageClass {
    DURABLE_REDUCED_AVAILABILITY,
    STANDARD
  }

  public final static class Builder {

    private final String id;
    private final String name;
    private final long createTime;
    private final long metageneration;
    private Cors cors;
    private Acl acl;
    private Acl defaultAcl;

    Builder(String id, String name, long createTime, long metageneration) {
      this.id = id;
      this.name = name;
      this.createTime = createTime;
      this.metageneration = metageneration;
    }

    public Builder cors(Cors cors) {
      this.cors = cors;
      return this;
    }

    public Builder acl(Acl acl) {
      this.acl = acl;
      return this;
    }

    public Builder defaultAcl(Acl defaultAcl) {
      this.defaultAcl = defaultAcl;
      return this;
    }

    public BucketInfo build() {
      return new BucketInfo(this);
    }
  }

  private BucketInfo(Builder builder) {
    id = builder.id;
    name = builder.name;
    createTime = builder.createTime;
    metageneration = builder.metageneration;
    cors = builder.cors;
    acl = builder.acl;
    defaultAcl = builder.defaultAcl;
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public Cors cors() {
    return cors;
  }

  public Acl acl() {
    return acl;
  }

  public Acl defaultObjectAcl() {
    return defaultAcl;
  }

  public Builder toBuilder() {
    return builder(id, name, createTime, metageneration).cors(cors).acl(acl).defaultAcl(defaultAcl);
  }

  public static Builder builder(String id, String name, long createTime, long metageneration) {
    return new Builder(id, name, createTime, metageneration);
  }
}
