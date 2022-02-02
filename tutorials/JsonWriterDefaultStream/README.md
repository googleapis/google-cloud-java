# BigQuery Write API streaming tutorial

This sample shows how to stream data from a JSON source into BigQuery by using
the [BigQuery Write API](https://cloud.google.com/bigquery/docs/write-api) with
the default stream.

## Usage

Download the
[sample data file](https://storage.googleapis.com/cloud-samples-data/bigquery/tutorials/github.json).

From this directory, run:

```
mvn compile exec:java \
  -Dexec.mainClass=com.example.bigquerystorage.JsonWriterDefaultStream \
  -Dexec.args="project_id dataset table filepath`
```

where `file_path` is the path to the JSON data file.

