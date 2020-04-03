/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Initial State for shielded instance, these are public keys which are safe to store in public */
public final class InitialStateConfig implements ApiMessage {
  private final List<FileContentBuffer> dbs;
  private final List<FileContentBuffer> dbxs;
  private final List<FileContentBuffer> keks;
  private final FileContentBuffer pk;

  private InitialStateConfig() {
    this.dbs = null;
    this.dbxs = null;
    this.keks = null;
    this.pk = null;
  }

  private InitialStateConfig(
      List<FileContentBuffer> dbs,
      List<FileContentBuffer> dbxs,
      List<FileContentBuffer> keks,
      FileContentBuffer pk) {
    this.dbs = dbs;
    this.dbxs = dbxs;
    this.keks = keks;
    this.pk = pk;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("dbs".equals(fieldName)) {
      return dbs;
    }
    if ("dbxs".equals(fieldName)) {
      return dbxs;
    }
    if ("keks".equals(fieldName)) {
      return keks;
    }
    if ("pk".equals(fieldName)) {
      return pk;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** The Key Database (db). */
  public List<FileContentBuffer> getDbsList() {
    return dbs;
  }

  /** The forbidden key database (dbx). */
  public List<FileContentBuffer> getDbxsList() {
    return dbxs;
  }

  /** The Key Exchange Key (KEK). */
  public List<FileContentBuffer> getKeksList() {
    return keks;
  }

  /** The Platform Key (PK). */
  public FileContentBuffer getPk() {
    return pk;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InitialStateConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InitialStateConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InitialStateConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InitialStateConfig();
  }

  public static class Builder {
    private List<FileContentBuffer> dbs;
    private List<FileContentBuffer> dbxs;
    private List<FileContentBuffer> keks;
    private FileContentBuffer pk;

    Builder() {}

    public Builder mergeFrom(InitialStateConfig other) {
      if (other == InitialStateConfig.getDefaultInstance()) return this;
      if (other.getDbsList() != null) {
        this.dbs = other.dbs;
      }
      if (other.getDbxsList() != null) {
        this.dbxs = other.dbxs;
      }
      if (other.getKeksList() != null) {
        this.keks = other.keks;
      }
      if (other.getPk() != null) {
        this.pk = other.pk;
      }
      return this;
    }

    Builder(InitialStateConfig source) {
      this.dbs = source.dbs;
      this.dbxs = source.dbxs;
      this.keks = source.keks;
      this.pk = source.pk;
    }

    /** The Key Database (db). */
    public List<FileContentBuffer> getDbsList() {
      return dbs;
    }

    /** The Key Database (db). */
    public Builder addAllDbs(List<FileContentBuffer> dbs) {
      if (this.dbs == null) {
        this.dbs = new LinkedList<>();
      }
      this.dbs.addAll(dbs);
      return this;
    }

    /** The Key Database (db). */
    public Builder addDbs(FileContentBuffer dbs) {
      if (this.dbs == null) {
        this.dbs = new LinkedList<>();
      }
      this.dbs.add(dbs);
      return this;
    }

    /** The forbidden key database (dbx). */
    public List<FileContentBuffer> getDbxsList() {
      return dbxs;
    }

    /** The forbidden key database (dbx). */
    public Builder addAllDbxs(List<FileContentBuffer> dbxs) {
      if (this.dbxs == null) {
        this.dbxs = new LinkedList<>();
      }
      this.dbxs.addAll(dbxs);
      return this;
    }

    /** The forbidden key database (dbx). */
    public Builder addDbxs(FileContentBuffer dbxs) {
      if (this.dbxs == null) {
        this.dbxs = new LinkedList<>();
      }
      this.dbxs.add(dbxs);
      return this;
    }

    /** The Key Exchange Key (KEK). */
    public List<FileContentBuffer> getKeksList() {
      return keks;
    }

    /** The Key Exchange Key (KEK). */
    public Builder addAllKeks(List<FileContentBuffer> keks) {
      if (this.keks == null) {
        this.keks = new LinkedList<>();
      }
      this.keks.addAll(keks);
      return this;
    }

    /** The Key Exchange Key (KEK). */
    public Builder addKeks(FileContentBuffer keks) {
      if (this.keks == null) {
        this.keks = new LinkedList<>();
      }
      this.keks.add(keks);
      return this;
    }

    /** The Platform Key (PK). */
    public FileContentBuffer getPk() {
      return pk;
    }

    /** The Platform Key (PK). */
    public Builder setPk(FileContentBuffer pk) {
      this.pk = pk;
      return this;
    }

    public InitialStateConfig build() {

      return new InitialStateConfig(dbs, dbxs, keks, pk);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllDbs(this.dbs);
      newBuilder.addAllDbxs(this.dbxs);
      newBuilder.addAllKeks(this.keks);
      newBuilder.setPk(this.pk);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InitialStateConfig{"
        + "dbs="
        + dbs
        + ", "
        + "dbxs="
        + dbxs
        + ", "
        + "keks="
        + keks
        + ", "
        + "pk="
        + pk
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InitialStateConfig) {
      InitialStateConfig that = (InitialStateConfig) o;
      return Objects.equals(this.dbs, that.getDbsList())
          && Objects.equals(this.dbxs, that.getDbxsList())
          && Objects.equals(this.keks, that.getKeksList())
          && Objects.equals(this.pk, that.getPk());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dbs, dbxs, keks, pk);
  }
}
