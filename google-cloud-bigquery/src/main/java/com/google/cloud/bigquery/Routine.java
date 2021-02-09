/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.bigquery.BigQuery.RoutineOption;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

/**
 * A Google BigQuery Routine.
 *
 * <p>Objects of this class are immutable. Operations that modify the routine like {@link #update}
 * return a new object. To get a {@code routine} object with the most recent information use {@link
 * #reload}.
 */
public class Routine extends RoutineInfo {

  private final BigQueryOptions options;
  private transient BigQuery bigquery;

  public static class Builder extends RoutineInfo.Builder {

    private final BigQuery bigquery;
    private final RoutineInfo.BuilderImpl infoBuilder;

    Builder(BigQuery bigquery, RoutineId routineId) {
      this.bigquery = bigquery;
      this.infoBuilder = new RoutineInfo.BuilderImpl();
      this.infoBuilder.setRoutineId(routineId);
    }

    Builder(Routine routine) {
      this.bigquery = routine.bigquery;
      this.infoBuilder = new RoutineInfo.BuilderImpl(routine);
    }

    @Override
    Builder setRoutineId(RoutineId id) {
      infoBuilder.setRoutineId(id);
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    @Override
    public Builder setRoutineType(String routineType) {
      infoBuilder.setRoutineType(routineType);
      return this;
    }

    @Override
    Builder setCreationTime(Long creationMillis) {
      infoBuilder.setCreationTime(creationMillis);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      infoBuilder.setDescription(description);
      return this;
    }

    @Override
    Builder setLastModifiedTime(Long lastModifiedMillis) {
      infoBuilder.setLastModifiedTime(lastModifiedMillis);
      return this;
    }

    @Override
    public Builder setDeterminismLevel(String determinismLevel) {
      infoBuilder.setDeterminismLevel(determinismLevel);
      return this;
    }

    @Override
    public Builder setLanguage(String language) {
      infoBuilder.setLanguage(language);
      return this;
    }

    @Override
    public Builder setArguments(List<RoutineArgument> arguments) {
      infoBuilder.setArguments(arguments);
      return this;
    }

    @Override
    public Builder setReturnType(StandardSQLDataType returnType) {
      infoBuilder.setReturnType(returnType);
      return this;
    }

    @Override
    public Builder setImportedLibraries(List<String> libraries) {
      infoBuilder.setImportedLibraries(libraries);
      return this;
    }

    @Override
    public Builder setBody(String body) {
      infoBuilder.setBody(body);
      return this;
    }

    @Override
    public Routine build() {
      return new Routine(bigquery, infoBuilder);
    }
  }

  Routine(BigQuery bigquery, RoutineInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.bigquery = checkNotNull(bigquery);
    this.options = bigquery.getOptions();
  }

  /** Checks if this routine exists. */
  public boolean exists() {
    return bigquery.getRoutine(getRoutineId(), RoutineOption.fields()) != null;
  }

  /**
   * Fetches this routine's latest information. Returns {@code null} if the routine does not exist.
   */
  public Routine reload(RoutineOption... options) {
    return bigquery.getRoutine(getRoutineId(), options);
  }

  /**
   * Update's the routine's information with this Routine's information. This method does not allow
   * changing the RoutineId identifier of the routine. A new {@code Routine} is returned.
   */
  public Routine update(RoutineOption... options) {
    return bigquery.update(this, options);
  }

  /**
   * Deletes this routine.
   *
   * @return {@code true} if routine was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete() {
    return bigquery.delete(getRoutineId());
  }

  /** Returns the routine's {@code BigQuery} object used to issue requests. */
  public BigQuery getBigQuery() {
    return bigquery;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Routine.class)) {
      return false;
    }
    Routine other = (Routine) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.getService();
  }

  static Routine fromPb(
      BigQuery bigquery, com.google.api.services.bigquery.model.Routine routinePb) {
    return new Routine(bigquery, new RoutineInfo.BuilderImpl(routinePb));
  }
}
