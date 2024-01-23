/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery.spi.v2;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.DatasetList;
import com.google.api.services.bigquery.model.DatasetReference;
import com.google.api.services.bigquery.model.GetIamPolicyRequest;
import com.google.api.services.bigquery.model.GetPolicyOptions;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobList;
import com.google.api.services.bigquery.model.JobStatus;
import com.google.api.services.bigquery.model.ListModelsResponse;
import com.google.api.services.bigquery.model.ListRoutinesResponse;
import com.google.api.services.bigquery.model.Model;
import com.google.api.services.bigquery.model.ModelReference;
import com.google.api.services.bigquery.model.Policy;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.api.services.bigquery.model.Routine;
import com.google.api.services.bigquery.model.RoutineReference;
import com.google.api.services.bigquery.model.SetIamPolicyRequest;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TableList;
import com.google.api.services.bigquery.model.TableReference;
import com.google.api.services.bigquery.model.TestIamPermissionsRequest;
import com.google.api.services.bigquery.model.TestIamPermissionsResponse;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@InternalExtensionOnly
public class HttpBigQueryRpc implements BigQueryRpc {

  public static final String DEFAULT_PROJECTION = "full";
  private static final String BASE_RESUMABLE_URI = "upload/bigquery/v2/projects/";
  // see:
  // https://cloud.google.com/bigquery/loading-data-post-request#resume-upload
  private static final int HTTP_RESUME_INCOMPLETE = 308;
  private final BigQueryOptions options;
  private final Bigquery bigquery;

  @InternalApi("Visible for testing")
  static final Function<DatasetList.Datasets, Dataset> LIST_TO_DATASET =
      new Function<DatasetList.Datasets, Dataset>() {
        @Override
        public Dataset apply(DatasetList.Datasets datasetPb) {
          return new Dataset()
              .setDatasetReference(datasetPb.getDatasetReference())
              .setFriendlyName(datasetPb.getFriendlyName())
              .setId(datasetPb.getId())
              .setKind(datasetPb.getKind())
              .setLabels(datasetPb.getLabels());
        }
      };

  public HttpBigQueryRpc(BigQueryOptions options) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    this.options = options;
    bigquery =
        new Bigquery.Builder(transport, new GsonFactory(), initializer)
            .setRootUrl(options.getResolvedApiaryHost("bigquery"))
            .setApplicationName(options.getApplicationName())
            .build();
  }

  private static BigQueryException translate(IOException exception) {
    return new BigQueryException(exception);
  }

  private void validateRPC() throws BigQueryException, IOException {
    if (!this.options.hasValidUniverseDomain()) {
      throw new BigQueryException(BigQueryException.UNKNOWN_CODE, "Invalid universe domain");
    }
  }

  @Override
  public Dataset getDataset(String projectId, String datasetId, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .datasets()
          .get(projectId, datasetId)
          .setFields(Option.FIELDS.getString(options))
          .setPrettyPrint(false)
          .execute();
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public Tuple<String, Iterable<Dataset>> listDatasets(String projectId, Map<Option, ?> options) {
    try {
      validateRPC();
      DatasetList datasetsList =
          bigquery
              .datasets()
              .list(projectId)
              .setPrettyPrint(false)
              .setAll(Option.ALL_DATASETS.getBoolean(options))
              .setFilter(Option.LABEL_FILTER.getString(options))
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .execute();
      Iterable<DatasetList.Datasets> datasets = datasetsList.getDatasets();
      return Tuple.of(
          datasetsList.getNextPageToken(),
          Iterables.transform(
              datasets != null ? datasets : ImmutableList.<DatasetList.Datasets>of(),
              LIST_TO_DATASET));
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Dataset create(Dataset dataset, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .datasets()
          .insert(dataset.getDatasetReference().getProjectId(), dataset)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Table create(Table table, Map<Option, ?> options) {
    try {
      validateRPC();
      // unset the type, as it is output only
      table.setType(null);
      TableReference reference = table.getTableReference();
      return bigquery
          .tables()
          .insert(reference.getProjectId(), reference.getDatasetId(), table)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Routine create(Routine routine, Map<Option, ?> options) {
    try {
      validateRPC();
      RoutineReference reference = routine.getRoutineReference();
      return bigquery
          .routines()
          .insert(reference.getProjectId(), reference.getDatasetId(), routine)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Job create(Job job, Map<Option, ?> options) {
    try {
      validateRPC();
      String projectId =
          job.getJobReference() != null
              ? job.getJobReference().getProjectId()
              : this.options.getProjectId();
      return bigquery
          .jobs()
          .insert(projectId, job)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Job createJobForQuery(Job job) {
    try {
      validateRPC();
      String projectId =
          job.getJobReference() != null
              ? job.getJobReference().getProjectId()
              : this.options.getProjectId();
      return bigquery.jobs().insert(projectId, job).setPrettyPrint(false).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteDataset(String projectId, String datasetId, Map<Option, ?> options) {
    try {
      validateRPC();
      bigquery
          .datasets()
          .delete(projectId, datasetId)
          .setPrettyPrint(false)
          .setDeleteContents(Option.DELETE_CONTENTS.getBoolean(options))
          .execute();
      return true;
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public Dataset patch(Dataset dataset, Map<Option, ?> options) {
    try {
      validateRPC();
      DatasetReference reference = dataset.getDatasetReference();
      return bigquery
          .datasets()
          .patch(reference.getProjectId(), reference.getDatasetId(), dataset)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Table patch(Table table, Map<Option, ?> options) {
    try {
      validateRPC();
      // unset the type, as it is output only
      table.setType(null);
      TableReference reference = table.getTableReference();
      return bigquery
          .tables()
          .patch(reference.getProjectId(), reference.getDatasetId(), reference.getTableId(), table)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .setAutodetectSchema(BigQueryRpc.Option.AUTODETECT_SCHEMA.getBoolean(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Table getTable(
      String projectId, String datasetId, String tableId, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .tables()
          .get(projectId, datasetId, tableId)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .setView(getTableMetadataOption(options))
          .execute();
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  private String getTableMetadataOption(Map<Option, ?> options) {
    if (options.containsKey(Option.TABLE_METADATA_VIEW)) {
      return options.get(Option.TABLE_METADATA_VIEW).toString();
    }
    return "STORAGE_STATS";
  }

  @Override
  public Tuple<String, Iterable<Table>> listTables(
      String projectId, String datasetId, Map<Option, ?> options) {
    try {
      validateRPC();
      TableList tableList =
          bigquery
              .tables()
              .list(projectId, datasetId)
              .setPrettyPrint(false)
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .execute();
      Iterable<TableList.Tables> tables = tableList.getTables();
      return Tuple.of(
          tableList.getNextPageToken(),
          Iterables.transform(
              tables != null ? tables : ImmutableList.<TableList.Tables>of(),
              new Function<TableList.Tables, Table>() {
                @Override
                public Table apply(TableList.Tables tablePb) {
                  return new Table()
                      .setFriendlyName(tablePb.getFriendlyName())
                      .setId(tablePb.getId())
                      .setKind(tablePb.getKind())
                      .setTableReference(tablePb.getTableReference())
                      .setType(tablePb.getType())
                      .setCreationTime(tablePb.getCreationTime())
                      .setTimePartitioning(tablePb.getTimePartitioning())
                      .setRangePartitioning(tablePb.getRangePartitioning());
                }
              }));
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteTable(String projectId, String datasetId, String tableId) {
    try {
      validateRPC();
      bigquery.tables().delete(projectId, datasetId, tableId).execute();
      return true;
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public Model patch(Model model, Map<Option, ?> options) {
    try {
      validateRPC();
      // unset the type, as it is output only
      ModelReference reference = model.getModelReference();
      return bigquery
          .models()
          .patch(reference.getProjectId(), reference.getDatasetId(), reference.getModelId(), model)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Model getModel(
      String projectId, String datasetId, String modelId, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .models()
          .get(projectId, datasetId, modelId)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public Tuple<String, Iterable<Model>> listModels(
      String projectId, String datasetId, Map<Option, ?> options) {
    try {
      validateRPC();
      ListModelsResponse modelList =
          bigquery
              .models()
              .list(projectId, datasetId)
              .setPrettyPrint(false)
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .execute();
      Iterable<Model> models =
          modelList.getModels() != null ? modelList.getModels() : ImmutableList.<Model>of();
      return Tuple.of(modelList.getNextPageToken(), models);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteModel(String projectId, String datasetId, String modelId) {
    try {
      validateRPC();
      bigquery.models().delete(projectId, datasetId, modelId).execute();
      return true;
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public Routine update(Routine routine, Map<Option, ?> options) {
    try {
      validateRPC();
      RoutineReference reference = routine.getRoutineReference();
      return bigquery
          .routines()
          .update(
              reference.getProjectId(), reference.getDatasetId(), reference.getRoutineId(), routine)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Routine getRoutine(
      String projectId, String datasetId, String routineId, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .routines()
          .get(projectId, datasetId, routineId)
          .setPrettyPrint(false)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public Tuple<String, Iterable<Routine>> listRoutines(
      String projectId, String datasetId, Map<Option, ?> options) {
    try {
      validateRPC();
      ListRoutinesResponse routineList =
          bigquery
              .routines()
              .list(projectId, datasetId)
              .setPrettyPrint(false)
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .execute();
      Iterable<Routine> routines =
          routineList.getRoutines() != null
              ? routineList.getRoutines()
              : ImmutableList.<Routine>of();
      return Tuple.of(routineList.getNextPageToken(), routines);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteRoutine(String projectId, String datasetId, String routineId) {
    try {
      validateRPC();
      bigquery.routines().delete(projectId, datasetId, routineId).execute();
      return true;
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public TableDataInsertAllResponse insertAll(
      String projectId, String datasetId, String tableId, TableDataInsertAllRequest request) {
    try {
      validateRPC();
      return bigquery
          .tabledata()
          .insertAll(projectId, datasetId, tableId, request)
          .setPrettyPrint(false)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public TableDataList listTableData(
      String projectId, String datasetId, String tableId, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .tabledata()
          .list(projectId, datasetId, tableId)
          .setPrettyPrint(false)
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setStartIndex(
              Option.START_INDEX.getLong(options) != null
                  ? BigInteger.valueOf(Option.START_INDEX.getLong(options))
                  : null)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public TableDataList listTableDataWithRowLimit(
      String projectId,
      String datasetId,
      String tableId,
      Integer maxResultPerPage,
      String pageToken) {
    try {
      validateRPC();
      return bigquery
          .tabledata()
          .list(projectId, datasetId, tableId)
          .setPrettyPrint(false)
          .setMaxResults(Long.valueOf(maxResultPerPage))
          .setPageToken(pageToken)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Job getJob(String projectId, String jobId, String location, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .jobs()
          .get(projectId, jobId)
          .setPrettyPrint(false)
          .setLocation(location)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public Job getQueryJob(String projectId, String jobId, String location) {
    try {
      validateRPC();
      return bigquery
          .jobs()
          .get(projectId, jobId)
          .setPrettyPrint(false)
          .setLocation(location)
          .execute();
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public Tuple<String, Iterable<Job>> listJobs(String projectId, Map<Option, ?> options) {
    try {
      validateRPC();
      Bigquery.Jobs.List request =
          bigquery
              .jobs()
              .list(projectId)
              .setPrettyPrint(false)
              .setAllUsers(Option.ALL_USERS.getBoolean(options))
              .setFields(Option.FIELDS.getString(options))
              .setStateFilter(Option.STATE_FILTER.<List<String>>get(options))
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .setProjection(DEFAULT_PROJECTION)
              .setParentJobId(Option.PARENT_JOB_ID.getString(options));
      if (Option.MIN_CREATION_TIME.getLong(options) != null) {
        request.setMinCreationTime(BigInteger.valueOf(Option.MIN_CREATION_TIME.getLong(options)));
      }
      if (Option.MAX_CREATION_TIME.getLong(options) != null) {
        request.setMaxCreationTime(BigInteger.valueOf(Option.MAX_CREATION_TIME.getLong(options)));
      }
      JobList jobsList = request.execute();

      Iterable<JobList.Jobs> jobs = jobsList.getJobs();
      return Tuple.of(
          jobsList.getNextPageToken(),
          Iterables.transform(
              jobs != null ? jobs : ImmutableList.<JobList.Jobs>of(),
              new Function<JobList.Jobs, Job>() {
                @Override
                public Job apply(JobList.Jobs jobPb) {
                  JobStatus statusPb =
                      jobPb.getStatus() != null ? jobPb.getStatus() : new JobStatus();
                  if (statusPb.getState() == null) {
                    statusPb.setState(jobPb.getState());
                  }
                  if (statusPb.getErrorResult() == null) {
                    statusPb.setErrorResult(jobPb.getErrorResult());
                  }
                  return new Job()
                      .setConfiguration(jobPb.getConfiguration())
                      .setId(jobPb.getId())
                      .setJobReference(jobPb.getJobReference())
                      .setKind(jobPb.getKind())
                      .setStatistics(jobPb.getStatistics())
                      .setStatus(statusPb)
                      .setUserEmail(jobPb.getUserEmail());
                }
              }));
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean cancel(String projectId, String jobId, String location) {
    try {
      validateRPC();
      bigquery
          .jobs()
          .cancel(projectId, jobId)
          .setLocation(location)
          .setPrettyPrint(false)
          .execute();
      return true;
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public boolean deleteJob(String projectId, String jobName, String location) {
    try {
      validateRPC();
      bigquery
          .jobs()
          .delete(projectId, jobName)
          .setLocation(location)
          .setPrettyPrint(false)
          .execute();
      return true;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public GetQueryResultsResponse getQueryResults(
      String projectId, String jobId, String location, Map<Option, ?> options) {
    try {
      validateRPC();
      return bigquery
          .jobs()
          .getQueryResults(projectId, jobId)
          .setPrettyPrint(false)
          .setLocation(location)
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setStartIndex(
              Option.START_INDEX.getLong(options) != null
                  ? BigInteger.valueOf(Option.START_INDEX.getLong(options))
                  : null)
          .setTimeoutMs(Option.TIMEOUT.getLong(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public GetQueryResultsResponse getQueryResultsWithRowLimit(
      String projectId, String jobId, String location, Integer maxResultPerPage, Long timeoutMs) {
    try {
      validateRPC();
      return bigquery
          .jobs()
          .getQueryResults(projectId, jobId)
          .setPrettyPrint(false)
          .setLocation(location)
          .setMaxResults(Long.valueOf(maxResultPerPage))
          .setTimeoutMs(timeoutMs)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public QueryResponse queryRpc(String projectId, QueryRequest content) {
    try {
      validateRPC();
      return bigquery.jobs().query(projectId, content).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public String open(Job loadJob) {
    try {
      String builder = options.getResolvedApiaryHost("bigquery");
      if (!builder.endsWith("/")) {
        builder += "/";
      }
      builder += BASE_RESUMABLE_URI + options.getProjectId() + "/jobs";
      GenericUrl url = new GenericUrl(builder);
      url.set("uploadType", "resumable");
      JsonFactory jsonFactory = bigquery.getJsonFactory();
      HttpRequestFactory requestFactory = bigquery.getRequestFactory();
      HttpRequest httpRequest =
          requestFactory.buildPostRequest(url, new JsonHttpContent(jsonFactory, loadJob));
      httpRequest.getHeaders().set("X-Upload-Content-Value", "application/octet-stream");
      HttpResponse response = httpRequest.execute();
      return response.getHeaders().getLocation();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Job write(
      String uploadId,
      byte[] toWrite,
      int toWriteOffset,
      long destOffset,
      int length,
      boolean last) {
    try {
      if (length == 0) {
        return null;
      }
      GenericUrl url = new GenericUrl(uploadId);
      HttpRequest httpRequest =
          bigquery
              .getRequestFactory()
              .buildPutRequest(url, new ByteArrayContent(null, toWrite, toWriteOffset, length));
      httpRequest.setParser(bigquery.getObjectParser());
      long limit = destOffset + length;
      StringBuilder range = new StringBuilder("bytes ");
      range.append(destOffset).append('-').append(limit - 1).append('/');
      if (last) {
        range.append(limit);
      } else {
        range.append('*');
      }
      httpRequest.getHeaders().setContentRange(range.toString());
      int code;
      String message;
      IOException exception = null;
      HttpResponse response = null;
      try {
        response = httpRequest.execute();
        code = response.getStatusCode();
        message = response.getStatusMessage();
      } catch (HttpResponseException ex) {
        exception = ex;
        code = ex.getStatusCode();
        message = ex.getStatusMessage();
      }
      if (!last && code != HTTP_RESUME_INCOMPLETE
          || last && !(code == HTTP_OK || code == HTTP_CREATED)) {
        if (exception != null) {
          throw exception;
        }
        throw new BigQueryException(code, message);
      }
      return last && response != null ? response.parseAs(Job.class) : null;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Policy getIamPolicy(String resourceId, Map<Option, ?> options) {
    try {
      validateRPC();
      GetIamPolicyRequest policyRequest = new GetIamPolicyRequest();
      if (null != Option.REQUESTED_POLICY_VERSION.getLong(options)) {
        policyRequest =
            policyRequest.setOptions(
                new GetPolicyOptions()
                    .setRequestedPolicyVersion(
                        Option.REQUESTED_POLICY_VERSION.getLong(options).intValue()));
      }
      return bigquery
          .tables()
          .getIamPolicy(resourceId, policyRequest)
          .setPrettyPrint(false)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Policy setIamPolicy(String resourceId, Policy policy, Map<Option, ?> options) {
    try {
      validateRPC();
      SetIamPolicyRequest policyRequest = new SetIamPolicyRequest().setPolicy(policy);
      return bigquery
          .tables()
          .setIamPolicy(resourceId, policyRequest)
          .setPrettyPrint(false)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public TestIamPermissionsResponse testIamPermissions(
      String resourceId, List<String> permissions, Map<Option, ?> options) {
    try {
      validateRPC();
      TestIamPermissionsRequest permissionsRequest =
          new TestIamPermissionsRequest().setPermissions(permissions);
      return bigquery
          .tables()
          .testIamPermissions(resourceId, permissionsRequest)
          .setPrettyPrint(false)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }
}
