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

## 📸 Proof of Concept
<img width="1919" height="960" alt="image" src="https://github.com/user-attachments/assets/e875f3e6-093c-4842-8d7d-e49368c57f47" />
<img width="1059" height="587" alt="image" src="https://github.com/user-attachments/assets/b0c880f4-5a13-45aa-8d2b-346203bf837c" />
