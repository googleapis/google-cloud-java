# Introduction

QuickPerf is a simple utility that uses JDBC to perform load testing on individual statements (such as queries and DML) against Spanner. It provides a rapid assessment of expected end-to-end latencies for specific statements, aiding in the performance tuning of schemas, indexes, and more. The tool includes random data generators to quickly fill a given schema with dummy data, respecting foreign-key relationships and interleaved tables.

QuickPerf is not designed to replace comprehensive test suites like JMeter. Instead, it serves as a quick alternative for gaining performance insights or populating schemas.

**Key Features**:
* Multi-threading to simulate concurrency
* Query parameterization with random value generators (String, Integer, Timestamp)
* Sampling of records for seeding foreign-key relationships or testing against a specific subset of data
* Batch mode support
* Automatic statement and transaction tagging


# Installation on Ubuntu 
```
sudo apt-get install openjdk-8-jdk
sudo apt install maven
```

## Authentification 
It is recommended to use a service account, otherwise larger scale tests will run into quota limitations

Set active auth to service account:
```
gcloud auth list
gcloud config set account xxx-compute@developer.gserviceaccount.com
```

# Configuration

## Parameters
```
{
    "project": "Project ID",
    "instance": "Spanner Instance",
    "database": "Spanner Database",
    "threads": Number of concurrent threads,
    "iterations": Number of how often a statement should be executed in a thread,
    "query": "Statement (e.g. query)",
    "samplingQuery": "OPTIONAL - Sampling query",
    "writeMetricToFile": Will write latency metrics to a file (true/false),
    "batchSize": If testing batching - determines how large a batch size would be,
    "queryParams": [
        {"order": 1, "value": "query paramters with value generator"}
    ]
}
```

## Example Config
```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "users",
    "threads": 1,
    "iterations": 10,
    "query": "SELECT users.user_id, membership.enrolled, GroupMgmt.grpname FROM users, GroupMgmt, membership WHERE users.user_id = ? AND users.user_id = membership.user_id AND GroupMgmt.group_id = membership.group_id",
    "samplingQuery": "SELECT user_id FROM Users TABLESAMPLE RESERVOIR (100000 ROWS)",
    "writeMetricToFile": false,
    "queryParams": [
        {"order": 1, "value": "#pi"}
    ]
}
```

# Hello World Example

The folder `exampleconfigs/config.json` contains a simple setup that runs SELECT 1 against the database

Configure the right Spanner `project` and `instance` and run the app. 

**config.json**
```
{
"project": "xxxx",
"instance": "xxx",
"database": "xxx",
"threads": 1,
"iterations": 100,
"query": "SELECT 1",
"writeMetricToFile": false,
"batchSize": 0
}
```

**Run:**
```
mvn -q exec:java -Dexec.args="-c exampleconfigs/config.json"
```



# End-to-End Example

Generates three tables with n:m relationships and performs a load test.

All in one runner generating test data and executing load test:
```
exampleconfigs/users/run.sh
```

What needs to be done to run it:
* Create spanner instance
* Create database named `users` 
* Set `project` and `instance` in each of the config JSON files located under `exampleconfigs/users/users_config.json`
    * `exampleconfigs/users/users_config.json`
    * `exampleconfigs/users/groupmgt_config.json` 
    * `exampleconfigs/users/membership_config.json`
    * `exampleconfigs/users/loadtestusers.json`


**Generate users table:**

```
mvn -q exec:java -Dexec.args="-c exampleconfigs/users/users_config.json"
```

users_config.json:
```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "users",
    "threads": 4,
    "iterations": 1000,
    "query": "INSERT INTO Users (user_id, name) VALUES(?,?)",
    "writeMetricToFile": false,
    "queryParams": [
        {"order": 1, "value": "#i"},
        {"order": 2, "value": "#s"}
    ]
}
```

**Generate GroupMgmt table:**

```
mvn  -q exec:java -Dexec.args="-c exampleconfigs/users/groupmgt_config.json"
```

groupmgt_config.json
```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "users",
    "threads": 4,
    "iterations": 1000,
    "query": "INSERT INTO GroupMgmt (group_id, grpname) VALUES(?,?)",
    "writeMetricToFile": false,
    "queryParams": [
        {"order": 1, "value": "#i"},
        {"order": 2, "value": "#s"}
    ]
}
```

**Generate Membership table:**

Run:
```
mvn  -q exec:java -Dexec.args="-c exampleconfigs/users/membership_config.json"
```

```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "users",
    "threads": 1,
    "iterations": 100,
    "query": "INSERT INTO membership(user_id, group_id, enrolled) VALUES((SELECT user_id FROM Users TABLESAMPLE RESERVOIR (1 ROWS)), (SELECT group_id FROM GroupMgmt TABLESAMPLE RESERVOIR (1 ROWS)), CURRENT_TIMESTAMP())",
    "writeMetricToFile": false
}
```


Load test random users
```
mvn  -q exec:java -Dexec.args="-c exampleconfigs/users/loadtestusers.json"
```

# Randomization examples

## String
Will generate a different random String value for each #s
```
INSERT INTO transactions (id, name, ts) VALUES (#s, #s, CURRENT_TIMESTAMP())
```
```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "xxxx",
    "threads": 4,
    "iterations": 1000,
    "query": "INSERT INTO transactions (id, name, ts) VALUES (?, ?, CURRENT_TIMESTAMP())",
    "writeMetricToFile": false,
    "queryParams": [
        {"order": 1, "value": "#s"},
        {"order": 2, "value": "#s"}
    ]
}
```

```
SELECT * FROM transactions WHERE id=#s
```
```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "xxxx",
    "threads": 4,
    "iterations": 1000,
    "query": "SELECT * FROM transactions WHERE id=?",
    "writeMetricToFile": false,
    "queryParams": [
        {"order": 1, "value": "#s"},
    ]
}
```


## Integer
Will generate a different random value for each #i
```
UPDATE accounts SET cid=#i WHERE aaId=4
```

```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "xxxx",
    "threads": 4,
    "iterations": 1000,
    "query": "UPDATE accounts SET ? WHERE aaId=4",
    "writeMetricToFile": false,
    "queryParams": [
        {"order": 1, "value": "#i"},
    ]
}
```

## Integer min max
Generates #i(1,10) integer values between 1 and 10
```
INSERT INTO test (id, groupid, amount) VALUES (#s, #i(1,2)#, #i)
```

## Timestamp 
Workaround for not randomizing timestamps is to use current_timestsamp()
```
INSERT INTO transactions (id, name, ts) VALUES (#s, #s, CURRENT_TIMESTAMP())'
```
```
{
    "project": "xxxx",
    "instance": "xxxx",
    "database": "xxxx",
    "threads": 4,
    "iterations": 1000,
    "query": "INSERT INTO transactions (id, name, ts) VALUES (?, ?, CURRENT_TIMESTAMP())'",
    "writeMetricToFile": false,
    "queryParams": [
        {"order": 1, "value": "#s"},
        {"order": 1, "value": "#s"}
    ]
}
```

## Sampling IDs
Sometimes it might be required to sample existing IDs that are then used in the query that is executed. 
The parameter ```-s``` allows to pull a sampled dataset, but only one column is allowed in the resultset. 
This query is executed only once and before the beginning of the run and the dataset is reused across the threads. 

* #ps will add quotes - such as for Strings
* #pi will **not** add quotes such as when integers are used 

In this case the #ps is the placeholder for samples that are pulled from the -s parameter 
```
-q 'SELECT * FROM test WHERE id = #ps''
-s 'SELECT id FROM test TABLESAMPLE RESERVOIR (100 ROWS)'
```

## Many-to-Many Relationship Example
Insert Users
```
INSERT INTO Users (user_id, name) VALUES(#i,#s)
```

Insert Groups
```
INSERT INTO GroupMgmt (group_id, grpname) VALUES(#i,#s)
```

Insert relationships with sampling:
```
INSERT INTO membership(user_id, group_id, enrolled) VALUES((SELECT user_id FROM Users TABLESAMPLE RESERVOIR (1 ROWS)), (SELECT group_id FROM GroupMgmt TABLESAMPLE RESERVOIR (1 ROWS)), CURRENT_TIMESTAMP())
```