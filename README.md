# Sensitive Data Classifier Backend

## 📋 Overview

This project provides a backend solution to scan files uploaded from a local machine to identify and classify sensitive data. It identifies data such as:
- PAN card numbers
- US Social Security Numbers (SSNs)
- Medical records
- Health insurance information
- Credit card numbers

### Data Classification Categories
- **PII (Personally Identifiable Information)**
- **PHI (Protected Health Information)**
- **PCI (Payment Card Information)**

The results are stored in a database, with a web interface provided to upload files, view scanned data, and manage records.

## ✨ Features

- **File Scanning**: Identify sensitive information using pattern matching techniques (e.g., regular expressions)
- **Categorization**: Classify sensitive data into PII, PHI, and PCI
- **Database Management**: Store and retrieve scanned results
- **Web Interface**: Simple HTML pages to upload files and display results
- **API Support**: Backend APIs for file uploads, data retrieval, and record deletion

## 🌐 Controllers Documentation

### 1. DataController

- **Package**: `com.aurva.rolwin.assignment.controller`
- **Description**: Handles HTTP requests for managing file data, including fetching files and deleting entities

#### Endpoints

##### Delete File Entity
- **URL**: `/data/delete/entity/{id}`
- **HTTP Method**: `DELETE`
- **Produces**: `application/json`
- **Description**: Deletes an entity with the specified ID
- **Parameters**:
  - `id` (Path Variable): The ID of the entity to delete
- **Response**: `FileDeleteResponse` object containing deletion details
- **Service Used**: `DataService.deleteEntity(int id)`

##### Get All Files
- **URL**: `/data/files`
- **HTTP Method**: `GET`
- **Produces**: `application/json`
- **Description**: Retrieves all files
- **Response**: `FileDataResponse` object containing file details
- **Service Used**: `DataService.getAllFiles()`

### 2. FileController

- **Package**: `com.aurva.rolwin.assignment.controller`
- **Description**: Manages file uploads

#### Endpoints

##### Upload File
- **URL**: `/upload/file`
- **HTTP Method**: `POST`
- **Consumes**: `multipart/form-data`
- **Produces**: `application/json`
- **Description**: Uploads files to the backend
- **Parameters**:
  - `FileUploadRequest` (Model Attribute): Contains file data and metadata
- **Response**: `FileUploadResponse` object with upload details
- **Service Used**: `FileUploadService.uploadFile(FileUploadRequest fileUploadRequest)`

## 🚀 Setup and Installation

### Prerequisites
- Java Development Kit
- Maven
- Git

### Clone the Repository
## 🔧 Build and Run

### Build the Project
```bash
   mvn clean install
```
## Run the Application
```
# Using Maven
mvn spring-boot:run

# Or using Java JAR
java -jar target/assignment-0.0.1-SNAPSHOT.jar
```
## 🧪 Testing

### Endpoint Testing

Use Postman or any REST client to test the following endpoints:

| Endpoint | Method | URL | Description |
|----------|--------|-----|-------------|
| Delete File Entity | `DELETE` | `/data/delete/entity/{id}` | Deletes a file entity with the specified ID |
| Get All Files | `GET` | `/data/files` | Retrieves a list of all scanned files |
| Upload File | `POST` | `/upload/file` | Handles the uploading of files |

### Logging
- Monitor console logs for:
  - Runtime information
  - Error details
  - Execution status

### Test Scenarios
- Validate file upload functionality
- Test sensitive data identification
- Verify data classification accuracy
- Check endpoint response codes
- Ensure proper error handling

### Tools Recommended
- **Postman**: For API endpoint testing
- **Swagger**: API documentation and testing
- **JUnit**: For unit testing
- **Mockito**: For mocking dependencies

### Best Practices
- Use valid test files
- Test edge cases
- Validate file size limits
- Check different file types
- Verify data privacy and security measures



