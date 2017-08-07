
CREATE TABLE Student(
id bigint(10) not null AUTO_INCREMENT comment'主键',
Examinee_Name VARCHAR(20) not null comment'姓名',
cardID VARCHAR(20) not null comment'考生身份证号',
Examinee_Num VARCHAR(10) not null comment'考生编号',
Creat_Time datetime comment'创建时间',
Contact VARCHAR(20)not null comment'联系方式',
White_List VARCHAR(10) comment'白名单',

PRIMARY KEY(id)
);


CREATE TABLE Exam_room(
id bigint(10) not null AUTO_INCREMENT comment'主键',
Province VARCHAR(20) not null comment'省份',
City VARCHAR(10) not null comment'市',
District VARCHAR(100) not null comment'地区',
ExamineRoom_Name VARCHAR(100) not null comment'考场名称',
ExamineRoom_Code VARCHAR(10) not null comment'考场编号',
Invigilator_Name VARCHAR(20) not null comment'负责人姓名',
Invigilator_Tel VARCHAR(20) not null comment'负责人电话',

PRIMARY KEY(id)
);


CREATE TABLE Course(
id bigint(10) not null AUTO_INCREMENT comment'主键',
Course_Title VARCHAR (200) not null comment'科目名称',
Course_Code VARCHAR(10) comment'科目编号',
Course_Class VARCHAR(20) not null comment'科目类别',
Course_SubCode INT(10) comment'子科目编号',
Exam_Date VARCHAR(10) not null comment'考试日期',
Start_time datetime  comment'考试开始时间',
End_time datetime comment'考试结束时间',

PRIMARY KEY(id)
);


CREATE TABLE Exam_record(
id bigint(10) not null AUTO_INCREMENT comment'主键',
ExamineRoom_Code VARCHAR(10) not null comment'考场编号',
Course_Code VARCHAR(10) comment'科目编号',
Course_SubCode VARCHAR(10) comment'子科目编号',
Examinee_Num VARCHAR(10) not null comment'考生编号',
Examinee_Name VARCHAR(10) not null comment'姓名',
Score VARCHAR(10)comment'分数',
Video VARCHAR(200)not null comment'视频',
File VARCHAR(200)not null comment'文件', 
Create_Time datetime comment'创建时间',
Batch_No varchar(10) DEFAULT NULL COMMENT '批次号',
PRIMARY KEY(id)
);

CREATE TABLE `exam_record_batch` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Exam_Site_Code` varchar(10) DEFAULT NULL COMMENT '考场编号',
  `Course_Code` varchar(10) DEFAULT NULL COMMENT '科目编号',
  `Course_SubCode` varchar(10) DEFAULT NULL COMMENT '子科目编号',
  `Examinee_Name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `Video` varchar(200) DEFAULT NULL COMMENT '视频',
  `Create_Time` datetime DEFAULT NULL COMMENT '创建时间',
  `Batch_No` varchar(10) DEFAULT NULL COMMENT '批次号',
  `Exam_Time` varchar(20) DEFAULT NULL COMMENT '考试时间',
  PRIMARY KEY (`id`)
) ;

