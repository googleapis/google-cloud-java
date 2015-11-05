Google Cloud Java Client for BigQuery
====================================

Java idiomatic client for [Google Cloud BigQuery] (https://cloud.google.com/bigquery).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)
<!-- TODO(mziccard): add in the maven shield once the artifact is pushed to maven -->

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
+<!-- TODO(mziccard): add link to API documentatin -->

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
Add this to your pom.xml file
<!-- TODO(mziccard): add dependency code -->


Example Application
-------------------

<!-- TODO(mziccard): add example application -->

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) section in the base directory's README.

About Google Cloud BigQuery
--------------------------

[Google Cloud BigQuery][cloud-bigquery] is a fully managed, NoOps, low cost data analytics service.
Data can be streamed into BigQuery at millions of rows per second to enable real-time analysis.
With BigQuery you can easily deploy Petabyte-scale Databases.

Be sure to activate the Google Cloud BigQuery API on the Developer's Console to use BigQuery from your project.

See the ``gcloud-java`` API [bigquery documentation][bigquery-api] to learn how to interact
with Google Cloud BigQuery using this Client Library.

Here is a code snippet showing a simple usage example from within Compute/App Engine. Note that you must [supply credentials](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) and a project ID if running this snippet elsewhere.

<!-- TODO(mziccard): add code snippet -->

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

<!-- TODO(mziccard): add this in once the RemoteGCBQMHelper class is functional -->

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/TESTING.md#testing-code-that-uses-bigquery
[cloud-platform]: https://cloud.google.com/

[cloud-bigquery]: https://cloud.google.com/bigquery/
[bigquery-api]: http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/bigquery/package-summary.html