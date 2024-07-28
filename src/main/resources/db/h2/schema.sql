CREATE TABLE SPRING_SESSION (
	PRIMARY_ID CHAR(36) NOT NULL,
	SESSION_ID CHAR(36) NOT NULL,
	CREATION_TIME BIGINT NOT NULL,
	LAST_ACCESS_TIME BIGINT NOT NULL,
	MAX_INACTIVE_INTERVAL INT NOT NULL,
	EXPIRY_TIME BIGINT NOT NULL,
	PRINCIPAL_NAME VARCHAR(100),
	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE UNIQUE INDEX  SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX  SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX  SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
	ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
	ATTRIBUTE_BYTES LONGVARBINARY NOT NULL,
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);


CREATE TABLE COMCODE (
	CREATED_DT			  	    DATETIME		  	NULL		,
	CREATED_USER_ID			    VARCHAR(50)			NULL		,
	CREATED_HOST_IP			    VARCHAR(50)			NULL		,
	CREATED_APP_URL			    VARCHAR(500)		NULL		,
	MODIFIED_DT				      DATETIME		  	NULL		,
	MODIFIED_USER_ID		    VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		    VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		    VARCHAR(500)		NULL    ,
	SYSTEM_TYPE_CODE		    VARCHAR(3)			NOT NULL,
	CODE_ID	  	      	    VARCHAR(255) 		NOT NULL,
  CODE				            VARCHAR(255) 		NOT NULL,
	CODE_NAME			          VARCHAR(255) 		NOT NULL,
	CODE_NAME_ABBR			    VARCHAR(255) 		NULL 		,
  P_CODE_ID  		    	    VARCHAR(255)		NULL 		,
	FROM_DT				          DATETIME		  	NOT NULL,
	TO_DT				            DATETIME		  	NOT NULL,
	HIERARCHY_LEVEL			    INT				      NOT NULL,
	PRT_SEQ				          INT				      NULL		,
  LOW_LEVEL_CODE_LENGTH 	INT				      NULL		,
	CMT					            VARCHAR(2000) 	NULL 		,
	constraint pk_comcode primary key(SYSTEM_TYPE_CODE, CODE_ID)	
);

CREATE TABLE COMDEPT (
	CREATED_DT			  	DATETIME		  	  NULL		,
	CREATED_USER_ID			VARCHAR(50)		  	NULL		,
	CREATED_HOST_IP			VARCHAR(50)		  	NULL		,
	CREATED_APP_URL			VARCHAR(500)	  	NULL		,
	MODIFIED_DT			  	DATETIME		  	  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)		  	NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)		  	NULL		,
	MODIFIED_APP_URL		VARCHAR(500)	  	NULL		,	
	ORG_CD				      VARCHAR(50)		  	NOT NULL,
  DEPT_CD				      VARCHAR(10) 	  	NOT NULL,
  P_DEPT_CD			      VARCHAR(255)	  	NULL 		,
  DEPT_NM_KOR			  	VARCHAR(255) 	  	NOT NULL,
  DEPT_ABBR_KOR		  	VARCHAR(255) 	  	NULL 		,
  DEPT_NM_ENG			  	VARCHAR(255) 	  	NULL 		,
  DEPT_ABBR_ENG		  	VARCHAR(255) 	  	NULL 		,
	FROM_DT				      DATE			  	    NULL		,
	TO_DT				        DATE			  	    NULL		,
	PRT_SEQ				      INT				  	    NULL		,
	CMT					        VARCHAR(2000) 	 	NULL 		,
	constraint pk_comdept 		primary key(ORG_CD, DEPT_CD)
	/*constraint fk_comdept1	 	foreign key(P_DEPT_CD) references COMDEPT(DEPT_CD)*/
); 

CREATE TABLE COMFILEINFO (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT				  DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  FILE_ID					    BINARY(16)	 		NOT NULL,
  APP_URL				      VARCHAR(50)			NULL 		,
  USER_ID				      VARCHAR(20)			NULL		,
  CONTENT_TYPE		  	VARCHAR(50)			NULL 		,
  UUID				        VARCHAR(1000)		NOT NULL,
  FILE_PATH			      VARCHAR(1000)		NULL 		,
  FILE_NM				      VARCHAR(1000)		NULL 		,
  FILE_SIZE			      INT					    NULL 		,
  DOWNLOAD_CNT		  	INT					    NULL 		,
	constraint pk_comfileinfo primary key(FILE_ID)
);

CREATE TABLE COMUSER (
	CREATED_DT			    DATETIME		  	NULL		,
	CREATED_USER_ID		  	VARCHAR(50)			NULL		,
	CREATED_HOST_IP		  	VARCHAR(50)			NULL		,
	CREATED_APP_URL		  	VARCHAR(500)		NULL		,
	MODIFIED_DT			    DATETIME		  	NULL		,
	MODIFIED_USER_ID	  	VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP	  	VARCHAR(50)			NULL		,
	MODIFIED_APP_URL	  	VARCHAR(500)		NULL		,
  USER_ID				    VARCHAR(50)			NOT NULL	,
	ORG_CD				    VARCHAR(50)			NULL		,
	STAFF_NO			    VARCHAR(50)			NULL		,
  USER_NAME			    VARCHAR(100)		NULL		,
  DEPT_CD				    VARCHAR(10) 		NULL 		,
  MOBILE_NUM 			    VARCHAR(20) 		NULL		,
  EMAIL 				    VARCHAR(320) 		NULL 		,
  PWD 		   		    VARCHAR(2000)		NULL		,
  FK_FILE				    VARCHAR(500)			NULL        ,
  NON_EXPIRED_YN		  	BOOLEAN			  	NOT NULL    ,
  NON_LOCKED_YN		    BOOLEAN			  	NOT NULL	,
  PASS_NON_EXPIRED_YN		BOOLEAN			  	NOT NULL	,
  ENABLED_YN			    BOOLEAN			  	NOT NULL	,
	constraint pk_comuser primary key(USER_ID)
	--constraint fk_comuser1	foreign key(FK_FILE) references COMFILEINFO(PK_FILE)
);

CREATE TABLE COMROLE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,	
	ORG_CD				      VARCHAR(50)			NOT NULL,
	ROLE_CD				      VARCHAR(50)			NOT NULL,
  ROLE_NM             VARCHAR(50)			NULL    ,
  MENU_GROUP_CD			  VARCHAR(10)			NULL    ,
  DESCRIPTION			  	VARCHAR(500)		NULL		,
	constraint pk_comrole primary key(ORG_CD, ROLE_CD)
);

CREATE TABLE COMUSERROLE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ORG_CD				      VARCHAR(50)			NOT NULL	,
  USER_ID				      VARCHAR(50)			NOT NULL	,
  ROLE_CD				      VARCHAR(50)			NOT NULL	,
	constraint pk_comuserrole 	primary key(ORG_CD, USER_ID, ROLE_CD)
	/*constraint fk_comuserauthority1	foreign key(USER_ID) references COMUSER(USER_ID)*/
	/*constraint fk_comuserauthority2	foreign key(AUTH_CD) references COMAUTHORITY(AUTH_CD)*/
); 
COMMENT ON TABLE COMUSERROLE IS '사용자권한매핑관리';


CREATE TABLE COMRESOURCE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME		  	NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  RESOURCE_ID	  	  	VARCHAR(10)			NOT NULL,
  RESOURCE_NAME		  	VARCHAR(50)			NOT NULL,
  RESOURCE_TYPE		  	VARCHAR(10)			NOT NULL,
  URL					        VARCHAR(500)		NULL		,
  DESCRIPTION			  	VARCHAR(500)		NULL		,
	constraint pk_comresource	primary key(RESOURCE_ID)
);
COMMENT ON TABLE COMRESOURCE IS '웹서버 리소스관리';

CREATE TABLE COMMENUGROUP (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,	
	ORG_CD				      VARCHAR(10)			NULL		,
	MENU_GROUP_CD			  VARCHAR(10)			NOT NULL,
  MENU_GROUP_NM			  VARCHAR(50)			NOT NULL,
  MENU_GROUP_URL		  VARCHAR(50)			NOT NULL,
  DESCRIPTION			  	VARCHAR(500)		NULL		,
	constraint pk_commenugroup	primary key(ORG_CD, MENU_GROUP_CD)
);
COMMENT ON TABLE COMMENUGROUP IS '메뉴그룹관리';

CREATE TABLE COMMENU (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT				  DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,	
	ORG_CD				      VARCHAR(10)			NOT NULL,
	MENU_GROUP_CD		  	VARCHAR(50)			NOT NULL,
  MENU_CD			        VARCHAR(10)			NOT NULL,
	MENU_NM			        VARCHAR(50)			NOT NULL,
  MENU_TYPE			      VARCHAR(10)			NOT NULL,
	P_MENU_CD			      VARCHAR(50)			NULL		,	
  APP_URL				      VARCHAR(50)			NULL		,
  SEQ					        INT				  	  NULL		,
  LVL					        INT				  	  NULL		,
	constraint pk_commenu		primary key(ORG_CD, MENU_GROUP_CD, MENU_CD)
);
COMMENT ON TABLE COMMENU IS '메뉴관리';

CREATE TABLE COMMENUROLE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT				  DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,	
	ORG_CD				      VARCHAR(10)			NOT NULL	,
	MENU_GROUP_CD		  	VARCHAR(50)			NOT NULL	,
  MENU_CD			        VARCHAR(10)			NOT NULL	,
	ROLE_CD				      VARCHAR(50)			NOT NULL	,
	constraint pk_commenurole		primary key(ORG_CD, MENU_GROUP_CD, MENU_CD, ROLE_CD)
);
COMMENT ON TABLE COMMENUROLE IS '메뉴롤관계관리';

CREATE TABLE COMLOGINHISTORY (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ID					    INT				    NOT NULL	,
	USER_ID				    VARCHAR(50)			NOT NULL	,
	EVENT_TYPE			  	VARCHAR(500)		NOT NULL	,
	EVENT_DT			    DATETIME		  	NOT NULL	,
	CLIENT_IP			    VARCHAR(500)		NOT NULL	,
	SUCCESS_YN			  	BOOLEAN			  	NOT NULL	,
	constraint pk_comloginhistory primary key(ID) 	
);
COMMENT ON TABLE COMLOGINHISTORY IS '로그인이력';


CREATE TABLE COMHOLIDAY (
	CREATED_DT			  	DATETIME		    NULL		,
	CREATED_USER_ID			VARCHAR(50)		  	NULL		,
	CREATED_HOST_IP			VARCHAR(50)		  	NULL		,
	CREATED_APP_URL			VARCHAR(500)	  	NULL		,
	MODIFIED_DT			  	DATETIME		    NULL		,
	MODIFIED_USER_ID		VARCHAR(50)		  	NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)		  	NULL		,
	MODIFIED_APP_URL		VARCHAR(500)	  	NULL		,
	ORG_CD				      VARCHAR(10)			NOT NULL	,
  HOLIDAY_DT			  	DATETIME		  	NOT NULL	,
  HOLIDAY_NM			  	VARCHAR(255)  		NOT NULL 	,
	CMT					    VARCHAR(2000) 		NULL 		,
	constraint pk_comholiday primary key(ORG_CD, HOLIDAY_DT)	
);
COMMENT ON TABLE COMHOLIDAY IS '공휴일관리';

CREATE TABLE BIZCODETYPE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ORG_CD				      VARCHAR(10)			NOT NULL,
	TYPE_ID				      VARCHAR(10)	  	NOT NULL,
	TYPE_NM				      VARCHAR(500)		NOT NULL,
	PRT_SEQ			      	INT		       		NULL		,
  BIZ_TYPE				    VARCHAR(10)		  NULL    ,
  BIZ_RULE_CMT_1      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_2      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_3      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_4      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_5      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_6      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_7      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_8      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_9      VARCHAR(500)	  NULL    ,
  BIZ_RULE_CMT_10     VARCHAR(500)	  NULL    ,
	CMT					        TEXT		 	      NULL 		,
	constraint pk_bizcodetype primary key(ORG_CD, TYPE_ID)
);
COMMENT ON TABLE BIZCODETYPE IS '업무코드구분';

CREATE TABLE BIZCODE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ORG_CD				      VARCHAR(10)			NOT NULL,
	TYPE_ID				      VARCHAR(10)	  	NOT NULL,
  CODE	  			      VARCHAR(10)	  	NOT NULL,  
	CODE_NM				      VARCHAR(500)		NULL    ,
	USE_YN  				    BOOLEAN	    	  NULL    ,
  PRT_SEQ			      	INT		       		NULL		,    
	CMT					        TEXT		 	      NULL 		,
	constraint pk_bizcode primary key(ORG_CD, TYPE_ID, CODE)
);
COMMENT ON TABLE BIZCODE IS '업무코드';



CREATE TABLE COMTERMDOMAIN (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME		  	NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	DOMAIN_ID			    VARCHAR(600)		NOT NULL	,
	DB					    VARCHAR(600)		NOT NULL	,
	DOMAIN_NAME			  	VARCHAR(600)		NOT NULL	,
	DATA_TYPE			    VARCHAR(600)		NOT NULL	,
	CMT					    TEXT		 	    NULL 		,
	constraint pk_comtermdomain primary key(DOMAIN_ID)	
);
COMMENT ON TABLE COMTERMDOMAIN IS '데이터도메인';

CREATE TABLE COMTERMWORD (
	CREATED_DT				DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT				DATETIME		  	NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	LOGICAL_NAME		  	VARCHAR(600)		NOT NULL	,
	LOGICAL_NAME_ENG		VARCHAR(600)		NULL		,
	PHYSICAL_NAME			VARCHAR(600)		NOT NULL	,
	CMT					    TEXT		 	    NULL 		,
	constraint pk_comtermword primary key(LOGICAL_NAME)	
);
COMMENT ON TABLE COMTERMWORD IS '단어사전';


CREATE TABLE COMTERM (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME		  	NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	TERM_ID				      VARCHAR(600)		NOT NULL,
	SYSTEM				      VARCHAR(600)		NOT NULL,
	TERM				        VARCHAR(600)		NOT NULL,
	TERM_ENG			      VARCHAR(600)		NULL		,
	COLUMN_NAME			  	VARCHAR(600)		NULL		,
	DOMAIN_ID			      VARCHAR(600)		NOT NULL,
	COMBI_YN			      BOOLEAN				  NOT NULL,
	TERM_DESCRIPTION		TEXT		 	      NULL 		,
	CMT					        TEXT		 	      NULL 		,
	constraint pk_comterm primary key(TERM_ID),
	constraint fk_comterm1 	foreign key(DOMAIN_ID) references COMTERMDOMAIN(DOMAIN_ID)
); 
COMMENT ON TABLE COMTERM IS '용어사전';


CREATE TABLE HRMCODETYPE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	TYPE_ID				    VARCHAR(10)	  		NOT NULL	,
	TYPE_NM				    VARCHAR(600)		NOT NULL	,
	PRT_SEQ			      	INT		       		NULL		,
	CMT					    TEXT		 	    NULL 		,
	constraint pk_hrmcodetype primary key(TYPE_ID)
);
COMMENT ON TABLE HRMCODETYPE IS 'HRM코드구분';


CREATE TABLE HRMCODE (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	TYPE_ID					    VARCHAR(10)	  	NOT NULL	,
  CODE  				      VARCHAR(10)	  	NOT NULL	,
	CODE_NM				      VARCHAR(600)		NOT NULL	,
	USE_YN			      	BOOLEAN			  	NOT NULL	,
	PRT_SEQ			      	INT		       		NULL		,
	CMT					        TEXT		 	      NULL 		,
  THE_1_ADD_INFO      TEXT		 	      NULL 		,
  THE_2_ADD_INFO      TEXT		 	      NULL 		,
  THE_3_ADD_INFO      TEXT		 	      NULL 		,
  THE_4_ADD_INFO      TEXT		 	      NULL 		,
  THE_5_ADD_INFO      TEXT		 	      NULL 		,
	constraint pk_hrmcode primary key(TYPE_ID, CODE),
 	constraint fk_hrmcode1 	foreign key(TYPE_ID) references HRMCODETYPE(TYPE_ID)
);
COMMENT ON TABLE HRMCODE IS 'HRM코드';

CREATE TABLE HRMSTAFF (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ORG_CD				      VARCHAR(10)			NOT NULL,
  STAFF_NO			      VARCHAR(10)			NOT NULL,
  STAFF_NAME		      VARCHAR(50)			NULL    ,
  STAFF_NAME_ENG	    VARCHAR(50)			NULL    ,
  STAFF_NAME_CHI	    VARCHAR(50)			NULL    ,
  RREGNO	            VARCHAR(20)			NULL    ,
  HOME_ADDR_TYPE      VARCHAR(20)			NULL    ,
  HOME_POST_NO        VARCHAR(20)			NULL    ,
  HOME_MAIN_ADDR      VARCHAR(20)			NULL    ,
  HOME_SUB_ADDR       VARCHAR(20)			NULL    ,
  EXTENSION_PHONE_NO  VARCHAR(20)			NULL    ,
  MOBILE_PHONE_NO     VARCHAR(20)			NULL    ,
  GENDER              VARCHAR(20)			NULL    ,
  BIRTHDAY            DATETIME  			NULL    ,
  WORK_STATE_CODE     VARCHAR(20)			NULL    ,
  IMG_PATH            VARCHAR(50)			NULL    ,	
  BLNG_DEPT_CODE      VARCHAR(10)			NULL    ,	
  WORK_DEPT_CODE      VARCHAR(10)			NULL    ,	
  JOB_GROUP_CODE      VARCHAR(10)			NULL    ,	
  JOB_POSITION_CODE   VARCHAR(10)			NULL    ,	
  OCCUPATION_CODE     VARCHAR(10)			NULL    ,	
  JOB_GRADE_CODE      VARCHAR(10)			NULL    ,	
  PAY_STEP_CODE       VARCHAR(10)			NULL    ,	
  JOB_CODE            VARCHAR(10)			NULL    ,	
	constraint pk_hrmstaff primary key(ORG_CD, STAFF_NO)
);
COMMENT ON TABLE HRMSTAFF IS '직원정보';

CREATE TABLE HRMSTAFFAPPOINTMENTRECORD (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ORG_CD				      VARCHAR(10)			NOT NULL,
  STAFF_NO			      VARCHAR(10)			NOT NULL,
  SEQ       		      INT       			NOT NULL,
  APPOINTMENT_TYPE_CODE VARCHAR(10)	  NOT NULL,  
  APPOINTMENT_DT	    DATETIME	  		NOT NULL,
  APPOINTMENT_END_DT	DATETIME  			NULL    ,
  RECORD_NAME		      VARCHAR(50)			NULL    ,  
  CMT       		      VARCHAR(2000)		NULL    ,  
  COMPLETE_YN       	BOOLEAN	      	NULL    ,  
  BLNG_DEPT_CODE      VARCHAR(10)			NULL    ,	
  WORK_DEPT_CODE      VARCHAR(10)			NULL    ,	
  JOB_GROUP_CODE      VARCHAR(10)			NULL    ,	
  JOB_POSITION_CODE   VARCHAR(10)			NULL    ,	
  OCCUPATION_CODE     VARCHAR(10)			NULL    ,	
  JOB_GRADE_CODE      VARCHAR(10)			NULL    ,	
  PAY_STEP_CODE       VARCHAR(10)			NULL    ,	
  JOB_CODE                  VARCHAR(10)			NULL    ,	
  DUTY_RESPONSIBILITY_CODE  VARCHAR(10)			NULL    ,	
	constraint pk_hrmstaffappointmentrecord primary key(ORG_CD, STAFF_NO, SEQ)
);
COMMENT ON TABLE HRMSTAFFAPPOINTMENTRECORD IS '직원발령기록';

CREATE TABLE HRMSTAFFDUTYRESPONSIBILITY (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ORG_CD				      VARCHAR(10)			NOT NULL,
  STAFF_NO			      VARCHAR(10)			NOT NULL,
  SEQ       		      INT       			NOT NULL,  
  DUTY_RESPONSIBILITY_CODE  VARCHAR(10)			NULL    ,	
  FROM_DT			        DATETIME		    NULL    ,
  TO_DT 			        DATETIME		    NULL    ,
  PAY_APPLY_YN 			  BOOLEAN 		    NULL    ,
	constraint pk_hrmstaffdutyresponsibility primary key(ORG_CD, STAFF_NO, SEQ)
);
COMMENT ON TABLE HRMSTAFFDUTYRESPONSIBILITY IS '직원직책정보';

CREATE TABLE HRMSTAFFFAMILY (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ORG_CD				      VARCHAR(10)			NOT NULL,
  STAFF_NO			      VARCHAR(10)			NOT NULL,
  SEQ       		      INT       			NOT NULL,  
  FAMILY_NAME         VARCHAR(50)			NULL    ,	
  RREGNO              VARCHAR(50)			NULL    ,	
  FAMILY_REL_CODE     VARCHAR(50)			NULL    ,	
  OCCUPATION_NAME     VARCHAR(50)			NULL    ,	
  SCHOOL_CAREER_CODE  VARCHAR(50)			NULL    ,	
  CMT                 VARCHAR(2000)	  NULL    ,	
	constraint pk_hrmstafffamily primary key(ORG_CD, STAFF_NO, SEQ)
);
COMMENT ON TABLE HRMSTAFFFAMILY IS '직원가족정보';

CREATE TABLE HRMSTAFFLICENSE (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ORG_CD				      VARCHAR(10)			NOT NULL,
  STAFF_NO			      VARCHAR(10)			NOT NULL,
  SEQ       		      INT       			NOT NULL,  
  LICENSE_TYPE        VARCHAR(50)			NULL    ,	
  LICENSE_NO          VARCHAR(50)			NULL    ,	
  DATE_OF_ACQUISITION DATETIME  			NULL    ,	
  CERTIFICATION_AUTHORITY VARCHAR(50)			NULL    ,	  
  CMT                 VARCHAR(2000)	  NULL    ,	
	constraint pk_hrmstafflicense primary key(ORG_CD, STAFF_NO, SEQ)
);
COMMENT ON TABLE HRMSTAFFLICENSE IS '직원가족정보';

CREATE TABLE HRMSTAFFSCHOOLCAREER (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ORG_CD				      VARCHAR(10)			NOT NULL,
  STAFF_NO			      VARCHAR(10)			NOT NULL,
  SEQ       		      INT       			NOT NULL,  
  SCHOOL_CAREER_CODE  VARCHAR(50)			NULL    ,	
  SCHOOL_CODE         VARCHAR(50)			NULL    ,	
  FROM_DT             DATETIME  			NULL    ,	
  TO_DT               DATETIME  			NULL    ,	
  MAJOR_NAME          VARCHAR(50)			NULL    ,	
  PLURAL_MAJOR_NAME   VARCHAR(50)			NULL    ,	
  LOCATION_NAME       VARCHAR(50)			NULL    ,	
  LESSON_YEAR         VARCHAR(50)			NULL    ,	  
  CMT                 VARCHAR(2000)	  NULL    ,	
	constraint pk_hrmstaffschoolcareer primary key(ORG_CD, STAFF_NO, SEQ)
);
COMMENT ON TABLE HRMSTAFFSCHOOLCAREER IS '직원가족정보';

CREATE TABLE GRWBOARD (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  BOARD_ID            INT             NOT NULL  AUTO_INCREMENT,
  BOARD_P_ID          INT             NULL    ,
  BOARD_TYPE          VARCHAR(10)     NOT NULL,
  BOARD_NAME          VARCHAR(500)		NULL    ,
  BOARD_DESC          TEXT			      NULL    ,
  USE_YN              BOOLEAN         NULL    ,
  SEQ                 INT             NULL    ,
  constraint pk_grwboard primary key(BOARD_ID)
);
COMMENT ON TABLE GRWBOARD IS '게시판';


CREATE TABLE GRWARTICLE (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ARTICLE_ID          INT             NOT NULL  AUTO_INCREMENT,
  ARTICLE_P_ID        INT             NULL    ,
  BOARD_ID            INT             NOT NULL,
  TITLE               VARCHAR(500)		NULL    ,
  CONTENTS            TEXT			      NULL    ,
  SEQ                 INT             NULL    ,
  HIT_CNT             INT             NULL    ,
  HIER_DEPTH          INT             NULL    ,
  FIXED_TOP_YN        BOOLEAN         NULL    ,
  PWD                 VARCHAR(500)		NULL    ,
  constraint pk_grwarticle primary key(ARTICLE_ID),  
  constraint fk_grwarticle1 	foreign key(BOARD_ID) references GRWBOARD(BOARD_ID)
);
COMMENT ON TABLE GRWARTICLE IS '게시글';

CREATE TABLE GRWARTICLEFILE (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ARTICLE_FILE_ID     INT             NOT NULL  AUTO_INCREMENT,
  ARTICLE_ID          INT             NOT NULL,  
  FILE_ID             BINARY(16)      NOT NULL,  
  constraint pk_grwarticlefile primary key(ARTICLE_FILE_ID),  
  constraint fk_grwarticlefile1 foreign key(ARTICLE_ID) references GRWARTICLE(ARTICLE_ID)
);
COMMENT ON TABLE GRWARTICLEFILE IS '게시글첨부파일';


CREATE TABLE GRWARTICLECHECK (
	CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,  
  ARTICLE_ID          INT             NOT NULL,
  USER_ID             VARCHAR(50)     NOT NULL,
  HIT_CNT             INT             NULL,  
  constraint pk_grwarticlecheck primary key(ARTICLE_ID, USER_ID),
  constraint fk_grwarticlecheck1 foreign key(ARTICLE_ID) references GRWARTICLE(ARTICLE_ID)
);
COMMENT ON TABLE GRWARTICLECHECK IS '게시글사용자조회수';


CREATE TABLE GRWWORKCALENDAR(
  CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ID                  INT             NOT NULL AUTO_INCREMENT,
  CALENDAR_NAME       VARCHAR(500)    NOT NULL,
  COLOR               VARCHAR(10)     NULL    ,
  constraint pk_grwworkcalendar primary key(ID)
);
COMMENT ON TABLE GRWWORKCALENDAR IS 'WORKCALENDAR';


CREATE TABLE GRWWORKCALENDAREVENT(
  CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ID                  INT             NOT NULL AUTO_INCREMENT,
  FK_WORKCALENDAR     INT             NOT NULL,
  TITLE               VARCHAR(500)    NOT NULL,
  START_DT            DATETIME        NULL    ,
  END_DT              DATETIME        NULL    ,
  ALLDAY              BOOLEAN         NULL    ,
  constraint pk_grwworkcalendarevent primary key(ID),
  constraint fk_grwworkcalendarevent1 foreign key(FK_WORKCALENDAR) references GRWWORKCALENDAR(ID)
);
COMMENT ON TABLE GRWWORKCALENDAREVENT IS 'GRWWORKCALENDAREVENT';

CREATE TABLE GRWWORKCALENDARUSER(
  CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ID                  INT             NOT NULL AUTO_INCREMENT,  
  USER_ID             VARCHAR(500)    NOT NULL,
  constraint pk_grwworkcalendaruser primary key(ID, USER_ID),
  constraint fk_grwworkcalendaruser1 foreign key(ID) references GRWWORKCALENDAR(ID)
);
COMMENT ON TABLE GRWWORKCALENDARUSER IS 'GRWWORKCALENDARUSER';

CREATE TABLE GRWTODOGROUP(
  CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ID                  INT             NOT NULL AUTO_INCREMENT,
  TODO_GROUP_NAME     VARCHAR(500)    NOT NULL,
  USER_ID             VARCHAR(500)    NOT NULL,    
  constraint pk_grwtodogroup primary key(ID)
);
COMMENT ON TABLE GRWTODOGROUP IS 'TODO그룹';


CREATE TABLE GRWTODO(
  CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  ID                  INT             NOT NULL AUTO_INCREMENT,
  TODO_GROUP_ID       INT             NOT NULL,
  TODO                VARCHAR(500)    NOT NULL,
  COMPLETE_YN         BOOLEAN         NULL    ,
  DUE_DT              DATETIME        NULL    ,
  COMMENTS            VARCHAR(500)    NULL    ,
  constraint pk_grwtodo primary key(ID),
  constraint fk_grwtodo1 foreign key(TODO_GROUP_ID) references GRWTODOGROUP(ID)
);
COMMENT ON TABLE GRWTODO IS 'TODO';

CREATE TABLE GRWTEAM(
  CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  TEAM_ID             INT             NOT NULL AUTO_INCREMENT,  
  TEAM_NAME           VARCHAR(500)    NOT NULL,  
  constraint pk_grwteam primary key(TEAM_ID)
);
COMMENT ON TABLE GRWTEAM IS 'TEAM';

CREATE TABLE GRWTEAMUSER(
  CREATED_DT			  	DATETIME			  NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			  NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  TEAM_ID             INT             NOT NULL,  
  USER_ID             VARCHAR(500)    NOT NULL, 
  AUTHORITY           VARCHAR(500)    NULL    , 
  constraint pk_grwteamuser primary key(TEAM_ID, USER_ID),
  constraint fk_grwteamuser1 foreign key(TEAM_ID) references GRWTEAM(TEAM_ID)
);
COMMENT ON TABLE GRWTEAMUSER IS 'TEAMUSER';
