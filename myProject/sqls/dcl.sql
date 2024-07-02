ALTER SESSION SET "_oracle_script" = TRUE 
;

CREATE USER landuseplan IDENTIFIED BY 1234
;

grant resource, dba, CONNECT TO landuseplan
;

GRANT CREATE ANY TABLE TO landuseplan
;