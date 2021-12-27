-- username=adnan password=adnan || username=admin password=admin
insert into euser (username,account_non_expired,account_non_locked,credentials_non_expired,enabled,password) values ('adnan',true,true,true,true,'$2a$10$dL9yWN6ToYEMMr//CqK5guRjbQI69UxEaOKobEDJUpKgbbVbcSg5.');
insert into euser (username,account_non_expired,account_non_locked,credentials_non_expired,enabled,password) values ('admin',true,true,true,true,'$2a$10$rCVWqgGLpd9Okr8iqNuNdes65H3M0l12/XqLS.LsJm81ymR1DoOcS');

insert into authority (authority) values ('ROLE_ADMIN');
insert into authority (authority) values ('ROLE_USER');

insert into user_authority (user_id, authority_id) values ('adnan','ROLE_ADMIN');
insert into user_authority (user_id, authority_id) values ('adnan','ROLE_USER');
insert into user_authority (user_id, authority_id) values ('admin','ROLE_ADMIN');
insert into user_authority (user_id, authority_id) values ('admin','ROLE_USER');
