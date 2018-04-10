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
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.DatasetList;
import com.google.api.services.bigquery.model.DatasetReference;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobList;
import com.google.api.services.bigquery.model.JobStatus;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TableList;
import com.google.api.services.bigquery.model.TableReference;
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
  private static final String BASE_RESUMABLE_URI =
      "https://www.googleapis.com/upload/bigquery/v2/projects/";
  // see: https://cloud.google.com/bigquery/loading-data-post-request#resume-upload
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
    bigquery = new Bigquery.Builder(transport, new JacksonFactory(), initializer)
        .setRootUrl(options.getHost())
        .setApplicationName(options.getApplicationName())
        .build();
  }

  private static BigQueryException translate(IOException exception) {
    return new BigQueryException(exception);
  }

  @Override
  public Dataset getDataset(String projectId, String datasetId, Map<Option, ?> options) {
    try {
      return bigquery.datasets()
          .get(projectId, datasetId)
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
  public Tuple<String, Iterable<Dataset>> listDatasets(String projectId, Map<Option, ?> options) {
    try {
      DatasetList datasetsList = bigquery.datasets()
          .list(projectId)
          .setAll(Option.ALL_DATASETS.getBoolean(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
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
      return bigquery.datasets().insert(dataset.getDatasetReference().getProjectId(), dataset)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Table create(Table table, Map<Option, ?> options) {
    try {
      // unset the type, as it is output only
      table.setType(null);
      TableReference reference = table.getTableReference();
      return bigquery.tables()
          .insert(reference.getProjectId(), reference.getDatasetId(), table)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Job create(Job job, Map<Option, ?> options) {
    try {
      String projectId = job.getJobReference() != null
          ? job.getJobReference().getProjectId() : this.options.getProjectId();
      return bigquery.jobs()
          .insert(projectId, job)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteDataset(String projectId, String datasetId, Map<Option, ?> options) {
    try {
      bigquery.datasets().delete(projectId, datasetId)
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
      DatasetReference reference = dataset.getDatasetReference();
      return bigquery.datasets()
          .patch(reference.getProjectId(), reference.getDatasetId(), dataset)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Table patch(Table table, Map<Option, ?> options) {
    try {
      // unset the type, as it is output only
      table.setType(null);
      TableReference reference = table.getTableReference();
      return bigquery.tables()
          .patch(reference.getProjectId(), reference.getDatasetId(), reference.getTableId(), table)
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Table getTable(String projectId, String datasetId, String tableId,
      Map<Option, ?> options) {
    try {
      return bigquery.tables()
          .get(projectId, datasetId, tableId)
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
  public Tuple<String, Iterable<Table>> listTables(String projectId, String datasetId,
      Map<Option, ?> options) {
    try {
      TableList tableList = bigquery.tables()
          .list(projectId, datasetId)
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .execute();
      Iterable<TableList.Tables> tables = tableList.getTables();
      return Tuple.of(tableList.getNextPageToken(),
          Iterables.transform(tables != null ? tables : ImmutableList.<TableList.Tables>of(),
              new Function<TableList.Tables, Table>() {
                @Override
                public Table apply(TableList.Tables tablePb) {
                  return new Table()
                      .setFriendlyName(tablePb.getFriendlyName())
                      .setId(tablePb.getId())
                      .setKind(tablePb.getKind())
                      .setTableReference(tablePb.getTableReference())
                      .setType(tablePb.getType());
                }
              }));
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean deleteTable(String projectId, String datasetId, String tableId) {
    try {
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
  public TableDataInsertAllResponse insertAll(String projectId, String datasetId, String tableId,
      TableDataInsertAllRequest request) {
    try {
      return bigquery.tabledata().insertAll(projectId, datasetId, tableId, request).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public TableDataList listTableData(
      String projectId, String datasetId, String tableId, Map<Option, ?> options) {
    try {
      return bigquery
          .tabledata()
          .list(projectId, datasetId, tableId)
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
  public Job getJob(String projectId, String jobId, String location, Map<Option, ?> options) {
    try {
      return bigquery
          .jobs()
          .get(projectId, jobId)
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
  public Tuple<String, Iterable<Job>> listJobs(String projectId, Map<Option, ?> options) {
    try {
      JobList jobsList = bigquery.jobs()
          .list(projectId)
          .setAllUsers(Option.ALL_USERS.getBoolean(options))
          .setFields(Option.FIELDS.getString(options))
          .setStateFilter(Option.STATE_FILTER.<List<String>>get(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setProjection(DEFAULT_PROJECTION)
          .execute();
      Iterable<JobList.Jobs> jobs = jobsList.getJobs();
      return Tuple.of(jobsList.getNextPageToken(),
          Iterables.transform(jobs != null ? jobs : ImmutableList.<JobList.Jobs>of(),
              new Function<JobList.Jobs, Job>() {
                @Override
                public Job apply(JobList.Jobs jobPb) {
                  JobStatus statusPb = jobPb.getStatus() != null
                      ? jobPb.getStatus() : new JobStatus();
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
      bigquery.jobs().cancel(projectId, jobId).setLocation(location).execute();
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
  public GetQueryResultsResponse getQueryResults(
      String projectId, String jobId, String location, Map<Option, ?> options) {
    try {
      return bigquery
          .jobs()
          .getQueryResults(projectId, jobId)
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
  public String open(Job loadJob) {
    try {
      String builder = BASE_RESUMABLE_URI + options.getProjectId() + "/jobs";
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
  public Job write(String uploadId, byte[] toWrite, int toWriteOffset, long destOffset, int length,
      boolean last) {
    try {
      if (length == 0) {
        return null;
      }
      GenericUrl url = new GenericUrl(uploadId);
      HttpRequest httpRequest = bigquery.getRequestFactory()
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
}
