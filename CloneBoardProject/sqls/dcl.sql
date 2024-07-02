ALTER SESSION SET "_oracle_script" = TRUE 
;

CREATE USER boarduser1 IDENTIFIED BY 1234
;

grant resource, dba, CONNECT TO boarduser1
;

GRANT CREATE ANY TABLE TO boarduser1
;