# Cloud Data Redundancy Removal System

## 🚀 Overview
This system identifies and prevents redundant data uploads using **SHA-256 Hashing**. It ensures that identical file content is only stored once in the Oracle Database, optimizing cloud storage efficiency.

## 🛠️ Features
- **Data Identification:** Generates unique fingerprints (hashes) for file content.
- **Validation:** Checks the database for existing hashes before allowing an upload.
- **Persistence:** Uses Oracle 11g to store unique data securely.

## 📁 File Guide
- `RedundancyManager.java`: The main Java application (JDBC).
- `database_setup.sql`: SQL script to create the table and sequence.

## 📸 Proof of Concept.

### 1. First Upload (Unique Data)
*Screenshot of Eclipse showing the **SUCCESS** message.*
<img width="997" height="799" alt="image" src="https://github.com/user-attachments/assets/d31d1ced-8c53-484d-adb5-a9ce3b2793ef" />

### 2. Redundancy Detected (Duplicate Data)
*Screenshot of Eclipse showing the **ALERT** message.
<img width="1118" height="808" alt="image" src="https://github.com/user-attachments/assets/ea433ffd-624d-4a34-8133-d1b461a718a3" />

### 3. Database Verification (Oracle SQL Plus)
*The result of `SELECT * FROM system.UserCloudVault;` showing the saved data.*
<img width="989" height="856" alt="image" src="https://github.com/user-attachments/assets/698ed7e5-1f8c-4d7f-8e6a-6c35566edbef" />

