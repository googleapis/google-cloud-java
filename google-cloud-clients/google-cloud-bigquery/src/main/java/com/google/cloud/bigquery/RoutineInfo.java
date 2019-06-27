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

import com.google.api.services.bigquery.model.Routine;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

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
    private final Long lastModifiedTime;
    private final String language;
    private final List<RoutineArgument> argumentList;
    private final StandardSQLDataType returnType;
    private final List<String> importedLibrariesList;
    private final String body;

    public abstract static class Builder {
         abstract Builder setRoutineId(RoutineId id);
         abstract Builder setEtag(String etag);
         public abstract Builder setRoutineType(String routineType);
         abstract Builder setCreationTime(Long creationMillis);
         abstract Builder setLastModifiedTime(Long lastModifiedMillis);
         public abstract Builder setLanguage(String language);
         public abstract Builder setArguments(List<RoutineArgument> argumentList);
         public abstract Builder setReturnType(StandardSQLDataType returnType);
         public abstract Builder setImportedLibraries(List<String> importedLibrariesList);
         public abstract Builder setBody(String body);
         public abstract RoutineInfo build();
    }

    static class BuilderImpl extends Builder {
        private RoutineId routineId;
        private String etag;
        private String routineType;
        private Long creationTime;
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
            this.lastModifiedTime = routinePb.getLastModifiedTime();
            this.language = routinePb.getLanguage();
            if (routinePb.getArguments() != null) {
                this.argumentList = Lists.transform(routinePb.getArguments(), RoutineArgument.FROM_PB_FUNCTION);
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
        this.lastModifiedTime = builder.lastModifiedTime;
        this.language = builder.language;
        this.argumentList = builder.argumentList;
        this.returnType = builder.returnType;
        this.importedLibrariesList = builder.importedLibrariesList;
        this.body = builder.body;
    }

    public RoutineId getRoutineId() { return routineId; }

    public String getEtag() { return etag; }

    public String getRoutineType() { return routineType; }

    public Long getCreationTime() { return creationTime; }

    public Long getLastModifiedTime() { return lastModifiedTime; }

    public String getLanguage() { return language; }

    public List<RoutineArgument> getArguments() { return argumentList; }

    public StandardSQLDataType getReturnType() { return returnType; }

    public List<String> getImportedLibraries() { return importedLibrariesList; }

    public String getBody() { return body; }

    public Builder toBuilder() { return new BuilderImpl(this); }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("routineId", routineId)
                .add("etag", etag)
                .add("routineType", routineType)
                .add("creationTime", creationTime)
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
        Routine routinePb = new Routine()
                .setEtag(getEtag())
                .setRoutineType(getRoutineType())
                .setCreationTime(getCreationTime())
                .setLastModifiedTime(getLastModifiedTime())
                .setLanguage(getLanguage());
        if (getRoutineId() != null) {
            routinePb.setRoutineReference(getRoutineId().toPb());
        }
        if (getArguments() != null) {
            routinePb.setArguments(Lists.transform(getArguments(), RoutineArgument.TO_PB_FUNCTION));
        }
        return routinePb;
    }



    static RoutineInfo fromPb(Routine routinePb) {
            return new BuilderImpl(routinePb).build();
    }

}