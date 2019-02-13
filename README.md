All the tests need to access gcloud project cloudprober-test.
To set the authentication: 
export GOOGLE_APPLICATION_CREDENTIALS=$HOME/key.json 

Build without test:
gradle build -x test

Run large Bigtable integration tests:
gradle btTest

Run large Spanner integration tests:
gradle spannerTest

RUn Spanner benchmark:
gradle spannerBenchmark --args="--gcp=true --thread=3 --rpc=100"
