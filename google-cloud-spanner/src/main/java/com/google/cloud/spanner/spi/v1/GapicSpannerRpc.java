/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.cloud.ServiceRpc;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminSettings;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminSettings;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.common.collect.ImmutableList;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import javax.annotation.Nullable;
import java.lang.UnsupportedOperationException;
import java.util.List;
import java.util.Map;


public class GapicSpannerRpc implements SpannerRpc {

	// private final DatabaseAdminClient adminDatabaseClient;
	// private final InstanceAdminClient adminInstanceClient;

	public Paginated<InstanceConfig> listInstanceConfigs(int pageSize, @Nullable String pageToken)
	  throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public InstanceConfig getInstanceConfig(String instanceConfigName) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
		// return adminInstanceClient.getInstanceConfig(instanceConfigName);
	}

	public Paginated<Instance> listInstances(int pageSize, @Nullable String pageToken, @Nullable String filter) 
	  throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
		// return adminInstanceClient.listInstances();
	}

	public Operation createInstance(String parent, String instanceId, Instance instance)
	  throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Operation updateInstance(Instance instance, FieldMask fieldMask) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Instance getInstance(String instanceName) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
		// return adminInstanceClient.getInstance(instanceName);
	}

	public void deleteInstance(String instanceName) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
		// adminInstanceClient.deleteInstance(instanceName);
	}

  // Database admin APIs.
	public Paginated<Database> listDatabases(String instanceName, int pageSize, @Nullable String pageToken)
	  throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Operation createDatabase(String instanceName, String createDatabaseStatement, Iterable<String> additionalStatements)
	  throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Operation updateDatabaseDdl(String databaseName, Iterable<String> updateDatabaseStatements, @Nullable String updateId)
	  throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void dropDatabase(String databaseName) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
		// adminDatabaseClient.dropDatabase(databaseName);
	}

	public Database getDatabase(String databaseName) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
		// adminDatabaseClient.getDatabase(databaseName);
	}

	public List<String> getDatabaseDdl(String databaseName) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	/** Retrieves a long running operation. */
	public Operation getOperation(String name) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Session createSession(String databaseName, @Nullable Map<String, String> labels, @Nullable Map<Option, ?> options)
	  throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void deleteSession(String sessionName, @Nullable Map<Option, ?> options) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public StreamingCall read(
		ReadRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public StreamingCall executeQuery(
		ExecuteSqlRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Transaction beginTransaction(BeginTransactionRequest request, @Nullable Map<Option, ?> options)
	  throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
	}

	public CommitResponse commit(CommitRequest commitRequest, @Nullable Map<Option, ?> options)
	  throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void rollback(RollbackRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public PartitionResponse partitionQuery(PartitionQueryRequest request, @Nullable Map<Option, ?> options)
	  throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
	}

	public PartitionResponse partitionRead(PartitionReadRequest request, @Nullable Map<Option, ?> options)
	  throws SpannerException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
}