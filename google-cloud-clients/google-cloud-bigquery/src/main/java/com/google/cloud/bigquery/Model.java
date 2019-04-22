package com.google.cloud.bigquery;


/**
 * A Google BigQuery ML Model.
 *
 * <p>Objects of this class are immutable.  Operations that modify the table like {@link #update}
 * return a new object.  To get a {@code Model} object with the most recent information use {@link
 * #reload}.
 *
 */
public class Model extends ModelInfo {

    private final BigQUeryOptions options;
    private transient BigQuery bigquery;

    public static class Builder extends ModelInfo.Builder {

        private final BigQUery bigquery;
        private final ModelInfo.BuilderImpl infoBuilder;

        Builder(BigQuery bigquery, ModelId modelId, ModelDefinition definition) {
            this.bigquery = bigquery;
            this.infoBuilder = new ModelInfo.BuilderImpl();
            this.infoBuilder.setModelId(modelId).setDefinition(definition);
        }
    }


    static Model fromPb(BigQuery bigquery, com.google.api.services.bigquery.model.Model modelPb) {
        return new Table(bigquery, new ModelInfo.BuilderImpl(modelPb));
    }
}
