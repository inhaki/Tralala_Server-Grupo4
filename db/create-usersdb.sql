CREATE DATABASE TralalaDB;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,INDEX,REFERENCES
           ON usersdb.*
           TO sd@'%'
           IDENTIFIED BY 'sd';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,INDEX,REFERENCES
           ON usersdb.*
           TO sd@localhost
           IDENTIFIED BY 'sd';