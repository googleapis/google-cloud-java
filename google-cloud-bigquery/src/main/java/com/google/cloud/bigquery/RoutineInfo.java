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

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.Routine;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery routine information. A Routine is an API abstraction that encapsulates several
 * related concepts inside the BigQuery service, including scalar user defined functions (UDFS) and
 * stored procedures.
 *
 * <p>For more information about the REST representation of routines, see:
 * https://cloud.google.com/bigquery/docs/reference/rest/v2/routines
 *
 * <p>For more information about working with scalar functions, see:
 * https://cloud.google.com/bigquery/docs/reference/standard-sql/user-defined-functions
 */
public class RoutineInfo implements Serializable {

  static final Function<Routine, RoutineInfo> FROM_PB_FUNCTION =
      new Function<Routine, RoutineInfo>() {
        @Override
        public RoutineInfo apply(Routine pb) {
          return RoutineInfo.fromPb(pb);
        }
      };
  static final Function<RoutineInfo, Routine> TO_PB_FUNCTION =
      new Function<RoutineInfo, Routine>() {
        @Override
        public Routine apply(RoutineInfo routineInfo) {
          return routineInfo.toPb();
        }
      };

  private final RoutineId routineId;
  private final String etag;
  private final String routineType;
  private final Long creationTime;
  private final String description;
  private final String determinismLevel;
  private final Long lastModifiedTime;
  private final String language;
  private final List<RoutineArgument> argumentList;
  private final StandardSQLDataType returnType;
  private final List<String> importedLibrariesList;
  private final String body;

  public abstract static class Builder {

    abstract Builder setRoutineId(RoutineId id);

    abstract Builder setEtag(String etag);

    /**
     * Sets the routine type for the Builder (e.g. SCALAR_FUNCTION).
     *
     * <p>See https://cloud.google.com/bigquery/docs/reference/rest/v2/routines
     */
    public abstract Builder setRoutineType(String routineType);

    abstract Builder setCreationTime(Long creationMillis);

    /** Sets the description for the routine. */
    abstract Builder setDescription(String description);

    abstract Builder setLastModifiedTime(Long lastModifiedMillis);

    /**
     * Sets the JavaScript UDF determinism levels (e.g. DETERMINISM_LEVEL_UNSPECIFIED,
     * DETERMINISTIC, NOT_DETERMINISTIC) only applicable to Javascript UDFs.
     */
    public abstract Builder setDeterminismLevel(String determinismLevel);

    /** Sets the language for the routine (e.g. SQL or JAVASCRIPT) */
    public abstract Builder setLanguage(String language);

    /** Specifies the list of input/output arguments for the routine. */
    public abstract Builder setArguments(List<RoutineArgument> argumentList);

    /**
     * Sets the return type of the routine.
     *
     * <p>Optional if language = "SQL"; required otherwise.
     *
     * <p>If absent, the return type is inferred from definitionBody at query time in each query
     * that references this routine. If present, then the evaluated result will be cast to the
     * specified returned type at query time.
     */
    public abstract Builder setReturnType(StandardSQLDataType returnType);

    /**
     * Optional. If language = "JAVASCRIPT", this field stores the path of the imported JAVASCRIPT
     * libraries as a list of gs:// URLs.
     */
    public abstract Builder setImportedLibraries(List<String> importedLibrariesList);

    /**
     * Required. The body of the routine.
     *
     * <p>For functions, this is the expression in the AS clause.
     *
     * <p>If language=SQL, it is the substring inside (but excluding) the parentheses. For example,
     * for the function created with the following statement:
     *
     * <p>CREATE FUNCTION JoinLines(x string, y string) as (concat(x, "\n", y))
     *
     * <p>The definitionBody is concat(x, "\n", y) (\n is not replaced with linebreak).
     *
     * <p>If language=JAVASCRIPT, it is the evaluated string in the AS clause. For example, for the
     * function created with the following statement:
     *
     * <p>CREATE FUNCTION f() RETURNS STRING LANGUAGE js AS 'return "\n";\n'
     *
     * <p>The definitionBody is
     *
     * <p>return "\n";\n
     *
     * <p>Note that both \n are replaced with linebreaks.
     */
    public abstract Builder setBody(String body);

    /** Creates a {@code RoutineInfo} object. */
    public abstract RoutineInfo build();
  }

  static class BuilderImpl extends Builder {
    private RoutineId routineId;
    private String etag;
    private String routineType;
    private Long creationTime;
    private String description;
    private String determinismLevel;
    private Long lastModifiedTime;
    private String language;
    private List<RoutineArgument> argumentList;
    private StandardSQLDataType returnType;
    private List<String> importedLibrariesList;
    private String body;

    BuilderImpl() {}

    BuilderImpl(RoutineInfo routineInfo) {
      this.routineId = routineInfo.routineId;
      this.etag = routineInfo.etag;
      this.routineType = routineInfo.routineType;
      this.creationTime = routineInfo.creationTime;
      this.description = routineInfo.description;
      this.determinismLevel = routineInfo.determinismLevel;
      this.lastModifiedTime = routineInfo.lastModifiedTime;
      this.language = routineInfo.language;
      this.argumentList = routineInfo.argumentList;
      this.returnType = routineInfo.returnType;
      this.importedLibrariesList = routineInfo.importedLibrariesList;
      this.body = routineInfo.body;
    }

    BuilderImpl(Routine routinePb) {
      this.routineId = RoutineId.fromPb(routinePb.getRoutineReference());
      this.etag = routinePb.getEtag();
      this.routineType = routinePb.getRoutineType();
      this.creationTime = routinePb.getCreationTime();
      this.description = routinePb.getDescription();
      this.determinismLevel = routinePb.getDeterminismLevel();
      this.lastModifiedTime = routinePb.getLastModifiedTime();
      this.language = routinePb.getLanguage();
      if (routinePb.getArguments() != null) {
        this.argumentList =
            Lists.transform(routinePb.getArguments(), RoutineArgument.FROM_PB_FUNCTION);
      }
      if (routinePb.getReturnType() != null) {
        this.returnType = StandardSQLDataType.fromPb(routinePb.getReturnType());
      }
      if (routinePb.getImportedLibraries() == null) {
        this.importedLibrariesList = Collections.emptyList();
      } else {
        this.importedLibrariesList = routinePb.getImportedLibraries();
      }
      this.body = routinePb.getDefinitionBody();
    }

    @Override
    Builder setRoutineId(RoutineId id) {
      this.routineId = id;
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    public Builder setRoutineType(String routineType) {
      this.routineType = routineType;
      return this;
    }

    @Override
    Builder setCreationTime(Long creationMillis) {
      this.creationTime = creationMillis;
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    public Builder setDeterminismLevel(String determinismLevel) {
      this.determinismLevel = determinismLevel;
      return this;
    }

    @Override
    Builder setLastModifiedTime(Long lastModifiedMillis) {
      this.lastModifiedTime = lastModifiedMillis;
      return this;
    }

    @Override
    public Builder setLanguage(String language) {
      this.language = language;
      return this;
    }

    @Override
    public Builder setArguments(List<RoutineArgument> argumentList) {
      this.argumentList = argumentList;
      return this;
    }

    @Override
    public Builder setReturnType(StandardSQLDataType returnType) {
      this.returnType = returnType;
      return this;
    }

    @Override
    public Builder setImportedLibraries(List<String> importedLibrariesList) {
      this.importedLibrariesList = importedLibrariesList;
      return this;
    }

    @Override
    public Builder setBody(String body) {
      this.body = body;
      return this;
    }

    @Override
    public RoutineInfo build() {
      return new RoutineInfo(this);
    }
  }

  RoutineInfo(BuilderImpl builder) {
    this.routineId = checkNotNull(builder.routineId);
    this.etag = builder.etag;
    this.routineType = builder.routineType;
    this.creationTime = builder.creationTime;
    this.description = builder.description;
    this.determinismLevel = builder.determinismLevel;
    this.lastModifiedTime = builder.lastModifiedTime;
    this.language = builder.language;
    this.argumentList = builder.argumentList;
    this.returnType = builder.returnType;
    this.importedLibrariesList = builder.importedLibrariesList;
    this.body = builder.body;
  }

  /** Returns the RoutineId identified for the routine resource. * */
  public RoutineId getRoutineId() {
    return routineId;
  }

  /** Returns the hash of the routine resource. */
  public String getEtag() {
    return etag;
  }

  /** Returns the type of the routine, e.g. SCALAR_FUNCTION. */
  public String getRoutineType() {
    return routineType;
  }

  /** Returns the creation time of the routine, represented as milliseconds since the epoch. */
  public Long getCreationTime() {
    return creationTime;
  }

  /** Returns the description of the routine. */
  public String getDescription() {
    return description;
  }

  /** Returns the determinism level of the JavaScript UDF if defined. */
  public String getDeterminismLevel() {
    return determinismLevel;
  }

  /**
   * Returns the last modification time of the routine, represented as milliseconds since the epoch.
   */
  public Long getLastModifiedTime() {
    return lastModifiedTime;
  }

  /**
   * Returns the language of the routine. Currently supported languages include SQL and JAVASCRIPT.
   */
  public String getLanguage() {
    return language;
  }

  /** Returns the list of arguments for the routine. */
  public List<RoutineArgument> getArguments() {
    return argumentList;
  }

  /** If specified, returns the data type returned from the routine. */
  public StandardSQLDataType getReturnType() {
    return returnType;
  }

  /**
   * Returns the list of imported libraries for the routine. Only relevant for routines implemented
   * using the JAVASCRIPT language.
   */
  public List<String> getImportedLibraries() {
    return importedLibrariesList;
  }

  /** Returns the definition body of the routine. */
  public String getBody() {
    return body;
  }

  /** Returns a builder pre-populated using the current values of this routine. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("routineId", routineId)
        .add("etag", etag)
        .add("routineType", routineType)
        .add("creationTime", creationTime)
        .add("description", description)
        .add("determinismLevel", determinismLevel)
        .add("lastModifiedTime", lastModifiedTime)
        .add("language", language)
        .add("arguments", argumentList)
        .add("returnType", returnType)
        .add("importedLibrariesList", importedLibrariesList)
        .add("body", body)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        routineId,
        etag,
        routineType,
        creationTime,
        description,
        determinismLevel,
        lastModifiedTime,
        language,
        argumentList,
        returnType,
        importedLibrariesList,
        body);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(RoutineInfo.class)
            && Objects.equals(toPb(), ((RoutineInfo) obj).toPb());
  }

  /** Returns a builder for a {@code RoutineInfo} object given routine identity. */
  public static Builder newBuilder(RoutineId routineId) {
    return new BuilderImpl().setRoutineId(routineId);
  }

  /** Returns a {@code RoutineInfo} object given routine identity. */
  public static RoutineInfo of(RoutineId routineId) {
    return newBuilder(routineId).build();
  }

  RoutineInfo setProjectId(String projectId) {
    if (Strings.isNullOrEmpty(getRoutineId().getProject())) {
      return toBuilder().setRoutineId(getRoutineId().setProjectId(projectId)).build();
    }
    return this;
  }

  Routine toPb() {
    Routine routinePb =
        new Routine()
            .setEtag(getEtag())
            .setRoutineType(getRoutineType())
            .setDefinitionBody(getBody())
            .setCreationTime(getCreationTime())
            .setDescription(getDescription())
            .setDeterminismLevel(getDeterminismLevel())
            .setLastModifiedTime(getLastModifiedTime())
            .setLanguage(getLanguage());
    if (getRoutineId() != null) {
      routinePb.setRoutineReference(getRoutineId().toPb());
    }
    if (getArguments() != null) {
      routinePb.setArguments(Lists.transform(getArguments(), RoutineArgument.TO_PB_FUNCTION));
    }
    if (getReturnType() != null) {
      routinePb.setReturnType(getReturnType().toPb());
    }
    return routinePb;
  }

  static RoutineInfo fromPb(Routine routinePb) {
    return new BuilderImpl(routinePb).build();
  }
}
