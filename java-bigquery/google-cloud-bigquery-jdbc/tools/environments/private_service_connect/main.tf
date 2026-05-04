provider "google" {
  project = var.project_id
  region  = var.region
}

# 1. VPC Network
resource "google_compute_network" "vpc" {
  name                    = "${var.env_name}-vpc"
  auto_create_subnetworks = false
}

# 2. Subnet
resource "google_compute_subnetwork" "subnet" {
  name          = "${var.env_name}-subnet"
  ip_cidr_range = "10.0.0.0/24"
  region        = var.region
  network       = google_compute_network.vpc.id
}

# 3. Cloud NAT for Internet Access (No Public IP for VM)
resource "google_compute_router" "router" {
  name    = "${var.env_name}-router"
  region  = var.region
  network = google_compute_network.vpc.id
}

resource "google_compute_router_nat" "nat" {
  name                               = "${var.env_name}-nat"
  router                             = google_compute_router.router.name
  region                             = var.region
  nat_ip_allocate_option             = "AUTO_ONLY"
  source_subnetwork_ip_ranges_to_nat = "ALL_SUBNETWORKS_ALL_IP_RANGES"
}

# 4. Private Service Connect for Google APIs
resource "google_compute_global_address" "psc_ip" {
  name         = "${var.env_name}-psc-ip"
  address_type = "INTERNAL"
  purpose      = "PRIVATE_SERVICE_CONNECT"
  network      = google_compute_network.vpc.id
  address      = "10.0.1.2" # Using a distinct IP outside the subnet range or just let it auto-allocate if possible, but purpose requires specific handling. Actually, global address for PSC can be any internal IP. Let's auto-allocate or use a specific one.
}

resource "google_compute_global_forwarding_rule" "psc_rule" {
  name                  = "${var.env_name}" # This name generates the p.googleapis.com endpoint
  target                = "all-apis"
  network               = google_compute_network.vpc.id
  ip_address            = google_compute_global_address.psc_ip.id
  load_balancing_scheme = ""
}

# 5. Firewall for IAP SSH
resource "google_compute_firewall" "iap_ssh" {
  name    = "${var.env_name}-allow-iap-ssh"
  network = google_compute_network.vpc.id

  allow {
    protocol = "tcp"
    ports    = ["22"]
  }

  source_ranges = ["172.253.30.0/23"] # IAP range
}

# 6. VM Instance
resource "google_compute_instance" "vm" {
  name         = "${var.env_name}-vm"
  machine_type = "e2-medium"
  zone         = var.zone

  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-12"
    }
  }

  network_interface {
    subnetwork = google_compute_subnetwork.subnet.id
    # No access_config block ensures no public IP
  }

  metadata = {
    enable-oslogin = "TRUE"
  }
}
