ROOT_FOLDER=$(git rev-parse --show-toplevel)

cd ${ROOT_FOLDER}
source .kokoro/common.sh
install_modules java-bigquery-jdbc

cd ${ROOT_FOLDER}/java-bigquery-jdbc
make integration-test test=ITPresubmitTests
