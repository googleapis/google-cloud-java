terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
resource "google_project_service" "bigquery" {
  service            = "bigquery.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "google_project_service" "bigqueryconnection" {
  service            = "bigqueryconnection.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "google_project_service" "sqladmin" {
  service            = "sqladmin.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}

resource "random_id" "id" {
  byte_length = 3
}
locals {
  db_name = lower("mysql-db-${random_id.id.hex}")
}

module "mysql-db" {
  source              = "GoogleCloudPlatform/sql-db/google//modules/mysql"
  version             = "12.0.0"
  name                = local.db_name
  database_version    = "MYSQL_8_0"
  deletion_protection = false
  project_id          = var.inputs.project_id
  zone                = var.inputs.zone
  region              = var.inputs.region
  depends_on          = [
    google_project_service.bigquery,
    google_project_service.bigqueryconnection,
    google_project_service.sqladmin
  ]
}
