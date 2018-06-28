package com.google.cloud.bigquery;


import com.google.auto.value.AutoValue;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class Clustering implements Serializable {

  private static final long serialVersionUID = 1L;

  @Nullable
  public abstract List<String> getFields();

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setFields(List<String> fields);

    public abstract Clustering build();
  }

  public static Builder newBuilder() {
    return new AutoValue_Clustering.Builder();
  }

  com.google.api.services.bigquery.model.Clustering toPb() {
    com.google.api.services.bigquery.model.Clustering clusterPb =
        new com.google.api.services.bigquery.model.Clustering();
    clusterPb.setFields(getFields());
    return clusterPb;
  }

  static Clustering fromPb(com.google.api.services.bigquery.model.Clustering clusterPb) {
    return newBuilder().setFields(clusterPb.getFields()).build();
  }

}
