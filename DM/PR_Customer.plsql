create or replace procedure PR_Customer is
 v_n  number;
 begin
 

  Select count(*) into v_n 
  from All_TABLES
      where OWNER = 'DEMO' AND Table_name = 'CUSTOMER';
  
  IF v_n = 0 then 
    execute immediate 
    'create Table Customer                            
             (    Customer_ID       Integer,
                  Email             Varchar(45),
                  Firstname         Varchar(40),
                  Lastname          Varchar(40),
                  Gender            Varchar(20),
                  Birthdate         Date,
                  Credits           Decimal
              )';
    COMMIT;
  End IF;  
  
   SELECT COUNT(*) INTO v_n
   FROM SYS.all_sequences
   where sequence_owner = 'DEMO' and sequence_name = 'SEQ_CUSTOMER_ID';
   
   IF v_n = 0 Then
       execute immediate 
              'create SEQUENCE SEQ_CUSTOMER_ID
                                START WITH   10000  
                                INCREMENT BY 1
                                CACHE        50';
      COMMIT;
   End IF;
   
 end PR_Customer;