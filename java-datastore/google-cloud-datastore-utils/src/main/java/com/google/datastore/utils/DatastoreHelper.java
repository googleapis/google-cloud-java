/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.datastore.v1.ArrayValue;
import com.google.datastore.v1.CompositeFilter;
import com.google.datastore.v1.Entity;
import com.google.datastore.v1.Filter;
import com.google.datastore.v1.Key;
import com.google.datastore.v1.Key.PathElement;
import com.google.datastore.v1.Key.PathElement.IdTypeCase;
import com.google.datastore.v1.Mutation;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyFilter;
import com.google.datastore.v1.PropertyOrder;
import com.google.datastore.v1.PropertyReference;
import com.google.datastore.v1.Value;
import com.google.datastore.v1.Value.ValueTypeCase;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.type.LatLng;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Helper methods for {@link Datastore}. */
// TODO: Accept OrBuilders when possible.
public final class DatastoreHelper {
  private static final Logger logger =
      Logger.getLogger(com.google.datastore.utils.DatastoreHelper.class.getName());

  private static final int MICROSECONDS_PER_SECOND = 1000 * 1000;
  private static final int NANOSECONDS_PER_MICROSECOND = 1000;

  /** The property used in the Datastore to give us a random distribution. * */
  public static final String SCATTER_PROPERTY_NAME = "__scatter__";

  /** The property used in the Datastore to get the key of the entity. * */
  public static final String KEY_PROPERTY_NAME = "__key__";

  /** Name of the environment variable used to set the project ID. */
  public static final String PROJECT_ID_ENV_VAR = "DATASTORE_PROJECT_ID";

  /** Name of the environment variable used to set the local host. */
  public static final String LOCAL_HOST_ENV_VAR = "DATASTORE_EMULATOR_HOST";

  /** Name of the environment variable used to set the service account. */
  public static final String SERVICE_ACCOUNT_ENV_VAR = "DATASTORE_SERVICE_ACCOUNT";

  /** Name of the environment variable used to set the private key file. */
  public static final String PRIVATE_KEY_FILE_ENV_VAR = "DATASTORE_PRIVATE_KEY_FILE";

  private static final String URL_OVERRIDE_ENV_VAR = "__DATASTORE_URL_OVERRIDE";

  private static final AtomicReference<String> projectIdFromComputeEngine = new AtomicReference<>();

  /** Comparator for Keys */
  private static final class KeyComparator implements Comparator<Key> {

    static final com.google.datastore.utils.DatastoreHelper.KeyComparator INSTANCE =
        new com.google.datastore.utils.DatastoreHelper.KeyComparator();

    private int comparePathElement(PathElement thisElement, PathElement otherElement) {
      int result = thisElement.getKind().compareTo(otherElement.getKind());
      if (result != 0) {
        return result;
      }
      if (thisElement.getIdTypeCase() == IdTypeCase.ID) {
        if (otherElement.getIdTypeCase() != IdTypeCase.ID) {
          return -1;
        }
        return Long.valueOf(thisElement.getId()).compareTo(otherElement.getId());
      }
      if (otherElement.getIdTypeCase() == IdTypeCase.ID) {
        return 1;
      }

      return thisElement.getName().compareTo(otherElement.getName());
    }

    @Override
    public int compare(Key thisKey, Key otherKey) {
      if (!thisKey.getPartitionId().equals(otherKey.getPartitionId())) {
        throw new IllegalArgumentException("Cannot compare keys with different partition ids.");
      }

      Iterator<PathElement> thisPath = thisKey.getPathList().iterator();
      Iterator<PathElement> otherPath = otherKey.getPathList().iterator();
      while (thisPath.hasNext()) {
        if (!otherPath.hasNext()) {
          return 1;
        }
        int result = comparePathElement(thisPath.next(), otherPath.next());
        if (result != 0) {
          return result;
        }
      }

      return otherPath.hasNext() ? -1 : 0;
    }
  }

  private DatastoreHelper() {}

  private static HttpTransport newTransport() throws GeneralSecurityException, IOException {
    return GoogleNetHttpTransport.newTrustedTransport();
  }

  static JsonFactory newJsonFactory() {
    return new GsonFactory();
  }

  /**
   * Constructs credentials for the given account and key.
   *
   * @param serviceAccountId service account ID (typically an e-mail address).
   * @param privateKeyFile the file name from which to get the private key.
   * @return valid credentials or {@code null}
   */
  public static Credential getServiceAccountCredential(
      String serviceAccountId, String privateKeyFile) throws GeneralSecurityException, IOException {
    return getServiceAccountCredential(serviceAccountId, privateKeyFile, DatastoreOptions.SCOPES);
  }

  /**
   * Constructs credentials for the given account and key file.
   *
   * @param serviceAccountId service account ID (typically an e-mail address).
   * @param privateKeyFile the file name from which to get the private key.
   * @param serviceAccountScopes Collection of OAuth scopes to use with the the service account flow
   *     or {@code null} if not.
   * @return valid credentials or {@code null}
   */
  public static Credential getServiceAccountCredential(
      String serviceAccountId, String privateKeyFile, Collection<String> serviceAccountScopes)
      throws GeneralSecurityException, IOException {
    return getCredentialBuilderWithoutPrivateKey(serviceAccountId, serviceAccountScopes)
        .setServiceAccountPrivateKeyFromP12File(new File(privateKeyFile))
        .build();
  }

  /**
   * Constructs credentials for the given account and key.
   *
   * @param serviceAccountId service account ID (typically an e-mail address).
   * @param privateKey the private key for the given account.
   * @param serviceAccountScopes Collection of OAuth scopes to use with the the service account flow
   *     or {@code null} if not.
   * @return valid credentials or {@code null}
   */
  public static Credential getServiceAccountCredential(
      String serviceAccountId, PrivateKey privateKey, Collection<String> serviceAccountScopes)
      throws GeneralSecurityException, IOException {
    return getCredentialBuilderWithoutPrivateKey(serviceAccountId, serviceAccountScopes)
        .setServiceAccountPrivateKey(privateKey)
        .build();
  }

  private static GoogleCredential.Builder getCredentialBuilderWithoutPrivateKey(
      String serviceAccountId, Collection<String> serviceAccountScopes)
      throws GeneralSecurityException, IOException {
    HttpTransport transport = newTransport();
    JsonFactory jsonFactory = newJsonFactory();
    return new GoogleCredential.Builder()
        .setTransport(transport)
        .setJsonFactory(jsonFactory)
        .setServiceAccountId(serviceAccountId)
        .setServiceAccountScopes(serviceAccountScopes);
  }

  /**
   * Constructs a {@link Datastore} from environment variables and/or the Compute Engine metadata
   * server.
   *
   * <p>The project ID is determined from, in order of preference:
   *
   * <ul>
   *   <li>DATASTORE_PROJECT_ID environment variable
   *   <li>Compute Engine
   * </ul>
   *
   * <p>Credentials are taken from, in order of preference:
   *
   * <ol>
   *   <li>No credentials (if the DATASTORE_EMULATOR_HOST environment variable is set)
   *   <li>Service Account specified by the DATASTORE_SERVICE_ACCOUNT and DATASTORE_PRIVATE_KEY_FILE
   *       environment variables
   *   <li>Google Application Default as described <a
   *       href="https://cloud.google.com/docs/authentication/production">here</a>.
   * </ol>
   */
  public static DatastoreOptions.Builder getOptionsFromEnv()
      throws GeneralSecurityException, IOException {
    DatastoreOptions.Builder options = new DatastoreOptions.Builder();
    setProjectEndpointFromEnv(options);
    options.credential(getCredentialFromEnv());
    return options;
  }

  private static Credential getCredentialFromEnv() throws GeneralSecurityException, IOException {
    if (System.getenv(LOCAL_HOST_ENV_VAR) != null) {
      logger.log(
          Level.INFO,
          "{0} environment variable was set. Not using credentials.",
          new Object[] {LOCAL_HOST_ENV_VAR});
      return null;
    }
    String serviceAccount = System.getenv(SERVICE_ACCOUNT_ENV_VAR);
    String privateKeyFile = System.getenv(PRIVATE_KEY_FILE_ENV_VAR);
    if (serviceAccount != null && privateKeyFile != null) {
      logger.log(
          Level.INFO,
          "{0} and {1} environment variables were set. " + "Using service account credential.",
          new Object[] {SERVICE_ACCOUNT_ENV_VAR, PRIVATE_KEY_FILE_ENV_VAR});
      return getServiceAccountCredential(serviceAccount, privateKeyFile);
    }
    return GoogleCredential.getApplicationDefault().createScoped(DatastoreOptions.SCOPES);
  }

  /**
   * Determines the project id from the environment. Uses the following sources in order of
   * preference:
   *
   * <ol>
   *   <li>Value of the DATASTORE_PROJECT_ID environment variable
   *   <li>Compute Engine
   * </ol>
   *
   * @throws IllegalStateException if the project ID cannot be determined
   */
  private static String getProjectIdFromEnv() {
    if (System.getenv(PROJECT_ID_ENV_VAR) != null) {
      return System.getenv(PROJECT_ID_ENV_VAR);
    }
    String projectIdFromComputeEngine = getProjectIdFromComputeEngine();
    if (projectIdFromComputeEngine != null) {
      return projectIdFromComputeEngine;
    }
    throw new IllegalStateException(
        String.format(
            "Could not determine project ID."
                + " If you are not running on Compute Engine, set the"
                + " %s environment variable.",
            PROJECT_ID_ENV_VAR));
  }

  /**
   * Gets the project ID from the Compute Engine metadata server. Returns {@code null} if the
   * project ID cannot be determined (because, for instance, the code is not running on Compute
   * Engine).
   */
  @Nullable
  public static String getProjectIdFromComputeEngine() {
    String cachedProjectId = projectIdFromComputeEngine.get();
    return cachedProjectId != null ? cachedProjectId : queryProjectIdFromComputeEngine();
  }

  @Nullable
  private static String queryProjectIdFromComputeEngine() {
    HttpTransport transport;

    try {
      transport = newTransport();
    } catch (GeneralSecurityException | IOException e) {
      logger.log(Level.WARNING, "Failed to create HttpTransport.", e);
      return null;
    }

    try {
      GenericUrl projectIdUrl =
          new GenericUrl("http://metadata/computeMetadata/v1/project/project-id");
      HttpRequest request = transport.createRequestFactory().buildGetRequest(projectIdUrl);
      request.getHeaders().set("Metadata-Flavor", "Google");
      String result = request.execute().parseAsString();
      projectIdFromComputeEngine.set(result);
      return result;
    } catch (IOException e) {
      logger.log(Level.INFO, "Could not determine project ID from Compute Engine.", e);
      return null;
    }
  }

  private static void setProjectEndpointFromEnv(DatastoreOptions.Builder options) {
    // DATASTORE_HOST is deprecated.
    if (System.getenv("DATASTORE_HOST") != null) {
      logger.warning(
          String.format(
              "Ignoring value of environment variable DATASTORE_HOST. "
                  + "To point datastore to a host running locally, use "
                  + "the environment variable %s.",
              LOCAL_HOST_ENV_VAR));
    }
    String projectId = getProjectIdFromEnv();
    if (System.getenv(URL_OVERRIDE_ENV_VAR) != null) {
      options.projectEndpoint(
          String.format("%s/projects/%s", System.getenv(URL_OVERRIDE_ENV_VAR), projectId));
      return;
    }
    if (System.getenv(LOCAL_HOST_ENV_VAR) != null) {
      options.projectId(projectId);
      options.localHost(System.getenv(LOCAL_HOST_ENV_VAR));
      return;
    }
    options.projectId(projectId);
    return;
  }

  /**
   * @see #getOptionsFromEnv()
   */
  public static Datastore getDatastoreFromEnv() throws GeneralSecurityException, IOException {
    return DatastoreFactory.get().create(getOptionsFromEnv().build());
  }

  /**
   * Gets a {@link com.google.datastore.utils.QuerySplitter}.
   *
   * <p>The returned {@link com.google.datastore.utils.QuerySplitter#getSplits} cannot accept a
   * query that contains inequality filters, a sort filter, or a missing kind.
   */
  public static QuerySplitter getQuerySplitter() {
    return com.google.datastore.utils.QuerySplitterImpl.INSTANCE;
  }

  public static Comparator<Key> getKeyComparator() {
    return com.google.datastore.utils.DatastoreHelper.KeyComparator.INSTANCE;
  }

  /** Make a sort order for use in a query. */
  public static PropertyOrder.Builder makeOrder(
      String property, PropertyOrder.Direction direction) {
    return PropertyOrder.newBuilder()
        .setProperty(makePropertyReference(property))
        .setDirection(direction);
  }

  /** Makes an ancestor filter. */
  public static Filter.Builder makeAncestorFilter(Key ancestor) {
    return makeFilter(
        com.google.datastore.utils.DatastoreHelper.KEY_PROPERTY_NAME,
        PropertyFilter.Operator.HAS_ANCESTOR,
        makeValue(ancestor));
  }

  /** Make a filter on a property for use in a query. */
  public static Filter.Builder makeFilter(
      String property, PropertyFilter.Operator operator, Value value) {
    return Filter.newBuilder()
        .setPropertyFilter(
            PropertyFilter.newBuilder()
                .setProperty(makePropertyReference(property))
                .setOp(operator)
                .setValue(value));
  }

  /** Make a filter on a property for use in a query. */
  public static Filter.Builder makeFilter(
      String property, PropertyFilter.Operator operator, Value.Builder value) {
    return makeFilter(property, operator, value.build());
  }

  /** Make a composite filter from the given sub-filters using AND to combine filters. */
  public static Filter.Builder makeAndFilter(Filter... subfilters) {
    return makeAndFilter(Arrays.asList(subfilters));
  }

  /** Make a composite filter from the given sub-filters using AND to combine filters. */
  public static Filter.Builder makeAndFilter(Iterable<Filter> subfilters) {
    return Filter.newBuilder()
        .setCompositeFilter(
            CompositeFilter.newBuilder()
                .addAllFilters(subfilters)
                .setOp(CompositeFilter.Operator.AND));
  }

  /** Make a property reference for use in a query. */
  public static PropertyReference.Builder makePropertyReference(String propertyName) {
    return PropertyReference.newBuilder().setName(propertyName);
  }

  /** Make an array value containing the specified values. */
  public static Value.Builder makeValue(Iterable<Value> values) {
    return Value.newBuilder().setArrayValue(ArrayValue.newBuilder().addAllValues(values));
  }

  /** Make a list value containing the specified values. */
  public static Value.Builder makeValue(Value value1, Value value2, Value... rest) {
    ArrayValue.Builder arrayValue = ArrayValue.newBuilder();
    arrayValue.addValues(value1);
    arrayValue.addValues(value2);
    arrayValue.addAllValues(Arrays.asList(rest));
    return Value.newBuilder().setArrayValue(arrayValue);
  }

  /** Make an array value containing the specified values. */
  public static Value.Builder makeValue(
      Value.Builder value1, Value.Builder value2, Value.Builder... rest) {
    ArrayValue.Builder arrayValue = ArrayValue.newBuilder();
    arrayValue.addValues(value1);
    arrayValue.addValues(value2);
    for (Value.Builder builder : rest) {
      arrayValue.addValues(builder);
    }
    return Value.newBuilder().setArrayValue(arrayValue);
  }

  /** Make a key value. */
  public static Value.Builder makeValue(Key key) {
    return Value.newBuilder().setKeyValue(key);
  }

  /** Make a key value. */
  public static Value.Builder makeValue(Key.Builder key) {
    return makeValue(key.build());
  }

  /** Make an integer value. */
  public static Value.Builder makeValue(long key) {
    return Value.newBuilder().setIntegerValue(key);
  }

  /** Make a floating point value. */
  public static Value.Builder makeValue(double value) {
    return Value.newBuilder().setDoubleValue(value);
  }

  /** Make a boolean value. */
  public static Value.Builder makeValue(boolean value) {
    return Value.newBuilder().setBooleanValue(value);
  }

  /** Make a string value. */
  public static Value.Builder makeValue(String value) {
    return Value.newBuilder().setStringValue(value);
  }

  /** Make an entity value. */
  public static Value.Builder makeValue(Entity entity) {
    return Value.newBuilder().setEntityValue(entity);
  }

  /** Make a entity value. */
  public static Value.Builder makeValue(Entity.Builder entity) {
    return makeValue(entity.build());
  }

  /** Make a ByteString value. */
  public static Value.Builder makeValue(ByteString blob) {
    return Value.newBuilder().setBlobValue(blob);
  }

  /** Make a timestamp value given a date. */
  public static Value.Builder makeValue(Date date) {
    return Value.newBuilder().setTimestampValue(toTimestamp(date.getTime() * 1000L));
  }

  /** Makes a GeoPoint value. */
  public static Value.Builder makeValue(LatLng value) {
    return Value.newBuilder().setGeoPointValue(value);
  }

  /** Makes a GeoPoint value. */
  public static Value.Builder makeValue(LatLng.Builder value) {
    return makeValue(value.build());
  }

  private static Timestamp.Builder toTimestamp(long microseconds) {
    long seconds = microseconds / MICROSECONDS_PER_SECOND;
    long microsecondsRemainder = microseconds % MICROSECONDS_PER_SECOND;
    if (microsecondsRemainder < 0) {
      // Nanos must be positive even if microseconds is negative.
      // Java modulus doesn't take care of this for us.
      microsecondsRemainder += MICROSECONDS_PER_SECOND;
      seconds -= 1;
    }
    return Timestamp.newBuilder()
        .setSeconds(seconds)
        .setNanos((int) microsecondsRemainder * NANOSECONDS_PER_MICROSECOND);
  }

  /**
   * Make a key from the specified path of kind/id-or-name pairs and/or Keys.
   *
   * <p>The id-or-name values must be either String, Long, Integer or Short.
   *
   * <p>The last id-or-name value may be omitted, in which case an entity without an id is created
   * (for use with automatic id allocation).
   *
   * <p>The PartitionIds of all Keys in the path must be equal. The returned Key.Builder will use
   * this PartitionId.
   */
  public static Key.Builder makeKey(Object... elements) {
    Key.Builder key = Key.newBuilder();
    PartitionId partitionId = null;
    for (int pathIndex = 0; pathIndex < elements.length; pathIndex += 2) {
      PathElement.Builder pathElement = PathElement.newBuilder();
      Object element = elements[pathIndex];
      if (element instanceof Key) {
        Key subKey = (Key) element;
        if (partitionId == null) {
          partitionId = subKey.getPartitionId();
        } else if (!partitionId.equals(subKey.getPartitionId())) {
          throw new IllegalArgumentException(
              "Partition IDs did not match, found: "
                  + partitionId
                  + " and "
                  + subKey.getPartitionId());
        }
        key.addAllPath(((Key) element).getPathList());
        // We increment by 2, but since we got a Key argument we're only consuming 1 element in this
        // iteration of the loop. Decrement the index so that when we jump by 2 we end up in the
        // right spot.
        pathIndex--;
      } else {
        String kind;
        try {
          kind = (String) element;
        } catch (ClassCastException e) {
          throw new IllegalArgumentException(
              "Expected string or Key, got: " + element.getClass(), e);
        }
        pathElement.setKind(kind);
        if (pathIndex + 1 < elements.length) {
          Object value = elements[pathIndex + 1];
          if (value instanceof String) {
            pathElement.setName((String) value);
          } else if (value instanceof Long) {
            pathElement.setId((Long) value);
          } else if (value instanceof Integer) {
            pathElement.setId((Integer) value);
          } else if (value instanceof Short) {
            pathElement.setId((Short) value);
          } else {
            throw new IllegalArgumentException(
                "Expected string or integer, got: " + value.getClass());
          }
        }
        key.addPath(pathElement);
      }
    }
    if (partitionId != null && !partitionId.equals(PartitionId.getDefaultInstance())) {
      key.setPartitionId(partitionId);
    }
    return key;
  }

  /**
   * @return the double contained in value
   * @throws IllegalArgumentException if the value does not contain a double.
   */
  public static double getDouble(Value value) {
    if (value.getValueTypeCase() != ValueTypeCase.DOUBLE_VALUE) {
      throw new IllegalArgumentException("Value does not contain a double.");
    }
    return value.getDoubleValue();
  }

  /**
   * @return the key contained in value
   * @throws IllegalArgumentException if the value does not contain a key.
   */
  public static Key getKey(Value value) {
    if (value.getValueTypeCase() != ValueTypeCase.KEY_VALUE) {
      throw new IllegalArgumentException("Value does not contain a key.");
    }
    return value.getKeyValue();
  }

  /**
   * @return the blob contained in value
   * @throws IllegalArgumentException if the value does not contain a blob.
   */
  public static ByteString getByteString(Value value) {
    if (value.getMeaning() == 18 && value.getValueTypeCase() == ValueTypeCase.STRING_VALUE) {
      return value.getStringValueBytes();
    } else if (value.getValueTypeCase() == ValueTypeCase.BLOB_VALUE) {
      return value.getBlobValue();
    }
    throw new IllegalArgumentException("Value does not contain a blob.");
  }

  /**
   * @return the entity contained in value
   * @throws IllegalArgumentException if the value does not contain an entity.
   */
  public static Entity getEntity(Value value) {
    if (value.getValueTypeCase() != ValueTypeCase.ENTITY_VALUE) {
      throw new IllegalArgumentException("Value does not contain an Entity.");
    }
    return value.getEntityValue();
  }

  /**
   * @return the string contained in value
   * @throws IllegalArgumentException if the value does not contain a string.
   */
  public static String getString(Value value) {
    if (value.getValueTypeCase() != ValueTypeCase.STRING_VALUE) {
      throw new IllegalArgumentException("Value does not contain a string.");
    }
    return value.getStringValue();
  }

  /**
   * @return the boolean contained in value
   * @throws IllegalArgumentException if the value does not contain a boolean.
   */
  public static boolean getBoolean(Value value) {
    if (value.getValueTypeCase() != ValueTypeCase.BOOLEAN_VALUE) {
      throw new IllegalArgumentException("Value does not contain a boolean.");
    }
    return value.getBooleanValue();
  }

  /**
   * @return the long contained in value
   * @throws IllegalArgumentException if the value does not contain a long.
   */
  public static long getLong(Value value) {
    if (value.getValueTypeCase() != ValueTypeCase.INTEGER_VALUE) {
      throw new IllegalArgumentException("Value does not contain an integer.");
    }
    return value.getIntegerValue();
  }

  /**
   * @return the timestamp in microseconds contained in value
   * @throws IllegalArgumentException if the value does not contain a timestamp.
   */
  public static long getTimestamp(Value value) {
    if (value.getMeaning() == 18 && value.getValueTypeCase() == ValueTypeCase.INTEGER_VALUE) {
      return value.getIntegerValue();
    } else if (value.getValueTypeCase() == ValueTypeCase.TIMESTAMP_VALUE) {
      return toMicroseconds(value.getTimestampValue());
    }
    throw new IllegalArgumentException("Value does not contain a timestamp.");
  }

  private static long toMicroseconds(TimestampOrBuilder timestamp) {
    // Nanosecond precision is lost.
    return timestamp.getSeconds() * MICROSECONDS_PER_SECOND
        + timestamp.getNanos() / NANOSECONDS_PER_MICROSECOND;
  }

  /**
   * @return the array contained in value as a list.
   * @throws IllegalArgumentException if the value does not contain an array.
   */
  public static List<Value> getList(Value value) {
    if (value.getValueTypeCase() != ValueTypeCase.ARRAY_VALUE) {
      throw new IllegalArgumentException("Value does not contain an array.");
    }
    return value.getArrayValue().getValuesList();
  }

  /**
   * Convert a timestamp value into a {@link Date} clipping off the microseconds.
   *
   * @param value a timestamp value to convert
   * @return the resulting {@link Date}
   * @throws IllegalArgumentException if the value does not contain a timestamp.
   */
  public static Date toDate(Value value) {
    return new Date(getTimestamp(value) / 1000);
  }

  /**
   * @param entity the entity to insert
   * @return a mutation that will insert an entity
   */
  public static Mutation.Builder makeInsert(Entity entity) {
    return Mutation.newBuilder().setInsert(entity);
  }

  /**
   * @param entity the entity to update
   * @return a mutation that will update an entity
   */
  public static Mutation.Builder makeUpdate(Entity entity) {
    return Mutation.newBuilder().setUpdate(entity);
  }

  /**
   * @param entity the entity to upsert
   * @return a mutation that will upsert an entity
   */
  public static Mutation.Builder makeUpsert(Entity entity) {
    return Mutation.newBuilder().setUpsert(entity);
  }

  /**
   * @param key the key of the entity to delete
   * @return a mutation that will delete an entity
   */
  public static Mutation.Builder makeDelete(Key key) {
    return Mutation.newBuilder().setDelete(key);
  }
}
