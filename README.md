# Sensitive Data Classifier Backend

## Overview
This project provides a backend solution to scan files uploaded from a local machine to identify and classify sensitive data. It identifies data such as PAN card numbers, US Social Security Numbers (SSNs), medical records, health insurance information, and credit card numbers. The classified data is categorized as:
- **PII (Personally Identifiable Information)**
- **PHI (Protected Health Information)**
- **PCI (Payment Card Information)**

The results are stored in a database, and a web interface is provided to upload files, view scanned data, and manage the records.

---

## Features
- **File Scanning**: Identify sensitive information using pattern matching techniques (e.g., regular expressions).
- **Categorization**: Classify sensitive data into PII, PHI, and PCI.
- **Database Management**: Store and retrieve scanned results.
- **Web Interface**: Simple HTML pages to upload files and display results.
- **API Support**: Backend APIs for file uploads, data retrieval, and record deletion.

---

## Controllers Documentation

### 1. DataController

- **Package**: `com.aurva.rolwin.assignment.controller`
- **Description**: Handles HTTP requests for managing file data, including fetching files and deleting entities.

#### Endpoints:
1. **Delete File Entity**
   - **URL**: `/data/delete/entity/{id}`
   - **HTTP Method**: `DELETE`
   - **Produces**: `application/json`
   - **Description**: Deletes an entity with the specified ID.
   - **Parameters**:
     - `id` (Path Variable): The ID of the entity to delete.
   - **Response**: `FileDeleteResponse` object containing deletion details.
   - **Service Used**: `DataService.deleteEntity(int id)`

2. **Get All Files**
   - **URL**: `/data/files`
   - **HTTP Method**: `GET`
   - **Produces**: `application/json`
   - **Description**: Retrieves all files.
   - **Response**: `FileDataResponse` object containing file details.
   - **Service Used**: `DataService.getAllFiles()`

---

### 2. FileController

- **Package**: `com.aurva.rolwin.assignment.controller`
- **Description**: Manages file uploads.

#### Endpoints:
1. **Upload File**
   - **URL**: `/upload/file`
   - **HTTP Method**: `POST`
   - **Consumes**: `multipart/form-data`
   - **Produces**: `application/json`
   - **Description**: Uploads files to the backend.
   - **Parameters**:
     - `FileUploadRequest` (Model Attribute): Contains file data and metadata.
   - **Response**: `FileUploadResponse` object with upload details.
   - **Service Used**: `FileUploadService.uploadFile(FileUploadRequest fileUploadRequest)`

---

🌐 Endpoints
EndpointMethodDescription/data/delete/entity/{id}DELETEDelete a file entity by ID/data/filesGETRetrieve all scanned files/upload/filePOSTUpload a new file
🧪 Testing

Use Postman or any REST client to interact with endpoints
Console logs provide runtime and error information

🐳 Deployment
Containerization

Dockerfile and docker-compose.yml provided for containerization

Supported Platforms

Render
Railway
Koyeb

📦 Components
DataController

Manages file data operations
Methods: deleteFile(), getFiles()

FileController

Handles file upload processes
Method: uploadFile()


  
