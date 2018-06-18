package com.google.cloud.bigquery;


import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.io.Serializable;

public class BigtableColumn implements Serializable {


  static final Function<com.google.api.services.bigquery.model.BigtableColumn, BigtableColumn> FROM_PB_FUNCTION =
      new Function<com.google.api.services.bigquery.model.BigtableColumn, BigtableColumn>() {
        @Override
        public BigtableColumn apply(
            com.google.api.services.bigquery.model.BigtableColumn pb) {
          return BigtableColumn.fromPb(pb);
        }
      };

  static final Function<BigtableColumn, com.google.api.services.bigquery.model.BigtableColumn> TO_PB_FUNCTION =
      new Function<BigtableColumn, com.google.api.services.bigquery.model.BigtableColumn>() {
        @Override
        public com.google.api.services.bigquery.model.BigtableColumn apply(
            BigtableColumn column) {
          return column.toPb();
        }
      };

  private static final long serialVersionUID = 1L;

  public String getQualifierEncoded() { return qualifierEncoded; }
  public String getFieldName() { return fieldName; }
  public Boolean getOnlyReadLatest() { return onlyReadLatest; }
  public String getEncoding() { return encoding; }
  public String getType() { return type; }

  private final String qualifierEncoded;
  private final String fieldName;
  private final Boolean onlyReadLatest;
  private final String encoding;
  private final String type;

  static final class Builder {
    private String qualifierEncoded;
    private String fieldName;
    private Boolean onlyReadLatest;
    private String encoding;
    private String type;

    private Builder() {}

    /**
     * Qualifier of the column.
     *
     * Columns in the parent column family that has this exact qualifier are exposed
     * as . field. If the qualifier is valid UTF-8 string, it can be specified in the
     * qualifier_string field. Otherwise, a base-64 encoded value must be set to qualifier_encoded. The column field name is the same as the
     * column qualifier. However, if the qualifier is not a valid BigQuery field
     * identifier, a valid identifier must be provided as field_name.
     */
    Builder setQualifierEncoded(String qualifierEncoded) {
      this.qualifierEncoded = qualifierEncoded;
      return this;
    }

    /**
     * If the qualifier is not a valid BigQuery field identifier, a valid identifier must
     * be provided as the column field name and is used as field name in queries.
     */
    Builder setFieldName(String fieldName) {
      this.fieldName = fieldName;
      return this;
    }

    /**
     * If this is set, only the latest version of value in this column are exposed.
     *
     * 'onlyReadLatest' can also be set at the column family level. However, the setting
     * at the column level takes precedence if 'onlyReadLatest' is set at both levels.
     */
    Builder setOnlyReadLatest(Boolean onlyReadLatest) {
      this.onlyReadLatest = onlyReadLatest;
      return this;
    }

    /**
     * The encoding of the values when the type is not STRING.
     * Acceptable encoding values are:
     * TEXT - indicates values are alphanumeric text strings.
     * BINARY - indicates values are encoded using HBase Bytes.toBytes family of functions.
     *
     * Encoding can also be set at the column family level. However, the setting at the
     * column level takes precedence if 'encoding' is set at both levels.
     */
    Builder setEncoding(String encoding) {
      this.encoding = encoding;
      return this;
    }

    /**
     * The type to convert the value in cells of this column.
     *
     * The values are expected to be encoded using HBase Bytes.toBytes function when using
     * the BINARY encoding value. Following BigQuery types are allowed (case-sensitive):
     * BYTES STRING INTEGER FLOAT BOOLEAN Default type is BYTES.
     *
     * 'type' can also be set at the column family level. However, the setting at the column
     * level takes precedence if 'type' is set at both levels.
     *
     */
    Builder setType(String type) {
      this.type = type;
      return this;
    }

    BigtableColumn build() {return new BigtableColumn(this);}
  }

  BigtableColumn(Builder builder) {
    qualifierEncoded = builder.qualifierEncoded;
    fieldName = builder.fieldName;
    onlyReadLatest = builder.onlyReadLatest;
    encoding = builder.encoding;
    type = builder.type;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("qualifierEncoded", qualifierEncoded)
        .add("fieldName", fieldName)
        .add("onlyReadLatest", onlyReadLatest)
        .add("encoding", encoding)
        .add("type", type)
        .toString();
  }

  static BigtableColumn fromPb(com.google.api.services.bigquery.model.BigtableColumn column) {
    Builder builder = new BigtableColumn.Builder();
    builder.setQualifierEncoded(column.getQualifierEncoded());
    builder.setFieldName(column.getFieldName());
    builder.setOnlyReadLatest(column.getOnlyReadLatest());
    builder.setEncoding(column.getEncoding());
    builder.setType(column.getType());
    return builder.build();
  }

  com.google.api.services.bigquery.model.BigtableColumn toPb() {
    com.google.api.services.bigquery.model.BigtableColumn column = new com.google.api.services.bigquery.model.BigtableColumn()
        .setQualifierEncoded(qualifierEncoded)
        .setFieldName(fieldName)
        .setOnlyReadLatest(onlyReadLatest)
        .setEncoding(encoding)
        .setType(type);
    return column;
  }
}
