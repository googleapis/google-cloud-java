/**
 * A client to the Google Cloud Datastore.
 * Typical usage would be:
 * <pre> {@code
 * DatastoreServiceOptions options = new DatastoreServiceOptions.Builder().dataset(DATASET).build();
 * DatastoreService datastore = DatastoreServiceFactory.getDefault(options);
 * KeyBuilder keyBuilder = datastore.newKeyBuilder(kind);
 * Key key = keyBuilder.build(keyName);
 * Entity entity = datastore.get(key);
 * if (entity == null) {
 *   entity = new Entity.Builder(key)
 *       .setProperty("name", new StringValue("John Do"))
 *       .setProperty("age", new LongValue.Builder(100).indexed(false).build())
 *       .setProperty("updated", new BooleanValue(false))
 *       .build();
 *   datastore.put(entity);
 * } else {
 *   BooleanValue updated = entity.property("updated");
 *   if (!updated.get()) {
 *     entity = entity.builder()
 *         .setProperty("updated", new BooleanValue(true))
 *         .removeProperty("old_property")
 *         .setProperty("new_property", new DoubleValue(1.1))
 *         .build();
 *     datastore.update(entity);
 *   }
 * }
 * } </pre>
 *
 */
package com.google.gcloud.datastore;
