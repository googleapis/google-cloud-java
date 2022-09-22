terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

provider "google" {
  project = var.project_id
  region  = var.region
  zone    = var.zone
}

resource "google_project_service" "sqladmin_api" {
  service            = "sqladmin.googleapis.com"
  disable_on_destroy = false
}
resource "google_project_service" "bigquery_connection_api" {
  service            = "bigqueryconnection.googleapis.com"
  disable_on_destroy = false
}
resource "google_project_service" "bigquery_api" {
  service            = "bigquery.googleapis.com"
  disable_on_destroy = false
}

locals {
  db_name = "mysql-db"
}

module "mysql-db" {
  source              = "GoogleCloudPlatform/sql-db/google//modules/mysql"
  version             = "12.0.0"
  name                = local.db_name
  database_version    = "MYSQL_8_0"
  deletion_protection = false
  project_id          = var.project_id
  zone                = var.zone
  depends_on          = [google_project_service.sqladmin_api]
}
