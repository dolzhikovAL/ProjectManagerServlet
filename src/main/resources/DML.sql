INSERT INTO public.skills ( language, level)
VALUES ('Java', 1);
INSERT INTO public.skills ( language, level)
VALUES ('Java', 2);
INSERT INTO public.skills ( language, level)
VALUES ('Java', 3);
INSERT INTO public.skills ( language, level)
VALUES ('Python', 1);
INSERT INTO public.skills ( language, level)
VALUES ('Python', 2);
INSERT INTO public.skills ( language, level)
VALUES ('Python', 3);
INSERT INTO public.skills ( language, level)
VALUES ('JS', 1);
INSERT INTO public.skills ( language, level)
VALUES ('JS', 2);
INSERT INTO public.skills ( language, level)
VALUES ('JS', 3);
INSERT INTO public.skills ( language, level)
VALUES ('C++', 1);
INSERT INTO public.skills ( language, level)
VALUES ('C++', 2);
INSERT INTO public.skills ( language, level)
VALUES ('C++', 3);


INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Ivan Ivanov','15000', '33','MAN',1);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Petr Petrov', '25000','29','MAN',2);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Olga Olina', '7000','25','WOMAN',3);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Svetlana Svetina','16000', '31','WOMAN',4);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Nikolay Nikolaev', '35000','50','MAN',1);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Semen Semenov','27000', '60','MAN',2);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Alexey Alexeev', '18000','19','MAN',3);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Alex Alexandrov', '18000','35','MAN',4);
INSERT INTO developers(developer_name,salary, developer_age, developer_gender,company_id)
VALUES ('Victor Victorov','20000', '80','MAN',1);

INSERT INTO customers(customer_name,customer_phone)
VALUES ('Vladimir Klichko', '04411111111');
INSERT INTO customers(customer_name,customer_phone)
VALUES ('Kostya Dzyu', '04422222222');
INSERT INTO customers(customer_name,customer_phone)
VALUES ('Alexander Usik ', '04433333333');
INSERT INTO customers(customer_name,customer_phone)
VALUES ('Dinamo', '0441444444');
INSERT INTO customers(customer_name,customer_phone)
VALUES ('Dnipro', '0445555555');

INSERT INTO companies(company_name,start_date)
VALUES ('UMS',  '11-11-2020');
INSERT INTO companies(company_name,start_date)
VALUES ('BeeLine','05-10-2020');
INSERT INTO companies(company_name, start_date)
VALUES ('VodaPhone', '01-05-2020');
INSERT INTO companies(company_name, start_date)
VALUES ('KievStar',  '21-10-2020');

INSERT INTO projects(project_name,start_date,end_date,cost,company_id)
VALUES ('Site_KMDA','21-10-2020','21-10-2021',1000000,4);
INSERT INTO projects(project_name,start_date,end_date,cost,company_id)
VALUES ('Training_Program','10-10-2020','09-10-2021',2000000,3);
INSERT INTO projects(project_name,start_date,end_date,cost,company_id)
VALUES ('Politics_Program', '01-11-2019','09-10-2020',5000000,1);
INSERT INTO projects(project_name,start_date,end_date,cost,company_id)
VALUES ('Team_Museum','01-11-2010','09-10-2020',800000,4);
INSERT INTO projects(project_name,start_date,end_date,cost,company_id)
VALUES ('Where_the_team','01-11-2020','09-10-2020',10000,2);
INSERT INTO projects(project_name,start_date,end_date,cost,company_id)
VALUES ('Internet_Market', '01-11-2020','09-10-2020',4000000,1);

INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('1', '2');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('1', '5');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('2', '3');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('3', '4');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('4', '8');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('4', '10');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('5', '6');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('5', '9');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('6', '12');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('7', '7');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('8', '8');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('9', '10');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('9', '4');
INSERT INTO dev_skills(developer_id, skill_id)
VALUES ('9', '1');

INSERT INTO cust_proj(customer_id, project_id)
VALUES ('1', '1');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('1', '2');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('1', '3');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('2', '2');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('3', '2');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('4', '2');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('4', '4');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('4', '6');
INSERT INTO cust_proj(customer_id, project_id)
VALUES ('5', '5');



INSERT INTO dev_proj(developer_id, project_id)
VALUES ('9', '1');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('4', '1');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('1', '1');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('1', '2');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('5', '2');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('7', '3');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('9', '3');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('1', '4');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('6', '4');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('9', '5');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('8', '5');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('2', '6');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('6', '6');
INSERT INTO dev_proj(developer_id, project_id)
VALUES ('5', '6');