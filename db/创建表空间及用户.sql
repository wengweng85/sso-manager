--������ռ�
create  tablespace DATA 
datafile 'F:\APP\ORADATA\ORCL\DATA_01.DBF' 
size 2G 
autoextend on 
next 512m maxsize 20480m 
extent management local; 

--�����û�
CREATE USER wxjy_manager  IDENTIFIED BY wxjy_manager 
ACCOUNT UNLOCK
DEFAULT TABLESPACE DATA
TEMPORARY TABLESPACE temp;      
grant connect,resource,dba to wxjy_manager; 
