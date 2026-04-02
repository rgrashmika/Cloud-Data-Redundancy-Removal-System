-- CodeAlpha Task 1: Database Setup for Cloud Redundancy System

-- 1. Create the Storage Vault Table
CREATE TABLE system.UserCloudVault (
    file_id NUMBER PRIMARY KEY,
    file_content CLOB NOT NULL,
    file_checksum VARCHAR2(64) UNIQUE NOT NULL,
    upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Create the Numbering Sequence
CREATE SEQUENCE system.vault_seq START WITH 1 INCREMENT BY 1;

-- 3. Finalize
COMMIT;