CREATE OR REPLACE TRIGGER TRG_CUSTOMER
    BEFORE INSERT OR UPDATE ON CUSTOMER
    FOR EACH ROW
    DECLARE 
BEGIN

---------------------------- Exception Credits ---------------------------------------------------------------------------------

    IF (:NEW.CREDITS < 0) THEN
            RAISE_APPLICATION_ERROR(-20900, 'The credits has to be greater or equal to 0 ');
    END IF;

---------------------------- Exception Birthdate -------------------------------------------------------------------------------

    IF (sysdate <= :NEW.birthdate ) THEN
            :NEW.birthdate:= :OLD.birthdate;  
            
            RAISE_APPLICATION_ERROR(-20901, 'The birthdate must be below the current date; 
            The birthdate cannot be updated - NO CHANGE' ); 
            
   END IF;

---------------------------- Email ---------------------------------------------------------------------------------------------

    IF  (:NEW.EMAIL  LIKE '' OR :NEW.EMAIL NOT like '_%@__%.__%' ) THEN
            RAISE_APPLICATION_ERROR(-20902, 'The email must contain the character @' ); 
    END IF; 
--------------------------------------------------------------------------------------------------------------------------------

END TRG_CUSTOMER;